1) Basic of web application
  // When you hit google.com in browser ... request is sent to web server
  // from there http request converts into servlet request then response is created
  // then http servlet response converted into http response and sent back to client

2) Basic request flow in java web application

3)web.xml

src>main>webapp>WEB-INF>web.xml
//it is the first file java web application looks into when it gets the request

4) Servlet class
  -every servlet class extends HttpServlet Class

  @WebServlet(urlPatterns = "/first") //here we specify the url for this servlet
  public class FirstServlet extends HttpServlet {

  }

5) create jsp files inside
src>main>webapp>WEB-INF>views>index.jsp

6)request dispatcher
through request dispatcher we can link jsp with servlet
request.setAttribute("bastmanName","Sachin") //now we can use this attribute in jsp using expression language ${batsmanName}
                                            //this is the step where you can get data from database and get the value

request.getParameter("email"); // to get email from form
request.setParameter("email","cuzook@gmail.com");//to set parameters
request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
String[] multiplevalues = request.getParameterValues("checkbox_or_selectbox");//we will get the multiple values and we have to store into String array

7) jsp
  JSP internally gets converted into servlet only
request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response); //here we are passing request and response to the jsp servlet
                                                                                  //and it internally sends the response back
use jstl in jsps
${batsmanName}

8) Session in servlet //sessions are per browser and user
  HTTPSession session = request.getSession(); //to get the session object of particular request
  session.setAttribute("username","ajay"); //set data into the session and it will persist through whole session
  session.getAttribute(username);

9) Context Object //context is per web application
  ServletContext context = request.getServletContext();
  context.setAttribute("name","ajay");
  context.getAttribute("name")

10) initParams in servlet
@WebServlet(urlPatterns={"/home"},
initParams={@WebInitParam={name="username", value="ajay"}}) //here we are setting the parameters

//to get the parameters we have to get config Object

this.getServletConfig().getInitParameter("username"); //you can do same shit in web.xml using servlet tag




12)   1) Web Server > Web Container > Web Application

    2) Tomcat is servlet container . Web Container or Servlet Container or Servlet Engine :
     is used to manage the components like servlets, JSP.It is a part of the web server.

    3)Web Server or HTTP Server: a server which is capable of handling HTTP request send by a client
    and respond back with a HTTP response.

    4) A web server is a computer system that processes requests via HTTP,
    the basic network protocol used to distribute information on the World Wide Web.
     The term can refer to the entire system, or specifically to the software that accepts and supervises the HTTP requests.

     So Apache is a web server and its basic functionality is to process http request

     5)   A web container also known as a servlet container is the component of a web server
         that interacts with Java servlets. A web container is responsible for managing the lifecycle of servlets,
         mapping a URL to a particular servlet and ensuring that the URL requester has the correct access-rights.

         A web container handles requests to servlets, JavaServer Pages (JSP) files, and other types of files that include server-side code.
         The Web container creates servlet instances, loads and unloads servlets, creates and manages request and response objects,
         and performs other servlet-management tasks.

         A web container implements the web component contract of the Java EE architecture, specifying a runtime environment for web components
         that includes security, concurrency, lifecycle management, transaction, deployment, and other services.

      EXAMPLE: JBOSS, APACHETOMCAT are web containers who are part or component of web server and servers and maintains servlets

      6) life cycle of Servlet
      The following is a typical user scenario of these methods.

          Assume that a user requests to visit a URL.
            The browser then generates an HTTP request for this URL.
            This request is then sent to the appropriate server.
          The HTTP request is received by the web server and forwarded to the servlet container.
            The container maps this request to a particular servlet.
            The servlet is dynamically retrieved and loaded into the address space of the container.
          The container invokes the init() method of the servlet.
            This method is invoked only when the servlet is first loaded into memory.
            It is possible to pass initialization parameters to the servlet so that it may configure itself.
          The container invokes the service() method of the servlet.
            This method is called to process the HTTP request.
            The servlet may read data that has been provided in the HTTP request.
          The servlet may also formulate an HTTP response for the client.
            The servlet remains in the container's address space and is available to process any other HTTP requests received from clients.
            The service() method is called for each HTTP request.
          The container may, at some point, decide to unload the servlet from its memory.
          ``The algorithms by which this decision is made are specific to each container.
          The container calls the servlet's destroy() method to relinquish any resources such as file handles that are allocated for the servlet;
           important data may be saved to a persistent store.
              The memory allocated for the servlet and its objects can then be garbage collected.


13) jsp
  //every jsp file gets converted into a servlet class file by tomcat and you can view it
  //inside tomcat folder > work >catalina>localhost> project name > org>net .......
 jsp directives
 <%@ page import="java.Date" %> //to import java classes into jsp
 <%@ include file="/new_file.jsp" %> //to import other jsp files which has html content
 <%! int add(){} %> // here you declare methods
 <% int i = 10%> //here you write java code
 <%= i %> //here you use the value of i

 <%
request.getParameter();// we can access request object because this code is already written iside Service method of JSP java file
session.getAttribute();//we dont have to use request.getSession(); in jsps because session object is given to us
application.getAttribute(); //this is ServletContext and we dont have to write request.getServletContext(); inste4ad just use application
pageContext.setAttribute("username ","ajay",PageContext.APPLICATION_SCOPE);//you can access all type of scopes with pageContext

+-------------+------------------------------------------------------+
| Scope       | Description                                          |
+-------------+------------------------------------------------------+
| page        | Objects can be accessed only within the JSP page     | //Since every page and every request has a different PageContext object,
|             | in which they are referenced.                        | //this indicates that the bean is not shared and thus a new bean will be created for each request.
+-------------+------------------------------------------------------+
| request     | Objects can be accessed within all the pages that    |
|             | serve the current request. These include pages       |
|             | that are forwarded to, and included in, the original |
|             | JSP page to which the request was routed.            |
+-------------+------------------------------------------------------+
| session     | Objects can only be accessed within the JSP pages    |
|             | accessed within the session for which the objects    |
|             | are defined.                                         |
+-------------+------------------------------------------------------+
| application | Application scope objects can be accessed by all     |
|             | JSP pages in a given context.                        |
+-------------+------------------------------------------------------+


 %>

 servlet config is use to set initParameters we can do that in web.xml even for jsp file also or inside web.xml using simple servlet class
 or using annotations we can set initParameters
14) content type
//it states that when respose comes to browser then how to format the response example html ,json , ...

15) request dispatcher
  response.sendRedirect("sucess.jsp"); //when we do this a whole new request is sent from browser side .
                                      //so if you want to send data to next request you have to use
                                      //session scope.

  RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
  dispatcher.forward(request,response); // here the request is sent from server side only not from browser


































...................
