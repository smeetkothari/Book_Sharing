<%@ page session="true" %>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style type="text/css">
	#tfheader{
		background-color:#F25950;
	}
	#tfnewsearch{
		float:left;
		padding:20px;
	}
	.tftextinput{
		margin: 0;
		padding: 5px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		border:1px solid #0076a3; border-right:0px;
		border-top-left-radius: 5px 5px;
		border-bottom-left-radius: 5px 5px;
	}
	.tfbutton {
		margin: 0px;
		margin-right: 50px;
		padding: 5px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		outline: none;
		cursor: pointer;
		text-align: center;
		text-decoration: none;
		color: #ffffff;
		border: solid 1px #0076a3; border-right:0px;
		background: #0095cd;
		background: -webkit-gradient(linear, left top, left bottom, from(#1A1918), to(#383736));
		background: -moz-linear-gradient(top,  #00adee,  #0078a5);
		border-top-right-radius: 5px 5px;
		border-bottom-right-radius: 5px 5px;
	}
	.tfbutton:hover {
		text-decoration: none;
		background: #007ead;
		background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
		background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	}
	/* Fixes submit button height problem in Firefox */
	.tfbutton::-moz-focus-inner {
	  border: 0;
	}
	.tfclear{
		clear:both;
	}
	td{
	display:block;
	}
	tr{
	display:block;
	border-bottom: 1px solid;
	}
	
	#user{
		
		margin: 50px;
		display: inline;
		font-family: Verdana, Helvetica, sans-serif;
		font-size:25px;
		
		
	}
</style>

<style type = "text/css">
@import url('http://fonts.googleapis.com/css?family=Amarante');

html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
  margin-top: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
  outline: none;
  -webkit-font-smoothing: antialiased;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
html { overflow-y: scroll; }
body { 
  background: #eee url('http://i.imgur.com/eeQeRmk.png'); /* http://subtlepatterns.com/weave/ */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
  font-size: 62.5%;
  line-height: 1;
  color: #585858;
  padding: 22px 10px;
  padding-bottom: 55px;
  
}

::selection { background: #5f74a0; color: #fff; }
::-moz-selection { background: #5f74a0; color: #fff; }
::-webkit-selection { background: #5f74a0; color: #fff; }

br { display: block; line-height: 1.6em; } 

article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { display: block; }
ol, ul { list-style: none; }

input, textarea { 
  -webkit-font-smoothing: antialiased;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  outline: none; 
}

blockquote, q { quotes: none; }
blockquote:before, blockquote:after, q:before, q:after { content: ''; content: none; }
strong, b { font-weight: bold; } 

table { border-collapse: collapse; border-spacing: 0; }
img { border: 0; max-width: 100%; }

h1 { 
  font-family: 'Amarante', Tahoma, sans-serif;
  font-weight: bold;
  font-size: 3.6em;
  line-height: 1.7em;
  margin-bottom: 10px;
  text-align: center;
}


/** page structure **/
#wrapper {
  display: block;
  width: 850px;
  background: #fff;
  margin: 100px 500px 200px 500px;
  padding: 10px 17px;
  -webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);
}

#keywords {
  margin: 0 auto;
  font-size: 1.2em;
  margin-bottom: 15px;
}


#keywords thead {
  cursor: pointer;
  background: #F25950;

  
 
}
#keywords thead tr th { 
  font-weight: bold;
  padding: 12px 30px;
  padding-left: 42px;
  
}
#keywords thead tr th span { 
  padding-right: 0px;
  background-repeat: no-repeat;
  background-position: 100% 100%;
  
}

#keywords thead tr th.headerSortUp, #keywords thead tr th.headerSortDown {
  background: #acc8dd;
  
}

#keywords thead tr th.headerSortUp span {
  background-image: url('http://i.imgur.com/SP99ZPJ.png');
}
#keywords thead tr th.headerSortDown span {
  background-image: url('http://i.imgur.com/RkA9MBo.png');
}


#keywords tbody tr { 
  color: #555;
}
#keywords tbody tr td {
  text-align: left;
 
}
.lalign {
  display: inline-block;
  padding: 10px 48px 30px 25px;
  margin: 0 auto;
  
  
  
}

</style>

<script>
$(function(){
  $('#keywords').tablesorter(); 
});
</script>



<div id="tfheader">
		<form id="tfnewsearch" method="post">
		<input type="submit" value= "Home" name = "HOME" class="tfbutton">
		<c:if test="${sessionScope.User==NULL}">
		        <input type="text" class="tftextinput" name="query" size="21" maxlength="120">
				<input type="submit" value="search" name="search" class="tfbutton">
				<input type="submit" value="Login" name="Login" class="tfbutton">
				
			</c:if>	
				
				
				<c:if test="${sessionScope.User!=NULL}">
				 
				<input type="submit" value="Upload Notes" name="upload" class="tfbutton">
				
				<input type="submit" value="View Submissions" name="viewsubs" class="tfbutton">
				<input type="submit" value="View Cart" name="cart" class="tfbutton">
				<input type="submit" value="MyBag" name="bag" class="tfbutton">
				<input type="submit" value="Logout" name="Logout" class="tfbutton">
				
				<div id = "user">
				<c:out value="Welcome ${sessionScope.User.name} "/>
				</div>
				</c:if>
				
				 
		</form>
		
		<div class="tfclear"></div>
		
		</div>







</head>
<body>
<div id="wrapper">
  <h1>View Submissions</h1>
  
  
  <table id="keywords" cellspacing="0" cellpadding="0">
  
    <thead>
      <tr>

    	<th><span>Name_of_Book</span></th>
        <th><span>Subject</span></th>
        <th><span>User</span></th>
        <th><span>No_of_Pages</span></th>
        <th><span>Description</span></th>
		<th><span>Amount</span></th>
  </tr>
  </thead>
  <c:forEach var="n" items="${viewsubs}">
   <tr>
    <td class="lalign">${n.name}</td>
    <td class="lalign">${n.subject}</td>
    <td class="lalign">By ${n.user.name}</td>
    <td class="lalign">${n.no_of_pages} pages</td>
    <td class="lalign">${n.description}</td>
    <td class="lalign">$${n.amount}</td>
	
  </tr>
		
	 
               
       </c:forEach>
		
		</table>
		</div>
</body>
</html>