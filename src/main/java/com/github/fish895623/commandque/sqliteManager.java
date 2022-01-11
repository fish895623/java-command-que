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
  static boolean checkFileExists() {
    File f = new File(filename);
    return f.exists();
  }

  /**
   * Attach to sqlite
   */
  public static void attachDatabase() {
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
