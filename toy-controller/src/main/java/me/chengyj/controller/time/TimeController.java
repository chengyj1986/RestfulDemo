package me.chengyj.controller.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/time")
public class TimeController {

	// http://127.0.0.1:8080/toy-web/mvc/time/beijing/now
	@RequestMapping(value = "/{local}/now", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getNowTime(@PathVariable String local) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", "0000");
		result.put("respMsg", "SUCCESS");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		data.put("local", local);
		result.put("respData", data);
		return result;
	}
}