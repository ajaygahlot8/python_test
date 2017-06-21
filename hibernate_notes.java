1) steps to use hibernate
  a) create hibernate configuration file : hibernate.cfg.xml (default name of configuration file)//connection and shit
  b) Model object : using annotations
  c) service method : create model object and pass it to data layer so that we can save it using hibernate API
  d) database desgin : not needed
  e) dao method to save object using SQL queries : not needed


2) Model class


@Entity(name =  "USER_DETAILS")//this name will used as table name as well as entity name
                              //entity name is used in hsql
@Table(name = "TABLE_NAME") //this only changes the table name not entity name                              
Class UserDetails{

  @Id
  int id;

  @column(name= "USER_NAME")
  String name;
}
