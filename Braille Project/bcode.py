# LOGAN MALACHI CAMPBELL
# BRAILE CODE FUNCTION : USED TO CONVERT CHARACTERS
# TO THE INTERNATIONAL BRAILLE SYSTEM
# CAPSTONE PROJECT CSCE UARK : 010 641 227

def braillecode(character):

    braille = ""
    zeroZero = "[ ][ ]\n"
    oneZero = "[*][ ]\n"
    oneOne = "[*][*]\n"
    zeroOne = "[ ][*]\n"
    spacer = "------"
    # template = [1][4][2][5][3][6]
    if (character == 'A' or character == 'a'):
        # braille = "[*][ ]\n[ ][ ]\n[ ][ ]\n------"
        braille = oneZero + zeroZero + zeroZero + spacer
        return braille
    if (character == 'B' or character == 'b'):
        # braille = "[*][ ]\n[*][ ]\n[ ][ ]\n------"
        braille = oneZero + oneZero + zeroZero + spacer
        return braille
    if (character == 'C' or character == 'c'):
        # braille = "[*][*]\n[ ][ ]\n[ ][ ]\n------"
        braille = oneOne + zeroZero + zeroZero + spacer
        return braille
    if (character == 'D' or character == 'd'):
        # braille = "[*][*]\n[ ][*]\n[ ][ ]\n------"
        braille = oneOne + zeroOne + zeroZero + spacer
        return braille
    if (character == 'E' or character == 'e'):
        braille = oneZero + zeroOne + zeroZero + spacer
        return braille
    if (character == 'F' or character == 'f'):
        braille = oneOne + oneZero + zeroZero + spacer
        return braille
    if (character == 'G' or character == 'g'):
        braille = oneOne + oneOne + zeroZero + spacer
        return braille
    if (character == 'H' or character == 'h'):
        braille = oneZero + oneOne + zeroZero + spacer
        return braille
    if (character == 'I' or character == 'i'):
        braille = zeroOne + oneZero + zeroZero + spacer
        return braille
    if (character == 'J' or character == 'j'):
        braille = zeroOne + oneOne + zeroZero + spacer
        return braille
    if (character == 'K' or character == 'k'):
        braille = oneZero + zeroZero + oneZero + spacer
        return braille
    if (character == 'L' or character == 'l'):
        braille = oneZero + oneZero + oneZero + spacer
        return braille
    if (character == 'M' or character == 'm'):
        braille = oneOne + zeroZero + oneZero + spacer
        return braille
    if (character == 'N' or character == 'n'):
        braille = oneOne + zeroOne + oneZero + spacer
        return braille
    if (character == 'O' or character == 'o'):
        braille = oneZero + zeroOne + oneZero + spacer
        return braille
    if (character == 'P' or character == 'p'):
        braille = oneOne + oneZero + oneZero + spacer
        return braille
    if (character == 'Q' or character == 'q'):
        braille = oneOne + oneOne + oneZero + spacer
        return braille
    if (character == 'R' or character == 'r'):
        braille = oneZero + oneOne + oneZero + spacer
        return braille
    if (character == 'S' or character == 's'):
        braille = zeroOne + oneZero + oneZero + spacer
        return braille
    if (character == 'T' or character == 't'):
        braille = zeroOne + oneOne + oneZero + spacer
        return braille
    if (character == 'U' or character == 'u'):
        braille = oneZero + zeroZero + oneOne + spacer
        return braille
    if (character == 'V' or character == 'v'):
        braille = oneZero + oneZero + oneOne + spacer
        return braille
    if (character == 'W' or character == 'w'):
        braille = zeroOne + oneOne + zeroOne + spacer
        return braille
    if (character == 'X' or character == 'x'):
        braille = oneOne + zeroZero + oneOne + spacer
        return braille
    if (character == 'Y' or character == 'y'):
        braille = oneOne + zeroOne + oneOne + spacer
        return braille
    if (character == 'Z' or character == 'zs'):
        braille = oneZero + zeroOne + oneOne + spacer
        return braille
    if (character == '1'):
        braille = oneZero + zeroZero + zeroZero + spacer
        return braille
    if (character == '2'):
        braille = oneZero + oneZero + zeroZero + spacer
        return braille
    if (character == '3'):
        braille = oneOne + zeroZero + zeroZero + spacer
        return braille
    if (character == '4'):
        braille = oneOne + zeroOne + zeroZero + spacer
        return braille
    if (character == '5'):
        braille = oneZero + zeroOne + zeroZero + spacer
        return braille
    if (character == '6'):
        braille = oneOne + oneZero + zeroZero + spacer
        return braille
    if (character == '7'):
        braille = oneOne + oneOne + zeroZero + spacer
        return braille
    if (character == '8'):
        braille = oneZero + oneOne + zeroZero + spacer
        return braille
    if (character == '9'):
        braille = zeroOne + oneZero + zeroZero + spacer
        return braille
    if (character == '0'):
        braille = zeroOne + oneOne + zeroZero + spacer
        return braille
    if (character == " "):
        braille = zeroZero + zeroZero + zeroZero + spacer
        return braille
