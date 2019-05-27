import java.io.File;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

public class pdf417
{

  public static String listFilesForFolder(final File folder)
  {

      String name = "";

      for (final File fileEntry : folder.listFiles())
          if (fileEntry.isDirectory())
              listFilesForFolder(fileEntry);
          else
              name = name + (fileEntry.getAbsolutePath()) + "\n";
      return name;
  }

  public static void threshold (BufferedImage picture)
  {
    int THRESHOLD = 100;
    BufferedImage pic = picture;
    Color white = Color.WHITE;
    int rgbWhite = white.getRGB();
    Color black = Color.BLACK;
    int rgbBlack = black.getRGB();
    Color colorize;
    for (int i = 0; i < pic.getWidth(); i++)
    {
      for (int j = 0; j < pic.getHeight(); j++)
      {
          //int color = pic.getRGB(i, j);
          Color pixel = new Color( pic.getRGB( i, j ) );
          double lum = Luminance.intensity(pixel);
          if (lum >= THRESHOLD)
          {
            pic.setRGB(i, j, rgbWhite);
          }
          else
          {
            pic.setRGB(i, j, rgbBlack);
          }
      }
    }
    try
    {
      File outputfile = new File("threshold.png");
      ImageIO.write(pic, "png", outputfile);
    }
    catch (IOException e)
    {
    }

  }

  public static void main(String args[])
  {
    //create an image object in ram
    BufferedImage image = null;
    String input_file_path ="";
    //READ
    try
    {
      //obtain file image


      // FILE DIRECTORY HERE: --->
      //=====================================
      File input_folder = new File("");
      //=====================================




      listFilesForFolder(input_folder);
      String names = listFilesForFolder(input_folder);
      String[] array = names.split("\n");
      //String input_file_path;
      int file_index = array.length;
      //reassign index because of testing purposes
      for (int x = 0; x < file_index; x++)
      {
        input_file_path = array[x];
        System.out.println("FILE #" + x + ": " + array[x]);
      }
      // Scanner reader = new Scanner(System.in);  // Reading from System.in
      // System.out.println("Enter a number [n]: ");
      // int choice = reader.nextInt(); // Scans the next token of the input as an int.
      // //once finished
      // reader.close();
      //create buffered image and pass the width and height
      //Type.TYPE_INT_ARGB is representing image pixel using 8bit int value
      //image = new BufferedImage (width,height, BufferedImage.TYPE_INT_ARGB);

      //HARD CODE CHOICE TESTING:
      //----------------------------------------
      int choice = 1;
      File input_file = new File(array[choice]);
      //----------------------------------------





      image = ImageIO.read(input_file);
      threshold(image);
      System.out.println("Reading complete");
      //BufferedImage inputImg = ImageIO.read(input_file);
      //Instead of creating a new image... send it back to main object
      image = ImageIO.read(input_file);
    }

    catch(IOException ex)
    {
      System.out.println("error : " + ex);
    }
    int x = image.getWidth();
    int y = image.getHeight();
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    int n = 0;
    //Boolean[][] scan = new Boolean[x][y];
try
{
      //int [][] pixels = new int[x][y];
      Color paint = new Color(255,0,0);
      int prgb = paint.getRGB();
    for (int xvalue = 0; xvalue < x; xvalue++)
    {
      for (int yvalue = 0; yvalue < y; yvalue++)
      {
        int argb = image.getRGB(xvalue,yvalue);
        //System.out.println(argb);
        //0xFF is an int literal (00 00 00 FF)
        //& is applied to yield the desired value for result
        // >> bitwise right shift by one bit
        //so argb is long unsigned integer
        //shifting the argb >> over to the number of bits allows to separate
        //each part of the number therefore letting &0xFF to convert it to a number
        int r = (argb>>16)&0xFF;
        int g = (argb>>8)&0xFF;
        int b = (argb>>0)&0xFF;
        int a = (argb>>24)&0xFF;
        //CERTAIN COLOR PIXEL:

        if ( r == 0 && g == 0 && b == 0)
        {
          //image.setRGB(xvalue, yvalue, prgb);
          int nextx = xvalue + 1;
          int nexty = yvalue + 1;
          while ((nextx <= y) && (nextx <= x))
          {
            int given = image.getRGB(nextx, yvalue);
            int rN = (given>>16)&0xFF;
            int gN = (given>>8)&0xFF;
            int bN = (given>>0)&0xFF;
            int aN = (given>>24)&0xFF;

            if (rN == 0 && gN == 0 && bN == 0)
            {
              image.setRGB(nextx,yvalue, prgb);
            }

            if (nextx <= x)
            {
              nextx++;
            }
            if (nexty <= y)
            {
              nexty++;
            }

          }

        }
        //System.out.println("RED [" + r + "]");
        //System.out.println("GREEN [" + g + "]");
        //System.out.println("BLUE [" + b + "]");
        //System.out.println("ALPHA [" + a + "]");
      }
    }

    System.out.println(n);
    File outputfile = new File("saved.png");
    ImageIO.write(image, "png", outputfile);
  }

  catch (IOException e)
  {
  }




  System.out.println("process completed");
}
}
