package net.one97.paytm.contacts.b;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import net.one97.paytm.contacts.entities.db_entities.Configuration;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final j f50091a;

    /* renamed from: b  reason: collision with root package name */
    private final c f50092b;

    public f(j jVar) {
        this.f50091a = jVar;
        this.f50092b = new c<Configuration>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `configuration_table`(`id`,`timestamp`,`type`,`fallbackEnabled`) VALUES (nullif(?, 0),?,?,?)";
            }

            public final /* synthetic */ void bind(androidx.sqlite.db.f fVar, Object obj) {
                Configuration configuration = (Configuration) obj;
                fVar.a(1, configuration.getId());
                fVar.a(2, configuration.getTimestamp());
                if (configuration.getType() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, (long) configuration.getType().intValue());
                }
                Integer valueOf = configuration.getFallbackEnabled() == null ? null : Integer.valueOf(configuration.getFallbackEnabled().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, (long) valueOf.intValue());
                }
            }
        };
    }

    public final void a(Configuration configuration) {
        this.f50091a.beginTransaction();
        try {
            this.f50092b.insert(configuration);
            this.f50091a.setTransactionSuccessful();
        } finally {
            this.f50091a.endTransaction();
        }
    }

    public final long a(int i2) {
        m a2 = m.a("Select timestamp  from configuration_table where type =?", 1);
        a2.a(1, (long) i2);
        Cursor query = this.f50091a.query(a2);
        try {
            return query.moveToFirst() ? query.getLong(0) : 0;
        } finally {
            query.close();
            a2.a();
        }
    }
}
