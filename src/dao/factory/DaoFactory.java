package dao.factory;

import com.sun.istack.internal.Nullable;
import dao.feature.FeatureDao;
import dao.room.RoomDao;

public abstract class DaoFactory {

    public static final String DATABASE = "Database";
    public static final String FILE = "File";

    public abstract RoomDao getRoomDao();
    public abstract FeatureDao getFeatureDao();


    public static DaoFactory getDaoFactory(
            String whichFactory) {

        switch (whichFactory) {
            case DATABASE:
                return new DbDaoFactory();
            case FILE:
                return new FileDaoFactory();
            default:
                return new DbDaoFactory();
        }
    }
}
