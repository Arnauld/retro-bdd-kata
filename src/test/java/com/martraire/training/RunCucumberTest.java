package com.martraire.training;

import cucumber.api.CucumberOptions;
import cucumber.contrib.junit.CommentDocBlockFilter;
import cucumber.contrib.junit.CucumberExt;
import cucumber.contrib.junit.CucumberExtOptions;
import org.junit.runner.RunWith;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
@RunWith(CucumberExt.class) // CucumberExt allows several pre-processing of the feature before feeding Cucumber
@CucumberOptions(strict = true)
@CucumberExtOptions(filters = CommentDocBlockFilter.class)
public class RunCucumberTest {
}
