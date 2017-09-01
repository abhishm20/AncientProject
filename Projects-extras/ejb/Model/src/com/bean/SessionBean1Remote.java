package com.bean;

import javax.ejb.Remote;

@Remote
public interface SessionBean1Remote {

	int add(int a , int b);
}
