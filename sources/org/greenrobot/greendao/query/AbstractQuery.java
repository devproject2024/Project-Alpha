package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

abstract class AbstractQuery<T> {
    protected final AbstractDao<T, ?> dao;
    protected final InternalQueryDaoAccess<T> daoAccess;
    protected final Thread ownerThread = Thread.currentThread();
    protected final String[] parameters;
    protected final String sql;

    protected static String[] toStringArray(Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                strArr[i2] = obj.toString();
            } else {
                strArr[i2] = null;
            }
        }
        return strArr;
    }

    protected AbstractQuery(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.daoAccess = new InternalQueryDaoAccess<>(abstractDao);
        this.sql = str;
        this.parameters = strArr;
    }

    public AbstractQuery<T> setParameter(int i2, Object obj) {
        checkThread();
        if (obj != null) {
            this.parameters[i2] = obj.toString();
        } else {
            this.parameters[i2] = null;
        }
        return this;
    }

    public AbstractQuery<T> setParameter(int i2, Date date) {
        return setParameter(i2, (Object) date != null ? Long.valueOf(date.getTime()) : null);
    }

    public AbstractQuery<T> setParameter(int i2, Boolean bool) {
        return setParameter(i2, (Object) bool != null ? Integer.valueOf(bool.booleanValue() ? 1 : 0) : null);
    }

    /* access modifiers changed from: protected */
    public void checkThread() {
        if (Thread.currentThread() != this.ownerThread) {
            throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        }
    }
}
