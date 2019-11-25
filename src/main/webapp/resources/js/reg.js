$(function () {

    let valu = document.getElementById('#passwd')

    let strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    let mediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");

    let validation = $('#passwd').val();
    let name = $('#nam').val();


        if (strongRegex.test(validation)) {
            $('body').find('#passwd').addClass('regcol3')
            console.log("green")
        } else if (mediumRegex.test(validation)) {
            $('body').find('#passwd').addClass('regcol2')
            console.log("orange")
        } else {

            $('#passwd').addClass('regcol')
            console.log("red")
        }
        console.log("haha")
        console.log(validation)
        console.log(valu)
        console.log(name)

        $('#counter').text(validation);


})




