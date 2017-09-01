package com.ocad.tags;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LinkProvider extends SimpleTagSupport{
	
	private String url;
	private String value;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String key) {
		this.value = value;
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
		ResourceBundle bundle = ResourceBundle.getBundle("parameters");
		String domain = bundle.getString("domain");
		try {
            
            getJspContext().getOut().write(domain+""+url+"?"+"id="+value);
        } catch (Exception e) {
            e.printStackTrace();
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Exception in linking ");
        }
	}

}
