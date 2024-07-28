package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;

class d implements androidx.sqlite.db.d {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f4569a;

    d(SQLiteProgram sQLiteProgram) {
        this.f4569a = sQLiteProgram;
    }

    public final void a(int i2) {
        this.f4569a.bindNull(i2);
    }

    public final void a(int i2, long j) {
        this.f4569a.bindLong(i2, j);
    }

    public final void a(int i2, double d2) {
        this.f4569a.bindDouble(i2, d2);
    }

    public final void a(int i2, String str) {
        this.f4569a.bindString(i2, str);
    }

    public final void a(int i2, byte[] bArr) {
        this.f4569a.bindBlob(i2, bArr);
    }

    public void close() {
        this.f4569a.close();
    }
}
