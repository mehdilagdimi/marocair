<%@include file="../layout/header.jsp" %>
<h1>Add flight...</h1>
<%
    String url = application.getInitParameter("url");
%>
<form action="<%=url%>/flight" method="post" class="bg-slate-300 p-6">
    <input class="border border-2 p-3" type="text" name="from" placeholder="From" >
    <input class="border border-2 p-3" type="text" name="to" placeholder="to">
    <input class="border border-2 p-3" type="number" name="nbr-of-seats" placeholder="Number of seats">
    <input class="border border-2 p-3" type="datetime-local" name="depart-time" placeholder="Depart time">
    <input class="border border-2 p-3" type="datetime-local" name="arrival-time" placeholder="Arrival time">
    <input class="border border-2 p-3" type="number" name="price" placeholder="Price">
    <button class="border border-2 p-3" type="submit">Submit</button>
</form>
<%@include file="../layout/footer.jsp" %>