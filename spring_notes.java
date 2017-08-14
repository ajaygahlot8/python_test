1) @component

  class A{
    @Autowired //Spring injects the dependency here means it will create the object and assign it to b;
              //telling spring to find the right bean and inject it
    B b;// spring ioc container will create the object and
  }


@component //this makes object of this class managed by spring ioc container
          //this is a bean .. basically every class is a bean
  class B{

  }

2) component scan
in spring-config.xml

<context:component-scan base-package="com.org.cuzok.model"/> //spring gets application context from here
//here the spring ioc container will look for all the components when the server is started
//specifying the base package makes up for the path where component might be present

3)

class Alpha{

  @Autowired
  @Qualifier(value="goodMorning") //either you can give the class name here in camel case or as reference name
  InterfaceBeta goodMorning //if ypu have more than 2 classes implementing interface that you are autowiring
                            //then you can either specify name of the class as reference name

}

class GoodMorning implements InterfaceBeta{

}

4) dependency injection

Class First{

  @Autowired //spring will find the implementation of this class and provide u the object
  Second sub;//it can be a interface or a class but if its an interface then spring will find the implementation a
            // and prvoide u the object to use it directly
            //in future if you change implementation of class Second then u dont have to do any change in Class First
}
Real life scenario :
lets suppose u need to test ur spring application then you can easily change the implementation class for Second
in the configuration(spring.xml) setting and for testing u can use the  mock or stub instead of real implementation
the mock or stub will be initialized with the dummy data so that test can run

Inversion of control :
Earlier the control was with Class First but using dependency injection control is with spring hence Inversion of control

5) Spring singleton bean //default scope for bean
  generally singleton pattern means one instance per classloader or jvm
  in spring singleton means one instance of bean per application context/container

6)  prototype scope for bean
if you want to create more than 1 instance for any bean then you have to specify the scope as prototype
a new instance is created every time a request for bean is made

<bean id="state" class="com.org.Users" scope="prototype">


@Component
@Scope("singleton")//here you can specify the scope
public class TennisCoach implements Coach {





7) spring notes from Spring in application

  1) “Dependency injection involves giving an object its dependencies as opposed to an object having to acquire those dependencies on its own.”

Excerpt From: iBooks.

  2) “Spring employs four key strategies:

      “Lightweight and minimally invasive development with POJOs
      Loose coupling through DI and interface orientation
      Declarative programming through aspects and common conventions
      Eliminating boilerplate code with aspects and templates”

Excerpt From: iBooks.













..
