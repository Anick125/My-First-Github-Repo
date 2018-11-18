package com.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\user\\eclipse-workspace\\BDDProject1\\login.feature"}
, tags= {"@Smoke"},glue= {"com.test"},dryRun=false)
public class Runner {

	
	
}
