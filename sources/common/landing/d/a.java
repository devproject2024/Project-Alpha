package common.landing.d;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.c;
import common.landing.b.a;
import f.a.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.insurance.InsuranceBuyPayDigitalCatalog;
import net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel;
import net.one97.paytm.common.entity.insurance.InsuranceBuyPayViewData;

public final class a implements b, a.C0181a {

    /* renamed from: a  reason: collision with root package name */
    private final List<InsuranceBuyPayOptionModel> f13500a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final common.landing.c.a.b f13501b;

    /* renamed from: c  reason: collision with root package name */
    private final a.b f13502c;

    public a(common.landing.c.a.b bVar, a.b bVar2) {
        this.f13501b = bVar;
        this.f13502c = bVar2;
    }

    public final void a() {
        a.b bVar = this.f13502c;
        if (bVar != null) {
            bVar.a(true);
        }
        common.landing.c.a.b bVar2 = this.f13501b;
        com.paytm.network.a aVar = null;
        if (bVar2 != null) {
            b bVar3 = this;
            k.c(bVar3, H5Event.TYPE_CALL_BACK);
            common.landing.c.a.b.b bVar4 = bVar2.f13492a;
            if (bVar4 != null) {
                k.c(bVar3, H5Event.TYPE_CALL_BACK);
                net.one97.paytm.insurance.b.a.a();
                String c2 = net.one97.paytm.insurance.b.a.c(bVar4.f13499a);
                StringBuilder sb = new StringBuilder("");
                if (!TextUtils.isEmpty(c2)) {
                    sb = new StringBuilder(c2);
                    sb.append(c.a(bVar4.f13499a));
                    sb.append("&channel=android");
                }
                com.paytm.network.b a2 = new com.paytm.network.b().a(bVar4.f13499a).a(a.C0715a.GET).a(a.c.INSURANCE).c("InsuranceBuyPayActivity").a(bVar3).a(a.b.SILENT);
                b.a aVar2 = f.a.b.f13524a;
                net.one97.paytm.insurance.b.a.a();
                String a3 = net.one97.paytm.insurance.b.a.a(bVar4.f13499a.getApplicationContext());
                k.a((Object) a3, "GTMHelper.getInstance().…ntext.applicationContext)");
                if (b.a.a(a3, bVar4.f13499a)) {
                    k.a((Object) a2, "networkCallBuilder");
                    a2.a((IJRPaytmDataModel) new InsuranceBuyPayDigitalCatalog((List) null, (String) null, (Integer) null, (String) null, (String) null, 31, (g) null));
                } else {
                    k.a((Object) a2, "networkCallBuilder");
                    a2.a((IJRPaytmDataModel) new InsuranceBuyPayViewData((List<InsuranceBuyPayOptionModel>) null, (String) null));
                }
                a2.a(sb.toString());
                aVar = a2.l();
            }
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    public final int b() {
        return this.f13500a.size();
    }

    public final void a(int i2) {
        a.b bVar = this.f13502c;
        if (bVar != null) {
            bVar.a(this.f13500a.get(i2));
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a.b bVar = this.f13502c;
        if (bVar != null) {
            bVar.a(networkCustomError);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof InsuranceBuyPayDigitalCatalog) {
            a.b bVar = this.f13502c;
            if (bVar != null) {
                bVar.a(false);
            }
            this.f13500a.clear();
            InsuranceBuyPayDigitalCatalog insuranceBuyPayDigitalCatalog = (InsuranceBuyPayDigitalCatalog) iJRPaytmDataModel;
            List<InsuranceBuyPayOptionModel> relatedCategories = insuranceBuyPayDigitalCatalog.getRelatedCategories();
            if (relatedCategories != null) {
                this.f13500a.addAll(relatedCategories);
            }
            a.b bVar2 = this.f13502c;
            if (bVar2 != null) {
                bVar2.a();
            }
            a.b bVar3 = this.f13502c;
            if (bVar3 != null) {
                bVar3.a(insuranceBuyPayDigitalCatalog.getCategoryHeader());
            }
            a.b bVar4 = this.f13502c;
            if (bVar4 != null) {
                bVar4.b(insuranceBuyPayDigitalCatalog.getDisplayName());
            }
        }
        if (iJRPaytmDataModel instanceof InsuranceBuyPayViewData) {
            a.b bVar5 = this.f13502c;
            if (bVar5 != null) {
                bVar5.a(false);
            }
            this.f13500a.clear();
            InsuranceBuyPayViewData insuranceBuyPayViewData = (InsuranceBuyPayViewData) iJRPaytmDataModel;
            List<InsuranceBuyPayOptionModel> rc_info = insuranceBuyPayViewData.getRc_info();
            if (rc_info != null) {
                this.f13500a.addAll(rc_info);
            }
            a.b bVar6 = this.f13502c;
            if (bVar6 != null) {
                bVar6.a();
            }
            a.b bVar7 = this.f13502c;
            if (bVar7 != null) {
                bVar7.a(insuranceBuyPayViewData.getExtra_description());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0050, code lost:
        r0 = r0.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(common.landing.a.a.C0178a r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r3, r0)
            android.view.View r0 = r3.itemView
            common.landing.a.a$a$a r1 = new common.landing.a.a$a$a
            r1.<init>(r3, r4)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            java.util.List<net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel> r0 = r2.f13500a
            java.lang.Object r0 = r0.get(r4)
            net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel r0 = (net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel) r0
            java.lang.String r0 = r0.getTitle()
            if (r0 == 0) goto L_0x002e
            java.lang.String r1 = "title"
            kotlin.g.b.k.c(r0, r1)
            android.widget.TextView r1 = r3.f13466a
            if (r1 == 0) goto L_0x002e
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x002e:
            java.util.List<net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel> r0 = r2.f13500a
            java.lang.Object r4 = r0.get(r4)
            net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel r4 = (net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel) r4
            java.lang.String r4 = r4.getIcon_url()
            if (r4 == 0) goto L_0x0077
            java.lang.String r0 = "url"
            kotlin.g.b.k.c(r4, r0)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r4 = r0.a((java.lang.String) r4)
            common.landing.a.a r0 = r3.f13468c
            android.content.Context r0 = r0.f13465b
            if (r0 == 0) goto L_0x005d
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x005d
            int r1 = net.one97.paytm.insurance.R.drawable.ins_bg_circle_f4f4f4
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            goto L_0x005e
        L_0x005d:
            r0 = 0
        L_0x005e:
            if (r0 != 0) goto L_0x0063
            kotlin.g.b.k.a()
        L_0x0063:
            com.squareup.picasso.aa r4 = r4.a((android.graphics.drawable.Drawable) r0)
            int r0 = net.one97.paytm.insurance.R.drawable.ins_bg_circle_f4f4f4
            com.squareup.picasso.aa r4 = r4.b((int) r0)
            android.widget.ImageView r3 = r3.f13467b
            if (r3 != 0) goto L_0x0074
            kotlin.g.b.k.a()
        L_0x0074:
            r4.a((android.widget.ImageView) r3)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: common.landing.d.a.a(common.landing.a.a$a, int):void");
    }
}
