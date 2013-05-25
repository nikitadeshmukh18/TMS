
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sample.model.Bus"%>
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
        <h2>Route : ${route} </h2>
        <h3><i>Currently Following Buses are Using Route Which You Want To Delete</i></h3>
        <h4>Please Delete These Bus(es) First</h4>
        <table class="table">
        <tr><th>BUS No</th><th>BUS Source</th><th>BUS Destination</th></tr>
        <c:forEach items='${busList}' var='bus'><tr>
        <td><c:out value='${bus.busNo}'/> </td><td> <c:out value='${bus.busSource}'/> </td><td> <c:out value='${bus.busDestination}'/> </td>
        </tr>
        </c:forEach>
       </table>


      </form>
      <text color = "red">${errorMessage}</text>
    </div>


  </body>
</html>
