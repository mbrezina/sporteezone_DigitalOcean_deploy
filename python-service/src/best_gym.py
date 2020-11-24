import requests
import pandas as pd
from bs4 import BeautifulSoup
from datetime import date, timedelta, datetime, time

def best_gym():
    URL = 'https://bestgym.cz/rozpis-lekci'
    page = requests.get(URL)
    soup = BeautifulSoup(page.content, 'html.parser')
    data = soup.find('div', class_ = 'tab-content class-schedule-tab')

    #pondeli, ostatni dny maji jine div
    pondeli = data.find('div', class_ = 'tab-pane fade in active')
    ul = pondeli.find_all('ul')
    pond = [pon.text for pon in ul]
    kousky = [pon.replace('\n', ' ').replace(' -', '').strip().split(' ') for pon in pond]
    datum = date.today() + timedelta(days=-date.today().weekday(), weeks=1)# + timedelta(0)
    odkazy = []
    for link in pondeli.find_all('a'):
        odkazy.append(link.get('href'))
    cena = []
    for kus in kousky:
        if int(kus[-5].split(':')[0]) < 14:
            cena.append(90)
        else:
            cena.append(100)

    treneri = [' '.join(kus[-3:-1]) for kus in kousky]
    konce = [datetime.strptime(str(datum) + ' ' + kus[-4], '%Y-%m-%d %H:%M').isoformat() for kus in kousky]
    zacatky = [datetime.strptime(str(datum) + ' ' + kus[-5], '%Y-%m-%d %H:%M').isoformat() for kus in kousky]
    nazvy = [' '.join(kus[0:-5]) for kus in kousky]

    #zbyle dny
    dny = data.find_all('div', class_ = 'tab-pane fade')
    x = 1
    for den in dny:
        ul = den.find_all('ul')
        pond = [pon.text for pon in ul]
        kousky = [pon.replace('\n', ' ').replace(' -', '').strip().split(' ') for pon in pond]
        datum = date.today() + timedelta(days=-date.today().weekday(), weeks=1) + timedelta(x)
        for link in den.find_all('a'):
            odkazy.append(link.get('href'))
        for trener in kousky:
            treneri.append(' '.join(trener[-3:-1]))
        for konec in kousky:
            konce.append(datetime.strptime(str(datum) + ' ' + konec[-4], '%Y-%m-%d %H:%M').isoformat())
        for zacatek in kousky:
            zacatky.append(datetime.strptime(str(datum) + ' ' + zacatek[-5], '%Y-%m-%d %H:%M').isoformat())
        for ceny in kousky:
            if int(kus[-5].split(':')[0]) < 14:
                cena.append(90)
            else:
                cena.append(100)
        for nazev in kousky:
            nazvy.append(' '.join(nazev[0:-5]))
        x +=1

    df = pd.DataFrame({'nazev': nazvy, 'odkazy': odkazy, 'trener': treneri, 'zacatek': zacatky, 'konec': konce,
                       'cena': cena}, columns = ['nazev', 'odkazy', 'trener', 'zacatek', 'konec', 'cena'])
    df['kodFitko'] = 11

    vysledek = df.to_json(force_ascii=False, orient='records')
    return vysledek

if __name__ == "__main__":
    best_gym()
