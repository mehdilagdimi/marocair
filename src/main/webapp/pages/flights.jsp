<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 16-Oct-22
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.marocair.marocair.model.Flight" %>
<%@ include file="../layout/header.jsp" %>

<%
    String url = application.getInitParameter("url");
%>
<div class="p-6">
    <h1 class="text-3xl">Display Flights...</h1>

    <table class="table-auto mt-6">
        <thead>
        <tr class="bg-gray-200">
            <th>#</th>
            <th>From</th>
            <th>Destination</th>
            <th>Depart time</th>
            <th>Arrival time</th>
            <th>Nbr of seats</th>
            <th>Available seats</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="flight" items="${searchedFlights}">
            <tr class="border border-3 border-blue-6 h-15 odd:bg-blue-100">
                <td class="p-3">${flight.getId()}</td>
                <td class="p-3">${flight.getFrom()}</td>
                <td class="p-3">${flight.getTo()}</td>
                <td class="p-3">${flight.getDepartTime()}</td>
                <td class="p-3">${flight.getArrivalTime()}</td>
                <td class="p-3">${flight.getNbrOfSeats()}</td>
                <td class="p-3">${flight.getAvailableSeats()}</td>
                <td class="p-3">${flight.getPrice()}</td>
                <td>
                    <form action="${url}reservation/add-reservation/" method="post">
                        <input name="flight-id" value="${flight.getId()}" hidden>
                        <button type="submit">Reserve</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../layout/footer.jsp" %>