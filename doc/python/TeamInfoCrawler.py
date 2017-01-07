#!/usr/bin/python
import sys
import re
from PyQt4.QtGui import *
from PyQt4.QtCore import *
from PyQt4.QtWebKit import *
from lxml import html
from bs4 import BeautifulSoup


def loadPage(url):
	page = QWebPage()
	loop = QEventLoop() # Create event loop
	page.mainFrame().loadFinished.connect(loop.quit) # Connect loadFinished to loop quit
	page.mainFrame().load(QUrl(url))
	loop.exec_() # Run event loop, it will end on loadFinished
	return page.mainFrame().toHtml()

def getTeamUrls(teamsBaseUrl):
	teamUrls = set()
   	html = loadPage(teamsBaseUrl)
   	bs4Obj = BeautifulSoup(str(html.toUtf8()), 'html.parser')
	teamUrlLinks = bs4Obj.find_all(href=re.compile("/cn/team/Summary/"))
	for teamUrl in teamUrlLinks:
	  teamUrls.add(teamUrl['href'])

	return teamUrls

def extractTeamData(teamUrl):
	print 'start to extract ' + teamUrl
	teamHtml = loadPage(teamUrl)
	bs4Obj = BeautifulSoup(str(teamHtml.toUtf8()), 'html.parser')
	dataDiv = bs4Obj.find("div", id='Tech_sclass')
	print dataDiv


app = QApplication(sys.argv)

baseTeamUrl = 'http://zq.win007.com'
teamUrls = getTeamUrls('http://zq.win007.com/cn/TeamHeadPage/2016-2017/36.html')
for teamUrl in teamUrls:
	teamFullUrl = baseTeamUrl + teamUrl
	extractTeamData(teamFullUrl)


app.exit()
