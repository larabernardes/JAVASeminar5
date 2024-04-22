package lv.venta.controler;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FirstController {
	
	@GetMapping("/hello") //localhost:8080/hello
	public String getHello() {
		System.out.println("The first controller is working!!");
		return "hello-page"; //it will show hello-page.html file in the browser
	}
	
	Random rand = new Random();
	@GetMapping("/hello/msg") //localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		System.out.println("The second controller is working!!");
		model.addAttribute("mypackage","Hello from JAVA: " + rand.nextInt(0, 100));
		return "hello-msg-page";
	}
	
	
	
}
