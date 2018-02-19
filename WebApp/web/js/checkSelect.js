

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
  
  
    $.ajax({
                url : 'change', // Your Servlet mapping or JSP(not suggested)
                data :{result:result}, 
                type : 'POST',
                async: true,
                dataType : 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
                success : function(data){
                   $('.cacca').empty().end();
                    var i=0;
                    
                    $('.cacca').html(data).end().trigger('chzen:updated');
                    
                    $(".chzn-select").multipleSelect("refresh");
                /*while(i<data["len"]){
                   $('.chzn-select').innerHTML = "<option value="+JSON.parse(data["cdl"]).id+">"+JSON.parse(data["cdl"]).nome+"</option>";
                   i++;
               }*/
               /*while(i<data["len"]){
                   $('.chzn-select').append("<option value="+(JSON.parse(data["cdl"])).id+">"+(JSON.parse(data["cdl"])).nome+"</option>").end().trigger('chzen:updated');
                   i++;
               }
                $("#special-cazzafà").multipleSelect({
                placeholder: "Seleziona i cdl",
                width: 250,
                filter: true,


            });*/
               
                /*while(i<data["len"]){
                    var o = new Option(JSON.parse(data.corso).nome_it, JSON.parse(data.corso).id);
                    /// jquerify the DOM object 'o' so we can use the html method
                    $(o).html(JSON.parse(data.corso).nome_it);
                    if(i<data.len){
                        $(".chzn-select").append(o).end();
                    }
                    else{
                        $(".chzn-select").append(o).end().trigger('chzen:updated');
                    }
                    i++;
                } */   
                    /*$.each(data, function (data) {
                        $('.chzn-select').append($('<option>', { 
                            value: JSON.parse(data.cdl)["id"],
                            text : data.cdl.nome 
                        }));
                    });*/
           }
                
            });
}