

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
  
  alert(result);
    $.ajax({
                url : 'change', // Your Servlet mapping or JSP(not suggested)
                data :{result:result}, 
                type : 'POST',
                async: true,
                dataType : 'json', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
                success : function(data){
                    $('.chzn-select').empty().end().trigger('chzen:updated');
                    var i=0;
                /*while(i<data["len"]){
                   $('.chzn-select').innerHTML = "<option value="+data["cdli"].id+">"+data["cdli"].nome+"</option>";
               }*/
                    alert(data.len);
                while(i<data["len"]){
                    var o = new Option(data.nome_it, data.id);
                    /// jquerify the DOM object 'o' so we can use the html method
                    $(o).html(data.nome_it);
                    if(i<data.len){
                        $(".chzn-select").append(o).end();
                    }
                    else{
                        $(".chzn-select").append(o).end().trigger('chzen:updated');
                    }
                    i++;
                }    
                /*    $.each(data, function (data) {
                        $('.chzn-select').append($('<option>', { 
                            value: JSON.parse(data.cdl)["id"],
                            text : data.cdl.nome 
                        }));
                    });*/
           }
                
            });
}