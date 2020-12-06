import requests
import pandas as pd
from bs4 import BeautifulSoup
from datetime import date, timedelta, datetime, time

def best_gym():
    dnes = datetime.today()
    sloupecky = ['zacatek', 'konec', 'nazev', 'kapacita', 'cena', 'obsazenost', 'trener', 'url']
    seznam = []
    while dnes < datetime.today()+timedelta(days = 14):
        datum = dnes.strftime('%Y-%m-%d')

        cookies = {
            'ARRAffinity': '712b857a6a927904fe5dcd413f35d755fc3688d2ff44bbb191140b59a4dd3ea3',
            '.AspNetCore.Antiforgery.mLc0_3LYtM4': 'CfDJ8C5WYVI_SPZOvSeVmzt0O_rdGjKN5r23ZaGV-KiR7807jVWDC1F4P8iZw9N6tm62hilg5hv6rSlEg_pSidUOZqxUxiBwO-kDcD9R_Nieq-96WMnsnYvZ7kXBR_IqA5hUazRS9CQLhmIv1aDKJqdr2bo',
            'XSRF-TOKEN': 'CfDJ8C5WYVI_SPZOvSeVmzt0O_rJC44b_Qf44Fkzd_MOdE-mDCtyoKB6ZX9gck7kzTyHQK4g9mrm2i7BYteyMTimN30ov3NiMeItCOtmgl8hXmWC9zN1B-dUP-jio6YEYYA3gUh-WGgmbeVZWAcbQUy1su4',
        }

        headers = {
            'User-Agent': 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:83.0) Gecko/20100101 Firefox/83.0',
            'Accept': 'application/json, text/plain, */*',
            'Accept-Language': 'en-US,en;q=0.5',
            'X-Requested-With': 'XMLHttpRequest',
            'X-XSRF-TOKEN': 'CfDJ8C5WYVI_SPZOvSeVmzt0O_rJC44b_Qf44Fkzd_MOdE-mDCtyoKB6ZX9gck7kzTyHQK4g9mrm2i7BYteyMTimN30ov3NiMeItCOtmgl8hXmWC9zN1B-dUP-jio6YEYYA3gUh-WGgmbeVZWAcbQUy1su4',
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
         #   'Content-Type': 'multipart/form-data',
            'Origin': 'http://rezervace.bestgym.cz',
            'Connection': 'keep-alive',
            'Referer': 'http://rezervace.bestgym.cz',
            'Cache-Control': 'max-age=0',
            'TE': 'Trailers',

        }

        data = {
            #'Content-Disposition': 'form-data',
            'date': datum,
            #'viewMode': "nday",
            'action':'get_events',

            'page':"0",
            #'filter.resource.id':"3751",
            #'filter.resource.type':"1",
            #"filter.matchTermName":'false'
         }

        response = requests.post('http://rezervace.bestgym.cz/cs/api/Term/List', headers=headers, cookies=cookies, data=data)


        eventy = pd.DataFrame.from_records(response.json()).loc['events'][0]
        if eventy:

            x = 0
            while x < len(eventy):
                if 'price' in eventy[x]['priceVariants'][0]:
                    eventy[x]['priceVariants'] = eventy[x]['priceVariants'][0]['price']
                else:
                    eventy[x]['priceVariants'] = 'neuvedena'
                x+=1

            x = 0
            while x < len(eventy):
                if eventy[x]['reservations']:
                    eventy[x]['reservations'] = eventy[x]['reservations'][0]['capacity']
                else:
                    eventy[x]['reservations'] = 'neznamo'
                x+=1

            x = 0
            while x < len(eventy):
                if eventy[x]['resources']['1']:
                    eventy[x]['url'] = eventy[x]['resources']['1'][0]['name']
                else:
                    eventy[x]['url'] = 'neuvedeno'
                x+=1

            x = 0
            while x < len(eventy):
                if eventy[x]['url'] == 'Sál 1':
                    eventy[x]['url'] = 'http://rezervace.bestgym.cz/cs/#/place/sal-1-3751/' + datum + ';viewMode=day'
                elif eventy[x]['url'] == 'Sál 2':
                    eventy[x]['url'] = 'http://rezervace.bestgym.cz/cs/#/place/sal-2-3751/' + datum + ';viewMode=day'
                else:
                    eventy[x]['url'] = 'http://rezervace.bestgym.cz/cs/#/service/squash-2626/' + datum + ';viewMode=day'
                x+=1

                
            x = 0
            while x < len(eventy):
                if eventy[x]['resources']['2']:
                    eventy[x]['resources'] = eventy[x]['resources']['2'][0]['name']
                else:
                    eventy[x]['resources'] = 'neuvedeno'
                x+=1



            frame = pd.DataFrame(eventy)
            sloupce = frame[['start', 'end', 'name', 'maxCapacity', 'priceVariants', 'reservations', 'resources', 'url']]
            seznam.append(sloupce[1:].values.tolist())
            dnes = dnes + timedelta(days = 1)

        else:
            dnes = dnes + timedelta(days = 1)

    flat_list = []
    for sublist in seznam:
        for item in sublist:
            flat_list.append(item)        

    data = pd.DataFrame(data = flat_list, columns=sloupecky)
    data['kod_fitko'] = 11

    vysledek = data.to_json(force_ascii=False, orient = 'records')
    
    return vysledek


if __name__ == "__main__":
    best_gym()
