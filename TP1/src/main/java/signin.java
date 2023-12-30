
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signin
 */
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public signin() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String civilite = request.getParameter("civilite");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String naissance = request.getParameter("naissance");
		String mail = request.getParameter("mail");
		String tele = request.getParameter("telephone");

		try {
			String insertSQL = "INSERT INTO Etudiant values(null,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, civilite);
			preparedStatement.setString(2, cp);
			preparedStatement.setString(3, ville);
			preparedStatement.setString(4, nom);
			preparedStatement.setString(5, prenom);
			preparedStatement.setString(6, adresse);
			preparedStatement.setString(7, naissance);
			preparedStatement.setString(8, mail);
			preparedStatement.setString(9, tele);

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				response.setContentType("text/html");
				response.getWriter().println("Data has been successfully added to the database.");
				response.getWriter().println("</br></br>civilite : " + civilite);
				response.getWriter().println("</br>cp : " + cp);
				response.getWriter().println("</br>ville : " + ville);
				response.getWriter().println("</br>nom : " + nom);
				response.getWriter().println("</br>prenom : " + prenom);
				response.getWriter().println("</br>adresse : " + adresse);
				response.getWriter().println("</br>naissance : " + naissance);
				response.getWriter().println("</br>mail : " + mail);
				response.getWriter().println("</br>tele : " + tele);
				
//				request.setAttribute("civilite", civilite);
//				
//		        RequestDispatcher dispatcher = request.getRequestDispatcher("final.jsp");
//		        dispatcher.forward(request, response);
			} else {
				response.setContentType("text/html");
				response.getWriter().println("Failed to insert data into the database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			response.getWriter().println("Database error: " + e.getMessage());
		}

		response.setContentType("text/html");

	}

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
