package com.ebanks.java;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;


/**
 * The Class Nashorn. This class is used to test the Nashorn Javascript Engine for Java.
 */
@SuppressWarnings("restriction")
public class Nashorn {

	ScriptEngine nashorn;
	


	/**
	 * Instantiates a new nashorn.
	 */
	public Nashorn()
	{
		this.nashorn = new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	/**
	 * Gets the nashorn.
	 *
	 * @return the nashorn
	 */
	public ScriptEngine getNashorn() {
		return nashorn;
	}

	/**
	 * Sets the nashorn.
	 *
	 * @param nashorn the new nashorn
	 */
	public void setNashorn(ScriptEngine nashorn) {
		this.nashorn = nashorn;
	}
	
	/**
	 * Instantiates a new nashorn.
	 *
	 * @param nashorn the nashorn
	 */
	public Nashorn(ScriptEngine nashorn)
	{
		this.nashorn = nashorn;
		this.nashorn = new ScriptEngineManager().getEngineByName("nashorn");
	}
	
	/**
	 * Hello world javascript.
	 *
	 * @throws ScriptException the script exception
	 */
	public void helloWorldJavascript() throws ScriptException
	{
		nashorn.eval("print('Hello World!');");
	}
	
	/**
	 * Hello world javascript read from file.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws ScriptException the script exception
	 */
	public void helloWorldJavascriptReadFromFile() throws FileNotFoundException, ScriptException
	{
		nashorn.eval(new FileReader("script.js"));
	}
	
	/**
	 * Nashorn pass java script in parameter.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 */
	public void nashornPassJavaScriptInParameter(String javascript) throws ScriptException
	{
       // ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        //ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String scriptName = javascript;
        Bindings bindings = nashorn.createBindings();
        bindings.put("scriptFileName", scriptName);
        nashorn.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        nashorn.eval("load('src/main/resources/javascript/' + scriptFileName)");
        setNashorn(nashorn);
        
	}
	
	/**
	 * Nashorn pass java script in parameter return engine.
	 *
	 * @param javascript the javascript
	 * @return the script engine
	 * @throws ScriptException the script exception
	 */
	public ScriptEngine nashornPassJavaScriptInParameterReturnEngine(String javascript) throws ScriptException
	{
        String scriptName = javascript;
        Bindings bindings = nashorn.createBindings();
        bindings.put("scriptFileName", scriptName);
        nashorn.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        nashorn.eval("load('src/main/resources/javascript/' + scriptFileName)");
        return  nashorn;
        
	}
	
	/**
	 * Nashorn pass java script in parameter call first function.
	 *
	 * @param javascript the javascript
	 * @return the string
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public String nashornPassJavaScriptInParameterCallFirstFunction(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		Object result = invocable.invokeFunction("fun1", "Peter Parker");
		System.out.println(result);
		System.out.println(result.getClass());
		
        return result.toString();
        		
        
	}
	
	/**
	 * Nashorn pass java script in parameter call second function.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptInParameterCallSecondFunction(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		Object result = invocable.invokeFunction("fun2", new String("Peter Parker"));
		
		Object result2 = invocable.invokeFunction("fun2", new Date());
		// [object java.util.Date]

		Object result3 = invocable.invokeFunction("fun2", LocalDateTime.now());
		// [object java.time.LocalDateTime]

		Object result4 = invocable.invokeFunction("fun2", new Person("Eric", 22));
	
		System.out.println(result);
		// System.out.println(result.getClass());
		
		System.out.println(result2);
		// System.out.println(result2.getClass());
		
		System.out.println(result3);
		// System.out.println(result3.getClass());
		
		System.out.println(result4);
		// System.out.println(result4.getClass());
	}
	
	/**
	 * Nashorn pass java script in parameter call both function.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptInParameterCallBothFunction(String javascript) throws ScriptException, NoSuchMethodException
	{
     //   ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
     //   ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		nashornPassJavaScriptInParameterCallFirstFunction(javascript);
		nashornPassJavaScriptInParameterCallSecondFunction(javascript);
        
	}
	
	/**
	 * Nashorn pass java script in parameter call add.
	 *
	 * @param javascript the javascript
	 * @param firstnumber the firstnumber
	 * @param secondnumber the secondnumber
	 * @return the double
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public double nashornPassJavaScriptInParameterCallAdd(String javascript, int firstnumber, int secondnumber) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		Object result = invocable.invokeFunction("add", firstnumber, secondnumber);
		String stringResult = result.toString();
		double doubleResult = Double.parseDouble(stringResult);
				
		System.out.println(result);
		//System.out.println(result.getClass());
		return doubleResult;
        
	}
	
	
	public static String fun1(String name) {
	    System.out.format("Hi there from Java, %s ", name);
	    return "greetings from java";
	}
	
	public static void fun2(Object object) {
	    System.out.println(object.getClass());
	}
	
	public static String fun4(ScriptObjectMirror person) {
		Object fullName = person.callMember("getFullName");
	    System.out.println("Full Name is: " + person.callMember("getFullName"));
	    return fullName.toString();
	}
	
	/**
	 * Nashorn pass java script in parameter call from java script.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptInParameterCallFromJavaScript(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		Object result = invocable.invokeFunction("javaClassFun");
		System.out.println(result);
		//System.out.println(result.getClass());
        
	}
	
	/**
	 * Nashorn pass java script print person full name.
	 *
	 * @param javascript the javascript
	 * @return the string
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public String nashornPassJavaScriptPrintPersonFullName(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		//calls inner function in Javascript
		Object result = invocable.invokeFunction("printPerson");
		System.out.println(result);
		return result.toString();
		//System.out.println(result.getClass());
        
	}
	
	/**
	 * Nashorn pass java script print array list.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptPrintArrayList(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		//calls inner function in Javascript
		Object result = invocable.invokeFunction("printAllArrayListItems");
		System.out.println(result);
		//System.out.println(result.getClass());
        
	}
	
	
	/**
	 * Nashorn pass java script print hash map.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptPrintHashMap(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		//calls inner function in Javascript
		Object result = invocable.invokeFunction("printAllHashMapItems");
		System.out.println(result);
		//System.out.println(result.getClass());
        
	}
	
	/**
	 * Nashorn pass java script lambda expression.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptLambdaExpression(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		//calls inner function in Javascript
		List<String> result = (List<String>) invocable.invokeFunction("lambda");
		System.out.println(result);
		//System.out.println(result.getClass());
        
	}
	
	/**
	 * Nashorn pass java script extended thread.
	 *
	 * @param javascript the javascript
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptExtendedThread(String javascript) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		//calls inner function in Javascript
		Object result = invocable.invokeFunction("extendedClass");
		System.out.println(result);
		//System.out.println(result.getClass());
        
	}
	
	/**
	 * Nashorn pass java script accept function without parameter.
	 *
	 * @param javascript the javascript
	 * @param function the function
	 * @throws ScriptException the script exception
	 * @throws NoSuchMethodException the no such method exception
	 */
	public void nashornPassJavaScriptAcceptFunctionWithoutParameter(String javascript, String function) throws ScriptException, NoSuchMethodException
	{
		nashornPassJavaScriptInParameter(javascript);
		
		Invocable invocable = (Invocable) nashorn;

		//calls inner function in Javascript
		Object result = invocable.invokeFunction(function);
		System.out.println(result);

        
	}
}
