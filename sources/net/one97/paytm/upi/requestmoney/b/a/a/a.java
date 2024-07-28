package net.one97.paytm.upi.requestmoney.b.a.a;

import android.content.Context;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.util.UpiDBManager;

public final class a extends AsyncTask<Object, Object, Object> {

    /* renamed from: a  reason: collision with root package name */
    private UpiDBTransactionModel f69112a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f69113b;

    public a(Context context, UpiDBTransactionModel upiDBTransactionModel) {
        this.f69113b = new WeakReference<>(context);
        this.f69112a = upiDBTransactionModel;
    }

    /* access modifiers changed from: protected */
    public final Object doInBackground(Object... objArr) {
        try {
            new UpiDBManager().addOrUpdate((Context) this.f69113b.get(), this.f69112a);
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
