<%@page import="java.lang.*" %>
<%@page import="java.util.*" %>
<%@page import="com.sample.service.*" %>




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


<%
                         String bus_no= request.getParameter("bus_no");
                         String route_no= request.getParameter("route_no");
                         String current= request.getParameter("current");
                         String total= request.getParameter("total");
                         String current_stop= request.getParameter("current_stop");
                         String url="deleteRunningBus?bus_no="+bus_no;


                                                                                            %>
                                                     <center>

                                                    <form class="form-signin" method="GET" action="cbusselect.do">
                                                    <h3>BUS_NO : <%=bus_no %> </h3>
                                                    <input type="hidden" name="bus_no" value=<%=bus_no %> >
                                                     <h3>ROUTE_NO : <%=route_no %> </h3>
                                                     <input type="hidden" name="route_no" value=<%=route_no %> >
                                                     <h3>Current : <%=current %> </h3>
                                                     <input type="hidden" name="current" value=<%=current %> >
                                                     <h3>Total : <%=total %> </h3>
                                                     <input type="hidden" name="total" value=<%=total %> >
                                                     <h3>current_stop : <%=current_stop %> </h3>
                                                     <% if(current.equals(total))
                                                     {
                                                     %>
                                                     <h1>This a Final Stop</h1>

                                                     <a href=<%=url %> class="btn btn-large btn-primary">Log Out</a>

                                                     <%                                                     }
                                                     else
                                                     {                                                    %>
                                                         <input type="submit" name="Submit" class="btn btn-large btn-primary" value="Next Stop" > <%
                                                                                                          } %>

                                                     </center>
                                                     </form>