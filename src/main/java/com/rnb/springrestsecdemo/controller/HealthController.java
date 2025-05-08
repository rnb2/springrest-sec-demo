package com.rnb.springrestsecdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rnb")
public class HealthController {

   /*"/hello")
    public ResponseEntity<String> greeting() {
        ResponseEntity<String> response = ResponseEntity.ok("Hello World");

        return response;
    }*/

    @GetMapping("/hello")
    public String greeting() {
        return "Hello user ";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        String id = request.getSession().getId();

        return "<b>About:</b>"
                + "<br /> <b>id:</b> " + id
                + "<br /> <b>URI:</b> " + request.getRequestURI()
                + "<br /> <b>method:</b> " + request.getMethod()
                + "<br /> <b>header:</b> " + request.getHeader("User-Agent")
                + "<br /> <b>remoteAddre:</b> " + request.getRemoteAddr();
    }

}
