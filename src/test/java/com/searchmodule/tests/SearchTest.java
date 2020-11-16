package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@BeforeTest
	public void bftest() {
		System.out.println("inside searchtest beforetest");
	}

	@Test
	@Parameters({ "keyword" })
	public void search(String keyword) throws IOException {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int size = searchPage.getResult();

		Assert.assertTrue(size > 0);

		Properties p = new Properties();
		String file = "data.properties";
		// FileReader reader=new
		// FileReader(System.getProperty("user.dir")+"/src/test/resources/data.properties");
		InputStream reader = getClass().getClassLoader().getResourceAsStream(file);
		p.load(reader);

		System.out.println("Hello this is my sample string " + p.getProperty("sampleString"));
	}

}
