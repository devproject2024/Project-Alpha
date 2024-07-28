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
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;

public final class h extends net.one97.paytm.i.h implements com.paytm.android.chat.e.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42087a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f42088b = f42088b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f42089c;

    public final View a(int i2) {
        if (this.f42089c == null) {
            this.f42089c = new HashMap();
        }
        View view = (View) this.f42089c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f42089c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class d extends l implements m<ResponseOfRegister, LoginInfo, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(2);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((ResponseOfRegister) obj, (LoginInfo) obj2);
            return x.f47997a;
        }

        public final void invoke(ResponseOfRegister responseOfRegister, LoginInfo loginInfo) {
            this.this$0.a();
            h.a(this.this$0);
        }
    }

    static final class e extends l implements m<Integer, String, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar) {
            super(2);
            this.this$0 = hVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (String) obj2);
            return x.f47997a;
        }

        public final void invoke(int i2, String str) {
            this.this$0.a();
            h.a(this.this$0);
        }
    }

    static final class f<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f42091a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f42092b;

        f(h hVar, boolean z) {
            this.f42091a = hVar;
            this.f42092b = z;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            boolean r = com.paytm.utility.b.r(this.f42091a.getContext());
            if (!com.paytm.utility.b.c(this.f42091a.getContext()) || !r || k.a(num.intValue(), 0) > 0) {
                this.f42091a.a();
            } else if (this.f42091a.getActivity() != null) {
                LinearLayout linearLayout = (LinearLayout) this.f42091a.a(R.id.chat_list_load_text);
                k.a((Object) linearLayout, "chat_list_load_text");
                com.paytm.android.chat.f.a((View) linearLayout, this.f42092b);
                View a2 = this.f42091a.a(R.id.layoutLoader);
                if (a2 != null) {
                    com.paytm.android.chat.f.a(a2, true);
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.chat_fragment_paytm_main, viewGroup, false);
        inflate.findViewById(R.id.btnBack).setOnClickListener(new b(this));
        if (getActivity() != null) {
            k.a((Object) ChatManager.b(), "ChatManager.getInstance()");
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            b2.a().getLocalChannelCount().b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new f(this, !ChatManager.h()), (io.reactivex.rxjava3.d.g<? super Throwable>) new g(this));
            com.paytm.a aVar = com.paytm.a.f40823c;
            com.paytm.a.a((Context) getActivity(), (kotlin.g.a.a<x>) new c(this), (m<? super ResponseOfRegister, ? super LoginInfo, x>) new d(this), (m<? super Integer, ? super String, x>) new e(this));
        }
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f42090a;

        b(h hVar) {
            this.f42090a = hVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f42090a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class c extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar) {
            super(0);
            this.this$0 = hVar;
        }

        public final void invoke() {
            this.this$0.a();
            h.a(this.this$0);
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

    static final class g<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f42093a;

        g(h hVar) {
            this.f42093a = hVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f42093a.a();
        }
    }

    public static final /* synthetic */ void a(h hVar) {
        if (hVar.getActivity() != null) {
            j childFragmentManager = hVar.getChildFragmentManager();
            q qVar = null;
            if ((childFragmentManager != null ? childFragmentManager.c(R.id.fl_container) : null) == null) {
                j childFragmentManager2 = hVar.getChildFragmentManager();
                if (childFragmentManager2 != null) {
                    qVar = childFragmentManager2.a();
                }
                k.a((Object) qVar, "childFragmentManager?.beginTransaction()");
                Fragment a2 = c.a(true);
                if (qVar != null) {
                    qVar.a(R.id.fl_container, a2);
                }
                if (qVar != null) {
                    qVar.c();
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f42089c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
