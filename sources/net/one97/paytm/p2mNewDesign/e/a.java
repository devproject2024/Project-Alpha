package net.one97.paytm.p2mNewDesign.e;

import android.content.Context;
import android.view.View;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.wallet.communicator.b;

public abstract class a implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    protected boolean f51247c = true;

    public abstract String a();

    public abstract void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z);

    public abstract void a(String str);

    public abstract void a(boolean z);

    public abstract boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list);

    public abstract void b();

    public abstract void b(boolean z);

    public abstract View c();

    public abstract String e();

    public abstract boolean f();

    public abstract void i();

    public final void c(boolean z) {
        this.f51247c = z;
        b(z);
    }

    public static void a(String str, String str2, String str3, Context context, String str4) {
        k.c(str, "eventCategory");
        k.c(str2, "event_action");
        k.c(str3, "event_label");
        k.c(context, "context");
        k.c(str4, SDKConstants.EVENT_KEY_SCREEN_NAME);
        b.a().sendCustomGTMEvents(str, str2, str3, (String) null, context, str4, str4);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
