# ScrabbleGame
A desktop word game built with Java Swing, inspired by Scrabble. Players form words by selecting letters from an 8×8 board and score points to reach a target score. 
Developed as a university course project for practicing object-oriented programming and GUI development with Java Swing.

About

The game presents an 8×8 grid of random letters. The player selects adjacent letters to form valid English words, earns points based on letter values, and tries to reach the target score of 50 points. The word dictionary is loaded from an external .txt file at runtime.

Gameplay

Enter your nickname when the game launches
Click letters on the board to spell a word — selected letters turn yellow
Click "Έλεγχος Λέξης" (Check Word) to validate your word
If the word is valid  — points are added and the used letters are replaced with new random ones
If the word is invalid  — the selection is cleared
Reach 50 points to win 


Features

1) 8×8 interactive letter board built with Java Swing
2) Dictionary validation — words checked against a .txt file loaded into a HashSet
3) Letter scoring — each letter has a point value (Scrabble-style)
4) Special blue tiles — double word score
5) Help system with 5 configurable assists:

Delete Row (×3)
Shuffle Row (×3)
Shuffle Column (×3)
Shuffle Entire Board (×5)
Swap Letters (×6)

6) Settings menu — customize the number of uses for each help type
7) Nickname system — enter or update your player name mid-game
8) Live scoreboard — tracks overall score, word score, and found words

Tech Stack

TechnologyUsageJavaCore languageJava SwingGUI (JFrame, JButton, JPanel, JMenuBar)HashSetDictionary storage for O(1) word lookupLinkedListLetter shuffling logicScanner + FileLoading the word dictionary from .txt

Project Structure

src/
├── Project_Java.java      # Entry point — launches the game
├── Main_Board.java        # Main game logic, UI layout, event handling
├── Game_Board.java        # Board initialization, letter values
└── Game_button.java       # Custom JButton with letter/value/position data

Setup & Run

Requirements

Java JDK 8+
NetBeans IDE (or any Java IDE)
A word dictionary file named javaDictionary.txt (one word per line)


Steps

Clone the repository:


bash   git clone https://github.com/athensicsd/ScrabbleGame.git


Open the project in NetBeans (File → Open Project)
Place javaDictionary.txt in the project root directory (same level as src/)
Run Project_Java.java


Dictionary file format

apple
table
board
...

One English word per line, no punctuation.


