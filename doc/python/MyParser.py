# -*- coding: UTF-8 -*-
#coding:utf-8
# coding=utf-8
import urllib2
import urllib
import string
import pytesseract
import requests
import cookielib
import StringIO
import gzip
from PIL import Image
from bs4 import BeautifulSoup
import sys
import MySQLdb
import datetime

reload(sys)
sys.setdefaultencoding('utf8')
db = MySQLdb.connect("localhost","lottery","westlife","lottery",charset='utf8')
cursor = db.cursor()
db.set_character_set('utf8')
cursor.execute('SET NAMES utf8;') 
cursor.execute('SET CHARACTER SET utf8;')
cursor.execute('SET character_set_connection=utf8;')

def download():
	try:
	    loginURL = "http://mkt.4318l.com/foot/re"
	    a = requests.session().get(loginURL,cookies = {}, headers = {})
	    print 'len:', len(a.content)
	    return a.content
	except BaseException:
		print 'error'

def nodeToFloat(raw):
	print 'to float:', raw.string
	try:		
		myStr = raw.get_text().encode("utf-8")
		if myStr:
			return float(myStr.strip(' '))
		else:
			return 0.00
	except BaseException:
		print 'error'
def transformMatchTime(matchTime):
	try:		
		print 'index:', matchTime, ',:', matchTime.find('上')
		if matchTime.find('上') > -1:
			result = matchTime.replace('上',' ')
			result = result.replace("'","")		
			return result
		elif matchTime.find('中场') > -1:
			matchTime.replace('中场','45')
			return '45'
		elif matchTime.find('a') > -1:		
			return '0'
		elif matchTime.find('p') > -1:		
			return '0'
		else:		
			result = matchTime.replace('下',' ')
			result = result.replace("'","")
			return result
	except BaseException:
		print 'transformer error.'
