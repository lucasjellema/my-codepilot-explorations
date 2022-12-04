# my-codepilot-explorations

After installing the VS Code extension for Copilot and signing up for Copilot - as per [the instructions](https://docs.github.com/en/copilot/getting-started-with-github-copilot/getting-started-with-github-copilot-in-visual-studio-code) I have made a first few steps with Copilot in VS Code to see if it can be a useful AssIstant while programming - a veritable pAIr programmer. 

The first trial - create a simple Java application. That is: a Java application for a simple task that requires more cumbersome steps than a comparable Node or Python program. Or at least, it feels that way. Read a CSV file and turn the data into an in memory structure that can easily be processed.

## Steps:

To create the Java class to process the CSV file

* create a file called DataProcessor.java in directory `javapilot`
* type `// class for loading a csv file and storing data in a list of maps`
* press <kbd>Ctrl+Enter</kbd>
* select the first solution from the list that is presented in the GitHub Copilot tab that is opened
* position the cursor at the end of the pasted code. Press <kbd>Ctrl+Enter</kbd> to get suggestions for how to proceed.
* accept the first proposal - to add methods `getData` and `getColumnNames` and method `main`

To create the CVS file with country data:

* create a file called data.csv
* type `// records for countries with comma separated values for country name, language, capital and population`
* press <kbd>Ctrl+Enter</kbd>
* accept first solution
* remove // Example: " and " + newline 
* accept suggestion for the first line with column names
* remove original comment

Run the Java class. The output presents the country data from the CSV as processed by the Java application.

It would be nice to also have the names of the columns printed to the output. To make that happen:
* add a comment in method `main`, just  before the `for` loop:  `// print names of columns`
* press <kbd>Ctrl+Enter</kbd>
* accept first solution

Run the Java class again. Now the column names are there as well.

Conclusion: with typing all of two suggestions after creating an empty Java file:
* // class for loading a csv file and storing data in a list of maps
* // print names of columns

and making use of <kbd>Ctrl+Enter</kbd> three times to get code fragments for the application I was able to compose a Java program that does what I set out to do. Not being a fluent Java programmer these days, I could have done this myself but it would have taken much longer (if only for all the typos I am apparently adding to any text or code I type) and probably resulted in far more frustration (with myself, with Java, with the IDE, with the world).

One additional comment in an empty csv file was required to produce a sample csv file with country records:
* // records for countries with comma separated values for country name, language, capital and population

after accepting the proposal from Copilot I had to do a little bit of refining the file in order to make it usable. In fairness, Copilot suggested a few ready to roll CSV files from GitHub.

Let's try to create a Java application that gets its CSV file from GitHub and does similar processing as done before.

* create an empty file called DataProcessor2.java
* add comment // class for downloading a csv file from GitHub and storing data in a list of maps
* press <kbd>Ctrl+Enter</kbd>
* select the third solution from the list that is presented in the GitHub Copilot tab that is opened

The final result is very much like the previous DataProcessor. There are three differences:
1. the input parameter to the constructor is called *url*
2. the InputStreamReader is creasted from a URL object
3. the value passed into the constructor should be a URL rather than a file location



 