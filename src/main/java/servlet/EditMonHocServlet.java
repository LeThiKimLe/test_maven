package servlet;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import bean.MonHoc;
import conn.DBConnection;
import utils.DBUtils;


/**
 * Servlet implementation class EditMonHocServlet
 */
@WebServlet(urlPatterns = { "/editMonHoc" })
public class EditMonHocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMonHocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
		} catch (ClassNotFoundException |  SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 
        String idStr = (String) request.getParameter("maMon");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
        }
        MonHoc mh = null;
 
        String errorString = null;
 
        try {
            mh = DBUtils.findMonHoc(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        if (errorString != null && mh == null) {
            response.sendRedirect(request.getServletPath() + "/monhocList");
            return;
        }
 	  
        request.setAttribute("errorString", errorString);
        request.setAttribute("monhoc", mh);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editMonHocView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	Connection conn = null;
		try {
			conn = DBConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
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
            sotinchi= Integer.parseInt(soTinchi);
        } catch (Exception e) {
        }
        MonHoc mh = new MonHoc(mamon, tenMon, sotinchi);
 
        String errorString = null;
 
        try {
            DBUtils.updateMonhoc(conn, mh);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("monhoc", mh);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editMonHocView.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/monhocList");
        }
	}
}
