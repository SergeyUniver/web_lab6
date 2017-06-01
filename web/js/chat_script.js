var ws;

function connect() {
    var username = document.getElementById("username").value;
    ws = new WebSocket("ws://localhost:8080/lab4_1_war_exploded/echo/chat/" + username);


    ws.onmessage = function(event) {
        var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    var to = document.getElementById("to").value;
    var json = JSON.stringify({
        "to":to,
        "content":content
    });

    ws.send(json);
    log.innerHTML += "Me : " + content + "\n";
}