package de.f73.term5.financerepl.repl;

import de.f73.term5.financerepl.services.CompanyQuoteService;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FinanceRepl {

    public FinanceRepl() {

        List<Command> commandList = new ArrayList<>();
        commandList.add(new CompanyQuoteService());
        commandList.add(new QuitCommand());

        try (Scanner scanner = new Scanner(System.in)) {

            Supplier<String> input = () -> {
                System.out.print("> ");
                return scanner.nextLine();
            };

            Predicate<String> expressionDispatcher = expression -> {

                String[] tokens = expression.split(" ");

                if(tokens.length < 1) {
                    return false;
                }

                String command = tokens[0];
                String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

                Optional<Command> first = commandList.stream().filter(cmd -> cmd.canHandle(command, args)).findFirst();
                return !first.isPresent() || first.get().handle(command, args);
            };

            Stream.generate(input).allMatch(expressionDispatcher);
        }
    }
}
