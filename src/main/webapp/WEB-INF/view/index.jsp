<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="it">

<body>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active"
             style="background-image: url('https://thenypost.files.wordpress.com/2017/02/car-rental1.jpg?quality=90&strip=all&w=618&h=410&crop=1')">
            <div class="carousel-caption d-none d-md-block">
                <h3>Facile e veloce, Basta un click</h3>
                <p>Il nostro sistema ti consente di noleggiare l'auto che preferisci in pochi semplici passi</p>
            </div>
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item"
             style="background-image: url('https://sx-content-labs.sixt.io/thirdlight/seo/branches/content_germany_171016_mercedes_glc_20_15.jpg')">
            <div class="carousel-caption d-none d-md-block">
                <h3>La tua soddisfazione al primo posto</h3>
                <p>Puntiamo ad offrire un servizio sempre migliore in modo da soddisfare tutte le esigenze dei
                    nostri clienti</p>
            </div>
        </div>
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item"
             style="background-image: url('http://www.autoaziendalimagazine.it/wp-content/uploads/2013/04/image17.png')">
            <div class="carousel-caption d-none d-md-block">
                <h3>La nostra flotta</h3>
                <p>Abbiamo una flotta di auto sempre piu numerosa, periodicamete revisionata e in continua
                    evoluzione</p>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>


<!-- Page Content -->
<div class="container">

    <c:if test="${utente.ruolo.descrizione=='Customer'}">
        <h4 class="my-4 text-center">Prenota ora la tua auto</h4>

        <!-- Selezione date prenotazione -->

        <div class="row">
            <div class="bootstrap-iso col-lg-12">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-lg-12">
                            <!-- Form code begins -->
                            <form action="<spring:url value="/cars/getAvailable"/>" method="get">
                                <div class="form-group d-inline-block col-lg-9"> <!-- Date input -->
                                    <div class="input-group input-daterange">
                                            <%-- <div class="input-group-addon"> Da </div>--%>
                                        <input class="form-control" value="" name="dataInizio">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text far fa-calendar-alt"></div>
                                        </div>
                                        &emsp;
                                        &emsp;
                                            <%--  <div class="input-group-addon"> A </div>--%>
                                        <input type="text" class="form-control" value="" name="dataFine">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text far fa-calendar-alt"></div>
                                        </div>
                                    </div>
                                </div>
                                &emsp;
                                <div class="form-group col-lg-2 d-inline"> <!-- Submit button -->
                                    <button class="btn btn-primary " type="submit"
                                            style="margin-bottom: 5px;">
                                        Prenota
                                    </button>
                                </div>
                            </form>
                            <!-- Form code ends -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${utente.ruolo.descrizione=='Admin'}">
        <br>
        <br>
        <div class="row">
            <div class="table-responsive">
                <table class="table table-borderless table-hover table-sm">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Cognome</th>
                        <th scope="col">Veicolo prenotato</th>
                        <th scope="col">Targa</th>
                        <th scope="col">Data Inizio</th>
                        <th scope="col">Data Fine</th>
                        <th scope="col">Data Prenotazione</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${prenotazioniInAttesa}" var="book">
                        <tr>
                            <td>${book.utente.nome}</td>
                            <td>${book.utente.cognome}</td>
                            <td>${book.veicolo.costruttore} ${book.veicolo.modello}</td>
                            <td>${book.veicolo.targa}</td>
                            <td>${book.dataInizio}</td>
                            <td>${book.dataFine}</td>
                            <td>${book.dataPrenotazione}</td>
                            <td>
                                <form action="/booking/action" method="post">
                                    <input hidden value="${book.id}" name="bookingId">
                                    <button type="submit" value="APPROVED" name="state"
                                            class="btn btn-primary" id="button1"> Approve
                                    </button>
                                    <button type="submit" value="REJECTED" name="state"
                                            class="btn btn-danger" id="button2"> Reject
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <hr>
        <br>
        <br>
        <div class="row">
            <div class="table-responsive">
                <table class="table table-borderless table-hover table-sm">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Cognome</th>
                        <th scope="col">Veicolo prenotato</th>
                        <th scope="col">Targa</th>
                        <th scope="col">Data Inizio</th>
                        <th scope="col">Data Fine</th>
                        <th scope="col">Data Prenotazione</th>
                        <th scope="col">Stato</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${storicoPrenotazioni}" var="history">
                        <tr>
                            <td>${history.utente.nome}</td>
                            <td>${history.utente.cognome}</td>
                            <td>${history.veicolo.costruttore} ${book.veicolo.modello}</td>
                            <td>${history.veicolo.targa}</td>
                            <td>${history.dataInizio}</td>
                            <td>${history.dataFine}</td>
                            <td>${history.dataPrenotazione}</td>
                            <td>${history.stato}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </c:if>

    <hr>
    <br>
</div>

<!-- /.container -->

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
        src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/static/js/datepicker.js"/>"></script>

</body>

</html>
