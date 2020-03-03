package academy.redoak.financerepl.command;

import academy.redoak.financerepl.repl.Command;

/**
 * A command for exiting the Application by typing in "quit" in the {@link academy.redoak.financerepl.repl.FinanceRepl}.
 */
public class QuitCommand implements Command {

    @Override
    public boolean canHandle(String expression, String... args) {
        return args.length == 0 && "quit".equals(expression);
    }

    @Override
    public boolean execute(String expression, String... args) {
        return false;
    }
}
