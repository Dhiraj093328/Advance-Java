<html>
<head>
<title>Admin Chat</title>
<link rel="stylesheet" href="chat.css">
<script>
function loadMessages(){
    fetch("GetMessagesServlet?user1=admin&user2=user")
    .then(res => res.text())
    .then(data => {
        document.getElementById("chatBox").innerHTML = data;
    });
}
setInterval(loadMessages, 2000);
</script>
</head>

<body onload="loadMessages()">

<a href="userChat.jsp">Go to User Page</a>

<div id="chatBox" class="chat-container"></div>

<form action="SendMessageServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="sender" value="admin">
    <input type="hidden" name="receiver" value="user">

    <input type="text" name="message" placeholder="Type message..." required>
    <input type="file" name="image">
    <button type="submit">Send</button>
</form>

</body>
</html>
