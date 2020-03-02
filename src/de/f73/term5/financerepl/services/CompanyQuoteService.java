package de.f73.term5.financerepl.services;

import de.f73.term5.financerepl.http.HttpRequestUtil;
import de.f73.term5.financerepl.json.JsonParserUtils;
import de.f73.term5.financerepl.repl.Command;

import java.io.IOException;

public class CompanyQuoteService implements Command {

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

        try {
            //TODO keep going here
            String result = HttpRequestUtil.getUrl("https://financialmodelingprep.com/api/v3/company/profile/" + args[0]);
            System.out.println(result);
            JsonParserUtils.parseFromString(result);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
