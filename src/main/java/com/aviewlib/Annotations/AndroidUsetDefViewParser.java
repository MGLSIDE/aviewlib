package com.aviewlib.Annotations;

public class AndroidUsetDefViewParser
{
	public static void AnnotationCall(Class<?> cls){
		AndroidUsetDefView anno=cls.getAnnotation(AndroidUsetDefView.class);
		if(anno.isViewGuroup()==true){
			if(android.view.View.class.isAssignableFrom(cls)==false){
				
	
				
				throw new IllegalArgumentException("no extends "+cls.getSuperclass().getName());
			}
			
		}
		else{
			if(android.view.ViewGroup.class.isAssignableFrom(cls)==false){
				throw new IllegalArgumentException("no extends "+cls.getSuperclass().getName());
			
				
			}
		}
	}
	
}
