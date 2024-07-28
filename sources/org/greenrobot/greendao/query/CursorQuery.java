package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;

public class CursorQuery<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;

    public /* bridge */ /* synthetic */ void setLimit(int i2) {
        super.setLimit(i2);
    }

    public /* bridge */ /* synthetic */ void setOffset(int i2) {
        super.setOffset(i2);
    }

    static final class QueryData<T2> extends AbstractQueryData<T2, CursorQuery<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        QueryData(AbstractDao abstractDao, String str, String[] strArr, int i2, int i3) {
            super(abstractDao, str, strArr);
            this.limitPosition = i2;
            this.offsetPosition = i3;
        }

        /* access modifiers changed from: protected */
        public final CursorQuery<T2> createQuery() {
            return new CursorQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return create(abstractDao, str, objArr, -1, -1);
    }

    static <T2> CursorQuery<T2> create(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i2, int i3) {
        return (CursorQuery) new QueryData(abstractDao, str, toStringArray(objArr), i2, i3).forCurrentThread();
    }

    private CursorQuery(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i2, int i3) {
        super(abstractDao, str, strArr, i2, i3);
        this.queryData = queryData2;
    }

    public CursorQuery forCurrentThread() {
        return (CursorQuery) this.queryData.forCurrentThread(this);
    }

    public Cursor query() {
        checkThread();
        return this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    }

    public CursorQuery<T> setParameter(int i2, Object obj) {
        return (CursorQuery) super.setParameter(i2, obj);
    }

    public CursorQuery<T> setParameter(int i2, Date date) {
        return (CursorQuery) super.setParameter(i2, date);
    }

    public CursorQuery<T> setParameter(int i2, Boolean bool) {
        return (CursorQuery) super.setParameter(i2, bool);
    }
}
