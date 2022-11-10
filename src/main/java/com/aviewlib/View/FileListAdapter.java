package com.aviewlib.View;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.util.*;
import android.graphics.*;
import java.io.*;
//文件列表适配器
public class FileListAdapter extends BaseAdapter
{

	private Context ctxt;
	private String[] pathArray=new String[]{};
	private String[] nameArray=new String[]{};
	private FileView mFileView=null;


    public static interface FileView
	{
		public View ReturnView(Context ctxt, String path, String Name, int p1, View p2, ViewGroup p3);
	}

	public void setFileView(FileView fv)
	{
		mFileView = fv;
	}

	public FileListAdapter(Context contxt)
	{
		ctxt = contxt;
	}
	public FileListAdapter(Context contxt, String[] na, String[] pa)
	{
		pathArray = pa;
		nameArray = na;
		ctxt = contxt;
	}

	public void setData(String[] na, String[] pa)
	{
		pathArray = pa;
		nameArray = na;
	}

	

	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return pathArray.length;
	}

	@Override
	public Object getItem(int p1)
	{
		// TODO: Implement this method
		return nameArray[p1];
	}

	@Override
	public long getItemId(int p1)
	{
		// TODO: Implement this method
		return p1;
	}

	@Override
	public View getView(int p1, View p2, ViewGroup p3)
	{

		if (mFileView == null)
		{
			TextView tv=new TextView(ctxt);
			tv.setText(nameArray[p1]);
			return tv;
		}
		else
		{
			return mFileView.ReturnView(ctxt, pathArray[p1], nameArray[p1], p1, p2, p3);
		}
	}



}
