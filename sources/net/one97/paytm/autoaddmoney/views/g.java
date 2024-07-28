package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.x;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.CustomAmountTextInputEditText;
import net.one97.paytm.autoaddmoney.a.a;
import net.one97.paytm.autoaddmoney.c.c;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.AnimationFactory;

public final class g extends net.one97.paytm.i.h {

    /* renamed from: b  reason: collision with root package name */
    public static final a f49415b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    ArrayList<IJRDataModel> f49416a;

    /* renamed from: c  reason: collision with root package name */
    private String f49417c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f49418d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    private String f49419e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.addmoney.a.c f49420f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f49421g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f49422h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f49423i;
    private TextView j;
    private View k;
    private View l;
    private CustomAmountTextInputEditText m;
    private CustomAmountTextInputEditText n;
    private RecyclerView o;
    private NestedScrollView p;
    private RelativeLayout q;
    private LottieAnimationView r;
    private TextView s;
    /* access modifiers changed from: private */
    public boolean t;
    private net.one97.paytm.autoaddmoney.a.a u;
    private HashMap v;

    static final class f<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49431a;

        f(g gVar) {
            this.f49431a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            Bundle bundle = null;
            net.one97.paytm.autoaddmoney.b.f fVar = aVar != null ? (net.one97.paytm.autoaddmoney.b.f) aVar.a() : null;
            net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
            FragmentActivity activity = this.f49431a.getActivity();
            if (activity != null) {
                Activity activity2 = activity;
                if (fVar != null) {
                    str = fVar.f49163a;
                } else {
                    str = null;
                }
                if (fVar != null) {
                    bundle = fVar.f49164b;
                }
                a2.a(activity2, str, bundle);
                com.paytm.utility.b.c((Activity) this.f49431a.getActivity());
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    static final class h<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49433a;

        h(g gVar) {
            this.f49433a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.b.e eVar;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && (eVar = (net.one97.paytm.autoaddmoney.b.e) aVar.a()) != null) {
                aa aaVar = aa.f47921a;
                String string = this.f49433a.getString(R.string.wallet_si_amount_error_part_1_new);
                kotlin.g.b.k.a((Object) string, "getString(R.string.walle…_amount_error_part_1_new)");
                String format = String.format(string, Arrays.copyOf(new Object[]{com.paytm.utility.b.a((double) eVar.f49161a) + this.f49433a.getString(R.string.wallet_si_amount_error_part_2) + com.paytm.utility.b.a((double) eVar.f49162b)}, 1));
                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                g.e(this.f49433a).setText(format);
                g.e(this.f49433a).setVisibility(0);
                View f2 = g.f(this.f49433a);
                Context context = this.f49433a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                f2.setBackgroundColor(androidx.core.content.b.c(context, R.color.color_fd5154));
            }
        }
    }

    static final class i<T> implements z<net.one97.paytm.autoaddmoney.a<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49434a;

