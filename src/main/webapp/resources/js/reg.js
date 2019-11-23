$(document.valdi(function () {

    let strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    let mediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");

    let validation = $('#passwd').val();

    let validate = function (value) {
        if (strongRegex.test(validation)) {
            $('#passwd').style.css("back")
            this["background-color"] = "green";
        } else if (mediumRegex.test(validation)) {
            $('#passwd').css("background-color", "orange");
            this["background-color"] = "orange";
        } else {

            $('#passwd').style.css("background-color", "red");
            this["background-color"] = "red";
        }

        $('#counter').text(validation);

    }
}))





