jQuery(document).ready(function(){
    jQuery("#searchResults").hide();

    jQuery("#search").click(function(){
      alert("Searching");

      jQuery.ajax({
      type : 'POST',
      url:"localhost:8080/Sample/search.do",
      success:function(data){
      alert("data" + data);
      }


    });
    jQuery("#searchResults").show();
});
});

