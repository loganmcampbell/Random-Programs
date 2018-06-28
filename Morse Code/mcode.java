import java.util.Scanner;

public class mcode
{

  public static String malpha (char letter)
  {
    String morse = "";
    if (letter == 'a' || letter == 'A')
      morse = "o --";
    if (letter == 'b' || letter == 'B')
      morse = "-- o o o";
    if (letter == 'c' || letter == 'C')
      morse = "-- o -- o";
    if (letter == 'd' || letter == 'D')
      morse = "-- o o";
    if (letter == 'e' || letter == 'E')
      morse = "o";
    if (letter == 'f' || letter == 'F')
      morse = "o o -- o";
    if (letter == 'g' || letter == 'G')
      morse = "-- -- o";
    if (letter == 'h' || letter == 'H')
      morse = "o o o o";
    if (letter == 'i' || letter == 'I')
      morse = "o o";
    if (letter == 'j' || letter == 'J')
      morse = "o -- -- --";
    if (letter == 'k' || letter == 'K')
      morse = "-- o --";
    if (letter == 'l' || letter == 'L')
      morse = "o -- o o";
    if (letter == 'm' || letter == 'M')
      morse = "-- --";
    if (letter == 'n' || letter == 'N')
      morse = "-- o";
    if (letter == 'o' || letter == 'O')
      morse = "-- -- --";
    if (letter == 'p' || letter == 'P')
      morse = "o -- -- o";
    if (letter == 'q' || letter == 'Q')
      morse = "-- -- o --";
    if (letter == 'r' || letter == 'R')
      morse = "o -- o";
    if (letter == 's' || letter == 'S')
      morse = "o o o";
    if (letter == 't' || letter == 'T')
      morse = "--";
    if (letter == 'u' || letter == 'U')
      morse = "o o --";
    if (letter == 'v' || letter == 'V')
      morse = "o o o --";
    if (letter == 'w' || letter == 'W')
      morse = "o -- --";
    if (letter == 'x' || letter == 'X')
      morse = "-- o o --";
    if (letter == 'y' || letter == 'Y')
      morse = "-- o -- --";
    if (letter == 'z' || letter == 'Z')
      morse = "-- -- o o";
    return morse;
  }

  public static String mnumber (char number)
  {
    String morse = "";
    if (number == '1')
      morse = "o -- -- -- --";
    if (number == '2')
      morse = "o o -- -- --";
    if (number == '3')
      morse = "o o o -- --";
    if (number == '4')
      morse = "o o o o --";
    if (number == '5')
      morse = "o o o o o";
    if (number == '6')
      morse = "-- o o o o";
    if (number == '7')
      morse = "-- -- o o o";
    if (number == '8')
      morse = "-- -- -- o o";
    if (number == '9')
      morse = "-- -- -- -- o";
    if (number == '0')
      morse = "-- -- -- -- --";
    return morse;
  }

  public static void main(String[] args)
  {
    // Scanner reader = new Scanner(System.in);  // Reading from System.in
    // System.out.println("Enter a word: ");
    // String w = reader.next();
    // //once finished
    // reader.close();
    // System.out.println("w");
    String words = "MORSE CODE 1";
    String code = "";
    for (int x = 0; x < words.length(); x++)
    {
      char c = words.charAt(x);
      if (Character.isLetter(c))
        code = code + malpha(c) + " | ";
      if (Character.isDigit(c))
        code = code + mnumber(c) + " | ";
    }

    System.out.println(code);
  }



}
