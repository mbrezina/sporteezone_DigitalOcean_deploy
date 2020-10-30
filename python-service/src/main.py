# -*- coding: utf-8 -*-

import logging
import irongym
import send_data_to_api

def execute():
    vysledek_irongym = irongym.scraping()
    logging.info(vysledek_irongym)
    send_data_to_api.send_data(vysledek_irongym)

