# -*-  coding: utf-8 -*-

"""
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * As long as you retain this notice you can do whatever you want with this
 * stuff. If we meet some day, and you think this stuff is worth it, you can
 * buy me a beer in return Poul-Henning Kamp
 * ----------------------------------------------------------------------------
"""

from __future__ import unicode_literals
from bs4 import BeautifulSoup
import requests

r  = requests.get('http://sacapof.org/')
data = r.text

suite = data.split('<h3>Dernières Actualités</h3>')[1]

for i in suite.split('<p>'):
    print i.split('</p>')[0] + '\n\n-----------------------\n\n'

"""
split = data.split('</header><!-- .entry-header -->')

for i in split:
    splitleretour = i.split('<p>')
    for j in splitleretour:
        try:
            print j.split('</p>')[0]
        except:
            pass
"""
