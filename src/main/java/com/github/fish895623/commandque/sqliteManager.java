package com.github.fish895623.commandque;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteManager {
  private String file;
  private String filename;
  private Connection connection = null;

  public void setFilename(String val) {
    this.filename = val;
    this.file = "jdbc:sqlite:" + filename;
  }

  // attach Database first
  public void createNewDatabase() {
    if (!checkFileExists()) {
      try (Connection conn = DriverManager.getConnection(this.file)) {
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
  boolean checkFileExists() {
    File f = new File(this.filename);
    return f.exists();
  }

  public void attachDatabase() {
    try {
      this.connection = DriverManager.getConnection(this.file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    sqliteManager app = new sqliteManager();
    app.setFilename("a.db");

    app.createNewDatabase();
  }
}
