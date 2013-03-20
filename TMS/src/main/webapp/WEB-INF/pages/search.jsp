<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>TMS | Search &middot;</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->

     <link href="<%=request.getContextPath()%>/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
     <script src="<%=request.getContextPath()%>/static/js/jquery-latest.js"></script>
     <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/jquery.autocomplete.css" type="text/css" />
     <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.autocomplete.js"></script>
     <script type="text/javascript"  src="<%=request.getContextPath()%>/static/js/gData.js"></script>
        <style type="text/css">
        #myGroup {visibility:hidden}
                    </style>
        <script type="text/javascript">
        $(document).ready(function(){
        	$("#txtStationFrom").autocomplete(gDarr,{max:35,matchContains: true}).result(function(evt,item){
        		if(item!=null && item.length==1){
        			var tar=item[0].split("-");
        			evt.target.value=item[0];
        			document.forms[0].lccp_src_stncode.value=$.trim(tar[1]);
        		}
        	});
        	$("#txtStationTo").autocomplete(gDarr,{max:35,matchContains:true}).result(function(evt,item){
                        if(item!=null && item.length==1){
                                var tar=item[0].split("-");
                                evt.target.value=item[0];
                                document.forms[0].lccp_dstn_stncode.value=$.trim(tar[1]);
                        }
                });
        });
        </script>

    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-inline {
        max-width: 500px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-search .form-signin-heading,
      .form-search .checkbox {
        margin-bottom: 10px;
      }
      .form-search input[type="text"]      {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
     <link href="<%=request.getContextPath()%>/static/css/bootstrap-responsive.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>



    <![endif]-->

    </head>

  <body>

   <div class="container">

      <form class="form-inline" name="myForm" method="POST">
        <h2 class="form-search-heading">Basic Search</h2>
        <input style="" name="lccp_src_stncode_dis" id="txtStationFrom" onfocus="focustxt=this;" placeholder="From Location"  size="25" value="" maxlength="25" autocomplete="off" type="text"  class="input-medium search-query" required>
        <input type="hidden" name="lccp_src_stncode" value="">
        <input style="" name="lccp_dstn_stncode_dis" id="txtStationTo" onfocus="focustxt=this;" size="25" placeholder="To Location" value="" maxlength="25" autocomplete="off" type="text"  class="input-medium search-query" required >
         <input type="hidden" name="lccp_dstn_stncode" value="">
          <button type="submit" class="btn">Search</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
