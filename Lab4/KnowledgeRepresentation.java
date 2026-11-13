
import java.util.*;

public class KnowledgeRepresentation {

    public static void main(String[] args) {

        // Facts
        Map<String, Boolean> facts = new LinkedHashMap<>();

        facts.put("has_feathers", true);
        facts.put("can_fly", true);
        facts.put("lays_eggs", true);

        // Knowledge Base: Rules
        Map<String, List<String>> rules = new LinkedHashMap<>();

        rules.put("bird", Arrays.asList(
                "has_feathers",
                "lays_eggs"
        ));

        rules.put("flying_bird", Arrays.asList(
                "bird",
                "can_fly"
        ));

        // Perform inference
        Set<String> results = infer(facts, rules);

        // Display initial facts
        System.out.println("Initial Facts:");

        for (Map.Entry<String, Boolean> entry : facts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Display inferred knowledge
        System.out.println("\nInferred Knowledge:");

        for (String result : results) {
            System.out.println(result);
        }
    }

    // Inference Function
    static Set<String> infer(
            Map<String, Boolean> facts,
            Map<String, List<String>> rules) {

        Set<String> inferred = new LinkedHashSet<>();

        // Apply rules to infer new knowledge
        for (Map.Entry<String, List<String>> rule : rules.entrySet()) {

            String conclusion = rule.getKey();
            List<String> conditions = rule.getValue();

            boolean satisfied = true;

            for (String condition : conditions) {

                if (!facts.getOrDefault(condition, false)
                        && !inferred.contains(condition)) {

                    satisfied = false;
                    break;
                }
            }

            if (satisfied) {
                inferred.add(conclusion);
            }
        }

        return inferred;
    }
}
