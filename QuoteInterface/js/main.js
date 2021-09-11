function showLoadingDialog() {
  let $loadingModel = $('#loadingModal');
  // show model
  $loadingModel.modal('show');
}

function hideLoadingDialog() {
  let $loadingModel = $('#loadingModal');
  $loadingModel.modal('hide');
}


(function ($) {
    "use strict";


    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input3').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
            

    /*==================================================================
    [ Chose Radio ]*/
    $("#radio1").on('change', function(){
        if ($(this).is(":checked")) {
            $('.input3-select').slideUp(300);
        }
    });

    $("#radio2").on('change', function(){
        if ($(this).is(":checked")) {
            $('.input3-select').slideDown(300);
        }
    });
    
    /*==================================================================
    [ Validate ]*/
    var pickupPostalCode = $('.validate-input input[name="ppcode"]');
    var deliveryPostalCode = $('.validate-input input[name="dpcode"]');


    $('#quoteForm').on('submit',function(){
        var validated = true;

        if($(pickupPostalCode).val().trim() == ''){
            showValidate(pickupPostalCode);
            validated=false;
        }

        if($(deliveryPostalCode).val().trim() == ''){
            showValidate(deliveryPostalCode);
            validated=false;
        }

        if (validated) {
            // submit form
            let selectedVehicle = $('select[name=vehicle]').val();
            let formData = {
              "pickup_postcode":   pickupPostalCode.val(),
              "delivery_postcode": deliveryPostalCode.val(),
              "vehicle": selectedVehicle
            }
            showLoadingDialog();

            $.ajax({
            url: 'http://localhost:8080/quote',
            type: 'post',
            dataType: 'json',
            contentType : "application/json",
            data: JSON.stringify(formData),
            success: function(data) {
                   setTimeout(hideLoadingDialog, 1000);
                   // ... do something with the data...
                   console.log(data);
                   if (data.price < 0) {
                    alert("Something went wrong! Price not calculated correctly, Try again later!");
                    return;
                   }
                   // format(, , data.vehicle, data.price)
                   let quoteMessage = 'A delivery from ' + data.pickupPostcode + ' to ' + data.deliveryPostcode + ' using a ' + data.vehicle + ' will cost you £' + data.price + '.';
                   $('#quoteMsg').text(quoteMessage)
                }
            });
        }

        event.preventDefault(); 
    });


    $('.validate-form .input3').each(function(){
        $(this).focus(function(){
           hideValidate(this);
       });
    });

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);