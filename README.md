# vaadin-visjs-dot-component
showcase of displaying graphviz dot-graphs in a vaadin-component using vis-network (visjs)


gradle multi-project with sub-projects
  
  :lib
  
  :example-webapp
  
project :lib contains the custom vaadin (web) component VisJsDotComponent and can be build as a jar.

project :example-webapp is a clone of https://github.com/vaadin/base-starter-spring-gradle and shows how to use the component

see [MainView](https://github.com/olafj/vaadin-visjs-dot-component/blob/5ac853ff950e2abc5acb3f2400ae170c568c61bc/example-webapp/src/main/java/com/example/demo/MainView.java) for more details

command to run example-webapp: 
<pre>./gradlew bootRun</pre>

open http://localhost:8080/ in browser
