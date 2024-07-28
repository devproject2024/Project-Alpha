package net.one97.paytm.moneytransfer.b.a.a;

import android.content.Context;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.moneytransfer.utils.j;

public final class a extends AsyncTask<Object, Object, Object> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<BeneficiaryEntity> f53532a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f53533b;

    public a(Context context, ArrayList<BeneficiaryEntity> arrayList) {
        this.f53533b = new WeakReference<>(context);
        this.f53532a = arrayList;
    }

    /* access modifiers changed from: protected */
    public final Object doInBackground(Object... objArr) {
        try {
            new j();
            j.a((Context) this.f53533b.get(), this.f53532a);
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
