package org.greenrobot.greendao.query;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.rx.RxQuery;
import rx.schedulers.Schedulers;

public class Query<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;
    private volatile RxQuery rxTxIo;
    private volatile RxQuery rxTxPlain;

    public /* bridge */ /* synthetic */ void setLimit(int i2) {
        super.setLimit(i2);
    }

    public /* bridge */ /* synthetic */ void setOffset(int i2) {
        super.setOffset(i2);
    }

    static final class QueryData<T2> extends AbstractQueryData<T2, Query<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr, int i2, int i3) {
            super(abstractDao, str, strArr);
            this.limitPosition = i2;
            this.offsetPosition = i3;
        }

        /* access modifiers changed from: protected */
        public final Query<T2> createQuery() {
            return new Query(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    static <T2> Query<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i2, int i3) {
        return (Query) new QueryData(abstractDao, str, toStringArray(objArr), i2, i3).forCurrentThread();
    }

    private Query(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i2, int i3) {
        super(abstractDao, str, strArr, i2, i3);
        this.queryData = queryData2;
    }

    public Query<T> forCurrentThread() {
        return (Query) this.queryData.forCurrentThread(this);
    }

    public List<T> list() {
        checkThread();
        return this.daoAccess.loadAllAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public LazyList<T> listLazy() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), true);
    }

    public LazyList<T> listLazyUncached() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), false);
    }

    public CloseableListIterator<T> listIterator() {
        return listLazyUncached().listIteratorAutoClose();
    }

    public T unique() {
        checkThread();
        return this.daoAccess.loadUniqueAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public T uniqueOrThrow() {
        T unique = unique();
        if (unique != null) {
            return unique;
        }
        throw new DaoException("No entity found for query");
    }

    public Query<T> setParameter(int i2, Object obj) {
        return (Query) super.setParameter(i2, obj);
    }

    public Query<T> setParameter(int i2, Date date) {
        return (Query) super.setParameter(i2, date);
    }

    public Query<T> setParameter(int i2, Boolean bool) {
        return (Query) super.setParameter(i2, bool);
    }

    public RxQuery __internalRxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new RxQuery(this);
        }
        return this.rxTxPlain;
    }

    public RxQuery __InternalRx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new RxQuery(this, Schedulers.io());
        }
        return this.rxTxIo;
    }
}
