package access_modifiers.assigment_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "private":
                return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";

            case "default":
                return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext))
                        ? "ALLOWED" : "DENIED";

            case "protected":
                return ("SAME_CLASS".equals(accessorContext) || 
                        "SAME_PACKAGE".equals(accessorContext) || 
                        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext))
                        ? "ALLOWED" : "DENIED";

            case "public":
                return "ALLOWED";

            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        Map<String, int[]> counts = new LinkedHashMap<>();
        counts.put("private", new int[]{0, 0});
        counts.put("default", new int[]{0, 0});
        counts.put("protected", new int[]{0, 0});
        counts.put("public", new int[]{0, 0});

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String modifier = attempt[0];
                    String context = attempt[1];
                    if (counts.containsKey(modifier)) {
                        String result = classifyAccess(modifier, context);
                        if ("ALLOWED".equals(result)) {
                            counts.get(modifier)[0]++;
                        } else {
                            counts.get(modifier)[1]++;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, int[]> entry : counts.entrySet()) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(entry.getKey())
              .append(": ")
              .append(entry.getValue()[0])
              .append(" allowed / ")
              .append(entry.getValue()[1])
              .append(" denied");
        }
        return sb.toString();
    }

    public static String describeContext(String accessorContext) {
        if (accessorContext == null || accessorContext.trim().isEmpty()) {
            return "";
        }

        String[] parts = accessorContext.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].isEmpty()) continue;
            String word = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase();
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(word);
        }
        return sb.toString();
    }
}
