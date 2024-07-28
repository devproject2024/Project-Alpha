package net.one97.paytm.addmoney.togv.view;

import android.app.Activity;
import android.content.Context;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.contactsSdk.database.Tables;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.u;
import net.one97.paytm.addmoney.FastScrollerLinearLayout;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.moneytransfer.contacts.a.a;
import net.one97.paytm.upi.requestmoney.model.ContactItemModel;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends Fragment implements View.OnClickListener, FastScrollerLinearLayout.a, a.d {
    private b A;
    private String B;
    private io.reactivex.rxjava3.b.b C;
    private io.reactivex.rxjava3.b.c D;
    private HashMap E;

    /* renamed from: a  reason: collision with root package name */
    TextInputEditText f48782a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.contacts.a.a f48783b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ContactItemModel> f48784c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<ContactItemModel> f48785d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView.LayoutManager f48786e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f48787f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f48788g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f48789h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f48790i;
    private TextView j;
    /* access modifiers changed from: private */
    public TextInputLayout k;
    private FastScrollerLinearLayout l;
    /* access modifiers changed from: private */
    public final float m = 0.2f;
    private final long n = 100;
    /* access modifiers changed from: private */
    public final io.reactivex.rxjava3.j.b<String> o;
    private TextView p;
    private final int q;
    private final int r;
    private final InputFilter.LengthFilter s;
    private final InputFilter.LengthFilter t;
    private p u;
    private TextWatcher v;
    /* access modifiers changed from: private */
    public boolean w;
    private RelativeLayout x;
    private LottieAnimationView y;
    private net.one97.paytm.addmoney.togv.d.a z;

    static final class b<T> implements io.reactivex.rxjava3.d.g<net.one97.paytm.addmoney.togv.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48792a;

        b(a aVar) {
            this.f48792a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            net.one97.paytm.addmoney.togv.a aVar = (net.one97.paytm.addmoney.togv.a) obj;
            a aVar2 = this.f48792a;
            k.a((Object) aVar, Tables.CONTACTS);
            ArrayList<ContactItemModel> a2 = aVar.a();
            ArrayList<ContactItemModel> b2 = aVar.b();
            if (AddMoneyUtils.a((Fragment) aVar2)) {
                aVar2.f48784c = a2;
                aVar2.f48785d = b2;
                ArrayList<ContactItemModel> arrayList = aVar2.f48784c;
                if (arrayList != null && arrayList.size() > 0) {
                    net.one97.paytm.moneytransfer.contacts.a.a aVar3 = aVar2.f48783b;
                    if (aVar3 != null) {
                        aVar3.a(arrayList);
                    }
                    net.one97.paytm.moneytransfer.contacts.a.a aVar4 = aVar2.f48783b;
                    if (aVar4 != null) {
                        k.c(arrayList, "originalList");
                        aVar4.f53910c = arrayList;
                    }
                }
                aVar2.a();
                TextInputEditText textInputEditText = aVar2.f48782a;
                if (textInputEditText == null) {
                    k.a("mSearchEditText");
                }
                net.one97.paytm.wallet.utility.e.b((EditText) textInputEditText, (Activity) aVar2.getActivity());
            }
        }
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f48793a = new c();

        c() {
        }

        public final /* synthetic */ void accept(Object obj) {
            ((Throwable) obj).printStackTrace();
        }
    }

    static final class i<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f48799a = new i();

        i() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str = (String) obj;
            k.a((Object) str, "it");
            if (str != null) {
                String lowerCase = str.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (lowerCase != null) {
                    return kotlin.m.p.b(lowerCase).toString();
                }
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    static final class j<T> implements io.reactivex.rxjava3.d.g<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48800a;

        j(a aVar) {
            this.f48800a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Filter filter;
            CharSequence charSequence = (String) obj;
            if (!TextUtils.isEmpty(charSequence)) {
                net.one97.paytm.moneytransfer.contacts.a.a l = this.f48800a.f48783b;
                if (l != null && (filter = l.getFilter()) != null) {
                    filter.filter(charSequence);
                    return;
                }
                return;
            }
            a.f(this.f48800a);
        }
    }

    public static final /* synthetic */ ImageView b(a aVar) {
        ImageView imageView = aVar.f48790i;
        if (imageView == null) {
            k.a("ivCross");
        }
        return imageView;
    }

    public static final /* synthetic */ FastScrollerLinearLayout e(a aVar) {
        FastScrollerLinearLayout fastScrollerLinearLayout = aVar.l;
        if (fastScrollerLinearLayout == null) {
            k.a("fastScroller");
        }
        return fastScrollerLinearLayout;
    }

    public static final /* synthetic */ TextView h(a aVar) {
        TextView textView = aVar.j;
        if (textView == null) {
            k.a("tvProceedButton");
        }
        return textView;
    }

    public a() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.o = a2;
        this.q = 12;
        this.r = 100;
        this.s = new InputFilter.LengthFilter(this.q);
        this.t = new InputFilter.LengthFilter(this.r);
    }

    public a(b bVar) {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.o = a2;
        this.q = 12;
        this.r = 100;
        this.s = new InputFilter.LengthFilter(this.q);
        this.t = new InputFilter.LengthFilter(this.r);
        this.A = bVar;
    }

    public a(String str) {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.o = a2;
        this.q = 12;
        this.r = 100;
        this.s = new InputFilter.LengthFilter(this.q);
        this.t = new InputFilter.LengthFilter(this.r);
        this.B = str;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.contacts_list_fragment, viewGroup, false);
        this.C = new io.reactivex.rxjava3.b.b();
        k.a((Object) inflate, "view");
        k.c(inflate, "view");
        View findViewById = inflate.findViewById(R.id.iv_back);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = inflate.findViewById(R.id.contactEditText);
        k.a((Object) findViewById2, "view.findViewById(R.id.contactEditText)");
        this.f48782a = (TextInputEditText) findViewById2;
        TextInputEditText textInputEditText = this.f48782a;
        if (textInputEditText == null) {
            k.a("mSearchEditText");
        }
        textInputEditText.requestFocus();
        View findViewById3 = inflate.findViewById(R.id.contactsRecyclerView);
        k.a((Object) findViewById3, "view.findViewById(R.id.contactsRecyclerView)");
        this.f48787f = (RecyclerView) findViewById3;
        this.f48786e = new LinearLayoutManager(getContext());
        this.f48783b = new net.one97.paytm.moneytransfer.contacts.a.a(new ArrayList(), getContext(), this);
        this.k = (TextInputLayout) inflate.findViewById(R.id.til_searchbox);
        RecyclerView recyclerView = this.f48787f;
        if (recyclerView == null) {
            k.a("contactsRV");
        }
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = this.f48787f;
        if (recyclerView2 == null) {
            k.a("contactsRV");
        }
        RecyclerView.LayoutManager layoutManager = this.f48786e;
        if (layoutManager == null) {
            k.a("viewManager");
        }
        recyclerView2.setLayoutManager(layoutManager);
        RecyclerView recyclerView3 = this.f48787f;
        if (recyclerView3 == null) {
            k.a("contactsRV");
        }
        recyclerView3.setAdapter(this.f48783b);
        View findViewById4 = inflate.findViewById(R.id.tv_btn_proceed);
        k.a((Object) findViewById4, "view.findViewById(R.id.tv_btn_proceed)");
        this.j = (TextView) findViewById4;
        TextView textView = this.j;
        if (textView == null) {
            k.a("tvProceedButton");
        }
        View.OnClickListener onClickListener = this;
        textView.setOnClickListener(onClickListener);
        this.v = new d(this);
        TextInputEditText textInputEditText2 = this.f48782a;
        if (textInputEditText2 == null) {
            k.a("mSearchEditText");
        }
        textInputEditText2.addTextChangedListener(this.v);
        io.reactivex.rxjava3.b.c subscribe = this.o.debounce(this.n, TimeUnit.MILLISECONDS).distinctUntilChanged().observeOn(io.reactivex.rxjava3.android.b.a.a()).filter(new h(this)).subscribeOn(io.reactivex.rxjava3.i.a.b()).map(i.f48799a).subscribe(new j(this));
        k.a((Object) subscribe, "subject.debounce(QUERY_T…arch();\n                }");
        this.D = subscribe;
        io.reactivex.rxjava3.b.b bVar = this.C;
        if (bVar == null) {
            k.a("compositeDisposable");
        }
        io.reactivex.rxjava3.b.c cVar = this.D;
        if (cVar == null) {
            k.a("disposable");
        }
        bVar.a(cVar);
        this.f48788g = (LottieAnimationView) inflate.findViewById(R.id.top_success_anim_view);
        String[] stringArray = getResources().getStringArray(R.array.alphabet_array);
        k.a((Object) stringArray, "resources.getStringArray(R.array.alphabet_array)");
        this.f48789h = stringArray;
        RecyclerView recyclerView4 = this.f48787f;
        if (recyclerView4 == null) {
            k.a("contactsRV");
        }
        if (recyclerView4 != null) {
            recyclerView4.addOnScrollListener(new e(this));
        }
        View findViewById5 = inflate.findViewById(R.id.iv_cross_search);
        k.a((Object) findViewById5, "view.findViewById(R.id.iv_cross_search)");
        this.f48790i = (ImageView) findViewById5;
        ImageView imageView = this.f48790i;
        if (imageView == null) {
            k.a("ivCross");
        }
        imageView.setOnClickListener(onClickListener);
        TextInputEditText textInputEditText3 = this.f48782a;
        if (textInputEditText3 == null) {
            k.a("mSearchEditText");
        }
        textInputEditText3.setOnEditorActionListener(new f(this));
        View findViewById6 = inflate.findViewById(R.id.fast_scroller);
        k.a((Object) findViewById6, "view.findViewById(R.id.fast_scroller)");
        this.l = (FastScrollerLinearLayout) findViewById6;
        FastScrollerLinearLayout fastScrollerLinearLayout = this.l;
        if (fastScrollerLinearLayout == null) {
            k.a("fastScroller");
        }
        RecyclerView recyclerView5 = this.f48787f;
        if (recyclerView5 == null) {
            k.a("contactsRV");
        }
        String[] strArr = this.f48789h;
        if (strArr == null) {
            k.a("indexList");
        }
        fastScrollerLinearLayout.setUpWithRecyclerView(recyclerView5, strArr, this);
        RecyclerView recyclerView6 = this.f48787f;
        if (recyclerView6 == null) {
            k.a("contactsRV");
        }
        recyclerView6.setNestedScrollingEnabled(false);
        this.p = (TextView) inflate.findViewById(R.id.tv_no_result_found);
        this.u = new g(this, getContext());
        this.x = (RelativeLayout) inflate.findViewById(R.id.money_transfer_loader_container);
        this.y = (LottieAnimationView) inflate.findViewById(R.id.money_transfer_loader);
        ArrayList<ContactItemModel> arrayList = this.f48784c;
        if (arrayList != null && arrayList.size() == 0) {
            f();
        }
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
                TextInputEditText textInputEditText = this.f48782a;
                if (textInputEditText == null) {
                    k.a("mSearchEditText");
                }
                textInputEditText.setText("");
                return;
            }
            int i4 = R.id.tv_btn_proceed;
            if (valueOf != null && valueOf.intValue() == i4) {
                c();
            }
        } else if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                bool = Boolean.valueOf(activity.isFinishing());
            }
            if (bool == null) {
                k.a();
            }
            if (!bool.booleanValue()) {
                UpiAppUtils.hideKeyboard(getActivity());
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                if (activity2.getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
                    FragmentActivity activity3 = getActivity();
                    if (activity3 == null) {
                        k.a();
                    }
                    activity3.finish();
                    return;
                }
                FragmentActivity activity4 = getActivity();
                if (activity4 != null && (supportFragmentManager = activity4.getSupportFragmentManager()) != null) {
                    supportFragmentManager.d();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        TextInputEditText textInputEditText = this.f48782a;
        if (textInputEditText == null) {
            k.a("mSearchEditText");
        }
        ContactItemModel contactItemModel = new ContactItemModel((String) null, String.valueOf(textInputEditText.getText()), (String) null, false);
        TextInputEditText textInputEditText2 = this.f48782a;
        if (textInputEditText2 == null) {
            k.a("mSearchEditText");
        }
        if (!net.one97.paytm.wallet.utility.e.d(String.valueOf(textInputEditText2.getText()))) {
            TextInputLayout textInputLayout = this.k;
            if (textInputLayout != null) {
                textInputLayout.setError(getString(R.string.err_valid_phone));
                return;
            }
            return;
        }
        a(contactItemModel);
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48794a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        d(a aVar) {
            this.f48794a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            this.f48794a.o.onNext(String.valueOf(editable));
            String valueOf = String.valueOf(editable);
            if (valueOf == null) {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (!TextUtils.isEmpty(kotlin.m.p.b(valueOf).toString())) {
                a.b(this.f48794a).setVisibility(0);
                if (!this.f48794a.w) {
                    a aVar = this.f48794a;
                    String valueOf2 = String.valueOf(editable);
                    if (valueOf2 != null) {
                        a.a(aVar, kotlin.m.p.b(valueOf2).toString());
                        TextInputLayout d2 = this.f48794a.k;
                        if (d2 != null) {
                            d2.setError("");
                        }
                        TextInputLayout d3 = this.f48794a.k;
                        if (d3 != null) {
                            d3.setErrorEnabled(false);
                        }
                        a.e(this.f48794a).setVisibility(8);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                }
            } else {
                a.f(this.f48794a);
            }
        }
    }

    public static final class e extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48795a;

        e(a aVar) {
            this.f48795a = aVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            ContactItemModel contactItemModel;
            ContactItemModel contactItemModel2;
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                if (layoutManager2 != null) {
                    int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition();
                    if (a.e(this.f48795a).getVisibility() == 0) {
                        Collection g2 = this.f48795a.f48784c;
                        int i4 = 0;
                        if (!(g2 == null || g2.isEmpty())) {
                            ArrayList g3 = this.f48795a.f48784c;
                            String str = null;
                            Integer valueOf = g3 != null ? Integer.valueOf(g3.size()) : null;
                            if (valueOf == null) {
                                k.a();
                            }
                            if (findLastCompletelyVisibleItemPosition < valueOf.intValue() - 1 && findFirstCompletelyVisibleItemPosition >= 0) {
                                ArrayList g4 = this.f48795a.f48784c;
                                if ((g4 == null || (contactItemModel2 = (ContactItemModel) g4.get(findFirstCompletelyVisibleItemPosition)) == null) ? false : contactItemModel2.ismIsHeading()) {
                                    FastScrollerLinearLayout e2 = a.e(this.f48795a);
                                    ArrayList g5 = this.f48795a.f48784c;
                                    if (!(g5 == null || (contactItemModel = (ContactItemModel) g5.get(findFirstCompletelyVisibleItemPosition)) == null)) {
                                        str = contactItemModel.getName();
                                    }
                                    String[] strArr = e2.f48010b;
                                    if (strArr == null) {
                                        k.a("sectionList");
                                    }
                                    int length = strArr.length;
                                    while (true) {
                                        if (i4 >= length) {
                                            i4 = -1;
                                            break;
                                        }
                                        String[] strArr2 = e2.f48010b;
                                        if (strArr2 == null) {
                                            k.a("sectionList");
                                        }
                                        if (kotlin.m.p.a(strArr2[i4], str, true)) {
                                            break;
                                        }
                                        i4++;
                                    }
                                    if (i4 != -1) {
                                        e2.a(i4);
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

    public static final class f implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48796a;

        f(a aVar) {
            this.f48796a = aVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6 || a.h(this.f48796a).getVisibility() != 0) {
                return false;
            }
            this.f48796a.c();
            return true;
        }
    }

    public static final class g extends p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48797a;

        public final int getVerticalSnapPreference() {
            return -1;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(a aVar, Context context) {
            super(context);
            this.f48797a = aVar;
        }

        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return super.calculateSpeedPerPixel(displayMetrics) * this.f48797a.m;
        }
    }

    private void d() {
        try {
            AnimationFactory.startWalletLoader(this.f48788g);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            AnimationFactory.stopWalletLoader(this.f48788g);
        } catch (Exception unused) {
        }
    }

    public final void a(ContactItemModel contactItemModel) {
        k.c(contactItemModel, "contactModel");
        if (TextUtils.isEmpty(contactItemModel.getPhnNo()) || !contactItemModel.getPhnNo().equals(com.paytm.utility.b.l((Context) getActivity()))) {
            b bVar = this.A;
            if (bVar != null) {
                bVar.a(contactItemModel);
            }
            b(contactItemModel);
            return;
        }
        com.paytm.utility.b.b((Context) getActivity(), "Alert", "Please select a contact other than your own");
    }

    private final void b(ContactItemModel contactItemModel) {
        net.one97.paytm.addmoney.togv.d.a aVar = this.z;
        if (aVar != null) {
            aVar.a(contactItemModel.getPhnNo().toString());
        }
    }

    public final void a(String str) {
        ArrayList<ContactItemModel> arrayList;
        int indexOf;
        k.c(str, "data");
        k.c(str, "data");
        ArrayList<ContactItemModel> arrayList2 = this.f48785d;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ContactItemModel contactItemModel = arrayList2.get(i2);
                k.a((Object) contactItemModel, "it.get(i)");
                ContactItemModel contactItemModel2 = contactItemModel;
                if (kotlin.m.p.a(contactItemModel2.getName(), str, true) && (arrayList = this.f48784c) != null && (indexOf = arrayList.indexOf(contactItemModel2)) >= 0 && indexOf < arrayList.size()) {
                    RecyclerView.LayoutManager layoutManager = this.f48786e;
                    if (layoutManager == null) {
                        k.a("viewManager");
                    }
                    if (!(layoutManager instanceof LinearLayoutManager)) {
                        continue;
                    } else {
                        p pVar = this.u;
                        if (pVar == null) {
                            k.a("smoothScroller");
                        }
                        if (pVar != null) {
                            pVar.setTargetPosition(indexOf);
                        }
                        try {
                            RecyclerView.LayoutManager layoutManager2 = this.f48786e;
                            if (layoutManager2 == null) {
                                k.a("viewManager");
                            }
                            if (layoutManager2 != null) {
                                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                                p pVar2 = this.u;
                                if (pVar2 == null) {
                                    k.a("smoothScroller");
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
            k.a();
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
            e();
        }
    }

    private final void e() {
        d();
        io.reactivex.rxjava3.b.c a2 = y.a(new C0859a(this)).a(io.reactivex.rxjava3.android.b.a.a()).b(io.reactivex.rxjava3.i.a.b()).a(new b(this), (io.reactivex.rxjava3.d.g<? super Throwable>) c.f48793a);
        io.reactivex.rxjava3.b.b bVar = this.C;
        if (bVar == null) {
            k.a("compositeDisposable");
        }
        bVar.a(a2);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 102) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            f();
            return;
        }
        this.w = false;
        e();
    }

    private final void f() {
        this.w = true;
        TextInputLayout textInputLayout = this.k;
        if (textInputLayout != null) {
            textInputLayout.setHint(getString(R.string.mt_enter_mobile_no_contact_search));
        }
        b(true);
        TextInputEditText textInputEditText = this.f48782a;
        if (textInputEditText == null) {
            k.a("mSearchEditText");
        }
        textInputEditText.setInputType(2);
        FastScrollerLinearLayout fastScrollerLinearLayout = this.l;
        if (fastScrollerLinearLayout == null) {
            k.a("fastScroller");
        }
        fastScrollerLinearLayout.setVisibility(8);
        TextView textView = this.j;
        if (textView == null) {
            k.a("tvProceedButton");
        }
        textView.setVisibility(0);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        io.reactivex.rxjava3.b.b bVar = this.C;
        if (bVar == null) {
            k.a("compositeDisposable");
        }
        bVar.dispose();
        HashMap hashMap = this.E;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void b() {
        a();
    }

    public final void a(boolean z2) {
        if (z2) {
            l lVar = new l("[0-9]+$");
            TextInputEditText textInputEditText = this.f48782a;
            if (textInputEditText == null) {
                k.a("mSearchEditText");
            }
            String valueOf = String.valueOf(textInputEditText.getText());
            if (lVar.containsMatchIn(valueOf)) {
                TextView textView = this.j;
                if (textView == null) {
                    k.a("tvProceedButton");
                }
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this.p;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    return;
                }
                return;
            }
            TextView textView3 = this.j;
            if (textView3 == null) {
                k.a("tvProceedButton");
            }
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.p;
            if (textView4 != null) {
                textView4.setText(getString(R.string.contact_not_found_error, valueOf));
            }
            TextView textView5 = this.p;
            if (textView5 != null) {
                textView5.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView6 = this.j;
        if (textView6 == null) {
            k.a("tvProceedButton");
        }
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        TextView textView7 = this.p;
        if (textView7 != null) {
            textView7.setVisibility(8);
        }
    }

    private void b(boolean z2) {
        if (z2) {
            TextInputEditText textInputEditText = this.f48782a;
            if (textInputEditText == null) {
                k.a("mSearchEditText");
            }
            textInputEditText.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{this.s});
            return;
        }
        TextInputEditText textInputEditText2 = this.f48782a;
        if (textInputEditText2 == null) {
            k.a("mSearchEditText");
        }
        textInputEditText2.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{this.t});
    }

    /* renamed from: net.one97.paytm.addmoney.togv.view.a$a  reason: collision with other inner class name */
    static final class C0859a<V> implements Callable<net.one97.paytm.addmoney.togv.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48791a;

        C0859a(a aVar) {
            this.f48791a = aVar;
        }

        public final /* synthetic */ Object call() {
            return a.k(this.f48791a);
        }
    }

    static final class h<T> implements q<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48798a;

        h(a aVar) {
            this.f48798a = aVar;
        }

        public final /* synthetic */ boolean test(Object obj) {
            return !this.f48798a.w;
        }
    }

    public static final /* synthetic */ void a(a aVar, String str) {
        if (new l("[0-9]+$").containsMatchIn(str)) {
            aVar.b(true);
        } else {
            aVar.b(false);
        }
    }

    public static final /* synthetic */ void f(a aVar) {
        net.one97.paytm.moneytransfer.contacts.a.a aVar2;
        net.one97.paytm.moneytransfer.contacts.a.a aVar3 = aVar.f48783b;
        if (aVar3 != null) {
            k.c("", CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            aVar3.f53912e = "";
        }
        TextInputLayout textInputLayout = aVar.k;
        if (textInputLayout != null) {
            textInputLayout.setError("");
        }
        TextInputLayout textInputLayout2 = aVar.k;
        if (textInputLayout2 != null) {
            textInputLayout2.setErrorEnabled(false);
        }
        ImageView imageView = aVar.f48790i;
        if (imageView == null) {
            k.a("ivCross");
        }
        imageView.setVisibility(8);
        if (!aVar.w) {
            Collection collection = aVar.f48784c;
            if (!(collection == null || collection.isEmpty())) {
                ArrayList<ContactItemModel> arrayList = aVar.f48784c;
                if (!(arrayList == null || (aVar2 = aVar.f48783b) == null)) {
                    aVar2.a(arrayList);
                }
                FastScrollerLinearLayout fastScrollerLinearLayout = aVar.l;
                if (fastScrollerLinearLayout == null) {
                    k.a("fastScroller");
                }
                fastScrollerLinearLayout.setVisibility(0);
                FastScrollerLinearLayout fastScrollerLinearLayout2 = aVar.l;
                if (fastScrollerLinearLayout2 == null) {
                    k.a("fastScroller");
                }
                fastScrollerLinearLayout2.a(0);
                TextView textView = aVar.j;
                if (textView == null) {
                    k.a("tvProceedButton");
                }
                textView.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0026, code lost:
        r1 = r1.getContentResolver();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ net.one97.paytm.addmoney.togv.a k(net.one97.paytm.addmoney.togv.view.a r17) {
        /*
            net.one97.paytm.addmoney.togv.a r0 = new net.one97.paytm.addmoney.togv.a
            r0.<init>()
            android.net.Uri r2 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r10 = "photo_uri"
            java.lang.String r11 = "data1"
            java.lang.String r12 = "display_name"
            java.lang.String[] r3 = new java.lang.String[]{r12, r11, r10}
            android.content.Context r1 = r17.getContext()
            if (r1 == 0) goto L_0x0035
            android.content.ContentResolver r1 = r1.getContentResolver()
            if (r1 == 0) goto L_0x0035
            r4 = 0
            r5 = 0
            java.lang.String r6 = "display_name COLLATE NOCASE ASC"
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)
            goto L_0x0036
        L_0x0035:
            r1 = 0
        L_0x0036:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r1 != 0) goto L_0x0040
            kotlin.g.b.k.a()
        L_0x0040:
            r1.moveToFirst()
            java.lang.String r3 = ""
        L_0x0045:
            boolean r4 = r1.isAfterLast()
            r5 = 1
            if (r4 != 0) goto L_0x00cd
            int r4 = r1.getColumnIndex(r12)
            java.lang.String r4 = r1.getString(r4)
            int r6 = r1.getColumnIndex(r11)
            java.lang.String r6 = r1.getString(r6)
            int r14 = r1.getColumnIndex(r10)
            java.lang.String r14 = r1.getString(r14)
            android.content.Context r15 = r17.getContext()
            if (r15 == 0) goto L_0x00c8
            java.lang.String r6 = net.one97.paytm.wallet.utility.e.b(r6)
            int r15 = r6.length()
            r13 = 10
            if (r15 <= r13) goto L_0x007a
            java.lang.String r6 = net.one97.paytm.wallet.utility.e.c(r6)
        L_0x007a:
            boolean r13 = net.one97.paytm.wallet.utility.e.d(r6)
            if (r13 == 0) goto L_0x00c8
            boolean r13 = r2.contains(r6)
            if (r13 != 0) goto L_0x00c8
            r2.add(r6)
            boolean r13 = net.one97.paytm.wallet.utility.e.e(r4)
            if (r13 == 0) goto L_0x00bf
            java.lang.String r13 = net.one97.paytm.wallet.utility.e.a(r4)
            r16 = r3
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 != 0) goto L_0x00a3
            boolean r16 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r3, (boolean) r5)
            if (r16 != 0) goto L_0x00b5
        L_0x00a3:
            net.one97.paytm.upi.requestmoney.model.ContactItemModel r3 = new net.one97.paytm.upi.requestmoney.model.ContactItemModel
            r15 = 0
            r3.<init>(r13, r15, r15, r5)
            r7.add(r3)
            r9.add(r3)
            java.lang.String r3 = "newHeading"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r3 = r13
        L_0x00b5:
            net.one97.paytm.upi.requestmoney.model.ContactItemModel r5 = new net.one97.paytm.upi.requestmoney.model.ContactItemModel
            r13 = 0
            r5.<init>(r4, r6, r14, r13)
            r7.add(r5)
            goto L_0x00c8
        L_0x00bf:
            r13 = 0
            net.one97.paytm.upi.requestmoney.model.ContactItemModel r5 = new net.one97.paytm.upi.requestmoney.model.ContactItemModel
            r5.<init>(r4, r6, r14, r13)
            r8.add(r5)
        L_0x00c8:
            r1.moveToNext()
            goto L_0x0045
        L_0x00cd:
            r1.close()
            int r1 = r8.size()
            if (r1 <= 0) goto L_0x00e9
            net.one97.paytm.upi.requestmoney.model.ContactItemModel r1 = new net.one97.paytm.upi.requestmoney.model.ContactItemModel
            java.lang.String r2 = "#"
            r3 = 0
            r1.<init>(r2, r3, r3, r5)
            r7.add(r1)
            r9.add(r1)
            java.util.Collection r8 = (java.util.Collection) r8
            r7.addAll(r8)
        L_0x00e9:
            r0.a(r7)
            r0.b(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.togv.view.a.k(net.one97.paytm.addmoney.togv.view.a):net.one97.paytm.addmoney.togv.a");
    }
}
