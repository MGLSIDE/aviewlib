package com.aviewlib.ActivityTools;
import android.app.*;
public class ActivityTool 
{

	public static String getAppAPK()
	{

		return new Application().getApplicationInfo().publicSourceDir;
	}

	public static String getActivityName(Class<? extends Activity>  actw)
	{

		return actw.getName();
	}
	

	public static String getActivityName(Activity  actwobj)
	{

		return actwobj.getClass().getName();

	}





}
