package com.aviewlib.imageTools;
import android.graphics.*;
import android.graphics.drawable.*;
import android.widget.*;
import android.util.*;
public class Picturesplicing
{
	private static int getBmpArrWidth(Bitmap[] bmparr)
	{

		int Tcv=0;
		for (int i=0;i < bmparr.length;i++)
		{

			Tcv = Tcv + bmparr[i].getWidth();


		}
		return Tcv;
	}
	public static int getBmpArrHeight(Bitmap[] bmparr)
	{

		int Tcv=0;

		for (int i=0;i < bmparr.length;i++)
		{

			Tcv = Tcv + bmparr[i].getHeight();


		}

		return Tcv;
	}
	public static  int Getwidestpicture(Bitmap[] bmparr)
	{
		int Tcv=-100;

		for (int i=0;i < bmparr.length;i++)
		{
			if (bmparr[i].getWidth() > Tcv)
			{
				Tcv = bmparr[i].getWidth();

			}

		}
		return Tcv;
	}
	private static  int Gethighestheight(Bitmap[] bmparr)
	{

		int Tcv=-100;

		for (int i=0;i < bmparr.length;i++)
		{
			if (bmparr[i].getHeight() > Tcv)
			{
				Tcv = bmparr[i].getHeight();

			}

		}

		return Tcv;
	}

	public static Bitmap TransverseSplice(Bitmap[] bmparr, Bitmap.Config cofs)
	{
		Bitmap.Config SaveFormat=Bitmap.Config.ARGB_8888;

		if (cofs != null)
		{
			SaveFormat = cofs;

		}
		Bitmap SaveBitmp=Bitmap.createBitmap(getBmpArrWidth(bmparr), Gethighestheight(bmparr),  SaveFormat);
		int Offset=0;

		int[][] BitmapPixelArray;
		int i=0;
		int x=0;
		int y=0;
		for (i = 0;i < bmparr.length;i++)
		{
			BitmapPixelArray = Image2Array.image2Arrays(bmparr[i]);
			for (x = 0;x < BitmapPixelArray[0].length;x++)

			{
				for (;y < BitmapPixelArray.length;y++)
				{
					SaveBitmp.setPixel(x + Offset, y, BitmapPixelArray[y][x]);


				}
				y = 0;

			}
			Offset = Offset + bmparr[i].getWidth();


		}


		return SaveBitmp;

	}

	public static Bitmap LongitudinalSplice(Bitmap[] bmparr, Bitmap.Config cofs)
	{

		Bitmap.Config SaveFormat=Bitmap.Config.ARGB_8888;

		if (cofs != null)
		{
			SaveFormat = cofs;

		}
		Bitmap SaveBitmp=Bitmap.createBitmap(Getwidestpicture(bmparr), getBmpArrHeight(bmparr), SaveFormat);
        int Offset=0;
		int[][] BitmapPixelArray;
		int i=0;
		int x=0;
		int y=0;

		for (;i < bmparr.length;i++)
		{

			BitmapPixelArray = Image2Array.image2Arrays(bmparr[i]);
			for (;y < BitmapPixelArray.length;y++)
			{
				for (;x < BitmapPixelArray[0].length;x++)
				{

					SaveBitmp.setPixel(x, y + Offset, BitmapPixelArray[y][x]);
					//Log.d("test", String.valueOf(y + Offset));
					//Log.d("test", String.valueOf(x));

				}
				x = 0;


			}

			y = 0;

			Offset = Offset + bmparr[i].getHeight();
		}
		return SaveBitmp;

	}

}
