document.addEventListener("DOMContentLoaded", () => {

    console.log("bbbb")


    let minRegex = new RegExp("(^(?=.*\\d)(?=.*[a-z]){8,})");
    let maxRegex = new RegExp("(^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$)");

    let strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    let mediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");




    let regvalue = document.getElementById("passwd");


    regvalue.onkeyup = function useValue() {

        let reg = document.getElementById('passwd').value;


        if (reg.match(maxRegex)) {

            regvalue.style.backgroundColor = '#00ff50';
            console.log("green")
        }
        if (reg.match(minRegex) && !reg.match(maxRegex)) {
            regvalue.style.backgroundColor = '#ff5500';
            console.log("orange")
        }  if(!reg.match(minRegex) && !reg.match(maxRegex)){

            regvalue.style.backgroundColor = '#ff272c';
            console.log("red")
            console.log(reg)

        }

    }






})