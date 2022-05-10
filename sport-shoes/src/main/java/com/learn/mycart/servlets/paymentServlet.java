package com.learn.mycart.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.mycart.dao.ProductDao;
import com.learn.mycart.dao.purchaseReportDao;
import com.learn.mycart.entities.Product;
import com.learn.mycart.entities.purchaseReport;
import com.learn.mycart.helper.FactoryProvider;

public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public paymentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher rd = null;
		try {
			int count = Integer.parseInt(request.getParameter("count"));
			ProductDao pd = new ProductDao(FactoryProvider.getFactory());
			purchaseReportDao prd = new purchaseReportDao(FactoryProvider.getFactory());
			for(int i = 1 ; i <= count ; i++) {
				int pid = Integer.parseInt(request.getParameter("id"+i));
				int q  = Integer.parseInt(request.getParameter("quantity"+i));
				Product p = pd.getProductById(pid);
				purchaseReport pr = new purchaseReport(p.getPid(),p.getpName(),p.getPriceAfterApplyDiscount(),q,p.getPriceAfterApplyDiscount()*q,new Date());
				int result = prd.setPurchaseReport(pr);
				System.out.println(result);
				rd = getServletContext().getRequestDispatcher("/index.jsp");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("exception", ex);
		} finally {
			rd.forward(request, response);
		}
	}

}
