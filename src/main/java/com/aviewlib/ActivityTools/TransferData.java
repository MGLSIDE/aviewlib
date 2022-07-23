package com.aviewlib.ActivityTools;
import android.graphics.*;
import android.widget.*;
import java.util.*;
import org.apache.commons.codec.language.bm.*;
import java.lang.ref.*;
import java.security.*;
import android.media.*;
public class TransferData
{

    
    private static Map dataList = new HashMap<>();
	
    public static void setData(String key, Object o)
	{

        WeakReference value =new WeakReference<>(o);
		
    
   
        dataList.put(key, value);

    }

	public static void setData(int key, Object o)
	{
		WeakReference value =new WeakReference<>(o);
      
		 
		 
		dataList.put(key,value);
    

	}
	
     public static void Rmove(String Key)
	 {
		 dataList.remove(Key);
	
		
	 }
	 public static void Rmove(int Key)
	 {
		 dataList.remove(Key);
		 
	 }
    public static Object getData(String key)
	{

		WeakReference reference =(WeakReference) dataList.get(key);

		if (reference != null)
		{

			Object o = reference.get();

			return o;

		}

		return null;

	}
	public static Object getData(int key)
	{

		WeakReference reference =(WeakReference) dataList.get(key);

		if (reference != null)
		{

			Object o = reference.get();

			return o;

		}

		return null;

	}

}
