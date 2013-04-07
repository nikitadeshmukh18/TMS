jQuery(document).ready(function(){

   jQuery("#updateBus").hide();
   jQuery("#saveUpdate").hide();
   jQuery("#u_bus_src").hide();
   jQuery("#u_bus_destination").hide();



});

function loadDetails() {


    jQuery("#updateBus").show();
    jQuery("#updateButton").hide();
    jQuery("#saveUpdate").show();
    var busNo = parseInt(jQuery("select#bus").val());


    $("#currentSrc").val(bus);
    $("#currentDestination").val(bus.busDestination);



}