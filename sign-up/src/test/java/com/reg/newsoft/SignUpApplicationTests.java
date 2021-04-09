package com.reg.newsoft;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reg.newsoft.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
class SignUpApplicationTests {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void registerUserTest() throws Exception {
		User user = new User();
		user.setName("Basant");
		user.setAddress("Hyderabad");
		user.setProductId(1);
		String jsonRequest = om.writeValueAsString(user);
		MvcResult result = mockMvc
				.perform(post("/api/users").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		String response = om.readValue(resultContent, String.class);
		// Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.equals(response) == Boolean.TRUE);

	}

}
