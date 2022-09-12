package com.aviewlib.Annotations;
import java.lang.annotation.*;
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface AndroidUsetDefView
{
	boolean isViewGuroup();; 
	boolean DefDraw() ;
	String Author() ;
	
	
}
