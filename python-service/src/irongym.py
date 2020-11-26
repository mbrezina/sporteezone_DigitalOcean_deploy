# -*- coding: utf-8 -*-

import requests
import pandas as pd
from bs4 import BeautifulSoup
import datetime
from datetime import date, timedelta

def mesicnik(date):
    if 'ledna' in date:
        den = date.replace('ledna', 'january')
    elif 'února' in date:
        den = date.replace('února', 'february')
    elif 'března' in date:
        den = date.replace('března', 'march')
    elif 'dubna' in date:
        den = date.replace('dubna', 'april')
    elif 'května' in date:
        den = date.replace('května', 'may')
    elif 'června' in date:
        den = date.replace('června', 'june')
    elif 'července' in date:
        den = date.replace('července', 'july')
    elif 'srpna' in date:
        den = date.replace('srpna', 'august')
    elif 'září' in date:
        den = date.replace('září', 'september')
    elif 'října' in date:
        den = date.replace('října', 'october')
    elif 'listopadu' in date:
        den = date.replace('listopadu', 'november')
    elif 'prosince' in date:
        den = date.replace('prosince', 'december')
    return den


def scraping():
    i = datetime.date.today()
    mesic_konec = i + timedelta(31)
    lesson = []
    obsazenost = []
    capacity = []
    date_iso = []
    kodFitka = []

    while mesic_konec > i:
        day = i.strftime("%d.%m.%Y")
        url = 'https://www.web-rezervace.cz/prihlaseni/den/index.php?rezervace=irongym&date=' + str(day)

        page = requests.get(url)
        soup = BeautifulSoup(page.content, 'html.parser')

        datumy = soup.find('div', class_='col-sm-11').text.strip()

        lekce = soup.find_all('div', class_='polozka_nadpis_aktivity')
        kapacity = soup.find_all('div', class_='polozka_obsazenost_kapacita')
        hodiny = soup.find_all('div', class_='polozka_cas_zacatku_hodiny')

        for lek in lekce:
            lesson.append(lek.get_text())
        for cap in kapacity:
            v = cap.get_text().strip().split('/')
            capacity.append(v[-1])
            obsazenost.append(v[0])
            # capacity.append(cap.get_text().strip().split('/')[-1])

        for hod in hodiny:
            date_iso.append(
                datetime.datetime.strptime(mesicnik(datumy) + hod.get_text().strip(), '%d. %B %Y%H:%M').isoformat())


        kodFitka.append(8)

        # s číslem fitka:
        nadpisy = ['kodFitka', 'nazev', 'obsazeno', 'kapacita', 'zacatek']
        kodFitka.append(int(8))

        # s číslem fitka:
        nadpisy = ['kodFitka', 'nazev', 'obsazenost', 'kapacita', 'zacatek']
        # nadpisy = ['název', 'kapacita', 'začátek']

        i = i + timedelta(1)

    df1 = pd.DataFrame(data=(kodFitka, lesson, obsazenost, capacity, date_iso), index=nadpisy)


    vysledek = df1.T.to_json(force_ascii=False, orient='records')
    return vysledek


# toto je způsob, jak odlišit program spuštěný přímo nebo z importu:
if __name__ == "__main__":
    scraping()
