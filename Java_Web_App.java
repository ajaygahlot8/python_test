1) Basic of web application
  // When you hit google.com in browser ... request is sent to web server
  // from there http request converts into servlet request then response is created
  // then response converted into http response and sent back to client

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

request.getParameter("email","cuzook@gmail.com"); // to get email from form

request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);

7) jsp
  JSP internally gets converted into servlet only
request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response); //here we are passing request and response to the jsp servlet
                                                                                  //and it internally sends the response back
use jstl in jsps
${batsmanName}



















































...................
