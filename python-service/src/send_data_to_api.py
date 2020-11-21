# -*- coding: utf-8 -*-
import os
import requests

def send_data(vysledek):
    print(f"posílám výsledek: {vysledek}")
    print("************")
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}

    #r = requests.post('http://localhost:8080/api/v1/lekce/addMore', data=vysledek.encode('utf-8'), headers=headers, auth=('admin', 'admin'))
    #r = requests.post('http://localhost:8080/api/v1/lekce/addMore', data=vysledek.encode('utf-8'), headers=headers)
    #r = requests.post('http://167.172.36.145:8080//api/v1/lekce/addMore', data=vysledek.encode('utf-8'), headers=headers)

    r = requests.post('http://167.172.36.145:8080/api/v1/lekce/addMore', auth=(os.environ["API_LOGIN"], os.environ["API_PASSWORD"]), data=vysledek.encode('utf-8'), headers=headers)
    print(r.status_code)
    print(r.text)
    return r.text
