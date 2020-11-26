# -*- coding: utf-8 -*-


import logging
import irongym
import bigonefitness_rev
import kamenak
import velky_pruvan
import best_gym

import send_data_to_api

def execute():

    vysledek_irongym = irongym.scraping()
    vysledek_bigonefitness = bigonefitness_rev.scraping_obf()
    vysledek_kamenak = kamenak.kamenak()
    vysledek_velky_pruvan = velky_pruvan.velky_pruvan()
    vysledek_best_gym = best_gym.best_gym()


    print("***********************")
    print("irongym:")
    send_data_to_api.send_data(vysledek_irongym)
    print("***********************")
    print("big one fitness:")
    send_data_to_api.send_data(vysledek_bigonefitness)
    print("***********************")
    print("kameňák:")
    send_data_to_api.send_data(vysledek_kamenak)
    print("***********************")
    print("velý průvan:")
    send_data_to_api.send_data(vysledek_velky_pruvan)
    print("***********************")
    print("best gym:")
    send_data_to_api.send_data(vysledek_best_gym)


if __name__=="__main__":
    execute()

