package com.BookIt.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features ="@Target/rerun.txt",
        glue = "com/BookIt/Steps"
)



public class failerRunner {
}
