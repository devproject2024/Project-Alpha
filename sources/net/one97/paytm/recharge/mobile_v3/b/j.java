package net.one97.paytm.recharge.mobile_v3.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.b;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.a.r;
import net.one97.paytm.recharge.common.e.ae;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.mobile_v3.b.c;
import net.one97.paytm.recharge.model.ContactItemModel;

public final class j extends Fragment implements TextWatcher, View.OnClickListener, b.C1169b, h.c, ae {

    /* renamed from: a  reason: collision with root package name */
    public static final a f63869a = new a((byte) 0);
    private static final String k;

    /* renamed from: b  reason: collision with root package name */
    private boolean f63870b;

    /* renamed from: c  reason: collision with root package name */
    private h.c f63871c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public r f63872d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f63873e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.recharge.common.a.b f63874f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f63875g;

    /* renamed from: h  reason: collision with root package name */
    private final io.reactivex.rxjava3.j.b<String> f63876h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> f63877i;
    /* access modifiers changed from: private */
    public final Handler j = new Handler();
    private HashMap l;

    static final class c<T> implements q<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f63878a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ boolean test(Object obj) {
            return true;
        }
    }

    private View a(int i2) {
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

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
    }

    public final void a(String str, io.reactivex.rxjava3.b.c cVar) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    static final class b extends l implements kotlin.g.a.b<List<? extends ContactItemModel>, x> {
        final /* synthetic */ j this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar) {
            super(1);
            this.this$0 = jVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends ContactItemModel>) (List) obj);
            return x.f47997a;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0002: MOVE  (r5v1 java.util.Collection) = 
              (r5v0 java.util.List<? extends net.one97.paytm.recharge.model.ContactItemModel>)
            
            	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
            */
        public final void invoke(java.util.List<? extends net.one97.paytm.recharge.model.ContactItemModel> r5) {
            /*
                r4 = this;
                if (r5 == 0) goto L_0x004a
                java.util.Collection r5 = (java.util.Collection) r5
                if (r5 == 0) goto L_0x004a
                boolean r0 = r5.isEmpty()
                r0 = r0 ^ 1
                if (r0 == 0) goto L_0x004a
                java.util.List r5 = (java.util.List) r5
                net.one97.paytm.recharge.mobile_v3.b.j r0 = r4.this$0
                net.one97.paytm.recharge.mobile_v3.b.j.a((net.one97.paytm.recharge.mobile_v3.b.j) r0)
                net.one97.paytm.recharge.mobile_v3.b.j r0 = r4.this$0
                net.one97.paytm.recharge.mobile_v3.b.j.b(r0)
                net.one97.paytm.recharge.mobile_v3.b.j r0 = r4.this$0
                r0.f63875g = true
                net.one97.paytm.recharge.mobile_v3.b.j r0 = r4.this$0
                net.one97.paytm.recharge.common.a.r r0 = r0.f63872d
                if (r0 == 0) goto L_0x004a
                net.one97.paytm.recharge.common.widget.CJRContactListV8$a r1 = new net.one97.paytm.recharge.common.widget.CJRContactListV8$a
                r1.<init>()
                net.one97.paytm.recharge.mobile_v3.b.j r2 = r4.this$0
                int r3 = net.one97.paytm.recharge.R.string.from_your_contacts
                java.lang.String r2 = r2.getString(r3)
                java.lang.String r3 = "getString(R.string.from_your_contacts)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                net.one97.paytm.recharge.common.widget.CJRContactListV8$a r1 = r1.a((java.lang.String) r2)
                net.one97.paytm.recharge.common.widget.CJRContactListV8$a r1 = r1.a((java.util.List<? extends net.one97.paytm.recharge.model.ContactItemModel>) r5)
                net.one97.paytm.recharge.mobile_v3.b.j r2 = r4.this$0
                net.one97.paytm.recharge.common.a.h$c r2 = (net.one97.paytm.recharge.common.a.h.c) r2
                r1.f61862c = r2
                r0.a((java.util.List<? extends net.one97.paytm.recharge.model.ContactItemModel>) r5, (net.one97.paytm.recharge.common.widget.CJRContactListV8.a) r1)
            L_0x004a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.j.b.invoke(java.util.List):void");
        }
    }

    static final class d<T, R> implements io.reactivex.rxjava3.d.h<T, u<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63879a;

        d(j jVar) {
            this.f63879a = jVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            final String str = (String) obj;
            return y.a(new ab<IJRPaytmDataModel>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f63880a;

                {
                    this.f63880a = r1;
                }

                public final void subscribe(z<IJRPaytmDataModel> zVar) {
                    net.one97.paytm.recharge.common.e.a e2 = this.f63880a.f63879a.f63877i;
                    if (e2 == null) {
                        k.a();
                    }
                    e2.a(zVar);
                    this.f63880a.f63879a.j.post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f63882a;

                        {
                            this.f63882a = r1;
                        }

                        public final void run() {
                            r d2 = this.f63882a.f63880a.f63879a.f63872d;
                            if (d2 != null) {
                                String str = str;
                                c.a aVar = c.z;
                                d2.a(str, c.M);
                            }
                        }
                    });
                }
            }).e().subscribeOn(io.reactivex.rxjava3.i.a.b());
        }
    }

    public j() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.f63876h = a2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = j.class.getSimpleName();
        k.a((Object) simpleName, "FJRSearchPhoneContactFra…V3::class.java.simpleName");
        k = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f63873e = arguments.getBoolean("is_recharge_tabs_flow", false);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_fragment_search_phone_contact, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00cb, code lost:
        if (androidx.core.content.b.a((android.content.Context) r5, "android.permission.READ_CONTACTS") == 0) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r6 = "view"
            kotlin.g.b.k.c(r5, r6)
            int r5 = net.one97.paytm.recharge.R.id.iv_search_back
            android.view.View r5 = r4.a((int) r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0 = r4
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r5.setOnClickListener(r0)
            int r5 = net.one97.paytm.recharge.R.id.clearIv
            android.view.View r5 = r4.a((int) r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setOnClickListener(r0)
            int r5 = net.one97.paytm.recharge.R.id.searchEdt
            android.view.View r5 = r4.a((int) r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            r0 = r4
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r5.addTextChangedListener(r0)
            int r5 = net.one97.paytm.recharge.R.id.searchEdt
            android.view.View r5 = r4.a((int) r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            java.lang.String r0 = "searchEdt"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            android.view.View r5 = (android.view.View) r5
            kotlin.g.b.k.c(r5, r6)
            boolean r6 = r5.requestFocus()
            r0 = 1
            if (r6 == 0) goto L_0x0065
            android.content.Context r6 = r4.getContext()
            if (r6 == 0) goto L_0x0054
            java.lang.String r1 = "input_method"
            java.lang.Object r6 = r6.getSystemService(r1)
            goto L_0x0055
        L_0x0054:
            r6 = 0
        L_0x0055:
            if (r6 == 0) goto L_0x005d
            android.view.inputmethod.InputMethodManager r6 = (android.view.inputmethod.InputMethodManager) r6
            r6.showSoftInput(r5, r0)
            goto L_0x0065
        L_0x005d:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            r5.<init>(r6)
            throw r5
        L_0x0065:
            int r5 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r5 = r4.a((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            java.lang.String r6 = "recycler_view"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r4.getContext()
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r5.setLayoutManager(r1)
            net.one97.paytm.recharge.common.a.r r5 = new net.one97.paytm.recharge.common.a.r
            android.content.Context r1 = r4.getContext()
            if (r1 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            java.lang.String r2 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r5.<init>(r1)
            r4.f63872d = r5
            net.one97.paytm.recharge.common.a.r r5 = r4.f63872d
            if (r5 == 0) goto L_0x009b
            r5.f60663g = r0
        L_0x009b:
            net.one97.paytm.recharge.common.a.r r5 = r4.f63872d
            if (r5 == 0) goto L_0x00a2
            r5.a()
        L_0x00a2:
            int r5 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r5 = r4.a((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.recharge.common.a.r r1 = r4.f63872d
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r5.setAdapter(r1)
            int r5 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r5 < r1) goto L_0x00cd
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 != 0) goto L_0x00c3
            kotlin.g.b.k.a()
        L_0x00c3:
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r1 = "android.permission.READ_CONTACTS"
            int r5 = androidx.core.content.b.a((android.content.Context) r5, (java.lang.String) r1)
            if (r5 != 0) goto L_0x00e9
        L_0x00cd:
            net.one97.paytm.recharge.common.utils.n r5 = net.one97.paytm.recharge.common.utils.n.f61679a
            r1 = r4
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            androidx.loader.a.a r1 = androidx.loader.a.a.a(r1)
            java.lang.String r3 = "LoaderManager.getInstanc…chPhoneContactFragmentV3)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            androidx.lifecycle.LiveData r5 = r5.a((androidx.loader.a.a) r1)
            net.one97.paytm.recharge.mobile_v3.b.j$b r1 = new net.one97.paytm.recharge.mobile_v3.b.j$b
            r1.<init>(r4)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            net.one97.paytm.recharge.common.utils.g.a(r4, r5, r1)
        L_0x00e9:
            int r5 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r5 = r4.a((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r4.getContext()
            r1.<init>(r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r5.setLayoutManager(r1)
            net.one97.paytm.recharge.common.a.r r5 = new net.one97.paytm.recharge.common.a.r
            android.content.Context r1 = r4.getContext()
            if (r1 != 0) goto L_0x010d
            kotlin.g.b.k.a()
        L_0x010d:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r5.<init>(r1)
            r4.f63872d = r5
            net.one97.paytm.recharge.common.a.r r5 = r4.f63872d
            if (r5 == 0) goto L_0x011b
            r5.f60663g = r0
        L_0x011b:
            net.one97.paytm.recharge.common.a.r r5 = r4.f63872d
            if (r5 == 0) goto L_0x0122
            r5.a()
        L_0x0122:
            int r5 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r5 = r4.a((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.recharge.common.a.r r6 = r4.f63872d
            androidx.recyclerview.widget.RecyclerView$a r6 = (androidx.recyclerview.widget.RecyclerView.a) r6
            r5.setAdapter(r6)
            net.one97.paytm.recharge.common.e.a<com.paytm.network.model.IJRPaytmDataModel> r5 = r4.f63877i
            if (r5 != 0) goto L_0x0154
            if (r5 == 0) goto L_0x013d
            r5.a()
        L_0x013d:
            net.one97.paytm.recharge.common.e.a r5 = new net.one97.paytm.recharge.common.e.a
            net.one97.paytm.recharge.mobile_v3.b.c$a r6 = net.one97.paytm.recharge.mobile_v3.b.c.z
            java.lang.String r6 = net.one97.paytm.recharge.mobile_v3.b.c.M
            r0 = r4
            net.one97.paytm.recharge.common.e.ae r0 = (net.one97.paytm.recharge.common.e.ae) r0
            r5.<init>(r6, r0)
            r4.f63877i = r5
            net.one97.paytm.recharge.common.a.r r5 = r4.f63872d
            if (r5 == 0) goto L_0x0154
            r5.a((net.one97.paytm.recharge.common.e.ae) r0)
        L_0x0154:
            io.reactivex.rxjava3.j.b<java.lang.String> r5 = r4.f63876h
            net.one97.paytm.recharge.mobile_v3.b.j$c r6 = net.one97.paytm.recharge.mobile_v3.b.j.c.f63878a
            io.reactivex.rxjava3.d.q r6 = (io.reactivex.rxjava3.d.q) r6
            io.reactivex.rxjava3.a.p r5 = r5.filter(r6)
            net.one97.paytm.recharge.mobile_v3.b.j$d r6 = new net.one97.paytm.recharge.mobile_v3.b.j$d
            r6.<init>(r4)
            io.reactivex.rxjava3.d.h r6 = (io.reactivex.rxjava3.d.h) r6
            io.reactivex.rxjava3.a.p r5 = r5.switchMap(r6)
            io.reactivex.rxjava3.a.x r6 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.p r5 = r5.subscribeOn(r6)
            io.reactivex.rxjava3.a.x r6 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.p r5 = r5.observeOn(r6)
            net.one97.paytm.recharge.common.e.a<com.paytm.network.model.IJRPaytmDataModel> r6 = r4.f63877i
            if (r6 != 0) goto L_0x0180
            kotlin.g.b.k.a()
        L_0x0180:
            io.reactivex.rxjava3.a.w r6 = (io.reactivex.rxjava3.a.w) r6
            r5.subscribe(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.j.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onResume() {
        super.onResume();
        ((EditText) a(R.id.searchEdt)).requestFocus();
        if (this.f63873e && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
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

    public final void onDestroyView() {
        Context context = getContext();
        if (context != null) {
            ba.a(context, (View) (EditText) a(R.id.searchEdt));
        }
        if (this.f63873e && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
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
        }
        super.onDestroyView();
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        View a2;
        if (g.c(String.valueOf(charSequence))) {
            ImageView imageView = (ImageView) a(R.id.clearIv);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            RecyclerView recyclerView = (RecyclerView) a(R.id.alphabetRV);
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            View a3 = a(R.id.dummySpaceView);
            if (a3 != null) {
                a3.setVisibility(8);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.l(getContext())) && (a2 = a(R.id.dummySpaceView)) != null) {
            a2.setVisibility(0);
        }
        if (this.f63875g) {
            RecyclerView recyclerView2 = (RecyclerView) a(R.id.alphabetRV);
            k.a((Object) recyclerView2, "alphabetRV");
            recyclerView2.setVisibility(0);
        }
        ImageView imageView2 = (ImageView) a(R.id.clearIv);
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    public final void afterTextChanged(Editable editable) {
        this.f63876h.onNext(String.valueOf(editable));
    }

    public final void a(ContactItemModel contactItemModel, int i2, boolean z) {
        k.c(contactItemModel, "contact");
        h.c cVar = this.f63871c;
        if (cVar != null) {
            cVar.a(contactItemModel, i2, false);
        }
        Intent intent = new Intent();
        intent.putExtra(e.aG, contactItemModel);
        intent.putExtra("contactPos", i2);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(212, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        ImageView imageView = (ImageView) a(R.id.iv_search_back);
        k.a((Object) imageView, "iv_search_back");
        int id = imageView.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            e();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) a(R.id.clearIv);
        k.a((Object) imageView2, "clearIv");
        int id2 = imageView2.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            ((EditText) a(R.id.searchEdt)).setText("");
        }
    }

    public final void e() {
        h.c cVar = this.f63871c;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final void a(char c2) {
        com.paytm.utility.b.c((Activity) getActivity());
        r rVar = this.f63872d;
        Integer a2 = rVar != null ? rVar.a(c2) : null;
        if (a2 != null && a2.intValue() >= 0) {
            RecyclerView recyclerView = (RecyclerView) a(R.id.recycler_view);
            RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(a2.intValue(), 0);
            }
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        r rVar;
        c.a aVar = c.z;
        if (k.a((Object) str, (Object) c.M) && (rVar = this.f63872d) != null) {
            rVar.notifyDataSetChanged();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> aVar = this.f63877i;
        if (aVar != null) {
            aVar.a();
        }
        this.f63877i = null;
    }

    public static final /* synthetic */ void a(j jVar) {
        if (!TextUtils.isEmpty(com.paytm.utility.b.l(jVar.getContext()))) {
            View a2 = jVar.a(R.id.dummySpaceView);
            if (a2 != null) {
                a2.setVisibility(0);
            }
            jVar.f63870b = true;
            r rVar = jVar.f63872d;
            if (rVar != null) {
                ContactItemModel contactItemModel = new ContactItemModel(com.paytm.utility.b.aa(jVar.getContext()), com.paytm.utility.b.l(jVar.getContext()), com.paytm.utility.b.al(jVar.getContext()), true);
                CJRContactListV8.a aVar = new CJRContactListV8.a();
                aVar.f61862c = jVar;
                rVar.a(contactItemModel, aVar);
            }
        }
    }

    public static final /* synthetic */ void b(j jVar) {
        if (jVar.f63874f == null) {
            ArrayList arrayList = new ArrayList();
            for (char c2 = 'A'; c2 <= 'Z'; c2 = (char) (c2 + 1)) {
                arrayList.add(Character.valueOf(c2));
            }
            RecyclerView recyclerView = (RecyclerView) jVar.a(R.id.alphabetRV);
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            RecyclerView recyclerView2 = (RecyclerView) jVar.a(R.id.alphabetRV);
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(jVar.getContext()));
            }
            jVar.f63874f = new net.one97.paytm.recharge.common.a.b(arrayList, jVar);
            RecyclerView recyclerView3 = (RecyclerView) jVar.a(R.id.alphabetRV);
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(jVar.f63874f);
            }
        }
    }
}
