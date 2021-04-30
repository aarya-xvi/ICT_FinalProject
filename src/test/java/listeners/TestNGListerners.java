package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListerners implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Verification of this testcase started: "+context.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Testcase passed: "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Testcase failed - "+result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
