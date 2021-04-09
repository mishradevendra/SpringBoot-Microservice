package com.reg.newsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.reg.newsoft.VO.Product;
import com.reg.newsoft.VO.ResponseTemplateVo;
import com.reg.newsoft.model.User;
import com.reg.newsoft.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/users")
	public String registerUser(@RequestBody User user) {
		userRepository.save(user);
		return "Successful added user with id " + user.getUserId();
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return "User deleted successful id:" + id;
	}

	@GetMapping("/users/{id}")
	public ResponseTemplateVo getUserWithProduct(@PathVariable Integer id) {
		ResponseTemplateVo response = new ResponseTemplateVo();
		User user = userRepository.findByUserId(id);
		Product product = restTemplate.getForObject("http://ORDER-SERVICE/product/" + user.getProductId(),
				Product.class);
		response.setUser(user);
		response.setProduct(product);

		return response;

	}
}
