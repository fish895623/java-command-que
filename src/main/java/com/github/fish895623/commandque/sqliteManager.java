package com.github.fish895623.commandque;

import java.io.File;
import java.sql.*;

public class sqliteManager {
  private String file;
  private String filename;
  private Connection connection;

  public ResultSet rs;

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

  /**
   * @param qry
   *         sqlite query
   */
  public String[] executeQuery(String qry, String val1, String val2) throws SQLException {
    Statement stat = connection.createStatement();
    this.rs = stat.executeQuery(qry);
    String[] result = {this.rs.getString(val1), this.rs.getString(val2)};
    return result;
  }

  public static void main(String[] args) throws SQLException {
    sqliteManager app = new sqliteManager();
    app.setFilename("a.db");
    app.attachDatabase();

    String[] a = app.executeQuery("SELECT ID, NAME FROM tabe", "ID", "NAME");

    for (String i : a) {
      System.out.println(i);
    }

    app.createNewDatabase();
  }
}
