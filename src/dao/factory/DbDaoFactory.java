package dao.factory;

import dao.feature.FeatureDao;
import dao.feature.FeatureDaoDb;
import dao.room.RoomDao;
import dao.room.RoomDaoDb;

public class DbDaoFactory extends DaoFactory{


    public RoomDao getRoomDao() {
        return new RoomDaoDb();
    }
    public FeatureDao getFeatureDao() {
        return new FeatureDaoDb();
    }
}
