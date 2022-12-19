package com.aviewlib.View;

import android.graphics.*;
import android.content.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import java.util.regex.*;
import android.app.*;
import java.lang.annotation.*;

//画布控件
public class CanvasView extends View
{

	@Documented
	private DrawClick mDrawClick=null;

	@Override

	public CanvasView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public CanvasView(Context context, DrawClick drawclick)
	{
		super(context);
		mDrawClick = drawclick;
	}

	@Override
	public CanvasView(Context context)
	{
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		mDrawClick.onDraw(this, canvas, getContext());


	}


	public void setDrawClick(DrawClick draw)
	{
		mDrawClick = draw;

	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		// TODO: Implement this method
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	    mDrawClick.onViewMeasure(this, widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom)
	{
		// TODO: Implement this method
		super.onLayout(changed, left, top, right, bottom);
		mDrawClick.onLayout(this, changed, left, top, right, bottom);
	}




	public static interface DrawClick
	{
		public void onDraw(CanvasView thisview, Canvas cas, Context ctx)
		public  void onLayout(CanvasView thisview, boolean changed, int left, int top, int right, int bottom)
		public void onViewMeasure(CanvasView thisview, int widthMeasureSpec, int heightMeasureSpec)
	}

	public static class GraphicObject extends Canvas
	{
		private Canvas adhecas;

		public  GraphicObject(Canvas AdhesionCanvas)
		{
			adhecas = AdhesionCanvas;
		}

	}


	public static class Tools
	{
		public static int getTextWidth(String text)
		{
			Paint pFont = new Paint();
			Rect rect = new Rect();
			pFont.getTextBounds(text, 0, 1, rect);
			return rect.width();
		}



		public static int getTextHeight(String text)
		{
			Paint pFont = new Paint();
			Rect rect = new Rect();
			pFont.getTextBounds(text, 0, 1, rect);
			return rect.height();
		}
		public static int px2dp(Context context, float pxValue)
		{
			final float scale=context.getResources().getDisplayMetrics().density;
			return (int)(pxValue / scale + 0.5f);
		}

		public static int dp2px(Context context, float dpValue)
		{
			final float scale=context.getResources().getDisplayMetrics().density;
			return (int)(dpValue * scale + 0.5f);
		}


	}


}
