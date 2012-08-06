<%@ taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <jsp:include page='../includes/common_includes.jsp'/>
    </head>

    <body>
        <jsp:include page='../includes/header.jsp'/>

        <p>Welcome to JPA Demo.</p>
        <ul>
          <li><a href="<spring:url value='/add/'/>">Add Students and Courses</a></li>
          <li><a href="<spring:url value='/list/'/>">List Students and Courses</a></li>
        </ul>
        <jsp:include page='../includes/footer.jsp'/>
    </body>
</html>
