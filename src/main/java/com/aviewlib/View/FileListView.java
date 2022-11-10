package com.aviewlib.View;
import android.widget.*;
import android.content.*;
import java.util.jar.*;
import android.util.*;
import android.view.*;
import android.widget.AdapterView.*;
import java.io.*;
import java.util.*;
import android.view.accessibility.*;
import android.os.*;
import android.graphics.*;
//文件列表控件
public class FileListView extends ListView
{
	private  final static String PreviouslevelfolderName="...";
	public   static String  SuperDirText=PreviouslevelfolderName;
	private  onFileItemClick monFileItemClick;
	private  FileListAdapter fileAdapter;
	private  String[] FileNameList;
	private  String[] FilePathList;
    private  File CurrentDirFile;
	private  String CurrentDir;


	public FileListView(Context contxt)
	{
		super(contxt);
		inits();
	}

	public FileListView(Context contxt, AttributeSet attr)
	{
		super(contxt, attr);
		inits();
	}


	public FileListView(Context contxt, AttributeSet attr, int defStyleAttr)
	{
		super(contxt, attr, defStyleAttr);
		inits();
	}

	public void inits()
	{
		CurrentDir = "/sdcard";
		fileAdapter = new FileListAdapter(getContext());
		setAdapter(fileAdapter);
		Refresh();
	}

	public void setDir(String str)
	{
		CurrentDir = str;
		Refresh();
	}


	public void setFileView(FileListAdapter.FileView fileViews)
	{
		fileAdapter.setFileView(fileViews);
	}

	public void setOnFileItemClick(onFileItemClick click)
	{
		monFileItemClick = click;
	}


	private String[] getDirPath(File f)
	{
		String[] flist=new String[f.list().length];
		if (!f.isDirectory())
		{
			throw new NullPointerException("No file list data.Not a folder.");
		}
		int cont=0;
		for (String name:f.list())
		{
			flist[cont] = f.toString() + "/" + name;
			cont++;
		}
		return flist;
	}

	private String[]  handleArray(String[] sarr)
	{
		String[] ret=new String[sarr.length + 1];
		ret[0] = PreviouslevelfolderName;
		for (int i=1;i < sarr.length + 1;i++)
		{
			ret[i] = sarr[i - 1];
		}
		return ret;
	}

	private void Refresh()
	{
		CurrentDirFile = new File(CurrentDir);
		FilePathList = handleArray(getDirPath(CurrentDirFile));
		FileNameList = handleArray(CurrentDirFile.list());
		fileAdapter.setData(FileNameList, FilePathList);
		fileAdapter.notifyDataSetChanged();
	}



	public boolean performItemClick(View view, int position, long id) 
	{
		boolean result=false;

		if (monFileItemClick != null)
		{

			if (position == 0)
			{
				result = monFileItemClick.onSuperDirClick(this, view, CurrentDirFile.getParent());
				if (result)
				{
					CurrentDir = CurrentDirFile.getParent();
					CurrentDirFile = new File(CurrentDir);
					Refresh();
				}
				return result;
			}

			File posFile=new File(FilePathList[position]);

			if (posFile.isFile())
			{
				monFileItemClick.onFileClick(this, view, position, FilePathList[position]);
				result = true;
				return result;
			}
			else
			{
				result = monFileItemClick.onDirClick(this, view, position, FilePathList[position]);

				if (result)	
				{
					CurrentDir = FilePathList[position];
					Refresh();
				}
				return result;
			}


		}

		return result;
	}



	@Override
	public Parcelable onSaveInstanceState()
	{
		FileListSavedState bss=new FileListSavedState(super.onSaveInstanceState());
		bss.path = CurrentDir;
		return bss;
	}

	@Override
	public void onRestoreInstanceState(Parcelable state)
	{
		FileListSavedState bss=(FileListSavedState)state;
		super.onRestoreInstanceState(bss.getSuperState());
		CurrentDir = bss.path;
		Refresh();
	}

	static class FileListSavedState extends BaseSavedState
	{
		public String path;
		

		public FileListSavedState(Parcel source)
		{
			super(source);
			path = source.readString();
		}

		public FileListSavedState(Parcelable superState)
		{
			super(superState);
		}

		@Override
		public void writeToParcel(Parcel out, int flags)
		{
			super.writeToParcel(out, flags);
			out.writeString(path);	
		}

	}

	public String getAtPresentDir()
	{
		return CurrentDir;
	}
	
	public static interface onFileItemClick
	{
		public void onFileClick(FileListView filst, View view, int position, String path);
		public boolean onDirClick(FileListView filst, View view, int position, String path);
		public boolean onSuperDirClick(FileListView filst, View view, String path);
	}

}

