 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.*" %>
 <%@page import="java.lang.*" %>
 <%@page import="com.sample.model.Bus"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
     <link href="<%=request.getContextPath()%>/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
     <link href="<%=request.getContextPath()%>/static/css/bootstrap-responsive.css" rel="stylesheet" type="text/css"/>
     <link href="<%=request.getContextPath()%>/static/css/form.css" rel="stylesheet" type="text/css"/>
     <script src="<%=request.getContextPath()%>/static/js/bootstrap-dropdown.js"></script>
     <script src="<%=request.getContextPath()%>/static/js/jquery.js"></script>
     <title>TMS | CONDUCTOR PAGE </title>
    </head>
    <body>
    <div class="container">
    <form class="form-conductor" method="GET" action="chome.do">
    <a href="/Sample/" class="btn btn-large btn-info">Home</a>
    <h2 class="form-conductor-heading">SELECT BUS</h2>
    <select id="bus_id" name="bus_id">
    <c:forEach items='${busList}' var='bus'>
    <option> <c:out value='${bus.busNo}'/>: <c:out value='${bus.busSource}'/> - <c:out value='${bus.busDestination}'/> </option>
    </c:forEach>
    </select>
    <button class="btn btn-large btn-primary" type="submit">Get In</button>
    </form>
                    </div> <!-- /container -->


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
