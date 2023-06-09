package uas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public final class QueryHelper {
  static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/s4_uas_pbo";
  static final String USER = "root";
  static final String PASS = "";

  static Connection conn;
  static Statement stmt;

  public static void init() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<String> transform(ResultSet res, Integer totalColumns) throws SQLException {
    ArrayList<String> data = new ArrayList<String>();
    for (int columnIdx = 1; columnIdx <= totalColumns; columnIdx++) {
      data.add(res.getString(columnIdx));
    }
    return data;
  }

  public static ArrayList<ArrayList<String>> select(String query) throws SQLException {
    stmt = conn.createStatement();
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    ResultSet result = stmt.executeQuery(query);
    ResultSetMetaData rsmd = result.getMetaData();
    while (result.next()) {
      ArrayList<String> row = transform(result, rsmd.getColumnCount());
      data.add(row);
    }
    stmt.close();
    return data;
  }

  public static ArrayList<String> find(String table, Integer id) throws SQLException {
    ArrayList<ArrayList<String>> result = QueryHelper.select("SELECT * FROM " + table + " WHERE id=" + id);
    ArrayList<String> data = result.isEmpty() ?  new ArrayList<String>() : result.get(0);
    return data;
  }

  public static ArrayList<String> find(String table, String extraQuery) throws SQLException {
    ArrayList<ArrayList<String>> result = QueryHelper.select("SELECT * FROM " + table + " " + extraQuery);
    ArrayList<String> data = result.isEmpty() ?  new ArrayList<String>() : result.get(0);
    return data;
  }

  public static void store(String table, String[] fields, String[] values) {
    try {
      stmt = conn.createStatement();
      String query = "INSERT INTO " + table + "(id";
      for (String field : fields) {
        query =  query + "," + field;
      }

      query = query + ") VALUE(NULL";

      for (String value : values) {
        query = value.equals("NULL") ? query + "," + value + "" : query + ",'" + value + "'";
      }
      query = query + ")";
      stmt.execute(query);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void update(String table, String id, String[] fields, String[] values) {
    try {
      stmt = conn.createStatement();
      String query = "UPDATE " + table + " SET";
      for (int i = 0; i < fields.length; i++) {
        String field = fields[i];
        String value = values[i];
        query = i == 0 ? query + "" : query + ",";
        query = value.equals("NULL") ? query + " " + field + "=" + value + "" : query + " " + field + "='" + value + "'";
      }
      query = query + " WHERE id=" + id;
      stmt.execute(query);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static void delete(String table, String id) {
    try {
      stmt = conn.createStatement();
      String query = "DELETE FROM " + table + " WHERE id=" + id;
      stmt.execute(query);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
 
  public static void populateTable(String query, JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Clear existing data
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Add column names to the table
        Vector<String> columnNames = new Vector<>();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }
        model.setColumnIdentifiers(columnNames);

        // Add rows to the table
        while (rs.next()) {
            Vector<Object> rowData = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.add(rs.getObject(i));
            }
            model.addRow(rowData);
        }
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
}