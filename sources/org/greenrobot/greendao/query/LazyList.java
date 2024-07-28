package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

public class LazyList<E> implements Closeable, List<E> {
    private final Cursor cursor;
    private final InternalQueryDaoAccess<E> daoAccess;
    private final List<E> entities;
    private volatile int loadedCount;
    private final ReentrantLock lock;
    /* access modifiers changed from: private */
    public final int size;

    protected class LazyIterator implements CloseableListIterator<E> {
        private final boolean closeWhenDone;
        private int index;

        public LazyIterator(int i2, boolean z) {
            this.index = i2;
            this.closeWhenDone = z;
        }

        public void add(E e2) {
            throw new UnsupportedOperationException();
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            int i2 = this.index;
            if (i2 > 0) {
                this.index = i2 - 1;
                return LazyList.this.get(this.index);
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void set(E e2) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.index < LazyList.this.size;
        }

        public E next() {
            if (this.index < LazyList.this.size) {
                E e2 = LazyList.this.get(this.index);
                this.index++;
                if (this.index == LazyList.this.size && this.closeWhenDone) {
                    close();
                }
                return e2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void close() {
            LazyList.this.close();
        }
    }

    LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor2, boolean z) {
        this.cursor = cursor2;
        this.daoAccess = internalQueryDaoAccess;
        this.size = cursor2.getCount();
        if (z) {
            this.entities = new ArrayList(this.size);
            for (int i2 = 0; i2 < this.size; i2++) {
                this.entities.add((Object) null);
            }
        } else {
            this.entities = null;
        }
        if (this.size == 0) {
            cursor2.close();
        }
        this.lock = new ReentrantLock();
    }

    public void loadRemaining() {
        checkCached();
        int size2 = this.entities.size();
        for (int i2 = 0; i2 < size2; i2++) {
            get(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void checkCached() {
        if (this.entities == null) {
            throw new DaoException("This operation only works with cached lazy lists");
        }
    }

    public E peek(int i2) {
        List<E> list = this.entities;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    public void close() {
        this.cursor.close();
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    public boolean isLoadedCompletely() {
        return this.loadedCount == this.size;
    }

    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    public void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        loadRemaining();
        return this.entities.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        loadRemaining();
        return this.entities.containsAll(collection);
    }

    public E get(int i2) {
        List<E> list = this.entities;
        if (list != null) {
            E e2 = list.get(i2);
            if (e2 == null) {
                this.lock.lock();
                try {
                    e2 = this.entities.get(i2);
                    if (e2 == null) {
                        e2 = loadEntity(i2);
                        this.entities.set(i2, e2);
                        this.loadedCount++;
                        if (this.loadedCount == this.size) {
                            this.cursor.close();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            return e2;
        }
        this.lock.lock();
        try {
            return loadEntity(i2);
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public E loadEntity(int i2) {
        if (this.cursor.moveToPosition(i2)) {
            E loadCurrent = this.daoAccess.loadCurrent(this.cursor, 0, true);
            if (loadCurrent != null) {
                return loadCurrent;
            }
            throw new DaoException("Loading of entity failed (null) at position ".concat(String.valueOf(i2)));
        }
        throw new DaoException("Could not move to cursor location ".concat(String.valueOf(i2)));
    }

    public int indexOf(Object obj) {
        loadRemaining();
        return this.entities.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<E> iterator() {
        return new LazyIterator(0, false);
    }

    public int lastIndexOf(Object obj) {
        loadRemaining();
        return this.entities.lastIndexOf(obj);
    }

    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(0, false);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(0, true);
    }

    public ListIterator<E> listIterator(int i2) {
        return new LazyIterator(i2, false);
    }

    public E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.size;
    }

    public List<E> subList(int i2, int i3) {
        checkCached();
        for (int i4 = i2; i4 < i3; i4++) {
            get(i4);
        }
        return this.entities.subList(i2, i3);
    }

    public Object[] toArray() {
        loadRemaining();
        return this.entities.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return this.entities.toArray(tArr);
    }
}
