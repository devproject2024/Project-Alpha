package com.travel.bus.busticket.i;

import android.content.Context;
import android.os.AsyncTask;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.bus.busticket.b.g;

public final class j extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    private int f22443a = 112;

    /* renamed from: b  reason: collision with root package name */
    private Context f22444b;

    /* renamed from: c  reason: collision with root package name */
    private IJRPaytmDataModel f22445c;

    /* renamed from: d  reason: collision with root package name */
    private String f22446d;

    /* renamed from: e  reason: collision with root package name */
    private g f22447e;

    public j(Context context, g gVar, IJRPaytmDataModel iJRPaytmDataModel, String str) {
        this.f22444b = context;
        this.f22445c = iJRPaytmDataModel;
        this.f22446d = str;
        this.f22447e = gVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        g gVar;
        g gVar2;
        if (this.f22444b == null) {
            return;
        }
        if (this.f22443a == 111 && (gVar2 = this.f22447e) != null) {
            gVar2.onFileReadComplete(this.f22445c, this.f22446d);
        } else if (this.f22443a == 112 && (gVar = this.f22447e) != null) {
            gVar.onFileWriteComplete(this.f22446d);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        int i2 = this.f22443a;
        if (i2 == 111) {
            this.f22445c = k.a(this.f22444b, this.f22446d);
            return null;
        } else if (i2 != 112) {
            return null;
        } else {
            k.a(this.f22444b, this.f22445c, this.f22446d);
            return null;
        }
    }
}
