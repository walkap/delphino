package dao.factory;

import dao.feature.FeatureDao;
import dao.feature.FeatureDaoDb;
import dao.room.RoomDao;
import dao.room.RoomDaoDb;
import dao.user.UserDao;
import dao.user.UserDaoDb;

public class DbDaoFactory extends DaoFactory{
    @Override
    public RoomDao getRoomDao() {
        return new RoomDaoDb();
    }
    @Override
    public FeatureDao getFeatureDao() {
        return new FeatureDaoDb();
    }
    @Override
    public UserDao getUserDao(){
        return new UserDaoDb();
    }
}
