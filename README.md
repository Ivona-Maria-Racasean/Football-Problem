# Football-Problem
## Problem's description and requirements:
"The file football.dat contains the results from the English Premier League for 2001/2.

The columns labeled ‘F’ and ‘A’ contain the total number of goals scored for and against each team in that season (so Arsenal scored 79 goals against opponents, and had 36 goals scored against them).

**Write a program to print the name of the team with the smallest difference in ‘for’ and ‘against’ goals.**"

## Solution:

### Readability
I tried to keep the code straightforward, with clear names and simple methods. Each method does one job, so it's easy to see what's going on.

### Modularity
Everything is broken down into small, focused methods:
- **`findTeamWithSmallestGoalDifference`**: Finds the team with the smallest goal difference.
- **`parseTeamFromLine`**: Turns a line from the file into a `Team` object.
- **`extractTeamName`**: Grabs the team name from the line.

### Separation of Input/Output and Logic (Testability)
The file reading and data processing are separated, so it's easy to test the logic without worrying about file I/O.

### **No Boilerplate**
Utility functions like **`parseTeamFromLine`** and **`extractTeamName`** encapsulate reusable logic, preventing code duplication. The use of **`Optional<String>`** to handle the absence of a team with the smallest goal difference is another example of the code's clean, non-boilerplate approach to handling edge cases.

### **Handles Changes Well**
Because each method does one thing, it's easy to update if something changes, like the file format. 

### Handling Large Files
The program can handle very large files (ex: 100GB) by processing the file line by line. This method ensures that the program does not attempt to load the entire file into memory, which would cause OutOfMemoryError in the case of large files. By processing each line individually, the program maintains a low memory footprint, making it efficient and capable of handling large datasets.
