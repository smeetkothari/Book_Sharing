<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ page language="java" import="java.io.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Expires", "0");
response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
response.setHeader("Pragma", "public");
response.setContentType("application/pdf");

InputStream in = new FileInputStream("C:/Users/Smeet/Desktop/spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64/sts-bundle/pivotal-tc-server-developer-3.1.0.RELEASE/tomcat-8.0.20.B.RELEASE/tmpFiles/"+request.getAttribute("path"));
request.getAttribute("path");
OutputStream out1 = response.getOutputStream();

// Copy the bits from instream to outstream
byte[] buf = new byte[1024];
int len;
while ((len = in.read(buf)) > 0) {
   out1.write(buf, 0, len);
}
in.close();
%>
</body>
</html>