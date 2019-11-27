document.addEventListener("DOMContentLoaded", () => {


    let minRegex = new RegExp("(^(?=.*\\d)(?=.*[a-z]){8,})");
    let maxRegex = new RegExp("(^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$)");


    let passText = document.getElementById('pass');

    let pass2Text = document.getElementById('pass2');

    let regvalue = document.getElementById("passwd");

    let confirmPass = document.getElementById('passwd2');


    regvalue.onkeyup = function useValue() {
        let password = document.getElementById('passwd').value;


        if (password.match(maxRegex)) {


            regvalue.style.backgroundColor = '#00ff50';
            passText.style.cssText = "font-size: 2em; color: #00ff50";
            passText.innerText = 'Hasło spełnia wszystkie założenia';


            console.log("green");
            console.log(password);
        }
        if (password.match(minRegex) && !password.match(maxRegex)) {
            regvalue.style.backgroundColor = '#ff6600';
            passText.style.cssText = "font-size: 2em; color: #ff6600";
            passText.innerText = 'Hasło powinno mieć jeszcze jedną dużą jedną małą literę i znak specjalny';


            console.log("orange");
            console.log(password);
        }
        if (!password.match(minRegex) && !password.match(maxRegex)) {

            regvalue.style.backgroundColor = '#ff272c';
            passText.style.cssText = "font-size: 2em; color: #ff272c";
            passText.innerText = 'Hasło musi mieć conajmniej 8 znaków, literę i cyfrę';


            console.log("red");
            console.log(password);

        }



    }

    confirmPass.onkeyup = function () {

        let password = document.getElementById('passwd').value;
        let password2 = document.getElementById('passwd2').value;


        if (password !== password2 && password2 !== null && password !== null) {
            confirmPass.style.backgroundColor = '#ff272c';
            pass2Text.style.cssText = "font-size: 2em; color: #ff272c";
            pass2Text.innerText = 'Hasła nie są identyczne';
            console.log("Hasła nie są identyczne")
        }

        if (password === password2 && password2 !== null && password !== null) {
            confirmPass.style.backgroundColor = '#00ff50';
            pass2Text.style.cssText = "font-size: 2em; color: #00ff50";
            pass2Text.innerText = 'Hasła są identyczne';
            console.log("Hasła są identyczne")
        }

    }



})