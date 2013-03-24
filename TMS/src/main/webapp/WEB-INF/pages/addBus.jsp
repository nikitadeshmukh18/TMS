
<html>
<head>

    <link href="<%=request.getContextPath()%>/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<h2>Hello World...!!</h2>

<h1>Add a bus here</h1>

<form name="BusForm" method="GET" action="">
Bus No : <input type = "text"  name="busNo" id="busNo"/> <br>
Source : <input type = "text"  name="busSource" id="busSource"/> <br>
Destination : <input type = "text"  name="busDestination" id= "busDestination"/> <br>
Bus Route : <input type = "text" name="routeId" id="routeId"/><br>
<input type = "submit" value="Add"/>

</form>
</body>
</html>
