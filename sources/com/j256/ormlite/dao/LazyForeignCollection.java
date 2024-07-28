package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.IOUtils;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements Serializable {
    private static final long serialVersionUID = -5460708106909626233L;
    private transient CloseableIterator<T> lastIterator;

    public boolean isEager() {
        return false;
    }

    public int refreshCollection() {
        return 0;
    }

    public LazyForeignCollection(Dao<T, ID> dao, Object obj, Object obj2, FieldType fieldType, String str, boolean z) {
        super(dao, obj, obj2, fieldType, str, z);
    }

    public CloseableIterator<T> iterator() {
        return closeableIterator(-1);
    }

    public CloseableIterator<T> iterator(int i2) {
        return closeableIterator(i2);
    }

    public CloseableIterator<T> closeableIterator() {
        return closeableIterator(-1);
    }

    public CloseableIterator<T> closeableIterator(int i2) {
        try {
            return iteratorThrow(i2);
        } catch (SQLException e2) {
            throw new IllegalStateException("Could not build lazy iterator for " + this.dao.getDataClass(), e2);
        }
    }

    public CloseableIterator<T> iteratorThrow() throws SQLException {
        return iteratorThrow(-1);
    }

    public CloseableIterator<T> iteratorThrow(int i2) throws SQLException {
        this.lastIterator = seperateIteratorThrow(i2);
        return this.lastIterator;
    }

    public CloseableWrappedIterable<T> getWrappedIterable() {
        return getWrappedIterable(-1);
    }

    public CloseableWrappedIterable<T> getWrappedIterable(final int i2) {
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            public CloseableIterator<T> iterator() {
                return closeableIterator();
            }

            public CloseableIterator<T> closeableIterator() {
                try {
                    return LazyForeignCollection.this.seperateIteratorThrow(i2);
                } catch (Exception e2) {
                    throw new IllegalStateException("Could not build lazy iterator for " + LazyForeignCollection.this.dao.getDataClass(), e2);
                }
            }
        });
    }

    public void closeLastIterator() throws IOException {
        CloseableIterator<T> closeableIterator = this.lastIterator;
        if (closeableIterator != null) {
            closeableIterator.close();
            this.lastIterator = null;
        }
    }

    public int size() {
        CloseableIterator it2 = iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            try {
                it2.moveToNext();
                i2++;
            } finally {
                IOUtils.closeQuietly(it2);
            }
        }
        return i2;
    }

    public boolean isEmpty() {
        CloseableIterator it2 = iterator();
        try {
            return !it2.hasNext();
        } finally {
            IOUtils.closeQuietly(it2);
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean contains(Object obj) {
        CloseableIterator it2 = iterator();
        do {
            try {
                if (!it2.hasNext()) {
                    IOUtils.closeQuietly(it2);
                    return false;
                }
            } catch (Throwable th) {
                IOUtils.closeQuietly(it2);
                throw th;
            }
        } while (!it2.next().equals(obj));
        IOUtils.closeQuietly(it2);
        return true;
    }

    public boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet(collection);
        CloseableIterator it2 = iterator();
        while (it2.hasNext()) {
            try {
                hashSet.remove(it2.next());
            } finally {
                IOUtils.closeQuietly(it2);
            }
        }
        return hashSet.isEmpty();
    }

    /* JADX INFO: finally extract failed */
    public boolean remove(Object obj) {
        CloseableIterator it2 = iterator();
        do {
            try {
                if (!it2.hasNext()) {
                    IOUtils.closeQuietly(it2);
                    return false;
                }
            } catch (Throwable th) {
                IOUtils.closeQuietly(it2);
                throw th;
            }
        } while (!it2.next().equals(obj));
        it2.remove();
        IOUtils.closeQuietly(it2);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        CloseableIterator it2 = iterator();
        boolean z = false;
        while (it2.hasNext()) {
            try {
                if (collection.contains(it2.next())) {
                    it2.remove();
                    z = true;
                }
            } finally {
                IOUtils.closeQuietly(it2);
            }
        }
        return z;
    }

    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator it2 = iterator();
        while (it2.hasNext()) {
            try {
                arrayList.add(it2.next());
            } finally {
                IOUtils.closeQuietly(it2);
            }
        }
        return arrayList.toArray();
    }

    public <E> E[] toArray(E[] eArr) {
        CloseableIterator it2 = iterator();
        ArrayList arrayList = null;
        int i2 = 0;
        while (it2.hasNext()) {
            try {
                E next = it2.next();
                if (i2 >= eArr.length) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        for (E add : eArr) {
                            arrayList.add(add);
                        }
                    }
                    arrayList.add(next);
                } else {
                    eArr[i2] = next;
                }
                i2++;
            } finally {
                IOUtils.closeQuietly(it2);
            }
        }
        if (arrayList != null) {
            return arrayList.toArray(eArr);
        }
        if (i2 < eArr.length - 1) {
            eArr[i2] = null;
        }
        return eArr;
    }

    public int updateAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    public int refreshAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: private */
    public CloseableIterator<T> seperateIteratorThrow(int i2) throws SQLException {
        if (this.dao != null) {
            return this.dao.iterator(getPreparedQuery(), i2);
        }
        throw new IllegalStateException("Internal DAO object is null.  Maybe the collection was deserialized or otherwise constructed wrongly.  Use dao.assignEmptyForeignCollection(...) or dao.getEmptyForeignCollection(...) instead");
    }
}
