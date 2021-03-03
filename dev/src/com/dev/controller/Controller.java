// 모든 Controller 객체에서 컨트롤러 기능을 구현하는 메소드를 통일하기 위해 만든 객체

package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public interface Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws 
				ServletException, IOException;

}
