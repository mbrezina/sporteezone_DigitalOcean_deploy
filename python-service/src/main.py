# -*- coding: utf-8 -*-

import logging
import irongym
import bigonefitness_rev
import kamenak
import velky_pruvan

import send_data_to_api

def execute():

    vysledek_irongym = irongym.scraping()
    vysledek_bigonefitness = bigonefitness_rev.scraping_obf()
    vysledek_kamenak = kamenak.kamenak()
    vysledek_velky_pruvan = velky_pruvan.velky_pruvan()

    send_data_to_api.send_data(vysledek_irongym)
    send_data_to_api.send_data(vysledek_bigonefitness)
    send_data_to_api.send_data(vysledek_kamenak)
    send_data_to_api.send_data(vysledek_velky_pruvan)


    # logging.info(vysledek_irongym)   není číslo fitka
    logging.info(vysledek_bigonefitness)  #
    #print(vysledek_bigonefitness)   číslo 6
    print(vysledek_kamenak)   # číslo 9
    logging.info(vysledek_velky_pruvan)  # číslo 10



if __name__=="__main__":
    execute()
