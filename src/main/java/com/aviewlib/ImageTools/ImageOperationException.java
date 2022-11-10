package com.aviewlib.ImageTools;

public class ImageOperationException extends RuntimeException
{
	
	public String ErroImageName=null;
	public String ErroImagePath=null;
	public ImageOperationException(){
		super();
		
	}
	public ImageOperationException(String ExceptionExceptionInformation){
		
		super(ExceptionExceptionInformation);
	}
	
	public ImageOperationException(String ExceptionExceptionInformation,String ErroImage,String ErroPath){
		super(ExceptionExceptionInformation);
	    ErroImagePath=ErroPath;
		ErroImageName=ErroImage;
	}
}
