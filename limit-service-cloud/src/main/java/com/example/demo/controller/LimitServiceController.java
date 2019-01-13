package com.example.demo.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ConfigProps;
import com.example.demo.domain.SomeBean;

@RestController
@RefreshScope
public class LimitServiceController {

	private ConfigProps props;

	public LimitServiceController(ConfigProps props) {
		super();
		this.props = props;
	}
	
	@GetMapping("/val")
	public SomeBean someBean() {
		return new SomeBean(props.getMin(),props.getMax());
	}
}
