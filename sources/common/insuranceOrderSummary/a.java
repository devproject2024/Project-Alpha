package common.insuranceOrderSummary;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRatingBar;
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
import net.one97.paytm.common.widgets.R;
import net.one97.paytm.insurance.common.a.a;
import org.json.JSONObject;

public final class a extends c implements DialogInterface.OnClickListener, net.one97.paytm.common.widgets.a.a {

    /* renamed from: d  reason: collision with root package name */
    private List<String> f13422d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private Context f13423e;

    /* renamed from: f  reason: collision with root package name */
    private View f13424f;

    /* renamed from: g  reason: collision with root package name */
    private CJROrderSummary f13425g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f13426h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJROrderSummary f13427i;
    private g<String, String> j;
    /* access modifiers changed from: private */
    public net.one97.paytm.common.widgets.c k;
    /* access modifiers changed from: private */
    public net.one97.paytm.insurance.common.a.a l;
    private HashMap m;

    public final View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
        HashMap hashMap = this.m;
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

    public final void a(float f2) {
        net.one97.paytm.common.widgets.c cVar;
        View view;
        AppCompatRatingBar appCompatRatingBar;
        View view2;
        ImageView imageView;
        View view3;
        TextView textView;
        View view4;
        TextView textView2;
        com.paytm.utility.b.x(this.f13423e, "is_app_rated");
        net.one97.paytm.insurance.b.c.a().sendNewCustomGTMEvents(this.f13423e, "app_rating", String.valueOf(Math.round(f2)), "Insurance", (String) null, (String) null, (String) null, "app_rating");
        if (f2 < 5.0f) {
            com.paytm.utility.b.a(this.f13423e, "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(this.f13423e, "app_rating_5_star_timestamp", 0);
            net.one97.paytm.common.widgets.c cVar2 = this.k;
            if (!(cVar2 == null || (view4 = cVar2.getView()) == null || (textView2 = (TextView) view4.findViewById(R.id.tv_msg)) == null)) {
                textView2.setText(getString(R.string.feedback_thanks_msg));
            }
            net.one97.paytm.common.widgets.c cVar3 = this.k;
            if (!(cVar3 == null || (view3 = cVar3.getView()) == null || (textView = (TextView) view3.findViewById(R.id.tv_sub_msg)) == null)) {
                textView.setVisibility(8);
            }
            net.one97.paytm.common.widgets.c cVar4 = this.k;
            if (!(cVar4 == null || (view2 = cVar4.getView()) == null || (imageView = (ImageView) view2.findViewById(R.id.iv_close_icon)) == null)) {
                imageView.setVisibility(8);
            }
            net.one97.paytm.common.widgets.c cVar5 = this.k;
            if (!(cVar5 == null || (view = cVar5.getView()) == null || (appCompatRatingBar = (AppCompatRatingBar) view.findViewById(R.id.ratingBar)) == null)) {
                appCompatRatingBar.setRating(f2);
            }
            k.a((Object) net.one97.paytm.insurance.b.a.a(), "GTMHelper.getInstance()");
            new Handler().postDelayed(new e(this), net.one97.paytm.insurance.b.a.c());
        } else {
            com.paytm.utility.b.a(this.f13423e, "app_rating_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(this.f13423e, "app_rating_less_than_5_star_timestamp", 0);
            if (isAdded() && isVisible() && (cVar = this.k) != null) {
                cVar.dismiss();
            }
            com.paytm.utility.b.ai(this.f13423e);
        }
        com.paytm.utility.b.a(this.f13423e, "app_rating_not_now_timestamp", 0);
    }

    public final void a() {
        net.one97.paytm.common.widgets.c cVar;
        com.paytm.utility.b.a(this.f13423e, "app_rating_not_now_timestamp", System.currentTimeMillis());
        com.paytm.utility.b.a(this.f13423e, "app_rating_5_star_timestamp", 0);
        com.paytm.utility.b.a(this.f13423e, "app_rating_less_than_5_star_timestamp", 0);
        net.one97.paytm.insurance.b.c.a().sendNewCustomGTMEvents(this.f13423e, "app_rating", "cross_button_clicked", "Insurance", (String) null, (String) null, (String) null, "app_rating");
        net.one97.paytm.common.widgets.c cVar2 = this.k;
        Boolean bool = null;
        Boolean valueOf = cVar2 != null ? Boolean.valueOf(cVar2.isAdded()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            net.one97.paytm.common.widgets.c cVar3 = this.k;
            if (cVar3 != null) {
                bool = Boolean.valueOf(cVar3.isVisible());
            }
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue() && (cVar = this.k) != null) {
                cVar.dismiss();
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f13432a;

        e(a aVar) {
            this.f13432a = aVar;
        }

        public final void run() {
            net.one97.paytm.common.widgets.c a2 = this.f13432a.k;
            if (a2 != null) {
                a2.dismiss();
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.insurance.b.b.INSTANCE.setAnimation((LottieAnimationView) a(net.one97.paytm.insurance.R.id.progress_bar));
        ((RelativeLayout) a(net.one97.paytm.insurance.R.id.contact_us_view)).setOnClickListener(new b(this));
        ((TextView) a(net.one97.paytm.insurance.R.id.tv_download_policy_wording)).setOnClickListener(new c(this));
        a(this.f13437b);
        Bundle arguments = getArguments();
        Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean("IS_MY_ORDER_SCREEN", false)) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            ImageView imageView = (ImageView) a(net.one97.paytm.insurance.R.id.ivBackBtn);
            k.a((Object) imageView, "ivBackBtn");
            imageView.setVisibility(0);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f13429a;

        b(a aVar) {
            this.f13429a = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.insurance.common.a.a aVar;
            a aVar2 = this.f13429a;
            CJROrderSummary c2 = aVar2.f13427i;
            if (c2 != null) {
                a.C0191a aVar3 = net.one97.paytm.insurance.common.a.a.f13991c;
                aVar = a.C0191a.a(c2);
            } else {
                aVar = null;
            }
            aVar2.l = aVar;
            net.one97.paytm.insurance.common.a.a b2 = this.f13429a.l;
            if (b2 != null) {
                b2.a((Context) this.f13429a.getActivity(), this.f13429a.getChildFragmentManager());
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f13430a;

        c(a aVar) {
            this.f13430a = aVar;
        }

        public final void onClick(View view) {
            this.f13430a.c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r14 = (r14 = r14.getOrderedCartList()).get(0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x05a2  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x067b  */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x069b  */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x06a0  */
    /* JADX WARNING: Removed duplicated region for block: B:460:0x06aa  */
    /* JADX WARNING: Removed duplicated region for block: B:466:0x06d4  */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x06d9  */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x06e8  */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x071a  */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x073e  */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x0747  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x074a  */
    /* JADX WARNING: Removed duplicated region for block: B:486:0x0753  */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x07cf  */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x07d8  */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x07db  */
    /* JADX WARNING: Removed duplicated region for block: B:509:0x07e4  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x07f7  */
    /* JADX WARNING: Removed duplicated region for block: B:632:0x0c2b  */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x0c89  */
    /* JADX WARNING: Removed duplicated region for block: B:652:0x0c98  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x0d36  */
    /* JADX WARNING: Removed duplicated region for block: B:659:0x0d39  */
    /* JADX WARNING: Removed duplicated region for block: B:662:0x0d51  */
    /* JADX WARNING: Removed duplicated region for block: B:663:0x0d54  */
    /* JADX WARNING: Removed duplicated region for block: B:666:0x0d6c  */
    /* JADX WARNING: Removed duplicated region for block: B:667:0x0d6f  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x0dcb  */
    /* JADX WARNING: Removed duplicated region for block: B:672:0x0dce  */
    /* JADX WARNING: Removed duplicated region for block: B:674:0x0dd1  */
    /* JADX WARNING: Removed duplicated region for block: B:677:0x0de0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r14) {
        /*
            r13 = this;
            super.onApiSuccess(r14)
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isFinishing()
            if (r0 == r1) goto L_0x0016
        L_0x0010:
            boolean r0 = r13.isAdded()
            if (r0 != 0) goto L_0x0017
        L_0x0016:
            return
        L_0x0017:
            if (r14 == 0) goto L_0x0ee7
            r0 = r14
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r0
            r13.f13427i = r0
            if (r14 == 0) goto L_0x0edf
            r13.f13425g = r0
            common.insuranceOrderSummary.d r14 = new common.insuranceOrderSummary.d
            java.lang.String r0 = "14"
            r14.<init>(r0)
            r13.f13436a = r14
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            r0 = 0
            r2 = 0
            if (r14 == 0) goto L_0x0044
            java.util.ArrayList r14 = r14.getOrderedCartList()
            if (r14 == 0) goto L_0x0044
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r14
            if (r14 == 0) goto L_0x0044
            java.lang.String r14 = r14.getItemStatus()
            goto L_0x0045
        L_0x0044:
            r14 = r2
        L_0x0045:
            java.lang.String r3 = "1"
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r3, (boolean) r1)
            java.lang.String r3 = "info"
            if (r14 != 0) goto L_0x01b5
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x0066
            java.util.ArrayList r14 = r14.getOrderedCartList()
            if (r14 == 0) goto L_0x0066
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r14
            if (r14 == 0) goto L_0x0066
            java.lang.String r14 = r14.getItemStatus()
            goto L_0x0067
        L_0x0066:
            r14 = r2
        L_0x0067:
            java.lang.String r4 = "2"
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r4, (boolean) r1)
            if (r14 != 0) goto L_0x01b5
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x0086
            java.util.ArrayList r14 = r14.getOrderedCartList()
            if (r14 == 0) goto L_0x0086
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r14
            if (r14 == 0) goto L_0x0086
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r14 = r14.getProductDetail()
            goto L_0x0087
        L_0x0086:
            r14 = r2
        L_0x0087:
            common.insuranceOrderSummary.d r4 = r13.f13436a
            if (r4 == 0) goto L_0x0095
            if (r14 == 0) goto L_0x0092
            java.lang.String r14 = r14.getName()
            goto L_0x0093
        L_0x0092:
            r14 = r2
        L_0x0093:
            r4.f13445a = r14
        L_0x0095:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x00b2
            java.util.ArrayList r14 = r14.getOrderedCartList()
            if (r14 == 0) goto L_0x00b2
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r14
            if (r14 == 0) goto L_0x00b2
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r14 = r14.getFullFillmentOject()
            if (r14 == 0) goto L_0x00b2
            java.lang.String r14 = r14.getFulfillmentResponse()
            goto L_0x00b3
        L_0x00b2:
            r14 = r2
        L_0x00b3:
            if (r14 == 0) goto L_0x00da
            org.json.JSONObject r14 = new org.json.JSONObject
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r13.f13425g
            if (r4 == 0) goto L_0x00d4
            java.util.ArrayList r4 = r4.getOrderedCartList()
            if (r4 == 0) goto L_0x00d4
            java.lang.Object r4 = r4.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x00d4
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()
            if (r4 == 0) goto L_0x00d4
            java.lang.String r4 = r4.getFulfillmentResponse()
            goto L_0x00d5
        L_0x00d4:
            r4 = r2
        L_0x00d5:
            r14.<init>(r4)
            r13.f13426h = r14
        L_0x00da:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x00f3
            org.json.JSONObject r4 = r13.f13426h
            if (r4 == 0) goto L_0x00f0
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x00f0
            java.lang.String r5 = "sub_title"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x00f1
        L_0x00f0:
            r4 = r2
        L_0x00f1:
            r14.f13446b = r4
        L_0x00f3:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x010b
            org.json.JSONObject r4 = r13.f13426h
            if (r4 == 0) goto L_0x0108
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x0108
            java.lang.String r5 = "image_url"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x0109
        L_0x0108:
            r4 = r2
        L_0x0109:
            r14.f13447c = r4
        L_0x010b:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0124
            org.json.JSONObject r4 = r13.f13426h
            if (r4 == 0) goto L_0x0121
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x0121
            java.lang.String r5 = "wording_url"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x0122
        L_0x0121:
            r4 = r2
        L_0x0122:
            r14.f13448d = r4
        L_0x0124:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x013d
            org.json.JSONObject r4 = r13.f13426h
            if (r4 == 0) goto L_0x013a
            org.json.JSONObject r4 = r4.optJSONObject(r3)
            if (r4 == 0) goto L_0x013a
            java.lang.String r5 = "underwriting_text"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x013b
        L_0x013a:
            r4 = r2
        L_0x013b:
            r14.p = r4
        L_0x013d:
            org.json.JSONObject r14 = r13.f13426h
            if (r14 == 0) goto L_0x0148
            java.lang.String r4 = "cancellation_charges"
            java.lang.String r14 = r14.optString(r4)
            goto L_0x0149
        L_0x0148:
            r14 = r2
        L_0x0149:
            if (r14 == 0) goto L_0x0168
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0168
            f.a.b$a r4 = f.a.b.f13524a
            org.json.JSONObject r4 = r13.f13426h
            if (r4 == 0) goto L_0x015c
            java.lang.String r5 = "cancellation_charges"
            java.lang.String r4 = r4.optString(r5)
            goto L_0x015d
        L_0x015c:
            r4 = r2
        L_0x015d:
            if (r4 != 0) goto L_0x0162
            kotlin.g.b.k.a()
        L_0x0162:
            java.lang.String r4 = f.a.b.a.a((java.lang.String) r4)
            r14.r = r4
        L_0x0168:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x017b
            java.util.ArrayList r14 = r14.getPaymentInfo()
            if (r14 == 0) goto L_0x017b
            int r14 = r14.size()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x017c
        L_0x017b:
            r14 = r2
        L_0x017c:
            if (r14 != 0) goto L_0x0181
            kotlin.g.b.k.a()
        L_0x0181:
            int r14 = r14.intValue()
            if (r14 <= r1) goto L_0x028c
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x028c
            f.a.b$a r4 = f.a.b.f13524a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r13.f13425g
            if (r4 == 0) goto L_0x01a8
            java.util.ArrayList r4 = r4.getPaymentInfo()
            if (r4 == 0) goto L_0x01a8
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r4 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r4
            if (r4 == 0) goto L_0x01a8
            double r4 = r4.getPgAmount()
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            goto L_0x01a9
        L_0x01a8:
            r4 = r2
        L_0x01a9:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = f.a.b.a.a((java.lang.String) r4)
            r14.q = r4
            goto L_0x028c
        L_0x01b5:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x01cc
            java.util.ArrayList r14 = r14.getOrderedCartList()
            if (r14 == 0) goto L_0x01cc
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r14
            if (r14 == 0) goto L_0x01cc
            java.lang.Object r14 = r14.getMetaDataResponse()
            goto L_0x01cd
        L_0x01cc:
            r14 = r2
        L_0x01cd:
            if (r14 == 0) goto L_0x0ed7
            com.google.gsonhtcfix.b.g r14 = (com.google.gsonhtcfix.b.g) r14
            if (r14 == 0) goto L_0x01d8
            java.lang.Object r14 = r14.get(r3)
            goto L_0x01d9
        L_0x01d8:
            r14 = r2
        L_0x01d9:
            if (r14 == 0) goto L_0x0ecf
            com.google.gsonhtcfix.b.g r14 = (com.google.gsonhtcfix.b.g) r14
            r13.j = r14
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x01f4
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r13.j
            if (r4 == 0) goto L_0x01f1
            java.lang.String r5 = "title"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01f2
        L_0x01f1:
            r4 = r2
        L_0x01f2:
            r14.f13445a = r4
        L_0x01f4:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x0211
            java.util.ArrayList r14 = r14.getOrderedCartList()
            if (r14 == 0) goto L_0x0211
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r14
            if (r14 == 0) goto L_0x0211
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r14 = r14.getFullFillmentOject()
            if (r14 == 0) goto L_0x0211
            java.lang.String r14 = r14.getFulfillmentResponse()
            goto L_0x0212
        L_0x0211:
            r14 = r2
        L_0x0212:
            if (r14 == 0) goto L_0x0239
            org.json.JSONObject r14 = new org.json.JSONObject
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r13.f13425g
            if (r4 == 0) goto L_0x0233
            java.util.ArrayList r4 = r4.getOrderedCartList()
            if (r4 == 0) goto L_0x0233
            java.lang.Object r4 = r4.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            if (r4 == 0) goto L_0x0233
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r4 = r4.getFullFillmentOject()
            if (r4 == 0) goto L_0x0233
            java.lang.String r4 = r4.getFulfillmentResponse()
            goto L_0x0234
        L_0x0233:
            r4 = r2
        L_0x0234:
            r14.<init>(r4)
            r13.f13426h = r14
        L_0x0239:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x024e
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r13.j
            if (r4 == 0) goto L_0x024b
            java.lang.String r5 = "sub_title"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x024c
        L_0x024b:
            r4 = r2
        L_0x024c:
            r14.f13446b = r4
        L_0x024e:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0262
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r13.j
            if (r4 == 0) goto L_0x025f
            java.lang.String r5 = "image_url"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0260
        L_0x025f:
            r4 = r2
        L_0x0260:
            r14.f13447c = r4
        L_0x0262:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0277
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r13.j
            if (r4 == 0) goto L_0x0274
            java.lang.String r5 = "wording_url"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0275
        L_0x0274:
            r4 = r2
        L_0x0275:
            r14.f13448d = r4
        L_0x0277:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x028c
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r4 = r13.j
            if (r4 == 0) goto L_0x0289
            java.lang.String r5 = "underwriting_text"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x028a
        L_0x0289:
            r4 = r2
        L_0x028a:
            r14.p = r4
        L_0x028c:
            java.util.List<java.lang.String> r14 = r13.f13422d
            if (r14 == 0) goto L_0x02a4
            android.content.Context r4 = r13.f13423e
            if (r4 == 0) goto L_0x029b
            int r5 = net.one97.paytm.insurance.R.string.health_ins_premium_paid
            java.lang.String r4 = r4.getString(r5)
            goto L_0x029c
        L_0x029b:
            r4 = r2
        L_0x029c:
            if (r4 != 0) goto L_0x02a1
            kotlin.g.b.k.a()
        L_0x02a1:
            r14.add(r4)
        L_0x02a4:
            java.util.List<java.lang.String> r14 = r13.f13422d
            if (r14 == 0) goto L_0x02bc
            android.content.Context r4 = r13.f13423e
            if (r4 == 0) goto L_0x02b3
            int r5 = net.one97.paytm.insurance.R.string.health_ins_medical_questionnaire_filled
            java.lang.String r4 = r4.getString(r5)
            goto L_0x02b4
        L_0x02b3:
            r4 = r2
        L_0x02b4:
            if (r4 != 0) goto L_0x02b9
            kotlin.g.b.k.a()
        L_0x02b9:
            r14.add(r4)
        L_0x02bc:
            java.util.List<java.lang.String> r14 = r13.f13422d
            if (r14 == 0) goto L_0x02d4
            android.content.Context r4 = r13.f13423e
            if (r4 == 0) goto L_0x02cb
            int r5 = net.one97.paytm.insurance.R.string.health_ins_medical_assessment
            java.lang.String r4 = r4.getString(r5)
            goto L_0x02cc
        L_0x02cb:
            r4 = r2
        L_0x02cc:
            if (r4 != 0) goto L_0x02d1
            kotlin.g.b.k.a()
        L_0x02d1:
            r14.add(r4)
        L_0x02d4:
            java.util.List<java.lang.String> r14 = r13.f13422d
            if (r14 == 0) goto L_0x02ec
            android.content.Context r4 = r13.f13423e
            if (r4 == 0) goto L_0x02e3
            int r5 = net.one97.paytm.insurance.R.string.health_ins_application_submission
            java.lang.String r4 = r4.getString(r5)
            goto L_0x02e4
        L_0x02e3:
            r4 = r2
        L_0x02e4:
            if (r4 != 0) goto L_0x02e9
            kotlin.g.b.k.a()
        L_0x02e9:
            r14.add(r4)
        L_0x02ec:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x02f4
            java.util.List<java.lang.String> r4 = r13.f13422d
            r14.f13449e = r4
        L_0x02f4:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x02fd
            java.lang.String r14 = r14.getPaymentStatus()
            goto L_0x02fe
        L_0x02fd:
            r14 = r2
        L_0x02fe:
            common.insuranceOrderSummary.d r4 = r13.f13436a
            if (r4 == 0) goto L_0x0304
            r4.f13450f = r14
        L_0x0304:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x030b
            java.lang.String r14 = r14.f13450f
            goto L_0x030c
        L_0x030b:
            r14 = r2
        L_0x030c:
            java.lang.String r4 = "FAILED"
            java.lang.String r5 = "PROCESSING"
            java.lang.String r6 = "SUCCESS"
            if (r14 != 0) goto L_0x0315
            goto L_0x0379
        L_0x0315:
            int r7 = r14.hashCode()
            r8 = -1149187101(0xffffffffbb80cbe3, float:-0.003930555)
            if (r7 == r8) goto L_0x0367
            r8 = 907287315(0x36141b13, float:2.2069478E-6)
            if (r7 == r8) goto L_0x0348
            r8 = 2066319421(0x7b29883d, float:8.802614E35)
            if (r7 == r8) goto L_0x0329
            goto L_0x0379
        L_0x0329:
            boolean r14 = r14.equals(r4)
            if (r14 == 0) goto L_0x0379
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x033b
            int r7 = net.one97.paytm.insurance.R.string.payment_failed
            java.lang.String r7 = r13.getString(r7)
            r14.f13451g = r7
        L_0x033b:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0379
            int r7 = net.one97.paytm.insurance.R.string.health_ins_payment_failed_desc
            java.lang.String r7 = r13.getString(r7)
            r14.o = r7
            goto L_0x0379
        L_0x0348:
            boolean r14 = r14.equals(r5)
            if (r14 == 0) goto L_0x0379
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x035a
            int r7 = net.one97.paytm.insurance.R.string.payment_pending
            java.lang.String r7 = r13.getString(r7)
            r14.f13451g = r7
        L_0x035a:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0379
            int r7 = net.one97.paytm.insurance.R.string.health_ins_payment_pending_desc
            java.lang.String r7 = r13.getString(r7)
            r14.o = r7
            goto L_0x0379
        L_0x0367:
            boolean r14 = r14.equals(r6)
            if (r14 == 0) goto L_0x0379
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0379
            int r7 = net.one97.paytm.insurance.R.string.payment_successful
            java.lang.String r7 = r13.getString(r7)
            r14.f13451g = r7
        L_0x0379:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0380
            java.lang.String r14 = r14.f13450f
            goto L_0x0381
        L_0x0380:
            r14 = r2
        L_0x0381:
            if (r14 != 0) goto L_0x0384
            goto L_0x03e6
        L_0x0384:
            int r7 = r14.hashCode()
            r8 = -1149187101(0xffffffffbb80cbe3, float:-0.003930555)
            if (r7 == r8) goto L_0x03cc
            r8 = 907287315(0x36141b13, float:2.2069478E-6)
            if (r7 == r8) goto L_0x03b2
            r8 = 2066319421(0x7b29883d, float:8.802614E35)
            if (r7 == r8) goto L_0x0398
            goto L_0x03e6
        L_0x0398:
            boolean r14 = r14.equals(r4)
            if (r14 == 0) goto L_0x03e6
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x03f2
            android.content.Context r7 = r13.f13423e
            if (r7 != 0) goto L_0x03a9
            kotlin.g.b.k.a()
        L_0x03a9:
            int r8 = net.one97.paytm.insurance.R.drawable.ins_ic_failed
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r7, (int) r8)
            r14.f13452h = r7
            goto L_0x03f2
        L_0x03b2:
            boolean r14 = r14.equals(r5)
            if (r14 == 0) goto L_0x03e6
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x03f2
            android.content.Context r7 = r13.f13423e
            if (r7 != 0) goto L_0x03c3
            kotlin.g.b.k.a()
        L_0x03c3:
            int r8 = net.one97.paytm.insurance.R.drawable.ins_ic_pending_copy
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r7, (int) r8)
            r14.f13452h = r7
            goto L_0x03f2
        L_0x03cc:
            boolean r14 = r14.equals(r6)
            if (r14 == 0) goto L_0x03e6
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x03f2
            android.content.Context r7 = r13.f13423e
            if (r7 != 0) goto L_0x03dd
            kotlin.g.b.k.a()
        L_0x03dd:
            int r8 = net.one97.paytm.insurance.R.drawable.ins_ic_success
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r7, (int) r8)
            r14.f13452h = r7
            goto L_0x03f2
        L_0x03e6:
            android.content.Context r14 = r13.f13423e
            if (r14 != 0) goto L_0x03ed
            kotlin.g.b.k.a()
        L_0x03ed:
            int r7 = net.one97.paytm.insurance.R.drawable.ins_ic_pending_copy
            androidx.core.content.b.a((android.content.Context) r14, (int) r7)
        L_0x03f2:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x0409
            java.util.ArrayList r14 = r14.getOrderedCartList()
            if (r14 == 0) goto L_0x0409
            java.lang.Object r14 = r14.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r14
            if (r14 == 0) goto L_0x0409
            java.lang.String r14 = r14.getAggregateItemPrice()
            goto L_0x040a
        L_0x0409:
            r14 = r2
        L_0x040a:
            common.insuranceOrderSummary.d r7 = r13.f13436a
            if (r7 == 0) goto L_0x041a
            f.a.b$a r8 = f.a.b.f13524a
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r14 = f.a.b.a.a((java.lang.String) r14)
            r7.j = r14
        L_0x041a:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x042e
            android.os.Bundle r7 = r13.getArguments()
            if (r7 == 0) goto L_0x042b
            java.lang.String r8 = "order_id"
            java.lang.String r7 = r7.getString(r8)
            goto L_0x042c
        L_0x042b:
            r7 = r2
        L_0x042c:
            r14.k = r7
        L_0x042e:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            java.lang.String r7 = "description"
            if (r14 == 0) goto L_0x0580
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = ""
            r8.<init>(r9)
            org.json.JSONObject r9 = r13.f13426h
            if (r9 == 0) goto L_0x0446
            java.lang.String r10 = "insuredFirstName"
            java.lang.String r9 = r9.optString(r10)
            goto L_0x0447
        L_0x0446:
            r9 = r2
        L_0x0447:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0483
            java.lang.String r9 = "For "
            r8.append(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            org.json.JSONObject r10 = r13.f13426h
            if (r10 == 0) goto L_0x0464
            java.lang.String r11 = "insuredFirstName"
            java.lang.String r10 = r10.optString(r11)
            goto L_0x0465
        L_0x0464:
            r10 = r2
        L_0x0465:
            r9.append(r10)
            java.lang.String r10 = " "
            r9.append(r10)
            org.json.JSONObject r10 = r13.f13426h
            if (r10 == 0) goto L_0x0478
            java.lang.String r11 = "insuredLastName"
            java.lang.String r10 = r10.optString(r11)
            goto L_0x0479
        L_0x0478:
            r10 = r2
        L_0x0479:
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.append(r9)
        L_0x0483:
            org.json.JSONObject r9 = r13.f13426h
            if (r9 == 0) goto L_0x0492
            org.json.JSONObject r9 = r9.optJSONObject(r3)
            if (r9 == 0) goto L_0x0492
            java.lang.String r9 = r9.optString(r7)
            goto L_0x0493
        L_0x0492:
            r9 = r2
        L_0x0493:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x052a
            org.json.JSONObject r9 = r13.f13426h
            if (r9 == 0) goto L_0x04b4
            org.json.JSONObject r9 = r9.optJSONObject(r3)
            if (r9 == 0) goto L_0x04b4
            java.lang.String r9 = r9.optString(r7)
            if (r9 == 0) goto L_0x04b4
            char r9 = r9.charAt(r0)
            java.lang.Character r9 = java.lang.Character.valueOf(r9)
            goto L_0x04b5
        L_0x04b4:
            r9 = r2
        L_0x04b5:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.Integer.parseInt(r9)
            org.json.JSONObject r9 = r13.f13426h
            if (r9 == 0) goto L_0x04e1
            org.json.JSONObject r9 = r9.optJSONObject(r3)
            if (r9 == 0) goto L_0x04e1
            java.lang.String r9 = r9.optString(r7)
            if (r9 == 0) goto L_0x04e1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = "."
            java.lang.String[] r10 = new java.lang.String[]{r10}
            java.util.List r9 = kotlin.m.p.b((java.lang.CharSequence) r9, (java.lang.String[]) r10)
            if (r9 == 0) goto L_0x04e1
            java.lang.Object r9 = r9.get(r0)
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x04e2
        L_0x04e1:
            r9 = r2
        L_0x04e2:
            if (r9 == 0) goto L_0x0522
            if (r9 == 0) goto L_0x04fb
            if (r9 == 0) goto L_0x04f3
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.CharSequence r9 = kotlin.m.p.b(r9)
            java.lang.String r9 = r9.toString()
            goto L_0x04fc
        L_0x04f3:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r14.<init>(r0)
            throw r14
        L_0x04fb:
            r9 = r2
        L_0x04fc:
            char r9 = r9.charAt(r0)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r9 = java.lang.Integer.parseInt(r9)
            if (r9 == r1) goto L_0x052a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = " + "
            r10.<init>(r11)
            int r9 = r9 - r1
            r10.append(r9)
            java.lang.String r9 = " members"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.append(r9)
            goto L_0x052a
        L_0x0522:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            r14.<init>(r0)
            throw r14
        L_0x052a:
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x057a
            com.google.gsonhtcfix.b.g<java.lang.String, java.lang.String> r9 = r13.j
            if (r9 == 0) goto L_0x053e
            java.lang.Object r9 = r9.get(r7)
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x053f
        L_0x053e:
            r9 = r2
        L_0x053f:
            if (r9 == 0) goto L_0x054e
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = "."
            java.lang.String[] r10 = new java.lang.String[]{r10}
            java.util.List r9 = kotlin.m.p.b((java.lang.CharSequence) r9, (java.lang.String[]) r10)
            goto L_0x054f
        L_0x054e:
            r9 = r2
        L_0x054f:
            if (r9 == 0) goto L_0x057a
            if (r9 == 0) goto L_0x055c
            int r10 = r9.size()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x055d
        L_0x055c:
            r10 = r2
        L_0x055d:
            if (r10 != 0) goto L_0x0562
            kotlin.g.b.k.a()
        L_0x0562:
            int r10 = r10.intValue()
            if (r10 <= r1) goto L_0x057a
            java.lang.String r10 = "For "
            r8.append(r10)
            if (r9 == 0) goto L_0x0576
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0577
        L_0x0576:
            r9 = r2
        L_0x0577:
            r8.append(r9)
        L_0x057a:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r14.l = r8
        L_0x0580:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x059e
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r13.f13425g
            if (r8 == 0) goto L_0x059b
            java.util.ArrayList r8 = r8.getOrderedCartList()
            if (r8 == 0) goto L_0x059b
            java.lang.Object r8 = r8.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8
            if (r8 == 0) goto L_0x059b
            java.lang.String r8 = r8.getItemStatus()
            goto L_0x059c
        L_0x059b:
            r8 = r2
        L_0x059c:
            r14.m = r8
        L_0x059e:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x05b0
            org.json.JSONObject r8 = r13.f13426h
            if (r8 == 0) goto L_0x05ad
            java.lang.String r9 = "policyNo"
            java.lang.String r8 = r8.optString(r9)
            goto L_0x05ae
        L_0x05ad:
            r8 = r2
        L_0x05ae:
            r14.n = r8
        L_0x05b0:
            int r14 = net.one97.paytm.insurance.R.id.transaction_amount_success
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "transaction_amount_success"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.e(r14)
            int r14 = net.one97.paytm.insurance.R.id.ivInsurerLogo
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            java.lang.String r8 = "ivInsurerLogo"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.a((android.widget.ImageView) r14)
            int r14 = net.one97.paytm.insurance.R.id.ivInsurerLogo
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            java.lang.String r8 = "ivInsurerLogo"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.b((android.widget.ImageView) r14)
            int r14 = net.one97.paytm.insurance.R.id.tv_brand_name
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "tv_brand_name"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.b((android.widget.TextView) r14)
            int r14 = net.one97.paytm.insurance.R.id.tv_plan_name
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "tv_plan_name"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.a((android.widget.TextView) r14)
            int r14 = net.one97.paytm.insurance.R.id.tvOrderIdValue
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "tvOrderIdValue"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.f(r14)
            int r14 = net.one97.paytm.insurance.R.id.tv_member_num
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "tv_member_num"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.g(r14)
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "tv_payment_status_text"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.c((android.widget.TextView) r14)
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "tv_payment_status_text"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.c((android.widget.TextView) r14)
            int r14 = net.one97.paytm.insurance.R.id.iv_insurance_logo
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            java.lang.String r8 = "iv_insurance_logo"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r13.c((android.widget.ImageView) r14)
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0662
            java.lang.String r14 = r14.f13450f
            if (r14 == 0) goto L_0x0662
            kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r6, (boolean) r1)
        L_0x0662:
            int r14 = net.one97.paytm.insurance.R.id.tv_money_deducted
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r8 = "tv_money_deducted"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            r8 = 8
            r14.setVisibility(r8)
            android.content.Context r14 = r13.getContext()
            if (r14 == 0) goto L_0x0680
            int r9 = net.one97.paytm.insurance.R.string.okay_got_it
            r14.getString(r9)
        L_0x0680:
            android.content.Context r14 = r13.getContext()
            if (r14 == 0) goto L_0x0697
            android.content.res.Resources r14 = r14.getResources()
            if (r14 == 0) goto L_0x0697
            int r9 = net.one97.paytm.insurance.R.array.recharge_summary_moeny_deducted_messages
            java.lang.String[] r14 = r14.getStringArray(r9)
            if (r14 == 0) goto L_0x0697
            kotlin.a.f.b(r14)
        L_0x0697:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = r13.f13425g
            if (r14 == 0) goto L_0x06a0
            java.lang.String r14 = r14.getCreatedAt()
            goto L_0x06a1
        L_0x06a0:
            r14 = r2
        L_0x06a1:
            r9 = r14
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x06cd
            int r9 = net.one97.paytm.insurance.R.id.tvTimeDate
            android.view.View r9 = r13.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r10 = "tvTimeDate"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            f.a.b$a r10 = f.a.b.f13524a
            if (r14 != 0) goto L_0x06bf
            kotlin.g.b.k.a()
        L_0x06bf:
            java.lang.String r10 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            java.lang.String r11 = "dd MMM yyyy, hh:mm aa"
            java.lang.String r14 = f.a.b.a.b(r14, r10, r11)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r9.setText(r14)
        L_0x06cd:
            org.json.JSONObject r14 = r13.f13426h
            java.lang.String r9 = "updatedAt"
            if (r14 == 0) goto L_0x06d9
            java.lang.String r14 = r14.optString(r9)
            goto L_0x06da
        L_0x06d9:
            r14 = r2
        L_0x06da:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            java.lang.String r10 = "tv_last_updated_value"
            java.lang.String r11 = "tv_last_updated_text"
            if (r14 != 0) goto L_0x071a
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            org.json.JSONObject r12 = r13.f13426h
            if (r12 == 0) goto L_0x06f9
            java.lang.String r12 = r12.optString(r9)
            goto L_0x06fa
        L_0x06f9:
            r12 = r2
        L_0x06fa:
            a((android.widget.TextView) r14, (java.lang.String) r12)
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r11)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
            r14.setVisibility(r0)
            goto L_0x0736
        L_0x071a:
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r11)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
            r14.setVisibility(r8)
        L_0x0736:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0747
            java.lang.String r14 = r14.f13450f
            if (r14 == 0) goto L_0x0747
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r5, (boolean) r1)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            goto L_0x0748
        L_0x0747:
            r14 = r2
        L_0x0748:
            if (r14 != 0) goto L_0x074d
            kotlin.g.b.k.a()
        L_0x074d:
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x07c7
            org.json.JSONObject r14 = r13.f13426h
            if (r14 == 0) goto L_0x075c
            java.lang.String r14 = r14.optString(r9)
            goto L_0x075d
        L_0x075c:
            r14 = r2
        L_0x075d:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0797
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            org.json.JSONObject r12 = r13.f13426h
            if (r12 == 0) goto L_0x0776
            java.lang.String r12 = r12.optString(r9)
            goto L_0x0777
        L_0x0776:
            r12 = r2
        L_0x0777:
            a((android.widget.TextView) r14, (java.lang.String) r12)
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r11)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
            r14.setVisibility(r0)
            goto L_0x07b3
        L_0x0797:
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r11)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
            r14.setVisibility(r8)
        L_0x07b3:
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_desc
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r10 = "tv_payment_status_desc"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)
            r13.d(r14)
            r13.d()
        L_0x07c7:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x07d8
            java.lang.String r14 = r14.f13450f
            if (r14 == 0) goto L_0x07d8
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r4, (boolean) r1)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            goto L_0x07d9
        L_0x07d8:
            r14 = r2
        L_0x07d9:
            if (r14 != 0) goto L_0x07de
            kotlin.g.b.k.a()
        L_0x07de:
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x07f7
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_desc
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r1 = "tv_payment_status_desc"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            r13.d(r14)
            goto L_0x0eb1
        L_0x07f7:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0808
            java.lang.String r14 = r14.f13450f
            if (r14 == 0) goto L_0x0808
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r6, (boolean) r1)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            goto L_0x0809
        L_0x0808:
            r14 = r2
        L_0x0809:
            if (r14 != 0) goto L_0x080e
            kotlin.g.b.k.a()
        L_0x080e:
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0e86
            int r14 = net.one97.paytm.insurance.R.id.dash
            android.view.View r14 = r13.a((int) r14)
            java.lang.String r4 = "dash"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.rl_header
            android.view.View r14 = r13.a((int) r14)
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            java.lang.String r4 = "rl_header"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.rl_payment_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            java.lang.String r4 = "rl_payment_status"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_pending
            android.view.View r14 = r13.a((int) r14)
            java.lang.String r4 = "lyt_application_status_pending"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.cl_header
            android.view.View r14 = r13.a((int) r14)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            java.lang.String r4 = "cl_header"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.success_payee_details_rl
            android.view.View r14 = r13.a((int) r14)
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            java.lang.String r4 = "success_payee_details_rl"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.toolbar
            android.view.View r14 = r13.a((int) r14)
            androidx.appcompat.widget.Toolbar r14 = (androidx.appcompat.widget.Toolbar) r14
            java.lang.String r4 = "toolbar"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tvHeaderMsg
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r4 = "tvHeaderMsg"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            org.json.JSONObject r4 = r13.f13426h
            if (r4 == 0) goto L_0x089f
            org.json.JSONObject r3 = r4.optJSONObject(r3)
            if (r3 == 0) goto L_0x089f
            java.lang.String r3 = r3.optString(r7)
            goto L_0x08a0
        L_0x089f:
            r3 = r2
        L_0x08a0:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            int r14 = net.one97.paytm.insurance.R.id.toolbar
            android.view.View r14 = r13.a((int) r14)
            androidx.appcompat.widget.Toolbar r14 = (androidx.appcompat.widget.Toolbar) r14
            common.insuranceOrderSummary.a$d r3 = new common.insuranceOrderSummary.a$d
            r3.<init>(r13)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r14.setOnClickListener(r3)
            int r14 = net.one97.paytm.insurance.R.id.tvHeaderTitle
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tvHeaderTitle"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x08cc
            java.lang.String r3 = r3.f13445a
            goto L_0x08cd
        L_0x08cc:
            r3 = r2
        L_0x08cd:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x08dd
            java.lang.String r3 = r3.f13447c
            goto L_0x08de
        L_0x08dd:
            r3 = r2
        L_0x08de:
            com.squareup.picasso.aa r14 = r14.a((java.lang.String) r3)
            int r3 = net.one97.paytm.insurance.R.id.ivLogo
            android.view.View r3 = r13.a((int) r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r14.a((android.widget.ImageView) r3)
            int r14 = net.one97.paytm.insurance.R.id.tvAmount
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x0902
            java.lang.String r3 = r3.f13453i
            goto L_0x0903
        L_0x0902:
            r3 = r2
        L_0x0903:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x090f
            java.lang.String r14 = r14.f13448d
            goto L_0x0910
        L_0x090f:
            r14 = r2
        L_0x0910:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0929
            int r14 = net.one97.paytm.insurance.R.id.tv_download_policy_wording
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_download_policy_wording"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
        L_0x0929:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0930
            java.lang.String r14 = r14.m
            goto L_0x0931
        L_0x0930:
            r14 = r2
        L_0x0931:
            if (r14 != 0) goto L_0x0936
            kotlin.g.b.k.a()
        L_0x0936:
            boolean r14 = b((java.lang.String) r14)
            java.lang.String r3 = "lyt_application_status_pending_post_payment"
            java.lang.String r4 = "tv_application_id_text"
            if (r14 == 0) goto L_0x0a82
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0948
            java.lang.String r14 = r14.m
            goto L_0x0949
        L_0x0948:
            r14 = r2
        L_0x0949:
            if (r14 != 0) goto L_0x094e
            kotlin.g.b.k.a()
        L_0x094e:
            int r6 = r14.hashCode()
            r7 = 1572(0x624, float:2.203E-42)
            if (r6 == r7) goto L_0x0958
            goto L_0x09eb
        L_0x0958:
            java.lang.String r6 = "15"
            boolean r14 = r14.equals(r6)
            if (r14 == 0) goto L_0x09eb
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r14 = r13.a((int) r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r14 = r13.a((int) r14)
            java.lang.String r4 = "lyt_application_status_success_fail_post_payment"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.divider_appl_status
            android.view.View r14 = r13.a((int) r14)
            java.lang.String r4 = "divider_appl_status"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r14 = r13.a((int) r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tv_health_ins_premium_paid_date_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            org.json.JSONObject r3 = r13.f13426h
            if (r3 == 0) goto L_0x09a5
            java.lang.String r3 = r3.optString(r9)
            goto L_0x09a6
        L_0x09a5:
            r3 = r2
        L_0x09a6:
            a((android.widget.TextView) r14, (java.lang.String) r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_pending
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_status_text_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r13.c((android.widget.TextView) r14)
            int r14 = net.one97.paytm.insurance.R.id.tv_health_ins_medical_assessment_desc
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_health_ins_medical_assessment_desc"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x09cf
            java.lang.String r3 = r3.p
            goto L_0x09d0
        L_0x09cf:
            r3 = r2
        L_0x09d0:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_pending
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_amount_my_orders_pending"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r13.e(r14)
            r13.d()
            goto L_0x0a67
        L_0x09eb:
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r14 = r13.a((int) r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r14 = r13.a((int) r14)
            java.lang.String r3 = "lyt_application_status_success_fail_post_payment"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0a1a
            int r3 = net.one97.paytm.insurance.R.string.application_in_process
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
        L_0x0a1a:
            int r14 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0a34
            android.content.Context r3 = r13.f13423e
            if (r3 != 0) goto L_0x0a2b
            kotlin.g.b.k.a()
        L_0x0a2b:
            int r6 = net.one97.paytm.insurance.R.color.color_health_ins_ffa400
            int r3 = androidx.core.content.b.c(r3, r6)
            r14.setTextColor(r3)
        L_0x0a34:
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_application_id_value"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_amount_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r13.e(r14)
            r13.d()
        L_0x0a67:
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_status_text_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            int r3 = net.one97.paytm.insurance.R.string.payment_successful
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            goto L_0x0e86
        L_0x0a82:
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r6 = "tv_application_id_value"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_pending_post_payment
            android.view.View r14 = r13.a((int) r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.lyt_application_status_success_fail_post_payment
            android.view.View r14 = r13.a((int) r14)
            java.lang.String r3 = "lyt_application_status_success_fail_post_payment"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0ac2
            java.lang.String r14 = r14.n
            goto L_0x0ac3
        L_0x0ac2:
            r14 = r2
        L_0x0ac3:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            r3 = 2
            if (r14 != 0) goto L_0x0b49
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r6 = 1098907648(0x41800000, float:16.0)
            r14.setTextSize(r3, r6)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            android.content.Context r6 = r13.getContext()
            if (r6 != 0) goto L_0x0aea
            kotlin.g.b.k.a()
        L_0x0aea:
            int r7 = net.one97.paytm.insurance.R.color.ins_color_666666
            int r6 = androidx.core.content.b.c(r6, r7)
            r14.setTextColor(r6)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r6 = 1098907648(0x41800000, float:16.0)
            r14.setTextSize(r3, r6)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            android.content.Context r3 = r13.getContext()
            if (r3 != 0) goto L_0x0b11
            kotlin.g.b.k.a()
        L_0x0b11:
            int r6 = net.one97.paytm.insurance.R.color.ins_color_666666
            int r3 = androidx.core.content.b.c(r3, r6)
            r14.setTextColor(r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            int r3 = net.one97.paytm.insurance.R.string.application_id
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0bce
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x0b41
            java.lang.String r3 = r3.n
            goto L_0x0b42
        L_0x0b41:
            r3 = r2
        L_0x0b42:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            goto L_0x0bce
        L_0x0b49:
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r6 = 1094713344(0x41400000, float:12.0)
            r14.setTextSize(r3, r6)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            android.content.Context r6 = r13.getContext()
            if (r6 != 0) goto L_0x0b67
            kotlin.g.b.k.a()
        L_0x0b67:
            int r7 = net.one97.paytm.insurance.R.color.ins_color_999999
            int r6 = androidx.core.content.b.c(r6, r7)
            r14.setTextColor(r6)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r6 = 1094713344(0x41400000, float:12.0)
            r14.setTextSize(r3, r6)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            android.content.Context r3 = r13.getContext()
            if (r3 != 0) goto L_0x0b8e
            kotlin.g.b.k.a()
        L_0x0b8e:
            int r6 = net.one97.paytm.insurance.R.color.ins_color_999999
            int r3 = androidx.core.content.b.c(r3, r6)
            r14.setTextColor(r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_text
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            int r3 = net.one97.paytm.insurance.R.string.health_ins_order_id
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_id_value
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_application_id_value"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            android.os.Bundle r3 = r13.getArguments()
            if (r3 == 0) goto L_0x0bc8
            java.lang.String r4 = "order_id"
            java.lang.String r3 = r3.getString(r4)
            goto L_0x0bc9
        L_0x0bc8:
            r3 = r2
        L_0x0bc9:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
        L_0x0bce:
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_amount_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r13.e(r14)
            int r14 = net.one97.paytm.insurance.R.id.tv_last_updated_value_success_reject
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            org.json.JSONObject r3 = r13.f13426h
            if (r3 == 0) goto L_0x0bf0
            java.lang.String r3 = r3.optString(r9)
            goto L_0x0bf1
        L_0x0bf0:
            r3 = r2
        L_0x0bf1:
            a((android.widget.TextView) r14, (java.lang.String) r3)
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0bfb
            java.lang.String r14 = r14.m
            goto L_0x0bfc
        L_0x0bfb:
            r14 = r2
        L_0x0bfc:
            if (r14 != 0) goto L_0x0c01
            kotlin.g.b.k.a()
        L_0x0c01:
            net.one97.paytm.InsuranceOrderSummary$a r3 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r3 = net.one97.paytm.InsuranceOrderSummary.O
            boolean r3 = r3.equals(r14)
            if (r3 != 0) goto L_0x0c28
            net.one97.paytm.InsuranceOrderSummary$a r3 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r3 = net.one97.paytm.InsuranceOrderSummary.P
            boolean r3 = r3.equals(r14)
            if (r3 != 0) goto L_0x0c28
            net.one97.paytm.InsuranceOrderSummary$a r3 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r3 = net.one97.paytm.InsuranceOrderSummary.Q
            boolean r14 = r3.equals(r14)
            if (r14 == 0) goto L_0x0c26
            goto L_0x0c28
        L_0x0c26:
            r14 = 0
            goto L_0x0c29
        L_0x0c28:
            r14 = 1
        L_0x0c29:
            if (r14 == 0) goto L_0x0dc7
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0c32
            java.lang.String r14 = r14.m
            goto L_0x0c33
        L_0x0c32:
            r14 = r2
        L_0x0c33:
            if (r14 != 0) goto L_0x0c38
            kotlin.g.b.k.a()
        L_0x0c38:
            net.one97.paytm.InsuranceOrderSummary$a r3 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r3 = net.one97.paytm.InsuranceOrderSummary.O
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x0c74
            net.one97.paytm.InsuranceOrderSummary$a r3 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r3 = net.one97.paytm.InsuranceOrderSummary.P
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0c5c
            int r14 = net.one97.paytm.insurance.R.string.application_cancelled
            java.lang.String r14 = r13.getString(r14)
            java.lang.String r3 = "getString(R.string.application_cancelled)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            goto L_0x0c7f
        L_0x0c5c:
            net.one97.paytm.InsuranceOrderSummary$a r3 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r3 = net.one97.paytm.InsuranceOrderSummary.Q
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r3)
            if (r14 == 0) goto L_0x0c74
            int r14 = net.one97.paytm.insurance.R.string.application_cancelled
            java.lang.String r14 = r13.getString(r14)
            java.lang.String r3 = "getString(R.string.application_cancelled)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            goto L_0x0c7f
        L_0x0c74:
            int r14 = net.one97.paytm.insurance.R.string.application_rejected
            java.lang.String r14 = r13.getString(r14)
            java.lang.String r3 = "getString(R.string.application_rejected)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
        L_0x0c7f:
            int r3 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r3 = r13.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0c8e
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r3.setText(r14)
        L_0x0c8e:
            int r14 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0ca8
            android.content.Context r3 = r13.f13423e
            if (r3 != 0) goto L_0x0c9f
            kotlin.g.b.k.a()
        L_0x0c9f:
            int r4 = net.one97.paytm.insurance.R.color.color_health_ins_fd5c5c
            int r3 = androidx.core.content.b.c(r3, r4)
            r14.setTextColor(r3)
        L_0x0ca8:
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_status_text_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            int r3 = net.one97.paytm.insurance.R.string.health_ins_refund_amount
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            int r14 = net.one97.paytm.insurance.R.id.tvOrderIdText
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tvOrderIdText"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.tvOrderIdValue
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tvOrderIdValue"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.tvTimeDate
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tvTimeDate"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r8)
            int r14 = net.one97.paytm.insurance.R.id.tv_refund_msg_desc
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_refund_msg_desc"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.lyt_refund_status
            android.view.View r14 = r13.a((int) r14)
            java.lang.String r3 = "lyt_refund_status"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tv_application_reject_reason
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_application_reject_reason"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r14.setVisibility(r0)
            int r14 = net.one97.paytm.insurance.R.id.tv_total_paid_amount_my_orders
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_total_paid_amount_my_orders"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x0d39
            java.lang.String r3 = r3.j
            goto L_0x0d3a
        L_0x0d39:
            r3 = r2
        L_0x0d3a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_deducted_for_health_check_up_amount
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_deducted_for_health_check_up_amount"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x0d54
            java.lang.String r3 = r3.r
            goto L_0x0d55
        L_0x0d54:
            r3 = r2
        L_0x0d55:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_amount_my_orders_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_amount_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            common.insuranceOrderSummary.d r3 = r13.f13436a
            if (r3 == 0) goto L_0x0d6f
            java.lang.String r3 = r3.q
            goto L_0x0d70
        L_0x0d6f:
            r3 = r2
        L_0x0d70:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
            android.text.SpannableStringBuilder r14 = new android.text.SpannableStringBuilder
            r14.<init>()
            int r3 = net.one97.paytm.insurance.R.string.failed_order_reason_title
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.append(r3)
            int r3 = net.one97.paytm.insurance.R.string.failed_order_reason_title
            java.lang.String r3 = r13.getString(r3)
            int r3 = r3.length()
            int r3 = r3 - r1
            net.one97.paytm.insurance.widgets.CustomTypefaceSpan r4 = new net.one97.paytm.insurance.widgets.CustomTypefaceSpan
            java.lang.String r6 = "sans-serif-medium"
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r0)
            java.lang.String r7 = ""
            r4.<init>(r7, r6)
            r6 = 18
            r14.setSpan(r4, r0, r3, r6)
            java.lang.String r3 = " "
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.append(r3)
            int r3 = net.one97.paytm.insurance.R.string.failed_order_reason_value
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.append(r3)
            int r3 = net.one97.paytm.insurance.R.id.tv_application_reject_reason
            android.view.View r3 = r13.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "tv_application_reject_reason"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r3.setText(r14)
        L_0x0dc7:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0dce
            java.lang.String r14 = r14.m
            goto L_0x0dcf
        L_0x0dce:
            r14 = r2
        L_0x0dcf:
            if (r14 != 0) goto L_0x0dd4
            kotlin.g.b.k.a()
        L_0x0dd4:
            net.one97.paytm.InsuranceOrderSummary$a r3 = net.one97.paytm.InsuranceOrderSummary.f13533b
            java.lang.String r3 = net.one97.paytm.InsuranceOrderSummary.N
            boolean r14 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r14, (boolean) r1)
            if (r14 == 0) goto L_0x0e86
            int r14 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0df5
            int r3 = net.one97.paytm.insurance.R.string.application_approved
            java.lang.String r3 = r13.getString(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r14.setText(r3)
        L_0x0df5:
            int r14 = net.one97.paytm.insurance.R.id.tv_application_status_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0e0f
            android.content.Context r3 = r13.f13423e
            if (r3 != 0) goto L_0x0e06
            kotlin.g.b.k.a()
        L_0x0e06:
            int r4 = net.one97.paytm.insurance.R.color.color_21c17a
            int r3 = androidx.core.content.b.c(r3, r4)
            r14.setTextColor(r3)
        L_0x0e0f:
            int r14 = net.one97.paytm.insurance.R.id.tv_payment_status_text_my_orders_success_fail
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r3 = "tv_payment_status_text_my_orders_success_fail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            r13.c((android.widget.TextView) r14)
            java.lang.Boolean r14 = r13.f13438c
            if (r14 != 0) goto L_0x0e27
            kotlin.g.b.k.a()
        L_0x0e27:
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L_0x0e86
            net.one97.paytm.common.widgets.c r14 = r13.k
            if (r14 != 0) goto L_0x0e86
            android.content.Context r6 = r13.getContext()
            net.one97.paytm.insurance.b.a r14 = net.one97.paytm.insurance.b.a.a()
            java.lang.String r3 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            long r7 = net.one97.paytm.insurance.b.a.d()
            net.one97.paytm.insurance.b.a r14 = net.one97.paytm.insurance.b.a.a()
            java.lang.String r3 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            long r9 = net.one97.paytm.insurance.b.a.e()
            net.one97.paytm.insurance.b.a r14 = net.one97.paytm.insurance.b.a.a()
            java.lang.String r3 = "GTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)
            long r11 = net.one97.paytm.insurance.b.a.f()
            boolean r14 = com.paytm.utility.b.a((android.content.Context) r6, (long) r7, (long) r9, (long) r11)
            if (r14 == 0) goto L_0x0e86
            boolean r14 = r13.isAdded()
            if (r14 == 0) goto L_0x0e86
            net.one97.paytm.common.widgets.c r14 = new net.one97.paytm.common.widgets.c
            r14.<init>()
            r13.k = r14
            net.one97.paytm.common.widgets.c r14 = r13.k
            if (r14 == 0) goto L_0x0e79
            r3 = r13
            net.one97.paytm.common.widgets.a.a r3 = (net.one97.paytm.common.widgets.a.a) r3
            r14.a((net.one97.paytm.common.widgets.a.a) r3)
        L_0x0e79:
            androidx.fragment.app.j r14 = r13.getFragmentManager()
            if (r14 == 0) goto L_0x0e86
            net.one97.paytm.common.widgets.c r3 = r13.k
            if (r3 == 0) goto L_0x0e86
            r3.show((androidx.fragment.app.j) r14, (java.lang.String) r2)
        L_0x0e86:
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0e97
            java.lang.String r14 = r14.f13450f
            if (r14 == 0) goto L_0x0e97
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r5, (boolean) r1)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            goto L_0x0e98
        L_0x0e97:
            r14 = r2
        L_0x0e98:
            if (r14 != 0) goto L_0x0e9d
            kotlin.g.b.k.a()
        L_0x0e9d:
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L_0x0eb1
            common.insuranceOrderSummary.d r14 = r13.f13436a
            if (r14 == 0) goto L_0x0ea9
            java.lang.String r2 = r14.m
        L_0x0ea9:
            if (r2 != 0) goto L_0x0eae
            kotlin.g.b.k.a()
        L_0x0eae:
            b((java.lang.String) r2)
        L_0x0eb1:
            net.one97.paytm.insurance.b.b r14 = net.one97.paytm.insurance.b.b.INSTANCE
            int r1 = net.one97.paytm.insurance.R.id.progress_bar
            android.view.View r1 = r13.a((int) r1)
            com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
            r14.stopAnimation(r1)
            int r14 = net.one97.paytm.insurance.R.id.scroll_view_parent
            android.view.View r14 = r13.a((int) r14)
            android.widget.ScrollView r14 = (android.widget.ScrollView) r14
            java.lang.String r1 = "scroll_view_parent"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            r14.setVisibility(r0)
            return
        L_0x0ecf:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<kotlin.String, kotlin.String>"
            r14.<init>(r0)
            throw r14
        L_0x0ed7:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.google.gsonhtcfix.internal.LinkedTreeMap<kotlin.String, kotlin.Any?>"
            r14.<init>(r0)
            throw r14
        L_0x0edf:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummary"
            r14.<init>(r0)
            throw r14
        L_0x0ee7:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummary"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: common.insuranceOrderSummary.a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    /* renamed from: common.insuranceOrderSummary.a$a  reason: collision with other inner class name */
    static final class C0177a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f13428a;

        C0177a(a aVar) {
            this.f13428a = aVar;
        }

        public final void run() {
            a aVar = this.f13428a;
            aVar.a(aVar.f13437b);
        }
    }

    private final void d() {
        new Handler().postDelayed(new C0177a(this), 10000);
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
        this.f13423e = context;
        a((IJRPaytmDataModel) new CJROrderSummary());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        this.f13424f = layoutInflater.inflate(net.one97.paytm.insurance.R.layout.health_insurance_post_payment_1, viewGroup, false);
        return this.f13424f;
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f13431a;

        d(a aVar) {
            this.f13431a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f13431a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
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
}
