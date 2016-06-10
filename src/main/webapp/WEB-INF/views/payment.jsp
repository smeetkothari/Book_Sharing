<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<style>	
* { margin: 0; padding: 0; outline: none; box-sizing:border-box; }
a>img { border: none; }
header, footer, article, section, nav, aside { display: block; }

/* === General === */
body {
    font-family:Arial;
    font-size: 14px;
    background: #eee url('http://i.imgur.com/eeQeRmk.png');
	
	
}

.clearfix {
    clear:both;
}
/* === Credit Card === */
.credit-card {
    display:block;
    position:relative;
    width:93.75%;   /* This is 300px on 320px wide screen */
    max-width:500px;    /* Just to make sure that it doesnt get crazy on bg screens */
    min-width:300px;    /* And make sure that it contains at least some size */
    margin:30px auto;
    padding:20px;
    overflow:hidden;
    border-radius:6px;
    z-index:1;
}

.credit-card .inputs {
    list-style:none;
    margin-top:30px;
    
}

.credit-card .inputs li {
    margin-bottom:30px;
}

.credit-card .inputs li.last {
    margin-bottom:10px;
}

.credit-card .inputs li.expire {
    float:left;
    width:70%;
    margin-right:5%;
}

.credit-card .inputs li.expire input{
    float:left;
    width:35%;
}

.credit-card .inputs li.expire input.month{
    width:60%;
    margin-right:5%;
}

.credit-card .inputs li.cvc-code {
    float:left;
    width:25%;
}

.credit-card .inputs li.cvc-code input {
    width:100%;
}

.credit-card .watermark {
    position:absolute;
    z-index:10;
}

.credit-card form {
    position:relative;
    z-index:50;
}

.credit-card .logo {
    position:absolute;
    top:15px;
    right:20px;
    text-transform:uppercase;
    font-weight:bold;
}

/* === Visa === */
.visa {
    color:#fff;
    box-shadow: 0px 0px 4px rgba(0,0,0,0.8), inset 0px 1px 3px rgba(255,255,255,0.3), inset 0px 0px 2px rgba(255,255,255,0.2);
}

.visa h2 {
    text-shadow:1px 1px 2px rgba(17,121,173,0.8);
}

.visa .logo {
    color:rgba(255,255,255,0.9);
    font-size:2em;
    font-style:italic;
    text-shadow:0px 0px 3px rgba(17,123,173,0.9);
}

.visa .logo:after {
    content:' ';
    position:absolute;
    left:0px;
    top:5px;
    width: 0;
    height: 0;
    border-top: 10px solid orange;
    border-left: 10px solid transparent;
}

.visa .watermark {
    bottom:-100px;
    left:-50px;
    color:rgba(255,255,255,0.06);
    font-size:20em;
    font-weight:bold;
    font-style:italic;
}

/* === Forms === */
label {
    display:block;
    margin-bottom:8px;
    color:rgba(255,255,255,0.6);
    text-transform:uppercase;
    font-size:1.1em;
    font-weight:bold;
    text-shadow:0px 1px 2px rgba(17,123,173,0.6);
}

input {
    display: inline;
    padding:12px 10px;
    color:#999;
    font-size:1.2em;
    font-weight:bold;
    text-shadow:1px  1px 1px #fff;
    border:1px solid rgba(16,103,133,0.6);
    box-shadow:0px 0px 3px rgba(255,255,255,0.5), inset 0px 1px 4px rgba(0,0,0,0.2);
    border-radius:3px;
}

input.full {
    width:100%;
}

/* === Gradients === */
.gr-visa {
    background: #1db1cf; /* Old browsers */
    background: -moz-linear-gradient(top,  #1db1cf 0%, #1078ab 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#1db1cf), color-stop(100%,#1078ab)); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  #1db1cf 0%,#1078ab 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  #1db1cf 0%,#1078ab 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  #1db1cf 0%,#1078ab 100%); /* IE10+ */
    background: linear-gradient(to bottom,  #1db1cf 0%,#1078ab 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1db1cf', endColorstr='#1078ab',GradientType=0 ); /* IE6-9 */
	margin-top: 200px;
	
}
.gr-input {
    background: #d3d3d3; /* Old browsers */
    background: -moz-linear-gradient(top,  #d3d3d3 0%, #d9d9d9 38%, #e5e5e5 82%, #e7e7e7 100%); /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#d3d3d3), color-stop(38%,#d9d9d9), color-stop(82%,#e5e5e5), color-stop(100%,#e7e7e7)); /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top,  #d3d3d3 0%,#d9d9d9 38%,#e5e5e5 82%,#e7e7e7 100%); /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top,  #d3d3d3 0%,#d9d9d9 38%,#e5e5e5 82%,#e7e7e7 100%); /* Opera 11.10+ */
    background: -ms-linear-gradient(top,  #d3d3d3 0%,#d9d9d9 38%,#e5e5e5 82%,#e7e7e7 100%); /* IE10+ */
    background: linear-gradient(to bottom,  #d3d3d3 0%,#d9d9d9 38%,#e5e5e5 82%,#e7e7e7 100%); /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#d3d3d3', endColorstr='#e7e7e7',GradientType=0 ); /* IE6-9 */
}

#button input[type="submit"] {
		width: 12%;
		padding: 20px;
		color: #000;
		font-size: 30px;
		margin-left: 850px;
		
	}

</style>
<form action="search" method="post">

<section class="credit-card visa gr-visa">
        <div class="logo">Visa</div>
		
        <form1>
            <h2>Payment Details</h2>

            <ul class="inputs">
			<li>
					<label>Card Holder</label>
					<input type="text" name="card_holder"  value="" class="full gr-input" required />
                </li>
                <li>
                    <label>Card Number</label>
                    <input type="text" name="card_number"  value="" class="full gr-input" required />
					</li>
					
                <li class="expire last">
                    <label>Expiration </label>
                    <input type="text" name="expire_month" value="" size="10" class="month gr-input" required />
                    <input type="text" name="expire_year" value="" size="10" class="year gr-input" required />
                    <div class="clearfix"></div>
                </li>
                <li class="cvc-code last">
                    <label>CVC Code</label>
                    <input type="text" name="cvc_code" value="" size="10" class="gr-input" required />
                </li>
                <div class="clearfix"></div>
            </ul>
        </form1>
        <div class="watermark">Visa</div>
    </section>

<div id = "button">
<input type="submit" value="Pay" name="pay" class= "tfbutton">
</div> 
</form>
</body>
</html>


