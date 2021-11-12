# TicTacToe with AI
This program is a TicTacToe game created in Java. It is played and output in console. You can play against other humans OR against the AI. The AI difficulty ranges from easy, medium, and hard. 

If you'd like to play the game, skip to "<strong>How To Play</strong>".

## Game Background
The game was created in Java. This is my first programming project I have created 100% by myself from scratch. This project's inspiration came from learning the Java language and programming in general to hopefully test out of a future programming class at college to graduate a semester earlier. 

The TicTacToe itself is rather basic. There are many things I'd like to change/will be changing as time progresses. The highlight of this program and the hardest concept was implementing the minimax algorithm to create the hard AI. It was the first time I've ever used recursion besides from practice problems as well as ever implementing an algorithm. 

I went into this project without understanding classes and objects. Because of this, the project has a weak foundatoin and depending on the time you're viewing the code, it could be horrible. Since the initial creation of TicTacToe itself, i've gained tons of more understanding of Java and OOP via JetBrains Academy, Youtube, and a Hackathon I participated in. I plan on cleaning the code and making the procesesses more efficient. I also plan on converting the game over to a GUI to make it funner.

Overall, it's been a fun project as well as learning experience. I can't wait to look at this code a year from now to see how far my skills have progressed.

## How to play
### Starting
To start the game, type in the following format: start player1 player2

The different options for player1 and player2 are the following: user, easy, medium, hard. Player1 is 'X' and always starts first.

For example, to play with 2 humans you would type "start user user" or to play against hard AI you would type "start user AI". You may also play AI vs AI such as "start hard medium".

### Exiting
To exit the game, you must type: exit. You can only exit before or after matches, not during a match. In other words, the command line should say "Input command:" rather than "Enter the coordinates:".

### Playing
If users are playing, you choose where to play based on coordinate inpute. The game receives input on a row by column format. 

You must type in the following format: coordinate1 coordinate2

For example, to place your 'piece' in top left corner you would type "1 1" or to place in middle row far right column you would type "2 3".

Below is a cheat sheet of the coordinate system.

[1 1] [1 2] [1 3]<br>
[2 1] [2 2] [2 3]<br>
[3 1] [3 2] [3 3]


