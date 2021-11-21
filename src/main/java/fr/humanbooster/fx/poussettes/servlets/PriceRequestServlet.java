package fr.humanbooster.fx.poussettes.servlets;

import fr.humanbooster.fx.poussettes.business.DemandeDePrix;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        if (request.getParameter("ID") != null) {
            Long idpoussette = Long.parseLong(request.getParameter("ID"));
            Poussette poussette = poussetteService.recupererPoussette(idpoussette);
            request.setAttribute("poussetteItem", poussette);
        }
        request.setAttribute("poussettes", poussetteService.recupererPoussettes());
        request.setAttribute("options", optionService.recupererOptions());
        request.getRequestDispatcher("WEB-INF/priceRequest.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateBegin = null;
        Date dateEnd = null;
        try {
            dateBegin = simpleDateFormat.parse(request.getParameter("dateBegin"));
            dateEnd = simpleDateFormat.parse(request.getParameter("dateEnd"));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        DemandeDePrix demandeDePrix = demandeDePrixService.ajouterDemandeDePrix(request.getParameter("email"),
                request.getParameter("poussette"), dateBegin, dateEnd, request.getParameter("info"));
//        ArrayList optionsList = new ArrayList<>();
//        optionsList.add(request.getParameter("option"));
        if (request.getParameter("option") != null)
        //Long idOption = Long.parseLong(request.getParameter("option"));
        Option option = optionService.recupererOption(idOption);
        System.out.println(option);
        demandeDePrixService.ajouterOption(demandeDePrix.getId(), option.getId());
        response.sendRedirect("confirmation");
    }
}
