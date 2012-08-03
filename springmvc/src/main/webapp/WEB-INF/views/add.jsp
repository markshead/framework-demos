<!DOCTYPE html>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <jsp:include page='../includes/common_includes.jsp'/>
    </head>

    <body>
        <jsp:include page='../includes/header.jsp'/>

        <form:form class='form-horizontal' action="student" commandName='student'>
            <h1>Add Student</h1>
            <hr/>
            <form:errors/>
            <div class='control-group'>
                <form:label class='control-label' path="firstName">First Name</form:label>
                <div class='controls'>
                    <form:input path="firstName"/>
                </div>
            </div>

            <div class='control-group'>
                <form:label class='control-label' path="lastName">Last Name</form:label>
                <div class='controls'>
                    <form:input path="lastName"/>
                </div>
            </div>

            <div class='form-actions'>
                <button class='btn btn-primary' type='submit'>
                    Save
                </button>
            </div>

        </form:form>

        <form:form class='form-horizontal' action='course' commandName='course'>
            <h1>Add Course</h1>
            <hr/>
            <form:errors/>
            <div class='control-group'>
                <form:label class='control-label' path="name">Course Name</form:label>
                <div class='controls'>
                    <form:input path="name"/>
                </div>
            </div>

            <div class='form-actions'>
                <button class='btn btn-primary' type='submit'>
                    Save
                </button>
            </div>

        </form:form>

        <jsp:include page='../includes/footer.jsp'/>
    </body>
</html>