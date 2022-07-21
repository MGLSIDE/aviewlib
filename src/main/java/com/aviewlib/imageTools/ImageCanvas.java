package com.aviewlib.imageTools;
import android.graphics.*;
import java.io.*;
import android.app.*;
import android.util.*;

public class ImageCanvas
{
	Bitmap DrawBitmap;
	int Bitmapx;
	int Bitmapy;

	public ImageCanvas()
	{
		this.DrawBitmap = Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888);
		this.Bitmapx = 0;
		this.Bitmapy = 0;


	}

	public ImageCanvas(Bitmap bmps)
	{
		this.DrawBitmap = bmps;
		this.Bitmapy = bmps.getHeight();
		this.Bitmapx = bmps.getWidth();


	}

	public Bitmap toBitmap()
	{

		return this.DrawBitmap;

	}
	public void SetSize(int x, int y)
	{
		if (x == 0 | y == 0)
		{
			throw new ImageOperationException("The length and width of the picture cannot be 0");




		}
		int xi=0;
		int yi=0;
		Bitmap newbitamp=Bitmap.createBitmap(x, y, this.DrawBitmap.getConfig());
		for (yi = 0;yi < y;yi++)
		{

			for (xi = 0;xi < x;xi++)
			{
				if (yi < this.DrawBitmap.getHeight() && xi < this.DrawBitmap.getWidth())
				{
					newbitamp.setPixel(xi, yi, this.DrawBitmap.getPixel(xi, yi));
				}
			}

		}
		this.DrawBitmap = newbitamp;


	}
	public void DrawClick(int x, int y, int Color)
	{
		this.DrawBitmap.setPixel(x, y, Color);

	}
	public void DrawImage(Bitmap image, int x0, int y0)
	{  
  

		if (x0 + 1 > this.Bitmapx | y0 + 1 > this.Bitmapy | y0 < 0 | x0 < 0)
		{

			throw new ImageOperationException(" The picture is drawn in the coordinate value.\n One of them may be too small or too large");



		}
		if (x0 + 1 + image.getWidth() > this.Bitmapx | y0 + 1 + image.getHeight() > this.Bitmapy)
		{
			throw new ImageOperationException("Image drawing area exceeds canvas image.");

		}
		for (int y=0;y < image.getHeight();y++)
		{
			for (int x = 0;x < image.getWidth();x++)
			{

				this.DrawBitmap.setPixel(x + x0, y + y0, image.getPixel(x, y));
			}
		}



	}
}
