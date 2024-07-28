package com.greendao.gen;

import com.paytm.android.chat.bean.daobean.SyncContactBean;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class DaoSession extends AbstractDaoSession {
    private final SyncContactBeanDao syncContactBeanDao = new SyncContactBeanDao(this.syncContactBeanDaoConfig, this);
    private final DaoConfig syncContactBeanDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        this.syncContactBeanDaoConfig = map.get(SyncContactBeanDao.class).clone();
        this.syncContactBeanDaoConfig.initIdentityScope(identityScopeType);
        registerDao(SyncContactBean.class, this.syncContactBeanDao);
    }

    public void clear() {
        this.syncContactBeanDaoConfig.clearIdentityScope();
    }

    public SyncContactBeanDao getSyncContactBeanDao() {
        return this.syncContactBeanDao;
    }
}
