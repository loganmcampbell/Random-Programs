/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import java.util.*;

/**
 *
 * @author Logan Malachi Campbell
 */
public class ImageSizer
{

    /**
     * @param args the command line arguments
     */
    public static void NewSize(String inputImgPath, String outputImgPath, int newWidth, int newHeight)
      throws IOException
        {
          //File direc = new File("C:\\Users\\Danin\\OneDrive\\Pictures");
          // array of extensions(use a List if you prefer)
          String[] EXTENSIONS = new String[]{
              "jpg", "jpeg","png"
          };
          // reads input image
          File inputFile = new File(inputImgPath);
          BufferedImage inputImg = ImageIO.read(inputFile);

          // creates output image
          BufferedImage outputImg = new BufferedImage(newWidth,
                  newHeight, inputImg.getType());

          // scales the input image to the output image
          Graphics2D gr2d = outputImg.createGraphics();
          gr2d.drawImage(inputImg, 0, 0, newWidth, newHeight, null);
          gr2d.dispose();

          // extracts extension of output file
          String formatName = outputImgPath.substring(outputImgPath
                  .lastIndexOf(".") + 1);

          // writes to output file
          ImageIO.write(outputImg, formatName, new File(outputImgPath));

        }


        public static String listFilesForFolder(final File folder)
        {

            String name = "";

            for (final File fileEntry : folder.listFiles())
            {
                if (fileEntry.isDirectory())
                {
                    listFilesForFolder(fileEntry);
                }
                else
                {
                    //System.out.println(fileEntry.getAbsolutePath());
                    name = name + (fileEntry.getAbsolutePath()) + "\n";

                }

            }
            return name;

        }



    public static void main(String[] args)
    {

            
            final File folder = new File("/Users/Logan/Pictures/resizepics");
            listFilesForFolder(folder);
            String names = listFilesForFolder(folder);
            String[] array = names.split("\n");
            String inputImgPath; String outputImgPath;

            for(int x = 0; x < array.length; x++)
            {
              inputImgPath  = array[x];
              outputImgPath = array[x].replace(".jpg", x +".jpg");
              //outputImgPath = array[x].replace(".png", x +".png");
              try
              {
                   // resize to a fixed width & height
                   int newWidth = 320;
                   int newHeight = 240;
                   ImageSizer.NewSize(inputImgPath, outputImgPath, newWidth, newHeight);
              }
              catch (IOException ex)
               {
                  System.out.println("Error resizing the image.");
                 ex.printStackTrace();
               }

            }





    }

}
