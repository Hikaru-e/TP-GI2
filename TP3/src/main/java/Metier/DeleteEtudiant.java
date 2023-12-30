package Metier;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class DeleteEtudiant
 */
@WebServlet("/delete_etudiant")
public class DeleteEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;
	private SaveEtudiant saveEtudiant = new SaveEtudiant();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bdetudiants";
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new ServletException("Database connection error: " + e.getMessage());
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String delSQL = "DELETE FROM tetudiant WHERE code = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(delSQL);
			ps.setString(1, code);

	        int rowsDeleted = ps.executeUpdate();
	        request.setAttribute("listEtd", saveEtudiant.getAllEtudiants());
	        if (rowsDeleted > 0) {
	            System.out.println("Student with Code " + code + " has been deleted.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
	        } else {
	            System.out.println("No students were deleted.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			String targetURL = request.getContextPath() + "/save_etudiant";
//			response.sendRedirect(targetURL);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
