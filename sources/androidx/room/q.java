package androidx.room;

import androidx.sqlite.db.f;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class q {
    private final j mDatabase;
    private final AtomicBoolean mLock = new AtomicBoolean(false);
    private volatile f mStmt;

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public q(j jVar) {
        this.mDatabase = jVar;
    }

    /* access modifiers changed from: protected */
    public void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    private f createNewStatement() {
        return this.mDatabase.compileStatement(createQuery());
    }

    private f getStmt(boolean z) {
        if (!z) {
            return createNewStatement();
        }
        if (this.mStmt == null) {
            this.mStmt = createNewStatement();
        }
        return this.mStmt;
    }

    public f acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    public void release(f fVar) {
        if (fVar == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
