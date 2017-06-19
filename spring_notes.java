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

  @Autowired
  Second sub;//it can be a interface or a class but if its an interface then spring will find the implementation a
            // and prvoide u the object to use it directly
            //in future if you change implementation of class Second then u dont have to do any change in Class First
}
