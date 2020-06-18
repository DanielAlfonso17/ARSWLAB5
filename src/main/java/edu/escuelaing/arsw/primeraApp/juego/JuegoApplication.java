package edu.escuelaing.arsw.primeraApp.juego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Random;

@SpringBootApplication
@Controller
public class JuegoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuegoApplication.class, args);
		Random ran = new Random();
		int numeroRandom = (int) (Math.random()*10000 +999);
		Juego.setNumeroRandom(numeroRandom);
	}

	@GetMapping("/juego")
	public String getForm(Model model){
		model.addAttribute("juego", new Juego());
		return "juego";
	}

	@PostMapping("/juego")
	public String greetingSubmit(@ModelAttribute Juego juego, Model model) {
		model.addAttribute("juego", juego);
		juego.prepararNumeros();
		juego.jugar();
		return "resultadoJuego";
	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 35000; //returns default port if heroku-port isn't set(i.e. on localhost)
	}
}
