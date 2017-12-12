package dao;

import entity.Feature;

public class FeatureDao extends AbstractDao {

    private static final String TABLE_NAME = "features";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";

    public void addFeature(String name, String description) {

        if (!isFeaturePresent(name)) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into " + TABLE_NAME + "(");
            sql.append(COLUMN_NAME).append(", ");
            sql.append(COLUMN_DESCRIPTION).append(")");
            sql.append(" values(");
            sql.append("'").append(name).append("', ");
            sql.append("'").append(description).append("')");
            this.executeUpdate(sql.toString());

            System.out.println("The Feature has been added to the database");
        }else{
            System.out.println("Ops!" + name + "already exists in the system");
        }

    }

    public void deleteFeature(String name) {
        if(!isFeaturePresent(name)) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(name).append("'");
            this.executeUpdate(sql.toString());
            System.out.println("The feature" + name + "has been deleted from database");
        }else{
            System.out.println("We are sorry, the feature you wanted to delete it doesn't exist");
        }
    }

    public Boolean isFeaturePresent(String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT from ").append(TABLE_NAME).append(" WHERE ").append(COLUMN_NAME).append(" = '").append(name).append("'");
        System.out.println(sql.toString());
        return this.isPresent(sql.toString());
    }

    public static void main(String[] args) {
        FeatureDao f = new FeatureDao();
        f.addFeature("Lavagna Interattiva", "Gli studenti ed il professore sono in grado di interagire con la lavagna in diretta");
    }
}