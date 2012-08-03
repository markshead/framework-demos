<!DOCTYPE html>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <jsp:include page='../includes/common_includes.jsp'/>
    </head>

    <body>
        <jsp:include page='../includes/header.jsp'/>

        <h2>Students</h2>
        <ol>
            <c:forEach var='student' items='${students}'>
                <li>${student.firstName} ${student.lastName} (${fn:length(student.enrolledCourses)})</li>
            </c:forEach>
        </ol>

        <h2>Courses</h2>
        <ol>
            <c:forEach var='course' items='${courses}'>
                <li>${course.name}</li>
            </c:forEach>
        </ol>

        <jsp:include page='../includes/footer.jsp'/>
    </body>
</html>