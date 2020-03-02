package de.f73.term5.financerepl.services;

import de.f73.term5.financerepl.repl.Command;

public class CompanyQuoteCommand implements Command {

    @Override
    public boolean canHandle(String command, String[] args) {

        if(!command.equalsIgnoreCase("profile"))
            return false;
        else if(args.length != 1) {
            System.out.println("Wrong number of arguments!");
            return false;
        }
        return true;
    }

    @Override
    public boolean handle(String expression, String[] args) {
        System.out.println("Fetching Company Profile...");
        //TODO keep going here

        return true;
    }
}
