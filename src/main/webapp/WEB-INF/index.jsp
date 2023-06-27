<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Save Travels</title>
</head>
<body  >
<div class="mx-auto p-2" style="width: 80%">
 <h1 style="color:dodgerblue"> Save Travels</h1>
 <table class="table s align-middle .table-bordered">
     <thead class="table-secondary">
     <tr>
         <th scope="col">Expense</th>
         <th scope="col">Vendor</th>
         <th scope="col">Amount</th>
     </tr>
     </thead>
     <tbody >
     <c:forEach items="${allBudgets}" var="item" >
      <tr>
          <td><c:out value="${item.expense}"></c:out> </td>
          <td><c:out value="${item.vendor}"></c:out> </td>
          <td>$<c:out value="${item.amount}"></c:out> </td>
      </tr>
     </c:forEach>
     </tbody>
 </table>

<h2 style="color:dodgerblue">Add an Expense : </h2>
    <div class="container">
        <form:form action="/expenses" method="post" modelAttribute="travel">
            <p>
                <form:label path="expense">Expense</form:label>
                <form:errors path="expense"/>
                <form:input path="expense"/>
            </p>
            <p>
                <form:label path="vendor">Vendor</form:label>
                <form:errors path="vendor"/>
                <form:input path="vendor"/>
            </p>
            <p>
                <form:label path="amount">Amount</form:label>
                <form:errors path="amount"/>
                <form:input type="text" path="amount"/>
            </p>
            <p>
                <form:label path="description">Description</form:label>
                <form:errors path="description"/>
                <form:input path="description"/>
            </p>
            <input class="btn btn-primary" type="submit" value="Submit"/>
        </form:form>
    </div>
</div>
</body>
</html>
