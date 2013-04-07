<!DOCTYPE html>
<html lang="en">
  <head>


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

      <form method="POST" action="saveUpdate">
        <h2 id="bus" name="bus" class="form-signin-heading">Bus Details for Bus No - ${bus.busNo}</h2>
        <input id="busSource" name="busSource" type="Text" class="input-block-level" placeholder="${bus.busSource}"></input>
        <input id="busDestination" name="busDestination" type="Text" class="input-block-level" placeholder="${bus.busDestination}"></input>
        <input id="route" name="route" type="Text" class="input-block-level" placeholder="${path.pathName}"></input>

        <button class="btn btn-large btn-primary" onClick = "window.close();">Save</button>
      </form>
      <text color = "red">${errorMessage}</text>
    </div>


  </body>
</html>
