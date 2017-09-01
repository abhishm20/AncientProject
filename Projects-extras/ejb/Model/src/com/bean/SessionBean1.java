package com.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SessionBean1
 */
@Stateless(mappedName = "bean1")
@LocalBean
public class SessionBean1 implements SessionBean1Remote, SessionBean1Local {

    /**
     * Default constructor. 
     */
    public SessionBean1() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int add(int a, int b) {
		return a+b;
	}

}
