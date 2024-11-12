package iameter;

import local.ptdemo.appsec.poc.missing.Condition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;

@WebServlet(name = "_06_Base64Semantics", value = "/_06_Base64Semantics")
public class _11_MissingPackagesCondition extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter responseWriter = response.getWriter();
        String parm1 = request.getParameter("parm1");

        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        if (Condition.check(1) != 1)
            // True positive if Condition.check(1) NOT equals to one
            responseWriter.println(parm1);
        else
            responseWriter.println("OK");
    }
}
