package net.one97.paytm.feed.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.ui.a.b;
import net.one97.paytm.feed.ui.feed.FeedFragment;
import net.one97.paytm.i.h;

public final class a extends h implements net.one97.paytm.feed.ui.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0565a f34810a = new C0565a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private b f34811b = new b();

    /* renamed from: c  reason: collision with root package name */
    private Context f34812c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f34813d;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.feed_fragment_manager, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        this.f34812c = context;
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a(getContext());
        com.google.android.play.core.splitcompat.a.b(getContext());
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        a2.b(R.id.feed_fragment_container, this.f34811b, "langauge");
        a2.c();
    }

    public final void a() {
        q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", true);
        int i2 = R.id.feed_fragment_container;
        Context context = this.f34812c;
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        net.one97.paytm.feed.repository.b.a(context);
        FeedFragment feedFragment = new FeedFragment();
        feedFragment.setArguments(bundle);
        feedFragment.setRetainInstance(true);
        a2.b(i2, feedFragment, "feed");
        a2.c();
    }

    /* renamed from: net.one97.paytm.feed.ui.a$a  reason: collision with other inner class name */
    public static final class C0565a {
        private C0565a() {
        }

        public /* synthetic */ C0565a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f34813d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
