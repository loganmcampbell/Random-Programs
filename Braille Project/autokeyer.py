import pyautogui
from pynput.keyboard import Controller
import time

keyboard = Controller()

decay = 5

print('\n')
delay = 0.0012/100000000
# print(delay)
# print('\n')
time.sleep(3)
for i in range(0, 5):
    time.sleep(.5)

name = "logan malachi campbell"
for s in name:
    time.sleep(delay)
    pyautogui.typewrite(s)
