package Tutores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (value = "/tutores")
public class CadastroTutor extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		
		Tutores novoTutor = new Tutores();
		novoTutor.setNome(nome);
		
		BancoTutores.salvar(novoTutor);
		
		PrintWriter writer = resp.getWriter();
		writer.printf("Tutor cadastrado com sucesso! Nome: %s", 
				novoTutor.getNome());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		List<Tutores> tutoresCadastrados = BancoTutores.buscar();
		
		PrintWriter writer = resp.getWriter();
		
		for(Tutores tutor : tutoresCadastrados) {
			writer.printf("ID: %d, Nome: %s", tutor.getId(),tutor.getNome());
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		List<Tutores> tutoresCadastrados = BancoTutores.buscar();
		Tutores tutorAntigo = null;
		
		for (Tutores tutor : tutoresCadastrados) {
			if(tutor.getId() == Integer.parseInt(req.getParameter("id"))) {
				tutorAntigo = tutor;
				break;
			}
		}
		
		String nome = req.getParameter("nome");
		
		if(tutorAntigo != null && nome != null) {
			tutorAntigo.setNome(nome);
		} else {
			resp.setStatus(404);
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	
		List<Tutores> tutoresCadastrados = BancoTutores.buscar();
		Tutores tutorParaDeletar = null;
		
		for (Tutores tutor : tutoresCadastrados) {
			if(tutor.getId() == Integer.parseInt(req.getParameter("id")) && tutor.getNome() != null) {
				tutoresCadastrados.remove(tutorParaDeletar);
				break;
			}
		}
		
	}
	
}

