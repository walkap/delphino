package dao.factory;

import com.sun.istack.internal.Nullable;
import dao.feature.FeatureDao;
import dao.feature.FeatureDaoFile;
import dao.room.RoomDao;
import dao.room.RoomDaoFile;
import dao.user.UserDao;
import entity.Building;
import entity.Feature;
import entity.room.Room;

import java.sql.SQLException;

public class FileDaoFactory extends DaoFactory{

    public RoomDao getRoomDao() {
        return new RoomDaoFile();
    }
    public FeatureDao getFeatureDao() {
        return new FeatureDaoFile();
    }

    @Override
    public UserDao getUserDao() {
        return null;
    }

    public static void main(String args[]){

        DaoFactory dbFactory =
                DaoFactory.getDaoFactory(DaoFactory.DATABASE);
        DaoFactory fileFactory =
                DaoFactory.getDaoFactory(DaoFactory.FILE);


        FeatureDao featureDaoDb =
                dbFactory.getFeatureDao();

       FeatureDao featureDaoFile = fileFactory.getFeatureDao();

        Feature f = new Feature("proiettore","dddd");
            featureDaoDb.insertFeature(f);

         featureDaoFile.insertFeature(f);
        }
}
