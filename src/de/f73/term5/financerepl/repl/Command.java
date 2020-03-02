package de.f73.term5.financerepl.repl;

public interface Command {

    /**
     * Checks if given command may be executed by Command implementation.
     *
     * @param command The command name of the command to be executed
     * @param args The arguments of the command
     *
     * @return <code>true</code> if command may be executed, <code>false</code> if not
     */
    boolean canHandle(String command, String[] args);

    /**
     * Executes given command.
     *
     * @param expression The command name to execute
     * @param args The arguments of the command
     *
     * @return <code>true</code> if execution should end the applicatin (due to exception for example), <code>false</code> if not
     */
    boolean handle(String expression, String[] args);
}
