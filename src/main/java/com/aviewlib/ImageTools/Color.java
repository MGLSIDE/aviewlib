package com.aviewlib.ImageTools;
import android.graphics.*;

public class Color
{
	private Bitmap.Config confg;
	private int ClorValue;

	public  Color(Bitmap.Config cfs, int colorValue)
	{
		confg = cfs;
		ClorValue=colorValue;
	}

	public Bitmap.Config getConfig()
	{
		return confg;
	}


	public int getColor()
	{
		return ClorValue;
	}


	public int getAlaph()
	{
		return ColorTools.getAlaph(ClorValue, confg);
	}

	
	public int[] DecomposeColor(){
		return ColorTools.DecomposeColor(ClorValue,confg);
	}

	public void setAlaph(int Alaph)
	{
		ClorValue = ColorTools.setAlaph(ClorValue, Alaph, confg);
	}
}