try:
	#soup = BeautifulSoup(open('bet.html'))
	rawContent = download()
	soup = BeautifulSoup(rawContent,'lxml')
	print 'soup:', rawContent
	content = soup.find_all('tbody',{'class':'TrBgOdd'})
	print 'content length', content
	fo = open("container.html", "wb")
	fo.write(rawContent)
	for item in content:
		print 'host:', item.find('div',{'class':'TeamNameH'}).get_text()
		#print 'guest:', item.find('div',{'class':'TeamNameC'}).get_text()
		#print 'item len', len(item), ',type:', type(item)
		host = item.find('div',{'class':'TeamNameH'}).get_text()
		guest = item.find('div',{'class':'TeamNameC'}).get_text()
		#time_box
		timeDiv = item.find_all('div',{'class':'time_box'})
		time = timeDiv[0].contents[0].string
		newTime = float(transformMatchTime(time))
		#print 'time:', newTime
		result = timeDiv[0].contents[1].string
		#print 'timebox:', timeDiv[0].contents[0].string

		divList = item.find_all('div',{'class':'Odds1X2Class'})
		#print 'divList len', len(divList), ',type:', type(divList)
		#print 'type:', type(divList[0].contents[1].get_text().encode("utf-8")), ',value:', divList[0].contents[1].get_text().encode("utf-8")
		hostWin = nodeToFloat(divList[0].contents[1])
		hostLost = nodeToFloat(divList[0].contents[3])	
		hostDeduce = nodeToFloat(divList[0].contents[5])
		hostHalfWin = nodeToFloat(divList[1].contents[1])
		hostHalfLost = nodeToFloat(divList[1].contents[3])
		hostHalfDeduce = nodeToFloat(divList[1].contents[5])

		# line_divL CRClass
		odds = item.find_all('div',{'class':'line_divL'})
		odds2 = item.find_all('div',{'class':'line_divR'})
		#print 'odds len:', len(odds), ',type:', len(odds[1]),',1:', odds[2].contents[0].string,',2:',odds[2].contents[1].string
		#print 'odds2 len:', len(odds2), ',type:', len(odds2[0]),',1:', odds2[0].contents[1].string,',2:',odds2[0].contents[3].string
		matchOdds = odds[0].contents[0].string
		matchHostOdds = nodeToFloat(odds2[0].contents[1])
		matchGuestOdds = nodeToFloat(odds2[0].contents[3])

		matchBig = odds[1].contents[0].string
		matchHostBigOdds = nodeToFloat(odds2[1].contents[1])
		matchGuestSmallOdds = nodeToFloat(odds2[1].contents[3])

		matchHalfOdds = odds[2].contents[1].string
		matchHalfHostOdds = nodeToFloat(odds2[2].contents[1])
		matchHalfGuestOdds = nodeToFloat(odds2[2].contents[3])

		matchHalfBig = odds[3].contents[0].string
		matchHalfHostBig = nodeToFloat(odds2[3].contents[1])
		matchHalfGuestSmall = nodeToFloat(odds2[3].contents[3])
		
		#print 'matchOdds:', matchOdds, 'matchHostOdds:',matchHostOdds,'matchGuestOdds:',matchGuestOdds
		#print 'matchBig:', matchBig, 'matchHostBigOdds:',matchHostBigOdds,'matchGuestSmallOdds:',matchGuestSmallOdds

		#print 'matchHalfOdds:', matchHalfOdds, 'matchHalfHostOdds:',matchHalfHostOdds,'matchHalfGuestOdds:',matchHalfGuestOdds
		#print 'matchHalfBig:', matchHalfBig, 'matchHalfHostBig:',matchHalfHostBig,'matchHalfGuestSmall:',matchHalfGuestSmall
		#sql = """insert into t_matches (host_team,guest_team,host_win,host_lost,host_deduce,host_half_win,host_half_lost,host_half_deduce,\
		#match_odds,match_host_odds,match_guest_odds,match_big,match_host_big,match_guest_small,match_half_odds,match_half_host_odds,\
		#match_half_guest_odds,\
		#data = (host,guest,hostWin,hostLost,hostDeduce,hostHalfWin,hostHalfLost,hostHalfDeduce,matchOdds,matchHostOdds,matchGuestOdds,matchBig,\
		#	matchHostBigOdds,matchGuestSmallOdds,matchHalfOdds,matchHalfHostOdds,matchHalfGuestOdds,matchHalfBig,matchHalfHostBig,\
		#	matchHalfGuestSmall,result,time)
		dt=datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")  
		sql = '''insert into t_matches (host_team,guest_team,host_win,host_lost,host_deduce,host_half_win,host_half_lost,host_half_deduce, \
		match_odds,match_host_odds,match_guest_odds,match_big,match_host_big,match_guest_small,match_half_odds,match_half_host_odds,match_half_guest_odds \
		,match_half_big,match_half_host_big,match_half_guest_small, match_result,create_date,match_time )\
		values ( '%s', '%s','%f','%f','%f','%f','%f','%f','%s','%f','%f','%s','%f','%f','%s','%f','%f','%s','%f','%f','%s','%s','%s')''' \
		% (host,guest,hostWin,hostLost,hostDeduce,hostHalfWin,hostHalfLost,hostHalfDeduce,matchOdds,matchHostOdds,matchGuestOdds, \
			matchBig,matchHostBigOdds,matchGuestSmallOdds,matchHalfOdds,matchHalfHostOdds,matchHalfGuestOdds,matchHalfBig,matchHalfHostBig,matchHalfGuestSmall, \
			result,dt,newTime)
		try:
			print 'start to execute:', sql
			cursor.execute(sql)
	   		db.commit()
		except MySQLdb.Error,e:
			print "Mysql Error %d: %s" % (e.args[0], e.args[1])
			db.rollback()
		#fo.write(item.prettify())

	db.close()
	fo.close()
except BaseException,e:
	print 'error occur:', e.args
