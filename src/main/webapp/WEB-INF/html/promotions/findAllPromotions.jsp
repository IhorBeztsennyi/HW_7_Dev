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
         <h3>All products:</h3>
              <div class="container">
                   <table class="table table-hover">
                      <tr>
                          <td>Id</td>
                          <td>Amount</td>
                          <td>Price</td>
                      </tr>
                      <c:forEach items="${promotions}" var="promotion">
                      <tr>
                          <td>
                              <c:out value="${promotion.id}" />
                          </td>
                          <td>
                              <c:out value="${promotion.amount}" />
                          </td>
                          <td>
                              <c:out value="${promotion.price}" />
                          </td>
                      </tr>
                      </c:forEach>
                  </table>
              </div>
         </div>
    </body>
</html>