<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${intestazione}</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/static/css/modern-business.css"/>" rel="stylesheet">

    <!-- Bootstrap Date-Picker Plugin -->
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>">

    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker.min.css"/>">
    <!-- icon -->
    <script src="<c:url value="https://kit.fontawesome.com/3b5d613cc7.js"/>" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/"/>" style="font-size: 24pt;"><spring:message
                code="header.navbar.titolo.label"/></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <c:if test="${utente!=null}">
            <div class="collapse navbar-collapse" id="navbarResponsive1">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<spring:url value="/cars/getAll"/>"><spring:message
                                code="header.navbar.showCar.label"/></a>
                    </li>
                    <c:if test="${utente.ruolo.descrizione=='Admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="<spring:url value="/user/newForm"/>"><spring:message
                                    code="header.navbar.newUser.label"/></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<spring:url value="/cars/newForm"/>"><spring:message code="header.navbar.newCar.label"/></a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </c:if>

        <div class="collapse navbar-collapse" id="navbarResponsive2">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <c:if test="${utente==null}">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <spring:message code="header.navbar.login.label"/>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" style="padding: 15px; padding-bottom: 10px;">
                                <%--@elvariable id="loginDTO" type="com.si2001.rentalcarspring.entities.dto.LoginDTO"--%>
                            <form:form class="form-horizontal" method="POST" modelAttribute="loginDTO"
                                       action="/user/login">
                                <form:input path="username" class="form-control login" type="text" name="username"
                                            placeholder="Username"/>
                                <form:errors path="username" cssClass="alert alert-danger" element="div"/>
                                <form:input path="password" class="form-control login" type="password" name="password"
                                            placeholder="Password"/>
                                <form:errors path="password" cssClass="alert alert-danger" element="div"/>
                                <c:if test="${not empty errorLogin}">
                                    <label class="alert alert-danger">${errorLogin}</label>
                                </c:if>
                                <input class="btn btn-primary" type="submit"/>
                            </form:form>
                        </div>
                    </c:if>
                    <c:if test="${utente!=null}">
                        <a class="nav-link dropdown-toggle" id="navbarDropdownBlog2" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                                ${utente.nome} ${utente.cognome}
                        </a>
                        <div class="dropdown-menu dropdown-menu-center" aria-labelledby="navbarDropdownBlog">
                            <a class="dropdown-item" href="<spring:url value="/user/logout"/>">logout</a>
                            <form:form action="/user/profile" method="get">
                                <input class="dropdown-item" type="submit" value="edit"/>
                            </form:form>
                        </div>
                    </c:if>
                </li>
            </ul>
            <%-- <li class="nav-item">
                 <a class="nav-link" href="about.html">About</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="services.html">Services</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link" href="profile.jsp">Contact</a>
             </li>
             <li class="nav-item dropdown">
                 <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                     Portfolio
                 </a>
                 <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                     <a class="dropdown-item" href="cars.jsp">1 Column Portfolio</a>
                     <a class="dropdown-item" href="availableCars.jsp">2 Column Portfolio</a>
                     <a class="dropdown-item" href="newCar.jsp">3 Column Portfolio</a>
                     <a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
                     <a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
                 </div>
             </li>--%>


            <%-- <li class="nav-item dropdown">
                 <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog2" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                     Other Pages
                 </a>
                 <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                     <a class="dropdown-item" href="full-width.html">Full Width Page</a>
                     <a class="dropdown-item" href="sidebar.html">Sidebar Page</a>
                     <a class="dropdown-item" href="newUser.jsp">FAQ</a>
                     <a class="dropdown-item" href="404.html">404</a>
                     <a class="dropdown-item" href="pricing.html">Pricing Table</a>
                 </div>
             </li>--%>
        </div>
    </div>
</nav>
<!-- Bootstrap core JavaScript -->
<%--<script type="text/javascript" src="<c:url value="/static/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"/>"></script>--%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>
</body>
