package com.udacity.pricing;

import com.udacity.pricing.repository.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@Autowired
	PriceRepository priceRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllPrices() throws Exception {
		mockMvc.perform(get("/prices"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded").exists())
				.andExpect(jsonPath("$._embedded.prices").exists())
				.andExpect(jsonPath("$._embedded.prices", hasSize(3)));
	}

}
