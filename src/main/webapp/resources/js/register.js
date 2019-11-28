document.addEventListener("DOMContentLoaded", () => {


    let minRegex = new RegExp("(^(?=.*\\d)(?=.*[a-z]){8,})");
    let maxRegex = new RegExp("(^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$)");

    let nameRegex = new RegExp("(^[a-zA-Z]{2,})");
    let emailRegex = new RegExp("(^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$)");


    let passText = document.getElementById('pass');
    let pass2Text = document.getElementById('pass2');
    let firstnameText = document.getElementById('firstText');
    let secondnameText = document.getElementById('secondText');
    let usernameText = document.getElementById('username');

    let regvalue = document.getElementById("passwd");
    let confirmPass = document.getElementById('passwd2');

    let firstname = document.getElementById('firstname');
    let secondname = document.getElementById('secondname');
    let email = document.getElementById('mail');

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
    function validForm(formId, paragraphId, regex){
        formId.onkeyup = function () {
            let name = formId.value;
            if(name.match(regex)){
                formId.style.backgroundColor = '#00ff50';
                paragraphId.innerText = '';
            } else {
                formId.style.backgroundColor = '#ff272c';
                paragraphId.style.cssText = 'font-size: 2em; color: #ff272c';
                paragraphId.innerText = 'Nieprawidłowy format';
            }

        }



    }

    validForm(firstname, firstnameText, nameRegex);
    validForm(secondname, secondnameText, nameRegex);
    validForm(email, usernameText, emailRegex);




})