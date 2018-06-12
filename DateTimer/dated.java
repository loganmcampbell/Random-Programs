import java.util.*;
import java.text.*;
public class dated
{


  public static void main (String [] args)
  {
    try
    {
      boolean check;
      check = true;
      while (check)
        {
          Thread.sleep(1000);
          Date date = new Date();
          SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
          //System.out.println("CURRENT D8 : " + date);
          DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
          Date birthday = formatter.parse("05/30/2018");
          System.out.println("[FORMAT] D8 : " + ft.format(date));

          if (date.equals(birthday))
          {
            System.out.println("HAPPY BIRTHDAY!!!!");
          }

        }
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

  }
}
