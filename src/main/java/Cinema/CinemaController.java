package Cinema;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class CinemaController {
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/")
    public String index() 
    {
		return "index.html";
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping("shop.html")
    public String getGrocery()
    {
    	return "shop.html";
    }
	
	
}



