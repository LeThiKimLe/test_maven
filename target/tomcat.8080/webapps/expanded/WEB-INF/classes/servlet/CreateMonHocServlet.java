package servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bean.MonHoc;
import conn.DBConnection;
import utils.DBUtils;

/**
 * Servlet implementation class CreateMonHocServlet
 */
@WebServlet(urlPatterns = { "/createMonHoc" })
public class CreateMonHocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMonHocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/createMonHocView.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        String maMon= (String)request.getParameter("maso_monhoc");
        String tenMon = new String(request.getParameter("ten_monhoc").getBytes("ISO-8859-1"), "UTF-8");
        String soTinchi = new String(request.getParameter("sotinchi").getBytes("ISO-8859-1"), "UTF-8");
        
        int mamon = 0;
        int sotinchi=0;
        
        try {
            mamon = Integer.parseInt(maMon);
            sotinchi=Integer.parseInt(soTinchi);
        } catch (Exception e) {
        }
        MonHoc mh = new MonHoc(mamon, tenMon, sotinchi);
 
        String errorString = null;
 
        try {
            DBUtils.insertMonHoc(conn, mh);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        request.setAttribute("errorString", errorString);
       
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createMonHocView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/monhocList");
        }
	}

}
