package com.github.fish895623.commandque;

import java.io.File;

public class JsonController {
  String a;

  JsonController() {
    this.a = "asdf";
  }

  public static void main(String[] args) {
  }

  boolean FileExist(String path) {
    return new File(path)
            .exists();
  }
}
