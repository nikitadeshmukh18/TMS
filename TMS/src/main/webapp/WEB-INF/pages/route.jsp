<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<%@page import="com.sample.model.BusStop"%>
<%@page import="com.sample.model.User"%>

<form class="form-conductor" method="GET" action="saveRoute">
<center>
<select id="busStops" name="busStops">
<c:forEach items='${busStops}' var='stop'>
<option><c:out value='${stop.stopId}'/>:<c:out value='${stop.stopName}'/></option>
</c:forEach>
</select>
<br>
<h3>Route N0: '${routeId}'
<input type="hidden" value='${routeId}' name="routeId"/>
<br>
Current Stop Index  = ${current}
<input type="hidden" value='${current}' name="current"/>
<br>
</h3>
Time (From Source) : <input type="text" name="timing">
<a href="newRoute" >New Route</a>
<input type="Submit">
</center>
</form>
