<%@include file="../layout/header.jsp" %>
    <%
        String url = application.getInitParameter("url");
    %>
    <div class="border border-2 border-green-300 p-6">
        <h1 class="text-4xl">[ADMIN] Main page...</h1>
        <p class="text-gray-500 text-3xl mt-3">Links:</p>
        <a class="mt-3 block text-blue-600 underline" href="<%= url+"admin/add-flight.jsp" %>">Add flight</a>
        <a class="mt-3 block text-blue-600 underline" href="<%= url+"flight" %>">Display flights</a>
    </div>
<%@include file="../layout/footer.jsp" %>
        