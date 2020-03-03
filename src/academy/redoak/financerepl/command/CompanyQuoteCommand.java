package academy.redoak.financerepl.command;

import academy.redoak.financerepl.http.HttpClient;
import academy.redoak.financerepl.model.CompanyProfile;
import academy.redoak.financerepl.repl.Command;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * A command to retrieve the profile of a stock corporation.
 */
public class CompanyQuoteCommand implements Command {

    @Override
    public boolean canHandle(String expression, String... args) {
        return "profile".equals(expression) && args.length == 1;
    }

    @Override
    public boolean execute(String expression, String... args) {
        if (!this.canHandle(expression, args)) {
            System.err.println("You missed to check, if command may be executed. Behaviour may be undefined.");
            return true;
        }
        HttpClient client =  HttpClient.getInstance();
        String url = "https://financialmodelingprep.com/api/v3/company/profile/" + args[0];
        String content = null;
        try {
            content = client.doHttpGET(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content); // about to become: »Apple Inc. $298.81 (+9.31%)«

        /*
         * You must add Jackson libraries (-databind, -annotations and -core).
         */
        ObjectMapper mapper = new ObjectMapper();

        // sometimes, we don't want to have ALL the attributes available in the response inside our model object
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            // read JSON string and map to Object
            CompanyProfile companyProfile = mapper.readValue(content, CompanyProfile.class);
            System.out.println(companyProfile.getProfile().getCompanyName() + " " + companyProfile.getProfile().getPrice() + " " + companyProfile.getProfile().getChangesPercentage());
            // regular Object-to-JSON
            System.out.println(mapper.writeValueAsString(companyProfile));
            // pretty print Object-to-JSON
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(companyProfile));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return true;
    }
}
