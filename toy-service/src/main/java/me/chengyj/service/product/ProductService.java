package me.chengyj.service.product;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import me.chengyj.dao.product.ProductDao;

import org.springframework.stereotype.Service;

@Service(value = "productService")
public class ProductService {
	@Resource
	private ProductDao productDao;

	public List<Map<String, Object>> getProductsByProductType(String productType) {
		List<Map<String, Object>> products = productDao.getProductsByProductType(productType);
		return products;
	}
}