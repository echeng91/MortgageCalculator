
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateMortgage
 */
@WebServlet("/CalculateMortgage")
public class CalculateMortgage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculateMortgage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean canCalculate = true;
		
		double principal = 0;
		try {
			principal = Double.parseDouble(request.getParameter("principal"));
			request.setAttribute("calcprincipal", principal);
		} catch (NumberFormatException e) {
			canCalculate = false;
			request.setAttribute("principalerror", "Invalid input for principal");
		}
		
		double rate = 0;
		try {
			rate = Double.parseDouble(request.getParameter("rate"));
			request.setAttribute("calcrate", rate);
		} catch (NumberFormatException e) {
			canCalculate = false;
			request.setAttribute("rateerror", "Invalid input for rate");
		}
		
		int term = 0;
		try {
			term = Integer.parseInt(request.getParameter("term"));
			request.setAttribute("calcterm", term);
		} catch (NumberFormatException e) {
			canCalculate = false;
			request.setAttribute("termerror", "Invalid input for term");
		}

		if(canCalculate) {
			Mortgage mg = new Mortgage(principal, rate, term);
			request.setAttribute("payment", mg.getFormattedPayment());
		}

		request.getRequestDispatcher("MortgageCalculator.jsp").forward(request, response);
	}

}
