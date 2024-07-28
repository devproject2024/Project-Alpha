package net.one97.paytm.insurance.common.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gsonhtcfix.b.g;
import com.paytm.network.model.IJRPaytmDataModel;
import f.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.InsuranceOrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.common.a.a;
import org.json.JSONObject;

public final class b extends common.insuranceOrderSummary.c implements DialogInterface.OnClickListener, View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private List<String> f14004d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private Context f14005e;

    /* renamed from: f  reason: collision with root package name */
    private View f14006f;

    /* renamed from: g  reason: collision with root package name */
    private CJROrderSummary f14007g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f14008h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJROrderSummary f14009i;
    private g<String, String> j;
    /* access modifiers changed from: private */
    public a k;
    private HashMap l;

    public final View a(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Boolean bool = this.f13438c;
        if (bool == null) {
            k.a();
        }
        if (!bool.booleanValue()) {
            net.one97.paytm.insurance.b.c.a().sendOpenScreenEvent(getContext(), "/term-life-insurance/summary");
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.insurance.b.b.INSTANCE.setAnimation((LottieAnimationView) a(R.id.progress_bar));
        ((RelativeLayout) a(R.id.contact_us_view)).setOnClickListener(new C0192b(this));
        ((TextView) a(R.id.tv_download_policy_wording)).setOnClickListener(new c(this));
        a(this.f13437b);
        Bundle arguments = getArguments();
        Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean("IS_MY_ORDER_SCREEN", false)) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            ImageView imageView = (ImageView) a(R.id.ivBackBtn);
            k.a((Object) imageView, "ivBackBtn");
            imageView.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.automatic_payments_view);
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new d(this));
        }
    }

    /* renamed from: net.one97.paytm.insurance.common.a.b$b  reason: collision with other inner class name */
    static final class C0192b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14011a;

        C0192b(b bVar) {
            this.f14011a = bVar;
        }

        public final void onClick(View view) {
            a aVar;
            b bVar = this.f14011a;
            CJROrderSummary b2 = bVar.f14009i;
            if (b2 != null) {
                a.C0191a aVar2 = a.f13991c;
                aVar = a.C0191a.a(b2);
            } else {
                aVar = null;
            }
            bVar.k = aVar;
            a a2 = this.f14011a.k;
            if (a2 != null) {
                a2.a(this.f14011a.getContext(), this.f14011a.getChildFragmentManager());
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14012a;

        c(b bVar) {
            this.f14012a = bVar;
        }

        public final void onClick(View view) {
            this.f14012a.c();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14013a;

        d(b bVar) {
            this.f14013a = bVar;
        }

        public final void onClick(View view) {
            String str;
            net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
            Context context = this.f14013a.getContext();
            StringBuilder sb = new StringBuilder("paytmmp://insautopay?orderid=");
            common.insuranceOrderSummary.d dVar = this.f14013a.f13436a;
            if (dVar != null) {
                str = dVar.k;
            } else {
                str = null;
            }
            sb.append(str);
            sb.append("&insurance_type=15");
            a2.handleDeepLink(context, sb.toString(), (Bundle) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r15 = (r15 = r15.getOrderedCartList()).get(0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x05b9  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x05d9  */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x05de  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x05e8  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0612  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0617  */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0620  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0658  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0682  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x068b  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x068e  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0697  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x06b3  */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x06be  */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x06c1  */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x06ca  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x074a  */
    /* JADX WARNING: Removed duplicated region for block: B:642:0x0d2f  */
    /* JADX WARNING: Removed duplicated region for block: B:659:0x0db4  */
    /* JADX WARNING: Removed duplicated region for block: B:662:0x0dc3  */
    /* JADX WARNING: Removed duplicated region for block: B:668:0x0e53  */
    /* JADX WARNING: Removed duplicated region for block: B:675:0x0e65  */
    /* JADX WARNING: Removed duplicated region for block: B:676:0x0e68  */
    /* JADX WARNING: Removed duplicated region for block: B:679:0x0e71  */
    /* JADX WARNING: Removed duplicated region for block: B:680:0x0e8e  */
    /* JADX WARNING: Removed duplicated region for block: B:683:0x0eb9  */
    /* JADX WARNING: Removed duplicated region for block: B:684:0x0ebc  */
    /* JADX WARNING: Removed duplicated region for block: B:687:0x0ed4  */
    /* JADX WARNING: Removed duplicated region for block: B:688:0x0ed7  */
    /* JADX WARNING: Removed duplicated region for block: B:691:0x0eef  */
    /* JADX WARNING: Removed duplicated region for block: B:692:0x0ef2  */
    /* JADX WARNING: Removed duplicated region for block: B:695:0x0f0a  */
    /* JADX WARNING: Removed duplicated region for block: B:696:0x0f0d  */
    /* JADX WARNING: Removed duplicated region for block: B:699:0x0f1d  */
    /* JADX WARNING: Removed duplicated region for block: B:703:0x0f76  */
    /* JADX WARNING: Removed duplicated region for block: B:704:0x0f79  */
    /* JADX WARNING: Removed duplicated region for block: B:706:0x0f7c  */
    /* JADX WARNING: Removed duplicated region for block: B:709:0x0f8b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r15) {
        /*
            r14 = this;
            androidx.fragment.app.FragmentActivity r0 = r14.getActivity()
            r1 = 1
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isFinishing()
            if (r0 == r1) goto L_0x0013
        L_0x000d:
            boolean r0 = r14.isAdded()
            if (r0 != 0) goto L_0x0014
        L_0x0013:
            return
        L_0x0014:
            if (r15 == 0) goto L_0x1119
            r0 = r15
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r0
            r14.f14009i = r0
            if (r15 == 0) goto L_0x1111
            r14.f14007g = r0
            common.insuranceOrderSummary.d r15 = new common.insuranceOrderSummary.d
            java.lang.String r0 = "15"
            r15.<init>(r0)
            r14.f13436a = r15
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            r0 = 0
            r2 = 0
            if (r15 == 0) goto L_0x0041
            java.util.ArrayList r15 = r15.getOrderedCartList()
            if (r15 == 0) goto L_0x0041
            java.lang.Object r15 = r15.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15
            if (r15 == 0) goto L_0x0041
            java.lang.Object r15 = r15.getMetaDataResponse()
            goto L_0x0042
        L_0x0041:
            r15 = r2
        L_0x0042:
            if (r15 == 0) goto L_0x1109
            com.google.gsonhtcfix.b.g r15 = (com.google.gsonhtcfix.b.g) r15
            java.lang.String r3 = "info"
            if (r15 == 0) goto L_0x004f
            java.lang.Object r15 = r15.get(r3)
            goto L_0x0050
        L_0x004f:
            r15 = r2
        L_0x0050:
            if (r15 == 0) goto L_0x1101
            com.google.gsonhtcfix.b.g r15 = (com.google.gsonhtcfix.b.g) r15
            r14.j = r15
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x006b
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r14.j
            if (r4 == 0) goto L_0x0068
            java.lang.String r5 = "title"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0069
        L_0x0068:
            r4 = r2
        L_0x0069:
            r15.f13445a = r4
        L_0x006b:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            if (r15 == 0) goto L_0x0088
            java.util.ArrayList r15 = r15.getOrderedCartList()
            if (r15 == 0) goto L_0x0088
            java.lang.Object r15 = r15.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15
            if (r15 == 0) goto L_0x0088
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r15 = r15.getFullFillmentOject()
            if (r15 == 0) goto L_0x0088
            java.lang.String r15 = r15.getFulfillmentResponse()
            goto L_0x0089
        L_0x0088:
            r15 = r2
        L_0x0089:
            if (r15 == 0) goto L_0x00b0
            org.json.JSONObject r15 = new org.json.JSONObject
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r14.f14007g
            if (r4 == 0) goto L_0x00aa
            java.util.ArrayList r4 = r4.getOrderedCartList()
            if (r4 == 0) goto L_0x00aa
            java.lang.Object r4 = r4.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x00aa
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()
            if (r4 == 0) goto L_0x00aa
            java.lang.String r4 = r4.getFulfillmentResponse()
            goto L_0x00ab
        L_0x00aa:
            r4 = r2
        L_0x00ab:
            r15.<init>(r4)
            r14.f14008h = r15
        L_0x00b0:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x00c5
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r14.j
            if (r4 == 0) goto L_0x00c2
            java.lang.String r5 = "sub_title"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x00c3
        L_0x00c2:
            r4 = r2
        L_0x00c3:
            r15.f13446b = r4
        L_0x00c5:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x00d9
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r14.j
            if (r4 == 0) goto L_0x00d6
            java.lang.String r5 = "image_url"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x00d7
        L_0x00d6:
            r4 = r2
        L_0x00d7:
            r15.f13447c = r4
        L_0x00d9:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x00ee
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r14.j
            if (r4 == 0) goto L_0x00eb
            java.lang.String r5 = "wording_url"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x00ec
        L_0x00eb:
            r4 = r2
        L_0x00ec:
            r15.f13448d = r4
        L_0x00ee:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0103
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r14.j
            if (r4 == 0) goto L_0x0100
            java.lang.String r5 = "underwriting_text"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0101
        L_0x0100:
            r4 = r2
        L_0x0101:
            r15.p = r4
        L_0x0103:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0117
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r14.j
            if (r4 == 0) goto L_0x0114
            java.lang.String r5 = "questionnaire_url"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0115
        L_0x0114:
            r4 = r2
        L_0x0115:
            r15.s = r4
        L_0x0117:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            if (r15 == 0) goto L_0x012e
            java.util.ArrayList r15 = r15.getOrderedCartList()
            if (r15 == 0) goto L_0x012e
            java.lang.Object r15 = r15.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15
            if (r15 == 0) goto L_0x012e
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r15 = r15.getProductDetail()
            goto L_0x012f
        L_0x012e:
            r15 = r2
        L_0x012f:
            common.insuranceOrderSummary.d r4 = r14.f13436a
            if (r4 == 0) goto L_0x013d
            if (r15 == 0) goto L_0x013a
            java.lang.String r15 = r15.getName()
            goto L_0x013b
        L_0x013a:
            r15 = r2
        L_0x013b:
            r4.f13445a = r15
        L_0x013d:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            if (r15 == 0) goto L_0x015a
            java.util.ArrayList r15 = r15.getOrderedCartList()
            if (r15 == 0) goto L_0x015a
            java.lang.Object r15 = r15.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15
            if (r15 == 0) goto L_0x015a
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r15 = r15.getFullFillmentOject()
            if (r15 == 0) goto L_0x015a
            java.lang.String r15 = r15.getFulfillmentResponse()
            goto L_0x015b
        L_0x015a:
            r15 = r2
        L_0x015b:
            if (r15 == 0) goto L_0x0182
            org.json.JSONObject r15 = new org.json.JSONObject
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r14.f14007g
            if (r4 == 0) goto L_0x017c
            java.util.ArrayList r4 = r4.getOrderedCartList()
            if (r4 == 0) goto L_0x017c
            java.lang.Object r4 = r4.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x017c
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()
            if (r4 == 0) goto L_0x017c
            java.lang.String r4 = r4.getFulfillmentResponse()
            goto L_0x017d
        L_0x017c:
            r4 = r2
        L_0x017d:
            r15.<init>(r4)
            r14.f14008h = r15
        L_0x0182:
            org.json.JSONObject r15 = r14.f14008h
            if (r15 == 0) goto L_0x0267
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x019f
            org.json.JSONObject r4 = r14.f14008h
            if (r4 == 0) goto L_0x019c
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x019c
            java.lang.String r5 = "sub_title"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x019d
        L_0x019c:
            r4 = r2
        L_0x019d:
            r15.f13446b = r4
        L_0x019f:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x01b7
            org.json.JSONObject r4 = r14.f14008h
            if (r4 == 0) goto L_0x01b4
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x01b4
            java.lang.String r5 = "image_url"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x01b5
        L_0x01b4:
            r4 = r2
        L_0x01b5:
            r15.f13447c = r4
        L_0x01b7:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x01d0
            org.json.JSONObject r4 = r14.f14008h
            if (r4 == 0) goto L_0x01cd
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x01cd
            java.lang.String r5 = "wording_url"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x01ce
        L_0x01cd:
            r4 = r2
        L_0x01ce:
            r15.f13448d = r4
        L_0x01d0:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x01e9
            org.json.JSONObject r4 = r14.f14008h
            if (r4 == 0) goto L_0x01e6
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x01e6
            java.lang.String r5 = "underwriting_text"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x01e7
        L_0x01e6:
            r4 = r2
        L_0x01e7:
            r15.p = r4
        L_0x01e9:
            org.json.JSONObject r15 = r14.f14008h
            if (r15 == 0) goto L_0x01f4
            java.lang.String r4 = "cancellation_charges"
            java.lang.String r15 = r15.optString(r4)
            goto L_0x01f5
        L_0x01f4:
            r15 = r2
        L_0x01f5:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x021b
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0229
            f.a.b$a r4 = f.a.b.f13524a
            org.json.JSONObject r4 = r14.f14008h
            if (r4 == 0) goto L_0x020e
            java.lang.String r5 = "cancellation_charges"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x020f
        L_0x020e:
            r4 = r2
        L_0x020f:
            if (r4 != 0) goto L_0x0214
            kotlin.g.b.k.a()
        L_0x0214:
            java.lang.String r4 = f.a.b.a.a((java.lang.String) r4)
            r15.r = r4
            goto L_0x0229
        L_0x021b:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0229
            f.a.b$a r4 = f.a.b.f13524a
            java.lang.String r4 = "0"
            java.lang.String r4 = f.a.b.a.a((java.lang.String) r4)
            r15.r = r4
        L_0x0229:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x023b
            org.json.JSONObject r4 = r14.f14008h
            if (r4 == 0) goto L_0x0238
            java.lang.String r5 = "nextPremium"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x0239
        L_0x0238:
            r4 = r2
        L_0x0239:
            r15.t = r4
        L_0x023b:
            org.json.JSONObject r15 = r14.f14008h
            if (r15 == 0) goto L_0x0246
            java.lang.String r4 = "questionnaire_url"
            java.lang.String r15 = r15.optString(r4)
            goto L_0x0247
        L_0x0246:
            r15 = r2
        L_0x0247:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x0267
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0267
            org.json.JSONObject r4 = r14.f14008h
            if (r4 == 0) goto L_0x0264
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x0264
            java.lang.String r5 = "questionnaire_url"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x0265
        L_0x0264:
            r4 = r2
        L_0x0265:
            r15.s = r4
        L_0x0267:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            if (r15 == 0) goto L_0x027a
            java.util.ArrayList r15 = r15.getPaymentInfo()
            if (r15 == 0) goto L_0x027a
            int r15 = r15.size()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x027b
        L_0x027a:
            r15 = r2
        L_0x027b:
            if (r15 != 0) goto L_0x0280
            kotlin.g.b.k.a()
        L_0x0280:
            int r15 = r15.intValue()
            if (r15 <= r1) goto L_0x02b2
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x02b2
            f.a.b$a r4 = f.a.b.f13524a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r14.f14007g
            if (r4 == 0) goto L_0x02a7
            java.util.ArrayList r4 = r4.getPaymentInfo()
            if (r4 == 0) goto L_0x02a7
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r4 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r4
            if (r4 == 0) goto L_0x02a7
            double r4 = r4.getPgAmount()
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            goto L_0x02a8
        L_0x02a7:
            r4 = r2
        L_0x02a8:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = f.a.b.a.a((java.lang.String) r4)
            r15.q = r4
        L_0x02b2:
            java.util.List<java.lang.String> r15 = r14.f14004d
            if (r15 == 0) goto L_0x02ca
            android.content.Context r4 = r14.f14005e
            if (r4 == 0) goto L_0x02c1
            int r5 = net.one97.paytm.insurance.R.string.health_ins_premium_paid
            java.lang.String r4 = r4.getString(r5)
            goto L_0x02c2
        L_0x02c1:
            r4 = r2
        L_0x02c2:
            if (r4 != 0) goto L_0x02c7
            kotlin.g.b.k.a()
        L_0x02c7:
            r15.add(r4)
        L_0x02ca:
            java.util.List<java.lang.String> r15 = r14.f14004d
            if (r15 == 0) goto L_0x02e2
            android.content.Context r4 = r14.f14005e
            if (r4 == 0) goto L_0x02d9
            int r5 = net.one97.paytm.insurance.R.string.life_ins_medical_questionnaire_filled
            java.lang.String r4 = r4.getString(r5)
            goto L_0x02da
        L_0x02d9:
            r4 = r2
        L_0x02da:
            if (r4 != 0) goto L_0x02df
            kotlin.g.b.k.a()
        L_0x02df:
            r15.add(r4)
        L_0x02e2:
            java.util.List<java.lang.String> r15 = r14.f14004d
            if (r15 == 0) goto L_0x02fa
            android.content.Context r4 = r14.f14005e
            if (r4 == 0) goto L_0x02f1
            int r5 = net.one97.paytm.insurance.R.string.life_ins_medical_assessment
            java.lang.String r4 = r4.getString(r5)
            goto L_0x02f2
        L_0x02f1:
            r4 = r2
        L_0x02f2:
            if (r4 != 0) goto L_0x02f7
            kotlin.g.b.k.a()
        L_0x02f7:
            r15.add(r4)
        L_0x02fa:
            java.util.List<java.lang.String> r15 = r14.f14004d
            if (r15 == 0) goto L_0x0312
            android.content.Context r4 = r14.f14005e
            if (r4 == 0) goto L_0x0309
            int r5 = net.one97.paytm.insurance.R.string.life_ins_application_submission
            java.lang.String r4 = r4.getString(r5)
            goto L_0x030a
        L_0x0309:
            r4 = r2
        L_0x030a:
            if (r4 != 0) goto L_0x030f
            kotlin.g.b.k.a()
        L_0x030f:
            r15.add(r4)
        L_0x0312:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x031a
            java.util.List<java.lang.String> r4 = r14.f14004d
            r15.f13449e = r4
        L_0x031a:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            if (r15 == 0) goto L_0x0323
            java.lang.String r15 = r15.getPaymentStatus()
            goto L_0x0324
        L_0x0323:
            r15 = r2
        L_0x0324:
            common.insuranceOrderSummary.d r4 = r14.f13436a
            if (r4 == 0) goto L_0x032a
            r4.f13450f = r15
        L_0x032a:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0331
            java.lang.String r15 = r15.f13450f
            goto L_0x0332
        L_0x0331:
            r15 = r2
        L_0x0332:
            java.lang.String r4 = "PROCESSING"
            java.lang.String r5 = "SUCCESS"
            if (r15 != 0) goto L_0x0339
            goto L_0x039f
        L_0x0339:
            int r6 = r15.hashCode()
            r7 = -1149187101(0xffffffffbb80cbe3, float:-0.003930555)
            if (r6 == r7) goto L_0x038d
            r7 = 907287315(0x36141b13, float:2.2069478E-6)
            if (r6 == r7) goto L_0x036e
            r7 = 2066319421(0x7b29883d, float:8.802614E35)
            if (r6 == r7) goto L_0x034d
            goto L_0x039f
        L_0x034d:
            java.lang.String r6 = "FAILED"
            boolean r15 = r15.equals(r6)
            if (r15 == 0) goto L_0x039f
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0361
            int r6 = net.one97.paytm.insurance.R.string.payment_failed
            java.lang.String r6 = r14.getString(r6)
            r15.f13451g = r6
        L_0x0361:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x039f
            int r6 = net.one97.paytm.insurance.R.string.health_ins_payment_failed_desc
            java.lang.String r6 = r14.getString(r6)
            r15.o = r6
            goto L_0x039f
        L_0x036e:
            boolean r15 = r15.equals(r4)
            if (r15 == 0) goto L_0x039f
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0380
            int r6 = net.one97.paytm.insurance.R.string.payment_pending
            java.lang.String r6 = r14.getString(r6)
            r15.f13451g = r6
        L_0x0380:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x039f
            int r6 = net.one97.paytm.insurance.R.string.health_ins_payment_pending_desc
            java.lang.String r6 = r14.getString(r6)
            r15.o = r6
            goto L_0x039f
        L_0x038d:
            boolean r15 = r15.equals(r5)
            if (r15 == 0) goto L_0x039f
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x039f
            int r6 = net.one97.paytm.insurance.R.string.payment_successful
            java.lang.String r6 = r14.getString(r6)
            r15.f13451g = r6
        L_0x039f:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x03a6
            java.lang.String r15 = r15.f13450f
            goto L_0x03a7
        L_0x03a6:
            r15 = r2
        L_0x03a7:
            if (r15 != 0) goto L_0x03aa
            goto L_0x040e
        L_0x03aa:
            int r6 = r15.hashCode()
            r7 = -1149187101(0xffffffffbb80cbe3, float:-0.003930555)
            if (r6 == r7) goto L_0x03f4
            r7 = 907287315(0x36141b13, float:2.2069478E-6)
            if (r6 == r7) goto L_0x03da
            r7 = 2066319421(0x7b29883d, float:8.802614E35)
            if (r6 == r7) goto L_0x03be
            goto L_0x040e
        L_0x03be:
            java.lang.String r6 = "FAILED"
            boolean r15 = r15.equals(r6)
            if (r15 == 0) goto L_0x040e
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x041a
            android.content.Context r6 = r14.f14005e
            if (r6 != 0) goto L_0x03d1
            kotlin.g.b.k.a()
        L_0x03d1:
            int r7 = net.one97.paytm.insurance.R.drawable.ins_ic_failed
            android.graphics.drawable.Drawable r6 = androidx.core.content.b.a((android.content.Context) r6, (int) r7)
            r15.f13452h = r6
            goto L_0x041a
        L_0x03da:
            boolean r15 = r15.equals(r4)
            if (r15 == 0) goto L_0x040e
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x041a
            android.content.Context r6 = r14.f14005e
            if (r6 != 0) goto L_0x03eb
            kotlin.g.b.k.a()
        L_0x03eb:
            int r7 = net.one97.paytm.insurance.R.drawable.ins_ic_pending_copy
            android.graphics.drawable.Drawable r6 = androidx.core.content.b.a((android.content.Context) r6, (int) r7)
            r15.f13452h = r6
            goto L_0x041a
        L_0x03f4:
            boolean r15 = r15.equals(r5)
            if (r15 == 0) goto L_0x040e
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x041a
            android.content.Context r6 = r14.f14005e
            if (r6 != 0) goto L_0x0405
            kotlin.g.b.k.a()
        L_0x0405:
            int r7 = net.one97.paytm.insurance.R.drawable.ins_ic_success
            android.graphics.drawable.Drawable r6 = androidx.core.content.b.a((android.content.Context) r6, (int) r7)
            r15.f13452h = r6
            goto L_0x041a
        L_0x040e:
            android.content.Context r15 = r14.f14005e
            if (r15 != 0) goto L_0x0415
            kotlin.g.b.k.a()
        L_0x0415:
            int r6 = net.one97.paytm.insurance.R.drawable.ins_ic_pending_copy
            androidx.core.content.b.a((android.content.Context) r15, (int) r6)
        L_0x041a:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            if (r15 == 0) goto L_0x0431
            java.util.ArrayList r15 = r15.getOrderedCartList()
            if (r15 == 0) goto L_0x0431
            java.lang.Object r15 = r15.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15
            if (r15 == 0) goto L_0x0431
            java.lang.String r15 = r15.getAggregateItemPrice()
            goto L_0x0432
        L_0x0431:
            r15 = r2
        L_0x0432:
            common.insuranceOrderSummary.d r6 = r14.f13436a
            if (r6 == 0) goto L_0x0442
            f.a.b$a r7 = f.a.b.f13524a
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r15 = f.a.b.a.a((java.lang.String) r15)
            r6.j = r15
        L_0x0442:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0456
            android.os.Bundle r6 = r14.getArguments()
            if (r6 == 0) goto L_0x0453
            java.lang.String r7 = "order_id"
            java.lang.String r6 = r6.getString(r7)
            goto L_0x0454
        L_0x0453:
            r6 = r2
        L_0x0454:
            r15.k = r6
        L_0x0456:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x04d0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = ""
            r6.<init>(r7)
            org.json.JSONObject r7 = r14.f14008h
            if (r7 == 0) goto L_0x046c
            java.lang.String r8 = "insuredFirstName"
            java.lang.String r7 = r7.optString(r8)
            goto L_0x046d
        L_0x046c:
            r7 = r2
        L_0x046d:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x04a9
            java.lang.String r7 = "For "
            r6.append(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            org.json.JSONObject r8 = r14.f14008h
            if (r8 == 0) goto L_0x048a
            java.lang.String r9 = "insuredFirstName"
            java.lang.String r8 = r8.optString(r9)
            goto L_0x048b
        L_0x048a:
            r8 = r2
        L_0x048b:
            r7.append(r8)
            java.lang.String r8 = " "
            r7.append(r8)
            org.json.JSONObject r8 = r14.f14008h
            if (r8 == 0) goto L_0x049e
            java.lang.String r9 = "insuredLastName"
            java.lang.String r8 = r8.optString(r9)
            goto L_0x049f
        L_0x049e:
            r8 = r2
        L_0x049f:
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.append(r7)
        L_0x04a9:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x04ca
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r7 = r14.j
            if (r7 == 0) goto L_0x04bf
            java.lang.String r8 = "applicant_name"
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x04c0
        L_0x04bf:
            r7 = r2
        L_0x04c0:
            if (r7 == 0) goto L_0x04ca
            java.lang.String r8 = "For "
            r6.append(r8)
            r6.append(r7)
        L_0x04ca:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r15.l = r6
        L_0x04d0:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x04ee
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r14.f14007g
            if (r6 == 0) goto L_0x04eb
            java.util.ArrayList r6 = r6.getOrderedCartList()
            if (r6 == 0) goto L_0x04eb
            java.lang.Object r6 = r6.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            if (r6 == 0) goto L_0x04eb
            java.lang.String r6 = r6.getItemStatus()
            goto L_0x04ec
        L_0x04eb:
            r6 = r2
        L_0x04ec:
            r15.m = r6
        L_0x04ee:
            int r15 = net.one97.paytm.insurance.R.id.transaction_amount_success
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "transaction_amount_success"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.e(r15)
            int r15 = net.one97.paytm.insurance.R.id.ivInsurerLogo
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            java.lang.String r6 = "ivInsurerLogo"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.a((android.widget.ImageView) r15)
            int r15 = net.one97.paytm.insurance.R.id.ivInsurerLogo
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            java.lang.String r6 = "ivInsurerLogo"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.b((android.widget.ImageView) r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_brand_name
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_brand_name"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.b((android.widget.TextView) r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_plan_name
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_plan_name"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.a((android.widget.TextView) r15)
            int r15 = net.one97.paytm.insurance.R.id.tvOrderIdValue
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tvOrderIdValue"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.f(r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_member_num
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_member_num"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.g(r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_payment_status_text"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.c((android.widget.TextView) r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_payment_status_text"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.c((android.widget.TextView) r15)
            int r15 = net.one97.paytm.insurance.R.id.iv_insurance_logo
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            java.lang.String r6 = "iv_insurance_logo"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.c((android.widget.ImageView) r15)
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x05a0
            java.lang.String r15 = r15.f13450f
            if (r15 == 0) goto L_0x05a0
            kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r5, (boolean) r1)
        L_0x05a0:
            int r15 = net.one97.paytm.insurance.R.id.tv_money_deducted
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_money_deducted"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r6 = 8
            r15.setVisibility(r6)
            android.content.Context r15 = r14.getContext()
            if (r15 == 0) goto L_0x05be
            int r7 = net.one97.paytm.insurance.R.string.okay_got_it
            r15.getString(r7)
        L_0x05be:
            android.content.Context r15 = r14.getContext()
            if (r15 == 0) goto L_0x05d5
            android.content.res.Resources r15 = r15.getResources()
            if (r15 == 0) goto L_0x05d5
            int r7 = net.one97.paytm.insurance.R.array.recharge_summary_moeny_deducted_messages
            java.lang.String[] r15 = r15.getStringArray(r7)
            if (r15 == 0) goto L_0x05d5
            kotlin.a.f.b(r15)
        L_0x05d5:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r15 = r14.f14007g
            if (r15 == 0) goto L_0x05de
            java.lang.String r15 = r15.getCreatedAt()
            goto L_0x05df
        L_0x05de:
            r15 = r2
        L_0x05df:
            r7 = r15
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x060b
            int r7 = net.one97.paytm.insurance.R.id.tvTimeDate
            android.view.View r7 = r14.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r8 = "tvTimeDate"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            f.a.b$a r8 = f.a.b.f13524a
            if (r15 != 0) goto L_0x05fd
            kotlin.g.b.k.a()
        L_0x05fd:
            java.lang.String r8 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            java.lang.String r9 = "dd MMM yyyy, hh:mm aa"
            java.lang.String r15 = f.a.b.a.b(r15, r8, r9)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r7.setText(r15)
        L_0x060b:
            org.json.JSONObject r15 = r14.f14008h
            java.lang.String r7 = "updatedAt"
            if (r15 == 0) goto L_0x0617
            java.lang.String r15 = r15.optString(r7)
            goto L_0x0618
        L_0x0617:
            r15 = r2
        L_0x0618:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x0658
            int r15 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            org.json.JSONObject r8 = r14.f14008h
            if (r8 == 0) goto L_0x0631
            java.lang.String r8 = r8.optString(r7)
            goto L_0x0632
        L_0x0631:
            r8 = r2
        L_0x0632:
            a((android.widget.TextView) r15, (java.lang.String) r8)
            int r15 = net.one97.paytm.insurance.R.id.tv_last_updated_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r8 = "tv_last_updated_text"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r8 = "tv_last_updated_value"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r0)
            goto L_0x067a
        L_0x0658:
            int r15 = net.one97.paytm.insurance.R.id.tv_last_updated_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r8 = "tv_last_updated_text"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r8 = "tv_last_updated_value"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r6)
        L_0x067a:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x068b
            java.lang.String r15 = r15.f13450f
            if (r15 == 0) goto L_0x068b
            boolean r15 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r4, (boolean) r1)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x068c
        L_0x068b:
            r15 = r2
        L_0x068c:
            if (r15 != 0) goto L_0x0691
            kotlin.g.b.k.a()
        L_0x0691:
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x06ab
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_desc
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r8 = "tv_payment_status_desc"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r14.d(r15)
            r14.a()
        L_0x06ab:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x06be
            java.lang.String r15 = r15.f13450f
            if (r15 == 0) goto L_0x06be
            java.lang.String r8 = "FAILED"
            boolean r15 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r8, (boolean) r1)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x06bf
        L_0x06be:
            r15 = r2
        L_0x06bf:
            if (r15 != 0) goto L_0x06c4
            kotlin.g.b.k.a()
        L_0x06c4:
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x074a
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_desc
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r1 = "tv_payment_status_desc"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            r14.d(r15)
            java.lang.Boolean r15 = r14.f13438c
            if (r15 != 0) goto L_0x06e2
            kotlin.g.b.k.a()
        L_0x06e2:
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x10e3
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x0740 }
            r1 = 5
            r15.<init>(r1)     // Catch:{ Exception -> 0x0740 }
            r1 = r15
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0740 }
            java.lang.String r2 = "event_category"
            java.lang.String r3 = "term_life_insurance"
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0740 }
            r1 = r15
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0740 }
            java.lang.String r2 = "event_action"
            java.lang.String r3 = "summary_page_loaded_payment_FAILED"
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0740 }
            r1 = r15
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0740 }
            java.lang.String r2 = "vertical_name"
            java.lang.String r3 = "Buy Insurance"
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0740 }
            android.content.Context r1 = r14.getContext()     // Catch:{ Exception -> 0x0740 }
            boolean r1 = com.paytm.utility.b.r((android.content.Context) r1)     // Catch:{ Exception -> 0x0740 }
            if (r1 == 0) goto L_0x072f
            r1 = r15
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0740 }
            java.lang.String r2 = "user_id"
            android.content.Context r3 = r14.getContext()     // Catch:{ Exception -> 0x0740 }
            java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r3)     // Catch:{ Exception -> 0x0740 }
            java.lang.String r4 = "CJRAppCommonUtility.getUserId(context)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0740 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0740 }
        L_0x072f:
            net.one97.paytm.insurance.a.a r1 = net.one97.paytm.insurance.b.c.a()     // Catch:{ Exception -> 0x0740 }
            java.lang.String r2 = "custom_event"
            java.util.Map r15 = (java.util.Map) r15     // Catch:{ Exception -> 0x0740 }
            android.content.Context r3 = r14.getContext()     // Catch:{ Exception -> 0x0740 }
            r1.sendCustomEventWithMap(r2, r15, r3)     // Catch:{ Exception -> 0x0740 }
            goto L_0x10e3
        L_0x0740:
            r15 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x10e3
            r15.printStackTrace()
            goto L_0x10e3
        L_0x074a:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x075b
            java.lang.String r15 = r15.f13450f
            if (r15 == 0) goto L_0x075b
            boolean r15 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r5, (boolean) r1)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x075c
        L_0x075b:
            r15 = r2
        L_0x075c:
            if (r15 != 0) goto L_0x0761
            kotlin.g.b.k.a()
        L_0x0761:
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x10b8
            java.lang.Boolean r15 = r14.f13438c
            if (r15 != 0) goto L_0x076e
            kotlin.g.b.k.a()
        L_0x076e:
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x07d3
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x07cb }
            r5 = 5
            r15.<init>(r5)     // Catch:{ Exception -> 0x07cb }
            r5 = r15
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x07cb }
            java.lang.String r8 = "event_category"
            java.lang.String r9 = "term_life_insurance"
            r5.put(r8, r9)     // Catch:{ Exception -> 0x07cb }
            r5 = r15
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x07cb }
            java.lang.String r8 = "event_action"
            java.lang.String r9 = "summary_page_loaded_payment_SUCCESS"
            r5.put(r8, r9)     // Catch:{ Exception -> 0x07cb }
            r5 = r15
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x07cb }
            java.lang.String r8 = "vertical_name"
            java.lang.String r9 = "Buy Insurance"
            r5.put(r8, r9)     // Catch:{ Exception -> 0x07cb }
            android.content.Context r5 = r14.getContext()     // Catch:{ Exception -> 0x07cb }
            boolean r5 = com.paytm.utility.b.r((android.content.Context) r5)     // Catch:{ Exception -> 0x07cb }
            if (r5 == 0) goto L_0x07bb
            r5 = r15
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x07cb }
            java.lang.String r8 = "user_id"
            android.content.Context r9 = r14.getContext()     // Catch:{ Exception -> 0x07cb }
            java.lang.String r9 = com.paytm.utility.b.n((android.content.Context) r9)     // Catch:{ Exception -> 0x07cb }
            java.lang.String r10 = "CJRAppCommonUtility.getUserId(context)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x07cb }
            r5.put(r8, r9)     // Catch:{ Exception -> 0x07cb }
        L_0x07bb:
            net.one97.paytm.insurance.a.a r5 = net.one97.paytm.insurance.b.c.a()     // Catch:{ Exception -> 0x07cb }
            java.lang.String r8 = "custom_event"
            java.util.Map r15 = (java.util.Map) r15     // Catch:{ Exception -> 0x07cb }
            android.content.Context r9 = r14.getContext()     // Catch:{ Exception -> 0x07cb }
            r5.sendCustomEventWithMap(r8, r15, r9)     // Catch:{ Exception -> 0x07cb }
            goto L_0x07d3
        L_0x07cb:
            r15 = move-exception
            boolean r5 = com.paytm.utility.b.v
            if (r5 == 0) goto L_0x07d3
            r15.printStackTrace()
        L_0x07d3:
            int r15 = net.one97.paytm.insurance.R.id.dash
            android.view.View r15 = r14.a((int) r15)
            java.lang.String r5 = "dash"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.rl_header
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            java.lang.String r5 = "rl_header"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.rl_payment_status
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            java.lang.String r5 = "rl_payment_status"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_pending
            android.view.View r15 = r14.a((int) r15)
            java.lang.String r5 = "lyt_application_status_pending"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.cl_header
            android.view.View r15 = r14.a((int) r15)
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            java.lang.String r5 = "cl_header"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.success_payee_details_rl
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            java.lang.String r5 = "success_payee_details_rl"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.toolbar
            android.view.View r15 = r14.a((int) r15)
            androidx.appcompat.widget.Toolbar r15 = (androidx.appcompat.widget.Toolbar) r15
            java.lang.String r5 = "toolbar"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tvHeaderMsg
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r5 = "tvHeaderMsg"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r5 = r14.j
            if (r5 == 0) goto L_0x085c
            java.lang.String r8 = "description"
            java.lang.Object r5 = r5.get(r8)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x085d
        L_0x085c:
            r5 = r2
        L_0x085d:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r15.setText(r5)
            org.json.JSONObject r15 = r14.f14008h
            if (r15 == 0) goto L_0x088b
            int r15 = net.one97.paytm.insurance.R.id.tvHeaderMsg
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r5 = "tvHeaderMsg"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            org.json.JSONObject r5 = r14.f14008h
            if (r5 == 0) goto L_0x0885
            org.json.JSONObject r3 = r5.optJSONObject(r3)
            if (r3 == 0) goto L_0x0885
            java.lang.String r5 = "description"
            java.lang.String r3 = r3.optString(r5)
            goto L_0x0886
        L_0x0885:
            r3 = r2
        L_0x0886:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r15.setText(r3)
        L_0x088b:
            int r15 = net.one97.paytm.insurance.R.id.toolbar
            android.view.View r15 = r14.a((int) r15)
            androidx.appcompat.widget.Toolbar r15 = (androidx.appcompat.widget.Toolbar) r15
            net.one97.paytm.insurance.common.a.b$e r3 = new net.one97.paytm.insurance.common.a.b$e
            r3.<init>(r14)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r15.setOnClickListener(r3)
            int r15 = net.one97.paytm.insurance.R.id.tvHeaderTitle
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r3 = "tvHeaderTitle"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r14.f13436a
            if (r3 == 0) goto L_0x08b2
            java.lang.String r3 = r3.f13445a
            goto L_0x08b3
        L_0x08b2:
            r3 = r2
        L_0x08b3:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r15.setText(r3)
            com.squareup.picasso.w r15 = com.squareup.picasso.w.a()
            common.insuranceOrderSummary.d r3 = r14.f13436a
            if (r3 == 0) goto L_0x08c3
            java.lang.String r3 = r3.f13447c
            goto L_0x08c4
        L_0x08c3:
            r3 = r2
        L_0x08c4:
            com.squareup.picasso.aa r15 = r15.a((java.lang.String) r3)
            int r3 = net.one97.paytm.insurance.R.id.ivLogo
            android.view.View r3 = r14.a((int) r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r15.a((android.widget.ImageView) r3)
            int r15 = net.one97.paytm.insurance.R.id.tvAmount
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r3 = "tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r14.f13436a
            if (r3 == 0) goto L_0x08e8
            java.lang.String r3 = r3.f13453i
            goto L_0x08e9
        L_0x08e8:
            r3 = r2
        L_0x08e9:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r15.setText(r3)
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x08f5
            java.lang.String r15 = r15.f13448d
            goto L_0x08f6
        L_0x08f5:
            r15 = r2
        L_0x08f6:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x090f
            int r15 = net.one97.paytm.insurance.R.id.tv_download_policy_wording
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r3 = "tv_download_policy_wording"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            r15.setVisibility(r0)
        L_0x090f:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0916
            java.lang.String r15 = r15.m
            goto L_0x0917
        L_0x0916:
            r15 = r2
        L_0x0917:
            if (r15 != 0) goto L_0x091c
            kotlin.g.b.k.a()
        L_0x091c:
            boolean r15 = b((java.lang.String) r15)
            java.lang.String r3 = "it"
            java.lang.String r5 = "GTMHelper.getInstance()\n…suranceAutopayVersion(it)"
            java.lang.String r8 = "lyt_application_status_success_fail_post_payment"
            java.lang.String r9 = "lyt_application_status_pending_post_payment"
            java.lang.String r10 = "tv_application_id_value"
            java.lang.String r11 = "tv_application_id_text"
            if (r15 == 0) goto L_0x0b72
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0937
            java.lang.String r15 = r15.m
            goto L_0x0938
        L_0x0937:
            r15 = r2
        L_0x0938:
            if (r15 != 0) goto L_0x093d
            kotlin.g.b.k.a()
        L_0x093d:
            int r12 = r15.hashCode()
            r13 = 53
            if (r12 == r13) goto L_0x0a03
            r13 = 1570(0x622, float:2.2E-42)
            if (r12 == r13) goto L_0x09f6
            r13 = 1603(0x643, float:2.246E-42)
            if (r12 == r13) goto L_0x094f
            goto L_0x0aac
        L_0x094f:
            java.lang.String r12 = "25"
            boolean r15 = r15.equals(r12)
            if (r15 == 0) goto L_0x0aac
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.divider_appl_status
            android.view.View r15 = r14.a((int) r15)
            java.lang.String r6 = "divider_appl_status"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_life_ins_premium_paid_date_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            org.json.JSONObject r6 = r14.f14008h
            if (r6 == 0) goto L_0x099a
            java.lang.String r6 = r6.optString(r7)
            goto L_0x099b
        L_0x099a:
            r6 = r2
        L_0x099b:
            a((android.widget.TextView) r15, (java.lang.String) r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_pending
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_payment_status_text_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.c((android.widget.TextView) r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_pending
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_payment_amount_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.e(r15)
            r14.a()
            android.content.Context r15 = r14.getContext()
            if (r15 == 0) goto L_0x09eb
            f.a.b$a r6 = f.a.b.f13524a
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r6 = net.one97.paytm.insurance.b.a.b((android.content.Context) r15)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            boolean r15 = f.a.b.a.a(r6, r15)
            if (r15 == 0) goto L_0x09eb
            int r15 = net.one97.paytm.insurance.R.id.automatic_payments_view
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x09eb
            r15.setVisibility(r0)
        L_0x09eb:
            r15 = 25
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r14.a((java.lang.Integer) r15)
            goto L_0x0b5c
        L_0x09f6:
            java.lang.String r7 = "13"
            boolean r15 = r15.equals(r7)
            if (r15 == 0) goto L_0x0aac
            r14.a((boolean) r1)
            goto L_0x0b5c
        L_0x0a03:
            java.lang.String r12 = "5"
            boolean r15 = r15.equals(r12)
            if (r15 == 0) goto L_0x0aac
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.divider_appl_status
            android.view.View r15 = r14.a((int) r15)
            java.lang.String r6 = "divider_appl_status"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_life_ins_premium_paid_date_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            org.json.JSONObject r6 = r14.f14008h
            if (r6 == 0) goto L_0x0a4e
            java.lang.String r6 = r6.optString(r7)
            goto L_0x0a4f
        L_0x0a4e:
            r6 = r2
        L_0x0a4f:
            a((android.widget.TextView) r15, (java.lang.String) r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_pending
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_payment_status_text_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.c((android.widget.TextView) r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_pending
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_payment_amount_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.e(r15)
            r14.a((boolean) r0)
            r14.a()
            android.content.Context r15 = r14.getContext()
            if (r15 == 0) goto L_0x0aa2
            f.a.b$a r6 = f.a.b.f13524a
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r6 = net.one97.paytm.insurance.b.a.b((android.content.Context) r15)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            boolean r15 = f.a.b.a.a(r6, r15)
            if (r15 == 0) goto L_0x0aa2
            int r15 = net.one97.paytm.insurance.R.id.automatic_payments_view
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x0aa2
            r15.setVisibility(r0)
        L_0x0aa2:
            r15 = 5
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r14.a((java.lang.Integer) r15)
            goto L_0x0b5c
        L_0x0aac:
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0ad9
            int r7 = net.one97.paytm.insurance.R.string.application_in_process
            java.lang.String r7 = r14.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
        L_0x0ad9:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0af3
            android.content.Context r7 = r14.f14005e
            if (r7 != 0) goto L_0x0aea
            kotlin.g.b.k.a()
        L_0x0aea:
            int r8 = net.one97.paytm.insurance.R.color.color_health_ins_ffa400
            int r7 = androidx.core.content.b.c(r7, r8)
            r15.setTextColor(r7)
        L_0x0af3:
            int r15 = net.one97.paytm.insurance.R.id.tv_last_updated_value_success_reject
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_last_updated_value_success_reject"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_payment_amount_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r14.e(r15)
            android.content.Context r15 = r14.getContext()
            if (r15 == 0) goto L_0x0b59
            f.a.b$a r6 = f.a.b.f13524a
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r6 = net.one97.paytm.insurance.b.a.b((android.content.Context) r15)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            boolean r15 = f.a.b.a.a(r6, r15)
            if (r15 == 0) goto L_0x0b59
            int r15 = net.one97.paytm.insurance.R.id.automatic_payments_view
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x0b59
            r15.setVisibility(r0)
        L_0x0b59:
            r14.a()
        L_0x0b5c:
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r3 = "tv_payment_status_text_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            int r3 = net.one97.paytm.insurance.R.string.payment_successful
            java.lang.String r3 = r14.getString(r3)
            goto L_0x10b3
        L_0x0b72:
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r9)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r15 = r14.a((int) r15)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r15.setVisibility(r0)
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0b91
            java.lang.String r15 = r15.n
            goto L_0x0b92
        L_0x0b91:
            r15 = r2
        L_0x0b92:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            r8 = 2
            if (r15 != 0) goto L_0x0c34
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r9 = 1098907648(0x41800000, float:16.0)
            r15.setTextSize(r8, r9)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            android.content.Context r9 = r14.getContext()
            if (r9 != 0) goto L_0x0bb9
            kotlin.g.b.k.a()
        L_0x0bb9:
            int r12 = net.one97.paytm.insurance.R.color.ins_color_666666
            int r9 = androidx.core.content.b.c(r9, r12)
            r15.setTextColor(r9)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r9 = 1098907648(0x41800000, float:16.0)
            r15.setTextSize(r8, r9)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            android.content.Context r8 = r14.getContext()
            if (r8 != 0) goto L_0x0be0
            kotlin.g.b.k.a()
        L_0x0be0:
            int r9 = net.one97.paytm.insurance.R.color.ins_color_666666
            int r8 = androidx.core.content.b.c(r8, r9)
            r15.setTextColor(r8)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            int r8 = net.one97.paytm.insurance.R.string.application_id
            java.lang.String r8 = r14.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r15.setText(r8)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0c16
            common.insuranceOrderSummary.d r8 = r14.f13436a
            if (r8 == 0) goto L_0x0c10
            java.lang.String r8 = r8.n
            goto L_0x0c11
        L_0x0c10:
            r8 = r2
        L_0x0c11:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r15.setText(r8)
        L_0x0c16:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r0)
            goto L_0x0cd2
        L_0x0c34:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r9 = 1094713344(0x41400000, float:12.0)
            r15.setTextSize(r8, r9)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            android.content.Context r9 = r14.getContext()
            if (r9 != 0) goto L_0x0c6e
            kotlin.g.b.k.a()
        L_0x0c6e:
            int r12 = net.one97.paytm.insurance.R.color.ins_color_999999
            int r9 = androidx.core.content.b.c(r9, r12)
            r15.setTextColor(r9)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r9 = 1094713344(0x41400000, float:12.0)
            r15.setTextSize(r8, r9)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            android.content.Context r8 = r14.getContext()
            if (r8 != 0) goto L_0x0c95
            kotlin.g.b.k.a()
        L_0x0c95:
            int r9 = net.one97.paytm.insurance.R.color.ins_color_999999
            int r8 = androidx.core.content.b.c(r8, r9)
            r15.setTextColor(r8)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            int r8 = net.one97.paytm.insurance.R.string.health_ins_order_id
            java.lang.String r8 = r14.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r15.setText(r8)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            android.os.Bundle r8 = r14.getArguments()
            if (r8 == 0) goto L_0x0ccc
            java.lang.String r9 = "order_id"
            java.lang.String r8 = r8.getString(r9)
            goto L_0x0ccd
        L_0x0ccc:
            r8 = r2
        L_0x0ccd:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r15.setText(r8)
        L_0x0cd2:
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r8 = "tv_payment_amount_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            r14.e(r15)
            int r15 = net.one97.paytm.insurance.R.id.tv_last_updated_value_success_reject
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            org.json.JSONObject r8 = r14.f14008h
            if (r8 == 0) goto L_0x0cf4
            java.lang.String r7 = r8.optString(r7)
            goto L_0x0cf5
        L_0x0cf4:
            r7 = r2
        L_0x0cf5:
            a((android.widget.TextView) r15, (java.lang.String) r7)
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0cff
            java.lang.String r15 = r15.m
            goto L_0x0d00
        L_0x0cff:
            r15 = r2
        L_0x0d00:
            if (r15 != 0) goto L_0x0d05
            kotlin.g.b.k.a()
        L_0x0d05:
            net.one97.paytm.InsuranceOrderSummary$a r7 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r7 = net.one97.paytm.InsuranceOrderSummary.O
            boolean r7 = r7.equals(r15)
            if (r7 != 0) goto L_0x0d2c
            net.one97.paytm.InsuranceOrderSummary$a r7 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r7 = net.one97.paytm.InsuranceOrderSummary.P
            boolean r7 = r7.equals(r15)
            if (r7 != 0) goto L_0x0d2c
            net.one97.paytm.InsuranceOrderSummary$a r7 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r7 = net.one97.paytm.InsuranceOrderSummary.Q
            boolean r15 = r7.equals(r15)
            if (r15 == 0) goto L_0x0d2a
            goto L_0x0d2c
        L_0x0d2a:
            r15 = 0
            goto L_0x0d2d
        L_0x0d2c:
            r15 = 1
        L_0x0d2d:
            if (r15 == 0) goto L_0x0f72
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0d36
            java.lang.String r15 = r15.m
            goto L_0x0d37
        L_0x0d36:
            r15 = r2
        L_0x0d37:
            if (r15 != 0) goto L_0x0d3c
            kotlin.g.b.k.a()
        L_0x0d3c:
            net.one97.paytm.InsuranceOrderSummary$a r7 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r7 = net.one97.paytm.InsuranceOrderSummary.O
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x0d78
            net.one97.paytm.InsuranceOrderSummary$a r7 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r7 = net.one97.paytm.InsuranceOrderSummary.P
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0d60
            int r15 = net.one97.paytm.insurance.R.string.application_cancelled
            java.lang.String r15 = r14.getString(r15)
            java.lang.String r7 = "getString(R.string.application_cancelled)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            goto L_0x0d83
        L_0x0d60:
            net.one97.paytm.InsuranceOrderSummary$a r7 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r7 = net.one97.paytm.InsuranceOrderSummary.Q
            boolean r15 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r7)
            if (r15 == 0) goto L_0x0d78
            int r15 = net.one97.paytm.insurance.R.string.application_cancelled
            java.lang.String r15 = r14.getString(r15)
            java.lang.String r7 = "getString(R.string.application_cancelled)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            goto L_0x0d83
        L_0x0d78:
            int r15 = net.one97.paytm.insurance.R.string.application_rejected
            java.lang.String r15 = r14.getString(r15)
            java.lang.String r7 = "getString(R.string.application_rejected)"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
        L_0x0d83:
            int r7 = net.one97.paytm.insurance.R.id.tv_next_premium
            android.view.View r7 = r14.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r8 = "tv_next_premium"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            r7.setVisibility(r6)
            int r7 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r7 = r14.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            int r8 = net.one97.paytm.insurance.R.string.application_id
            java.lang.String r8 = r14.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            int r7 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r7 = r14.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0db9
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r7.setText(r15)
        L_0x0db9:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0dd3
            android.content.Context r7 = r14.f14005e
            if (r7 != 0) goto L_0x0dca
            kotlin.g.b.k.a()
        L_0x0dca:
            int r8 = net.one97.paytm.insurance.R.color.color_health_ins_fd5c5c
            int r7 = androidx.core.content.b.c(r7, r8)
            r15.setTextColor(r7)
        L_0x0dd3:
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_payment_status_text_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            int r7 = net.one97.paytm.insurance.R.string.health_ins_refund_amount
            java.lang.String r7 = r14.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
            int r15 = net.one97.paytm.insurance.R.id.tvOrderIdText
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tvOrderIdText"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tvOrderIdValue
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tvOrderIdValue"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tvTimeDate
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tvTimeDate"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_refund_msg_desc
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_refund_msg_desc"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.lyt_refund_status
            android.view.View r15 = r14.a((int) r15)
            java.lang.String r7 = "lyt_refund_status"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_reject_reason
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_application_reject_reason"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r15.setVisibility(r0)
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0e61
            org.json.JSONObject r7 = r14.f14008h
            if (r7 == 0) goto L_0x0e5e
            java.lang.String r8 = "applicationNo"
            java.lang.String r7 = r7.optString(r8)
            goto L_0x0e5f
        L_0x0e5e:
            r7 = r2
        L_0x0e5f:
            r15.n = r7
        L_0x0e61:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0e68
            java.lang.String r15 = r15.n
            goto L_0x0e69
        L_0x0e68:
            r15 = r2
        L_0x0e69:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x0e8e
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r0)
            goto L_0x0eaa
        L_0x0e8e:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r6)
        L_0x0eaa:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            common.insuranceOrderSummary.d r7 = r14.f13436a
            if (r7 == 0) goto L_0x0ebc
            java.lang.String r7 = r7.n
            goto L_0x0ebd
        L_0x0ebc:
            r7 = r2
        L_0x0ebd:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
            int r15 = net.one97.paytm.insurance.R.id.tv_total_paid_amount_my_orders
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_total_paid_amount_my_orders"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            common.insuranceOrderSummary.d r7 = r14.f13436a
            if (r7 == 0) goto L_0x0ed7
            java.lang.String r7 = r7.j
            goto L_0x0ed8
        L_0x0ed7:
            r7 = r2
        L_0x0ed8:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
            int r15 = net.one97.paytm.insurance.R.id.tv_deducted_for_health_check_up_amount
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_deducted_for_health_check_up_amount"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            common.insuranceOrderSummary.d r7 = r14.f13436a
            if (r7 == 0) goto L_0x0ef2
            java.lang.String r7 = r7.r
            goto L_0x0ef3
        L_0x0ef2:
            r7 = r2
        L_0x0ef3:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_payment_amount_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            common.insuranceOrderSummary.d r7 = r14.f13436a
            if (r7 == 0) goto L_0x0f0d
            java.lang.String r7 = r7.q
            goto L_0x0f0e
        L_0x0f0d:
            r7 = r2
        L_0x0f0e:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
            int r15 = net.one97.paytm.insurance.R.id.automatic_payments_view
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x0f20
            r15.setVisibility(r6)
        L_0x0f20:
            android.text.SpannableStringBuilder r15 = new android.text.SpannableStringBuilder
            r15.<init>()
            int r7 = net.one97.paytm.insurance.R.string.failed_order_reason_title
            java.lang.String r7 = r14.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.append(r7)
            int r7 = net.one97.paytm.insurance.R.string.failed_order_reason_title
            java.lang.String r7 = r14.getString(r7)
            int r7 = r7.length()
            int r7 = r7 - r1
            net.one97.paytm.insurance.widgets.CustomTypefaceSpan r8 = new net.one97.paytm.insurance.widgets.CustomTypefaceSpan
            java.lang.String r9 = "sans-serif-medium"
            android.graphics.Typeface r9 = android.graphics.Typeface.create(r9, r0)
            java.lang.String r12 = ""
            r8.<init>(r12, r9)
            r9 = 18
            r15.setSpan(r8, r0, r7, r9)
            java.lang.String r7 = " "
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.append(r7)
            int r7 = net.one97.paytm.insurance.R.string.failed_order_reason_value
            java.lang.String r7 = r14.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.append(r7)
            int r7 = net.one97.paytm.insurance.R.id.tv_application_reject_reason
            android.view.View r7 = r14.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r8 = "tv_application_reject_reason"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r7.setText(r15)
        L_0x0f72:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0f79
            java.lang.String r15 = r15.m
            goto L_0x0f7a
        L_0x0f79:
            r15 = r2
        L_0x0f7a:
            if (r15 != 0) goto L_0x0f7f
            kotlin.g.b.k.a()
        L_0x0f7f:
            net.one97.paytm.InsuranceOrderSummary$a r7 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r7 = net.one97.paytm.InsuranceOrderSummary.N
            boolean r15 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r15, (boolean) r1)
            if (r15 == 0) goto L_0x10b8
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            int r7 = net.one97.paytm.insurance.R.string.policy_num_life
            java.lang.String r7 = r14.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0fb6
            int r7 = net.one97.paytm.insurance.R.string.application_approved
            java.lang.String r7 = r14.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r15.setText(r7)
        L_0x0fb6:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0fd0
            android.content.Context r7 = r14.f14005e
            if (r7 != 0) goto L_0x0fc7
            kotlin.g.b.k.a()
        L_0x0fc7:
            int r8 = net.one97.paytm.insurance.R.color.color_21c17a
            int r7 = androidx.core.content.b.c(r7, r8)
            r15.setTextColor(r7)
        L_0x0fd0:
            int r15 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_success_fail
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r7 = "tv_payment_status_text_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            r14.c((android.widget.TextView) r15)
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0ff3
            org.json.JSONObject r7 = r14.f14008h
            if (r7 == 0) goto L_0x0ff0
            java.lang.String r8 = "policyNo"
            java.lang.String r7 = r7.optString(r8)
            goto L_0x0ff1
        L_0x0ff0:
            r7 = r2
        L_0x0ff1:
            r15.n = r7
        L_0x0ff3:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x0ffa
            java.lang.String r15 = r15.n
            goto L_0x0ffb
        L_0x0ffa:
            r15 = r2
        L_0x0ffb:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x1020
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r0)
            goto L_0x103c
        L_0x1020:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r6)
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r11)
            r15.setVisibility(r6)
        L_0x103c:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x1043
            java.lang.String r15 = r15.t
            goto L_0x1044
        L_0x1043:
            r15 = r2
        L_0x1044:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x1078
            int r15 = net.one97.paytm.insurance.R.id.tv_next_premium
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_next_premium"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r15.setVisibility(r0)
            int r15 = net.one97.paytm.insurance.R.id.tv_next_premium
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r6 = "tv_next_premium"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            common.insuranceOrderSummary.d r6 = r14.f13436a
            if (r6 == 0) goto L_0x1072
            java.lang.String r6 = r6.t
            goto L_0x1073
        L_0x1072:
            r6 = r2
        L_0x1073:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r15.setText(r6)
        L_0x1078:
            android.content.Context r15 = r14.getContext()
            if (r15 == 0) goto L_0x10a0
            f.a.b$a r6 = f.a.b.f13524a
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r6 = net.one97.paytm.insurance.b.a.b((android.content.Context) r15)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            boolean r15 = f.a.b.a.a(r6, r15)
            if (r15 == 0) goto L_0x10a0
            int r15 = net.one97.paytm.insurance.R.id.automatic_payments_view
            android.view.View r15 = r14.a((int) r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x10a0
            r15.setVisibility(r0)
        L_0x10a0:
            int r15 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            common.insuranceOrderSummary.d r3 = r14.f13436a
            if (r3 == 0) goto L_0x10b2
            java.lang.String r3 = r3.n
            goto L_0x10b3
        L_0x10b2:
            r3 = r2
        L_0x10b3:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r15.setText(r3)
        L_0x10b8:
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x10c9
            java.lang.String r15 = r15.f13450f
            if (r15 == 0) goto L_0x10c9
            boolean r15 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r4, (boolean) r1)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            goto L_0x10ca
        L_0x10c9:
            r15 = r2
        L_0x10ca:
            if (r15 != 0) goto L_0x10cf
            kotlin.g.b.k.a()
        L_0x10cf:
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x10e3
            common.insuranceOrderSummary.d r15 = r14.f13436a
            if (r15 == 0) goto L_0x10db
            java.lang.String r2 = r15.m
        L_0x10db:
            if (r2 != 0) goto L_0x10e0
            kotlin.g.b.k.a()
        L_0x10e0:
            b((java.lang.String) r2)
        L_0x10e3:
            net.one97.paytm.insurance.b.b r15 = net.one97.paytm.insurance.b.b.INSTANCE
            int r1 = net.one97.paytm.insurance.R.id.progress_bar
            android.view.View r1 = r14.a((int) r1)
            com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
            r15.stopAnimation(r1)
            int r15 = net.one97.paytm.insurance.R.id.scroll_view_parent
            android.view.View r15 = r14.a((int) r15)
            android.widget.ScrollView r15 = (android.widget.ScrollView) r15
            java.lang.String r1 = "scroll_view_parent"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            r15.setVisibility(r0)
            return
        L_0x1101:
            kotlin.u r15 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<kotlin.String, kotlin.String>"
            r15.<init>(r0)
            throw r15
        L_0x1109:
            kotlin.u r15 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<kotlin.String, kotlin.Any?>"
            r15.<init>(r0)
            throw r15
        L_0x1111:
            kotlin.u r15 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummary"
            r15.<init>(r0)
            throw r15
        L_0x1119:
            kotlin.u r15 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummary"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.common.a.b.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14010a;

        a(b bVar) {
            this.f14010a = bVar;
        }

        public final void run() {
            b bVar = this.f14010a;
            bVar.a(bVar.f13437b);
        }
    }

    private final void a() {
        new Handler().postDelayed(new a(this), 10000);
    }

    private static boolean b(String str) {
        InsuranceOrderSummary.a aVar = InsuranceOrderSummary.f13533b;
        if (InsuranceOrderSummary.N.equals(str)) {
            return false;
        }
        InsuranceOrderSummary.a aVar2 = InsuranceOrderSummary.f13533b;
        if (InsuranceOrderSummary.O.equals(str)) {
            return false;
        }
        InsuranceOrderSummary.a aVar3 = InsuranceOrderSummary.f13533b;
        if (InsuranceOrderSummary.P.equals(str)) {
            return false;
        }
        InsuranceOrderSummary.a aVar4 = InsuranceOrderSummary.f13533b;
        return !InsuranceOrderSummary.Q.equals(str);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.f14005e = context;
        a((IJRPaytmDataModel) new CJROrderSummary());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f14006f = layoutInflater.inflate(R.layout.life_insurance_post_payment_1, viewGroup, false);
        return this.f14006f;
    }

    public final void onClick(View view) {
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btn_fill_now;
        if (valueOf != null && valueOf.intValue() == i2) {
            common.insuranceOrderSummary.d dVar = this.f13436a;
            if (dVar != null) {
                str = dVar.s;
            }
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                startActivity(intent);
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f14014a;

        e(b bVar) {
            this.f14014a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f14014a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r6 = r6.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(boolean r9) {
        /*
            r8 = this;
            java.lang.String r0 = "tv_life_ins_medical_questionnaire_filled_desc"
            java.lang.String r1 = "btn_fill_now"
            r2 = 8
            r3 = 0
            r4 = 0
            if (r9 == 0) goto L_0x0047
            int r5 = net.one97.paytm.insurance.R.id.tv_life_ins_medical_questionnaire_filled
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.content.Context r6 = r8.f14005e
            if (r6 == 0) goto L_0x0024
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L_0x0024
            int r7 = net.one97.paytm.insurance.R.string.life_ins_medical_questionnaire_filled_ok
            java.lang.String r6 = r6.getString(r7)
            goto L_0x0025
        L_0x0024:
            r6 = r3
        L_0x0025:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            int r5 = net.one97.paytm.insurance.R.id.btn_fill_now
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            r5.setVisibility(r2)
            int r1 = net.one97.paytm.insurance.R.id.tv_life_ins_medical_questionnaire_filled_desc
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            r1.setVisibility(r2)
            goto L_0x0082
        L_0x0047:
            int r5 = net.one97.paytm.insurance.R.id.tv_life_ins_medical_questionnaire_filled
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.content.Context r6 = r8.f14005e
            if (r6 == 0) goto L_0x0060
            android.content.res.Resources r6 = r6.getResources()
            if (r6 == 0) goto L_0x0060
            int r7 = net.one97.paytm.insurance.R.string.life_ins_medical_questionnaire_filled
            java.lang.String r6 = r6.getString(r7)
            goto L_0x0061
        L_0x0060:
            r6 = r3
        L_0x0061:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
            int r5 = net.one97.paytm.insurance.R.id.btn_fill_now
            android.view.View r5 = r8.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            r5.setVisibility(r4)
            int r1 = net.one97.paytm.insurance.R.id.tv_life_ins_medical_questionnaire_filled_desc
            android.view.View r1 = r8.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            r1.setVisibility(r4)
        L_0x0082:
            int r0 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r0 = r8.a((int) r0)
            java.lang.String r1 = "lyt_application_status_pending_post_payment"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r4)
            int r0 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r0 = r8.a((int) r0)
            java.lang.String r5 = "lyt_application_status_success_fail_post_payment"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.insurance.R.id.divider_appl_status
            android.view.View r0 = r8.a((int) r0)
            java.lang.String r2 = "divider_appl_status"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r4)
            int r0 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r0 = r8.a((int) r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r4)
            int r0 = net.one97.paytm.insurance.R.id.tv_life_ins_premium_paid_date_text
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            org.json.JSONObject r1 = r8.f14008h
            if (r1 == 0) goto L_0x00cb
            java.lang.String r2 = "updatedAt"
            java.lang.String r3 = r1.optString(r2)
        L_0x00cb:
            a((android.widget.TextView) r0, (java.lang.String) r3)
            int r0 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_pending
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_payment_status_text_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r8.c((android.widget.TextView) r0)
            int r0 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_pending
            android.view.View r0 = r8.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_payment_amount_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r8.e(r0)
            r8.a()
            android.content.Context r0 = r8.getContext()
            if (r0 == 0) goto L_0x011f
            f.a.b$a r1 = f.a.b.f13524a
            net.one97.paytm.insurance.b.a.a()
            java.lang.String r1 = net.one97.paytm.insurance.b.a.b((android.content.Context) r0)
            java.lang.String r2 = "GTMHelper.getInstance()\n…suranceAutopayVersion(it)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r2 = "it"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            boolean r0 = f.a.b.a.a(r1, r0)
            if (r0 == 0) goto L_0x011f
            int r0 = net.one97.paytm.insurance.R.id.automatic_payments_view
            android.view.View r0 = r8.a((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x011f
            r0.setVisibility(r4)
        L_0x011f:
            if (r9 == 0) goto L_0x012a
            r9 = 13
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.a((java.lang.Integer) r9)
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.common.a.b.a(boolean):void");
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r1 = r1.getResources();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.Integer r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            goto L_0x006f
        L_0x0004:
            int r1 = r4.intValue()
            r2 = 5
            if (r1 != r2) goto L_0x006f
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_2
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x0024
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0024
            int r2 = net.one97.paytm.insurance.R.drawable.health_ins_appl_status_pending
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x0025
        L_0x0024:
            r1 = r0
        L_0x0025:
            r4.setImageDrawable(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_3
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x0041
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0041
            int r2 = net.one97.paytm.insurance.R.drawable.health_ins_appl_status_pending
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x0042
        L_0x0041:
            r1 = r0
        L_0x0042:
            r4.setImageDrawable(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_4
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x005d
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x005d
            int r0 = net.one97.paytm.insurance.R.drawable.health_ins_appl_status_pending
            android.graphics.drawable.Drawable r0 = r1.getDrawable(r0)
        L_0x005d:
            r4.setImageDrawable(r0)
            int r4 = net.one97.paytm.insurance.R.id.btn_fill_now
            android.view.View r4 = r3.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = r3
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r4.setOnClickListener(r0)
            return
        L_0x006f:
            if (r4 != 0) goto L_0x0073
            goto L_0x00e7
        L_0x0073:
            int r1 = r4.intValue()
            r2 = 13
            if (r1 != r2) goto L_0x00e7
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_2
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x0094
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0094
            int r2 = net.one97.paytm.insurance.R.drawable.ins_success_nobel
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x0095
        L_0x0094:
            r1 = r0
        L_0x0095:
            r4.setImageDrawable(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_3
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x00b1
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x00b1
            int r2 = net.one97.paytm.insurance.R.drawable.health_ins_appl_status_pending
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x00b2
        L_0x00b1:
            r1 = r0
        L_0x00b2:
            r4.setImageDrawable(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_4
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x00cd
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x00cd
            int r0 = net.one97.paytm.insurance.R.drawable.health_ins_appl_status_pending
            android.graphics.drawable.Drawable r0 = r1.getDrawable(r0)
        L_0x00cd:
            r4.setImageDrawable(r0)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_divider_2
            android.view.View r4 = r3.a((int) r4)
            android.content.Context r0 = r3.f14005e
            if (r0 != 0) goto L_0x00dd
            kotlin.g.b.k.a()
        L_0x00dd:
            int r1 = net.one97.paytm.insurance.R.color.color_21c17a
            int r0 = androidx.core.content.b.c(r0, r1)
            r4.setBackgroundColor(r0)
            return
        L_0x00e7:
            if (r4 != 0) goto L_0x00ea
            return
        L_0x00ea:
            int r4 = r4.intValue()
            r1 = 25
            if (r4 != r1) goto L_0x01b5
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_2
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x010b
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x010b
            int r2 = net.one97.paytm.insurance.R.drawable.ins_success_nobel
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x010c
        L_0x010b:
            r1 = r0
        L_0x010c:
            r4.setImageDrawable(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_3
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x0128
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0128
            int r2 = net.one97.paytm.insurance.R.drawable.ins_success_nobel
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x0129
        L_0x0128:
            r1 = r0
        L_0x0129:
            r4.setImageDrawable(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_4
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x0145
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0145
            int r2 = net.one97.paytm.insurance.R.drawable.health_ins_appl_status_pending
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            goto L_0x0146
        L_0x0145:
            r1 = r0
        L_0x0146:
            r4.setImageDrawable(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_divider_2
            android.view.View r4 = r3.a((int) r4)
            android.content.Context r1 = r3.f14005e
            if (r1 != 0) goto L_0x0156
            kotlin.g.b.k.a()
        L_0x0156:
            int r2 = net.one97.paytm.insurance.R.color.color_21c17a
            int r1 = androidx.core.content.b.c(r1, r2)
            r4.setBackgroundColor(r1)
            int r4 = net.one97.paytm.insurance.R.id.iv_appl_status_divider_3
            android.view.View r4 = r3.a((int) r4)
            android.content.Context r1 = r3.f14005e
            if (r1 != 0) goto L_0x016c
            kotlin.g.b.k.a()
        L_0x016c:
            int r2 = net.one97.paytm.insurance.R.color.color_21c17a
            int r1 = androidx.core.content.b.c(r1, r2)
            r4.setBackgroundColor(r1)
            int r4 = net.one97.paytm.insurance.R.id.tv_life_ins_medical_questionnaire_filled
            android.view.View r4 = r3.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            android.content.Context r1 = r3.f14005e
            if (r1 == 0) goto L_0x018d
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x018d
            int r0 = net.one97.paytm.insurance.R.string.life_ins_medical_questionnaire_filled_ok
            java.lang.String r0 = r1.getString(r0)
        L_0x018d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            int r4 = net.one97.paytm.insurance.R.id.btn_fill_now
            android.view.View r4 = r3.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r0 = "btn_fill_now"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            r0 = 8
            r4.setVisibility(r0)
            int r4 = net.one97.paytm.insurance.R.id.tv_life_ins_medical_questionnaire_filled_desc
            android.view.View r4 = r3.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r1 = "tv_life_ins_medical_questionnaire_filled_desc"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            r4.setVisibility(r0)
        L_0x01b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.common.a.b.a(java.lang.Integer):void");
    }

    private static void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView != null) {
                b.a aVar = f.a.b.f13524a;
                if (str == null) {
                    k.a();
                }
                textView.setText(b.a.a(str, "dd MM yyyy, hh:mm", "dd MMM yyyy, hh:mm aa"));
            }
        }
    }

    public final void onResume() {
        super.onResume();
        a();
    }
}
