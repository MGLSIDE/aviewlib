package com.aviewlib.imageToolsx;
import android.graphics.*;
import java.io.*;
import com.aviewlib.imageTools.*;

public class SaveImageAfter
{
	
	
	
public static void SavePngAfter(Bitmap bitmap, String name)
	{
		File file = new File(name);
		try
		{
			FileOutputStream out = new FileOutputStream(file);
			
			if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, out))
			{
				out.flush();
				out.close();
			}
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static void SaveJpegAfter(Bitmap bitmap,int Compress, String name)
	{
		File file = new File(name);
		try
		{
			FileOutputStream out = new FileOutputStream(file);
			
			if (bitmap.compress(Bitmap.CompressFormat.JPEG, Compress, out))
			{
				out.flush();
				out.close();
			}
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
		}
	}
	public static void SaveWebpAfter(Bitmap bitmap,int Compress, String name)
	{
		File file = new File(name);
		try
		{
			FileOutputStream out = new FileOutputStream(file);
			
			if (bitmap.compress(Bitmap.CompressFormat.WEBP, Compress, out))
			{
				out.flush();
				out.close();
			}
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
		}
	}
}
