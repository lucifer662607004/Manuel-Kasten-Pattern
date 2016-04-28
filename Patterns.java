/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Steven
 */
public class Patterns {
    static int width=1024;
    static int height=1024;
    static int marginH=0;
    static int marginW=0;
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println(Patterns.RD(500, 500));
        if (args.length>1) {
            try {
                marginH=Integer.parseInt(args[0]);
                marginW=Integer.parseInt(args[1]);
                
            }catch (NumberFormatException e){
                System.out.println("Wrong Params! Usage: \njava Patterns <int Height-1024> <int Width-1024>");
                marginH=0;
                marginW=0;
            }
            
        }
        long start = System.currentTimeMillis();
        BufferedImage result=new BufferedImage(width+2*marginW,height+2*marginH,BufferedImage.TYPE_INT_RGB);
        //Graphics2D g=result.createGraphics();
        for (int i=0-marginW;i<width+marginW;i++){
            for (int j=0-marginH;j<height+marginH;j++){
                Color c=new Color((int)Patterns.RD(i, j),(int)Patterns.GR(i, j),(int)Patterns.BL(i, j));
                result.setRGB(i+marginW, j+marginH, c.getRGB());//Time Eslapse: 5.94
                //g.setColor(c);
                //g.drawRect(i+marginW, j+marginH, 1, 1);//6.009
                //g.drawLine(i, j, 1, 1);//Time Eslapse: 8.544
            }
        }
        //g.dispose();
        try{
            File output=new File("result.png");
            ImageIO.write(result, "png", output);
        }catch (IOException e){
            System.out.println("IOException");
        }
        System.out.println("Done.");
        long eslapsedTime = System.currentTimeMillis() -start;
        System.out.println("Time Eslapse: "+eslapsedTime/1000F);
    }
    
    public static double RD(int i, int j){
        double a=0,b=0,c,d,n=0;
        while((c=a*a)+(d=b*b)<4&&n++<880){
            b=2*a*b+j*8e-9-.645411;
            a=c-d+i*8e-9+.356888;
        }
//        System.out.println(n);
        return 255*(java.lang.Math.pow((n-80)/800,.3));
    }
    public static double GR(int i, int j){
        double a=0,b=0,c,d,n=0;
        while((c=a*a)+(d=b*b)<4&&n++<880){
            b=2*a*b+j*8e-9-.645411;
            a=c-d+i*8e-9+.356888;
        }
//        System.out.println(n);
        return 255*(java.lang.Math.pow((n-80)/800,.7));
    }
    public static double BL(int i, int j){
        double a=0,b=0,c,d,n=0;
        while((c=a*a)+(d=b*b)<4&&n++<880){
            b=2*a*b+j*8e-9-.645411;
            a=c-d+i*8e-9+.356888;
        }
//        System.out.println(n);
        return 255*(java.lang.Math.pow((n-80)/800,.5));
    }
}
