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
            <form action="/saveNewPromotion" method="post">
                <div class="form-group">
                    <label for="amount">Amount:</label><br>
                    <input type="text" class="form-control" id="amount" placeholder="5" name="amount"><br>
                </div>
                 <div class="form-group">
                     <label for="price">Promotion price:</label><br>
                     <input type="text" class="form-control" id="price" placeholder="5.25" name="price"><br>
                 </div>
                    <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>