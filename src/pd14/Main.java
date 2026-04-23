package pd14;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Event> events = List.of(
                new Event("ERROR", 5, "Null pointer"),
                new Event("INFO", 1, "Start app"),
                new Event("WARN", 3, "Low memory"),
                new Event("ERROR", 10, "Crash"),
                new Event("INFO", 2, "User login"),
                new Event("ERROR", 2, "Lack of Memory")
        );

        Predicate<Event> onlyErrors = e -> e.type().equals("ERROR");
        Predicate<Event> highPriority = e -> e.priority() >= 5;

        List<Predicate<Event>> filters1 = List.of(onlyErrors);
        List<Predicate<Event>> filters2 = List.of(onlyErrors, highPriority);

        Function<Event, String> formatter = (Event e) ->
                e.type() + ": " + e.message();

        Function<Event, String> detailedFormatter = (Event e) ->
                "priority: " + e.priority() + ", "
                        + e.type() + ": " + e.message();

        Consumer<String> consoleOutput = System.out::println;

        System.out.println("\nOnly errors");
        EventProcessor.process(events, filters1, formatter, consoleOutput);

        System.out.println("\nErrors + high priority");
        EventProcessor.process(events, filters2, detailedFormatter, consoleOutput);
    }
}