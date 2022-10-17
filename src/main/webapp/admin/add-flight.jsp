<%@ page import="java.util.ArrayList" %>
<%@ page import="com.marocair.marocair.model.Flight" %>
<jsp:include page="/admin/layout/header.jsp">
    <jsp:param name="sectionTitle" value="Add flights" />
</jsp:include>

<form action="${url}flight" method="post" class="bg-slate-300 p-6">
    <input class="border border-2 p-3" type="text" name="from" placeholder="From" >
    <input class="border border-2 p-3" type="text" name="to" placeholder="to">
    <input class="border border-2 p-3" type="number" name="nbr-of-seats" placeholder="Number of seats">
    <input class="border border-2 p-3" type="datetime-local" name="depart-time" placeholder="Depart time">
    <input class="border border-2 p-3" type="datetime-local" name="arrival-time" placeholder="Arrival time">
    <input class="border border-2 p-3" type="number" name="price" placeholder="Price">
    <button class="border border-2 p-3" type="submit">Submit</button>
</form>

<%@include file="/admin/layout/footer.jsp" %>