package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.a.s;
import net.one97.paytm.recharge.common.e.y;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.model.ContactItemModel;

public final class t extends Fragment implements TextWatcher, View.OnClickListener, h.c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f61397b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f61398e;

    /* renamed from: a  reason: collision with root package name */
    public h.c f61399a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public s f61400c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f61401d;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f61402f;

    private View a(int i2) {
        if (this.f61402f == null) {
            this.f61402f = new HashMap();
        }
        View view = (View) this.f61402f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61402f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    static final class b extends l implements kotlin.g.a.b<List<? extends ContactItemModel>, x> {
        final /* synthetic */ t this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar) {
            super(1);
            this.this$0 = tVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends ContactItemModel>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<? extends ContactItemModel> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(com.paytm.utility.b.l(this.this$0.getContext()))) {
                    Context context = this.this$0.getContext();
                    if (context == null) {
                        k.a();
                    }
                    arrayList.add(new ContactItemModel(context.getString(R.string.my_number), com.paytm.utility.b.l(this.this$0.getContext()), com.paytm.utility.b.al(this.this$0.getContext()), false));
                }
                arrayList.addAll(list);
                s a2 = this.this$0.f61400c;
                if (a2 != null) {
                    CJRContactListV8.a aVar = new CJRContactListV8.a();
                    String string = this.this$0.getString(R.string.from_your_contacts);
                    k.a((Object) string, "getString(R.string.from_your_contacts)");
                    CJRContactListV8.a a3 = aVar.a(string).a((List<? extends ContactItemModel>) arrayList);
                    a3.f61862c = this.this$0;
                    a2.a(list, a3);
                }
            }
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
        String simpleName = t.class.getSimpleName();
        k.a((Object) simpleName, "FJRSearchPhoneContactFra…V8::class.java.simpleName");
        f61398e = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f61401d = arguments.getBoolean("is_recharge_tabs_flow", false);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_fragment_search_phone_contact, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007a, code lost:
        if (androidx.core.content.b.a((android.content.Context) r4, "android.permission.READ_CONTACTS") == 0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r5 = "view"
            kotlin.g.b.k.c(r4, r5)
            int r4 = net.one97.paytm.recharge.R.id.iv_search_back
            android.view.View r4 = r3.a((int) r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r0 = r3
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r4.setOnClickListener(r0)
            int r4 = net.one97.paytm.recharge.R.id.search_clear_tv
            android.view.View r4 = r3.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setOnClickListener(r0)
            int r4 = net.one97.paytm.recharge.R.id.searchEdt
            android.view.View r4 = r3.a((int) r4)
            android.widget.EditText r4 = (android.widget.EditText) r4
            r0 = r3
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r4.addTextChangedListener(r0)
            int r4 = net.one97.paytm.recharge.R.id.searchEdt
            android.view.View r4 = r3.a((int) r4)
            android.widget.EditText r4 = (android.widget.EditText) r4
            java.lang.String r0 = "searchEdt"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            android.view.View r4 = (android.view.View) r4
            kotlin.g.b.k.c(r4, r5)
            boolean r5 = r4.requestFocus()
            r0 = 1
            if (r5 == 0) goto L_0x0063
            android.content.Context r5 = r3.getContext()
            if (r5 == 0) goto L_0x0052
            java.lang.String r1 = "input_method"
            java.lang.Object r5 = r5.getSystemService(r1)
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            if (r5 == 0) goto L_0x005b
            android.view.inputmethod.InputMethodManager r5 = (android.view.inputmethod.InputMethodManager) r5
            r5.showSoftInput(r4, r0)
            goto L_0x0063
        L_0x005b:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            r4.<init>(r5)
            throw r4
        L_0x0063:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x007c
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 != 0) goto L_0x0072
            kotlin.g.b.k.a()
        L_0x0072:
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r5 = "android.permission.READ_CONTACTS"
            int r4 = androidx.core.content.b.a((android.content.Context) r4, (java.lang.String) r5)
            if (r4 != 0) goto L_0x0098
        L_0x007c:
            net.one97.paytm.recharge.common.utils.n r4 = net.one97.paytm.recharge.common.utils.n.f61679a
            r5 = r3
            androidx.lifecycle.q r5 = (androidx.lifecycle.q) r5
            androidx.loader.a.a r5 = androidx.loader.a.a.a(r5)
            java.lang.String r1 = "LoaderManager.getInstanc…chPhoneContactFragmentV8)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            androidx.lifecycle.LiveData r4 = r4.a((androidx.loader.a.a) r5)
            net.one97.paytm.recharge.common.fragment.t$b r5 = new net.one97.paytm.recharge.common.fragment.t$b
            r5.<init>(r3)
            kotlin.g.a.b r5 = (kotlin.g.a.b) r5
            net.one97.paytm.recharge.common.utils.g.a(r3, r4, r5)
        L_0x0098:
            int r4 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r4 = r3.a((int) r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r5 = "recycler_view"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r3.getContext()
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r4.setLayoutManager(r1)
            net.one97.paytm.recharge.common.a.s r4 = new net.one97.paytm.recharge.common.a.s
            r4.<init>()
            r3.f61400c = r4
            net.one97.paytm.recharge.common.a.s r4 = r3.f61400c
            if (r4 == 0) goto L_0x00c0
            r4.f60674e = r0
        L_0x00c0:
            net.one97.paytm.recharge.common.a.s r4 = r3.f61400c
            if (r4 == 0) goto L_0x00c8
            r4.f60674e = r0
            r4.f60675f = r0
        L_0x00c8:
            int r4 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r4 = r3.a((int) r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.recharge.common.a.s r5 = r3.f61400c
            androidx.recyclerview.widget.RecyclerView$a r5 = (androidx.recyclerview.widget.RecyclerView.a) r5
            r4.setAdapter(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.t.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onResume() {
        super.onResume();
        ((EditText) a(R.id.searchEdt)).requestFocus();
        if (this.f61401d && (getActivity() instanceof y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((y) activity).e();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((y) activity2).i();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public final void onDestroyView() {
        Context context = getContext();
        if (context != null) {
            ba.a(context, (View) (EditText) a(R.id.searchEdt));
        }
        if (this.f61401d && (getActivity() instanceof y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((y) activity).az_();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    y yVar = (y) activity2;
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        yVar.b(activity3.getResources().getString(R.string.recharge_tabs_toolbar_title));
                    } else {
                        throw new u("null cannot be cast to non-null type android.content.Context");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        }
        super.onDestroyView();
        HashMap hashMap = this.f61402f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void afterTextChanged(Editable editable) {
        Filter filter;
        s sVar = this.f61400c;
        if (sVar != null && (filter = sVar.getFilter()) != null) {
            filter.filter(editable);
        }
    }

    public final void a(ContactItemModel contactItemModel, int i2, boolean z) {
        k.c(contactItemModel, "contact");
        h.c cVar = this.f61399a;
        if (cVar != null) {
            cVar.a(contactItemModel, i2, true);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
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
        TextView textView = (TextView) a(R.id.search_clear_tv);
        k.a((Object) textView, "search_clear_tv");
        int id2 = textView.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            ((EditText) a(R.id.searchEdt)).setText("");
        }
    }

    public final void e() {
        h.c cVar = this.f61399a;
        if (cVar != null) {
            cVar.e();
        }
    }
}
