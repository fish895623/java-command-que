package com.github.fish895623.commandque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class Que {
  private final static Logger logger = LogManager.getLogger(Que.class);

  private final Connection connection = null;
  private final String dbFileName;

  public Que(String dbFileName) {
    this.dbFileName = dbFileName;
  }

  public static String te() {
    return "asdf";
  }

  public static void main(String[] args) {
    logger.warn("asdf");
    logger.info("aaa");
  }
}
