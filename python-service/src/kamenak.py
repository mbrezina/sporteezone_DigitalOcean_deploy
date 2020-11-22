import requests
import pandas as pd
from bs4 import BeautifulSoup
import re
import json

def kamenak():
    url = 'https://clients6.google.com/calendar/v3/calendars/o.s.fitkokamenak@gmail.com/events?calendarId=o.s.fitkokamenak%40gmail.com&singleEvents=true&timeZone=Europe%2FPrague&maxAttendees=1&maxResults=250&sanitizeHtml=true&timeMin=2020-10-26T00%3A00%3A00%2B01%3A00&timeMax=2020-12-07T00%3A00%3A00%2B01%3A00&key=AIzaSyBNlYH01_9Hc5S1J9vuFmu2nUqBZJNAXxs'
    page = requests.get(url)
    soup = BeautifulSoup(page.content, 'html.parser')

    data = json.loads(soup.text)
    lekce = data['items']
    rozvrh = pd.DataFrame.from_records(lekce)

    rozvrh['start'] = rozvrh['start'].apply(lambda x: x['dateTime'])
    rozvrh['end'] = rozvrh['end'].apply(lambda x: x['dateTime'])
    rozvrh['zacatek'] = rozvrh['start'].apply(lambda x: x.split('+')[0])
    rozvrh['konec'] = rozvrh['end'].apply(lambda x: x.split('+')[0])
    rozvrh['kod_fitko'] = 9

    rozvrh['trener'] = rozvrh['summary'].apply(lambda x: re.split('-|,', x)[1] if '-' in x else 'neuvedeno')
    rozvrh['nazev'] = rozvrh['summary'].apply(lambda x: re.split('-|,', x)[0])

    rozvrh = rozvrh[['kod_fitko', 'nazev', 'trener', 'zacatek', 'konec']]

    vysledek = rozvrh.to_json(force_ascii=False, orient='records')
    
    return vysledek

if __name__ == "__main__":
    kamenak()
