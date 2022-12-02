package com.example

/**
 * A Test project to load groovy scripts from within the jar file. This creates a fat jar with all dependencies.
 * Build Command: mvn clean install
 * Run Command: java -cp mvn-groovy-test-example-1.0-jar-with-dependencies.jar; com.example.App %*
 * 
 */
public final class App {
	
	private GroovyScriptEngine groovyScriptEngine = null;
	private GroovyShell groovyShell;
	private GroovyClassLoader groovyClassLoader = null;
	private Boolean loadFromClasspath = true;
	
	public App() {
		loadDescriptor().invokeMethod("executeMe", null)
	}
	
	private Object loadDescriptor() {
		Object pluginDescriptor = bootStrapScript("Plugins.groovy")
		pluginDescriptor
	}
	
	Object bootStrapScript(String script) {
		Object pluginScript = null
		println "bootStrapScript script: "+ script
		if (loadFromClasspath) {
			//pluginScript = new GroovyShell(this.class.getClassLoader()).evaluate(new File(script));		//<-- Line no:60
			
			//classLoader = new GroovyClassLoader(this.class.getClassLoader());
			/*String scriptUrl = Thread.currentThread().getContextClassLoader().getResource(script);
			groovyClassLoader = new GroovyClassLoader(scriptUrl);
			println "-> "+ groovyClassLoader.getClassPath()*/
			//println com.example.App.class.getLocation().path
			
			groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
			pluginScript = groovyClassLoader.parseClass(new File(script));
			return pluginScript
		} else {
			pluginScript = groovyScriptEngine.loadScriptByName(script).newInstance()
			return pluginScript
		}
		
		println "Returning pluginScript as null"
		return pluginScript
	}
	
    public static void main( String[] args ) {
        App app = new App()
    }
}
