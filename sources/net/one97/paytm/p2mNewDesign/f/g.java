package net.one97.paytm.p2mNewDesign.f;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import net.one97.paytm.network.f;
import net.one97.paytm.p2mNewDesign.b.a;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;

public interface g extends e {
    LiveData<f> a(Context context, String str);

    LiveData<f> a(String str, Context context, String str2, boolean z);

    void a(String str, boolean z, boolean z2);

    void a(InstrumentInfo instrumentInfo, String str);

    void c(boolean z);

    String d();

    void d(String str);

    String e();

    void e(boolean z);

    void f(boolean z);

    a g();

    j getFragmentManager();

    a h();

    boolean i();

    boolean j();

    boolean k();

    void n();

    void o();

    void p();

    Activity q();

    void r();

    void s();

    boolean t();

    void u();
}
