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
            <form action="/saveNewProduct" method="post">
                <div class="form-group">
                    <label for="name">Name:</label><br>
                    <input type="text" class="form-control" id="name" placeholder="Only one letter (X)" name="name"><br>
                </div>
                 <div class="form-group">
                     <label for="price">Price by one:</label><br>
                     <input type="text" class="form-control" id="price" placeholder="3.25" name="price"><br>
                 </div>
                 <div class="form-group">
                     <label for="promotionId">Promotion ID:</label><br>
                     <input type="text" class="form-control" id="promotionId" placeholder="1" name="promotionId"><br>
                 </div>
                    <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>