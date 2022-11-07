package com.aviewlib.ImageTools;
import android.graphics.*;

public class ColorTools
{


	public static int[] DecomposeColor(int color, Bitmap.Config fomat)
	{
		int Alpha,red,green,blue;


		if (fomat == Bitmap.Config.ARGB_4444)
		{
			Alpha = color >> 12 & 15;
			red = color >> 8 & 15;

			green = color >> 4 & 15;

			blue = color & 15;

			return new int[]{Alpha,red,green,blue};
		}

		if (fomat == Bitmap.Config.ARGB_8888)
		{
			Alpha = color >> 24 & 255;
			red = color >> 16 & 255;

			green = color >> 8 & 255;

			blue = color & 255;

			return new int[]{Alpha,red,green,blue};
		}

		if (fomat == Bitmap.Config.ALPHA_8)
		{

			return new int[]{color};

		}
		if (fomat == Bitmap.Config.RGB_565)
		{

			red = color >> 11 & 31;

			green = color >> 6 & 63;

			blue = color & 31;

			return new int[]{red,green,blue};
		}
		throw new ImageOperationException("Unsupported color format.");
	}



	public  static int setAlaph(int colors , int Alaph, Bitmap.Config fomat)
	{
		int red,green,blue;

		if (fomat == Bitmap.Config.ARGB_8888)
		{
			if (Alaph > 255)
			{
				throw new ImageOperationException("Transparency (Alpha) cannot be greater than 255.");
			}

			red = colors >> 16 & 255;
			green = colors >> 8 & 255;
			blue = colors & 255;
			return Alaph << 24 | red << 16 | green << 8 | blue;
		}


		if (fomat == Bitmap.Config.ALPHA_8)
		{
			if (Alaph > 255)
			{
				throw new ImageOperationException("Transparency (Alpha) cannot be greater than 255.");

			}

			return Alaph;
		}


		if (fomat == Bitmap.Config.ARGB_4444)
		{

			if (Alaph > 15)
			{
				throw new ImageOperationException("Transparency (Alpha) cannot be greater than 15.");

			}
			red = colors >> 8 & 15;
			green = colors >> 4 & 15;
			blue = colors & 15;
			return Alaph << 12 | red << 8 | green << 4 | blue;
		}

		throw new ImageOperationException("Unsupported color format.");
	}



	public static int getAlaph(int Color, Bitmap.Config  fomat)
	{
		if (fomat == Bitmap.Config.ARGB_8888)
		{
			return Color >> 24;
		}
		if (fomat == Bitmap.Config.ARGB_4444)
		{
			return Color >> 12;

		}
		if (fomat == Bitmap.Config.ALPHA_8)
		{
			return Color;
		}
		throw new ImageOperationException("Unsupported color format.");

	}







}
