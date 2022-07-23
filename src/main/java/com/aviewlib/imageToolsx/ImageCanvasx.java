package com.aviewlib.imageToolsx;
import android.graphics.*;
import java.io.*;
import android.app.*;
import com.aviewlib.imageTools.ImageOperationException;
import android.util.*;
import com.aviewlib.imageTools.*;

public class ImageCanvasx extends ImageCanvas
{
	Bitmap DrawBitmap;
	int Bitmapx;
	int Bitmapy;

	public ImageCanvasx()
	{
		this.DrawBitmap = Bitmap.createBitmap(0, 0, Bitmap.Config.ARGB_8888);
		this.Bitmapx = 0;
		this.Bitmapy = 0;


	}
	public ImageCanvasx(String ImageName)
	{
		Bitmap bmps=BitmapFactory.decodeFile(ImageName);
		this.DrawBitmap = bmps;
		this.Bitmapy = bmps.getHeight();
		this.Bitmapx = bmps.getWidth();
	}
	public ImageCanvasx(Bitmap bmps)
	{
		this.DrawBitmap = bmps;
		this.Bitmapy = bmps.getHeight();
		this.Bitmapx = bmps.getWidth();


	}
	public void DrawImage(String imageName, int x0, int y0)
	{
		this.DrawImage(BitmapFactory.decodeFile(imageName), x0, y0);
		
	}
}
