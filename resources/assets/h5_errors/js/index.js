/**
* Check Env
*/
let UA = window.navigator.userAgent;
let device = {
    iOS: /iPhone|iPad|iPod/i.test(UA),
    Android: /Android/i.test(UA),
}
let isInContainer = UA.toLocaleLowerCase().indexOf('appcontainer') !== -1;
let key = getUrlParameter("type", window.location)
key = key.toUpperCase();

let errorData = {
    "NW": {
        "icon": "assets/img/noNetwork.svg",
        "headingText": "Please check your internet connection and try again",
        "buttonText": ""
    },
    "SR": {
        "icon": "assets/img/error.svg",
        "headingText": "Something went wrong",
        "buttonText": ""
    },
    "NR": {
        "icon": "assets/img/error.svg",
        "headingText": "Server not responding",
        "buttonText": "Try Again"
    },
    "AN": {
        "icon": "assets/img/error.svg",
        "headingText": "App not found",
        "buttonText": ""
    },
     "ADN": {
         "icon": "assets/img/error.svg",
         "headingText": "App data not found",
         "buttonText": ""
     }
}
//Methods
function getUrlParameter(name, url) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(url);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

function methodRouting(h5Action = () => { }, webAction = () => { }) {
    if (isInContainer) {
        h5Ready(h5Action)
    } else {
        webReady(webAction)
    }
}

function h5Ready(callback) {
    if (window.AlipayJSBridge) {
        callback && callback();
    } else {
        document.addEventListener('AlipayJSBridgeReady', callback, false);
    }
}

function webReady(callback) {
    callback && callback();
}


function init() {
    if (key === undefined || key === null)
        key = 'SR';
    let errorLogo = document.getElementById('errorLogo');
    let content = document.getElementById('content');
    let tryAgain = document.getElementById('tryAgain');
    if (errorData[key] === undefined || errorData[key] === null)
        key = 'SR';

    errorLogo.src = errorData[key].icon;
    content.innerHTML = errorData[key].headingText;
    tryAgain.innerHTML = errorData[key].buttonText;
    if (errorData[key].buttonText !== "") {
        tryAgain.style.display = 'inline-block';
    }

}



// Event Listener
function onBackButtonClick() {
    methodRouting(function () {
        window.AlipayJSBridge.call('exitSession')
    })
}

function tryAgainClick() {
    methodRouting(function () {
        window.AlipayJSBridge.call('paytmHandleError', {
            type: key
        })
    })
}
//paytmHandleError

//Init
init();