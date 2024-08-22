# aishell

## how to use
(For now) you need to clone the repo and build the app with maven 
```
mvn -DsktipTests=true clean package
```

The jar file that's generated is in `/target`.
Create an alias for the app in your `.bashrc` file:
```
alias aishell="java -jar path/to/target/aishell-jar-file.jar"
```
Specify your MISTRAL_AI_API_KEY:
```
export MISTRAL_AI_API_KEY=..your_key
```

Run the app:
```
aishell
```

Type `help` to list available commands:
```
help
```

Ask the LLM with the `answer` command:
```
answer "your question"
```
