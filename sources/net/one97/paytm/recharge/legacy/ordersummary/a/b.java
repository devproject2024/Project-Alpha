package net.one97.paytm.recharge.legacy.ordersummary.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseRechargeInvoiceAndUtilityOptionsView;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;

public class b extends net.one97.paytm.recharge.ordersummary.d.a implements View.OnClickListener {

    /* renamed from: i  reason: collision with root package name */
    public static final a f63018i = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public Rect f63019a;

    /* renamed from: b  reason: collision with root package name */
    public View f63020b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63021c;

    /* renamed from: d  reason: collision with root package name */
    protected LinearLayout f63022d;

    /* renamed from: e  reason: collision with root package name */
    protected CJROrderedCart f63023e;

    /* renamed from: f  reason: collision with root package name */
    protected net.one97.paytm.recharge.common.h.f f63024f;

    /* renamed from: g  reason: collision with root package name */
    protected net.one97.paytm.recharge.ordersummary.b.a f63025g;

    /* renamed from: h  reason: collision with root package name */
    CJRBaseRechargeInvoiceAndUtilityOptionsView f63026h;
    /* access modifiers changed from: private */
    public View j;
    /* access modifiers changed from: private */
    public View k;
    /* access modifiers changed from: private */
    public boolean p;
    private HashMap q;

