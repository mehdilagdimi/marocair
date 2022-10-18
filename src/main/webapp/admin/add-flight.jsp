<%@ page import="java.util.ArrayList" %>
<%@ page import="com.marocair.marocair.model.Flight" %>
<jsp:include page="/admin/layout/header.jsp">
    <jsp:param name="sectionTitle" value="Add flights" />
</jsp:include>

<%
    String url = application.getInitParameter("url");
%>
<form action="<%=url%>flight" method="post" class="bg-gray-50 rounded-md p-6">
    <div class="flex-col">
        <div class="grid grid-cols-3 gap-4">
            <input class="border border-1 p-3 rounded-md" type="text" name="from" placeholder="From" >
            <input class="border border-1 p-3 rounded-md" type="text" name="to" placeholder="to">
            <input class="border border-1 p-3 rounded-md" type="number" name="nbr-of-seats" placeholder="Number of seats">
            <input class="border border-1 p-3 rounded-md" type="datetime-local" name="depart-time" placeholder="Depart time">
            <input class="border border-1 p-3 rounded-md" type="datetime-local" name="arrival-time" placeholder="Arrival time">
            <input class="border border-1 p-3 rounded-md" type="number" name="price" placeholder="Price">
        </div>
        <div class="flex justify-end mt-4">
            <button class="border p-3 rounded-md font-semibold text-white bg-cyan-600" type="submit">Submit</button>
        </div>
    </div>
</form>

<%@include file="/admin/layout/footer.jsp" %>