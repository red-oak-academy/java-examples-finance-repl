package academy.redoak.financerepl;

import academy.redoak.financerepl.repl.FinanceRepl;

/**
 * Main application class for starting the {@link FinanceRepl}.
 */
public class FinanceReplApplication {

    /**
     * Just calls the {@link FinanceRepl} constructor.
     *
     * @param args No command line arguments are respected.
     */
    public static void main(String[] args) {
        new FinanceRepl();
    }
}
