package com.aviewlib.View;
import android.view.*;
import android.graphics.*;
import android.content.*;
import android.util.*;
import android.widget.*;
//手动绘图效果实现控件
public  class HandPaintedView extends View
{
	private int mov_x;//声明起点坐标
	private int mov_y;
	private int Max_X;
	private int Max_Y;
	private Canvas cas;
	private Canvas cas2;
	private Paint paint;//声明画笔
	private Bitmap bmp;
	private boolean isBezierCurve;


	public HandPaintedView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initView();
	}

	public HandPaintedView(Context context, AttributeSet attrs, int style)
	{
		super(context, attrs, style);
		initView();
	}

	public HandPaintedView(Context context)
	{
		super(context);
		initView();

	}

	private void initView()
	{
		Max_X = 1;
		Max_Y = 1;
		isBezierCurve = false;
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);//创建一个画笔
		bmp = Bitmap.createBitmap(Max_X, Max_Y, Bitmap.Config.ARGB_8888);
		cas = new Canvas();
		cas2 = new Canvas();

        cas.setBitmap(bmp);

		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(10);
		paint.setDither(true);
		paint.setAntiAlias(true);
		paint.setStrokeJoin(Paint.Join.ROUND);
		paint.setStrokeCap(Paint.Cap.ROUND);
	}


	//画图
	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawBitmap(bmp, 0, 0, null);

		super.onDraw(canvas);
	}
	//触摸事件
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		int Action=event.getAction();
		float event_X=event.getX();
		float event_Y=event.getY();

		if (event_X > Max_X)
		{
			Max_X = (int)Math.ceil(event_X) + 1;
			bmp = CoverBitmap(bmp);
			cas.setBitmap(bmp);
		}
		if (event_Y > Max_Y)
		{
			Max_Y = (int)Math.ceil(event_Y) + 1;
			bmp = CoverBitmap(bmp);
			cas.setBitmap(bmp);
		}


		if (Action == MotionEvent.ACTION_MOVE)
		{//如果拖动

			cas.drawLine(mov_x, mov_y, event_X, event_Y, paint);//画线
			invalidate();
		}
		if (Action == MotionEvent.ACTION_DOWN)
		{//如果点击
			mov_x = (int) event_X;
			mov_y = (int) event_Y;
			// canvas.drawPoint(mov_x, mov_y, paint);//画点
			invalidate();
		}
		if (Action == MotionEvent.ACTION_UP)
		{

		}
		mov_x = (int) event_X;
		mov_y = (int) event_Y;

		return true;
	}

	public void setPaint(Paint pa)
	{
		paint = pa;
	}

	public void setPaintClor(int color)
	{
		paint.setColor(color);
	}

	public void setPaintStrokeWidth(float size)
	{
		paint.setStrokeWidth(size);
	}


	public Bitmap ImportBitmap()
	{
		return bmp.copy(Bitmap.Config.ARGB_8888, true) ;
	}

	public void clear()
	{
		Max_X = 1;
		Max_Y = 1;
		bmp = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
		cas.setBitmap(bmp);
        invalidate();

	}

	private Bitmap CoverBitmap(Bitmap foreground)
	{
		Bitmap bmps=Bitmap.createBitmap(Max_X, Max_Y, Bitmap.Config.ARGB_8888);


		cas2.setBitmap(bmps);
		cas2.drawBitmap(foreground, 0, 0, null);//在 0，0坐标开始画入fg ，可以从任意位置画入
		cas2.save(Canvas.ALL_SAVE_FLAG);//保存   
		cas2.restore();//存储   
		return bmps;   
	}



}
