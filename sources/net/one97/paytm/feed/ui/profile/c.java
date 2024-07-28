package net.one97.paytm.feed.ui.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.profile.Following;
import net.one97.paytm.feed.ui.feed.g;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.i.h;

public final class c extends h {

    /* renamed from: e  reason: collision with root package name */
    public static final a f35294e = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    b f35295a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f35296b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f35297c;

    /* renamed from: d  reason: collision with root package name */
    boolean f35298d;

    /* renamed from: f  reason: collision with root package name */
    private int f35299f = 1;

    /* renamed from: g  reason: collision with root package name */
    private b f35300g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Context f35301h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f35302i;

    public interface b {
        void a(Following following);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f35299f = arguments.getInt("column-count");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView.LayoutManager layoutManager;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.feed_following_item_list, viewGroup, false);
        this.f35296b = (RecyclerView) inflate.findViewById(R.id.list);
        this.f35297c = (LinearLayout) inflate.findViewById(R.id.layoutFeedNoData);
        RecyclerView recyclerView = this.f35296b;
        if (recyclerView instanceof RecyclerView) {
            if (recyclerView == null) {
                k.a();
            }
            if (this.f35299f <= 1) {
                layoutManager = new LinearLayoutManager(recyclerView.getContext());
            } else {
                layoutManager = new GridLayoutManager(recyclerView.getContext(), this.f35299f);
            }
            recyclerView.setLayoutManager(layoutManager);
            this.f35295a = new b(new ArrayList(), this.f35300g);
            recyclerView.setAdapter(this.f35295a);
        }
        RecyclerView recyclerView2 = this.f35296b;
        if (recyclerView2 != null) {
            if (recyclerView2 == null) {
                k.a();
            }
            RecyclerView.LayoutManager layoutManager2 = recyclerView2.getLayoutManager();
            if (layoutManager2 != null) {
                recyclerView2.addOnScrollListener(new C0589c(this, (GridLayoutManager) layoutManager2));
            } else {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            }
        }
        return inflate;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        this.f35301h = context;
        if (context instanceof b) {
            this.f35300g = (b) context;
        }
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a(this.f35301h);
        com.google.android.play.core.splitcompat.a.b(this.f35301h);
    }

    public final void onDetach() {
        super.onDetach();
        this.f35300g = null;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.profile.c$c  reason: collision with other inner class name */
    public static final class C0589c extends g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f35303a;

        public final boolean a() {
            return false;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [net.one97.paytm.feed.ui.profile.c, androidx.recyclerview.widget.LinearLayoutManager] */
        /* JADX WARNING: type inference failed for: r2v0, types: [int, androidx.recyclerview.widget.LinearLayoutManager] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        C0589c(androidx.recyclerview.widget.LinearLayoutManager r1, int r2) {
            /*
                r0 = this;
                r0.f35303a = r1
                r1 = 2
                r0.<init>(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.profile.c.C0589c.<init>(net.one97.paytm.feed.ui.profile.c, androidx.recyclerview.widget.LinearLayoutManager):void");
        }

        public final boolean b() {
            return this.f35303a.f35298d;
        }

        public final void a(int i2, int i3) {
            if (!this.f35303a.f35298d) {
                j jVar = j.f35397a;
                Context a2 = this.f35303a.f35301h;
                if (a2 == null) {
                    k.a();
                }
                if (j.e(a2)) {
                    c cVar = this.f35303a;
                    cVar.f35298d = true;
                    c.b(cVar);
                    return;
                }
            }
            if (i2 == i3) {
                Toast.makeText(this.f35303a.f35301h, R.string.feed_no_internet_post, 0).show();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            if (this.f35303a.f35295a != null) {
                b bVar = this.f35303a.f35295a;
                if (bVar == null) {
                    k.a();
                }
                bVar.f35284a.isEmpty();
            }
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
        }
    }

    public static final /* synthetic */ void b(c cVar) {
        if (cVar.getActivity() instanceof ProfileActivity) {
            FragmentActivity activity = cVar.getActivity();
            if (activity != null) {
                ProfileActivity profileActivity = (ProfileActivity) activity;
                if (profileActivity != null) {
                    if (cVar == null) {
                        k.a();
                    }
                    Context context = cVar.f35301h;
                    if (context == null) {
                        k.a();
                    }
                    profileActivity.a(context);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.profile.ProfileActivity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f35302i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
