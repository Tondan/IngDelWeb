

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
                    alert("Cuiao");
                    var i=0;
                    alert(data["len"]);
                    
                    $('.chzn-select').empty().end().trigger('chzen:updated');
                    /*while(e.firstChild){
                        e.removeChild(e.firstChild);
                    }
                    
            /*        alert("eya");
                    i=0;
                while(i<data["len"]){
                   alert("Ciao");
                   $this.getElementById('ch').innerHTML = "<option value="+data["cdli"].id+">"+data["cdli"].nome+"</option>";
               }*/
           }
                
            });
}