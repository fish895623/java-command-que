package com.github.fish895623.commandque;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteManager {
  static String file;
  static String filename;

  public static void setFilename(String val) {
    filename = val;
    file = "jdbc:sqlite:" + filename;
  }

  public static void createNewDatabase() {
    if (!checkFileExists()) {
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

  /**
   * check database file exists
   */
  static boolean checkFileExists() {
    File f = new File(filename);
    return f.exists();
  }

  /**
   * Attach to sqlite
   */
  public static void attachDatabase() {
  }
}
