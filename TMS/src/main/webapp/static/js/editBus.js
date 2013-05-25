
function loadDetails() {

var url = "/Sample/admin/updateBus?bus="+$("#bus").val();
window.open(url,'Update Bus Details','width=600,height=400,toolbar=no,location=yes,directories=no,status=yes,menubar=no,scrollbars=yes,copyhistory=yes,resizable=yes');


}

function loadConductorDetails() {
    var url = "/Sample/admin/updateConductor?c="+$("#cond").val();
    window.open(url,'Update Bus Details','width=600,height=400,toolbar=no,location=yes,directories=no,status=yes,menubar=no,scrollbars=yes,copyhistory=yes,resizable=yes');


}

 function loadRouteDetails()
 {
var url = "/Sample/admin/removeRoute?route="+$("#route").val();
TINY.box.show({iframe:url,boxid:'',width:550,height:550,fixed:false,maskid:'bluemask',maskopacity:40,closejs:function(){closeJS()}});
alert(url);
 }

function loadRouteUpdateDetails()
{
var url = "/Sample/admin/updateRoute?route="+$("#route").val();
TINY.box.show({iframe:url,boxid:'',width:550,height:550,fixed:false,maskid:'bluemask',maskopacity:40,closejs:function(){closeJS()}});
alert(url);

}



