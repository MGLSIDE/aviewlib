package com.aviewlib.imageToolsx;
import android.graphics.*;
import com.aviewlib.imageTools.*;

public class Picturesplicingx extends Picturesplicing
{
	public static Bitmap TransverseSplice(String[] bmparra, Bitmap.Config cofs){
		
		
		Bitmap[] bmparr=new Bitmap[bmparra.length];
		for (int i=0;i<bmparr.length;i++)
		{
			bmparr[i]=BitmapFactory.decodeFile(bmparra[i]);
		}
		return TransverseSplice(bmparr,cofs);
	}
	
	
public static Bitmap LongitudinalSplice(String[] bmparra, Bitmap.Config cofs)
	{
		Bitmap[] bmparr=new Bitmap[bmparra.length];
		for (int i=0;i<bmparr.length;i++)
		{
			bmparr[i]=BitmapFactory.decodeFile(bmparra[i]);
		}
	
		
		return LongitudinalSplice(bmparr,cofs);

	}
}
