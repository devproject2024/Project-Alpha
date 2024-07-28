package com.alipay.mobile.nebulaappcenter.dbapi;

import com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper;

public interface H5DaoExecutor<T> {
    T execute(H5BaseDBHelper h5BaseDBHelper) throws Exception;
}
