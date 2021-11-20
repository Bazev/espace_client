package fr.humanbooster.fx.poussettes.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.poussettes.business.Poussette;
import fr.humanbooster.fx.poussettes.service.PoussetteService;
import fr.humanbooster.fx.poussettes.service.impl.CouleurServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.OptionServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.PoussetteServiceImpl;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PoussetteService poussetteService = new PoussetteServiceImpl();
    private List<Poussette> poussettes = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        new CouleurServiceImpl();
        new OptionServiceImpl();
        new PoussetteServiceImpl();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("poussettes", poussetteService.recupererPoussettes());
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}