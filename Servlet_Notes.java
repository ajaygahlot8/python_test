1) Web Server > Web Container > Web Application

2) Tomcat is servlet container . Web Container or Servlet Container or Servlet Engine :
 is used to manage the components like servlets, JSP.It is a part of the web server.

3)Web Server or HTTP Server: a server which is capable of handling HTTP request send by a client
and respond back with a HTTP response.

4)



MAVEN:-------------
1)
    Beginner - POM + build life cycle
    Intermediate - dependency management + transitive dependency
    Multi Module Project - modules like business layer n shit
    How to develop WAR

2)Convention over configuration
    Means setting defaults
    src>main>java n shit

3) create default folder structure and add pom.xml
  Maven commands :
    1) mvn compile - //creates target folder and adds classes folder where all .class files gets saved
        uses 2 plugins : maven-resources-plugin + maven-compiler-plugin

    2) mvn test-compile //creates folder test-classes inside target folder
        uses 4 plugins : maven-compiler-plugin:compile ///here it will compile src main folder even though we ran test-compile
                         maven-compiler-plugin:testCompile
                         and 2 resources plugin shit

    3) mvn clean - //deletes the target directory

    4) mvn test -// it runs mvn compile + mvn test compile + run the junit test and show result
      compiles src file then compiles test files then run the junit test


    5) mvn install -// run all phases till install{ //creates couple of folders inside target folder
          for pacakaging it uses plugin {maven-jar-plugin:jar} which creates jar inside target folder
          in install phase it copies the jar inside target folder and copies it to local maven repository {default inside .m2 folder }
    }
4) build life cycle  phases: validate>compile>test>package>integration test >verify>install>deploy

    each phase  calls the previous phase //i.e. when mvn install -- maven calls all phases validate>compile>test>package>integration test >verify>install
    you can add plugins to specific phase i.e for test phase you can add junit plugin
    default plugins defined for different phases are defined in parent pom.xml{super pom}


5) POM.xml
It Defines
  1. Name  //Name of project others can inject through
      Combination of group-id and artifact-id
      <groupId>net.atos.wlp.common.abo.pom</groupId>
      <artifactId>wlp-super-pom-abo</artifactId> //it has to be unique so we can make it unique by changing group id also

  2. Version //version of project //SNAPSHOT-90
    <version>5.2.2.056-DEV-SNAPSHOT</version>

  3. Packaging //war, jar
    <packaging>jar</packaging> //jar , war ,ear and pom

  4. Dependencies // importing other jars // Maven checks the Online Maven Repository and download the jars into localrepository
                  //so that next time you want to use the specific version jar , it checks local Repositoryfirst
        <dependency>
            <groupId>net.atos.xa.resourcelocator</groupId>
            <artifactId>xa-rl-core</artifactId>
            <version>${xa.rl.core.version}</version>
        </dependency>
  5. Plugins // helps us with functionality like maven-compiler-plugin to compile the code , each plugin is specified to specific phase
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <configuration>
            <source>1.8</source> //it specifies what jdk version to use //here you can change the version of java you use
            <target>1.8</target>  //right click to project go to update after changing version
          </configuration>
        </plugin>

6) transitive dependency //when one dependency depends on other dependencies example hibernate dependency
                        // when you import hibernate , the jars hibernate depends on gets included too.
                        //when you right click on a dependency you will see the pom.xml of that dependency

                        <dependency>
                    			<groupId>org.hibernate</groupId>
                    			<artifactId>hibernate-ehcache</artifactId>
                    			<exclusions> //if you want to exclude any specific transitive dependency
                    				<exclusion>
                    					<groupId>org.hibernate</groupId>
                    					<artifactId>hibernate-core</artifactId>
                    				</exclusion>
                    			</exclusions>
                    		</dependency>

      CLick on dependency hierarchy TAB to see through which dependency specific dependency is coming

 7) <scope> // it specifies at which phase you want to use the dependency

      <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <scope>test</scope> //normally this dependency will get used in every phase but by specifying
                          //scope you know that it should only be used in specific phase
       <scope>provided</scope>//means maven doesnt need to get it because it is already provided by web server
       <scope>runtime</scope>//means it will only be available at runtime not at compile time,
                              //hence if u want to access it in your code build will fail
      </dependency>

 8) Effective pom directory TAB
  it follows inheritance
  it contains everything from your pom.xml + parent pom.xml +super pom.xml
  under <build> you can see tags like
  <build>
    <sourceDirectory>C:\Users\a622719\Desktop\workspace_22_may\abo_22_may\wlp-acs-vac\wlp-acs-vac-core\src\main\java</sourceDirectory>
    <scriptSourceDirectory>C:\Users\a622719\Desktop\workspace_22_may\abo_22_may\wlp-acs-vac\wlp-acs-vac-core\src\main\scripts</scriptSourceDirectory>
    <testSourceDirectory>C:\Users\a622719\Desktop\workspace_22_may\abo_22_may\wlp-acs-vac\wlp-acs-vac-core\src\test\java</testSourceDirectory>
    <outputDirectory>C:\Users\a622719\Desktop\workspace_22_may\abo_22_may\wlp-acs-vac\wlp-acs-vac-core\target\classes</outputDirectory>
    <testOutputDirectory>C:\Users\a622719\Desktop\workspace_22_may\abo_22_may\wlp-acs-vac\wlp-acs-vac-core\target\test-classes</testOutputDirectory>


      if you want to change any default tag just add it in your own pom.xml and you will overwrite it
    and now in EFFECTIVE pom.xml you will see updated value
 9) Execution and goals


 <plugin>
   <artifactId>maven-compiler-plugin</artifactId>
   <version>2.3.2</version>
   <executions>
     <execution>
       <id>default-compile</id>
       <phase>compile</phase> //phase
       <goals>
         <goal>compile</goal> //this goal to run in phase defined above
       </goals>
       <configuration>
         <source>1.8</source>
         <target>1.8</target>
         <encoding>UTF-8</encoding>
       </configuration>
     </execution>
     <execution>


10)   Multi Module Project
  1)<packaging>pom</packaging> // it defines that this pom.xml is parent to child poms
    //you have to define the child in this parent pom.xml as
    <modules>
      <module>wlp-acs-vac-core</module>//name of modules should be similar to folder name
      <module>wlp-acs-vac-config</module>
      <module>wlp-acs-vac-admin</module>
      <module>wlp-acs-vac-provider</module>
      <module>wlp-acs-vac-batch</module>
      <module>wlp-acs-vac-plapi</module>
      <module>wlp-acs-vac-test</module>
      <module>wlp-acs-vac-functional</module>
   </modules>

 2) dependency without version
  if you see any dependency without version tag that means the version of that dependency is defined in either same pom.xml
  or in parent pom.xml in <properties> tag

  <properties>
		<xa.rl.core.version>2.2.1</xa.rl.core.version>
	</properties>

  <dependency>
			<groupId>net.atos.xa.resourcelocator</groupId>
			<artifactId>xa-rl-core</artifactId>
			<version>${xa.rl.core.version}</version> //here version is defined in properties tag
	</dependency>


11)  tips and tricks
 mvn -X clean //to get detailed information it prints all the debug information
 mvn help:effective-settings // settings used by maven in my system like path of local repo n all
 mvn archetype:generate  //to generate the struture of type of project you want to build
