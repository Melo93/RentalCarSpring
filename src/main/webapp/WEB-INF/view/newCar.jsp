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
                        <form:form method="post" action="/cars/new" modelAttribute="newCar">
                            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Costruttore</label>
                                    <form:input type="text" class="form-control"
                                                path="costruttore"/>
                                    <form:errors path="costruttore" cssClass="text-danger"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Modello</label>
                                    <form:input type="text" class="form-control" path="modello"/>
                                    <form:errors path="modello" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Anno di Immatricolazione</label>
                                    <form:input type="text" class="form-control" path="annoCostruzione"/>
                                    <form:errors path="annoCostruzione" cssClass="text-danger"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Targa</label>
                                    <form:input type="text" class="form-control" path="targa"/>
                                    <form:errors path="targa" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Cilindrata</label>
                                    <form:input type="text" class="form-control" path="cilindrata"/>
                                    <form:errors path="cilindrata" cssClass="text-danger"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Cavalli</label>
                                    <form:input type="text" class="form-control" path="cavalli"/>
                                    <form:errors path="cavalli" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Url Immagine</label>
                                <form:input type="text" class="form-control" path="urlImg"/>
                                <form:errors path="urlImg" cssClass="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label>Prezzo</label>
                                <form:input type="text" class="form-control" path="prezzo"/>
                                <form:errors path="prezzo" cssClass="text-danger"/>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <fieldset>
                                        <label>Alimentazione Veicolo: </label>
                                        <br>
                                        <form:select path="alimentazione" id="select" name="role">
                                            <form:option value="Diesel" selected="selected">Diesel</form:option>
                                            <form:option value="Benzina">Benzina</form:option>
                                            <form:option value="Ibrida">Ibrida</form:option>
                                            <form:option value="GPL">GPL</form:option>
                                            <form:option value="Metano">Metano</form:option>
                                        </form:select>
                                    </fieldset>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <fieldset>
                                        <label>Tipologia Veicolo: </label>
                                        <br>
                                        <form:select path="tipologia" id="select" name="role">
                                            <form:option value="City Car" selected="selected">City Car</form:option>
                                            <form:option value="SUV">SUV</form:option>
                                            <form:option value="Crossover">Crossover</form:option>
                                            <form:option value="Monovolume">Monovolume</form:option>
                                            <form:option value="Station Wagon">Station Wagon</form:option>
                                            <form:option value="Furgone">Furgone</form:option>
                                            <form:option value="Sportiva">Sportiva</form:option>
                                            <form:option value="Berlina">Berlina</form:option>
                                        </form:select>
                                    </fieldset>
                                </div>
                            </div>
                            <input type="submit" class="btn btn-primary" value="Modifica">
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<hr>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment.min.js"></script>

</body>
</html>
