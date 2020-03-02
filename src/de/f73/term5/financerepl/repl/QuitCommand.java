package de.f73.term5.financerepl.repl;

public class QuitCommand implements Command {

    @Override
    public boolean canHandle(String command, String[] args) {
        return command.equalsIgnoreCase("quit");
    }

    @Override
    public boolean handle(String expression, String[] args) {
        return false;
    }
}
