package net.one97.paytm.moneytransfer.contacts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.contacts.FastScrollerLinearLayout;
import net.one97.paytm.moneytransfer.contacts.a.b;
import net.one97.paytm.moneytransfer.contacts.b.a;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.model.ContactItemModel;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.a.g;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.viewmodel.b;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends Fragment implements View.OnClickListener, FastScrollerLinearLayout.a, b.d, g.a {
    private final InputFilter.LengthFilter A;
    private p B;
    private TextWatcher C;
    /* access modifiers changed from: private */
    public boolean D;
    private boolean E;
    private String F;
    private RelativeLayout G;
    private LottieAnimationView H;
    private RecyclerView I;
    /* access modifiers changed from: private */
    public net.one97.paytm.moneytransfer.view.a.g J;
    private io.reactivex.rxjava3.b.c K;
    private HashMap L;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public b f53898a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ContactItemModel> f53899b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<ContactItemModel> f53900c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.LayoutManager f53901d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f53902e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f53903f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f53904g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f53905h = "";

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f53906i;
    private AppCompatEditText j;
    private net.one97.paytm.moneytransfer.contacts.b.a k;
    private LottieAnimationView l;
    private String[] m;
    private ImageView n;
    private TextView o;
    /* access modifiers changed from: private */
    public TextInputLayout p;
    private FastScrollerLinearLayout q;
    /* access modifiers changed from: private */
    public final float r = 0.2f;
    private final long s = 100;
    private net.one97.paytm.moneytransfer.d.b t;
    /* access modifiers changed from: private */
    public final io.reactivex.rxjava3.j.b<String> u;
    private TextView v;
    private net.one97.paytm.moneytransfer.viewmodel.b w;
    private final int x;
    private final int y;
    private final InputFilter.LengthFilter z;

    static final class e<T> implements z<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransfer.model.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53957a;

        e(a aVar) {
            this.f53957a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            ArrayList<ContactItemModel> arrayList = null;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null && b.f53965a[dVar.ordinal()] == 1) {
                a aVar = this.f53957a;
                net.one97.paytm.moneytransfer.model.b bVar = (net.one97.paytm.moneytransfer.model.b) cVar.f54033b;
                ArrayList<ContactItemModel> a2 = bVar != null ? bVar.a() : null;
                if (a2 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.moneytransfer.model.b bVar2 = (net.one97.paytm.moneytransfer.model.b) cVar.f54033b;
                if (bVar2 != null) {
                    arrayList = bVar2.b();
                }
                if (arrayList == null) {
                    kotlin.g.b.k.a();
                }
                aVar.f53899b = a2;
                aVar.f53900c = arrayList;
                ArrayList<ContactItemModel> arrayList2 = aVar.f53899b;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    b bVar3 = aVar.f53898a;
                    if (bVar3 != null) {
                        bVar3.a(arrayList2);
                    }
                    b bVar4 = aVar.f53898a;
                    if (bVar4 != null) {
                        kotlin.g.b.k.c(arrayList2, "originalList");
                        bVar4.f53934c = arrayList2;
                    }
                }
                aVar.a();
            }
        }
    }

    static final class f<T> implements z<net.one97.paytm.moneytransfer.model.c<a.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53958a;

        f(a aVar) {
            this.f53958a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = b.f53966b[dVar.ordinal()];
                if (i2 == 1) {
                    this.f53958a.b(true);
                } else if (i2 == 2) {
                    a.a(this.f53958a, (a.b) cVar.f54033b);
                } else if (i2 == 3) {
                    a.a(this.f53958a, cVar.f54034c);
                }
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.moneytransfer.model.c<a.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53959a;

        g(a aVar) {
            this.f53959a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            String str2;
            a.d dVar;
            a.d dVar2;
            a.d dVar3;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            a aVar = this.f53959a;
            String str3 = null;
            if (cVar == null || (dVar3 = (a.d) cVar.f54033b) == null) {
                str = null;
            } else {
                str = dVar3.f53982a;
            }
            String f2 = m.f(str);
            kotlin.g.b.k.a((Object) f2, "MoneyTransferUtils.toCam…Details?.data?.payeeName)");
            aVar.f53903f = f2;
            if (!(cVar == null || (dVar2 = (a.d) cVar.f54033b) == null)) {
                str3 = dVar2.f53983b;
            }
            if (!TextUtils.isEmpty(str3)) {
                a aVar2 = this.f53959a;
                if (cVar == null || (dVar = (a.d) cVar.f54033b) == null || (str2 = dVar.f53983b) == null) {
                    str2 = "";
                }
                aVar2.f53904g = str2;
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.moneytransfer.model.c<b.C0979b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53960a;

        h(a aVar) {
            this.f53960a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.d dVar;
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            if (cVar != null) {
                dVar = cVar.f54032a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = b.f53967c[dVar.ordinal()];
                if (i2 == 1) {
                    this.f53960a.b(true);
                } else if (i2 == 2) {
                    a.a(this.f53960a, (b.C0979b) cVar.f54033b);
                } else if (i2 == 3) {
                    a.b(this.f53960a, cVar.f54034c);
                }
            }
        }
    }

    static final class i<T> implements z<ArrayList<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53961a;

        i(a aVar) {
            this.f53961a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            net.one97.paytm.moneytransfer.view.a.g b2 = this.f53961a.J;
            if (b2 != null) {
                if (arrayList == null) {
                    kotlin.g.b.k.a();
                }
                b2.a((List<String>) arrayList);
            }
        }
    }

    static final class k<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final k f53963a = new k();

        k() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            kotlin.g.b.k.a((Object) str, "it");
            if (str != null) {
                String lowerCase = str.toLowerCase();
                kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (lowerCase != null) {
                    return kotlin.m.p.b(lowerCase).toString();
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class l<T> implements io.reactivex.rxjava3.d.g<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53964a;

        l(a aVar) {
            this.f53964a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Filter filter;
            CharSequence charSequence = (String) obj;
            if (!TextUtils.isEmpty(charSequence)) {
                net.one97.paytm.moneytransfer.contacts.a.b l = this.f53964a.f53898a;
                if (l != null && (filter = l.getFilter()) != null) {
                    filter.filter(charSequence);
                    return;
                }
                return;
            }
            a.h(this.f53964a);
        }
    }

    public a() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        kotlin.g.b.k.a((Object) a2, "PublishSubject.create()");
        this.u = a2;
        this.x = 12;
        this.y = 100;
        this.z = new InputFilter.LengthFilter(this.x);
        this.A = new InputFilter.LengthFilter(this.y);
    }

    public static final /* synthetic */ ImageView d(a aVar) {
        ImageView imageView = aVar.n;
        if (imageView == null) {
            kotlin.g.b.k.a("ivCross");
        }
        return imageView;
    }

    public static final /* synthetic */ FastScrollerLinearLayout g(a aVar) {
        FastScrollerLinearLayout fastScrollerLinearLayout = aVar.q;
        if (fastScrollerLinearLayout == null) {
            kotlin.g.b.k.a("fastScroller");
        }
        return fastScrollerLinearLayout;
    }

    public static final /* synthetic */ TextView j(a aVar) {
        TextView textView = aVar.o;
        if (textView == null) {
            kotlin.g.b.k.a("tvProceedButton");
        }
        return textView;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.moneytransfer.contacts.b.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ctsViewModel::class.java)");
        this.k = (net.one97.paytm.moneytransfer.contacts.b.a) a2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        ai a3 = am.a(activity).a(net.one97.paytm.moneytransfer.viewmodel.b.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(ac…ityViewModel::class.java)");
        this.w = (net.one97.paytm.moneytransfer.viewmodel.b) a3;
    }

    /* access modifiers changed from: private */
    public final void b(boolean z2) {
        if (z2) {
            try {
                if (!this.E) {
                    RelativeLayout relativeLayout = this.G;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    LottieAnimationView lottieAnimationView = this.H;
                    if (lottieAnimationView != null) {
                        AnimationFactory.startWalletLoader(lottieAnimationView);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.E) {
            net.one97.paytm.moneytransfer.contacts.a.b bVar = this.f53898a;
            if (bVar != null) {
                bVar.a(-1);
            }
        } else {
            RelativeLayout relativeLayout2 = this.G;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView2 = this.H;
            if (lottieAnimationView2 != null) {
                AnimationFactory.stopWalletLoader(lottieAnimationView2);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextInputLayout textInputLayout;
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_money_transfer_contacts, viewGroup, false);
        kotlin.g.b.k.a((Object) inflate, "view");
        kotlin.g.b.k.c(inflate, "view");
        View findViewById = inflate.findViewById(R.id.iv_back);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = inflate.findViewById(R.id.contactEditText);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.contactEditText)");
        this.j = (AppCompatEditText) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.contactsRecyclerView);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.contactsRecyclerView)");
        this.f53906i = (RecyclerView) findViewById3;
        this.f53901d = new LinearLayoutManager(getContext());
        this.f53898a = new net.one97.paytm.moneytransfer.contacts.a.b(new ArrayList(), getContext(), this);
        this.p = (TextInputLayout) inflate.findViewById(R.id.til_searchbox);
        RecyclerView recyclerView = this.f53906i;
        if (recyclerView == null) {
            kotlin.g.b.k.a("contactsRV");
        }
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = this.f53906i;
        if (recyclerView2 == null) {
            kotlin.g.b.k.a("contactsRV");
        }
        RecyclerView.LayoutManager layoutManager = this.f53901d;
        if (layoutManager == null) {
            kotlin.g.b.k.a("viewManager");
        }
        recyclerView2.setLayoutManager(layoutManager);
        RecyclerView recyclerView3 = this.f53906i;
        if (recyclerView3 == null) {
            kotlin.g.b.k.a("contactsRV");
        }
        recyclerView3.setAdapter(this.f53898a);
        View findViewById4 = inflate.findViewById(R.id.tv_btn_proceed);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.tv_btn_proceed)");
        this.o = (TextView) findViewById4;
        TextView textView = this.o;
        if (textView == null) {
            kotlin.g.b.k.a("tvProceedButton");
        }
        View.OnClickListener onClickListener = this;
        textView.setOnClickListener(onClickListener);
        this.C = new C0962a(this);
        AppCompatEditText appCompatEditText = this.j;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        appCompatEditText.addTextChangedListener(this.C);
        io.reactivex.rxjava3.b.c subscribe = this.u.debounce(this.s, TimeUnit.MILLISECONDS).distinctUntilChanged().observeOn(io.reactivex.rxjava3.android.b.a.a()).filter(new j(this)).subscribeOn(io.reactivex.rxjava3.i.a.b()).map(k.f53963a).subscribe(new l(this));
        kotlin.g.b.k.a((Object) subscribe, "subject.debounce(QUERY_T…arch();\n                }");
        this.K = subscribe;
        this.l = (LottieAnimationView) inflate.findViewById(R.id.top_success_anim_view);
        String[] stringArray = getResources().getStringArray(R.array.alphabet_array);
        kotlin.g.b.k.a((Object) stringArray, "resources.getStringArray(R.array.alphabet_array)");
        this.m = stringArray;
        RecyclerView recyclerView4 = this.f53906i;
        if (recyclerView4 == null) {
            kotlin.g.b.k.a("contactsRV");
        }
        recyclerView4.addOnScrollListener(new b(this));
        View findViewById5 = inflate.findViewById(R.id.iv_cross_search);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.iv_cross_search)");
        this.n = (ImageView) findViewById5;
        ImageView imageView = this.n;
        if (imageView == null) {
            kotlin.g.b.k.a("ivCross");
        }
        imageView.setOnClickListener(onClickListener);
        AppCompatEditText appCompatEditText2 = this.j;
        if (appCompatEditText2 == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        appCompatEditText2.setOnEditorActionListener(new c(this));
        View findViewById6 = inflate.findViewById(R.id.fast_scroller);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.fast_scroller)");
        this.q = (FastScrollerLinearLayout) findViewById6;
        FastScrollerLinearLayout fastScrollerLinearLayout = this.q;
        if (fastScrollerLinearLayout == null) {
            kotlin.g.b.k.a("fastScroller");
        }
        RecyclerView recyclerView5 = this.f53906i;
        if (recyclerView5 == null) {
            kotlin.g.b.k.a("contactsRV");
        }
        String[] strArr = this.m;
        if (strArr == null) {
            kotlin.g.b.k.a("indexList");
        }
        fastScrollerLinearLayout.setUpWithRecyclerView(recyclerView5, strArr, this);
        RecyclerView recyclerView6 = this.f53906i;
        if (recyclerView6 == null) {
            kotlin.g.b.k.a("contactsRV");
        }
        recyclerView6.setNestedScrollingEnabled(false);
        this.v = (TextView) inflate.findViewById(R.id.tv_no_result_found);
        this.B = new d(this, getContext());
        this.G = (RelativeLayout) inflate.findViewById(R.id.money_transfer_loader_container);
        this.H = (LottieAnimationView) inflate.findViewById(R.id.money_transfer_loader);
        ArrayList<ContactItemModel> arrayList = this.f53899b;
        if (arrayList != null && arrayList.size() == 0) {
            g();
        }
        AppCompatEditText appCompatEditText3 = this.j;
        if (appCompatEditText3 == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        m.b((EditText) appCompatEditText3, (Activity) getActivity());
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        if (activity.getIntent().getBooleanExtra("do_open_contacts", false) && (textInputLayout = this.p) != null) {
            textInputLayout.setHint(getString(R.string.mt_enter_name_mobile_no_upi_id));
        }
        this.I = (RecyclerView) inflate.findViewById(R.id.vpaRecyclerView);
        RecyclerView recyclerView7 = this.I;
        if (recyclerView7 != null) {
            recyclerView7.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        }
        this.J = new net.one97.paytm.moneytransfer.view.a.g();
        net.one97.paytm.moneytransfer.view.a.g gVar = this.J;
        if (gVar != null) {
            gVar.a((g.a) this);
        }
        RecyclerView recyclerView8 = this.I;
        if (recyclerView8 != null) {
            recyclerView8.setAdapter(this.J);
        }
        net.one97.paytm.moneytransfer.viewmodel.b bVar = this.w;
        if (bVar == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        q qVar = this;
        bVar.f54676a.observe(qVar, new e(this));
        net.one97.paytm.moneytransfer.contacts.b.a aVar = this.k;
        if (aVar == null) {
            kotlin.g.b.k.a("mContactViewModel");
        }
        aVar.f53970b.observe(qVar, new f(this));
        net.one97.paytm.moneytransfer.contacts.b.a aVar2 = this.k;
        if (aVar2 == null) {
            kotlin.g.b.k.a("mContactViewModel");
        }
        aVar2.f53971c.observe(qVar, new g(this));
        net.one97.paytm.moneytransfer.viewmodel.b bVar2 = this.w;
        if (bVar2 == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        bVar2.p.observe(qVar, new h(this));
        net.one97.paytm.moneytransfer.viewmodel.b bVar3 = this.w;
        if (bVar3 == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        bVar3.r.observe(qVar, new i(this));
        return inflate;
    }

    public final void onClick(View view) {
        androidx.fragment.app.j supportFragmentManager;
        Boolean bool = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.iv_back;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.iv_cross_search;
            if (valueOf != null && valueOf.intValue() == i3) {
                UpiAppUtils.hideKeyboard(getActivity());
                AppCompatEditText appCompatEditText = this.j;
                if (appCompatEditText == null) {
                    kotlin.g.b.k.a("mSearchEditText");
                }
                appCompatEditText.setText("");
                return;
            }
            int i4 = R.id.tv_btn_proceed;
            if (valueOf != null && valueOf.intValue() == i4) {
                RelativeLayout relativeLayout = this.G;
                if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                    b();
                }
            }
        } else if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                bool = Boolean.valueOf(activity.isFinishing());
            }
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            if (!bool.booleanValue()) {
                UpiAppUtils.hideKeyboard(getActivity());
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity2, "activity!!");
                if (!activity2.getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
                    FragmentActivity activity3 = getActivity();
                    if (activity3 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity3, "activity!!");
                    if (!activity3.getIntent().getBooleanExtra("do_open_contacts", false)) {
                        FragmentActivity activity4 = getActivity();
                        if (activity4 != null && (supportFragmentManager = activity4.getSupportFragmentManager()) != null) {
                            supportFragmentManager.d();
                            return;
                        }
                        return;
                    }
                }
                FragmentActivity activity5 = getActivity();
                if (activity5 == null) {
                    kotlin.g.b.k.a();
                }
                activity5.finish();
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.contacts.a$a  reason: collision with other inner class name */
    public static final class C0962a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53907a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        C0962a(a aVar) {
            this.f53907a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            this.f53907a.u.onNext(String.valueOf(editable));
            String valueOf = String.valueOf(editable);
            if (valueOf == null) {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (!TextUtils.isEmpty(kotlin.m.p.b(valueOf).toString())) {
                a.d(this.f53907a).setVisibility(0);
                if (!this.f53907a.D) {
                    a aVar = this.f53907a;
                    String valueOf2 = String.valueOf(editable);
                    if (valueOf2 != null) {
                        a.c(aVar, kotlin.m.p.b(valueOf2).toString());
                        TextInputLayout f2 = this.f53907a.p;
                        if (f2 != null) {
                            f2.setError("");
                        }
                        TextInputLayout f3 = this.f53907a.p;
                        if (f3 != null) {
                            f3.setErrorEnabled(false);
                        }
                        a.g(this.f53907a).setVisibility(8);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                }
            } else {
                a.h(this.f53907a);
            }
        }
    }

    public static final class b extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53931a;

        b(a aVar) {
            this.f53931a = aVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            ContactItemModel contactItemModel;
            ContactItemModel contactItemModel2;
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                if (layoutManager2 != null) {
                    int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition();
                    if (a.g(this.f53931a).getVisibility() == 0) {
                        Collection i4 = this.f53931a.f53899b;
                        int i5 = 0;
                        if (!(i4 == null || i4.isEmpty())) {
                            ArrayList i6 = this.f53931a.f53899b;
                            String str = null;
                            Integer valueOf = i6 != null ? Integer.valueOf(i6.size()) : null;
                            if (valueOf == null) {
                                kotlin.g.b.k.a();
                            }
                            if (findLastCompletelyVisibleItemPosition < valueOf.intValue() - 1 && findFirstCompletelyVisibleItemPosition >= 0) {
                                ArrayList i7 = this.f53931a.f53899b;
                                if ((i7 == null || (contactItemModel2 = (ContactItemModel) i7.get(findFirstCompletelyVisibleItemPosition)) == null) ? false : contactItemModel2.ismIsHeading()) {
                                    FastScrollerLinearLayout g2 = a.g(this.f53931a);
                                    ArrayList i8 = this.f53931a.f53899b;
                                    if (!(i8 == null || (contactItemModel = (ContactItemModel) i8.get(findFirstCompletelyVisibleItemPosition)) == null)) {
                                        str = contactItemModel.getName();
                                    }
                                    String[] strArr = g2.f53895b;
                                    if (strArr == null) {
                                        kotlin.g.b.k.a("sectionList");
                                    }
                                    int length = strArr.length;
                                    while (true) {
                                        if (i5 >= length) {
                                            i5 = -1;
                                            break;
                                        }
                                        String[] strArr2 = g2.f53895b;
                                        if (strArr2 == null) {
                                            kotlin.g.b.k.a("sectionList");
                                        }
                                        if (kotlin.m.p.a(strArr2[i5], str, true)) {
                                            break;
                                        }
                                        i5++;
                                    }
                                    if (i5 != -1) {
                                        g2.a(i5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    public static final class c implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53955a;

        c(a aVar) {
            this.f53955a = aVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6 || a.j(this.f53955a).getVisibility() != 0) {
                return false;
            }
            this.f53955a.b();
            return true;
        }
    }

    public static final class d extends p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53956a;

        public final int getVerticalSnapPreference() {
            return -1;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, Context context) {
            super(context);
            this.f53956a = aVar;
        }

        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return super.calculateSpeedPerPixel(displayMetrics) * this.f53956a.r;
        }
    }

    private void d() {
        net.one97.paytm.moneytransfer.d.b bVar;
        if (getActivity() != null) {
            c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
            if (!TextUtils.isEmpty(net.one97.paytm.moneytransfer.d.c.a(c.a.a().f53989d))) {
                h();
                return;
            }
        }
        if (getContext() != null) {
            net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_PHONEBOOK_CLICKED_N_DIALOG_LOADED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "user_not_on_UPI_Bank_Account", "");
            String str = this.F;
            if (str != null && (bVar = this.t) != null) {
                bVar.e(str);
            }
        }
    }

    private final void a(String str, String str2) {
        net.one97.paytm.moneytransfer.utils.f.a(getContext(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, Events.Action.PROCEED_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "upi", "phonebook");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isVPA", true);
        bundle.putString("vpa", str);
        bundle.putString("username", str2);
        bundle.putString("picture", this.f53904g);
        bundle.putInt("source_of_initiation", MoneyTransferV3Activity.c.PHONEBOOK.ordinal());
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        m.a(bundle, activity.getSupportFragmentManager(), R.id.fragmentContainer);
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        if (context instanceof net.one97.paytm.moneytransfer.d.b) {
            this.t = (net.one97.paytm.moneytransfer.d.b) context;
        }
    }

    private void e() {
        try {
            AnimationFactory.startWalletLoader(this.l);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            AnimationFactory.stopWalletLoader(this.l);
        } catch (Exception unused) {
        }
    }

    public final void a(ContactItemModel contactItemModel, int i2) {
        kotlin.g.b.k.c(contactItemModel, "contactModel");
        String str = "";
        this.f53903f = str;
        this.f53905h = str;
        String photoUri = contactItemModel.getPhotoUri();
        if (photoUri != null) {
            str = photoUri;
        }
        this.f53904g = str;
        this.E = true;
        if (!TextUtils.isEmpty(contactItemModel.getName())) {
            String name = contactItemModel.getName();
            kotlin.g.b.k.a((Object) name, "contactModel.name");
            this.f53903f = name;
        }
        if (this.f53902e) {
            return;
        }
        if (com.paytm.utility.a.m(getContext())) {
            String phnNo = contactItemModel.getPhnNo();
            kotlin.g.b.k.a((Object) phnNo, "contactModel.phnNo");
            c(phnNo);
            net.one97.paytm.moneytransfer.contacts.a.b bVar = this.f53898a;
            if (bVar != null) {
                bVar.a(i2);
                return;
            }
            return;
        }
        m.d((Activity) getActivity());
    }

    private final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.F = str;
            if (!com.paytm.utility.a.m(getActivity())) {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            } else if (!this.f53902e) {
                if (TextUtils.isEmpty(this.f53903f)) {
                    this.f53905h = str;
                } else {
                    this.f53905h = this.f53903f;
                }
                this.f53902e = true;
                net.one97.paytm.moneytransfer.contacts.b.a aVar = this.k;
                if (aVar == null) {
                    kotlin.g.b.k.a("mContactViewModel");
                }
                aVar.a(str);
            }
        }
    }

    public final void b() {
        this.f53903f = "";
        this.f53905h = "";
        this.E = false;
        AppCompatEditText appCompatEditText = this.j;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        if (kotlin.m.p.a((CharSequence) String.valueOf(appCompatEditText.getText()), (CharSequence) "@", false)) {
            AppCompatEditText appCompatEditText2 = this.j;
            if (appCompatEditText2 == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            if (d(String.valueOf(appCompatEditText2.getText()))) {
                net.one97.paytm.moneytransfer.viewmodel.b bVar = this.w;
                if (bVar == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                AppCompatEditText appCompatEditText3 = this.j;
                if (appCompatEditText3 == null) {
                    kotlin.g.b.k.a("mSearchEditText");
                }
                String valueOf = String.valueOf(appCompatEditText3.getText());
                if (valueOf != null) {
                    bVar.a(kotlin.m.p.b(valueOf).toString(), "");
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            return;
        }
        AppCompatEditText appCompatEditText4 = this.j;
        if (appCompatEditText4 == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        if (m.d(String.valueOf(appCompatEditText4.getText()))) {
            this.f53904g = "";
            UpiAppUtils.hideKeyboard(getActivity());
            AppCompatEditText appCompatEditText5 = this.j;
            if (appCompatEditText5 == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            c(String.valueOf(appCompatEditText5.getText()));
            return;
        }
        TextInputLayout textInputLayout = this.p;
        if (textInputLayout != null) {
            textInputLayout.setError(getString(R.string.err_valid_phone));
        }
    }

    private final boolean d(String str) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            TextInputLayout textInputLayout = this.p;
            if (textInputLayout != null) {
                textInputLayout.setError(getString(R.string.upi_empty_vpa_error));
            }
            return false;
        } else if (str.length() > 255) {
            TextInputLayout textInputLayout2 = this.p;
            if (textInputLayout2 != null) {
                textInputLayout2.setError(getString(R.string.upi_vpa_length_breach));
            }
            return false;
        } else if (new kotlin.m.l("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+").matches(charSequence)) {
            return true;
        } else {
            TextInputLayout textInputLayout3 = this.p;
            if (textInputLayout3 != null) {
                textInputLayout3.setError(getString(R.string.upi_invalid_upi));
            }
            return false;
        }
    }

    public final void a(String str) {
        ArrayList<ContactItemModel> arrayList;
        int indexOf;
        kotlin.g.b.k.c(str, "data");
        kotlin.g.b.k.c(str, "data");
        ArrayList<ContactItemModel> arrayList2 = this.f53900c;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ContactItemModel contactItemModel = arrayList2.get(i2);
                kotlin.g.b.k.a((Object) contactItemModel, "it.get(i)");
                ContactItemModel contactItemModel2 = contactItemModel;
                if (kotlin.m.p.a(contactItemModel2.getName(), str, true) && (arrayList = this.f53899b) != null && (indexOf = arrayList.indexOf(contactItemModel2)) >= 0 && indexOf < arrayList.size()) {
                    RecyclerView.LayoutManager layoutManager = this.f53901d;
                    if (layoutManager == null) {
                        kotlin.g.b.k.a("viewManager");
                    }
                    if (!(layoutManager instanceof LinearLayoutManager)) {
                        continue;
                    } else {
                        p pVar = this.B;
                        if (pVar == null) {
                            kotlin.g.b.k.a("smoothScroller");
                        }
                        if (pVar != null) {
                            pVar.setTargetPosition(indexOf);
                        }
                        try {
                            RecyclerView.LayoutManager layoutManager2 = this.f53901d;
                            if (layoutManager2 == null) {
                                kotlin.g.b.k.a("viewManager");
                            }
                            if (layoutManager2 != null) {
                                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                                p pVar2 = this.B;
                                if (pVar2 == null) {
                                    kotlin.g.b.k.a("smoothScroller");
                                }
                                linearLayoutManager.startSmoothScroll(pVar2);
                            } else {
                                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public final void onStart() {
        boolean z2;
        super.onStart();
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        if (androidx.core.content.b.a(context, "android.permission.READ_CONTACTS") != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 102);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            f();
        }
    }

    private final void f() {
        net.one97.paytm.moneytransfer.viewmodel.b bVar = this.w;
        if (bVar == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        if (!bVar.f54677b) {
            net.one97.paytm.moneytransfer.viewmodel.b bVar2 = this.w;
            if (bVar2 == null) {
                kotlin.g.b.k.a("moneyTransferActivityViewModel");
            }
            bVar2.a();
        }
        net.one97.paytm.moneytransfer.viewmodel.b bVar3 = this.w;
        if (bVar3 == null) {
            kotlin.g.b.k.a("moneyTransferActivityViewModel");
        }
        if (bVar3.o) {
            e();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 102) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            g();
            return;
        }
        this.D = false;
        f();
    }

    private final void g() {
        this.D = true;
        TextInputLayout textInputLayout = this.p;
        if (textInputLayout != null) {
            textInputLayout.setHint(getString(R.string.mt_enter_mobile_no_contact_search));
        }
        c(true);
        AppCompatEditText appCompatEditText = this.j;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        appCompatEditText.setInputType(2);
        FastScrollerLinearLayout fastScrollerLinearLayout = this.q;
        if (fastScrollerLinearLayout == null) {
            kotlin.g.b.k.a("fastScroller");
        }
        fastScrollerLinearLayout.setVisibility(8);
        TextView textView = this.o;
        if (textView == null) {
            kotlin.g.b.k.a("tvProceedButton");
        }
        textView.setVisibility(0);
        RecyclerView recyclerView = this.I;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        io.reactivex.rxjava3.b.c cVar = this.K;
        if (cVar == null) {
            kotlin.g.b.k.a("disposable");
        }
        cVar.dispose();
        HashMap hashMap = this.L;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void c() {
        a();
    }

    public final void a(boolean z2) {
        if (z2) {
            kotlin.m.l lVar = new kotlin.m.l("[0-9]+$");
            AppCompatEditText appCompatEditText = this.j;
            if (appCompatEditText == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            String valueOf = String.valueOf(appCompatEditText.getText());
            if (lVar.containsMatchIn(valueOf)) {
                TextView textView = this.o;
                if (textView == null) {
                    kotlin.g.b.k.a("tvProceedButton");
                }
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this.v;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                RecyclerView recyclerView = this.I;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                    return;
                }
                return;
            }
            AppCompatEditText appCompatEditText2 = this.j;
            if (appCompatEditText2 == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            if (kotlin.m.p.a((CharSequence) String.valueOf(appCompatEditText2.getText()), (CharSequence) "@", false)) {
                TextView textView3 = this.o;
                if (textView3 == null) {
                    kotlin.g.b.k.a("tvProceedButton");
                }
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = this.v;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                RecyclerView recyclerView2 = this.I;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                }
                net.one97.paytm.moneytransfer.viewmodel.b bVar = this.w;
                if (bVar == null) {
                    kotlin.g.b.k.a("moneyTransferActivityViewModel");
                }
                AppCompatEditText appCompatEditText3 = this.j;
                if (appCompatEditText3 == null) {
                    kotlin.g.b.k.a("mSearchEditText");
                }
                String valueOf2 = String.valueOf(appCompatEditText3.getText());
                if (valueOf2 != null) {
                    String obj = kotlin.m.p.b(valueOf2).toString();
                    kotlin.g.b.k.c(obj, "query");
                    String substring = obj.substring(kotlin.m.p.a((CharSequence) obj, "@", 0, false, 6) + 1, obj.length());
                    kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (bVar.s == null || bVar.s.size() == 0) {
                        c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
                        List<String> a2 = kotlin.m.p.a((CharSequence) net.one97.paytm.moneytransfer.d.c.a(c.a.a().f53991f), new String[]{AppConstants.COMMA});
                        if (a2 != null && (!a2.isEmpty())) {
                            for (String next : a2) {
                                ArrayList<String> arrayList = bVar.s;
                                if (arrayList != null) {
                                    arrayList.add(next);
                                }
                            }
                            bVar.r.setValue(bVar.s);
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (bVar.s != null) {
                        Iterator<String> it2 = bVar.s.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            kotlin.g.b.k.a((Object) next2, "t");
                            if (next2 != null) {
                                String lowerCase = next2.toLowerCase();
                                kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                                if (kotlin.m.p.b(lowerCase, substring, false)) {
                                    arrayList2.add(next2);
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                    y<ArrayList<String>> yVar = bVar.r;
                    if (yVar != null) {
                        yVar.setValue(arrayList2);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            TextView textView5 = this.o;
            if (textView5 == null) {
                kotlin.g.b.k.a("tvProceedButton");
            }
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.v;
            if (textView6 != null) {
                textView6.setText(getString(R.string.contact_not_found_error, valueOf));
            }
            TextView textView7 = this.v;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            RecyclerView recyclerView3 = this.I;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView8 = this.o;
        if (textView8 == null) {
            kotlin.g.b.k.a("tvProceedButton");
        }
        if (textView8 != null) {
            textView8.setVisibility(8);
        }
        TextView textView9 = this.v;
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        RecyclerView recyclerView4 = this.I;
        if (recyclerView4 != null) {
            recyclerView4.setVisibility(8);
        }
    }

    private void c(boolean z2) {
        if (z2) {
            AppCompatEditText appCompatEditText = this.j;
            if (appCompatEditText == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            appCompatEditText.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{this.z});
            return;
        }
        AppCompatEditText appCompatEditText2 = this.j;
        if (appCompatEditText2 == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        appCompatEditText2.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{this.A});
    }

    private final void h() {
        androidx.fragment.app.j supportFragmentManager;
        net.one97.paytm.moneytransfer.utils.f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_PHONEBOOK_CLICKED_N_DIALOG_LOADED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "user_not_on_UPI_Bank_Account", "");
        UpiAppUtils.hideKeyboard(getActivity());
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            androidx.fragment.app.q qVar = null;
            Boolean valueOf = activity != null ? Boolean.valueOf(activity.isFinishing()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (!valueOf.booleanValue()) {
                FragmentActivity activity2 = getActivity();
                if (!(activity2 == null || (supportFragmentManager = activity2.getSupportFragmentManager()) == null)) {
                    qVar = supportFragmentManager.a();
                }
                net.one97.paytm.moneytransfer.view.fragments.i iVar = new net.one97.paytm.moneytransfer.view.fragments.i();
                Bundle bundle = new Bundle();
                if (kotlin.m.p.a(this.f53905h) && kotlin.m.p.a(this.f53903f)) {
                    bundle.putString(ContactColumn.PHONE_NUMBER, this.F);
                } else if (kotlin.m.p.a(this.f53903f)) {
                    bundle.putString(ContactColumn.PHONE_NUMBER, this.f53905h);
                } else {
                    bundle.putString(ContactColumn.PHONE_NUMBER, this.f53903f);
                }
                iVar.setArguments(bundle);
                net.one97.paytm.moneytransfer.d.b bVar = this.t;
                if (bVar != null) {
                    iVar.a(bVar);
                }
                if (qVar != null) {
                    qVar.a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out);
                }
                if (qVar != null) {
                    qVar.a(R.id.fragmentContainer, iVar, "MoneyTransferNoUPIUserFragment").a("MoneyTransferNoUPIUserFragment");
                }
                if (qVar != null) {
                    qVar.c();
                }
            }
        }
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "tag");
        StringBuilder sb = new StringBuilder();
        AppCompatEditText appCompatEditText = this.j;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mSearchEditText");
        }
        String valueOf = String.valueOf(appCompatEditText.getText());
        if (valueOf != null) {
            String obj = kotlin.m.p.b(valueOf).toString();
            int a2 = kotlin.m.p.a((CharSequence) obj, "@", 0, false, 6);
            if (a2 != -1) {
                int i2 = a2 + 1;
                if (obj != null) {
                    obj = obj.substring(0, i2);
                    kotlin.g.b.k.a((Object) obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            sb.append(obj);
            sb.append(str);
            AppCompatEditText appCompatEditText2 = this.j;
            if (appCompatEditText2 == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            appCompatEditText2.setText(sb.toString());
            AppCompatEditText appCompatEditText3 = this.j;
            if (appCompatEditText3 == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            appCompatEditText3.setSelection(sb.length());
            net.one97.paytm.moneytransfer.viewmodel.b bVar = this.w;
            if (bVar == null) {
                kotlin.g.b.k.a("moneyTransferActivityViewModel");
            }
            AppCompatEditText appCompatEditText4 = this.j;
            if (appCompatEditText4 == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            String valueOf2 = String.valueOf(appCompatEditText4.getText());
            if (valueOf2 != null) {
                bVar.a(kotlin.m.p.b(valueOf2).toString(), "");
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    static final class j<T> implements io.reactivex.rxjava3.d.q<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53962a;

        j(a aVar) {
            this.f53962a = aVar;
        }

        public final /* synthetic */ boolean test(Object obj) {
            return !this.f53962a.D;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x014a, code lost:
        r12 = r12.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.contacts.a r12, net.one97.paytm.moneytransfer.contacts.b.a.b r13) {
        /*
            r0 = 0
            r12.f53902e = r0
            r12.b((boolean) r0)
            if (r13 == 0) goto L_0x019d
            boolean r1 = r13.f53978b
            if (r1 == 0) goto L_0x000f
            r12.d()
        L_0x000f:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$PaymentOptionList r13 = r13.f53977a
            if (r13 == 0) goto L_0x019d
            java.lang.String r1 = "paymentOptionListItem"
            kotlin.g.b.k.c(r13, r1)
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r1 = r13.getDestinationPayment()
            java.lang.String r2 = "paymentOptionListItem.destinationPayment"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$Error r1 = r1.getError()
            if (r1 == 0) goto L_0x002b
            r12.d()
            return
        L_0x002b:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r1 = r13.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getPaymentType()
            net.one97.paytm.upi.common.PaymentInstrumentationType r3 = net.one97.paytm.upi.common.PaymentInstrumentationType.UPI
            java.lang.String r3 = r3.name()
            r4 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r4)
            java.lang.String r3 = "name"
            if (r1 == 0) goto L_0x007e
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r0 = r13.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r0 = r0.getVpaId()
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r13 = r13.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
            java.lang.String r13 = r13.getDisplayName()
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r5 = "wallet_money_transfer"
            java.lang.String r6 = "selected_contact_link_status"
            java.lang.String r7 = "/money-transfer"
            java.lang.String r8 = "linked_upi"
            java.lang.String r9 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r4, r5, r6, r7, r8, r9)
            java.lang.String r1 = "vpaId"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r12.a((java.lang.String) r0, (java.lang.String) r13)
            goto L_0x0138
        L_0x007e:
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r1 = r13.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getPaymentType()
            net.one97.paytm.upi.common.PaymentInstrumentationType r5 = net.one97.paytm.upi.common.PaymentInstrumentationType.BANK
            java.lang.String r5 = r5.name()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r4)
            if (r1 == 0) goto L_0x0138
            androidx.fragment.app.FragmentActivity r1 = r12.getActivity()
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r5 = "wallet_money_transfer"
            java.lang.String r6 = "selected_contact_link_status"
            java.lang.String r7 = "/money-transfer"
            java.lang.String r8 = "linked_bank"
            java.lang.String r9 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r4, r5, r6, r7, r8, r9)
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r1 = r13.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getBankAccountNumber()
            java.lang.String r4 = "paymentOptionListItem.de…Payment.bankAccountNumber"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = r12.f53903f
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r5 = r13.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            java.lang.String r5 = r5.getIfscCode()
            java.lang.String r6 = "paymentOptionListItem.destinationPayment.ifscCode"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$DestinationPayment r13 = r13.getDestinationPayment()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
            java.lang.String r13 = r13.getBankName()
            java.lang.String r2 = "paymentOptionListItem.destinationPayment.bankName"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
            android.content.Context r6 = r12.getContext()
            java.lang.String r7 = "wallet_money_transfer"
            java.lang.String r8 = "proceed_clicked"
            java.lang.String r9 = "/money-transfer"
            java.lang.String r10 = "bank_account"
            java.lang.String r11 = "phonebook"
            net.one97.paytm.moneytransfer.utils.f.a(r6, r7, r8, r9, r10, r11)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r6 = "isVPA"
            r2.putBoolean(r6, r0)
            java.lang.String r0 = "vpa"
            r2.putString(r0, r1)
            java.lang.String r0 = "username"
            r2.putString(r0, r4)
            java.lang.String r0 = "ifsc"
            r2.putString(r0, r5)
            java.lang.String r0 = "bankname"
            r2.putString(r0, r13)
            java.lang.String r13 = r12.f53904g
            java.lang.String r0 = "picture"
            r2.putString(r0, r13)
            net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity$c r13 = net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity.c.PHONEBOOK
            int r13 = r13.ordinal()
            java.lang.String r0 = "source_of_initiation"
            r2.putInt(r0, r13)
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            if (r13 != 0) goto L_0x012a
            kotlin.g.b.k.a()
        L_0x012a:
            java.lang.String r0 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            androidx.fragment.app.j r13 = r13.getSupportFragmentManager()
            int r0 = net.one97.paytm.moneytransfer.R.id.fragmentContainer
            net.one97.paytm.moneytransfer.utils.m.a((android.os.Bundle) r2, (androidx.fragment.app.j) r13, (int) r0)
        L_0x0138:
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            r4 = r13
            android.content.Context r4 = (android.content.Context) r4
            androidx.appcompat.widget.AppCompatEditText r12 = r12.j
            if (r12 != 0) goto L_0x0148
            java.lang.String r13 = "mSearchEditText"
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0148:
            if (r12 == 0) goto L_0x0155
            android.text.Editable r12 = r12.getText()
            if (r12 == 0) goto L_0x0155
            java.lang.String r12 = r12.toString()
            goto L_0x0156
        L_0x0155:
            r12 = 0
        L_0x0156:
            r13 = r12
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0163
            java.lang.String r3 = "none"
        L_0x0161:
            r9 = r3
            goto L_0x0190
        L_0x0163:
            kotlin.m.l r13 = new kotlin.m.l
            java.lang.String r0 = "[0-9]+$"
            r13.<init>((java.lang.String) r0)
            kotlin.m.l r0 = new kotlin.m.l
            java.lang.String r1 = "[A-Za-z]+$"
            r0.<init>((java.lang.String) r1)
            java.lang.String r1 = java.lang.String.valueOf(r12)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r13 = r13.containsMatchIn(r1)
            if (r13 == 0) goto L_0x0180
            java.lang.String r3 = "phone_number"
            goto L_0x0161
        L_0x0180:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = r0.containsMatchIn(r12)
            if (r12 == 0) goto L_0x018d
            goto L_0x0161
        L_0x018d:
            java.lang.String r3 = "name_phone_number_both"
            goto L_0x0161
        L_0x0190:
            java.lang.String r5 = "wallet_money_transfer"
            java.lang.String r6 = "phonebook_list_clicked"
            java.lang.String r7 = "/money-transfer"
            java.lang.String r8 = "user_on_UPI_or_Bank_Account"
            net.one97.paytm.moneytransfer.utils.f.a(r4, r5, r6, r7, r8, r9)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.contacts.a.a(net.one97.paytm.moneytransfer.contacts.a, net.one97.paytm.moneytransfer.contacts.b.a$b):void");
    }

    public static final /* synthetic */ void a(a aVar, UpiCustomVolleyError upiCustomVolleyError) {
        aVar.f53902e = false;
        aVar.b(false);
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equals(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
            m.b((Activity) aVar.getActivity());
        } else {
            aVar.d();
        }
    }

    public static final /* synthetic */ void a(a aVar, b.C0979b bVar) {
        String str;
        String str2;
        TextInputLayout textInputLayout;
        TextInputLayout textInputLayout2;
        aVar.b(false);
        Integer num = null;
        if (bVar != null) {
            str = bVar.f54690b;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            AppCompatEditText appCompatEditText = aVar.j;
            if (appCompatEditText == null) {
                kotlin.g.b.k.a("mSearchEditText");
            }
            String valueOf = String.valueOf(appCompatEditText.getText());
            if (valueOf != null) {
                String obj = kotlin.m.p.b(valueOf).toString();
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                aVar.a(obj, str);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (bVar != null) {
            str2 = bVar.f54691c;
        } else {
            str2 = null;
        }
        if (bVar != null) {
            num = Integer.valueOf(bVar.f54689a);
        }
        if (num != null && num.intValue() == 1) {
            TextInputLayout textInputLayout3 = aVar.p;
            if (textInputLayout3 != null) {
                textInputLayout3.setError(aVar.getString(R.string.upi_unable_to_verify_vpa));
            }
        } else if (num != null && num.intValue() == 2) {
            if (kotlin.m.p.a(UpiUtils.AUTHENTICATION_FAILURE_401, str2, true)) {
                m.b((Activity) aVar.getActivity());
            }
            if ((kotlin.m.p.a("XH", str2, true) || kotlin.m.p.a("J02", str2, true) || kotlin.m.p.a("U17", str2, true) || kotlin.m.p.a("0037", str2, true)) && (textInputLayout2 = aVar.p) != null) {
                textInputLayout2.setError(aVar.getString(R.string.upi_address_incorrect));
            }
            if (kotlin.m.p.a("INT-1470", str2, true) && (textInputLayout = aVar.p) != null) {
                textInputLayout.setError(aVar.getString(R.string.mt_vpa_verify_no_bank_linked_err));
            }
            if (kotlin.m.p.a("1006", str2, true)) {
                Intent intent = new Intent(aVar.getActivity(), UpiRegistrationActivity.class);
                intent.putExtra("redirect", 80);
                intent.setFlags(536870912);
                aVar.startActivityForResult(intent, 2013);
            }
        }
    }

    public static final /* synthetic */ void b(a aVar, UpiCustomVolleyError upiCustomVolleyError) {
        aVar.b(false);
        if (upiCustomVolleyError == null) {
            return;
        }
        if (kotlin.m.p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || kotlin.m.p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
            m.b((Activity) aVar.getActivity());
        } else {
            aVar.h();
        }
    }

    public static final /* synthetic */ void c(a aVar, String str) {
        if (new kotlin.m.l("[0-9]+$").containsMatchIn(str)) {
            aVar.c(true);
        } else {
            aVar.c(false);
        }
    }

    public static final /* synthetic */ void h(a aVar) {
        net.one97.paytm.moneytransfer.contacts.a.b bVar;
        net.one97.paytm.moneytransfer.contacts.a.b bVar2 = aVar.f53898a;
        if (bVar2 != null) {
            kotlin.g.b.k.c("", CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            bVar2.f53936e = "";
        }
        TextInputLayout textInputLayout = aVar.p;
        if (textInputLayout != null) {
            textInputLayout.setError("");
        }
        TextInputLayout textInputLayout2 = aVar.p;
        if (textInputLayout2 != null) {
            textInputLayout2.setErrorEnabled(false);
        }
        ImageView imageView = aVar.n;
        if (imageView == null) {
            kotlin.g.b.k.a("ivCross");
        }
        imageView.setVisibility(8);
        if (!aVar.D) {
            Collection collection = aVar.f53899b;
            if (!(collection == null || collection.isEmpty())) {
                ArrayList<ContactItemModel> arrayList = aVar.f53899b;
                if (!(arrayList == null || (bVar = aVar.f53898a) == null)) {
                    bVar.a(arrayList);
                }
                FastScrollerLinearLayout fastScrollerLinearLayout = aVar.q;
                if (fastScrollerLinearLayout == null) {
                    kotlin.g.b.k.a("fastScroller");
                }
                fastScrollerLinearLayout.setVisibility(0);
                FastScrollerLinearLayout fastScrollerLinearLayout2 = aVar.q;
                if (fastScrollerLinearLayout2 == null) {
                    kotlin.g.b.k.a("fastScroller");
                }
                fastScrollerLinearLayout2.a(0);
                TextView textView = aVar.o;
                if (textView == null) {
                    kotlin.g.b.k.a("tvProceedButton");
                }
                textView.setVisibility(8);
                RelativeLayout relativeLayout = aVar.G;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                RecyclerView recyclerView = aVar.I;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
            }
        }
    }
}
