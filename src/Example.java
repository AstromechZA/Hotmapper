import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import hotmapper.Hotmap;
import hotmapper.Hotmap.ColourRange;


public class Example
{
	public static void main(String[] args)
	{
		double[][] derp = new double[1000][1000];
		
		for(int i=0;i<1000;i++)
		{
			int x = (int)(Math.random()*1000);
			int y = (int)(Math.random()*1000);
			derp[y][x] += Math.random()*20 + 10;
		}			

		Hotmap hm = new Hotmap(derp, 50);
		
		try {
		    BufferedImage bi = hm.makeImage(ColourRange.BLUE_TO_RED);
		    File outputfile = new File("sample.png");
		    ImageIO.write(bi, "png", outputfile);
		} catch (IOException e) { }
	}
}
