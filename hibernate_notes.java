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

  @Id @GeneratedValue(strategy=GenerationType.AUTO) //to generate value for surrogate keys
  int id;

  @column(name= "USER_NAME")
  String name;

  @Basic //to override defaults set by hibernate like datatype for sql n all
  String last_name;

  @Transient //if you dont want this field to set in database
  String first_name;

  @Temporal(TemporalType.DATE) //to store only date
  Date dob

  @Lob // if string then stores in db as CLOB if byte array then stores as BLOB
  String description
}


3) sessionFactory object is very heavy object and it is one per application
 if you want to communicate with db you had to have a session factory object

 SessionFactory session = new Configuration.configure().buildSessionFactory();
 //configure method will get the configuration from hibernate.cfg.xml
 session.beginTransaction();
 session.save(user);//ready to save into db
 session.getTransaction().commit(); // gets into db
// above code is inside try block and in catch block transaction is rolledback
 session.close(); //this line comes in finally block

4) to get stuff from db
User user = (User)session.get(Users.class,5); //second argument is primary key


6) Embedded objects

class User{

  @EmbeddedId //if primary key is embedded
  UserID id;

  @Embedded //this means the all variables of object will be made as column inside User table
  Adress add


  @Embedded
  @AttributeOverrides({ //we use it because only one object  can be embedded and use the column name of embedded object
    @AttributeOverride(name="city" , column=@Column(name="HOME_CITY")),
  })
  Address homeAddres;
}
@Embeddable // means no seperate table will be created for it
Class Address{


}

















 ...
