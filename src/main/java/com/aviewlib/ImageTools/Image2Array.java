package com.aviewlib.ImageTools;
import android.graphics.*;
import android.util.*;

public class Image2Array
{

	public static Bitmap Arrays2image(int[][] arrs)
	{
		return Arrays2image(arrs, null);
	}

	public static Bitmap Arrays2image(int[][] arrs, Bitmap.Config cofg)
	{

		int yh=arrs.length;
		int xh=arrs[0].length;
		Bitmap.Config cofs=Bitmap.Config.ARGB_8888;
		
		
		if (cofg != null)
		{
			cofs = cofg;
		}
		
		Bitmap bimps=Bitmap.createBitmap(xh, yh, cofs);

		for (int contx=0;contx < yh;contx++)
		{
			for (int conty=0;conty < xh;conty++)
			{
				bimps.setPixel(contx, conty, arrs[conty][contx]);

			}

		}

		return bimps;
	}

	public static int[][] image2Arrays(Bitmap bmp)
	{

		int x;
		int y;
		x = bmp.getWidth();
		y = bmp.getHeight();

		int xi=0;
		int yi=0;

		int[][] bmparr=new int[y][x];

		for (;yi < y ;yi++)

		{
			for (;xi < x ;xi++)
			{

				bmparr[yi][xi] = bmp.getPixel(xi, yi);

			}
			xi = 0;
		}
		yi = 0;
		return bmparr;
	}

}
