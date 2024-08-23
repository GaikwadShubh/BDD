package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter spark;

    public static void setUpExtentReport() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent.attachReporter(spark);
    }

    public static void flushReport() {
        extent.flush();
    }
}
