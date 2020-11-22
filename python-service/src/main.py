# -*- coding: utf-8 -*-

import logging
import irongym
import bigonefitness_rev
import send_data_to_api

def execute():
    vysledek_irongym = irongym.scraping()
    vysledek_bigonefitness = bigonefitness_rev.scraping_obf()

    send_data_to_api.send_data(vysledek_irongym)
    send_data_to_api.send_data(vysledek_bigonefitness)

if __name__=="__main__":
    execute()
