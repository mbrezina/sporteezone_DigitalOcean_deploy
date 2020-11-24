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
    vysledek_best_gym = best_gym.best_gym()

    send_data_to_api.send_data(vysledek_irongym)
    send_data_to_api.send_data(vysledek_bigonefitness)
    send_data_to_api.send_data(vysledek_kamenak)
    send_data_to_api.send_data(vysledek_velky_pruvan)
    send_data_to_api.send_data(vysledek_best_gym)


if __name__=="__main__":
    execute()
