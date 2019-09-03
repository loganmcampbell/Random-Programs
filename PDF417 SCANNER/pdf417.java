import java.io.File;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.imageio.*;

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
  public static void threshold (BufferedImage picture, int THRESHOLD)
  {
    //int THRESHOLD = 100;
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
  public static void pixelate (BufferedImage img, int pixelsize)
  {
    try
    {
      BufferedImage imagePixelated = ImageUtil.pixelate(img, pixelsize);
      ImageIO.write(imagePixelated, "png", new File("pixelate.png"));
    }
    catch (IOException e)
    {
    }
  }






  public static void main(String args[])
  {
    //create an image object in ram

    int slice = 0;
    BufferedImage image = null;
    String input_file_path ="";

    Boolean leftup = true;
    Boolean rightup = true;
    Boolean leftdown = true;
    Boolean rightdown = true;
    final int deviation = 5;
    int lastpixelx = 0; int lastpixely = 0; int lastpixelx2 = 0; int lastpixely2 = 0;
            Vector<Integer> xbound = new Vector<Integer>();
            Vector<Integer> ybound = new Vector<Integer>();

                  //RED
                  Color paint1 = new Color(255,0,0);
                  int red = paint1.getRGB();

                  //BLUE
                  Color paint2 = new Color(0,0,255);
                  int blue = paint2.getRGB();

                  //GREEN
                  Color paint3 = new Color(0,255,0);
                  int green = paint3.getRGB();

                  //GRAY
                  Color paint4 = new Color(220,220,220);
                  int GRAY = paint4.getRGB();

                  //YELLOW
                  Color paint5 = new Color(255, 255, 0);
                  int yellow = paint5.getRGB();
    //READ
    try
    {
      //obtain file image
      File input_folder = new File("C:\\Users\\Logan\\Desktop\\random programs\\PDF417 READ\\read\\");
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

      //HARD CODE TESTING:

      int choice = 0;
      File input_file = new File(array[choice]);
      image = ImageIO.read(input_file);
      pixelate(image,5);
      threshold(image,100);
      System.out.println("Reading complete");
      //BufferedImage inputImg = ImageIO.read(input_file);
      //Instead of creating a new image... send it back to main object
      File threshold_file = new File("threshold.png");
      image = ImageIO.read(threshold_file);
    }

    catch(IOException ex)
    {
      System.out.println("error : " + ex);
    }
    int x = image.getWidth();
    int y = image.getHeight();
    System.out.println("x = " + x);
    System.out.println("y = " + y);
    //Boolean[][] scan = new Boolean[x][y];
try
{
      //int [][] pixels = new int[x][y];


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

        //CERTAIN COLOR PIXEL: [BLACK PIXEL]
        //This alone, colors all black pixels in image.
        //--------------------------------------------
        if ( r == 0 && g == 0 && b == 0)
        {
          int xaxis = xvalue;
          int yaxis = yvalue;
          slice++;
          image.setRGB(xvalue, yvalue, red);
          //FIND THE FIRST LEFT TOP PIXEL OF THE ENTIRE BLOCK
          //------------------------------------------------
          if (leftup == true)
          {
            System.out.println("LEFT UP || PAINTED YELLOW AT : " + xvalue + " , " + yvalue);
            image.setRGB(xvalue, yvalue, yellow);
            leftup = false;
          }
          //------------------------------------------------

          //FIND THE FIRST LEFT BOTTOM PIXEL OF THE ENTIRE BLOCK
          //----------------------------------------------------
          if (xbound.isEmpty())
          {
            //System.out.println("ADDED : " + xaxis);
            xbound.add(xaxis);
            lastpixelx = xaxis;
            lastpixely = yvalue;
          }
          else
          {
          boolean range  = true;
          for (int z = xaxis; z <= (xaxis+5); z++)
          {
            if (xbound.contains(z))
            {
              range = false;
              //System.out.println("ignore: " + z);
            }
          }
          for (int z = xaxis - 5; z <= (xaxis); z++)
          {
            if (xbound.contains(z))
            {
              range = false;
              if (lastpixelx != xvalue && lastpixelx != 1)
              {
                //System.out.println(lastpixelx + " " + lastpixely + " -> "+ yvalue+ " " + xvalue);
                if (leftdown == true)
                {
                System.out.println("LEFT DOWN || PAINTED YELLOW AT : " + lastpixelx + " , " + lastpixely);
                image.setRGB(lastpixelx, lastpixely, yellow);
                leftdown = false;
                }

              }
              lastpixelx = xvalue; lastpixely = yvalue;
              //System.out.println("ignore: " + z);
              //System.out.println(" at " + xvalue + " " + yvalue);


            }
          }


          if ( range == true)
          {
            xbound.add(xaxis);
          }
            //------------------------------------------------
            //System.out.println("ADDED : " + xaxis);
        }







        //Let's check the next color over (in the x-direction) since we know the current one  is black!
          int nextx = xvalue + 1;
        //--------------------------------------------
          //SAVE THE INTIAL BLACK PIXEL POSITION.
          int row = yvalue;
          //System.out.println("SQUARE ["+slice+"]");
          //Use a loop to enable to scan The image in the x direction for as long as the image.





          while ( (nextx < x))
          {
            //CHECK THE COLOR  OF THE [NEXT OVER PIXEL (WITHIN THE SAME ROW HENCE ROW CONSTANT)]
            int given = image.getRGB(nextx, row);

            /*
            System.out.println("COLUMN: " + nextx);
            System.out.println("ROW : " + row);
            */

            //TRANFROM BYTES TO COLORS
             int rN = (given>>16)&0xFF;
             int gN = (given>>8)&0xFF;
             int bN = (given>>0)&0xFF;
             int aN = (given>>24)&0xFF;



            if (rN == 0 && gN == 0 && bN == 0)
            {

              //System.out.println("COLORED");
              image.setRGB(nextx,row, green); //color the black pixel a color if you wanted to as well.
              nextx++;  //at this point it is okay to move to the next pixel in the x direction.

            }
            //BASE CASE CHECK IF IT IS WHITE!
            else if (rN == 255 && gN == 255 && bN == 255)
            {
               //System.out.println("lastx : " + lastpixelx2 + " lasty : " + lastpixely2 + "\t cx: " + nextx + " cy: " + row);
               if (lastpixelx2 != nextx)
               {

                   if (rightdown == true && lastpixelx2 != 0) // LastPixelx2 can't be zero only if the image has a black pixel in the topleftcorner to be read.
                   {
                     System.out.println("RIGHT DOWN || PAINTED YELLOW AT : " + lastpixelx2 + " , " + lastpixely2);
                     image.setRGB(lastpixelx2,lastpixely2, yellow);
                     rightdown = false;

                   }

             }
               lastpixelx2 = nextx;
               lastpixely2 = row;

               image.setRGB(nextx,row, blue); //color the white pixel a color if you wanted to.
               //FIND THE FIRST LEFT TOP PIXEL OF THE ENTIRE IMAGE
               //------------------------------------------------
               if (rightup == true)
               {

                 image.setRGB(nextx, row, yellow);
                 System.out.println("RIGHT UP || PAINTED YELLOW AT : " + nextx + " , " + row);
                 rightup = false;
               }
               //------------------------------------------------
              //revert to the intial position of black color where you started.
              //at this point you're down with this row and need to move new row

                               int get = image.getRGB(nextx, row + 1);
                               //TRANFROM BYTES TO COLORS
                                int rw = (given>>16)&0xFF;
                                int gw = (given>>8)&0xFF;
                                int bw = (given>>0)&0xFF;
                                int aw = (given>>24)&0xFF;

                                if (rw == 255 && gw == 255 && bw == 255)
                                {
                                //   if (slice == 5399)
                                //   {
                                //     String save = "slice[" + slice + "].jpg";
                                //     ImageIO.write(image.getSubimage(0, 0, x, y), "png", new File(save));
                                //     if( slice == 5)
                                //     {
                                //       System.exit(0);
                                //     }
                                // }

                                  break;


                                }
                                row++;

            }

          }

        }
        //System.out.println("RED [" + r + "]");
        //System.out.println("GREEN [" + g + "]");
        //System.out.println("BLUE [" + b + "]");
        //System.out.println("ALPHA [" + a + "]");
        System.out.print("\t AT : (" + x + ","+ y + ") RED[" + r +"]|GREEN["+ g + "]|BLUE[" + b +"]|ALPHA[" + a + "]\n");
      }

    }
    File outputfile = new File("output.png");
    ImageIO.write(image, "png", outputfile);
  }

  catch (IOException e)
  {
  }




  System.out.println("\n\n\nprocess completed");
}
}
