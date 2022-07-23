package com.aviewlib.imageTools;
import android.graphics.*;

public class ColorTools
{


	public int setAlaph(int colors , int Alaph, Bitmap.Config cofs)
	{
		int red;
		int green;
	
		int blue;
		/*Bitmap.Config.RGBA_F16
		 Bitmap.Config.HARDWARE
		 Bitmap.Config.ALPHA_8
		 Bitmap.Config.RGB_565
		 Bitmap.Config.ARGB_8888
		 Bitmap.Config.ARGB_4444*/
		if (cofs == Bitmap.Config.ARGB_8888)
		{
			if (Alaph > 255)
			{
				throw new ImageOperationException("Alaph Value too large.");


			}
			red = colors >> 16 & 255;
			green = colors >> 8 & 255;
			blue = colors & 0xFF;
			return Alaph << 24 | red << 16 | green << 8 | blue;
		}
		if (cofs == Bitmap.Config.ALPHA_8)
		{

			if (Alaph > 255)
			{
				throw new ImageOperationException("Alaph Value too large.");


			}
			return Alaph;

		}
		if (cofs == Bitmap.Config.ARGB_4444)
		{
			if (Alaph > 15)
			{
				throw new ImageOperationException("Alaph Value too large.");

			}
			red = colors >> 8 & 15;
			green = colors >> 4 & 15;
			blue = colors & 15;
			return Alaph << 12 | red << 8 | green << 4 | blue;
		}
		throw new ImageOperationException("Not an ARGB color, or not a color");
	}

	public int getAlaph(Color colors)
	{
		if (colors.getConfig() == Bitmap.Config.ARGB_8888)
		{

			return colors.getColor() >> 24;
		}
		if (colors.getConfig() == Bitmap.Config.ARGB_4444)
		{

			return colors.getColor() >> 12;
		}

		throw new ImageOperationException("Not an ARGB color, or not a color");
	}
	public int getAlaph(int Color, Bitmap.Config  fomat)
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
		throw new ImageOperationException("Not an ARGB color, or not a color");

	}

}
