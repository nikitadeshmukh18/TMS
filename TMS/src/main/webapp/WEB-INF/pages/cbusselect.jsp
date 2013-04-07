<%@page import="java.lang.*" %>
<%@page import="java.util.*" %>
<%
                         String bus_no= request.getParameter("bus_no");
                         String route_no= request.getParameter("route_no");
                         String current= request.getParameter("current");
                         String total= request.getParameter("total");
                         String current_stop= request.getParameter("current_stop");
                                                                                             %>
                                                     <center>
                                                     <h1>Hey This is Simple Home</h1>
                                                     <h2>Yet to Design</h2>

                                                    <form class="form-conductor" method="GET" action="cbusselect.do">
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
                                                     <h1>Hey Dude..Final Stop</h1>

                                                     <%
                                                     }
                                                     else
                                                     {                                                    %>
                                                        <h1>Hey Dude..</h1>
                                                                                                          <input type="submit" name="Submit" > <%
                                                                                                           } %>

                                                     </center>
                                                     </form>