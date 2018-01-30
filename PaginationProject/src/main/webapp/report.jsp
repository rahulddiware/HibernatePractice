
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<c:choose>
  <c:when test="${reportData ne null }">
     <table border="1"  width="100"   height="200" style="color:red" bgcolor="cyan">
       <tr><th>EMPNO</th><th>ENAME</th><th>JOB</th><th>SAL</th></tr>
       <c:forEach var="reportData" items="${reportData}">
           <tr>
             <td>${dto.empno}</td>
             <td>${dto.ename}</td>
             <td>${dto.job}</td>
             <td>${dto.sal}</td>
          </tr>
       </c:forEach>
     </table>
  </c:when>
  <c:otherwise>
       Records not found
  </c:otherwise>
</c:choose>
<br><br>
<!-- display page numbers-->
<c:if test="${pageNo ne 1}">
   <a href="controller?pageNo=${pageNo-1}&pageSize=${pageSize}">previous</a>
</c:if> 
<c:forEach var="i" begin="1" end="${pagesCount}" step="1" >
    <a href="controller?pageNo=${i}&pageSize=${pageSize}">[${i}] </a>&nbsp;&nbsp;&nbsp;
</c:forEach>
<c:if test="${pageNo ne pagesCount}">
   <a href="controller?pageNo=${pageNo+1}&pageSize=${pageSize}">next</a>
</c:if> 
<br><br>
<a href="index.jsp">home</a>

