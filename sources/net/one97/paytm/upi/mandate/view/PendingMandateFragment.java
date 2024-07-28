package net.one97.paytm.upi.mandate.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.data.a;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.util.CirclePageIndicator;

public final class PendingMandateFragment extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67465a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f67466b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f67467c;

    /* renamed from: d  reason: collision with root package name */
    private CirclePageIndicator f67468d;

    /* renamed from: e  reason: collision with root package name */
    private i f67469e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.upi.mandate.f.b f67470f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f67471g;

    /* renamed from: h  reason: collision with root package name */
    private RefreshListReceiver f67472h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f67473i;

    static final class c<T> implements z<net.one97.paytm.upi.mandate.data.a<List<? extends MandateItem>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PendingMandateFragment f67476a;

        c(PendingMandateFragment pendingMandateFragment) {
            this.f67476a = pendingMandateFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.mandate.data.a aVar = (net.one97.paytm.upi.mandate.data.a) obj;
            if (aVar != null) {
                int i2 = h.f67533a[aVar.f67117a.ordinal()];
                if (i2 != 1 && i2 == 2) {
                    List list = (List) aVar.f67118b;
                    this.f67476a.f67471g = (list != null ? list.size() : 0) < 20;
                    if (list != null) {
                        Collection collection = list;
                        if (true ^ collection.isEmpty()) {
                            View view = this.f67476a.getView();
                            if (view != null) {
                                f.b(view);
                            }
                            PendingMandateFragment.d(this.f67476a).setVisibility(0);
                            if (aVar.f67120d) {
                                i a2 = PendingMandateFragment.a(this.f67476a);
                                k.c(list, "list");
                                a2.f67534a.addAll(collection);
                                a2.notifyDataSetChanged();
                            } else {
                                i a3 = PendingMandateFragment.a(this.f67476a);
                                k.c(list, "list");
                                a3.f67534a.clear();
                                a3.f67534a.addAll(collection);
                                a3.notifyDataSetChanged();
                            }
                            if (PendingMandateFragment.a(this.f67476a).getCount() <= 0) {
                                PendingMandateFragment.e(this.f67476a).setVisibility(8);
                                return;
                            } else {
                                PendingMandateFragment.e(this.f67476a).setVisibility(0);
                                return;
                            }
                        }
                    }
                    if (!aVar.f67120d) {
                        View view2 = this.f67476a.getView();
                        if (view2 != null) {
                            f.a(view2);
                        }
                        PendingMandateFragment.d(this.f67476a).setVisibility(8);
                        PendingMandateFragment.e(this.f67476a).setVisibility(8);
                    }
                }
            }
        }
    }

    public static final /* synthetic */ i a(PendingMandateFragment pendingMandateFragment) {
        i iVar = pendingMandateFragment.f67469e;
        if (iVar == null) {
            k.a("pendingMandatePagerAdapter");
        }
        return iVar;
    }

    public static final /* synthetic */ net.one97.paytm.upi.mandate.f.b c(PendingMandateFragment pendingMandateFragment) {
        net.one97.paytm.upi.mandate.f.b bVar = pendingMandateFragment.f67470f;
        if (bVar == null) {
            k.a("pendingMandateViewModel");
        }
        return bVar;
    }

    public static final /* synthetic */ ViewPager d(PendingMandateFragment pendingMandateFragment) {
        ViewPager viewPager = pendingMandateFragment.f67467c;
        if (viewPager == null) {
            k.a("vpPendingMandates");
        }
        return viewPager;
    }

    public static final /* synthetic */ CirclePageIndicator e(PendingMandateFragment pendingMandateFragment) {
        CirclePageIndicator circlePageIndicator = pendingMandateFragment.f67468d;
        if (circlePageIndicator == null) {
            k.a("cpi_pager");
        }
        return circlePageIndicator;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_pending_mandate, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.wallet_loader);
        k.a((Object) findViewById, "view.findViewById<Lottie…View>(R.id.wallet_loader)");
        this.f67466b = (LottieAnimationView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.vpPendingMandates);
        k.a((Object) findViewById2, "view.findViewById(R.id.vpPendingMandates)");
        this.f67467c = (ViewPager) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.cpi_pager);
        k.a((Object) findViewById3, "view.findViewById(R.id.cpi_pager)");
        this.f67468d = (CirclePageIndicator) findViewById3;
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        this.f67469e = new i(childFragmentManager);
        ViewPager viewPager = this.f67467c;
        if (viewPager == null) {
            k.a("vpPendingMandates");
        }
        i iVar = this.f67469e;
        if (iVar == null) {
            k.a("pendingMandatePagerAdapter");
        }
        viewPager.setAdapter(iVar);
        CirclePageIndicator circlePageIndicator = this.f67468d;
        if (circlePageIndicator == null) {
            k.a("cpi_pager");
        }
        ViewPager viewPager2 = this.f67467c;
        if (viewPager2 == null) {
            k.a("vpPendingMandates");
        }
        circlePageIndicator.setViewPager(viewPager2);
        ViewPager viewPager3 = this.f67467c;
        if (viewPager3 == null) {
            k.a("vpPendingMandates");
        }
        viewPager3.addOnPageChangeListener(new b());
        this.f67472h = new RefreshListReceiver();
        IntentFilter intentFilter = new IntentFilter("action_refresh_pending_mandates");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
        RefreshListReceiver refreshListReceiver = this.f67472h;
        if (refreshListReceiver == null) {
            k.a();
        }
        a2.a(refreshListReceiver, intentFilter);
        k.a((Object) inflate, "view");
        f.a(inflate);
        return inflate;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.upi.mandate.f.b.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ateViewModel::class.java)");
        this.f67470f = (net.one97.paytm.upi.mandate.f.b) a2;
        net.one97.paytm.upi.mandate.f.b bVar = this.f67470f;
        if (bVar == null) {
            k.a("pendingMandateViewModel");
        }
        bVar.f67215b.observe(this, new c(this));
        net.one97.paytm.upi.mandate.f.b bVar2 = this.f67470f;
        if (bVar2 == null) {
            k.a("pendingMandateViewModel");
        }
        bVar2.a();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (getActivity() != null) {
            if (this.f67472h != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
                RefreshListReceiver refreshListReceiver = this.f67472h;
                if (refreshListReceiver == null) {
                    k.a();
                }
                a2.a((BroadcastReceiver) refreshListReceiver);
            }
            this.f67472h = null;
        }
        HashMap hashMap = this.f67473i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final class b implements ViewPager.e {
        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageSelected(int i2) {
        }

        public b() {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
            a.b bVar;
            if (i2 + 3 > PendingMandateFragment.a(PendingMandateFragment.this).getCount() && !PendingMandateFragment.this.f67471g) {
                net.one97.paytm.upi.mandate.f.b c2 = PendingMandateFragment.c(PendingMandateFragment.this);
                net.one97.paytm.upi.mandate.data.a value = c2.f67215b.getValue();
                if (value != null) {
                    bVar = value.f67117a;
                } else {
                    bVar = null;
                }
                if (bVar != a.b.LOADING) {
                    c2.f67214a++;
                    c2.a();
                }
            }
        }
    }

    public final class RefreshListReceiver extends BroadcastReceiver {
        public RefreshListReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && p.a("action_refresh_pending_mandates", intent.getAction(), true)) {
                net.one97.paytm.upi.mandate.f.b c2 = PendingMandateFragment.c(PendingMandateFragment.this);
                c2.f67214a = 0;
                c2.a();
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
}
