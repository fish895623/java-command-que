package com.github.fish895623.commandque;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteManager {
  /**
   * @param fileName
   *         Sqlite database location
   */
  public static void createNewDatabase(String fileName) {
    String url = "jdbc:sqlite:" + fileName;

    try (Connection conn = DriverManager.getConnection(url)) {
      if (conn != null) {
        DatabaseMetaData meta = conn.getMetaData();
        System.out.println("The driver name is " + meta.getDriverName());
        System.out.println("A new database has been created.");
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * @param filename
   *         Sqlite database location
   */
  public static void connect(String filename) {
    Connection conn = null;
    try {
      String url = "jdbc:sqlite:" + filename;
      conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  /**
   * @param args
   *         the command line arguments
   */
  public static void main(String[] args) {
    createNewDatabase("a.db");
    connect("a.db");
  }
}
