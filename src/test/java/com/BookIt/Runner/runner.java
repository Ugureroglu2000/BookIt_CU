package com.BookIt.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features="src/test/Resources/Features",
        glue="com/BookIt/Steps",
        dryRun=false,
//        strict = true,
        tags ="@log"
)

public class runner {

}
