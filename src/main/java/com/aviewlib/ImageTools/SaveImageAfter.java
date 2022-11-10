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

				throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());

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

			throw new ImageOperationException(e.getMessage());

		}
		catch (IOException e)
		{
			throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());


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

				throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());

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

			throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());

		}
		catch (IOException e)
		{
			throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());


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

				throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());
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

			throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());

		}
		catch (IOException e)
		{
			throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());


		}
	}

	public static void SaveAIIAfter(Bitmap bitmap, Bitmap.CompressFormat fomat, int Compress, String path)
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

				throw new ImageOperationException(e.getMessage());
			}
		}

		try
		{
			FileOutputStream out = new FileOutputStream(file);

			if (bitmap.compress(fomat, Compress, out))
			{
				out.flush();
				out.close();
			}
		}
		catch (FileNotFoundException e)
		{

			throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());

		}
		catch (IOException e)
		{
			throw new ImageOperationException(e.getMessage(), file.getName(), file.toString());


		}
	}
}
