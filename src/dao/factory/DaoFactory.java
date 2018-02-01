package dao.factory;

import dao.feature.FeatureDao;
import dao.room.RoomDao;

public abstract class DaoFactory {

    public static final String DATABASE = "Database";
    public static final String FILE = "File";

    public abstract RoomDao getRoomDao();
    public abstract FeatureDao getFeatureDao();

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
                return new DbDaoFactory();
        }
    }
}
