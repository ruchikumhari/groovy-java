# Problem description
This is an existing problem that has been discussed on [stackoverflow](https://stackoverflow.com/questions/74569226/how-to-load-groovy-scripts-from-within-the-jar-file/74606781?noredirect=1#comment131768662_74606781), and this project contains only the bare necessities for experimenting with it. I'm attempting to use the App.groovy main class to execute the groovy scripts contained within the fat jar.

## Main intent
1. Have groovy scripts packaged inside the fat jar. <done>
2. Execute the fat jar and run `executeMe` function from each of these groovy script files (Plugins.groovy, Windows.groovy, Linux.groovy). <Stuck :(>

I have also provided build and run commands and also current exception in this Readme file.

# Java & Maven details
Java version: 1.8.0_302
Maven version: 3.2.5
Groovy: 4.0.6

# Project creation
mvn archetype:generate -DgroupId=com.example -DartifactId=mvn-groovy-test-example -DinteractiveMode=false
mvn clean install eclipse:clean eclipse:eclipse

# Resources
https://stackoverflow.com/questions/4971566/create-eclipse-groovy-java-project-with-maven

# Build
mvn clean install

# Run CMD
java -cp mvn-groovy-test-example-1.0-jar-with-dependencies.jar; com.example.App %* 

# Present Error
Exception in thread "main" java.io.FileNotFoundException: C:\Share\groovy-script-example\target\Plugins.groovy (C:\Share\groovy-script-example\target\Plugins.groovy)
        at groovy.lang.GroovyCodeSource.<init>(GroovyCodeSource.java:107)
        at groovy.lang.GroovyClassLoader.parseClass(GroovyClassLoader.java:245)
        at groovy.lang.GroovyClassLoader$parseClass.call(Unknown Source)
        at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:45)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:125)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:139)
        at com.example.App.bootStrapScript(App.groovy:38)
        at com.example.App.loadDescriptor(App.groovy:21)
        at com.example.App.<init>(App.groovy:17)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
        at org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:73)
        at org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrapNoCoerce.callConstructor(ConstructorSite.java:108)
        at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:57)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:263)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:268)
        at com.example.App.main(App.groovy:50)
