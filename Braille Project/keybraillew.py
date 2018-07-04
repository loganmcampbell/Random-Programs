# LOGAN MALACHI CAMPBELL
# LIVE FEED THE BRAILLE FUNCTION INTO
# A KEYLOGGER TO DISPLAY KEYSTROKES AS
# AS BRAILLE


from bcode import braillecode
from pynput.keyboard import Listener

# log_dir = ""

# logging.basicConfig(filename=(log_dir + "keylog.txt"), level=logging.DEBUG,
#                     format='%s(asctime)s: %(messages)s:')


def on_press(key):
    input = str(key)
    print(key)
    # if key == Key.esc
    # return false
    for x in input:
        letter = input.replace("'", "")
    # print(input)
    if (letter.isalpha()):
        print(braillecode(letter))


with Listener(on_press=on_press) as listener:
        listener.join()
