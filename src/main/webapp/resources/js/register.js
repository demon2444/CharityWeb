document.addEventListener("DOMContentLoaded", () => {



    let minRegex = new RegExp("(^(?=.*\\d)(?=.*[a-z]){8,})");
    let maxRegex = new RegExp("(^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$)");


    let passText = document.getElementById('pass');


    let regvalue = document.getElementById("passwd");


    regvalue.onkeyup = function useValue() {


        let password = document.getElementById('passwd').value;
        let password2 = document.getElementById("passwd2").value;



        if (password.match(maxRegex)) {



            regvalue.style.backgroundColor = '#00ff50';
            passText.style.cssText = "font-size: 2em; color: #00ff50";
            passText.innerText =  'Hasło spełnia wszystkie założenia';


            console.log("green");
            console.log(password);
        }
        if (password.match(minRegex) && !password.match(maxRegex)) {
            regvalue.style.backgroundColor = '#ff6600';
            passText.style.cssText = "font-size: 2em; color: #ff6600";
            passText.innerText = 'Hasło powinno mieć jeszcze jedną dużą jedną małą literę i znak specjalny';


            console.log("orange");
            console.log(password);
        }  if(!password.match(minRegex) && !password.match(maxRegex)){

            regvalue.style.backgroundColor = '#ff272c';
            passText.style.cssText = "font-size: 2em; color: #ff272c";
            passText.innerText = 'Hasło musi mieć conajmniej 8 znaków, literę i cyfrę';


            console.log("red");
            console.log(password);

        }

        if(password !== password2) {
            console.log("Hasła nie są identyczne")
        }

    }






})