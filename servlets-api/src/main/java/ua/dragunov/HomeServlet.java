package ua.dragunov;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private Set<String> ips = new ConcurrentSkipListSet<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ips.add(req.getRemoteHost() + " " + req.getHeader("User-Agent"));

        PrintWriter writer = resp.getWriter();

        for (String ip : ips) {
            if (ip.equals(req.getRemoteHost() + " " + req.getHeader("User-Agent")))
                writer.println(String.format("<b>%s</b>", ip));
            else writer.println(ip);
        }
    }
}
