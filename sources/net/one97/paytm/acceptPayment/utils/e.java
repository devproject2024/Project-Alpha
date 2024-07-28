package net.one97.paytm.acceptPayment.utils;

import android.app.Activity;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;

public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private b f52164a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Activity> f52165b;

    /* renamed from: c  reason: collision with root package name */
    private String f52166c;

    public e(String str, b bVar, Activity activity) {
        k.d(str, "targetClassName");
        k.d(bVar, "listener");
        this.f52166c = str;
        this.f52164a = bVar;
        this.f52165b = new WeakReference<>(activity);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Activity activity;
        WeakReference<Activity> weakReference = this.f52165b;
        if (!(weakReference == null || (activity = (Activity) weakReference.get()) == null)) {
            b.a(activity, networkCustomError, this.f52166c);
        }
        this.f52164a.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f52164a.onApiSuccess(iJRPaytmDataModel);
    }
}
