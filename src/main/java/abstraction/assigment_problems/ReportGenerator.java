package abstraction.assigment_problems;

public class ReportGenerator implements Exportable {
    private String reportName;

    public ReportGenerator(String reportName) {
        this.reportName = reportName;
    }

    public String getReportName() {
        return reportName;
    }

    @Override
    public String exportData() {
        Exportable.CounterHolder.increment();
        return "Exported report: " + reportName;
    }
}
