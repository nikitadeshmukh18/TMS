<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/static/css/form.css" rel="stylesheet" type="text/css"/>
     <script src="<%=request.getContextPath()%>/static/js/bootstrap-dropdown.js"></script>
     <script src="<%=request.getContextPath()%>/static/js/jquery.js"></script>
</head>
<body>
WELCOME ADMIN ${user.name} <text align="right"><a href="/Sample/welcome">Log Out</a></text>
                     <section id="dropdowns">
                              <div class="page-header">

                   <div class="bs-docs-example">
                               <div id="navbar-example" class="navbar navbar-static">
                                 <div class="navbar-inner">
                                   <div class="container" style="width: auto;">
                                     <a class="brand" href="#">TMS | ADMIN</a>
                                     <ul class="nav" role="navigation">
                                       <li class="dropdown">
                                         <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">MANAGE BUS<b class="caret"></b></a>
                                         <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                                             <li role="presentation"><a role="menuitem" tabindex="-1" href="admin?id=1">ADD BUS</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#anotherAction">MODIFY BUS INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#">DELETE BUS</a></li>

                                         </ul>
                                       </li>
                                        <li class="dropdown">
                                         <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">MANAGE ROUTES<b class="caret"></b></a>
                                         <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin?id=2">ADD ROUTES</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#anotherAction">MODIFY ROUTES INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#">DELETE ROUTES</a></li>

                                         </ul>
                                       </li>
                                        <li class="dropdown">
                                         <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">MANAGE STOPS<b class="caret"></b></a>
                                         <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ADD STOPS</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#anotherAction">MODIFY STOPS INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#">DELETE STOPS</a></li>

                                         </ul>
                                       </li>
                                        <li class="dropdown">
                                         <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">MANAGE CONDUCTOR<b class="caret"></b></a>
                                         <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ADD CONDUCTOR</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#anotherAction">MODIFY CONDUCTOR INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="#">DELETE CONDUCTOR</a></li>

                                         </ul>
                                       </li>
                                     </ul>

                                   </div>
                                 </div>
                               </div> <!-- /navbar-example -->
                             </div>
                            </div>

                            <!-- Indivisual Code For Bus/Route/Conductor -->

                            <%
                                        String ID = "";
                                        int id=0;

                                        ID = request.getParameter("id");

                                        id=Integer.parseInt(ID);
                                        
                                       switch(id)
                                       {
                                                     case 0:
                                                     %>
                                                     <center>
                                                     <h1>Hey This is Simple Home</h1>
                                                     <h2>Yet to Design</h2>
                                                     </center>
                                                    <%
                                                     break;
                                                     case 1:
                                                         %>

                                                         <div class="container">
                                                               <form class="form-addbus" method="POST" action="addbus.do">
                                                                 <h2 class="form-addbus-heading">ADD BUS DETAILS</h2>
                                                                 <input id="busid" name"username" type="text" class="input-block-level" placeholder="Bus ID" required/>
                                                                 <input id="bussrc" name="bussrc" type="text" class="input-block-level" placeholder="Bus Source" required/>
                                                                 <input id="busdesti" name="busdesti" type="text" class="input-block-level" placeholder="Bus Destination" required/>
                                                                <button class="btn btn-info btn-large" type="button" onclick="openwin(0);">Existing Route</button>
                                                                <button class="btn btn-info btn-large" type="button" onclick="openwin(0);">New Route</button><br>
                                                         <button class="btn btn-large btn-primary" type="submit">Add Bus</button>
                                                               </form>

                                                             </div> <!-- /container -->
                                                         <%
                                                         break;
                                                     case 2:
                                                          %>
                                                          <div class="container">
                                                                <form class="form-addroute" method="POST" action="addroute.do">
                                                                 <h2 class="form-addroute-heading">ADD ROUTE DETAILS</h2>
                                                                 <input id="busid" name"username" type="text" class="input-block-level" placeholder="Route ID" required/>
                                                                 <input id="bussrc" name="bussrc" type="text" class="input-block-level" placeholder="Route Source" required/>
                                                                 <input id="busdesti" name="busdesti" type="text" class="input-block-level" placeholder="Route Destination" required/>
                                                                 <button class="btn btn-large btn-primary" type="submit">Add Route</button>
                                                                </form>

                                                                 </div> <!-- /container -->
                                                          <%
                                                         break;
                                                      default :
                                                          %>
                                                         <h1>Default</h1>
                                                         <%
                                       }

                            %>




                                       <script src="<%=request.getContextPath()%>/static/js/bootstrap-transition.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/jquery.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-alert.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-modal.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-dropdown.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-scrollspy.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-tab.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-tooltip.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-popover.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-button.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-collapse.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-carousel.js"></script>
                                           <script src="<%=request.getContextPath()%>/static/js/bootstrap-typeahead.js"></script>

</body>
</html>