package com.paytm.paymentsettings.merchantSubscriptions.view;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;

public final class e extends h implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f43506c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    b f43507a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public List<ActiveSubscriptionDetailsItem> f43508b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f43509d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f43510e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f43511f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f43512g;

    public interface b {
        void a(View view, int i2);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_active_subscription, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        View view = null;
        View findViewById = activity != null ? activity.findViewById(R.id.no_subscription_rl) : null;
        if (findViewById != null) {
            this.f43509d = (RelativeLayout) findViewById;
            FragmentActivity activity2 = getActivity();
            View findViewById2 = activity2 != null ? activity2.findViewById(R.id.subscription_rv) : null;
            if (findViewById2 != null) {
                this.f43510e = (RecyclerView) findViewById2;
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    view = activity3.findViewById(R.id.iv_back_arrow_as);
                }
                if (view != null) {
                    this.f43511f = (ImageView) view;
                    ImageView imageView = this.f43511f;
                    if (imageView != null) {
                        imageView.setOnClickListener(this);
                    }
                    this.f43507a = new b(this.f43508b, getContext());
                    RecyclerView recyclerView = this.f43510e;
                    if (recyclerView != null) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }
                    RecyclerView recyclerView2 = this.f43510e;
                    if (recyclerView2 != null) {
                        recyclerView2.setHasFixedSize(true);
                    }
                    RecyclerView recyclerView3 = this.f43510e;
                    if (recyclerView3 != null) {
                        recyclerView3.setAdapter(this.f43507a);
                    }
                    RecyclerView recyclerView4 = this.f43510e;
                    if (recyclerView4 != null) {
                        recyclerView4.addOnItemTouchListener(new c(getContext(), new d(this)));
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public static final class d implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f43516a;

        d(e eVar) {
            this.f43516a = eVar;
        }

        public final void a(View view, int i2) {
            k.c(view, "view");
            FragmentActivity activity = this.f43516a.getActivity();
            if (activity != null) {
                ((ActiveSubscriptionActivity) activity).startActiveSubscriptionDetailFragment((ActiveSubscriptionDetailsItem) this.f43516a.f43508b.get(i2));
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity");
        }
    }

    public final void a(boolean z) {
        if (z) {
            RecyclerView recyclerView = this.f43510e;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            RelativeLayout relativeLayout = this.f43509d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        RecyclerView recyclerView2 = this.f43510e;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.f43509d;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r2 = r2.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r2) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r2, r0)
            int r2 = r2.getId()
            int r0 = com.paytm.paymentsettings.R.id.iv_back_arrow_as
            if (r2 != r0) goto L_0x0058
            androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
            if (r2 == 0) goto L_0x001d
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()
            if (r2 == 0) goto L_0x001d
            r2.b()
        L_0x001d:
            androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
            if (r2 == 0) goto L_0x0032
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()
            if (r2 == 0) goto L_0x0032
            int r2 = r2.f()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0033
        L_0x0032:
            r2 = 0
        L_0x0033:
            if (r2 != 0) goto L_0x0038
            kotlin.g.b.k.a()
        L_0x0038:
            int r2 = r2.intValue()
            r0 = 1
            if (r2 <= r0) goto L_0x004f
            androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
            if (r2 == 0) goto L_0x004e
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()
            if (r2 == 0) goto L_0x004e
            r2.d()
        L_0x004e:
            return
        L_0x004f:
            androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
            if (r2 == 0) goto L_0x0058
            r2.finish()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.view.e.onClick(android.view.View):void");
    }

    public final class c implements RecyclerView.k {

        /* renamed from: b  reason: collision with root package name */
        private final GestureDetector f43514b;

        /* renamed from: c  reason: collision with root package name */
        private final b f43515c;

        public final void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            k.c(recyclerView, "rv");
            k.c(motionEvent, "e");
        }

        public static final class a extends GestureDetector.SimpleOnGestureListener {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            a() {
            }
        }

        public c(Context context, b bVar) {
            this.f43515c = bVar;
            this.f43514b = new GestureDetector(context, new a());
        }

        public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            k.c(recyclerView, "rv");
            k.c(motionEvent, "e");
            View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder == null || this.f43515c == null || !this.f43514b.onTouchEvent(motionEvent)) {
                return false;
            }
            this.f43515c.a(findChildViewUnder, recyclerView.getChildAdapterPosition(findChildViewUnder));
            return false;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: com.paytm.paymentsettings.merchantSubscriptions.view.e$e  reason: collision with other inner class name */
    public static final class C0741e<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(((ActiveSubscriptionDetailsItem) t).getNextRenewalDate(), ((ActiveSubscriptionDetailsItem) t2).getNextRenewalDate());
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f43512g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
