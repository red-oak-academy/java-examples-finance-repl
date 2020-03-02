package de.f73.term5.financerepl.repl;

public interface Command {
    boolean canHandle(String command, String[] args);

    boolean handle(String expression, String[] args);
}
