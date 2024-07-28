package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

abstract class AbstractQueryWithLimit<T> extends AbstractQuery<T> {
    protected final int limitPosition;
    protected final int offsetPosition;

    protected AbstractQueryWithLimit(AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i2, int i3) {
        super(abstractDao, str, strArr);
        this.limitPosition = i2;
        this.offsetPosition = i3;
    }

    public AbstractQueryWithLimit<T> setParameter(int i2, Object obj) {
        if (i2 < 0 || (i2 != this.limitPosition && i2 != this.offsetPosition)) {
            return (AbstractQueryWithLimit) super.setParameter(i2, obj);
        }
        throw new IllegalArgumentException("Illegal parameter index: ".concat(String.valueOf(i2)));
    }

    public void setLimit(int i2) {
        checkThread();
        if (this.limitPosition != -1) {
            this.parameters[this.limitPosition] = Integer.toString(i2);
            return;
        }
        throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
    }

    public void setOffset(int i2) {
        checkThread();
        if (this.offsetPosition != -1) {
            this.parameters[this.offsetPosition] = Integer.toString(i2);
            return;
        }
        throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
    }
}
