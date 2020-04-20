package com.ims.c01basic;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class C04SessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		// TODO Auto-generated method stub
		System.out.println("????????????"+httpSessionBindingEvent.getName()+",???????"+httpSessionBindingEvent.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		// TODO Auto-generated method stub
		System.out.println("?????????????"+httpSessionBindingEvent.getName()+",???????"+httpSessionBindingEvent.getValue());
	}

	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		// TODO Auto-generated method stub
		
	}

}
