from bcode import braillecode
from pynput.keyboard import Listener


def on_press(key):
    input = str(key)
    print(key)
    if (key == "Key.esc"):
        return exit
    if (key == "Key.space"):
        braillecode("clear")

    for x in input:
        letter = input.replace("'", "")
    # print(input)
    if (letter.isalpha()):
        print(braillecode(letter))


with Listener(on_press=on_press) as listener:
        listener.join()
