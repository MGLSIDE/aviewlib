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
	private Paint paint;//声明画笔
	private Bitmap bmp;

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
		Max_X = 0;
		Max_Y = 0;
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);//创建一个画笔
		cas = new Canvas();
		bmp = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);

        cas.setBitmap(bmp);
		paint.setStyle(Paint.Style.STROKE);//设置非填充
		paint.setStrokeWidth(10);//笔宽5像素
		paint.setColor(Color.BLACK);//设置为红笔
		paint.setAntiAlias(true);//锯齿不显示
		paint.setDither(true);
		paint.setStrokeJoin(Paint.Join.ROUND);//设置图像的结合方式
		paint.setStrokeCap(Paint.Cap.ROUND);//设置画笔为圆形样式
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
		return bmp;
	}

	private Bitmap CopyPixel(Bitmap src, Bitmap aim)
	{
		for (int i=0;i < src.getHeight();i++)
		{
			for (int i2=0;i < src.getWidth();i++)
			{

				aim.setPixel(i2, i, src.getPixel(i2, i));

			}
		}
		return aim;
	}

}
