<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
         <c:import url="${contextPath}/WEB-INF/html/header.jsp"/>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/html/navibar.jsp"/>
        <div class="container">
            <form action="/updatePromotion" method="post">
            <div class="form-group">
                    <label for="id">Promotion id you want to update:</label><br>
                    <input type="text" class="form-control" id="id" placeholder="ID" name="id"><br>
             </div>
                 <div class="form-group">
                     <label for="amount">Amount:</label><br>
                     <input type="text" class="form-control" id="amount" placeholder="3" name="amount"><br>
                 </div>
                 <div class="form-group">
                     <label for="price">Price:</label><br>
                     <input type="text" class="form-control" id="price" placeholder="4.67" name="price"><br>
                 </div>
                    <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>