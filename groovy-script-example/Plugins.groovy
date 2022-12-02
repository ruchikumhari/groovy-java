package desc

def getAllPlugins() {
	List<Map> allPlugins = new ArrayList<Map>()
	
	allPlugins.add(linux())
	allPlugins.add(windows())
	
	allPlugins	
}

def executeMe() {
	println "Inside Plugins>executeMe"
}

def linux() {
	Map linuxPlugin = ["name": "ia64"]
	linuxPlugin
}
def windows() {
	Map windowsPlugin = ["name": "10"]
	windowsPlugin
}