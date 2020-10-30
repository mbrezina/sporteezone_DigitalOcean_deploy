# -*- coding: utf-8 -*-

import requests

def send_data(vysledek):
    print(f"posílám výsledek: {vysledek}")
    print("************")
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    r = requests.post('http://localhost:8080/api/v1/lekce/addMore', data=vysledek.encode('utf-8'), headers=headers, auth=('admin', 'admin'))
    return r.text
