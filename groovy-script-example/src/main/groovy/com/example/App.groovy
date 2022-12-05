package com.example

import java.util.stream.Collectors

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
		groovyShell =  new GroovyShell();
		
		loadDescriptor().invokeMethod("executeMe", null)
	}
	
	private Object loadDescriptor() {
		Object pluginDescriptor = bootStrapScript("Plugins.groovy")
		pluginDescriptor
	}
	
	Object bootStrapScript(String script) {
		
		String pluginsDir = System.getProperty("plugins_dir")
		if (pluginsDir != null) {
			script = pluginsDir + script
		} else {
			script = "/plugins/" + script
		}
		
		Object pluginScript = null
		println "bootStrapScript script: "+ script
		if (loadFromClasspath) {
			//pluginScript = new GroovyShell(this.class.getClassLoader()).evaluate(new File(script));		//<-- Line no:60
			
			//classLoader = new GroovyClassLoader(this.class.getClassLoader());
			/*String scriptUrl = Thread.currentThread().getContextClassLoader().getResource(script);
			groovyClassLoader = new GroovyClassLoader(scriptUrl);
			println "-> "+ groovyClassLoader.getClassPath()*/
			//println com.informatica.csm.plugins.PluginBootStrapper.class.getLocation().path
			
			/*groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
			pluginScript = groovyClassLoader.parseClass(new File(script));*/
			
			/*groovyScriptEngine = new GroovyScriptEngine('mvn-groovy-test-example-1.0-jar-with-dependencies.jar/').with {
			  loadScriptByName(script).newInstance()
			}*/
			/*String contents = null
			InputStream inputStream = getClass().getResourceAsStream("/"+script);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) 
				//contents = reader.lines().collect(Collectors.joining(System.lineSeparator()));
			pluginScript = new GroovyShell().parse(reader);*/
			
			
			/*URL jar = new URL('jar:file:./mvn-groovy-test-example-1.0-jar-with-dependencies.jar!/') //jar url must end with !/
			groovyScriptEngine = new GroovyScriptEngine(jar)
			pluginScript = groovyScriptEngine.loadScriptByName('desc/Plugins.groovy').newInstance()*/
			
			if (this.loadFromClasspath) {			
				InputStream inputStream = getClass().getResourceAsStream(script);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) 
				pluginScript = groovyShell.parse(reader);
				return pluginScript
			} else {
				pluginScript = groovyScriptEngine.loadScriptByName(script).newInstance()
				return pluginScript
			}
			
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
