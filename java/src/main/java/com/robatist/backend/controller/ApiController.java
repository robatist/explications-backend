package com.robatist.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:40000")
public interface ApiController {

}
