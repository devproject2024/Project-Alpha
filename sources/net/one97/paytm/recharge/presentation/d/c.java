package net.one97.paytm.recharge.presentation.d;

import android.os.Bundle;
import androidx.fragment.app.j;
import net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;

public interface c {
    io.reactivex.rxjava3.j.c<CJRTaggedObservable<?>> a(int i2, Bundle bundle);

    void a();

    void a(String str);

    void a(String str, CJRPayChannelOptions cJRPayChannelOptions, boolean z);

    void a(CJRPaymentModes cJRPaymentModes);

    void a(CJRTaggedObservable<?> cJRTaggedObservable);

    io.reactivex.rxjava3.j.c<CJRTaggedObservable<CJRFetchBalanceResponse>> b();

    String c();

    j d();
}
