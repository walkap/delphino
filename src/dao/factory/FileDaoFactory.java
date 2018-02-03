package dao.factory;

import com.sun.istack.internal.Nullable;
import dao.feature.FeatureDao;
import dao.feature.FeatureDaoFile;
import dao.room.RoomDao;
import dao.room.RoomDaoFile;
import dao.user.UserDao;
import dao.user.UserDaoDb;
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
    public UserDao getUserDao() {
        return new UserDaoDb();
    }


}
