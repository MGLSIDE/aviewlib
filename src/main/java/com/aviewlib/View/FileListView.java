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

public class FileListView extends ListView
{

	private String CurrentDir;
	private File CurrentDirFile;
	public  FileListAdapter fileAdapter;
	public  String[] FileNameList;
	public  String[] FilePathList;

    private onFileItemClick monFileItemClick=null;
	public FileListView(Context contxt)
	{
		super(contxt);
		inits();
	}
	public void setOnFileItemClick(onFileItemClick click){
		monFileItemClick=click;
	}
	
	
	
	public FileListView(Context contxt, AttributeSet attr)
	{

		super(contxt, attr);
		inits();
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
		String[] ret=new String[sarr.length+1];
		ret[0] = "...";
		for (int i=1;i < sarr.length + 1;i++)
		{
			ret[i] = sarr[i - 1];
		}
		return ret;
	}




	public FileListView(Context contxt, AttributeSet attr, int defStyleAttr)
	{

		super(contxt, attr, defStyleAttr);
		inits();
	}
	public void inits()
	{
		CurrentDir = "/sdcard";
		CurrentDirFile = new File(CurrentDir);
		FileNameList = handleArray(CurrentDirFile.list());
		FilePathList = handleArray(getDirPath(CurrentDirFile));
		fileAdapter = new FileListAdapter(getContext(), FileNameList, FilePathList);
		setAdapter(fileAdapter);

	}

	public void Refresh()
	{

		CurrentDirFile = new File(CurrentDir);
		FilePathList = handleArray(getDirPath(CurrentDirFile));
		FileNameList = handleArray(CurrentDirFile.list());
		fileAdapter = new FileListAdapter(getContext(), FileNameList, FilePathList);
		setAdapter(fileAdapter);
		fileAdapter.notifyDataSetChanged();
	}


	public boolean performItemClick(View view, int position, long id) 
	{
		boolean result=false;
		if (position != 0)
		{
			playSoundEffect(SoundEffectConstants.CLICK);
			File FileItem=new File(FilePathList[position]);
			if (this.monFileItemClick != null)
			{
				result = monFileItemClick.onClick(view, position, id,!FileItem.isDirectory(),FileItem.toString());
			}
			if (FileItem.isDirectory())
			{
				
				CurrentDir = FileItem.toString();
				Refresh();
			}
		}



		if (position == 0 && CurrentDirFile.getParent() != null)
		{
			if (new File(CurrentDirFile.getParent()).list() != null)
			{
				playSoundEffect(SoundEffectConstants.CLICK);
				CurrentDir = CurrentDirFile.getParent();
				Refresh();
				result = true;
			}
		}
		if (view != null)
		{
			view.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
		}

		return result;
	}



	public static interface onFileItemClick
	{
		public boolean onClick(View view, int position, long id, boolean isFile,String path);

	}

}

