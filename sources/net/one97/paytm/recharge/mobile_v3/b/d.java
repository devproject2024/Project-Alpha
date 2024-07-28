package net.one97.paytm.recharge.mobile_v3.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRServiceActions;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.c.g;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.common.widget.UtilityThinBannersLayout;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8;
import net.one97.paytm.recharge.mobile_v3.a.a;
import net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJROutstandingAmountDisplayValuesV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.model.CJRPromoCode;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.model.rechargeutility.CJRSuccessRateAlertMessage;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public class d extends net.one97.paytm.recharge.mobile.a.d implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, net.one97.paytm.recharge.common.e.ad, net.one97.paytm.recharge.common.e.ae, net.one97.paytm.recharge.common.e.ai, net.one97.paytm.recharge.common.e.i, net.one97.paytm.recharge.common.e.u, net.one97.paytm.recharge.common.e.w, UtilityThinBannersLayout.b, a.b, net.one97.paytm.recharge.mobile_v3.d.a, net.one97.paytm.recharge.mobile_v3.d.b {
    /* access modifiers changed from: private */
    public static final String aI;
    public static final a s = new a((byte) 0);
    private CJRInputFieldsItem A;
    private List<CJRAggsItem> B;
    private List<? extends CJRBrowsePlanProductList> C;
    private boolean D;
    /* access modifiers changed from: private */
    public boolean E;
    private String F;
    private boolean G = true;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private StringBuilder N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    /* access modifiers changed from: private */
    public final Handler S = new Handler();
    private io.reactivex.rxjava3.b.c T;
    private final io.reactivex.rxjava3.j.b<String> U;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> V;
    private boolean W;
    private boolean X;
    private boolean Y;
    /* access modifiers changed from: private */
    public boolean Z;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private net.one97.paytm.recharge.common.c.g aD;
    private View.OnClickListener aE;
    private View.OnClickListener aF;
    private final View.OnClickListener aG;
    private final g.a aH;
    private HashMap aJ;
    /* access modifiers changed from: private */
    public boolean aa;
    private boolean ab;
    /* access modifiers changed from: private */
    public boolean ac;
    /* access modifiers changed from: private */
    public NestedScrollView ad;
    private int ae;
    /* access modifiers changed from: private */
    public CJRPromoWidgetV3 af;
    private View ag;
    private net.one97.paytm.recharge.mobile_v3.a.b ah;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.mobile_v3.a.c ai;
    private boolean aj;
    private boolean ak;
    private boolean al;
    private String am;
    private CollapsingToolbarLayout an;
    private AppBarLayout ao;
    /* access modifiers changed from: private */
    public ViewGroup ap;
    private int aq;
    private CJRMobileFastForwardWidgetV8 ar;
    private boolean as;
    /* access modifiers changed from: private */
    public boolean at;
    /* access modifiers changed from: private */
    public CJRProceedWidgetV8 au;
    /* access modifiers changed from: private */
    public boolean av;
    private CJRCircleImageViewV8 aw;
    private TextView ax;
    private boolean ay;
    private boolean az;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public CJRRechargeCart f63788f;
    /* access modifiers changed from: package-private */
    public CJRProductsItem n;
    /* access modifiers changed from: package-private */
    public CJRAmountInputFieldWidgetV3 o;
    boolean p;
    CJRSuccessRateAlertMessage q;
    net.one97.paytm.recharge.common.utils.aa r;
    private final String t = "scroll.view.height";
    private net.one97.paytm.recharge.common.utils.o u;
    private CJRPromoCode v;
    private net.one97.paytm.recharge.mobile_v3.a.d w;
    private net.one97.paytm.recharge.mobile_v3.a.a x;
    /* access modifiers changed from: private */
    public CJRPersonalInsurance y;
    private androidx.lifecycle.z<CJRBrowsePlanProductList> z;

    public final void a(CJRHomePageItem cJRHomePageItem) {
        kotlin.g.b.k.c(cJRHomePageItem, "item");
    }

    public final View b(int i2) {
        if (this.aJ == null) {
            this.aJ = new HashMap();
        }
        View view = (View) this.aJ.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.aJ.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void u() {
        HashMap hashMap = this.aJ;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class ad<T> implements io.reactivex.rxjava3.d.q<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63792a;

        ad(d dVar) {
            this.f63792a = dVar;
        }

        public final /* synthetic */ boolean test(Object obj) {
            String str = (String) obj;
            kotlin.g.b.k.a((Object) str, "it");
            if (kotlin.m.p.a(str)) {
                this.f63792a.d(true);
                return false;
            }
            this.f63792a.d(false);
            return true;
        }
    }

    static final class ae<T, R> implements io.reactivex.rxjava3.d.h<T, io.reactivex.rxjava3.a.u<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63793a;

        ae(d dVar) {
            this.f63793a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            final String str = (String) obj;
            return io.reactivex.rxjava3.a.y.a(new io.reactivex.rxjava3.a.ab<IJRPaytmDataModel>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ae f63794a;

                {
                    this.f63794a = r1;
                }

                public final void subscribe(io.reactivex.rxjava3.a.z<IJRPaytmDataModel> zVar) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    final CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    a2.setErrorType(ERROR_TYPE.UNDEFINED);
                    CRUFlowModel flowName = a2.getFlowName();
                    if (flowName != null) {
                        flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                    }
                    CRUFlowModel flowName2 = a2.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setActionType(ACTION_TYPE.PLAN_AMOUNT_SEARCH.name());
                    }
                    if (this.f63794a.f63793a.V != null) {
                        net.one97.paytm.recharge.common.e.a i2 = this.f63794a.f63793a.V;
                        if (i2 == null) {
                            kotlin.g.b.k.a();
                        }
                        i2.a(zVar);
                        this.f63794a.f63793a.S.post(new Runnable(this) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ AnonymousClass1 f63796a;

                            {
                                this.f63796a = r1;
                            }

                            public final void run() {
                                if (this.f63796a.f63794a.f63793a.V != null) {
                                    d dVar = this.f63796a.f63794a.f63793a;
                                    String str = str;
                                    kotlin.g.b.k.a((Object) str, "searchedQuery");
                                    CJRRechargeErrorModel cJRRechargeErrorModel = a2;
                                    net.one97.paytm.recharge.common.e.a i2 = this.f63796a.f63794a.f63793a.V;
                                    if (i2 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    dVar.a("search_browse_plan", str, (Object) cJRRechargeErrorModel, (net.one97.paytm.recharge.common.e.ai) i2);
                                    return;
                                }
                                d dVar2 = this.f63796a.f63794a.f63793a;
                                String str2 = str;
                                kotlin.g.b.k.a((Object) str2, "searchedQuery");
                                d.a(dVar2, "search_browse_plan", str2, a2, (net.one97.paytm.recharge.common.e.ai) null, 8);
                            }
                        });
                    }
                }
            }).e().subscribeOn(io.reactivex.rxjava3.i.a.b());
        }
    }

    static final class t<T> implements androidx.lifecycle.z<CJRBrowsePlanProductList> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63839a;

        t(d dVar) {
            this.f63839a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRBrowsePlanProductList cJRBrowsePlanProductList = (CJRBrowsePlanProductList) obj;
            if (cJRBrowsePlanProductList != null && !this.f63839a.E) {
                this.f63839a.a(cJRBrowsePlanProductList);
            }
        }
    }

    static final class v extends kotlin.g.b.l implements kotlin.g.a.b<LinkedList<CJRSelectedGroupItem>, kotlin.x> {
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(d dVar) {
            super(1);
            this.this$0 = dVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LinkedList<CJRSelectedGroupItem>) (LinkedList) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(LinkedList<CJRSelectedGroupItem> linkedList) {
            if (linkedList != null && !linkedList.isEmpty()) {
                d.a(this.this$0, (LinkedList) linkedList);
                d.b(this.this$0, (LinkedList) linkedList);
            }
        }
    }

    static final class w extends kotlin.g.b.l implements kotlin.g.a.b<CJRProductsItem, kotlin.x> {
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(d dVar) {
            super(1);
            this.this$0 = dVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRProductsItem) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRProductsItem cJRProductsItem) {
            net.one97.paytm.recharge.mobile.d.a d2;
            net.one97.paytm.recharge.mobile.d.a d3;
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            if (cJRProductsItem != null) {
                this.this$0.n = cJRProductsItem;
                d dVar2 = this.this$0;
                Object obj = null;
                dVar2.q = null;
                dVar2.p = false;
                CJRProductsItem cJRProductsItem2 = dVar2.n;
                if (cJRProductsItem2 != null) {
                    Long productId = cJRProductsItem2.getProductId();
                    if ((productId != null ? productId.longValue() : 0) > 0) {
                        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                        CRUFlowModel flowName = a2.getFlowName();
                        if (flowName != null) {
                            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                        }
                        CRUFlowModel flowName2 = a2.getFlowName();
                        if (flowName2 != null) {
                            flowName2.setActionType(ACTION_TYPE.SUCCESS_RATE_ALERT.name());
                        }
                        net.one97.paytm.recharge.common.utils.aa aaVar = dVar2.r;
                        if (aaVar != null) {
                            String operator = cJRProductsItem2.getOperator();
                            Long productId2 = cJRProductsItem2.getProductId();
                            if (productId2 == null) {
                                kotlin.g.b.k.a();
                            }
                            aaVar.a("success_rate_alert_message", operator, productId2.longValue(), cJRProductsItem2.getService(), cJRProductsItem2.getPaytype(), cJRProductsItem2.getCircle(), a2);
                        }
                    }
                }
                this.this$0.a(cJRProductsItem);
                this.this$0.e();
                d.c(this.this$0);
                CJRProductsItem a3 = this.this$0.n;
                if (!((a3 != null ? a3.getOperator() : null) == null || (d2 = this.this$0.f63600h) == null || d2.P || (d3 = this.this$0.f63600h) == null || (dVar = d3.v) == null)) {
                    net.one97.paytm.recharge.mobile.d.a d4 = this.this$0.f63600h;
                    if (d4 != null) {
                        obj = d4.e();
                    }
                    Object obj2 = obj;
                    if (obj2 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJRProductsItem a4 = this.this$0.n;
                    if (a4 == null) {
                        kotlin.g.b.k.a();
                    }
                    String operator2 = a4.getOperator();
                    if (operator2 == null) {
                        kotlin.g.b.k.a();
                    }
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, "Operator_dropdown_item_selected", (Object) null, operator2, (Object) null, "auto", (Object) null, 84);
                }
                net.one97.paytm.recharge.mobile.d.a d5 = this.this$0.f63600h;
                if (d5 != null) {
                    d5.P = false;
                }
            }
        }
    }

    static final class x extends kotlin.g.b.l implements kotlin.g.a.b<CJRPersonalInsurance, kotlin.x> {
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(d dVar) {
            super(1);
            this.this$0 = dVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRPersonalInsurance) obj);
            return kotlin.x.f47997a;
        }

        public final void invoke(CJRPersonalInsurance cJRPersonalInsurance) {
            String str = null;
            if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null)) {
                if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getProductID() : null)) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.INSURANCE_LOADED);
                    if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null)) {
                        TextView textView = (TextView) this.this$0.b(R.id.insurance_title);
                        if (textView != null) {
                            textView.setText(cJRPersonalInsurance != null ? cJRPersonalInsurance.getTitleForPersonalInsurance() : null);
                        }
                        TextView textView2 = (TextView) this.this$0.b(R.id.insurance_title);
                        if (textView2 != null) {
                            net.one97.paytm.recharge.common.utils.ai.a(textView2);
                        }
                    } else {
                        TextView textView3 = (TextView) this.this$0.b(R.id.insurance_title);
                        if (textView3 != null) {
                            net.one97.paytm.recharge.common.utils.ai.b(textView3);
                        }
                    }
                    if (!TextUtils.isEmpty(cJRPersonalInsurance != null ? cJRPersonalInsurance.getSubTitleForPersonalInsurance() : null)) {
                        TextView textView4 = (TextView) this.this$0.b(R.id.insurance_subtitle);
                        if (textView4 != null) {
                            if (cJRPersonalInsurance != null) {
                                str = cJRPersonalInsurance.getSubTitleForPersonalInsurance();
                            }
                            textView4.setText(str);
                        }
                        TextView textView5 = (TextView) this.this$0.b(R.id.insurance_subtitle);
                        if (textView5 != null) {
                            net.one97.paytm.recharge.common.utils.ai.a(textView5);
                        }
                    } else {
                        TextView textView6 = (TextView) this.this$0.b(R.id.insurance_subtitle);
                        if (textView6 != null) {
                            net.one97.paytm.recharge.common.utils.ai.b(textView6);
                        }
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) this.this$0.b(R.id.insurance_layout);
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    d dVar2 = this.this$0;
                    dVar2.a(dVar2.at);
                    this.this$0.y = cJRPersonalInsurance;
                }
            }
        }
    }

    public d() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        kotlin.g.b.k.a((Object) a2, "PublishSubject.create()");
        this.U = a2;
        this.aE = new l(this);
        this.aF = new k(this);
        this.aG = new j(this);
        this.aH = new ac(this);
    }

    public final void a(CJRRechargeErrorModel cJRRechargeErrorModel) {
        String str;
        String code;
        if (getActivity() != null && this.f63600h != null) {
            View view = getView();
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = null;
            ViewGroup viewGroup = view != null ? (ViewGroup) view.findViewById(R.id.lyt_recreate_loader) : null;
            View view2 = getView();
            if (view2 != null) {
                cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) view2.findViewById(R.id.recreate_progress_bar);
            }
            if (cJRRechargeLottieAnimationView != null) {
                cJRRechargeLottieAnimationView.playAnimation();
            }
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            String categoryId = aVar.r.getCategoryId();
            String str2 = "";
            if (categoryId == null) {
                categoryId = str2;
            }
            Map hashMap = new HashMap();
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 == null) {
                kotlin.g.b.k.a();
            }
            String str3 = (String) aVar2.z.getValue();
            if (str3 == null) {
                str3 = str2;
            }
            hashMap.put("recharge_number", str3);
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 == null || (str = cJRAmountInputFieldWidgetV3.getInputText()) == null) {
                str = str2;
            }
            hashMap.put("price", str);
            CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV8 = this.ar;
            hashMap.put("ff", (cJRMobileFastForwardWidgetV8 == null || !cJRMobileFastForwardWidgetV8.a()) ? UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT : "Y");
            CJRPromoCode cJRPromoCode = this.v;
            if (!(cJRPromoCode == null || (code = cJRPromoCode.getCode()) == null)) {
                str2 = code;
            }
            hashMap.put(PayUtility.PROMO_CODE, str2);
            if (cJRRechargeErrorModel != null) {
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            cJRRechargeUtilities.launchDeeplinkOnRecreate(activity, categoryId, hashMap);
        }
    }

    public void onCreate(Bundle bundle) {
        CJRItem cJRItem;
        CJRItem cJRItem2;
        net.one97.paytm.recharge.mobile.d.a aVar;
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        HashMap<String, String> hashMap3;
        HashMap<String, String> hashMap4;
        HashMap<String, String> hashMap5;
        HashMap<String, String> hashMap6;
        HashMap<String, String> hashMap7;
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.e();
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.a((net.one97.paytm.recharge.common.e.p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar3 = this.f63599g;
        if (dVar3 != null) {
            dVar3.f();
        }
        net.one97.paytm.recharge.mobile.d dVar4 = this.f63599g;
        if (dVar4 != null) {
            dVar4.a((net.one97.paytm.recharge.common.e.n) this);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.Z = arguments.getBoolean("is_recharge_tabs_flow", false);
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        String str = null;
        if (aVar3 != null) {
            cJRItem = aVar3.r;
        } else {
            cJRItem = null;
        }
        if (cJRItem instanceof CJRHomePageItem) {
            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
            if (aVar4 != null) {
                cJRItem2 = aVar4.r;
            } else {
                cJRItem2 = null;
            }
            if (cJRItem2 != null) {
                this.ab = ((CJRHomePageItem) cJRItem2).isAppLink();
                net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
                if (aVar5 != null) {
                    aVar5.N = this.ab;
                }
                if (this.ab && (aVar = this.f63600h) != null && (hashMap = aVar.m) != null && (!hashMap.isEmpty())) {
                    net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
                    if (aVar6 == null || (hashMap6 = aVar6.m) == null || !hashMap6.containsKey("recharge_number")) {
                        net.one97.paytm.recharge.mobile.d.a aVar7 = this.f63600h;
                        if (aVar7 == null || (hashMap4 = aVar7.m) == null || !hashMap4.containsKey("number")) {
                            net.one97.paytm.recharge.mobile.d.a aVar8 = this.f63600h;
                            if (aVar8 != null && (hashMap2 = aVar8.m) != null && hashMap2.containsKey(ContactColumn.PHONE_NUMBER) && (aVar2 = this.f63600h) != null) {
                                net.one97.paytm.recharge.mobile.d.a aVar9 = this.f63600h;
                                if (!(aVar9 == null || (hashMap3 = aVar9.m) == null)) {
                                    str = hashMap3.get(ContactColumn.PHONE_NUMBER);
                                }
                                aVar2.M = str;
                                return;
                            }
                            return;
                        }
                        net.one97.paytm.recharge.mobile.d.a aVar10 = this.f63600h;
                        if (aVar10 != null) {
                            net.one97.paytm.recharge.mobile.d.a aVar11 = this.f63600h;
                            if (!(aVar11 == null || (hashMap5 = aVar11.m) == null)) {
                                str = hashMap5.get("number");
                            }
                            aVar10.M = str;
                            return;
                        }
                        return;
                    }
                    net.one97.paytm.recharge.mobile.d.a aVar12 = this.f63600h;
                    if (aVar12 != null) {
                        net.one97.paytm.recharge.mobile.d.a aVar13 = this.f63600h;
                        if (!(aVar13 == null || (hashMap7 = aVar13.m) == null)) {
                            str = hashMap7.get("recharge_number");
                        }
                        aVar12.M = str;
                        return;
                    }
                    return;
                }
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRHomePageItem");
        }
    }

    public void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.recharge.mobile.d) {
            this.r = ((net.one97.paytm.recharge.mobile.d) context).b();
            net.one97.paytm.recharge.common.utils.aa aaVar = this.r;
            if (aaVar == null) {
                this.r = new net.one97.paytm.recharge.common.utils.aa(context, this);
            } else if (aaVar != null) {
                aaVar.a((net.one97.paytm.recharge.common.e.w) this);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_fragment_enter_mobile_recharge_amount, viewGroup, false);
    }

    static final class u implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63840a;

        u(d dVar) {
            this.f63840a = dVar;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (appBarLayout != null && appBarLayout.getTotalScrollRange() != 0) {
                RelativeLayout relativeLayout = (RelativeLayout) this.f63840a.b(R.id.container_main_header);
                kotlin.g.b.k.a((Object) relativeLayout, "container_main_header");
                relativeLayout.setAlpha(1.0f - ((float) Math.abs(i2 / appBarLayout.getTotalScrollRange())));
            }
        }
    }

    static final class y implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63841a;

        y(d dVar) {
            this.f63841a = dVar;
        }

        public final void onClick(View view) {
            CheckBox checkBox = (CheckBox) this.f63841a.b(R.id.insurance_checkbox);
            if (checkBox != null) {
                checkBox.performClick();
            }
        }
    }

    static final class z implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63842a;

        z(d dVar) {
            this.f63842a = dVar;
        }

        public final void onClick(View view) {
            CJRCart cart;
            String finalPrice;
            Object obj;
            String str;
            String productID;
            CheckBox checkBox = (CheckBox) this.f63842a.b(R.id.insurance_checkbox);
            String str2 = null;
            if (checkBox == null || !checkBox.isChecked()) {
                Context context = this.f63842a.getContext();
                if (context != null) {
                    kotlin.g.b.k.a((Object) context, "context");
                    net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                    net.one97.paytm.recharge.mobile.d.a d2 = this.f63842a.f63600h;
                    if (d2 == null || (obj = d2.e()) == null) {
                        obj = "";
                    }
                    CJRPersonalInsurance f2 = this.f63842a.y;
                    if (f2 == null || (productID = f2.getProductID()) == null) {
                        str = "";
                    } else {
                        str = productID;
                    }
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "upsell_widget_unchecked", "", str, (Object) null, (Object) null, (Object) null, 112);
                }
                this.f63842a.c();
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.INSURANCE_REMOVE_CLICKED);
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.INSURANCE_REMOVE_VERIFY.name());
                }
                d dVar4 = this.f63842a;
                d.a(dVar4, "remove_insurance_verify", dVar4, false, false, a2, 12);
            } else {
                CheckBox checkBox2 = (CheckBox) this.f63842a.b(R.id.insurance_checkbox);
                if (checkBox2 != null) {
                    checkBox2.setChecked(false);
                }
                TextView textView = (TextView) this.f63842a.b(R.id.insurance_title);
                if (textView != null) {
                    textView.setSelected(false);
                }
                TextView textView2 = (TextView) this.f63842a.b(R.id.insurance_subtitle);
                if (textView2 != null) {
                    textView2.setSelected(false);
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.f63842a.b(R.id.insurance_layout);
                if (relativeLayout != null) {
                    relativeLayout.performClick();
                }
            }
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f63842a.b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                d dVar5 = this.f63842a;
                CJRRechargeCart g2 = dVar5.f63788f;
                if (g2 == null || (cart = g2.getCart()) == null || (finalPrice = cart.getFinalPrice()) == null) {
                    CJRAmountInputFieldWidgetV3 h2 = this.f63842a.o;
                    if (h2 != null) {
                        str2 = h2.getFormattedString();
                    }
                } else {
                    str2 = finalPrice;
                }
                cJRProceedWidgetV8.setProceedBtnText(dVar5.a(str2));
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        kotlin.g.b.k.c(menu, "menu");
        kotlin.g.b.k.c(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        e();
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2) {
        if (z2) {
            RelativeLayout relativeLayout = (RelativeLayout) b(R.id.insurance_layout);
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(this);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) b(R.id.insurance_layout);
            if (relativeLayout2 != null) {
                relativeLayout2.setEnabled(true);
            }
            TextView textView = (TextView) b(R.id.insurance_title);
            if (textView != null) {
                textView.setEnabled(true);
            }
            TextView textView2 = (TextView) b(R.id.insurance_subtitle);
            if (textView2 != null) {
                textView2.setEnabled(true);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) b(R.id.insurance_layout);
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener((View.OnClickListener) null);
        }
        RelativeLayout relativeLayout4 = (RelativeLayout) b(R.id.insurance_layout);
        if (relativeLayout4 != null) {
            relativeLayout4.setEnabled(false);
        }
        TextView textView3 = (TextView) b(R.id.insurance_title);
        if (textView3 != null) {
            textView3.setEnabled(false);
        }
        TextView textView4 = (TextView) b(R.id.insurance_subtitle);
        if (textView4 != null) {
            textView4.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        FJRRechargeUtilityBaseV2.b bVar;
        CJRProductsItem cJRProductsItem = this.n;
        if (cJRProductsItem != null) {
            if (cJRProductsItem == null) {
                kotlin.g.b.k.a();
            }
            String bbpsLogoUrl = cJRProductsItem.getBbpsLogoUrl();
            if (bbpsLogoUrl == null) {
                CJRProductsItem cJRProductsItem2 = this.n;
                if (cJRProductsItem2 == null) {
                    kotlin.g.b.k.a();
                }
                bbpsLogoUrl = cJRProductsItem2.getBbps_logo_url();
            }
            if (bbpsLogoUrl == null) {
                bbpsLogoUrl = "";
            }
            if (!TextUtils.isEmpty(bbpsLogoUrl) && (bVar = this.j) != null) {
                bVar.a(bbpsLogoUrl);
            }
        }
    }

    static final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63832a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ StringBuilder f63833b;

        r(d dVar, StringBuilder sb) {
            this.f63832a = dVar;
            this.f63833b = sb;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.z;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                net.one97.paytm.recharge.mobile_v3.b.d r0 = r5.f63832a
                net.one97.paytm.recharge.mobile.d.a r0 = r0.f63600h
                if (r0 == 0) goto L_0x0015
                androidx.lifecycle.y<java.lang.String> r0 = r0.z
                androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
                if (r0 == 0) goto L_0x0015
                java.lang.Object r0 = r0.getValue()
                java.lang.String r0 = (java.lang.String) r0
                goto L_0x0016
            L_0x0015:
                r0 = 0
            L_0x0016:
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x005e
                net.one97.paytm.recharge.common.utils.n r1 = net.one97.paytm.recharge.common.utils.n.f61679a
                if (r0 != 0) goto L_0x0026
                kotlin.g.b.k.a()
            L_0x0026:
                net.one97.paytm.recharge.model.ContactItemModel r1 = net.one97.paytm.recharge.common.utils.n.a((java.lang.String) r0)
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x0034
                java.lang.String r1 = r1.getName()
                if (r1 != 0) goto L_0x0035
            L_0x0034:
                r1 = r2
            L_0x0035:
                kotlin.g.b.x$e r3 = new kotlin.g.b.x$e
                r3.<init>()
                net.one97.paytm.recharge.common.utils.n r4 = net.one97.paytm.recharge.common.utils.n.f61679a
                net.one97.paytm.recharge.model.ContactItemModel r0 = net.one97.paytm.recharge.common.utils.n.a((java.lang.String) r0)
                if (r0 == 0) goto L_0x0048
                java.lang.String r0 = r0.getPhotoUri()
                if (r0 != 0) goto L_0x0049
            L_0x0048:
                r0 = r2
            L_0x0049:
                r3.element = r0
                android.os.Handler r0 = new android.os.Handler
                android.os.Looper r2 = android.os.Looper.getMainLooper()
                r0.<init>(r2)
                net.one97.paytm.recharge.mobile_v3.b.d$r$1 r2 = new net.one97.paytm.recharge.mobile_v3.b.d$r$1
                r2.<init>(r5, r1, r3)
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                r0.post(r2)
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.r.run():void");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:49|50|51|(3:53|(1:55)|56)|57|58|(3:60|(1:62)|63)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0133 */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0137 A[Catch:{ Exception -> 0x014e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.CJRProductsItem r17) {
        /*
            r16 = this;
            r6 = r16
            r0 = r17
            java.lang.String r1 = "selectedProduct"
            kotlin.g.b.k.c(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Group: "
            r1.<init>(r2)
            int r2 = net.one97.paytm.recharge.R.id.txt_operator
            android.view.View r2 = r6.b((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "txt_operator"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r2 = r2.getText()
            r1.append(r2)
            java.lang.String r2 = ": PID: "
            r1.append(r2)
            java.lang.Long r2 = r17.getProductId()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.paytm.utility.q.d(r1)
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = net.one97.paytm.recharge.widgets.c.d.b()
            java.lang.Long r2 = r17.getProductId()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setProductId(r2)
            net.one97.paytm.recharge.common.b.a r1 = r6.f63601i
            if (r1 == 0) goto L_0x004f
            r1.f60870a = r0
        L_0x004f:
            net.one97.paytm.recharge.common.b.a r0 = r6.f63601i
            r7 = 2
            r8 = 0
            r9 = 0
            r10 = 1
            if (r0 == 0) goto L_0x0494
            boolean r0 = r0.b()
            if (r0 != r10) goto L_0x0494
            net.one97.paytm.recharge.common.b.a r0 = r6.f63601i
            if (r0 != 0) goto L_0x0064
            kotlin.g.b.k.a()
        L_0x0064:
            android.content.Context r1 = r16.getContext()
            if (r1 != 0) goto L_0x006d
            kotlin.g.b.k.a()
        L_0x006d:
            java.lang.String r2 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.view.View r0 = r0.a((android.content.Context) r1)
            if (r0 == 0) goto L_0x007d
            java.lang.Object r1 = r0.getTag()
            goto L_0x007e
        L_0x007d:
            r1 = r9
        L_0x007e:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.common.b.a.C1172a
            if (r2 != 0) goto L_0x0083
            r1 = r9
        L_0x0083:
            net.one97.paytm.recharge.common.b.a$a r1 = (net.one97.paytm.recharge.common.b.a.C1172a) r1
            if (r1 == 0) goto L_0x008a
            net.one97.paytm.recharge.common.b.a$b r1 = r1.f60875a
            goto L_0x008b
        L_0x008a:
            r1 = r9
        L_0x008b:
            if (r1 != 0) goto L_0x008e
            goto L_0x004f
        L_0x008e:
            int[] r2 = net.one97.paytm.recharge.mobile_v3.b.e.f63843a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r10) goto L_0x0099
            goto L_0x004f
        L_0x0099:
            boolean r1 = r0 instanceof net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3
            if (r1 == 0) goto L_0x004f
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = (net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3) r0
            java.lang.String r1 = "view"
            kotlin.g.b.k.c(r0, r1)
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r6.o
            if (r1 == 0) goto L_0x00ae
            java.lang.String r1 = r1.getInputText()
            goto L_0x00af
        L_0x00ae:
            r1 = r9
        L_0x00af:
            r6.o = r0
            r2 = r6
            net.one97.paytm.recharge.mobile_v3.d.b r2 = (net.one97.paytm.recharge.mobile_v3.d.b) r2
            r0.setOnKeyUpDownListener(r2)
            r0.b()
            r2 = r6
            android.view.View$OnFocusChangeListener r2 = (android.view.View.OnFocusChangeListener) r2
            r0.setInputFocusChangeListener(r2)
            r2 = r6
            android.text.TextWatcher r2 = (android.text.TextWatcher) r2
            r0.setInputFieldTextChangeListener(r2)
            r0.setLargeAmount()
            int r2 = net.one97.paytm.recharge.R.color.v3_text_2
            r0.setInputHintTextColor(r2)
            r16.getContext()
            net.one97.paytm.recharge.common.utils.ba.a()
            int r2 = net.one97.paytm.recharge.R.string.amount
            java.lang.String r2 = r6.getString(r2)
            r0.setInputHintText((java.lang.String) r2)
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r2 = r6.o
            if (r2 != 0) goto L_0x00e4
            kotlin.g.b.k.a()
        L_0x00e4:
            net.one97.paytm.recharge.mobile_v3.b.d$b r3 = new net.one97.paytm.recharge.mobile_v3.b.d$b
            r3.<init>(r6)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setInputFieldClickListener(r3)
            boolean r2 = r6.R
            if (r2 != 0) goto L_0x00f6
            boolean r2 = r6.E
            if (r2 == 0) goto L_0x00fd
        L_0x00f6:
            if (r1 != 0) goto L_0x00fa
            java.lang.String r1 = ""
        L_0x00fa:
            r0.setInputText(r1)
        L_0x00fd:
            java.lang.Object r1 = r0.getTag()
            boolean r1 = r1 instanceof net.one97.paytm.recharge.common.b.a.C1172a
            if (r1 == 0) goto L_0x0158
            java.lang.Object r1 = r0.getTag()
            if (r1 == 0) goto L_0x0150
            net.one97.paytm.recharge.common.b.a$a r1 = (net.one97.paytm.recharge.common.b.a.C1172a) r1
            java.lang.Object r2 = r1.f60877c
            boolean r2 = r2 instanceof net.one97.paytm.recharge.model.v4.CJRInputFieldsItem
            if (r2 == 0) goto L_0x0158
            java.lang.Object r1 = r1.f60877c
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r1
            r6.A = r1
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = r6.A     // Catch:{ Exception -> 0x0133 }
            if (r1 == 0) goto L_0x0133
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = r6.n     // Catch:{ Exception -> 0x0133 }
            if (r2 != 0) goto L_0x0124
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0133 }
        L_0x0124:
            java.lang.String r2 = r2.getMinAmount()     // Catch:{ Exception -> 0x0133 }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x0133 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0133 }
            r1.setMin(r2)     // Catch:{ Exception -> 0x0133 }
        L_0x0133:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = r6.A     // Catch:{ Exception -> 0x014e }
            if (r1 == 0) goto L_0x0158
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = r6.n     // Catch:{ Exception -> 0x014e }
            if (r2 != 0) goto L_0x013e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x014e }
        L_0x013e:
            java.lang.String r2 = r2.getMaxAmount()     // Catch:{ Exception -> 0x014e }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x014e }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x014e }
            r1.setMax(r2)     // Catch:{ Exception -> 0x014e }
            goto L_0x0158
        L_0x014e:
            goto L_0x0158
        L_0x0150:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.data.CJRCategoryInputFieldHelperV8.Entry"
            r0.<init>(r1)
            throw r0
        L_0x0158:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0167
            int r1 = net.one97.paytm.recharge.R.string.transition_name_input_field_with_action
            java.lang.String r1 = r6.getString(r1)
            r0.setTransitionName(r1)
        L_0x0167:
            int r1 = net.one97.paytm.recharge.R.id.container_product_input_fields
            android.view.View r1 = r6.b((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 == 0) goto L_0x0176
            android.view.View r0 = (android.view.View) r0
            r1.addView(r0)
        L_0x0176:
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x018d
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r0 = r0.y
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x018d
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r0 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r0
            if (r0 == 0) goto L_0x018d
            java.lang.String r0 = r0.getValue()
            goto L_0x018e
        L_0x018d:
            r0 = r9
        L_0x018e:
            java.lang.String r1 = "postpaid"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r10)
            java.lang.String r2 = "prepaid"
            if (r1 == 0) goto L_0x0220
            r6.Y = r10
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x01a0
            r0.O = r10
        L_0x01a0:
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x01f1
            boolean r0 = r0.f61411d
            if (r0 != 0) goto L_0x01f1
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x01b2
            boolean r0 = r0.isPrefetch()
            if (r0 == r10) goto L_0x01e6
        L_0x01b2:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x01bc
            boolean r0 = r0.isFetchAmount()
            if (r0 == r10) goto L_0x01e6
        L_0x01bc:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x01f1
            boolean r0 = r0.isVodaFetchBill()
            if (r0 != r10) goto L_0x01f1
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x01f1
            androidx.lifecycle.y<java.lang.String> r0 = r0.z
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x01f1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x01f1
            android.content.Context r1 = r16.getContext()
            java.lang.String r1 = com.paytm.utility.b.l((android.content.Context) r1)
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r10)
            if (r0 != r10) goto L_0x01f1
        L_0x01e6:
            r6.I = r10
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FETCH_BILL
            java.lang.String r1 = "fetch_mobile_bill_in_bg"
            r6.b((java.lang.String) r1, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            r0 = 1
            goto L_0x01f2
        L_0x01f1:
            r0 = 0
        L_0x01f2:
            if (r0 != 0) goto L_0x0339
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 == 0) goto L_0x01fd
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r1.j()
            goto L_0x01fe
        L_0x01fd:
            r1 = r9
        L_0x01fe:
            if (r1 == 0) goto L_0x0339
            net.one97.paytm.common.entity.recharge.CJRBillDetails r1 = r1.getCjrBillDetails()
            if (r1 == 0) goto L_0x0339
            r6.at = r10
            java.lang.Double r1 = r1.getAmount()
            if (r1 == 0) goto L_0x0217
            double r3 = r1.doubleValue()
            java.lang.String r1 = java.lang.String.valueOf(r3)
            goto L_0x0218
        L_0x0217:
            r1 = r9
        L_0x0218:
            r6.a((java.lang.String) r1, (boolean) r10)
            r16.C()
            goto L_0x0339
        L_0x0220:
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r10)
            if (r0 == 0) goto L_0x0338
            net.one97.paytm.recharge.common.e.a<com.paytm.network.model.IJRPaytmDataModel> r0 = r6.V
            if (r0 != 0) goto L_0x0277
            if (r0 == 0) goto L_0x022f
            r0.a()
        L_0x022f:
            net.one97.paytm.recharge.common.e.a r0 = new net.one97.paytm.recharge.common.e.a
            r1 = r6
            net.one97.paytm.recharge.common.e.ae r1 = (net.one97.paytm.recharge.common.e.ae) r1
            java.lang.String r3 = "search_browse_plan"
            r0.<init>(r3, r1)
            r6.V = r0
            io.reactivex.rxjava3.j.b<java.lang.String> r0 = r6.U
            r3 = 600(0x258, double:2.964E-321)
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            io.reactivex.rxjava3.a.p r0 = r0.debounce(r3, r1)
            net.one97.paytm.recharge.mobile_v3.b.d$ad r1 = new net.one97.paytm.recharge.mobile_v3.b.d$ad
            r1.<init>(r6)
            io.reactivex.rxjava3.d.q r1 = (io.reactivex.rxjava3.d.q) r1
            io.reactivex.rxjava3.a.p r0 = r0.filter(r1)
            net.one97.paytm.recharge.mobile_v3.b.d$ae r1 = new net.one97.paytm.recharge.mobile_v3.b.d$ae
            r1.<init>(r6)
            io.reactivex.rxjava3.d.h r1 = (io.reactivex.rxjava3.d.h) r1
            io.reactivex.rxjava3.a.p r0 = r0.switchMap(r1)
            io.reactivex.rxjava3.a.x r1 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.p r0 = r0.subscribeOn(r1)
            io.reactivex.rxjava3.a.x r1 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.p r0 = r0.observeOn(r1)
            net.one97.paytm.recharge.common.e.a<com.paytm.network.model.IJRPaytmDataModel> r1 = r6.V
            if (r1 != 0) goto L_0x0272
            kotlin.g.b.k.a()
        L_0x0272:
            io.reactivex.rxjava3.a.w r1 = (io.reactivex.rxjava3.a.w) r1
            r0.subscribe(r1)
        L_0x0277:
            r6.Y = r8
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x027f
            r0.O = r8
        L_0x027f:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x02ec
            boolean r0 = r0.getShowBrowsePlan()
            if (r0 != r10) goto L_0x02ec
            r6.P = r10
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r6.o
            if (r0 == 0) goto L_0x029a
            android.widget.TextView r0 = r0.getActionPrimaryText()
            if (r0 == 0) goto L_0x029a
            int r1 = net.one97.paytm.recharge.R.drawable.v3_bg_action_1
            r0.setBackgroundResource(r1)
        L_0x029a:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r6.o
            if (r0 == 0) goto L_0x02a9
            android.widget.TextView r0 = r0.getActionPrimaryText()
            if (r0 == 0) goto L_0x02a9
            r1 = 1092616192(0x41200000, float:10.0)
            r0.setTextSize(r7, r1)
        L_0x02a9:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r6.o
            if (r0 == 0) goto L_0x02bf
            int r1 = net.one97.paytm.recharge.R.string.v3_action_see_plans
            java.lang.String r1 = r6.getString(r1)
            java.lang.String r3 = "getString(R.string.v3_action_see_plans)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            int r3 = net.one97.paytm.recharge.R.color.v3_action_active
            android.view.View$OnClickListener r4 = r6.aG
            r0.a(r1, r3, r4)
        L_0x02bf:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r6.o
            if (r0 == 0) goto L_0x02c8
            android.view.View$OnClickListener r1 = r6.aG
            r0.setActionLayoutClickListener(r1)
        L_0x02c8:
            androidx.lifecycle.z<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r0 = r6.z
            if (r0 != 0) goto L_0x02d5
            net.one97.paytm.recharge.mobile_v3.b.d$t r0 = new net.one97.paytm.recharge.mobile_v3.b.d$t
            r0.<init>(r6)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r6.z = r0
        L_0x02d5:
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x02ec
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r0 = r0.J
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x02ec
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            androidx.lifecycle.z<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r3 = r6.z
            if (r3 != 0) goto L_0x02e9
            kotlin.g.b.k.a()
        L_0x02e9:
            r0.observe(r1, r3)
        L_0x02ec:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x0332
            boolean r0 = r0.getShowOne2OneOffer()
            if (r0 != r10) goto L_0x0332
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x0332
            boolean r0 = r0.getShowDynamicPlan()
            if (r0 != r10) goto L_0x0332
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r0 = net.one97.paytm.recharge.di.helper.c.W()
            if (r0 == 0) goto L_0x0332
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x0312
            boolean r0 = r0.getShowOne2OneUserOffer()
            if (r0 == r10) goto L_0x032b
        L_0x0312:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x031b
            java.lang.String r0 = r0.getOne2OneOfferText()
            goto L_0x031c
        L_0x031b:
            r0 = r9
        L_0x031c:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x032b
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x0338
            r0.I = r10
            goto L_0x0338
        L_0x032b:
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x0338
            r0.I = r10
            goto L_0x0338
        L_0x0332:
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x0338
            r0.I = r8
        L_0x0338:
            r0 = 0
        L_0x0339:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r6.o
            if (r1 == 0) goto L_0x0342
            java.lang.String r1 = r1.getInputText()
            goto L_0x0343
        L_0x0342:
            r1 = r9
        L_0x0343:
            net.one97.paytm.recharge.mobile.d.a r3 = r6.f63600h
            if (r3 == 0) goto L_0x034c
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r3 = r3.j()
            goto L_0x034d
        L_0x034c:
            r3 = r9
        L_0x034d:
            if (r3 == 0) goto L_0x0393
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0393
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 == 0) goto L_0x0368
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r1 = r1.J
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x0368
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1
            goto L_0x0369
        L_0x0368:
            r1 = r9
        L_0x0369:
            if (r1 != 0) goto L_0x0393
            java.lang.String r1 = r3.getPayType()
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r10)
            if (r1 == 0) goto L_0x0393
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r1 = r3.getRechargeAmount()
            double r1 = net.one97.paytm.recharge.widgets.c.d.c(r1)
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0393
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r6.a((java.lang.String) r1, (boolean) r10)
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PLAN_AMOUNT_SEARCH
            java.lang.String r2 = "search.last.recharge.plan"
            r6.a((java.lang.String) r2, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1)
        L_0x0393:
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 != 0) goto L_0x039a
            kotlin.g.b.k.a()
        L_0x039a:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            java.lang.String r2 = "price"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x03f4
            java.lang.Object r3 = r1.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            r1.remove(r2)
            boolean r1 = r6.Y
            if (r1 != 0) goto L_0x03e9
            r6.a((java.lang.String) r3, (boolean) r10)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r9)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r3.setErrorType(r0)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r3.getFlowName()
            if (r0 == 0) goto L_0x03ce
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r1 = r1.name()
            r0.setErrorType(r1)
        L_0x03ce:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r3.getFlowName()
            if (r0 == 0) goto L_0x03dd
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.AUTO_FILL_AMOUNT_DEEPLINK
            java.lang.String r1 = r1.name()
            r0.setActionType(r1)
        L_0x03dd:
            r2 = 0
            r4 = 0
            r5 = 10
            java.lang.String r1 = "search_browse_plan_prefill"
            r0 = r16
            a(r0, r1, r2, r3, r4, r5)
            goto L_0x044b
        L_0x03e9:
            if (r0 != 0) goto L_0x044b
            r6.at = r10
            r6.a((java.lang.String) r3, (boolean) r10)
            r16.C()
            goto L_0x044b
        L_0x03f4:
            java.lang.String r2 = "amount"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x044b
            java.lang.Object r3 = r1.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            r1.remove(r2)
            boolean r1 = r6.Y
            if (r1 != 0) goto L_0x0441
            r6.a((java.lang.String) r3, (boolean) r10)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r9)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r3.setErrorType(r0)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r3.getFlowName()
            if (r0 == 0) goto L_0x0426
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r1 = r1.name()
            r0.setErrorType(r1)
        L_0x0426:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r3.getFlowName()
            if (r0 == 0) goto L_0x0435
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.AUTO_FILL_AMOUNT_DEEPLINK
            java.lang.String r1 = r1.name()
            r0.setActionType(r1)
        L_0x0435:
            r2 = 0
            r4 = 0
            r5 = 10
            java.lang.String r1 = "search_browse_plan_prefill"
            r0 = r16
            a(r0, r1, r2, r3, r4, r5)
            goto L_0x044b
        L_0x0441:
            if (r0 != 0) goto L_0x044b
            r6.at = r10
            r6.a((java.lang.String) r3, (boolean) r10)
            r16.C()
        L_0x044b:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r6.o
            if (r0 == 0) goto L_0x0453
            java.lang.String r9 = r0.getInputText()
        L_0x0453:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x045d
            r6.av = r10
        L_0x045d:
            int r0 = net.one97.paytm.recharge.R.id.dummy_focusable_view
            android.view.View r0 = r6.b((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x046a
            r0.requestFocus()
        L_0x046a:
            boolean r0 = r6.E
            if (r0 == 0) goto L_0x047a
            boolean r0 = r6.at
            if (r0 != 0) goto L_0x047a
            r6.aj = r8
            java.lang.String r0 = "validate.product.selection"
            r6.k((java.lang.String) r0)
        L_0x047a:
            r6.E = r8
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r0 = r6.B
            if (r0 == 0) goto L_0x0486
            int r0 = r0.size()
            if (r0 == r10) goto L_0x004f
        L_0x0486:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r6.n
            if (r0 == 0) goto L_0x004f
            if (r0 != 0) goto L_0x048f
            kotlin.g.b.k.a()
        L_0x048f:
            r6.b((net.one97.paytm.recharge.model.v4.CJRProductsItem) r0)
            goto L_0x004f
        L_0x0494:
            boolean r0 = r6.W
            if (r0 != 0) goto L_0x0540
            r6.W = r10
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x0520
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x0520
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x0520
            boolean r0 = r0.showFastForward()
            if (r0 != r10) goto L_0x0520
            r16.g()
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = r6.ar
            if (r0 == 0) goto L_0x04bf
            net.one97.paytm.recharge.mobile_v3.b.d$d r1 = new net.one97.paytm.recharge.mobile_v3.b.d$d
            r1.<init>(r6)
            net.one97.paytm.recharge.common.e.m r1 = (net.one97.paytm.recharge.common.e.m) r1
            r0.setOnCheckChangedListener(r1)
        L_0x04bf:
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = r6.ar
            if (r0 == 0) goto L_0x04d1
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 != 0) goto L_0x04ca
            kotlin.g.b.k.a()
        L_0x04ca:
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            java.util.Map r1 = (java.util.Map) r1
            r0.a((java.util.Map<java.lang.String, java.lang.String>) r1)
        L_0x04d1:
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = r6.ar
            if (r0 == 0) goto L_0x0520
            if (r0 != 0) goto L_0x04da
            kotlin.g.b.k.a()
        L_0x04da:
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0520
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x04e9
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r0 = r0.j()
            goto L_0x04ea
        L_0x04e9:
            r0 = r9
        L_0x04ea:
            if (r0 == 0) goto L_0x0520
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            if (r0 == 0) goto L_0x0520
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            if (r0 != 0) goto L_0x04fd
            kotlin.g.b.k.a()
        L_0x04fd:
            java.lang.String r1 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 == 0) goto L_0x0510
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            if (r1 == 0) goto L_0x0510
            java.lang.String r9 = r1.getCategoryId()
        L_0x0510:
            boolean r0 = net.one97.paytm.recharge.common.utils.az.e(r0, r9)
            if (r0 != 0) goto L_0x0520
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = r6.ar
            if (r0 != 0) goto L_0x051d
            kotlin.g.b.k.a()
        L_0x051d:
            r0.setFastForwardChecked(r10)
        L_0x0520:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x052d
            r0.setVisibility(r8)
        L_0x052d:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x053d
            r1 = r6
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x053d:
            r16.f()
        L_0x0540:
            boolean r0 = r6.O
            if (r0 != 0) goto L_0x0654
            r6.O = r10
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            int r1 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r1 = r6.b((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            if (r1 == 0) goto L_0x0558
            r1.getGlobalVisibleRect(r0)
        L_0x0558:
            int r0 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r0 = r6.b((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1 = 8
            if (r0 == 0) goto L_0x0567
            r0.setVisibility(r1)
        L_0x0567:
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r16.getActivity()
            if (r2 == 0) goto L_0x0581
            android.view.WindowManager r2 = r2.getWindowManager()
            if (r2 == 0) goto L_0x0581
            android.view.Display r2 = r2.getDefaultDisplay()
            if (r2 == 0) goto L_0x0581
            r2.getMetrics(r0)
        L_0x0581:
            int r0 = r0.heightPixels
            double r2 = (double) r0
            r4 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            double r4 = r4 * r2
            float r0 = (float) r4
            r4 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r4 = r4 * r2
            double r2 = r2 - r4
            float r2 = (float) r2
            int r3 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r3 = r6.b((int) r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            android.util.Property r4 = android.view.View.TRANSLATION_Y
            float[] r5 = new float[r7]
            r5[r8] = r0
            r0 = 0
            r5[r10] = r0
            android.animation.ObjectAnimator r9 = android.animation.ObjectAnimator.ofFloat(r3, r4, r5)
            java.lang.String r3 = "animContainerMainContentTranslate"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
            r3 = 100
            r9.setStartDelay(r3)
            int r5 = net.one97.paytm.recharge.R.id.container_main_content
            android.view.View r5 = r6.b((int) r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            android.util.Property r11 = android.view.View.ALPHA
            float[] r12 = new float[r7]
            r12 = {0, 1065353216} // fill-array
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofFloat(r5, r11, r12)
            java.lang.String r5 = "animContainerMainContentAlpha"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            r11.setStartDelay(r3)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            int r4 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r4 = r6.b((int) r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            if (r4 == 0) goto L_0x05e1
            r4.getGlobalVisibleRect(r3)
        L_0x05e1:
            int r3 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r3 = r6.b((int) r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            if (r3 == 0) goto L_0x05ee
            r3.setVisibility(r1)
        L_0x05ee:
            int r1 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r1 = r6.b((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            android.util.Property r3 = android.view.View.TRANSLATION_Y
            float[] r4 = new float[r7]
            r4[r8] = r2
            r4[r10] = r0
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r1, r3, r4)
            int r0 = net.one97.paytm.recharge.R.id.container_main_header
            android.view.View r0 = r6.b((int) r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            android.util.Property r1 = android.view.View.ALPHA
            float[] r2 = new float[r7]
            r2 = {0, 1065353216} // fill-array
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r0, r1, r2)
            android.animation.AnimatorSet r14 = new android.animation.AnimatorSet
            r14.<init>()
            net.one97.paytm.recharge.mobile_v3.b.d$c r15 = new net.one97.paytm.recharge.mobile_v3.b.d$c
            r0 = r15
            r1 = r16
            r2 = r12
            r3 = r13
            r4 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            android.animation.Animator$AnimatorListener r15 = (android.animation.Animator.AnimatorListener) r15
            r14.addListener(r15)
            r0 = 500(0x1f4, double:2.47E-321)
            r14.setDuration(r0)
            android.view.animation.AccelerateDecelerateInterpolator r0 = new android.view.animation.AccelerateDecelerateInterpolator
            r0.<init>()
            android.animation.TimeInterpolator r0 = (android.animation.TimeInterpolator) r0
            r14.setInterpolator(r0)
            r0 = 4
            android.animation.Animator[] r0 = new android.animation.Animator[r0]
            android.animation.Animator r12 = (android.animation.Animator) r12
            r0[r8] = r12
            android.animation.Animator r13 = (android.animation.Animator) r13
            r0[r10] = r13
            android.animation.Animator r9 = (android.animation.Animator) r9
            r0[r7] = r9
            r1 = 3
            android.animation.Animator r11 = (android.animation.Animator) r11
            r0[r1] = r11
            r14.playTogether(r0)
            r14.start()
        L_0x0654:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.a(net.one97.paytm.recharge.model.v4.CJRProductsItem):void");
    }

    /* renamed from: net.one97.paytm.recharge.mobile_v3.b.d$d  reason: collision with other inner class name */
    public static final class C1249d implements net.one97.paytm.recharge.common.e.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63811a;

        C1249d(d dVar) {
            this.f63811a = dVar;
        }

        public final void a(boolean z, boolean z2) {
            String str;
            CJRCart cart;
            this.f63811a.ac = z2;
            d dVar = this.f63811a;
            net.one97.paytm.recharge.mobile.d.a aVar = dVar.f63600h;
            if (aVar != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), z ? "fast_forward_checked" : "fast_forward_unchecked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) dVar.b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                CJRRechargeCart cJRRechargeCart = dVar.f63788f;
                if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (str = cart.getFinalPrice()) == null) {
                    CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = dVar.o;
                    str = cJRAmountInputFieldWidgetV3 != null ? cJRAmountInputFieldWidgetV3.getFormattedString() : null;
                }
                cJRProceedWidgetV8.setProceedBtnText(dVar.a(str));
            }
        }
    }

    private void f() {
        String str;
        CJRCart cart;
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            CJRRechargeCart cJRRechargeCart = this.f63788f;
            if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (str = cart.getFinalPrice()) == null) {
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
                str = cJRAmountInputFieldWidgetV3 != null ? cJRAmountInputFieldWidgetV3.getFormattedString() : null;
            }
            cJRProceedWidgetV8.setProceedBtnText(a(str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r1 = r1.f61409b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r2 = this;
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 == 0) goto L_0x003d
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 != 0) goto L_0x0011
            kotlin.g.b.k.a()
        L_0x0011:
            java.lang.String r1 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.recharge.mobile.d.a r1 = r2.f63600h
            if (r1 == 0) goto L_0x0025
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.getCategoryId()
            goto L_0x0026
        L_0x0025:
            r1 = 0
        L_0x0026:
            boolean r0 = net.one97.paytm.recharge.common.utils.az.e(r0, r1)
            if (r0 == 0) goto L_0x003d
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = r2.ar
            if (r0 == 0) goto L_0x0035
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
        L_0x0035:
            android.view.View r0 = r2.ag
            if (r0 == 0) goto L_0x003c
            net.one97.paytm.recharge.common.utils.ai.b(r0)
        L_0x003c:
            return
        L_0x003d:
            net.one97.paytm.recharge.mobile.d.a r0 = r2.f63600h
            if (r0 == 0) goto L_0x0061
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x0061
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x0061
            boolean r0 = r0.showFastForward()
            r1 = 1
            if (r0 != r1) goto L_0x0061
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r0 = r2.ar
            r1 = 0
            if (r0 == 0) goto L_0x005a
            r0.setVisibility(r1)
        L_0x005a:
            android.view.View r0 = r2.ag
            if (r0 == 0) goto L_0x0061
            r0.setVisibility(r1)
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.g():void");
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63806a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63807b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63808c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63809d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63810e;

        c(d dVar, ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2, ObjectAnimator objectAnimator3, ObjectAnimator objectAnimator4) {
            this.f63806a = dVar;
            this.f63807b = objectAnimator;
            this.f63808c = objectAnimator2;
            this.f63809d = objectAnimator3;
            this.f63810e = objectAnimator4;
        }

        public final void onAnimationStart(Animator animator) {
            ViewGroup l;
            RelativeLayout relativeLayout = (RelativeLayout) this.f63806a.b(R.id.container_main_header);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            LinearLayout linearLayout = (LinearLayout) this.f63806a.b(R.id.container_main_content);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            CJRAmountInputFieldWidgetV3 h2 = this.f63806a.o;
            if (TextUtils.isEmpty(h2 != null ? h2.getInputText() : null) && this.f63806a.av && (l = this.f63806a.ap) != null) {
                l.setVisibility(4);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            boolean z = false;
            if (this.f63806a.Z && (this.f63806a.getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
                FragmentActivity activity = this.f63806a.getActivity();
                if (activity != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity).e();
                    FragmentActivity activity2 = this.f63806a.getActivity();
                    if (activity2 != null) {
                        ((net.one97.paytm.recharge.common.e.y) activity2).i();
                        Toolbar toolbar = (Toolbar) this.f63806a.b(R.id.toolbar);
                        if (toolbar != null) {
                            toolbar.setVisibility(0);
                        }
                        this.f63806a.aa = true;
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            }
            CJRAmountInputFieldWidgetV3 h2 = this.f63806a.o;
            if (h2 != null) {
                if (h2.getInputText().length() == 0) {
                    z = true;
                }
                if (z && this.f63806a.av) {
                    this.f63806a.b();
                }
            }
        }

        public final void onAnimationCancel(Animator animator) {
            boolean z = false;
            if (this.f63806a.Z && (this.f63806a.getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
                FragmentActivity activity = this.f63806a.getActivity();
                if (activity != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity).e();
                    FragmentActivity activity2 = this.f63806a.getActivity();
                    if (activity2 != null) {
                        ((net.one97.paytm.recharge.common.e.y) activity2).i();
                        Toolbar toolbar = (Toolbar) this.f63806a.b(R.id.toolbar);
                        if (toolbar != null) {
                            toolbar.setVisibility(0);
                        }
                        this.f63806a.aa = true;
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            }
            CJRAmountInputFieldWidgetV3 h2 = this.f63806a.o;
            if (h2 != null) {
                if (h2.getInputText().length() == 0) {
                    z = true;
                }
                if (z && this.f63806a.av) {
                    this.f63806a.b();
                }
            }
        }
    }

    public final String a(String str) {
        if (!isAdded() || getContext() == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return getString(R.string.proceed_re);
        }
        return getString(R.string.v3_proceed_btn_ff_selected, str);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63805a;

        b(d dVar) {
            this.f63805a = dVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.mobile.d.a d2;
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI()) && (d2 = this.f63805a.f63600h) != null && (dVar = d2.v) != null) {
                net.one97.paytm.recharge.mobile.d.a d3 = this.f63805a.f63600h;
                Object e2 = d3 != null ? d3.e() : null;
                if (e2 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, "amount_clicked_non_prefetch", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        }
    }

    private final void b(boolean z2) {
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 != null) {
            cJRAmountInputFieldWidgetV3.d(!z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (android.text.TextUtils.isEmpty(net.one97.paytm.recharge.common.b.a.a(r0, r1, r4)) == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String j(java.lang.String r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0004
            java.lang.String r4 = ""
        L_0x0004:
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r0 = r3.A
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.recharge.common.b.a r0 = r3.f63601i
            if (r0 == 0) goto L_0x003a
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.recharge.common.b.a r0 = r3.f63601i
            if (r0 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            android.content.Context r0 = r3.getContext()
            if (r0 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            java.lang.String r1 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r1 = r3.A
            if (r1 != 0) goto L_0x002e
            kotlin.g.b.k.a()
        L_0x002e:
            java.lang.String r0 = net.one97.paytm.recharge.common.b.a.a((android.content.Context) r0, (net.one97.paytm.recharge.model.v4.CJRInputFieldsItem) r1, (java.lang.String) r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0059
        L_0x003a:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x0050 }
            double r0 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x0050 }
            double r0 = java.lang.Math.ceil(r0)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0050 }
            r1 = 14
            r2 = 0
            java.lang.String r4 = net.one97.paytm.recharge.widgets.c.d.a(r0, r2, r2, r2, r1)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0059
        L_0x0050:
            java.lang.String r4 = net.one97.paytm.recharge.common.widget.CJRAmountView.a((java.lang.String) r4)
            java.lang.String r0 = "CJRAmountView.getInteger(dueAmount)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
        L_0x0059:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r4 = net.one97.paytm.recharge.widgets.c.d.d(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.j(java.lang.String):java.lang.String");
    }

    private final void a(String str, boolean z2) {
        this.L = true;
        if (this.M) {
            this.M = false;
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                cJRAmountInputFieldWidgetV3.c();
            }
        }
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
        if (cJRAmountInputFieldWidgetV32 != null) {
            cJRAmountInputFieldWidgetV32.setInputText("");
        }
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV33 = this.o;
        if (cJRAmountInputFieldWidgetV33 != null) {
            cJRAmountInputFieldWidgetV33.a(j(str));
        }
        if (this.at) {
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV34 = this.o;
            if (!TextUtils.isEmpty(cJRAmountInputFieldWidgetV34 != null ? cJRAmountInputFieldWidgetV34.getInputText() : null)) {
                CJRPromoWidgetV3 cJRPromoWidgetV3 = this.af;
                if (cJRPromoWidgetV3 != null) {
                    cJRPromoWidgetV3.setEnabled(true, this);
                }
                a(true);
                if (z2) {
                    C();
                }
            }
        }
        this.L = false;
    }

    private final void b(CJRProductsItem cJRProductsItem) {
        List<CJRAggsItem> list = this.B;
        if (list != null) {
            int i2 = 0;
            for (Object next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.k.a();
                }
                CJRAggsItem cJRAggsItem = (CJRAggsItem) next;
                Collection productList = cJRAggsItem.getProductList();
                if (productList != null && (!productList.isEmpty())) {
                    if (kotlin.g.b.k.a((Object) ((CJRProductsItem) ((List) productList).get(0)).getProductId(), (Object) cJRProductsItem.getProductId())) {
                        cJRAggsItem.setItemSelected(true);
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        net.one97.paytm.recharge.widgets.c.d.a("PType: Display selected product type");
                        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
                        if (cJRAmountInputFieldWidgetV3 != null) {
                            cJRAmountInputFieldWidgetV3.a(cJRAggsItem, cJRProductsItem, (View.OnClickListener) this);
                        }
                    } else {
                        cJRAggsItem.setItemSelected(false);
                    }
                }
                i2 = i3;
            }
        }
    }

    public final void a(CJRAggsItem cJRAggsItem, boolean z2, CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        net.one97.paytm.recharge.mobile.d.a aVar;
        net.one97.paytm.recharge.common.b.a aVar2;
        kotlin.g.b.k.c(cJRAggsItem, "item");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        StringBuilder sb = new StringBuilder("PType: ");
        String str = "User";
        sb.append(z2 ? str : "Auto");
        sb.append(" select product type");
        net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
        List<CJRProductsItem> productList = cJRAggsItem.getProductList();
        String str2 = null;
        if (productList != null && (!productList.isEmpty())) {
            Long productId = cJRAggsItem.getProductList().get(0).getProductId();
            CJRProductsItem cJRProductsItem = this.n;
            if (!kotlin.g.b.k.a((Object) productId, (Object) cJRProductsItem != null ? cJRProductsItem.getProductId() : null)) {
                this.E = z2;
                LinearLayout linearLayout = (LinearLayout) b(R.id.container_product_input_fields);
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                }
                net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                if (!(aVar3 == null || (aVar2 = aVar3.x) == null)) {
                    aVar2.d();
                }
                h();
                this.R = false;
                if (!(!z2 || cJRBrowsePlanProductList == null || (aVar = this.f63600h) == null)) {
                    aVar.a(cJRBrowsePlanProductList);
                }
                if (z2) {
                    CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
                    if (cJRAmountInputFieldWidgetV3 != null) {
                        str2 = cJRAmountInputFieldWidgetV3.getInputText();
                    }
                    this.F = str2;
                }
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                StringBuilder sb2 = new StringBuilder("PType: ");
                if (!z2) {
                    str = "Auto";
                }
                sb2.append(str);
                sb2.append(" selected product type changed");
                net.one97.paytm.recharge.widgets.c.d.a(sb2.toString());
                net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
                if (aVar4 != null) {
                    aVar4.a(cJRAggsItem.getProductList().get(0));
                    return;
                }
                return;
            }
        }
        if (this.n != null) {
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
            if (!TextUtils.isEmpty(cJRAmountInputFieldWidgetV32 != null ? cJRAmountInputFieldWidgetV32.getInputText() : null)) {
                this.E = z2;
                if (z2) {
                    CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV33 = this.o;
                    if (cJRAmountInputFieldWidgetV33 != null) {
                        str2 = cJRAmountInputFieldWidgetV33.getInputText();
                    }
                    this.F = str2;
                }
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a("PType: Display selected product type");
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV34 = this.o;
                if (cJRAmountInputFieldWidgetV34 != null) {
                    CJRProductsItem cJRProductsItem2 = this.n;
                    if (cJRProductsItem2 == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRAmountInputFieldWidgetV34.a(cJRAggsItem, cJRProductsItem2, (View.OnClickListener) this);
                }
                if (!this.at) {
                    this.aj = false;
                    k("validate.product.selection");
                    return;
                }
                C();
                net.one97.paytm.recharge.mobile_v3.a.c cVar = this.ai;
                if (cVar != null) {
                    cVar.dismissAllowingStateLoss();
                }
            }
        }
    }

    private final void h() {
        net.one97.paytm.recharge.mobile.d.a aVar;
        LiveData liveData;
        androidx.lifecycle.z<CJRBrowsePlanProductList> zVar = this.z;
        if (zVar != null && (aVar = this.f63600h) != null && (liveData = aVar.J) != null) {
            liveData.removeObserver(zVar);
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        LiveData liveData;
        String str;
        net.one97.paytm.recharge.mobile.d.a aVar;
        if (i2 != 607) {
            if (i2 != 1021) {
                if (i2 == 4569 && -1 != i3) {
                    if (this.at) {
                        C();
                    } else {
                        b();
                    }
                }
            } else if (i3 == -1) {
                c(1021);
            } else {
                d(1021);
            }
            return super.a(i2, i3, intent);
        }
        if (!super.a(i2, i3, intent)) {
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (!(aVar2 == null || (liveData = aVar2.z) == null || (str = (String) liveData.getValue()) == null || (aVar = this.f63600h) == null)) {
                kotlin.g.b.k.a((Object) str, "it");
                aVar.a(str, false);
            }
            if (this.at) {
                C();
            } else {
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
                if (cJRAmountInputFieldWidgetV3 != null) {
                    cJRAmountInputFieldWidgetV3.clearFocus();
                }
                b();
            }
        } else {
            this.ay = true;
            b();
        }
        return true;
    }

    static final class af implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63798a;

        af(d dVar) {
            this.f63798a = dVar;
        }

        public final void run() {
            if (this.f63798a.o != null) {
                new Handler().postDelayed(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ af f63799a;

                    {
                        this.f63799a = r1;
                    }

                    public final void run() {
                        CJRAmountInputFieldWidgetV3 h2 = this.f63799a.f63798a.o;
                        if (h2 == null) {
                            kotlin.g.b.k.a();
                        }
                        h2.d();
                        FragmentActivity activity = this.f63799a.f63798a.getActivity();
                        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
                        if (!(systemService instanceof InputMethodManager)) {
                            systemService = null;
                        }
                        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                        if (inputMethodManager != null) {
                            CJRAmountInputFieldWidgetV3 h3 = this.f63799a.f63798a.o;
                            if (h3 == null) {
                                kotlin.g.b.k.a();
                            }
                            inputMethodManager.toggleSoftInputFromWindow(h3.getApplicationWindowToken(), 2, 0);
                        }
                    }
                }, 100);
            }
        }
    }

    private final void v() {
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 != null) {
            cJRAmountInputFieldWidgetV3.post(new af(this));
        }
    }

    public final void c(int i2) {
        w();
        if (this.J) {
            this.J = false;
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                String string = getString(R.string.v3_checking_outstanding_amount);
                kotlin.g.b.k.a((Object) string, "getString(R.string.v3_checking_outstanding_amount)");
                cJRAmountInputFieldWidgetV3.e(string);
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            String str = null;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.FETCH_BILL.name());
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                net.one97.paytm.recharge.common.e.i iVar = this;
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
                if (cJRAmountInputFieldWidgetV32 != null) {
                    str = cJRAmountInputFieldWidgetV32.getInputText();
                }
                aVar.a("fetch_mobile_bill", iVar, str, (Object) a2);
            }
        } else if (i2 == 800) {
            onClick((CJRProceedWidgetV8) b(R.id.btn_pre_validate));
        }
    }

    public final void d(int i2) {
        this.J = false;
        ay ayVar = ay.f61523a;
        ay.a(i2);
    }

    /* access modifiers changed from: private */
    public final void w() {
        net.one97.paytm.recharge.common.utils.o oVar;
        String str;
        net.one97.paytm.recharge.mobile.d.a aVar;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        RelativeLayout relativeLayout = (RelativeLayout) b(R.id.insurance_layout);
        if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            Context context = getContext();
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 == null || (cJRCategoryDataHelper = aVar2.f61409b) == null) {
                str = null;
            } else {
                str = cJRCategoryDataHelper.getCategoryId();
            }
            if (net.one97.paytm.recharge.di.helper.c.a(context, str) && (aVar = this.f63600h) != null) {
                aVar.r();
            }
        }
        net.one97.paytm.recharge.common.utils.o oVar2 = this.u;
        if (oVar2 != null && !oVar2.a() && (oVar = this.u) != null) {
            oVar.b();
        }
    }

    public void onDestroyView() {
        com.paytm.utility.g.a((g.a) null);
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.b((net.one97.paytm.recharge.common.e.p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.b((net.one97.paytm.recharge.common.e.n) this);
        }
        super.onDestroyView();
        u();
    }

    public final boolean ax_() {
        com.paytm.network.f.b(getContext()).cancelAll((Object) ba.f61539a);
        super.ax_();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.m();
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "back_button_amount_screen", (Object) null, "back_button", (Object) null, (Object) null, (Object) null, 116);
        }
        net.one97.paytm.recharge.common.b.a aVar2 = this.f63601i;
        if (aVar2 == null) {
            return false;
        }
        aVar2.c();
        return false;
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63823a;

        l(d dVar) {
            this.f63823a = dVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                this.f63823a.b("fetch_mobile_bill", ACTION_TYPE.FETCH_BILL);
                this.f63823a.w();
            }
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63822a;

        k(d dVar) {
            this.f63822a = dVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                this.f63822a.a("search.last.recharge.plan", ACTION_TYPE.PLAN_AMOUNT_SEARCH_AGAIN);
                this.f63822a.w();
            }
        }
    }

    public final void a(String str, ACTION_TYPE action_type) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(action_type, "actionType");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(action_type.name());
        }
        if (com.paytm.utility.b.c(getContext())) {
            a(this, str, (String) null, a2, (net.one97.paytm.recharge.common.e.ai) null, 10);
            return;
        }
        a(str, -1, (IJRPaytmDataModel) null, (NetworkCustomError) new as(false, 1, (kotlin.g.b.g) null), (Object) a2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> b(net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r10) {
        /*
            r9 = this;
            java.lang.String r0 = "selectedPlan"
            kotlin.g.b.k.c(r10, r0)
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r0 = r9.B
            if (r0 == 0) goto L_0x0074
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0071
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r3
            java.util.List r4 = r3.getProductList()
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x006b
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r7 = r4 instanceof java.util.Collection
            if (r7 == 0) goto L_0x003a
            r7 = r4
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0067
        L_0x003a:
            java.util.Iterator r4 = r4.iterator()
        L_0x003e:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0067
            java.lang.Object r7 = r4.next()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r7 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r7
            java.lang.String r7 = r7.getProductType()
            if (r7 == 0) goto L_0x005f
            java.lang.String r8 = r10.getProductType()
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r6)
            if (r7 != r6) goto L_0x005f
            r3.setItemSelected(r6)
            r7 = 1
            goto L_0x0063
        L_0x005f:
            r3.setItemSelected(r5)
            r7 = 0
        L_0x0063:
            if (r7 == 0) goto L_0x003e
            r3 = 0
            goto L_0x0068
        L_0x0067:
            r3 = 1
        L_0x0068:
            if (r3 != 0) goto L_0x006b
            r5 = 1
        L_0x006b:
            if (r5 == 0) goto L_0x0016
            r1.add(r2)
            goto L_0x0016
        L_0x0071:
            java.util.List r1 = (java.util.List) r1
            return r1
        L_0x0074:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.b(net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList):java.util.List");
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        String str;
        String str2;
        String str3;
        List<CJRProductsItem> productList;
        Object obj;
        Object e2;
        LiveData liveData;
        LiveData liveData2;
        CJRBrowsePlanProductList cJRBrowsePlanProductList2 = cJRBrowsePlanProductList;
        kotlin.g.b.k.c(cJRBrowsePlanProductList2, "selectedPlan");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a("PType: Plan Selected");
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.BROWSE_PLAN_SELECTED);
        this.C = null;
        this.D = false;
        this.Q = false;
        Double price = cJRBrowsePlanProductList.getPrice();
        a(price != null ? String.valueOf(price.doubleValue()) : null, cJRBrowsePlanProductList.isFromPlanResponse());
        if (this.aA) {
            str = "amount field";
        } else {
            str = this.aB ? "prefilled" : "browse plan";
        }
        String str4 = str;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        String str5 = (aVar == null || (liveData2 = aVar.z) == null) ? null : (String) liveData2.getValue();
        Double price2 = cJRBrowsePlanProductList.getPrice();
        kotlin.g.b.k.a((Object) price2, "selectedPlan.price");
        double doubleValue = price2.doubleValue();
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (az.a(str5, doubleValue, (List<? extends CJRFrequentOrder>) (aVar2 == null || (liveData = aVar2.f61414g) == null) ? null : (List) liveData.getValue()) && !this.aB) {
            String str6 = this.aA ? "amount entered" : str4;
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar3 = new net.one97.paytm.recharge.ordersummary.h.d(context);
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
            if (aVar3 == null || (e2 = aVar3.e()) == null) {
                obj = "";
            } else {
                obj = e2;
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar3, obj, "Last_recharge_amount_selected", "", (Object) null, (Object) null, (Object) null, str6, 56);
        }
        List<CJRAggsItem> list = this.B;
        if (list != null && (list == null || list.size() != 1)) {
            List<CJRAggsItem> b2 = b(cJRBrowsePlanProductList);
            if ((this.R || !this.E) && b2 != null && (!b2.isEmpty()) && (productList = b2.get(0).getProductList()) != null && (!productList.isEmpty())) {
                List<CJRProductsItem> productList2 = b2.get(0).getProductList();
                if (productList2 == null) {
                    kotlin.g.b.k.a();
                }
                Long productId = productList2.get(0).getProductId();
                CJRProductsItem cJRProductsItem = this.n;
                if (!kotlin.g.b.k.a((Object) productId, (Object) cJRProductsItem != null ? cJRProductsItem.getProductId() : null)) {
                    net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    net.one97.paytm.recharge.widgets.c.d.a("PType: Auto select product type due selected Plan");
                    a(b2.get(0), false, (CJRBrowsePlanProductList) null);
                    return;
                }
            }
            if (b2 == null || !(!b2.isEmpty()) || this.n == null) {
                G();
            } else {
                net.one97.paytm.recharge.widgets.c.d dVar5 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a("PType: Display selected product type");
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
                if (cJRAmountInputFieldWidgetV3 != null) {
                    CJRAggsItem cJRAggsItem = b2.get(0);
                    CJRProductsItem cJRProductsItem2 = this.n;
                    if (cJRProductsItem2 == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRAmountInputFieldWidgetV3.a(cJRAggsItem, cJRProductsItem2, (View.OnClickListener) this);
                }
                CJRPromoWidgetV3 cJRPromoWidgetV3 = this.af;
                if (cJRPromoWidgetV3 != null) {
                    cJRPromoWidgetV3.setEnabled(true, this);
                }
                a(true);
                this.Q = true;
                this.at = true;
                C();
            }
        } else if (!cJRBrowsePlanProductList.isFromPlanResponse()) {
            this.at = false;
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
            if (cJRAmountInputFieldWidgetV32 != null) {
                cJRAmountInputFieldWidgetV32.g();
            }
            b(false);
            b();
        } else {
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV33 = this.o;
            if (cJRAmountInputFieldWidgetV33 != null) {
                View.OnClickListener onClickListener = this;
                kotlin.g.b.k.c(cJRBrowsePlanProductList2, "selectedPlan");
                String amountPlanDescription = cJRBrowsePlanProductList.getAmountPlanDescription();
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedValidity())) {
                    arrayList.add(new kotlin.o(cJRAmountInputFieldWidgetV33.getContext().getString(R.string.v3_os_selected_plan_validity), cJRBrowsePlanProductList.getValidity()));
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedDataValue())) {
                    arrayList.add(new kotlin.o(cJRAmountInputFieldWidgetV33.getContext().getString(R.string.v3_os_selected_plan_data), cJRBrowsePlanProductList.getData()));
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedTalktime())) {
                    String talktime = cJRBrowsePlanProductList.getTalktime();
                    if (talktime != null) {
                        if (cJRAmountInputFieldWidgetV33.f63945h.matches(talktime)) {
                            str3 = cJRAmountInputFieldWidgetV33.getContext().getString(R.string.v3_os_selected_plan_talktime);
                            kotlin.g.b.k.a((Object) str3, "if (selectedPlan.talktim…  else\n                \"\"");
                            arrayList.add(new kotlin.o(str3, cJRBrowsePlanProductList.getTalktime()));
                        }
                    }
                    str3 = "";
                    kotlin.g.b.k.a((Object) str3, "if (selectedPlan.talktim…  else\n                \"\"");
                    arrayList.add(new kotlin.o(str3, cJRBrowsePlanProductList.getTalktime()));
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedSms())) {
                    arrayList.add(new kotlin.o("", cJRBrowsePlanProductList.getSms()));
                }
                if (kotlin.g.b.k.a((Object) amountPlanDescription, (Object) cJRAmountInputFieldWidgetV33.f63946i)) {
                    cJRAmountInputFieldWidgetV33.a(cJRBrowsePlanProductList2, (ArrayList<kotlin.o<String, String>>) arrayList, true);
                } else if (kotlin.g.b.k.a((Object) amountPlanDescription, (Object) cJRAmountInputFieldWidgetV33.j)) {
                    cJRAmountInputFieldWidgetV33.a(cJRBrowsePlanProductList2, (ArrayList<kotlin.o<String, String>>) arrayList);
                } else if (kotlin.g.b.k.a((Object) amountPlanDescription, (Object) cJRAmountInputFieldWidgetV33.k)) {
                    cJRAmountInputFieldWidgetV33.a(cJRBrowsePlanProductList2, (ArrayList<kotlin.o<String, String>>) arrayList, false);
                } else if (!(!arrayList.isEmpty()) && TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedDescription())) {
                    cJRAmountInputFieldWidgetV33.g();
                    cJRAmountInputFieldWidgetV33.d(true);
                } else if (arrayList.isEmpty()) {
                    cJRAmountInputFieldWidgetV33.a(cJRBrowsePlanProductList2, (ArrayList<kotlin.o<String, String>>) arrayList);
                } else {
                    cJRAmountInputFieldWidgetV33.a(cJRBrowsePlanProductList2, (ArrayList<kotlin.o<String, String>>) arrayList, true);
                }
                if ((!arrayList.isEmpty()) || !TextUtils.isEmpty(cJRBrowsePlanProductList.getParsedDescription())) {
                    if (cJRAmountInputFieldWidgetV33.k.equals(amountPlanDescription)) {
                        cJRAmountInputFieldWidgetV33.f63944g = null;
                    } else {
                        cJRAmountInputFieldWidgetV33.f63944g = onClickListener;
                    }
                    cJRAmountInputFieldWidgetV33.d(false);
                    ViewFlipper viewFlipper = cJRAmountInputFieldWidgetV33.f63943f;
                    if (viewFlipper != null) {
                        viewFlipper.setVisibility(0);
                    }
                }
            }
            CJRPromoWidgetV3 cJRPromoWidgetV32 = this.af;
            if (cJRPromoWidgetV32 != null) {
                cJRPromoWidgetV32.setEnabled(true, this);
            }
            a(true);
            this.Q = true;
            this.at = true;
            C();
        }
        if (cJRBrowsePlanProductList.isFromPlanResponse()) {
            try {
                net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
                if (aVar4 != null) {
                    net.one97.paytm.recharge.ordersummary.h.d dVar6 = aVar4.v;
                    Object e3 = aVar4.e();
                    String str7 = "/" + aVar4.e() + "/browse_plans";
                    Double price3 = cJRBrowsePlanProductList.getPrice();
                    kotlin.g.b.k.a((Object) price3, "selectedPlan.price");
                    String planCategoryDisplayName = cJRBrowsePlanProductList.getPlanCategoryDisplayName();
                    if (planCategoryDisplayName == null) {
                        str2 = "";
                    } else {
                        str2 = planCategoryDisplayName;
                    }
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar6, e3, "plan_selected", str7, price3, (Object) null, str2, str4, 16);
                }
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
        }
        this.aA = false;
        this.aB = false;
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63821a;

        j(d dVar) {
            this.f63821a = dVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "it");
            if (eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                return;
            }
            if (com.paytm.utility.b.c(this.f63821a.getContext())) {
                this.f63821a.a();
                return;
            }
            this.f63821a.j();
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.BROWSE_PLAN.name());
            }
            d.super.a("tag.get.browse.plans", (NetworkCustomError) new as(false, 1, (kotlin.g.b.g) null), (Object) a2);
        }
    }

    public final void b(String str, ACTION_TYPE action_type) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(action_type, "actionType");
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 != null) {
            String string = getString(R.string.v3_checking_outstanding_amount);
            kotlin.g.b.k.a((Object) string, "getString(R.string.v3_checking_outstanding_amount)");
            cJRAmountInputFieldWidgetV3.e(string);
            this.H = true;
            d(false);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            String str2 = null;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(action_type.name());
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                net.one97.paytm.recharge.common.e.i iVar = this;
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
                if (cJRAmountInputFieldWidgetV32 != null) {
                    str2 = cJRAmountInputFieldWidgetV32.getInputText();
                }
                aVar.a(str, iVar, str2, (Object) a2);
            }
            if (cJRAmountInputFieldWidgetV3.hasFocus()) {
                this.G = false;
                cJRAmountInputFieldWidgetV3.e();
            }
        }
    }

    public final boolean a(String str, MotionEvent motionEvent) {
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() == 1647421367 && str.equals("dispatch.touch.event") && motionEvent != null && motionEvent.getAction() == 1) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("key-intercept: amount-screen: dispatchTouchEvent to amount-input-field : ".concat(String.valueOf(motionEvent)));
            this.av = true;
            x();
        }
        return false;
    }

    private void x() {
        if (!this.av) {
            y();
            return;
        }
        this.as = true;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ap, View.ALPHA, new float[]{0.0f});
        kotlin.g.b.k.a((Object) ofFloat, "animAlphaFooter");
        ofFloat.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200);
        animatorSet.addListener(new e(this, ofFloat));
        animatorSet.playTogether(new Animator[]{ofFloat});
        animatorSet.start();
    }

    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63812a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ObjectAnimator f63813b;

        e(d dVar, ObjectAnimator objectAnimator) {
            this.f63812a = dVar;
            this.f63813b = objectAnimator;
        }

        public final void onAnimationStart(Animator animator) {
            CJRProceedWidgetV8 p = this.f63812a.au;
            if (p != null) {
                p.setVisibility(0);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.f63812a.A();
        }

        public final void onAnimationCancel(Animator animator) {
            this.f63812a.A();
        }
    }

    public final void b() {
        this.av = true;
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.au;
        if (cJRProceedWidgetV8 == null || cJRProceedWidgetV8.getVisibility() != 0) {
            x();
        }
        if (!this.Z) {
            v();
            return;
        }
        v();
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 != null && this.f61110b != null) {
            net.one97.paytm.recharge.common.utils.t.b(cJRAmountInputFieldWidgetV3);
        }
    }

    /* access modifiers changed from: private */
    public final void y() {
        if (this.av) {
            A();
            return;
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.au;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setVisibility(8);
        }
        ViewGroup viewGroup = this.ap;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f);
        }
        ViewGroup viewGroup2 = this.ap;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void A() {
        if (!this.av) {
            y();
            return;
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.au;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setVisibility(0);
        }
        ViewGroup viewGroup = this.ap;
        if (viewGroup != null) {
            viewGroup.setAlpha(0.0f);
        }
        ViewGroup viewGroup2 = this.ap;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
    }

    public void onFocusChange(View view, boolean z2) {
        CJRRechargeEditText inputView;
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (!(cJRAmountInputFieldWidgetV3 == null || (inputView = cJRAmountInputFieldWidgetV3.getInputView()) == null)) {
            num = Integer.valueOf(inputView.getId());
        }
        if (!kotlin.g.b.k.a((Object) valueOf, (Object) num)) {
            return;
        }
        if (z2) {
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
            if (cJRAmountInputFieldWidgetV32 != null) {
                cJRAmountInputFieldWidgetV32.setInputHintTextColor(R.color.v3_text_3);
                return;
            }
            return;
        }
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV33 = this.o;
        if (cJRAmountInputFieldWidgetV33 != null) {
            cJRAmountInputFieldWidgetV33.setInputHintTextColor(R.color.v3_text_2);
        }
    }

    private final void B() {
        if (this.av) {
            A();
            return;
        }
        this.as = false;
        f();
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.au;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setVisibility(8);
        }
        EditText editText = (EditText) b(R.id.dummy_focusable_view);
        if (editText != null) {
            editText.requestFocus();
        }
        this.S.postDelayed(new i(this), 375);
    }

    static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63818a;

        i(d dVar) {
            this.f63818a = dVar;
        }

        public final void run() {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f63818a.ap, View.ALPHA, new float[]{1.0f});
            kotlin.g.b.k.a((Object) ofFloat, "animAlphaFooter");
            ofFloat.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200);
            animatorSet.addListener(new a(this, ofFloat));
            animatorSet.playTogether(new Animator[]{ofFloat});
            animatorSet.start();
        }

        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i f63819a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ObjectAnimator f63820b;

            a(i iVar, ObjectAnimator objectAnimator) {
                this.f63819a = iVar;
                this.f63820b = objectAnimator;
            }

            public final void onAnimationStart(Animator animator) {
                CJRProceedWidgetV8 p = this.f63819a.f63818a.au;
                if (p != null) {
                    p.setVisibility(8);
                }
                ViewGroup l = this.f63819a.f63818a.ap;
                if (l != null) {
                    l.setVisibility(0);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                this.f63819a.f63818a.y();
            }

            public final void onAnimationCancel(Animator animator) {
                this.f63819a.f63818a.y();
            }
        }
    }

    public final boolean a(String str, KeyEvent keyEvent) {
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() == -789823017 && str.equals("dispatch.key.event")) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("key-intercept: amount-screen: dispatchKeyEventPreIme : pressed");
            if (keyEvent != null && keyEvent.getKeyCode() == 4) {
                AppBarLayout appBarLayout = this.ao;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true, true);
                }
                if (this.at) {
                    this.av = false;
                    B();
                } else {
                    this.av = true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void C() {
        this.av = false;
        j();
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (!(cJRAmountInputFieldWidgetV3 == null || this.f61110b == null)) {
            net.one97.paytm.recharge.common.utils.t.a(cJRAmountInputFieldWidgetV3);
        }
        B();
    }

    public final void a(String str, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        ViewTreeObserver viewTreeObserver;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(onGlobalLayoutListener, "layoutListener");
        if (kotlin.g.b.k.a((Object) str, (Object) this.t)) {
            NestedScrollView nestedScrollView = this.ad;
            if (!(nestedScrollView == null || (viewTreeObserver = nestedScrollView.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            CJRPromoWidgetV3 cJRPromoWidgetV3 = this.af;
            this.ae = cJRPromoWidgetV3 != null ? cJRPromoWidgetV3.getHeight() : 0;
            CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV8 = this.ar;
            this.aq = cJRMobileFastForwardWidgetV8 != null ? cJRMobileFastForwardWidgetV8.getHeight() : 0;
            View view = getView();
            if (view == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) view, "view!!");
            int height = view.getHeight();
            AppBarLayout appBarLayout = this.ao;
            int height2 = appBarLayout != null ? appBarLayout.getHeight() : 0;
            View view2 = getView();
            if (view2 == null) {
                kotlin.g.b.k.a();
            }
            Toolbar toolbar = (Toolbar) view2.findViewById(R.id.toolbar);
            kotlin.g.b.k.a((Object) toolbar, "toolbarView");
            int height3 = height2 - toolbar.getHeight();
            NestedScrollView nestedScrollView2 = this.ad;
            if (height >= (nestedScrollView2 != null ? nestedScrollView2.getHeight() : 0) + height3) {
                AppBarLayout appBarLayout2 = this.ao;
                ViewGroup.LayoutParams layoutParams = appBarLayout2 != null ? appBarLayout2.getLayoutParams() : null;
                if (!(layoutParams instanceof CoordinatorLayout.d)) {
                    layoutParams = null;
                }
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
                behavior.setDragCallback(new net.one97.paytm.recharge.widgets.c.f(false));
                if (dVar != null) {
                    dVar.a((CoordinatorLayout.Behavior) behavior);
                }
                AppBarLayout appBarLayout3 = this.ao;
                if (appBarLayout3 != null) {
                    appBarLayout3.setLayoutParams(dVar);
                }
            }
        }
    }

    public static /* synthetic */ void a(d dVar, String str, String str2, Object obj, net.one97.paytm.recharge.common.e.ai aiVar, int i2) {
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3;
        if ((i2 & 2) != 0 && ((cJRAmountInputFieldWidgetV3 = dVar.o) == null || (str2 = cJRAmountInputFieldWidgetV3.getInputText()) == null)) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            aiVar = dVar;
        }
        dVar.a(str, str2, obj, aiVar);
    }

    public final void a(String str, String str2, Object obj, net.one97.paytm.recharge.common.e.ai aiVar) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "searchedQuery");
        kotlin.g.b.k.c(aiVar, "responseListener");
        if (isAdded() && getContext() != null) {
            if (kotlin.g.b.k.a((Object) "search.last.recharge.plan", (Object) str)) {
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
                if (cJRAmountInputFieldWidgetV3 != null) {
                    String string = getString(R.string.v3_checking_last_recharge_plan);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.v3_checking_last_recharge_plan)");
                    cJRAmountInputFieldWidgetV3.e(string);
                }
            } else {
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
                if (cJRAmountInputFieldWidgetV32 != null) {
                    String string2 = getString(R.string.v3_checking_recharge_plan);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.v3_checking_recharge_plan)");
                    cJRAmountInputFieldWidgetV32.e(string2);
                }
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                String e2 = ba.e(str2);
                kotlin.g.b.k.a((Object) e2, "RechargeUtils.getCleanAmountString(searchedQuery)");
                aVar.b(str, aiVar, e2, new String[]{"price"}, obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        r4 = r4.J;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterTextChanged(android.text.Editable r15) {
        /*
            r14 = this;
            boolean r0 = r14.L
            if (r0 != 0) goto L_0x0161
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r14.o
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x000d
            r0.d(r1)
        L_0x000d:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r14.o
            if (r0 == 0) goto L_0x0014
            r0.c(r1)
        L_0x0014:
            boolean r0 = r14.Q
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x00c0
            boolean r0 = r14.Y
            if (r0 != 0) goto L_0x00c0
            boolean r0 = r14.E
            if (r0 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x00c0
            if (r15 == 0) goto L_0x0034
            java.lang.String r0 = r15.toString()
            if (r0 == 0) goto L_0x0034
            java.lang.String r4 = r14.F
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r2)
            if (r0 == r2) goto L_0x00c0
        L_0x0034:
            r0 = 0
            r14.C = r0
            r14.D = r3
            net.one97.paytm.recharge.mobile.d.a r4 = r14.f63600h
            if (r4 == 0) goto L_0x004a
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r4 = r4.J
            androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
            if (r4 == 0) goto L_0x004a
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r4 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r4
            goto L_0x004b
        L_0x004a:
            r4 = r0
        L_0x004b:
            if (r4 == 0) goto L_0x004f
            r14.aC = r2
        L_0x004f:
            boolean r4 = r14.aC
            if (r4 == 0) goto L_0x009b
            if (r15 == 0) goto L_0x005a
            java.lang.String r4 = r15.toString()
            goto L_0x005b
        L_0x005a:
            r4 = r0
        L_0x005b:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0068
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r4 = 0
            goto L_0x0069
        L_0x0068:
            r4 = 1
        L_0x0069:
            if (r4 == 0) goto L_0x009b
            net.one97.paytm.recharge.ordersummary.h.d r5 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r4 = r14.getContext()
            if (r4 != 0) goto L_0x0076
            kotlin.g.b.k.a()
        L_0x0076:
            java.lang.String r6 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r5.<init>(r4)
            net.one97.paytm.recharge.mobile.d.a r4 = r14.f63600h
            if (r4 == 0) goto L_0x008b
            java.lang.Object r4 = r4.e()
            if (r4 != 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r6 = r4
            goto L_0x008c
        L_0x008b:
            r6 = r1
        L_0x008c:
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 120(0x78, float:1.68E-43)
            java.lang.String r7 = "plan_removed"
            java.lang.String r8 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14.aC = r3
        L_0x009b:
            net.one97.paytm.recharge.mobile.d.a r1 = r14.f63600h
            if (r1 == 0) goto L_0x00a2
            r1.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0)
        L_0x00a2:
            android.content.Context r0 = r14.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x00bd
            net.one97.paytm.recharge.common.e.a<com.paytm.network.model.IJRPaytmDataModel> r0 = r14.V
            if (r0 == 0) goto L_0x00bd
            r14.d((boolean) r3)
            io.reactivex.rxjava3.j.b<java.lang.String> r0 = r14.U
            java.lang.String r15 = java.lang.String.valueOf(r15)
            r0.onNext(r15)
            goto L_0x00c0
        L_0x00bd:
            r14.d((boolean) r2)
        L_0x00c0:
            boolean r15 = r14.M
            if (r15 == 0) goto L_0x00e0
            r14.M = r3
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r15 = r14.o
            if (r15 == 0) goto L_0x00cd
            r15.c()
        L_0x00cd:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r15 = r14.o
            if (r15 == 0) goto L_0x00d4
            r15.g()
        L_0x00d4:
            r14.b((boolean) r3)
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r15 = r14.o
            if (r15 == 0) goto L_0x00e0
            int r0 = net.one97.paytm.recharge.R.color.color_00b9f5
            r15.setDividerColor(r0)
        L_0x00e0:
            boolean r15 = r14.al
            if (r15 == 0) goto L_0x0135
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r15 = r14.o
            if (r15 == 0) goto L_0x015f
            net.one97.paytm.recharge.mobile_v3.widget.CJROutstandingAmountDisplayValuesV3$a r0 = net.one97.paytm.recharge.mobile_v3.widget.CJROutstandingAmountDisplayValuesV3.f63956d
            int r0 = net.one97.paytm.recharge.mobile_v3.widget.CJROutstandingAmountDisplayValuesV3.f63957e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r15.d(r3)
            android.widget.ViewFlipper r1 = r15.f63943f
            if (r1 == 0) goto L_0x00fc
            r1.setVisibility(r3)
        L_0x00fc:
            android.widget.ViewFlipper r1 = r15.f63943f
            if (r1 != 0) goto L_0x0103
            kotlin.g.b.k.a()
        L_0x0103:
            int r2 = net.one97.paytm.recharge.R.id.lyt_info_secondary_bill_status_2
            android.view.View r1 = r1.findViewById(r2)
            net.one97.paytm.recharge.mobile_v3.widget.CJROutstandingAmountDisplayValuesV3 r1 = (net.one97.paytm.recharge.mobile_v3.widget.CJROutstandingAmountDisplayValuesV3) r1
            android.widget.ViewFlipper r2 = r15.f63943f
            if (r2 == 0) goto L_0x0120
            android.widget.ViewFlipper r15 = r15.f63943f
            if (r15 != 0) goto L_0x0116
            kotlin.g.b.k.a()
        L_0x0116:
            r4 = r1
            android.view.View r4 = (android.view.View) r4
            int r15 = r15.indexOfChild(r4)
            r2.setDisplayedChild(r15)
        L_0x0120:
            if (r0 == 0) goto L_0x0127
            int r15 = r0.intValue()
            goto L_0x0129
        L_0x0127:
            int r15 = net.one97.paytm.recharge.mobile_v3.widget.CJROutstandingAmountDisplayValuesV3.f63955c
        L_0x0129:
            r1.f63959b = r15
            androidx.recyclerview.widget.RecyclerView$a r15 = r1.getAdapter()
            if (r15 == 0) goto L_0x015f
            r15.notifyDataSetChanged()
            goto L_0x015f
        L_0x0135:
            if (r15 != 0) goto L_0x015f
            java.lang.String r15 = r14.am
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x015f
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r15 = r14.o
            if (r15 == 0) goto L_0x015f
            int r0 = net.one97.paytm.recharge.R.string.v3_outstanding_bill_label
            java.lang.Object[] r1 = new java.lang.Object[r2]
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r2 = r14.am
            java.lang.String r2 = net.one97.paytm.recharge.widgets.c.d.d(r2)
            r1[r3] = r2
            java.lang.String r0 = r14.getString(r0, r1)
            java.lang.String r1 = "getString(R.string.v3_ou…mount(fetchedBillAmount))"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.view.View unused = r15.a((java.lang.String) r0, (java.lang.String) null, (android.view.View.OnClickListener) null)
        L_0x015f:
            r14.at = r3
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.afterTextChanged(android.text.Editable):void");
    }

    private void c(CJRServiceActions cJRServiceActions) {
        CJRInputFieldsItem cJRInputFieldsItem;
        CJRInputFieldsItem cJRInputFieldsItem2;
        kotlin.g.b.k.c(cJRServiceActions, "serviceAction");
        if (!TextUtils.isEmpty(cJRServiceActions.getBillAmountMax()) && (cJRInputFieldsItem2 = this.A) != null) {
            String billAmountMax = cJRServiceActions.getBillAmountMax();
            kotlin.g.b.k.a((Object) billAmountMax, "serviceAction.billAmountMax");
            cJRInputFieldsItem2.setMax(Double.valueOf(new BigDecimal(billAmountMax).doubleValue()));
        }
        if (!TextUtils.isEmpty(cJRServiceActions.getBillAmountMin()) && (cJRInputFieldsItem = this.A) != null) {
            String billAmountMin = cJRServiceActions.getBillAmountMin();
            kotlin.g.b.k.a((Object) billAmountMin, "serviceAction.billAmountMin");
            cJRInputFieldsItem.setMin(Double.valueOf(new BigDecimal(billAmountMin).doubleValue()));
        }
    }

    public final void a(CJRServiceActions cJRServiceActions, String str) {
        Object obj;
        kotlin.g.b.k.c(str, "amount");
        if (getActivity() != null && isAdded() && getFragmentManager() != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null || (obj = aVar.e()) == null) {
                obj = "";
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "bill_fetched_successfully", "", "bill due", (Object) null, (Object) null, (Object) null, 112);
            this.I = false;
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                if (cJRServiceActions != null) {
                    c(cJRServiceActions);
                }
                this.at = true;
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.BILL_FETCHED_SUCCESSFUL);
                if ((cJRServiceActions != null ? cJRServiceActions.getDisplayValues() : null) != null) {
                    this.al = true;
                    this.am = str;
                    ArrayList arrayList = new ArrayList();
                    if (cJRServiceActions.getDisplayValues().size() > 2) {
                        arrayList.add(cJRServiceActions.getDisplayValues().get(0));
                        arrayList.add(cJRServiceActions.getDisplayValues().get(1));
                    } else {
                        arrayList.addAll(cJRServiceActions.getDisplayValues());
                    }
                    CJRDisplayValues cJRDisplayValues = new CJRDisplayValues();
                    cJRDisplayValues.setmLabel(getString(R.string.v3_heading_bill_amount));
                    cJRDisplayValues.setmValue(str);
                    arrayList.add(cJRDisplayValues);
                    CJROutstandingAmountDisplayValuesV3.a aVar2 = CJROutstandingAmountDisplayValuesV3.f63956d;
                    Integer valueOf = Integer.valueOf(CJROutstandingAmountDisplayValuesV3.f63955c);
                    kotlin.g.b.k.c(arrayList, "displayVlaues");
                    cJRAmountInputFieldWidgetV3.d(false);
                    ViewFlipper viewFlipper = cJRAmountInputFieldWidgetV3.f63943f;
                    if (viewFlipper != null) {
                        viewFlipper.setVisibility(0);
                    }
                    ViewFlipper viewFlipper2 = cJRAmountInputFieldWidgetV3.f63943f;
                    if (viewFlipper2 == null) {
                        kotlin.g.b.k.a();
                    }
                    CJROutstandingAmountDisplayValuesV3 cJROutstandingAmountDisplayValuesV3 = (CJROutstandingAmountDisplayValuesV3) viewFlipper2.findViewById(R.id.lyt_info_secondary_bill_status_2);
                    ViewFlipper viewFlipper3 = cJRAmountInputFieldWidgetV3.f63943f;
                    if (viewFlipper3 != null) {
                        ViewFlipper viewFlipper4 = cJRAmountInputFieldWidgetV3.f63943f;
                        if (viewFlipper4 == null) {
                            kotlin.g.b.k.a();
                        }
                        viewFlipper3.setDisplayedChild(viewFlipper4.indexOfChild(cJROutstandingAmountDisplayValuesV3));
                    }
                    kotlin.g.b.k.c(arrayList, "displayVlaues");
                    cJROutstandingAmountDisplayValuesV3.f63959b = valueOf != null ? valueOf.intValue() : CJROutstandingAmountDisplayValuesV3.f63955c;
                    cJROutstandingAmountDisplayValuesV3.f63958a.clear();
                    cJROutstandingAmountDisplayValuesV3.f63958a.addAll(arrayList);
                    RecyclerView.a adapter = cJROutstandingAmountDisplayValuesV3.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                    a(str, true);
                    this.az = false;
                } else {
                    this.al = false;
                    this.am = str;
                    a(str, true);
                    this.az = true;
                    String string = getString(R.string.v3_checking_outstanding_success_label);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.v3_ch…utstanding_success_label)");
                    cJRAmountInputFieldWidgetV3.a(string, getString(R.string.v3_action_check_status), this.aE);
                    b(true);
                }
                this.ak = true;
                CJRPromoWidgetV3 cJRPromoWidgetV3 = this.af;
                if (cJRPromoWidgetV3 != null) {
                    cJRPromoWidgetV3.post(new m(this, cJRServiceActions, str));
                }
            }
            d(true);
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63824a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRServiceActions f63825b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f63826c;

        m(d dVar, CJRServiceActions cJRServiceActions, String str) {
            this.f63824a = dVar;
            this.f63825b = cJRServiceActions;
            this.f63826c = str;
        }

        public final void run() {
            this.f63824a.a(true);
            CJRPromoWidgetV3 s = this.f63824a.af;
            if (s != null) {
                s.setEnabled(true, this.f63824a);
            }
        }
    }

    public final void b(CJRServiceActions cJRServiceActions) {
        if (getActivity() != null && isAdded() && getFragmentManager() != null) {
            this.I = false;
            this.ak = false;
            this.al = false;
            this.am = null;
            this.at = false;
            this.az = true;
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                if (cJRServiceActions != null) {
                    c(cJRServiceActions);
                }
                String string = getString(R.string.v3_checking_outstanding_failed_label);
                kotlin.g.b.k.a((Object) string, "getString(R.string.v3_ch…outstanding_failed_label)");
                cJRAmountInputFieldWidgetV3.b(string, getString(R.string.v3_action_check_status), this.aE);
            }
            d(true);
        }
    }

    public final void a(CJRServiceActions cJRServiceActions) {
        Object obj;
        if (getActivity() != null && isAdded() && getFragmentManager() != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null || (obj = aVar.e()) == null) {
                obj = "";
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "bill_fetched_successfully", "", "no outstanding", (Object) null, (Object) null, (Object) null, 112);
            this.I = false;
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                if (cJRServiceActions != null) {
                    c(cJRServiceActions);
                }
                String string = getString(R.string.v3_checking_outstanding_no_due_label);
                kotlin.g.b.k.a((Object) string, "getString(R.string.v3_ch…outstanding_no_due_label)");
                CJRAmountInputFieldWidgetV3.b(cJRAmountInputFieldWidgetV3, string);
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.BILL_FETCHED_SUCCESSFUL_NO_DUE);
                this.ak = true;
                this.al = false;
                this.am = null;
                if (ExtensionsKt.isNotNullNotBlank(cJRAmountInputFieldWidgetV3.getInputText())) {
                    this.at = true;
                    CJRPromoWidgetV3 cJRPromoWidgetV3 = this.af;
                    if (cJRPromoWidgetV3 != null) {
                        cJRPromoWidgetV3.post(new s(this, cJRServiceActions));
                    }
                }
            }
            d(true);
        }
    }

    static final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63837a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRServiceActions f63838b;

        s(d dVar, CJRServiceActions cJRServiceActions) {
            this.f63837a = dVar;
            this.f63838b = cJRServiceActions;
        }

        public final void run() {
            this.f63837a.a(true);
            CJRPromoWidgetV3 s = this.f63837a.af;
            if (s != null) {
                s.setEnabled(true, this.f63837a);
            }
        }
    }

    public final Map<String, Object> q() {
        String str;
        String str2;
        String str3;
        String str4;
        LiveData liveData;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        LiveData liveData2;
        net.one97.paytm.recharge.common.h.b i2 = i();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (liveData2 = aVar.z) == null || (str = (String) liveData2.getValue()) == null) {
            str = "";
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 == null || (cJRCategoryDataHelper = aVar2.f61409b) == null || (str2 = cJRCategoryDataHelper.getGroupFieldValuesForGA()) == null) {
            str2 = "";
        }
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 == null || (str3 = cJRAmountInputFieldWidgetV3.getInputText()) == null) {
            str3 = "";
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 == null || (liveData = aVar3.f61413f) == null || (str4 = (String) liveData.getValue()) == null) {
            str4 = "";
        }
        CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV8 = this.ar;
        boolean z2 = true;
        if (cJRMobileFastForwardWidgetV8 == null || !cJRMobileFastForwardWidgetV8.a()) {
            z2 = false;
        }
        return i2.a(str, str2, str3, str4, z2);
    }

    public final void a(CJRInstruct cJRInstruct) {
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3;
        super.a(cJRInstruct);
        if (cJRInstruct instanceof CJRInstruct.openCouponsActivity) {
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
            if (cJRAmountInputFieldWidgetV32 != null) {
                cJRAmountInputFieldWidgetV32.postDelayed(new aa(this), 1000);
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                aVar.L = null;
            }
        } else if (((cJRInstruct instanceof CJRInstruct.openRechargePaymentActivity) || (cJRInstruct instanceof CJRInstruct.openPostOrderSummaryActivity)) && (cJRAmountInputFieldWidgetV3 = this.o) != null) {
            cJRAmountInputFieldWidgetV3.postDelayed(new ab(this), 1000);
        }
    }

    static final class aa implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63789a;

        aa(d dVar) {
            this.f63789a = dVar;
        }

        public final void run() {
            this.f63789a.l();
        }
    }

    static final class ab implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63790a;

        ab(d dVar) {
            this.f63790a = dVar;
        }

        public final void run() {
            this.f63790a.l();
        }
    }

    public final void c() {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.au;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.a();
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.a();
        }
        ViewGroup viewGroup = this.ap;
        if (viewGroup != null) {
            viewGroup.setEnabled(false);
        }
        View b2 = b(R.id.dummy_view);
        if (b2 != null) {
            net.one97.paytm.recharge.common.utils.ai.a(b2);
        }
    }

    static final class ac implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63791a;

        ac(d dVar) {
            this.f63791a = dVar;
        }

        public final void onOkClick() {
            com.paytm.utility.g.a((g.a) null);
            net.one97.paytm.recharge.mobile.d x = this.f63791a.f63599g;
            if (x != null) {
                x.d();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        if (r2.equals("fetch_mobile_bill_in_bg") != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a3, code lost:
        if (r2.equals("fetch_mobile_bill") != false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ab, code lost:
        if ((r5 instanceof net.one97.paytm.recharge.common.utils.al) == false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        r1 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
        if (r1 != null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b5, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b8, code lost:
        kotlin.g.b.k.a((java.lang.Object) r1, "context!!");
        r13 = new net.one97.paytm.recharge.ordersummary.h.d(r1);
        r1 = r0.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c0, code lost:
        if (r1 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
        r1 = r1.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        if (r1 != null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c9, code lost:
        r14 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cb, code lost:
        r14 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cc, code lost:
        r1 = (net.one97.paytm.recharge.common.utils.al) r5;
        r5 = r1.getError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d3, code lost:
        if (r5 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d5, code lost:
        r5 = r5.getAlertMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d9, code lost:
        if (r5 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00df, code lost:
        r17 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e1, code lost:
        net.one97.paytm.recharge.ordersummary.h.d.a(r13, r14, "Bill_fetch_error", "", r17, (java.lang.Object) null, (java.lang.Object) null, (java.lang.Object) null, 112);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f2, code lost:
        if (r0.I == false) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f4, code lost:
        r0.I = false;
        r0.az = true;
        r2 = r0.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fa, code lost:
        if (r2 == null) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fc, code lost:
        r3 = getString(net.one97.paytm.recharge.R.string.v3_checking_outstanding_failed_label);
        kotlin.g.b.k.a((java.lang.Object) r3, "getString(R.string.v3_ch…outstanding_failed_label)");
        r2.b(r3, getString(net.one97.paytm.recharge.R.string.v3_action_check_status), r0.aE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0114, code lost:
        if ((r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011c, code lost:
        if ((r1.getError() instanceof net.one97.paytm.recharge.common.utils.c) == false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011e, code lost:
        r1 = ((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8).getFlowName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0125, code lost:
        if (r1 == null) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0127, code lost:
        r1.setErrorType(net.one97.paytm.recharge.widgets.model.ERROR_TYPE.AUTH.name());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0130, code lost:
        r1 = net.one97.paytm.recharge.common.utils.az.f61525a;
        net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013a, code lost:
        b((net.one97.paytm.common.entity.shopping.CJRServiceActions) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0143, code lost:
        if ((r1.getError() instanceof net.one97.paytm.recharge.common.utils.c) == false) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0145, code lost:
        r0.J = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0148, code lost:
        r0.J = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014e, code lost:
        if (kotlin.m.p.a("fetch_mobile_bill_in_bg", r2, true) != false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0150, code lost:
        super.a(r2, r1.getError(), r8);
        j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015e, code lost:
        if ((r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0160, code lost:
        r1 = net.one97.paytm.recharge.common.utils.az.f61525a;
        net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0169, code lost:
        r1 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x016f, code lost:
        if (r1 != null) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0171, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0174, code lost:
        kotlin.g.b.k.a((java.lang.Object) r1, "context!!");
        r2 = new net.one97.paytm.recharge.ordersummary.h.d(r1);
        r1 = r0.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x017c, code lost:
        if (r1 == null) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017e, code lost:
        r1 = r1.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0182, code lost:
        if (r1 != null) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0185, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0187, code lost:
        r3 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0188, code lost:
        if (r5 == null) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018a, code lost:
        r1 = r24.getAlertMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018e, code lost:
        if (r1 != null) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0191, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0193, code lost:
        r6 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0194, code lost:
        net.one97.paytm.recharge.ordersummary.h.d.a(r2, r3, "Bill_fetch_error", "", r6, (java.lang.Object) null, (java.lang.Object) null, (java.lang.Object) null, 112);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r23, com.paytm.network.model.NetworkCustomError r24, java.lang.Object r25) {
        /*
            r22 = this;
            r0 = r22
            r2 = r23
            r5 = r24
            r8 = r25
            androidx.fragment.app.FragmentActivity r1 = r22.getActivity()
            if (r1 == 0) goto L_0x01c4
            boolean r1 = r22.isAdded()
            if (r1 != 0) goto L_0x0016
            goto L_0x01c4
        L_0x0016:
            boolean r1 = r5 instanceof net.one97.paytm.recharge.common.utils.au
            r3 = 0
            if (r1 == 0) goto L_0x004b
            boolean r1 = r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x0023
            r1 = r8
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            goto L_0x0029
        L_0x0023:
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
        L_0x0029:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x0038
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.RECREATE
            java.lang.String r3 = r3.name()
            r2.setActionType(r3)
        L_0x0038:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x0047
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            java.lang.String r3 = r3.name()
            r2.setErrorType(r3)
        L_0x0047:
            r0.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1)
            return
        L_0x004b:
            r11 = 1
            r12 = 0
            if (r2 != 0) goto L_0x0051
            goto L_0x01ba
        L_0x0051:
            int r1 = r23.hashCode()
            java.lang.String r4 = "fetch_mobile_bill_in_bg"
            switch(r1) {
                case -1673135277: goto L_0x01a1;
                case -1539539073: goto L_0x009d;
                case -1527767841: goto L_0x0096;
                case 1302090869: goto L_0x005c;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x01ba
        L_0x005c:
            java.lang.String r1 = "validate.product.selection"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x01ba
            android.os.Handler r1 = r0.S
            net.one97.paytm.recharge.mobile_v3.b.d$q r3 = new net.one97.paytm.recharge.mobile_v3.b.d$q
            r3.<init>(r0)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r1.post(r3)
            boolean r1 = r5 instanceof net.one97.paytm.recharge.common.utils.av
            if (r1 == 0) goto L_0x0091
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            androidx.fragment.app.FragmentActivity r3 = r22.getActivity()
            android.app.Activity r3 = (android.app.Activity) r3
            r4 = r0
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            r6 = 0
            r7 = 1021(0x3fd, float:1.431E-42)
            r9 = 16
            r10 = 0
            r2 = r23
            r5 = r24
            r8 = r25
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.handleError$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x01bf
        L_0x0091:
            super.a((java.lang.String) r23, (com.paytm.network.model.NetworkCustomError) r24, (java.lang.Object) r25)
            goto L_0x01bf
        L_0x0096:
            boolean r1 = r2.equals(r4)
            if (r1 == 0) goto L_0x01ba
            goto L_0x00a5
        L_0x009d:
            java.lang.String r1 = "fetch_mobile_bill"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x01ba
        L_0x00a5:
            boolean r1 = r5 instanceof net.one97.paytm.recharge.common.utils.al
            java.lang.String r6 = "context!!"
            java.lang.String r7 = ""
            if (r1 == 0) goto L_0x0169
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r1 = r22.getContext()
            if (r1 != 0) goto L_0x00b8
            kotlin.g.b.k.a()
        L_0x00b8:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r13.<init>(r1)
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            if (r1 == 0) goto L_0x00cb
            java.lang.Object r1 = r1.e()
            if (r1 != 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r14 = r1
            goto L_0x00cc
        L_0x00cb:
            r14 = r7
        L_0x00cc:
            r1 = r5
            net.one97.paytm.recharge.common.utils.al r1 = (net.one97.paytm.recharge.common.utils.al) r1
            com.paytm.network.model.NetworkCustomError r5 = r1.getError()
            if (r5 == 0) goto L_0x00df
            java.lang.String r5 = r5.getAlertMessage()
            if (r5 != 0) goto L_0x00dc
            goto L_0x00df
        L_0x00dc:
            r17 = r5
            goto L_0x00e1
        L_0x00df:
            r17 = r7
        L_0x00e1:
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 112(0x70, float:1.57E-43)
            java.lang.String r15 = "Bill_fetch_error"
            java.lang.String r16 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            boolean r5 = r0.I
            if (r5 == 0) goto L_0x013a
            r0.I = r12
            r0.az = r11
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r2 = r0.o
            if (r2 == 0) goto L_0x0112
            int r3 = net.one97.paytm.recharge.R.string.v3_checking_outstanding_failed_label
            java.lang.String r3 = r0.getString(r3)
            java.lang.String r4 = "getString(R.string.v3_ch…outstanding_failed_label)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            int r4 = net.one97.paytm.recharge.R.string.v3_action_check_status
            java.lang.String r4 = r0.getString(r4)
            android.view.View$OnClickListener r5 = r0.aE
            r2.b(r3, r4, r5)
        L_0x0112:
            boolean r2 = r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r2 == 0) goto L_0x01bf
            com.paytm.network.model.NetworkCustomError r1 = r1.getError()
            boolean r1 = r1 instanceof net.one97.paytm.recharge.common.utils.c
            if (r1 == 0) goto L_0x0130
            r1 = r8
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r1.getFlowName()
            if (r1 == 0) goto L_0x0130
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.AUTH
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x0130:
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            r1 = r8
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1)
            goto L_0x01bf
        L_0x013a:
            r0.b((net.one97.paytm.common.entity.shopping.CJRServiceActions) r3)
            com.paytm.network.model.NetworkCustomError r3 = r1.getError()
            boolean r3 = r3 instanceof net.one97.paytm.recharge.common.utils.c
            if (r3 == 0) goto L_0x0148
            r0.J = r11
            goto L_0x014a
        L_0x0148:
            r0.J = r12
        L_0x014a:
            boolean r3 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r2, (boolean) r11)
            if (r3 != 0) goto L_0x015c
            com.paytm.network.model.NetworkCustomError r1 = r1.getError()
            super.a((java.lang.String) r2, (com.paytm.network.model.NetworkCustomError) r1, (java.lang.Object) r8)
            r22.j()
            goto L_0x01bf
        L_0x015c:
            boolean r1 = r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x01bf
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            r1 = r8
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1)
            goto L_0x01bf
        L_0x0169:
            net.one97.paytm.recharge.ordersummary.h.d r2 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r1 = r22.getContext()
            if (r1 != 0) goto L_0x0174
            kotlin.g.b.k.a()
        L_0x0174:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r2.<init>(r1)
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            if (r1 == 0) goto L_0x0187
            java.lang.Object r1 = r1.e()
            if (r1 != 0) goto L_0x0185
            goto L_0x0187
        L_0x0185:
            r3 = r1
            goto L_0x0188
        L_0x0187:
            r3 = r7
        L_0x0188:
            if (r5 == 0) goto L_0x0193
            java.lang.String r1 = r24.getAlertMessage()
            if (r1 != 0) goto L_0x0191
            goto L_0x0193
        L_0x0191:
            r6 = r1
            goto L_0x0194
        L_0x0193:
            r6 = r7
        L_0x0194:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 112(0x70, float:1.57E-43)
            java.lang.String r4 = "Bill_fetch_error"
            java.lang.String r5 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x01bf
        L_0x01a1:
            java.lang.String r1 = "fetch_product_list"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x01ba
            r0.J = r12
            boolean r1 = r0.K
            if (r1 != 0) goto L_0x01bf
            r0.K = r11
            com.paytm.utility.g$a r1 = r0.aH
            com.paytm.utility.g.a((com.paytm.utility.g.a) r1)
            super.a((java.lang.String) r23, (com.paytm.network.model.NetworkCustomError) r24, (java.lang.Object) r25)
            goto L_0x01bf
        L_0x01ba:
            r0.J = r12
            super.a((java.lang.String) r23, (com.paytm.network.model.NetworkCustomError) r24, (java.lang.Object) r25)
        L_0x01bf:
            r0.d((boolean) r11)
            r0.ay = r12
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.a(java.lang.String, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    static final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63831a;

        q(d dVar) {
            this.f63831a = dVar;
        }

        public final void run() {
            this.f63831a.l();
            net.one97.paytm.recharge.mobile_v3.a.c t = this.f63831a.ai;
            if (t != null) {
                t.a();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        r1 = r1.J;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.model.v4.ErrorAction r8) {
        /*
            r7 = this;
            java.lang.String r0 = "action"
            kotlin.g.b.k.c(r8, r0)
            int[] r0 = net.one97.paytm.recharge.mobile_v3.b.e.f63844b
            int r8 = r8.ordinal()
            r8 = r0[r8]
            r0 = 1
            if (r8 == r0) goto L_0x00aa
            r1 = 2
            if (r8 == r1) goto L_0x00a6
            r1 = 3
            if (r8 == r1) goto L_0x0018
            goto L_0x00a5
        L_0x0018:
            java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r8 = r7.C
            boolean r1 = r8 instanceof java.util.ArrayList
            r2 = 0
            if (r1 != 0) goto L_0x0020
            r8 = r2
        L_0x0020:
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r1 = r7.C
            if (r1 != 0) goto L_0x005f
            net.one97.paytm.recharge.mobile.d.a r1 = r7.f63600h
            if (r1 == 0) goto L_0x0037
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r1 = r1.J
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x0037
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x005f
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            net.one97.paytm.recharge.mobile.d.a r1 = r7.f63600h
            if (r1 == 0) goto L_0x0050
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r1 = r1.J
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x0050
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1
            goto L_0x0051
        L_0x0050:
            r1 = r2
        L_0x0051:
            if (r1 == 0) goto L_0x0057
            r8.add(r1)
            goto L_0x005f
        L_0x0057:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList"
            r8.<init>(r0)
            throw r8
        L_0x005f:
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r1 = r7.B
            if (r1 == 0) goto L_0x00a2
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0069:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00a2
            java.lang.Object r3 = r1.next()
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r3
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = r7.n
            if (r4 == 0) goto L_0x007e
            java.lang.Long r4 = r4.getProductId()
            goto L_0x007f
        L_0x007e:
            r4 = r2
        L_0x007f:
            java.util.List r5 = r3.getProductList()
            r6 = 0
            if (r5 == 0) goto L_0x0093
            java.lang.Object r5 = r5.get(r6)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x0093
            java.lang.Long r5 = r5.getProductId()
            goto L_0x0094
        L_0x0093:
            r5 = r2
        L_0x0094:
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x009e
            r3.setItemSelected(r6)
            goto L_0x0069
        L_0x009e:
            r3.setItemSelected(r0)
            goto L_0x0069
        L_0x00a2:
            r7.a((java.util.ArrayList<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList>) r8, (boolean) r0)
        L_0x00a5:
            return
        L_0x00a6:
            r7.e("")
            return
        L_0x00aa:
            r7.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.a(net.one97.paytm.recharge.model.v4.ErrorAction):void");
    }

    public final void a(CJRPromoCode cJRPromoCode, CJRRechargeCart cJRRechargeCart) {
        CJRCart cart;
        String finalPrice;
        CJRPromoWidgetV3 cJRPromoWidgetV3;
        kotlin.g.b.k.c(cJRRechargeCart, "rechargeCart");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.PROMO_APPLIED);
        this.f63788f = cJRRechargeCart;
        this.v = cJRPromoCode;
        CJRPromoCode cJRPromoCode2 = this.v;
        String str = null;
        if (!TextUtils.isEmpty(cJRPromoCode2 != null ? cJRPromoCode2.getCode() : null) && (cJRPromoWidgetV3 = this.af) != null) {
            CJRPromoCode cJRPromoCode3 = this.v;
            if (cJRPromoCode3 == null) {
                kotlin.g.b.k.a();
            }
            String code = cJRPromoCode3.getCode();
            if (code == null) {
                kotlin.g.b.k.a();
            }
            View.OnClickListener onClickListener = this;
            cJRPromoWidgetV3.a(code, onClickListener, onClickListener);
        }
        net.one97.paytm.recharge.common.utils.o oVar = this.u;
        if (oVar == null || !oVar.f61684a) {
            g();
        } else {
            CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV8 = this.ar;
            if (cJRMobileFastForwardWidgetV8 != null) {
                net.one97.paytm.recharge.common.utils.ai.b(cJRMobileFastForwardWidgetV8);
            }
            View view = this.ag;
            if (view != null) {
                net.one97.paytm.recharge.common.utils.ai.b(view);
            }
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            CJRRechargeCart cJRRechargeCart2 = this.f63788f;
            if (cJRRechargeCart2 == null || (cart = cJRRechargeCart2.getCart()) == null || (finalPrice = cart.getFinalPrice()) == null) {
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
                if (cJRAmountInputFieldWidgetV3 != null) {
                    str = cJRAmountInputFieldWidgetV3.getFormattedString();
                }
            } else {
                str = finalPrice;
            }
            cJRProceedWidgetV8.setProceedBtnText(a(str));
        }
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        kotlin.g.b.k.c(cJRRechargeCart, "cjrRechargeCart");
        CJRPromoWidgetV3 cJRPromoWidgetV3 = this.af;
        if (cJRPromoWidgetV3 != null) {
            cJRPromoWidgetV3.setEnabled(true, this);
        }
        D();
    }

    private final void D() {
        if (this.v != null) {
            c();
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.PROMO_REMOVE_VERIFY.name());
            }
            a(this, "remove_promo_verify", this, false, true, a2, 4);
        }
    }

    private final void E() {
        CheckBox checkBox = (CheckBox) b(R.id.insurance_checkbox);
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        TextView textView = (TextView) b(R.id.insurance_title);
        if (textView != null) {
            textView.setSelected(false);
        }
        TextView textView2 = (TextView) b(R.id.insurance_subtitle);
        if (textView2 != null) {
            textView2.setSelected(false);
        }
        String str = null;
        this.f63788f = null;
        this.v = null;
        net.one97.paytm.recharge.common.utils.o oVar = this.u;
        if (oVar != null) {
            oVar.f61684a = false;
        }
        net.one97.paytm.recharge.common.utils.o oVar2 = this.u;
        if (oVar2 != null) {
            oVar2.f61685b = null;
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                str = cJRAmountInputFieldWidgetV3.getFormattedString();
            }
            cJRProceedWidgetV8.setProceedBtnText(a(str));
        }
        g();
    }

    public final void a(Integer num, String str, String str2) {
        int i2;
        int i3;
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setmAlertTitle(str);
        networkCustomError.setAlertMessage(str2);
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        networkCustomError.setStatusCode(i2);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            aVar.a("fetch_promo_verify", i3, (IJRPaytmDataModel) null, networkCustomError, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0090, code lost:
        r9 = r9.getProductId();
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ba A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01be A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject c(boolean r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r2 = r0.o
            if (r2 == 0) goto L_0x01e0
            net.one97.paytm.recharge.common.b.a r4 = r0.f63601i
            r5 = 1
            if (r4 == 0) goto L_0x01c0
            r4 = r2
            android.view.View r4 = (android.view.View) r4
            java.lang.String r6 = r2.getInputText()
            r7 = 0
            boolean r4 = net.one97.paytm.recharge.common.b.a.a((android.view.View) r4, (java.lang.String) r6, (boolean) r7)
            if (r4 != r5) goto L_0x01c0
            net.one97.paytm.recharge.mobile.d.a r4 = r0.f63600h
            java.lang.String r6 = "subregion_id"
            java.lang.String r7 = "ref_id"
            if (r4 == 0) goto L_0x006c
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.m
            if (r4 == 0) goto L_0x006c
            java.util.Map r4 = (java.util.Map) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r5
            if (r4 != r5) goto L_0x006c
            net.one97.paytm.recharge.mobile.d.a r4 = r0.f63600h
            if (r4 == 0) goto L_0x004e
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.m
            if (r4 == 0) goto L_0x004e
            boolean r4 = r4.containsKey(r7)
            if (r4 != r5) goto L_0x004e
            net.one97.paytm.recharge.mobile.d.a r4 = r0.f63600h
            if (r4 == 0) goto L_0x004e
            java.util.HashMap<java.lang.String, java.lang.String> r4 = r4.m
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r4.get(r7)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x004f
        L_0x004e:
            r4 = 0
        L_0x004f:
            net.one97.paytm.recharge.mobile.d.a r8 = r0.f63600h
            if (r8 == 0) goto L_0x006d
            java.util.HashMap<java.lang.String, java.lang.String> r8 = r8.m
            if (r8 == 0) goto L_0x006d
            boolean r8 = r8.containsKey(r6)
            if (r8 != r5) goto L_0x006d
            net.one97.paytm.recharge.mobile.d.a r8 = r0.f63600h
            if (r8 == 0) goto L_0x006d
            java.util.HashMap<java.lang.String, java.lang.String> r8 = r8.m
            if (r8 == 0) goto L_0x006d
            java.lang.Object r8 = r8.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x006e
        L_0x006c:
            r4 = 0
        L_0x006d:
            r8 = 0
        L_0x006e:
            if (r1 == 0) goto L_0x0074
            net.one97.paytm.recharge.model.CJRPersonalInsurance r1 = r0.y
            r14 = r1
            goto L_0x0075
        L_0x0074:
            r14 = 0
        L_0x0075:
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            if (r1 == 0) goto L_0x01be
            java.lang.String r12 = r2.getInputText()
            boolean r2 = r0.f61113e
            java.lang.String r9 = "enteredAmount"
            kotlin.g.b.k.c(r12, r9)
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r9 = r1.G
            java.lang.Object r9 = r9.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r9 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r9
            r10 = -1
            if (r9 == 0) goto L_0x009b
            java.lang.Long r9 = r9.getProductId()
            if (r9 == 0) goto L_0x009b
            long r15 = r9.longValue()
            goto L_0x009c
        L_0x009b:
            r15 = r10
        L_0x009c:
            androidx.lifecycle.y<java.lang.String> r9 = r1.z
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            boolean r17 = r1.o()
            int r18 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r18 == 0) goto L_0x01bc
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x01bc
            r10 = r12
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x01bc
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r11 = java.lang.String.valueOf(r15)
            r10.put(r11, r12)
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.Map r11 = (java.util.Map) r11
            if (r9 != 0) goto L_0x00dd
            kotlin.g.b.k.a()
        L_0x00dd:
            java.lang.String r15 = "recharge_number"
            r11.put(r15, r9)
            java.lang.String r15 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r3 = "CJRRechargeUtilityConstant.KEY_CATEGORY_ID"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r1.f61409b
            java.lang.String r3 = r3.getCategoryId()
            java.lang.String r18 = ""
            if (r3 != 0) goto L_0x00f5
            r3 = r18
        L_0x00f5:
            r11.put(r15, r3)
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r3 = r1.J
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r3 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r3
            if (r3 == 0) goto L_0x015a
            java.lang.String r15 = r3.getValidity()
            if (r15 != 0) goto L_0x010a
            r15 = r18
        L_0x010a:
            java.lang.String r5 = "validity"
            r13.put(r5, r15)
            java.lang.String r5 = r3.getTalktime()
            if (r5 != 0) goto L_0x0118
            r5 = r18
        L_0x0118:
            java.lang.String r15 = "talktime"
            r13.put(r15, r5)
            java.lang.String r5 = r3.getDescription()
            if (r5 != 0) goto L_0x0126
            r5 = r18
        L_0x0126:
            java.lang.String r15 = "couponDescription"
            r13.put(r15, r5)
            java.lang.String r5 = r3.getData()
            if (r5 != 0) goto L_0x0133
            r5 = r18
        L_0x0133:
            java.lang.String r15 = "data"
            r13.put(r15, r5)
            java.lang.String r5 = r3.getSms()
            if (r5 != 0) goto L_0x0140
            r5 = r18
        L_0x0140:
            java.lang.String r15 = "sms"
            r13.put(r15, r5)
            if (r17 == 0) goto L_0x015a
            java.lang.String r5 = "this"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            r20 = r14
            long r14 = r3.getProductId()
            java.lang.String r3 = "plan_id"
            r13.put(r3, r14)
            goto L_0x015c
        L_0x015a:
            r20 = r14
        L_0x015c:
            if (r17 == 0) goto L_0x016e
            java.lang.String r3 = "phone"
            r13.put(r3, r9)
            java.lang.String r3 = "amount"
            r13.put(r3, r12)
            r13.put(r6, r8)
            r13.put(r7, r4)
        L_0x016e:
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r3 = r1.G
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r3 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r3
            if (r3 == 0) goto L_0x018c
            java.lang.String r4 = r3.getPostOrderViewType()
            java.lang.String r5 = "post_order_view_type"
            r13.put(r5, r4)
            if (r17 == 0) goto L_0x018c
            java.lang.String r3 = r3.getOperator()
            java.lang.String r4 = "operator_id"
            r13.put(r4, r3)
        L_0x018c:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r4 = r1.G
            java.lang.Object r4 = r4.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r4 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r4
            if (r4 == 0) goto L_0x019e
            r3.add(r4)
        L_0x019e:
            if (r2 == 0) goto L_0x01a6
            java.lang.String r2 = "doNotBlockOnValidate"
            r4 = 1
            r13.put(r2, r4)
        L_0x01a6:
            net.one97.paytm.recharge.common.utils.w r1 = r1.t
            if (r1 == 0) goto L_0x01ba
            r1 = r3
            java.util.List r1 = (java.util.List) r1
            r15 = 1408(0x580, float:1.973E-42)
            r9 = r10
            r10 = r11
            r11 = r13
            r13 = r1
            r14 = r20
            org.json.JSONObject r1 = net.one97.paytm.recharge.common.utils.w.a(r9, r10, r11, r12, r13, r14, r15)
            return r1
        L_0x01ba:
            r1 = 0
            return r1
        L_0x01bc:
            r1 = 0
            return r1
        L_0x01be:
            r1 = 0
            return r1
        L_0x01c0:
            r2 = 1
            r0.M = r2
            r19.l()
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r2 = r0.o
            if (r2 == 0) goto L_0x01e0
            if (r2 != 0) goto L_0x01cf
            kotlin.g.b.k.a()
        L_0x01cf:
            r2.d()
            androidx.core.widget.NestedScrollView r2 = r0.ad
            if (r2 == 0) goto L_0x01e0
            net.one97.paytm.recharge.mobile_v3.b.d$f r3 = new net.one97.paytm.recharge.mobile_v3.b.d$f
            r3.<init>(r0, r1)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.post(r3)
        L_0x01e0:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.c(boolean):org.json.JSONObject");
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63814a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f63815b;

        f(d dVar, boolean z) {
            this.f63814a = dVar;
            this.f63815b = z;
        }

        public final void run() {
            NestedScrollView u = this.f63814a.ad;
            if (u != null) {
                CJRAmountInputFieldWidgetV3 h2 = this.f63814a.o;
                if (h2 == null) {
                    kotlin.g.b.k.a();
                }
                u.scrollTo(0, h2.getErrorView().getBottom());
            }
        }
    }

    private final void F() {
        String str;
        String str2;
        String str3;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        LiveData liveData;
        CJRSelectedRecharge cJRSelectedRecharge = new CJRSelectedRecharge();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null) {
            kotlin.g.b.k.a();
        }
        Object value = aVar.G.getValue();
        if (value == null) {
            kotlin.g.b.k.a();
        }
        Long productId = ((CJRProductsItem) value).getProductId();
        if (productId == null) {
            kotlin.g.b.k.a();
        }
        cJRSelectedRecharge.setProductId(String.valueOf(productId.longValue()));
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 == null || (str = cJRAmountInputFieldWidgetV3.getInputText()) == null) {
            str = "10";
        }
        cJRSelectedRecharge.setProductPrice(str);
        Map hashMap = new HashMap();
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 == null || (liveData = aVar2.z) == null || (str2 = (String) liveData.getValue()) == null) {
            str2 = "";
        }
        hashMap.put("recharge_number", str2);
        String productPrice = cJRSelectedRecharge.getProductPrice();
        kotlin.g.b.k.a((Object) productPrice, "selectedRecharge.productPrice");
        hashMap.put("price", productPrice);
        String productPrice2 = cJRSelectedRecharge.getProductPrice();
        kotlin.g.b.k.a((Object) productPrice2, "selectedRecharge.productPrice");
        hashMap.put("totalamount", productPrice2);
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 == null || (cJRCategoryDataHelper = aVar3.f61409b) == null || (str3 = cJRCategoryDataHelper.getCategoryId()) == null) {
            str3 = "";
        }
        hashMap.put("category_id", str3);
        cJRSelectedRecharge.setConfigList(hashMap);
        net.one97.paytm.recharge.common.utils.o oVar = this.u;
        if (oVar != null) {
            oVar.a(cJRSelectedRecharge);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cJRSelectedRecharge);
        net.one97.paytm.recharge.common.utils.o oVar2 = this.u;
        if (oVar2 != null) {
            oVar2.a((ArrayList<CJRSelectedRecharge>) arrayList);
        }
        CheckBox checkBox = (CheckBox) b(R.id.insurance_checkbox);
        boolean z2 = true;
        if (checkBox == null || !checkBox.isChecked()) {
            z2 = false;
        }
        JSONObject c2 = c(z2);
        if (c2 != null) {
            net.one97.paytm.recharge.common.utils.o oVar3 = this.u;
            if (oVar3 != null) {
                oVar3.f61686c = c2;
            }
            net.one97.paytm.recharge.common.utils.o oVar4 = this.u;
            if (oVar4 != null) {
                oVar4.c();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void k(String str) {
        List<CJRAggsItem> list;
        String str2;
        String str3;
        HashMap<String, String> hashMap;
        String str4;
        HashMap<String, String> hashMap2;
        HashMap<String, String> hashMap3;
        HashMap<String, String> hashMap4;
        net.one97.paytm.recharge.mobile.d.a aVar;
        HashMap<String, String> hashMap5;
        c();
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 != null) {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(false);
            }
            String str5 = null;
            if (this.f63601i == null || !net.one97.paytm.recharge.common.b.a.a((View) cJRAmountInputFieldWidgetV3, cJRAmountInputFieldWidgetV3.getInputText(), false)) {
                this.M = true;
                l();
                net.one97.paytm.recharge.mobile_v3.a.c cVar = this.ai;
                if (cVar != null) {
                    cVar.dismissAllowingStateLoss();
                }
                if (!kotlin.g.b.k.a((Object) "validate.last.recharge.plan", (Object) str) || ((list = this.B) != null && (list == null || list.size() != 1))) {
                    List<CJRAggsItem> list2 = this.B;
                    if ((list2 != null ? list2.size() : 0) > 1) {
                        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
                        if (cJRAmountInputFieldWidgetV32 != null) {
                            str5 = cJRAmountInputFieldWidgetV32.getInputText();
                        }
                        if (TextUtils.isEmpty(str5)) {
                            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV33 = this.o;
                            if (cJRAmountInputFieldWidgetV33 != null) {
                                cJRAmountInputFieldWidgetV33.g();
                            }
                            this.az = false;
                        }
                    }
                } else {
                    this.az = true;
                    CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV34 = this.o;
                    if (cJRAmountInputFieldWidgetV34 != null) {
                        String string = getString(R.string.v3_checking_last_recharge_plan_failed_label);
                        kotlin.g.b.k.a((Object) string, "getString(R.string.v3_ch…charge_plan_failed_label)");
                        cJRAmountInputFieldWidgetV34.c(string, getString(R.string.v3_action_check_status), this.aF);
                    }
                }
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV35 = this.o;
                if (cJRAmountInputFieldWidgetV35 != null) {
                    if (cJRAmountInputFieldWidgetV35 == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRAmountInputFieldWidgetV35.d();
                    NestedScrollView nestedScrollView = this.ad;
                    if (nestedScrollView != null) {
                        nestedScrollView.post(new ah(this, str));
                    }
                }
            } else {
                View b2 = b(R.id.dummy_view);
                if (b2 != null) {
                    net.one97.paytm.recharge.common.utils.ai.a(b2);
                }
                net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                if (aVar2 == null || (hashMap = aVar2.m) == null || !(!hashMap.isEmpty())) {
                    str3 = null;
                    str2 = null;
                } else {
                    net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                    if (aVar3 == null || (hashMap4 = aVar3.m) == null || !hashMap4.containsKey("ref_id") || (aVar = this.f63600h) == null || (hashMap5 = aVar.m) == null) {
                        str4 = null;
                    } else {
                        str4 = hashMap5.get("ref_id");
                    }
                    net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
                    if (aVar4 == null || (hashMap2 = aVar4.m) == null || !hashMap2.containsKey("subregion_id")) {
                        str3 = str4;
                        str2 = null;
                    } else {
                        net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
                        str3 = str4;
                        str2 = (aVar5 == null || (hashMap3 = aVar5.m) == null) ? null : hashMap3.get("subregion_id");
                    }
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.VERIFY_CALL.name());
                }
                net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
                if (aVar6 != null) {
                    aVar6.a(str, cJRAmountInputFieldWidgetV3.getInputText(), str3, str2, (net.one97.paytm.recharge.common.e.ai) this, (Object) a2);
                }
            }
            new Handler().postDelayed(new ai(this, str), 1000);
        }
    }

    static final class ah implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63801a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f63802b;

        ah(d dVar, String str) {
            this.f63801a = dVar;
            this.f63802b = str;
        }

        public final void run() {
            NestedScrollView u = this.f63801a.ad;
            if (u != null) {
                CJRAmountInputFieldWidgetV3 h2 = this.f63801a.o;
                if (h2 == null) {
                    kotlin.g.b.k.a();
                }
                u.scrollTo(0, h2.getErrorView().getBottom());
            }
        }
    }

    static final class ai implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63803a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f63804b;

        ai(d dVar, String str) {
            this.f63803a = dVar;
            this.f63804b = str;
        }

        public final void run() {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f63803a.b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(true);
            }
        }
    }

    public void onClick(View view) {
        LiveData liveData;
        String str;
        String str2;
        String str3;
        net.one97.paytm.recharge.mobile.d.a aVar;
        HashMap<String, String> hashMap;
        String str4;
        HashMap<String, String> hashMap2;
        HashMap<String, String> hashMap3;
        HashMap<String, String> hashMap4;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        HashMap<String, String> hashMap5;
        CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage;
        String str5;
        CJRCart cart;
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3;
        net.one97.paytm.recharge.mobile_v3.a.d dVar;
        net.one97.paytm.recharge.mobile_v3.a.a aVar3;
        View view2 = view;
        if (view2 != null && !net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(view2, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
            int id = view.getId();
            Object obj = null;
            if (id == R.id.insurance_layout) {
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
                if (cJRAmountInputFieldWidgetV32 != null) {
                    cJRAmountInputFieldWidgetV32.clearFocus();
                    kotlin.x xVar = kotlin.x.f47997a;
                }
                CJRPersonalInsurance cJRPersonalInsurance = this.y;
                if (cJRPersonalInsurance != null) {
                    if (this.x == null) {
                        this.x = new net.one97.paytm.recharge.mobile_v3.a.a();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("tnc_title", getString(R.string.insurance_tnc_detail_dialog_title));
                    CheckBox checkBox = (CheckBox) b(R.id.insurance_checkbox);
                    kotlin.g.b.k.a((Object) checkBox, "insurance_checkbox");
                    bundle.putBoolean("intent_is_insurance_checked", checkBox.isChecked());
                    bundle.putString("tnc_text", cJRPersonalInsurance.getTermsAndConditions());
                    net.one97.paytm.recharge.mobile_v3.a.a aVar4 = this.x;
                    if (aVar4 == null) {
                        kotlin.g.b.k.a();
                    }
                    aVar4.setArguments(bundle);
                    net.one97.paytm.recharge.mobile_v3.a.a aVar5 = this.x;
                    if (aVar5 != null) {
                        if (aVar5 == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!aVar5.isAdded()) {
                            net.one97.paytm.recharge.mobile_v3.a.a aVar6 = this.x;
                            if (aVar6 != null) {
                                obj = aVar6.getFragmentManager();
                            }
                            if (obj == null && (aVar3 = this.x) != null) {
                                androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                                aVar3.show(childFragmentManager, aI);
                                kotlin.x xVar2 = kotlin.x.f47997a;
                            }
                        }
                    }
                    kotlin.x xVar3 = kotlin.x.f47997a;
                }
            } else if (id == R.id.txt_promo_enabled) {
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.APPLY_PROMO_CLICKED);
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV33 = this.o;
                if (cJRAmountInputFieldWidgetV33 != null) {
                    cJRAmountInputFieldWidgetV33.clearFocus();
                    kotlin.x xVar4 = kotlin.x.f47997a;
                }
                if (this.Y || this.at) {
                    F();
                    return;
                }
                net.one97.paytm.recharge.mobile.d.a aVar7 = this.f63600h;
                if (aVar7 != null) {
                    obj = aVar7.S;
                }
                if (obj == null) {
                    this.aj = true;
                    k("amount_verify_call");
                    return;
                }
                F();
            } else if (id == R.id.lyt_remove_promo) {
                net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.REMOVE_PROMO_CLICKED);
                D();
            } else if (id != R.id.txt_promo_applied) {
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) b(R.id.ic_operator);
                kotlin.g.b.k.a((Object) cJRCircleImageViewV8, "ic_operator");
                if (id != cJRCircleImageViewV8.getId()) {
                    TextView textView = (TextView) b(R.id.txt_update_operator);
                    kotlin.g.b.k.a((Object) textView, "txt_update_operator");
                    if (id != textView.getId()) {
                        if (id == R.id.btn_pre_validate) {
                            net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.PRE_VALIDATE_CLICKED);
                            if (com.paytm.utility.b.c(getContext())) {
                                w();
                            }
                            if (this.az && (cJRAmountInputFieldWidgetV3 = this.o) != null) {
                                ViewFlipper viewFlipper = cJRAmountInputFieldWidgetV3.f63943f;
                                if (viewFlipper != null) {
                                    viewFlipper.setVisibility(0);
                                }
                                kotlin.x xVar5 = kotlin.x.f47997a;
                            }
                            if (!com.paytm.utility.b.c(getContext())) {
                                net.one97.paytm.recharge.widgets.c.d dVar5 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                                CRUFlowModel flowName = a2.getFlowName();
                                if (flowName != null) {
                                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                                }
                                CRUFlowModel flowName2 = a2.getFlowName();
                                if (flowName2 != null) {
                                    flowName2.setActionType(ACTION_TYPE.VERIFY_CALL.name());
                                }
                                a("amount_verify_call", 0, (IJRPaytmDataModel) null, (NetworkCustomError) new as(false, 1, (kotlin.g.b.g) null), (Object) a2);
                                return;
                            }
                            List<CJRAggsItem> list = this.B;
                            if ((list != null ? list.size() : 0) > 1 && this.D) {
                                G();
                                return;
                            } else if (this.Y) {
                                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV34 = this.o;
                                if (cJRAmountInputFieldWidgetV34 != null) {
                                    if (this.f63601i == null || !net.one97.paytm.recharge.common.b.a.a((View) cJRAmountInputFieldWidgetV34, cJRAmountInputFieldWidgetV34.getInputText(), false)) {
                                        this.M = true;
                                        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV35 = this.o;
                                        if (cJRAmountInputFieldWidgetV35 == null) {
                                            kotlin.g.b.k.a();
                                        }
                                        cJRAmountInputFieldWidgetV35.d();
                                    } else {
                                        a(true);
                                        this.at = true;
                                        CJRPromoWidgetV3 cJRPromoWidgetV3 = this.af;
                                        if (cJRPromoWidgetV3 != null) {
                                            cJRPromoWidgetV3.setEnabled(true, this);
                                            kotlin.x xVar6 = kotlin.x.f47997a;
                                        }
                                        C();
                                    }
                                    kotlin.x xVar7 = kotlin.x.f47997a;
                                    return;
                                }
                                return;
                            } else if (this.at) {
                                C();
                                return;
                            } else {
                                this.aj = false;
                                k("amount_verify_call");
                                return;
                            }
                        } else if (id == R.id.btn_proceed) {
                            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV36 = this.o;
                            if (cJRAmountInputFieldWidgetV36 != null) {
                                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
                                if (cJRProceedWidgetV8 != null) {
                                    cJRProceedWidgetV8.setEnabled(false);
                                }
                                if (!this.p && (cJRSuccessRateAlertMessage = this.q) != null) {
                                    if (!TextUtils.isEmpty(cJRSuccessRateAlertMessage != null ? cJRSuccessRateAlertMessage.getMessage() : null)) {
                                        net.one97.paytm.recharge.common.c.g gVar = this.aD;
                                        if (gVar == null) {
                                            CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage2 = this.q;
                                            if (cJRSuccessRateAlertMessage2 == null) {
                                                kotlin.g.b.k.a();
                                            }
                                            CJRRechargeCart cJRRechargeCart = this.f63788f;
                                            if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (str5 = cart.getFinalPrice()) == null) {
                                                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV37 = this.o;
                                                str5 = cJRAmountInputFieldWidgetV37 != null ? cJRAmountInputFieldWidgetV37.getFormattedString() : null;
                                            }
                                            this.aD = new net.one97.paytm.recharge.common.c.g(cJRSuccessRateAlertMessage2, a(str5), new ag(this));
                                        } else if (gVar != null) {
                                            CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage3 = this.q;
                                            if (cJRSuccessRateAlertMessage3 == null) {
                                                kotlin.g.b.k.a();
                                            }
                                            gVar.a(cJRSuccessRateAlertMessage3);
                                        }
                                        net.one97.paytm.recharge.common.c.g gVar2 = this.aD;
                                        if (gVar2 == null) {
                                            kotlin.g.b.k.a();
                                        }
                                        if (!gVar2.isAdded()) {
                                            net.one97.paytm.recharge.common.c.g gVar3 = this.aD;
                                            if (gVar3 != null) {
                                                androidx.fragment.app.j childFragmentManager2 = getChildFragmentManager();
                                                g.a aVar8 = net.one97.paytm.recharge.common.c.g.f60996a;
                                                gVar3.show(childFragmentManager2, net.one97.paytm.recharge.common.c.g.f60997e);
                                            }
                                            net.one97.paytm.recharge.widgets.c.d dVar6 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                                            CRUFlowModel flowName3 = a3.getFlowName();
                                            if (flowName3 != null) {
                                                flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
                                            }
                                            CRUFlowModel flowName4 = a3.getFlowName();
                                            if (flowName4 != null) {
                                                flowName4.setActionType(ACTION_TYPE.SUCCESS_RATE_ALERT.name());
                                            }
                                            az azVar = az.f61525a;
                                            az.a(a3);
                                        }
                                    }
                                } else if (this.f63601i == null || !net.one97.paytm.recharge.common.b.a.a((View) cJRAmountInputFieldWidgetV36, cJRAmountInputFieldWidgetV36.getInputText(), false)) {
                                    this.M = true;
                                    l();
                                    CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV38 = this.o;
                                    if (cJRAmountInputFieldWidgetV38 != null) {
                                        if (cJRAmountInputFieldWidgetV38 == null) {
                                            kotlin.g.b.k.a();
                                        }
                                        cJRAmountInputFieldWidgetV38.d();
                                        NestedScrollView nestedScrollView = this.ad;
                                        if (nestedScrollView != null) {
                                            Boolean.valueOf(nestedScrollView.post(new n(this)));
                                        }
                                    }
                                } else {
                                    net.one97.paytm.recharge.widgets.c.d dVar7 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                    net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.PROCEED_CLICKED);
                                    j();
                                    View b2 = b(R.id.dummy_view);
                                    if (b2 != null) {
                                        net.one97.paytm.recharge.common.utils.ai.a(b2);
                                        kotlin.x xVar8 = kotlin.x.f47997a;
                                    }
                                    CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV39 = this.o;
                                    if (cJRAmountInputFieldWidgetV39 != null) {
                                        cJRAmountInputFieldWidgetV39.clearFocus();
                                        kotlin.x xVar9 = kotlin.x.f47997a;
                                    }
                                    net.one97.paytm.recharge.mobile.d.a aVar9 = this.f63600h;
                                    if (aVar9 == null || (hashMap = aVar9.m) == null || !(!hashMap.isEmpty())) {
                                        str3 = null;
                                        str2 = null;
                                    } else {
                                        net.one97.paytm.recharge.mobile.d.a aVar10 = this.f63600h;
                                        if (aVar10 == null || (hashMap4 = aVar10.m) == null || !hashMap4.containsKey("ref_id") || (aVar2 = this.f63600h) == null || (hashMap5 = aVar2.m) == null) {
                                            str4 = null;
                                        } else {
                                            str4 = hashMap5.get("ref_id");
                                        }
                                        net.one97.paytm.recharge.mobile.d.a aVar11 = this.f63600h;
                                        if (aVar11 == null || (hashMap2 = aVar11.m) == null || !hashMap2.containsKey("subregion_id")) {
                                            str3 = str4;
                                            str2 = null;
                                        } else {
                                            net.one97.paytm.recharge.mobile.d.a aVar12 = this.f63600h;
                                            str3 = str4;
                                            str2 = (aVar12 == null || (hashMap3 = aVar12.m) == null) ? null : hashMap3.get("subregion_id");
                                        }
                                    }
                                    net.one97.paytm.recharge.widgets.c.d dVar8 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                    CJRRechargeErrorModel a4 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.CLP_PROCEED, ERROR_TYPE.UNDEFINED);
                                    net.one97.paytm.recharge.widgets.c.d dVar9 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                    net.one97.paytm.recharge.widgets.c.d.b(a4, ACTION_TYPE.CLP_PROCEED);
                                    net.one97.paytm.recharge.widgets.c.d dVar10 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                                    net.one97.paytm.recharge.widgets.c.d.a(a4, ACTION_TYPE.CLP_PROCEED);
                                    CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
                                    if (cJRProceedWidgetV82 != null) {
                                        cJRProceedWidgetV82.a();
                                        kotlin.x xVar10 = kotlin.x.f47997a;
                                    }
                                    CheckBox checkBox2 = (CheckBox) b(R.id.insurance_checkbox);
                                    CJRPersonalInsurance cJRPersonalInsurance2 = (checkBox2 == null || !checkBox2.isChecked()) ? null : this.y;
                                    FragmentActivity activity = getActivity();
                                    if (!(activity == null || (aVar = this.f63600h) == null)) {
                                        kotlin.g.b.k.a((Object) activity, "it");
                                        Context context = activity;
                                        String inputText = cJRAmountInputFieldWidgetV36.getInputText();
                                        CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV8 = this.ar;
                                        boolean z2 = cJRMobileFastForwardWidgetV8 != null && cJRMobileFastForwardWidgetV8.a();
                                        boolean z3 = this.f61113e;
                                        CJRPromoCode cJRPromoCode = this.v;
                                        Boolean.valueOf(aVar.a(context, "verify", inputText, z2, z3, str3, str2, a4, cJRPersonalInsurance2, cJRPromoCode != null ? cJRPromoCode.getCode() : null, this.u));
                                    }
                                }
                                net.one97.paytm.recharge.mobile.d.a aVar13 = this.f63600h;
                                if (aVar13 != null) {
                                    net.one97.paytm.recharge.ordersummary.h.d.a(aVar13.v, aVar13.e(), "amount_entered_non_prefetch", (Object) null, cJRAmountInputFieldWidgetV36.getInputText(), (Object) null, (Object) null, (Object) null, 116);
                                    CJRMobileFastForwardWidgetV8 cJRMobileFastForwardWidgetV82 = this.ar;
                                    if (cJRMobileFastForwardWidgetV82 == null || !cJRMobileFastForwardWidgetV82.a()) {
                                        if (this.ac) {
                                            d.a aVar14 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                                            str = net.one97.paytm.recharge.ordersummary.h.d.k;
                                        } else {
                                            d.a aVar15 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                                            str = net.one97.paytm.recharge.ordersummary.h.d.f64342i;
                                        }
                                    } else if (this.ac) {
                                        d.a aVar16 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                                        str = net.one97.paytm.recharge.ordersummary.h.d.j;
                                    } else {
                                        d.a aVar17 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                                        str = net.one97.paytm.recharge.ordersummary.h.d.f64341h;
                                    }
                                    String str6 = str;
                                    net.one97.paytm.recharge.ordersummary.h.d dVar11 = aVar13.v;
                                    Object e2 = aVar13.e();
                                    String str7 = net.one97.paytm.common.utility.d.ez;
                                    kotlin.g.b.k.a((Object) str7, "CJRGTMConstants.GTM_EVENT_PROCEED_CLICKED");
                                    CJRProductsItem cJRProductsItem = this.n;
                                    if (cJRProductsItem != null) {
                                        obj = cJRProductsItem.getProductId();
                                    }
                                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar11, e2, str7, (Object) null, str6, (Object) null, String.valueOf(obj), (Object) null, 84);
                                    kotlin.x xVar11 = kotlin.x.f47997a;
                                }
                                new Handler().postDelayed(new o(this), 1000);
                                kotlin.x xVar12 = kotlin.x.f47997a;
                                return;
                            }
                            return;
                        } else if (id == R.id.lyt_info_secondary_plan_status_1 || id == R.id.lyt_info_secondary_plan_status_2) {
                            Object tag = view.getTag();
                            if (!(tag instanceof kotlin.o)) {
                                tag = null;
                            }
                            kotlin.o oVar = (kotlin.o) tag;
                            if (getContext() != null && isAdded() && !isDetached() && getFragmentManager() != null && oVar != null) {
                                j();
                                CJRBrowsePlanProductList cJRBrowsePlanProductList = (CJRBrowsePlanProductList) oVar.getFirst();
                                ArrayList arrayList = new ArrayList();
                                for (kotlin.o oVar2 : (Iterable) oVar.getSecond()) {
                                    arrayList.add(((String) oVar2.getFirst()) + ' ' + ((String) oVar2.getSecond()));
                                }
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("title", getString(R.string.v3_dialog_header_plans_details));
                                bundle2.putString("info.msg.1", cJRBrowsePlanProductList.getDescription());
                                bundle2.putSerializable("list.data", arrayList);
                                if (this.ah == null) {
                                    Context context2 = getContext();
                                    if (context2 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    Fragment instantiate = Fragment.instantiate(context2, net.one97.paytm.recharge.mobile_v3.a.b.class.getName(), bundle2);
                                    if (!(instantiate instanceof net.one97.paytm.recharge.mobile_v3.a.b)) {
                                        instantiate = null;
                                    }
                                    this.ah = (net.one97.paytm.recharge.mobile_v3.a.b) instantiate;
                                }
                                net.one97.paytm.recharge.mobile_v3.a.b bVar = this.ah;
                                if (bVar != null) {
                                    bVar.setArguments(bundle2);
                                }
                                net.one97.paytm.recharge.mobile_v3.a.b bVar2 = this.ah;
                                if (bVar2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                bVar2.f63726a = new p(this, view2);
                                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV310 = this.o;
                                if (cJRAmountInputFieldWidgetV310 != null) {
                                    cJRAmountInputFieldWidgetV310.clearFocus();
                                    kotlin.x xVar13 = kotlin.x.f47997a;
                                }
                                net.one97.paytm.recharge.mobile_v3.a.b bVar3 = this.ah;
                                if (bVar3 != null) {
                                    bVar3.show(getChildFragmentManager(), net.one97.paytm.recharge.mobile_v3.a.b.class.getSimpleName());
                                    kotlin.x xVar14 = kotlin.x.f47997a;
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (id == R.id.lyt_info_secondary_product_type) {
                            List<? extends CJRBrowsePlanProductList> list2 = this.C;
                            if (!(list2 instanceof ArrayList)) {
                                list2 = null;
                            }
                            ArrayList arrayList2 = (ArrayList) list2;
                            if (this.C == null) {
                                net.one97.paytm.recharge.mobile.d.a aVar18 = this.f63600h;
                                if (!(aVar18 == null || (liveData = aVar18.J) == null)) {
                                    obj = (CJRBrowsePlanProductList) liveData.getValue();
                                }
                                if (obj != null) {
                                    arrayList2 = new ArrayList();
                                    net.one97.paytm.recharge.mobile.d.a aVar19 = this.f63600h;
                                    if (aVar19 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    Object value = aVar19.J.getValue();
                                    if (value != null) {
                                        arrayList2.add((CJRBrowsePlanProductList) value);
                                    } else {
                                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList");
                                    }
                                }
                            }
                            a((ArrayList<CJRBrowsePlanProductList>) arrayList2, true);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                int id2 = view.getId();
                CJRCircleImageViewV8 cJRCircleImageViewV82 = (CJRCircleImageViewV8) b(R.id.ic_operator);
                kotlin.g.b.k.a((Object) cJRCircleImageViewV82, "ic_operator");
                e(id2 == cJRCircleImageViewV82.getId() ? H5Param.MENU_ICON : "link");
            } else if (this.v != null) {
                if (this.w == null) {
                    this.w = new net.one97.paytm.recharge.mobile_v3.a.d();
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("tnc_title", getString(R.string.mobile_offer_detail_dialog_title));
                CJRPromoCode cJRPromoCode2 = this.v;
                if (cJRPromoCode2 == null) {
                    kotlin.g.b.k.a();
                }
                bundle3.putString("coupon_code_extra", cJRPromoCode2.getCode());
                CJRPromoCode cJRPromoCode3 = this.v;
                if (cJRPromoCode3 == null) {
                    kotlin.g.b.k.a();
                }
                bundle3.putString("tnc_text", cJRPromoCode3.getTerms());
                net.one97.paytm.recharge.mobile_v3.a.d dVar12 = this.w;
                if (dVar12 == null) {
                    kotlin.g.b.k.a();
                }
                dVar12.setArguments(bundle3);
                net.one97.paytm.recharge.mobile_v3.a.d dVar13 = this.w;
                if (dVar13 != null) {
                    if (dVar13 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!dVar13.isAdded()) {
                        net.one97.paytm.recharge.mobile_v3.a.d dVar14 = this.w;
                        if (dVar14 != null) {
                            obj = dVar14.getFragmentManager();
                        }
                        if (obj == null && (dVar = this.w) != null) {
                            dVar.show(getChildFragmentManager(), aI);
                        }
                    }
                }
            }
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63827a;

        n(d dVar) {
            this.f63827a = dVar;
        }

        public final void run() {
            NestedScrollView u = this.f63827a.ad;
            if (u != null) {
                CJRAmountInputFieldWidgetV3 h2 = this.f63827a.o;
                if (h2 == null) {
                    kotlin.g.b.k.a();
                }
                u.scrollTo(0, h2.getErrorView().getBottom());
            }
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63828a;

        o(d dVar) {
            this.f63828a = dVar;
        }

        public final void run() {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f63828a.b(R.id.btn_proceed);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(true);
            }
        }
    }

    static final class p implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63829a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63830b;

        p(d dVar, View view) {
            this.f63829a = dVar;
            this.f63830b = view;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f63830b.performClick();
            this.f63829a.C();
        }
    }

    /* access modifiers changed from: private */
    public final void d(boolean z2) {
        if (z2) {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = this.au;
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setOnClickListener(this);
            }
            CJRCircleImageViewV8 cJRCircleImageViewV8 = this.aw;
            if (cJRCircleImageViewV8 != null) {
                cJRCircleImageViewV8.setOnClickListener(this);
            }
            TextView textView = this.ax;
            if (textView != null) {
                textView.setOnClickListener(this);
                return;
            }
            return;
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = this.au;
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.setOnClickListener((View.OnClickListener) null);
        }
        CJRCircleImageViewV8 cJRCircleImageViewV82 = this.aw;
        if (cJRCircleImageViewV82 != null) {
            cJRCircleImageViewV82.setOnClickListener((View.OnClickListener) null);
        }
        TextView textView2 = this.ax;
        if (textView2 != null) {
            textView2.setOnClickListener((View.OnClickListener) null);
        }
    }

    private final void a(ArrayList<CJRBrowsePlanProductList> arrayList, boolean z2) {
        LiveData liveData;
        if (getContext() != null && isAdded() && !isDetached() && getFragmentManager() != null) {
            net.one97.paytm.recharge.mobile_v3.a.c cVar = this.ai;
            if (cVar != null) {
                if (cVar != null && !cVar.isAdded()) {
                    net.one97.paytm.recharge.mobile_v3.a.c cVar2 = this.ai;
                    if ((cVar2 != null ? cVar2.getFragmentManager() : null) != null) {
                        return;
                    }
                } else {
                    return;
                }
            }
            j();
            Bundle bundle = new Bundle();
            bundle.putString("title", getString(R.string.v3_dialog_header_recharge_type));
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            bundle.putSerializable("info.msg.1", (aVar == null || (liveData = aVar.J) == null) ? null : (CJRBrowsePlanProductList) liveData.getValue());
            bundle.putSerializable("info.msg.2", arrayList);
            List<CJRAggsItem> list = this.B;
            if (list != null) {
                bundle.putSerializable("list.data", (ArrayList) list);
                if (this.ai == null) {
                    Context context = getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    Fragment instantiate = Fragment.instantiate(context, net.one97.paytm.recharge.mobile_v3.a.c.class.getName(), bundle);
                    if (!(instantiate instanceof net.one97.paytm.recharge.mobile_v3.a.c)) {
                        instantiate = null;
                    }
                    this.ai = (net.one97.paytm.recharge.mobile_v3.a.c) instantiate;
                }
                net.one97.paytm.recharge.mobile_v3.a.c cVar3 = this.ai;
                if (cVar3 != null) {
                    cVar3.setArguments(bundle);
                }
                net.one97.paytm.recharge.mobile_v3.a.c cVar4 = this.ai;
                if (cVar4 != null) {
                    cVar4.f63733a = this;
                }
                net.one97.paytm.recharge.mobile_v3.a.c cVar5 = this.ai;
                if (cVar5 != null) {
                    cVar5.setCancelable(z2);
                }
                net.one97.paytm.recharge.mobile_v3.a.c cVar6 = this.ai;
                if (cVar6 != null) {
                    androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                    kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                    cVar6.show(childFragmentManager, net.one97.paytm.recharge.mobile_v3.a.c.class.getSimpleName());
                    return;
                }
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.recharge.model.v4.CJRAggsItem>");
        }
    }

    public final void a(String str, io.reactivex.rxjava3.b.c cVar) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2042516569) {
                if (hashCode != -1650697714) {
                    if (hashCode != 1501798078 || !str.equals("search.last.recharge.plan")) {
                        return;
                    }
                } else if (!str.equals("search_browse_plan_prefill")) {
                    return;
                }
            } else if (!str.equals("search_browse_plan")) {
                return;
            }
            this.T = cVar;
        }
    }

    private final void G() {
        View view;
        this.at = false;
        j();
        CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
        if (cJRAmountInputFieldWidgetV3 != null) {
            int i2 = R.id.lyt_info_secondary_product_type;
            ViewFlipper viewFlipper = cJRAmountInputFieldWidgetV3.f63943f;
            if (viewFlipper == null) {
                kotlin.g.b.k.a();
            }
            view = viewFlipper.findViewById(i2);
        } else {
            view = null;
        }
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.ck_status_action_arrow) : null;
        if (!(imageView instanceof ImageView)) {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setSelected(!imageView.isSelected());
        }
        List<CJRAggsItem> list = this.B;
        if (list != null) {
            int i3 = 0;
            for (Object next : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.k.a();
                }
                CJRAggsItem cJRAggsItem = (CJRAggsItem) next;
                if (i3 == 0) {
                    cJRAggsItem.setItemSelected(true);
                } else {
                    cJRAggsItem.setItemSelected(false);
                }
                i3 = i4;
            }
        }
        List<? extends CJRBrowsePlanProductList> list2 = this.C;
        if (!(list2 instanceof ArrayList)) {
            list2 = null;
        }
        a((ArrayList<CJRBrowsePlanProductList>) (ArrayList) list2, false);
        if (!this.av) {
            this.av = true;
            x();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v1, types: [java.util.List, java.util.List<? extends net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList>] */
    /* JADX WARNING: type inference failed for: r12v15 */
    /* JADX WARNING: type inference failed for: r12v21 */
    /* JADX WARNING: type inference failed for: r12v22 */
    /* JADX WARNING: type inference failed for: r12v23 */
    /* JADX WARNING: type inference failed for: r12v24 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01de, code lost:
        if (r0.size() != 1) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01e1, code lost:
        r0 = r7.n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e3, code lost:
        if (r0 == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01e5, code lost:
        if (r0 != null) goto L_0x01ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e7, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ea, code lost:
        b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ee, code lost:
        if (r1 != false) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01f0, code lost:
        r0 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01f2, code lost:
        if (r0 == null) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f4, code lost:
        r0.g();
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01f9, code lost:
        b(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01fc, code lost:
        r0 = r7.af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01fe, code lost:
        if (r0 == null) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0200, code lost:
        r0.setEnabled(true, r7);
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0208, code lost:
        a(true);
        r7.at = true;
        r0 = r7.ai;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x020f, code lost:
        if (r0 == null) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0211, code lost:
        r0.dismissAllowingStateLoss();
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0216, code lost:
        if (r1 == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0218, code lost:
        F();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x021c, code lost:
        C();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x021f, code lost:
        l();
        r7.aj = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x022a, code lost:
        if (r0.equals("search_browse_plan_prefill") != false) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02a3, code lost:
        if (r0.equals("search_browse_plan") != false) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02a5, code lost:
        r2 = r1 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02a7, code lost:
        if (r2 == false) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02a9, code lost:
        r7.az = false;
        w();
        r3 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02b2, code lost:
        if (r3 == null) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02b4, code lost:
        r3 = r3.getInputText();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02b8, code lost:
        if (r3 != null) goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02ba, code lost:
        r3 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02bb, code lost:
        r5 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r1;
        r13 = r5.getProductList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02c2, code lost:
        if (r13 == null) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02ca, code lost:
        if (net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r13) != true) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02ce, code lost:
        if ((r6 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) != false) goto L_0x02d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02d0, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02d1, code lost:
        r6 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02d3, code lost:
        if (r6 == null) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02d9, code lost:
        if (r6.getProductId() == null) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02db, code lost:
        r13 = new java.lang.StringBuilder();
        r13.append(r6.getProductId());
        r13.append('-');
        r6 = r7.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02ee, code lost:
        if (r6 == null) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02f0, code lost:
        r6 = r6.z;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02f4, code lost:
        if (r6 == null) goto L_0x02fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02f6, code lost:
        r6 = (java.lang.String) r6.getValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02fd, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02fe, code lost:
        r13.append(r6);
        r6 = r13.toString();
        r13 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0308, code lost:
        r6 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0310, code lost:
        if (r6.length() <= 0) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0312, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0314, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0315, code lost:
        if (r13 == false) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0317, code lost:
        r13 = r7.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0319, code lost:
        if (r13 == null) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x031b, code lost:
        r13 = r13.U;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x031d, code lost:
        if (r13 == null) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x031f, code lost:
        r13 = r13.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0326, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0327, code lost:
        if (r13 != null) goto L_0x032f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0329, code lost:
        r13 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x032f, code lost:
        r13 = r7.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0331, code lost:
        if (r13 == null) goto L_0x033e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0333, code lost:
        r13 = r13.U;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0335, code lost:
        if (r13 == null) goto L_0x033e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0337, code lost:
        r13 = r13.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x033e, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x033f, code lost:
        if (r13 == null) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0345, code lost:
        if (r13.containsKey(r3) != false) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0347, code lost:
        if (r2 != false) goto L_0x034a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0349, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x034a, code lost:
        r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x034c, code lost:
        if (r1 == null) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x034e, code lost:
        r13.put(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0351, code lost:
        r1 = r7.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0353, code lost:
        if (r1 == null) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0355, code lost:
        r1 = r1.U;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0357, code lost:
        if (r1 == null) goto L_0x035c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0359, code lost:
        r1.put(r6, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x035c, code lost:
        r1 = r5.getProductList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0360, code lost:
        if (r1 == null) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0362, code lost:
        r2 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0375, code lost:
        if (r1.hasNext() == false) goto L_0x039d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0377, code lost:
        r5 = r1.next();
        r12 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r5;
        kotlin.g.b.k.a((java.lang.Object) r12, "it");
        r6 = r12.getPrice();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0385, code lost:
        if (r6 == null) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0387, code lost:
        r6 = java.lang.String.valueOf((int) r6.doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0390, code lost:
        if (r6 != null) goto L_0x0393;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0392, code lost:
        r6 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0397, code lost:
        if (kotlin.m.p.a(r3, r6, true) == false) goto L_0x036f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0399, code lost:
        r2.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x039d, code lost:
        r1 = new java.util.HashSet();
        r3 = new java.util.ArrayList();
        r2 = ((java.util.List) r2).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x03b3, code lost:
        if (r2.hasNext() == false) goto L_0x03d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03b5, code lost:
        r5 = r2.next();
        r12 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r5;
        kotlin.g.b.k.a((java.lang.Object) r12, "it");
        r12 = r12.getProductType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03c3, code lost:
        if (r12 != null) goto L_0x03c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x03c5, code lost:
        r12 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x03ca, code lost:
        if (r1.add(r12) == false) goto L_0x03af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03cc, code lost:
        r3.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x03d0, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x03d3, code lost:
        if (r12 == 0) goto L_0x048e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x03dd, code lost:
        if ((!r12.isEmpty()) == false) goto L_0x048e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x03df, code lost:
        r1 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, net.one97.paytm.recharge.widgets.model.ACTION_TYPE.SEARCH_BROWSE_PLAN_SUCCESSFUL);
        r1 = r7.B;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x03e8, code lost:
        if (r1 == null) goto L_0x0462;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x03ea, code lost:
        if (r1 == null) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x03f0, code lost:
        if (r1.size() != 1) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x03f8, code lost:
        if (r12.size() != 1) goto L_0x0441;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x03fa, code lost:
        r1 = r12.get(0);
        kotlin.g.b.k.a(r1, "exaxtSearchResult[0]");
        r1 = b((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0409, code lost:
        if (r1 == null) goto L_0x0441;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0412, code lost:
        if ((!r1.isEmpty()) != true) goto L_0x0441;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0414, code lost:
        r7.E = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x041a, code lost:
        if (kotlin.m.p.a("search_browse_plan_prefill", r0, true) == false) goto L_0x041f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x041c, code lost:
        r7.aB = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0423, code lost:
        if (kotlin.m.p.a("search_browse_plan", r0, true) == false) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0425, code lost:
        r7.aA = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0427, code lost:
        r0 = r7.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0429, code lost:
        if (r0 == null) goto L_0x0436;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x042b, code lost:
        r0.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r12.get(0));
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0436, code lost:
        r0 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0438, code lost:
        if (r0 == null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x043a, code lost:
        r0.clearFocus();
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0445, code lost:
        if (kotlin.m.p.a("search_browse_plan", r0, true) != false) goto L_0x0453;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x044b, code lost:
        if (kotlin.m.p.a("search_browse_plan_prefill", r0, true) == false) goto L_0x044e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x044e, code lost:
        G();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0453, code lost:
        r7.C = r12;
        r7.D = true;
        r0 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0459, code lost:
        if (r0 == null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x045b, code lost:
        r0.g();
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0462, code lost:
        r7.E = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0468, code lost:
        if (kotlin.m.p.a("search_browse_plan_prefill", r0, true) == false) goto L_0x046d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x046a, code lost:
        r7.aB = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0471, code lost:
        if (kotlin.m.p.a("search_browse_plan", r0, true) == false) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0473, code lost:
        r7.aA = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0475, code lost:
        r0 = r7.f63600h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0477, code lost:
        if (r0 == null) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0479, code lost:
        r0.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r12.get(0));
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x0484, code lost:
        r0 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0486, code lost:
        if (r0 == null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0488, code lost:
        r0.clearFocus();
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x048e, code lost:
        r1 = r7.B;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0490, code lost:
        if (r1 == null) goto L_0x04c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0492, code lost:
        if (r1 == null) goto L_0x049b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0498, code lost:
        if (r1.size() != 1) goto L_0x049b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x049b, code lost:
        r1 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x049d, code lost:
        if (r1 == null) goto L_0x04a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x049f, code lost:
        r1.g();
        r1 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x04a4, code lost:
        b(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x04ab, code lost:
        if (kotlin.m.p.a("search_browse_plan", r0, true) != false) goto L_0x04b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x04b1, code lost:
        if (kotlin.m.p.a("search_browse_plan_prefill", r0, true) == false) goto L_0x04bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x04b5, code lost:
        if (r7.ay != false) goto L_0x04bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x04b7, code lost:
        r7.C = r12;
        r7.D = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x04bc, code lost:
        G();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x04c0, code lost:
        r0 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x04c2, code lost:
        if (r0 == null) goto L_0x04c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x04c4, code lost:
        r0.g();
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x04c9, code lost:
        b(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x04ce, code lost:
        if (r7.av != false) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x04d0, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x04d3, code lost:
        r7.ay = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (r0.equals("search.last.recharge.plan") != false) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b4, code lost:
        if (r0.equals("validate.product.selection") != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bb, code lost:
        if (r0.equals("amount_verify_call") != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
        if (r0.equals("validate.last.recharge.plan") != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c6, code lost:
        if ((r1 instanceof net.one97.paytm.common.entity.CJRRechargeCart) == false) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c8, code lost:
        r2 = net.one97.paytm.recharge.common.utils.az.f61525a;
        r1 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) null, (net.one97.paytm.common.entity.CJRRechargeCart) r1, true, 5);
        r2 = r1.getBoolean("extra.has.error");
        r15 = r1.getString("extra.error.msg");
        r10 = r1.getString("extra.error.title");
        r11 = r1.getString("extra.error.action.btn.label");
        r12 = r1.getString("extra.error.action.btn");
        r13 = r1.getBoolean("extra.show.error.info.dialog");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f9, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) "amount_verify_call") == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fd, code lost:
        if (r7.aj == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ff, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0101, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0102, code lost:
        if (r2 == false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0104, code lost:
        if (r1 == false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0108, code lost:
        if (r7.E != false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010c, code lost:
        if (r7.R == false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0112, code lost:
        if (getContext() == null) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0114, code lost:
        r0 = net.one97.paytm.recharge.common.utils.az.f61525a;
        net.one97.paytm.recharge.common.utils.az.a(getContext(), net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED, net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CTA_CONTACT, (java.lang.String) null, r15, 8);
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0127, code lost:
        if (r13 == false) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0129, code lost:
        a(r10, r15, r11, net.one97.paytm.recharge.common.utils.ba.b(r12), r13, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0139, code lost:
        r1 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013b, code lost:
        if (r1 == null) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013d, code lost:
        r1.b(r15);
        r1 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0144, code lost:
        if ((r6 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014a, code lost:
        if (getContext() == null) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014c, code lost:
        r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6;
        r1.setErrorMsg(r15);
        r1.setErrorType(net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR);
        r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE;
        r3 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015d, code lost:
        if (r3 != null) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015f, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0162, code lost:
        kotlin.g.b.k.a((java.lang.Object) r3, "context!!");
        r2.sendEventToPaytmAnalytics(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x016a, code lost:
        r7.M = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0170, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "validate.product.selection", (java.lang.Object) r0) == false) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0174, code lost:
        if (r7.av != false) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0178, code lost:
        if (r7.as != false) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017a, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017d, code lost:
        r0 = r7.af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017f, code lost:
        if (r0 == null) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0181, code lost:
        r0.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0184, code lost:
        a(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0187, code lost:
        r7.at = false;
        r0 = r7.ai;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x018b, code lost:
        if (r0 == null) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x018d, code lost:
        r0.dismissAllowingStateLoss();
        r0 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0198, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) "amount_verify_call") == false) goto L_0x01a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x019a, code lost:
        r2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, net.one97.paytm.recharge.widgets.model.ACTION_TYPE.AMOUNT_VERIFIED_VIA_BACKEND);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a6, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) "validate.product.selection") == false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a8, code lost:
        r2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PRODUCT_TYPE_VERIFIED_SUCCESSFULLY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01b3, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "validate.last.recharge.plan", (java.lang.Object) r0) == false) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b5, code lost:
        r7.az = true;
        r0 = r7.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01b9, code lost:
        if (r0 == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01bb, code lost:
        r2 = getString(net.one97.paytm.recharge.R.string.v3_checking_last_recharge_plan_failed_label);
        kotlin.g.b.k.a((java.lang.Object) r2, "getString(R.string.v3_ch…charge_plan_failed_label)");
        r0.c(r2, getString(net.one97.paytm.recharge.R.string.v3_action_check_status), r7.aF);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01d2, code lost:
        r7.az = false;
        r0 = r7.B;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01d6, code lost:
        if (r0 == null) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d8, code lost:
        if (r0 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r18, com.paytm.network.model.IJRPaytmDataModel r19, java.lang.Object r20) {
        /*
            r17 = this;
            r7 = r17
            r0 = r18
            r1 = r19
            r6 = r20
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            if (r2 == 0) goto L_0x04d8
            boolean r2 = r17.isAdded()
            if (r2 != 0) goto L_0x0016
            goto L_0x04d8
        L_0x0016:
            r8 = 0
            r7.D = r8
            r17.l()
            r9 = 1
            if (r0 != 0) goto L_0x0021
            goto L_0x04d5
        L_0x0021:
            int r2 = r18.hashCode()
            java.lang.String r3 = "validate.last.recharge.plan"
            java.lang.String r4 = "validate.product.selection"
            java.lang.String r5 = "amount_verify_call"
            java.lang.String r10 = "search_browse_plan_prefill"
            java.lang.String r11 = "search_browse_plan"
            r12 = 0
            switch(r2) {
                case -2042516569: goto L_0x029f;
                case -2013158012: goto L_0x022e;
                case -1650697714: goto L_0x0226;
                case -639358832: goto L_0x00be;
                case 982579453: goto L_0x00b7;
                case 1302090869: goto L_0x00b0;
                case 1501798078: goto L_0x00a6;
                case 1578457049: goto L_0x0037;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x04d5
        L_0x0037:
            java.lang.String r2 = "remove_insurance_verify"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x04d5
            boolean r0 = r1 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r0 == 0) goto L_0x04d5
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.INSURANCE_REMOVED
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            int r0 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r0 = r7.b((int) r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            if (r0 == 0) goto L_0x0057
            r0.setChecked(r8)
        L_0x0057:
            int r0 = net.one97.paytm.recharge.R.id.insurance_title
            android.view.View r0 = r7.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0064
            r0.setSelected(r8)
        L_0x0064:
            int r0 = net.one97.paytm.recharge.R.id.insurance_subtitle
            android.view.View r0 = r7.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0071
            r0.setSelected(r8)
        L_0x0071:
            r0 = r1
            net.one97.paytm.common.entity.CJRRechargeCart r0 = (net.one97.paytm.common.entity.CJRRechargeCart) r0
            r7.f63788f = r0
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r7.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x04d5
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r7.f63788f
            if (r1 == 0) goto L_0x0093
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r1.getCart()
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = r1.getFinalPrice()
            if (r1 != 0) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r12 = r1
            goto L_0x009b
        L_0x0093:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r7.o
            if (r1 == 0) goto L_0x009b
            java.lang.String r12 = r1.getFormattedString()
        L_0x009b:
            java.lang.String r1 = r7.a((java.lang.String) r12)
            r0.setProceedBtnText(r1)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x04d5
        L_0x00a6:
            java.lang.String r2 = "search.last.recharge.plan"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x04d5
            goto L_0x02a5
        L_0x00b0:
            boolean r2 = r0.equals(r4)
            if (r2 == 0) goto L_0x04d5
            goto L_0x00c4
        L_0x00b7:
            boolean r2 = r0.equals(r5)
            if (r2 == 0) goto L_0x04d5
            goto L_0x00c4
        L_0x00be:
            boolean r2 = r0.equals(r3)
            if (r2 == 0) goto L_0x04d5
        L_0x00c4:
            boolean r2 = r1 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r2 == 0) goto L_0x04d5
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.common.entity.CJRRechargeCart r1 = (net.one97.paytm.common.entity.CJRRechargeCart) r1
            r2 = 5
            android.os.Bundle r1 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r12, (net.one97.paytm.common.entity.CJRRechargeCart) r1, (boolean) r9, (int) r2)
            java.lang.String r2 = "extra.has.error"
            boolean r2 = r1.getBoolean(r2)
            java.lang.String r10 = "extra.error.msg"
            java.lang.String r15 = r1.getString(r10)
            java.lang.String r10 = "extra.error.title"
            java.lang.String r10 = r1.getString(r10)
            java.lang.String r11 = "extra.error.action.btn.label"
            java.lang.String r11 = r1.getString(r11)
            java.lang.String r12 = "extra.error.action.btn"
            java.lang.String r12 = r1.getString(r12)
            java.lang.String r13 = "extra.show.error.info.dialog"
            boolean r13 = r1.getBoolean(r13)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x0101
            boolean r1 = r7.aj
            if (r1 == 0) goto L_0x0101
            r1 = 1
            goto L_0x0102
        L_0x0101:
            r1 = 0
        L_0x0102:
            if (r2 == 0) goto L_0x0194
            if (r1 == 0) goto L_0x0127
            boolean r1 = r7.E
            if (r1 != 0) goto L_0x010e
            boolean r1 = r7.R
            if (r1 == 0) goto L_0x0127
        L_0x010e:
            android.content.Context r0 = r17.getContext()
            if (r0 == 0) goto L_0x0187
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r11 = r17.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r12 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r13 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CTA_CONTACT
            r14 = 0
            r16 = 8
            net.one97.paytm.recharge.common.utils.az.a(r11, r12, r13, r14, r15, r16)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0187
        L_0x0127:
            if (r13 == 0) goto L_0x0139
            net.one97.paytm.recharge.model.v4.ErrorAction r4 = net.one97.paytm.recharge.common.utils.ba.b((java.lang.String) r12)
            r0 = r17
            r1 = r10
            r2 = r15
            r3 = r11
            r5 = r13
            r6 = r20
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (net.one97.paytm.recharge.model.v4.ErrorAction) r4, (boolean) r5, (java.lang.Object) r6)
            goto L_0x017d
        L_0x0139:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r7.o
            if (r1 == 0) goto L_0x0142
            r1.b((java.lang.String) r15)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x0142:
            boolean r1 = r6 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x016a
            android.content.Context r1 = r17.getContext()
            if (r1 == 0) goto L_0x016a
            r1 = r6
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            r1.setErrorMsg(r15)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INLINE_ERROR
            r1.setErrorType(r2)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            android.content.Context r3 = r17.getContext()
            if (r3 != 0) goto L_0x0162
            kotlin.g.b.k.a()
        L_0x0162:
            java.lang.String r5 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            r2.sendEventToPaytmAnalytics(r1, r3)
        L_0x016a:
            r7.M = r9
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x017d
            boolean r0 = r7.av
            if (r0 != 0) goto L_0x017d
            boolean r0 = r7.as
            if (r0 != 0) goto L_0x017d
            r17.b()
        L_0x017d:
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r0 = r7.af
            if (r0 == 0) goto L_0x0184
            r0.setEnabled(r8)
        L_0x0184:
            r7.a((boolean) r8)
        L_0x0187:
            r7.at = r8
            net.one97.paytm.recharge.mobile_v3.a.c r0 = r7.ai
            if (r0 == 0) goto L_0x021f
            r0.dismissAllowingStateLoss()
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x021f
        L_0x0194:
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x01a2
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.AMOUNT_VERIFIED_VIA_BACKEND
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2)
            goto L_0x01af
        L_0x01a2:
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x01af
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PRODUCT_TYPE_VERIFIED_SUCCESSFULLY
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2)
        L_0x01af:
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x01d2
            r7.az = r9
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r7.o
            if (r0 == 0) goto L_0x01fc
            int r2 = net.one97.paytm.recharge.R.string.v3_checking_last_recharge_plan_failed_label
            java.lang.String r2 = r7.getString(r2)
            java.lang.String r3 = "getString(R.string.v3_ch…charge_plan_failed_label)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r3 = net.one97.paytm.recharge.R.string.v3_action_check_status
            java.lang.String r3 = r7.getString(r3)
            android.view.View$OnClickListener r4 = r7.aF
            r0.c(r2, r3, r4)
            goto L_0x01fc
        L_0x01d2:
            r7.az = r8
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r0 = r7.B
            if (r0 == 0) goto L_0x01ee
            if (r0 == 0) goto L_0x01e1
            int r0 = r0.size()
            if (r0 != r9) goto L_0x01e1
            goto L_0x01ee
        L_0x01e1:
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = r7.n
            if (r0 == 0) goto L_0x01fc
            if (r0 != 0) goto L_0x01ea
            kotlin.g.b.k.a()
        L_0x01ea:
            r7.b((net.one97.paytm.recharge.model.v4.CJRProductsItem) r0)
            goto L_0x01fc
        L_0x01ee:
            if (r1 != 0) goto L_0x01fc
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r7.o
            if (r0 == 0) goto L_0x01f9
            r0.g()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x01f9:
            r7.b((boolean) r8)
        L_0x01fc:
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r0 = r7.af
            if (r0 == 0) goto L_0x0208
            r2 = r7
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setEnabled(r9, r2)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0208:
            r7.a((boolean) r9)
            r7.at = r9
            net.one97.paytm.recharge.mobile_v3.a.c r0 = r7.ai
            if (r0 == 0) goto L_0x0216
            r0.dismissAllowingStateLoss()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0216:
            if (r1 == 0) goto L_0x021c
            r17.F()
            goto L_0x021f
        L_0x021c:
            r17.C()
        L_0x021f:
            r17.l()
            r7.aj = r8
            goto L_0x04d5
        L_0x0226:
            boolean r2 = r0.equals(r10)
            if (r2 == 0) goto L_0x04d5
            goto L_0x02a5
        L_0x022e:
            java.lang.String r2 = "remove_promo_verify"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x04d5
            boolean r0 = r1 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r0 == 0) goto L_0x04d5
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PROMO_REMOVED
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            r7.v = r12
            net.one97.paytm.recharge.common.utils.o r0 = r7.u
            if (r0 == 0) goto L_0x024b
            r0.f61685b = r12
            kotlin.x r0 = kotlin.x.f47997a
        L_0x024b:
            net.one97.paytm.recharge.common.utils.o r0 = r7.u
            if (r0 == 0) goto L_0x0253
            r0.f61684a = r8
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0253:
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r0 = r7.af
            if (r0 == 0) goto L_0x025f
            r2 = r7
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setEnabled(r9, r2)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x025f:
            r17.g()
            r0 = r1
            net.one97.paytm.common.entity.CJRRechargeCart r0 = (net.one97.paytm.common.entity.CJRRechargeCart) r0
            r7.f63788f = r0
            net.one97.paytm.recharge.common.utils.o r0 = r7.u
            if (r0 == 0) goto L_0x026f
            r0.f61685b = r12
            kotlin.x r0 = kotlin.x.f47997a
        L_0x026f:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r7.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x04d5
            net.one97.paytm.common.entity.CJRRechargeCart r1 = r7.f63788f
            if (r1 == 0) goto L_0x028c
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r1.getCart()
            if (r1 == 0) goto L_0x028c
            java.lang.String r1 = r1.getFinalPrice()
            if (r1 != 0) goto L_0x028a
            goto L_0x028c
        L_0x028a:
            r12 = r1
            goto L_0x0294
        L_0x028c:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r7.o
            if (r1 == 0) goto L_0x0294
            java.lang.String r12 = r1.getFormattedString()
        L_0x0294:
            java.lang.String r1 = r7.a((java.lang.String) r12)
            r0.setProceedBtnText(r1)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x04d5
        L_0x029f:
            boolean r2 = r0.equals(r11)
            if (r2 == 0) goto L_0x04d5
        L_0x02a5:
            boolean r2 = r1 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8
            if (r2 == 0) goto L_0x04d5
            r7.az = r8
            r17.w()
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r3 = r7.o
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x02ba
            java.lang.String r3 = r3.getInputText()
            if (r3 != 0) goto L_0x02bb
        L_0x02ba:
            r3 = r4
        L_0x02bb:
            r5 = r1
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8 r5 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r5
            java.util.List r13 = r5.getProductList()
            if (r13 == 0) goto L_0x035c
            java.util.Collection r13 = (java.util.Collection) r13
            boolean r13 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotEmpty(r13)
            if (r13 != r9) goto L_0x035c
            boolean r13 = r6 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r13 != 0) goto L_0x02d1
            r6 = r12
        L_0x02d1:
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6
            if (r6 == 0) goto L_0x0308
            java.lang.String r13 = r6.getProductId()
            if (r13 == 0) goto L_0x0308
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r6 = r6.getProductId()
            r13.append(r6)
            r6 = 45
            r13.append(r6)
            net.one97.paytm.recharge.mobile.d.a r6 = r7.f63600h
            if (r6 == 0) goto L_0x02fd
            androidx.lifecycle.y<java.lang.String> r6 = r6.z
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            if (r6 == 0) goto L_0x02fd
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x02fe
        L_0x02fd:
            r6 = r12
        L_0x02fe:
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            kotlin.x r13 = kotlin.x.f47997a
            goto L_0x0309
        L_0x0308:
            r6 = r4
        L_0x0309:
            r13 = r6
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            int r13 = r13.length()
            if (r13 <= 0) goto L_0x0314
            r13 = 1
            goto L_0x0315
        L_0x0314:
            r13 = 0
        L_0x0315:
            if (r13 == 0) goto L_0x035c
            net.one97.paytm.recharge.mobile.d.a r13 = r7.f63600h
            if (r13 == 0) goto L_0x0326
            androidx.a.e<java.lang.Object, java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8>> r13 = r13.U
            if (r13 == 0) goto L_0x0326
            java.lang.Object r13 = r13.get(r6)
            java.util.HashMap r13 = (java.util.HashMap) r13
            goto L_0x0327
        L_0x0326:
            r13 = r12
        L_0x0327:
            if (r13 != 0) goto L_0x032f
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            goto L_0x033f
        L_0x032f:
            net.one97.paytm.recharge.mobile.d.a r13 = r7.f63600h
            if (r13 == 0) goto L_0x033e
            androidx.a.e<java.lang.Object, java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8>> r13 = r13.U
            if (r13 == 0) goto L_0x033e
            java.lang.Object r13 = r13.get(r6)
            java.util.HashMap r13 = (java.util.HashMap) r13
            goto L_0x033f
        L_0x033e:
            r13 = r12
        L_0x033f:
            if (r13 == 0) goto L_0x035c
            boolean r14 = r13.containsKey(r3)
            if (r14 != 0) goto L_0x035c
            if (r2 != 0) goto L_0x034a
            r1 = r12
        L_0x034a:
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8 r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8) r1
            if (r1 == 0) goto L_0x0351
            r13.put(r3, r1)
        L_0x0351:
            net.one97.paytm.recharge.mobile.d.a r1 = r7.f63600h
            if (r1 == 0) goto L_0x035c
            androidx.a.e<java.lang.Object, java.util.HashMap<java.lang.String, net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanSearchModelV8>> r1 = r1.U
            if (r1 == 0) goto L_0x035c
            r1.put(r6, r13)
        L_0x035c:
            java.util.List r1 = r5.getProductList()
            if (r1 == 0) goto L_0x03d3
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x036f:
            boolean r5 = r1.hasNext()
            java.lang.String r6 = "it"
            if (r5 == 0) goto L_0x039d
            java.lang.Object r5 = r1.next()
            r12 = r5
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r12 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            java.lang.Double r6 = r12.getPrice()
            if (r6 == 0) goto L_0x0392
            double r12 = r6.doubleValue()
            int r6 = (int) r12
            java.lang.String r6 = java.lang.String.valueOf(r6)
            if (r6 != 0) goto L_0x0393
        L_0x0392:
            r6 = r4
        L_0x0393:
            boolean r6 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r6, (boolean) r9)
            if (r6 == 0) goto L_0x036f
            r2.add(r5)
            goto L_0x036f
        L_0x039d:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x03af:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x03d0
            java.lang.Object r5 = r2.next()
            r12 = r5
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r12 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            java.lang.String r12 = r12.getProductType()
            if (r12 != 0) goto L_0x03c6
            r12 = r4
        L_0x03c6:
            boolean r12 = r1.add(r12)
            if (r12 == 0) goto L_0x03af
            r3.add(r5)
            goto L_0x03af
        L_0x03d0:
            r12 = r3
            java.util.List r12 = (java.util.List) r12
        L_0x03d3:
            if (r12 == 0) goto L_0x048e
            r1 = r12
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r9
            if (r1 == 0) goto L_0x048e
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.SEARCH_BROWSE_PLAN_SUCCESSFUL
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) null, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1)
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r1 = r7.B
            if (r1 == 0) goto L_0x0462
            if (r1 == 0) goto L_0x03f4
            int r1 = r1.size()
            if (r1 != r9) goto L_0x03f4
            goto L_0x0462
        L_0x03f4:
            int r1 = r12.size()
            if (r1 != r9) goto L_0x0441
            java.lang.Object r1 = r12.get(r8)
            java.lang.String r2 = "exaxtSearchResult[0]"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1
            java.util.List r1 = r7.b((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1)
            if (r1 == 0) goto L_0x0441
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r9
            if (r1 != r9) goto L_0x0441
            r7.E = r8
            boolean r1 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r9)
            if (r1 == 0) goto L_0x041f
            r7.aB = r9
            goto L_0x0427
        L_0x041f:
            boolean r0 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x0427
            r7.aA = r9
        L_0x0427:
            net.one97.paytm.recharge.mobile.d.a r0 = r7.f63600h
            if (r0 == 0) goto L_0x0436
            java.lang.Object r1 = r12.get(r8)
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1
            r0.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0436:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r7.o
            if (r0 == 0) goto L_0x04d3
            r0.clearFocus()
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x04d3
        L_0x0441:
            boolean r1 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r0, (boolean) r9)
            if (r1 != 0) goto L_0x0453
            boolean r0 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x044e
            goto L_0x0453
        L_0x044e:
            r17.G()
            goto L_0x04d3
        L_0x0453:
            r7.C = r12
            r7.D = r9
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r7.o
            if (r0 == 0) goto L_0x04d3
            r0.g()
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x04d3
        L_0x0462:
            r7.E = r8
            boolean r1 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r9)
            if (r1 == 0) goto L_0x046d
            r7.aB = r9
            goto L_0x0475
        L_0x046d:
            boolean r0 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x0475
            r7.aA = r9
        L_0x0475:
            net.one97.paytm.recharge.mobile.d.a r0 = r7.f63600h
            if (r0 == 0) goto L_0x0484
            java.lang.Object r1 = r12.get(r8)
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r1 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1
            r0.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1)
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0484:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r7.o
            if (r0 == 0) goto L_0x04d3
            r0.clearFocus()
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x04d3
        L_0x048e:
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r1 = r7.B
            if (r1 == 0) goto L_0x04c0
            if (r1 == 0) goto L_0x049b
            int r1 = r1.size()
            if (r1 != r9) goto L_0x049b
            goto L_0x04c0
        L_0x049b:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r7.o
            if (r1 == 0) goto L_0x04a4
            r1.g()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x04a4:
            r7.b((boolean) r8)
            boolean r1 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r0, (boolean) r9)
            if (r1 != 0) goto L_0x04b3
            boolean r0 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r0, (boolean) r9)
            if (r0 == 0) goto L_0x04bc
        L_0x04b3:
            boolean r0 = r7.ay
            if (r0 != 0) goto L_0x04bc
            r7.C = r12
            r7.D = r9
            goto L_0x04d3
        L_0x04bc:
            r17.G()
            goto L_0x04d3
        L_0x04c0:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r0 = r7.o
            if (r0 == 0) goto L_0x04c9
            r0.g()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x04c9:
            r7.b((boolean) r8)
            boolean r0 = r7.av
            if (r0 != 0) goto L_0x04d3
            r17.b()
        L_0x04d3:
            r7.ay = r8
        L_0x04d5:
            r7.d((boolean) r9)
        L_0x04d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        if (r14.equals("remove_insurance_verify") != false) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r14.equals("search.last.recharge.plan") != false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
        if (r14.equals("validate.product.selection") != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r14.equals("amount_verify_call") != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (kotlin.m.p.a("validate.product.selection", r14, true) == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        if (net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE.isAuthError(r5) == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        r0.S.post(new net.one97.paytm.recharge.mobile_v3.b.d.g(r13));
        net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.handleError$default(net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE, r14, getActivity(), r0, r17, false, 1021, r18, 16, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        r0.S.post(new net.one97.paytm.recharge.mobile_v3.b.d.h(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0109, code lost:
        if (r14.equals("search_browse_plan_prefill") != false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0112, code lost:
        if (r14.equals("remove_promo_verify") != false) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0114, code lost:
        l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011d, code lost:
        if (r14.equals("search_browse_plan") != false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0127, code lost:
        if (com.paytm.utility.b.c(getContext()) == false) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0129, code lost:
        w();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012c, code lost:
        r4 = r0.B;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012e, code lost:
        if (r4 == null) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0130, code lost:
        if (r4 == null) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0136, code lost:
        if (r4.size() != 1) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0139, code lost:
        r4 = r0.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x013b, code lost:
        if (r4 == null) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x013d, code lost:
        r4.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0140, code lost:
        b(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0147, code lost:
        if (kotlin.m.p.a("search_browse_plan", r14, true) != false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x014d, code lost:
        if (kotlin.m.p.a("search_browse_plan_prefill", r14, true) == false) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
        G();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0155, code lost:
        r0.C = null;
        r0.D = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x015e, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "search.last.recharge.plan", (java.lang.Object) r14) == false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0160, code lost:
        r0.az = true;
        r4 = r0.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0164, code lost:
        if (r4 == null) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0166, code lost:
        r5 = getString(net.one97.paytm.recharge.R.string.v3_checking_last_recharge_plan_failed_label);
        kotlin.g.b.k.a((java.lang.Object) r5, "getString(R.string.v3_ch…charge_plan_failed_label)");
        r4.c(r5, getString(net.one97.paytm.recharge.R.string.v3_action_check_status), r0.aF);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0182, code lost:
        if (com.paytm.utility.b.c(getContext()) != false) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0186, code lost:
        if ((r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0188, code lost:
        r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PLAN_AMOUNT_SEARCH_AGAIN;
        r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion;
        r6 = ((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8).getFlowName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0193, code lost:
        if (r6 == null) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0195, code lost:
        r6 = r6.getActionType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x019a, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01a1, code lost:
        if (r4 != r5.getActionType(r6, net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PLAN_AMOUNT_SEARCH)) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a3, code lost:
        j();
        super.a(r14, (com.paytm.network.model.NetworkCustomError) new net.one97.paytm.recharge.common.utils.as(false, 1, (kotlin.g.b.g) null), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b1, code lost:
        r0.az = false;
        r2 = r0.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b5, code lost:
        if (r2 == null) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b7, code lost:
        r2.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01ba, code lost:
        b(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01bf, code lost:
        if (r0.av != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01c1, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c6, code lost:
        if ((r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c8, code lost:
        r1 = net.one97.paytm.recharge.common.utils.az.f61525a;
        net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r14, int r15, com.paytm.network.model.IJRPaytmDataModel r16, com.paytm.network.model.NetworkCustomError r17, java.lang.Object r18) {
        /*
            r13 = this;
            r0 = r13
            r2 = r14
            r5 = r17
            r8 = r18
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            if (r1 == 0) goto L_0x01d7
            boolean r1 = r13.isAdded()
            if (r1 != 0) goto L_0x0014
            goto L_0x01d7
        L_0x0014:
            boolean r1 = r5 instanceof net.one97.paytm.recharge.common.utils.au
            r3 = 0
            if (r1 == 0) goto L_0x0049
            boolean r1 = r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x0021
            r1 = r8
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            goto L_0x0027
        L_0x0021:
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
        L_0x0027:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x0036
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.RECREATE
            java.lang.String r3 = r3.name()
            r2.setActionType(r3)
        L_0x0036:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x0045
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DISTORT
            java.lang.String r3 = r3.name()
            r2.setErrorType(r3)
        L_0x0045:
            r13.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1)
            return
        L_0x0049:
            r1 = 0
            r0.D = r1
            r11 = 1
            if (r2 != 0) goto L_0x0051
            goto L_0x01d1
        L_0x0051:
            int r4 = r14.hashCode()
            java.lang.String r6 = "getString(R.string.v3_ch…charge_plan_failed_label)"
            java.lang.String r7 = "search.last.recharge.plan"
            java.lang.String r9 = "validate.product.selection"
            java.lang.String r10 = "search_browse_plan_prefill"
            java.lang.String r12 = "search_browse_plan"
            switch(r4) {
                case -2042516569: goto L_0x0119;
                case -2013158012: goto L_0x010c;
                case -1650697714: goto L_0x0105;
                case -639358832: goto L_0x00c9;
                case 982579453: goto L_0x007e;
                case 1302090869: goto L_0x0077;
                case 1501798078: goto L_0x006f;
                case 1578457049: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x01d1
        L_0x0065:
            java.lang.String r1 = "remove_insurance_verify"
            boolean r1 = r14.equals(r1)
            if (r1 == 0) goto L_0x01d1
            goto L_0x0114
        L_0x006f:
            boolean r4 = r14.equals(r7)
            if (r4 == 0) goto L_0x01d1
            goto L_0x011f
        L_0x0077:
            boolean r1 = r14.equals(r9)
            if (r1 == 0) goto L_0x01d1
            goto L_0x0086
        L_0x007e:
            java.lang.String r1 = "amount_verify_call"
            boolean r1 = r14.equals(r1)
            if (r1 == 0) goto L_0x01d1
        L_0x0086:
            boolean r1 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r14, (boolean) r11)
            if (r1 == 0) goto L_0x00bb
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            boolean r1 = r1.isAuthError(r5)
            if (r1 == 0) goto L_0x00bb
            android.os.Handler r1 = r0.S
            net.one97.paytm.recharge.mobile_v3.b.d$g r3 = new net.one97.paytm.recharge.mobile_v3.b.d$g
            r3.<init>(r13)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r1.post(r3)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            androidx.fragment.app.FragmentActivity r3 = r13.getActivity()
            android.app.Activity r3 = (android.app.Activity) r3
            r4 = r0
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            r6 = 0
            r7 = 1021(0x3fd, float:1.431E-42)
            r9 = 16
            r10 = 0
            r2 = r14
            r5 = r17
            r8 = r18
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.handleError$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x01d4
        L_0x00bb:
            android.os.Handler r1 = r0.S
            net.one97.paytm.recharge.mobile_v3.b.d$h r3 = new net.one97.paytm.recharge.mobile_v3.b.d$h
            r3.<init>(r13)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r1.post(r3)
            goto L_0x01d1
        L_0x00c9:
            java.lang.String r3 = "validate.last.recharge.plan"
            boolean r3 = r14.equals(r3)
            if (r3 == 0) goto L_0x01d1
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r2 = r0.B
            if (r2 == 0) goto L_0x00e2
            if (r2 == 0) goto L_0x00df
            int r2 = r2.size()
            if (r2 != r11) goto L_0x00df
            goto L_0x00e2
        L_0x00df:
            r0.az = r1
            goto L_0x00fc
        L_0x00e2:
            r0.az = r11
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r0.o
            if (r1 == 0) goto L_0x00fc
            int r2 = net.one97.paytm.recharge.R.string.v3_checking_last_recharge_plan_failed_label
            java.lang.String r2 = r13.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            int r3 = net.one97.paytm.recharge.R.string.v3_action_check_status
            java.lang.String r3 = r13.getString(r3)
            android.view.View$OnClickListener r4 = r0.aF
            r1.c(r2, r3, r4)
        L_0x00fc:
            net.one97.paytm.recharge.mobile_v3.a.c r1 = r0.ai
            if (r1 == 0) goto L_0x01d4
            r1.dismissAllowingStateLoss()
            goto L_0x01d4
        L_0x0105:
            boolean r4 = r14.equals(r10)
            if (r4 == 0) goto L_0x01d1
            goto L_0x011f
        L_0x010c:
            java.lang.String r1 = "remove_promo_verify"
            boolean r1 = r14.equals(r1)
            if (r1 == 0) goto L_0x01d1
        L_0x0114:
            r13.l()
            goto L_0x01d1
        L_0x0119:
            boolean r4 = r14.equals(r12)
            if (r4 == 0) goto L_0x01d1
        L_0x011f:
            android.content.Context r4 = r13.getContext()
            boolean r4 = com.paytm.utility.b.c((android.content.Context) r4)
            if (r4 == 0) goto L_0x012c
            r13.w()
        L_0x012c:
            java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem> r4 = r0.B
            if (r4 == 0) goto L_0x015a
            if (r4 == 0) goto L_0x0139
            int r4 = r4.size()
            if (r4 != r11) goto L_0x0139
            goto L_0x015a
        L_0x0139:
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r4 = r0.o
            if (r4 == 0) goto L_0x0140
            r4.g()
        L_0x0140:
            r13.b((boolean) r1)
            boolean r1 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r14, (boolean) r11)
            if (r1 != 0) goto L_0x0155
            boolean r1 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r14, (boolean) r11)
            if (r1 == 0) goto L_0x0150
            goto L_0x0155
        L_0x0150:
            r13.G()
            goto L_0x01c4
        L_0x0155:
            r0.C = r3
            r0.D = r11
            goto L_0x01c4
        L_0x015a:
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r14)
            if (r4 == 0) goto L_0x01b1
            r0.az = r11
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r4 = r0.o
            if (r4 == 0) goto L_0x017a
            int r5 = net.one97.paytm.recharge.R.string.v3_checking_last_recharge_plan_failed_label
            java.lang.String r5 = r13.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            int r6 = net.one97.paytm.recharge.R.string.v3_action_check_status
            java.lang.String r6 = r13.getString(r6)
            android.view.View$OnClickListener r7 = r0.aF
            r4.c(r5, r6, r7)
        L_0x017a:
            android.content.Context r4 = r13.getContext()
            boolean r4 = com.paytm.utility.b.c((android.content.Context) r4)
            if (r4 != 0) goto L_0x01bd
            boolean r4 = r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r4 == 0) goto L_0x01bd
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PLAN_AMOUNT_SEARCH_AGAIN
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE$Companion r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion
            r6 = r8
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r6
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r6.getFlowName()
            if (r6 == 0) goto L_0x019a
            java.lang.String r6 = r6.getActionType()
            goto L_0x019b
        L_0x019a:
            r6 = r3
        L_0x019b:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r7 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PLAN_AMOUNT_SEARCH
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r5 = r5.getActionType(r6, r7)
            if (r4 != r5) goto L_0x01bd
            r13.j()
            net.one97.paytm.recharge.common.utils.as r4 = new net.one97.paytm.recharge.common.utils.as
            r4.<init>(r1, r11, r3)
            com.paytm.network.model.NetworkCustomError r4 = (com.paytm.network.model.NetworkCustomError) r4
            super.a((java.lang.String) r14, (com.paytm.network.model.NetworkCustomError) r4, (java.lang.Object) r8)
            goto L_0x01bd
        L_0x01b1:
            r0.az = r1
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r2 = r0.o
            if (r2 == 0) goto L_0x01ba
            r2.g()
        L_0x01ba:
            r13.b((boolean) r1)
        L_0x01bd:
            boolean r1 = r0.av
            if (r1 != 0) goto L_0x01c4
            r13.b()
        L_0x01c4:
            boolean r1 = r8 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r1 == 0) goto L_0x01d4
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            r1 = r8
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1)
            goto L_0x01d4
        L_0x01d1:
            super.a((java.lang.String) r14, (com.paytm.network.model.NetworkCustomError) r5, (java.lang.Object) r8)
        L_0x01d4:
            r13.d((boolean) r11)
        L_0x01d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.a(java.lang.String, int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63816a;

        g(d dVar) {
            this.f63816a = dVar;
        }

        public final void run() {
            this.f63816a.l();
            net.one97.paytm.recharge.mobile_v3.a.c t = this.f63816a.ai;
            if (t != null) {
                t.a();
            }
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63817a;

        h(d dVar) {
            this.f63817a = dVar;
        }

        public final void run() {
            this.f63817a.l();
            net.one97.paytm.recharge.mobile_v3.a.c t = this.f63817a.ai;
            if (t != null) {
                t.dismissAllowingStateLoss();
            }
        }
    }

    static final class ag implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f63800a;

        ag(d dVar) {
            this.f63800a = dVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "v");
            if (!eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                d dVar = this.f63800a;
                kotlin.g.b.k.c(view, "view");
                dVar.p = true;
                if (view instanceof CJRProceedWidgetV8) {
                    ((CJRProceedWidgetV8) view).a();
                }
                dVar.onClick((CJRProceedWidgetV8) dVar.b(R.id.btn_proceed));
            }
        }
    }

    public final void a(CJRSuccessRateAlertMessage cJRSuccessRateAlertMessage) {
        this.q = cJRSuccessRateAlertMessage;
    }

    public void onDestroy() {
        super.onDestroy();
        this.ah = null;
        this.ai = null;
        net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> aVar = this.V;
        if (aVar != null) {
            aVar.a();
        }
        this.V = null;
        io.reactivex.rxjava3.b.c cVar = this.T;
        if (cVar != null) {
            cVar.dispose();
        }
        this.T = null;
        if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && this.Z) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).az_();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    net.one97.paytm.recharge.common.e.y yVar = (net.one97.paytm.recharge.common.e.y) activity2;
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        yVar.b(activity3.getResources().getString(R.string.recharge_tabs_toolbar_title));
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type android.content.Context");
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public void onResume() {
        super.onResume();
        if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && this.Z && this.aa) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).e();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity2).i();
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public final void a(net.one97.paytm.recharge.common.e.ai aiVar) {
        kotlin.g.b.k.c(aiVar, "onSuccess");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.INSURANCE_VERIFY.name());
        }
        a(this, "verify", aiVar, true, false, a2, 8);
    }

    static /* synthetic */ void a(d dVar, String str, net.one97.paytm.recharge.common.e.ai aiVar, boolean z2, boolean z3, Object obj, int i2) {
        dVar.a(str, aiVar, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, obj);
    }

    public final void b(CJRRechargeCart cJRRechargeCart) {
        CJRCart cart;
        String finalPrice;
        Object obj;
        String str;
        String productID;
        kotlin.g.b.k.c(cJRRechargeCart, "rechargeCart");
        az azVar = az.f61525a;
        String str2 = null;
        Bundle a2 = az.a((Context) null, cJRRechargeCart, false, 5);
        boolean z2 = a2.getBoolean("extra.has.error");
        String string = a2.getString("extra.error.msg");
        if (z2) {
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                cJRAmountInputFieldWidgetV3.b(string);
            }
            this.M = true;
            return;
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.INSURANCE_ADDED);
        this.f63788f = cJRRechargeCart;
        CheckBox checkBox = (CheckBox) b(R.id.insurance_checkbox);
        if (checkBox != null) {
            checkBox.setChecked(true);
        }
        TextView textView = (TextView) b(R.id.insurance_title);
        if (textView != null) {
            textView.setSelected(true);
        }
        TextView textView2 = (TextView) b(R.id.insurance_subtitle);
        if (textView2 != null) {
            textView2.setSelected(true);
        }
        Context context = getContext();
        if (context != null) {
            kotlin.g.b.k.a((Object) context, "it");
            net.one97.paytm.recharge.ordersummary.h.d dVar2 = new net.one97.paytm.recharge.ordersummary.h.d(context);
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null || (obj = aVar.e()) == null) {
                obj = "";
            }
            CJRPersonalInsurance cJRPersonalInsurance = this.y;
            if (cJRPersonalInsurance == null || (productID = cJRPersonalInsurance.getProductID()) == null) {
                str = "";
            } else {
                str = productID;
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, obj, "upsell_widget_checked", "", str, (Object) null, (Object) null, (Object) null, 112);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV8 != null) {
            CJRRechargeCart cJRRechargeCart2 = this.f63788f;
            if (cJRRechargeCart2 == null || (cart = cJRRechargeCart2.getCart()) == null || (finalPrice = cart.getFinalPrice()) == null) {
                CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV32 = this.o;
                if (cJRAmountInputFieldWidgetV32 != null) {
                    str2 = cJRAmountInputFieldWidgetV32.getFormattedString();
                }
            } else {
                str2 = finalPrice;
            }
            cJRProceedWidgetV8.setProceedBtnText(a(str2));
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = d.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "FJRMobileAmountFragmentV3::class.java.simpleName");
        aI = simpleName;
    }

    public final void a(String str, CJRRechargeCart cJRRechargeCart, CJRRechargePayment cJRRechargePayment, Object obj) {
        boolean z2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            net.one97.paytm.recharge.common.utils.a aVar = net.one97.paytm.recharge.common.utils.a.f61493a;
            kotlin.g.b.k.a((Object) activity, "it");
            Activity activity2 = activity;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Map<String, Object> q2 = q();
            net.one97.paytm.recharge.common.utils.o oVar = this.u;
            if (oVar != null) {
                z2 = oVar.f61684a;
            } else {
                z2 = false;
            }
            net.one97.paytm.recharge.common.utils.a.a(activity2, str2, cJRRechargeCart, cJRRechargePayment, q2, (Class<?>) null, obj, z2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0204  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r9 = "view"
            kotlin.g.b.k.c(r8, r9)
            net.one97.paytm.recharge.mobile.d.a r9 = r7.f63600h
            r0 = 0
            if (r9 == 0) goto L_0x0033
            net.one97.paytm.recharge.ordersummary.h.d r9 = r9.v
            if (r9 == 0) goto L_0x0033
            android.content.Context r1 = r7.getContext()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "/"
            r2.<init>(r3)
            net.one97.paytm.recharge.mobile.d.a r3 = r7.f63600h
            if (r3 == 0) goto L_0x0023
            java.lang.Object r3 = r3.e()
            goto L_0x0024
        L_0x0023:
            r3 = r0
        L_0x0024:
            r2.append(r3)
            java.lang.String r3 = "/amount"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r9.a((android.content.Context) r1, (java.lang.String) r2)
        L_0x0033:
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a
            android.content.Context r9 = r7.getContext()
            net.one97.paytm.recharge.mobile.d.a r1 = r7.f63600h
            if (r1 == 0) goto L_0x0046
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            if (r1 == 0) goto L_0x0046
            java.lang.String r1 = r1.getCategoryId()
            goto L_0x0047
        L_0x0046:
            r1 = r0
        L_0x0047:
            boolean r9 = net.one97.paytm.recharge.di.helper.c.a(r9, r1)
            if (r9 == 0) goto L_0x0054
            net.one97.paytm.recharge.mobile.d.a r9 = r7.f63600h
            if (r9 == 0) goto L_0x0054
            r9.r()
        L_0x0054:
            int r9 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r9 = r7.b((int) r9)
            androidx.appcompat.widget.Toolbar r9 = (androidx.appcompat.widget.Toolbar) r9
            r7.a((androidx.appcompat.widget.Toolbar) r9)
            int r9 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r9 = r7.b((int) r9)
            androidx.appcompat.widget.Toolbar r9 = (androidx.appcompat.widget.Toolbar) r9
            java.lang.String r1 = "toolbar"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            java.lang.String r1 = ""
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r9.setTitle((java.lang.CharSequence) r1)
            int r9 = net.one97.paytm.recharge.R.id.collapsing_toolbar
            android.view.View r9 = r8.findViewById(r9)
            com.google.android.material.appbar.CollapsingToolbarLayout r9 = (com.google.android.material.appbar.CollapsingToolbarLayout) r9
            r7.an = r9
            int r9 = net.one97.paytm.recharge.R.id.app_bar_layout
            android.view.View r9 = r8.findViewById(r9)
            boolean r1 = r9 instanceof com.google.android.material.appbar.AppBarLayout
            if (r1 != 0) goto L_0x0089
            r9 = r0
        L_0x0089:
            com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
            r7.ao = r9
            com.google.android.material.appbar.AppBarLayout r9 = r7.ao
            if (r9 == 0) goto L_0x009b
            net.one97.paytm.recharge.mobile_v3.b.d$u r1 = new net.one97.paytm.recharge.mobile_v3.b.d$u
            r1.<init>(r7)
            com.google.android.material.appbar.AppBarLayout$b r1 = (com.google.android.material.appbar.AppBarLayout.b) r1
            r9.a((com.google.android.material.appbar.AppBarLayout.b) r1)
        L_0x009b:
            net.one97.paytm.recharge.mobile.d.a r9 = r7.f63600h
            if (r9 == 0) goto L_0x00a4
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r9 = r9.F
            androidx.lifecycle.LiveData r9 = (androidx.lifecycle.LiveData) r9
            goto L_0x00a5
        L_0x00a4:
            r9 = r0
        L_0x00a5:
            net.one97.paytm.recharge.mobile_v3.b.d$v r1 = new net.one97.paytm.recharge.mobile_v3.b.d$v
            r1.<init>(r7)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            net.one97.paytm.recharge.common.utils.g.a(r7, r9, r1)
            net.one97.paytm.recharge.mobile.d.a r9 = r7.f63600h
            if (r9 == 0) goto L_0x00b8
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r9 = r9.G
            androidx.lifecycle.LiveData r9 = (androidx.lifecycle.LiveData) r9
            goto L_0x00b9
        L_0x00b8:
            r9 = r0
        L_0x00b9:
            net.one97.paytm.recharge.mobile_v3.b.d$w r1 = new net.one97.paytm.recharge.mobile_v3.b.d$w
            r1.<init>(r7)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            net.one97.paytm.recharge.common.utils.g.a(r7, r9, r1)
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a
            android.content.Context r9 = r7.getContext()
            net.one97.paytm.recharge.mobile.d.a r1 = r7.f63600h
            if (r1 == 0) goto L_0x00d6
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
            if (r1 == 0) goto L_0x00d6
            java.lang.String r1 = r1.getCategoryId()
            goto L_0x00d7
        L_0x00d6:
            r1 = r0
        L_0x00d7:
            boolean r9 = net.one97.paytm.recharge.di.helper.c.a(r9, r1)
            if (r9 == 0) goto L_0x00f1
            net.one97.paytm.recharge.mobile.d.a r9 = r7.f63600h
            if (r9 == 0) goto L_0x00e4
            androidx.lifecycle.y<net.one97.paytm.recharge.model.CJRPersonalInsurance> r9 = r9.T
            goto L_0x00e5
        L_0x00e4:
            r9 = r0
        L_0x00e5:
            androidx.lifecycle.LiveData r9 = (androidx.lifecycle.LiveData) r9
            net.one97.paytm.recharge.mobile_v3.b.d$x r1 = new net.one97.paytm.recharge.mobile_v3.b.d$x
            r1.<init>(r7)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            net.one97.paytm.recharge.common.utils.g.a(r7, r9, r1)
        L_0x00f1:
            int r9 = net.one97.paytm.recharge.R.id.upper_section
            android.view.View r9 = r8.findViewById(r9)
            androidx.core.widget.NestedScrollView r9 = (androidx.core.widget.NestedScrollView) r9
            r7.ad = r9
            androidx.core.widget.NestedScrollView r9 = r7.ad
            if (r9 != 0) goto L_0x0102
            kotlin.g.b.k.a()
        L_0x0102:
            android.view.ViewTreeObserver r9 = r9.getViewTreeObserver()
            net.one97.paytm.recharge.common.utils.u r1 = new net.one97.paytm.recharge.common.utils.u
            java.lang.String r2 = r7.t
            r3 = r7
            net.one97.paytm.recharge.common.e.ad r3 = (net.one97.paytm.recharge.common.e.ad) r3
            r1.<init>(r2, r3)
            android.view.ViewTreeObserver$OnGlobalLayoutListener r1 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r1
            r9.addOnGlobalLayoutListener(r1)
            int r9 = net.one97.paytm.recharge.R.id.lyt_footer
            android.view.View r9 = r8.findViewById(r9)
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r7.ap = r9
            int r9 = net.one97.paytm.recharge.R.id.lyt_fast_forward
            android.view.View r9 = r8.findViewById(r9)
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r9 = (net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8) r9
            r7.ar = r9
            int r9 = net.one97.paytm.recharge.R.id.bank_offers_promocode_text_layout
            android.view.View r9 = r8.findViewById(r9)
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r9 = (net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3) r9
            r7.af = r9
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r9 = r7.af
            r1 = 0
            if (r9 == 0) goto L_0x013b
            r9.setEnabled(r1)
        L_0x013b:
            android.content.Context r9 = r7.getContext()
            if (r9 == 0) goto L_0x01b1
            android.content.Context r9 = r7.getContext()
            if (r9 != 0) goto L_0x014a
            kotlin.g.b.k.a()
        L_0x014a:
            java.lang.String r2 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
            net.one97.paytm.recharge.mobile.d.a r2 = r7.f63600h
            if (r2 == 0) goto L_0x015c
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
            if (r2 == 0) goto L_0x015c
            java.lang.String r2 = r2.getCategoryId()
            goto L_0x015d
        L_0x015c:
            r2 = r0
        L_0x015d:
            r3 = 1
            com.google.gson.f r4 = new com.google.gson.f     // Catch:{ Exception -> 0x01a4 }
            r4.<init>()     // Catch:{ Exception -> 0x01a4 }
            net.one97.paytm.recharge.di.helper.c r5 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r5 = net.one97.paytm.recharge.di.helper.c.bR()     // Catch:{ Exception -> 0x01a4 }
            java.lang.Class<java.util.HashMap> r6 = java.util.HashMap.class
            java.lang.Object r4 = r4.a((java.lang.String) r5, r6)     // Catch:{ Exception -> 0x01a4 }
            boolean r5 = r4 instanceof java.util.HashMap     // Catch:{ Exception -> 0x01a4 }
            if (r5 != 0) goto L_0x0174
            goto L_0x0175
        L_0x0174:
            r0 = r4
        L_0x0175:
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x01a4 }
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01a4 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01a4 }
            if (r4 != 0) goto L_0x01a4
            if (r0 == 0) goto L_0x01a4
            r4 = r0
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x01a4 }
            if (r4 == 0) goto L_0x019c
            boolean r4 = r4.containsKey(r2)     // Catch:{ Exception -> 0x01a4 }
            if (r4 != r3) goto L_0x01a4
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x01a4 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01a4 }
            boolean r9 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r0, (android.content.Context) r9)     // Catch:{ Exception -> 0x01a4 }
            if (r9 == 0) goto L_0x01a4
            goto L_0x01a5
        L_0x019c:
            kotlin.u r9 = new kotlin.u     // Catch:{ Exception -> 0x01a4 }
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            r9.<init>(r0)     // Catch:{ Exception -> 0x01a4 }
            throw r9     // Catch:{ Exception -> 0x01a4 }
        L_0x01a4:
            r3 = 0
        L_0x01a5:
            if (r3 == 0) goto L_0x01b1
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r9 = r7.af
            if (r9 == 0) goto L_0x01ba
            android.view.View r9 = (android.view.View) r9
            net.one97.paytm.recharge.common.utils.ai.b(r9)
            goto L_0x01ba
        L_0x01b1:
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r9 = r7.af
            if (r9 == 0) goto L_0x01ba
            android.view.View r9 = (android.view.View) r9
            net.one97.paytm.recharge.common.utils.ai.a(r9)
        L_0x01ba:
            int r9 = net.one97.paytm.recharge.R.id.promo_divider
            android.view.View r9 = r8.findViewById(r9)
            r7.ag = r9
            int r9 = net.one97.paytm.recharge.R.id.btn_pre_validate
            android.view.View r9 = r8.findViewById(r9)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r9
            r7.au = r9
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = r7.au
            if (r9 == 0) goto L_0x01d9
            int r0 = net.one97.paytm.recharge.R.string.next
            java.lang.String r0 = r7.getString(r0)
            r9.setProceedBtnText(r0)
        L_0x01d9:
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = r7.au
            if (r9 == 0) goto L_0x01e3
            r0 = r7
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x01e3:
            int r9 = net.one97.paytm.recharge.R.id.ic_operator
            android.view.View r9 = r8.findViewById(r9)
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r9 = (net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8) r9
            r7.aw = r9
            int r9 = net.one97.paytm.recharge.R.id.txt_update_operator
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.ax = r8
            r7.a((boolean) r1)
            int r8 = net.one97.paytm.recharge.R.id.insurance_checkbox_container
            android.view.View r8 = r7.b((int) r8)
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            if (r8 == 0) goto L_0x020e
            net.one97.paytm.recharge.mobile_v3.b.d$y r9 = new net.one97.paytm.recharge.mobile_v3.b.d$y
            r9.<init>(r7)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
        L_0x020e:
            int r8 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r8 = r7.b((int) r8)
            android.widget.CheckBox r8 = (android.widget.CheckBox) r8
            net.one97.paytm.recharge.mobile_v3.b.d$z r9 = new net.one97.paytm.recharge.mobile_v3.b.d$z
            r9.<init>(r7)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r8.setOnClickListener(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void z() {
        if (this.f63600h != null) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            if (aVar.f61412e) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setActionType(ACTION_TYPE.RECREATE.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setErrorType(ERROR_TYPE.UI_DISTORT.name());
                }
                a(a2);
            }
        }
    }

    public final void a() {
        String str;
        Serializable serializable;
        String regex;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || !aVar.f61412e) {
            j();
            CJRAmountInputFieldWidgetV3 cJRAmountInputFieldWidgetV3 = this.o;
            if (cJRAmountInputFieldWidgetV3 != null) {
                cJRAmountInputFieldWidgetV3.clearFocus();
            }
            EditText editText = (EditText) b(R.id.dummy_focusable_view);
            if (editText != null) {
                editText.clearFocus();
            }
            this.E = false;
            this.Q = false;
            HashMap hashMap = new HashMap(1);
            Bundle bundle = new Bundle();
            StringBuilder sb = this.N;
            if (sb == null || (str = sb.toString()) == null) {
                str = "";
            }
            bundle.putString("title", str);
            CJRInputFieldsItem cJRInputFieldsItem = this.A;
            if (cJRInputFieldsItem == null || (regex = cJRInputFieldsItem.getRegex()) == null) {
                serializable = "";
            } else {
                serializable = regex;
            }
            bundle.putSerializable("price_regex", serializable);
            int i2 = Build.VERSION.SDK_INT;
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 != null) {
                net.one97.paytm.recharge.ordersummary.h.d.a(aVar2.v, aVar2.e(), "Browse Plans_dropdown_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
            if (dVar != null) {
                dVar.a(hashMap, bundle);
                return;
            }
            return;
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setActionType(ACTION_TYPE.RECREATE.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UI_DISTORT.name());
        }
        a(a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r0 = r0.getPrice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(java.lang.CharSequence r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            net.one97.paytm.recharge.mobile.d.a r3 = r2.f63600h
            r4 = 1
            r5 = 0
            r6 = 0
            if (r3 == 0) goto L_0x005a
            boolean r0 = r2.Q
            if (r0 == 0) goto L_0x005a
            boolean r0 = r2.E
            if (r0 != 0) goto L_0x005a
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r0 = r3.J
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0
            if (r0 == 0) goto L_0x002a
            java.lang.Double r0 = r0.getPrice()
            if (r0 == 0) goto L_0x002a
            double r0 = r0.doubleValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x002b
        L_0x002a:
            r0 = r6
        L_0x002b:
            java.lang.String r0 = r2.j((java.lang.String) r0)
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r2.o
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = r1.getInputText()
            goto L_0x0039
        L_0x0038:
            r1 = r6
        L_0x0039:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r4)
            if (r0 != 0) goto L_0x005a
            r2.Q = r5
            net.one97.paytm.recharge.mobile.d.a r0 = r2.f63600h
            if (r0 == 0) goto L_0x0052
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r0 = r0.J
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0052
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0
            goto L_0x0053
        L_0x0052:
            r0 = r6
        L_0x0053:
            if (r0 == 0) goto L_0x0057
            r2.aC = r4
        L_0x0057:
            r3.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r6)
        L_0x005a:
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r3 = r2.af
            if (r3 == 0) goto L_0x0061
            r3.setEnabled(r5)
        L_0x0061:
            r2.a((boolean) r5)
            r2.E()
            net.one97.paytm.recharge.mobile.d.a r3 = r2.f63600h
            if (r3 == 0) goto L_0x006d
            r3.S = r6
        L_0x006d:
            r2.ak = r5
            boolean r3 = r2.as
            if (r3 != 0) goto L_0x0096
            net.one97.paytm.recharge.mobile.widget.CJRMobileFastForwardWidgetV8 r3 = r2.ar
            if (r3 == 0) goto L_0x0096
            boolean r3 = r3.a()
            if (r3 != r4) goto L_0x0096
            int r3 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r3 = r2.b((int) r3)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r3 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r3
            if (r3 == 0) goto L_0x0096
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r4 = r2.o
            if (r4 == 0) goto L_0x008f
            java.lang.String r6 = r4.getFormattedString()
        L_0x008f:
            java.lang.String r4 = r2.a((java.lang.String) r6)
            r3.setProceedBtnText(r4)
        L_0x0096:
            boolean r3 = r2.al
            if (r3 != 0) goto L_0x009d
            r2.b((boolean) r5)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (this.H) {
            this.H = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.L;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String n() {
        /*
            r1 = this;
            net.one97.paytm.recharge.mobile.d.a r0 = r1.f63600h
            if (r0 == 0) goto L_0x0008
            java.lang.String r0 = r0.L
            if (r0 != 0) goto L_0x000a
        L_0x0008:
            java.lang.String r0 = ""
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.n():java.lang.String");
    }

    public final boolean o() {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        return aVar != null && aVar.o();
    }

    public final void l() {
        net.one97.paytm.recharge.common.c.g gVar;
        try {
            net.one97.paytm.recharge.common.c.g gVar2 = this.aD;
            if (!(gVar2 == null || !gVar2.isVisible() || (gVar = this.aD) == null)) {
                gVar.dismiss();
            }
        } catch (Exception unused) {
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = this.au;
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.b();
        }
        CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV82 != null) {
            cJRProceedWidgetV82.b();
        }
        ViewGroup viewGroup = this.ap;
        if (viewGroup != null) {
            viewGroup.setEnabled(true);
        }
        CJRProceedWidgetV8 cJRProceedWidgetV83 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
        if (cJRProceedWidgetV83 != null) {
            cJRProceedWidgetV83.setEnabled(true);
        }
        View b2 = b(R.id.dummy_view);
        if (b2 != null) {
            net.one97.paytm.recharge.common.utils.ai.b(b2);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(networkCustomError, "error");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            aVar.a("fetch_promo_verify", 401, (IJRPaytmDataModel) null, networkCustomError, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r6 = r6.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        r6 = (r6 = r0.f63600h).m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(java.lang.String r28, net.one97.paytm.recharge.common.e.ai r29, boolean r30, boolean r31, java.lang.Object r32) {
        /*
            r27 = this;
            r0 = r27
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            java.lang.String r2 = "subregion_id"
            java.lang.String r3 = "ref_id"
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0057
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            if (r1 == 0) goto L_0x0057
            java.util.Map r1 = (java.util.Map) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r4
            if (r1 != r4) goto L_0x0057
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            if (r1 == 0) goto L_0x0037
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            if (r1 == 0) goto L_0x0037
            boolean r1 = r1.containsKey(r3)
            if (r1 != r4) goto L_0x0037
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            if (r1 == 0) goto L_0x0037
            java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
            if (r1 == 0) goto L_0x0037
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0038
        L_0x0037:
            r1 = r5
        L_0x0038:
            net.one97.paytm.recharge.mobile.d.a r6 = r0.f63600h
            if (r6 == 0) goto L_0x0055
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r6.m
            if (r6 == 0) goto L_0x0055
            boolean r6 = r6.containsKey(r2)
            if (r6 != r4) goto L_0x0055
            net.one97.paytm.recharge.mobile.d.a r6 = r0.f63600h
            if (r6 == 0) goto L_0x0055
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r6.m
            if (r6 == 0) goto L_0x0055
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0059
        L_0x0055:
            r6 = r5
            goto L_0x0059
        L_0x0057:
            r1 = r5
            r6 = r1
        L_0x0059:
            if (r30 != 0) goto L_0x006f
            int r7 = net.one97.paytm.recharge.R.id.insurance_checkbox
            android.view.View r7 = r0.b((int) r7)
            android.widget.CheckBox r7 = (android.widget.CheckBox) r7
            if (r7 == 0) goto L_0x006c
            boolean r7 = r7.isChecked()
            if (r7 != r4) goto L_0x006c
            goto L_0x006f
        L_0x006c:
            r19 = r5
            goto L_0x0073
        L_0x006f:
            net.one97.paytm.recharge.model.CJRPersonalInsurance r4 = r0.y
            r19 = r4
        L_0x0073:
            androidx.fragment.app.FragmentActivity r4 = r27.getActivity()
            if (r4 == 0) goto L_0x0268
            net.one97.paytm.recharge.mobile.d.a r7 = r0.f63600h
            if (r7 == 0) goto L_0x0268
            java.lang.String r8 = "it"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            android.content.Context r4 = (android.content.Context) r4
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r8 = r0.o
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x0093
            java.lang.String r8 = r8.getInputText()
            if (r8 != 0) goto L_0x0091
            goto L_0x0093
        L_0x0091:
            r12 = r8
            goto L_0x0094
        L_0x0093:
            r12 = r9
        L_0x0094:
            if (r31 == 0) goto L_0x0099
        L_0x0096:
            r18 = r5
            goto L_0x00a3
        L_0x0099:
            net.one97.paytm.recharge.model.CJRPromoCode r8 = r0.v
            if (r8 == 0) goto L_0x0096
            java.lang.String r8 = r8.getCode()
            r18 = r8
        L_0x00a3:
            if (r31 == 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            net.one97.paytm.recharge.common.utils.o r5 = r0.u
        L_0x00a8:
            r20 = r5
            java.lang.String r5 = "context"
            kotlin.g.b.k.c(r4, r5)
            java.lang.String r5 = "tag"
            r8 = r28
            kotlin.g.b.k.c(r8, r5)
            java.lang.String r5 = "enteredAmount"
            kotlin.g.b.k.c(r12, r5)
            java.lang.String r5 = "onSuccess"
            r15 = r29
            kotlin.g.b.k.c(r15, r5)
            net.one97.paytm.recharge.common.b.c r5 = r7.s
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x0252
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r5 = r7.G
            java.lang.Object r5 = r5.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x00e0
            java.lang.Long r5 = r5.getProductId()
            if (r5 == 0) goto L_0x00e0
            long r13 = r5.longValue()
            goto L_0x00e2
        L_0x00e0:
            r13 = -1
        L_0x00e2:
            androidx.lifecycle.y<java.lang.String> r5 = r7.z
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            boolean r11 = r7.o()
            r16 = -1
            int r21 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r21 == 0) goto L_0x023b
            r16 = r5
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x023b
            r16 = r12
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x023b
            java.util.HashMap r16 = new java.util.HashMap
            r16.<init>()
            r0 = r16
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r0.put(r13, r12)
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.util.Map r13 = (java.util.Map) r13
            if (r5 != 0) goto L_0x0129
            kotlin.g.b.k.a()
        L_0x0129:
            java.lang.String r14 = "recharge_number"
            r13.put(r14, r5)
            java.lang.String r14 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.String r8 = "CJRRechargeUtilityConstant.KEY_CATEGORY_ID"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r8 = r7.f61409b
            java.lang.String r8 = r8.getCategoryId()
            if (r8 != 0) goto L_0x013e
            r8 = r9
        L_0x013e:
            r13.put(r14, r8)
            androidx.lifecycle.y<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r8 = r7.J
            java.lang.Object r8 = r8.getValue()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r8 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r8
            if (r8 == 0) goto L_0x01a3
            java.lang.String r14 = r8.getValidity()
            r30 = r9
            if (r14 != 0) goto L_0x0155
            r14 = r30
        L_0x0155:
            java.lang.String r9 = "validity"
            r10.put(r9, r14)
            java.lang.String r9 = r8.getTalktime()
            if (r9 != 0) goto L_0x0163
            r9 = r30
        L_0x0163:
            java.lang.String r14 = "talktime"
            r10.put(r14, r9)
            java.lang.String r9 = r8.getDescription()
            if (r9 != 0) goto L_0x0171
            r9 = r30
        L_0x0171:
            java.lang.String r14 = "couponDescription"
            r10.put(r14, r9)
            java.lang.String r9 = r8.getData()
            if (r9 != 0) goto L_0x017e
            r9 = r30
        L_0x017e:
            java.lang.String r14 = "data"
            r10.put(r14, r9)
            java.lang.String r9 = r8.getSms()
            if (r9 != 0) goto L_0x018b
            r9 = r30
        L_0x018b:
            java.lang.String r14 = "sms"
            r10.put(r14, r9)
            if (r11 == 0) goto L_0x01a5
            java.lang.String r9 = "this"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            long r8 = r8.getProductId()
            java.lang.String r14 = "plan_id"
            r10.put(r14, r8)
            goto L_0x01a5
        L_0x01a3:
            r30 = r9
        L_0x01a5:
            if (r11 == 0) goto L_0x01b7
            java.lang.String r8 = "phone"
            r10.put(r8, r5)
            java.lang.String r5 = "amount"
            r10.put(r5, r12)
            r10.put(r2, r6)
            r10.put(r3, r1)
        L_0x01b7:
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r1 = r7.G
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            if (r1 == 0) goto L_0x01d5
            java.lang.String r2 = r1.getPostOrderViewType()
            java.lang.String r3 = "post_order_view_type"
            r10.put(r3, r2)
            if (r11 == 0) goto L_0x01d5
            java.lang.String r1 = r1.getOperator()
            java.lang.String r2 = "operator_id"
            r10.put(r2, r1)
        L_0x01d5:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r2 = r7.G
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            if (r2 == 0) goto L_0x01e7
            r1.add(r2)
        L_0x01e7:
            boolean r14 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r4)
            net.one97.paytm.recharge.common.utils.w r2 = r7.t
            if (r2 == 0) goto L_0x021a
            net.one97.paytm.recharge.common.utils.w r2 = r7.t
            if (r2 == 0) goto L_0x0219
            boolean r3 = r7.f61411d
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r7.f61409b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r4.getCategoryData()
            if (r4 == 0) goto L_0x0203
            java.lang.String r4 = r4.getDisplayName()
            if (r4 != 0) goto L_0x0205
        L_0x0203:
            r4 = r30
        L_0x0205:
            r16 = r1
            java.util.List r16 = (java.util.List) r16
            r7 = r2
            r8 = r28
            r9 = r0
            r0 = r10
            r10 = r13
            r11 = r0
            r13 = r3
            r15 = r4
            r17 = r32
            r21 = r29
            r7.a((java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.String>) r9, (java.util.Map<java.lang.String, java.lang.String>) r10, (org.json.JSONObject) r11, (java.lang.String) r12, (boolean) r13, (boolean) r14, (java.lang.String) r15, (java.util.List<net.one97.paytm.recharge.model.v4.CJRProductsItem>) r16, (java.lang.Object) r17, (java.lang.String) null, (java.lang.String) r18, (net.one97.paytm.recharge.model.CJRPersonalInsurance) r19, (net.one97.paytm.recharge.common.utils.o) r20, (net.one97.paytm.recharge.common.e.ai) r21)
        L_0x0219:
            return
        L_0x021a:
            r23 = -1
            r24 = 0
            boolean r0 = r7.f61412e
            if (r0 == 0) goto L_0x0228
            net.one97.paytm.recharge.common.utils.au r0 = new net.one97.paytm.recharge.common.utils.au
            r0.<init>()
            goto L_0x022d
        L_0x0228:
            net.one97.paytm.recharge.common.utils.bi r0 = new net.one97.paytm.recharge.common.utils.bi
            r0.<init>()
        L_0x022d:
            com.paytm.network.model.NetworkCustomError r0 = (com.paytm.network.model.NetworkCustomError) r0
            r25 = r0
            r21 = r29
            r22 = r28
            r26 = r32
            r21.a(r22, r23, r24, r25, r26)
            return
        L_0x023b:
            r23 = -1
            r24 = 0
            net.one97.paytm.recharge.common.utils.bi r0 = new net.one97.paytm.recharge.common.utils.bi
            r0.<init>()
            r25 = r0
            com.paytm.network.model.NetworkCustomError r25 = (com.paytm.network.model.NetworkCustomError) r25
            r21 = r29
            r22 = r28
            r26 = r32
            r21.a(r22, r23, r24, r25, r26)
            return
        L_0x0252:
            r23 = 403(0x193, float:5.65E-43)
            r24 = 0
            net.one97.paytm.recharge.common.utils.c r0 = new net.one97.paytm.recharge.common.utils.c
            r0.<init>()
            r25 = r0
            com.paytm.network.model.NetworkCustomError r25 = (com.paytm.network.model.NetworkCustomError) r25
            r21 = r29
            r22 = r28
            r26 = r32
            r21.a(r22, r23, r24, r25, r26)
        L_0x0268:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.a(java.lang.String, net.one97.paytm.recharge.common.e.ai, boolean, boolean, java.lang.Object):void");
    }

    public final void b(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            if (str == null) {
                str = "";
            }
            aVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) (r0 = r0.y).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.mobile_v3.b.d r10, java.util.LinkedList r11) {
        /*
            net.one97.paytm.recharge.mobile.d.a r0 = r10.f63600h
            r1 = 0
            if (r0 == 0) goto L_0x0018
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r0 = r0.y
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0018
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r0 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r0
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getLabel()
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r10.N = r3
            net.one97.paytm.recharge.mobile_v3.widget.CJRPromoWidgetV3 r3 = r10.af
            r4 = 0
            if (r3 == 0) goto L_0x002d
            r3.setEnabled(r4)
        L_0x002d:
            r10.a((boolean) r4)
            r10.E()
            net.one97.paytm.recharge.mobile.d.a r3 = r10.f63600h
            if (r3 == 0) goto L_0x0039
            r3.S = r1
        L_0x0039:
            r10.ak = r4
            r10.al = r4
            r10.am = r1
            r10.at = r4
            r10.E = r4
            r10.C = r1
            r10.D = r4
            java.lang.Object r3 = r11.get(r4)
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r3 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r3
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = r3.getItem()
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x005b
            java.lang.String r3 = r3.getDisplayValue()
            if (r3 != 0) goto L_0x005c
        L_0x005b:
            r3 = r5
        L_0x005c:
            r2.append(r3)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r3 = r1
        L_0x0066:
            boolean r6 = r11.hasNext()
            java.lang.String r7 = " "
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r6 = r11.next()
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r6 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r6
            java.lang.StringBuilder r8 = r10.N
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r7)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r7 = r6.getItem()
            if (r7 == 0) goto L_0x0089
            java.lang.String r7 = r7.getDisplayValue()
            if (r7 != 0) goto L_0x008a
        L_0x0089:
            r7 = r5
        L_0x008a:
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.append(r7)
        L_0x0094:
            net.one97.paytm.recharge.model.v4.CJRAggsItem r7 = r6.getItem()
            if (r7 == 0) goto L_0x009f
            java.lang.String r7 = r7.getImageUrl()
            goto L_0x00a0
        L_0x009f:
            r7 = r1
        L_0x00a0:
            boolean r7 = net.one97.paytm.recharge.common.utils.g.c(r7)
            if (r7 == 0) goto L_0x0066
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = r6.getItem()
            if (r3 != 0) goto L_0x00af
            kotlin.g.b.k.a()
        L_0x00af:
            java.lang.String r3 = r3.getImageUrl()
            goto L_0x0066
        L_0x00b4:
            boolean r11 = net.one97.paytm.recharge.common.utils.g.c(r0)
            if (r11 == 0) goto L_0x00c0
            r2.append(r7)
            r2.append(r0)
        L_0x00c0:
            r11 = r3
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x00d9
            com.squareup.picasso.w r11 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r11 = r11.a((java.lang.String) r3)
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r0 = r10.aw
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r11.a((android.widget.ImageView) r0)
            goto L_0x00e0
        L_0x00d9:
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r11 = r10.aw
            if (r11 == 0) goto L_0x00e0
            r11.setImageResource(r4)
        L_0x00e0:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x0115
            net.one97.paytm.recharge.model.ContactItemModel r11 = r11.C
            if (r11 == 0) goto L_0x0115
            java.lang.String r0 = r11.getName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00fe
            java.lang.String r0 = r11.getName()
            java.lang.String r3 = "it.name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            goto L_0x00ff
        L_0x00fe:
            r0 = r5
        L_0x00ff:
            java.lang.String r3 = r11.getPhotoUri()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0162
            java.lang.String r5 = r11.getPhotoUri()
            java.lang.String r11 = "it.photoUri"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            goto L_0x0162
        L_0x0115:
            r11 = r10
            net.one97.paytm.recharge.mobile_v3.b.d r11 = (net.one97.paytm.recharge.mobile_v3.b.d) r11
            net.one97.paytm.recharge.mobile.d.a r11 = r11.f63600h
            if (r11 == 0) goto L_0x0161
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r11 = r11.j()
            if (r11 == 0) goto L_0x0161
            java.lang.String r0 = r11.getContactName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0138
            java.lang.String r0 = r11.getContactName()
            java.lang.String r3 = "it.contactName"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            goto L_0x0139
        L_0x0138:
            r0 = r5
        L_0x0139:
            net.one97.paytm.recharge.common.utils.n r3 = net.one97.paytm.recharge.common.utils.n.f61679a
            java.lang.String r11 = r11.getRechargeNumber()
            java.lang.String r3 = "it.rechargeNumber"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            net.one97.paytm.recharge.model.ContactItemModel r11 = net.one97.paytm.recharge.common.utils.n.a((java.lang.String) r11)
            if (r11 == 0) goto L_0x0162
            java.lang.String r3 = r11.getPhotoUri()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0162
            java.lang.String r11 = r11.getPhotoUri()
            java.lang.String r3 = "contact.photoUri"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            r5 = r11
            goto L_0x0162
        L_0x0161:
            r0 = r5
        L_0x0162:
            r11 = r5
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            r3 = 8
            if (r11 != 0) goto L_0x01b1
            int r11 = net.one97.paytm.recharge.R.id.customer_image
            android.view.View r11 = r10.b((int) r11)
            net.one97.paytm.common.widgets.CircularImageView r11 = (net.one97.paytm.common.widgets.CircularImageView) r11
            if (r11 == 0) goto L_0x01b1
            int r11 = net.one97.paytm.recharge.R.id.customer_image
            android.view.View r11 = r10.b((int) r11)
            net.one97.paytm.common.widgets.CircularImageView r11 = (net.one97.paytm.common.widgets.CircularImageView) r11
            if (r11 == 0) goto L_0x0184
            r11.setVisibility(r4)
        L_0x0184:
            int r11 = net.one97.paytm.recharge.R.id.tv_name_initial
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0191
            r11.setVisibility(r3)
        L_0x0191:
            com.squareup.picasso.w r11 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r11 = r11.a((java.lang.String) r5)
            int r3 = net.one97.paytm.recharge.R.drawable.v3_default_logo_contact
            com.squareup.picasso.aa r11 = r11.a((int) r3)
            int r3 = net.one97.paytm.recharge.R.drawable.v3_default_logo_contact
            com.squareup.picasso.aa r11 = r11.b((int) r3)
            int r3 = net.one97.paytm.recharge.R.id.customer_image
            android.view.View r3 = r10.b((int) r3)
            net.one97.paytm.common.widgets.CircularImageView r3 = (net.one97.paytm.common.widgets.CircularImageView) r3
            r11.a((android.widget.ImageView) r3)
            goto L_0x021b
        L_0x01b1:
            r11 = r0
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x01f2
            int r11 = net.one97.paytm.recharge.R.id.tv_name_initial
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x01f2
            int r11 = net.one97.paytm.recharge.R.id.tv_name_initial
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x01d1
            r11.setVisibility(r4)
        L_0x01d1:
            int r11 = net.one97.paytm.recharge.R.id.customer_image
            android.view.View r11 = r10.b((int) r11)
            net.one97.paytm.common.widgets.CircularImageView r11 = (net.one97.paytm.common.widgets.CircularImageView) r11
            if (r11 == 0) goto L_0x01de
            r11.setVisibility(r3)
        L_0x01de:
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            int r11 = net.one97.paytm.recharge.R.id.tv_name_initial
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            java.lang.String r3 = "tv_name_initial"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            net.one97.paytm.recharge.widgets.c.d.a((android.widget.TextView) r11, (java.lang.String) r0, (int) r4)
            goto L_0x021b
        L_0x01f2:
            int r11 = net.one97.paytm.recharge.R.id.customer_image
            android.view.View r11 = r10.b((int) r11)
            net.one97.paytm.common.widgets.CircularImageView r11 = (net.one97.paytm.common.widgets.CircularImageView) r11
            if (r11 == 0) goto L_0x01ff
            r11.setVisibility(r4)
        L_0x01ff:
            int r11 = net.one97.paytm.recharge.R.id.tv_name_initial
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x020c
            r11.setVisibility(r3)
        L_0x020c:
            int r11 = net.one97.paytm.recharge.R.id.customer_image
            android.view.View r11 = r10.b((int) r11)
            net.one97.paytm.common.widgets.CircularImageView r11 = (net.one97.paytm.common.widgets.CircularImageView) r11
            if (r11 == 0) goto L_0x021b
            int r3 = net.one97.paytm.recharge.R.drawable.v3_default_logo_contact
            r11.setImageResource(r3)
        L_0x021b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r11 = android.text.TextUtils.isEmpty(r0)
            if (r11 != 0) goto L_0x026b
            int r11 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0230
            r11.setText(r0)
        L_0x0230:
            int r11 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x023d
            r11.setVisibility(r4)
        L_0x023d:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            net.one97.paytm.recharge.mobile.d.a r0 = r10.f63600h
            if (r0 == 0) goto L_0x0253
            androidx.lifecycle.y<java.lang.String> r0 = r0.z
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0253
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0254
        L_0x0253:
            r0 = r1
        L_0x0254:
            r11.append(r0)
            java.lang.String r0 = ", "
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.StringBuilder r11 = r2.insert(r4, r11)
            java.lang.String r0 = "titleBuilder.insert(0, \"…obileNumber()?.value}, \")"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            goto L_0x02a5
        L_0x026b:
            int r11 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x028c
            net.one97.paytm.recharge.mobile.d.a r0 = r10.f63600h
            if (r0 == 0) goto L_0x0286
            androidx.lifecycle.y<java.lang.String> r0 = r0.z
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0286
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0287
        L_0x0286:
            r0 = r1
        L_0x0287:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r11.setText(r0)
        L_0x028c:
            int r11 = net.one97.paytm.recharge.R.id.txt_contact_name
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0299
            r11.setVisibility(r4)
        L_0x0299:
            java.util.concurrent.Executor r11 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            net.one97.paytm.recharge.mobile_v3.b.d$r r0 = new net.one97.paytm.recharge.mobile_v3.b.d$r
            r0.<init>(r10, r2)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r11.execute(r0)
        L_0x02a5:
            int r11 = net.one97.paytm.recharge.R.id.txt_operator
            android.view.View r11 = r10.b((int) r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x02b8
            java.lang.String r0 = r2.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r11.setText(r0)
        L_0x02b8:
            android.widget.TextView r11 = r10.ax
            if (r11 == 0) goto L_0x02c2
            r0 = r10
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r11.setOnClickListener(r0)
        L_0x02c2:
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r11 = r10.aw
            if (r11 == 0) goto L_0x02cc
            r0 = r10
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r11.setOnClickListener(r0)
        L_0x02cc:
            int r11 = net.one97.paytm.recharge.R.id.container_product_input_fields
            android.view.View r11 = r10.b((int) r11)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x02d9
            r11.removeAllViews()
        L_0x02d9:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x02e4
            net.one97.paytm.recharge.common.b.a r11 = r11.x
            if (r11 == 0) goto L_0x02e4
            r11.c()
        L_0x02e4:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x02eb
            r11.a((net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r1)
        L_0x02eb:
            r10.aC = r4
            r10.X = r4
            r10.h()
            r11 = 1
            r10.R = r11
            r10.at = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.a(net.one97.paytm.recharge.mobile_v3.b.d, java.util.LinkedList):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0063 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.recharge.mobile_v3.b.d r10, java.util.LinkedList r11) {
        /*
            net.one97.paytm.recharge.mobile.d.a r0 = r10.f63600h
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x010f
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x010f
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r0.getCategoryData()
            if (r0 == 0) goto L_0x010f
            boolean r0 = r0.isProductListInLastGrouping()
            if (r0 != r3) goto L_0x010f
            java.lang.Object r11 = r11.getLast()
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r11 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r11
            net.one97.paytm.recharge.model.v4.CJRAggsItem r0 = r11.getItem()
            if (r0 == 0) goto L_0x00dc
            java.util.List r0 = r0.getAggs()
            if (r0 == 0) goto L_0x00dc
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00dc
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = r11.getItem()
            if (r11 == 0) goto L_0x00da
            java.util.List r11 = r11.getAggs()
            if (r11 == 0) goto L_0x00da
            r10.B = r11
            net.one97.paytm.recharge.mobile.d.a r0 = r10.f63600h
            if (r0 == 0) goto L_0x0054
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r0 = r0.G
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0054
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r0 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r0
            if (r0 == 0) goto L_0x0054
            java.lang.Long r0 = r0.getProductId()
            goto L_0x0055
        L_0x0054:
            r0 = r1
        L_0x0055:
            r4 = r11
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0063:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00b8
            java.lang.Object r6 = r4.next()
            r7 = r6
            net.one97.paytm.recharge.model.v4.CJRAggsItem r7 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r7
            java.util.List r8 = r7.getProductList()
            if (r8 == 0) goto L_0x00b1
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r9 = r8 instanceof java.util.Collection
            if (r9 == 0) goto L_0x0085
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x00ac
        L_0x0085:
            java.util.Iterator r8 = r8.iterator()
        L_0x0089:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00ac
            java.lang.Object r9 = r8.next()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r9 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r9
            java.lang.Long r9 = r9.getProductId()
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r0)
            if (r9 == 0) goto L_0x00a4
            r7.setItemSelected(r3)
            r9 = 1
            goto L_0x00a8
        L_0x00a4:
            r7.setItemSelected(r2)
            r9 = 0
        L_0x00a8:
            if (r9 == 0) goto L_0x0089
            r7 = 0
            goto L_0x00ad
        L_0x00ac:
            r7 = 1
        L_0x00ad:
            if (r7 != 0) goto L_0x00b1
            r7 = 1
            goto L_0x00b2
        L_0x00b1:
            r7 = 0
        L_0x00b2:
            if (r7 == 0) goto L_0x0063
            r5.add(r6)
            goto L_0x0063
        L_0x00b8:
            java.util.List r5 = (java.util.List) r5
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 != r3) goto L_0x00cf
            java.lang.Object r11 = r5.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            java.util.List r11 = r11.getProductList()
            goto L_0x00e8
        L_0x00cf:
            java.lang.Object r11 = r11.get(r2)
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = (net.one97.paytm.recharge.model.v4.CJRAggsItem) r11
            java.util.List r11 = r11.getProductList()
            goto L_0x00e8
        L_0x00da:
            r11 = r1
            goto L_0x00e8
        L_0x00dc:
            r10.B = r1
            net.one97.paytm.recharge.model.v4.CJRAggsItem r11 = r11.getItem()
            if (r11 == 0) goto L_0x00da
            java.util.List r11 = r11.getProductList()
        L_0x00e8:
            if (r11 == 0) goto L_0x0107
            r0 = r11
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 != r3) goto L_0x0107
            net.one97.paytm.recharge.mobile.d.a r10 = r10.f63600h
            if (r10 == 0) goto L_0x0106
            if (r11 != 0) goto L_0x00fd
            kotlin.g.b.k.a()
        L_0x00fd:
            java.lang.Object r11 = r11.get(r2)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r11 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r11
            r10.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r11)
        L_0x0106:
            return
        L_0x0107:
            net.one97.paytm.recharge.mobile.d.a r10 = r10.f63600h
            if (r10 == 0) goto L_0x010e
            r10.a((net.one97.paytm.recharge.model.v4.CJRProductsItem) r1)
        L_0x010e:
            return
        L_0x010f:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 != 0) goto L_0x0115
            r11 = 1
            goto L_0x0116
        L_0x0115:
            r11 = 0
        L_0x0116:
            net.one97.paytm.recharge.mobile.d.a r0 = r10.f63600h
            if (r0 == 0) goto L_0x011d
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            goto L_0x011e
        L_0x011d:
            r0 = r1
        L_0x011e:
            if (r0 != 0) goto L_0x0122
            r0 = 1
            goto L_0x0123
        L_0x0122:
            r0 = 0
        L_0x0123:
            net.one97.paytm.recharge.mobile.d.a r4 = r10.f63600h
            if (r4 == 0) goto L_0x0130
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r4 = r4.f61409b
            if (r4 == 0) goto L_0x0130
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r4.getCategoryData()
            goto L_0x0131
        L_0x0130:
            r4 = r1
        L_0x0131:
            if (r4 != 0) goto L_0x0135
            r4 = 1
            goto L_0x0136
        L_0x0135:
            r4 = 0
        L_0x0136:
            net.one97.paytm.recharge.mobile.d.a r5 = r10.f63600h
            if (r5 == 0) goto L_0x014b
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
            if (r5 == 0) goto L_0x014b
            net.one97.paytm.recharge.model.v4.CJRCategoryData r5 = r5.getCategoryData()
            if (r5 == 0) goto L_0x014b
            boolean r5 = r5.isProductListInLastGrouping()
            if (r5 != r3) goto L_0x014b
            goto L_0x014c
        L_0x014b:
            r3 = 0
        L_0x014c:
            net.one97.paytm.recharge.mobile.d.a r5 = r10.f63600h
            if (r5 == 0) goto L_0x015c
            java.lang.Object r5 = r5.e()
            if (r5 == 0) goto L_0x015c
            java.lang.String r5 = r5.toString()
            if (r5 != 0) goto L_0x015e
        L_0x015c:
            java.lang.String r5 = "Mobile"
        L_0x015e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r8 = " requesting getProductList()"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r7 = " isViewModelNull: "
            java.lang.String r11 = r7.concat(r11)
            r6.append(r11)
            java.lang.String r11 = java.lang.String.valueOf(r0)
            java.lang.String r0 = " isCategoryDataHelperNull: "
            java.lang.String r11 = r0.concat(r11)
            r6.append(r11)
            java.lang.String r11 = java.lang.String.valueOf(r4)
            java.lang.String r0 = " isCategoryDataNull: "
            java.lang.String r11 = r0.concat(r11)
            r6.append(r11)
            java.lang.String r11 = java.lang.String.valueOf(r3)
            java.lang.String r0 = " isProductListInLastGrouping: "
            java.lang.String r11 = r0.concat(r11)
            r6.append(r11)
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r11 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            java.lang.String r0 = "1721"
            r11.setErrorCode(r0)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r11.setErrorType(r0)
            java.lang.String r0 = r6.toString()
            r11.setErrorMsg(r0)
            r11.setScreenName(r5)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r11.getFlowName()
            if (r0 == 0) goto L_0x01d1
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r1 = r1.name()
            r0.setErrorType(r1)
        L_0x01d1:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r11.getFlowName()
            if (r0 == 0) goto L_0x01e0
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.MISSING_PRODUCT_IN_LAST_GROUPING
            java.lang.String r1 = r1.name()
            r0.setActionType(r1)
        L_0x01e0:
            r10.K = r2
            net.one97.paytm.recharge.mobile.d.a r10 = r10.f63600h
            if (r10 == 0) goto L_0x01eb
            java.lang.String r0 = "fetch_product_list"
            r10.b(r0, r11)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.b(net.one97.paytm.recharge.mobile_v3.b.d, java.util.LinkedList):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) (r1 = r1.G).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void c(net.one97.paytm.recharge.mobile_v3.b.d r20) {
        /*
            r0 = r20
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            r2 = 0
            if (r1 == 0) goto L_0x001a
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r1 = r1.G
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x001a
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r1 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r1
            if (r1 == 0) goto L_0x001a
            java.lang.Long r1 = r1.getProductId()
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            if (r1 == 0) goto L_0x009e
            net.one97.paytm.recharge.mobile.d.a r1 = r0.f63600h
            if (r1 == 0) goto L_0x002e
            androidx.lifecycle.y<java.lang.String> r1 = r1.z
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x002f
        L_0x002e:
            r1 = r2
        L_0x002f:
            if (r1 == 0) goto L_0x009e
            r3 = 4621819117588971520(0x4024000000000000, double:10.0)
            net.one97.paytm.recharge.mobile_v3.widget.CJRAmountInputFieldWidgetV3 r1 = r0.o     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = r1.getInputText()     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x0041
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            r10 = r3
            net.one97.paytm.recharge.common.utils.o r1 = new net.one97.paytm.recharge.common.utils.o
            android.content.Context r6 = r20.getContext()
            if (r6 != 0) goto L_0x004d
            kotlin.g.b.k.a()
        L_0x004d:
            r7 = 0
            net.one97.paytm.recharge.mobile.d.a r3 = r0.f63600h
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r3.e()
            if (r3 == 0) goto L_0x0063
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r8 = r3
            goto L_0x0064
        L_0x0063:
            r8 = r4
        L_0x0064:
            net.one97.paytm.recharge.mobile.d.a r3 = r0.f63600h
            if (r3 == 0) goto L_0x0075
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r3.f61409b
            if (r3 == 0) goto L_0x0075
            java.lang.String r3 = r3.getCategoryId()
            if (r3 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r9 = r3
            goto L_0x0076
        L_0x0075:
            r9 = r4
        L_0x0076:
            r12 = 0
            r13 = 0
            r14 = 0
            boolean r15 = r20.o()
            r16 = 0
            r17 = 0
            r18 = r0
            net.one97.paytm.recharge.common.e.u r18 = (net.one97.paytm.recharge.common.e.u) r18
            net.one97.paytm.recharge.mobile.d.a r3 = r0.f63600h
            if (r3 == 0) goto L_0x008d
            java.lang.Object r2 = r3.e()
        L_0x008d:
            java.lang.String r19 = java.lang.String.valueOf(r2)
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19)
            r0.u = r1
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.o r0 = r0.u
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.common.utils.o) r0)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.d.c(net.one97.paytm.recharge.mobile_v3.b.d):void");
    }
}
