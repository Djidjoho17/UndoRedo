# 📝 JavaFX Text Editor with Undo/Redo

A desktop text editor built with Java and JavaFX that demonstrates
stack-based undo and redo functionality using core data structures.

## 🎯 What It Does

- **Text Editing** — type freely in a clean text editor window
- **Undo** — press CTRL + Z to revert the editor to a previous state
- **Redo** — press CTRL + Y to restore text removed by the last undo
- **State History** — every keystroke is tracked and recoverable

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| UI Framework | JavaFX |
| Build Tool | Maven |
| Data Structure | Stack (Array-based) |

## 🏗️ The Core Concept — Stack Data Structure

This project demonstrates one of the most important real-world
applications of the **Stack** data structure.

A Stack follows **LIFO** — Last In, First Out. The last item
pushed onto the stack is the first one removed. Think of it
like a stack of plates — you always take from the top.

### How Undo/Redo works with two stacks
