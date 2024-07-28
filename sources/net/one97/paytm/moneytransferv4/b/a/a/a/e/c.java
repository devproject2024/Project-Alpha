package net.one97.paytm.moneytransferv4.b.a.a.a.e;

import android.view.View;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.moneytransferv4.b.a.a.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55286a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* renamed from: net.one97.paytm.moneytransferv4.b.a.a.a.e.c$a$a  reason: collision with other inner class name */
        static final class C1012a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f55287a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ContactDetail f55288b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f55289c;

            C1012a(d dVar, ContactDetail contactDetail, int i2) {
                this.f55287a = dVar;
                this.f55288b = contactDetail;
                this.f55289c = i2;
            }

            public final void onClick(View view) {
                this.f55287a.a(this.f55288b, this.f55289c);
            }
        }
    }
}
