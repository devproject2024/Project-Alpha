package androidx.room;

import android.database.Cursor;
import androidx.sqlite.db.c;
import androidx.sqlite.db.e;

public final class l extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private a f4465b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4466c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4467d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4468e;

    public l(a aVar, a aVar2, String str, String str2) {
        super(aVar2.version);
        this.f4465b = aVar;
        this.f4466c = aVar2;
        this.f4467d = str;
        this.f4468e = str2;
    }

    public final void a(androidx.sqlite.db.b bVar) {
        boolean f2 = f(bVar);
        this.f4466c.createAllTables(bVar);
        if (!f2) {
            b onValidateSchema = this.f4466c.onValidateSchema(bVar);
            if (!onValidateSchema.f4469a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f4470b);
            }
        }
        c(bVar);
        this.f4466c.onCreate(bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.sqlite.db.b r6, int r7, int r8) {
        /*
            r5 = this;
            androidx.room.a r0 = r5.f4465b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0061
            androidx.room.j$d r0 = r0.f4376d
            if (r7 != r8) goto L_0x000f
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x001d
        L_0x000f:
            if (r8 <= r7) goto L_0x0013
            r3 = 1
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r0 = r0.a(r4, r3, r7, r8)
        L_0x001d:
            if (r0 == 0) goto L_0x0061
            androidx.room.l$a r2 = r5.f4466c
            r2.onPreMigrate(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x0028:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r0.next()
            androidx.room.a.a r2 = (androidx.room.a.a) r2
            r2.migrate(r6)
            goto L_0x0028
        L_0x0038:
            androidx.room.l$a r0 = r5.f4466c
            androidx.room.l$b r0 = r0.onValidateSchema(r6)
            boolean r2 = r0.f4469a
            if (r2 == 0) goto L_0x004b
            androidx.room.l$a r0 = r5.f4466c
            r0.onPostMigrate(r6)
            r5.c(r6)
            goto L_0x0062
        L_0x004b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Migration didn't properly handle: "
            r7.<init>(r8)
            java.lang.String r8 = r0.f4470b
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0061:
            r1 = 0
        L_0x0062:
            if (r1 != 0) goto L_0x009a
            androidx.room.a r0 = r5.f4465b
            if (r0 == 0) goto L_0x0079
            boolean r0 = r0.a(r7, r8)
            if (r0 != 0) goto L_0x0079
            androidx.room.l$a r7 = r5.f4466c
            r7.dropAllTables(r6)
            androidx.room.l$a r7 = r5.f4466c
            r7.createAllTables(r6)
            return
        L_0x0079:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "A migration from "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = " to "
            r0.append(r7)
            r0.append(r8)
            java.lang.String r7 = " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.l.a(androidx.sqlite.db.b, int, int):void");
    }

    public final void b(androidx.sqlite.db.b bVar, int i2, int i3) {
        a(bVar, i2, i3);
    }

    /* JADX INFO: finally extract failed */
    public final void b(androidx.sqlite.db.b bVar) {
        super.b(bVar);
        if (e(bVar)) {
            Cursor a2 = bVar.a((e) new androidx.sqlite.db.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                String string = a2.moveToFirst() ? a2.getString(0) : null;
                a2.close();
                if (!this.f4467d.equals(string) && !this.f4468e.equals(string)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
        } else {
            b onValidateSchema = this.f4466c.onValidateSchema(bVar);
            if (onValidateSchema.f4469a) {
                this.f4466c.onPostMigrate(bVar);
                c(bVar);
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f4470b);
            }
        }
        this.f4466c.onOpen(bVar);
        this.f4465b = null;
    }

    private void c(androidx.sqlite.db.b bVar) {
        d(bVar);
        bVar.c(k.a(this.f4467d));
    }

    private static void d(androidx.sqlite.db.b bVar) {
        bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean e(androidx.sqlite.db.b bVar) {
        Cursor b2 = bVar.b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (b2.moveToFirst() && b2.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            b2.close();
        }
    }

    private static boolean f(androidx.sqlite.db.b bVar) {
        Cursor b2 = bVar.b("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (b2.moveToFirst() && b2.getInt(0) == 0) {
                z = true;
            }
            return z;
        } finally {
            b2.close();
        }
    }

    public static abstract class a {
        public final int version;

        /* access modifiers changed from: protected */
        public abstract void createAllTables(androidx.sqlite.db.b bVar);

        /* access modifiers changed from: protected */
        public abstract void dropAllTables(androidx.sqlite.db.b bVar);

        /* access modifiers changed from: protected */
        public abstract void onCreate(androidx.sqlite.db.b bVar);

        /* access modifiers changed from: protected */
        public abstract void onOpen(androidx.sqlite.db.b bVar);

        /* access modifiers changed from: protected */
        public void onPostMigrate(androidx.sqlite.db.b bVar) {
        }

        /* access modifiers changed from: protected */
        public void onPreMigrate(androidx.sqlite.db.b bVar) {
        }

        public a(int i2) {
            this.version = i2;
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void validateMigration(androidx.sqlite.db.b bVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        /* access modifiers changed from: protected */
        public b onValidateSchema(androidx.sqlite.db.b bVar) {
            validateMigration(bVar);
            return new b(true, (String) null);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4469a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4470b;

        public b(boolean z, String str) {
            this.f4469a = z;
            this.f4470b = str;
        }
    }
}
