package net.one97.paytm.contacts.b;

import androidx.room.c;
import androidx.room.j;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.List;
import net.one97.paytm.contacts.entities.db_entities.NonExistedContacts;

public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final j f50094a;

    /* renamed from: b  reason: collision with root package name */
    private final c f50095b;

    /* renamed from: c  reason: collision with root package name */
    private final q f50096c;

    public h(j jVar) {
        this.f50094a = jVar;
        this.f50095b = new c<NonExistedContacts>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `non_existed_contacts`(`row_id`,`contactId`,`type`) VALUES (nullif(?, 0),?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                NonExistedContacts nonExistedContacts = (NonExistedContacts) obj;
                fVar.a(1, nonExistedContacts.getId());
                if (nonExistedContacts.getContactId() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, nonExistedContacts.getContactId());
                }
                if (nonExistedContacts.getType() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, (long) nonExistedContacts.getType().intValue());
                }
            }
        };
        this.f50096c = new q(jVar) {
            public final String createQuery() {
                return "Delete from non_existed_contacts where contactId=?";
            }
        };
    }

    public final void a(List<NonExistedContacts> list) {
        this.f50094a.beginTransaction();
        try {
            this.f50095b.insert(list);
            this.f50094a.setTransactionSuccessful();
        } finally {
            this.f50094a.endTransaction();
        }
    }

    public final void a(String str) {
        f acquire = this.f50096c.acquire();
        this.f50094a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f50094a.endTransaction();
                this.f50096c.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f50094a.setTransactionSuccessful();
        this.f50094a.endTransaction();
        this.f50096c.release(acquire);
    }
}
