package com.robatist.backend.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:40000") // TODO: 24/10/2023 confirm if this change work here
public interface ApiController {

}
