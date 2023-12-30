package Metier;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Etudiant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveEtudiant
 */
@WebServlet("/save_etudiant")
public class SaveEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEtudiant() {
		super();
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	ArrayList<Etudiant> getAllEtudiants() {
		ArrayList<Etudiant> listEtd = new ArrayList<>();
		String getAll = "select * from tetudiant";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(getAll);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String code = resultSet.getNString("code");
				String nom = resultSet.getNString("nom");
				String prenom = resultSet.getNString("prenom");
				int age = resultSet.getInt("age");
				String ville = resultSet.getNString("ville");

				Etudiant etd = new Etudiant(code, nom, prenom, age, ville);
				listEtd.add(etd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEtd;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("nom") != null) {
			String code = request.getParameter("code");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			String ville = request.getParameter("ville");
			try {
				String insertSQL = "INSERT INTO tetudiant VALUES (?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, code);
				preparedStatement.setString(2, nom);
				preparedStatement.setString(3, prenom);
				preparedStatement.setInt(4, age);
				preparedStatement.setString(5, ville);
				int rowsInserted = preparedStatement.executeUpdate();

				if (rowsInserted > 0) {
					request.setAttribute("result", true);
					request.setAttribute("listEtd", getAllEtudiants());
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("result", false);
					request.setAttribute("listEtd", getAllEtudiants());
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("result", false);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		}
		request.setAttribute("listEtd", getAllEtudiants());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
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
