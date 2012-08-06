<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri='http://www.springframework.org/tags' prefix="spring" %>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a shape="rect" data-target=".nav-collapse"
               data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a href="<spring:url value='/'/>" class="brand">spring-mvc demo</a>

            <div class="nav-collapse">
                <ul class="nav">
                    <li class="">
                        <a href="<spring:url value='/add/'/>">
                            Add Students And Courses
                        </a>
                    </li>

                    <li class="">
                        <a href="<spring:url value='/list/'/>">
                            List Students And Courses
                        </a>
                    </li>

                    <li><a shape="rect" href="<spring:url value='/console/'/>">
                        DB Console
                    </a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="container">

