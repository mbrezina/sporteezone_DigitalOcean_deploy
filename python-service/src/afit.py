import requests
from bs4 import BeautifulSoup
import pandas as pd
from datetime import date, datetime, timedelta
import numpy as np
import time

def afit():
    URL = ['http://rezervace.afit.cz:18080/timeline/week?criteriaTimestamp&resetFilter=true#timelineCalendar',
           'http://rezervace.afit.cz:18080/timeline/week?ac%5B0%5D.s=true&_ac%5B0%5D.s=on&ac%5B1%5D.s=true&_ac%5B1%5D.s=on&ac%5B2%5D.s=true&_ac%5B2%5D.s=on&ac%5B3%5D.s=true&_ac%5B3%5D.s=on&ac%5B4%5D.s=true&_ac%5B4%5D.s=on&ac%5B5%5D.s=true&_ac%5B5%5D.s=on&ac%5B6%5D.s=true&_ac%5B6%5D.s=on&ac%5B7%5D.s=true&_ac%5B7%5D.s=on&ac%5B8%5D.s=true&_ac%5B8%5D.s=on&ac%5B9%5D.s=true&_ac%5B9%5D.s=on&ac%5B10%5D.s=true&_ac%5B10%5D.s=on&ac%5B11%5D.s=true&_ac%5B11%5D.s=on&ac%5B12%5D.s=true&_ac%5B12%5D.s=on&ac%5B13%5D.s=true&_ac%5B13%5D.s=on&ac%5B14%5D.s=true&_ac%5B14%5D.s=on&ac%5B15%5D.s=true&_ac%5B15%5D.s=on&ac%5B16%5D.s=true&_ac%5B16%5D.s=on&ac%5B17%5D.s=true&_ac%5B17%5D.s=on&ac%5B18%5D.s=true&_ac%5B18%5D.s=on&tc%5B0%5D.s=true&_tc%5B0%5D.s=on&tc%5B1%5D.s=true&_tc%5B1%5D.s=on&tc%5B2%5D.s=true&_tc%5B2%5D.s=on&tc%5B3%5D.s=true&_tc%5B3%5D.s=on&ic%5B0%5D.s=true&_ic%5B0%5D.s=on&ic%5B1%5D.s=true&_ic%5B1%5D.s=on&ic%5B2%5D.s=true&_ic%5B2%5D.s=on&ic%5B3%5D.s=true&_ic%5B3%5D.s=on&ic%5B4%5D.s=true&_ic%5B4%5D.s=on&ic%5B5%5D.s=true&_ic%5B5%5D.s=on&ic%5B6%5D.s=true&_ic%5B6%5D.s=on&ic%5B7%5D.s=true&_ic%5B7%5D.s=on&ic%5B8%5D.s=true&_ic%5B8%5D.s=on&ic%5B9%5D.s=true&_ic%5B9%5D.s=on&ic%5B10%5D.s=true&_ic%5B10%5D.s=on&ic%5B11%5D.s=true&_ic%5B11%5D.s=on&ic%5B12%5D.s=true&_ic%5B12%5D.s=on&ic%5B13%5D.s=true&_ic%5B13%5D.s=on&ic%5B14%5D.s=true&_ic%5B14%5D.s=on&ic%5B15%5D.s=true&_ic%5B15%5D.s=on&ic%5B16%5D.s=true&_ic%5B16%5D.s=on&ic%5B17%5D.s=true&_ic%5B17%5D.s=on&ic%5B18%5D.s=true&_ic%5B18%5D.s=on&ic%5B19%5D.s=true&_ic%5B19%5D.s=on&ic%5B20%5D.s=true&_ic%5B20%5D.s=on&ic%5B21%5D.s=true&_ic%5B21%5D.s=on&ic%5B22%5D.s=true&_ic%5B22%5D.s=on&ic%5B23%5D.s=true&_ic%5B23%5D.s=on&ic%5B24%5D.s=true&_ic%5B24%5D.s=on&ic%5B25%5D.s=true&_ic%5B25%5D.s=on&ic%5B26%5D.s=true&_ic%5B26%5D.s=on&ic%5B27%5D.s=true&_ic%5B27%5D.s=on&ic%5B28%5D.s=true&_ic%5B28%5D.s=on&ic%5B29%5D.s=true&_ic%5B29%5D.s=on&ic%5B30%5D.s=true&_ic%5B30%5D.s=on&check_all=on&criteriaTimestamp=' + str(round(time.time()) * 1000 + 345600000 + 604800000)]
    bez_dupl = []

    for url in URL:
        page = requests.get(url)
        soup = BeautifulSoup(page.content, 'html.parser')
        #prava cast rozvrhu (dny)
        datumy = soup.find_all('span', class_='day')
        saly = soup.find_all('li', class_='hall')
        sal = sorted(list(set(sal.text for sal in saly)))
        dny = [datetime.strptime((datum.text.split(' ')[1] + str(date.today().year)), "%d.%m.%Y").strftime("%Y-%m-%d") 
               for datum in datumy[-7:]]

        pravy_rozvrh = pd.DataFrame([[den, hala] for den in dny for hala in sal])

        #leva cast -samotne cviceni
        tables_data = pd.read_html(page.text)
        levy_rozvrh = tables_data[1]

        #spojeni dnu na tabulku
        rozvrh = pd.concat([pravy_rozvrh, levy_rozvrh], axis=1)
        rozvrh = rozvrh.T.reset_index(drop=True).T

        #pridani dat k samotnym cvicenim
        x = 1
        while x <= len(rozvrh.columns) -1:
            rozvrh[x] = rozvrh[0] + ' ' + rozvrh[x]
            x += 1

        #vyhozeni duplicit a null hodnot
        rozvrh.drop([0,1], axis = 1, inplace = True)
        bez_dupl = bez_dupl + (list(set(np.concatenate(rozvrh.values).tolist())))

    df = pd.DataFrame(bez_dupl).dropna()

    #vyhozeni slov, co tam delaj bordel a jsou nalepeny na dalsich
    df= df[0].str.replace('náhradník  ','').str.replace(' Blokováno ', '').str.replace(' Ukončeno ', '').str.replace('Sál ', '')
    df = pd.DataFrame(df)
    #rozhozeni do sloupcu
    df1 = df[0].str.split('  ', expand=True).add_prefix('column')
    df = df.join(df1)

    df['column0'] = df['column0'].apply(lambda x: x.split(' ')[0])
    df['zacatek'] = df['column0'] + ' ' + df['column1'].apply(lambda x: x.split(' ')[0])
    df['konec'] = df['column0'] + ' ' + df['column1'].apply(lambda x: x.split(' ')[1])
    df['zacatek'] = df['zacatek'].apply(lambda x: datetime.strptime(x, '%Y-%m-%d %H:%M').isoformat())
    df['konec'] = df['konec'].apply(lambda x: datetime.strptime(x, '%Y-%m-%d %H:%M').isoformat())

    df['nazev'] = df['column1'].apply(lambda x: ' '.join(x.split(' ')[2:-1]))
    df['obsazenost'] = df['column3'].apply(lambda x: x.split(' ')[0])
    df['cena'] = df['column3'].apply(lambda x: x.split(' ')[-2])
    df['kodFitko'] = 1
    df['url'] = 'http://rezervace.afit.cz:18080/timeline/week?criteriaTimestamp&resetFilter=true#timelineCalendar'
    df.rename(columns={'column2': 'trener'}, inplace = True)

    df = df[['nazev', 'zacatek', 'konec', 'trener','obsazenost', 'cena', 'kodFitko']]

    vysledek = df.to_json(force_ascii=False, orient='records')
    return vysledek
    
if __name__ == "__main__":
    afit()
