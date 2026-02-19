# 💬 Java Chat Application — Client Server Model

A real-time chat application built using **Java Socket Programming** and **Swing GUI** that enables communication between a client and a server over a TCP connection.

This project demonstrates networking fundamentals, multithreading, and graphical user interface development in Java.

---

## 📌 Project Overview

The Chat Application follows a **Client–Server Architecture**, where:

* The **Server** listens for incoming client connections.
* The **Client** connects to the server and exchanges messages.
* Communication occurs in real-time using **TCP sockets**.
* A graphical user interface (GUI) provides user-friendly interaction.

This project is ideal for understanding how real-world messaging systems work at a fundamental level.

---

## 🚀 Features

✅ Real-time messaging between client and server
✅ Client–Server architecture using TCP protocol
✅ Graphical User Interface built with Java Swing
✅ Multithreaded communication for simultaneous read/write
✅ Keyboard support (send message using Enter key)
✅ Graceful chat termination using `exit` command
✅ Lightweight and easy to run

---

## 🏗️ System Architecture

```
+----------------+        TCP Connection        +----------------+
|     Client     |  <------------------------>  |     Server     |
|   Swing GUI    |                              |    Console     |
+----------------+                              +----------------+
```

---

## 🛠️ Technologies Used

| Technology         | Purpose                     |
| ------------------ | --------------------------- |
| Java               | Core programming language   |
| Java Swing         | GUI development             |
| Socket Programming | Network communication       |
| Multithreading     | Concurrent message handling |
| AWT Event Handling | User input events           |

---

## 📂 Project Structure

```
ChatApp
│── Client.java
│── Server.java
└── README.md
```

---

## ⚙️ How It Works

1. The server starts and listens on port **7777**.
2. The client connects to the server using the IP address (`127.0.0.1`).
3. Input and output streams are created for communication.
4. Separate threads manage:

   * Receiving messages
   * Sending messages
5. Messages are displayed instantly on both sides.

---

## ▶️ How to Run the Project

### Step 1 — Compile the Files

```bash
javac Server.java
javac Client.java
```

### Step 2 — Run Server First

```bash
java Server
```

You should see:

```
Server is ready to accept connection...
```

### Step 3 — Run Client

```bash
java Client
```

Now you can start chatting 🎉

⚠️ Make sure server is running before starting client.

---

## ⌨️ Controls

| Action       | Method      |
| ------------ | ----------- |
| Send Message | Press Enter |
| Exit Chat    | Type `exit` |

---

## 📸 Screenshots (Optional)

You can add screenshots here to make the project more attractive.

Example:

```
Screenshot1.png
Screenshot2.png
Screenshot3.png
```

---

## 🎯 Learning Outcomes

Through this project, you can learn:

* Fundamentals of socket programming
* TCP client–server communication
* Multithreading concepts in Java
* GUI development using Swing
* Event-driven programming
* Network application design

---

## 🔮 Future Enhancements

* Multiple client support (Group chat)
* User authentication system
* Message timestamps
* Chat history storage (database)
* Emoji support
* File transfer feature
* Internet-based deployment

---

## 👨‍💻 Author

**Tarang Thakur**
B.Tech Electronics & Communication Engineering

GitHub: https://github.com/Tarang-Thakur

---

## 📜 License

This project is open-source and available under the MIT License.

---

⭐ If you like this project, consider giving it a star on GitHub!
