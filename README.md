
# Simple Notes App (In Progress)

This is a **simple notes application** built using **Java**, which allows users to create, view, and delete notes. The app uses a **CSV file** to store note data, but it's still under development, and some features are incomplete or missing.

![Interface img](src\assets\interface.png)

---

## Current Features 📋

- **Create Notes**: Users can create new text notes.
- **View Notes**: The app displays a list of saved notes.
- **Delete Notes**: Users can delete notes from the list.
- **CSV-Based Storage**: Notes are stored in a `CSV` file to allow for simple data persistence between sessions.

---

## Features To Be Added 🛠️

- **Edit Notes**: Currently, notes cannot be edited once they are created.
- **Search Notes**: A search feature will be implemented to quickly find specific notes.
- **Note Categories**: Ability to assign categories or tags to notes for better organization.
- **Improved CSV Handling**: Further optimization of reading from and writing to the CSV file to improve performance and reliability.

---

## Technologies Used ⚙️

- **Java**: The application is written in vanilla Java.
- **Swing**: Used for the graphical user interface (GUI), allowing users to interact with the application.
- **AWT**: Utilized for some basic graphical components.
- **CSV**: Notes are stored in a `CSV` file, simulating a simple database system for data persistence.

---

## Installation and Execution 🔧

1. Clone the repository or download the ZIP file:
    ```bash
    git clone https://github.com/yourusername/simple-notes-app.git
    ```
2. Navigate to the project directory:
    ```bash
    cd simple-notes-app
    ```
3. Compile the project:
    ```bash
    javac src/com/notesapp/*.java
    ```
4. Run the application:
    ```bash
    java src/com/notesapp/Main
    ```

---

## Project Structure 🔩

```
simple-notes-app/
├── src/
│     └── com/
│           └── notesapp/
│                 ├── Main.java           # Main class to launch the app
│                 ├── NotesApp.java       # Core app logic
│                 ├── Note.java           # Note object model
│                 ├── NotesPanel.java     # Panel displaying notes list
│                 └── notes.csv           # CSV file storing the notes
└── README.md                             # README file with project details
```

---

## Known Issues 🐞

- **Basic CSV Implementation**: The current CSV handling is basic and may not handle complex note data formats.
- **Incomplete GUI**: The user interface is minimal and lacks some interactive elements.
- **Error Handling**: Minimal error handling has been implemented. Future versions will improve input validation.

---

## Future Plans 🚀

- **Add Edit and Search Features**: To improve note management.
- **Refine the UI**: To make it more user-friendly and visually appealing.
- **Optimize CSV Handling**: Improve the reading and writing processes of the CSV file to allow for faster and more reliable data storage.

---

## Special Thanks 🎁

Thanks to the open-source community for inspiring this project and providing excellent resources for learning Java development.

---

Made by [Your Name] - mansourlol440@gmail.com

---