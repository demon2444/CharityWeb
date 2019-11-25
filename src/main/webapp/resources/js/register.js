document.addEventListener("DOMContentLoaded", () => {

    console.log("bbbb")

    let minRegex = new RegExp("^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$");
    let maxRegex = new RegExp("^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$")

    let strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    let mediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");

    function useValue() {
        let regvalue = document.getElementById('passwd');
        let val = regvalue.value;

        if (val.match(maxRegex)) {

            regvalue.style.backgroundColor = '#00ff50';
            console.log("green")
        }  if (val.match(minRegex)) {
        regvalue.style.backgroundColor = '#ff5500';
            console.log("orange")
        } else {

        regvalue.style.backgroundColor = '#ff272c';
            console.log("red")
            console.log(val)
        }

    }

    
})