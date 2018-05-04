package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0503.dao.CustomerDAO;
import ex0503.dao.CustomerDAOImpl;
import ex0503.dto.CustomerDTO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");// post방식 한글처리
		
    	String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		CustomerDTO customerDTO = new CustomerDTO(id, name, Integer.parseInt(age) , tel, addr);
		
		CustomerDAO dao =new CustomerDAOImpl();
		int result = dao.insert(customerDTO);
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
