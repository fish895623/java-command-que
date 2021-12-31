package com.github.fish895623.commandque;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteManager {
  /**
   * @param filename Database filename
   */
  public static void createNewDatabase(String filename) {
    String file = "jdbc:sqlite:" + filename;

    try (Connection conn = DriverManager.getConnection(file)) {
      if (conn != null) {
        DatabaseMetaData meta = conn.getMetaData();
        System.out.println(meta.getDriverName());
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
