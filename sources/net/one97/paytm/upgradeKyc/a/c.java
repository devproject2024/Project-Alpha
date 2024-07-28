package net.one97.paytm.upgradeKyc.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import java.util.ArrayList;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.t;
import net.one97.paytm.upgradeKyc.utils.e;

public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private Context f65209a;

    /* renamed from: b  reason: collision with root package name */
    private String f65210b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f65211c;

    /* renamed from: d  reason: collision with root package name */
    private String f65212d;

    /* renamed from: e  reason: collision with root package name */
    private String f65213e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<PayTMPartnerListModal.Response> f65214f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f65215g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private String f65216h;

    public final int getCount() {
        return 1;
    }

    public c(Context context, j jVar, String str, String str2, boolean z, String str3, String str4, ArrayList<PayTMPartnerListModal.Response> arrayList) {
        super(jVar);
        this.f65209a = context;
        this.f65210b = str;
        this.f65211c = z;
        this.f65212d = str3;
        this.f65213e = str4;
        this.f65216h = str2;
        this.f65214f = arrayList;
        this.f65215g.clear();
        if (!TextUtils.isEmpty(this.f65212d)) {
            this.f65215g.add(this.f65212d);
        }
        if (!TextUtils.isEmpty(this.f65213e)) {
            this.f65215g.add(this.f65213e);
        }
        if (this.f65211c) {
            this.f65215g.add(this.f65209a.getString(R.string.courier_doc));
        }
    }

    public final Fragment a() {
        Bundle bundle = new Bundle();
        bundle.putString("tab", this.f65212d);
        bundle.putSerializable("kyc_center_list", this.f65214f);
        bundle.putString("doc_number", this.f65210b);
        bundle.putString("doc_type", this.f65216h);
        t tVar = new t();
        tVar.setArguments(bundle);
        return tVar;
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f65209a.getString(R.string.visit_kyc_center);
    }

    public final String a(int i2) {
        if (i2 < this.f65215g.size()) {
            return this.f65215g.get(i2);
        }
        return null;
    }
}
