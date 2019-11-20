$(function () {
    let counter = $('#counter')
    counter.html("0/100")
    $('#area').on("change paste keyup keypress", function (e) {
        counter.html($(this).val().length + "/10")
        if($(this).val().length <= 3) {
            counter.css("color", "green")
        } else if($(this).val().length < 6) {
            counter.css("color", "yellow")
        } else if($(this).val().length >= 6 && $(this).val().length < 10) {
            counter.css("color", "red")
        } else {
            counter.css("color", "red")
            e.preventDefault()
        }
    })
})