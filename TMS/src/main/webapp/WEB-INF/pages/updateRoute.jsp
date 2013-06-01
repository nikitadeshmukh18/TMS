
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sample.model.RouteStops"%>
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
        <h2>Route : ${route} </h2>
        <h3><i>Following Stops are Currently in Route</i></h3>
        <table class="table">
                <tr><th>Stop No</th><th>Stop Name </th><th>Delete </th></tr>
                <c:forEach items='${routeStops}' var='r'>
                <tr>
                    <td><c:out value="${r.stopIndex}" /></td>
                	<td><c:out value="${r.stopName}" /></td>
                	<td><a href="deleteRouteStop?route=${route}&stopIndex=${r.stopIndex}" class="btn btn-small btn-primary">Delete Stops</a></td>
                </tr>
                </c:forEach>
               </table>



    <form action="insertRouteStops" class="form-signin">
    <h2>Insert Stop in Route </h2>

    <input  name="stop_index" type="text" class="input-block-level" placeholder="Stop Index " required/>
    <input type="hidden" value="${route}" name="route">
    LIST OF STOPS
    <select id="bus_stop" name="bus_stop">
    <c:forEach items='${busStops}' var='b'>
    <option>  <c:out value="${b.stopId}" />: <c:out value="${b.stopName}" />   </option>
    </c:forEach>
        </select>
    <input  name="stop_time" type="text" class="input-block-level" placeholder="Time From Src " required/>
    <button class="btn btn-success" type="submit">Insert Stop</button>
      </form>
    <text color = "red">${errorMessage}</text>
    </div>


  </body>
</html>
