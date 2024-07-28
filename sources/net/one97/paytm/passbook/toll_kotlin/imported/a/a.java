package net.one97.paytm.passbook.toll_kotlin.imported.a;

import android.app.Activity;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.b;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.toll_kotlin.imported.model.TollTxnPsgHstryModel;
import net.one97.paytm.passbook.toll_kotlin.imported.model.TollWalletPsgHistoryModel;
import net.one97.paytm.passbook.toll_kotlin.imported.model.TollWalletpsgHstryResponseModel;

public final class a implements g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public TollTxnPsgHstryModel f58942a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.passbook.toll_kotlin.imported.a f58943b;

    /* renamed from: c  reason: collision with root package name */
    public List<TollWalletPsgHistoryModel> f58944c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58945d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f58946e;

    /* renamed from: f  reason: collision with root package name */
    private int f58947f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Activity f58948g;

    public final /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        this.f58943b.b();
        if (iJRDataModel != null && (iJRDataModel instanceof TollWalletpsgHstryResponseModel)) {
            TollWalletpsgHstryResponseModel tollWalletpsgHstryResponseModel = (TollWalletpsgHstryResponseModel) iJRDataModel;
            if (TextUtils.isEmpty(tollWalletpsgHstryResponseModel.getStatus())) {
                return;
            }
            if (tollWalletpsgHstryResponseModel.getStatus().equalsIgnoreCase("SUCCESS")) {
                List<TollWalletPsgHistoryModel> entryModelList = tollWalletpsgHstryResponseModel.getEntryModelList();
                if (entryModelList != null) {
                    int size = this.f58944c.size();
                    this.f58944c.addAll(entryModelList);
                    this.f58943b.a(size, this.f58944c.size());
                }
                if (entryModelList.size() < 20) {
                    this.f58945d = false;
                } else {
                    this.f58945d = true;
                }
            } else {
                this.f58943b.a(this.f58942a.getErrorHeading(), tollWalletpsgHstryResponseModel.getStatusMessage());
            }
        }
    }

    public a(TollTxnPsgHstryModel tollTxnPsgHstryModel, net.one97.paytm.passbook.toll_kotlin.imported.a aVar, Activity activity) {
        this.f58942a = tollTxnPsgHstryModel;
        this.f58943b = aVar;
        this.f58944c = new ArrayList();
        this.f58948g = activity;
    }

    public final void a() {
        b tollEntriesRequest = this.f58942a.getTollEntriesRequest(20, b(), this, this);
        if (com.paytm.utility.b.c(this.f58948g.getApplicationContext())) {
            this.f58943b.a();
            if (tollEntriesRequest != null) {
                this.f58948g.getApplicationContext();
                c.a();
                c.b(tollEntriesRequest);
            }
            this.f58946e = true;
            return;
        }
        this.f58943b.b();
        this.f58943b.a((e) tollEntriesRequest);
    }

    public final int b() {
        return this.f58944c.size();
    }

    public final TollWalletPsgHistoryModel a(int i2) {
        return this.f58944c.get(i2);
    }

    public static w c() {
        return w.a();
    }

    public final int d() {
        int i2 = this.f58947f;
        if (i2 != 0) {
            return i2;
        }
        int round = Math.round((this.f58942a.getContext().getResources().getDisplayMetrics().xdpi / 160.0f) * 50.0f);
        this.f58947f = round;
        return round;
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f58943b.b();
        this.f58943b.a((Throwable) networkCustomError);
    }
}
