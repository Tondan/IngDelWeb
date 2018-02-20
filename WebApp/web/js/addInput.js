

$("#attento").on("change", function(){  
    var fileCount = this.files.length;


if(fileCount>5){
alert("troppe immissioni");}
else{

    for(var i=0; i<fileCount; i++){

        

    }

}

/*
var BstrapModal = function (title, body, buttons) {
    var title = title || "Lorem Ipsum History", body = body || 
    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
    when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
    It has survived not only five centuries, but also the leap into electronic typesetting, 
    remaining essentially unchanged.", buttons = buttons || [{ Value: "CLOSE", 
    Css: "btn-primary", Callback: function (event) { BstrapModal.Close(); } }];
    var GetModalStructure = function () {
        var that = this;
        that.Id = BstrapModal.Id = Math.random();
        var buttonshtml = "";
        for (var i = 0; i < buttons.length; i++) {
            buttonshtml += "<button type='button' class='btn " + 
            (buttons[i].Css||"") + "' name='btn" + that.Id + 
            "'>" + (buttons[i].Value||"CLOSE") + 
            "</button>";
        }
        return "<div class='modal fade' name='dynamiccustommodal' 
        id='" + that.Id + "' tabindex='-1' role='dialog' 
        data-backdrop='static' data-keyboard='false' aria-labelledby='" + 
        that.Id + "Label'><div class='modal-dialog'>
        <div class='modal-content'><div class='modal-header'>
        <button type='button' class='close modal-white-close' 
        onclick='BstrapModal.Close()'><span aria-hidden='true'>&times;
        </span></button><h4 class='modal-title'>" + title + 
        "</h4></div><div class='modal-body'>
        <div class='row'><div class='col-xs-12 col-md-12 col-sm-12 col-lg-12'>" + 
        body + "</div></div></div><div class='modal-footer bg-default'>
        <div class='col-xs-12 col-sm-12 col-lg-12'>" + buttonshtml + 
        "</div></div></div></div></div>";
}();
    BstrapModal.Delete = function () {
        var modals = document.getElementsByName("dynamiccustommodal");
        if (modals.length > 0) document.body.removeChild(modals[0]);
    };
    BstrapModal.Close = function () {
        $(document.getElementById(BstrapModal.Id)).modal('hide');
        BstrapModal.Delete();
    };    
    this.Show = function () {
        BstrapModal.Delete();
        document.body.appendChild($(GetModalStructure)[0]);
        var btns = document.querySelectorAll("button[name='btn" + BstrapModal.Id + "']");
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", buttons[i].Callback || BstrapModal.Close);
        }
        $(document.getElementById(BstrapModal.Id)).modal('show');
    };
};


});

*/

/*
var counter = 1;
var limit = 5;

function addInput(divName){
     if (counter == limit){
          alert("You have reached the limit of adding " + counter + " inputs");
     }
    
     else {
          var newdiv = document.createElement('div');
         
          newdiv.innerHTML = "<div class='col-md-6'>" + "<h5>Nome materiale</h5>" + (counter + 1) + 
          "<input type='text' class='form-control style_2' placeholder='nome' name='nomem[]'>" + "</div>" +  "<div class='col-md-6'>" + "<h5>Upload materiale</h5>"+
         + "<input type='file' name='linkm[]' onchange='ValidateCurr(this)'/>" + "</div>" + "<div class='col-md-12'>" + "<h5>Descrizione materiale IT</h5>" +
         "<textarea rows='5' name='descrizioneitm[]' class='tinymce1'></textarea>"+ "<h5>Descrizione materiale EN</h5>"+ "<textarea rows='5' name='descrizioneenm[]' class='tinymce1'></textarea>"
         + "</div>"
          
         document.getElementById(divName).appendChild(newdiv);
         counter++;
        

         tinyMCE.execCommand("mceRepaint");
     }
}
*/

