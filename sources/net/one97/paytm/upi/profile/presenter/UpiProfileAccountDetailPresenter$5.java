package net.one97.paytm.upi.profile.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class UpiProfileAccountDetailPresenter$5 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f67997a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f67998b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpiProfileAccountDetailPresenter$5(f fVar, Handler handler, String str) {
        super(handler);
        this.f67998b = fVar;
        this.f67997a = str;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        f.a(this.f67998b, 0, bundle, this.f67997a);
    }
}
