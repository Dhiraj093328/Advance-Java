package test;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class MyDate extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter jw = getJspContext().getOut();

        Date date = new Date();   // current date & time
        jw.println(date);
    }
}
