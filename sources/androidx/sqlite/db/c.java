package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.Closeable;

public interface c extends Closeable {

    /* renamed from: androidx.sqlite.db.c$c  reason: collision with other inner class name */
    public interface C0072c {
        c a(b bVar);
    }

    String a();

    void a(boolean z);

    b b();

    void close();

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4541a;

        public abstract void a(b bVar);

        public abstract void a(b bVar, int i2, int i3);

        public void b(b bVar) {
        }

        public a(int i2) {
            this.f4541a = i2;
        }

        public void b(b bVar, int i2, int i3) {
            throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(java.lang.String r2) {
            /*
                java.lang.String r0 = ":memory:"
                boolean r0 = r2.equalsIgnoreCase(r0)
                if (r0 != 0) goto L_0x002a
                java.lang.String r0 = r2.trim()
                int r0 = r0.length()
                if (r0 != 0) goto L_0x0013
                goto L_0x002a
            L_0x0013:
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x002a }
                r1 = 16
                if (r0 < r1) goto L_0x0022
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x002a }
                r0.<init>(r2)     // Catch:{ Exception -> 0x002a }
                android.database.sqlite.SQLiteDatabase.deleteDatabase(r0)     // Catch:{ Exception -> 0x002a }
                return
            L_0x0022:
                java.io.File r0 = new java.io.File     // Catch:{  }
                r0.<init>(r2)     // Catch:{  }
                r0.delete()     // Catch:{  }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.c.a.a(java.lang.String):void");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f4542a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4543b;

        /* renamed from: c  reason: collision with root package name */
        public final a f4544c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4545d;

        b(Context context, String str, a aVar, boolean z) {
            this.f4542a = context;
            this.f4543b = str;
            this.f4544c = aVar;
            this.f4545d = z;
        }

        public static a a(Context context) {
            return new a(context);
        }

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            Context f4546a;

            /* renamed from: b  reason: collision with root package name */
            public String f4547b;

            /* renamed from: c  reason: collision with root package name */
            public a f4548c;

            /* renamed from: d  reason: collision with root package name */
            boolean f4549d;

            public final b a() {
                if (this.f4548c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.f4546a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.f4549d || !TextUtils.isEmpty(this.f4547b)) {
                    return new b(this.f4546a, this.f4547b, this.f4548c, this.f4549d);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            a(Context context) {
                this.f4546a = context;
            }

            public final a a(String str) {
                this.f4547b = str;
                return this;
            }

            public final a a(a aVar) {
                this.f4548c = aVar;
                return this;
            }

            public final a b() {
                this.f4549d = true;
                return this;
            }
        }
    }
}
