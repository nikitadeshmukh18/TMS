<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<%@page import="com.sample.model.User"%>
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
WELCOME ADMIN ${user.name} <text align="right"><a href="/Sample/welcome">Log Out</a>  ${id}</text>
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
                                             <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/addBus">ADD BUS</a></li>
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


                                        String ID= request.getParameter("id");

                                        int id =  Integer.parseInt(ID);


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
                                                               <form class="form-addbus" method="POST" action="admin/saveBus">
                                                                 <h2 class="form-addbus-heading">ADD BUS DETAILS</h2>

                                                                 <select id="bus_src" name="bus_src">

                                                               <c:forEach items='${busStops}' var='stop'>

                                                                    <option> <c:out value='${stop.stopName}'/></option>
                                                                 </c:forEach>
                                                                 </select>

                                                                <select id="bus_destination" name="bus_destination">

                                                                <c:forEach items='${busStops}' var='stop'>

                                                                <option> <c:out value='${stop.stopName}'/></option>
                                                                </c:forEach>
                                                                </select>




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
                                                                <form class="form-addroute" method="POST" action="addroute">
                                                                 <h2 class="form-addroute-heading">ADD ROUTE DETAILS</h2>
                                                                 <input id="busid" name"username" type="text" class="input-block-level" placeholder="Route ID" required/>
                                                                 <input id="bussrc" name="bussrc" type="text" class="input-block-level" placeholder="Route Source" required/>
                                                                 <input id="busdesti" name="busdesti" type="text" class="input-block-level" placeholder="Route Destination" required/>
                                                                 <button class="btn btn-large btn-primary" type="submit">Add Route</button>
                                                                </form>

                                                                 </div> <!-- /container -->
                                                          <%
                                                         break;
                                                     case 13:                 //ADD BUS Second Page
                                                           String bussrc = "";
                                                           bussrc = request.getParameter("bussrc");
                                                           String busdesti = "";
                                                           busdesti = request.getParameter("busdesti");
                                                           String busid="";
                                                           busid = request.getParameter("busid");

                                                           %>
                                                           <script language="javascript">function mypopup(url,width,height)
                                                           {
                                                           width=window.screen.width;
                                                           height=window.screen.height;
                                                           mywindow = window.open
                                                           (url,"mywindow","location=0,status=1,scrollbars=1,resizable=1,menubar=0,toolbar=no,width="+width+",height="+height);
                                                           //mywindow.moveTo(0,0);
                                                            mywindow.focus();
                                                           }
                                                           </script>
                                                           <pre>
                                                           BUS ID Submitted is <%=busid%>
                                                           Src : <%=bussrc%>
                                                           Desti : <%=busdesti%>
                                                           Apply Search Logic Here
                                                           </pre>
                                                           <a href="javascript:javascript:mypopup('http://localhost:8080/Sample/admin?id=14&bisid=<%=busid%>&bussrc=<%=bussrc%>&busdesti=<%=busdesti%>','400','400')" > WANT NEW ROUTE </a>
                                                           <%
                                                           break;


                                                     case 14:                 //ADD BUS Pop UP & NEW Route
                                                     String bussrc1 = "";
                                                     bussrc1 = request.getParameter("bussrc");
                                                     String busdesti1 = "";
                                                     busdesti1 = request.getParameter("busdesti");
                                                     String busid1="";
                                                     busid1 = request.getParameter("busid");

                                                     %>

                                                         <div class="alert">
                                                         <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                         Here You Could Add Alerts

                                                         </div>
                                                                                                                 <pre>
                                                     BUS ID Submitted is <%=busid1%>
                                                     Src : <%=bussrc1%>
                                                     Desti : <%=busdesti1%>
                                                     Apply New Route Logic with bus ID
                                                                                                                 </pre>
                                                      <div class="container">
                                                      <form class="form-addbusroute" method="POST" action="addroute">

                                                     New Route ID : <input  name="bustime" type="text" class="input-block-level" placeholder="Arrival Time OF BUS" required/>

                                                     Select Bus Stop : <select name="busstop">
                                                                       <option>1</option>
                                                                       <option>2</option>
                                                                       <option>3</option>
                                                                       <option>4</option>
                                                                       <option>5</option>
                                                                       </select>
                                                     <input  name="bustime" type="text" class="input-block-level" placeholder="Arrival Time OF BUS" required/>
                                                     <button class="btn btn-success btn-large" type="submit">Add Stop</button>

                                                      </form>

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