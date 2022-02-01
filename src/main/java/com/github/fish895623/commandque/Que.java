package com.github.fish895623.commandque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Que {
  private final static Logger logger = LogManager.getLogger(Que.class);
  private static Connection connection = null;
  private static Statement statement;

  private String dbFileName;

  public static String te() {
    return "asdf";
  }

  public static void main(String[] args) {
    Que a = new Que();
    a.setDBFileName("asdf");
    a.start();
  }

  public ResultSet getData(String query) {
    ResultSet rs = null;

    try {
      rs = statement.executeQuery(query);

      logger.info("Executing Query");
    } catch (SQLException e) {
      e.printStackTrace();
      logger.error("ERROR on getting Data");
    }

    return rs;
  }

  public void start() {
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:" + dbFileName);
      statement = connection.createStatement();

      logger.info("Connect to sqlite");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();

      logger.error("ClassNotFound, SQLException");
    }
  }

  public void setDBFileName(String val) {
    this.dbFileName = val;
  }
}
