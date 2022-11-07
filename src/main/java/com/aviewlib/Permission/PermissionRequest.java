package com.aviewlib.Permission;
import android.app.*;
import android.*;
import android.content.pm.*;

public class PermissionRequest
{
    private final static int REQUEST_CODE_ASK_PERMISSIONS = 123;
	
	public static void RequestPermission(Activity activity, String[] perm, int reqCode)
	{
		int hasWriteContactsPermisson;
		for (String permName:perm)
		{
			hasWriteContactsPermisson = activity.checkSelfPermission(permName);
			if (hasWriteContactsPermisson != PackageManager.PERMISSION_GRANTED)
			{
				activity.requestPermissions(new String[]{permName}, reqCode);
			}
		}
	}
	
	
	public static void RequestPermission(Activity activity, String[] perm)
	{
		RequestPermission(activity, perm, REQUEST_CODE_ASK_PERMISSIONS);
	}

	
	
	
}
