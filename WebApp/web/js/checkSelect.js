

function CheckSelect(select){
  var result = [];
  var options = select && select.options;
  var opt;

  for (var i=0, iLen=options.length; i<iLen; i++) {
    opt = options[i];

    if (opt.selected) {
      result.push(opt.value);
    }
  }
  if(result>0){
  
    $.ajax({
                url : 'change', // Your Servlet mapping or JSP(not suggested)
                data :{result:result}, 
                type : 'POST',
                async: true,
                dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
                success : function(data){
                   $('.cacca').empty().end();
                    
                    $('.cacca').html(data).end().trigger('chzen:updated');
                    
                    $(".chzn-select").multipleSelect("refresh");
                
                }
                
            });
        }
        else{
            $('.cacca').empty().end();
            $('.cacca').html("<select class='chzn-select' name='modulo' id='special-cazzafà' multiple></select>").end().trigger('chzen:updated');
            $(".chzn-select").multipleSelect("refresh");
        }
}