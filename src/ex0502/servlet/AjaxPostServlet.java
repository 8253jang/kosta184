package ex0502.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxPostServlet
 */
@WebServlet("/postServlet")
public class AjaxPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//book번호에 해당하는 img를 준비한다.
		String imageNames [] = {"spring.jpg" , "android.jpg","jquery.jpg","jsmasterbook.jpg"};
		
		//전송된 book정보에 따른 이미지를 찾아서 응답해준다.
		
		String book = request.getParameter("book"); // 0 1 2 3 4 
				
	    PrintWriter out = response.getWriter();
		out.println(imageNames[Integer.parseInt(book)]);//front쪽으로 전달될 데이터 <body>영역에 출력
	}

}















