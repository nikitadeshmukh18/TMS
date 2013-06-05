<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<%@page import="com.sample.model.User"%>
<%@page import="com.sample.model.Bus"%>
<%@page import="com.sample.service.BusService"%>
<!DOCTYPE html>
<html>
<head>
  <script src="<%=request.getContextPath()%>/static/js/bootstrap-dropdown.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/jquery.js"></script>
  <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/static/js/editBus.js"></script>
<script language="javascript" type="text/javascript">
function routePopUp(url) {
	newwindow=window.open(url,'name','height=200,width=150');
	if (window.focus) {newwindow.focus()}
	return false;
}

</script>

    <title></title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/static/css/form.css" rel="stylesheet" type="text/css"/>

</head>

<style type="text/css">


</style>
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
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/editBus">MODIFY BUS INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/deleteBus">DELETE BUS</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/displayBuses">DISPLAY ALL BUSES</a></li>

                                         </ul>
                                       </li>
                                        <li class="dropdown">
                                         <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">MANAGE ROUTES<b class="caret"></b></a>
                                         <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/addRoute">ADD ROUTES</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/modifyRoute">MODIFY ROUTES INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/deleteRoute">DELETE ROUTES</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/displayRoutes">DISPLAY ROUTES</a></li>

                                         </ul>
                                       </li>
                                        <li class="dropdown">
                                         <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">MANAGE STOPS<b class="caret"></b></a>
                                         <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/addStop">ADD STOPS</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/editStop">MODIFY STOP INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/deleteStop">DELETE STOP</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/displayStops">DISPLAY STOPS</a></li>

                                         </ul>
                                       </li>
                                        <li class="dropdown">
                                         <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">MANAGE CONDUCTOR<b class="caret"></b></a>
                                         <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/addConductor">ADD CONDUCTOR</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/editConductor">MODIFY CONDUCTOR INFO</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/deleteConductor">DELETE CONDUCTOR</a></li>
                                           <li role="presentation"><a role="menuitem" tabindex="-1" href="admin/displayConductors">DISPLAY CONDUCTORS</a></li>

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
                                                                 <h2 class="form-addbus-heading">ADD BUS DETAILS</h2><br>

                                                                From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp:
                                                                <select id="bus_src" name="bus_src">

                                                               <c:forEach items='${busStops}' var='stop'>
                                                                 <option> <c:out value='${stop.stopName}'/></option>
                                                               </c:forEach>
                                                                 </select>
                                                               <br>
                                                                To&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <select id="bus_destination" name="bus_destination">

                                                                <c:forEach items='${busStops}' var='stop'>

                                                                <option> <c:out value='${stop.stopName}'/></option>
                                                                </c:forEach>
                                                                </select>
                                                                <br>

                                                                Start Time : <input id="startTime" name="startTime" type="Text" class="input-block-level" placeholder="Start Time" required/>
                                                                <br>
                                                                Routes :   <select id="route" name="route">

                                                                <c:forEach items='${routes}' var='route'>

                                                                <option> <c:out value='${route.routeId}:'/>${route.pathName}</option>
                                                                </c:forEach>
                                                                </select>



                                                                <button class="btn btn-info" type="button" onclick="parent.location='/Sample/admin/addRoute'">New Route</button><br>

                                                                <br>
                                                         <button class="btn btn-large btn-primary" type="submit">SAVE</button>
                                                               </form>

                                                             </div> <!-- /container -->
                                                         <%
                                                         break;
                                                     case 2:
                                                          %>
                                                          <div class="container">
                                                                 <form class="form-addroute" method="POST" action="admin/saveRoute">
                                                                 <h2 class="form-addroute-heading">ADD ROUTE DETAILS</h2>
                                                                 <input id="busid" name"username" type="text" class="input-block-level" placeholder="Route ID" required/>
                                                                 <input id="bussrc" name="bussrc" type="text" class="input-block-level" placeholder="Route Source" required/>
                                                                 <input id="busdesti" name="busdesti" type="text" class="input-block-level" placeholder="Route Destination" required/>
                                                                 <button class="btn btn-large btn-primary" type="submit">Add Route</button>
                                                                 </form>


                                                                 </div> <!-- /container -->
                                                          <%
                                                         break;
                                                     case 3:
                                                          %>
                                                          <div class="container">
                                                                   <form class="form-addroute" method="POST" action="admin/saveStop">
                                                                   <h2 class="form-addroute-heading">Add Station Details</h2>
                                                                    <input id="stop" name="stop" type="text" class="input-block-level" placeholder="Stop Name" required/>
                                                                    <button class="btn btn-large btn-primary" type="submit">Save</button>
                                                                    </form>

                                                          </div> <!-- /container -->
                                                          <%
                                                           break;

                                                     case 4:
                                                     %>
                                                          <div class="container">
                                                             <form class="form-addroute" method="POST">
                                                               <h2 class="form-addroute-heading">Select Bus To Modify</h2>
                                                               <select id="bus" name="bus">
                                                                   <c:forEach items='${buses}' var='bus'>
                                                                        <option value=${bus.busNo}>${bus.busNo}</option>
                                                                   </c:forEach>
                                                               </select>



                                                               <button id="Update" class="btn btn-large btn-primary" onClick="loadDetails()">Update</button>


                                                               </form>
                                                          </div> <!-- /container -->
                                                     <%
                                                     break;

                                                    case 5:
                                                     %>
                                                          <div class="container">
                                                             <form class="form-addroute" method="POST" action="admin/removeBus">
                                                               <h2 class="form-addroute-heading">Select Bus To Delete</h2>
                                                               <select id="bus" name="bus">
                                                                   <c:forEach items='${buses}' var='bus'>
                                                                        <option value=${bus.busNo}>${bus.busNo}</option>
                                                                   </c:forEach>
                                                               </select>




                                                               <button id="delete" class="btn btn-large btn-primary">Delete</button>


                                                               </form>
                                                          </div> <!-- /container -->
                                                     <%
                                                     break;


                                                     case 6:
                                                     %>
                                                          <div class="container">
                                                             <form class="form-addroute" method="POST" action="admin/updateStop">
                                                               <h2 class="form-addroute-heading">Select Bus Stop To Modify</h2>
                                                               <select id="editStopList" name="stop">
                                                                   <c:forEach items='${busStops}' var='stop'>
                                                                        <option value=${stop.stopId}>${stop.stopName}</option>
                                                                   </c:forEach>
                                                               </select>
                                                               <label for="newName">Changed Name : </label>
                                                               <input id="newName" name="newName" type="text" class="input-block-level" required/>

                                                               <button id="updateStop" class="btn btn-large btn-primary">Update</button>


                                                               </form>
                                                          </div> <!-- /container -->
                                                     <%
                                                     break;


                                                     case 7:
                                                     %>
                                                          <div class="container">
                                                             <form class="form-addroute" method="POST" action="admin/removeStop">
                                                               <h2 class="form-addroute-heading">Select Bus Stop To Modify</h2>
                                                               <select id="editStopList" name="stop">
                                                                   <c:forEach items='${busStops}' var='stop'>
                                                                        <option value=${stop.stopId}>${stop.stopName}</option>
                                                                   </c:forEach>
                                                               </select>

                                                               <button id="removeStop" class="btn btn-large btn-primary">Delete</button>


                                                               </form>
                                                          </div> <!-- /container -->
                                                     <%
                                                     break;
                                                    case 8:         //add conductor
                                                         %>

                                                         <div class="container">
                                                               <form class="form-addbus" method="POST" action="admin/saveConductor">
                                                                 <h2 class="form-addbus-heading">Add Conductor Details</h2><br>


                                                                Name : <input id="CName" name="CName" type="Text" class="input-block-level" placeholder="Conductor name" required/>
                                                                <br>
                                                                Username : <input id="Cusername" name="Cusername" type="Text" class="input-block-level" placeholder="Username for Conductor" required/>
                                                                <br>
                                                                Password : <input id="Cpassword" name="Cpassword" type="Text" class="input-block-level" placeholder="Password for Conductor" required/>
                                                                <br>

                                                                <button class="btn btn-large btn-primary" type="submit">SAVE</button>
                                                               </form>

                                                             </div> <!-- /container -->
                                                         <%
                                                         break;
                                                         case 9:     //remove conductor
                                                         %>

                                                         <div class="container">
                                                               <form class="form-addbus" method="POST" action="admin/removeConductor">
                                                               <h2 class="form-addbus-heading">Select Conductor to be removed</h2><br>


                                                                <select id="conductor" name="conductor">
                                                                    <c:forEach items='${conductors}' var='c'>
                                                                       <option value=${c.id}>${c.name}</option>
                                                                    </c:forEach>
                                                                </select>

                                                                <button class="btn btn-large btn-primary" type="submit">DELETE</button>
                                                               </form>

                                                             </div> <!-- /container -->
                                                         <%
                                                         break;
                                                    case 10:
                                                     %>
                                                          <div class="container">
                                                             <form class="form-addroute" method="POST">
                                                               <h2 class="form-addroute-heading">Select Conductor To Modify</h2>
                                                               <select id="cond" name="cond">
                                                                   <c:forEach items='${conductors}' var='c'>
                                                                        <option value=${c.id}>${c.name}</option>
                                                                   </c:forEach>
                                                               </select>



                                                               <button id="Update" class="btn btn-large btn-primary" onClick="loadConductorDetails()">Update</button>


                                                               </form>
                                                          </div> <!-- /container -->
                                                     <%
                                                     break;



                                                    case 11:    //REMOVE ROUTE
                                                     %>
                                                        <div class="container">
                                                        <form class="form-addroute" action="admin/removeRoute">
                                                        <h2 class="form-addroute-heading">Select Route to Delete</h2>
                                                      Routes :   <select id="routeSelect" name="routeSelect">

                                                        <c:forEach items='${routes}' var='r'>

                                                            <option> <c:out value='${r.routeId}'/></option>
                                                        </c:forEach>
                                                       </select>
                                                     <button id="removeRoute" class="btn btn-large btn-primary">Delete</button>
                                                     <a onClick="loadRouteDetails()" class="btn btn-large btn-primary">Update Working</a>
                                                     </form>
                                                     </div> <!-- /container -->
                                                     <%
                                                     break;




                                         case 12:    //BUS LIST WHICH ARE ON ROUTE TO BE DELETED
                                                     %>
                                                     <div class="container">
                                                     <form class="form-addroute" method="POST" action="admin/removeRoute">
                                                     <h2 class="form-addroute-heading">Select Route to Delete</h2>

                                                     Route ID :  <%

                                                    String route1= request.getParameter("rt11");


                                                     int rt1=Integer.parseInt(route1);



                                                    %>
                                                    ROUTE : <%=rt1 %>-- ${rt1}----<c:out value="${rt1}"/>
                                                    <c:set var="contains" value="false" />
                                                    <c:forEach var="item" items="${buses}">
                                                      ${item.busNo}
                                                      <c:if test="${rt1 eq item.routeId}">
                                                      <h3><b>   ${item.busNo}</b></h3>
                                                        <c:set var="contains" value="true" />
                                                      </c:if>
                                                    </c:forEach>


                                                    <c:forEach items='${buses}' var='bus'>
                                                     <option value=${bus.busNo}>${bus.busNo}</option>
                                                    </c:forEach>



                                                         ${bussrc10}
                                                      <select id="bus" name="bus">
                                                      <c:forEach items='${buses12}' var='bus'>
                                                      <option value='${bus.busNo}'>'${bus.busNo}'</option>
                                                      </c:forEach>
                                                      </select>
                                                    <b>${busList.busNo}</b>
                                                    <b><i>${BUS.busList.busNo}</i></b>
                                                    <table border="1">
                                                    <tr><td>BUS ID </td><td>BUS Source</td><td>BUS Destination </td></tr>


                                                    <c:forEach items='${busList12}' var='bus1'>
                                                    <tr>
                                                    <td><c:out value='${bus1.busNo}'/></td>
                                                    <td><c:out value='${bus1.busSource}'/> </td>
                                                    <td><c:out value='${bus1.busDestination}'/> </td>
                                                    </tr>
                                                    </c:forEach>
                                                    </table>




                                                     </form>
                                                     </div> <!-- /container -->
                                                     <%
                                                     break;


                                                    case 14:    //MODIFY ROUTE
                                                     %>
                                                     <div class="container">
                                                     <form class="form-addroute" method="POST" action="admin/updateRoute">
                                                     <h2 class="form-addroute-heading">Select Route to Modify</h2>
                                                     Routes :   <select id="route" name="route">

                                                     <c:forEach items='${routes}' var='route'>

                                                     <option> <c:out value='${route.routeId}'/></option>
                                                     </c:forEach>
                                                     </select>
                                                     <button id="removeRoute" class="btn btn-large btn-primary">Modify</button>
                                                     <a onClick="loadRouteUpdateDetails()" class="btn btn-large btn-primary">Update Route</a>
                                                     </form>
                                                     </div> <!-- /container -->
                                                     <%
                                                     break;



                                                     case 15:    //DISPLAY ROUTE TO BE MODIFIED
                                                      %>
                                                      <div class="container">
                                                      <form class="form-addroute" method="POST" action="admin/updateRoute">



                                                      <ul class="nav nav-pills" id="myTab">
                                                      <li class="active" ><a href="#insert" data-toggle="tab">Insert</a></li>
                                                      <li><a href="#delete" data-toggle="tab">Delete</a></li>

                                                      </ul>

                                                     <div class="tab-content">

                                                      <div class="tab-pane active" id="insert">
                                                        <form class="form-addroute" method="POST" action="admin/insertInRoute">
                                                        <h2 class="form-addroute-heading">Insert Bus Stop in Route</h2>
                                                        <input  name="index" type="text" class="input-block-level" placeholder="Enter Index" required/>

                                                        LIST OF STOPS

                                                        <select id="bus_src" name="bus_src">
                                                        <c:forEach items='${busStopList}' var='stop'>
                                                        <option> <c:out value='${stop.stopName}'/></option>
                                                        </c:forEach>
                                                        </select>
                                                        <button class="btn btn-success" type="submit">Insert</button>
                                                        </form>
                                                      </div>


                                                      <div class="tab-pane" id="delete">
                                                        <form class="form-addroute" method="POST" action="admin/deleteInRoute">
                                                        <h2 class="form-addroute-heading">Insert Bus Stop in Route</h2>



                                                         <button class="btn btn-danger" type="submit">Delete</button>
                                                         </form>
                                                      </div>
                                                     </div>
                                                        <script>
                                                       $(function () {
                                                       $('#myTab a:first').tab('show');
                                                       })
                                                       </script>
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
                                                           Bus Successfully Created
                                                           Source : ${bus.busSource}
                                                           Destination : ${bus.busDestination}
                                                           Route: ${rt}
                                                           Start Time: ${time}

                                                           </pre>
                                                           <a href="javascript:javascript:mypopup('http://localhost:8080/Sample/admin?id=14&bisid=<%=busid%>&bussrc=<%=bussrc%>&busdesti=<%=busdesti%>','400','400')" > WANT NEW ROUTE </a>
                                                           <%
                                                           break;


                                                     case 16:                 //ADD BUS Pop UP & NEW Route
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
                                                     <button class="btn btn-success btn-large" type="sub mit">Add Stop</button>

                                                      </form>

                                                     <%
                                                     break;

                                                case 17:    //display Buses
                                                     %>
                                                        <div class="container">
                                                            <table class="table table-striped tablestyle" >
                                                                <thead>
                                                                    <th>Bus No</th>
                                                                    <th>Source</th>
                                                                    <th>Desination</th>
                                                                    <th>Path</th>
                                                                    <th>Time</th>
                                                                </thead>
                                                                  <c:forEach var='bus' items='${buses}' varStatus="status">
                                                                              <tr><td> <c:out value='${bus.busNo}'/></td>
                                                                                <td> <c:out value='${bus.busSource}'/></td>
                                                                                <td> <c:out value='${bus.busDestination}'/></td>
                                                                                <td> <c:out value='${paths[status.index].pathName}'/> </td>
                                                                                <td> <c:out value='${bus.startTime}'/></td>
                                                                              </tr>
                                                                  </c:forEach>

                                                            </table>
                                                     </div> <!-- /container -->
                                                     <%
                                                     break;

                                                case 18:    //Routes
                                                     %>
                                                        <div class="container">
                                                            <table class="table table-striped tablestyle" >
                                                                <thead>
                                                                    <th>Route Id</th>
                                                                    <th>Route</th>
                                                                </thead>
                                                                  <c:forEach var='route' items='${routes}'>
                                                                              <tr><td> <c:out value='${route.routeId}'/></td>
                                                                                <td> <c:out value='${route.pathName}'/></td>
                                                                              </tr>
                                                                  </c:forEach>

                                                            </table>

                                                     </div> <!-- /container -->
                                                     <%
                                                     break;

                                                case 19:    //Routes
                                                     %>
                                                        <div class="container">
                                                            <table class="table table-striped tablestyle" >
                                                                <thead>
                                                                    <th>Stop Id</th>
                                                                    <th>Stop Name</th>
                                                                </thead>
                                                                  <c:forEach var='stop' items='${busStops}'>
                                                                              <tr><td> <c:out value='${stop.stopId}'/></td>
                                                                                <td> <c:out value='${stop.stopName}'/></td>
                                                                              </tr>
                                                                  </c:forEach>

                                                            </table>

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