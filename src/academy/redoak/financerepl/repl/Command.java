package academy.redoak.financerepl.repl;

/**
 * An interface to be implemented, in order to execute some given command in the {@link FinanceRepl}.
 */
public interface Command {

    /**
     * Checks if given command may be executed by Command implementation.
     *
     * @param expression The command name of the command to be executed
     * @param args The arguments of the command
     *
     * @return <code>true</code> if command may be executed, <code>false</code> if not
     */
    boolean canHandle(String expression, String... args);

    /**
     * Executes given command.
     *
     * @param expression The command name to execute
     * @param args The arguments of the command
     *
     * @return <code>true</code> if execution should end the application (due to exception for example), <code>false</code> if not
     */
    boolean execute(String expression, String... args);
}
