<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<!DOCTYPE html>
<html lang="it">

<body>

<hr>
<div class="title" style="margin-left: 10%;">
    <a class="title" style="font-size: 22pt;">Modifica Profilo</a>
</div>
<hr>
<div class="container">
    <div class="row">
        <div class="bootstrap-iso col-lg-12">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12 col-lg-12">
                        <!-- Form code begins -->
                        <form:form method="post" action="/user/edit" modelAttribute="editUtente">
                            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Username</label>
                                    <form:input type="text" class="form-control"
                                                path="username" disabled="true"/>
                                    <form:hidden path="username"/>
                                    <form:errors path="username" cssClass="text-danger"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Password</label>
                                    <form:input type="password" class="form-control" path="password"/>
                                    <form:errors path="password" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Nome</label>
                                    <form:input type="text" class="form-control" path="nome"/>
                                    <form:errors path="nome" cssClass="text-danger"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Cognome</label>
                                    <form:input type="text" class="form-control" path="cognome"/>
                                    <form:errors path="cognome" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Codice Fiscale</label>
                                <form:input type="text" class="form-control" path="codiceFiscale"/>
                                <form:errors path="codiceFiscale" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label>Data di Nascita</label>
                                <input class="form-control date" id="dataDiNascita" name="dataDiNascita"
                                       value="${editUtente.dataDiNascita}"
                                       placeholder="${editUtente.dataDiNascita}" type="text"/>
                                <form:hidden path="dataDiNascita"/>
                                <form:errors path="dataDiNascita" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label>Tipologia Account</label>
                                <form:input path="ruolo.descrizione"
                                            class="form-control" disabled="true"/>
                                <form:hidden path="ruolo.descrizione"/>
                            </div>
                            <input type="submit" class="btn btn-primary" value="Modifica">
                        </form:form>
                        <!-- Form code ends -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>

</div>

<script type="text/javascript" src="<c:url value="/static/js/profile.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"/>"></script>
</body>
</html>
