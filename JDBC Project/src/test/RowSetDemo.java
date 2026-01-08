package test;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {

    public static void main(String[] args) {
        try {
            CachedRowSet rowset = RowSetProvider.newFactory().createCachedRowSet();

            rowset.setUrl("jdbc:mysql://localhost:3306/javadb");
            rowset.setUsername("root");        // change if needed
            rowset.setPassword("Dhiraj@0933");    // change if needed

            rowset.setCommand("SELECT * FROM person");
            
            rowset.execute();

            while (rowset.next()) {
                System.out.println(rowset.getInt(1) + " Name : " + rowset.getString(2)+ " Age : "+rowset.getInt(3));
            }

        } catch (Exception e) {
        	System.out.println(e);
        }
    }
}
