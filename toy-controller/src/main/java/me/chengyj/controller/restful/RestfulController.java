package me.chengyj.controller.restful;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/restful")
public class RestfulController {
	@Resource
	private RestTemplate restTemplate;

	// http://127.0.0.1:8080/toy-web/mvc/restful/test
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> test() {
		String url = "http://10.1.228.184:60001/eshop/mvc/basket";
		Map<String, String> request = new HashMap<String, String>();
		request.put("state", "1");
		Map<String, String> response = new HashMap<String, String>();
		try {
			response = restTemplate.postForObject(url, request, Map.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", "0000");
		result.put("respMsg", "SUCCESS");
		result.put("response", response);
		return result;
	}
}
