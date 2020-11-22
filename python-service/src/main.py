# -*- coding: utf-8 -*-

import logging
import irongym
import bigonefitness_rev
import send_data_to_api
import kamenak
import velky_pruvan

def execute():
    vysledek_irongym = irongym.scraping()
    vysledek_bigonefitness = bigonefitness_rev.scraping_obf()
    vysledek_kamenak = kamenak.kamenak()
    vysledek_velky_pruvan = velky_pruvan.velky_pruvan()
    logging.info(vysledek_irongym)
    
    send_data_to_api.send_data(vysledek_irongym)
    send_data_to_api.send_data(vysledek_bigonefitness)
    send_data_to_api.send_data(vysledek_kamenak)
    send_data_to_api.send_data(vysledek_velky_pruvan)


if __name__=="__main__":
    execute()
