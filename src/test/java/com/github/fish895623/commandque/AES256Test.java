package com.github.fish895623.commandque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AES256Test {
  @Test
  void encrypt_decrypt() throws Exception {
    AES256 v = new AES256();
    assertEquals(v.decrypt(v.encrypt("Hello World!")), "Hello World!");
  }
}