package dao.feature;

import dao.AbstractDao;
import dao.DataSource;
import entity.Feature;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FeatureDaoDb extends AbstractDao implements FeatureDao{

    private static final String TABLE_NAME = "features";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";

    public void insertFeature(Feature f) {

        if (!isFeaturePresent(f)) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into " + TABLE_NAME + "(");
            sql.append(COLUMN_NAME).append(", ");
            sql.append(COLUMN_DESCRIPTION).append(")");
            sql.append(" values(");
            sql.append("'").append(f.getName()).append("', ");
            sql.append("'").append(f.getDescription()).append("')");
            this.executeUpdate(sql.toString());

            System.out.println("The Feature has been added to the database");
        }else{
            System.out.println("Ops!" + f.getName() + "already exists in the system");
        }

    }

    public void deleteFeature(Feature f) {
        if(isFeaturePresent(f)) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE from ").append(TABLE_NAME)
                    .append(" WHERE ").append(COLUMN_NAME)
                    .append(" = '").append(f.getName()).append("'");
            this.executeUpdate(sql.toString());
            System.out.println("The feature" + f.getName() + "has been deleted from database");
        }else{
            System.out.println("We are sorry, the feature you wanted to delete it doesn't exist");
        }
    }

    public boolean isFeaturePresent(Feature f) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(f.getName()).append("'");
        System.out.println(sql.toString());
        return this.isPresent(sql.toString());
    }

    public void updateFeature(Feature f) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE " + TABLE_NAME)
                .append(" SET ")
                .append(COLUMN_NAME).append(" = '").append(f.getName()).append("', ")
                .append(COLUMN_DESCRIPTION).append(" = '").append(f.getDescription()).append("'")
                .append(" WHERE ").append(COLUMN_NAME).append(" = '").append(f.getName()).append("'");
        System.out.println(sql.toString());
        this.executeUpdate(sql.toString());
        System.out.println("The feature has been updated!");

    }

    public ArrayList<Feature> getFeatures() {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        ArrayList<Feature> list = new ArrayList<>();
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM " + TABLE_NAME);
            ResultSet rs = s.executeQuery(sql.toString());
            while (rs.next()) {
                String name = rs.getString(COLUMN_NAME);
                String description = rs.getString(COLUMN_DESCRIPTION);
                list.add(new Feature(name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        return list;
    }

    public Feature getFeature(String name) {
        Statement s = null;
        DataSource ds = new DataSource();
        Connection c = ds.getConnection();
        Feature f = new Feature(name, "");
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM " + TABLE_NAME)
                    .append(" WHERE ")
                    .append(COLUMN_NAME)
                    .append(" = ")
                    .append("'")
                    .append(name)
                    .append("'");
            ResultSet rs = s.executeQuery(sql.toString());
            String description = rs.getString(COLUMN_DESCRIPTION);
            f.setDescription(description);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Closing statement...");
            this.closeStatement(s);
            System.out.println("Closing connection...");
            ds.closeConnection(c);
        }
        return f;
    }
}