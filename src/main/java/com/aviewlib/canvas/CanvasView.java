package com.aviewlib.canvas;

import android.graphics.*;
import android.content.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import java.util.regex.*;
import android.widget.AutoCompleteTextView.*;
import android.app.*;
import com.aviewlib.Annotations.*;
@AndroidUsetDefView(
Author="MGLSIDE",
DefDraw=true,
isViewGuroup=false
)
public class CanvasView extends View{
private int ViewHeight=0;
private int ViewWidth=0;
private int ViewOIDW=0;
private int ViewOIDH=0;


private Paint mpaints;
public DrawClickListener ViewOnClickListener=new DrawClickListener(){
public void Draw(Context ctx,CanvasView vthis,Canvas cas){
	
	
}
	
};
public Object Canvasbackground=0;
public Bitmap BackgroundBitmp=null;
public CanvasView(Context context,AttributeSet attrs){
  //Attribute属性，布局文件里设置的自定义属性
  //attrs必须传给父类，好让父类知道具体要绘制的参数
  
  super(context,attrs);

	
	
}
      
public int getViewHeight()
{
return ViewHeight;
}
public int getViewWidth()
{
return ViewWidth;
}
public int getViewOldWidth(){
return ViewOIDW;
}
public int getViewOldHeight(){
return ViewOIDH;
}
public CanvasView(Context context)
{
	
	super(context);
	
	
}

public void setbackground(int Canvasbackgrounds)
{
	
	this.Canvasbackground=Canvasbackgrounds;
	
}
public void onDraw(Canvas canvas){
  if (Canvasbackground==0){
	  
	  canvas.drawColor(0xFFFFFFFF);
  }
  else{
	
	  canvas.drawColor(Canvasbackground);
	  
	}
	if(BackgroundBitmp==null)
	{}
		else
	{
		
		
		Rect src = new Rect(0, 0, this.ViewWidth,this.ViewHeight);
        // 指定图片在屏幕上显示的区域
        Rect dst = new Rect(0, 0, this.ViewWidth,this.ViewHeight);
        // 绘制图片
        canvas.drawBitmap(this.BackgroundBitmp, src, dst, null);

	}

	
	this.ViewOnClickListener.Draw(getContext(),this,canvas);


	
}


public void setbackground(DrawClickListener drawc)
{
	this.ViewOnClickListener=drawc;
}
public void setbackground(Bitmap Canvasbackgrounds)
{
	
	
	this.BackgroundBitmp=Canvasbackgrounds;
	
	
}

@Override
protected void onSizeChanged(int w,int h,int oldw,int oldh){
  //当界面改变时，即切屏时当前的宽度与高度
 ViewHeight=h;
 ViewWidth=w;
 //宽高改变之前的宽高宽高改变之前的宽高
 ViewOIDW=oldw;
 ViewOIDH=oldh;
 
}
public void setDrawClickListener(DrawClickListener drawc)
{
	
	this.ViewOnClickListener=drawc;
}
public int getCanvasHeight()
{
	
	return ViewHeight;
}
public int getCanvasWidth(){
	

	return ViewWidth;
}
}