        i(g gVar) {
            this.f49434a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (kotlin.g.b.k.a((Object) aVar != null ? (Boolean) aVar.a() : null, (Object) Boolean.FALSE) && (activity = this.f49434a.getActivity()) != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class j<T> implements z<net.one97.paytm.autoaddmoney.a<? extends com.paytm.network.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49435a;

        j(g gVar) {
            this.f49435a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            g gVar = this.f49435a;
            com.paytm.network.a aVar2 = aVar != null ? (com.paytm.network.a) aVar.a() : null;
            if (aVar2 == null) {
                kotlin.g.b.k.a();
            }
            gVar.a(aVar2);
            com.paytm.utility.b.c((Activity) this.f49435a.getActivity());
        }
    }

    static final class k<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.h>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49436a;

        k(g gVar) {
            this.f49436a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.b.h hVar;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && (hVar = (net.one97.paytm.autoaddmoney.b.h) aVar.a()) != null) {
                Boolean valueOf = hVar != null ? Boolean.valueOf(hVar.f49168a) : null;
                if (valueOf == null) {
                    kotlin.g.b.k.a();
                }
                if (valueOf.booleanValue()) {
                    g.e(this.f49436a).setText(this.f49436a.getString(R.string.enter_amount_error));
                    g.e(this.f49436a).setVisibility(0);
                    View f2 = g.f(this.f49436a);
                    Context context = this.f49436a.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    f2.setBackgroundColor(androidx.core.content.b.c(context, R.color.color_fd5154));
                } else if (hVar.f49169b) {
                    g.g(this.f49436a).setText(this.f49436a.getString(R.string.enter_amount_error));
                    g.g(this.f49436a).setVisibility(0);
                    View h2 = g.h(this.f49436a);
                    Context context2 = this.f49436a.getContext();
                    if (context2 == null) {
                        kotlin.g.b.k.a();
                    }
                    h2.setBackgroundColor(androidx.core.content.b.c(context2, R.color.color_fd5154));
                }
            }
        }
    }

    static final class l<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49437a;

        l(g gVar) {
            this.f49437a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.b.e eVar;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && (eVar = (net.one97.paytm.autoaddmoney.b.e) aVar.a()) != null) {
                aa aaVar = aa.f47921a;
                String string = this.f49437a.getString(R.string.auto_sum_error);
                kotlin.g.b.k.a((Object) string, "getString(R.string.auto_sum_error)");
                String format = String.format(string, Arrays.copyOf(new Object[]{com.paytm.utility.b.a((double) eVar.f49162b)}, 1));
                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                g.g(this.f49437a).setText(format);
                g.g(this.f49437a).setVisibility(0);
                View h2 = g.h(this.f49437a);
                Context context = this.f49437a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                h2.setBackgroundColor(androidx.core.content.b.c(context, R.color.color_fd5154));
                g.i(this.f49437a).scrollTo(0, g.g(this.f49437a).getBottom());
            }
        }
    }

    static final class m<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49438a;

        m(g gVar) {
            this.f49438a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.b.d dVar;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && (dVar = (net.one97.paytm.autoaddmoney.b.d) aVar.a()) != null) {
                g.a(this.f49438a, dVar.f49160b);
            }
        }
    }

    static final class n<T> implements z<net.one97.paytm.autoaddmoney.a<? extends ArrayList<IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49439a;

        n(g gVar) {
            this.f49439a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && (arrayList = (ArrayList) aVar.a()) != null) {
                this.f49439a.a((ArrayList<IJRDataModel>) arrayList);
            }
        }
    }

    static final class o<T> implements z<net.one97.paytm.autoaddmoney.a<? extends x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49440a;

        o(g gVar) {
            this.f49440a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && ((x) aVar.a()) != null) {
                this.f49440a.a();
            }
        }
    }

    static final class p<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49441a;

        p(g gVar) {
            this.f49441a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.b.e eVar;
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (aVar != null && (eVar = (net.one97.paytm.autoaddmoney.b.e) aVar.a()) != null) {
                if (eVar.f49162b > 0) {
                    TextView g2 = g.g(this.f49441a);
                    aa aaVar = aa.f47921a;
                    String string = this.f49441a.getString(R.string.wallet_si_amount_error_part_1_new);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.walle…_amount_error_part_1_new)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{com.paytm.utility.b.a((double) eVar.f49161a) + this.f49441a.getString(R.string.wallet_si_amount_error_part_2) + com.paytm.utility.b.a((double) eVar.f49162b)}, 1));
                    kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                    g2.setText(format);
                    g.g(this.f49441a).setVisibility(0);
                    View h2 = g.h(this.f49441a);
                    Context context = this.f49441a.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    h2.setBackgroundColor(androidx.core.content.b.c(context, R.color.color_fd5154));
                    g.i(this.f49441a).scrollTo(0, g.g(this.f49441a).getBottom());
                } else if (eVar.f49161a > 0) {
                    TextView g3 = g.g(this.f49441a);
                    aa aaVar2 = aa.f47921a;
                    String string2 = this.f49441a.getString(R.string.wallet_si_amount_error_part__3_new);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.walle…amount_error_part__3_new)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{com.paytm.utility.b.a((double) eVar.f49161a)}, 1));
                    kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                    g3.setText(format2);
                    g.g(this.f49441a).setVisibility(0);
                    View h3 = g.h(this.f49441a);
                    Context context2 = this.f49441a.getContext();
                    if (context2 == null) {
                        kotlin.g.b.k.a();
                    }
                    h3.setBackgroundColor(androidx.core.content.b.c(context2, R.color.color_fd5154));
                    g.i(this.f49441a).scrollTo(0, g.g(this.f49441a).getBottom());
                } else {
                    g.g(this.f49441a).setVisibility(8);
                    g.e(this.f49441a).setVisibility(8);
                    g.g(this.f49441a).setText((CharSequence) null);
                    g.e(this.f49441a).setText((CharSequence) null);
                    View h4 = g.h(this.f49441a);
                    Context context3 = this.f49441a.getContext();
                    if (context3 == null) {
                        kotlin.g.b.k.a();
                    }
                    h4.setBackgroundColor(androidx.core.content.b.c(context3, R.color.color_e8edf3));
                }
            }
        }
    }

    public static final /* synthetic */ CustomAmountTextInputEditText c(g gVar) {
        CustomAmountTextInputEditText customAmountTextInputEditText = gVar.m;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("et_minAmount");
        }
        return customAmountTextInputEditText;
    }

    public static final /* synthetic */ CustomAmountTextInputEditText d(g gVar) {
        CustomAmountTextInputEditText customAmountTextInputEditText = gVar.n;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("et_autoaddAmount");
        }
        return customAmountTextInputEditText;
    }

    public static final /* synthetic */ TextView e(g gVar) {
        TextView textView = gVar.f49423i;
        if (textView == null) {
            kotlin.g.b.k.a("error_txt_minError");
        }
        return textView;
    }

    public static final /* synthetic */ View f(g gVar) {
        View view = gVar.k;
        if (view == null) {
            kotlin.g.b.k.a("view_bottom_min_amount");
        }
        return view;
    }

    public static final /* synthetic */ TextView g(g gVar) {
        TextView textView = gVar.j;
        if (textView == null) {
            kotlin.g.b.k.a("error_txt_AutoAdderror");
        }
        return textView;
    }

    public static final /* synthetic */ View h(g gVar) {
        View view = gVar.l;
        if (view == null) {
            kotlin.g.b.k.a("view_bottom_autoadd_amount");
        }
        return view;
    }

    public static final /* synthetic */ NestedScrollView i(g gVar) {
        NestedScrollView nestedScrollView = gVar.p;
        if (nestedScrollView == null) {
            kotlin.g.b.k.a("mscroll_view");
        }
        return nestedScrollView;
    }

    public static final /* synthetic */ TextView k(g gVar) {
        TextView textView = gVar.f49422h;
        if (textView == null) {
            kotlin.g.b.k.a("min_rs_tv");
        }
        return textView;
    }

    public static final /* synthetic */ TextView l(g gVar) {
        TextView textView = gVar.f49421g;
        if (textView == null) {
            kotlin.g.b.k.a("auto_rs_tv");
        }
        return textView;
    }

    public static final /* synthetic */ net.one97.paytm.autoaddmoney.a.a m(g gVar) {
        net.one97.paytm.autoaddmoney.a.a aVar = gVar.u;
        if (aVar == null) {
            kotlin.g.b.k.a("topupSuggestionAdapter");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        kotlin.g.b.k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            window.setSoftInputMode(16);
        }
        net.one97.paytm.addmoney.a.c a2 = net.one97.paytm.addmoney.a.c.a(layoutInflater, viewGroup);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            a2.a((net.one97.paytm.autoaddmoney.c.c) net.one97.paytm.autoaddmoney.util.a.a((AmAutomaticActivity) activity2, net.one97.paytm.autoaddmoney.c.c.class));
            kotlin.g.b.k.a((Object) a2, "AmFragmentSetAutomaticBi…entViewModel()\n\n        }");
            this.f49420f = a2;
            net.one97.paytm.addmoney.a.c cVar = this.f49420f;
            if (cVar == null) {
                kotlin.g.b.k.a("viewDataBinding");
            }
            return cVar.getRoot();
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.autoaddmoney.views.AmAutomaticActivity");
    }

    static final class c implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49426a;

        c(g gVar) {
            this.f49426a = gVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z && !this.f49426a.t) {
                CharSequence valueOf = String.valueOf(g.c(this.f49426a).getText());
                if (!(valueOf == null || valueOf.length() == 0)) {
                    this.f49426a.t = true;
                    g gVar = this.f49426a;
                    String Q = com.paytm.utility.b.Q(String.valueOf(g.c(gVar).getText()));
                    kotlin.g.b.k.a((Object) Q, "CJRAppCommonUtility.getC…inAmount.text.toString())");
                    gVar.a("Minimum_balance_entered", Q);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2) {
        Bundle arguments = getArguments();
        String str3 = (arguments == null || !arguments.getBoolean("EDIT_MODE", false)) ? "Create" : "Update";
        net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        Context context = activity;
        String[] strArr = new String[3];
        strArr[0] = str3;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            kotlin.g.b.k.a();
        }
        String string = arguments2.getString("source", "");
        kotlin.g.b.k.a((Object) string, "arguments!!.getString(UtilsConstants.SOURCE, \"\")");
        strArr[1] = string;
        strArr[2] = str2;
        a2.a(context, "Auto Add Money", str, (ArrayList<String>) kotlin.a.k.d(strArr), "", "", "");
    }

    public static final class b implements a.C0868a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49424a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f49425b;

        b(g gVar, x.e eVar) {
            this.f49424a = gVar;
            this.f49425b = eVar;
        }

        public final void a(String str) {
            kotlin.g.b.k.c(str, "value");
            g.d(this.f49424a).setTag("rv_top");
            g.d(this.f49424a).setText(AddMoneyUtils.d(str));
            g.d(this.f49424a).setTag((Object) null);
            this.f49424a.a("Suggestive_amount_clicked", str);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        LiveData liveData;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        LiveData liveData5;
        LiveData liveData6;
        LiveData liveData7;
        LiveData liveData8;
        LiveData liveData9;
        LiveData liveData10;
        LiveData liveData11;
        LiveData liveData12;
        Spanned spanned;
        String replace;
        String str;
        String replace2;
        String a2;
        super.onActivityCreated(bundle);
        String str2 = null;
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                kotlin.g.b.k.a();
            }
            if (arguments.containsKey("auto_amount")) {
                Bundle arguments2 = getArguments();
                this.f49417c = arguments2 != null ? arguments2.getString("auto_amount") : null;
            }
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments3.containsKey("min_amount")) {
                Bundle arguments4 = getArguments();
                this.f49419e = arguments4 != null ? arguments4.getString("min_amount") : null;
            }
            Bundle arguments5 = getArguments();
            if (arguments5 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments5.containsKey("IS_DEACTIVATED")) {
                Bundle arguments6 = getArguments();
                if (arguments6 == null) {
                    kotlin.g.b.k.a();
                }
                this.f49418d = Boolean.valueOf(arguments6.getBoolean("IS_DEACTIVATED"));
            }
            Bundle arguments7 = getArguments();
            Serializable serializable = arguments7 != null ? arguments7.getSerializable("SAVED_CARDS") : null;
            if (serializable != null && (serializable instanceof ArrayList)) {
                this.f49416a = (ArrayList) serializable;
            }
        }
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.min_rs_tv) : null;
        if (textView == null) {
            kotlin.g.b.k.a();
        }
        this.f49422h = textView;
        View view2 = getView();
        NestedScrollView nestedScrollView = view2 != null ? (NestedScrollView) view2.findViewById(R.id.scroll_view) : null;
        if (nestedScrollView == null) {
            kotlin.g.b.k.a();
        }
        this.p = nestedScrollView;
        View view3 = getView();
        TextView textView2 = view3 != null ? (TextView) view3.findViewById(R.id.text_terms_heading) : null;
        if (textView2 == null) {
            kotlin.g.b.k.a();
        }
        this.s = textView2;
        View view4 = getView();
        TextView textView3 = view4 != null ? (TextView) view4.findViewById(R.id.auto_rs_tv) : null;
        if (textView3 == null) {
            kotlin.g.b.k.a();
        }
        this.f49421g = textView3;
        View view5 = getView();
        TextView textView4 = view5 != null ? (TextView) view5.findViewById(R.id.error_txt1) : null;
        if (textView4 == null) {
            kotlin.g.b.k.a();
        }
        this.f49423i = textView4;
        View view6 = getView();
        TextView textView5 = view6 != null ? (TextView) view6.findViewById(R.id.error_txt2) : null;
        if (textView5 == null) {
            kotlin.g.b.k.a();
        }
        this.j = textView5;
        View view7 = getView();
        View findViewById = view7 != null ? view7.findViewById(R.id.view2) : null;
        if (findViewById == null) {
            kotlin.g.b.k.a();
        }
        this.k = findViewById;
        View view8 = getView();
        View findViewById2 = view8 != null ? view8.findViewById(R.id.view3) : null;
        if (findViewById2 == null) {
            kotlin.g.b.k.a();
        }
        this.l = findViewById2;
        View view9 = getView();
        CustomAmountTextInputEditText customAmountTextInputEditText = view9 != null ? (CustomAmountTextInputEditText) view9.findViewById(R.id.edit_p2p_amount) : null;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a();
        }
        this.m = customAmountTextInputEditText;
        View view10 = getView();
        RelativeLayout relativeLayout = view10 != null ? (RelativeLayout) view10.findViewById(R.id.loader_container) : null;
        if (relativeLayout == null) {
            kotlin.g.b.k.a();
        }
        this.q = relativeLayout;
        View view11 = getView();
        LottieAnimationView lottieAnimationView = view11 != null ? (LottieAnimationView) view11.findViewById(R.id.view_loader) : null;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a();
        }
        this.r = lottieAnimationView;
        View view12 = getView();
        CustomAmountTextInputEditText customAmountTextInputEditText2 = view12 != null ? (CustomAmountTextInputEditText) view12.findViewById(R.id.edit_p2p_amount_add) : null;
        if (customAmountTextInputEditText2 == null) {
            kotlin.g.b.k.a();
        }
        this.n = customAmountTextInputEditText2;
        View view13 = getView();
        RecyclerView recyclerView = view13 != null ? (RecyclerView) view13.findViewById(R.id.rv_topup_sug) : null;
        if (recyclerView == null) {
            kotlin.g.b.k.a();
        }
        this.o = recyclerView;
        x.e eVar = new x.e();
        eVar.element = net.one97.paytm.helper.a.f50546a.a().f("addMoneyTopupSuggestions");
        if (TextUtils.isEmpty((String) eVar.element)) {
            FragmentActivity activity = getActivity();
            eVar.element = activity != null ? activity.getString(R.string.topup_suggestions) : null;
        }
        boolean z = true;
        if (((String) eVar.element) != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 0, false);
            RecyclerView recyclerView2 = this.o;
            if (recyclerView2 == null) {
                kotlin.g.b.k.a("rv_topupSuggestion");
            }
            recyclerView2.setLayoutManager(linearLayoutManager);
            this.u = new net.one97.paytm.autoaddmoney.a.a(kotlin.m.p.a((CharSequence) (String) eVar.element, new String[]{AppConstants.COMMA}), new b(this, eVar));
            RecyclerView recyclerView3 = this.o;
            if (recyclerView3 == null) {
                kotlin.g.b.k.a("rv_topupSuggestion");
            }
            net.one97.paytm.autoaddmoney.a.a aVar = this.u;
            if (aVar == null) {
                kotlin.g.b.k.a("topupSuggestionAdapter");
            }
            recyclerView3.setAdapter(aVar);
            CharSequence charSequence = this.f49417c;
            if (!(charSequence == null || charSequence.length() == 0)) {
                net.one97.paytm.autoaddmoney.a.a aVar2 = this.u;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("topupSuggestionAdapter");
                }
                String Q = com.paytm.utility.b.Q(this.f49417c);
                kotlin.g.b.k.a((Object) Q, "CJRAppCommonUtility.getCleanString(mTopUpAmount)");
                aVar2.a(Q);
            }
        }
        CustomAmountTextInputEditText customAmountTextInputEditText3 = this.m;
        if (customAmountTextInputEditText3 == null) {
            kotlin.g.b.k.a("et_minAmount");
        }
        customAmountTextInputEditText3.setPrefix("");
        CustomAmountTextInputEditText customAmountTextInputEditText4 = this.n;
        if (customAmountTextInputEditText4 == null) {
            kotlin.g.b.k.a("et_autoaddAmount");
        }
        customAmountTextInputEditText4.setPrefix("");
        if (!(getActivity() == null || (a2 = net.one97.paytm.newaddmoney.utils.e.a(getActivity())) == null)) {
            net.one97.paytm.addmoney.a.c cVar = this.f49420f;
            if (cVar == null) {
                kotlin.g.b.k.a("viewDataBinding");
            }
            if (cVar.a() != null) {
                int a3 = net.one97.paytm.autoaddmoney.c.c.a(a2);
                if (a3 > 0) {
                    CustomAmountTextInputEditText customAmountTextInputEditText5 = this.m;
                    if (customAmountTextInputEditText5 == null) {
                        kotlin.g.b.k.a("et_minAmount");
                    }
                    customAmountTextInputEditText5.setMaxDigitsBeforeDecimalPoint(a3);
                    CustomAmountTextInputEditText customAmountTextInputEditText6 = this.n;
                    if (customAmountTextInputEditText6 == null) {
                        kotlin.g.b.k.a("et_autoaddAmount");
                    }
                    customAmountTextInputEditText6.setMaxDigitsBeforeDecimalPoint(a3);
                }
                kotlin.x xVar = kotlin.x.f47997a;
            }
        }
        CharSequence charSequence2 = this.f49419e;
        if (charSequence2 == null || charSequence2.length() == 0) {
            this.f49419e = String.valueOf(net.one97.paytm.helper.a.f50546a.a().h("addMoneyMinBalanceDefaultValue"));
            CharSequence charSequence3 = this.f49419e;
            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                z = false;
            }
            if (z) {
                this.f49419e = Constants.RESULT_STATUS_SUCCESS;
            }
        }
        if (!TextUtils.isEmpty(this.f49419e)) {
            String str3 = this.f49419e;
            Integer valueOf = str3 != null ? Integer.valueOf(kotlin.m.p.a((CharSequence) str3, AppUtility.CENTER_DOT, 0, false, 6)) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.intValue() < 0) {
                str = this.f49419e;
            } else {
                String str4 = this.f49419e;
                str = (str4 == null || (replace2 = new kotlin.m.l("0*$").replace((CharSequence) str4, "")) == null) ? null : new kotlin.m.l("\\.$").replace((CharSequence) replace2, "");
            }
            this.f49419e = str;
            CustomAmountTextInputEditText customAmountTextInputEditText7 = this.m;
            if (customAmountTextInputEditText7 == null) {
                kotlin.g.b.k.a("et_minAmount");
            }
            customAmountTextInputEditText7.setText(com.paytm.utility.b.S(this.f49419e));
            TextView textView6 = this.f49422h;
            if (textView6 == null) {
                kotlin.g.b.k.a("min_rs_tv");
            }
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            textView6.setTextColor(androidx.core.content.b.c(context, R.color.color_1d252d));
        }
        if (!TextUtils.isEmpty(this.f49417c)) {
            String str5 = this.f49417c;
            Integer valueOf2 = str5 != null ? Integer.valueOf(kotlin.m.p.a((CharSequence) str5, AppUtility.CENTER_DOT, 0, false, 6)) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf2.intValue() < 0) {
                str2 = this.f49417c;
            } else {
                String str6 = this.f49417c;
                if (!(str6 == null || (replace = new kotlin.m.l("0*$").replace((CharSequence) str6, "")) == null)) {
                    str2 = new kotlin.m.l("\\.$").replace((CharSequence) replace, "");
                }
            }
            this.f49417c = str2;
            CustomAmountTextInputEditText customAmountTextInputEditText8 = this.n;
            if (customAmountTextInputEditText8 == null) {
                kotlin.g.b.k.a("et_autoaddAmount");
            }
            customAmountTextInputEditText8.setText(com.paytm.utility.b.S(this.f49417c));
            TextView textView7 = this.f49421g;
            if (textView7 == null) {
                kotlin.g.b.k.a("auto_rs_tv");
            }
            Context context2 = getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            textView7.setTextColor(androidx.core.content.b.c(context2, R.color.color_1d252d));
        }
        try {
            String f2 = net.one97.paytm.helper.a.f50546a.a().f("aam_agree_terms_privacy");
            if (!TextUtils.isEmpty(f2)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    spanned = Html.fromHtml(f2, 0);
                    kotlin.g.b.k.a((Object) spanned, "Html.fromHtml(terms_text…ml.FROM_HTML_MODE_LEGACY)");
                } else {
                    spanned = Html.fromHtml(f2);
                    kotlin.g.b.k.a((Object) spanned, "Html.fromHtml(terms_text)");
                }
                TextView textView8 = this.s;
                if (textView8 == null) {
                    kotlin.g.b.k.a("mTerms");
                }
                textView8.setMovementMethod(LinkMovementMethod.getInstance());
                TextView textView9 = this.s;
                if (textView9 == null) {
                    kotlin.g.b.k.a("mTerms");
                }
                textView9.setText(spanned);
                TextView textView10 = this.s;
                if (textView10 == null) {
                    kotlin.g.b.k.a("mTerms");
                }
                textView10.setVisibility(0);
                TextView textView11 = this.s;
                if (textView11 == null) {
                    kotlin.g.b.k.a("mTerms");
                }
                AddMoneyUtils.a(textView11);
                CustomAmountTextInputEditText customAmountTextInputEditText9 = this.m;
                if (customAmountTextInputEditText9 == null) {
                    kotlin.g.b.k.a("et_minAmount");
                }
                customAmountTextInputEditText9.requestFocus();
                CustomAmountTextInputEditText customAmountTextInputEditText10 = this.m;
                if (customAmountTextInputEditText10 == null) {
                    kotlin.g.b.k.a("et_minAmount");
                }
                net.one97.paytm.wallet.utility.e.a((EditText) customAmountTextInputEditText10, (Activity) getActivity());
                CustomAmountTextInputEditText customAmountTextInputEditText11 = this.n;
                if (customAmountTextInputEditText11 == null) {
                    kotlin.g.b.k.a("et_autoaddAmount");
                }
                customAmountTextInputEditText11.setOnFocusChangeListener(new c(this));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        net.one97.paytm.addmoney.a.c cVar2 = this.f49420f;
        if (cVar2 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        cVar2.setLifecycleOwner(this);
        net.one97.paytm.addmoney.a.c cVar3 = this.f49420f;
        if (cVar3 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a4 = cVar3.a();
        if (!(a4 == null || (liveData12 = a4.f49215i) == null)) {
            liveData12.observe(getViewLifecycleOwner(), new f(this));
        }
        net.one97.paytm.addmoney.a.c cVar4 = this.f49420f;
        if (cVar4 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a5 = cVar4.a();
        if (!(a5 == null || (liveData11 = a5.f49214h) == null)) {
            liveData11.observe(getViewLifecycleOwner(), new j(this));
        }
        net.one97.paytm.addmoney.a.c cVar5 = this.f49420f;
        if (cVar5 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a6 = cVar5.a();
        if (!(a6 == null || (liveData10 = a6.f49212f) == null)) {
            liveData10.observe(getViewLifecycleOwner(), new k(this));
        }
        net.one97.paytm.addmoney.a.c cVar6 = this.f49420f;
        if (cVar6 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a7 = cVar6.a();
        if (!(a7 == null || (liveData9 = a7.k) == null)) {
            liveData9.observe(getViewLifecycleOwner(), new l(this));
        }
        net.one97.paytm.addmoney.a.c cVar7 = this.f49420f;
        if (cVar7 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a8 = cVar7.a();
        if (!(a8 == null || (liveData8 = a8.f49207a) == null)) {
            liveData8.observe(getViewLifecycleOwner(), new m(this));
        }
        net.one97.paytm.addmoney.a.c cVar8 = this.f49420f;
        if (cVar8 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a9 = cVar8.a();
        if (!(a9 == null || (liveData7 = a9.j) == null)) {
            liveData7.observe(getViewLifecycleOwner(), new n(this));
        }
        net.one97.paytm.addmoney.a.c cVar9 = this.f49420f;
        if (cVar9 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a10 = cVar9.a();
        if (!(a10 == null || (liveData6 = a10.f49213g) == null)) {
            liveData6.observe(getViewLifecycleOwner(), new o(this));
        }
        net.one97.paytm.addmoney.a.c cVar10 = this.f49420f;
        if (cVar10 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a11 = cVar10.a();
        if (!(a11 == null || (liveData5 = a11.f49209c) == null)) {
            liveData5.observe(getViewLifecycleOwner(), new p(this));
        }
        net.one97.paytm.addmoney.a.c cVar11 = this.f49420f;
        if (cVar11 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a12 = cVar11.a();
        if (!(a12 == null || (liveData4 = a12.f49211e) == null)) {
            liveData4.observe(getViewLifecycleOwner(), new q(this));
        }
        net.one97.paytm.addmoney.a.c cVar12 = this.f49420f;
        if (cVar12 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a13 = cVar12.a();
        if (!(a13 == null || (liveData3 = a13.f49210d) == null)) {
            liveData3.observe(getViewLifecycleOwner(), new C0879g(this));
        }
        net.one97.paytm.addmoney.a.c cVar13 = this.f49420f;
        if (cVar13 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a14 = cVar13.a();
        if (!(a14 == null || (liveData2 = a14.f49208b) == null)) {
            liveData2.observe(getViewLifecycleOwner(), new h(this));
        }
        net.one97.paytm.addmoney.a.c cVar14 = this.f49420f;
        if (cVar14 == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a15 = cVar14.a();
        if (a15 != null && (liveData = a15.l) != null) {
            liveData.observe(getViewLifecycleOwner(), new i(this));
        }
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<IJRDataModel> arrayList) {
        com.paytm.utility.b.c((Activity) getActivity());
        d dVar = new d();
        Bundle bundle = new Bundle();
        net.one97.paytm.autoaddmoney.util.d dVar2 = net.one97.paytm.autoaddmoney.util.d.f49283a;
        net.one97.paytm.autoaddmoney.util.d.a(arrayList);
        bundle.putSerializable("SAVED_CARDS", arrayList);
        Boolean bool = this.f49418d;
        if (bool == null) {
            kotlin.g.b.k.a();
        }
        bundle.putBoolean("IS_DEACTIVATED", bool.booleanValue());
        Bundle arguments = getArguments();
        Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean("EDIT_MODE", false)) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        bundle.putBoolean("EDIT_MODE", valueOf.booleanValue());
        CustomAmountTextInputEditText customAmountTextInputEditText = this.m;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("et_minAmount");
        }
        bundle.putSerializable("min_amount", com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText.getText())));
        CustomAmountTextInputEditText customAmountTextInputEditText2 = this.n;
        if (customAmountTextInputEditText2 == null) {
            kotlin.g.b.k.a("et_autoaddAmount");
        }
        bundle.putSerializable("auto_amount", com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText2.getText())));
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            kotlin.g.b.k.a();
        }
        bundle.putString("source", arguments2.getString("source", ""));
        dVar.setArguments(bundle);
        dVar.show(getChildFragmentManager(), g.class.getName());
        StringBuilder sb = new StringBuilder();
        CustomAmountTextInputEditText customAmountTextInputEditText3 = this.m;
        if (customAmountTextInputEditText3 == null) {
            kotlin.g.b.k.a("et_minAmount");
        }
        sb.append(com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText3.getText())));
        sb.append(AppConstants.COMMA);
        CustomAmountTextInputEditText customAmountTextInputEditText4 = this.n;
        if (customAmountTextInputEditText4 == null) {
            kotlin.g.b.k.a("et_autoaddAmount");
        }
        sb.append(com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText4.getText())));
        a("Proceed_clicked", sb.toString());
    }

    /* access modifiers changed from: private */
    public final void a() {
        Boolean bool;
        boolean z;
        boolean z2;
        net.one97.paytm.addmoney.a.c cVar = this.f49420f;
        if (cVar == null) {
            kotlin.g.b.k.a("viewDataBinding");
        }
        net.one97.paytm.autoaddmoney.c.c a2 = cVar.a();
        if (a2 != null) {
            net.one97.paytm.addmoney.a.c cVar2 = this.f49420f;
            if (cVar2 == null) {
                kotlin.g.b.k.a("viewDataBinding");
            }
            CustomAmountTextInputEditText customAmountTextInputEditText = cVar2.k;
            kotlin.g.b.k.a((Object) customAmountTextInputEditText, "viewDataBinding.editP2pAmount");
            String Q = com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText.getText()));
            kotlin.g.b.k.a((Object) Q, "CJRAppCommonUtility.getC…2pAmount.text.toString())");
            net.one97.paytm.addmoney.a.c cVar3 = this.f49420f;
            if (cVar3 == null) {
                kotlin.g.b.k.a("viewDataBinding");
            }
            CustomAmountTextInputEditText customAmountTextInputEditText2 = cVar3.l;
            kotlin.g.b.k.a((Object) customAmountTextInputEditText2, "viewDataBinding.editP2pAmountAdd");
            String Q2 = com.paytm.utility.b.Q(String.valueOf(customAmountTextInputEditText2.getText()));
            kotlin.g.b.k.a((Object) Q2, "CJRAppCommonUtility.getC…mountAdd.text.toString())");
            String a3 = net.one97.paytm.newaddmoney.utils.e.a(getActivity());
            kotlin.g.b.k.c(Q, "editP2pAmount");
            kotlin.g.b.k.c(Q2, "editP2pAmountAdd");
            int h2 = net.one97.paytm.helper.a.f50546a.a().h("addMoneyMinBalanceMinLimitMinKyc");
            int h3 = net.one97.paytm.helper.a.f50546a.a().h("addMoneyMinBalanceMaxLimitMinKyc");
            if (kotlin.g.b.k.a((Object) a3, (Object) net.one97.paytm.newaddmoney.utils.d.PAYTM_PRIME_WALLET.name()) || kotlin.g.b.k.a((Object) a3, (Object) net.one97.paytm.newaddmoney.utils.d.PAYTM_ADHAAR_OTP_KYC.name())) {
                h2 = net.one97.paytm.helper.a.f50546a.a().h("addMoneyMinBalanceMinLimit");
                h3 = net.one97.paytm.helper.a.f50546a.a().h("addMoneyMinBalanceMaxLimit");
            }
            if (h2 == 0) {
                h2 = 1;
            }
            if (h3 == 0) {
                h3 = 9900;
            }
            if (!net.one97.paytm.addmoney.utils.j.a(Q, (double) h2, (double) h3)) {
                a2.f49208b.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.e(h2, h3)));
                z = false;
            } else {
                z = true;
            }
            if (z && a2.a(Q2, Q, a3)) {
                z2 = true;
            } else {
                z2 = false;
            }
            bool = Boolean.valueOf(z2);
        } else {
            bool = null;
        }
        if (bool == null) {
            kotlin.g.b.k.a();
        }
        if (bool.booleanValue()) {
            ArrayList<IJRDataModel> arrayList = this.f49416a;
            if (arrayList != null) {
                a(arrayList);
                return;
            }
            net.one97.paytm.addmoney.a.c cVar4 = this.f49420f;
            if (cVar4 == null) {
                kotlin.g.b.k.a("viewDataBinding");
            }
            net.one97.paytm.autoaddmoney.c.c a4 = cVar4.a();
            if (a4 != null) {
                a4.f49207a.setValue(new net.one97.paytm.autoaddmoney.a(new net.one97.paytm.autoaddmoney.b.d(net.one97.paytm.helper.a.f50546a.a().a(R.string.please_wait_fetch_card), true)));
                a4.m.a(false, (a.h) new c.a(a4));
            }
        }
    }

    public final void a(com.paytm.network.a aVar) {
        kotlin.g.b.k.c(aVar, "request");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new e(this, aVar));
        builder.show();
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49429a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f49430b;

        e(g gVar, com.paytm.network.a aVar) {
            this.f49429a = gVar;
            this.f49430b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f49429a.getActivity())) {
                this.f49430b.a();
            } else {
                this.f49429a.a(this.f49430b);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49427a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AlertDialog f49428b;

        d(g gVar, AlertDialog alertDialog) {
            this.f49427a = gVar;
            this.f49428b = alertDialog;
        }

        public final void onClick(View view) {
            this.f49428b.dismiss();
            this.f49427a.a();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 2091) {
            a();
        }
    }

    static final class q<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49442a;

        q(g gVar) {
            this.f49442a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (!TextUtils.isEmpty(g.c(this.f49442a).getText())) {
                TextView k = g.k(this.f49442a);
                Context context = this.f49442a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                k.setTextColor(androidx.core.content.b.c(context, R.color.color_1d252d));
                View f2 = g.f(this.f49442a);
                Context context2 = this.f49442a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                f2.setBackgroundColor(androidx.core.content.b.c(context2, R.color.grey_color));
            } else {
                TextView k2 = g.k(this.f49442a);
                Context context3 = this.f49442a.getContext();
                if (context3 == null) {
                    kotlin.g.b.k.a();
                }
                k2.setTextColor(androidx.core.content.b.c(context3, R.color.color_b8c2cb));
                View f3 = g.f(this.f49442a);
                Context context4 = this.f49442a.getContext();
                if (context4 == null) {
                    kotlin.g.b.k.a();
                }
                f3.setBackgroundColor(androidx.core.content.b.c(context4, R.color.color_e2ebee));
            }
            g.e(this.f49442a).setVisibility(8);
            g.g(this.f49442a).setVisibility(8);
            View h2 = g.h(this.f49442a);
            Context context5 = this.f49442a.getContext();
            if (context5 == null) {
                kotlin.g.b.k.a();
            }
            h2.setBackgroundColor(androidx.core.content.b.c(context5, R.color.color_e8edf3));
        }
    }

    /* renamed from: net.one97.paytm.autoaddmoney.views.g$g  reason: collision with other inner class name */
    static final class C0879g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f49432a;

        C0879g(g gVar) {
            this.f49432a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (!TextUtils.isEmpty(g.d(this.f49432a).getText())) {
                TextView l = g.l(this.f49432a);
                Context context = this.f49432a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                l.setTextColor(androidx.core.content.b.c(context, R.color.color_1d252d));
            } else {
                TextView l2 = g.l(this.f49432a);
                Context context2 = this.f49432a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                l2.setTextColor(androidx.core.content.b.c(context2, R.color.color_506d85));
            }
            g.g(this.f49432a).setVisibility(8);
            View h2 = g.h(this.f49432a);
            Context context3 = this.f49432a.getContext();
            if (context3 == null) {
                kotlin.g.b.k.a();
            }
            h2.setBackgroundColor(androidx.core.content.b.c(context3, R.color.color_e8edf3));
            if (g.d(this.f49432a).getTag() == null) {
                net.one97.paytm.autoaddmoney.a.a m = g.m(this.f49432a);
                String Q = com.paytm.utility.b.Q(String.valueOf(g.d(this.f49432a).getText()));
                kotlin.g.b.k.a((Object) Q, "CJRAppCommonUtility.getC…ddAmount.text.toString())");
                m.a(Q);
            }
        }
    }

    public static final /* synthetic */ void a(g gVar, boolean z) {
        if (z) {
            RelativeLayout relativeLayout = gVar.q;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mLoaderContainer");
            }
            relativeLayout.setVisibility(0);
            LottieAnimationView lottieAnimationView = gVar.r;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("mLoaderView");
            }
            AnimationFactory.startWalletLoader(lottieAnimationView);
            return;
        }
        com.paytm.utility.b.c((Activity) gVar.getActivity());
        RelativeLayout relativeLayout2 = gVar.q;
        if (relativeLayout2 == null) {
            kotlin.g.b.k.a("mLoaderContainer");
        }
        relativeLayout2.setVisibility(8);
        LottieAnimationView lottieAnimationView2 = gVar.r;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("mLoaderView");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView2);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
