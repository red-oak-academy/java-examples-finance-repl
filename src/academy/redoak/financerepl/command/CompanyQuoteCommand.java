package academy.redoak.financerepl.command;

import academy.redoak.financerepl.repl.Command;

/**
 * A command in order to retrieve the profile of a stock corporation.
 */
public class CompanyQuoteCommand implements Command {

    @Override
    public boolean canHandle(String command, String[] args) {
        // profile is meant to be the typed into the REPL
        if(!command.equalsIgnoreCase("profile"))
            return false;
        else if(args.length != 1) { // there should be exactly one argument, which is meant to be the ticker symbol
            System.out.println("Wrong number of arguments!");
            return false;
        }
        // if no issue detected, the command may be executed
        return true;
    }

    @Override
    public boolean execute(String expression, String[] args) {
        System.out.println("Fetching Company Profile...");
        //TODO keep going here

        // REPL should keep running after successfully calling the command
        return true;
    }
}
