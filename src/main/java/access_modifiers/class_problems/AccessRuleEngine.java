package access_modifiers.class_problems;

public class AccessRuleEngine {

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

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String result = classifyAccess(attempt[0], attempt[1]);
                    if ("ALLOWED".equals(result)) {
                        allowed++;
                    } else {
                        denied++;
                    }
                }
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
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
