package com.github.fish895623.commandque.controller;

import com.github.fish895623.commandque.data.InfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class get {
  @RequestMapping(method = RequestMethod.POST, path = "/get")
  // NOTE Remove @RequestBoy to use `application/x-www-form-urlencoded`
  public InfoVO post(InfoVO body) {
    body.setT(body.getName() + "123");
    return body;
  }
}

@Controller
class getController {
  /**
   * Testing 2
   */
  @GetMapping(path = "/get")
  public String staticGet() {
    return "get.html";
  }
}