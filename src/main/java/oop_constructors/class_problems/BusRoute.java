package week4.class_problems;

public class BusRoute implements Comparable<BusRoute> {
    private String routeCode;
    private String routeName;
    private int priority;

    public BusRoute(String routeCode, String routeName, int priority) {
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.priority = priority;
    }

    public BusRoute(String routeCode, String routeName) {
        this(routeCode, routeName, 3); // default priority 3
    }

    @Override
    public int compareTo(BusRoute other) {
        // Sort by priority descending (higher first), then routeCode case-insensitive, then routeName length
        if (this.priority != other.priority)
            return Integer.compare(other.priority, this.priority); // descending
        int codeCompare = this.routeCode.compareToIgnoreCase(other.routeCode);
        if (codeCompare != 0) return codeCompare;
        return Integer.compare(this.routeName.length(), other.routeName.length());
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        // Simple bubble sort (O(n^2))
        for (int i = 0; i < routes.length - 1; i++) {
            for (int j = 0; j < routes.length - 1 - i; j++) {
                if (routes[j].compareTo(routes[j+1]) > 0) {
                    BusRoute temp = routes[j];
                    routes[j] = routes[j+1];
                    routes[j+1] = temp;
                }
            }
        }
        return routes;
    }

    public static void main(String[] args) {
        BusRoute[] routes = {
            new BusRoute("RT205L", "Airport Express", 3),
            new BusRoute("rt201j", "City Central", 4),
            new BusRoute("RT299T", "Night Service") // defaults to 3
        };
        BusRoute[] ranked = rankRoutes(routes);
        for (BusRoute br : ranked) {
            System.out.print(br.routeCode + " ");
        }
        System.out.println();
    }
}