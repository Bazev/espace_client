package fr.humanbooster.fx.poussettes.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.poussettes.business.Poussette;
import fr.humanbooster.fx.poussettes.service.CouleurService;
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
    private CouleurService couleurService = new CouleurServiceImpl();

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
        String poussetteRecherche = null;
        List<Poussette> poussettesCorrespondantes = new ArrayList<>();
        List<Poussette> poussettes = poussetteService.recupererPoussettes();
        Long idColor = null;
        Long nbRoues = null;

        if (request.getParameter("POUSSETTE") != null) {
            poussetteRecherche = request.getParameter("POUSSETTE");
        }

        if (request.getParameter("COULEUR") != null && !request.getParameter("COULEUR").equals("")) {
            idColor = Long.parseLong(request.getParameter("COULEUR"));
        }
        if (request.getParameter("NBROUES") != null) {
            nbRoues = Long.parseLong(request.getParameter("NBROUES"));
        }
        for (Poussette poussette : poussettes) {
            if ((idColor == null || poussette.getCouleur().getId().equals(idColor))
                    &&
                    (poussetteRecherche == null || poussette.getNom().toLowerCase().contains(poussetteRecherche.toLowerCase()))
                    &&
                    (nbRoues == null || poussette.getNbRoues().equals(nbRoues))) {
                poussettesCorrespondantes.add(poussette);
            }
        }
        request.setAttribute("couleurs", couleurService.recupererCouleurs());
        request.setAttribute("poussettes", poussettesCorrespondantes);
        request.setAttribute("poussetteRecherche", poussetteRecherche);
        //request.setAttribute("poussettes", poussetteService.recupererPoussettes());
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