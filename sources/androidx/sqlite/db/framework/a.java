package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.sqlite.db.b;
import androidx.sqlite.db.e;
import androidx.sqlite.db.f;
import java.io.IOException;
import java.util.List;

final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4550a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f4551b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteDatabase f4552c;

    a(SQLiteDatabase sQLiteDatabase) {
        this.f4552c = sQLiteDatabase;
    }

    public final f a(String str) {
        return new e(this.f4552c.compileStatement(str));
    }

    public final void a() {
        this.f4552c.beginTransaction();
    }

    public final void b() {
        this.f4552c.endTransaction();
    }

    public final void c() {
        this.f4552c.setTransactionSuccessful();
    }

    public final boolean d() {
        return this.f4552c.inTransaction();
    }

    public final Cursor b(String str) {
        return a((e) new androidx.sqlite.db.a(str));
    }

    public final Cursor a(final e eVar) {
        return this.f4552c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b(), f4551b, (String) null);
    }

    public final Cursor a(final e eVar, CancellationSignal cancellationSignal) {
        return this.f4552c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() {
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b(), f4551b, (String) null, cancellationSignal);
    }

    public final void c(String str) throws SQLException {
        this.f4552c.execSQL(str);
    }

    public final void a(String str, Object[] objArr) throws SQLException {
        this.f4552c.execSQL(str, objArr);
    }

    public final boolean e() {
        return this.f4552c.isOpen();
    }

    public final String f() {
        return this.f4552c.getPath();
    }

    public final List<Pair<String, String>> g() {
        return this.f4552c.getAttachedDbs();
    }

    public final void close() throws IOException {
        this.f4552c.close();
    }

    /* access modifiers changed from: package-private */
    public final boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f4552c == sQLiteDatabase;
    }
}
