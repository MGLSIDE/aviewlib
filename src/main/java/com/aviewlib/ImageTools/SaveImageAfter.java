package com.aviewlib.ImageTools;
import android.graphics.*;
import java.io.*;

public class SaveImageAfter
{
	public static void SavePngAfter(Bitmap bitmap, String path) 
	{
		File file = new File(path);
		
		if (file.exists() == false)
		{

			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{

				e.printStackTrace();
			}
		}


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

	public static void SaveJpegAfter(Bitmap bitmap, int Compress, String path)
	{
		File file = new File(path);



		if (file.exists() == false)
		{

			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{

				e.printStackTrace();
			}
		}

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
	
	
	public static void SaveWebpAfter(Bitmap bitmap, int Compress, String path)
	{
		File file = new File(path);
		if (file.exists() == false)
		{

			try
			{
				file.createNewFile();
			}
			catch (IOException e)
			{

				e.printStackTrace();
			}
		}

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
