$(document).ready(function () {
    consultar();
});


$('#selectSchedule').on('change', function (e) {

    id = $("#selectSchedule option:selected").val();
    name = $("#selectSchedule option:selected").text();

    consultarRutaCliente(id);




});


function consultar() {
    $.ajax({
        url: "http://localhost:8080/consult",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: 'text',
        success: function (resp) {

            var jsonResp = JSON.parse(resp);


            $("#selectNames").empty();
            $('#selectSchedule').append('<option value="0" selected disabled="disabled" class="col-6">Seleccione un cliente</option>');
            for (var i = 0; i < jsonResp.length; i++) {
                $('#selectSchedule').append('<option value="' + jsonResp[i][0] + '">' + jsonResp[i].split(',')[1] + '</option>');
            }


        },
        error: function () {
            alert("Error");
        }
    });
}

function consultarRutaCliente(id) {
    $.ajax({
        url: "http://localhost:8080/consultPath",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: 'text',
        data: id,
        success: function (resp) {

            var jsonResp = JSON.parse(resp);

            console.log(jsonResp);
            separarComas = jsonResp[0].split(',')[1];
            separarServidor = separarComas.split('-');

            
            
            $("#infoServidor").empty();
            $('#infoServidor').append(separarComas);

            $("#infoRuta").empty();
            $('#infoRuta').append('<option">' + jsonResp[0].split(',')[0] + '</option>');





        },
        error: function () {
            alert("Error");
        }
    });
}





