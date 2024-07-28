package org.greenrobot.greendao;

import android.database.Cursor;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.internal.DaoConfig;

public class InternalUnitTestDaoAccess<T, K> {
    private final AbstractDao<T, K> dao;

    public InternalUnitTestDaoAccess(Database database, Class<AbstractDao<T, K>> cls, IdentityScope<?, ?> identityScope) throws Exception {
        DaoConfig daoConfig = new DaoConfig(database, cls);
        daoConfig.setIdentityScope(identityScope);
        this.dao = cls.getConstructor(new Class[]{DaoConfig.class}).newInstance(new Object[]{daoConfig});
    }

    public K getKey(T t) {
        return this.dao.getKey(t);
    }

    public Property[] getProperties() {
        return this.dao.getProperties();
    }

    public boolean isEntityUpdateable() {
        return this.dao.isEntityUpdateable();
    }

    public T readEntity(Cursor cursor, int i2) {
        return this.dao.readEntity(cursor, i2);
    }

    public K readKey(Cursor cursor, int i2) {
        return this.dao.readKey(cursor, i2);
    }

    public AbstractDao<T, K> getDao() {
        return this.dao;
    }
}
