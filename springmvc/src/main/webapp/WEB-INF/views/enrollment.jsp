<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <jsp:include page='../includes/common_includes.jsp'/>
    </head>

    <body>
        <jsp:include page='../includes/header.jsp'/>

        <h2>${student.firstName}'s classes</h2>
        <hr/>
        <h3>Enrolled Courses</h3>
        <ol>
            <c:forEach items='${student.enrolledCourses}' var='course'>
                <spring:url value='/enrollment/cancel/${student.id}/${course.id}' var='cancelLink'/>
                <li>
                        ${course.name}
                    <a href="${cancelLink}">
                        <i class="icon-minus-sign"></i>
                    </a>
                </li>
            </c:forEach>
        </ol>

        <h3>Available Courses</h3>
        <ol>
            <c:forEach items='${coursesList}' var='course'>
                <spring:url value='/enrollment/enroll/${student.id}/${course.id}' var='enrollLink'/>
                <li>
                        ${course.name}
                    <a href="${enrollLink}">
                        <i class="icon-plus-sign"></i>
                    </a>
                </li>
            </c:forEach>
        </ol>

        <jsp:include page='../includes/footer.jsp'/>
    </body>
</html>