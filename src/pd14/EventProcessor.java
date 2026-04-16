package pd14;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class EventProcessor {

    public static void process(
            List<Event> events,
            List<Predicate<Event>> filters,
            Function<Event, String> formatter,
            Consumer<String> output
    ){
        events.forEach(event -> {
            boolean passed = true;
            for (var filter : filters){
                if(!filter.test(event)){
                    passed = false;
                    break;
                }
            }
            if(passed){
                String formatted = formatter.apply(event);
                output.accept(formatted);
            }
        });
    }
}
