package iameter;

import local.ptdemo.appsec.poc.missing.Filter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "_06_Base64Semantics", value = "/_06_Base64Semantics")
public class _11_MissingPackages extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final PrintWriter responseWriter = response.getWriter();
        String parm1 = request.getParameter("parm1");

        parm1 = Filter.sanitizeOne();

        // True positive if sanitizeOne is implemented improperly
        responseWriter.println(parm1);
    }

}
