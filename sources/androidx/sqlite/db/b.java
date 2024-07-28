package androidx.sqlite.db;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

public interface b extends Closeable {
    Cursor a(e eVar);

    Cursor a(e eVar, CancellationSignal cancellationSignal);

    f a(String str);

    void a();

    void a(String str, Object[] objArr) throws SQLException;

    Cursor b(String str);

    void b();

    void c();

    void c(String str) throws SQLException;

    boolean d();

    boolean e();

    String f();

    List<Pair<String, String>> g();
}
