package com.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resource/Features",glue={"com.test.stepdefns","com.test.hooks"},plugin={"pretty","junit:target/report.xml","html:target/report.html","json:target/report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/reun.txt,dryRun=true"},monochrome=true,tags="@smoke")
//@traget/rerun.txt

public class TestRunner {

}
