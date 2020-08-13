#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
#include <windows.h>
using namespace std;

void typer (string typing)
{
  int x = 0;
  while ( typing[x] != '\0')
  {
  	cout << typing[x];
  	Sleep(50);
  	x++;
  };
}

void randomseed()
{
  srand(time(NULL));
}


int randomnumber1()
{
    //Numbers between 0 and 15
    int randomnumber = rand() % 15;
    return (randomnumber);
}
int randomnumber2()
{
    //Numbers between 0 and 15
    int randomnumber = rand() % 15;
    return (randomnumber);
}
int main()
{
  string title = "| E G Y P T I A N  R A T  S L A P |\n";
  typer(title);
  cout << "===================================" << endl;
  cout << "___________________________________" << endl;
  cout << endl; cout << endl;

  return 0;
}
