import os
import logging
import requests
from time import sleep
from selenium import webdriver
from bs4 import BeautifulSoup as soup
import random
import shutil
import urllib3

# OBTAIN THE PATH THE PROGRAM IS IN
fileDir = os.path.dirname(os.path.realpath('__file__'))
# OBTAIN THE PATH TO THE GECKODRIVER
geckopath = os.path.join(fileDir, 'Drivers/GeckoDriver/geckodriver.exe')
# browser = webdriver.Firefox(executable_path = geckopath)

# LOOK FOR THE TOP 25 TEXT FILE CREATED IN FOLDER "SEARCH"
filename = os.path.join(fileDir, 'Drivers/search/top25.txt')
# OPEN THAT FILE AND OBTAIN THE INFORMATION (CITY,STATE)
with open(filename) as f:
    content = f.readlines()
# REMOVE ALL THE \n
content = [x.strip() for x in content]
f.close()
# print(content)

# CREATE LISTS FOR CITIES AND STATES
state = []
city = []

# PARSE EACH LINE OBTAINED IN THE TOP25.TXT
for x in content:
  word = x.split(",")
  word[0] = word[0].replace(" ", "-")
  city.append(word[0].strip())
  state.append(word[1].strip())

# CREATE DATA FOLDER
  if (os.path.isdir(os.path.join('Data'))):
      datapath = os.path.join(fileDir,'Data\\')
      shutil.rmtree(datapath)
  else:
      os.mkdir("Data")

# CREATE DIRECTORIES
for x, y in zip(city, state):
  # CREATE FOLDERS IN DATA
  city_state = x.title() + "_" + y.upper()
  # CREATE PATHS FOR DATA
  citystatepath = "/Data/"+ x.title() +"_" + y.upper()
  # print(citystatepath)

  # CREATE THE SUBFOLDERS FOR DATA
  os.makedirs(os.path.join('Data', city_state))

# CREATE A LIST FOR THE CUSTOM URLS NEEDED
my_urls = []
# CREATE THE URLS AND PLACE INTO URL LIST
for x, y in zip(city, state):
  curr_url = 'https://www.realtor.com/soldhomeprices/' + x.upper() + "_" + y.upper()
  my_urls.append(curr_url)
  sess = requests.Session()
  request = sess
  headers = {'User-Agent':'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.15) Gecko/20110303 Firefox/3.6.15'}
  proxies = {"http":"http://10.10.1.10:3128"}
  # request.cookies.clear()
  sleep( random.randint(4,8))
  request = requests.get(curr_url, headers=headers,proxies=proxies)
  print("*")
  print(request.status_code)
  print(request.cookies)
  print(request.headers)
  print("*")
  result = request
  data = result.text
  fuke = soup(data, 'html.parser')
  print(fuke)
  sess.close()
  request.close()
  print("completed : \t " + curr_url + "\t [x]")
  sleep(2)



# END OF PROGRAM
# clearthings = input("Test clear? : ")
# if clearthings == "yes":
#     datapath = os.path.join(fileDir,'Data')
#     shutil.rmtree(datapath)
# else:
#     print("keep it")

datapath = os.path.join(fileDir,'Data')
shutil.rmtree(datapath)

exit()
