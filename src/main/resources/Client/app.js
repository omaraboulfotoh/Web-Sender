// Get references to elements on the page.
var form = document.getElementById("message-form");
var messageField = document.getElementById("message");
var messagesList = document.getElementById("messages");
var socketStatus = document.getElementById("status");
var closeBtn = document.getElementById("close");
var refreshBtn = document.getElementById("refresh");

var sentMessagesCount = 0;
const sendBtn = document.getElementById("send");

startWebsocket();

function startWebsocket() {
  var socket = new WebSocket("ws://localhost:8025/ws/chat");
  // Handle messages sent by the server.
  // Show a connected message when the WebSocket is opened.
  socket.onopen = function (event) {
    socketStatus.innerHTML = "CONNECTED";
    socketStatus.className = "open";
  };

  socket.onmessage = function (event) {
    var message = event.data;
    console.log(JSON.parse(message));
    messagesList.innerHTML = 
      '<li class="received"><span>Received:</span>' + message + "</li>" + messagesList.innerHTML;
  };

  // Handle any errors that occur.
  socket.onerror = function (error) {
    socket = null;
    console.log("WebSocket Error: " + error);
  };

  socket.onclose = function () {
    socket = null;
    socketStatus.innerHTML = "Disconnected";
    socketStatus.className = "closed";
    setTimeout(startWebsocket, 1000);
  };

  // Close the WebSocket connection when the close button is clicked.
  closeBtn.onclick = function (e) {
    e.preventDefault();

    // Close the WebSocket.
    socket.close();

    return false;
  };

  refreshBtn.onclick = function (e) {
    console.log(e);

    e.preventDefault();
    startWebsocket();
  };

  sendBtn.onclick = function (e) {
    console.log(e);
    e.preventDefault();
    socket.send('message: #' + sentMessagesCount);

    sentMessagesCount += 1;
  }
}

