package fr.humanbooster.fx.poussettes.servlets;

import fr.humanbooster.fx.poussettes.business.Option;
import fr.humanbooster.fx.poussettes.business.Poussette;
import fr.humanbooster.fx.poussettes.service.DemandeDePrixService;
import fr.humanbooster.fx.poussettes.service.OptionService;
import fr.humanbooster.fx.poussettes.service.PoussetteService;
import fr.humanbooster.fx.poussettes.service.impl.DemandeDePrixServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.OptionServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.PoussetteServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/priceRequest")
public class PriceRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DemandeDePrixService demandeDePrixService = new DemandeDePrixServiceImpl();
    private OptionService optionService = new OptionServiceImpl();
    private PoussetteService poussetteService = new PoussetteServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceRequestServlet() {
        new DemandeDePrixServiceImpl();
        new OptionServiceImpl();
        new PoussetteServiceImpl();
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idpoussette = Long.parseLong(request.getParameter("ID"));
        Poussette poussette = poussetteService.recupererPoussette(idpoussette);
        if (request.getParameter("ID") != null) {
            request.setAttribute("poussettes", poussette);
            System.out.println(poussette);
        }
        request.setAttribute("poussettes", poussetteService.recupererPoussettes());


        request.setAttribute("options", optionService.recupererOptions());
        request.getRequestDispatcher("WEB-INF/priceRequest.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
