import requests
import pandas as pd
import re
import numpy as np
from datetime import date, datetime, timedelta

# maji tydenni rozvrh, delano vzdy od nasledujiciho pondeli na tyden.
def velky_pruvan():
    URL = 'http://velkypruvan.cz/telarna.html'
    page = requests.get(URL)
    data_table = pd.read_html(page.text)
    rozvrh = data_table[0]

    #pridani dne v tydnu k lekcim
    x = 1
    while x <= 8:
        rozvrh[x] = rozvrh[0] + ' ' + rozvrh[x]
        x += 1

    #vyhozeni Nan a dani pod sebe jednotlivych lekci    
    rozvrh.set_index([0], inplace = True)
    polo = np.concatenate(rozvrh.values).tolist()
    df = pd.DataFrame(polo)
    df = df.dropna()

    df['trener'] = df[0].apply(lambda x: x.split(' ')[-1])
    treneri = ['Denisa', 'Unka', 'Monika', 'Jiřina', 'Lenča', 'Magda', 'Valerie', 'Martina', 'Paty', 'Monča']
    treneri = [i.upper() for i in treneri]
    df['trener'] = df['trener'].apply(lambda x: x if x.strip() in treneri else 'neuvedeno')

    #pridani datumu k lekcim
    def prekladac(den):
        dnes = date.today()
        pondeli = dnes + timedelta(days=dnes.weekday())
        if den == 'Pondělí':
            return pondeli
        elif den == 'Úterý':
            return pondeli + timedelta(days = 1)
        elif den == 'Středa':
            return pondeli + timedelta(days = 2)
        elif den == 'Čtvrtek':
            return pondeli + timedelta(days = 3)
        elif den == 'Pátek':
            return pondeli + timedelta(days = 4)
        elif den == 'Sobota':
            return pondeli + timedelta(days = 5)
        elif den == 'Neděle':
            return pondeli + timedelta(days = 6)

    df['datum'] = df[0].apply(lambda x: prekladac(x.split(' ')[0]))
    df['start'] = df[0].apply(lambda x: re.split(' - | -|-| ', x)[1])
    df['end'] = df[0].apply(lambda x: re.split(' - | -|-| ', x)[2])
    df['zacatek'] = df['datum'].astype(str) + ' ' + df['start']
    df['konec'] = df['datum'].astype(str) + ' ' + df['end']
    df['zacatek'] = df['zacatek'].apply(lambda x: datetime.strptime(x, '%Y-%m-%d %H:%M').isoformat())
    df['konec'] = df['konec'].apply(lambda x: datetime.strptime(x, '%Y-%m-%d %H:%M').isoformat())
    df['nazev'] = df[0].apply(lambda x: (' '.join(re.split(' - | -|-| ', x)[3:-1])).lower())
    df['nazev'] = df['nazev'].apply(lambda x: ' '.join(x.split()[:3]))
    df['kodFitko'] = 10
    df['cena'] = 100
    df['url'] = 'http://velkypruvan.cz/kontakt.html'

    #vyhozeni pomocnych sloupcu
    df = df[['nazev', 'zacatek', 'konec', 'trener', 'kodFitko', 'cena', 'url']]
    vysledek = df.to_json(force_ascii=False, orient='records')
    
    return vysledek

if __name__ == "__main__":
    velky_pruvan()
