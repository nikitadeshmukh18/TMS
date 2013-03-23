<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>TMS | Sign in &middot;</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->

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
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
     <link href="<%=request.getContextPath()%>/static/css/bootstrap-responsive.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>



    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="static/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="static/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="static/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="static/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="static/ico/favicon.png">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="GET" action="admin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input id="username" name"username" type="text" class="input-block-level" placeholder="Email address" required>
        <input id="password" name="password" type="password" class="input-block-level" placeholder="Password" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="static/js/bootstrap-transition.js"></script>
    <script src="static/js/jquery.js"></script>
    <script src="static/js/bootstrap-alert.js"></script>
    <script src="static/js/bootstrap-modal.js"></script>
    <script src="static/js/bootstrap-dropdown.js"></script>
    <script src="static/js/bootstrap-scrollspy.js"></script>
    <script src="static/js/bootstrap-tab.js"></script>
    <script src="static/js/bootstrap-tooltip.js"></script>
    <script src="static/js/bootstrap-popover.js"></script>
    <script src="static/js/bootstrap-button.js"></script>
    <script src="static/js/bootstrap-collapse.js"></script>
    <script src="static/js/bootstrap-carousel.js"></script>
    <script src="static/js/bootstrap-typeahead.js"></script>

  </body>
</html>
