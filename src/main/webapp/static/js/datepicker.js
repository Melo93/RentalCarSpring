$(document).ready(function () {
    var today = new Date();

    $('.input-daterange').datepicker({
        format: 'yyyy-mm-dd',
        startDate:today
    });

})

