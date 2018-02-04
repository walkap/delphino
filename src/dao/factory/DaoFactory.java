package dao.factory;

import dao.feature.FeatureDao;
import dao.room.RoomDao;
import dao.user.UserDao;

public abstract class DaoFactory {

    public static final String DATABASE = "Database";
    public static final String FILE = "File";

    public abstract RoomDao getRoomDao();
    public abstract FeatureDao getFeatureDao();
    public abstract UserDao getUserDao();

    /**
     * This method instantiate a concrete factory dao
     * @param factory
     * @return DaoFactory
     */
    public static DaoFactory getDaoFactory(String factory) {
        switch (factory) {
            case DATABASE:
                return new DbDaoFactory();
            case FILE:
                return new FileDaoFactory();
            default:
                return null;
        }
    }
}
