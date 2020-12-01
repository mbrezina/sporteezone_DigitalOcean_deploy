# -*- coding: utf-8 -*-
import os
import requests

def send_data(vysledek):

    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}

    r = requests.post("http://167.172.36.145:8081/api/v1/lekce/addMore", auth=(os.environ["API_LOGIN"], os.environ["API_PASSWORD"]), data=vysledek.encode("utf-8"), headers=headers)

    print(vysledek)

    print("response status code: " + str(r.status_code))
    print("response text: " + r.text)
    # return r.text
