package com.github.fish895623.commandque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class pidManagerTest {
  @Test
  void osCheck() {
    assertEquals(new pidManager().os, "linux");
  }
}
