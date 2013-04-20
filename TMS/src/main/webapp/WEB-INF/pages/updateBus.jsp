
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
  <head>

    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
       $("#selectRoute").hide();
       $("#busNo").hide();
     });

     function changeRoute(){

         $("#route").hide();
         $("#selectRoute").show();
         $("#selectRoute").change(function() {
            var route = $("#selectRoute").val();
            $("#route").val(route.toString());

         });

    }

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

      <form method="POST" action="saveUpdate" name="busForm" id="busForm">

        <h2 id="bus" name="bus" class="form-signin-heading">Bus Details for Bus No - ${bus.busNo}</h2>

        <input id="busNo" name="busNo" type="Text" value = "${bus.busNo}"/>
        <label for="busSource">Source</label>
        <input id="busSource" name="busSource" type="Text" value="${bus.busSource}" style = "width:50;"></input><br>
        <label for="busDestination">Destination</label>
        <input id="busDestination" name="busDestination" type="Text" style = "width:50;" value="${bus.busDestination}"></input><br>
        <label for="startTime">Destination</label>
        <input id="startTime" name="startTime" type="Text" style = "width:50;" value="${bus.startTime}"></input><br>
        <label for="route">Route</label>
        <select id="selectRoute">
        <c:forEach items='${routes}' var='route'>

            <option> <c:out value='${route.routeId}:'/>${route.pathName}</option>
            </c:forEach>
        </select>
        <input id="route" name="route" type="Text" style = "width:100" value="${path.routeId}:${path.pathName}" readonly="readonly"><button type="button" class="btn btn-small" onClick = "changeRoute()">Change</button></input><br>

        <button class="btn btn-large btn-primary" onClick = "window.close();">Save</button>
      </form>
      <text color = "red">${errorMessage}</text>
    </div>


  </body>
</html>
