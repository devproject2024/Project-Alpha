package net.one97.paytm.insurance.common.landing.b;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.a.y;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.insurance.InsuranceCategoryList;
import net.one97.paytm.common.entity.insurance.InsuranceCategoryModel;
import net.one97.paytm.insurance.common.landing.a.a;

public final class a implements b, a.C0193a {

    /* renamed from: a  reason: collision with root package name */
    private List<InsuranceCategoryModel> f14015a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Boolean f14016b;

    /* renamed from: c  reason: collision with root package name */
    private String f14017c;

    /* renamed from: d  reason: collision with root package name */
    private final common.landing.c.a.a f14018d;

    /* renamed from: e  reason: collision with root package name */
    private final a.b f14019e;

    public a(common.landing.c.a.a aVar, a.b bVar) {
        k.c(aVar, "categoryRepository");
        k.c(bVar, "categorySelectionView");
        this.f14018d = aVar;
        this.f14019e = bVar;
    }

    public final void a() {
        StringBuilder sb;
        CharSequence charSequence;
        this.f14016b = this.f14019e.b();
        this.f14017c = this.f14019e.c();
        a.b bVar = this.f14019e;
        if (bVar != null) {
            bVar.a(true);
        }
        common.landing.c.a.a aVar = this.f14018d;
        b bVar2 = this;
        Boolean bool = this.f14016b;
        String str = this.f14017c;
        k.c(bVar2, H5Event.TYPE_CALL_BACK);
        common.landing.c.a.b.a aVar2 = aVar.f13482a;
        k.c(bVar2, H5Event.TYPE_CALL_BACK);
        if (!k.a((Object) bool, (Object) Boolean.TRUE)) {
            k.a((Object) net.one97.paytm.insurance.b.a.a(), "GTMHelper.getInstance()");
            StringBuilder sb2 = new StringBuilder(net.one97.paytm.insurance.b.a.b());
            sb2.append(c.a(aVar2.f13496a, false));
            sb = new StringBuilder(sb2);
        } else if (TextUtils.isEmpty(str)) {
            k.a((Object) net.one97.paytm.insurance.b.a.a(), "GTMHelper.getInstance()");
            StringBuilder sb3 = new StringBuilder(net.one97.paytm.insurance.b.a.b());
            sb3.append(c.a(aVar2.f13496a, false));
            sb = new StringBuilder(sb3);
            sb.append("&flag=bundle");
        } else {
            Uri parse = Uri.parse(str);
            k.a((Object) parse, "Uri.parse(bundleUrl)");
            Set<String> queryParameterNames = parse != null ? parse.getQueryParameterNames() : null;
            StringBuilder sb4 = new StringBuilder(c.a(aVar2.f13496a, false));
            if (queryParameterNames == null) {
                queryParameterNames = y.INSTANCE;
            }
            if (true ^ queryParameterNames.isEmpty()) {
                CharSequence charSequence2 = sb4;
                k.d(charSequence2, "$this$removePrefix");
                k.d(r3, "prefix");
                if (p.b(charSequence2, r3)) {
                    charSequence = charSequence2.subSequence(r3.length(), charSequence2.length());
                } else {
                    charSequence = charSequence2.subSequence(0, charSequence2.length());
                }
                StringBuilder insert = new StringBuilder(charSequence).insert(0, AppConstants.AND_SIGN);
                StringBuilder sb5 = new StringBuilder(str);
                sb5.append(insert);
                sb = sb5;
            } else {
                sb = new StringBuilder(str);
                sb.append(sb4);
            }
        }
        if (sb != null) {
            sb.append("&channel=androidapp");
        }
        com.paytm.network.a l = new com.paytm.network.b().a(aVar2.f13496a).a(a.C0715a.GET).a(a.c.INSURANCE).a(String.valueOf(sb)).a((IJRPaytmDataModel) new InsuranceCategoryList((List<InsuranceCategoryModel>) null, (String) null)).c("CategorySelectionActivity").a(bVar2).a(a.b.SILENT).l();
        if (l != null) {
            l.a();
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f14019e.a(networkCustomError);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof InsuranceCategoryList) {
            a.b bVar = this.f14019e;
            if (bVar != null) {
                bVar.a(false);
            }
            this.f14015a.clear();
            InsuranceCategoryList insuranceCategoryList = (InsuranceCategoryList) iJRPaytmDataModel;
            List<InsuranceCategoryModel> products = insuranceCategoryList.getProducts();
            if (products != null) {
                this.f14015a.addAll(products);
            }
            this.f14019e.a();
            this.f14019e.a(insuranceCategoryList.getTitle());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0025, code lost:
        r1 = r1.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(common.landing.a.b.a r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r4, r0)
            java.util.List<net.one97.paytm.common.entity.insurance.InsuranceCategoryModel> r0 = r3.f14015a
            java.lang.Object r0 = r0.get(r5)
            net.one97.paytm.common.entity.insurance.InsuranceCategoryModel r0 = (net.one97.paytm.common.entity.insurance.InsuranceCategoryModel) r0
            java.lang.String r0 = r0.getLogo()
            java.lang.String r1 = "url"
            kotlin.g.b.k.c(r0, r1)
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r0 = r1.a((java.lang.String) r0)
            common.landing.a.b r1 = r4.f13476c
            android.content.Context r1 = r1.f13473b
            if (r1 == 0) goto L_0x0032
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0032
            int r2 = net.one97.paytm.insurance.R.drawable.ins_bg_circle_f4f4f4
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            if (r1 != 0) goto L_0x0038
            kotlin.g.b.k.a()
        L_0x0038:
            com.squareup.picasso.aa r0 = r0.a((android.graphics.drawable.Drawable) r1)
            int r1 = net.one97.paytm.insurance.R.drawable.ins_bg_circle_f4f4f4
            com.squareup.picasso.aa r0 = r0.b((int) r1)
            android.widget.ImageView r1 = r4.f13475b
            r0.a((android.widget.ImageView) r1)
            java.util.List<net.one97.paytm.common.entity.insurance.InsuranceCategoryModel> r0 = r3.f14015a
            java.lang.Object r0 = r0.get(r5)
            net.one97.paytm.common.entity.insurance.InsuranceCategoryModel r0 = (net.one97.paytm.common.entity.insurance.InsuranceCategoryModel) r0
            java.lang.String r0 = r0.getTitle()
            java.lang.String r1 = "title"
            kotlin.g.b.k.c(r0, r1)
            android.widget.TextView r1 = r4.f13474a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            android.view.View r0 = r4.itemView
            common.landing.a.b$a$a r1 = new common.landing.a.b$a$a
            r1.<init>(r4, r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.common.landing.b.a.a(common.landing.a.b$a, int):void");
    }

    public final int b() {
        return this.f14015a.size();
    }

    public final void a(int i2) {
        this.f14019e.a(this.f14015a.get(i2));
    }
}
