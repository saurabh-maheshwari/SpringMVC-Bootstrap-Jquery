<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/css/bootstrap-responsive.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/jquery/jquery-1.10.1.min.js" />"
	type="text/javascript" />
</head>
<body>
	<h1>Hello world!</h1>
	<h5>Saurabh Maheshwari</h5>
	<P>The time on the server is ${serverTime}.</P>


	<a href="http://jquery.com/">jQuery</a>
	<script type="text/javascript">
		$(document).ready(function() {
			$("a").click(function(event) {
				alert("The link will no longer take you to jquery.com");
				event.preventDefault();
			});
		});
	</script>


</body>
</html>
