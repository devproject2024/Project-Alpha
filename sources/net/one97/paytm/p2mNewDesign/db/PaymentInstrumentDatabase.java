package net.one97.paytm.p2mNewDesign.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.g.b.k;
import net.one97.paytm.p2mNewDesign.db.a.c;
import net.one97.paytm.p2mNewDesign.db.a.e;

public abstract class PaymentInstrumentDatabase extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f51202a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile PaymentInstrumentDatabase f51203b;

    public abstract net.one97.paytm.p2mNewDesign.db.a.a a();

    public abstract e b();

    public abstract c c();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final PaymentInstrumentDatabase a(Context context) {
            PaymentInstrumentDatabase d2;
            k.c(context, "context");
            synchronized (this) {
                d2 = PaymentInstrumentDatabase.f51203b;
                if (d2 == null) {
                    d2 = i.a(context.getApplicationContext(), PaymentInstrumentDatabase.class, "payment_instrument_database").b().c();
                    PaymentInstrumentDatabase.f51203b = d2;
                }
            }
            return d2;
        }
    }
}
