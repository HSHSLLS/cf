package cf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cf.service.impl.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/getNameById",method = RequestMethod.GET)
	public String getNameById(@RequestParam int id){
		System.out.println(id+"");
		String name = testService.getNameById(id);
		System.out.println("oracle数据，TESTTABLE表，id=1时，name是"+name);
		return name;
		
	}
}
