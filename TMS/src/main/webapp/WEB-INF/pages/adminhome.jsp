<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<%
            String ID = "";
            int id=0;
            
            ID = request.getParameter("id");
            id=Integer.parseInt(ID);
           switch(id)
           {
                         case 1:
                             %>
                             <h1>hello</h1>
                             <%
                             break;
                          default :
                              %>
                             <h1>Default</h1>
                             <%
           }
           
%> 