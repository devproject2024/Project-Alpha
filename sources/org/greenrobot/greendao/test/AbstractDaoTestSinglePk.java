package org.greenrobot.greendao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K> extends AbstractDaoTest<D, T, K> {
    private Property pkColumn;
    protected Set<K> usedPks = new HashSet();

    /* access modifiers changed from: protected */
    public abstract T createEntity(K k);

    /* access modifiers changed from: protected */
    public abstract K createRandomPk();

    public AbstractDaoTestSinglePk(Class<D> cls) {
        super(cls);
    }

    public void setUp() throws Exception {
        super.setUp();
        for (Property property : this.daoAccess.getProperties()) {
            if (property.primaryKey) {
                if (this.pkColumn == null) {
                    this.pkColumn = property;
                } else {
                    throw new RuntimeException("Test does not work with multiple PK columns");
                }
            }
        }
        if (this.pkColumn == null) {
            throw new RuntimeException("Test does not work without a PK column");
        }
    }

    public void testInsertAndLoad() {
        Object nextPk = nextPk();
        Object createEntity = createEntity(nextPk);
        this.dao.insert(createEntity);
        assertEquals(nextPk, this.daoAccess.getKey(createEntity));
        Object load = this.dao.load(nextPk);
        assertNotNull(load);
        assertEquals(this.daoAccess.getKey(createEntity), this.daoAccess.getKey(load));
    }

    public void testInsertInTx() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 20; i2++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        assertEquals((long) arrayList.size(), this.dao.count());
    }

    public void testCount() {
        this.dao.deleteAll();
        assertEquals(0, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        assertEquals(1, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        assertEquals(2, this.dao.count());
    }

    public void testInsertTwice() {
        Object createEntity = createEntity(nextPk());
        this.dao.insert(createEntity);
        try {
            this.dao.insert(createEntity);
            fail("Inserting twice should not work");
        } catch (SQLException unused) {
        }
    }

    public void testInsertOrReplaceTwice() {
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        long insert = this.dao.insert(createEntityWithRandomPk);
        long insertOrReplace = this.dao.insertOrReplace(createEntityWithRandomPk);
        if (this.dao.getPkProperty().type == Long.class) {
            assertEquals(insert, insertOrReplace);
        }
    }

    public void testInsertOrReplaceInTx() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < 20; i2++) {
            Object createEntityWithRandomPk = createEntityWithRandomPk();
            if (i2 % 2 == 0) {
                arrayList.add(createEntityWithRandomPk);
            }
            arrayList2.add(createEntityWithRandomPk);
        }
        this.dao.insertOrReplaceInTx(arrayList);
        this.dao.insertOrReplaceInTx(arrayList2);
        assertEquals((long) arrayList2.size(), this.dao.count());
    }

    public void testDelete() {
        Object nextPk = nextPk();
        this.dao.deleteByKey(nextPk);
        this.dao.insert(createEntity(nextPk));
        assertNotNull(this.dao.load(nextPk));
        this.dao.deleteByKey(nextPk);
        assertNull(this.dao.load(nextPk));
    }

    public void testDeleteAll() {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < 10; i2++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        this.dao.deleteAll();
        assertEquals(0, this.dao.count());
        for (Object key : arrayList) {
            Object key2 = this.daoAccess.getKey(key);
            assertNotNull(key2);
            assertNull(this.dao.load(key2));
        }
    }

    public void testDeleteInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 10; i2++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        ArrayList<Object> arrayList2 = new ArrayList<>();
        arrayList2.add(arrayList.get(0));
        arrayList2.add(arrayList.get(3));
        arrayList2.add(arrayList.get(4));
        arrayList2.add(arrayList.get(8));
        this.dao.deleteInTx(arrayList2);
        assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object key : arrayList2) {
            Object key2 = this.daoAccess.getKey(key);
            assertNotNull(key2);
            assertNull(this.dao.load(key2));
        }
    }

    public void testDeleteByKeyInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 10; i2++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.daoAccess.getKey(arrayList.get(0)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(3)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(4)));
        arrayList2.add(this.daoAccess.getKey(arrayList.get(8)));
        this.dao.deleteByKeyInTx(arrayList2);
        assertEquals((long) (arrayList.size() - arrayList2.size()), this.dao.count());
        for (Object next : arrayList2) {
            assertNotNull(next);
            assertNull(this.dao.load(next));
        }
    }

    public void testRowId() {
        assertTrue(this.dao.insert(createEntityWithRandomPk()) != this.dao.insert(createEntityWithRandomPk()));
    }

    public void testLoadAll() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 15; i2++) {
            arrayList.add(createEntity(nextPk()));
        }
        this.dao.insertInTx(arrayList);
        assertEquals(arrayList.size(), this.dao.loadAll().size());
    }

    public void testQuery() {
        this.dao.insert(createEntityWithRandomPk());
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        this.dao.insert(createEntityWithRandomPk());
        List queryRaw = this.dao.queryRaw("WHERE " + this.dao.getPkColumns()[0] + "=?", nextPk.toString());
        assertEquals(1, queryRaw.size());
        assertEquals(nextPk, this.daoAccess.getKey(queryRaw.get(0)));
    }

    public void testUpdate() {
        this.dao.deleteAll();
        Object createEntityWithRandomPk = createEntityWithRandomPk();
        this.dao.insert(createEntityWithRandomPk);
        this.dao.update(createEntityWithRandomPk);
        assertEquals(1, this.dao.count());
    }

    public void testReadWithOffset() {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(5, "42", nextPk);
        try {
            assertEquals(nextPk, this.daoAccess.getKey(this.daoAccess.readEntity(queryWithDummyColumnsInFront, 5)));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    public void testLoadPkWithOffset() {
        runLoadPkTest(10);
    }

    public void testLoadPk() {
        runLoadPkTest(0);
    }

    public void testSave() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            Object createEntity = createEntity((Object) null);
            if (createEntity != null) {
                this.dao.save(createEntity);
                this.dao.save(createEntity);
                assertEquals(1, this.dao.count());
            }
        }
    }

    public void testSaveInTx() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 20; i2++) {
                Object createEntity = createEntity((Object) null);
                if (i2 % 2 == 0) {
                    arrayList.add(createEntity);
                }
                arrayList2.add(createEntity);
            }
            this.dao.saveInTx(arrayList);
            this.dao.saveInTx(arrayList2);
            assertEquals((long) arrayList2.size(), this.dao.count());
        }
    }

    /* access modifiers changed from: protected */
    public void runLoadPkTest(int i2) {
        Object nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(i2, "42", nextPk);
        try {
            assertEquals(nextPk, this.daoAccess.readKey(queryWithDummyColumnsInFront, i2));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    /* access modifiers changed from: protected */
    public Cursor queryWithDummyColumnsInFront(int i2, String str, K k) {
        StringBuilder sb = new StringBuilder("SELECT ");
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append(str);
            sb.append(AppConstants.COMMA);
        }
        SqlUtils.appendColumns(sb, "T", this.dao.getAllColumns()).append(" FROM ");
        sb.append('\"');
        sb.append(this.dao.getTablename());
        sb.append('\"');
        sb.append(" T");
        if (k != null) {
            sb.append(" WHERE ");
            assertEquals(1, this.dao.getPkColumns().length);
            sb.append(this.dao.getPkColumns()[0]);
            sb.append("=");
            DatabaseUtils.appendValueToSql(sb, k);
        }
        Cursor rawQuery = this.db.rawQuery(sb.toString(), (String[]) null);
        assertTrue(rawQuery.moveToFirst());
        while (i3 < i2) {
            try {
                assertEquals(str, rawQuery.getString(i3));
                i3++;
            } catch (RuntimeException e2) {
                rawQuery.close();
                throw e2;
            }
        }
        if (k != null) {
            assertEquals(1, rawQuery.getCount());
        }
        return rawQuery;
    }

    /* access modifiers changed from: protected */
    public boolean checkKeyIsNullable() {
        if (createEntity((Object) null) != null) {
            return true;
        }
        DaoLog.d("Test is not available for entities with non-null keys");
        return false;
    }

    /* access modifiers changed from: protected */
    public K nextPk() {
        for (int i2 = 0; i2 < 100000; i2++) {
            K createRandomPk = createRandomPk();
            if (this.usedPks.add(createRandomPk)) {
                return createRandomPk;
            }
        }
        throw new IllegalStateException("Could not find a new PK");
    }

    /* access modifiers changed from: protected */
    public T createEntityWithRandomPk() {
        return createEntity(nextPk());
    }
}
