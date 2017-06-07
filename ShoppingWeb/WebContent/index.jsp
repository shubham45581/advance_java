<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="searchController" method="get">
		<input type="text" name="textSearch">
		<input type="submit" value="search">
	</form>
	<a href="addproduct.jsp">Add Products</a>
	<a href="addcategory.jsp">Add Category</a>
	<a href="AddSeller.jsp">Add Seller</a>
<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "shopping";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT product_id,product_name,product_price,product_weight,product_dimensions,product_desc,product_quantity,seller_id ,category_id ,img1 FROM product";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<%=resultSet.getString("product_id") %>
<%=resultSet.getString("product_name") %>
<%=resultSet.getString("product_price") %>
<%=resultSet.getString("product_weight") %>
<%=resultSet.getString("product_dimensions") %>
<%=resultSet.getString("product_desc") %>
<%=resultSet.getString("product_quantity") %>
<%=resultSet.getString("seller_id") %>
<%=resultSet.getString("category_id") %>
<img src="images/<%=resultSet.getString("img1")%>"/>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>


</body>
</html>