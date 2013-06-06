<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<%@page import="com.sample.model.BusStop"%>
<%@page import="com.sample.model.User"%>
<%@page import="com.sample.model.RouteStops"%>

<!DOCTYPE html>

<html lang="en">
  <head>

    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


    </script>

     <link href="<%=request.getContextPath()%>/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>

    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }

      }

    </style>
     <link href="<%=request.getContextPath()%>/static/css/bootstrap-responsive.css" rel="stylesheet" type="text/css"/>


     </head>

  <body>

 <div class="container">
   <a href="/Sample/admin?id=0" class="btn btn-large btn-info">Admin Home</a>

<form class="form-signin" method="GET" action="saveRoute">
<h2>New Route </h2>
<h3><i>(Adding Stops in Route)</i></h3>
<select id="busStops" name="busStops">
<c:forEach items='${busStops}' var='stop'>
<option><c:out value='${stop.stopId}'/>:<c:out value='${stop.stopName}'/></option>
</c:forEach>
</select>
<br>
<h3>Route N0: '${routeId}'
<input type="hidden" value='${routeId}' name="routeId"/>
<br>
Current Stop Index  = ${current}
<input type="hidden" value='${current}' name="current"/>
<br>
</h3>
Time (From Source) :
<select id="timehr" name="timehr">
<c:forEach var="i" begin="00" end="23">
<option><c:out value="${i}"/></option>
</c:forEach>
</select>
:
<select id="timemin" name="timemin">
<c:forEach var="j" begin="00" end="59">
<option><c:out value="${j}"/></option>
</c:forEach>
</select>


<a href="newRoute" >New Route</a>
<input type="Submit" class="btn btn-primary btn-large" value="Add Stop">
</center>
</form>
