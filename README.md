# Web-Sender

 It contains of 2 parts first and it's a Bluetooth listener which responsabile for init the connection with the POS and reciving the messages sent from the POS.
 The second one is Java local Server that responsabile init the communication with the web application and sending the recived messages to it.
 
 # Local Server 
 
 Using java we create a local socket servier wich using port '8025' to open a communication channel between the web application and the server.
 When the Desktop application revcive a message from the POS it pass it to the server to can send it to the web application with json formt.
 
 # Web Side 
 
 The web application is a java script which can control the connection to the local server as it can init or finish this connection as needed, it connect via port '8025' and start listening for income json message from the server.
 
 
 
 # Current Soultion 
 
We develop just one side communication as the desktop app works as reciver/sender which recive the message from the pos and send to the web application via the local socket server and cannot make the other side communication so far.
Also the web application works as reciver so far as it recive the message from the server and we will work on back to back solution to make web application recive and send data also the server to can recive and send data to the POS.
 
 
