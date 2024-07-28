package net.one97.paytm.moneytransfer.b.a.a;

import android.content.Context;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.utils.j;

public final class c extends AsyncTask<String, String, ArrayList<BeneficiaryEntity>> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f53537a;

    /* renamed from: b  reason: collision with root package name */
    private a.b f53538b;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        super.onPostExecute(arrayList);
        if (this.f53538b != null) {
            CJRKYCBeneficiaryBase cJRKYCBeneficiaryBase = new CJRKYCBeneficiaryBase();
            cJRKYCBeneficiaryBase.setTotalCount(arrayList.size());
            cJRKYCBeneficiaryBase.setBeneficiariesList(arrayList);
            this.f53538b.onSuccess(cJRKYCBeneficiaryBase);
        }
    }

    public c(Context context, a.b bVar) {
        this.f53537a = new WeakReference<>(context);
        this.f53538b = bVar;
    }

    private ArrayList<BeneficiaryEntity> a() {
        try {
            new j();
            return j.a((Context) this.f53537a.get());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
