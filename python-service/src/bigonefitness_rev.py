import requests
import json
import pandas as pd
from datetime import datetime

def scraping_obf():
  cookies = {
      'pll_language': 'cs',
      'PHPSESSID': '7hishk26b82d5cjrnbtldhn0p3',
  }

  headers = {
      'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.0',
      'Accept': 'application/json, text/javascript, */*; q=0.01',
      'Accept-Language': 'cs,sk;q=0.8,en-US;q=0.5,en;q=0.3',
      'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
      'X-Requested-With': 'XMLHttpRequest',
      'Origin': 'https://www.big1fitness.cz',
      'Connection': 'keep-alive',
      'Referer': 'https://www.big1fitness.cz/cs/rozvrhy/',
      'Cache-Control': 'max-age=0',
      'TE': 'Trailers',
  }

  data = {
    'action': 'get_events',
    'readonly': 'true',
    'categories': '0',
    'excluded': '0',
    'start': '1603666800',
    'end': '1607295600'
  }

  response = requests.post('https://www.big1fitness.cz/wp-admin/admin-ajax.php', headers=headers, cookies=cookies, data=data)


  rozvrh = pd.DataFrame.from_records(response.json())
  rozvrh = rozvrh[['title','start','end']]
  rozvrh['obsazenost'] = 0
  rozvrh['kapacita'] = 0
  ##rozvrh['IdFitness'] = 

  rozvrh['start'] = rozvrh['start'].map(lambda date_string: datetime.strptime(date_string, "%Y-%m-%d %H:%M:%S").isoformat())
  rozvrh['end'] = rozvrh['end'].map(lambda date_string: datetime.strptime(date_string, "%Y-%m-%d %H:%M:%S").isoformat())

  rozvrh = rozvrh.rename(columns = {"title": "nazev", "start":"zacatek", "end":"konec"})

  bigOneFitness = rozvrh.to_json(orient="records", force_ascii=False)

  return bigOneFitness
