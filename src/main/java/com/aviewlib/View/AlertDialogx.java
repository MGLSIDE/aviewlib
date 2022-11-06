package com.aviewlib.View;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.app.AlertDialog.*;
import android.content.DialogInterface.*;
//扩展AlertDialog
public class AlertDialogx extends AlertDialog
{
	private Context ViewContext=null;


	public AlertDialogx(Context context)
	{
        super(context);
		ViewContext = context;
	}


    public AlertDialogx(Context context, int theme)
	{
        super(context, theme);
		ViewContext = context;
	}


	public static class Builderx extends Builder
	{
		public Builderx(Context ctxt)
		{

			super(ctxt);
		}


		public AlertDialogx.Builderx setItems(String [] data, AdapterView.OnItemClickListener click)
		{
			ArrayAdapter adp=new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data);
			ListView  vlist=new ListView(getContext());

			vlist.setAdapter(adp);
			vlist.setOnItemClickListener(click);
			setView(vlist);
            return this;
		}

		public AlertDialogx.Builderx setItems(String [] data, AdapterView.OnItemClickListener click, int style)
		{


			ArrayAdapter adp=new ArrayAdapter(getContext(), style);
			ListView  vlist=new ListView(getContext());

			vlist.setAdapter(adp);
			vlist.setOnItemClickListener(click);
			setView(vlist);
            return this;
		}

		public AlertDialogx.Builderx setItems(String [] data, AdapterView.OnItemClickListener click, AdapterView.OnItemLongClickListener LongClick)
		{
			ArrayAdapter adp=new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, data);
			ListView  vlist=new ListView(getContext());

			vlist.setAdapter(adp);
			vlist.setOnItemClickListener(click);
			vlist.setOnItemLongClickListener(LongClick);
			setView(vlist);

			return this;
		}

		public AlertDialogx.Builderx setItems(String [] data, AdapterView.OnItemClickListener click, AdapterView.OnItemLongClickListener LongClick, int style)
		{
			ArrayAdapter adp=new ArrayAdapter(getContext(), style, data);
			ListView  vlist=new ListView(getContext());

			vlist.setAdapter(adp);
			vlist.setOnItemClickListener(click);
			vlist.setOnItemLongClickListener(LongClick);
			setView(vlist);

			return this;
		}

		@Override
		public AlertDialogx.Builderx setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener)
		{
			if (listener == null)
			{
				super.setNeutralButton(text, new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
						}
					});
				return this;
			}
		    else
			{
				super.setNeutralButton(text, listener);
				return this;
			}
		}

		@Override
		public AlertDialogx.Builderx setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener)
		{
			if (listener == null)
			{
				super.setPositiveButton(text, new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							// TODO: Implement this method
						}
					});
				return this;
			}
		    else
			{
				// TODO: Implement this method
				super.setPositiveButton(text, listener);
				return this;
			}
		}


		public AlertDialogx.Builderx setCanvasView(CanvasView.DrawClick draw)
		{
			setView(new CanvasView(getContext(), draw));
			return this;
		}

		public AlertDialogx.Builderx setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener)
		{
			if (listener == null)
			{
				super.setNegativeButton(text, new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							// TODO: Implement this method
						}
					});
				return this;
			}
		    else
			{
				// TODO: Implement this method
				super.setNegativeButton(text, listener);
				return this;
			}
		}





		@Override
		public AlertDialogx.Builderx setItems(CharSequence[] items, DialogInterface.OnClickListener listener)
		{
			// TODO: Implement this method
			super.setItems(items, listener);
			return this;
		}

		@Override
		public AlertDialogx.Builderx setItems(int itemsId, DialogInterface.OnClickListener listener)
		{
			// TODO: Implement this method
			super.setItems(itemsId, listener);
			return this;
		}

		@Override
		public AlertDialogx.Builderx setIconAttribute(int attrId)
		{
			// TODO: Implement this method
			super.setIconAttribute(attrId);
			return this;
		}

		@Override
		public AlertDialogx.Builderx setPositiveButton(int textId, DialogInterface.OnClickListener listener)
		{
			// TODO: Implement this method
			super.setPositiveButton(textId, listener);
			return this;
		}

		@Override
		public AlertDialogx.Builderx setView(int layoutResId)
		{
			// TODO: Implement this method
			super.setView(layoutResId);
			return this;
		}

	}

	enum AlertDialogxButton
	{
		POSITIVE,
		NEUTRAL,
		NEGATIVE
		}




}
