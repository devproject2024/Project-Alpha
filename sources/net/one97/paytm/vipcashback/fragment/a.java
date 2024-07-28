package net.one97.paytm.vipcashback.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.vipcashback.f.d;

public abstract class a extends h {
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public static boolean f20912f;

    /* renamed from: g  reason: collision with root package name */
    public static final C0402a f20913g = new C0402a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final String f20914a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    Context f20915b;

    /* renamed from: c  reason: collision with root package name */
    boolean f20916c;

    /* renamed from: d  reason: collision with root package name */
    AppCompatActivity f20917d;

    /* renamed from: e  reason: collision with root package name */
    String f20918e;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f20919h;

    public View a(int i2) {
        if (this.f20919h == null) {
            this.f20919h = new HashMap();
        }
        View view = (View) this.f20919h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f20919h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public abstract void b();

    public void d() {
        HashMap hashMap = this.f20919h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    /* renamed from: net.one97.paytm.vipcashback.fragment.a$a  reason: collision with other inner class name */
    public static final class C0402a {
        private C0402a() {
        }

        public /* synthetic */ C0402a(byte b2) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f20915b = getActivity();
        a();
    }

    public final void a(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "error");
        if (isAdded()) {
            d.a aVar = d.f20859a;
            d.a.a(networkCustomError, (FragmentActivity) this.f20917d, (Boolean) null, 12);
        }
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
        if (context instanceof AppCompatActivity) {
            this.f20917d = (AppCompatActivity) context;
        }
    }

    public final void a(com.paytm.network.a aVar) {
        k.c(aVar, "networkCall");
        d.a aVar2 = d.f20859a;
        Context context = this.f20915b;
        if (context == null) {
            k.a();
        }
        d.a.a(context, aVar, false);
    }
}
