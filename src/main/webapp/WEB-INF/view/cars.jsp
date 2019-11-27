<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h3 class="mt-5 mb-1">Le nostre Autovetture</h3>

    <ol class="breadcrumb">
    </ol>

    <!-- Project One -->
    <c:forEach items="${cars}" var="car">
    <div class="row">
      <div class="col-md-5">
        <a href="#">
          <img class="img-fluid rounded mb-3 mb-md-0" src="<c:url value="${car.urlImg}"/>" alt="">
        </a>
      </div>
      <div class="col-md-7">
        <h3>${car.costruttore} ${car.modello}</h3>
        <div class="row">
          <ul class="list-group list-group-horizontal col-lg-auto">
            <li class="list-group-item"><label class="font-weight-bold">Immatricolazione: </label> ${car.annoCostruzione}</li>
            <li class="list-group-item"><label class="font-weight-bold">Tipologia: </label> ${car.tipologia.tipologia}</li>
          </ul>
        </div>
        <div class="row">
          <ul class="list-group list-group-horizontal col-lg-auto">
            <li class="list-group-item"><label class="font-weight-bold">Alimentazione: </label> ${car.alimentazione}</li>
          </ul>
        </div>
        <div class="row">
          <ul class="list-group list-group-horizontal col-lg-auto">
            <li class="list-group-item"><label class="font-weight-bold">Cilindrata: </label> ${car.cilindrata} CC</li>
            <li class="list-group-item"><label class="font-weight-bold">Cavalli: </label> ${car.cavalli} CV</li>
          </ul>
        </div>
        <div class="row float-right">
          <ul class="list-group list-group-horizontal pull col-lg-auto">
            <li class="list-group-item" style="font-size: 20pt" ><label class="font-weight-bold">Prezzo: </label> ${car.prezzo} $</li>
          </ul>
        </div>
      </div>
    </div>
    <!-- /.row -->
    <hr>
    </c:forEach>

  </div>
  <!-- /.container -->


</body>

</html>
