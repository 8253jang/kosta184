package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0503.dao.CustomerDAO;
import ex0503.dao.CustomerDAOImpl;
import ex0503.dto.CustomerDTO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//dao호출한후 그 결과 list 받아서 json으로 변환해서 전송한다.
		CustomerDAO dao =new CustomerDAOImpl();
		List<CustomerDTO> list = dao.selectAll();
		
		JSONArray arr = JSONArray.fromObject(list);//[{id:값,name:값, ...},{},{}]
		
		PrintWriter out = response.getWriter();
		out.println(arr);
	}

}







