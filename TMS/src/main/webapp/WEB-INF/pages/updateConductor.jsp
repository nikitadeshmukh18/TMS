
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
  <head>

    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

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

      <form method="POST" action="saveUpdateConductor" name="busForm" id="busForm">

        <h2 id="cond" name="cond" class="form-signin-heading">Conductor Details - ${conductor.id}</h2>

        <input id="cid" name="cid" type="Text" value = "${conductor.id}" style="display:none;"/>
        <label for="name">Name</label>
        <input id="name" name="name" type="Text" value="${conductor.name}" style = "width:50;"></input><br>
        <label for="Cusername">Username</label>
        <input id="Cusername" name="Cusername" type="Text" value="${Cuser.username}" style = "width:50;"></input><br>
        <label for="Cpassword">Password</label>
        <input id="Cpassword" name="Cpassword" type="Text" value="${Cuser.password}" style = "width:50;"></input><br>

        <button class="btn btn-large btn-primary" onClick = "window.close();">Save</button>
      </form>
      <text color = "red">${errorMessage}</text>
    </div>


  </body>
</html>
