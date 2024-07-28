package net.one97.paytm.recharge.dth.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.c.e;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.u;
import net.one97.paytm.recharge.common.fragment.FJRRechargeUtilBaseFragment;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.common.widget.CJRFetchingAmountLoader;
import net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout;
import net.one97.paytm.recharge.common.widget.CustomDthInputLayout;
import net.one97.paytm.recharge.common.widget.CustomInputLinearLayout;
import net.one97.paytm.recharge.common.widget.PreventScrollTextView;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.dth.a.i;
import net.one97.paytm.recharge.dth.widget.CJRDTHRechargeHeaderView;
import net.one97.paytm.recharge.dth.widget.CJRDTHRechargeShimmerView;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityPrefetchV2;
import net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText;
import net.one97.paytm.recharge.model.CJRAmountPreFetchDetails;
import net.one97.paytm.recharge.model.CJRPromoCode;
import net.one97.paytm.recharge.model.CJRRechargeData;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRDthRechargeHeaderModel;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRNextGroupData;
import net.one97.paytm.recharge.model.v4.CJRProductList;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.GroupAttributesItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class g extends net.one97.paytm.recharge.common.fragment.o implements e.b, ai, net.one97.paytm.recharge.common.e.h, net.one97.paytm.recharge.common.e.o, u, ConvenienceFeeInputLayout.b, CustomInputLinearLayout.a, CustomInputLinearLayout.b, i.b, CJRDTHRechargeHeaderView.a, net.one97.paytm.recharge.mobile_v3.d.b {
    static final /* synthetic */ kotlin.k.i[] t = {y.a((v) new w(y.b(g.class), "isFromRecentOnly", "isFromRecentOnly()Z"))};
    public static final a v = new a((byte) 0);
    private String A;
    private String B;
    private String C;
    private CJRProductsItem D;
    private CJRNextGroupData E;
    private List<CJRAggsItem> F;
    private net.one97.paytm.recharge.common.c.e G;
    private CJRDTHRechargeShimmerView H;
    private final String I = "dth";
    private boolean J;
    /* access modifiers changed from: private */
    public boolean K;
    private boolean L;
    private boolean M;
    private CJRProductsItem N;
    private boolean O;
    private HashMap<String, CJRAmountPreFetchDetails> P = new HashMap<>();
    /* access modifiers changed from: private */
    public EditText Q;
    /* access modifiers changed from: private */
    public JSONObject R;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.utils.o S;
    /* access modifiers changed from: private */
    public String T = "";
    private CJRPromoCode U;
    private final kotlin.g V = kotlin.h.a(new l(this));
    /* access modifiers changed from: private */
    public boolean W;
    private boolean X;
    private boolean Y;
    /* access modifiers changed from: private */
    public boolean Z;
    private boolean aa;
    private View.OnClickListener ab = new f(this);
    private HashMap ac;
    String u;
    private CJRCategoryData w;
    private CJRSelectedGroupItem x;
    private CJRNextGroupData y;
    private String z;

    /* access modifiers changed from: private */
    public final boolean S() {
        return ((Boolean) this.V.getValue()).booleanValue();
    }

    public final void a(Boolean bool) {
    }

    public final void a(CJRNextGroupData cJRNextGroupData) {
    }

    public final View b(int i2) {
        if (this.ac == null) {
            this.ac = new HashMap();
        }
        View view = (View) this.ac.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.ac.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b(Data<CJRCategoryData> data) {
    }

    public final void h() {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public final void u() {
        HashMap hashMap = this.ac;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void v() {
    }

    static final /* synthetic */ class d extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        d(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ g this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(g gVar) {
            super(0);
            this.this$0 = gVar;
        }

        public final boolean invoke() {
            HashMap<String, String> hashMap;
            net.one97.paytm.recharge.common.h.g h2 = this.this$0.f61339f;
            if (h2 == null || (hashMap = h2.m) == null) {
                return false;
            }
            return hashMap.containsKey("isFromRecents");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g a(Bundle bundle) {
            kotlin.g.b.k.c(bundle, "bundle");
            g gVar = new g();
            gVar.setArguments(bundle);
            return gVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        try {
            CJRCategoryData cJRCategoryData = this.w;
            Boolean valueOf = cJRCategoryData != null ? Boolean.valueOf(cJRCategoryData.showFastForward()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            this.f61341h = valueOf.booleanValue();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.J = arguments.getBoolean("is_recharge_tabs_flow", false);
            }
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_recharge_utility_layout, (ViewGroup) null, false);
    }

    public final net.one97.paytm.recharge.common.h.g a(CJRItem cJRItem) {
        androidx.lifecycle.ai aiVar;
        kotlin.g.b.k.c(cJRItem, "pRechargeItem");
        CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
        try {
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                aiVar = am.a(activity).a(net.one97.paytm.recharge.dth.c.a.class);
            } else {
                aiVar = null;
            }
            net.one97.paytm.recharge.dth.c.a aVar = (net.one97.paytm.recharge.dth.c.a) aiVar;
            if (aVar != null) {
                this.f61339f = aVar;
                a((net.one97.paytm.recharge.common.h.b) aVar);
                aVar.b(new d(this));
                aVar.B = frequentOrderList;
                this.w = aVar.O;
                this.x = aVar.P;
                this.y = aVar.f61409b.getNextGroupItemData();
                aVar.f61409b.setCategoryData(this.w);
            }
            return aVar;
        } catch (Exception unused) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            Intent intent = new Intent(getActivity(), AJRRechargeUtilityActivity.class);
            FragmentActivity activity3 = getActivity();
            if ((activity3 != null ? activity3.getIntent() : null) != null) {
                FragmentActivity activity4 = getActivity();
                Intent intent2 = activity4 != null ? activity4.getIntent() : null;
                if (intent2 == null) {
                    kotlin.g.b.k.a();
                }
                intent.putExtras(intent2);
            }
            intent.setFlags(603979776);
            FragmentActivity activity5 = getActivity();
            if (activity5 != null) {
                activity5.startActivity(intent);
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r8 = r8.f61409b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r8, r0)
            super.onViewCreated(r8, r9)
            net.one97.paytm.recharge.common.h.g r8 = r7.f61339f
            r9 = 0
            if (r8 == 0) goto L_0x0016
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r8 = r8.f61409b
            if (r8 == 0) goto L_0x0016
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r8 = r8.getNextGroupItemData()
            goto L_0x0017
        L_0x0016:
            r8 = r9
        L_0x0017:
            r7.E = r8
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r8 = r7.E
            if (r8 == 0) goto L_0x0023
            java.util.List r8 = r8.getAggs()
            r7.F = r8
        L_0x0023:
            android.content.Context r8 = r7.getContext()
            java.lang.String r0 = ""
            r1 = 0
            if (r8 == 0) goto L_0x00a4
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r7.w
            if (r2 == 0) goto L_0x0040
            java.lang.Long r2 = r2.getCategoryId()
            if (r2 == 0) goto L_0x0040
            long r2 = r2.longValue()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            if (r2 != 0) goto L_0x0041
        L_0x0040:
            r2 = r0
        L_0x0041:
            boolean r2 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r8, (java.lang.String) r2)
            if (r2 != 0) goto L_0x0057
            int r8 = net.one97.paytm.recharge.R.id.bank_offers_promocode_text_layout
            android.view.View r8 = r7.b((int) r8)
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r8 = (net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3) r8
            if (r8 == 0) goto L_0x00a4
            android.view.View r8 = (android.view.View) r8
            net.one97.paytm.recharge.common.utils.ai.b(r8)
            goto L_0x00a4
        L_0x0057:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r7.w
            if (r2 == 0) goto L_0x006e
            java.lang.Long r2 = r2.getCategoryId()
            if (r2 == 0) goto L_0x006e
            long r2 = r2.longValue()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            if (r2 == 0) goto L_0x006e
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0071
        L_0x006e:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x0071:
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00a1
            net.one97.paytm.recharge.common.utils.o r2 = new net.one97.paytm.recharge.common.utils.o
            net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r7.w
            if (r3 == 0) goto L_0x008d
            java.lang.Long r3 = r3.getCategoryId()
            if (r3 == 0) goto L_0x008d
            long r3 = r3.longValue()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            if (r3 != 0) goto L_0x008e
        L_0x008d:
            r3 = r0
        L_0x008e:
            r4 = r7
            net.one97.paytm.recharge.common.e.u r4 = (net.one97.paytm.recharge.common.e.u) r4
            r2.<init>(r8, r0, r3, r4)
            r7.S = r2
            r8 = 1
            r7.g((boolean) r8)
            net.one97.paytm.recharge.common.utils.az r8 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.o r8 = r7.S
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.common.utils.o) r8)
        L_0x00a1:
            r7.g((boolean) r1)
        L_0x00a4:
            int r8 = net.one97.paytm.recharge.R.id.lyt_fast_forward_dth
            android.view.View r8 = r7.b((int) r8)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x00b3
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            goto L_0x00b4
        L_0x00b3:
            r8 = r9
        L_0x00b4:
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
            if (r8 == 0) goto L_0x01d3
            android.widget.LinearLayout$LayoutParams r8 = (android.widget.LinearLayout.LayoutParams) r8
            if (r8 == 0) goto L_0x00c5
            r3 = 10
            int r3 = com.paytm.utility.b.c((int) r3)
            r8.setMargins(r1, r3, r1, r1)
        L_0x00c5:
            int r3 = net.one97.paytm.recharge.R.id.lyt_fast_forward_dth
            android.view.View r3 = r7.b((int) r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            if (r3 == 0) goto L_0x00d4
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r3.setLayoutParams(r8)
        L_0x00d4:
            int r8 = net.one97.paytm.recharge.R.id.lyt_proceed_btn_dth
            android.view.View r8 = r7.b((int) r8)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            java.lang.String r3 = "lyt_proceed_btn_dth"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            if (r8 == 0) goto L_0x01cd
            android.widget.LinearLayout$LayoutParams r8 = (android.widget.LinearLayout.LayoutParams) r8
            r2 = 20
            int r4 = com.paytm.utility.b.c((int) r2)
            r5 = 15
            int r6 = com.paytm.utility.b.c((int) r5)
            int r2 = com.paytm.utility.b.c((int) r2)
            int r5 = com.paytm.utility.b.c((int) r5)
            r8.setMargins(r4, r6, r2, r5)
            int r2 = net.one97.paytm.recharge.R.id.lyt_proceed_btn_dth
            android.view.View r2 = r7.b((int) r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r2.setLayoutParams(r8)
            r7.f((boolean) r1)
            r7.F()
            net.one97.paytm.recharge.model.v4.CJRCategoryData r8 = r7.w
            if (r8 == 0) goto L_0x011e
            java.lang.String r9 = r8.getDisclaimer()
        L_0x011e:
            r7.f((java.lang.String) r9)
            int r8 = net.one97.paytm.recharge.R.id.btn_proceed_dth
            android.view.View r8 = r7.b((int) r8)
            android.widget.Button r8 = (android.widget.Button) r8
            if (r8 == 0) goto L_0x0131
            r9 = r7
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x0131:
            int r8 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r8 = r7.b((int) r8)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r8 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r8
            if (r8 == 0) goto L_0x0141
            r9 = r7
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x0141:
            int r8 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r8 = r7.b((int) r8)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r8 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r8
            if (r8 == 0) goto L_0x0151
            r9 = r7
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x0151:
            int r8 = net.one97.paytm.recharge.R.id.lyt_fast_forward_dth
            android.view.View r8 = r7.b((int) r8)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x0160
            android.view.View$OnClickListener r9 = r7.ab
            r8.setOnClickListener(r9)
        L_0x0160:
            int r8 = net.one97.paytm.recharge.R.id.radio_fast_forward_dth
            android.view.View r8 = r7.b((int) r8)
            android.widget.CheckBox r8 = (android.widget.CheckBox) r8
            if (r8 == 0) goto L_0x016d
            r8.setClickable(r1)
        L_0x016d:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            boolean r8 = r8 instanceof net.one97.paytm.recharge.common.e.y
            if (r8 == 0) goto L_0x018b
            boolean r8 = r7.J
            if (r8 == 0) goto L_0x018b
            android.os.Handler r8 = new android.os.Handler
            r8.<init>()
            net.one97.paytm.recharge.dth.a.g$p r9 = new net.one97.paytm.recharge.dth.a.g$p
            r9.<init>(r7)
            java.lang.Runnable r9 = (java.lang.Runnable) r9
            r0 = 100
            r8.postDelayed(r9, r0)
            return
        L_0x018b:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            boolean r8 = r8 instanceof net.one97.paytm.recharge.common.e.y
            if (r8 == 0) goto L_0x01cc
            boolean r8 = r7.J
            if (r8 != 0) goto L_0x01cc
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x01cc
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x01c4
            net.one97.paytm.recharge.common.e.y r8 = (net.one97.paytm.recharge.common.e.y) r8
            r8.b((java.lang.String) r0)
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            boolean r8 = r8 instanceof net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity
            if (r8 == 0) goto L_0x01cc
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x01bc
            net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity r8 = (net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity) r8
            r8.l()
            goto L_0x01cc
        L_0x01bc:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity"
            r8.<init>(r9)
            throw r8
        L_0x01c4:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface"
            r8.<init>(r9)
            throw r8
        L_0x01cc:
            return
        L_0x01cd:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r2)
            throw r8
        L_0x01d3:
            kotlin.u r8 = new kotlin.u
            r8.<init>(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62710a;

        p(g gVar) {
            this.f62710a = gVar;
        }

        public final void run() {
            if (this.f62710a.getActivity() != null) {
                FragmentActivity activity = this.f62710a.getActivity();
                if (activity != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity).e();
                    FragmentActivity activity2 = this.f62710a.getActivity();
                    if (activity2 != null) {
                        ((net.one97.paytm.recharge.common.e.y) activity2).i();
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        }
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        kotlin.g.b.k.c(menu, "menu");
        kotlin.g.b.k.c(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        U();
    }

    public final void w() {
        LinearLayout linearLayout = (LinearLayout) b(R.id.lyt_ff_proceed);
        if (linearLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.b(linearLayout);
        }
        LinearLayout linearLayout2 = (LinearLayout) b(R.id.lyt_ff_proceed_dth);
        if (linearLayout2 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(linearLayout2);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.next_btn_parent_lyt);
        if (cJRProceedWidgetV8 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(cJRProceedWidgetV8);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x000e: MOVE  (r7v4 java.util.Collection) = 
          (r1v0 java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    private final void a(java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r19, boolean r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout"
            r4 = 1
            r5 = 0
            r6 = 0
            if (r1 == 0) goto L_0x0199
            r7 = r1
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L_0x0199
            boolean r8 = r7.isEmpty()
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x0199
            r8 = r7
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = kotlin.a.k.e(r8)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r9 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r9
            r0.N = r9
            if (r2 == 0) goto L_0x0153
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L_0x0076
            java.lang.Object r2 = r1.get(r5)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            java.lang.String r2 = r2.getOperator()
            if (r2 == 0) goto L_0x0076
            java.lang.Object r1 = r1.get(r5)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            java.lang.String r13 = r1.getOperator()
            if (r13 != 0) goto L_0x0047
            kotlin.g.b.k.a()
        L_0x0047:
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x0076
            net.one97.paytm.recharge.ordersummary.h.d r9 = r1.v
            if (r9 == 0) goto L_0x0076
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x0059
            java.lang.String r1 = r1.a()
            r10 = r1
            goto L_0x005a
        L_0x0059:
            r10 = r6
        L_0x005a:
            if (r10 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            java.lang.String r1 = "/Dth"
            java.lang.String r12 = r1.toLowerCase()
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            r14 = 0
            r16 = 0
            r17 = 80
            java.lang.String r11 = "Select Operator_dropdown_item_selected"
            java.lang.String r15 = "auto"
            net.one97.paytm.recharge.ordersummary.h.d.a(r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x0076:
            java.lang.Object r1 = r8.get(r5)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            java.util.List r1 = r1.getInputFields()
            if (r1 == 0) goto L_0x0089
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.List r1 = kotlin.a.k.c(r1)
            goto L_0x008a
        L_0x0089:
            r1 = r6
        L_0x008a:
            if (r1 == 0) goto L_0x00bf
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r4
            if (r2 != r4) goto L_0x00bf
            int r2 = r1.size()
            if (r2 <= r4) goto L_0x00bf
            java.lang.Object r2 = r1.get(r5)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r2 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r2
            if (r2 == 0) goto L_0x00a9
            java.lang.String r2 = r2.getConfigKey()
            goto L_0x00aa
        L_0x00a9:
            r2 = r6
        L_0x00aa:
            r0.A = r2
            java.lang.Object r2 = r1.get(r5)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r2 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r2
            if (r2 == 0) goto L_0x00b9
            java.lang.String r2 = r2.getTitle()
            goto L_0x00ba
        L_0x00b9:
            r2 = r6
        L_0x00ba:
            r0.C = r2
            r1.remove(r5)
        L_0x00bf:
            if (r1 == 0) goto L_0x013b
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r4
            if (r2 != r4) goto L_0x013b
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            boolean r2 = r2 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
            if (r2 == 0) goto L_0x00e0
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x00da
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r2 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r2
            r2.f61988b = r4
            goto L_0x00e0
        L_0x00da:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x00e0:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x00ea
            r3 = r0
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r3 = (net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a) r3
            r2.setLayoutClickListener(r3)
        L_0x00ea:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x00f8
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r3 = kotlin.a.k.e(r3)
            r2.setImputFields(r3)
        L_0x00f8:
            java.lang.Object r2 = r8.get(r5)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            boolean r2 = r2.isDTHAmountFetchTrue()
            if (r2 != 0) goto L_0x0118
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x0118
            net.one97.paytm.recharge.common.h.g r3 = r0.f61339f
            if (r3 == 0) goto L_0x010f
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r3.m
            goto L_0x0110
        L_0x010f:
            r3 = r6
        L_0x0110:
            if (r3 != 0) goto L_0x0115
            kotlin.g.b.k.a()
        L_0x0115:
            r2.setDeepLinkParams(r3)
        L_0x0118:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x0126
            net.one97.paytm.common.entity.CJRItem r3 = r0.f61340g
            if (r3 != 0) goto L_0x0123
            kotlin.g.b.k.a()
        L_0x0123:
            r2.setRechargeItem(r3)
        L_0x0126:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x0132
            net.one97.paytm.recharge.model.v4.CJRProductList r3 = new net.one97.paytm.recharge.model.v4.CJRProductList
            r3.<init>(r6, r8)
            r2.setDTHProductList(r3)
        L_0x0132:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r0.r
            if (r2 == 0) goto L_0x013b
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r2.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRInputFieldsItem>) r1, (java.lang.Boolean) r3, (boolean) r5)
        L_0x013b:
            r18.T()
            r0.b((java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem>) r8)
            java.lang.Object r1 = r8.get(r5)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            boolean r1 = r1.isSoftPrefetch()
            if (r1 == 0) goto L_0x0152
            java.lang.String r1 = r0.u
            r0.i((java.lang.String) r1)
        L_0x0152:
            return
        L_0x0153:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r9 = r0.r
            if (r9 == 0) goto L_0x0190
            net.one97.paytm.recharge.model.v4.CJRProductList r10 = new net.one97.paytm.recharge.model.v4.CJRProductList
            r10.<init>(r6, r8)
            net.one97.paytm.common.entity.CJRItem r11 = r0.f61340g
            net.one97.paytm.recharge.dth.a.g$e r7 = new net.one97.paytm.recharge.dth.a.g$e
            r7.<init>(r0, r2, r1)
            r12 = r7
            android.view.View$OnClickListener r12 = (android.view.View.OnClickListener) r12
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x016e
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            r13 = r1
            goto L_0x016f
        L_0x016e:
            r13 = r6
        L_0x016f:
            if (r13 != 0) goto L_0x0174
            kotlin.g.b.k.a()
        L_0x0174:
            net.one97.paytm.recharge.common.h.g r1 = r0.f61339f
            if (r1 == 0) goto L_0x017c
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            r14 = r1
            goto L_0x017d
        L_0x017c:
            r14 = r6
        L_0x017d:
            if (r14 != 0) goto L_0x0182
            kotlin.g.b.k.a()
        L_0x0182:
            r15 = r0
            net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout$b r15 = (net.one97.paytm.recharge.common.widget.ConvenienceFeeInputLayout.b) r15
            r16 = r0
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$a r16 = (net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.a) r16
            r17 = r0
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout$b r17 = (net.one97.paytm.recharge.common.widget.CustomInputLinearLayout.b) r17
            r9.a(r10, r11, r12, r13, r14, r15, r16, r17)
        L_0x0190:
            r0.b((java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem>) r8)
            r18.U()
            r18.T()
        L_0x0199:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            java.lang.String r2 = "recharge_number"
            if (r1 == 0) goto L_0x01a4
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = r1.b((java.lang.String) r2)
            goto L_0x01a5
        L_0x01a4:
            r1 = r6
        L_0x01a5:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r7 = r0.r
            if (r7 == 0) goto L_0x01ae
            android.view.View r2 = r7.a((java.lang.String) r2)
            goto L_0x01af
        L_0x01ae:
            r2 = r6
        L_0x01af:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r7 = r0.r
            if (r7 == 0) goto L_0x01bd
            net.one97.paytm.recharge.model.v4.CJRProductList r7 = r7.getProductList()
            if (r7 == 0) goto L_0x01bd
            java.util.List r6 = r7.getProducts()
        L_0x01bd:
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x01ca
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x01c8
            goto L_0x01ca
        L_0x01c8:
            r6 = 0
            goto L_0x01cb
        L_0x01ca:
            r6 = 1
        L_0x01cb:
            if (r6 != 0) goto L_0x01fc
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r6 = r0.r
            if (r6 == 0) goto L_0x01fc
            net.one97.paytm.recharge.model.v4.CJRProductList r6 = r6.getProductList()
            if (r6 == 0) goto L_0x01fc
            java.util.List r6 = r6.getProducts()
            if (r6 == 0) goto L_0x01fc
            java.lang.Object r5 = r6.get(r5)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x01fc
            boolean r5 = r5.isSoftPrefetch()
            if (r5 != r4) goto L_0x01fc
            boolean r5 = r2 instanceof android.widget.EditText
            if (r5 == 0) goto L_0x01fc
            android.widget.EditText r2 = (android.widget.EditText) r2
            net.one97.paytm.recharge.dth.a.g$b r5 = new net.one97.paytm.recharge.dth.a.g$b
            r5.<init>(r0)
            android.text.TextWatcher r5 = (android.text.TextWatcher) r5
            r2.addTextChangedListener(r5)
            goto L_0x020c
        L_0x01fc:
            boolean r5 = r2 instanceof android.widget.EditText
            if (r5 == 0) goto L_0x020c
            android.widget.EditText r2 = (android.widget.EditText) r2
            net.one97.paytm.recharge.dth.a.g$c r5 = new net.one97.paytm.recharge.dth.a.g$c
            r5.<init>(r0)
            android.text.TextWatcher r5 = (android.text.TextWatcher) r5
            r2.addTextChangedListener(r5)
        L_0x020c:
            if (r1 == 0) goto L_0x022d
            boolean r1 = r1.isDynamicLength()
            if (r1 != r4) goto L_0x022d
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            boolean r1 = r1 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
            if (r1 == 0) goto L_0x022d
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r0.r
            if (r1 == 0) goto L_0x0227
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r1 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r1
            r2 = r0
            net.one97.paytm.recharge.common.e.h r2 = (net.one97.paytm.recharge.common.e.h) r2
            r1.setFetchAmountListener(r2)
            goto L_0x022d
        L_0x0227:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r3)
            throw r1
        L_0x022d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.a(java.util.List, boolean):void");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62691a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f62692b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f62693c;

        e(g gVar, boolean z, List list) {
            this.f62691a = gVar;
            this.f62692b = z;
            this.f62693c = list;
        }

        public final void onClick(View view) {
            if (view == null) {
                try {
                    kotlin.g.b.k.a();
                } catch (Exception e2) {
                    com.paytm.utility.q.d(e2.getMessage());
                    return;
                }
            }
            ViewParent parent = view.getParent();
            if (parent != null) {
                g gVar = this.f62691a;
                View findViewById = ((RelativeLayout) parent).findViewById(R.id.edit_no);
                if (findViewById != null) {
                    gVar.Q = (EditText) findViewById;
                    Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
                    intent.setType("vnd.android.cursor.dir/phone_v2");
                    this.f62691a.startActivityForResult(intent, 100);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type android.widget.EditText");
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
    }

    public static final class j implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62702a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f62703b;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        j(g gVar, View view) {
            this.f62702a = gVar;
            this.f62703b = view;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
            if (android.text.TextUtils.isEmpty(((net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText) r3).getText()) != false) goto L_0x005e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r3) {
            /*
                r2 = this;
                net.one97.paytm.recharge.dth.a.g r0 = r2.f62702a
                r0.o = null
                net.one97.paytm.recharge.dth.a.g r0 = r2.f62702a
                r0.R = null
                net.one97.paytm.recharge.dth.a.g r0 = r2.f62702a
                java.lang.String r0 = r0.T
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0029
                net.one97.paytm.recharge.dth.a.g r0 = r2.f62702a
                int r1 = net.one97.paytm.recharge.R.id.lyt_fast_forward_dth
                android.view.View r0 = r0.b((int) r1)
                android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
                if (r0 == 0) goto L_0x0029
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.recharge.common.utils.ai.a(r0)
            L_0x0029:
                if (r3 == 0) goto L_0x007f
                java.lang.String r3 = r3.toString()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                r0 = 1
                if (r3 != r0) goto L_0x003f
                net.one97.paytm.recharge.dth.a.g r3 = r2.f62702a
                r0 = 0
                r3.g((boolean) r0)
                return
            L_0x003f:
                if (r3 != 0) goto L_0x007f
                android.view.View r3 = r2.f62703b
                if (r3 == 0) goto L_0x005e
                if (r3 == 0) goto L_0x0056
                net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText r3 = (net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText) r3
                android.text.Editable r3 = r3.getText()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 == 0) goto L_0x007a
                goto L_0x005e
            L_0x0056:
                kotlin.u r3 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText"
                r3.<init>(r0)
                throw r3
            L_0x005e:
                net.one97.paytm.recharge.dth.a.g r3 = r2.f62702a
                boolean r3 = r3.S()
                if (r3 != 0) goto L_0x006e
                net.one97.paytm.recharge.dth.a.g r3 = r2.f62702a
                boolean r3 = r3.W
                if (r3 == 0) goto L_0x007f
            L_0x006e:
                net.one97.paytm.recharge.dth.a.g r3 = r2.f62702a
                java.lang.String r3 = r3.u
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x007f
            L_0x007a:
                net.one97.paytm.recharge.dth.a.g r3 = r2.f62702a
                r3.g((boolean) r0)
            L_0x007f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.j.afterTextChanged(android.text.Editable):void");
        }
    }

    /* access modifiers changed from: private */
    public final void e(boolean z2) {
        if (z2) {
            this.X = true;
            LinearLayout linearLayout = (LinearLayout) b(R.id.lyt_ff_proceed_dth);
            if (linearLayout != null) {
                net.one97.paytm.recharge.common.utils.ai.b(linearLayout);
            }
            LinearLayout linearLayout2 = (LinearLayout) b(R.id.lyt_ff_proceed_dth);
            if (linearLayout2 != null) {
                linearLayout2.postDelayed(new m(this), 250);
            }
        } else if (!z2) {
            this.X = false;
            if (this.o != null) {
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.next_btn_parent_lyt);
                if (cJRProceedWidgetV8 != null) {
                    net.one97.paytm.recharge.common.utils.ai.b(cJRProceedWidgetV8);
                }
                LinearLayout linearLayout3 = (LinearLayout) b(R.id.lyt_ff_proceed_dth);
                if (linearLayout3 != null) {
                    linearLayout3.postDelayed(new n(this), 250);
                }
            }
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62707a;

        m(g gVar) {
            this.f62707a = gVar;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f62707a.b(R.id.lyt_ff_proceed_dth);
            if (linearLayout != null) {
                net.one97.paytm.recharge.common.utils.ai.b(linearLayout);
            }
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f62707a.b(R.id.next_btn_parent_lyt);
            if (cJRProceedWidgetV8 != null) {
                net.one97.paytm.recharge.common.utils.ai.a(cJRProceedWidgetV8);
            }
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62708a;

        n(g gVar) {
            this.f62708a = gVar;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f62708a.b(R.id.lyt_ff_proceed_dth);
            if (linearLayout != null) {
                net.one97.paytm.recharge.common.utils.ai.a(linearLayout);
            }
        }
    }

    private final void U() {
        CJRProductsItem cJRProductsItem = this.N;
        if (cJRProductsItem != null) {
            if (cJRProductsItem == null) {
                kotlin.g.b.k.a();
            }
            String bbpsLogoUrl = cJRProductsItem.getBbpsLogoUrl();
            if (bbpsLogoUrl == null) {
                CJRProductsItem cJRProductsItem2 = this.N;
                if (cJRProductsItem2 == null) {
                    kotlin.g.b.k.a();
                }
                bbpsLogoUrl = cJRProductsItem2.getBbps_logo_url();
            }
            if (bbpsLogoUrl == null) {
                bbpsLogoUrl = "";
            }
            if (!TextUtils.isEmpty(bbpsLogoUrl)) {
                a(bbpsLogoUrl);
            }
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62685a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        b(g gVar) {
            this.f62685a = gVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.util.List} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r10) {
            /*
                r9 = this;
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r0.r
                java.lang.String r1 = "recharge_number"
                r2 = 0
                if (r0 == 0) goto L_0x0014
                int r0 = r0.c((java.lang.String) r1)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x0015
            L_0x0014:
                r0 = r2
            L_0x0015:
                net.one97.paytm.recharge.dth.a.g r3 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r3 = r3.r
                if (r3 == 0) goto L_0x002c
                java.lang.String r4 = java.lang.String.valueOf(r0)
                java.lang.String r5 = "InputField_"
                java.lang.String r4 = r5.concat(r4)
                android.view.View r3 = r3.findViewWithTag(r4)
                goto L_0x002d
            L_0x002c:
                r3 = r2
            L_0x002d:
                net.one97.paytm.recharge.dth.a.g r4 = r9.f62685a
                r4.o = null
                net.one97.paytm.recharge.dth.a.g r4 = r9.f62685a
                r4.R = null
                net.one97.paytm.recharge.dth.a.g r4 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r4.r
                if (r4 == 0) goto L_0x0044
                net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = r4.b((java.lang.String) r1)
                goto L_0x0045
            L_0x0044:
                r1 = r2
            L_0x0045:
                if (r1 == 0) goto L_0x005e
                boolean r4 = r1.isDynamicLength()
                if (r4 != 0) goto L_0x005e
                android.os.Handler r4 = new android.os.Handler
                r4.<init>()
                net.one97.paytm.recharge.dth.a.g$b$a r5 = new net.one97.paytm.recharge.dth.a.g$b$a
                r5.<init>(r9, r0, r3, r1)
                java.lang.Runnable r5 = (java.lang.Runnable) r5
                r0 = 200(0xc8, double:9.9E-322)
                r4.postDelayed(r5, r0)
            L_0x005e:
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r0.r
                if (r0 == 0) goto L_0x0069
                r0.q()
            L_0x0069:
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r0.r
                if (r0 == 0) goto L_0x0074
                r0.o()
            L_0x0074:
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.h.g r0 = r0.f61339f
                if (r0 == 0) goto L_0x0083
                net.one97.paytm.recharge.common.utils.w r0 = r0.t
                if (r0 == 0) goto L_0x0083
                r1 = 1
                r0.o = r1
            L_0x0083:
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.h.g r0 = r0.f61339f
                if (r0 == 0) goto L_0x0092
                net.one97.paytm.recharge.common.utils.w r0 = r0.t
                if (r0 == 0) goto L_0x0092
                r0.a((org.json.JSONArray) r2, (java.lang.String) r2)
            L_0x0092:
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r0.r
                boolean r0 = r0 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
                if (r0 == 0) goto L_0x00b2
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r0.r
                if (r0 == 0) goto L_0x00aa
                net.one97.paytm.recharge.common.widget.CustomDthInputLayout r0 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r0
                r0.g()
                goto L_0x00b2
            L_0x00aa:
                kotlin.u r10 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout"
                r10.<init>(r0)
                throw r10
            L_0x00b2:
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r0.r
                if (r0 == 0) goto L_0x00c1
                java.lang.String r1 = "price"
                net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r0 = r0.b((java.lang.String) r1)
                goto L_0x00c2
            L_0x00c1:
                r0 = r2
            L_0x00c2:
                if (r0 == 0) goto L_0x00c9
                java.lang.String r1 = r0.getMessage()
                goto L_0x00ca
            L_0x00c9:
                r1 = r2
            L_0x00ca:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x00e5
                net.one97.paytm.recharge.dth.a.g r1 = r9.f62685a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r1 = r1.r
                if (r1 == 0) goto L_0x00e5
                if (r0 == 0) goto L_0x00e1
                java.lang.String r0 = r0.getMessage()
                goto L_0x00e2
            L_0x00e1:
                r0 = r2
            L_0x00e2:
                r1.setAmountFieldMessage(r0)
            L_0x00e5:
                if (r10 == 0) goto L_0x00ec
                java.lang.String r10 = r10.toString()
                goto L_0x00ed
            L_0x00ec:
                r10 = r2
            L_0x00ed:
                net.one97.paytm.recharge.dth.a.g r0 = r9.f62685a
                net.one97.paytm.recharge.common.h.g r0 = r0.f61339f
                if (r0 == 0) goto L_0x0102
                androidx.lifecycle.y<java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>> r0 = r0.f61414g
                androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
                if (r0 == 0) goto L_0x0102
                java.lang.Object r0 = r0.getValue()
                r2 = r0
                java.util.List r2 = (java.util.List) r2
            L_0x0102:
                boolean r10 = net.one97.paytm.recharge.common.utils.az.a((java.lang.String) r10, (java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r2)
                if (r10 == 0) goto L_0x0131
                net.one97.paytm.recharge.dth.a.g r10 = r9.f62685a
                net.one97.paytm.recharge.common.h.g r10 = r10.f61339f
                if (r10 == 0) goto L_0x0131
                net.one97.paytm.recharge.ordersummary.h.d r0 = r10.v
                if (r0 == 0) goto L_0x0131
                net.one97.paytm.recharge.dth.a.g r10 = r9.f62685a
                net.one97.paytm.recharge.common.h.g r10 = r10.f61339f
                if (r10 == 0) goto L_0x0122
                java.lang.String r10 = r10.a()
                if (r10 != 0) goto L_0x0124
            L_0x0122:
                java.lang.String r10 = ""
            L_0x0124:
                r1 = r10
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 124(0x7c, float:1.74E-43)
                java.lang.String r2 = "repeat_user_tapping_new_dth_recharge"
                net.one97.paytm.recharge.ordersummary.h.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            L_0x0131:
                net.one97.paytm.recharge.dth.a.g r10 = r9.f62685a
                r0 = 0
                r10.g((boolean) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.b.afterTextChanged(android.text.Editable):void");
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f62686a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Integer f62687b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f62688c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ CJRInputFieldsItem f62689d;

            a(b bVar, Integer num, View view, CJRInputFieldsItem cJRInputFieldsItem) {
                this.f62686a = bVar;
                this.f62687b = num;
                this.f62688c = view;
                this.f62689d = cJRInputFieldsItem;
            }

            public final void run() {
                CustomInputLinearLayout g2;
                if (this.f62687b != null && (this.f62688c instanceof EditText) && (g2 = this.f62686a.f62685a.r) != null) {
                    CJRInputFieldsItem cJRInputFieldsItem = this.f62689d;
                    CustomInputLinearLayout g3 = this.f62686a.f62685a.r;
                    if (g3 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (g2.a(cJRInputFieldsItem, (LinearLayout) g3, this.f62687b.intValue(), false)) {
                        this.f62686a.f62685a.i(((EditText) this.f62688c).getText().toString());
                    }
                }
            }
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62690a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(g gVar) {
            this.f62690a = gVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
            r2 = r2.f61414g;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r13) {
            /*
                r12 = this;
                r0 = 0
                if (r13 == 0) goto L_0x0008
                java.lang.String r1 = r13.toString()
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                net.one97.paytm.recharge.dth.a.g r2 = r12.f62690a
                net.one97.paytm.recharge.common.h.g r2 = r2.f61339f
                if (r2 == 0) goto L_0x001e
                androidx.lifecycle.y<java.util.List<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>> r2 = r2.f61414g
                androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
                if (r2 == 0) goto L_0x001e
                java.lang.Object r2 = r2.getValue()
                java.util.List r2 = (java.util.List) r2
                goto L_0x001f
            L_0x001e:
                r2 = r0
            L_0x001f:
                boolean r1 = net.one97.paytm.recharge.common.utils.az.a((java.lang.String) r1, (java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r2)
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x0051
                net.one97.paytm.recharge.dth.a.g r1 = r12.f62690a
                net.one97.paytm.recharge.common.h.g r1 = r1.f61339f
                if (r1 == 0) goto L_0x0051
                net.one97.paytm.recharge.ordersummary.h.d r3 = r1.v
                if (r3 == 0) goto L_0x0051
                net.one97.paytm.recharge.dth.a.g r1 = r12.f62690a
                net.one97.paytm.recharge.common.h.g r1 = r1.f61339f
                if (r1 == 0) goto L_0x0044
                java.lang.String r1 = r1.a()
                if (r1 != 0) goto L_0x0042
                goto L_0x0044
            L_0x0042:
                r4 = r1
                goto L_0x0045
            L_0x0044:
                r4 = r2
            L_0x0045:
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 124(0x7c, float:1.74E-43)
                java.lang.String r5 = "repeat_user_tapping_new_dth_recharge"
                net.one97.paytm.recharge.ordersummary.h.d.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            L_0x0051:
                java.lang.String r13 = java.lang.String.valueOf(r13)
                boolean r13 = net.one97.paytm.recharge.common.utils.g.c(r13)
                if (r13 == 0) goto L_0x007a
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r13 = r13.r
                if (r13 == 0) goto L_0x0068
                java.lang.String r13 = r13.getAmount()
                goto L_0x0069
            L_0x0068:
                r13 = r0
            L_0x0069:
                boolean r13 = net.one97.paytm.recharge.common.utils.g.c(r13)
                if (r13 == 0) goto L_0x007a
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r13 = r13.r
                if (r13 == 0) goto L_0x007a
                r13.setAmountOnAmountField(r2)
            L_0x007a:
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r13 = r13.r
                if (r13 == 0) goto L_0x0085
                r13.q()
            L_0x0085:
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                net.one97.paytm.recharge.common.h.g r13 = r13.f61339f
                if (r13 == 0) goto L_0x0094
                net.one97.paytm.recharge.common.utils.w r13 = r13.t
                if (r13 == 0) goto L_0x0094
                r1 = 1
                r13.o = r1
            L_0x0094:
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                net.one97.paytm.recharge.common.h.g r13 = r13.f61339f
                if (r13 == 0) goto L_0x00a3
                net.one97.paytm.recharge.common.utils.w r13 = r13.t
                if (r13 == 0) goto L_0x00a3
                r13.a((org.json.JSONArray) r0, (java.lang.String) r0)
            L_0x00a3:
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r13 = r13.r
                boolean r13 = r13 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
                if (r13 == 0) goto L_0x00c3
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r13 = r13.r
                if (r13 == 0) goto L_0x00bb
                net.one97.paytm.recharge.common.widget.CustomDthInputLayout r13 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r13
                r13.g()
                goto L_0x00c3
            L_0x00bb:
                kotlin.u r13 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout"
                r13.<init>(r0)
                throw r13
            L_0x00c3:
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                r13.o = null
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                r13.R = null
                net.one97.paytm.recharge.dth.a.g r13 = r12.f62690a
                r0 = 0
                r13.g((boolean) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.c.afterTextChanged(android.text.Editable):void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r6.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L_0x0015
            java.lang.Object r2 = r6.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            if (r2 == 0) goto L_0x0015
            boolean r2 = r2.getShowBrowsePlan()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0016
        L_0x0015:
            r2 = r0
        L_0x0016:
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00ad
            android.content.Context r2 = r5.getContext()
            if (r2 == 0) goto L_0x00ad
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r2 = r5.r
            if (r2 == 0) goto L_0x00ad
            android.view.View r2 = r2.getAmountContainerView()
            if (r2 == 0) goto L_0x00ad
            if (r2 == 0) goto L_0x00a5
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r2 = (net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8) r2
            android.content.Context r3 = r5.getContext()
            if (r3 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            int r4 = net.one97.paytm.recharge.R.string.browse_plans_txt
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context!!.getString(R.string.browse_plans_txt)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r5.r
            if (r4 == 0) goto L_0x0052
            net.one97.paytm.recharge.model.v4.CJRProductList r4 = r4.getProductList()
            if (r4 == 0) goto L_0x0052
            java.util.List r0 = r4.getProducts()
        L_0x0052:
            java.util.Collection r0 = (java.util.Collection) r0
            r4 = 1
            if (r0 == 0) goto L_0x0060
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r0 = 0
            goto L_0x0061
        L_0x0060:
            r0 = 1
        L_0x0061:
            if (r0 != 0) goto L_0x0082
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r5.r
            if (r0 == 0) goto L_0x0082
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = r0.getProductList()
            if (r0 == 0) goto L_0x0082
            java.util.List r0 = r0.getProducts()
            if (r0 == 0) goto L_0x0082
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x0082
            boolean r0 = r0.isOffersForYouEnabled()
            if (r0 != r4) goto L_0x0082
            r1 = 1
        L_0x0082:
            if (r1 == 0) goto L_0x0098
            android.content.Context r0 = r5.getContext()
            if (r0 != 0) goto L_0x008d
            kotlin.g.b.k.a()
        L_0x008d:
            int r1 = net.one97.paytm.recharge.R.string.offers_and_plans_text
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "context!!.getString(R.st…ng.offers_and_plans_text)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
        L_0x0098:
            int r0 = net.one97.paytm.recharge.R.color.color_00b9f5
            net.one97.paytm.recharge.dth.a.g$i r1 = new net.one97.paytm.recharge.dth.a.g$i
            r1.<init>(r5, r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r2.a(r3, r0, r1)
            return
        L_0x00a5:
            kotlin.u r6 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8"
            r6.<init>(r0)
            throw r6
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.b(java.util.List):void");
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f62701b;

        i(g gVar, List list) {
            this.f62700a = gVar;
            this.f62701b = list;
        }

        public final void onClick(View view) {
            CustomInputLinearLayout g2;
            CJRProductList productList;
            List<CJRProductsItem> products;
            CJRProductsItem cJRProductsItem;
            CJRProductList productList2;
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            if (!com.paytm.utility.b.c((Context) this.f62700a.getActivity())) {
                this.f62700a.J();
                return;
            }
            net.one97.paytm.recharge.common.h.g h2 = this.f62700a.f61339f;
            if (!(h2 == null || (dVar = h2.v) == null)) {
                StringBuilder sb = new StringBuilder();
                String upperCase = "dth".toUpperCase();
                kotlin.g.b.k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                sb.append(upperCase);
                sb.append(" (new)");
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, sb.toString(), "Browse Plans_dropdown_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            CJRRechargeData cJRRechargeData = new CJRRechargeData();
            boolean z = false;
            cJRRechargeData.setOperator(((CJRProductsItem) this.f62701b.get(0)).getOperatorLabel());
            cJRRechargeData.setOperatorDisplay(((CJRProductsItem) this.f62701b.get(0)).getOperatorDisplayLabel());
            Long productId = ((CJRProductsItem) this.f62701b.get(0)).getProductId();
            List<CJRProductsItem> list = null;
            cJRRechargeData.setProductId(productId != null ? String.valueOf(productId.longValue()) : null);
            cJRRechargeData.setCircle(StringSet.all);
            CJRItem i2 = this.f62700a.f61340g;
            String uRLType = i2 != null ? i2.getURLType() : null;
            CustomInputLinearLayout g3 = this.f62700a.r;
            if (!(g3 == null || (productList2 = g3.getProductList()) == null)) {
                list = productList2.getProducts();
            }
            Collection collection = list;
            if (!((collection == null || collection.isEmpty()) || (g2 = this.f62700a.r) == null || (productList = g2.getProductList()) == null || (products = productList.getProducts()) == null || (cJRProductsItem = products.get(0)) == null || !cJRProductsItem.isOffersForYouEnabled())) {
                z = true;
            }
            g gVar = this.f62700a;
            if (uRLType == null) {
                uRLType = "";
            }
            gVar.a(cJRRechargeData, uRLType, z, this.f62700a.Z());
        }
    }

    public final boolean B() {
        boolean B2 = super.B();
        W();
        if (this.R == null) {
            V();
        }
        return B2;
    }

    public final void x() {
        Context context = getContext();
        if (context != null) {
            kotlin.g.b.k.a((Object) context, "it");
            this.r = new CustomDthInputLayout(context);
        }
    }

    public final void l() {
        t();
        A();
    }

    public final void onStop() {
        this.Y = true;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        new net.one97.paytm.recharge.common.utils.t(activity).a();
        super.onStop();
    }

    public final void onStart() {
        boolean z2;
        super.onStart();
        if (this.Y && (z2 = this.X)) {
            this.Y = false;
            e(z2);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0004: MOVE  (r0v1 java.util.Collection) = 
          (r0v0 java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    private void X() {
        /*
            r13 = this;
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r0 = r13.F
            if (r0 == 0) goto L_0x00db
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x00db
            boolean r1 = r0.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x00db
            java.util.List r0 = (java.util.List) r0
            net.one97.paytm.recharge.common.h.g r1 = r13.f61339f
            if (r1 == 0) goto L_0x00db
            net.one97.paytm.recharge.common.h.g r1 = r13.f61339f
            boolean r1 = r1 instanceof net.one97.paytm.recharge.dth.c.a
            r2 = 0
            java.lang.String r3 = "null cannot be cast to non-null type net.one97.paytm.recharge.dth.viewmodel.CJRDTHRechargeViewModel"
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.recharge.common.h.g r1 = r13.f61339f
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.recharge.ordersummary.h.d r4 = r1.v
            if (r4 == 0) goto L_0x004e
            net.one97.paytm.recharge.common.h.g r1 = r13.f61339f
            if (r1 == 0) goto L_0x0048
            net.one97.paytm.recharge.dth.c.a r1 = (net.one97.paytm.recharge.dth.c.a) r1
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r1.b()
            r5 = r1
            goto L_0x0036
        L_0x0035:
            r5 = r2
        L_0x0036:
            if (r5 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 124(0x7c, float:1.74E-43)
            java.lang.String r6 = "new_recharge_clicked"
            net.one97.paytm.recharge.ordersummary.h.d.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x004e
        L_0x0048:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r3)
            throw r0
        L_0x004e:
            net.one97.paytm.recharge.common.c.e r1 = new net.one97.paytm.recharge.common.c.e
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r4 = new net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b
            r4.<init>()
            int r5 = net.one97.paytm.recharge.R.string.select_operator
            java.lang.String r5 = r13.getString(r5)
            java.lang.String r6 = "getString(R.string.select_operator)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r4 = r4.a((java.lang.String) r5)
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$a r5 = net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8.f61954f
            int r5 = net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8.k
            r4.f61970h = r5
            r5 = 0
            r4.f61964b = r5
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.a.k.c(r0)
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r0 = r4.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>) r0)
            r4 = r13
            net.one97.paytm.recharge.common.e.o r4 = (net.one97.paytm.recharge.common.e.o) r4
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r0 = r0.a((net.one97.paytm.recharge.common.e.o) r4)
            r1.<init>(r0)
            r13.G = r1
            net.one97.paytm.recharge.common.c.e r0 = r13.G
            if (r0 == 0) goto L_0x008f
            r0 = r13
            net.one97.paytm.recharge.common.c.e$b r0 = (net.one97.paytm.recharge.common.c.e.b) r0
            net.one97.paytm.recharge.common.c.e.a((net.one97.paytm.recharge.common.c.e.b) r0)
        L_0x008f:
            net.one97.paytm.recharge.common.c.e r0 = r13.G
            if (r0 == 0) goto L_0x0096
            r0.setCancelable(r5)
        L_0x0096:
            net.one97.paytm.recharge.common.c.e r0 = r13.G
            if (r0 == 0) goto L_0x00a8
            androidx.fragment.app.j r1 = r13.getChildFragmentManager()
            java.lang.String r4 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = "select_operator"
            r0.show(r1, r4)
        L_0x00a8:
            net.one97.paytm.recharge.common.h.g r0 = r13.f61339f
            boolean r0 = r0 instanceof net.one97.paytm.recharge.dth.c.a
            if (r0 == 0) goto L_0x00db
            net.one97.paytm.recharge.common.h.g r0 = r13.f61339f
            if (r0 == 0) goto L_0x00db
            net.one97.paytm.recharge.ordersummary.h.d r4 = r0.v
            if (r4 == 0) goto L_0x00db
            net.one97.paytm.recharge.common.h.g r0 = r13.f61339f
            if (r0 == 0) goto L_0x00d5
            net.one97.paytm.recharge.dth.c.a r0 = (net.one97.paytm.recharge.dth.c.a) r0
            if (r0 == 0) goto L_0x00c2
            java.lang.Object r2 = r0.b()
        L_0x00c2:
            r5 = r2
            if (r5 != 0) goto L_0x00c8
            kotlin.g.b.k.a()
        L_0x00c8:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 124(0x7c, float:1.74E-43)
            java.lang.String r6 = "operator_selection_popup"
            net.one97.paytm.recharge.ordersummary.h.d.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        L_0x00d5:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r3)
            throw r0
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.X():void");
    }

    private final void a(CJRAggsItem cJRAggsItem) {
        int i2;
        CustomInputLinearLayout customInputLinearLayout;
        View childAt;
        c(false);
        this.z = cJRAggsItem.getValue();
        View view = null;
        CJRDthRechargeHeaderModel cJRDthRechargeHeaderModel = new CJRDthRechargeHeaderModel((String) null, cJRAggsItem.getDisplayValue(), cJRAggsItem.getImageUrl());
        if (this.w != null) {
            a(cJRAggsItem.getProductList(), false);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            CustomInputLinearLayout customInputLinearLayout2 = this.r;
            if (customInputLinearLayout2 != null) {
                view = customInputLinearLayout2.a("recharge_number");
            }
            if (view != null) {
                view.postDelayed(new s(view, activity), 500);
            }
        }
        LinearLayout linearLayout = (LinearLayout) b(R.id.main_content_layout);
        if (linearLayout != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity2, "activity!!");
            linearLayout.addView(new CJRDTHRechargeHeaderView(activity2, cJRDthRechargeHeaderModel, this), 0);
        }
        Button button = (Button) b(R.id.btn_proceed_dth);
        if (button != null) {
            button.setText(getString(R.string.proceed_btn_prepaid));
        }
        CustomInputLinearLayout customInputLinearLayout3 = this.r;
        if (customInputLinearLayout3 != null) {
            i2 = customInputLinearLayout3.getChildCount();
        } else {
            i2 = 0;
        }
        if (i2 > 0 && (customInputLinearLayout = this.r) != null && (childAt = customInputLinearLayout.getChildAt(0)) != null) {
            childAt.requestFocus();
        }
    }

    static final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f62716a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f62717b;

        s(View view, FragmentActivity fragmentActivity) {
            this.f62716a = view;
            this.f62717b = fragmentActivity;
        }

        public final void run() {
            if (this.f62716a != null) {
                FragmentActivity fragmentActivity = this.f62717b;
                kotlin.g.b.k.a((Object) fragmentActivity, "it");
                new net.one97.paytm.recharge.common.utils.t(fragmentActivity);
                net.one97.paytm.recharge.common.utils.t.b(this.f62716a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = r1.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(net.one97.paytm.recharge.model.v4.CJRAggsItem r10, boolean r11) {
        /*
            r9 = this;
            r0 = 1
            r9.M = r0
            java.util.List r1 = r10.getProductList()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0018
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            if (r1 == 0) goto L_0x0018
            java.util.List r1 = r1.getInputFields()
            goto L_0x0019
        L_0x0018:
            r1 = r3
        L_0x0019:
            if (r1 == 0) goto L_0x012e
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r0
            if (r4 != r0) goto L_0x012e
            net.one97.paytm.recharge.common.h.g r4 = r9.f61339f
            if (r4 == 0) goto L_0x002c
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.m
            goto L_0x002d
        L_0x002c:
            r4 = r3
        L_0x002d:
            if (r4 != 0) goto L_0x0032
            kotlin.g.b.k.a()
        L_0x0032:
            java.lang.Object r1 = r1.get(r2)
            if (r1 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r1
            java.lang.String r1 = r1.getConfigKey()
            if (r1 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            java.lang.Object r1 = r4.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x005a
            boolean r4 = kotlin.m.p.a(r4)
            if (r4 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r4 = 0
            goto L_0x005b
        L_0x005a:
            r4 = 1
        L_0x005b:
            if (r4 != 0) goto L_0x012e
            r9.u = r1
            net.one97.paytm.recharge.common.h.g r4 = r9.f61339f
            if (r4 == 0) goto L_0x009a
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r5 = r9.r
            if (r5 == 0) goto L_0x0072
            android.widget.EditText r5 = r5.getMBillAmountEdt()
            if (r5 == 0) goto L_0x0072
            android.text.Editable r5 = r5.getText()
            goto L_0x0073
        L_0x0072:
            r5 = r3
        L_0x0073:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r6 = r9.r
            if (r6 == 0) goto L_0x0080
            java.lang.String r6 = r6.getGroupFieldInputValue()
            goto L_0x0081
        L_0x0080:
            r6 = r3
        L_0x0081:
            if (r6 != 0) goto L_0x0086
            kotlin.g.b.k.a()
        L_0x0086:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r7 = r9.r
            if (r7 == 0) goto L_0x008f
            java.lang.String r7 = r7.getInputFieldValues()
            goto L_0x0090
        L_0x008f:
            r7 = r3
        L_0x0090:
            if (r7 != 0) goto L_0x0095
            kotlin.g.b.k.a()
        L_0x0095:
            java.lang.String r8 = r9.l
            r4.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8)
        L_0x009a:
            java.lang.String r4 = r10.getValue()
            r9.z = r4
            r9.B = r1
            net.one97.paytm.recharge.common.h.g r4 = r9.f61339f
            if (r4 == 0) goto L_0x00a8
            r4.D = r0
        L_0x00a8:
            if (r11 == 0) goto L_0x00ac
            r9.m = r0
        L_0x00ac:
            net.one97.paytm.recharge.model.v4.CJRDthRechargeHeaderModel r11 = new net.one97.paytm.recharge.model.v4.CJRDthRechargeHeaderModel
            java.lang.String r4 = r10.getDisplayValue()
            java.lang.String r5 = r10.getImageUrl()
            r11.<init>(r1, r4, r5)
            java.util.List r10 = r10.getProductList()
            r9.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem>) r10, (boolean) r0)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r10 = r9.r
            if (r10 == 0) goto L_0x0126
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r10 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r10
            java.lang.String r10 = r10.getAmount()
            if (r10 == 0) goto L_0x00d5
            boolean r10 = net.one97.paytm.recharge.common.utils.g.c(r10)
            if (r10 != r0) goto L_0x00d5
            r9.g((boolean) r0)
        L_0x00d5:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x00f1
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r9.r
            if (r0 == 0) goto L_0x00e3
            android.widget.EditText r3 = r0.getMBillAmountEdt()
        L_0x00e3:
            if (r3 == 0) goto L_0x00f1
            net.one97.paytm.recharge.dth.a.g$r r0 = new net.one97.paytm.recharge.dth.a.g$r
            r0.<init>(r3, r10)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r4 = 500(0x1f4, double:2.47E-321)
            r3.postDelayed(r0, r4)
        L_0x00f1:
            int r10 = net.one97.paytm.recharge.R.id.main_content_layout
            android.view.View r10 = r9.b((int) r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x0118
            net.one97.paytm.recharge.dth.widget.CJRDTHRechargeHeaderView r0 = new net.one97.paytm.recharge.dth.widget.CJRDTHRechargeHeaderView
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()
            if (r1 != 0) goto L_0x0106
            kotlin.g.b.k.a()
        L_0x0106:
            java.lang.String r3 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            android.content.Context r1 = (android.content.Context) r1
            r3 = r9
            net.one97.paytm.recharge.dth.widget.CJRDTHRechargeHeaderView$a r3 = (net.one97.paytm.recharge.dth.widget.CJRDTHRechargeHeaderView.a) r3
            r0.<init>(r1, r11, r3)
            android.view.View r0 = (android.view.View) r0
            r10.addView(r0, r2)
        L_0x0118:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r10 = r9.r
            if (r10 == 0) goto L_0x012e
            android.widget.EditText r10 = r10.getMBillAmountEdt()
            if (r10 == 0) goto L_0x012e
            r10.requestFocus()
            return
        L_0x0126:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout"
            r10.<init>(r11)
            throw r10
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.a(net.one97.paytm.recharge.model.v4.CJRAggsItem, boolean):void");
    }

    static final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f62714a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f62715b;

        r(EditText editText, FragmentActivity fragmentActivity) {
            this.f62714a = editText;
            this.f62715b = fragmentActivity;
        }

        public final void run() {
            if (this.f62714a != null) {
                FragmentActivity fragmentActivity = this.f62715b;
                kotlin.g.b.k.a((Object) fragmentActivity, "it");
                new net.one97.paytm.recharge.common.utils.t(fragmentActivity);
                net.one97.paytm.recharge.common.utils.t.b(this.f62714a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r2 = r2.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void J() {
        /*
            r6 = this;
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r0 = r6.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            android.content.Context r2 = r6.getContext()
            r3 = 0
            if (r2 == 0) goto L_0x001c
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x001c
            int r4 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r2 = r2.getString(r4)
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            android.content.Context r4 = r6.getContext()
            if (r4 == 0) goto L_0x0030
            android.content.res.Resources r4 = r4.getResources()
            if (r4 == 0) goto L_0x0030
            int r5 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r4 = r4.getString(r5)
            goto L_0x0031
        L_0x0030:
            r4 = r3
        L_0x0031:
            net.one97.paytm.recharge.common.utils.az.a(r0, r1, r3, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.J():void");
    }

    public final void R() {
        if (this.J) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (activity2 instanceof AJRRechargeUtilityActivity)) {
            ((AJRRechargeUtilityActivity) activity2).onBackPressed();
        }
    }

    public final void G() {
        String str;
        CJRCart cart;
        String amount;
        if (((CheckBox) b(R.id.radio_fast_forward_dth)) != null) {
            CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward_dth);
            kotlin.g.b.k.a((Object) checkBox, "radio_fast_forward_dth");
            if (!checkBox.isChecked()) {
                Button button = (Button) b(R.id.btn_proceed_dth);
                if (button != null) {
                    button.setText(getString(R.string.proceed_btn_prepaid));
                    return;
                }
                return;
            }
        }
        if (isAdded() && this.n) {
            CJRUtilityPrefetchV2 H2 = H();
            if (((CheckBox) b(R.id.radio_fast_forward_dth)) != null) {
                CheckBox checkBox2 = (CheckBox) b(R.id.radio_fast_forward_dth);
                kotlin.g.b.k.a((Object) checkBox2, "radio_fast_forward_dth");
                if (checkBox2.isChecked()) {
                    CustomInputLinearLayout customInputLinearLayout = this.r;
                    if (customInputLinearLayout == null || (amount = customInputLinearLayout.getAmount()) == null || !kotlin.m.p.a(amount)) {
                        CustomInputLinearLayout customInputLinearLayout2 = this.r;
                        String str2 = null;
                        if (customInputLinearLayout2 != null) {
                            str = customInputLinearLayout2.getAmount();
                        } else {
                            str = null;
                        }
                        if (!kotlin.m.p.a("0", str, true)) {
                            if (this.o != null) {
                                Button button2 = (Button) b(R.id.btn_proceed_dth);
                                kotlin.g.b.k.a((Object) button2, "btn_proceed_dth");
                                Resources resources = getResources();
                                int i2 = R.string.proceed_btn_ff_selected;
                                Object[] objArr = new Object[1];
                                CJRRechargeCart cJRRechargeCart = this.o;
                                if (!(cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null)) {
                                    str2 = cart.getFinalPrice();
                                }
                                objArr[0] = str2;
                                button2.setText(resources.getString(i2, objArr));
                                return;
                            }
                            Button button3 = (Button) b(R.id.btn_proceed_dth);
                            kotlin.g.b.k.a((Object) button3, "btn_proceed_dth");
                            Resources resources2 = getResources();
                            int i3 = R.string.proceed_btn_ff_selected;
                            Object[] objArr2 = new Object[1];
                            CustomInputLinearLayout customInputLinearLayout3 = this.r;
                            if (customInputLinearLayout3 != null) {
                                str2 = customInputLinearLayout3.getAmount();
                            }
                            objArr2[0] = str2;
                            button3.setText(resources2.getString(i3, objArr2));
                            return;
                        }
                    }
                    if (H2 == null) {
                        Button button4 = (Button) b(R.id.btn_proceed_dth);
                        kotlin.g.b.k.a((Object) button4, "btn_proceed_dth");
                        button4.setText(getResources().getString(R.string.utility_proceed));
                        return;
                    } else if (this.o != null) {
                        Button button5 = (Button) b(R.id.btn_proceed_dth);
                        kotlin.g.b.k.a((Object) button5, "btn_proceed_dth");
                        button5.setText(H2.getPost());
                        return;
                    } else {
                        Button button6 = (Button) b(R.id.btn_proceed_dth);
                        kotlin.g.b.k.a((Object) button6, "btn_proceed_dth");
                        button6.setText(H2.getPre());
                        return;
                    }
                }
            }
            if (H2 == null) {
                Button button7 = (Button) b(R.id.btn_proceed_dth);
                kotlin.g.b.k.a((Object) button7, "btn_proceed_dth");
                button7.setText(getResources().getString(R.string.utility_proceed));
            } else if (this.o != null) {
                Button button8 = (Button) b(R.id.btn_proceed_dth);
                kotlin.g.b.k.a((Object) button8, "btn_proceed_dth");
                button8.setText(H2.getPost());
            } else {
                Button button9 = (Button) b(R.id.btn_proceed_dth);
                kotlin.g.b.k.a((Object) button9, "btn_proceed_dth");
                button9.setText(H2.getPre());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r1 = r1.getCategoryId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F() {
        /*
            r3 = this;
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L_0x0042
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 != 0) goto L_0x0011
            kotlin.g.b.k.a()
        L_0x0011:
            java.lang.String r1 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.recharge.model.v4.CJRCategoryData r1 = r3.w
            if (r1 == 0) goto L_0x002b
            java.lang.Long r1 = r1.getCategoryId()
            if (r1 == 0) goto L_0x002b
            long r1 = r1.longValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            boolean r0 = net.one97.paytm.recharge.common.utils.az.e(r0, r1)
            if (r0 == 0) goto L_0x0042
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward_dth
            android.view.View r0 = r3.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x0041
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
        L_0x0041:
            return
        L_0x0042:
            boolean r0 = r3.f61341h
            if (r0 == 0) goto L_0x0089
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r3.r
            if (r0 == 0) goto L_0x0089
            boolean r0 = r0.j()
            r1 = 1
            if (r0 != r1) goto L_0x0089
            int r0 = net.one97.paytm.recharge.R.id.lyt_fast_forward_dth
            android.view.View r0 = r3.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x0060
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
        L_0x0060:
            boolean r0 = r3.m
            r2 = 0
            if (r0 == 0) goto L_0x0078
            int r0 = net.one97.paytm.recharge.R.id.radio_fast_forward_dth
            android.view.View r0 = r3.b((int) r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            if (r0 == 0) goto L_0x0072
            r0.setChecked(r1)
        L_0x0072:
            r3.G()
            r3.m = r2
            return
        L_0x0078:
            int r0 = net.one97.paytm.recharge.R.id.radio_fast_forward_dth
            android.view.View r0 = r3.b((int) r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            if (r0 == 0) goto L_0x0085
            r0.setChecked(r2)
        L_0x0085:
            r3.G()
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.F():void");
    }

    /* JADX WARNING: type inference failed for: r1v10, types: [net.one97.paytm.recharge.common.h.g] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L_0x000c
            int r1 = r14.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed_dth
            r3 = 17
            if (r1 != 0) goto L_0x0015
            goto L_0x00d8
        L_0x0015:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x00d8
            boolean r14 = r13.K
            java.lang.String r1 = "radio_fast_forward_dth"
            r2 = 1
            if (r14 != r2) goto L_0x004b
            int r14 = net.one97.paytm.recharge.R.id.radio_fast_forward_dth
            android.view.View r14 = r13.b((int) r14)
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            if (r14 == 0) goto L_0x0044
            int r14 = net.one97.paytm.recharge.R.id.radio_fast_forward_dth
            android.view.View r14 = r13.b((int) r14)
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            boolean r14 = r14.isChecked()
            if (r14 == 0) goto L_0x0044
            net.one97.paytm.recharge.ordersummary.h.d$a r14 = net.one97.paytm.recharge.ordersummary.h.d.f64339c
            java.lang.String r0 = net.one97.paytm.recharge.ordersummary.h.d.j
            goto L_0x0075
        L_0x0044:
            net.one97.paytm.recharge.ordersummary.h.d$a r14 = net.one97.paytm.recharge.ordersummary.h.d.f64339c
            java.lang.String r0 = net.one97.paytm.recharge.ordersummary.h.d.k
            goto L_0x0075
        L_0x004b:
            if (r14 != 0) goto L_0x0075
            int r14 = net.one97.paytm.recharge.R.id.radio_fast_forward_dth
            android.view.View r14 = r13.b((int) r14)
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            if (r14 == 0) goto L_0x006f
            int r14 = net.one97.paytm.recharge.R.id.radio_fast_forward_dth
            android.view.View r14 = r13.b((int) r14)
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            boolean r14 = r14.isChecked()
            if (r14 == 0) goto L_0x006f
            net.one97.paytm.recharge.ordersummary.h.d$a r14 = net.one97.paytm.recharge.ordersummary.h.d.f64339c
            java.lang.String r0 = net.one97.paytm.recharge.ordersummary.h.d.f64341h
            goto L_0x0075
        L_0x006f:
            net.one97.paytm.recharge.ordersummary.h.d$a r14 = net.one97.paytm.recharge.ordersummary.h.d.f64339c
            java.lang.String r0 = net.one97.paytm.recharge.ordersummary.h.d.f64342i
        L_0x0075:
            r8 = r0
            net.one97.paytm.recharge.common.h.g r14 = r13.f61339f
            if (r14 == 0) goto L_0x008b
            net.one97.paytm.recharge.ordersummary.h.d r4 = r14.v
            if (r4 == 0) goto L_0x008b
            java.lang.String r7 = r13.I
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 112(0x70, float:1.57E-43)
            java.lang.String r6 = "proceed_clicked"
            r5 = r7
            net.one97.paytm.recharge.ordersummary.h.d.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x008b:
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x009a
            android.view.Window r14 = r14.getWindow()
            if (r14 == 0) goto L_0x009a
            r14.setSoftInputMode(r3)
        L_0x009a:
            java.lang.String r14 = r13.T
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x00ca
            net.one97.paytm.common.entity.CJRRechargeCart r14 = r13.o
            if (r14 == 0) goto L_0x00ca
            net.one97.paytm.recharge.common.utils.o r14 = r13.S
            if (r14 == 0) goto L_0x00ca
            boolean r14 = r14.f61684a
            if (r14 != r2) goto L_0x00ca
            r13.D()
            int r14 = net.one97.paytm.recharge.R.id.btn_proceed_dth
            android.view.View r14 = r13.b((int) r14)
            android.widget.Button r14 = (android.widget.Button) r14
            if (r14 == 0) goto L_0x00c9
            net.one97.paytm.recharge.dth.a.g$o r0 = new net.one97.paytm.recharge.dth.a.g$o
            r0.<init>(r13)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r1 = 300(0x12c, double:1.48E-321)
            r14.postDelayed(r0, r1)
        L_0x00c9:
            return
        L_0x00ca:
            net.one97.paytm.recharge.common.h.g r14 = r13.f61339f
            if (r14 == 0) goto L_0x00d4
            net.one97.paytm.recharge.common.utils.w r14 = r14.t
            if (r14 == 0) goto L_0x00d4
            r14.o = r2
        L_0x00d4:
            r13.y()
            return
        L_0x00d8:
            int r2 = net.one97.paytm.recharge.R.id.txt_promo_enabled
            if (r1 != 0) goto L_0x00dd
            goto L_0x010a
        L_0x00dd:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x010a
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x00f2
            android.view.Window r14 = r14.getWindow()
            if (r14 == 0) goto L_0x00f2
            r14.setSoftInputMode(r3)
        L_0x00f2:
            boolean r14 = super.B()
            if (r14 == 0) goto L_0x0109
            net.one97.paytm.recharge.common.utils.o r14 = r13.S
            if (r14 == 0) goto L_0x0102
            org.json.JSONObject r0 = r13.ac()
            r14.f61686c = r0
        L_0x0102:
            net.one97.paytm.recharge.common.utils.o r14 = r13.S
            if (r14 == 0) goto L_0x0109
            r14.c()
        L_0x0109:
            return
        L_0x010a:
            int r2 = net.one97.paytm.recharge.R.id.lyt_remove_promo
            r3 = 0
            java.lang.String r4 = "it"
            if (r1 != 0) goto L_0x0112
            goto L_0x016e
        L_0x0112:
            int r5 = r1.intValue()
            if (r5 != r2) goto L_0x016e
            java.lang.String r14 = ""
            r13.T = r14
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x0132
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            android.content.Context r14 = (android.content.Context) r14
            boolean r14 = com.paytm.utility.b.c((android.content.Context) r14)
            if (r14 != 0) goto L_0x0132
            r13.J()
            return
        L_0x0132:
            org.json.JSONObject r8 = r13.ac()
            net.one97.paytm.recharge.widgets.c.d r14 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            int r14 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r14 = r13.b((int) r14)
            android.widget.Button r14 = (android.widget.Button) r14
            if (r14 == 0) goto L_0x0149
            r14.setEnabled(r3)
        L_0x0149:
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x016d
            r13.D()
            net.one97.paytm.recharge.common.h.g r1 = r13.f61339f
            boolean r2 = r1 instanceof net.one97.paytm.recharge.dth.c.a
            if (r2 != 0) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            r0 = r1
        L_0x015a:
            r5 = r0
            net.one97.paytm.recharge.dth.c.a r5 = (net.one97.paytm.recharge.dth.c.a) r5
            if (r5 == 0) goto L_0x016d
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r6 = r14
            android.content.Context r6 = (android.content.Context) r6
            r9 = r13
            net.one97.paytm.recharge.common.e.ai r9 = (net.one97.paytm.recharge.common.e.ai) r9
            java.lang.String r7 = "remove_promo_verify"
            r5.a((android.content.Context) r6, (java.lang.String) r7, (org.json.JSONObject) r8, (net.one97.paytm.recharge.common.e.ai) r9, (java.lang.Object) r10)
        L_0x016d:
            return
        L_0x016e:
            int r2 = net.one97.paytm.recharge.R.id.txt_promo_applied
            if (r1 != 0) goto L_0x0173
            goto L_0x01d7
        L_0x0173:
            int r5 = r1.intValue()
            if (r5 != r2) goto L_0x01d7
            net.one97.paytm.recharge.model.CJRPromoCode r14 = r13.U
            if (r14 == 0) goto L_0x027e
            if (r14 == 0) goto L_0x0184
            java.lang.String r14 = r14.getTerms()
            goto L_0x0185
        L_0x0184:
            r14 = r0
        L_0x0185:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x027e
            net.one97.paytm.recharge.mobile_v3.a.d r14 = new net.one97.paytm.recharge.mobile_v3.a.d
            r14.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            int r2 = net.one97.paytm.recharge.R.string.mobile_offer_detail_dialog_title
            java.lang.String r2 = r13.getString(r2)
            java.lang.String r3 = "tnc_title"
            r1.putString(r3, r2)
            net.one97.paytm.recharge.model.CJRPromoCode r2 = r13.U
            if (r2 == 0) goto L_0x01ab
            java.lang.String r2 = r2.getCode()
            goto L_0x01ac
        L_0x01ab:
            r2 = r0
        L_0x01ac:
            java.lang.String r3 = "coupon_code_extra"
            r1.putString(r3, r2)
            net.one97.paytm.recharge.model.CJRPromoCode r2 = r13.U
            if (r2 == 0) goto L_0x01b9
            java.lang.String r0 = r2.getTerms()
        L_0x01b9:
            java.lang.String r2 = "tnc_text"
            r1.putString(r2, r0)
            r14.setArguments(r1)
            boolean r0 = r14.isAdded()
            if (r0 != 0) goto L_0x027e
            androidx.fragment.app.j r0 = r13.getChildFragmentManager()
            java.lang.Class r1 = r13.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            r14.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            return
        L_0x01d7:
            int r2 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            if (r1 != 0) goto L_0x01dc
            return
        L_0x01dc:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x027e
            if (r14 == 0) goto L_0x01ed
            net.one97.paytm.recharge.widgets.c.e r1 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            boolean r14 = r1.validateIsAlreadyClicked(r14)
            if (r14 == 0) goto L_0x01ed
            return
        L_0x01ed:
            net.one97.paytm.common.entity.CJRRechargeCart r14 = r13.o
            if (r14 != 0) goto L_0x027b
            android.content.Context r14 = r13.getContext()
            boolean r14 = com.paytm.utility.b.c((android.content.Context) r14)
            if (r14 != 0) goto L_0x01ff
            r13.J()
            return
        L_0x01ff:
            boolean r14 = r13.B()
            if (r14 == 0) goto L_0x0267
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x0222
            android.content.Context r14 = (android.content.Context) r14
            boolean r14 = com.paytm.utility.d.c(r14)
            if (r14 != 0) goto L_0x0222
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            android.app.Activity r14 = (android.app.Activity) r14
            r0 = r13
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            r1 = 31
            net.one97.paytm.recharge.common.utils.z.a((android.app.Activity) r14, (androidx.fragment.app.Fragment) r0, (int) r1)
            return
        L_0x0222:
            int r14 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r14 = r13.b((int) r14)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r14 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r14
            if (r14 == 0) goto L_0x022f
            r14.setEnabled(r3)
        L_0x022f:
            int r14 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r14 = r13.b((int) r14)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r14 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r14
            if (r14 == 0) goto L_0x023c
            r14.a()
        L_0x023c:
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x0266
            net.one97.paytm.recharge.common.h.g r1 = r13.f61339f
            boolean r2 = r1 instanceof net.one97.paytm.recharge.dth.c.a
            if (r2 != 0) goto L_0x0249
            r1 = r0
        L_0x0249:
            r5 = r1
            net.one97.paytm.recharge.dth.c.a r5 = (net.one97.paytm.recharge.dth.c.a) r5
            if (r5 == 0) goto L_0x0266
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            r6 = r14
            android.content.Context r6 = (android.content.Context) r6
            org.json.JSONObject r8 = r13.ac()
            r9 = r13
            net.one97.paytm.recharge.common.e.ai r9 = (net.one97.paytm.recharge.common.e.ai) r9
            net.one97.paytm.recharge.widgets.c.d r14 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            java.lang.String r7 = "dth_pre_verify"
            r5.a((android.content.Context) r6, (java.lang.String) r7, (org.json.JSONObject) r8, (net.one97.paytm.recharge.common.e.ai) r9, (java.lang.Object) r10)
        L_0x0266:
            return
        L_0x0267:
            androidx.fragment.app.FragmentActivity r14 = r13.getActivity()
            if (r14 == 0) goto L_0x027a
            net.one97.paytm.recharge.common.utils.t r0 = new net.one97.paytm.recharge.common.utils.t
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            android.app.Activity r14 = (android.app.Activity) r14
            r0.<init>(r14)
            r0.a()
        L_0x027a:
            return
        L_0x027b:
            r13.ad()
        L_0x027e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.onClick(android.view.View):void");
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62709a;

        o(g gVar) {
            this.f62709a = gVar;
        }

        public final void run() {
            net.one97.paytm.recharge.common.utils.o k = this.f62709a.S;
            if (k != null) {
                CJRRechargeCart a2 = this.f62709a.o;
                if (a2 == null) {
                    kotlin.g.b.k.a();
                }
                k.a(a2, (CJRRechargePayment) null);
            }
            this.f62709a.t();
        }
    }

    public final void D() {
        Button button = (Button) b(R.id.btn_proceed_dth);
        if (button != null) {
            net.one97.paytm.recharge.common.utils.ai.b(button);
        }
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.loading_threedots_view_dth);
        if (relativeLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.a(relativeLayout);
        }
        ba.a((LottieAnimationView) (CJRRechargeLottieAnimationView) b(R.id.loading_threedots_lav_dth));
        FrameLayout frameLayout = (FrameLayout) b(R.id.transparent_view);
        if (frameLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.a(frameLayout);
        }
    }

    public final void t() {
        Button button = (Button) b(R.id.btn_proceed_dth);
        if (button != null) {
            net.one97.paytm.recharge.common.utils.ai.a(button);
        }
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.loading_threedots_view_dth);
        if (relativeLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.b(relativeLayout);
        }
        ba.b((LottieAnimationView) (CJRRechargeLottieAnimationView) b(R.id.loading_threedots_lav_dth));
        this.q = false;
        FrameLayout frameLayout = (FrameLayout) b(R.id.transparent_view);
        if (frameLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.b(frameLayout);
        }
    }

    public final void C() {
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward_dth);
        kotlin.g.b.k.a((Object) relativeLayout, "lyt_fast_forward_dth");
        relativeLayout.setVisibility(8);
        CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward_dth);
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        this.n = true;
        G();
        c(true);
    }

    public final void c(boolean z2) {
        if (getActivity() != null && isAdded()) {
            Button button = (Button) b(R.id.btn_proceed_dth);
            if (button != null) {
                button.setEnabled(z2);
            }
            Button button2 = (Button) b(R.id.btn_proceed_dth);
            if (button2 != null) {
                button2.setClickable(z2);
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62694a;

        f(g gVar) {
            this.f62694a = gVar;
        }

        public final void onClick(View view) {
            String str;
            this.f62694a.K = true;
            CheckBox checkBox = (CheckBox) this.f62694a.b(R.id.radio_fast_forward_dth);
            if (checkBox != null) {
                checkBox.toggle();
            }
            net.one97.paytm.recharge.common.h.g h2 = this.f62694a.f61339f;
            if (h2 != null) {
                CustomInputLinearLayout customInputLinearLayout = this.f62694a.r;
                if (customInputLinearLayout == null || (str = customInputLinearLayout.getAmount()) == null) {
                    str = "";
                }
                CheckBox checkBox2 = (CheckBox) this.f62694a.b(R.id.radio_fast_forward_dth);
                boolean isChecked = checkBox2 != null ? checkBox2.isChecked() : false;
                CustomInputLinearLayout g2 = this.f62694a.r;
                String str2 = null;
                String groupFieldInputValue = g2 != null ? g2.getGroupFieldInputValue() : null;
                if (groupFieldInputValue == null) {
                    kotlin.g.b.k.a();
                }
                CustomInputLinearLayout g3 = this.f62694a.r;
                if (g3 != null) {
                    str2 = g3.getInputFieldValues();
                }
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                String o = this.f62694a.l;
                kotlin.g.b.k.c(str, "billAmount");
                kotlin.g.b.k.c(groupFieldInputValue, "groupFieldVal");
                kotlin.g.b.k.c(str2, "inputFieldVal");
                kotlin.g.b.k.c(o, "serviceType");
                net.one97.paytm.recharge.ordersummary.h.d dVar = h2.v;
                kotlin.g.b.k.c(str, "billAmount");
                kotlin.g.b.k.c(groupFieldInputValue, "groupFieldValue");
                kotlin.g.b.k.c(str2, "inputFieldValue");
                kotlin.g.b.k.c(o, "serviceType");
                try {
                    HashMap hashMap = new HashMap();
                    if (!kotlin.m.p.a(str)) {
                        hashMap.put("recharge_utilities_amount", str);
                    }
                    hashMap.put("recharge_utilities_service_type", o);
                    hashMap.put("recharge_utilities_ff_state", isChecked ? "checked" : "unchecked");
                    hashMap.put("recharge_utilities_group_field_values", groupFieldInputValue);
                    hashMap.put("recharge_utilities_input_field_values", str2);
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    net.one97.paytm.recharge.di.helper.b.a(dVar.a(), (Map<String, Object>) hashMap, "recharge_utilities_fast_forward_clicked", dVar.f64344b);
                } catch (Throwable unused) {
                }
            }
            this.f62694a.G();
        }
    }

    public final void f(String str) {
        TextView textView = (TextView) b(R.id.disclaimer_text_readmore_dth);
        kotlin.g.b.k.a((Object) textView, "disclaimer_text_readmore_dth");
        PreventScrollTextView preventScrollTextView = (PreventScrollTextView) b(R.id.meta_data_desc_dth);
        kotlin.g.b.k.a((Object) preventScrollTextView, "meta_data_desc_dth");
        a(str, textView, (TextView) preventScrollTextView);
    }

    public final void a(String str, TextView textView, TextView textView2) {
        kotlin.g.b.k.c(textView, "readMoreView");
        kotlin.g.b.k.c(textView2, "descriptionView");
        if (!i().f61411d) {
            CharSequence charSequence = str;
            boolean z2 = true;
            if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
                textView2.setText(charSequence);
                CharSequence obj = textView2.getText().toString();
                if (kotlin.m.p.a(obj, (CharSequence) "g.co/playtermsin", false)) {
                    int a2 = kotlin.m.p.a(obj, "g.co/playtermsin", 0, false, 6);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    CharSequence text = textView2.getText();
                    if (text != null) {
                        Spannable spannable = (Spannable) text;
                        int i2 = 16 + a2;
                        spannable.setSpan(new FJRRechargeUtilBaseFragment.ExpandedURLSpanNoUnderline(this, "g.co/playtermsin"), a2, i2, 33);
                        Context context = getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        spannable.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.paytm_blue)), a2, i2, 33);
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.text.Spannable");
                    }
                }
                textView2.setMaxLines(2);
                textView2.setVisibility(0);
                textView2.postDelayed(new q(textView2, textView), 300);
                CJRCategoryData categoryData = i().f61409b.getCategoryData();
                String str2 = null;
                CharSequence disclaimerHtml = categoryData != null ? categoryData.getDisclaimerHtml() : null;
                if (disclaimerHtml != null && !kotlin.m.p.a(disclaimerHtml)) {
                    z2 = false;
                }
                if (z2) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    if (categoryData != null) {
                        str2 = categoryData.getDisclaimerHtml();
                    }
                    textView2.setText(Html.fromHtml(str2, 0));
                    return;
                }
                if (categoryData != null) {
                    str2 = categoryData.getDisclaimerHtml();
                }
                textView2.setText(Html.fromHtml(str2));
                return;
            }
            textView2.setVisibility(8);
            textView.setVisibility(8);
        }
    }

    static final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f62711a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f62712b;

        q(TextView textView, TextView textView2) {
            this.f62711a = textView;
            this.f62712b = textView2;
        }

        public final void run() {
            if (this.f62711a.getLineCount() > 2) {
                this.f62712b.setVisibility(0);
                this.f62712b.setOnClickListener(new View.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ q f62713a;

                    {
                        this.f62713a = r1;
                    }

                    public final void onClick(View view) {
                        this.f62713a.f62711a.setMaxLines(Integer.MAX_VALUE);
                        this.f62713a.f62712b.setVisibility(8);
                    }
                });
                TextView textView = this.f62712b;
                textView.setPaintFlags(8 | textView.getPaintFlags());
                return;
            }
            this.f62712b.setVisibility(8);
        }
    }

    public final boolean z() {
        CheckBox checkBox = (CheckBox) b(R.id.radio_fast_forward_dth);
        if (checkBox != null) {
            return checkBox.isChecked();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x018d, code lost:
        if ((r8 == null || r8.length() == 0) != false) goto L_0x018f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRInstruct r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.sendBillFetchSuccessfullEvent
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.recharge.ordersummary.h.d r1 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r0 = r11.getContext()
            if (r0 != 0) goto L_0x000f
            kotlin.g.b.k.a()
        L_0x000f:
            java.lang.String r2 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r1.<init>(r0)
            java.lang.String r2 = r11.I
            net.one97.paytm.recharge.model.v4.CJRInstruct$sendBillFetchSuccessfullEvent r12 = (net.one97.paytm.recharge.model.v4.CJRInstruct.sendBillFetchSuccessfullEvent) r12
            java.lang.String r5 = r12.getLabel()
            java.lang.String r6 = net.one97.paytm.recharge.common.utils.ab.f61496a
            java.lang.String r12 = "CJRRechargeUtilityConstant.UTILITY"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
            r7 = 0
            r8 = 0
            r9 = 96
            java.lang.String r3 = "bill_fetched_successfully"
            java.lang.String r4 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        L_0x0032:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.updateProductResponseOnDTH
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0053
            net.one97.paytm.recharge.dth.widget.CJRDTHRechargeShimmerView r12 = r11.H
            if (r12 == 0) goto L_0x003f
            r12.a(r2)
        L_0x003f:
            int r12 = net.one97.paytm.recharge.R.id.main_content_layout
            android.view.View r12 = r11.b((int) r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x004c
            r12.removeViewAt(r2)
        L_0x004c:
            r11.f((boolean) r1)
            r11.F()
            return
        L_0x0053:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.openSubscriberBottomSheet
            r3 = 0
            if (r0 == 0) goto L_0x010a
            net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet r12 = (net.one97.paytm.recharge.model.v4.CJRInstruct.openSubscriberBottomSheet) r12
            r12.getRechargeCart()
            net.one97.paytm.common.entity.shopping.CJRGroupDisplay r12 = r12.getCjrGroupDisplay()
            r11.t()
            androidx.fragment.app.j r0 = r11.getChildFragmentManager()
            java.lang.String r4 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.String r4 = r11.u
            if (r4 != 0) goto L_0x0098
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = r11.D
            if (r4 == 0) goto L_0x007a
            java.util.List r4 = r4.getInputFields()
            goto L_0x007b
        L_0x007a:
            r4 = r3
        L_0x007b:
            if (r4 != 0) goto L_0x0080
            kotlin.g.b.k.a()
        L_0x0080:
            java.lang.Object r2 = r4.get(r2)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r2 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r2
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = r2.getConfigKey()
            goto L_0x008e
        L_0x008d:
            r2 = r3
        L_0x008e:
            java.util.Map<java.lang.String, java.lang.String> r4 = r11.k
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r11.u = r2
        L_0x0098:
            r11.aa = r1
            int r1 = net.one97.paytm.recharge.R.id.bank_offers_promocode_text_layout
            android.view.View r1 = r11.b((int) r1)
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r1 = (net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3) r1
            if (r1 == 0) goto L_0x00a9
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.b(r1)
        L_0x00a9:
            net.one97.paytm.recharge.dth.a.i$a r1 = net.one97.paytm.recharge.dth.a.i.f62720c
            if (r12 == 0) goto L_0x00b2
            java.util.Map r12 = r12.getValuesMap()
            goto L_0x00b3
        L_0x00b2:
            r12 = r3
        L_0x00b3:
            if (r12 != 0) goto L_0x00b8
            kotlin.g.b.k.a()
        L_0x00b8:
            java.lang.String r1 = r11.u
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed_dth
            android.view.View r2 = r11.b((int) r2)
            android.widget.Button r2 = (android.widget.Button) r2
            if (r2 == 0) goto L_0x00ce
            java.lang.CharSequence r2 = r2.getText()
            if (r2 == 0) goto L_0x00ce
            java.lang.String r3 = r2.toString()
        L_0x00ce:
            r2 = r11
            net.one97.paytm.recharge.dth.a.i$b r2 = (net.one97.paytm.recharge.dth.a.i.b) r2
            java.lang.String r4 = "map"
            kotlin.g.b.k.c(r12, r4)
            net.one97.paytm.recharge.dth.a.i r4 = new net.one97.paytm.recharge.dth.a.i
            r4.<init>()
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r6 = net.one97.paytm.recharge.dth.a.i.f62723f
            java.io.Serializable r12 = (java.io.Serializable) r12
            r5.putSerializable(r6, r12)
            if (r1 == 0) goto L_0x00f2
            java.lang.String r12 = net.one97.paytm.recharge.dth.a.i.f62724g
            r5.putString(r12, r1)
        L_0x00f2:
            if (r3 == 0) goto L_0x00fb
            java.lang.String r12 = net.one97.paytm.recharge.dth.a.i.f62725h
            r5.putString(r12, r3)
        L_0x00fb:
            r4.f62727b = r2
            r4.setArguments(r5)
            java.lang.Class<net.one97.paytm.recharge.dth.a.i> r12 = net.one97.paytm.recharge.dth.a.i.class
            java.lang.String r12 = r12.getSimpleName()
            r4.show((androidx.fragment.app.j) r0, (java.lang.String) r12)
            return
        L_0x010a:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.errorInFetchAmountField
            java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout"
            if (r0 == 0) goto L_0x0137
            r11.O = r2
            r11.ab()
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r12 = r11.r
            boolean r12 = r12 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
            if (r12 == 0) goto L_0x02a0
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r12 = r11.r
            if (r12 == 0) goto L_0x0131
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r12 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r12
            net.one97.paytm.recharge.common.widget.CJRAmountInputFieldWidgetV8 r0 = r12.f61987a
            android.view.View r0 = (android.view.View) r0
            android.widget.TextView r12 = r12.b(r0)
            if (r12 == 0) goto L_0x0130
            android.view.View r12 = (android.view.View) r12
            net.one97.paytm.recharge.common.utils.ai.a(r12)
        L_0x0130:
            return
        L_0x0131:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r4)
            throw r12
        L_0x0137:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.updateAmountField
            if (r0 == 0) goto L_0x0278
            r11.O = r2
            r11.ab()
            net.one97.paytm.recharge.model.v4.CJRInstruct$updateAmountField r12 = (net.one97.paytm.recharge.model.v4.CJRInstruct.updateAmountField) r12
            java.lang.String r0 = r12.getAmount()
            java.lang.Boolean r0 = com.paytm.utility.b.K((java.lang.String) r0)
            if (r0 != 0) goto L_0x014f
            kotlin.g.b.k.a()
        L_0x014f:
            boolean r0 = r0.booleanValue()
            r4 = 0
            if (r0 != 0) goto L_0x0164
            java.lang.String r6 = r12.getAmount()
            double r6 = java.lang.Double.parseDouble(r6)
            double r6 = com.paytm.utility.b.b((double) r6)
            goto L_0x0165
        L_0x0164:
            r6 = r4
        L_0x0165:
            boolean r8 = r11.L
            if (r8 == 0) goto L_0x018f
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r8 = r11.r
            if (r8 == 0) goto L_0x017e
            android.widget.EditText r8 = r8.getMBillAmountEdt()
            if (r8 == 0) goto L_0x017e
            android.text.Editable r8 = r8.getText()
            if (r8 == 0) goto L_0x017e
            java.lang.String r8 = r8.toString()
            goto L_0x017f
        L_0x017e:
            r8 = r3
        L_0x017f:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x018c
            int r8 = r8.length()
            if (r8 != 0) goto L_0x018a
            goto L_0x018c
        L_0x018a:
            r8 = 0
            goto L_0x018d
        L_0x018c:
            r8 = 1
        L_0x018d:
            if (r8 == 0) goto L_0x01df
        L_0x018f:
            if (r0 != 0) goto L_0x01bf
            java.lang.String r8 = r12.getAmount()
            double r8 = java.lang.Double.parseDouble(r8)
            double r8 = com.paytm.utility.b.b((double) r8)
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x01df
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r11.r
            if (r4 == 0) goto L_0x01ac
            java.lang.String r5 = java.lang.String.valueOf(r8)
            r4.setAmountOnAmountField(r5)
        L_0x01ac:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r11.r
            if (r4 == 0) goto L_0x01b3
            r4.setAmountFieldInlineMessage()
        L_0x01b3:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r11.r
            if (r4 == 0) goto L_0x01df
            java.lang.String r5 = java.lang.String.valueOf(r8)
            r4.setAmountFetchMessage(r5)
            goto L_0x01df
        L_0x01bf:
            java.lang.String r4 = r12.getAmount()
            int r4 = java.lang.Integer.parseInt(r4)
            if (r4 <= 0) goto L_0x01df
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r11.r
            if (r4 == 0) goto L_0x01d4
            java.lang.String r5 = r12.getAmount()
            r4.setAmountOnAmountField(r5)
        L_0x01d4:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r4 = r11.r
            if (r4 == 0) goto L_0x01df
            java.lang.String r5 = r12.getAmount()
            r4.setAmountFetchMessage(r5)
        L_0x01df:
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r12.getCjrRechargeCart()
            r11.b((net.one97.paytm.common.entity.CJRRechargeCart) r4)
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r12.getCjrRechargeCart()
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()
            if (r4 == 0) goto L_0x01f5
            java.util.ArrayList r4 = r4.getCartItems()
            goto L_0x01f6
        L_0x01f5:
            r4 = r3
        L_0x01f6:
            if (r4 == 0) goto L_0x0277
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r12.getCjrRechargeCart()
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()
            if (r4 == 0) goto L_0x0277
            java.util.ArrayList r4 = r4.getCartItems()
            if (r4 == 0) goto L_0x0277
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r1
            if (r4 != r1) goto L_0x0277
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r12.getCjrRechargeCart()
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()
            if (r4 == 0) goto L_0x021f
            java.util.ArrayList r3 = r4.getCartItems()
        L_0x021f:
            if (r3 != 0) goto L_0x0224
            kotlin.g.b.k.a()
        L_0x0224:
            java.lang.Object r2 = r3.get(r2)
            java.lang.String r3 = "cjrInstruct.cjrRechargeCart.cart?.cartItems!![0]"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2
            java.util.Map r2 = r2.getConfigurationList()
            java.lang.String r3 = "configurationList"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            boolean r3 = r2.isEmpty()
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x0277
            java.lang.String r1 = "recharge_number"
            boolean r3 = r2.containsKey(r1)
            if (r3 == 0) goto L_0x0277
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0277
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.CJRAmountPreFetchDetails> r2 = r11.P
            java.util.Map r2 = (java.util.Map) r2
            if (r1 != 0) goto L_0x025f
            kotlin.g.b.k.a()
        L_0x025f:
            net.one97.paytm.recharge.model.CJRAmountPreFetchDetails r3 = new net.one97.paytm.recharge.model.CJRAmountPreFetchDetails
            if (r0 == 0) goto L_0x0268
            java.lang.String r0 = r12.getAmount()
            goto L_0x026c
        L_0x0268:
            java.lang.String r0 = java.lang.String.valueOf(r6)
        L_0x026c:
            net.one97.paytm.common.entity.CJRRechargeCart r12 = r12.getCjrRechargeCart()
            r3.<init>(r0, r12, r1)
            r2.put(r1, r3)
        L_0x0277:
            return
        L_0x0278:
            boolean r0 = r12 instanceof net.one97.paytm.recharge.model.v4.CJRInstruct.showNotMandatoryFields
            if (r0 == 0) goto L_0x029d
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            boolean r0 = r0 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
            if (r0 == 0) goto L_0x0299
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            if (r0 == 0) goto L_0x0293
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r0 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r0
            r1 = r12
            net.one97.paytm.recharge.model.v4.CJRInstruct$showNotMandatoryFields r1 = (net.one97.paytm.recharge.model.v4.CJRInstruct.showNotMandatoryFields) r1
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r1.getCjrRechargeCart()
            r0.setRechargeCartResponse(r1)
            goto L_0x0299
        L_0x0293:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r4)
            throw r12
        L_0x0299:
            super.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r12)
            return
        L_0x029d:
            super.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r12)
        L_0x02a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.a(net.one97.paytm.recharge.model.v4.CJRInstruct):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r0 = (r0 = r0.getAttributes()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRAggsItem r3, int r4) {
        /*
            r2 = this;
            java.lang.String r4 = "operatorItem"
            kotlin.g.b.k.c(r3, r4)
            net.one97.paytm.recharge.common.c.e r4 = r2.G
            if (r4 == 0) goto L_0x000c
            r4.dismiss()
        L_0x000c:
            net.one97.paytm.recharge.common.h.g r4 = r2.f61339f
            if (r4 == 0) goto L_0x0058
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.m
            if (r4 == 0) goto L_0x0058
            r4.clear()
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r2.w
            if (r0 == 0) goto L_0x002f
            java.util.List r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x002f
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r0 = (net.one97.paytm.recharge.model.v4.GroupAttributesItem) r0
            if (r0 == 0) goto L_0x002f
            java.lang.String r0 = r0.getName()
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = r3.getValue()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0058
            java.util.Map r4 = (java.util.Map) r4
            if (r0 != 0) goto L_0x004c
            kotlin.g.b.k.a()
        L_0x004c:
            java.lang.String r3 = r3.getValue()
            if (r3 != 0) goto L_0x0055
            kotlin.g.b.k.a()
        L_0x0055:
            r4.put(r0, r3)
        L_0x0058:
            r3 = 1
            r2.f((boolean) r3)
            r2.F()
            int r3 = net.one97.paytm.recharge.R.id.btn_proceed_dth
            android.view.View r3 = r2.b((int) r3)
            android.widget.Button r3 = (android.widget.Button) r3
            if (r3 == 0) goto L_0x006e
            android.view.View r3 = (android.view.View) r3
            net.one97.paytm.recharge.common.utils.ai.a(r3)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.a(net.one97.paytm.recharge.model.v4.CJRAggsItem, int):void");
    }

    private final void Y() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        this.H = new CJRDTHRechargeShimmerView(activity);
        LinearLayout linearLayout = (LinearLayout) b(R.id.main_content_layout);
        if (linearLayout != null) {
            linearLayout.addView(this.H, 0);
        }
        CJRDTHRechargeShimmerView cJRDTHRechargeShimmerView = this.H;
        if (cJRDTHRechargeShimmerView != null) {
            cJRDTHRechargeShimmerView.a(true);
        }
    }

    public final void a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r14.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.ErrorAction r14) {
        /*
            r13 = this;
            java.lang.String r0 = "action"
            kotlin.g.b.k.c(r14, r0)
            int[] r0 = net.one97.paytm.recharge.dth.a.h.f62719a
            int r14 = r14.ordinal()
            r14 = r0[r14]
            r0 = 1
            if (r14 == r0) goto L_0x0018
            r0 = 2
            if (r14 == r0) goto L_0x0014
            goto L_0x0017
        L_0x0014:
            r13.X()
        L_0x0017:
            return
        L_0x0018:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r14 = r13.r
            if (r14 == 0) goto L_0x0113
            net.one97.paytm.recharge.model.v4.CJRProductList r14 = r14.getProductList()
            if (r14 == 0) goto L_0x0113
            java.util.List r14 = r14.getProducts()
            if (r14 == 0) goto L_0x0113
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.List r14 = kotlin.a.k.d(r14)
            if (r14 == 0) goto L_0x0113
            r1 = 0
            r2 = 0
            if (r14 == 0) goto L_0x0045
            java.lang.Object r3 = r14.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            if (r3 == 0) goto L_0x0045
            boolean r3 = r3.getShowBrowsePlan()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0046
        L_0x0045:
            r3 = r1
        L_0x0046:
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0113
            net.one97.paytm.recharge.common.h.g r3 = r13.f61339f
            if (r3 == 0) goto L_0x007c
            net.one97.paytm.recharge.ordersummary.h.d r4 = r3.v
            if (r4 == 0) goto L_0x007c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "dth"
            java.lang.String r5 = r5.toUpperCase()
            java.lang.String r6 = "(this as java.lang.String).toUpperCase()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r3.append(r5)
            java.lang.String r5 = " (new)"
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 124(0x7c, float:1.74E-43)
            java.lang.String r6 = "Browse Plans_dropdown_clicked"
            net.one97.paytm.recharge.ordersummary.h.d.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x007c:
            net.one97.paytm.recharge.model.CJRRechargeData r3 = new net.one97.paytm.recharge.model.CJRRechargeData
            r3.<init>()
            java.lang.Object r4 = r14.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            java.lang.String r4 = r4.getOperatorLabel()
            r3.setOperator(r4)
            java.lang.Object r14 = r14.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r14 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r14
            if (r14 == 0) goto L_0x009b
            java.lang.String r14 = r14.getOperatorDisplayLabel()
            goto L_0x009c
        L_0x009b:
            r14 = r1
        L_0x009c:
            r3.setOperatorDisplay(r14)
            java.lang.String r14 = "all"
            r3.setCircle(r14)
            net.one97.paytm.common.entity.CJRItem r14 = r13.f61340g
            if (r14 == 0) goto L_0x00ad
            java.lang.String r14 = r14.getURLType()
            goto L_0x00ae
        L_0x00ad:
            r14 = r1
        L_0x00ae:
            net.one97.paytm.recharge.common.h.g r4 = r13.f61339f
            if (r4 == 0) goto L_0x00ca
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRProductList>> r4 = r4.w
            if (r4 == 0) goto L_0x00ca
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.recharge.model.v4.Data r4 = (net.one97.paytm.recharge.model.v4.Data) r4
            if (r4 == 0) goto L_0x00ca
            java.lang.Object r4 = r4.getData()
            net.one97.paytm.recharge.model.v4.CJRProductList r4 = (net.one97.paytm.recharge.model.v4.CJRProductList) r4
            if (r4 == 0) goto L_0x00ca
            java.util.List r1 = r4.getProducts()
        L_0x00ca:
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x00d7
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r1 = 0
            goto L_0x00d8
        L_0x00d7:
            r1 = 1
        L_0x00d8:
            if (r1 != 0) goto L_0x0107
            net.one97.paytm.recharge.common.h.g r1 = r13.f61339f
            if (r1 == 0) goto L_0x0107
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRProductList>> r1 = r1.w
            if (r1 == 0) goto L_0x0107
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.v4.Data r1 = (net.one97.paytm.recharge.model.v4.Data) r1
            if (r1 == 0) goto L_0x0107
            java.lang.Object r1 = r1.getData()
            net.one97.paytm.recharge.model.v4.CJRProductList r1 = (net.one97.paytm.recharge.model.v4.CJRProductList) r1
            if (r1 == 0) goto L_0x0107
            java.util.List r1 = r1.getProducts()
            if (r1 == 0) goto L_0x0107
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            if (r1 == 0) goto L_0x0107
            boolean r1 = r1.isOffersForYouEnabled()
            if (r1 != r0) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r0 = 0
        L_0x0108:
            if (r14 != 0) goto L_0x010c
            java.lang.String r14 = ""
        L_0x010c:
            java.lang.String r1 = r13.Z()
            r13.a((net.one97.paytm.recharge.model.CJRRechargeData) r3, (java.lang.String) r14, (boolean) r0, (java.lang.String) r1)
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.a(net.one97.paytm.recharge.model.v4.ErrorAction):void");
    }

    /* access modifiers changed from: private */
    public final String Z() {
        CJRInputFieldsItem cJRInputFieldsItem;
        if (this.M) {
            return this.u;
        }
        CustomInputLinearLayout customInputLinearLayout = this.r;
        Integer valueOf = customInputLinearLayout != null ? Integer.valueOf(customInputLinearLayout.c("recharge_number")) : null;
        CustomInputLinearLayout customInputLinearLayout2 = this.r;
        View findViewWithTag = customInputLinearLayout2 != null ? customInputLinearLayout2.findViewWithTag("InputField_".concat(String.valueOf(valueOf))) : null;
        if (valueOf == null || !(findViewWithTag instanceof EditText)) {
            return null;
        }
        CustomInputLinearLayout customInputLinearLayout3 = this.r;
        boolean z2 = false;
        if (customInputLinearLayout3 != null) {
            CustomInputLinearLayout customInputLinearLayout4 = this.r;
            if (customInputLinearLayout4 != null) {
                cJRInputFieldsItem = customInputLinearLayout4.b("recharge_number");
            } else {
                cJRInputFieldsItem = null;
            }
            CustomInputLinearLayout customInputLinearLayout5 = this.r;
            if (customInputLinearLayout5 == null) {
                kotlin.g.b.k.a();
            }
            z2 = customInputLinearLayout3.a(cJRInputFieldsItem, (LinearLayout) customInputLinearLayout5, valueOf.intValue(), false);
        }
        if (z2) {
            return ((EditText) findViewWithTag).getText().toString();
        }
        return null;
    }

    public final void onDestroy() {
        if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && this.J) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).az_();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    net.one97.paytm.recharge.common.e.y yVar = (net.one97.paytm.recharge.common.e.y) activity2;
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        yVar.b(activity3.getResources().getString(R.string.recharge_tabs_toolbar_title));
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.content.Context");
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        } else if ((getActivity() instanceof AJRRechargeUtilityActivity) && !this.J) {
            FragmentActivity activity4 = getActivity();
            if (activity4 != null) {
                ((AJRRechargeUtilityActivity) activity4).i();
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity");
            }
        }
        super.onDestroy();
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62699a;

        h(g gVar) {
            this.f62699a = gVar;
        }

        public final void run() {
            if (this.f62699a.r instanceof CustomDthInputLayout) {
                CustomInputLinearLayout g2 = this.f62699a.r;
                if (g2 != null) {
                    ((CustomDthInputLayout) g2).setErrorViewLayoutParam(false);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
            }
        }
    }

    static final class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62718a;

        t(g gVar) {
            this.f62718a = gVar;
        }

        public final void run() {
            CustomInputLinearLayout g2 = this.f62718a.r;
            if (g2 != null) {
                ((CustomDthInputLayout) g2).f();
                CustomInputLinearLayout g3 = this.f62718a.r;
                if (g3 != null) {
                    CJRFetchingAmountLoader loaderWidget = ((CustomDthInputLayout) g3).getLoaderWidget();
                    loaderWidget.setVisibility(0);
                    TextView textView = (TextView) loaderWidget.a(R.id.label);
                    if (textView != null) {
                        net.one97.paytm.recharge.common.utils.ai.a(textView);
                    }
                    CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) loaderWidget.a(R.id.loading_threedots_amount);
                    if (cJRRechargeLottieAnimationView != null) {
                        net.one97.paytm.recharge.common.utils.ai.a(cJRRechargeLottieAnimationView);
                    }
                    CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView2 = (CJRRechargeLottieAnimationView) loaderWidget.a(R.id.loading_threedots_amount);
                    if (cJRRechargeLottieAnimationView2 != null) {
                        cJRRechargeLottieAnimationView2.loop(true);
                    }
                    CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView3 = (CJRRechargeLottieAnimationView) loaderWidget.a(R.id.loading_threedots_amount);
                    if (cJRRechargeLottieAnimationView3 != null) {
                        cJRRechargeLottieAnimationView3.playAnimation();
                        return;
                    }
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
        }
    }

    private final JSONObject ac() {
        String str;
        Long categoryId;
        String valueOf;
        CJRProductsItem cJRProductsItem;
        Long productId;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        List<CJRProductsItem> list = this.p;
        String str2 = "";
        if (list == null || (cJRProductsItem = list.get(0)) == null || (productId = cJRProductsItem.getProductId()) == null || (str = String.valueOf(productId.longValue())) == null) {
            str = str2;
        }
        jSONObject2.put(CLPConstants.PRODUCT_ID, str);
        jSONObject2.put("qty", 1);
        JSONObject jSONObject3 = new JSONObject();
        CustomInputLinearLayout customInputLinearLayout = this.r;
        JSONObject jSONObject4 = null;
        jSONObject3.put("price", customInputLinearLayout != null ? customInputLinearLayout.b(false) : null);
        CJRCategoryData cJRCategoryData = this.w;
        if (!(cJRCategoryData == null || (categoryId = cJRCategoryData.getCategoryId()) == null || (valueOf = String.valueOf(categoryId.longValue())) == null)) {
            str2 = valueOf;
        }
        jSONObject3.put("category_id", str2);
        jSONObject3.put("recharge_number", Z());
        CustomInputLinearLayout customInputLinearLayout2 = this.r;
        jSONObject3.put("totalamount", customInputLinearLayout2 != null ? customInputLinearLayout2.b(false) : null);
        jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, jSONObject3);
        this.R = V();
        CustomInputLinearLayout customInputLinearLayout3 = this.r;
        if (customInputLinearLayout3 != null) {
            jSONObject4 = customInputLinearLayout3.getMetaData();
        }
        jSONObject2.put("meta_data", jSONObject4);
        jSONArray.put(jSONObject2);
        jSONObject.put("cart_items", jSONArray);
        return jSONObject;
    }

    public final void b() {
        this.u = Z();
        CustomInputLinearLayout customInputLinearLayout = this.r;
        CJRInputFieldsItem cJRInputFieldsItem = null;
        Integer valueOf = customInputLinearLayout != null ? Integer.valueOf(customInputLinearLayout.c("recharge_number")) : null;
        CustomInputLinearLayout customInputLinearLayout2 = this.r;
        View findViewWithTag = customInputLinearLayout2 != null ? customInputLinearLayout2.findViewWithTag("InputField_".concat(String.valueOf(valueOf))) : null;
        CustomInputLinearLayout customInputLinearLayout3 = this.r;
        if (customInputLinearLayout3 != null) {
            cJRInputFieldsItem = customInputLinearLayout3.b("recharge_number");
        }
        CustomInputLinearLayout customInputLinearLayout4 = this.r;
        if (customInputLinearLayout4 != null) {
            customInputLinearLayout4.postDelayed(new C1215g(this, valueOf, findViewWithTag, cJRInputFieldsItem), 200);
        }
    }

    /* renamed from: net.one97.paytm.recharge.dth.a.g$g  reason: collision with other inner class name */
    static final class C1215g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Integer f62696b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f62697c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRInputFieldsItem f62698d;

        C1215g(g gVar, Integer num, View view, CJRInputFieldsItem cJRInputFieldsItem) {
            this.f62695a = gVar;
            this.f62696b = num;
            this.f62697c = view;
            this.f62698d = cJRInputFieldsItem;
        }

        public final void run() {
            CustomInputLinearLayout g2;
            if (this.f62696b != null && (this.f62697c instanceof EditText) && (g2 = this.f62695a.r) != null) {
                CJRInputFieldsItem cJRInputFieldsItem = this.f62698d;
                CustomInputLinearLayout g3 = this.f62695a.r;
                if (g3 == null) {
                    kotlin.g.b.k.a();
                }
                if (g2.a(cJRInputFieldsItem, (LinearLayout) g3, this.f62696b.intValue(), false)) {
                    g gVar = this.f62695a;
                    gVar.i(gVar.u);
                }
            }
        }
    }

    public final boolean a(String str, MotionEvent motionEvent) {
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() == 1647421367 && str.equals("dispatch.touch.event") && motionEvent != null && motionEvent.getAction() == 1) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("key-intercept: amount-screen: dispatchTouchEvent to amount-input-field : ".concat(String.valueOf(motionEvent)));
            if (!this.Z) {
                e(true);
            }
        }
        return false;
    }

    public final boolean a(String str, KeyEvent keyEvent) {
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() == -789823017 && str.equals("dispatch.key.event")) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("key-intercept: dth amount-screen: dispatchKeyEventPreIme : pressed");
            Integer valueOf = keyEvent != null ? Integer.valueOf(keyEvent.getKeyCode()) : null;
            if ((valueOf != null && valueOf.intValue() == 4) || (valueOf != null && valueOf.intValue() == 66)) {
                e(false);
            }
        }
        return false;
    }

    public final void a(JSONArray jSONArray, String str) {
        Window window;
        if (this.aa) {
            net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
            if (!(gVar instanceof net.one97.paytm.recharge.dth.c.a)) {
                gVar = null;
            }
            net.one97.paytm.recharge.dth.c.a aVar = (net.one97.paytm.recharge.dth.c.a) gVar;
            if (aVar != null) {
                CJRRechargeCart cJRRechargeCart = this.o;
                net.one97.paytm.recharge.common.utils.w wVar = aVar.t;
                if (wVar != null) {
                    wVar.f61781a = cJRRechargeCart;
                }
                net.one97.paytm.recharge.common.utils.w wVar2 = aVar.t;
                if (wVar2 != null) {
                    wVar2.o = false;
                }
            }
            this.aa = false;
        }
        net.one97.paytm.recharge.common.h.g gVar2 = this.f61339f;
        if (gVar2 != null) {
            net.one97.paytm.recharge.common.utils.w wVar3 = gVar2.t;
            if (wVar3 != null) {
                wVar3.a(jSONArray, str);
            }
            net.one97.paytm.recharge.common.utils.w wVar4 = gVar2.t;
            if (wVar4 != null) {
                net.one97.paytm.recharge.common.utils.w.a(wVar4, jSONArray, (Object) null, 2);
            }
        }
        D();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(17);
        }
    }

    public final void a(CJRPromoCode cJRPromoCode, CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(cJRRechargeCart, "pRechargeCart");
        this.U = cJRPromoCode;
        if (cJRPromoCode != null && !TextUtils.isEmpty(cJRPromoCode.getCode())) {
            this.o = cJRRechargeCart;
            String code = cJRPromoCode.getCode();
            if (code == null) {
                code = "";
            }
            this.T = code;
            net.one97.paytm.recharge.common.utils.o oVar = this.S;
            if (oVar == null || !oVar.f61684a) {
                RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward_dth);
                if (relativeLayout != null) {
                    net.one97.paytm.recharge.common.utils.ai.a(relativeLayout);
                }
            } else {
                RelativeLayout relativeLayout2 = (RelativeLayout) b(R.id.lyt_fast_forward_dth);
                if (relativeLayout2 != null) {
                    net.one97.paytm.recharge.common.utils.ai.b(relativeLayout2);
                }
            }
            CJRPromoWidgetV3 cJRPromoWidgetV3 = (CJRPromoWidgetV3) b(R.id.bank_offers_promocode_text_layout);
            if (cJRPromoWidgetV3 != null) {
                String code2 = cJRPromoCode.getCode();
                if (code2 == null) {
                    code2 = "";
                }
                View.OnClickListener onClickListener = this;
                cJRPromoWidgetV3.a(code2, onClickListener, onClickListener);
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(networkCustomError, "error");
        if (!com.paytm.utility.d.c(getActivity())) {
            z.a((Activity) getActivity(), (Fragment) this, 31);
        } else {
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, (String) null, getActivity(), this, networkCustomError, false, 31, (Object) null, 16, (Object) null);
        }
    }

    public final void a(Integer num, String str, String str2) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            az azVar = az.f61525a;
            az.a(activity, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CLP_PROCEED, str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        r7 = (r7 = r7.getCartItems()).get(0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x013c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r7, com.paytm.network.model.IJRPaytmDataModel r8, java.lang.Object r9) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            int r9 = r7.hashCode()
            r0 = -2013158012(0xffffffff8801a584, float:-3.901409E-34)
            r1 = 1
            r2 = 0
            r3 = 0
            if (r9 == r0) goto L_0x0180
            r0 = 34430556(0x20d5e5c, float:1.0386124E-37)
            if (r9 == r0) goto L_0x0016
            goto L_0x01bd
        L_0x0016:
            java.lang.String r9 = "dth_pre_verify"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x01bd
            int r7 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r7 = r6.b((int) r7)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r7 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r7
            if (r7 == 0) goto L_0x002b
            r7.setEnabled(r1)
        L_0x002b:
            int r7 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r7 = r6.b((int) r7)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r7 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r7
            if (r7 == 0) goto L_0x0038
            r7.b()
        L_0x0038:
            if (r8 == 0) goto L_0x0178
            net.one97.paytm.common.entity.CJRRechargeCart r8 = (net.one97.paytm.common.entity.CJRRechargeCart) r8
            r6.o = r8
            net.one97.paytm.recharge.common.utils.az r7 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r7 = r6.getContext()
            android.os.Bundle r7 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r7, (net.one97.paytm.common.entity.CJRRechargeCart) r8, (boolean) r2, (boolean) r2)
            java.lang.String r9 = "extra.has.error"
            boolean r9 = r7.getBoolean(r9)
            java.lang.String r0 = "extra.error.title"
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r4 = "extra.error.msg"
            java.lang.String r7 = r7.getString(r4)
            if (r9 == 0) goto L_0x007c
            androidx.fragment.app.FragmentActivity r8 = r6.getActivity()
            if (r8 == 0) goto L_0x007b
            r6.o = r3
            r6.R = r3
            net.one97.paytm.recharge.common.utils.t r9 = new net.one97.paytm.recharge.common.utils.t
            java.lang.String r1 = "it"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            r1 = r8
            android.app.Activity r1 = (android.app.Activity) r1
            r9.<init>(r1)
            r9.a()
            android.content.Context r8 = (android.content.Context) r8
            com.paytm.utility.b.b((android.content.Context) r8, (java.lang.String) r0, (java.lang.String) r7)
        L_0x007b:
            return
        L_0x007c:
            net.one97.paytm.recharge.di.helper.c r7 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r7 = net.one97.paytm.recharge.di.helper.c.bb()
            if (r7 == 0) goto L_0x0174
            net.one97.paytm.recharge.widgets.c.d r7 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x016c }
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r8.getCart()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x009f
            java.util.ArrayList r7 = r7.getCartItems()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x009f
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x016c }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r7 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r7     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x009f
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r7 = r7.getServiceOptions()     // Catch:{ Exception -> 0x016c }
            goto L_0x00a0
        L_0x009f:
            r7 = r3
        L_0x00a0:
            net.one97.paytm.common.entity.shopping.CJRServiceActions r7 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.common.entity.shopping.CJRServiceOptions) r7)     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x00ab
            java.util.ArrayList r7 = r7.getGroupDisplay()     // Catch:{ Exception -> 0x016c }
            goto L_0x00ac
        L_0x00ab:
            r7 = r3
        L_0x00ac:
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x016c }
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x016c }
            boolean r9 = net.one97.paytm.recharge.di.helper.c.bz()     // Catch:{ Exception -> 0x016c }
            if (r9 == 0) goto L_0x00e8
            if (r8 == 0) goto L_0x00e5
            net.one97.paytm.common.entity.shopping.CJRCart r7 = r8.getCart()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x00e5
            java.util.ArrayList r7 = r7.getCartItems()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x00e5
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x016c }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r7 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r7     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x00e5
            net.one97.paytm.common.entity.shopping.CJRServiceOptions r7 = r7.getServiceOptions()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x00e5
            java.util.ArrayList r7 = r7.getActions()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x00e5
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x016c }
            net.one97.paytm.common.entity.shopping.CJRServiceActions r7 = (net.one97.paytm.common.entity.shopping.CJRServiceActions) r7     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x00e5
            java.util.ArrayList r7 = r7.getGroupDisplay()     // Catch:{ Exception -> 0x016c }
            goto L_0x00e6
        L_0x00e5:
            r7 = r3
        L_0x00e6:
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x016c }
        L_0x00e8:
            if (r7 == 0) goto L_0x0174
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ Exception -> 0x016c }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x016c }
        L_0x00f0:
            boolean r9 = r7.hasNext()     // Catch:{ Exception -> 0x016c }
            if (r9 == 0) goto L_0x013d
            java.lang.Object r9 = r7.next()     // Catch:{ Exception -> 0x016c }
            r0 = r9
            net.one97.paytm.common.entity.shopping.CJRGroupDisplay r0 = (net.one97.paytm.common.entity.shopping.CJRGroupDisplay) r0     // Catch:{ Exception -> 0x016c }
            java.lang.String r4 = r0.getType()     // Catch:{ Exception -> 0x016c }
            if (r4 == 0) goto L_0x010e
            java.lang.String r5 = "radio"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r1)     // Catch:{ Exception -> 0x016c }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x016c }
            goto L_0x010f
        L_0x010e:
            r4 = r3
        L_0x010f:
            if (r4 != 0) goto L_0x0114
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x016c }
        L_0x0114:
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x016c }
            if (r4 == 0) goto L_0x0139
            java.lang.String r0 = r0.getPlacement()     // Catch:{ Exception -> 0x016c }
            if (r0 == 0) goto L_0x012b
            java.lang.String r4 = "bottomsheet"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)     // Catch:{ Exception -> 0x016c }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x016c }
            goto L_0x012c
        L_0x012b:
            r0 = r3
        L_0x012c:
            if (r0 != 0) goto L_0x0131
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x016c }
        L_0x0131:
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x016c }
            if (r0 == 0) goto L_0x0139
            r0 = 1
            goto L_0x013a
        L_0x0139:
            r0 = 0
        L_0x013a:
            if (r0 == 0) goto L_0x00f0
            goto L_0x013e
        L_0x013d:
            r9 = r3
        L_0x013e:
            net.one97.paytm.common.entity.shopping.CJRGroupDisplay r9 = (net.one97.paytm.common.entity.shopping.CJRGroupDisplay) r9     // Catch:{ Exception -> 0x016c }
            if (r9 == 0) goto L_0x0174
            java.util.Map r7 = r9.getValuesMap()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x0156
            java.util.Set r7 = r7.keySet()     // Catch:{ Exception -> 0x016c }
            if (r7 == 0) goto L_0x0156
            int r7 = r7.size()     // Catch:{ Exception -> 0x016c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x016c }
        L_0x0156:
            if (r3 != 0) goto L_0x015b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x016c }
        L_0x015b:
            int r7 = r3.intValue()     // Catch:{ Exception -> 0x016c }
            if (r7 <= 0) goto L_0x0174
            net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet r7 = new net.one97.paytm.recharge.model.v4.CJRInstruct$openSubscriberBottomSheet     // Catch:{ Exception -> 0x016c }
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x016c }
            net.one97.paytm.recharge.model.v4.CJRInstruct r7 = (net.one97.paytm.recharge.model.v4.CJRInstruct) r7     // Catch:{ Exception -> 0x016c }
            r6.a((net.one97.paytm.recharge.model.v4.CJRInstruct) r7)     // Catch:{ Exception -> 0x016c }
            goto L_0x0174
        L_0x016c:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.q.d(r7)
        L_0x0174:
            r6.ad()
            goto L_0x01bd
        L_0x0178:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart"
            r7.<init>(r8)
            throw r7
        L_0x0180:
            java.lang.String r8 = "remove_promo_verify"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x01bd
            r6.t()
            int r7 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r7 = r6.b((int) r7)
            android.widget.Button r7 = (android.widget.Button) r7
            if (r7 == 0) goto L_0x0198
            r7.setEnabled(r1)
        L_0x0198:
            int r7 = net.one97.paytm.recharge.R.id.lyt_fast_forward_dth
            android.view.View r7 = r6.b((int) r7)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x01a7
            android.view.View r7 = (android.view.View) r7
            net.one97.paytm.recharge.common.utils.ai.a(r7)
        L_0x01a7:
            r6.g((boolean) r1)
            r6.o = r3
            r6.R = r3
            net.one97.paytm.recharge.common.utils.o r7 = r6.S
            if (r7 == 0) goto L_0x01b4
            r7.f61685b = r3
        L_0x01b4:
            net.one97.paytm.recharge.common.utils.o r7 = r6.S
            if (r7 == 0) goto L_0x01ba
            r7.f61684a = r2
        L_0x01ba:
            r6.G()
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        String str2 = str;
        if (str2 != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2013158012) {
                if (hashCode == 34430556 && str2.equals("dth_pre_verify")) {
                    CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.next_btn_parent_lyt);
                    if (cJRProceedWidgetV8 != null) {
                        cJRProceedWidgetV8.setEnabled(true);
                    }
                    CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) b(R.id.next_btn_parent_lyt);
                    if (cJRProceedWidgetV82 != null) {
                        cJRProceedWidgetV82.b();
                    }
                    this.o = null;
                    this.R = null;
                    CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, (String) null, getActivity(), this, networkCustomError, false, 31, (Object) null, 16, (Object) null);
                }
            } else if (str2.equals("remove_promo_verify")) {
                t();
                RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward_dth);
                if (relativeLayout != null) {
                    net.one97.paytm.recharge.common.utils.ai.a(relativeLayout);
                }
                this.o = null;
                this.R = null;
                net.one97.paytm.recharge.common.utils.o oVar = this.S;
                if (oVar != null) {
                    oVar.f61685b = null;
                }
                net.one97.paytm.recharge.common.utils.o oVar2 = this.S;
                if (oVar2 != null) {
                    oVar2.f61684a = false;
                }
                g(true);
                Button button = (Button) b(R.id.btn_proceed);
                if (button != null) {
                    button.setEnabled(true);
                }
            }
        }
    }

    private final void ad() {
        this.Z = true;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            kotlin.g.b.k.a((Object) activity, "it");
            new net.one97.paytm.recharge.common.utils.t(activity).a();
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.next_btn_parent_lyt);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.postDelayed(new k(this), 100);
        }
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f62704a;

        k(g gVar) {
            this.f62704a = gVar;
        }

        public final void run() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat((CJRProceedWidgetV8) this.f62704a.b(R.id.next_btn_parent_lyt), View.ALPHA, new float[]{0.0f});
            kotlin.g.b.k.a((Object) ofFloat, "animNextAlphaFooter");
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(100);
            ofFloat.addListener(new AnimatorListenerAdapter(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ k f62705a;

                public final void onAnimationStart(Animator animator) {
                }

                {
                    this.f62705a = r1;
                }

                public final void onAnimationEnd(Animator animator) {
                    CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f62705a.f62704a.b(R.id.next_btn_parent_lyt);
                    if (cJRProceedWidgetV8 != null) {
                        cJRProceedWidgetV8.setVisibility(8);
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                    CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f62705a.f62704a.b(R.id.next_btn_parent_lyt);
                    if (cJRProceedWidgetV8 != null) {
                        cJRProceedWidgetV8.setVisibility(8);
                    }
                }
            });
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((LinearLayout) this.f62704a.b(R.id.lyt_ff_proceed_dth), View.ALPHA, new float[]{1.0f});
            kotlin.g.b.k.a((Object) ofFloat2, "animAlphaFooter");
            ofFloat2.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200);
            animatorSet.addListener(new a(this));
            animatorSet.start();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        }

        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ k f62706a;

            a(k kVar) {
                this.f62706a = kVar;
            }

            public final void onAnimationStart(Animator animator) {
                LinearLayout linearLayout = (LinearLayout) this.f62706a.f62704a.b(R.id.lyt_ff_proceed_dth);
                if (linearLayout != null) {
                    net.one97.paytm.recharge.common.utils.ai.a(linearLayout);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                this.f62706a.f62704a.Z = false;
                this.f62706a.f62704a.e(false);
            }

            public final void onAnimationCancel(Animator animator) {
                this.f62706a.f62704a.Z = false;
                this.f62706a.f62704a.e(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void g(boolean z2) {
        String str;
        Context context;
        String str2;
        CJRItem cJRItem;
        Long categoryId;
        if (getActivity() != null) {
            Context activity = getActivity();
            CJRCategoryData cJRCategoryData = this.w;
            if (cJRCategoryData == null || (categoryId = cJRCategoryData.getCategoryId()) == null || (str = String.valueOf(categoryId.longValue())) == null) {
                str = "";
            }
            if (az.a(activity, str) && (context = getContext()) != null) {
                net.one97.paytm.recharge.common.h.g gVar = this.f61339f;
                Object obj = null;
                if (gVar == null || (cJRItem = gVar.r) == null) {
                    str2 = null;
                } else {
                    str2 = cJRItem.getCategoryId();
                }
                boolean z3 = false;
                try {
                    com.google.gson.f fVar = new com.google.gson.f();
                    net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                    Object a2 = fVar.a(net.one97.paytm.recharge.di.helper.c.bR(), HashMap.class);
                    if (a2 instanceof HashMap) {
                        obj = a2;
                    }
                    HashMap hashMap = (HashMap) obj;
                    if (!TextUtils.isEmpty(str2) && hashMap != null) {
                        Map map = hashMap;
                        if (map == null) {
                            throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                        } else if (map.containsKey(str2) && ba.c((String) hashMap.get(str2), context)) {
                            z3 = true;
                        }
                    }
                } catch (Exception unused) {
                }
                if (z3) {
                    if (z2) {
                        CJRPromoWidgetV3 cJRPromoWidgetV3 = (CJRPromoWidgetV3) b(R.id.bank_offers_promocode_text_layout);
                        if (cJRPromoWidgetV3 != null) {
                            cJRPromoWidgetV3.setEnabled(z2, this);
                        }
                    } else {
                        CJRPromoWidgetV3 cJRPromoWidgetV32 = (CJRPromoWidgetV3) b(R.id.bank_offers_promocode_text_layout);
                        if (cJRPromoWidgetV32 != null) {
                            cJRPromoWidgetV32.setEnabled(z2);
                        }
                    }
                    CJRPromoWidgetV3 cJRPromoWidgetV33 = (CJRPromoWidgetV3) b(R.id.bank_offers_promocode_text_layout);
                    if (cJRPromoWidgetV33 != null) {
                        net.one97.paytm.recharge.common.utils.ai.a(cJRPromoWidgetV33);
                        return;
                    }
                    return;
                }
            }
        }
        CJRPromoWidgetV3 cJRPromoWidgetV34 = (CJRPromoWidgetV3) b(R.id.bank_offers_promocode_text_layout);
        if (cJRPromoWidgetV34 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(cJRPromoWidgetV34);
        }
    }

    private final void T() {
        CustomInputLinearLayout customInputLinearLayout = this.r;
        View a2 = customInputLinearLayout != null ? customInputLinearLayout.a("recharge_number") : null;
        if (a2 instanceof CJRRechargeEditText) {
            CJRRechargeEditText cJRRechargeEditText = (CJRRechargeEditText) a2;
            cJRRechargeEditText.setOnKeyUpDownListener(this);
            cJRRechargeEditText.setImeOptions(1);
        }
        if (this.r instanceof CustomDthInputLayout) {
            CustomInputLinearLayout customInputLinearLayout2 = this.r;
            if (customInputLinearLayout2 != null) {
                net.one97.paytm.recharge.mobile_v3.d.b bVar = this;
                ((CustomDthInputLayout) customInputLinearLayout2).setOnKeyUpDownListener(bVar);
                CustomInputLinearLayout customInputLinearLayout3 = this.r;
                if (customInputLinearLayout3 != null) {
                    CJRRechargeEditText amountView = ((CustomDthInputLayout) customInputLinearLayout3).getAmountView();
                    if (amountView != null) {
                        amountView.setImeOptions(1);
                    }
                    CustomInputLinearLayout customInputLinearLayout4 = this.r;
                    if (customInputLinearLayout4 != null) {
                        CJRRechargeEditText amountView2 = ((CustomDthInputLayout) customInputLinearLayout4).getAmountView();
                        if (amountView2 != null) {
                            amountView2.setOnKeyUpDownListener(bVar);
                        }
                        CustomInputLinearLayout customInputLinearLayout5 = this.r;
                        if (customInputLinearLayout5 != null) {
                            CJRRechargeEditText amountView3 = ((CustomDthInputLayout) customInputLinearLayout5).getAmountView();
                            if (amountView3 != null) {
                                amountView3.addTextChangedListener(new j(this, a2));
                                return;
                            }
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
        }
    }

    private final JSONObject V() {
        String str;
        String str2;
        GroupAttributesItem groupAttributesItem;
        GroupAttributesItem groupAttributesItem2;
        CustomInputLinearLayout customInputLinearLayout = this.r;
        String str3 = null;
        this.R = customInputLinearLayout != null ? customInputLinearLayout.getMetaData() : null;
        JSONObject jSONObject = this.R;
        if (jSONObject != null) {
            if (jSONObject != null) {
                CJRNextGroupData cJRNextGroupData = this.y;
                jSONObject.put((cJRNextGroupData == null || (groupAttributesItem2 = cJRNextGroupData.getGroupAttributesItem()) == null) ? null : groupAttributesItem2.getName(), this.z);
            }
            if (jSONObject != null) {
                CJRNextGroupData cJRNextGroupData2 = this.y;
                if (!(cJRNextGroupData2 == null || (groupAttributesItem = cJRNextGroupData2.getGroupAttributesItem()) == null)) {
                    str3 = groupAttributesItem.getDisplayName();
                }
                jSONObject.put(str3, this.z);
            }
            String str4 = this.C;
            if (str4 != null) {
                boolean z2 = false;
                if ((str4.length() > 0) && (str2 = this.B) != null) {
                    if (str2.length() > 0) {
                        z2 = true;
                    }
                    if (z2 && jSONObject != null) {
                        jSONObject.put(this.C, this.B);
                    }
                }
            }
            if (jSONObject != null) {
                CJRProductsItem cJRProductsItem = this.D;
                if (cJRProductsItem == null || (str = cJRProductsItem.getPostOrderViewType()) == null) {
                    str = "";
                }
                jSONObject.put("post_order_view_type", str);
            }
            W();
        }
        return this.R;
    }

    private void W() {
        String str;
        Map<String, String> map = this.k;
        String str2 = this.A;
        if (str2 != null) {
            boolean z2 = false;
            if ((str2.length() > 0) && (str = this.B) != null) {
                if (str.length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    String str3 = this.A;
                    if (str3 == null) {
                        kotlin.g.b.k.a();
                    }
                    String str4 = this.B;
                    if (str4 == null) {
                        kotlin.g.b.k.a();
                    }
                    map.put(str3, str4);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r1 = r1.m;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void f(boolean r8) {
        /*
            r7 = this;
            net.one97.paytm.recharge.common.h.g r0 = r7.f61339f
            if (r0 == 0) goto L_0x0175
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.m
            if (r0 == 0) goto L_0x0175
            net.one97.paytm.recharge.common.h.g r1 = r7.f61339f
            r2 = 0
            if (r1 == 0) goto L_0x001a
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            if (r1 == 0) goto L_0x001a
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r3 = "isFromDeeplink"
            boolean r1 = r1.containsKey(r3)
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            r7.W = r1
            net.one97.paytm.recharge.model.v4.CJRCategoryData r1 = r7.w
            r3 = 0
            if (r1 == 0) goto L_0x0035
            java.util.List r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r1 = (net.one97.paytm.recharge.model.v4.GroupAttributesItem) r1
            if (r1 == 0) goto L_0x0035
            java.lang.String r1 = r1.getName()
            goto L_0x0036
        L_0x0035:
            r1 = r3
        L_0x0036:
            java.lang.String r4 = "promo"
            boolean r5 = r0.containsKey(r4)
            if (r5 == 0) goto L_0x0046
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r7.j = r4
        L_0x0046:
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0175
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0175
            net.one97.paytm.recharge.model.v4.CJRCategoryData r1 = r7.w
            if (r1 == 0) goto L_0x0095
            net.one97.paytm.recharge.model.v4.CJRGroupings r1 = r1.getGroupings()
            if (r1 == 0) goto L_0x0095
            java.util.List r1 = r1.getAggs()
            if (r1 == 0) goto L_0x0095
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x0076:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0091
            java.lang.Object r5 = r1.next()
            r6 = r5
            net.one97.paytm.recharge.model.v4.CJRAggsItem r6 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r6
            java.lang.String r6 = r6.getValue()
            boolean r6 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r2)
            if (r6 == 0) goto L_0x0076
            r4.add(r5)
            goto L_0x0076
        L_0x0091:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            goto L_0x0096
        L_0x0095:
            r0 = r3
        L_0x0096:
            if (r0 == 0) goto L_0x0175
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0137
            java.lang.Object r8 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            java.util.List r8 = r8.getProductList()
            if (r8 == 0) goto L_0x00b6
            java.lang.Object r8 = r8.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r8
            goto L_0x00b7
        L_0x00b6:
            r8 = r3
        L_0x00b7:
            r7.D = r8
            java.lang.Object r8 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            java.util.List r8 = r8.getProductList()
            r7.p = r8
            net.one97.paytm.recharge.model.v4.CJRProductsItem r8 = r7.D
            if (r8 == 0) goto L_0x00ce
            java.util.List r8 = r8.getInputFields()
            goto L_0x00cf
        L_0x00ce:
            r8 = r3
        L_0x00cf:
            if (r8 == 0) goto L_0x0136
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0136
            int r1 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r1 = r7.b((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x00eb
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.a(r1)
        L_0x00eb:
            int r1 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r1 = r7.b((int) r1)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r1 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r1
            if (r1 == 0) goto L_0x00fe
            int r4 = net.one97.paytm.recharge.R.string.next
            java.lang.String r4 = r7.getString(r4)
            r1.setProceedBtnText(r4)
        L_0x00fe:
            net.one97.paytm.recharge.common.h.g r1 = r7.f61339f
            if (r1 == 0) goto L_0x012d
            net.one97.paytm.recharge.common.h.g r1 = r7.f61339f
            if (r1 != 0) goto L_0x0109
            kotlin.g.b.k.a()
        L_0x0109:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r8 = r8.get(r2)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r8 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r8
            if (r8 == 0) goto L_0x0119
            java.lang.String r3 = r8.getConfigKey()
        L_0x0119:
            boolean r8 = r1.containsKey(r3)
            if (r8 == 0) goto L_0x012d
            java.lang.Object r8 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            boolean r0 = r7.S()
            r7.a((net.one97.paytm.recharge.model.v4.CJRAggsItem) r8, (boolean) r0)
            return
        L_0x012d:
            java.lang.Object r8 = r0.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r8 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r8
            r7.a((net.one97.paytm.recharge.model.v4.CJRAggsItem) r8)
        L_0x0136:
            return
        L_0x0137:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed_dth
            android.view.View r0 = r7.b((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x0146
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
        L_0x0146:
            if (r8 != 0) goto L_0x016e
            net.one97.paytm.recharge.common.h.g r8 = r7.f61339f
            if (r8 == 0) goto L_0x016d
            r7.Y()
            net.one97.paytm.recharge.common.h.g r8 = r7.f61339f
            if (r8 == 0) goto L_0x0165
            net.one97.paytm.recharge.dth.c.a r8 = (net.one97.paytm.recharge.dth.c.a) r8
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            java.lang.String r1 = "fetch_product_detail_by_pid"
            r8.d(r1, r0)
            return
        L_0x0165:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.dth.viewmodel.CJRDTHRechargeViewModel"
            r8.<init>(r0)
            throw r8
        L_0x016d:
            return
        L_0x016e:
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r8 = r7.E
            if (r8 == 0) goto L_0x0175
            r7.X()
        L_0x0175:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.f(boolean):void");
    }

    public final String n() {
        String str = this.j;
        return str == null ? "" : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r19, int r20, android.content.Intent r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "data1"
            java.lang.String r3 = ""
            r4 = 2
            r5 = 0
            if (r0 == r4) goto L_0x017c
            r4 = 3
            r6 = 1
            r7 = 0
            if (r0 == r4) goto L_0x015b
            r4 = 7
            if (r0 == r4) goto L_0x015b
            r4 = 100
            if (r0 == r4) goto L_0x001a
            goto L_0x019e
        L_0x001a:
            androidx.fragment.app.FragmentActivity r0 = r18.getActivity()
            if (r0 == 0) goto L_0x015a
            if (r21 == 0) goto L_0x015a
            android.net.Uri r9 = r21.getData()
            if (r9 == 0) goto L_0x015a
            androidx.fragment.app.FragmentActivity r0 = r18.getActivity()     // Catch:{ all -> 0x0152 }
            if (r0 != 0) goto L_0x0031
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0152 }
        L_0x0031:
            java.lang.String r4 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)     // Catch:{ all -> 0x0152 }
            android.content.ContentResolver r8 = r0.getContentResolver()     // Catch:{ all -> 0x0152 }
            java.lang.String[] r10 = new java.lang.String[]{r2}     // Catch:{ all -> 0x0152 }
            r11 = 0
            r12 = 0
            r13 = 0
            android.database.Cursor r4 = r8.query(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0152 }
            java.lang.String r0 = "/amount"
            if (r4 == 0) goto L_0x00eb
            boolean r8 = r4.moveToFirst()     // Catch:{ all -> 0x0150 }
            if (r8 == 0) goto L_0x00eb
            int r2 = r4.getColumnIndex(r2)     // Catch:{ all -> 0x0150 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = "number"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)     // Catch:{ all -> 0x0150 }
            androidx.fragment.app.FragmentActivity r8 = r18.getActivity()     // Catch:{ all -> 0x0150 }
            if (r8 == 0) goto L_0x014a
            java.lang.String r8 = "-"
            java.lang.String r2 = kotlin.m.p.a(r2, r8, r3, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = " "
            java.lang.String r2 = kotlin.m.p.a(r2, r8, r3, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = "("
            java.lang.String r2 = kotlin.m.p.a(r2, r8, r3, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = ")"
            java.lang.String r2 = kotlin.m.p.a(r2, r8, r3, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.g.b(r2)     // Catch:{ all -> 0x0150 }
            if (r2 == 0) goto L_0x008b
            android.widget.EditText r0 = r1.Q     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x014a
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0150 }
            r0.setText(r2)     // Catch:{ all -> 0x0150 }
            goto L_0x014a
        L_0x008b:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ all -> 0x0150 }
            android.content.Context r8 = r18.getContext()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r9 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0150 }
            r10 = 0
            java.lang.String r11 = "utility_hide_title"
            int r2 = net.one97.paytm.recharge.R.string.invalid_no_msg     // Catch:{ all -> 0x0150 }
            java.lang.String r12 = r1.getString(r2)     // Catch:{ all -> 0x0150 }
            r13 = 0
            net.one97.paytm.recharge.common.h.g r2 = r1.f61339f     // Catch:{ all -> 0x0150 }
            if (r2 == 0) goto L_0x00a5
            java.lang.String r2 = r2.A     // Catch:{ all -> 0x0150 }
            r14 = r2
            goto L_0x00a6
        L_0x00a5:
            r14 = r5
        L_0x00a6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0150 }
            r2.<init>()     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = r1.I     // Catch:{ all -> 0x0150 }
            r2.append(r3)     // Catch:{ all -> 0x0150 }
            r2.append(r0)     // Catch:{ all -> 0x0150 }
            java.lang.String r15 = r2.toString()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.common.h.g r0 = r1.f61339f     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e1
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRProductList>> r0 = r0.w     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e1
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.model.v4.Data r0 = (net.one97.paytm.recharge.model.v4.Data) r0     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e1
            java.lang.Object r0 = r0.getData()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = (net.one97.paytm.recharge.model.v4.CJRProductList) r0     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e1
            java.util.List r0 = r0.getProducts()     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e1
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e1
            java.lang.Long r5 = r0.getProductId()     // Catch:{ all -> 0x0150 }
        L_0x00e1:
            java.lang.String r16 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0150 }
            r17 = 1
            net.one97.paytm.recharge.common.utils.az.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0150 }
            goto L_0x014a
        L_0x00eb:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ all -> 0x0150 }
            android.content.Context r8 = r18.getContext()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r9 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0150 }
            r10 = 0
            java.lang.String r11 = "utility_hide_title"
            int r2 = net.one97.paytm.recharge.R.string.invalid_no_msg     // Catch:{ all -> 0x0150 }
            java.lang.String r12 = r1.getString(r2)     // Catch:{ all -> 0x0150 }
            r13 = 0
            net.one97.paytm.recharge.common.h.g r2 = r1.f61339f     // Catch:{ all -> 0x0150 }
            if (r2 == 0) goto L_0x0105
            java.lang.String r2 = r2.A     // Catch:{ all -> 0x0150 }
            r14 = r2
            goto L_0x0106
        L_0x0105:
            r14 = r5
        L_0x0106:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0150 }
            r2.<init>()     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = r1.I     // Catch:{ all -> 0x0150 }
            r2.append(r3)     // Catch:{ all -> 0x0150 }
            r2.append(r0)     // Catch:{ all -> 0x0150 }
            java.lang.String r15 = r2.toString()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.common.h.g r0 = r1.f61339f     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0141
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRProductList>> r0 = r0.w     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0141
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.model.v4.Data r0 = (net.one97.paytm.recharge.model.v4.Data) r0     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0141
            java.lang.Object r0 = r0.getData()     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.model.v4.CJRProductList r0 = (net.one97.paytm.recharge.model.v4.CJRProductList) r0     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0141
            java.util.List r0 = r0.getProducts()     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0141
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0150 }
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0141
            java.lang.Long r5 = r0.getProductId()     // Catch:{ all -> 0x0150 }
        L_0x0141:
            java.lang.String r16 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0150 }
            r17 = 1
            net.one97.paytm.recharge.common.utils.az.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0150 }
        L_0x014a:
            if (r4 == 0) goto L_0x015a
            r4.close()
            goto L_0x015a
        L_0x0150:
            r0 = move-exception
            goto L_0x0154
        L_0x0152:
            r0 = move-exception
            r4 = r5
        L_0x0154:
            if (r4 == 0) goto L_0x0159
            r4.close()
        L_0x0159:
            throw r0
        L_0x015a:
            return r6
        L_0x015b:
            androidx.fragment.app.FragmentActivity r0 = r18.getActivity()
            if (r0 == 0) goto L_0x017b
            androidx.fragment.app.FragmentActivity r0 = r18.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = net.one97.paytm.recharge.common.utils.z.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x017b
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed_dth
            android.view.View r0 = r1.b((int) r0)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x017a
            r0.performClick()
        L_0x017a:
            return r6
        L_0x017b:
            return r7
        L_0x017c:
            r1.o = r5
            r1.R = r5
            int r2 = net.one97.paytm.recharge.R.id.lyt_ff_proceed_dth
            android.view.View r2 = r1.b((int) r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            if (r2 == 0) goto L_0x018f
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.ai.b(r2)
        L_0x018f:
            int r2 = net.one97.paytm.recharge.R.id.next_btn_parent_lyt
            android.view.View r2 = r1.b((int) r2)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r2
            if (r2 == 0) goto L_0x019e
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.recharge.common.utils.ai.a(r2)
        L_0x019e:
            boolean r0 = super.a((int) r19, (int) r20, (android.content.Intent) r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.a(int, int, android.content.Intent):boolean");
    }

    private final void b(CJRRechargeCart cJRRechargeCart) {
        EditText editText;
        CustomInputLinearLayout customInputLinearLayout = this.r;
        if (customInputLinearLayout != null) {
            editText = customInputLinearLayout.getMBillAmountEdt();
        } else {
            editText = null;
        }
        if (editText != null && (this.r instanceof CustomDthInputLayout)) {
            CustomInputLinearLayout customInputLinearLayout2 = this.r;
            if (customInputLinearLayout2 != null) {
                ((CustomDthInputLayout) customInputLinearLayout2).setRechargeCartResponse(cJRRechargeCart);
                CustomInputLinearLayout customInputLinearLayout3 = this.r;
                if (customInputLinearLayout3 != null) {
                    ((CustomDthInputLayout) customInputLinearLayout3).b();
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.util.Map] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r0 = (r0 = r0.getMBillAmountEdt()).getText();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.lang.String r12) {
        /*
            r11 = this;
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r11.p
            r1 = 0
            if (r0 == 0) goto L_0x001b
            java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r11.p
            if (r0 != 0) goto L_0x000c
            kotlin.g.b.k.a()
        L_0x000c:
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isSoftPrefetch()
            if (r0 != 0) goto L_0x001b
            return
        L_0x001b:
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.CJRAmountPreFetchDetails> r0 = r11.P
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r12)
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout"
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x00d3
            if (r12 == 0) goto L_0x00d3
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            if (r0 == 0) goto L_0x00d3
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x00d3
            boolean r0 = r11.O
            if (r0 != 0) goto L_0x00d3
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            boolean r0 = r0 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
            if (r0 == 0) goto L_0x0057
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            if (r0 == 0) goto L_0x0051
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r0 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r0
            r0.g()
            goto L_0x0057
        L_0x0051:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x0057:
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.CJRAmountPreFetchDetails> r0 = r11.P
            java.util.Map r0 = (java.util.Map) r0
            r0.put(r12, r3)
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            if (r0 == 0) goto L_0x0073
            android.widget.EditText r0 = r0.getMBillAmountEdt()
            if (r0 == 0) goto L_0x0073
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0073
            java.lang.String r0 = r0.toString()
            goto L_0x0074
        L_0x0073:
            r0 = r3
        L_0x0074:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0081
            int r0 = r0.length()
            if (r0 != 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r0 = 0
            goto L_0x0082
        L_0x0081:
            r0 = 1
        L_0x0082:
            r11.L = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = "recharge_number"
            r0.put(r2, r12)
            r11.O = r4
            r11.aa()
            net.one97.paytm.recharge.common.h.g r12 = r11.f61339f
            if (r12 == 0) goto L_0x00cb
            r5 = r12
            net.one97.paytm.recharge.dth.c.a r5 = (net.one97.paytm.recharge.dth.c.a) r5
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r12 = r11.r
            if (r12 == 0) goto L_0x00a2
            java.util.Map r3 = r12.a((boolean) r1, (boolean) r4)
        L_0x00a2:
            r7 = r3
            if (r7 != 0) goto L_0x00a8
            kotlin.g.b.k.a()
        L_0x00a8:
            r8 = r0
            java.util.Map r8 = (java.util.Map) r8
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r12 = r11.r
            if (r12 == 0) goto L_0x00b5
            org.json.JSONObject r12 = r12.getMetaData()
            if (r12 != 0) goto L_0x00ba
        L_0x00b5:
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
        L_0x00ba:
            r9 = r12
            net.one97.paytm.recharge.widgets.c.d r12 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r12 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            java.lang.String r6 = "fetch_dth_monthly_amount"
            r5.a((java.lang.String) r6, (java.util.Map<java.lang.String, java.lang.String>) r7, (java.util.Map<java.lang.String, java.lang.String>) r8, (org.json.JSONObject) r9, (java.lang.Object) r10)
            return
        L_0x00cb:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.dth.viewmodel.CJRDTHRechargeViewModel"
            r12.<init>(r0)
            throw r12
        L_0x00d3:
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.CJRAmountPreFetchDetails> r0 = r11.P
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r12)
            if (r0 == 0) goto L_0x0163
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            if (r0 == 0) goto L_0x00f1
            android.widget.EditText r0 = r0.getMBillAmountEdt()
            if (r0 == 0) goto L_0x00f1
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x00f1
            java.lang.String r3 = r0.toString()
        L_0x00f1:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x00fb
            int r0 = r3.length()
            if (r0 != 0) goto L_0x00fc
        L_0x00fb:
            r1 = 1
        L_0x00fc:
            if (r1 == 0) goto L_0x0163
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            boolean r0 = r0 instanceof net.one97.paytm.recharge.common.widget.CustomDthInputLayout
            if (r0 == 0) goto L_0x0123
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            if (r0 == 0) goto L_0x011d
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r0 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r0
            r0.f()
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            if (r0 == 0) goto L_0x0117
            net.one97.paytm.recharge.common.widget.CustomDthInputLayout r0 = (net.one97.paytm.recharge.common.widget.CustomDthInputLayout) r0
            r0.setErrorViewLayoutParam(r4)
            goto L_0x0123
        L_0x0117:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x011d:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x0123:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r0 = r11.r
            if (r0 == 0) goto L_0x013e
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.CJRAmountPreFetchDetails> r1 = r11.P
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r1 = r1.get(r12)
            net.one97.paytm.recharge.model.CJRAmountPreFetchDetails r1 = (net.one97.paytm.recharge.model.CJRAmountPreFetchDetails) r1
            if (r1 == 0) goto L_0x0139
            java.lang.String r1 = r1.getAmount()
            if (r1 != 0) goto L_0x013b
        L_0x0139:
            java.lang.String r1 = ""
        L_0x013b:
            r0.setAmountOnAmountField(r1)
        L_0x013e:
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.CJRAmountPreFetchDetails> r0 = r11.P
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r12 = r0.get(r12)
            net.one97.paytm.recharge.model.CJRAmountPreFetchDetails r12 = (net.one97.paytm.recharge.model.CJRAmountPreFetchDetails) r12
            if (r12 == 0) goto L_0x0153
            net.one97.paytm.common.entity.CJRRechargeCart r12 = r12.getCjrRechargeCart()
            if (r12 == 0) goto L_0x0153
            r11.b((net.one97.paytm.common.entity.CJRRechargeCart) r12)
        L_0x0153:
            net.one97.paytm.recharge.common.widget.CustomInputLinearLayout r12 = r11.r
            if (r12 == 0) goto L_0x0163
            net.one97.paytm.recharge.dth.a.g$h r0 = new net.one97.paytm.recharge.dth.a.g$h
            r0.<init>(r11)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r1 = 500(0x1f4, double:2.47E-321)
            r12.postDelayed(r0, r1)
        L_0x0163:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.g.i(java.lang.String):void");
    }

    private final void aa() {
        CustomInputLinearLayout customInputLinearLayout;
        if ((this.r instanceof CustomDthInputLayout) && (customInputLinearLayout = this.r) != null) {
            customInputLinearLayout.postDelayed(new t(this), 100);
        }
    }

    private final void ab() {
        if (this.r instanceof CustomDthInputLayout) {
            CustomInputLinearLayout customInputLinearLayout = this.r;
            if (customInputLinearLayout != null) {
                ((CustomDthInputLayout) customInputLinearLayout).e();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CustomDthInputLayout");
        }
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(cJRRechargeCart, "cjrRechargeCart");
        this.o = cJRRechargeCart;
        this.R = null;
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_fast_forward_dth);
        if (relativeLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.a(relativeLayout);
        }
        g(true);
    }
}
