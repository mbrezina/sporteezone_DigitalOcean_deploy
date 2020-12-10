import requests
from bs4 import BeautifulSoup
from datetime import date, datetime, timedelta
import pandas as pd
import re

def blue_gym():
    i = date.today()
    zacatek = []
    konec = []
    trener = []
    obsazenost = []
    nazev = []
    odkaz = []
    a = 0

    while a <= 1:
        day = i.strftime("%d-%m-%Y")
        url = 'http://cz.boofit.net/bluegym/rozvrh-a-rezervace/aktualni-rozvrh/1119/' + str(day)
        page = requests.get(url)
        soup = BeautifulSoup(page.content, 'html.parser')

        dany_den = soup.find_all('div', class_ = 'col7-sm-7')


        for den in dany_den:
            datum = den.find('dt')
            datum = '.'.join(re.findall(r'\d+', datum.text))
            cviceni = den.find_all('p', class_ = 'lesson')
            for lekce in cviceni:

                zacatek.append(datetime.strptime(datum + ' ' + lekce.text.split()[0],'%d.%m.%Y %H:%M').isoformat())
                konec.append(datetime.strptime(datum + ' ' + lekce.text.split()[2],'%d.%m.%Y %H:%M').isoformat())
                trener.append(lekce.text.split()[-2])
                obsazenost.append(lekce.text.split()[-1])
                nazev.append(' '.join(lekce.text.split()[3:-2]))
                odkaz.append(url)

        i = i + timedelta(days = 7)
        a+=1


    nadpisy = ['nazev', 'zacatek', 'konec', 'obsazenost', 'trener', 'url']

    df = pd.DataFrame(data = (nazev, zacatek, konec, obsazenost, trener, odkaz), index = nadpisy)
    df = df.T
    df['kodFitko'] = 2


    vysledek = df.to_json(force_ascii=False, orient='records')
    return vysledek

if __name__ == "__main__":
    blue_gym()
