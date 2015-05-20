package com.ebanks.java;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NashornTest {

	
	String javascript;
    @Before
    public void setUp() {
    	javascript = "script.js";
        System.out.println("@Before - setUp");
    }
    
	@Test
	public void testHelloWorldJavascript() throws Exception {
        Nashorn nashorn = new Nashorn();
        nashorn.helloWorldJavascript();
	}

	@Test
	public void testHelloWorldJavascriptReadFromFile() throws Exception {
        Nashorn nashorn = new Nashorn();
        nashorn.helloWorldJavascriptReadFromFile();
	}
	
	@Test
	public void testNashornPassJavaScriptInParameter() throws Exception {
      //  String javascript = "script.js";
        
        Nashorn nashorn = new Nashorn();
        nashorn.nashornPassJavaScriptInParameter(javascript);
	}
	
	@Test
	public void testNashornPassJavaScriptInParameterCallFirstFunction() throws Exception {
      //  String javascript = "script.js";
        
        Nashorn nashorn = new Nashorn();
        String result = nashorn.nashornPassJavaScriptInParameterCallFirstFunction(javascript);
        assertEquals("greetings from javascript", result);
	}
	
	@Test
	public void testNashornPassJavaScriptInParameterCallSecondFunction() throws Exception {
      //  String javascript = "script.js";
        
        Nashorn nashorn = new Nashorn();
        nashorn.nashornPassJavaScriptInParameterCallSecondFunction(javascript);
	}
	
	@Test
	public void testNashornPassJavaScriptInParameterCallBothFunction() throws Exception {
      //  String javascript = "script.js";
        
        Nashorn nashorn = new Nashorn();
        nashorn.nashornPassJavaScriptInParameterCallBothFunction(javascript);
	}

	@Test
	public void testNashornPassJavaScriptInParameterCallAdd() throws Exception {
		//   String javascript = "script.js";
	        
	        Nashorn nashorn = new Nashorn();
	        int firstNumber = 5;
			int secondNumber = 6;
			double result = 11;
			double finalResult = nashorn.nashornPassJavaScriptInParameterCallAdd(javascript, firstNumber, secondNumber);
			assertEquals(finalResult, result, 0);
	}
	
	
	@Test
	public void testNashornPassJavaScriptInParameterCallFromJavaScript() throws Exception {
		 //  String javascript = "script.js";
	        
	        Nashorn nashorn = new Nashorn();
			nashorn.nashornPassJavaScriptInParameterCallFromJavaScript(javascript);
	}
	
	
	@Test
	public void testNashornPrintPersonFullName() throws Exception {
		 //  String javascript = "script.js";
	        
	        Nashorn nashorn = new Nashorn();
			String fullName = nashorn.nashornPassJavaScriptPrintPersonFullName(javascript);
			assertEquals(fullName, "Test Name");
	}

	@Test
	public void testNashornPassJavaScriptPrintHashMap() throws Exception {
		//   String javascript = "script.js";
	        
	        Nashorn nashorn = new Nashorn();
			nashorn.nashornPassJavaScriptPrintArrayList(javascript);
	}

	@Test
	public void testNashornPassJavaScriptPrintArrayList() throws Exception {
		 //  String javascript = "script.js";
	        
	        Nashorn nashorn = new Nashorn();
			nashorn.nashornPassJavaScriptPrintHashMap(javascript);
	}

	@Test
	public void testNashornPassJavaScriptLambdaExpression() throws Exception {
		//   String javascript = "script.js";
	        
	        Nashorn nashorn = new Nashorn();
			nashorn.nashornPassJavaScriptLambdaExpression(javascript);
	}

	@Test
	public void testNashornPassJavaScriptExtendedThread() throws Exception {
		//   String javascript = "script.js";
	        
	        Nashorn nashorn = new Nashorn();
			nashorn.nashornPassJavaScriptExtendedThread(javascript);
	}
}
