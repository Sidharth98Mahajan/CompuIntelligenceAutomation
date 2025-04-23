package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.util.Objects;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports createInstance() {
        if (extent == null) {
            // Create an HTML reporter object that will generate an HTML report.
        	ExtentSparkReporter htmlReporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/test-output/ExtentReport.html"));


            // Configure the HTML report to be in the desired format
            htmlReporter.config().setReportName("Automation Test Report");
            htmlReporter.config().setDocumentTitle("Test Execution Results");

            // Create an ExtentReports instance with the HTML reporter
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    // To start a new test in the report
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    // To flush the report (write it to disk)
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }

    // To get the current test instance
    public static ExtentTest getTest() {
        return test;
    }
}
