package me.chengyj.controller.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import me.chengyj.service.product.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Resource
	private ProductService productService;

	// http://127.0.0.1:8080/toy-web/mvc/product/GSM_VAS/products
	@RequestMapping(value = "/{productType}/products", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getProducts(@PathVariable String productType) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("respCode", "0000");
		result.put("respMsg", "SUCCESS");
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> products = productService.getProductsByProductType(productType);
		data.put("products", products);
		result.put("respData", data);
		return result;
	}
}