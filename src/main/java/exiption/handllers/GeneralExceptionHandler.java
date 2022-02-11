package exiption.handllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GeneralExceptionHandler")
public class GeneralExceptionHandler extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processError( request, response);
    }

    private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Throwable attribute = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String name = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (code==500)
        {
            out.println("<h1>Error page</h1>");
            out.println("<h1>status code/h1>");
            out.println(code);
        }else if (code==404){
            out.println("<h1>Exception Error</h1>");
            out.println(code);
        }
    }
}

