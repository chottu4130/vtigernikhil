package practice;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetestPractice implements IRetryAnalyzer
{
	int count=0;
	int retryLimit=4;
	public boolean retry(ITestResult result) {
		if(count<retryLimit)
		{
		count++;
		return true;
		}
		return false;
	}
	
		
	}
	

