package com.aviewlib.ImageTools;
import android.graphics.*;
import android.graphics.drawable.*;
import android.widget.*;
import android.util.*;
public class Picturesplicing
{
	public static int getBmpArrWidth(Bitmap[] bmparr)
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
		int Tcv=0;
		for (int i=0;i < bmparr.length;i++)
		{
			if (bmparr[i].getWidth() > Tcv)
			{
				Tcv = bmparr[i].getWidth();
			}
		}
		return Tcv;
	}


	public static  int Gethighestheight(Bitmap[] bmparr)
	{
		int Tcv=0;
		for (int i=0;i < bmparr.length;i++)
		{
			if (bmparr[i].getHeight() > Tcv)
			{
				Tcv = bmparr[i].getHeight();

			}
		}
		return Tcv;
	}




	public static Bitmap TransverseSplice(Bitmap[] bmparr, Bitmap.Config cofs, int interval)
	{
		//横向拼接图片
		Bitmap.Config SaveFormat=Bitmap.Config.ARGB_8888;

		if (cofs != null)
		{
			SaveFormat = cofs;
		}


		Bitmap SaveBitmp=Bitmap.createBitmap(getBmpArrWidth(bmparr) + (interval * (bmparr.length - 1)), Gethighestheight(bmparr),  SaveFormat);
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
			Offset = Offset + bmparr[i].getWidth() + interval;


		}


		return SaveBitmp;

	}



	public static Bitmap LongitudinalSplice(Bitmap[] bmparr, Bitmap.Config cofs, int interval)
	{
		//纵向拼接图片
		Bitmap.Config SaveFormat=Bitmap.Config.ARGB_8888;

		if (cofs != null)
		{
			SaveFormat = cofs;

		}

		Bitmap SaveBitmp=Bitmap.createBitmap(Getwidestpicture(bmparr), getBmpArrHeight(bmparr) + (interval * (bmparr.length - 1)), SaveFormat);
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
				}
				x = 0;
			}
			y = 0;
			Offset = Offset + bmparr[i].getHeight() + interval;
		}
		
		return SaveBitmp;
	}

	public static Bitmap TransverseSplice(String[] bmparra, Bitmap.Config cofs, int interval)
	{
		Bitmap[] bmparr=new Bitmap[bmparra.length];
		for (int i=0;i < bmparr.length;i++)
		{
			bmparr[i] = BitmapFactory.decodeFile(bmparra[i]);
		}
		return TransverseSplice(bmparr, cofs, interval);
	}

	public static Bitmap LongitudinalSplice(String[] bmparra, Bitmap.Config cofs, int interval)
	{
		Bitmap[] bmparr=new Bitmap[bmparra.length];
		for (int i=0;i < bmparr.length;i++)
		{
			bmparr[i] = BitmapFactory.decodeFile(bmparra[i]);
		}
		return LongitudinalSplice(bmparr, cofs, interval);
	}

	public static Bitmap LongitudinalSplice(String[] bmparra)
	{
		return LongitudinalSplice(bmparra, null, 0);

	}
	public static Bitmap LongitudinalSplice(Bitmap[] bmparra)
	{
		return LongitudinalSplice(bmparra, null, 0);

	}

	public static Bitmap TransverseSplice(Bitmap[] bmparra)
	{
		return TransverseSplice(bmparra, null, 0);

	}
	public static Bitmap TransverseSplice(String[] bmparra)
	{
		return TransverseSplice(bmparra, null, 0);

	}
}
