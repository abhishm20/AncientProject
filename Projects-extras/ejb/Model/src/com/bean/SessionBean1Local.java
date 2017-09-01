package com.bean;

import javax.ejb.Local;

@Local
public interface SessionBean1Local {

	int sub(int a, int b);
}
