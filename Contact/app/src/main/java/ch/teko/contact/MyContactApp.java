package ch.teko.contact;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import ch.teko.contact.db.DaoMaster;
import ch.teko.contact.db.DaoSession;

/**
 * Created by jonathan on 19.06.17.
 */

public class MyContactApp extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "db-nameen");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
