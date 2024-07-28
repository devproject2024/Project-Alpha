package net.one97.paytm.newaddmoney.view;

import android.animation.Animator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.CustomAmountTextInputEditText;
import net.one97.paytm.newaddmoney.a.a;
import net.one97.paytm.newaddmoney.a.b;
import net.one97.paytm.newaddmoney.c.a;
import net.one97.paytm.newaddmoney.c.b;
import net.one97.paytm.newaddmoney.view.b;
import net.one97.paytm.wallet.newdesign.addmoney.model.AddMoneyOffers;
import net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney;

public final class c extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    public String f55891a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.addmoney.a.k f55892b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.newaddmoney.c.a f55893c;

    /* renamed from: d  reason: collision with root package name */
    ViewTreeObserver.OnGlobalLayoutListener f55894d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f55895e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AddMoneyOffers.AddMoneyCodeOffers> f55896f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f55897g;

    /* renamed from: h  reason: collision with root package name */
    private String f55898h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f55899i = true;
    /* access modifiers changed from: private */
    public boolean j;
    private final long k = 300;
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

    static final class b<T> implements androidx.lifecycle.z<net.one97.paytm.newaddmoney.utils.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55916a;

        b(c cVar) {
            this.f55916a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            androidx.databinding.i<String> iVar;
            String str2;
            androidx.databinding.i<String> iVar2;
            net.one97.paytm.newaddmoney.utils.b bVar = (net.one97.paytm.newaddmoney.utils.b) obj;
            Context context = this.f55916a.getContext();
            if (context != null && bVar != null) {
                int i2 = d.f55943a[bVar.ordinal()];
                if (i2 == 1) {
                    Context context2 = this.f55916a.getContext();
                    String[] strArr = new String[4];
                    strArr[0] = net.one97.paytm.newaddmoney.utils.e.a(this.f55916a.getActivity());
                    strArr[1] = "Wallet";
                    strArr[2] = "";
                    net.one97.paytm.newaddmoney.c.a h2 = this.f55916a.f55893c;
                    if (h2 == null || (iVar = h2.k) == null) {
                        str = null;
                    } else {
                        str = iVar.get();
                    }
                    strArr[3] = str;
                    net.one97.paytm.addmoney.utils.d.a(context2, "add_money", "add_money_account_selected", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), "");
                    net.one97.paytm.addmoney.a.k e2 = c.e(this.f55916a);
                    TextView textView = e2.f48070i;
                    kotlin.g.b.k.a((Object) textView, "chooseOption");
                    textView.setText(this.f55916a.getString(R.string.paytm_wallet));
                    TextView textView2 = e2.j;
                    kotlin.g.b.k.a((Object) textView2, "chooseTextHeading");
                    textView2.setText(this.f55916a.getString(R.string.money_will_be_added_to));
                    e2.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(context, R.drawable.ic_wallet_bal_copy), (Drawable) null);
                    TextView textView3 = e2.f48065d;
                    kotlin.g.b.k.a((Object) textView3, "applyPromoText");
                    textView3.setEnabled(true);
                    e2.w.setText(this.f55916a.getString(R.string.proceed));
                    this.f55916a.b(false);
                    e2.f48065d.setTextColor(androidx.core.content.b.c(context, R.color.paytm_blue));
                } else if (i2 == 2) {
                    Context context3 = this.f55916a.getContext();
                    String[] strArr2 = new String[4];
                    strArr2[0] = net.one97.paytm.newaddmoney.utils.e.a(this.f55916a.getActivity());
                    strArr2[1] = "GV";
                    strArr2[2] = "";
                    net.one97.paytm.newaddmoney.c.a h3 = this.f55916a.f55893c;
                    if (h3 == null || (iVar2 = h3.k) == null) {
                        str2 = null;
                    } else {
                        str2 = iVar2.get();
                    }
                    strArr2[3] = str2;
                    net.one97.paytm.addmoney.utils.d.a(context3, "add_money", "add_money_account_selected", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr2), "");
                    net.one97.paytm.addmoney.a.k e3 = c.e(this.f55916a);
                    e3.w.setText(this.f55916a.getString(R.string.add_money_gv_bottom_sheet_proceed));
                    TextView textView4 = e3.f48070i;
                    kotlin.g.b.k.a((Object) textView4, "chooseOption");
                    textView4.setText(this.f55916a.getString(R.string.paytm_giftvoucher));
                    TextView textView5 = c.e(this.f55916a).f48065d;
                    kotlin.g.b.k.a((Object) textView5, "binder.applyPromoText");
                    textView5.setEnabled(false);
                    this.f55916a.a(false, "", "");
                    TextView textView6 = e3.j;
                    kotlin.g.b.k.a((Object) textView6, "chooseTextHeading");
                    textView6.setText(this.f55916a.getString(R.string.buy_text));
                    this.f55916a.b(true);
                    TextView textView7 = e3.y;
                    kotlin.g.b.k.a((Object) textView7, "promoApplyMessage");
                    net.one97.paytm.newaddmoney.utils.c.a((View) textView7, false);
                    e3.f48065d.setTextColor(androidx.core.content.b.c(context, R.color.color_4000baf2));
                    e3.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.b.a(context, R.drawable.uam_ic_gift_voucher), (Drawable) null);
                }
            }
        }
    }

    static final class e<T> implements androidx.lifecycle.z<ArrayList<AddMoneyOffers.AddMoneyCodeOffers>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55919a;

        e(c cVar) {
            this.f55919a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null) {
                ArrayList l = this.f55919a.f55896f;
                if (l != null) {
                    l.clear();
                }
                ArrayList l2 = this.f55919a.f55896f;
                if (l2 != null) {
                    l2.addAll(arrayList);
                }
            }
        }
    }

    static final class f<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55920a;

        f(c cVar) {
            this.f55920a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null) {
                NetworkCustomError networkCustomError = (NetworkCustomError) aVar.a();
                if (NetworkCustomError.ErrorType.NetworkError.equals(networkCustomError != null ? networkCustomError.getErrorType() : null)) {
                    this.f55920a.a((com.paytm.network.a) null);
                } else {
                    AddMoneyUtils.a(this.f55920a.getActivity(), networkCustomError, AddMoneyNewActivity.class.getCanonicalName(), Boolean.FALSE);
                }
            }
        }
    }

    static final class g<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55921a;

        g(c cVar) {
            this.f55921a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (((net.one97.paytm.autoaddmoney.b.f) ((net.one97.paytm.autoaddmoney.a) obj).a()) != null && this.f55921a.d()) {
                net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
                FragmentActivity activity = this.f55921a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                a2.a((Activity) activity, AddMoneyNewActivity.class.getCanonicalName(), (Bundle) null);
            }
        }
    }

    static final class h<T> implements androidx.lifecycle.z<net.one97.paytm.autoaddmoney.a<? extends com.paytm.network.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55922a;

        h(c cVar) {
            this.f55922a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f55922a.a((com.paytm.network.a) ((net.one97.paytm.autoaddmoney.a) obj).a());
        }
    }

    static final class j<T> implements androidx.lifecycle.z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55924a;

        j(c cVar) {
            this.f55924a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            androidx.databinding.i<String> iVar;
            String str2 = (String) obj;
            if (str2 != null) {
                c.e(this.f55924a).f48064c.requestFocus();
                c.r(this.f55924a);
                Context context = this.f55924a.getContext();
                if (context != null) {
                    int i2 = R.string.add_money_max_amount_error;
                    str = context.getString(i2, new Object[]{this.f55924a.getString(R.string.rupees) + " " + AddMoneyUtils.e(str2)});
                } else {
                    str = null;
                }
                net.one97.paytm.newaddmoney.c.a h2 = this.f55924a.f55893c;
                if (h2 != null && (iVar = h2.l) != null) {
                    iVar.set(str);
                }
            }
        }
    }

    static final class k<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55925a;

        k(c cVar) {
            this.f55925a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.newaddmoney.c.a h2;
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar;
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "walletLimitReached");
            if (bool.booleanValue() && (h2 = this.f55925a.f55893c) != null && (yVar = h2.o) != null) {
                yVar.setValue(net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER);
            }
        }
    }

    static final class l<T> implements androidx.lifecycle.z<kotlin.o<? extends Boolean, ? extends WalletLimitsResponseModelAddMoney>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55926a;

        l(c cVar) {
            this.f55926a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d5, code lost:
            r1 = (net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney) r6.getSecond();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.o r6 = (kotlin.o) r6
                java.lang.String r0 = "getString(R.string.title_400)"
                if (r6 == 0) goto L_0x00d3
                java.lang.Object r1 = r6.getSecond()
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney r1 = (net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney) r1
                if (r1 == 0) goto L_0x00d3
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney$Response r1 = r1.getResponse()
                if (r1 == 0) goto L_0x00d3
                java.lang.Boolean r2 = r1.getIsLimitApplicable()
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L_0x00b1
                net.one97.paytm.newaddmoney.view.c r2 = r5.f55926a
                java.lang.String r2 = r2.f55897g
                net.one97.paytm.newaddmoney.utils.d r3 = net.one97.paytm.newaddmoney.utils.d.PAYTM_ADHAAR_OTP_KYC
                java.lang.String r3 = r3.name()
                boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
                if (r3 != 0) goto L_0x0059
                net.one97.paytm.newaddmoney.utils.d r3 = net.one97.paytm.newaddmoney.utils.d.PAYTM_MIN_KYC
                java.lang.String r3 = r3.name()
                boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
                if (r3 == 0) goto L_0x003d
                goto L_0x0059
            L_0x003d:
                net.one97.paytm.newaddmoney.utils.d r1 = net.one97.paytm.newaddmoney.utils.d.PAYTM_PRIME_WALLET
                java.lang.String r1 = r1.name()
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)
                if (r1 == 0) goto L_0x00d3
                net.one97.paytm.newaddmoney.view.c r1 = r5.f55926a
                java.lang.Object r2 = r6.getFirst()
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                r2.booleanValue()
                net.one97.paytm.newaddmoney.view.c.k(r1)
                goto L_0x00d3
            L_0x0059:
                java.lang.String r2 = r1.getAddMoneyDestination()
                java.lang.String r3 = "MAIN"
                boolean r2 = r3.equals(r2)
                if (r2 == 0) goto L_0x0074
                net.one97.paytm.newaddmoney.view.c r1 = r5.f55926a
                java.lang.Object r2 = r6.getFirst()
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                r2.booleanValue()
                net.one97.paytm.newaddmoney.view.c.k(r1)
                goto L_0x00d3
            L_0x0074:
                java.lang.String r1 = r1.getAddMoneyDestination()
                java.lang.String r2 = "GIFT_VOUCHER"
                boolean r1 = r2.equals(r1)
                if (r1 == 0) goto L_0x008e
                net.one97.paytm.newaddmoney.view.c r1 = r5.f55926a
                net.one97.paytm.autoaddmoney.b.d r2 = new net.one97.paytm.autoaddmoney.b.d
                r3 = 0
                java.lang.String r4 = ""
                r2.<init>(r4, r3)
                r1.a((net.one97.paytm.autoaddmoney.b.d) r2)
                goto L_0x00d3
            L_0x008e:
                net.one97.paytm.newaddmoney.view.c r1 = r5.f55926a
                java.lang.Object r2 = r6.getSecond()
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney r2 = (net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney) r2
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney$Response r2 = r2.getResponse()
                if (r2 == 0) goto L_0x00a2
                java.lang.String r2 = r2.getMessage()
                if (r2 != 0) goto L_0x00ad
            L_0x00a2:
                net.one97.paytm.newaddmoney.view.c r2 = r5.f55926a
                int r3 = net.one97.paytm.addmoney.R.string.title_400
                java.lang.String r2 = r2.getString(r3)
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            L_0x00ad:
                net.one97.paytm.newaddmoney.view.c.b((net.one97.paytm.newaddmoney.view.c) r1, (java.lang.String) r2)
                goto L_0x00d3
            L_0x00b1:
                net.one97.paytm.newaddmoney.view.c r1 = r5.f55926a
                java.lang.Object r2 = r6.getSecond()
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney r2 = (net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney) r2
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney$Response r2 = r2.getResponse()
                if (r2 == 0) goto L_0x00c5
                java.lang.String r2 = r2.getMessage()
                if (r2 != 0) goto L_0x00d0
            L_0x00c5:
                net.one97.paytm.newaddmoney.view.c r2 = r5.f55926a
                int r3 = net.one97.paytm.addmoney.R.string.title_400
                java.lang.String r2 = r2.getString(r3)
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            L_0x00d0:
                net.one97.paytm.newaddmoney.view.c.b((net.one97.paytm.newaddmoney.view.c) r1, (java.lang.String) r2)
            L_0x00d3:
                if (r6 == 0) goto L_0x00e2
                java.lang.Object r1 = r6.getSecond()
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney r1 = (net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney) r1
                if (r1 == 0) goto L_0x00e2
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney$Response r1 = r1.getResponse()
                goto L_0x00e3
            L_0x00e2:
                r1 = 0
            L_0x00e3:
                if (r1 != 0) goto L_0x0107
                net.one97.paytm.newaddmoney.view.c r1 = r5.f55926a
                java.lang.Object r6 = r6.getSecond()
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney r6 = (net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney) r6
                net.one97.paytm.wallet.newdesign.addmoney.model.WalletLimitsResponseModelAddMoney$Response r6 = r6.getResponse()
                if (r6 == 0) goto L_0x00f9
                java.lang.String r6 = r6.getMessage()
                if (r6 != 0) goto L_0x0104
            L_0x00f9:
                net.one97.paytm.newaddmoney.view.c r6 = r5.f55926a
                int r2 = net.one97.paytm.addmoney.R.string.title_400
                java.lang.String r6 = r6.getString(r2)
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            L_0x0104:
                net.one97.paytm.newaddmoney.view.c.b((net.one97.paytm.newaddmoney.view.c) r1, (java.lang.String) r6)
            L_0x0107:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.l.onChanged(java.lang.Object):void");
        }
    }

    static final class m<T> implements androidx.lifecycle.z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55927a;

        m(c cVar) {
            this.f55927a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f55927a.f55897g = (String) obj;
        }
    }

    static final class v<T> implements androidx.lifecycle.z<Double> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55936a;

        v(c cVar) {
            this.f55936a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            TextView textView = (TextView) this.f55936a.a(R.id.tv_toal_bal_value);
            kotlin.g.b.k.a((Object) textView, "tv_toal_bal_value");
            textView.setText(this.f55936a.getString(R.string.am_balance, com.paytm.utility.b.S(String.valueOf(((Double) obj).doubleValue()))));
        }
    }

    static final class w<T> implements androidx.lifecycle.z<List<? extends net.one97.paytm.newaddmoney.b.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55937a;

        w(c cVar) {
            this.f55937a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            final List list = (List) obj;
            RecyclerView recyclerView = (RecyclerView) this.f55937a.a(R.id.rv_wallet_balances);
            kotlin.g.b.k.a((Object) recyclerView, "rv_wallet_balances");
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f55937a.getActivity()));
            Collection collection = list;
            if (!(collection == null || collection.isEmpty())) {
                RecyclerView recyclerView2 = (RecyclerView) this.f55937a.a(R.id.rv_wallet_balances);
                kotlin.g.b.k.a((Object) recyclerView2, "rv_wallet_balances");
                kotlin.g.b.k.a((Object) list, "it");
                recyclerView2.setAdapter(new net.one97.paytm.newaddmoney.a.b(list, new b.a(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ w f55938a;

                    {
                        this.f55938a = r1;
                    }

                    public final void a(int i2) {
                        String str;
                        androidx.databinding.i<String> iVar;
                        String str2;
                        androidx.databinding.i<String> iVar2;
                        androidx.databinding.i<String> iVar3;
                        int i3 = i2;
                        int i4 = ((net.one97.paytm.newaddmoney.b.a) list.get(i3)).f55821d;
                        String str3 = null;
                        if (i4 == net.one97.paytm.addmoney.utils.n.PAYTM_WALLET.getValue()) {
                            if (this.f55938a.f55937a.isAdded()) {
                                FragmentActivity activity = this.f55938a.f55937a.getActivity();
                                if (activity == null) {
                                    kotlin.g.b.k.a();
                                }
                                Context context = activity;
                                String[] strArr = new String[4];
                                strArr[0] = net.one97.paytm.addmoney.utils.n.PAYTM_WALLET.getWalletName();
                                strArr[1] = "";
                                strArr[2] = "";
                                net.one97.paytm.newaddmoney.c.a h2 = this.f55938a.f55937a.f55893c;
                                if (!(h2 == null || (iVar3 = h2.k) == null)) {
                                    str3 = iVar3.get();
                                }
                                strArr[3] = str3;
                                net.one97.paytm.addmoney.utils.d.a(context, "add_money", "paytm_bal_item_clicked", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), "");
                                net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
                                FragmentActivity activity2 = this.f55938a.f55937a.getActivity();
                                if (activity2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                kotlin.g.b.k.a((Object) activity2, "activity!!");
                                a2.a((Context) activity2, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet");
                            }
                        } else if (i4 == net.one97.paytm.addmoney.utils.n.FUEL_WALLET.getValue() || i4 == net.one97.paytm.addmoney.utils.n.COMMUNICATION_WALLET.getValue() || i4 == net.one97.paytm.addmoney.utils.n.GIFT_CARDS.getValue()) {
                            if (this.f55938a.f55937a.isAdded()) {
                                String str4 = ((net.one97.paytm.newaddmoney.b.a) list.get(i3)).f55819b;
                                if (str4 == null) {
                                    str = null;
                                } else if (str4 != null) {
                                    String lowerCase = str4.toLowerCase();
                                    kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                                    str = kotlin.m.p.a(lowerCase, " ", "_", false);
                                } else {
                                    throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                                }
                                FragmentActivity activity3 = this.f55938a.f55937a.getActivity();
                                if (activity3 == null) {
                                    kotlin.g.b.k.a();
                                }
                                Context context2 = activity3;
                                String[] strArr2 = new String[4];
                                strArr2[0] = str;
                                strArr2[1] = "";
                                strArr2[2] = "";
                                net.one97.paytm.newaddmoney.c.a h3 = this.f55938a.f55937a.f55893c;
                                if (!(h3 == null || (iVar = h3.k) == null)) {
                                    str3 = iVar.get();
                                }
                                strArr2[3] = str3;
                                net.one97.paytm.addmoney.utils.d.a(context2, "add_money", "paytm_bal_item_clicked", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr2), "");
                                net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
                                FragmentActivity activity4 = this.f55938a.f55937a.getActivity();
                                if (activity4 == null) {
                                    kotlin.g.b.k.a();
                                }
                                kotlin.g.b.k.a((Object) activity4, "activity!!");
                                a3.a((Context) activity4, Integer.valueOf(((net.one97.paytm.newaddmoney.b.a) list.get(i3)).f55821d), (net.one97.paytm.newaddmoney.b.a) list.get(i3));
                            }
                        } else if (this.f55938a.f55937a.isAdded()) {
                            String str5 = ((net.one97.paytm.newaddmoney.b.a) list.get(i3)).f55819b;
                            if (str5 == null) {
                                str2 = null;
                            } else if (str5 != null) {
                                String lowerCase2 = str5.toLowerCase();
                                kotlin.g.b.k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                str2 = kotlin.m.p.a(lowerCase2, " ", "_", false);
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                            }
                            FragmentActivity activity5 = this.f55938a.f55937a.getActivity();
                            if (activity5 == null) {
                                kotlin.g.b.k.a();
                            }
                            Context context3 = activity5;
                            String[] strArr3 = new String[4];
                            strArr3[0] = str2;
                            strArr3[1] = "";
                            strArr3[2] = "";
                            net.one97.paytm.newaddmoney.c.a h4 = this.f55938a.f55937a.f55893c;
                            if (!(h4 == null || (iVar2 = h4.k) == null)) {
                                str3 = iVar2.get();
                            }
                            strArr3[3] = str3;
                            net.one97.paytm.addmoney.utils.d.a(context3, "add_money", "paytm_bal_item_clicked", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr3), "");
                            net.one97.paytm.helper.c a4 = net.one97.paytm.helper.a.f50546a.a();
                            FragmentActivity activity6 = this.f55938a.f55937a.getActivity();
                            if (activity6 == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) activity6, "activity!!");
                            a4.a((Context) activity6, Integer.valueOf(((net.one97.paytm.newaddmoney.b.a) list.get(i3)).f55821d), Integer.valueOf(((net.one97.paytm.newaddmoney.b.a) list.get(i3)).f55818a), ((net.one97.paytm.newaddmoney.b.a) list.get(i3)).f55822e);
                        }
                    }
                }));
            }
        }
    }

    static final class x<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55940a;

        x(c cVar) {
            this.f55940a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            Boolean bool = (Boolean) obj;
            c cVar = this.f55940a;
            Context context = cVar.getContext();
            if (context == null || (str = context.getString(R.string.please_wait)) == null) {
                str = "";
            }
            kotlin.g.b.k.a((Object) bool, "isShowLoader");
            cVar.a(new net.one97.paytm.autoaddmoney.b.d(str, bool.booleanValue()));
        }
    }

    public static final /* synthetic */ net.one97.paytm.addmoney.a.k e(c cVar) {
        net.one97.paytm.addmoney.a.k kVar = cVar.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        return kVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        ViewDataBinding a2 = androidx.databinding.f.a(layoutInflater, R.layout.fragment_new_addmoney_wallet, viewGroup, false);
        kotlin.g.b.k.a((Object) a2, "DataBindingUtil.inflate(…wallet, container, false)");
        this.f55892b = (net.one97.paytm.addmoney.a.k) a2;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            b.a aVar = net.one97.paytm.newaddmoney.c.b.f55842a;
            FragmentActivity activity2 = getActivity();
            this.f55893c = (net.one97.paytm.newaddmoney.c.a) am.a(activity, (al.b) b.a.a(activity2 != null ? activity2.getApplication() : null, this)).a(net.one97.paytm.newaddmoney.c.a.class);
        }
        net.one97.paytm.addmoney.a.k kVar = this.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar.a(this.f55893c);
        net.one97.paytm.addmoney.a.k kVar2 = this.f55892b;
        if (kVar2 == null) {
            kotlin.g.b.k.a("binder");
        }
        return kVar2.getRoot();
    }

    public final void onDetach() {
        super.onDetach();
        net.one97.paytm.newaddmoney.c.a aVar = this.f55893c;
        if (aVar != null) {
            net.one97.paytm.wallet.d.c cVar = aVar.f55831a;
            if (cVar != null) {
                cVar.a();
            }
            io.reactivex.rxjava3.b.b bVar = aVar.z;
            if (bVar != null) {
                bVar.dispose();
            }
            aVar.f55831a = null;
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        int i2;
        double d2;
        androidx.databinding.i<String> iVar;
        androidx.databinding.i<String> iVar2;
        String str2;
        androidx.lifecycle.y<Boolean> yVar;
        LiveData liveData;
        androidx.lifecycle.y<kotlin.x> yVar2;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        String str3;
        androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar3;
        androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar4;
        androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar5;
        net.one97.paytm.newaddmoney.c.a aVar;
        androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar6;
        androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar7;
        androidx.databinding.i<String> iVar3;
        String str4;
        androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar8;
        androidx.databinding.i<String> iVar4;
        LiveData liveData5;
        LiveData liveData6;
        androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> yVar9;
        androidx.lifecycle.y<kotlin.x> yVar10;
        LiveData liveData7;
        LiveData liveData8;
        LiveData liveData9;
        LiveData liveData10;
        androidx.databinding.i<String> iVar5;
        super.onActivityCreated(bundle);
        this.f55897g = net.one97.paytm.newaddmoney.utils.e.a(getContext());
        net.one97.paytm.addmoney.utils.d.a(getActivity(), "/add-money/wallet");
        net.one97.paytm.addmoney.a.k kVar = this.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar.f48065d.setOnClickListener(new n(this));
        kVar.p.setOnClickListener(new o(this));
        kVar.B.setOnClickListener(new p(this));
        kVar.j.setOnClickListener(new q(this));
        kVar.f48070i.setOnClickListener(new r(this));
        kVar.o.setOnClickListener(new s(this));
        net.one97.paytm.addmoney.a.k kVar2 = this.f55892b;
        if (kVar2 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar2.w.setOnClickListener(new u(this));
        Context context = getContext();
        String[] strArr = new String[4];
        boolean z2 = false;
        strArr[0] = net.one97.paytm.newaddmoney.utils.e.a(getActivity());
        strArr[1] = "";
        strArr[2] = "";
        net.one97.paytm.newaddmoney.c.a aVar2 = this.f55893c;
        if (aVar2 == null || (iVar5 = aVar2.k) == null) {
            str = null;
        } else {
            str = iVar5.get();
        }
        strArr[3] = str;
        net.one97.paytm.addmoney.utils.d.a(context, "add_money", "add_money_amount_enter_tapped", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), (String) null);
        this.f55898h = getString(R.string.add_money);
        net.one97.paytm.addmoney.a.k kVar3 = this.f55892b;
        if (kVar3 == null) {
            kotlin.g.b.k.a("binder");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText = kVar3.f48064c;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText, "binder.amwAmountInputEt");
        customAmountTextInputEditText.setPrefix("");
        String f2 = net.one97.paytm.helper.a.f50546a.a().f("max_digit_paytmcash");
        if (!TextUtils.isEmpty(f2)) {
            if (f2 == null) {
                kotlin.g.b.k.a();
            }
            i2 = Integer.parseInt(f2);
        } else {
            i2 = 0;
        }
        if (i2 <= 0) {
            i2 = 5;
        }
        net.one97.paytm.addmoney.a.k kVar4 = this.f55892b;
        if (kVar4 == null) {
            kotlin.g.b.k.a("binder");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText2 = kVar4.f48064c;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText2, "binder.amwAmountInputEt");
        customAmountTextInputEditText2.setMaxDigitsBeforeDecimalPoint(i2);
        InputFilter[] inputFilterArr = {new net.one97.paytm.common.widgets.f(i2, 2)};
        net.one97.paytm.addmoney.a.k kVar5 = this.f55892b;
        if (kVar5 == null) {
            kotlin.g.b.k.a("binder");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText3 = kVar5.f48064c;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText3, "binder.amwAmountInputEt");
        customAmountTextInputEditText3.setFilters(inputFilterArr);
        net.one97.paytm.addmoney.a.k kVar6 = this.f55892b;
        if (kVar6 == null) {
            kotlin.g.b.k.a("binder");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText4 = kVar6.f48064c;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText4, "binder.amwAmountInputEt");
        customAmountTextInputEditText4.setImeOptions(6);
        net.one97.paytm.addmoney.a.k kVar7 = this.f55892b;
        if (kVar7 == null) {
            kotlin.g.b.k.a("binder");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText5 = kVar7.f48064c;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText5, "binder.amwAmountInputEt");
        customAmountTextInputEditText5.setOnFocusChangeListener(new ac(this));
        net.one97.paytm.addmoney.a.k kVar8 = this.f55892b;
        if (kVar8 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar8.f48064c.addTextChangedListener(new ad(this));
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("amount")) {
            double d3 = arguments.getDouble("amount");
            if (d3 > 0.0d) {
                String b2 = com.paytm.utility.b.b(Double.valueOf(d3));
                net.one97.paytm.addmoney.a.k kVar9 = this.f55892b;
                if (kVar9 == null) {
                    kotlin.g.b.k.a("binder");
                }
                kVar9.f48064c.setText(AddMoneyUtils.d(b2));
            }
        }
        net.one97.paytm.newaddmoney.c.a aVar3 = this.f55893c;
        if (!(aVar3 == null || (liveData10 = aVar3.s) == null)) {
            liveData10.observe(this, new e(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar4 = this.f55893c;
        if (!(aVar4 == null || (liveData9 = aVar4.t) == null)) {
            liveData9.observe(this, new x(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar5 = this.f55893c;
        if (!(aVar5 == null || (liveData8 = aVar5.f55834d) == null)) {
            liveData8.observe(getViewLifecycleOwner(), new l(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar6 = this.f55893c;
        if (!(aVar6 == null || (liveData7 = aVar6.f55833c) == null)) {
            liveData7.observe(getViewLifecycleOwner(), new m(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar7 = this.f55893c;
        if (!(aVar7 == null || (yVar10 = aVar7.f55839i) == null)) {
            yVar10.observe(this, new t(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar8 = this.f55893c;
        if (!(aVar8 == null || (yVar9 = aVar8.o) == null)) {
            yVar9.observe(this, new b(this));
        }
        String f3 = net.one97.paytm.helper.a.f50546a.a().f("add_money_banner_url");
        if (!TextUtils.isEmpty(f3) && com.paytm.utility.b.n(getContext()) != null) {
            androidx.fragment.app.q a2 = getChildFragmentManager().a();
            int i3 = R.id.offer_container;
            b.a aVar9 = b.f55889a;
            if (f3 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(f3, "url");
            b bVar = new b();
            Bundle bundle2 = new Bundle();
            bundle2.putString("url", f3);
            bVar.setArguments(bundle2);
            a2.a(i3, bVar, "banner_fragment").c();
        }
        net.one97.paytm.newaddmoney.c.a aVar10 = this.f55893c;
        if (!(aVar10 == null || (liveData6 = aVar10.x) == null)) {
            liveData6.observe(getViewLifecycleOwner(), new v(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar11 = this.f55893c;
        if (!(aVar11 == null || (liveData5 = aVar11.y) == null)) {
            liveData5.observe(getViewLifecycleOwner(), new w(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar12 = this.f55893c;
        if (aVar12 != null) {
            aVar12.G.a(net.one97.paytm.helper.a.f50546a.a().f("PaytmCashProductId"), (net.one97.paytm.addmoney.h) new a.C1044a(aVar12));
        }
        net.one97.paytm.addmoney.a.k kVar10 = this.f55892b;
        if (kVar10 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar10.t.setOnClickListener(new y(this));
        net.one97.paytm.newaddmoney.c.a aVar13 = this.f55893c;
        if (aVar13 != null) {
            Activity activity = getActivity();
            aVar13.z = new io.reactivex.rxjava3.b.b();
            if (aVar13.f55831a == null) {
                aVar13.f55831a = new net.one97.paytm.wallet.d.c(false);
            }
            net.one97.paytm.wallet.d.c cVar = aVar13.f55831a;
            if (cVar != null) {
                androidx.databinding.i<String> iVar6 = aVar13.k;
                cVar.b(iVar6 != null ? iVar6.get() : null);
            }
            net.one97.paytm.wallet.d.c cVar2 = aVar13.f55831a;
            if (cVar2 != null) {
                cVar2.a(activity, (net.one97.paytm.wallet.f.f) aVar13, "addMoneyWallet");
            }
            net.one97.paytm.wallet.d.c cVar3 = aVar13.f55831a;
            if (cVar3 != null) {
                cVar3.a((net.one97.paytm.wallet.f.e) aVar13);
            }
            net.one97.paytm.wallet.d.c cVar4 = aVar13.f55831a;
            if (cVar4 != null) {
                cVar4.a(aVar13.B);
            }
        }
        if (net.one97.paytm.newaddmoney.utils.e.a()) {
            Context activity2 = getActivity();
            String[] strArr2 = new String[4];
            strArr2[0] = net.one97.paytm.newaddmoney.utils.e.a(getActivity());
            strArr2[1] = "";
            strArr2[2] = "";
            net.one97.paytm.newaddmoney.c.a aVar14 = this.f55893c;
            if (aVar14 == null || (iVar4 = aVar14.k) == null) {
                str4 = null;
            } else {
                str4 = iVar4.get();
            }
            strArr2[3] = str4;
            net.one97.paytm.addmoney.utils.d.a(activity2, "add_money", "add_money_wallet_status", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr2), "Inactive");
            net.one97.paytm.newaddmoney.c.a aVar15 = this.f55893c;
            if (!(aVar15 == null || (yVar8 = aVar15.o) == null)) {
                yVar8.setValue(net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER);
            }
        } else {
            Context context2 = getContext();
            String[] strArr3 = new String[4];
            strArr3[0] = net.one97.paytm.newaddmoney.utils.e.a(getActivity());
            strArr3[1] = "";
            strArr3[2] = "";
            net.one97.paytm.newaddmoney.c.a aVar16 = this.f55893c;
            if (aVar16 == null || (iVar3 = aVar16.k) == null) {
                str3 = null;
            } else {
                str3 = iVar3.get();
            }
            strArr3[3] = str3;
            net.one97.paytm.addmoney.utils.d.a(context2, "add_money", "add_money_wallet_status", "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr3), "Active");
            Bundle arguments2 = getArguments();
            if (arguments2 != null && arguments2.containsKey("tab")) {
                String string = arguments2.getString("tab");
                if (string != null && string.equals("wallet")) {
                    net.one97.paytm.newaddmoney.c.a aVar17 = this.f55893c;
                    if (!(aVar17 == null || (yVar7 = aVar17.o) == null)) {
                        yVar7.setValue(net.one97.paytm.newaddmoney.utils.b.TO_WALLET);
                    }
                } else if (!(string == null || !string.equals("giftVoucher") || (aVar = this.f55893c) == null || (yVar6 = aVar.o) == null)) {
                    yVar6.setValue(net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER);
                }
                z2 = true;
            }
            if (!z2 && getContext() != null) {
                String f4 = net.one97.paytm.helper.a.f50546a.a().f("default_option_to_addMoney");
                if (f4 != null && f4.equals(net.one97.paytm.newaddmoney.utils.b.TO_WALLET.toString())) {
                    net.one97.paytm.newaddmoney.c.a aVar18 = this.f55893c;
                    if (!(aVar18 == null || (yVar5 = aVar18.o) == null)) {
                        yVar5.setValue(net.one97.paytm.newaddmoney.utils.b.TO_WALLET);
                    }
                } else if (f4 == null || !f4.equals(net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER.toString())) {
                    net.one97.paytm.newaddmoney.c.a aVar19 = this.f55893c;
                    if (!(aVar19 == null || (yVar3 = aVar19.o) == null)) {
                        yVar3.setValue(net.one97.paytm.newaddmoney.utils.b.TO_WALLET);
                    }
                } else {
                    net.one97.paytm.newaddmoney.c.a aVar20 = this.f55893c;
                    if (!(aVar20 == null || (yVar4 = aVar20.o) == null)) {
                        yVar4.setValue(net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER);
                    }
                }
            }
        }
        net.one97.paytm.newaddmoney.c.a aVar21 = this.f55893c;
        if (!(aVar21 == null || (liveData4 = aVar21.f55832b) == null)) {
            liveData4.observe(this, new f(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar22 = this.f55893c;
        if (!(aVar22 == null || (liveData3 = aVar22.v) == null)) {
            liveData3.observe(this, new g(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar23 = this.f55893c;
        if (!(aVar23 == null || (liveData2 = aVar23.u) == null)) {
            liveData2.observe(this, new h(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar24 = this.f55893c;
        if (!(aVar24 == null || (yVar2 = aVar24.q) == null)) {
            yVar2.observe(this, new i(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar25 = this.f55893c;
        if (!(aVar25 == null || (liveData = aVar25.p) == null)) {
            liveData.observe(getViewLifecycleOwner(), new j(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar26 = this.f55893c;
        if (!(aVar26 == null || (yVar = aVar26.f55838h) == null)) {
            yVar.observe(this, new k(this));
        }
        net.one97.paytm.newaddmoney.c.a aVar27 = this.f55893c;
        if (aVar27 != null) {
            d2 = aVar27.A;
        } else {
            d2 = 0.0d;
        }
        if (d2 <= 0.0d && (str2 = this.f55897g) != null && str2.equals(net.one97.paytm.newaddmoney.utils.d.PAYTM_MIN_KYC.name())) {
            a(true);
        }
        net.one97.paytm.addmoney.a.k kVar11 = this.f55892b;
        if (kVar11 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar11.q.setOnClickListener(new z(this));
        net.one97.paytm.addmoney.a.k kVar12 = this.f55892b;
        if (kVar12 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar12.M.setOnClickListener(new aa(this));
        net.one97.paytm.newaddmoney.c.a aVar28 = this.f55893c;
        if (!(aVar28 == null || (iVar2 = aVar28.m) == null)) {
            net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
            String string2 = getString(R.string.am_use_wallet);
            kotlin.g.b.k.a((Object) string2, "getString(R.string.am_use_wallet)");
            iVar2.set(a3.a("addMoneyWalletUsageHeading", string2));
        }
        net.one97.paytm.newaddmoney.c.a aVar29 = this.f55893c;
        if (!(aVar29 == null || (iVar = aVar29.n) == null)) {
            net.one97.paytm.helper.c a4 = net.one97.paytm.helper.a.f50546a.a();
            String string3 = getString(R.string.am_manage_wallet);
            kotlin.g.b.k.a((Object) string3, "getString(R.string.am_manage_wallet)");
            iVar.set(a4.a("addMoneyWalletManageHeading", string3));
        }
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_manage_wallet);
        kotlin.g.b.k.a((Object) recyclerView, "rv_manage_wallet");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_manage_wallet);
        kotlin.g.b.k.a((Object) recyclerView2, "rv_manage_wallet");
        recyclerView2.setAdapter(new net.one97.paytm.newaddmoney.a.a(b("addMoneyWalletManageList", "[{\"title\":\"Setup Automatic Add Money\", \"type\": \"SETUP_AUTOMATIC\", \"deeplink\": \"paytmmp://cash_wallet?featuretype=add_money&tab=automatic_add_money\"},{\"title\":\"Nearby Cash Deposit Points\", \"type\": \"NEARBY_CASH_DEPOSIT_POINTS\", \"deeplink\": \"paytmmp://cash_wallet?featuretype=nearbyAddMoney&destination=toWallet\"},{\"title\":\"Set Payment Reminders\", \"type\": \"SET_PAYMENT_REMINDER\", \"deeplink\": \"paytmmp://payment_reminder\"},{\"title\":\"View Spend Analytics\", \"type\": \"VIEW_SPEND_ANALYTICS\", \"deeplink\": \"paytmmp://passbook?featuretype=spend_analytics\"},{\"title\":\"Request Wallet Statement\", \"type\": \"REQUEST_WALLET_STATEMENT\", \"deeplink\": \"paytmmp://cash_wallet?featuretype=statement_download\"}]"), new C1047c(this)));
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rv_wallet_usage);
        kotlin.g.b.k.a((Object) recyclerView3, "rv_wallet_usage");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView4 = (RecyclerView) a(R.id.rv_wallet_usage);
        kotlin.g.b.k.a((Object) recyclerView4, "rv_wallet_usage");
        recyclerView4.setAdapter(new net.one97.paytm.newaddmoney.a.a(b("addMoneyWalletUsageList", "[{\"title\":\"Make a Payment\", \"type\": \"MAKE_PAYMENT\", \"deeplink\": \"paytmmp://cash_wallet?featuretype=scanner\"},{\"title\":\"Gift Paytm Cash\", \"type\": \"GIFT_PAYTM_CASH\", \"deeplink\": \"paytmmp://cash_wallet?featuretype=gift_paytm_cash\"},{\"title\":\"Send Money to Bank\", \"type\": \"SEND_MONEY_TO_BANK\", \"deeplink\": \"paytmmp://cash_wallet?featuretype=wallet_to_ppb\"}]"), new d(this)));
        a();
    }

    static final class y implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55941a;

        y(c cVar) {
            this.f55941a = cVar;
        }

        public final void onClick(View view) {
            if (this.f55941a.j) {
                com.paytm.utility.b.c((Activity) this.f55941a.getActivity());
            }
        }
    }

    static final class z implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55942a;

        z(c cVar) {
            this.f55942a = cVar;
        }

        public final void onClick(View view) {
            c.b(this.f55942a);
        }
    }

    static final class aa implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55900a;

        aa(c cVar) {
            this.f55900a = cVar;
        }

        public final void onClick(View view) {
            c.b(this.f55900a);
        }
    }

    public final void a() {
        if (this.f55894d == null) {
            this.f55894d = new ab(this);
        }
        net.one97.paytm.addmoney.a.k kVar = this.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        NestedScrollView nestedScrollView = kVar.F;
        kotlin.g.b.k.a((Object) nestedScrollView, "binder.scrollView");
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(this.f55894d);
    }

    static final class ab implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55901a;

        ab(c cVar) {
            this.f55901a = cVar;
        }

        public final void onGlobalLayout() {
            if (!this.f55901a.f55899i) {
                Rect rect = new Rect();
                c.e(this.f55901a).F.getWindowVisibleDisplayFrame(rect);
                NestedScrollView nestedScrollView = c.e(this.f55901a).F;
                kotlin.g.b.k.a((Object) nestedScrollView, "binder.scrollView");
                View rootView = nestedScrollView.getRootView();
                kotlin.g.b.k.a((Object) rootView, "binder.scrollView.rootView");
                int height = rootView.getHeight();
                double d2 = (double) (height - rect.bottom);
                double d3 = ((double) height) * 0.15d;
                if (d2 > d3 && !this.f55901a.j) {
                    this.f55901a.j = true;
                    c.f(this.f55901a);
                } else if (d2 <= d3 && this.f55901a.j) {
                    this.f55901a.j = false;
                    c.g(this.f55901a);
                }
            }
        }
    }

    public static final class af implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55905a;

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        af(c cVar) {
            this.f55905a = cVar;
        }

        public final void onAnimationEnd(Animator animator) {
            View view = c.e(this.f55905a).l;
            kotlin.g.b.k.a((Object) view, "binder.headBorder");
            view.setVisibility(0);
            TextView textView = c.e(this.f55905a).G;
            kotlin.g.b.k.a((Object) textView, "binder.tvAddmoney");
            textView.setVisibility(0);
            TextView textView2 = c.e(this.f55905a).M;
            kotlin.g.b.k.a((Object) textView2, "binder.tvWalletBalance");
            textView2.setVisibility(0);
            c.e(this.f55905a).f48064c.requestFocus();
            CustomAmountTextInputEditText customAmountTextInputEditText = c.e(this.f55905a).f48064c;
            CustomAmountTextInputEditText customAmountTextInputEditText2 = c.e(this.f55905a).f48064c;
            kotlin.g.b.k.a((Object) customAmountTextInputEditText2, "binder.amwAmountInputEt");
            customAmountTextInputEditText.setSelection(String.valueOf(customAmountTextInputEditText2.getText()).length());
        }
    }

    public static final class ae implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55904a;

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        ae(c cVar) {
            this.f55904a = cVar;
        }

        public final void onAnimationEnd(Animator animator) {
            ImageView imageView = c.e(this.f55904a).q;
            kotlin.g.b.k.a((Object) imageView, "binder.ivWalletBalArrow");
            imageView.setVisibility(0);
        }
    }

    private final void a(float f2) {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        net.one97.paytm.addmoney.a.k kVar = this.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        cVar.b(kVar.t);
        cVar.a(R.id.proceed_cl, f2);
        net.one97.paytm.addmoney.a.k kVar2 = this.f55892b;
        if (kVar2 == null) {
            kotlin.g.b.k.a("binder");
        }
        cVar.c(kVar2.t);
    }

    /* renamed from: net.one97.paytm.newaddmoney.view.c$c  reason: collision with other inner class name */
    public static final class C1047c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55917a;

        C1047c(c cVar) {
            this.f55917a = cVar;
        }

        public final void a(net.one97.paytm.newaddmoney.b.b bVar) {
            String str;
            androidx.databinding.i<String> iVar;
            kotlin.g.b.k.c(bVar, "amCta");
            FragmentActivity activity = this.f55917a.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            Context context = activity;
            String a2 = c.a(bVar.f55829c);
            String[] strArr = new String[4];
            strArr[0] = "";
            strArr[1] = "";
            strArr[2] = "";
            net.one97.paytm.newaddmoney.c.a h2 = this.f55917a.f55893c;
            if (h2 == null || (iVar = h2.k) == null) {
                str = null;
            } else {
                str = iVar.get();
            }
            strArr[3] = str;
            net.one97.paytm.addmoney.utils.d.a(context, "add_money", a2, "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), "");
            net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
            FragmentActivity activity2 = this.f55917a.getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity2, "activity!!");
            a3.a((Context) activity2, bVar.f55830d);
        }
    }

    public static final class d implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55918a;

        d(c cVar) {
            this.f55918a = cVar;
        }

        public final void a(net.one97.paytm.newaddmoney.b.b bVar) {
            String str;
            androidx.databinding.i<String> iVar;
            kotlin.g.b.k.c(bVar, "amCta");
            FragmentActivity activity = this.f55918a.getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            Context context = activity;
            String a2 = c.a(bVar.f55829c);
            String[] strArr = new String[4];
            strArr[0] = "";
            strArr[1] = "";
            strArr[2] = "";
            net.one97.paytm.newaddmoney.c.a h2 = this.f55918a.f55893c;
            if (h2 == null || (iVar = h2.k) == null) {
                str = null;
            } else {
                str = iVar.get();
            }
            strArr[3] = str;
            net.one97.paytm.addmoney.utils.d.a(context, "add_money", a2, "/add-money", (ArrayList<String>) kotlin.a.k.d(strArr), "");
            net.one97.paytm.helper.c a3 = net.one97.paytm.helper.a.f50546a.a();
            FragmentActivity activity2 = this.f55918a.getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity2, "activity!!");
            a3.a((Context) activity2, bVar.f55830d);
        }
    }

    private static List<net.one97.paytm.newaddmoney.b.b> b(String str, String str2) {
        Object a2 = new com.google.gsonhtcfix.f().a(net.one97.paytm.helper.a.f50546a.a().a(str, str2), new a().getType());
        kotlin.g.b.k.a(a2, "Gson().fromJson(\n       …en<List<AmCta>>(){}.type)");
        List<net.one97.paytm.newaddmoney.b.b> list = (List) a2;
        for (net.one97.paytm.newaddmoney.b.b next : list) {
            String str3 = next.f55829c;
            if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.MAKE_PAYMENT.name())) {
                next.f55828b = R.drawable.am_ic_pay;
            } else if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.GIFT_PAYTM_CASH.name())) {
                next.f55828b = R.drawable.am_ic_paytm_cash;
            } else if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.SEND_MONEY_TO_BANK.name())) {
                next.f55828b = R.drawable.am_ic_to_bank;
            } else if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.SETUP_AUTOMATIC.name())) {
                next.f55828b = R.drawable.am_ic_automatic;
            } else if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.NEARBY_CASH_DEPOSIT_POINTS.name())) {
                next.f55828b = R.drawable.am_ic_add_cash;
            } else if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.SET_PAYMENT_REMINDER.name())) {
                next.f55828b = R.drawable.am_ic_reminder;
            } else if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.VIEW_SPEND_ANALYTICS.name())) {
                next.f55828b = R.drawable.am_ic_analysis;
            } else if (kotlin.g.b.k.a((Object) str3, (Object) net.one97.paytm.newaddmoney.b.c.REQUEST_WALLET_STATEMENT.name())) {
                next.f55828b = R.drawable.am_ic_request;
            }
        }
        return list;
    }

    public static final class a extends com.google.gsonhtcfix.c.a<List<? extends net.one97.paytm.newaddmoney.b.b>> {
        a() {
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55928a;

        n(c cVar) {
            this.f55928a = cVar;
        }

        public final void onClick(View view) {
            androidx.databinding.i<String> iVar;
            androidx.databinding.i<String> iVar2;
            String str = null;
            if (TextUtils.isEmpty(this.f55928a.e())) {
                Context activity = this.f55928a.getActivity();
                String[] strArr = new String[4];
                strArr[0] = net.one97.paytm.newaddmoney.utils.e.a(this.f55928a.getContext());
                strArr[1] = "";
                strArr[2] = "";
                net.one97.paytm.newaddmoney.c.a h2 = this.f55928a.f55893c;
                if (!(h2 == null || (iVar2 = h2.k) == null)) {
                    str = iVar2.get();
                }
                strArr[3] = str;
                net.one97.paytm.addmoney.utils.d.a(activity, "add_money", "add_money_have_promo", "/home-screen/add-money/", (ArrayList<String>) kotlin.a.k.d(strArr), (String) null);
            } else {
                Context activity2 = this.f55928a.getActivity();
                String[] strArr2 = new String[4];
                strArr2[0] = net.one97.paytm.newaddmoney.utils.e.a(this.f55928a.getContext());
                strArr2[1] = "";
                strArr2[2] = "";
                net.one97.paytm.newaddmoney.c.a h3 = this.f55928a.f55893c;
                if (!(h3 == null || (iVar = h3.k) == null)) {
                    str = iVar.get();
                }
                strArr2[3] = str;
                net.one97.paytm.addmoney.utils.d.a(activity2, "add_money", "add_money_enter_amount_have_promo", "/home-screen/add-money/", (ArrayList<String>) kotlin.a.k.d(strArr2), (String) null);
            }
            net.one97.paytm.newaddmoney.c.a h4 = this.f55928a.f55893c;
            if (h4 != null) {
                String m = this.f55928a.e();
                kotlin.g.b.k.a((Object) m, "getAddMoneyAmount()");
                if (h4.b(m)) {
                    c.n(this.f55928a);
                }
            }
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55929a;

        o(c cVar) {
            this.f55929a = cVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f55929a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55930a;

        p(c cVar) {
            this.f55930a = cVar;
        }

        public final void onClick(View view) {
            this.f55930a.a(false, "", "");
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55931a;

        q(c cVar) {
            this.f55931a = cVar;
        }

        public final void onClick(View view) {
            new h().show(this.f55931a.getChildFragmentManager(), h.class.getName());
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55932a;

        r(c cVar) {
            this.f55932a = cVar;
        }

        public final void onClick(View view) {
            new h().show(this.f55932a.getChildFragmentManager(), h.class.getName());
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55933a;

        s(c cVar) {
            this.f55933a = cVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                net.one97.paytm.newaddmoney.view.c r6 = r5.f55933a
                java.lang.String r6 = r6.e()
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r6 = android.text.TextUtils.isEmpty(r6)
                r0 = 0
                if (r6 != 0) goto L_0x0024
                net.one97.paytm.newaddmoney.view.c r6 = r5.f55933a     // Catch:{ NumberFormatException -> 0x0020 }
                java.lang.String r6 = r6.e()     // Catch:{ NumberFormatException -> 0x0020 }
                java.lang.String r2 = "getAddMoneyAmount()"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)     // Catch:{ NumberFormatException -> 0x0020 }
                double r2 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException -> 0x0020 }
                goto L_0x0025
            L_0x0020:
                r6 = move-exception
                r6.printStackTrace()
            L_0x0024:
                r2 = r0
            L_0x0025:
                net.one97.paytm.newaddmoney.view.c r6 = r5.f55933a
                java.lang.String r6 = r6.f55897g
                if (r6 == 0) goto L_0x003a
                net.one97.paytm.newaddmoney.utils.d r4 = net.one97.paytm.newaddmoney.utils.d.PAYTM_PRIME_WALLET
                java.lang.String r4 = r4.toString()
                boolean r6 = r6.equals(r4)
                r4 = 1
                if (r6 == r4) goto L_0x0048
            L_0x003a:
                net.one97.paytm.newaddmoney.view.c r6 = r5.f55933a
                net.one97.paytm.newaddmoney.c.a r6 = r6.f55893c
                if (r6 == 0) goto L_0x0044
                double r0 = r6.A
            L_0x0044:
                int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r6 < 0) goto L_0x005d
            L_0x0048:
                net.one97.paytm.newaddmoney.view.c r6 = r5.f55933a
                androidx.fragment.app.FragmentActivity r6 = r6.getActivity()
                if (r6 == 0) goto L_0x005c
                net.one97.paytm.newaddmoney.view.c r0 = r5.f55933a
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
                android.app.Activity r6 = (android.app.Activity) r6
                net.one97.paytm.newaddmoney.view.c.a((net.one97.paytm.newaddmoney.view.c) r0, (android.app.Activity) r6)
            L_0x005c:
                return
            L_0x005d:
                net.one97.paytm.newaddmoney.view.c r6 = r5.f55933a
                r6.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.s.onClick(android.view.View):void");
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putSerializable("amount", com.paytm.utility.b.Q(e()));
        fVar.setArguments(bundle);
        fVar.show(getChildFragmentManager(), f.class.getName());
    }

    static final class ag implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55906a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f55907b;

        ag(c cVar, BottomSheetBehavior bottomSheetBehavior) {
            this.f55906a = cVar;
            this.f55907b = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f55907b.setState(4);
        }
    }

    static final class ah implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f55909b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f55910c;

        ah(c cVar, Activity activity, com.google.android.material.bottomsheet.a aVar) {
            this.f55908a = cVar;
            this.f55909b = activity;
            this.f55910c = aVar;
        }

        public final void onClick(View view) {
            String str;
            androidx.databinding.i<String> iVar;
            Context context = this.f55909b;
            String[] strArr = new String[4];
            strArr[0] = "";
            strArr[1] = "";
            strArr[2] = "";
            net.one97.paytm.newaddmoney.c.a h2 = this.f55908a.f55893c;
            if (h2 == null || (iVar = h2.k) == null) {
                str = null;
            } else {
                str = iVar.get();
            }
            strArr[3] = str;
            net.one97.paytm.addmoney.utils.d.a(context, "gift_voucher", "gv_knowmore_closed", "/gift-voucher", (ArrayList<String>) kotlin.a.k.d(strArr), (String) null);
            this.f55910c.dismiss();
        }
    }

    static final class ai implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f55911a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f55912b;

        ai(Activity activity, com.google.android.material.bottomsheet.a aVar) {
            this.f55911a = activity;
            this.f55912b = aVar;
        }

        public final void onClick(View view) {
            Intent b2 = net.one97.paytm.helper.a.f50546a.a().b(this.f55911a);
            b2.putExtra("url", "https://www.paytmbank.com/Terms&Conditions");
            b2.putExtra("title", this.f55911a.getString(R.string.uam_gv_t_n_c));
            this.f55911a.startActivity(b2);
            this.f55912b.dismiss();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        r0 = r0.o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r10 = this;
            android.content.Context r0 = r10.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            java.lang.String r0 = r10.f55897g
            if (r0 == 0) goto L_0x00b1
            java.lang.String r2 = "getAddMoneyAmount()"
            if (r0 == 0) goto L_0x0095
            net.one97.paytm.newaddmoney.utils.d r3 = net.one97.paytm.newaddmoney.utils.d.PAYTM_MIN_KYC
            java.lang.String r3 = r3.name()
            boolean r0 = r0.equals(r3)
            r3 = 1
            if (r0 != r3) goto L_0x0095
            net.one97.paytm.newaddmoney.c.a r0 = r10.f55893c
            if (r0 == 0) goto L_0x002f
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r0 = r0.o
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.newaddmoney.utils.b r0 = (net.one97.paytm.newaddmoney.utils.b) r0
            goto L_0x0030
        L_0x002f:
            r0 = r1
        L_0x0030:
            net.one97.paytm.newaddmoney.utils.b r4 = net.one97.paytm.newaddmoney.utils.b.TO_WALLET
            if (r0 != r4) goto L_0x0095
            net.one97.paytm.newaddmoney.c.a r0 = r10.f55893c
            if (r0 == 0) goto L_0x0091
            java.lang.String r4 = r10.e()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            java.lang.String r5 = "amount"
            kotlin.g.b.k.c(r4, r5)
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r6 = 0
            if (r5 == 0) goto L_0x0056
            androidx.lifecycle.y<kotlin.x> r0 = r0.q
            kotlin.x r4 = kotlin.x.f47997a
            r0.setValue(r4)
            goto L_0x0072
        L_0x0056:
            java.lang.String r4 = com.paytm.utility.b.Q((java.lang.String) r4)
            java.lang.String r5 = "CJRAppCommonUtility.getCleanString(amount)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            double r4 = java.lang.Double.parseDouble(r4)
            double r7 = r0.A
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0071
            androidx.lifecycle.y<java.lang.Boolean> r0 = r0.f55838h
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r0.setValue(r4)
            goto L_0x0072
        L_0x0071:
            r6 = 1
        L_0x0072:
            if (r6 != r3) goto L_0x0091
            net.one97.paytm.newaddmoney.c.a r0 = r10.f55893c
            if (r0 == 0) goto L_0x0090
            java.lang.String r3 = r10.e()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            net.one97.paytm.newaddmoney.c.a r2 = r10.f55893c
            if (r2 == 0) goto L_0x008d
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r2 = r2.o
            if (r2 == 0) goto L_0x008d
            java.lang.Object r1 = r2.getValue()
            net.one97.paytm.newaddmoney.utils.b r1 = (net.one97.paytm.newaddmoney.utils.b) r1
        L_0x008d:
            r0.a(r3, r1)
        L_0x0090:
            return
        L_0x0091:
            r10.b((boolean) r3)
            return
        L_0x0095:
            net.one97.paytm.newaddmoney.c.a r0 = r10.f55893c
            if (r0 == 0) goto L_0x00b1
            java.lang.String r3 = r10.e()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            net.one97.paytm.newaddmoney.c.a r2 = r10.f55893c
            if (r2 == 0) goto L_0x00ae
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r2 = r2.o
            if (r2 == 0) goto L_0x00ae
            java.lang.Object r1 = r2.getValue()
            net.one97.paytm.newaddmoney.utils.b r1 = (net.one97.paytm.newaddmoney.utils.b) r1
        L_0x00ae:
            r0.a(r3, r1)
        L_0x00b1:
            return
        L_0x00b2:
            r10.a((com.paytm.network.a) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.c():void");
    }

    static final class ac implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55902a;

        ac(c cVar) {
            this.f55902a = cVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                if (this.f55902a.f55899i) {
                    this.f55902a.f55899i = false;
                }
                View view2 = c.e(this.f55902a).f48063b;
                Context context = this.f55902a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                view2.setBackgroundColor(androidx.core.content.b.c(context, R.color.paytm_blue_selected));
                net.one97.paytm.newaddmoney.c.a h2 = this.f55902a.f55893c;
                if (h2 != null) {
                    h2.b();
                    return;
                }
                return;
            }
            View view3 = c.e(this.f55902a).f48063b;
            Context context2 = this.f55902a.getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            view3.setBackgroundColor(androidx.core.content.b.c(context2, R.color.color_e8edf3));
        }
    }

    public static final class ad implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55903a;

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        ad(c cVar) {
            this.f55903a = cVar;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            c cVar = this.f55903a;
            cVar.f55895e = cVar.e();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
            r2 = r2.o;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void afterTextChanged(android.text.Editable r9) {
            /*
                r8 = this;
                net.one97.paytm.newaddmoney.view.c r0 = r8.f55903a
                java.lang.String r1 = java.lang.String.valueOf(r9)
                boolean r0 = r0.b((java.lang.String) r1)
                java.lang.String r1 = ""
                if (r0 == 0) goto L_0x0013
                net.one97.paytm.newaddmoney.view.c r0 = r8.f55903a
                r0.a(false, (java.lang.String) r1, (java.lang.String) r1)
            L_0x0013:
                r0 = 0
                if (r9 == 0) goto L_0x003b
                int r2 = r9.length()
                if (r2 != 0) goto L_0x003b
                net.one97.paytm.newaddmoney.view.c r9 = r8.f55903a
                net.one97.paytm.addmoney.a.k r9 = net.one97.paytm.newaddmoney.view.c.e(r9)
                android.widget.TextView r9 = r9.C
                if (r9 == 0) goto L_0x0095
                net.one97.paytm.newaddmoney.view.c r2 = r8.f55903a
                android.content.Context r2 = r2.getContext()
                if (r2 != 0) goto L_0x0031
                kotlin.g.b.k.a()
            L_0x0031:
                int r3 = net.one97.paytm.addmoney.R.color.color_7f8386
                int r2 = androidx.core.content.b.c(r2, r3)
                r9.setTextColor(r2)
                goto L_0x0095
            L_0x003b:
                net.one97.paytm.newaddmoney.view.c r2 = r8.f55903a
                net.one97.paytm.newaddmoney.c.a r2 = r2.f55893c
                if (r2 == 0) goto L_0x004a
                androidx.databinding.i<java.lang.String> r2 = r2.l
                if (r2 == 0) goto L_0x004a
                r2.set(r1)
            L_0x004a:
                net.one97.paytm.newaddmoney.view.c r2 = r8.f55903a
                net.one97.paytm.addmoney.a.k r2 = net.one97.paytm.newaddmoney.view.c.e(r2)
                android.widget.TextView r2 = r2.C
                if (r2 == 0) goto L_0x0068
                net.one97.paytm.newaddmoney.view.c r3 = r8.f55903a
                android.content.Context r3 = r3.getContext()
                if (r3 != 0) goto L_0x005f
                kotlin.g.b.k.a()
            L_0x005f:
                int r4 = net.one97.paytm.addmoney.R.color.black
                int r3 = androidx.core.content.b.c(r3, r4)
                r2.setTextColor(r3)
            L_0x0068:
                net.one97.paytm.newaddmoney.view.c r2 = r8.f55903a
                java.lang.String r3 = java.lang.String.valueOf(r9)
                boolean r2 = r2.b((java.lang.String) r3)
                if (r2 == 0) goto L_0x0095
                net.one97.paytm.newaddmoney.view.c r2 = r8.f55903a
                net.one97.paytm.newaddmoney.c.a r2 = r2.f55893c
                if (r2 == 0) goto L_0x0087
                androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r2 = r2.o
                if (r2 == 0) goto L_0x0087
                java.lang.Object r2 = r2.getValue()
                net.one97.paytm.newaddmoney.utils.b r2 = (net.one97.paytm.newaddmoney.utils.b) r2
                goto L_0x0088
            L_0x0087:
                r2 = r0
            L_0x0088:
                net.one97.paytm.newaddmoney.utils.b r3 = net.one97.paytm.newaddmoney.utils.b.TO_WALLET
                if (r2 != r3) goto L_0x0095
                net.one97.paytm.newaddmoney.view.c r2 = r8.f55903a
                java.lang.String r9 = java.lang.String.valueOf(r9)
                net.one97.paytm.newaddmoney.view.c.e(r2, r9)
            L_0x0095:
                net.one97.paytm.newaddmoney.view.c r9 = r8.f55903a
                android.content.Context r2 = r9.getContext()
                r9 = 4
                java.lang.String[] r9 = new java.lang.String[r9]
                r3 = 0
                net.one97.paytm.newaddmoney.view.c r4 = r8.f55903a
                androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
                android.content.Context r4 = (android.content.Context) r4
                java.lang.String r4 = net.one97.paytm.newaddmoney.utils.e.a(r4)
                r9[r3] = r4
                r3 = 1
                r9[r3] = r1
                r3 = 2
                r9[r3] = r1
                r1 = 3
                net.one97.paytm.newaddmoney.view.c r3 = r8.f55903a
                net.one97.paytm.newaddmoney.c.a r3 = r3.f55893c
                if (r3 == 0) goto L_0x00c6
                androidx.databinding.i<java.lang.String> r3 = r3.k
                if (r3 == 0) goto L_0x00c6
                java.lang.Object r0 = r3.get()
                java.lang.String r0 = (java.lang.String) r0
            L_0x00c6:
                r9[r1] = r0
                java.util.ArrayList r6 = kotlin.a.k.d(r9)
                r7 = 0
                java.lang.String r3 = "add_money"
                java.lang.String r4 = "add_money_amount_entered"
                java.lang.String r5 = "/add-money"
                net.one97.paytm.addmoney.utils.d.a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.util.ArrayList<java.lang.String>) r6, (java.lang.String) r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.ad.afterTextChanged(android.text.Editable):void");
        }
    }

    /* access modifiers changed from: private */
    public final boolean b(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f55895e)) {
            try {
                String Q = com.paytm.utility.b.Q(str);
                kotlin.g.b.k.a((Object) Q, "CJRAppCommonUtility.getCleanString(editAmount)");
                double parseDouble = Double.parseDouble(Q);
                String str2 = this.f55895e;
                if (str2 == null || parseDouble != Double.parseDouble(str2)) {
                    return true;
                }
                return false;
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    static final class u implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55935a;

        u(c cVar) {
            this.f55935a = cVar;
        }

        public final void onClick(View view) {
            c.i(this.f55935a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r0.o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0028
            net.one97.paytm.newaddmoney.c.a r0 = r2.f55893c
            if (r0 == 0) goto L_0x0011
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r0 = r0.o
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.newaddmoney.utils.b r0 = (net.one97.paytm.newaddmoney.utils.b) r0
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            net.one97.paytm.newaddmoney.utils.b r1 = net.one97.paytm.newaddmoney.utils.b.TO_WALLET
            if (r0 != r1) goto L_0x0028
            r3 = 1
            r2.b((boolean) r3)
            net.one97.paytm.newaddmoney.c.a r3 = r2.f55893c
            if (r3 == 0) goto L_0x0027
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r3 = r3.o
            if (r3 == 0) goto L_0x0027
            net.one97.paytm.newaddmoney.utils.b r0 = net.one97.paytm.newaddmoney.utils.b.TO_GIFTVOUCHER
            r3.setValue(r0)
        L_0x0027:
            return
        L_0x0028:
            if (r3 != 0) goto L_0x003b
            r3 = 0
            r2.b((boolean) r3)
            net.one97.paytm.newaddmoney.c.a r3 = r2.f55893c
            if (r3 == 0) goto L_0x003b
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r3 = r3.o
            if (r3 == 0) goto L_0x003b
            net.one97.paytm.newaddmoney.utils.b r0 = net.one97.paytm.newaddmoney.utils.b.TO_WALLET
            r3.setValue(r0)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.a(boolean):void");
    }

    /* access modifiers changed from: private */
    public final void b(boolean z2) {
        net.one97.paytm.addmoney.a.k kVar = this.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        ImageView imageView = kVar != null ? kVar.o : null;
        kotlin.g.b.k.a((Object) imageView, "binder?.info");
        net.one97.paytm.newaddmoney.utils.c.a((View) imageView, z2);
    }

    /* access modifiers changed from: package-private */
    public final void a(net.one97.paytm.autoaddmoney.b.d dVar) {
        if (d()) {
            if (dVar.f49160b) {
                net.one97.paytm.addmoney.a.k kVar = this.f55892b;
                if (kVar == null) {
                    kotlin.g.b.k.a("binder");
                }
                RelativeLayout relativeLayout = kVar.s;
                kotlin.g.b.k.a((Object) relativeLayout, "binder.loaderContainer");
                relativeLayout.setVisibility(0);
                net.one97.paytm.addmoney.a.k kVar2 = this.f55892b;
                if (kVar2 == null) {
                    kotlin.g.b.k.a("binder");
                }
                net.one97.paytm.common.widgets.a.a(kVar2.O);
            } else if (dVar.f49160b) {
                net.one97.paytm.addmoney.a.k kVar3 = this.f55892b;
                if (kVar3 == null) {
                    kotlin.g.b.k.a("binder");
                }
                TextView textView = kVar3.w;
                kotlin.g.b.k.a((Object) textView, "binder.proceed");
                textView.setEnabled(false);
                net.one97.paytm.addmoney.a.k kVar4 = this.f55892b;
                if (kVar4 == null) {
                    kotlin.g.b.k.a("binder");
                }
                RelativeLayout relativeLayout2 = kVar4.s;
                kotlin.g.b.k.a((Object) relativeLayout2, "binder.loaderContainer");
                relativeLayout2.setVisibility(0);
                net.one97.paytm.addmoney.a.k kVar5 = this.f55892b;
                if (kVar5 == null) {
                    kotlin.g.b.k.a("binder");
                }
                net.one97.paytm.common.widgets.a.a(kVar5.O);
            } else {
                net.one97.paytm.addmoney.a.k kVar6 = this.f55892b;
                if (kVar6 == null) {
                    kotlin.g.b.k.a("binder");
                }
                TextView textView2 = kVar6.w;
                kotlin.g.b.k.a((Object) textView2, "binder.proceed");
                textView2.setEnabled(true);
                net.one97.paytm.addmoney.a.k kVar7 = this.f55892b;
                if (kVar7 == null) {
                    kotlin.g.b.k.a("binder");
                }
                RelativeLayout relativeLayout3 = kVar7.s;
                kotlin.g.b.k.a((Object) relativeLayout3, "binder.loaderContainer");
                relativeLayout3.setVisibility(8);
                net.one97.paytm.addmoney.a.k kVar8 = this.f55892b;
                if (kVar8 == null) {
                    kotlin.g.b.k.a("binder");
                }
                net.one97.paytm.common.widgets.a.b(kVar8.O);
            }
        }
    }

    public final void a(String str, String str2) {
        this.f55891a = str;
        a(true, str, str2);
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2, String str, String str2) {
        net.one97.paytm.wallet.d.c cVar;
        net.one97.paytm.wallet.d.c cVar2;
        if (z2) {
            net.one97.paytm.addmoney.a.k kVar = this.f55892b;
            if (kVar == null) {
                kotlin.g.b.k.a("binder");
            }
            TextView textView = kVar.f48065d;
            kotlin.g.b.k.a((Object) textView, "binder.applyPromoText");
            textView.setVisibility(8);
            net.one97.paytm.addmoney.a.k kVar2 = this.f55892b;
            if (kVar2 == null) {
                kotlin.g.b.k.a("binder");
            }
            ImageView imageView = kVar2.B;
            kotlin.g.b.k.a((Object) imageView, "binder.removeCoupon");
            imageView.setVisibility(0);
            net.one97.paytm.addmoney.a.k kVar3 = this.f55892b;
            if (kVar3 == null) {
                kotlin.g.b.k.a("binder");
            }
            TextView textView2 = kVar3.J;
            kotlin.g.b.k.a((Object) textView2, "binder.tvAppliedCouponText");
            textView2.setVisibility(0);
            net.one97.paytm.addmoney.a.k kVar4 = this.f55892b;
            if (kVar4 == null) {
                kotlin.g.b.k.a("binder");
            }
            TextView textView3 = kVar4.J;
            kotlin.g.b.k.a((Object) textView3, "binder.tvAppliedCouponText");
            textView3.setText(getString(R.string.applied_promo_text, str));
            net.one97.paytm.addmoney.a.k kVar5 = this.f55892b;
            if (kVar5 == null) {
                kotlin.g.b.k.a("binder");
            }
            TextView textView4 = kVar5.y;
            kotlin.g.b.k.a((Object) textView4, "binder.promoApplyMessage");
            net.one97.paytm.newaddmoney.utils.c.a(textView4, str2);
            this.f55891a = str;
            net.one97.paytm.newaddmoney.c.a aVar = this.f55893c;
            if (aVar != null && (cVar2 = aVar.f55831a) != null) {
                cVar2.e(str);
                return;
            }
            return;
        }
        net.one97.paytm.addmoney.a.k kVar6 = this.f55892b;
        if (kVar6 == null) {
            kotlin.g.b.k.a("binder");
        }
        ImageView imageView2 = kVar6.B;
        kotlin.g.b.k.a((Object) imageView2, "binder.removeCoupon");
        imageView2.setVisibility(8);
        net.one97.paytm.addmoney.a.k kVar7 = this.f55892b;
        if (kVar7 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView5 = kVar7.y;
        kotlin.g.b.k.a((Object) textView5, "binder.promoApplyMessage");
        textView5.setVisibility(8);
        net.one97.paytm.addmoney.a.k kVar8 = this.f55892b;
        if (kVar8 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView6 = kVar8.f48065d;
        kotlin.g.b.k.a((Object) textView6, "binder.applyPromoText");
        textView6.setVisibility(0);
        net.one97.paytm.addmoney.a.k kVar9 = this.f55892b;
        if (kVar9 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView7 = kVar9.v;
        kotlin.g.b.k.a((Object) textView7, "binder.offerDetailsText");
        textView7.setVisibility(8);
        net.one97.paytm.addmoney.a.k kVar10 = this.f55892b;
        if (kVar10 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView8 = kVar10.J;
        kotlin.g.b.k.a((Object) textView8, "binder.tvAppliedCouponText");
        textView8.setVisibility(8);
        net.one97.paytm.newaddmoney.c.a aVar2 = this.f55893c;
        if (!(aVar2 == null || (cVar = aVar2.f55831a) == null)) {
            cVar.d();
        }
        this.f55891a = null;
    }

    public final void a(com.paytm.network.a aVar) {
        if (d()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getResources().getString(R.string.no_connection));
            builder.setMessage(getResources().getString(R.string.no_internet));
            if (aVar != null) {
                builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new aj(this, aVar));
            } else {
                builder.setPositiveButton(getResources().getString(R.string.ok), ak.f55915a);
            }
            builder.show();
        }
    }

    static final class aj implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55913a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f55914b;

        aj(c cVar, com.paytm.network.a aVar) {
            this.f55913a = cVar;
            this.f55914b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f55913a.getActivity())) {
                net.one97.paytm.newaddmoney.c.a h2 = this.f55913a.f55893c;
                if (h2 != null) {
                    h2.d();
                }
                this.f55914b.a();
                return;
            }
            this.f55913a.a(this.f55914b);
        }
    }

    static final class ak implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final ak f55915a = new ak();

        ak() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
        }
    }

    /* access modifiers changed from: private */
    public final boolean d() {
        if (getActivity() == null) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        return !activity.isFinishing();
    }

    /* access modifiers changed from: private */
    public final String e() {
        net.one97.paytm.addmoney.a.k kVar = this.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText = kVar.f48064c;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText, "binder.amwAmountInputEt");
        return com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText.getText()));
    }

    static final class t<T> implements androidx.lifecycle.z<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55934a;

        t(c cVar) {
            this.f55934a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c.i(this.f55934a);
        }
    }

    static final class i<T> implements androidx.lifecycle.z<kotlin.x> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f55923a;

        i(c cVar) {
            this.f55923a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            androidx.databinding.i<String> iVar;
            c.e(this.f55923a).f48064c.requestFocus();
            c.r(this.f55923a);
            net.one97.paytm.newaddmoney.c.a h2 = this.f55923a.f55893c;
            if (h2 != null && (iVar = h2.l) != null) {
                iVar.set(this.f55923a.getString(R.string.enter_valid_amnt));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.F;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.newaddmoney.view.c r10) {
        /*
            net.one97.paytm.newaddmoney.c.a r0 = r10.f55893c
            r1 = 0
            if (r0 == 0) goto L_0x0012
            androidx.lifecycle.y<java.lang.Boolean> r0 = r0.F
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            if (r0 != 0) goto L_0x0018
            kotlin.g.b.k.a()
        L_0x0018:
            java.lang.String r2 = "viewModel?.subWalletVisibile?.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0026
            java.lang.String r0 = "closed"
            goto L_0x0028
        L_0x0026:
            java.lang.String r0 = "open"
        L_0x0028:
            androidx.fragment.app.FragmentActivity r2 = r10.getActivity()
            if (r2 != 0) goto L_0x0031
            kotlin.g.b.k.a()
        L_0x0031:
            r3 = r2
            android.content.Context r3 = (android.content.Context) r3
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]
            r9 = 0
            r2[r9] = r0
            r0 = 1
            java.lang.String r4 = ""
            r2[r0] = r4
            r0 = 2
            r2[r0] = r4
            r0 = 3
            net.one97.paytm.newaddmoney.c.a r4 = r10.f55893c
            if (r4 == 0) goto L_0x0052
            androidx.databinding.i<java.lang.String> r4 = r4.k
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0053
        L_0x0052:
            r4 = r1
        L_0x0053:
            r2[r0] = r4
            java.util.ArrayList r7 = kotlin.a.k.d(r2)
            java.lang.String r4 = "add_money"
            java.lang.String r5 = "paytm_bal_dropdown_clicked"
            java.lang.String r6 = "/add-money"
            java.lang.String r8 = ""
            net.one97.paytm.addmoney.utils.d.a((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.util.ArrayList<java.lang.String>) r7, (java.lang.String) r8)
            net.one97.paytm.newaddmoney.c.a r10 = r10.f55893c
            if (r10 == 0) goto L_0x00db
            androidx.lifecycle.y<java.lang.Boolean> r0 = r10.F
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            java.lang.String r2 = "subWalletVisibile.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0086
            r10.b()
            return
        L_0x0086:
            androidx.lifecycle.y<java.lang.Boolean> r0 = r10.F
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x0093
            kotlin.g.b.k.a()
        L_0x0093:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00db
            androidx.databinding.i<java.lang.Integer> r0 = r10.C
            r2 = 180(0xb4, float:2.52E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.set(r2)
            androidx.databinding.i<java.lang.String> r0 = r10.D
            androidx.databinding.i<java.lang.String> r2 = r10.f55836f
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00c8
            if (r2 == 0) goto L_0x00c0
            r1 = 24
            java.lang.String r1 = r2.substring(r9, r1)
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            goto L_0x00c8
        L_0x00c0:
            kotlin.u r10 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r10.<init>(r0)
            throw r10
        L_0x00c8:
            r0.set(r1)
            androidx.databinding.i<java.lang.Integer> r0 = r10.E
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            r0.set(r1)
            androidx.lifecycle.y<java.lang.Boolean> r10 = r10.F
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r10.setValue(r0)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.b(net.one97.paytm.newaddmoney.view.c):void");
    }

    public static final /* synthetic */ void f(c cVar) {
        net.one97.paytm.addmoney.a.k kVar = cVar.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView = kVar.G;
        kotlin.g.b.k.a((Object) textView, "binder.tvAddmoney");
        textView.setVisibility(4);
        net.one97.paytm.addmoney.a.k kVar2 = cVar.f55892b;
        if (kVar2 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView2 = kVar2.M;
        kotlin.g.b.k.a((Object) textView2, "binder.tvWalletBalance");
        textView2.setVisibility(4);
        net.one97.paytm.addmoney.a.k kVar3 = cVar.f55892b;
        if (kVar3 == null) {
            kotlin.g.b.k.a("binder");
        }
        ImageView imageView = kVar3.q;
        kotlin.g.b.k.a((Object) imageView, "binder.ivWalletBalArrow");
        imageView.setVisibility(4);
        net.one97.paytm.addmoney.a.k kVar4 = cVar.f55892b;
        if (kVar4 == null) {
            kotlin.g.b.k.a("binder");
        }
        Group group = kVar4.f48062a;
        kotlin.g.b.k.a((Object) group, "binder.actionGroup");
        group.setVisibility(8);
        int[] iArr = {0, 0};
        net.one97.paytm.addmoney.a.k kVar5 = cVar.f55892b;
        if (kVar5 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar5.n.getLocationOnScreen(iArr);
        int[] iArr2 = {0, 0};
        net.one97.paytm.addmoney.a.k kVar6 = cVar.f55892b;
        if (kVar6 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar6.m.getLocationOnScreen(iArr2);
        net.one97.paytm.addmoney.a.k kVar7 = cVar.f55892b;
        if (kVar7 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView3 = kVar7.N;
        kotlin.g.b.k.a((Object) textView3, "binder.tvWalletBalanceTop");
        textView3.setTranslationY(0.0f);
        net.one97.paytm.addmoney.a.k kVar8 = cVar.f55892b;
        if (kVar8 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView4 = kVar8.H;
        kotlin.g.b.k.a((Object) textView4, "binder.tvAddmoneyTop");
        textView4.setScaleX(1.0f);
        net.one97.paytm.addmoney.a.k kVar9 = cVar.f55892b;
        if (kVar9 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView5 = kVar9.H;
        kotlin.g.b.k.a((Object) textView5, "binder.tvAddmoneyTop");
        textView5.setScaleY(1.0f);
        net.one97.paytm.addmoney.a.k kVar10 = cVar.f55892b;
        if (kVar10 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView6 = kVar10.H;
        kotlin.g.b.k.a((Object) textView6, "binder.tvAddmoneyTop");
        textView6.setTranslationX(0.0f);
        net.one97.paytm.addmoney.a.k kVar11 = cVar.f55892b;
        if (kVar11 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView7 = kVar11.H;
        kotlin.g.b.k.a((Object) textView7, "binder.tvAddmoneyTop");
        textView7.setTranslationY(0.0f);
        net.one97.paytm.addmoney.a.k kVar12 = cVar.f55892b;
        if (kVar12 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout = kVar12.n;
        kotlin.g.b.k.a((Object) constraintLayout, "binder.headContainerTop");
        constraintLayout.setTranslationX(((float) iArr2[0]) - ((float) iArr[0]));
        net.one97.paytm.addmoney.a.k kVar13 = cVar.f55892b;
        if (kVar13 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout2 = kVar13.n;
        kotlin.g.b.k.a((Object) constraintLayout2, "binder.headContainerTop");
        constraintLayout2.setTranslationY(((float) iArr2[1]) - ((float) iArr[1]));
        net.one97.paytm.addmoney.a.k kVar14 = cVar.f55892b;
        if (kVar14 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout3 = kVar14.n;
        kotlin.g.b.k.a((Object) constraintLayout3, "binder.headContainerTop");
        constraintLayout3.setVisibility(0);
        net.one97.paytm.addmoney.a.k kVar15 = cVar.f55892b;
        if (kVar15 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout4 = kVar15.m;
        kotlin.g.b.k.a((Object) constraintLayout4, "binder.headContainer");
        constraintLayout4.setVisibility(8);
        cVar.a(1.0f);
        net.one97.paytm.addmoney.a.k kVar16 = cVar.f55892b;
        if (kVar16 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar16.n.animate().translationY(0.0f).translationX(0.0f).setDuration(cVar.k).setListener(new af(cVar)).start();
        net.one97.paytm.addmoney.a.k kVar17 = cVar.f55892b;
        if (kVar17 == null) {
            kotlin.g.b.k.a("binder");
        }
        ViewPropertyAnimator scaleY = kVar17.H.animate().scaleX(0.75f).scaleY(0.75f);
        net.one97.paytm.addmoney.a.k kVar18 = cVar.f55892b;
        if (kVar18 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView8 = kVar18.H;
        kotlin.g.b.k.a((Object) textView8, "binder.tvAddmoneyTop");
        ViewPropertyAnimator translationX = scaleY.translationX(((float) textView8.getWidth()) * -0.125f);
        net.one97.paytm.addmoney.a.k kVar19 = cVar.f55892b;
        if (kVar19 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView9 = kVar19.H;
        kotlin.g.b.k.a((Object) textView9, "binder.tvAddmoneyTop");
        translationX.translationY(-0.125f * ((float) textView9.getHeight())).setDuration(cVar.k).start();
        net.one97.paytm.addmoney.a.k kVar20 = cVar.f55892b;
        if (kVar20 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar20.N.animate().translationY((float) AddMoneyUtils.a()).setDuration(cVar.k).start();
    }

    public static final /* synthetic */ void g(c cVar) {
        net.one97.paytm.addmoney.a.k kVar = cVar.f55892b;
        if (kVar == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout = kVar.m;
        kotlin.g.b.k.a((Object) constraintLayout, "binder.headContainer");
        constraintLayout.setVisibility(4);
        net.one97.paytm.addmoney.a.k kVar2 = cVar.f55892b;
        if (kVar2 == null) {
            kotlin.g.b.k.a("binder");
        }
        Group group = kVar2.f48062a;
        kotlin.g.b.k.a((Object) group, "binder.actionGroup");
        group.setVisibility(0);
        int[] iArr = {0, 0};
        net.one97.paytm.addmoney.a.k kVar3 = cVar.f55892b;
        if (kVar3 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar3.m.getLocationOnScreen(iArr);
        int[] iArr2 = {0, 0};
        net.one97.paytm.addmoney.a.k kVar4 = cVar.f55892b;
        if (kVar4 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar4.n.getLocationOnScreen(iArr2);
        net.one97.paytm.addmoney.a.k kVar5 = cVar.f55892b;
        if (kVar5 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView = kVar5.M;
        kotlin.g.b.k.a((Object) textView, "binder.tvWalletBalance");
        textView.setTranslationY((float) AddMoneyUtils.a());
        net.one97.paytm.addmoney.a.k kVar6 = cVar.f55892b;
        if (kVar6 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView2 = kVar6.G;
        kotlin.g.b.k.a((Object) textView2, "binder.tvAddmoney");
        net.one97.paytm.addmoney.a.k kVar7 = cVar.f55892b;
        if (kVar7 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView3 = kVar7.G;
        kotlin.g.b.k.a((Object) textView3, "binder.tvAddmoney");
        textView2.setTranslationY(((float) textView3.getHeight()) * -0.125f);
        net.one97.paytm.addmoney.a.k kVar8 = cVar.f55892b;
        if (kVar8 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView4 = kVar8.G;
        kotlin.g.b.k.a((Object) textView4, "binder.tvAddmoney");
        net.one97.paytm.addmoney.a.k kVar9 = cVar.f55892b;
        if (kVar9 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView5 = kVar9.G;
        kotlin.g.b.k.a((Object) textView5, "binder.tvAddmoney");
        textView4.setTranslationX(-0.125f * ((float) textView5.getWidth()));
        net.one97.paytm.addmoney.a.k kVar10 = cVar.f55892b;
        if (kVar10 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView6 = kVar10.G;
        kotlin.g.b.k.a((Object) textView6, "binder.tvAddmoney");
        textView6.setScaleX(0.75f);
        net.one97.paytm.addmoney.a.k kVar11 = cVar.f55892b;
        if (kVar11 == null) {
            kotlin.g.b.k.a("binder");
        }
        TextView textView7 = kVar11.G;
        kotlin.g.b.k.a((Object) textView7, "binder.tvAddmoney");
        textView7.setScaleY(0.75f);
        net.one97.paytm.addmoney.a.k kVar12 = cVar.f55892b;
        if (kVar12 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout2 = kVar12.m;
        kotlin.g.b.k.a((Object) constraintLayout2, "binder.headContainer");
        constraintLayout2.setTranslationX(((float) iArr2[0]) - ((float) iArr[0]));
        net.one97.paytm.addmoney.a.k kVar13 = cVar.f55892b;
        if (kVar13 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout3 = kVar13.m;
        kotlin.g.b.k.a((Object) constraintLayout3, "binder.headContainer");
        constraintLayout3.setTranslationY(((float) iArr2[1]) - ((float) iArr[1]));
        net.one97.paytm.addmoney.a.k kVar14 = cVar.f55892b;
        if (kVar14 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout4 = kVar14.m;
        kotlin.g.b.k.a((Object) constraintLayout4, "binder.headContainer");
        constraintLayout4.setVisibility(0);
        net.one97.paytm.addmoney.a.k kVar15 = cVar.f55892b;
        if (kVar15 == null) {
            kotlin.g.b.k.a("binder");
        }
        ConstraintLayout constraintLayout5 = kVar15.n;
        kotlin.g.b.k.a((Object) constraintLayout5, "binder.headContainerTop");
        constraintLayout5.setVisibility(4);
        net.one97.paytm.addmoney.a.k kVar16 = cVar.f55892b;
        if (kVar16 == null) {
            kotlin.g.b.k.a("binder");
        }
        View view = kVar16.l;
        kotlin.g.b.k.a((Object) view, "binder.headBorder");
        view.setVisibility(4);
        cVar.a(0.0f);
        net.one97.paytm.addmoney.a.k kVar17 = cVar.f55892b;
        if (kVar17 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar17.f48064c.clearFocus();
        net.one97.paytm.addmoney.a.k kVar18 = cVar.f55892b;
        if (kVar18 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar18.m.animate().translationX(0.0f).translationY(0.0f).setDuration(cVar.k).setListener(new ae(cVar)).start();
        net.one97.paytm.addmoney.a.k kVar19 = cVar.f55892b;
        if (kVar19 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar19.G.animate().scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setDuration(cVar.k).start();
        net.one97.paytm.addmoney.a.k kVar20 = cVar.f55892b;
        if (kVar20 == null) {
            kotlin.g.b.k.a("binder");
        }
        kVar20.M.animate().translationY(0.0f).setDuration(cVar.k).start();
    }

    public static final /* synthetic */ String a(String str) {
        if (kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.MAKE_PAYMENT.name())) {
            return "make_payment_clicked";
        }
        if (kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.GIFT_PAYTM_CASH.name())) {
            return "giftvoucher_clicked";
        }
        if (kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.SEND_MONEY_TO_BANK.name())) {
            return "p2b_clicked";
        }
        if (kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.SETUP_AUTOMATIC.name())) {
            return "automatic_addmoney_clicked";
        }
        if (kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.NEARBY_CASH_DEPOSIT_POINTS.name())) {
            return "nearby_cashpoint_clicked";
        }
        if (kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.SET_PAYMENT_REMINDER.name())) {
            return "payment_reminder_clicked";
        }
        if (kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.VIEW_SPEND_ANALYTICS.name())) {
            return "spend_analytics_clicked";
        }
        return kotlin.g.b.k.a((Object) str, (Object) net.one97.paytm.newaddmoney.b.c.REQUEST_WALLET_STATEMENT.name()) ? "request_statement_clicked" : "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void i(net.one97.paytm.newaddmoney.view.c r13) {
        /*
            net.one97.paytm.newaddmoney.c.a r0 = r13.f55893c
            r1 = 0
            if (r0 == 0) goto L_0x0010
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r0 = r0.o
            if (r0 == 0) goto L_0x0010
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.newaddmoney.utils.b r0 = (net.one97.paytm.newaddmoney.utils.b) r0
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            net.one97.paytm.newaddmoney.utils.b r2 = net.one97.paytm.newaddmoney.utils.b.TO_WALLET
            java.lang.String r3 = "getAddMoneyAmount()"
            r4 = 2
            r5 = 0
            r6 = 1
            if (r0 != r2) goto L_0x006a
            android.content.Context r7 = r13.getContext()
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            androidx.fragment.app.FragmentActivity r2 = r13.getActivity()
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = net.one97.paytm.newaddmoney.utils.e.a(r2)
            r0[r5] = r2
            java.lang.String r2 = "Wallet"
            r0[r6] = r2
            java.lang.String r2 = ""
            r0[r4] = r2
            r2 = 3
            net.one97.paytm.newaddmoney.c.a r4 = r13.f55893c
            if (r4 == 0) goto L_0x0044
            androidx.databinding.i<java.lang.String> r4 = r4.k
            if (r4 == 0) goto L_0x0044
            java.lang.Object r1 = r4.get()
            java.lang.String r1 = (java.lang.String) r1
        L_0x0044:
            r0[r2] = r1
            java.util.ArrayList r11 = kotlin.a.k.d(r0)
            java.lang.String r8 = "add_money"
            java.lang.String r9 = "add_money_proceed"
            java.lang.String r10 = "/add-money"
            java.lang.String r12 = ""
            net.one97.paytm.addmoney.utils.d.a((android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.util.ArrayList<java.lang.String>) r11, (java.lang.String) r12)
            net.one97.paytm.newaddmoney.c.a r0 = r13.f55893c
            if (r0 == 0) goto L_0x0069
            java.lang.String r1 = r13.e()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            boolean r0 = r0.b((java.lang.String) r1)
            if (r0 != r6) goto L_0x00ec
            r13.c()
        L_0x0069:
            return
        L_0x006a:
            android.content.Context r7 = r13.getContext()
            java.lang.String[] r0 = new java.lang.String[r4]
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = net.one97.paytm.newaddmoney.utils.e.a(r1)
            r0[r5] = r1
            java.lang.String r1 = "GV"
            r0[r6] = r1
            java.util.ArrayList r11 = kotlin.a.k.d(r0)
            java.lang.String r8 = "add_money"
            java.lang.String r9 = "add_money_proceed"
            java.lang.String r10 = "/add-money"
            java.lang.String r12 = ""
            net.one97.paytm.addmoney.utils.d.a((android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.util.ArrayList<java.lang.String>) r11, (java.lang.String) r12)
            net.one97.paytm.newaddmoney.c.a r0 = r13.f55893c
            if (r0 == 0) goto L_0x00ec
            java.lang.String r1 = r13.e()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r2 = "amount"
            kotlin.g.b.k.c(r1, r2)
            net.one97.paytm.helper.a$a r2 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r2 = r2.a()
            java.lang.String r3 = "gvmaxvalue"
            int r2 = r2.h((java.lang.String) r3)
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x00bc
            androidx.lifecycle.y<kotlin.x> r0 = r0.q
            kotlin.x r1 = kotlin.x.f47997a
            r0.setValue(r1)
            goto L_0x00e7
        L_0x00bc:
            java.lang.String r1 = com.paytm.utility.b.Q((java.lang.String) r1)
            java.lang.String r3 = "CJRAppCommonUtility.getCleanString(amount)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            double r3 = java.lang.Double.parseDouble(r1)
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.lang.String r1 = com.paytm.utility.b.Q((java.lang.String) r1)
            java.lang.String r7 = "CJRAppCommonUtility.getC…(mGvMaxAmount.toString())"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            double r7 = java.lang.Double.parseDouble(r1)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e6
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.a((java.lang.String) r1)
            goto L_0x00e7
        L_0x00e6:
            r5 = 1
        L_0x00e7:
            if (r5 != r6) goto L_0x00ec
            r13.c()
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.i(net.one97.paytm.newaddmoney.view.c):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = r3.o;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void k(net.one97.paytm.newaddmoney.view.c r3) {
        /*
            net.one97.paytm.newaddmoney.c.a r0 = r3.f55893c
            if (r0 == 0) goto L_0x0020
            java.lang.String r1 = r3.e()
            java.lang.String r2 = "getAddMoneyAmount()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.newaddmoney.c.a r3 = r3.f55893c
            if (r3 == 0) goto L_0x001c
            androidx.lifecycle.y<net.one97.paytm.newaddmoney.utils.b> r3 = r3.o
            if (r3 == 0) goto L_0x001c
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.newaddmoney.utils.b r3 = (net.one97.paytm.newaddmoney.utils.b) r3
            goto L_0x001d
        L_0x001c:
            r3 = 0
        L_0x001d:
            r0.a(r1, r3)
        L_0x0020:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.k(net.one97.paytm.newaddmoney.view.c):void");
    }

    public static final /* synthetic */ void b(c cVar, String str) {
        cVar.a(new net.one97.paytm.autoaddmoney.b.d("", false));
        com.paytm.utility.b.b((Context) cVar.getActivity(), "", str);
    }

    public static final /* synthetic */ void n(c cVar) {
        com.paytm.utility.b.c((Activity) cVar.getActivity());
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("amount", com.paytm.utility.b.Q(cVar.e()));
        bundle.putSerializable("Selected_Coupon_Index", cVar.f55891a);
        bundle.putSerializable("add_money_offers", cVar.f55896f);
        aVar.setArguments(bundle);
        aVar.show(cVar.getChildFragmentManager(), a.class.getName());
    }

    public static final /* synthetic */ void a(c cVar, Activity activity) {
        String l2 = net.one97.paytm.helper.a.f50546a.a().l();
        ViewParent viewParent = null;
        View inflate = activity.getLayoutInflater().inflate(R.layout.uam_gv_layout_know_more, (ViewGroup) null);
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(activity);
        aVar.setContentView(inflate);
        if (inflate != null) {
            viewParent = inflate.getParent();
        }
        if (viewParent != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from((View) viewParent);
            kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from…iew?.getParent() as View)");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            from.setPeekHeight(displayMetrics.heightPixels);
            aVar.setOnDismissListener(new ag(cVar, from));
            from.setState(2);
            if (!activity.isFinishing()) {
                aVar.show();
            }
            ((TextView) inflate.findViewById(R.id.tv_title)).setText(l2);
            ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new ah(cVar, activity, aVar));
            ((TextView) inflate.findViewById(R.id.tv_info_2)).setText(activity.getString(R.string.uam_gv_info_2, new Object[]{l2}));
            CharSequence f2 = net.one97.paytm.helper.a.f50546a.a().f("gvpopupknowmore");
            if (!TextUtils.isEmpty(f2)) {
                ((ImageView) inflate.findViewById(R.id.iv_success_3)).setVisibility(0);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_info_3);
                textView.setText(f2);
                textView.setVisibility(0);
            }
            ((TextView) inflate.findViewById(R.id.tv_hint)).setText(activity.getString(R.string.uam_gv_hint, new Object[]{l2}));
            ((TextView) inflate.findViewById(R.id.tv_terms_and_condition)).setOnClickListener(new ai(activity, aVar));
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type android.view.View");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void e(net.one97.paytm.newaddmoney.view.c r5, java.lang.String r6) {
        /*
            r0 = 0
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ NumberFormatException -> 0x0019 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NumberFormatException -> 0x0019 }
            if (r2 != 0) goto L_0x001d
            java.lang.String r6 = com.paytm.utility.b.Q((java.lang.String) r6)     // Catch:{ NumberFormatException -> 0x0019 }
            java.lang.String r2 = "CJRAppCommonUtility.getCleanString(amount)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)     // Catch:{ NumberFormatException -> 0x0019 }
            double r2 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException -> 0x0019 }
            goto L_0x001e
        L_0x0019:
            r6 = move-exception
            r6.printStackTrace()
        L_0x001d:
            r2 = r0
        L_0x001e:
            java.lang.String r6 = r5.f55897g
            if (r6 == 0) goto L_0x0052
            net.one97.paytm.newaddmoney.utils.d r4 = net.one97.paytm.newaddmoney.utils.d.PAYTM_MIN_KYC
            java.lang.String r4 = r4.name()
            boolean r6 = r6.equals(r4)
            r4 = 1
            if (r6 != r4) goto L_0x0052
            net.one97.paytm.newaddmoney.c.a r6 = r5.f55893c
            if (r6 == 0) goto L_0x0035
            double r0 = r6.A
        L_0x0035:
            int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x004e
            r5.a((boolean) r4)
            net.one97.paytm.helper.a$a r6 = net.one97.paytm.helper.a.f50546a
            net.one97.paytm.helper.c r6 = r6.a()
            java.lang.String r0 = "showPopupWhileSwitchingToGV"
            boolean r6 = r6.g((java.lang.String) r0)
            if (r6 == 0) goto L_0x0052
            r5.b()
            return
        L_0x004e:
            r6 = 0
            r5.a((boolean) r6)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.view.c.e(net.one97.paytm.newaddmoney.view.c, java.lang.String):void");
    }

    public static final /* synthetic */ void r(c cVar) {
        try {
            Rect rect = new Rect();
            net.one97.paytm.addmoney.a.k kVar = cVar.f55892b;
            if (kVar == null) {
                kotlin.g.b.k.a("binder");
            }
            kVar.F.getHitRect(rect);
            net.one97.paytm.addmoney.a.k kVar2 = cVar.f55892b;
            if (kVar2 == null) {
                kotlin.g.b.k.a("binder");
            }
            if (!kVar2.f48064c.getLocalVisibleRect(rect)) {
                net.one97.paytm.addmoney.a.k kVar3 = cVar.f55892b;
                if (kVar3 == null) {
                    kotlin.g.b.k.a("binder");
                }
                NestedScrollView nestedScrollView = kVar3.F;
                net.one97.paytm.addmoney.a.k kVar4 = cVar.f55892b;
                if (kVar4 == null) {
                    kotlin.g.b.k.a("binder");
                }
                NestedScrollView nestedScrollView2 = kVar4.F;
                kotlin.g.b.k.a((Object) nestedScrollView2, "binder.scrollView");
                nestedScrollView.scrollTo(0, nestedScrollView2.getTop());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
