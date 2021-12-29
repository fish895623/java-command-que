package com.github.fish895623.commandque.controller;

import com.github.fish895623.commandque.data.InfoVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class get {
  @RequestMapping(method = RequestMethod.POST, path = "/get")
  public InfoVO post(@RequestBody InfoVO body) {
    body.setT(body.getName() + "123");
    return body;
  }

  @GetMapping(path = "/get")
  public String staticGet() {
    return "get.html";
  }
}
