package abstraction.assigment_problems;

public interface Exportable {
    String exportData();

    class CounterHolder {
        private static int totalExports = 0;

        public static synchronized void increment() {
            totalExports++;
        }

        public static synchronized int getCount() {
            return totalExports;
        }
    }

    static int getTotalExports() {
        return CounterHolder.getCount();
    }

    static void exportAll(Exportable[] items) {
        if (items != null) {
            for (Exportable item : items) {
                if (item != null) {
                    System.out.println(item.exportData());
                }
            }
        }
    }
}
