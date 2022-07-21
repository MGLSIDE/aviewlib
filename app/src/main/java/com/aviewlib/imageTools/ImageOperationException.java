package com.aviewlib.imageTools;

public class ImageOperationException extends ArrayIndexOutOfBoundsException
{
	
	public String ErroImageName;
	public String ErroImagePath;
	public ImageOperationException(){
		super();
		
	}
	public ImageOperationException(String ExceptionExceptionInformation){
		
		super(ExceptionExceptionInformation);
	}
	
	public ImageOperationException(String ExceptionExceptionInformation,String ErroImage){
		super(ExceptionExceptionInformation);
	
	}
}
