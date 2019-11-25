document.addEventListener("DOMContentLoaded", () => {



    let minRegex = new RegExp("(^(?=.*\\d)(?=.*[a-z]){8,})");
    let maxRegex = new RegExp("(^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$)");





    let regvalue = document.getElementById("passwd");


    regvalue.onkeyup = function useValue() {

        let reg = document.getElementById('passwd').value;


        if (reg.match(maxRegex)) {

            regvalue.style.backgroundColor = '#00ff50';
            console.log("green")
            console.log(reg)
        }
        if (reg.match(minRegex) && !reg.match(maxRegex)) {
            regvalue.style.backgroundColor = '#ff5500';
            console.log("orange")
            console.log(reg)
        }  if(!reg.match(minRegex) && !reg.match(maxRegex)){

            regvalue.style.backgroundColor = '#ff272c';
            console.log("red")
            console.log(reg)

        }

    }






})