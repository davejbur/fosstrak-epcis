package org.fosstrak.epcis.repository;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This is a wrapper for the default Servlet which handles requests to
 * static content.
 *
 * @author Marco Steybe
 */
public class StaticContentServlet extends HttpServlet {

    private static final Log LOG = LogFactory.getLog(StaticContentServlet.class);
    private static final long serialVersionUID = 1L;

    //FIX - static content doesn't seem to work...!
    @Override
    public void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getNamedDispatcher("default");
        HttpServletRequest wrapped = new HttpServletRequestWrapper(req) {
            @Override
            public String getPathInfo() {
                if (LOG.isDebugEnabled())
                {
                  LOG.debug("Doing getpathinfo: "+req.getPathInfo());
                }
                return "/static" + req.getPathInfo();
            }
        };
        if (LOG.isDebugEnabled())
        {
          LOG.debug("Doing rd.forward: "+wrapped.getPathInfo()+", "+resp.toString());
        }
        rd.forward(wrapped, resp);
    }
}
