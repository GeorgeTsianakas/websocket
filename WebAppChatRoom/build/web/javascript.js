var socket = new WebSocket("ws://127.0.0.1:8080/WebAppChatRoom/hello");

let input = document.querySelector("#input");
let submit = document.querySelector("#submit");

submit.addEventListener("click", function (event) {
    event.preventDefault();
    socket.send(input.value);
});

socket.onmessage = onMessage;

function onMessage(event) {
    var newMessage = event.data;
}
