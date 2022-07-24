package com.aviewlib.imageTools;
import android.graphics.*;

public class ColorTools
{

	
	public int[] DecomposeColor(int color,Bitmap.Config fomat){
		int Alpha;
		int red;
		int green;
		int blue;
		
		
		if(fomat==Bitmap.Config.ARGB_4444)
		{
			Alpha=color>> 12&15;
			red = color >> 8 & 15;
			
			green = color >> 4 & 15;
		
			blue = color & 15;
			
			return new int[]{Alpha,red,green,blue};
		}
		
		if(fomat==Bitmap.Config.ARGB_8888)
		{
			Alpha=color>> 24&255;
			red = color >> 16 & 255;
			
			green = color >> 8 & 255;
		
			blue = color & 255;
			
			return new int[]{Alpha,red,green,blue};
		}
		
		if(fomat==Bitmap.Config.ALPHA_8){
			
			return new int[]{color};
			
		}
		if(fomat==Bitmap.Config.RGB_565)
		{
			
			red = color >> 11 & 31;
			
			green = color >> 6 & 63;
		
			blue = color & 31;
			
			return new int[]{red,green,blue};
		}
		throw new ImageOperationException("Not an ARGB color, or not a color");
	}
	public int[] DecomposeColor(Color color){
		int Alpha;
		int red;
		int green;
		int blue;
		
		
		if(color.getConfig()==Bitmap.Config.ARGB_4444)
		{
			Alpha=color.getColor()>> 12&15;
			red = color.getColor() >> 8 & 15;
			
			green = color.getColor() >> 4 & 15;
		
			blue = color.getColor() & 15;
			
			return new int[]{Alpha,red,green,blue};
		}
		
		if(color.getConfig()==Bitmap.Config.ARGB_8888)
		{
			Alpha=color.getColor()>> 24&255;
			red = color.getColor() >> 16 & 255;
			
			green = color.getColor() >> 8 & 255;
		
			blue = color.getColor() & 255;
			
			return new int[]{Alpha,red,green,blue};
		}
		
		if(color.getConfig()==Bitmap.Config.ALPHA_8){
			
			return new int[]{color.getColor()};
			
		}
		if(color.getConfig()==Bitmap.Config.RGB_565)
		{
			
			red = color.getColor() >> 11 & 31;
			
			green = color.getColor() >> 6 & 63;
		
			blue = color.getColor() & 31;
			
			return new int[]{red,green,blue};
		}
		throw new ImageOperationException("Not an ARGB color, or not a color");
	}

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
			blue = colors & 255;
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
	public int setAlaph(Color colors , int Alaph, Bitmap.Config cofs)
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
			red = colors.getColor() >> 16 & 255;
			green = colors.getColor() >> 8 & 255;
			blue = colors.getColor() & 255;
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
			red = colors.getColor() >> 8 & 15;
			green = colors.getColor() >> 4 & 15;
			blue = colors.getColor() & 15;
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
