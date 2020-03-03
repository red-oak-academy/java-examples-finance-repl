package academy.redoak.financerepl.repl;

import academy.redoak.financerepl.command.QuitCommand;
import academy.redoak.financerepl.services.CompanyQuoteCommand;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A REPL (Read Evaluation Print Loop) for doing some minor research about stock corporations.
 */
public class FinanceRepl {

    /**
     * The default constructor starts the REPL in the console and does ask for a command as long as the user does not quit.
     */
    public FinanceRepl() {

        // Remember to register all your commands by adding it to the list!
        List<Command> commands = new ArrayList<>();
        commands.add(new CompanyQuoteCommand());
        commands.add(new QuitCommand());

        // Try-with-catch in order to auto close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // A supplier, which asks for user input and reads and returns it
            Supplier<String> inputSupplier = () -> {
                System.out.print("> ");
                return scanner.nextLine();
            };

            // The Predicate, which checks, what command to execute and eventually executes it, if there is one present
            Predicate<String> dispatcher = (expression) -> {
                String[] tokens = expression.split(" ");

                if (tokens.length < 1) {
                    return true;
                }
                // command token is always the very first token
                String commandStr = tokens[0];

                // take all the tokens, which aren't the command token itself
                String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

                Optional<Command> optionalCommand = commands.stream()
                        // find the command(s), which are able to execute the command
                        .filter(command -> command.canHandle(commandStr, args))
                        // and pick the first one, you can find (which is hopefully the onky one)
                        .findFirst();
                // if there was no suitable command found, we gotta tell the user and ask for a new expression
                if (!optionalCommand.isPresent()) {
                    System.out.println("There is no function suitable to execute your expression");
                    return true;
                }
                // otherwise execute it and close the REPL, or don't – just as defined by command execution
                return optionalCommand.get().execute(commandStr, args);
            };

            /*
             * Stream.generate creates a Stream of the products of the given supplier.
             * The allMatch method of the StreamAPI does terminate as soon as either all
             * contained objects in the Stream are checked and return true, when given
             * into the Predicate, or as soon as an object returns false.
             *
             * Since the Stream.generate will create a new object with the Supplier as soon
             * as allMatch asks for the next object, it's basically an endless flow of objects,
             * but as soon as a given expression delivers a false when given to the predicate,
             * the REPL will terminate, because allMatch does.
             */
            Stream.generate(inputSupplier).allMatch(dispatcher);
        }
    }
}
