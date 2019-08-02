package me.chengyj.dao.product;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "productDao")
public class ProductDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getProductsByProductType(String productType) {
		String sql = "select * from product_offering where upc_offer_type=?";
		List<Map<String, Object>> products = jdbcTemplate.queryForList(sql, productType);
		return products;
	}
}