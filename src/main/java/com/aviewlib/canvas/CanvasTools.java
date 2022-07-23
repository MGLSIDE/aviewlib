package com.aviewlib.canvas;
import android.text.*;
import android.graphics.*;
import android.*;
import android.content.*;

public class CanvasTools
{
	public static int getTextWidth(String text){
		Paint pFont = new Paint();
Rect rect = new Rect();
pFont.getTextBounds(text, 0, 1, rect);

		
		
		return rect.width();
	}
	public static int getTextHeight(String text){
		Paint pFont = new Paint();
Rect rect = new Rect();
pFont.getTextBounds(text, 0, 1, rect);

		
		
		return rect.height();
	}
	public static int px2dp(Context context,float pxValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }

    public static int dp2px(Context context,float dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
	
	
}
