package com.martraire.training;

import cucumber.api.junit.Cucumber;
import cucumber.contrib.formatter.pdf.PdfFormatter;
import cucumber.contrib.junit.CommentDocBlockFilter;
import cucumber.contrib.junit.CucumberExt;
import cucumber.contrib.junit.CucumberExtOptions;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
@RunWith(CucumberExt.class) // CucumberExt allows several pre-processing of the feature before feeding Cucumber
@Cucumber.Options(
        //tags = {"@wip"},
        format = {"com.martraire.training.RunCucumberWithPdfTest$ConfiguredFormatter:target/pdf"}
)
@CucumberExtOptions(filters = CommentDocBlockFilter.class)
public class RunCucumberWithPdfTest {

    public static class ConfiguredFormatter extends PdfFormatter {
        public ConfiguredFormatter(File reportDir) throws FileNotFoundException {
            super(reportDir, defaultConfiguration()
                            .withMetaInformationsResources(RunCucumberTest.class, "00-meta.properties")
                                    // override some of the previous meta infomations
                            .withReportFilename("purchase-order.pdf")
                            .withAuthor("Arnauld")
                            .withTitle("Purchase Order - Cancellation Policy")
                            .withPreambuleResource(RunCucumberTest.class, "00-preambule.md")
                            .withDocumentMargin(10, 40)
                            .withDescriptionMargin(0, 0, 5, 5)
                            .withScenarioMargin(0, 0, 2, 5)
                            .displayUri(false)
                            .displayTags(true)
            );
        }
    }
}
