package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	private Iservice service = new ServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1- récupération des données
		String nom;
		String prenom;
		int age;
		int id;
		int adr;
		String log;
		String mdp;
			 //Faire traitement A
			if(request.getParameter("nom")!=null) {
				age = Integer.parseInt(request.getParameter("age"));
				nom = request.getParameter("nom");
				prenom = request.getParameter("prenom");
				adr = Integer.parseInt(request.getParameter("idAdresses"));
				log = request.getParameter("login");
				mdp = request.getParameter("mdp");

			//2- envoyer à la couche service
			Personne p = new Personne();
			p.setAge(age);
			p.setNom(nom);
			p.setPrenom(prenom);
			
			Connexion c = new Connexion();
			
			c.setLogin(log);
			c.setMdp(mdp);
			
			p.setConnexion(c);
			
			if(adr!=0) {
                p.setAdresse(service.getAdresse(adr));
            }
			
			
			
			
			if(request.getParameter("ajouter")!=null){
				service.ajouterPersonne(p);
			}
			if(request.getParameter("modifier")!=null) {
				id = Integer.parseInt(request.getParameter("id"));//name input personne jsp
				p.setIdPersonne(id);
				service.modifierPersonne(p);
			}
		}
		
		
		//3 - préparation à l'envoi
		request.setAttribute("personne", service.findAllPersonnes());
		request.setAttribute("adresses", service.findAllAdresses());
		
		//4- appel de la jsp
		request.getRequestDispatcher("personne.jsp")
		.forward(request, response);
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
