package com.aviewlib.ActivityTools;
import android.app.*;
import org.apache.http.client.utils.*;
import java.lang.annotation.*;
import android.graphics.*;

public class ActivityTool 
{
	
	
	static private String  AtpresCurreActivityName="";
	public static void setAtpresCurreActivityName(String ActivityName ){
		
		AtpresCurreActivityName=ActivityName;
	}
	
	
    public static  String getAtpresCurreActivityName(){
		
		return AtpresCurreActivityName;
	}
	
	public static String getAppAPK(){
	
		return new Application().getApplicationInfo().publicSourceDir;
	}
	
	public static String getActivityName(Class<? extends Activity>  actw ){
		
		return actw.getName();
	}
	

	public static String getActivityName(Activity  actwobj){
		
		return actwobj.getClass().getName();
		
	}
	
	
	
 
	
}
