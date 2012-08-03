<!DOCTYPE html>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <jsp:include page='../includes/common_includes.jsp'/>
    </head>

    <body>
        <jsp:include page='../includes/header.jsp'/>

        <ol>
            <c:forEach items='${students}' var='student'>
                <li>${student.firstName} ${student.lastName} -
                    <a href="<spring:url value='/manage-enrollments/${student.id}'/>">
                        Manage courses (${fn:length(student.enrolledCourses)})
                    </a>
                </li>
            </c:forEach>
        </ol>

        <c:if test='${student != null}'>
            <spring:url value="/manage-enrollments/enroll/${student.id}" var='action'/>
            <form:form class='form-vertical' commandName='student'
                       action='${action}'>
                <div class='control-group'>
                    <form:label path="enrolledCourses">Courses</form:label>
                    <div class='controls'>
                        <form:select path="enrolledCourses" multiple="true" items="${coursesList}" itemLabel="name"
                           itemValue="id"/>
                    </div>
                </div>

                <div class='form-actions'>
                    <button type='submit' class='btn btn-primary'>
                        Save
                    </button>
                </div>
            </form:form>
        </c:if>
        <jsp:include page='../includes/footer.jsp'/>
    </body>
</html>