package net.one97.paytm.upi.requestmoney.b.a.a;

import android.content.Context;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.e;
import net.one97.paytm.upi.util.UpiDBManager;

public final class b extends AsyncTask<String, String, ArrayList<UpiDBTransactionModel>> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f69114a;

    /* renamed from: b  reason: collision with root package name */
    private e f69115b;

    /* renamed from: c  reason: collision with root package name */
    private String f69116c;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        super.onPostExecute(arrayList);
        e eVar = this.f69115b;
        if (eVar != null) {
            eVar.a(arrayList);
        }
    }

    public b(Context context, String str, e eVar) {
        this.f69114a = new WeakReference<>(context);
        this.f69116c = str;
        this.f69115b = eVar;
    }

    private ArrayList<UpiDBTransactionModel> a() {
        try {
            return new UpiDBManager().getRecentTransactions((Context) this.f69114a.get(), this.f69116c);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
