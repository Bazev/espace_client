package fr.humanbooster.fx.poussettes.servlets;

import fr.humanbooster.fx.poussettes.business.DemandeDePrix;
import fr.humanbooster.fx.poussettes.service.DemandeDePrixService;
import fr.humanbooster.fx.poussettes.service.impl.DemandeDePrixServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {
    private DemandeDePrixService demandeDePrixService = new DemandeDePrixServiceImpl();


    public ConfirmationServlet() {
        new DemandeDePrixServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ask", demandeDePrixService.getLastRequest().toString());

        request.getRequestDispatcher("WEB-INF/confirmation.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
