package Cinema;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Api(value = "CinemaController", tags = "其實就是設定網址前端的轉跳")
@RestController
public class CinemaController {
	@Autowired
	
	@ApiOperation(value = "index", notes = "return index.html")
	@CrossOrigin(origins = "*")
	@RequestMapping("/")
    public void index(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException 
    {
    	RequestDispatcher view;
    	view = request.getRequestDispatcher("index.html");
		view.forward(request, response);
    }
	
	@ApiOperation(value = "shop", notes = "return shop.html")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
    public void shop(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException 
    {
    	RequestDispatcher view;
    	view = request.getRequestDispatcher("shop.html");
		view.forward(request, response);
    }
	
	
}



