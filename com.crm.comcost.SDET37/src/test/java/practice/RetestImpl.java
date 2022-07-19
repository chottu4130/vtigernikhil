package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetestImpl
{
	@Test(retryAnalyzer = practice.RetestPractice.class)
	public void pract()
	{
		System.out.println("fgyhjnkm");
		Assert.fail();
		System.out.println("xdxfcvgbhnjmk");
	}
}
