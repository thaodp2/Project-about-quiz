var questions = null;
var selectedQ = null;
var time = null;

if (questions === null) {
    questions = document.getElementsByClassName("question");
}

if (selectedQ === null) {
    selectedQ = parseInt(0);
}


function next() {
    if (selectedQ === questions.length - 1) {
        document.getElementById("buttonNext").value = "Submit";   
    }
    if (selectedQ === questions.length && time !== null) {
        document.getElementById("doquiz").submit();       
        return;
    }
    for (var i = 0; i < questions.length; i++) {
        questions[i].setAttribute("hidden", "true");
    }
    questions[selectedQ++].removeAttribute("hidden");
}

var myInterval;

function startTimer(time, display, realtime) {
    var currentDate = new Date();
    var dateSubmit = new Date(time);
    var timer = (dateSubmit - currentDate) / 1000;
    
    if (timer > realtime) {
        timer = realtime;
    }
    if(timer < 0){
        timer=0;
    }
    var minutes, seconds;
    myInterval = setInterval(function () {        
        timer = timer - 1;
        if (timer < 1) {
            //first form
            //document.getElementById("doquiz").submit();
            clearInterval(myInterval);
        }
        //parse to 10 base
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;
        display.textContent = minutes + ":" + seconds;
    }, 1000);//loop after 1 second
}



window.onload = function () {
    next();
    time = document.getElementById('time').value;
    realtime = document.getElementById('realtime').value;
    //get first element
    display = document.querySelector('#showTime');
    startTimer(time, display, realtime);
};



