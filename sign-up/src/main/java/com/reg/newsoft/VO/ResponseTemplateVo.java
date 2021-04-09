package com.reg.newsoft.VO;

import com.reg.newsoft.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

	private User user;
	private Product product;

}
