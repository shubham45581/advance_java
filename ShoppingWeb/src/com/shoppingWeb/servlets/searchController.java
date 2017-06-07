package com.shoppingWeb.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;

import com.shoppingWeb.connectDB.ConnectDb;

/**
 * Servlet implementation class searchController
 */
@WebServlet("/searchController")
public class searchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement pstmt = null;
	String TextSearch = request.getParameter("textSearch");
	String[] words = TextSearch.split(" ");
	for(String s : words){
		System.out.println(s);
	}
	int i = 1;
	try {
		Connection con = ConnectDb.getconnection();
		pstmt = con.prepareStatement("select * from product,seller,category where seller.seller_id = product.seller_id and category.category_id = product.category_id");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(i));
		}
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
	}

	

}
