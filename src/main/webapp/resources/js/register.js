document.addEventListener("DOMContentLoaded", () => {



    let minRegex = new RegExp("(^(?=.*\\d)(?=.*[a-z]){8,})");
    let maxRegex = new RegExp("(^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$)");





    let regvalue = document.getElementById("passwd");


    regvalue.onkeyup = function useValue() {


        let password = document.getElementById('passwd').value;
        let password2 = document.getElementById("passwd2").value;

        if (password.match(maxRegex)) {

            regvalue.style.backgroundColor = '#00ff50';
            console.log("green")
            console.log(reg)
        }
        if (password.match(minRegex) && !password.match(maxRegex)) {
            regvalue.style.backgroundColor = '#ff6600';
            console.log("orange")
            console.log(reg)
        }  if(!password.match(minRegex) && !password.match(maxRegex)){

            regvalue.style.backgroundColor = '#ff272c';
            console.log("red")
            console.log(reg)

        }

        if(password !== password2) {
            console.log("Hasła nie są identyczne")
        }

    }






})