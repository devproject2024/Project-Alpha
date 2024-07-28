package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.f;

final class e extends d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteStatement f4570a;

    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f4570a = sQLiteStatement;
    }

    public final int a() {
        return this.f4570a.executeUpdateDelete();
    }

    public final long b() {
        return this.f4570a.executeInsert();
    }
}
