package com.ims.c01basic;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class C05SessionAttributeListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        // TODO Auto-generated method stub
        System.out.println("添加属性：" + httpSessionBindingEvent.getName() + "，添加属性值：" + httpSessionBindingEvent.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        // TODO Auto-generated method stub
        System.out.println("移除属性：" + httpSessionBindingEvent.getName() + "，移除属性：" + httpSessionBindingEvent.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        // TODO Auto-generated method stub

    }

}
