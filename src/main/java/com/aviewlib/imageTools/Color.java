package com.aviewlib.imageTools;
import android.graphics.*;

public class Color
{
	private Bitmap.Config Config=null;
	private int ColorValue=0;
	public Bitmap.Config 	 getConfig(){
		return this.Config;
		
	}
	public int getColor(){
		
		return this.ColorValue;
	}
	public Color(Bitmap.Config cofs,int Value){
		this.ColorValue=Value;
		this.Config=cofs;
		
	}
	
}
