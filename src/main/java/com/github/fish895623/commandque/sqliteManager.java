package com.github.fish895623.commandque;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteManager {
  // TODO Change to Builder pattern
  private final String file;
  private final String filename;

  public static class Builder {
    private String filename;
    private String file;

    public Builder setFilename(String val) {
      this.filename = val;
      this.file = "jdbc:sqlite:" + filename;
      return this;
    }

    public sqliteManager build() {
      return new sqliteManager(this);
    }
  }

  public sqliteManager(Builder builder) {
    this.file = builder.file;
    this.filename = builder.filename;
  }

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

  /**
   * Attach to sqlite
   */
  public void attachDatabase() {
  }

  public static void main(String[] args) {
    sqliteManager app = new sqliteManager.Builder().setFilename("a.db").build();
    app.createNewDatabase();
  }
}
