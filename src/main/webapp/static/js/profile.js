$(document).ready(function () {
        var date_input=$('.date'); //our date input has the name "date"
        console.log(date_input.attr("type"));
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        var options={
            format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoClose: true,
        };

        date_input.datepicker(options);

})