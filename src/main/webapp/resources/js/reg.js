$(function () {
    let register = $('#passd')
    register.html("0/10")
    $("#pass").on("change paste keyup keypress", function (e) {
        register.html($(this).val().length + "/10")
        if($(this).val().length <= 3) {
            register.css("color", "green")
        } else if($(this).val().length < 6) {
            register.css("color", "yellow")
        } else if($(this).val().length >= 6 && $(this).val().length < 10) {
            register.css("color", "red")
        } else {
            register.css("color", "red")
            e.preventDefault()
        }
    })
})