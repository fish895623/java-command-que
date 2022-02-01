package com.github.fish895623.commandque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Que {
  private final static Logger logger = LogManager.getLogger(Que.class);

  static {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String dbFileName;
  private String query;

  public Que(Builder builder) {
    this.dbFileName = builder.dbFileName;
    this.query = builder.query;
  }

  public static String te() {
    return "asdf";
  }

  public static void main(String[] args) throws SQLException {
    Que a = new Builder()
            .setDBFileName("asdf.db")
            .setQuery("SELECT ID, USER FROM User")
            .build();
    ResultSet ab = a.connect();
    while (ab.next()) {
      String id = ab.getString("ID");
      String user = ab.getString("USER");
      System.out.printf("%s %s \n", id, user);
    }

  }

  public ResultSet connect() throws SQLException {
    Connection connection =
            DriverManager.getConnection("jdbc:sqlite:" + this.dbFileName);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(this.query);
    return resultSet;
  }

  /*
   * DB builder
   */
  public static class Builder {
    private String dbFileName;
    private String query;

    public Builder setDBFileName(String val) {
      this.dbFileName = val;
      return this;
    }

    public Builder setQuery(String val) {
      this.query = val;
      return this;
    }

    public Que build() {
      return new Que(this);
    }
  }
}
