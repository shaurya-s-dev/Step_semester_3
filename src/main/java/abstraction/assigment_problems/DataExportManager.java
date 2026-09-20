package abstraction.assigment_problems;

public class DataExportManager {

    public static int getTotalExports() {
        return Exportable.getTotalExports();
    }

    public static void exportAll(Exportable[] items) {
        Exportable.exportAll(items);
    }
}