    public View a(int i2) {
        if (this.q == null) {
            this.q = new HashMap();
        }
        View view = (View) this.q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void b() {
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63030a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f63031b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f63032c;

        d(b bVar, ArrayList arrayList, ArrayList arrayList2) {
            this.f63030a = bVar;
            this.f63031b = arrayList;
            this.f63032c = arrayList2;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            RecyclerView.a adapter;
            RecyclerView recyclerView;
            RecyclerView.a adapter2;
            int i2 = 0;
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                this.f63031b.add(0, Integer.valueOf(R.drawable.order_history_bill_reminder));
                ArrayList arrayList = this.f63032c;
                Context context = this.f63030a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                arrayList.add(0, context.getString(R.string.extra_option_set_bill_reminder));
                CJRBaseRechargeInvoiceAndUtilityOptionsView cJRBaseRechargeInvoiceAndUtilityOptionsView = this.f63030a.f63026h;
                if (cJRBaseRechargeInvoiceAndUtilityOptionsView != null && (recyclerView = cJRBaseRechargeInvoiceAndUtilityOptionsView.f63074a) != null && (adapter2 = recyclerView.getAdapter()) != null) {
                    adapter2.notifyDataSetChanged();
                    return;
                }
                return;
            }
            CJRBaseRechargeInvoiceAndUtilityOptionsView cJRBaseRechargeInvoiceAndUtilityOptionsView2 = this.f63030a.f63026h;
            if (cJRBaseRechargeInvoiceAndUtilityOptionsView2 != null) {
                Context context2 = this.f63030a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                String string = context2.getString(R.string.extra_option_set_bill_reminder);
                kotlin.g.b.k.a((Object) string, "context!!.getString(R.st…option_set_bill_reminder)");
                kotlin.g.b.k.c(string, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                try {
                    if (cJRBaseRechargeInvoiceAndUtilityOptionsView2.f63075b != null) {
                        List<String> list = cJRBaseRechargeInvoiceAndUtilityOptionsView2.f63075b;
                        if (list == null) {
                            kotlin.g.b.k.a();
                        }
                        int size = list.size();
                        if (size >= 0) {
                            while (!string.equals(cJRBaseRechargeInvoiceAndUtilityOptionsView2.f63075b.get(i2))) {
                                if (i2 != size) {
                                    i2++;
                                } else {
                                    return;
                                }
                            }
                            if (cJRBaseRechargeInvoiceAndUtilityOptionsView2.f63075b instanceof ArrayList) {
                                ((ArrayList) cJRBaseRechargeInvoiceAndUtilityOptionsView2.f63075b).remove(i2);
                            }
                            RecyclerView recyclerView2 = cJRBaseRechargeInvoiceAndUtilityOptionsView2.f63074a;
                            if (recyclerView2 != null && (adapter = recyclerView2.getAdapter()) != null) {
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final CJROrderedCart c() {
        CJROrderedCart cJROrderedCart = this.f63023e;
        if (cJROrderedCart == null) {
            kotlin.g.b.k.a("orderedCart");
        }
        return cJROrderedCart;
    }

    /* access modifiers changed from: protected */
    public final void d(CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(cJROrderedCart, "<set-?>");
        this.f63023e = cJROrderedCart;
    }

    public final net.one97.paytm.recharge.ordersummary.b.a d() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63025g;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_success_recharge_order_summary, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        if (this.l instanceof AJRechargeOrderSummaryActivity) {
            CJRRechargeUtilities.INSTANCE.debugLog("FJRSuccessRechargeOrderSummaryFragment get viewModel from Activity");
            AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
            if (aJRechargeOrderSummaryActivity != null) {
                this.f63025g = aJRechargeOrderSummaryActivity.l();
                net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63025g;
                if (aVar == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                this.n = aVar.f63998b;
                net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63025g;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                CJROrderedCart u = aVar2.u();
                if (u == null) {
                    kotlin.g.b.k.a();
                }
                this.f63023e = u;
                CJROrderedCart cJROrderedCart = this.f63023e;
                if (cJROrderedCart == null) {
                    kotlin.g.b.k.a("orderedCart");
                }
                CJROrderSummary cJROrderSummary = this.n;
                String str2 = null;
                cJROrderedCart.setOrderId(cJROrderSummary != null ? cJROrderSummary.getId() : null);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    kotlin.g.b.k.a((Object) activity, "it");
                    Context applicationContext = activity.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext, "it.applicationContext");
                    this.f63024f = (net.one97.paytm.recharge.common.h.f) am.a(activity, (al.b) new net.one97.paytm.recharge.common.h.a(net.one97.paytm.recharge.common.b.d.b(applicationContext), net.one97.paytm.recharge.common.b.d.d(activity))).a(net.one97.paytm.recharge.common.h.f.class);
                }
                e();
                if (getView() != null) {
                    View view = getView();
                    if (view == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) view, "view!!");
                    a(view, bundle);
                }
                if (getActivity() != null) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f63025g;
                    if (aVar3 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    if (aVar3.s) {
                        CJROrderedCart cJROrderedCart2 = this.f63023e;
                        if (cJROrderedCart2 == null) {
                            kotlin.g.b.k.a("orderedCart");
                        }
                        if (p.a("7", cJROrderedCart2.getItemStatus(), true)) {
                            net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.f63025g;
                            if (aVar4 == null) {
                                kotlin.g.b.k.a("viewModel");
                            }
                            if (!aVar4.f64004h) {
                                CJROrderSummary cJROrderSummary2 = this.n;
                                if (!TextUtils.isEmpty(cJROrderSummary2 != null ? cJROrderSummary2.getId() : null)) {
                                    try {
                                        SFInterface sFInterface = SFInterface.INSTANCE;
                                        CJROrderSummary cJROrderSummary3 = this.n;
                                        if (cJROrderSummary3 == null || (str = cJROrderSummary3.getId()) == null) {
                                            str = "";
                                        }
                                        sFInterface.notifySuccessTransaction(str);
                                        net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.f63025g;
                                        if (aVar5 == null) {
                                            kotlin.g.b.k.a("viewModel");
                                        }
                                        aVar5.f64004h = true;
                                        StringBuilder sb = new StringBuilder("OrderId -> ");
                                        CJROrderSummary cJROrderSummary4 = this.n;
                                        if (cJROrderSummary4 != null) {
                                            str2 = cJROrderSummary4.getId();
                                        }
                                        sb.append(str2);
                                        q.d(sb.toString());
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
            }
        } else {
            CJRRechargeUtilities.INSTANCE.debugLog("FJRSuccessRechargeOrderSummaryFragment no implementation to get viewModel: Default returning to home");
            AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity2 = this.l;
            if (aJRechargeOrderSummaryActivity2 != null) {
                aJRechargeOrderSummaryActivity2.c(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (getContext() instanceof net.one97.paytm.recharge.ordersummary.f.n) {
            Context context = getContext();
            if (context != null) {
                ((net.one97.paytm.recharge.ordersummary.f.n) context).a(this);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharableScreen");
            }
        }
        if (getContext() instanceof AJRechargeOrderSummaryActivity) {
            Context context2 = getContext();
            if (context2 != null) {
                AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = (AJRechargeOrderSummaryActivity) context2;
                aJRechargeOrderSummaryActivity.a(0);
                aJRechargeOrderSummaryActivity.b();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view, Bundle bundle) {
        String str;
        CJROrderedCart cJROrderedCart;
        kotlin.g.b.k.c(view, "view");
        View findViewById = view.findViewById(R.id.container_details);
        if (findViewById != null) {
            this.f63022d = (LinearLayout) findViewById;
            if (view.findViewById(R.id.container_details) != null) {
                View findViewById2 = view.findViewById(R.id.logo);
                String str2 = null;
                if (!(findViewById2 instanceof CJRCircleImageViewV8)) {
                    findViewById2 = null;
                }
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) findViewById2;
                View findViewById3 = view.findViewById(R.id.img_default);
                if (!(findViewById3 instanceof ImageView)) {
                    findViewById3 = null;
                }
                ImageView imageView = (ImageView) findViewById3;
                View findViewById4 = view.findViewById(R.id.txt_recharge_status);
                if (findViewById4 != null) {
                    TextView textView = (TextView) findViewById4;
                    View findViewById5 = view.findViewById(R.id.txt_recharge_amount);
                    if (findViewById5 != null) {
                        TextView textView2 = (TextView) findViewById5;
                        View findViewById6 = view.findViewById(R.id.txt_order_date_time);
                        if (findViewById6 != null) {
                            TextView textView3 = (TextView) findViewById6;
                            CJROrderSummary cJROrderSummary = this.n;
                            if (cJROrderSummary == null) {
                                kotlin.g.b.k.a();
                            }
                            ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
                            if (orderedCartList == null) {
                                kotlin.g.b.k.a();
                            }
                            CJROrderedCart cJROrderedCart2 = orderedCartList.get(0);
                            CJROrderSummaryProductDetail productDetail = cJROrderedCart2 != null ? cJROrderedCart2.getProductDetail() : null;
                            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63025g;
                            if (aVar == null) {
                                kotlin.g.b.k.a("viewModel");
                            }
                            kotlin.g.b.k.a((Object) cJROrderedCart2, "orderedCart");
                            String c2 = aVar.c(cJROrderedCart2);
                            if (!TextUtils.isEmpty(c2)) {
                                if (cJRCircleImageViewV8 != null) {
                                    cJRCircleImageViewV8.setVisibility(0);
                                }
                                if (imageView != null) {
                                    imageView.setVisibility(8);
                                }
                                try {
                                    w.a().a(c2).a((ImageView) cJRCircleImageViewV8);
                                } catch (Exception unused) {
                                }
                            } else if (!com.paytm.utility.b.c(getContext())) {
                                if (cJRCircleImageViewV8 != null) {
                                    cJRCircleImageViewV8.setVisibility(8);
                                }
                                if (imageView != null) {
                                    imageView.setVisibility(8);
                                }
                            }
                            textView.setText(a(productDetail));
                            int i2 = R.string.rupee_re;
                            Object[] objArr = new Object[1];
                            ArrayList<CJROrderedCart> orderedCartList2 = k().getOrderedCartList();
                            if (orderedCartList2 == null || (cJROrderedCart = orderedCartList2.get(0)) == null || (str = cJROrderedCart.getAggregateItemPrice()) == null) {
                                str = "";
                            }
                            objArr[0] = com.paytm.utility.b.x(str);
                            textView2.setText(getString(i2, objArr));
                            CJROrderSummary cJROrderSummary2 = this.n;
                            if (cJROrderSummary2 != null) {
                                str2 = cJROrderSummary2.getCreatedAt();
                            }
                            String a2 = ab.a(str2, "hh:mm a, dd MMM yyyy");
                            kotlin.g.b.k.a((Object) a2, "CJRRechargeUtilityConsta…E_ORDER_DATE_TIME_FORMAT)");
                            textView3.setText(p.a(p.a(a2, "PM", "pm", false), "AM", "am", false));
                            c(view);
                            b(view);
                            a(view);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63042a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ScrollView f63043b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f63044c;

        h(b bVar, ScrollView scrollView, View view) {
            this.f63042a = bVar;
            this.f63043b = scrollView;
            this.f63044c = view;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver = this.f63043b.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            this.f63042a.f63019a = new Rect();
            this.f63043b.getHitRect(this.f63042a.f63019a);
            int[] iArr = {0, 0};
            this.f63043b.getLocationOnScreen(iArr);
            Rect rect = this.f63042a.f63019a;
            if (rect != null) {
                rect.left = iArr[0];
            }
            Rect rect2 = this.f63042a.f63019a;
            if (rect2 != null) {
                rect2.top = iArr[1];
            }
            this.f63042a.f(this.f63044c);
            b bVar = this.f63042a;
            ViewGroup viewGroup = this.f63043b;
            Rect rect3 = bVar.f63019a;
            if (rect3 == null) {
                kotlin.g.b.k.a();
            }
            bVar.k = b.a(viewGroup, rect3);
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        CardView cardView;
        kotlin.g.b.k.c(view, "view");
        ScrollView scrollView = (ScrollView) view;
        ViewTreeObserver viewTreeObserver = scrollView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new h(this, scrollView, view));
        }
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new i(this, (TextView) view.findViewById(R.id.txt_recharge_status)));
        View view2 = this.j;
        if (view2 != null && (cardView = (CardView) view2.findViewById(R.id.container_btn)) != null) {
            cardView.setOnClickListener(new j(this, scrollView));
        }
    }

    static final class i implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63045a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f63046b;

        i(b bVar, TextView textView) {
            this.f63045a = bVar;
            this.f63046b = textView;
        }

        public final void onScrollChanged() {
            if (this.f63045a.f63019a != null) {
                if (!this.f63046b.getLocalVisibleRect(this.f63045a.f63019a) && !this.f63045a.f63021c) {
                    b bVar = this.f63045a;
                    bVar.f63021c = true;
                    View view = bVar.f63020b;
                    if (view == null) {
                        kotlin.g.b.k.a();
                    }
                    bVar.g(view);
                } else if (this.f63046b.getLocalVisibleRect(this.f63045a.f63019a) && this.f63045a.f63021c) {
                    b bVar2 = this.f63045a;
                    bVar2.f63021c = false;
                    View view2 = bVar2.f63020b;
                    if (view2 == null) {
                        kotlin.g.b.k.a();
                    }
                    bVar2.h(view2);
                }
                if (this.f63045a.j != null) {
                    LinearLayout linearLayout = this.f63045a.f63022d;
                    if (linearLayout == null) {
                        kotlin.g.b.k.a();
                    }
                    ViewGroup viewGroup = linearLayout;
                    Rect rect = this.f63045a.f63019a;
                    if (rect == null) {
                        kotlin.g.b.k.a();
                    }
                    if (b.c(viewGroup, rect) == null) {
                        b bVar3 = this.f63045a;
                        bVar3.d(bVar3.j);
                        return;
                    }
                    b bVar4 = this.f63045a;
                    bVar4.e(bVar4.j);
                }
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63047a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ScrollView f63048b;

        j(b bVar, ScrollView scrollView) {
            this.f63047a = bVar;
            this.f63048b = scrollView;
        }

        public final void onClick(final View view) {
            kotlin.g.b.k.a((Object) view, "v");
            view.setEnabled(false);
            view.postDelayed(new Runnable() {
                public final void run() {
                    View view = view;
                    kotlin.g.b.k.a((Object) view, "v");
                    view.setEnabled(true);
                }
            }, 200);
            int[] iArr = {0, 0};
            View a2 = this.f63047a.k;
            if (a2 != null) {
                a2.getLocationOnScreen(iArr);
            }
            this.f63048b.smoothScrollTo(0, iArr[1]);
        }
    }

    /* JADX WARNING: type inference failed for: r2v28, types: [android.view.View] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.view.View r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "view"
            kotlin.g.b.k.c(r1, r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f63023e
            java.lang.String r3 = "orderedCart"
            if (r2 != 0) goto L_0x0012
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0012:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r6 = "options"
            kotlin.g.b.k.c(r4, r6)
            java.lang.String r7 = "optionIcons"
            kotlin.g.b.k.c(r5, r7)
            net.one97.paytm.recharge.common.h.f r8 = r0.f63024f
            if (r8 == 0) goto L_0x003d
            androidx.lifecycle.y<java.lang.Boolean> r8 = r8.f61442e
            androidx.lifecycle.LiveData r8 = (androidx.lifecycle.LiveData) r8
            if (r8 == 0) goto L_0x003d
            r9 = r0
            androidx.lifecycle.q r9 = (androidx.lifecycle.q) r9
            net.one97.paytm.recharge.legacy.ordersummary.a.b$d r10 = new net.one97.paytm.recharge.legacy.ordersummary.a.b$d
            r10.<init>(r0, r5, r4)
            androidx.lifecycle.z r10 = (androidx.lifecycle.z) r10
            r8.observe(r9, r10)
        L_0x003d:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = r0.f63023e
            if (r8 != 0) goto L_0x0044
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0044:
            java.lang.String r8 = r0.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r8)
            int r9 = net.one97.paytm.recharge.R.drawable.ic_recharge_another_recharge
            r10 = r8
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r11 = 0
            if (r10 == 0) goto L_0x0059
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r10 = 0
            goto L_0x005a
        L_0x0059:
            r10 = 1
        L_0x005a:
            if (r10 != 0) goto L_0x006b
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r5.add(r9)
            if (r8 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            r4.add(r8)
        L_0x006b:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r0.n
            r9 = 0
            if (r8 == 0) goto L_0x0097
            java.util.ArrayList r8 = r8.getOrderedCartList()
            if (r8 == 0) goto L_0x0097
            java.lang.Object r8 = r8.get(r11)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8
            if (r8 == 0) goto L_0x0097
            java.util.ArrayList r8 = r8.getAction()
            if (r8 == 0) goto L_0x0097
            java.lang.Object r8 = r8.get(r11)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8
            if (r8 == 0) goto L_0x0097
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r8 = r8.getUrlParams()
            if (r8 == 0) goto L_0x0097
            java.lang.String r8 = r8.getUrl()
            goto L_0x0098
        L_0x0097:
            r8 = r9
        L_0x0098:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x00bb
            int r8 = net.one97.paytm.recharge.R.drawable.ic_recharge_download_invoice
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r5.add(r8)
            android.content.Context r8 = r18.getContext()
            if (r8 != 0) goto L_0x00b2
            kotlin.g.b.k.a()
        L_0x00b2:
            int r10 = net.one97.paytm.recharge.R.string.download_invoice
            java.lang.String r8 = r8.getString(r10)
            r4.add(r8)
        L_0x00bb:
            android.content.Context r8 = r18.getContext()
            if (r8 != 0) goto L_0x00c4
            kotlin.g.b.k.a()
        L_0x00c4:
            java.lang.String r10 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            net.one97.paytm.recharge.legacy.ordersummary.a.b$c r12 = new net.one97.paytm.recharge.legacy.ordersummary.a.b$c
            r12.<init>(r0, r2)
            android.view.View$OnClickListener r12 = (android.view.View.OnClickListener) r12
            java.lang.String r2 = "context"
            kotlin.g.b.k.c(r8, r2)
            kotlin.g.b.k.c(r4, r6)
            kotlin.g.b.k.c(r5, r7)
            java.lang.String r2 = "optionsViewOnClickListener"
            kotlin.g.b.k.c(r12, r2)
            android.widget.LinearLayout r2 = r0.f63022d
            if (r2 == 0) goto L_0x00f4
            net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseRechargeInvoiceAndUtilityOptionsView r6 = new net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseRechargeInvoiceAndUtilityOptionsView
            java.util.List r4 = (java.util.List) r4
            java.util.List r5 = (java.util.List) r5
            r6.<init>(r8, r4, r5, r12)
            r0.f63026h = r6
            android.view.View r6 = (android.view.View) r6
            r2.addView(r6)
        L_0x00f4:
            android.widget.LinearLayout r2 = r0.f63022d
            java.lang.String r4 = "viewModel"
            if (r2 == 0) goto L_0x0123
            net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseRechargeOrderPaymentDetailsView r5 = new net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseRechargeOrderPaymentDetailsView
            android.content.Context r13 = r18.getContext()
            if (r13 != 0) goto L_0x0105
            kotlin.g.b.k.a()
        L_0x0105:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r10)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r0.f63025g
            if (r14 != 0) goto L_0x010f
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x010f:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r15 = r0.f63023e
            if (r15 != 0) goto L_0x0116
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0116:
            r16 = 1
            r17 = 1
            r12 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            android.view.View r5 = (android.view.View) r5
            r2.addView(r5)
        L_0x0123:
            android.widget.LinearLayout r2 = r0.f63022d
            if (r2 == 0) goto L_0x0151
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r5 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r13 = r18.getContext()
            if (r13 != 0) goto L_0x0132
            kotlin.g.b.k.a()
        L_0x0132:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r10)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r0.f63025g
            if (r14 != 0) goto L_0x013c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x013c:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r6 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r15 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.l
            r16 = 2
            r17 = r0
            net.one97.paytm.recharge.ordersummary.f.b r17 = (net.one97.paytm.recharge.ordersummary.f.b) r17
            r12 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            android.view.View r5 = (android.view.View) r5
            r2.addView(r5)
        L_0x0151:
            android.widget.LinearLayout r2 = r0.f63022d
            if (r2 == 0) goto L_0x017f
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r5 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r13 = r18.getContext()
            if (r13 != 0) goto L_0x0160
            kotlin.g.b.k.a()
        L_0x0160:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r10)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r0.f63025g
            if (r14 != 0) goto L_0x016a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x016a:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r6 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r15 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.m
            r16 = 2
            r17 = r0
            net.one97.paytm.recharge.ordersummary.f.b r17 = (net.one97.paytm.recharge.ordersummary.f.b) r17
            r12 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            android.view.View r5 = (android.view.View) r5
            r2.addView(r5)
        L_0x017f:
            android.widget.LinearLayout r2 = r0.f63022d
            if (r2 != 0) goto L_0x0186
            kotlin.g.b.k.a()
        L_0x0186:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r5 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r13 = r18.getContext()
            if (r13 != 0) goto L_0x0191
            kotlin.g.b.k.a()
        L_0x0191:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r10)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r0.f63025g
            if (r14 != 0) goto L_0x019b
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x019b:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r6 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r15 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.k
            r16 = 2
            r17 = r0
            net.one97.paytm.recharge.ordersummary.f.b r17 = (net.one97.paytm.recharge.ordersummary.f.b) r17
            r12 = r5
            r12.<init>(r13, r14, r15, r16, r17)
            android.view.View r5 = (android.view.View) r5
            r2.addView(r5)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f63025g
            if (r2 != 0) goto L_0x01b7
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01b7:
            boolean r2 = r2.s
            if (r2 == 0) goto L_0x02e0
            android.widget.LinearLayout r2 = r0.f63022d
            if (r2 == 0) goto L_0x01e8
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView r5 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView
            androidx.fragment.app.FragmentActivity r6 = r18.getActivity()
            if (r6 != 0) goto L_0x01ca
            kotlin.g.b.k.a()
        L_0x01ca:
            java.lang.String r7 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.recharge.ordersummary.b.a r7 = r0.f63025g
            if (r7 != 0) goto L_0x01d6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01d6:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r0.f63023e
            if (r4 != 0) goto L_0x01dd
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x01dd:
            r3 = r0
            net.one97.paytm.recharge.ordersummary.f.e r3 = (net.one97.paytm.recharge.ordersummary.f.e) r3
            r5.<init>(r6, r7, r4, r3)
            android.view.View r5 = (android.view.View) r5
            r2.addView(r5)
        L_0x01e8:
            java.lang.String r2 = "rootView"
            kotlin.g.b.k.c(r1, r2)
            androidx.fragment.app.FragmentActivity r1 = r18.getActivity()
            if (r1 == 0) goto L_0x0206
            android.view.Window r1 = r1.getWindow()
            if (r1 == 0) goto L_0x0206
            android.view.View r1 = r1.getDecorView()
            if (r1 == 0) goto L_0x0206
            int r2 = net.one97.paytm.recharge.R.id.container_view_details
            android.view.View r1 = r1.findViewById(r2)
            goto L_0x0207
        L_0x0206:
            r1 = r9
        L_0x0207:
            r0.j = r1
            android.view.View r1 = r0.j
            if (r1 != 0) goto L_0x02e0
            android.content.Context r1 = r18.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = net.one97.paytm.recharge.R.layout.content_btn_view_details_order_summary
            android.view.View r1 = r1.inflate(r2, r9)
            r0.j = r1
            android.view.View r1 = r0.j
            if (r1 == 0) goto L_0x022a
            int r2 = net.one97.paytm.recharge.R.id.container_view_details
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.setTag(r2)
        L_0x022a:
            android.view.View r1 = r0.j
            if (r1 == 0) goto L_0x0233
            r2 = 8
            r1.setVisibility(r2)
        L_0x0233:
            r0.p = r11
            android.view.View r1 = r0.j
            if (r1 == 0) goto L_0x0242
            int r2 = net.one97.paytm.recharge.R.id.img_view_details
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x0243
        L_0x0242:
            r1 = r9
        L_0x0243:
            if (r1 == 0) goto L_0x02d8
            net.one97.paytm.recharge.di.helper.c r1 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r1 = net.one97.paytm.recharge.di.helper.c.aV()
            if (r1 == 0) goto L_0x026a
            android.view.View r2 = r0.j
            if (r2 == 0) goto L_0x025a
            int r3 = net.one97.paytm.recharge.R.id.txt_view_details
            android.view.View r2 = r2.findViewById(r3)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
        L_0x025a:
            if (r9 == 0) goto L_0x0262
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r9.setText(r1)
            goto L_0x026a
        L_0x0262:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.TextView"
            r1.<init>(r2)
            throw r1
        L_0x026a:
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            androidx.fragment.app.FragmentActivity r2 = r18.getActivity()
            if (r2 == 0) goto L_0x0284
            android.view.WindowManager r2 = r2.getWindowManager()
            if (r2 == 0) goto L_0x0284
            android.view.Display r2 = r2.getDefaultDisplay()
            if (r2 == 0) goto L_0x0284
            r2.getMetrics(r1)
        L_0x0284:
            androidx.fragment.app.FragmentActivity r2 = r18.getActivity()
            if (r2 == 0) goto L_0x0296
            android.view.View r3 = r0.j
            android.view.ViewGroup$LayoutParams r4 = new android.view.ViewGroup$LayoutParams
            r5 = -1
            r6 = -2
            r4.<init>(r5, r6)
            r2.addContentView(r3, r4)
        L_0x0296:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r11)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r11)
            android.view.View r4 = r0.j
            if (r4 == 0) goto L_0x02a5
            r4.measure(r2, r3)
        L_0x02a5:
            android.view.View r2 = r0.j
            if (r2 == 0) goto L_0x02ad
            r3 = 0
            r2.setX(r3)
        L_0x02ad:
            android.view.View r2 = r0.j
            if (r2 == 0) goto L_0x02c7
            int r1 = r1.heightPixels
            r3 = 48
            int r3 = com.paytm.utility.b.c((int) r3)
            int r1 = r1 - r3
            android.view.View r3 = r0.j
            if (r3 == 0) goto L_0x02c2
            int r11 = r3.getMeasuredHeight()
        L_0x02c2:
            int r1 = r1 - r11
            float r1 = (float) r1
            r2.setY(r1)
        L_0x02c7:
            android.view.View r1 = r0.j
            if (r1 == 0) goto L_0x02e0
            net.one97.paytm.recharge.legacy.ordersummary.a.b$l r2 = new net.one97.paytm.recharge.legacy.ordersummary.a.b$l
            r2.<init>(r0)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r3 = 200(0xc8, double:9.9E-322)
            r1.postDelayed(r2, r3)
            goto L_0x02e0
        L_0x02d8:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.ImageView"
            r1.<init>(r2)
            throw r1
        L_0x02e0:
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 == 0) goto L_0x02fa
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargeFooterPaytmTrustView r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargeFooterPaytmTrustView
            android.content.Context r3 = r18.getContext()
            if (r3 != 0) goto L_0x02ef
            kotlin.g.b.k.a()
        L_0x02ef:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r10)
            r2.<init>(r3)
            android.view.View r2 = (android.view.View) r2
            r1.addView(r2)
        L_0x02fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.b(android.view.View):void");
    }

    public void onResume() {
        super.onResume();
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.l;
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.d();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r3 = r3.getOrderedCartList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(android.view.View r14) {
        /*
            r13 = this;
            java.lang.String r0 = "rootView"
            kotlin.g.b.k.c(r14, r0)
            int r0 = net.one97.paytm.recharge.R.id.container_details
            android.view.View r0 = r14.findViewById(r0)
            if (r0 == 0) goto L_0x0186
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r1 = net.one97.paytm.recharge.R.id.img_recharge_amount
            android.view.View r1 = r14.findViewById(r1)
            if (r1 == 0) goto L_0x017e
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r2 = net.one97.paytm.recharge.R.id.txt_recharge_number
            android.view.View r2 = r14.findViewById(r2)
            java.lang.String r3 = "null cannot be cast to non-null type android.widget.TextView"
            if (r2 == 0) goto L_0x0178
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r4 = net.one97.paytm.recharge.R.id.txt_recharge_operator
            android.view.View r4 = r14.findViewById(r4)
            if (r4 == 0) goto L_0x0172
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = net.one97.paytm.recharge.R.id.txt_help
            android.view.View r14 = r14.findViewById(r5)
            if (r14 == 0) goto L_0x016c
            android.widget.TextView r14 = (android.widget.TextView) r14
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r13.n
            r5 = 0
            if (r3 == 0) goto L_0x004b
            java.util.ArrayList r3 = r3.getOrderedCartList()
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r3.get(r5)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            android.text.SpannableString r6 = r13.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
            int r2 = net.one97.paytm.recharge.R.string.recharge_operator
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.String r3 = r13.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)
            r7[r5] = r3
            r3 = 1
            java.lang.String r8 = ""
            r7[r3] = r8
            java.lang.String r2 = r13.getString(r2, r7)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setText(r2)
            net.one97.paytm.recharge.legacy.ordersummary.a.b$k r2 = new net.one97.paytm.recharge.legacy.ordersummary.a.b$k
            r2.<init>(r13)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r14.setOnClickListener(r2)
            android.view.View r1 = (android.view.View) r1
            android.view.View r14 = (android.view.View) r14
            r2 = 8
            r1.setVisibility(r2)
            r2 = 4
            r14.setVisibility(r2)
            r0.setVisibility(r2)
            r2 = 3
            android.animation.PropertyValuesHolder[] r4 = new android.animation.PropertyValuesHolder[r2]
            android.util.Property r7 = android.view.View.ALPHA
            float[] r8 = new float[r6]
            r8 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r7 = android.animation.PropertyValuesHolder.ofFloat(r7, r8)
            r4[r5] = r7
            android.util.Property r7 = android.view.View.SCALE_X
            float[] r8 = new float[r6]
            r8 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r7 = android.animation.PropertyValuesHolder.ofFloat(r7, r8)
            r4[r3] = r7
            android.util.Property r7 = android.view.View.SCALE_Y
            float[] r8 = new float[r6]
            r8 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r7 = android.animation.PropertyValuesHolder.ofFloat(r7, r8)
            r4[r6] = r7
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r1, r4)
            java.lang.String r7 = "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            android.view.animation.BounceInterpolator r8 = new android.view.animation.BounceInterpolator
            r8.<init>()
            android.animation.TimeInterpolator r8 = (android.animation.TimeInterpolator) r8
            r4.setInterpolator(r8)
            r8 = 1000(0x3e8, double:4.94E-321)
            r4.setDuration(r8)
            android.animation.PropertyValuesHolder[] r8 = new android.animation.PropertyValuesHolder[r2]
            android.util.Property r9 = android.view.View.ALPHA
            float[] r10 = new float[r6]
            r10 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofFloat(r9, r10)
            r8[r5] = r9
            android.util.Property r9 = android.view.View.SCALE_X
            float[] r10 = new float[r6]
            r10 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofFloat(r9, r10)
            r8[r3] = r9
            android.util.Property r9 = android.view.View.SCALE_Y
            float[] r10 = new float[r6]
            r10 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r9 = android.animation.PropertyValuesHolder.ofFloat(r9, r10)
            r8[r6] = r9
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r14, r8)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            android.view.animation.AccelerateDecelerateInterpolator r9 = new android.view.animation.AccelerateDecelerateInterpolator
            r9.<init>()
            android.animation.TimeInterpolator r9 = (android.animation.TimeInterpolator) r9
            r8.setInterpolator(r9)
            r9 = 700(0x2bc, double:3.46E-321)
            r8.setDuration(r9)
            android.animation.PropertyValuesHolder[] r2 = new android.animation.PropertyValuesHolder[r2]
            android.util.Property r11 = android.view.View.ALPHA
            float[] r12 = new float[r6]
            r12 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r11 = android.animation.PropertyValuesHolder.ofFloat(r11, r12)
            r2[r5] = r11
            android.util.Property r5 = android.view.View.SCALE_X
            float[] r11 = new float[r6]
            r11 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r5 = android.animation.PropertyValuesHolder.ofFloat(r5, r11)
            r2[r3] = r5
            android.util.Property r3 = android.view.View.SCALE_Y
            float[] r5 = new float[r6]
            r5 = {0, 1065353216} // fill-array
            android.animation.PropertyValuesHolder r3 = android.animation.PropertyValuesHolder.ofFloat(r3, r5)
            r2[r6] = r3
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r0, r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            android.view.animation.AccelerateDecelerateInterpolator r3 = new android.view.animation.AccelerateDecelerateInterpolator
            r3.<init>()
            android.animation.TimeInterpolator r3 = (android.animation.TimeInterpolator) r3
            r2.setInterpolator(r3)
            r2.setDuration(r9)
            android.animation.AnimatorSet r3 = new android.animation.AnimatorSet
            r3.<init>()
            net.one97.paytm.recharge.legacy.ordersummary.a.b$e r5 = new net.one97.paytm.recharge.legacy.ordersummary.a.b$e
            r5.<init>(r13, r1, r14, r0)
            android.animation.Animator$AnimatorListener r5 = (android.animation.Animator.AnimatorListener) r5
            r3.addListener(r5)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r4)
            r14.add(r8)
            r14.add(r2)
            java.util.Collection r14 = (java.util.Collection) r14
            r3.playTogether(r14)
            r3.start()
            return
        L_0x016c:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r3)
            throw r14
        L_0x0172:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r3)
            throw r14
        L_0x0178:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r3)
            throw r14
        L_0x017e:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.ImageView"
            r14.<init>(r0)
            throw r14
        L_0x0186:
            kotlin.u r14 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.LinearLayout"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.c(android.view.View):void");
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63050a;

        k(b bVar) {
            this.f63050a = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
            r1 = r1.getOrderedCartList();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r4) {
            /*
                r3 = this;
                net.one97.paytm.recharge.legacy.ordersummary.a.b r0 = r3.f63050a     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                java.lang.String r1 = "v"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                net.one97.paytm.recharge.legacy.ordersummary.a.b r1 = r3.f63050a     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r1.n     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                if (r1 == 0) goto L_0x001d
                java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                if (r1 == 0) goto L_0x001d
                r2 = 0
                java.lang.Object r1 = r1.get(r2)     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                goto L_0x001e
            L_0x001d:
                r1 = 0
            L_0x001e:
                r0.a((android.view.View) r4, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ NullPointerException -> 0x0030, IndexOutOfBoundsException -> 0x0022 }
                return
            L_0x0022:
                r4 = move-exception
                java.lang.Class<net.one97.paytm.recharge.legacy.ordersummary.a.b> r0 = net.one97.paytm.recharge.legacy.ordersummary.a.b.class
                r0.getName()
                java.lang.String r4 = r4.getMessage()
                com.paytm.utility.q.b(r4)
                return
            L_0x0030:
                r4 = move-exception
                java.lang.Class<net.one97.paytm.recharge.legacy.ordersummary.a.b> r0 = net.one97.paytm.recharge.legacy.ordersummary.a.b.class
                r0.getName()
                java.lang.String r4 = r4.getMessage()
                com.paytm.utility.q.b(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.k.onClick(android.view.View):void");
        }
    }

    /* access modifiers changed from: protected */
    public String a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        String str;
        CJRAttributes attributes;
        int i2 = R.string.recharge_order_status_success;
        Object[] objArr = new Object[1];
        if (cJROrderSummaryProductDetail == null || (attributes = cJROrderSummaryProductDetail.getAttributes()) == null || (str = attributes.getPayTypeDisplayLabel()) == null) {
            str = "";
        }
        objArr[0] = str;
        String string = getString(i2, objArr);
        kotlin.g.b.k.a((Object) string, "getString(R.string.recha…ayTypeDisplayLabel ?: \"\")");
        return string;
    }

    /* access modifiers changed from: protected */
    public SpannableString a(CJROrderedCart cJROrderedCart) {
        String str;
        String str2;
        String str3;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        if (cJROrderedCart == null || (productDetail = cJROrderedCart.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (str = attributes.getOperatorDisplayLabel()) == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = " - ";
        }
        sb.append(str2);
        if (cJROrderedCart == null || (str3 = cJROrderedCart.getRechargeNumber()) == null) {
            str3 = "";
        }
        sb.append(str3);
        return new SpannableString(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r1 = (r1 = (r1 = r1.getProductDetail()).getAttributes()).getOperatorDisplayLabel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(net.one97.paytm.common.entity.shopping.CJROrderedCart r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = r1.getOperatorDisplayLabel()
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            java.lang.String r1 = ""
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.b(net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r5 = (r5 = r5.getProductDetail()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(net.one97.paytm.common.entity.shopping.CJROrderedCart r5) {
        /*
            r4 = this;
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.f63025g
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            boolean r0 = r0.s
            r1 = 1
            java.lang.String r2 = "postpaid"
            r3 = 0
            if (r0 == 0) goto L_0x0047
            if (r5 == 0) goto L_0x0024
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r5.getProductDetail()
            if (r5 == 0) goto L_0x0024
            net.one97.paytm.common.entity.recharge.CJRAttributes r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x0024
            java.lang.String r5 = r5.getPaytype()
            goto L_0x0025
        L_0x0024:
            r5 = r3
        L_0x0025:
            boolean r5 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r1)
            if (r5 == 0) goto L_0x0039
            android.content.Context r5 = r4.getContext()
            if (r5 == 0) goto L_0x0038
            int r0 = net.one97.paytm.recharge.R.string.extra_option_pay_another_bill
            java.lang.String r5 = r5.getString(r0)
            return r5
        L_0x0038:
            return r3
        L_0x0039:
            android.content.Context r5 = r4.getContext()
            if (r5 == 0) goto L_0x0046
            int r0 = net.one97.paytm.recharge.R.string.extra_option_do_another_recharge
            java.lang.String r5 = r5.getString(r0)
            return r5
        L_0x0046:
            return r3
        L_0x0047:
            if (r5 == 0) goto L_0x005a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r5.getProductDetail()
            if (r5 == 0) goto L_0x005a
            net.one97.paytm.common.entity.recharge.CJRAttributes r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x005a
            java.lang.String r5 = r5.getPaytype()
            goto L_0x005b
        L_0x005a:
            r5 = r3
        L_0x005b:
            boolean r5 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r1)
            if (r5 == 0) goto L_0x006f
            android.content.Context r5 = r4.getContext()
            if (r5 == 0) goto L_0x006e
            int r0 = net.one97.paytm.recharge.R.string.extra_option_pay_again
            java.lang.String r5 = r5.getString(r0)
            return r5
        L_0x006e:
            return r3
        L_0x006f:
            android.content.Context r5 = r4.getContext()
            if (r5 == 0) goto L_0x007c
            int r0 = net.one97.paytm.recharge.R.string.extra_option_recharge_again
            java.lang.String r5 = r5.getString(r0)
            return r5
        L_0x007c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.c(net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }

    protected static int f() {
        return R.drawable.ic_recharge_another_recharge;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63028a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f63029b;

        c(b bVar, CJROrderedCart cJROrderedCart) {
            this.f63028a = bVar;
            this.f63029b = cJROrderedCart;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
            r3 = r3.getProductDetail();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r3) {
            /*
                r2 = this;
                java.lang.String r0 = "v"
                kotlin.g.b.k.c(r3, r0)
                int r0 = r3.getId()
                int r1 = net.one97.paytm.recharge.legacy.ordersummary.a.b.f()
                if (r0 != r1) goto L_0x007e
                net.one97.paytm.recharge.legacy.ordersummary.a.b r3 = r2.f63028a
                net.one97.paytm.recharge.ordersummary.b.a r3 = r3.d()
                java.lang.String r0 = "pay_another_bill_clicked"
                java.lang.String r1 = "bottom_nav"
                r3.c((java.lang.String) r0, (java.lang.String) r1)
                net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r2.f63029b
                if (r3 == 0) goto L_0x0030
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r3.getProductDetail()
                if (r3 == 0) goto L_0x0030
                long r0 = r3.getCategoryId()
                java.lang.Long r3 = java.lang.Long.valueOf(r0)
                goto L_0x0031
            L_0x0030:
                r3 = 0
            L_0x0031:
                java.lang.String r3 = java.lang.String.valueOf(r3)
                net.one97.paytm.recharge.legacy.ordersummary.a.b r0 = r2.f63028a
                net.one97.paytm.recharge.ordersummary.b.a r0 = r0.d()
                boolean r0 = r0.s
                if (r0 != 0) goto L_0x0052
                net.one97.paytm.recharge.legacy.ordersummary.a.b r3 = r2.f63028a
                net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r3 = r3.l
                if (r3 == 0) goto L_0x0051
                net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r2.f63029b
                if (r0 != 0) goto L_0x004e
                kotlin.g.b.k.a()
            L_0x004e:
                r3.a(r0, true, true)
            L_0x0051:
                return
            L_0x0052:
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.util.HashMap r0 = r0.getCategoryIdUrl()
                boolean r3 = r0.containsKey(r3)
                r0 = 1
                if (r3 != r0) goto L_0x0072
                net.one97.paytm.recharge.legacy.ordersummary.a.b r3 = r2.f63028a
                net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r3 = r3.l
                if (r3 == 0) goto L_0x0071
                net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r2.f63029b
                if (r0 != 0) goto L_0x006e
                kotlin.g.b.k.a()
            L_0x006e:
                r3.a(r0, true, true)
            L_0x0071:
                return
            L_0x0072:
                net.one97.paytm.recharge.legacy.ordersummary.a.b r3 = r2.f63028a
                net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r3 = r3.l
                if (r3 == 0) goto L_0x007d
                r3.c((boolean) r0)
            L_0x007d:
                return
            L_0x007e:
                int r1 = net.one97.paytm.recharge.R.drawable.order_history_bill_reminder
                if (r0 != r1) goto L_0x009b
                net.one97.paytm.recharge.legacy.ordersummary.a.b r3 = r2.f63028a
                net.one97.paytm.recharge.common.h.f r3 = r3.f63024f
                if (r3 == 0) goto L_0x009a
                net.one97.paytm.recharge.common.utils.j r3 = r3.f61441d
                if (r3 == 0) goto L_0x009a
                net.one97.paytm.recharge.legacy.ordersummary.a.b r0 = r2.f63028a
                androidx.fragment.app.j r0 = r0.getChildFragmentManager()
                java.lang.String r1 = "childFragmentManager"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r3.a(r0)
            L_0x009a:
                return
            L_0x009b:
                net.one97.paytm.recharge.legacy.ordersummary.a.b r0 = r2.f63028a
                net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r2.f63029b
                r0.a((android.view.View) r3, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.c.onClick(android.view.View):void");
        }
    }

    public final void a(View view, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(view, "v");
        super.a(view, cJROrderedCart);
        int id = view.getId();
        if (id == R.id.txt_help || id == R.drawable.ic_help || id == R.id.need_help) {
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63025g;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar.c("help_clicked", (String) null);
        } else if (id == R.drawable.ic_recharge_download_invoice) {
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63025g;
            if (aVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar2.c("download_invoice_clicked", (String) null);
        } else if ((id == R.drawable.ic_book_again || id == R.drawable.ic_recharge_another_recharge) && cJROrderedCart != null) {
            net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f63025g;
            if (aVar3 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            if (!aVar3.a(cJROrderedCart)) {
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.f63025g;
                if (aVar4 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                if (!aVar4.b(cJROrderedCart)) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.f63025g;
                    if (aVar5 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    aVar5.c("pay_another_bill_clicked", "bottom_nav");
                    return;
                }
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.f63025g;
            if (aVar6 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar6.c("try_again_clicked", (String) null);
        }
    }

    /* access modifiers changed from: private */
    public static View c(ViewGroup viewGroup, Rect rect) {
        while (true) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                kotlin.g.b.k.a((Object) childAt, "childView");
                if (childAt.getVisibility() == 0) {
                    if (!childAt.getLocalVisibleRect(rect)) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        if (viewGroup2.getId() == R.id.container_details || viewGroup2.getId() == R.id.container_main) {
                            viewGroup = viewGroup2;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63051a;

        l(b bVar) {
            this.f63051a = bVar;
        }

        public final void run() {
            View b2 = this.f63051a.j;
            View findViewById = b2 != null ? b2.findViewById(R.id.container_btn) : null;
            if (findViewById == null) {
                kotlin.g.b.k.a();
            }
            b.i(findViewById);
        }
    }

    /* renamed from: net.one97.paytm.recharge.legacy.ordersummary.a.b$b  reason: collision with other inner class name */
    public static final class C1218b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f63027a;

        C1218b(View view) {
            this.f63027a = view;
        }

        public final void onAnimationEnd(Animator animator) {
            ObjectAnimator.ofFloat(this.f63027a, View.TRANSLATION_Y, new float[]{0.0f}).start();
        }
    }

    public void d(View view) {
        if (this.j != null && this.p) {
            int[] iArr = {0, 0};
            if (view != null) {
                view.getLocationOnScreen(iArr);
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f})});
            kotlin.g.b.k.a((Object) ofPropertyValuesHolder, "ObjectAnimator.ofPropert….toFloat(), 0.toFloat()))");
            ofPropertyValuesHolder.setDuration(200);
            ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
            ofPropertyValuesHolder.addListener(new g(this, view));
            ofPropertyValuesHolder.start();
        }
    }

    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63040a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63041b;

        g(b bVar, View view) {
            this.f63040a = bVar;
            this.f63041b = view;
        }

        public final void onAnimationStart(Animator animator) {
            this.f63040a.p = false;
        }

        public final void onAnimationEnd(Animator animator) {
            View view = this.f63041b;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public void e(View view) {
        LinearLayout linearLayout;
        if (this.j != null && (linearLayout = this.f63022d) != null && this.f63019a != null && !this.p && !this.f63021c) {
            if (linearLayout == null) {
                kotlin.g.b.k.a();
            }
            ViewGroup viewGroup = linearLayout;
            Rect rect = this.f63019a;
            if (rect == null) {
                kotlin.g.b.k.a();
            }
            if (c(viewGroup, rect) != null) {
                int[] iArr = {0, 0};
                if (view != null) {
                    view.getLocationOnScreen(iArr);
                }
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f})});
                kotlin.g.b.k.a((Object) ofPropertyValuesHolder, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
                ofPropertyValuesHolder.setDuration(200);
                ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
                ofPropertyValuesHolder.addListener(new n(this, view));
                ofPropertyValuesHolder.start();
            }
        }
    }

    public static final class n extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63055b;

        n(b bVar, View view) {
            this.f63054a = bVar;
            this.f63055b = view;
        }

        public final void onAnimationStart(Animator animator) {
            this.f63054a.p = true;
            View view = this.f63055b;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int g() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63025g;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar.a(false);
    }

    /* access modifiers changed from: protected */
    public SpannableString h() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63025g;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        CJROrderedCart cJROrderedCart = this.f63023e;
        if (cJROrderedCart == null) {
            kotlin.g.b.k.a("orderedCart");
        }
        return aVar.a(context, false, cJROrderedCart, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r5 = (r5 = r5.getWindow()).getDecorView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(android.view.View r5) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r5, r0)
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            r0 = 0
            if (r5 == 0) goto L_0x0023
            android.view.Window r5 = r5.getWindow()
            if (r5 == 0) goto L_0x0023
            android.view.View r5 = r5.getDecorView()
            if (r5 == 0) goto L_0x0023
            int r1 = net.one97.paytm.recharge.R.id.txt_banner_recharge_status
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.view.View r5 = r5.findViewWithTag(r1)
            goto L_0x0024
        L_0x0023:
            r5 = r0
        L_0x0024:
            r4.f63020b = r5
            android.content.Context r5 = r4.getContext()
            if (r5 == 0) goto L_0x00bc
            android.view.View r5 = r4.f63020b
            if (r5 != 0) goto L_0x00bc
            android.content.Context r5 = r4.getContext()
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            int r1 = r4.g()
            android.view.View r5 = r5.inflate(r1, r0)
            r4.f63020b = r5
            android.view.View r5 = r4.f63020b
            if (r5 != 0) goto L_0x0049
            kotlin.g.b.k.a()
        L_0x0049:
            int r0 = net.one97.paytm.recharge.R.id.txt_banner_recharge_status
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5.setTag(r0)
            android.view.View r5 = r4.f63020b
            if (r5 != 0) goto L_0x0059
            kotlin.g.b.k.a()
        L_0x0059:
            int r0 = net.one97.paytm.recharge.R.id.txt_banner_recharge_status
            android.view.View r5 = r5.findViewById(r0)
            if (r5 == 0) goto L_0x00b4
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.text.SpannableString r0 = r4.h()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x007e
            android.view.View r0 = r4.f63020b
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            r3 = -2
            r1.<init>(r2, r3)
            r5.addContentView(r0, r1)
        L_0x007e:
            android.view.View r5 = r4.f63020b
            r0 = 0
            if (r5 == 0) goto L_0x0086
            r5.setPivotY(r0)
        L_0x0086:
            android.view.View r5 = r4.f63020b
            if (r5 == 0) goto L_0x008d
            r5.setPivotX(r0)
        L_0x008d:
            android.view.View r5 = r4.f63020b
            if (r5 == 0) goto L_0x009d
            android.graphics.Rect r1 = r4.f63019a
            if (r1 == 0) goto L_0x0099
            int r1 = r1.left
            float r1 = (float) r1
            goto L_0x009a
        L_0x0099:
            r1 = 0
        L_0x009a:
            r5.setX(r1)
        L_0x009d:
            android.view.View r5 = r4.f63020b
            if (r5 == 0) goto L_0x00bc
            android.graphics.Rect r1 = r4.f63019a
            if (r1 == 0) goto L_0x00a8
            int r0 = r1.top
            float r0 = (float) r0
        L_0x00a8:
            r1 = 30
            int r1 = com.paytm.utility.b.c((int) r1)
            float r1 = (float) r1
            float r0 = r0 - r1
            r5.setY(r0)
            return
        L_0x00b4:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.TextView"
            r5.<init>(r0)
            throw r5
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.f(android.view.View):void");
    }

    public void g(View view) {
        kotlin.g.b.k.c(view, "bannerView");
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f})});
        kotlin.g.b.k.a((Object) ofPropertyValuesHolder, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
        ofPropertyValuesHolder.addListener(new m(this, view));
        ofPropertyValuesHolder.start();
    }

    public static final class m extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63052a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63053b;

        m(b bVar, View view) {
            this.f63052a = bVar;
            this.f63053b = view;
        }

        public final void onAnimationStart(Animator animator) {
            this.f63053b.setVisibility(0);
        }

        public final void onAnimationEnd(Animator animator) {
            b bVar = this.f63052a;
            bVar.d(bVar.j);
        }
    }

    public final void h(View view) {
        kotlin.g.b.k.c(view, "bannerView");
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f})});
        kotlin.g.b.k.a((Object) ofPropertyValuesHolder, "ObjectAnimator.ofPropert….toFloat(), 0.toFloat()))");
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
        ofPropertyValuesHolder.addListener(new f(this, view));
        ofPropertyValuesHolder.start();
    }

    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63038a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63039b;

        f(b bVar, View view) {
            this.f63038a = bVar;
            this.f63039b = view;
        }

        public final void onAnimationStart(Animator animator) {
            b bVar = this.f63038a;
            bVar.e(bVar.j);
        }

        public final void onAnimationEnd(Animator animator) {
            this.f63039b.setVisibility(8);
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63033a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f63034b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f63035c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LinearLayout f63036d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ View f63037e = null;

        /* JADX WARNING: type inference failed for: r1v0, types: [net.one97.paytm.recharge.legacy.ordersummary.a.b, android.view.View] */
        /* JADX WARNING: type inference failed for: r4v0, types: [android.widget.LinearLayout, android.view.View] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        e(android.view.View r1, android.view.View r2, android.widget.LinearLayout r3, android.view.View r4) {
            /*
                r0 = this;
                r0.f63033a = r1
                r0.f63034b = r2
                r0.f63035c = r3
                r0.f63036d = r4
                r1 = 0
                r0.f63037e = r1
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.e.<init>(net.one97.paytm.recharge.legacy.ordersummary.a.b, android.view.View, android.view.View, android.widget.LinearLayout):void");
        }

        public final void onAnimationStart(Animator animator) {
            this.f63034b.setVisibility(0);
            this.f63035c.setVisibility(0);
            this.f63036d.setVisibility(0);
            View view = this.f63037e;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.f63033a.f63019a != null) {
                ViewGroup viewGroup = this.f63036d;
                Rect rect = this.f63033a.f63019a;
                if (rect == null) {
                    kotlin.g.b.k.a();
                }
                if (b.c(viewGroup, rect) == null) {
                    b bVar = this.f63033a;
                    bVar.d(bVar.j);
                    return;
                }
            }
            b bVar2 = this.f63033a;
            bVar2.e(bVar2.j);
        }
    }

    public void onClick(View view) {
        String str;
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderedCart cJROrderedCart;
        ArrayList<CJROrderedCart> orderedCartList2;
        CJROrderedCart cJROrderedCart2;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        View view2 = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.share;
        if (valueOf != null && valueOf.intValue() == i2 && (getContext() instanceof net.one97.paytm.recharge.ordersummary.f.n)) {
            CJROrderSummary cJROrderSummary = this.n;
            if (p.a("credit card", (cJROrderSummary == null || (orderedCartList2 = cJROrderSummary.getOrderedCartList()) == null || (cJROrderedCart2 = orderedCartList2.get(0)) == null || (productDetail = cJROrderedCart2.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null) ? null : attributes.getPaytype(), true)) {
                try {
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    net.one97.paytm.recharge.di.helper.b.a(getContext(), "share_clicked", "");
                } catch (Throwable unused) {
                }
            }
            Context context = getContext();
            if (context != null) {
                net.one97.paytm.recharge.ordersummary.f.n nVar = (net.one97.paytm.recharge.ordersummary.f.n) context;
                CJROrderSummary cJROrderSummary2 = this.n;
                if (cJROrderSummary2 == null || (orderedCartList = cJROrderSummary2.getOrderedCartList()) == null || (cJROrderedCart = orderedCartList.get(0)) == null || (str = cJROrderedCart.getName()) == null) {
                    str = "";
                }
                View view3 = getView();
                if (view3 != null) {
                    view2 = view3.findViewById(R.id.container_main);
                }
                nVar.a(str, view2);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharableScreen");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r11.getProductDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.shopping.CJROrderedCart r11, int r12, android.view.ViewGroup r13, android.widget.LinearLayout.LayoutParams r14, net.one97.paytm.recharge.ordersummary.widget.a r15) {
        /*
            r10 = this;
            java.lang.String r0 = "layoutParams"
            kotlin.g.b.k.c(r14, r0)
            if (r11 == 0) goto L_0x0013
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r11.getProductDetail()
            if (r0 == 0) goto L_0x0013
            long r0 = r0.getCategoryId()
            int r1 = (int) r0
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            if (r11 == 0) goto L_0x0026
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r11 = r11.getProductDetail()
            if (r11 == 0) goto L_0x0026
            long r2 = r11.getVerticalId()
            java.lang.String r11 = java.lang.String.valueOf(r2)
            if (r11 != 0) goto L_0x0028
        L_0x0026:
            java.lang.String r11 = ""
        L_0x0028:
            r5 = r11
            int r6 = net.one97.paytm.recharge.common.utils.ba.a((int) r1)
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x00a7
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            androidx.fragment.app.FragmentActivity r3 = r10.getActivity()
            if (r3 != 0) goto L_0x003e
            kotlin.g.b.k.a()
        L_0x003e:
            java.lang.String r11 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r11)
            r4 = 0
            net.one97.paytm.common.entity.shopping.CJROrderSummary r11 = r10.n
            r0 = 0
            if (r11 == 0) goto L_0x004f
            java.lang.String r11 = r11.getId()
            r7 = r11
            goto L_0x0050
        L_0x004f:
            r7 = r0
        L_0x0050:
            if (r15 == 0) goto L_0x0056
            com.paytmmall.clpartifact.widgets.blueprints.SFWidget r11 = r15.f64548a
            r9 = r11
            goto L_0x0057
        L_0x0056:
            r9 = r0
        L_0x0057:
            java.lang.String r8 = "order"
            android.view.View r11 = r2.getPostTxnCashBackView(r3, r4, r5, r6, r7, r8, r9)
            net.one97.paytm.recharge.ordersummary.b.a r15 = r10.f63025g
            java.lang.String r1 = "viewModel"
            if (r15 != 0) goto L_0x0066
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0066:
            boolean r15 = r15.d()
            if (r15 == 0) goto L_0x0076
            if (r11 == 0) goto L_0x0076
            if (r13 == 0) goto L_0x0075
            android.view.ViewGroup$LayoutParams r14 = (android.view.ViewGroup.LayoutParams) r14
            r13.addView(r11, r12, r14)
        L_0x0075:
            return
        L_0x0076:
            net.one97.paytm.recharge.ordersummary.b.a r11 = r10.f63025g
            if (r11 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007d:
            boolean r11 = r11.d()
            if (r11 == 0) goto L_0x00a7
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r11 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            java.lang.String r12 = "loadCashbackOffersView postTxnView is null"
            r11.setErrorMsg(r12)
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r12 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UI_DESCRIPTION
            r11.setErrorType(r12)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r12 = r11.getFlowName()
            if (r12 == 0) goto L_0x00a2
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r13 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_CASHBACK_OFFERS
            java.lang.String r13 = r13.name()
            r12.setActionType(r13)
        L_0x00a2:
            net.one97.paytm.recharge.common.utils.az r12 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r11)
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.a.b.a(net.one97.paytm.common.entity.shopping.CJROrderedCart, int, android.view.ViewGroup, android.widget.LinearLayout$LayoutParams, net.one97.paytm.recharge.ordersummary.widget.a):void");
    }

    public static final /* synthetic */ View a(ViewGroup viewGroup, Rect rect) {
        while (true) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                kotlin.g.b.k.a((Object) childAt, "childView");
                if (childAt.getVisibility() == 0) {
                    if (!childAt.getLocalVisibleRect(rect)) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        if (viewGroup2.getId() == R.id.container_details || viewGroup2.getId() == R.id.container_main) {
                            viewGroup = viewGroup2;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
    }

    public static final /* synthetic */ void i(View view) {
        view.getY();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{-((float) com.paytm.utility.b.c(10)), 0.0f});
        kotlin.g.b.k.a((Object) ofFloat, "animation");
        ofFloat.setDuration(700);
        ofFloat.setRepeatCount(3);
        ofFloat.setRepeatMode(2);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new C1218b(view));
        ofFloat.start();
    }
}
