package net.one97.paytm.contacts.db;

import android.content.Context;
import net.one97.paytm.contacts.b.k;
import net.one97.paytm.contacts.b.m;

public abstract class ContactDatabase extends androidx.room.j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50139a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile ContactDatabase f50140b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final androidx.room.a.a f50141c = new i();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final androidx.room.a.a f50142d = new h();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final androidx.room.a.a f50143e = new g();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final androidx.room.a.a f50144f = new f();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final androidx.room.a.a f50145g = new e();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final androidx.room.a.a f50146h = new d();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final androidx.room.a.a f50147i = new c();
    /* access modifiers changed from: private */
    public static final androidx.room.a.a j = new b();
    /* access modifiers changed from: private */
    public static final androidx.room.a.a k = new j();

    public abstract k a();

    public abstract m b();

    public abstract net.one97.paytm.contacts.b.a c();

    public abstract net.one97.paytm.contacts.b.g d();

    public abstract net.one97.paytm.contacts.b.e e();

    public abstract net.one97.paytm.contacts.b.i f();

    public abstract net.one97.paytm.contacts.b.c g();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final ContactDatabase a(Context context) {
            ContactDatabase h2;
            kotlin.g.b.k.c(context, "context");
            synchronized (this) {
                h2 = ContactDatabase.f50140b;
                if (h2 == null) {
                    h2 = androidx.room.i.a(context.getApplicationContext(), ContactDatabase.class, "contact_database").a(ContactDatabase.f50141c, ContactDatabase.f50142d, ContactDatabase.f50143e, ContactDatabase.f50144f, ContactDatabase.f50145g, ContactDatabase.f50146h, ContactDatabase.f50147i, ContactDatabase.j, ContactDatabase.k).c();
                    ContactDatabase.f50140b = h2;
                }
            }
            return h2;
        }
    }

    public static final class i extends androidx.room.a.a {
        i() {
            super(8, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class h extends androidx.room.a.a {
        h() {
            super(7, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class g extends androidx.room.a.a {
        g() {
            super(6, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class f extends androidx.room.a.a {
        f() {
            super(5, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class e extends androidx.room.a.a {
        e() {
            super(4, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class d extends androidx.room.a.a {
        d() {
            super(3, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class c extends androidx.room.a.a {
        c() {
            super(2, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class b extends androidx.room.a.a {
        b() {
            super(1, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("ALTER TABLE payee_meta_info  ADD COLUMN newContactVisibility TEXT");
            bVar.c("ALTER TABLE payee_info_table  ADD COLUMN newContactVisibility TEXT");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }

    public static final class j extends androidx.room.a.a {
        j() {
            super(9, 10);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            kotlin.g.b.k.c(bVar, "database");
            bVar.c("update configuration_table set timestamp=0 where type= 1");
        }
    }
}
