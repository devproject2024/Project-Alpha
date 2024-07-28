package com.paytm.android.chat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.imsdk.LoginInfo;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.network.response.ResponseOfRegister;
import com.paytm.android.chat.utils.AppUtilKt;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.i.h;

public final class i extends h implements com.paytm.android.chat.e.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42094a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static final String f42095b = f42095b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f42096c;

    public final View a(int i2) {
        if (this.f42096c == null) {
            this.f42096c = new HashMap();
        }
        View view = (View) this.f42096c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f42096c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class d extends l implements m<ResponseOfRegister, LoginInfo, x> {
        final /* synthetic */ i this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(i iVar) {
            super(2);
            this.this$0 = iVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((ResponseOfRegister) obj, (LoginInfo) obj2);
            return x.f47997a;
        }

        public final void invoke(ResponseOfRegister responseOfRegister, LoginInfo loginInfo) {
            this.this$0.a();
            i.a(this.this$0);
        }
    }

    static final class e extends l implements m<Integer, String, x> {
        final /* synthetic */ i this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(i iVar) {
            super(2);
            this.this$0 = iVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (String) obj2);
            return x.f47997a;
        }

        public final void invoke(int i2, String str) {
            this.this$0.a();
            i.a(this.this$0);
        }
    }

    static final class f<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f42098a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f42099b;

        f(i iVar, boolean z) {
            this.f42098a = iVar;
            this.f42099b = z;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            Context context = this.f42098a.getContext();
            if (context != null) {
                k.a((Object) context, "context ?: return@subscribe");
                boolean r = com.paytm.utility.b.r(context);
                if (!com.paytm.utility.b.c(context) || !r || k.a(num.intValue(), 0) > 0) {
                    this.f42098a.a();
                    return;
                }
                FragmentActivity activity = this.f42098a.getActivity();
                if (activity != null) {
                    k.a((Object) activity, "activity");
                    if (!activity.isDestroyed()) {
                        LinearLayout linearLayout = (LinearLayout) this.f42098a.a(R.id.chat_list_load_text);
                        k.a((Object) linearLayout, "chat_list_load_text");
                        com.paytm.android.chat.f.a((View) linearLayout, this.f42099b);
                        View a2 = this.f42098a.a(R.id.layoutLoader);
                        if (a2 != null) {
                            com.paytm.android.chat.f.a(a2, true);
                        }
                    }
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

    public final void onResume() {
        super.onResume();
        if (getActivity() != null) {
            com.paytm.android.chat.c.a(getActivity());
            if (isVisible() && getChildFragmentManager().c(R.id.fl_container) == null && getActivity() != null) {
                k.a((Object) ChatManager.b(), "ChatManager.getInstance()");
                ChatManager b2 = ChatManager.b();
                k.a((Object) b2, "ChatManager.getInstance()");
                b2.a().getLocalChannelCount().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new f(this, !ChatManager.h()), (io.reactivex.rxjava3.d.g<? super Throwable>) new g(this));
                com.paytm.a aVar = com.paytm.a.f40823c;
                com.paytm.a.a((Context) getActivity(), (kotlin.g.a.a<x>) new c(this), (m<? super ResponseOfRegister, ? super LoginInfo, x>) new d(this), (m<? super Integer, ? super String, x>) new e(this));
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.chat_fragment_paytm_main, viewGroup, false);
        inflate.findViewById(R.id.btnBack).setOnClickListener(new b(this));
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f42097a;

        b(i iVar) {
            this.f42097a = iVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f42097a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class c extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ i this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(i iVar) {
            super(0);
            this.this$0 = iVar;
        }

        public final void invoke() {
            this.this$0.a();
            i.a(this.this$0);
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        try {
            AppUtilKt.reInitializeChatManager(context);
        } catch (Exception unused) {
        }
    }

    public final void onDetach() {
        super.onDetach();
        a();
    }

    public final void a() {
        try {
            View a2 = a(R.id.layoutLoader);
            if (a2 != null) {
                com.paytm.android.chat.f.a(a2, false);
            }
        } catch (Exception unused) {
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            com.paytm.android.chat.c.a(getActivity());
        }
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    static final class g<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f42100a;

        g(i iVar) {
            this.f42100a = iVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42100a.a();
        }
    }

    public static final /* synthetic */ void a(i iVar) {
        if (iVar.getActivity() != null) {
            j childFragmentManager = iVar.getChildFragmentManager();
            q qVar = null;
            if ((childFragmentManager != null ? childFragmentManager.c(R.id.fl_container) : null) == null) {
                j childFragmentManager2 = iVar.getChildFragmentManager();
                if (childFragmentManager2 != null) {
                    qVar = childFragmentManager2.a();
                }
                k.a((Object) qVar, "childFragmentManager?.beginTransaction()");
                Fragment a2 = c.a(true);
                k.a((Object) a2, "fragment");
                c cVar = (c) a2;
                Bundle arguments = cVar.getArguments();
                if (arguments == null) {
                    arguments = new Bundle();
                }
                k.a((Object) arguments, "fragment.arguments ?: Bundle()");
                arguments.putBoolean("is_fragment_flow", true);
                cVar.setArguments(arguments);
                if (qVar != null) {
                    qVar.a(R.id.fl_container, a2, "hometab");
                }
                if (qVar != null) {
                    qVar.c();
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f42096c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
