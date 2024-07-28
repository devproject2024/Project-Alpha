package net.one97.paytm.feed.ui.feed;

import androidx.databinding.h;
import androidx.databinding.m;
import androidx.lifecycle.ai;
import com.alipay.mobile.h5container.api.H5Event;
import kotlin.g.b.k;

public abstract class d extends ai implements h {

    /* renamed from: a  reason: collision with root package name */
    private transient m f35025a;

    public synchronized void addOnPropertyChangedCallback(h.a aVar) {
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        if (this.f35025a == null) {
            this.f35025a = new m();
        }
        m mVar = this.f35025a;
        if (mVar == null) {
            k.a();
        }
        mVar.a(aVar);
    }

    public synchronized void removeOnPropertyChangedCallback(h.a aVar) {
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        if (this.f35025a != null) {
            m mVar = this.f35025a;
            if (mVar == null) {
                k.a();
            }
            mVar.b(aVar);
        }
    }

    public final void a(int i2) {
        m mVar = this.f35025a;
        if (mVar != null) {
            if (mVar == null) {
                k.a();
            }
            mVar.a(this, i2);
        }
    }
}
