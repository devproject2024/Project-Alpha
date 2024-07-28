package net.one97.paytm.feed.ui.feed;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.arthurivanets.arvi.widget.PlayableItemsRecyclerView;
import com.google.android.gms.location.LocationResult;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.FeedAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a.a;
import net.one97.paytm.feed.b.u;
import net.one97.paytm.feed.d;
import net.one97.paytm.feed.repository.models.Category;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.language.FeedLanguage;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.repository.models.progress.FeedProgress;
import net.one97.paytm.feed.ui.feed.c;
import net.one97.paytm.feed.utility.e;
import net.one97.paytm.feed.utility.q;

public final class FeedFragment extends net.one97.paytm.feed.ui.base.a<u, e> implements a.C0555a, net.one97.paytm.feed.e, b, net.one97.paytm.feed.ui.feed.e.b {
    /* access modifiers changed from: private */
    public static String A = "InboxFeedComments";
    /* access modifiers changed from: private */
    public static String B = "profile";
    /* access modifiers changed from: private */
    public static String C = "following";
    private static boolean D;
    private static boolean E;

    /* renamed from: i  reason: collision with root package name */
    public static final a f34877i = new a((byte) 0);
    /* access modifiers changed from: private */
    public static String y = "categories";
    /* access modifiers changed from: private */
    public static String z = "InboxHomeFeed";
    private HashMap F;

    /* renamed from: d  reason: collision with root package name */
    boolean f34878d;

    /* renamed from: e  reason: collision with root package name */
    boolean f34879e;

    /* renamed from: f  reason: collision with root package name */
    Category f34880f;

    /* renamed from: g  reason: collision with root package name */
    String f34881g = "";

    /* renamed from: h  reason: collision with root package name */
    public b f34882h = new b();
    private boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public Bundle m = new Bundle();
    /* access modifiers changed from: private */
    public final c n = new c(this);
    /* access modifiers changed from: private */
    public final String o = "FeedFragment";
    /* access modifiers changed from: private */
    public boolean p;
    private ArrayList<String> q = new ArrayList<>();
    private int r = 10;
    /* access modifiers changed from: private */
    public int s = -1;
    /* access modifiers changed from: private */
    public int t = -1;
    private q u;
    private c v;
    private LinearLayoutManager w;
    /* access modifiers changed from: private */
    public int x;

    public static final class b extends Observable {
    }

    public final void i() {
        HashMap hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        i();
    }

    static final class d<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34884a;

        d(FeedFragment feedFragment) {
            this.f34884a = feedFragment;
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            FeedFragment.k(this.f34884a);
            ((u) this.f34884a.b()).a(8);
            d.a aVar = net.one97.paytm.feed.d.f34256a;
            int a2 = net.one97.paytm.feed.d.f34257b;
            if (num != null && num.intValue() == a2) {
                net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
                if (!net.one97.paytm.feed.b.b()) {
                    this.f34884a.l = true;
                }
                FeedFragment.d(this.f34884a).a();
                String unused = this.f34884a.o;
                StringBuilder sb = new StringBuilder("FeedRxResponseCode.DATA_IS_AVAILABLE");
                net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                sb.append(net.one97.paytm.feed.b.b());
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                this.f34884a.p = false;
            } else {
                d.a aVar2 = net.one97.paytm.feed.d.f34256a;
                int b2 = net.one97.paytm.feed.d.f34258c;
                if (num != null && num.intValue() == b2) {
                    String unused2 = this.f34884a.o;
                    StringBuilder sb2 = new StringBuilder("FeedRxResponseCode.REFRESH_DATA_IS_AVAILABLE");
                    net.one97.paytm.feed.b bVar4 = net.one97.paytm.feed.b.f33792d;
                    sb2.append(net.one97.paytm.feed.b.b());
                    net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.k();
                } else {
                    d.a aVar3 = net.one97.paytm.feed.d.f34256a;
                    int c2 = net.one97.paytm.feed.d.f34259d;
                    if (num != null && num.intValue() == c2) {
                        FeedFragment.k(this.f34884a);
                        net.one97.paytm.feed.e.b bVar6 = net.one97.paytm.feed.e.b.f34268c;
                        if (net.one97.paytm.feed.e.b.C()) {
                            Toast.makeText(this.f34884a.f34870c, R.string.feed_no_feed_available, 0).show();
                        }
                        FeedFragment.d(this.f34884a).a();
                        String unused3 = this.f34884a.o;
                        StringBuilder sb3 = new StringBuilder("FeedRxResponseCode.DATA_IS_EMPTY");
                        net.one97.paytm.feed.b bVar7 = net.one97.paytm.feed.b.f33792d;
                        sb3.append(net.one97.paytm.feed.b.b());
                        net.one97.paytm.feed.e.b bVar8 = net.one97.paytm.feed.e.b.f34268c;
                        net.one97.paytm.feed.e.b.k();
                    } else {
                        d.a aVar4 = net.one97.paytm.feed.d.f34256a;
                        int g2 = net.one97.paytm.feed.d.f34263h;
                        if (num != null && num.intValue() == g2) {
                            this.f34884a.p = true;
                            FeedFragment.d(this.f34884a).a();
                        } else {
                            d.a aVar5 = net.one97.paytm.feed.d.f34256a;
                            int d2 = net.one97.paytm.feed.d.f34260e;
                            if (num != null && num.intValue() == d2) {
                                FeedFragment.k(this.f34884a);
                                FeedFragment.d(this.f34884a).a();
                                String unused4 = this.f34884a.o;
                                StringBuilder sb4 = new StringBuilder("FeedRxResponseCode.DATA_SERVER_ERROR");
                                net.one97.paytm.feed.b bVar9 = net.one97.paytm.feed.b.f33792d;
                                sb4.append(net.one97.paytm.feed.b.b());
                                net.one97.paytm.feed.e.b bVar10 = net.one97.paytm.feed.e.b.f34268c;
                                net.one97.paytm.feed.e.b.k();
                                net.one97.paytm.feed.e.b bVar11 = net.one97.paytm.feed.e.b.f34268c;
                                if (net.one97.paytm.feed.e.b.C()) {
                                    Toast.makeText(this.f34884a.f34870c, R.string.feed_server_error, 0).show();
                                }
                            } else {
                                d.a aVar6 = net.one97.paytm.feed.d.f34256a;
                                int f2 = net.one97.paytm.feed.d.f34262g;
                                if (num != null && num.intValue() == f2) {
                                    FeedFragment.n(this.f34884a);
                                }
                            }
                        }
                    }
                }
            }
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f34885a;

                {
                    this.f34885a = r1;
                }

                public final void run() {
                    this.f34885a.f34884a.f34878d = false;
                }
            }, 2000);
        }
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.b<FeedLanguage, x> {
        final /* synthetic */ FeedFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FeedFragment feedFragment) {
            super(1);
            this.this$0 = feedFragment;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedLanguage) obj);
            return x.f47997a;
        }

        public final void invoke(FeedLanguage feedLanguage) {
            if (feedLanguage != null && (!feedLanguage.getLanguages().isEmpty())) {
                int i2 = 0;
                for (Object next : feedLanguage.getLanguages()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    FeedLanguageData feedLanguageData = (FeedLanguageData) next;
                    if (p.a(feedLanguageData.getLanguageCode(), "en", true)) {
                        this.this$0.t = i2;
                    } else if (p.a(feedLanguageData.getLanguageCode(), "hi", true)) {
                        this.this$0.s = i2;
                    }
                    if (feedLanguageData.isSelected()) {
                        this.this$0.t = -10;
                        this.this$0.s = -10;
                    }
                    i2 = i3;
                }
                if (!(this.this$0.t == -10 || this.this$0.s == -10)) {
                    feedLanguage.getLanguages().get(this.this$0.t).setSelected(true);
                    feedLanguage.getLanguages().get(this.this$0.s).setSelected(true);
                }
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.a(feedLanguage.getLanguages());
                this.this$0.q();
            }
        }
    }

    static final class h<T> implements z<List<? extends FeedDataMinimal>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34890a;

        h(FeedFragment feedFragment) {
            this.f34890a = feedFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            this.f34890a.f34878d = false;
            Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.intValue() > 0) {
                String unused = this.f34890a.o;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                Message obtainMessage = this.f34890a.n.obtainMessage();
                this.f34890a.m.putParcelableArrayList("data", new ArrayList(list));
                kotlin.g.b.k.a((Object) obtainMessage, "msg");
                obtainMessage.setData(this.f34890a.m);
                this.f34890a.n.removeCallbacksAndMessages((Object) null);
                this.f34890a.n.sendMessageDelayed(obtainMessage, 200);
                return;
            }
            String unused2 = this.f34890a.o;
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            c d2 = FeedFragment.d(this.f34890a);
            d2.f35011a.clear();
            d2.notifyDataSetChanged();
            a aVar = FeedFragment.f34877i;
            if (kotlin.g.b.k.a((Object) FeedFragment.B, (Object) this.f34890a.f34881g)) {
                TextView textView = FeedFragment.e(this.f34890a).f34229f;
                kotlin.g.b.k.a((Object) textView, "dataBinding.feedNoData");
                textView.setVisibility(0);
                PlayableItemsRecyclerView playableItemsRecyclerView = FeedFragment.e(this.f34890a).f34231h;
                kotlin.g.b.k.a((Object) playableItemsRecyclerView, "dataBinding.recyclerview");
                playableItemsRecyclerView.setVisibility(8);
                return;
            }
            a aVar2 = FeedFragment.f34877i;
            if (FeedFragment.C.equals(this.f34890a.f34881g)) {
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                if (net.one97.paytm.feed.e.c.j()) {
                    TextView textView2 = FeedFragment.e(this.f34890a).f34229f;
                    kotlin.g.b.k.a((Object) textView2, "dataBinding.feedNoData");
                    textView2.setVisibility(0);
                    PlayableItemsRecyclerView playableItemsRecyclerView2 = FeedFragment.e(this.f34890a).f34231h;
                    kotlin.g.b.k.a((Object) playableItemsRecyclerView2, "dataBinding.recyclerview");
                    playableItemsRecyclerView2.setVisibility(8);
                    com.google.android.play.core.splitcompat.a.a(this.f34890a.f34870c);
                    TextView textView3 = FeedFragment.e(this.f34890a).f34229f;
                    kotlin.g.b.k.a((Object) textView3, "dataBinding.feedNoData");
                    textView3.setText(this.f34890a.getString(R.string.no_followed_items));
                    return;
                }
                FeedFragment feedFragment = this.f34890a;
                TextView textView4 = ((u) feedFragment.b()).f34228e;
                kotlin.g.b.k.a((Object) textView4, "dataBinding.feedLoginText");
                textView4.setVisibility(0);
                TextView textView5 = ((u) feedFragment.b()).f34226c;
                kotlin.g.b.k.a((Object) textView5, "dataBinding.feedLogin");
                textView5.setVisibility(0);
                ImageView imageView = ((u) feedFragment.b()).f34227d;
                kotlin.g.b.k.a((Object) imageView, "dataBinding.feedLoginImage");
                imageView.setVisibility(0);
                return;
            }
            TextView textView6 = FeedFragment.e(this.f34890a).f34229f;
            kotlin.g.b.k.a((Object) textView6, "dataBinding.feedNoData");
            textView6.setVisibility(8);
            PlayableItemsRecyclerView playableItemsRecyclerView3 = FeedFragment.e(this.f34890a).f34231h;
            kotlin.g.b.k.a((Object) playableItemsRecyclerView3, "dataBinding.recyclerview");
            playableItemsRecyclerView3.setVisibility(0);
        }
    }

    static final class i<T> implements z<List<? extends FeedDataMinimal>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34891a;

        i(FeedFragment feedFragment) {
            this.f34891a = feedFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.intValue() > 0) {
                net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.a((ArrayList<FeedItem>) (ArrayList) net.one97.paytm.feed.repository.db.b.a((List<? extends FeedDataMinimal>) list));
                FeedFragment.d(this.f34891a).notifyDataSetChanged();
            }
        }
    }

    public static final /* synthetic */ c d(FeedFragment feedFragment) {
        c cVar = feedFragment.v;
        if (cVar == null) {
            kotlin.g.b.k.a(FeedAdapter.TAG);
        }
        return cVar;
    }

    public static final /* synthetic */ u e(FeedFragment feedFragment) {
        return (u) feedFragment.b();
    }

    public static final /* synthetic */ LinearLayoutManager q(FeedFragment feedFragment) {
        LinearLayoutManager linearLayoutManager = feedFragment.w;
        if (linearLayoutManager == null) {
            kotlin.g.b.k.a("feedLayoutManager");
        }
        return linearLayoutManager;
    }

    public static final /* synthetic */ e r(FeedFragment feedFragment) {
        return (e) feedFragment.c();
    }

    public final HashMap<Integer, Object> e() {
        return new HashMap<>();
    }

    public final void a(ArrayList<FeedDataMinimal> arrayList) {
        if (arrayList != null && arrayList.size() == 0 && kotlin.g.b.k.a((Object) B, (Object) this.f34881g)) {
            TextView textView = ((u) b()).f34229f;
            kotlin.g.b.k.a((Object) textView, "dataBinding.feedNoData");
            textView.setVisibility(0);
            PlayableItemsRecyclerView playableItemsRecyclerView = ((u) b()).f34231h;
            kotlin.g.b.k.a((Object) playableItemsRecyclerView, "dataBinding.recyclerview");
            playableItemsRecyclerView.setVisibility(8);
        } else if (arrayList == null || arrayList.size() != 0 || !kotlin.g.b.k.a((Object) C, (Object) this.f34881g)) {
            TextView textView2 = ((u) b()).f34229f;
            kotlin.g.b.k.a((Object) textView2, "dataBinding.feedNoData");
            textView2.setVisibility(8);
            PlayableItemsRecyclerView playableItemsRecyclerView2 = ((u) b()).f34231h;
            kotlin.g.b.k.a((Object) playableItemsRecyclerView2, "dataBinding.recyclerview");
            playableItemsRecyclerView2.setVisibility(0);
        } else {
            TextView textView3 = ((u) b()).f34229f;
            kotlin.g.b.k.a((Object) textView3, "dataBinding.feedNoData");
            textView3.setVisibility(0);
            PlayableItemsRecyclerView playableItemsRecyclerView3 = ((u) b()).f34231h;
            kotlin.g.b.k.a((Object) playableItemsRecyclerView3, "dataBinding.recyclerview");
            playableItemsRecyclerView3.setVisibility(8);
            TextView textView4 = ((u) b()).f34229f;
            kotlin.g.b.k.a((Object) textView4, "dataBinding.feedNoData");
            textView4.setText(getString(R.string.no_followed_items));
        }
        if (arrayList != null) {
            net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
            ArrayList<FeedItem> arrayList2 = (ArrayList) net.one97.paytm.feed.repository.db.b.a((List<? extends FeedDataMinimal>) arrayList);
            net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
            if (net.one97.paytm.feed.b.b()) {
                LinearLayoutManager linearLayoutManager = this.w;
                if (linearLayoutManager == null) {
                    kotlin.g.b.k.a("feedLayoutManager");
                }
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                c cVar = this.v;
                if (cVar == null) {
                    kotlin.g.b.k.a(FeedAdapter.TAG);
                }
                if (findLastVisibleItemPosition == cVar.getItemCount() - 1) {
                    String str = B;
                    Category category = this.f34880f;
                    if (kotlin.g.b.k.a((Object) str, (Object) category != null ? category.getDisplayName() : null)) {
                        PlayableItemsRecyclerView playableItemsRecyclerView4 = ((u) b()).f34231h;
                        c cVar2 = this.v;
                        if (cVar2 == null) {
                            kotlin.g.b.k.a(FeedAdapter.TAG);
                        }
                        playableItemsRecyclerView4.scrollToPosition(cVar2.getItemCount() - 1);
                    } else {
                        PlayableItemsRecyclerView playableItemsRecyclerView5 = ((u) b()).f34231h;
                        c cVar3 = this.v;
                        if (cVar3 == null) {
                            kotlin.g.b.k.a(FeedAdapter.TAG);
                        }
                        playableItemsRecyclerView5.scrollToPosition(cVar3.getItemCount() - 2);
                    }
                }
            }
            c cVar4 = this.v;
            if (cVar4 == null) {
                kotlin.g.b.k.a(FeedAdapter.TAG);
            }
            kotlin.g.b.k.c(arrayList2, "list");
            if (cVar4.f35011a.size() == 0) {
                cVar4.f35011a = arrayList2;
                cVar4.notifyItemRangeInserted(0, arrayList2.size());
            } else {
                h.b a2 = androidx.recyclerview.widget.h.a(new c.C0575c(cVar4, arrayList2));
                kotlin.g.b.k.a((Object) a2, "DiffUtil.calculateDiff(o…            }\n\n        })");
                cVar4.f35011a = arrayList2;
                a2.a((RecyclerView.a) cVar4);
            }
            net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            if (this.k) {
                ((u) b()).f34231h.scrollToPosition(0);
                this.k = false;
                this.l = false;
            }
            if (kotlin.g.b.k.a((Object) this.f34881g, (Object) z)) {
                net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                if (net.one97.paytm.feed.e.b.C()) {
                    q();
                }
            }
            c cVar5 = this.v;
            if (cVar5 == null) {
                kotlin.g.b.k.a(FeedAdapter.TAG);
            }
            cVar5.a();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final j f34892a = new j();

        j() {
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            kotlin.g.b.k.a((Object) view, "it");
            Context context = view.getContext();
            kotlin.g.b.k.a((Object) context, "it.context");
            net.one97.paytm.feed.e.b.a(context);
        }
    }

    /* access modifiers changed from: private */
    public final void q() {
        net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
        if (!TextUtils.isEmpty(net.one97.paytm.feed.e.c.d())) {
            net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
            if (!net.one97.paytm.feed.repository.b.b()) {
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                if (net.one97.paytm.feed.e.b.d() == null) {
                    p();
                    return;
                }
                c cVar2 = this.v;
                if (cVar2 == null) {
                    kotlin.g.b.k.a(FeedAdapter.TAG);
                }
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                cVar2.a(net.one97.paytm.feed.e.b.d());
            }
        }
    }

    public final int d() {
        return R.layout.feed_fragment;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a() {
            return FeedFragment.y;
        }

        public static String b() {
            return FeedFragment.C;
        }

        public static FeedFragment a(Bundle bundle) {
            FeedFragment feedFragment = new FeedFragment();
            feedFragment.setArguments(bundle);
            return feedFragment;
        }
    }

    private final void s() {
        Context context;
        if (isAdded() && (context = this.f34870c) != null) {
            TextView textView = ((u) b()).f34224a;
            textView.setVisibility(0);
            textView.setText(context.getString(R.string.feed_retry));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, androidx.core.content.b.a(context, R.drawable.feed_no_internet), (Drawable) null, (Drawable) null);
            textView.setOnClickListener(new o(context, this));
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34898a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34899b;

        o(Context context, FeedFragment feedFragment) {
            this.f34898a = context;
            this.f34899b = feedFragment;
        }

        public final void onClick(View view) {
            FeedFragment.j(this.f34899b);
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34896a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34897b;

        n(Context context, FeedFragment feedFragment) {
            this.f34896a = context;
            this.f34897b = feedFragment;
        }

        public final void onClick(View view) {
            FeedFragment.j(this.f34897b);
        }
    }

    public static final class g extends g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f34888a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34889b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(u uVar, LinearLayoutManager linearLayoutManager, int i2, FeedFragment feedFragment) {
            super(linearLayoutManager, i2);
            this.f34888a = uVar;
            this.f34889b = feedFragment;
        }

        public final boolean a() {
            return this.f34889b.f34879e;
        }

        public final boolean b() {
            return this.f34889b.f34878d;
        }

        public final void a(int i2, int i3) {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            Context f2 = this.f34889b.f34870c;
            if (f2 == null) {
                kotlin.g.b.k.a();
            }
            if (net.one97.paytm.feed.utility.j.e(f2)) {
                if (!this.f34889b.p) {
                    FeedFragment.o(this.f34889b);
                } else if (i2 == i3) {
                    FeedFragment.o(this.f34889b);
                }
            } else if (i2 == i3) {
                Toast.makeText(this.f34889b.f34870c, R.string.feed_no_internet_post, 0).show();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (this.f34889b.x == 2 && i2 == 0) {
                net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(2, FeedFragment.q(this.f34889b).findLastVisibleItemPosition());
            }
            if (this.f34889b.x == 0 && i2 == 1) {
                net.one97.paytm.feed.events.a aVar2 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.a(0, FeedFragment.q(this.f34889b).findLastVisibleItemPosition());
            }
            this.f34889b.x = i2;
            net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a.a(i2, System.currentTimeMillis());
            if (this.f34889b.x == 0 && FeedFragment.d(this.f34889b) != null && (!FeedFragment.d(this.f34889b).f35011a.isEmpty())) {
                net.one97.paytm.feed.events.a aVar4 = net.one97.paytm.feed.events.a.f34284a;
                net.one97.paytm.feed.events.a.b(FeedFragment.d(this.f34889b).f35011a);
            }
        }
    }

    static final class m implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34895a;

        m(FeedFragment feedFragment) {
            this.f34895a = feedFragment;
        }

        public final void onRefresh() {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            Context f2 = this.f34895a.f34870c;
            if (f2 == null) {
                kotlin.g.b.k.a();
            }
            if (!net.one97.paytm.feed.utility.j.e(f2)) {
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                if (net.one97.paytm.feed.e.b.C()) {
                    Toast.makeText(this.f34895a.f34870c, R.string.feed_no_internet_post, 0).show();
                }
            } else if (!this.f34895a.f34878d) {
                if (this.f34895a.f34880f == null) {
                    e r = FeedFragment.r(this.f34895a);
                    net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                    a aVar = FeedFragment.f34877i;
                    String l = FeedFragment.z;
                    net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
                    r.a(net.one97.paytm.feed.e.b.x(), l, true, net.one97.paytm.feed.b.i());
                } else {
                    net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                    if (net.one97.paytm.feed.e.c.j()) {
                        e r2 = FeedFragment.r(this.f34895a);
                        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                        Context x = net.one97.paytm.feed.e.b.x();
                        Category category = this.f34895a.f34880f;
                        if (category == null) {
                            kotlin.g.b.k.a();
                        }
                        String id = category.getId();
                        if (id == null) {
                            kotlin.g.b.k.a();
                        }
                        net.one97.paytm.feed.b bVar5 = net.one97.paytm.feed.b.f33792d;
                        r2.a(x, id, true, net.one97.paytm.feed.b.l());
                    }
                }
                this.f34895a.k = true;
                return;
            } else {
                Toast.makeText(this.f34895a.f34870c, R.string.feed_request_already_in_progress, 0).show();
            }
            FeedFragment.k(this.f34895a);
        }
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34894a;

        l(FeedFragment feedFragment) {
            this.f34894a = feedFragment;
        }

        public final void run() {
            FeedFragment.e(this.f34894a).f34231h.scrollToPosition(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005a, code lost:
        if (android.text.TextUtils.isEmpty(net.one97.paytm.feed.e.c.d()) != false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResume() {
        /*
            r7 = this;
            super.onResume()
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.k()
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 == 0) goto L_0x0020
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            com.google.android.play.core.splitcompat.a.a((android.content.Context) r0)
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            com.google.android.play.core.splitcompat.a.b((android.content.Context) r0)
        L_0x0020:
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            r0 = 0
            net.one97.paytm.feed.e.b.c((boolean) r0)
            net.one97.paytm.feed.events.f r1 = net.one97.paytm.feed.events.f.f34346d
            long r1 = net.one97.paytm.feed.events.f.a()
            int r2 = (int) r1
            if (r2 != 0) goto L_0x0040
            net.one97.paytm.feed.e.b r1 = net.one97.paytm.feed.e.b.f34268c
            boolean r1 = net.one97.paytm.feed.e.b.C()
            if (r1 == 0) goto L_0x0040
            net.one97.paytm.feed.events.f r1 = net.one97.paytm.feed.events.f.f34346d
            long r1 = java.lang.System.currentTimeMillis()
            net.one97.paytm.feed.events.f.a((long) r1)
        L_0x0040:
            net.one97.paytm.feed.e.b r1 = net.one97.paytm.feed.e.b.f34268c
            java.lang.String r1 = net.one97.paytm.feed.e.b.h()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x005c
            net.one97.paytm.feed.e.c r1 = net.one97.paytm.feed.e.c.f34275a
            java.lang.String r1 = net.one97.paytm.feed.e.c.d()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0065
        L_0x005c:
            android.content.Context r1 = r7.f34870c
            if (r1 == 0) goto L_0x0065
            net.one97.paytm.feed.e.b r2 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.b((android.content.Context) r1)
        L_0x0065:
            net.one97.paytm.feed.e.b r1 = net.one97.paytm.feed.e.b.f34268c
            boolean r1 = net.one97.paytm.feed.e.b.p()
            if (r1 == 0) goto L_0x009d
            net.one97.paytm.feed.events.a r1 = net.one97.paytm.feed.events.a.f34284a
            long r1 = java.lang.System.currentTimeMillis()
            net.one97.paytm.feed.events.a.b((long) r1)
            net.one97.paytm.feed.events.a r1 = net.one97.paytm.feed.events.a.f34284a
            net.one97.paytm.feed.events.a r1 = net.one97.paytm.feed.events.a.f34284a
            int r1 = net.one97.paytm.feed.events.a.e()
            net.one97.paytm.feed.events.a.a((int) r1)
            net.one97.paytm.feed.events.f r1 = net.one97.paytm.feed.events.f.f34346d
            long r1 = net.one97.paytm.feed.events.f.c()
            net.one97.paytm.feed.events.a r3 = net.one97.paytm.feed.events.a.f34284a
            long r3 = net.one97.paytm.feed.events.a.d()
            net.one97.paytm.feed.events.a r5 = net.one97.paytm.feed.events.a.f34284a
            long r5 = net.one97.paytm.feed.events.a.c()
            long r3 = r3 - r5
            long r1 = r1 + r3
            net.one97.paytm.feed.events.f.c(r1)
            net.one97.paytm.feed.e.b r1 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.b((boolean) r0)
        L_0x009d:
            net.one97.paytm.feed.e.c r1 = net.one97.paytm.feed.e.c.f34275a
            boolean r1 = net.one97.paytm.feed.e.c.j()
            if (r1 == 0) goto L_0x00e1
            java.lang.String r1 = r7.f34881g
            java.lang.String r2 = C
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x00e1
            androidx.databinding.ViewDataBinding r1 = r7.b()
            net.one97.paytm.feed.b.u r1 = (net.one97.paytm.feed.b.u) r1
            android.widget.TextView r1 = r1.f34228e
            java.lang.String r2 = "dataBinding.feedLoginText"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = 8
            r1.setVisibility(r2)
            androidx.databinding.ViewDataBinding r1 = r7.b()
            net.one97.paytm.feed.b.u r1 = (net.one97.paytm.feed.b.u) r1
            android.widget.TextView r1 = r1.f34226c
            java.lang.String r3 = "dataBinding.feedLogin"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r1.setVisibility(r2)
            androidx.databinding.ViewDataBinding r1 = r7.b()
            net.one97.paytm.feed.b.u r1 = (net.one97.paytm.feed.b.u) r1
            android.widget.ImageView r1 = r1.f34227d
            java.lang.String r3 = "dataBinding.feedLoginImage"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r1.setVisibility(r2)
        L_0x00e1:
            androidx.databinding.ViewDataBinding r1 = r7.b()
            net.one97.paytm.feed.b.u r1 = (net.one97.paytm.feed.b.u) r1
            com.arthurivanets.arvi.widget.PlayableItemsRecyclerView r1 = r1.f34231h
            r2 = 1
            r1.a((boolean) r2)
            androidx.recyclerview.widget.LinearLayoutManager r1 = r7.w
            if (r1 != 0) goto L_0x00f6
            java.lang.String r2 = "feedLayoutManager"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00f6:
            int r1 = r1.getChildCount()
        L_0x00fa:
            if (r0 >= r1) goto L_0x0124
            androidx.databinding.ViewDataBinding r2 = r7.b()
            net.one97.paytm.feed.b.u r2 = (net.one97.paytm.feed.b.u) r2
            com.arthurivanets.arvi.widget.PlayableItemsRecyclerView r2 = r2.f34231h
            androidx.databinding.ViewDataBinding r3 = r7.b()
            net.one97.paytm.feed.b.u r3 = (net.one97.paytm.feed.b.u) r3
            com.arthurivanets.arvi.widget.PlayableItemsRecyclerView r3 = r3.f34231h
            android.view.View r3 = r3.getChildAt(r0)
            androidx.recyclerview.widget.RecyclerView$v r2 = r2.findContainingViewHolder(r3)
            boolean r3 = r2 instanceof net.one97.paytm.feed.ui.feed.b.d
            if (r3 == 0) goto L_0x0121
            net.one97.paytm.feed.ui.feed.b.d r2 = (net.one97.paytm.feed.ui.feed.b.d) r2
            android.animation.ObjectAnimator r2 = r2.f35003d
            if (r2 == 0) goto L_0x0121
            r2.resume()
        L_0x0121:
            int r0 = r0 + 1
            goto L_0x00fa
        L_0x0124:
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            boolean r0 = net.one97.paytm.feed.e.b.b()
            if (r0 == 0) goto L_0x0146
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            int r0 = net.one97.paytm.feed.e.b.a()
            if (r0 < 0) goto L_0x0146
            net.one97.paytm.feed.ui.feed.c r0 = r7.v
            if (r0 != 0) goto L_0x013d
            java.lang.String r1 = "feedAdapter"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x013d:
            net.one97.paytm.feed.e.b r1 = net.one97.paytm.feed.e.b.f34268c
            int r1 = net.one97.paytm.feed.e.b.a()
            r0.notifyItemChanged(r1)
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.FeedFragment.onResume():void");
    }

    public final void onStart() {
        super.onStart();
        try {
            if (getActivity() != null) {
                net.one97.paytm.feed.a.a aVar = net.one97.paytm.feed.a.a.f33785c;
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                Activity activity2 = activity;
                kotlin.g.b.k.c(activity2, "activity");
                if (net.one97.paytm.feed.a.a.f33783a == null) {
                    net.one97.paytm.feed.a.a.f33784b = new net.one97.paytm.feed.a.b(aVar);
                    Context context = activity2;
                    androidx.browser.customtabs.e eVar = net.one97.paytm.feed.a.a.f33784b;
                    if (eVar != null) {
                        androidx.browser.customtabs.c.a(context, "com.android.chrome", (net.one97.paytm.feed.a.b) eVar);
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.feed.chrometabs.ServiceConnection");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (kotlin.g.b.k.a((Object) this.f34881g, (Object) z)) {
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.a((net.one97.paytm.feed.e) this);
            return;
        }
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.b((net.one97.paytm.feed.e) this);
    }

    public final void onStop() {
        super.onStop();
        net.one97.paytm.feed.repository.a aVar = net.one97.paytm.feed.repository.a.f34359b;
        net.one97.paytm.feed.repository.a.b();
        try {
            if (getActivity() != null) {
                net.one97.paytm.feed.a.a aVar2 = net.one97.paytm.feed.a.a.f33785c;
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                net.one97.paytm.feed.a.a.a((Activity) activity);
            }
        } catch (Exception unused) {
        }
        if (kotlin.g.b.k.a((Object) this.f34881g, (Object) z)) {
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.y();
            return;
        }
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.z();
    }

    public final void onPause() {
        super.onPause();
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.c(true);
        Context context = this.f34870c;
        if (context != null) {
            net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a.a(context);
            net.one97.paytm.feed.repository.db.a aVar2 = net.one97.paytm.feed.repository.db.a.f34614a;
            net.one97.paytm.feed.repository.db.a.d(context, "");
        }
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.C()) {
            net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
            net.one97.paytm.feed.events.f.i();
        } else {
            net.one97.paytm.feed.events.f fVar2 = net.one97.paytm.feed.events.f.f34346d;
            net.one97.paytm.feed.events.f.f34345c += net.one97.paytm.feed.events.f.f34344b - net.one97.paytm.feed.events.f.f34343a;
            net.one97.paytm.feed.events.f.j();
        }
        ((u) b()).f34231h.a();
    }

    public static final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final b f34883a;

        public c(b bVar) {
            kotlin.g.b.k.c(bVar, "listener");
            this.f34883a = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r2 = r2.getData();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r2) {
            /*
                r1 = this;
                super.handleMessage(r2)
                if (r2 == 0) goto L_0x0012
                android.os.Bundle r2 = r2.getData()
                if (r2 == 0) goto L_0x0012
                java.lang.String r0 = "data"
                java.util.ArrayList r2 = r2.getParcelableArrayList(r0)
                goto L_0x0013
            L_0x0012:
                r2 = 0
            L_0x0013:
                net.one97.paytm.feed.ui.feed.b r0 = r1.f34883a
                r0.a(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.FeedFragment.c.handleMessage(android.os.Message):void");
        }
    }

    public final void onDestroy() {
        PlayableItemsRecyclerView playableItemsRecyclerView = ((u) b()).f34231h;
        if (playableItemsRecyclerView != null) {
            playableItemsRecyclerView.b();
        }
        super.onDestroy();
        net.one97.paytm.feed.a.a aVar = net.one97.paytm.feed.a.a.f33785c;
        net.one97.paytm.feed.a.a.a((a.C0555a) null);
    }

    public final void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.j = z2;
        StringBuilder sb = new StringBuilder("Hit API once now :: ");
        sb.append(this.j);
        sb.append(" and movedToInbox :: ");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        sb.append(net.one97.paytm.feed.e.b.l());
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        if (z2) {
            r();
        } else if (g() && h()) {
            ((u) b()).f34231h.a();
        }
    }

    public static final class e implements net.one97.paytm.feed.utility.o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34886a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34887b;

        e(FeedFragment feedFragment, int i2) {
            this.f34886a = feedFragment;
            this.f34887b = i2;
        }

        public final void a(LocationResult locationResult) {
            kotlin.g.b.k.c(locationResult, "locationResult");
            String unused = this.f34886a.o;
            Location a2 = locationResult.a();
            kotlin.g.b.k.a((Object) a2, "locationResult.lastLocation");
            String.valueOf(a2.getLatitude());
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
            Location a3 = locationResult.a();
            kotlin.g.b.k.a((Object) a3, "locationResult.lastLocation");
            Location a4 = locationResult.a();
            kotlin.g.b.k.a((Object) a4, "locationResult.lastLocation");
            net.one97.paytm.feed.e.c.a((float) a3.getLatitude(), (float) a4.getLongitude());
            FeedFragment.d(this.f34886a).notifyItemChanged(this.f34887b);
        }
    }

    public final void a(int i2) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        this.u = new q(activity, this, new e(this, i2));
    }

    public final boolean j() {
        q.a aVar = q.f35420b;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        return q.a.a(activity);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 15723 && i3 == -1) {
            q qVar = this.u;
            if (qVar == null) {
                kotlin.g.b.k.a("locationUtil");
            }
            qVar.a();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 15724) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            q qVar = this.u;
            if (qVar == null) {
                kotlin.g.b.k.a("locationUtil");
            }
            qVar.a();
        } else if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
            net.one97.paytm.feed.utility.e eVar = net.one97.paytm.feed.utility.e.f35388a;
            Context context = getContext();
            String string = getString(R.string.location_permission_setting_title);
            kotlin.g.b.k.a((Object) string, "getString(R.string.locat…permission_setting_title)");
            String string2 = getString(R.string.location_settings_cta);
            kotlin.g.b.k.a((Object) string2, "getString(R.string.location_settings_cta)");
            View.OnClickListener kVar = new k(this);
            kotlin.g.b.k.c(string, "title");
            kotlin.g.b.k.c(string2, "cta1Text");
            kotlin.g.b.k.c(kVar, "cta1ClickListener");
            if (context != null) {
                try {
                    Dialog a2 = net.one97.paytm.feed.utility.e.a(context);
                    a2.setCanceledOnTouchOutside(true);
                    if (!TextUtils.isEmpty(string)) {
                        View findViewById = a2.findViewById(R.id.title);
                        if (findViewById != null) {
                            ((TextView) findViewById).setText(string);
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        View findViewById2 = a2.findViewById(R.id.confirmBtn);
                        if (findViewById2 != null) {
                            ((TextView) findViewById2).setText(string2);
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                        }
                    }
                    ((TextView) a2.findViewById(R.id.confirmBtn)).setOnClickListener(new e.a(a2, kVar));
                } catch (Exception unused) {
                }
            }
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedFragment f34893a;

        k(FeedFragment feedFragment) {
            this.f34893a = feedFragment;
        }

        public final void onClick(View view) {
            FeedFragment.t(this.f34893a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0207  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r7 = this;
            android.content.Context r0 = r7.f34870c
            com.google.android.play.core.splitcompat.a.a((android.content.Context) r0)
            android.os.Bundle r0 = r7.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.String r2 = y
            android.os.Parcelable r0 = r0.getParcelable(r2)
            net.one97.paytm.feed.repository.models.Category r0 = (net.one97.paytm.feed.repository.models.Category) r0
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            r7.f34880f = r0
            android.os.Bundle r0 = r7.getArguments()
            r2 = 0
            if (r0 == 0) goto L_0x007a
            android.os.Bundle r0 = r7.getArguments()
            if (r0 != 0) goto L_0x0028
            kotlin.g.b.k.a()
        L_0x0028:
            java.lang.String r3 = "isFromUpdate"
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x007a
            android.os.Bundle r0 = r7.getArguments()
            if (r0 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            boolean r0 = r0.getBoolean(r3)
            if (r0 == 0) goto L_0x007a
            int r0 = net.one97.paytm.feed.R.id.tvTitle
            java.util.HashMap r3 = r7.F
            if (r3 != 0) goto L_0x004c
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r7.F = r3
        L_0x004c:
            java.util.HashMap r3 = r7.F
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x006f
            android.view.View r3 = r7.getView()
            if (r3 != 0) goto L_0x0062
            r3 = r1
            goto L_0x006f
        L_0x0062:
            android.view.View r3 = r3.findViewById(r0)
            java.util.HashMap r4 = r7.F
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.put(r0, r3)
        L_0x006f:
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r0 = "tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r3.setVisibility(r2)
        L_0x007a:
            net.one97.paytm.feed.repository.models.Category r0 = r7.f34880f
            r3 = 1
            if (r0 != 0) goto L_0x00a0
            android.os.Bundle r0 = r7.getArguments()
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x008e
            java.lang.String r5 = "category"
            java.lang.String r0 = r0.getString(r5, r4)
            goto L_0x008f
        L_0x008e:
            r0 = r1
        L_0x008f:
            java.lang.String r5 = "following"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r5, (boolean) r3)
            if (r0 == 0) goto L_0x00a0
            net.one97.paytm.feed.repository.models.Category r0 = new net.one97.paytm.feed.repository.models.Category
            java.lang.String r5 = C
            r0.<init>(r5, r5, r4, r4)
            r7.f34880f = r0
        L_0x00a0:
            net.one97.paytm.feed.repository.models.Category r0 = r7.f34880f
            if (r0 == 0) goto L_0x00a9
            java.lang.String r0 = r0.getId()
            goto L_0x00aa
        L_0x00a9:
            r0 = r1
        L_0x00aa:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r4 = 2
            if (r0 != 0) goto L_0x00e3
            java.lang.String r0 = B
            net.one97.paytm.feed.repository.models.Category r5 = r7.f34880f
            if (r5 == 0) goto L_0x00be
            java.lang.String r5 = r5.getDisplayName()
            goto L_0x00bf
        L_0x00be:
            r5 = r1
        L_0x00bf:
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = B
            r7.f34881g = r0
            goto L_0x00e7
        L_0x00ca:
            java.lang.String r0 = C
            net.one97.paytm.feed.repository.models.Category r5 = r7.f34880f
            if (r5 == 0) goto L_0x00d5
            java.lang.String r5 = r5.getDisplayName()
            goto L_0x00d6
        L_0x00d5:
            r5 = r1
        L_0x00d6:
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x00e3
            java.lang.String r0 = C
            r7.f34881g = r0
            r7.r = r4
            goto L_0x00e7
        L_0x00e3:
            java.lang.String r0 = z
            r7.f34881g = r0
        L_0x00e7:
            android.os.Bundle r0 = r7.getArguments()
            if (r0 == 0) goto L_0x0105
            java.lang.String r5 = "expanded"
            boolean r5 = r0.getBoolean(r5, r2)
            if (r5 == 0) goto L_0x00fa
            net.one97.paytm.feed.e.b r5 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.B()
        L_0x00fa:
            java.lang.String r5 = "IS_FRESH_INSTALL"
            boolean r0 = r0.getBoolean(r5, r2)
            if (r0 == 0) goto L_0x0105
            r7.r()
        L_0x0105:
            androidx.databinding.ViewDataBinding r0 = r7.b()
            net.one97.paytm.feed.b.u r0 = (net.one97.paytm.feed.b.u) r0
            r5 = 8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.a(r5)
            androidx.databinding.ViewDataBinding r0 = r7.b()
            net.one97.paytm.feed.b.u r0 = (net.one97.paytm.feed.b.u) r0
            com.arthurivanets.arvi.widget.PlayableItemsRecyclerView r0 = r0.f34231h
            com.arthurivanets.arvi.widget.c$b[] r4 = new com.arthurivanets.arvi.widget.c.b[r4]
            com.arthurivanets.arvi.widget.c$b r5 = com.arthurivanets.arvi.widget.c.b.IDLING
            r4[r2] = r5
            com.arthurivanets.arvi.widget.c$b r5 = com.arthurivanets.arvi.widget.c.b.DRAGGING
            r4[r3] = r5
            r0.setPlaybackTriggeringStates(r4)
            com.arthurivanets.arvi.widget.c$a r4 = com.arthurivanets.arvi.widget.c.a.ONE_AT_A_TIME
            r0.setAutoplayMode(r4)
            r0.setItemAnimator(r1)
            androidx.recyclerview.widget.LinearLayoutManager r4 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r5 = r0.getContext()
            r4.<init>(r5, r3, r2)
            r7.w = r4
            androidx.recyclerview.widget.LinearLayoutManager r4 = r7.w
            if (r4 != 0) goto L_0x0145
            java.lang.String r5 = "feedLayoutManager"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0145:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r4
            r0.setLayoutManager(r4)
            android.content.Context r4 = r7.f34870c
            com.google.android.play.core.splitcompat.a.a((android.content.Context) r4)
            net.one97.paytm.feed.ui.feed.c r4 = new net.one97.paytm.feed.ui.feed.c
            android.content.Context r5 = r7.f34870c
            if (r5 != 0) goto L_0x0158
            kotlin.g.b.k.a()
        L_0x0158:
            r6 = r7
            net.one97.paytm.feed.ui.feed.e.b r6 = (net.one97.paytm.feed.ui.feed.e.b) r6
            r4.<init>(r5, r6)
            r7.v = r4
            net.one97.paytm.feed.ui.feed.c r4 = r7.v
            java.lang.String r5 = "feedAdapter"
            if (r4 != 0) goto L_0x0169
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0169:
            r4.setHasStableIds(r3)
            net.one97.paytm.feed.ui.feed.c r3 = r7.v
            if (r3 != 0) goto L_0x0173
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0173:
            androidx.recyclerview.widget.RecyclerView$a r3 = (androidx.recyclerview.widget.RecyclerView.a) r3
            r0.setAdapter(r3)
            net.one97.paytm.feed.utility.f r3 = new net.one97.paytm.feed.utility.f
            android.content.Context r4 = r7.f34870c
            if (r4 != 0) goto L_0x0181
            kotlin.g.b.k.a()
        L_0x0181:
            r5 = 1106247680(0x41f00000, float:30.0)
            r3.<init>(r4, r5)
            androidx.recyclerview.widget.RecyclerView$h r3 = (androidx.recyclerview.widget.RecyclerView.h) r3
            r0.addItemDecoration(r3)
            androidx.lifecycle.ai r0 = r7.c()
            net.one97.paytm.feed.ui.feed.e r0 = (net.one97.paytm.feed.ui.feed.e) r0
            io.reactivex.rxjava3.j.b<java.lang.Integer> r0 = r0.f35039c
            net.one97.paytm.feed.ui.feed.FeedFragment$d r3 = new net.one97.paytm.feed.ui.feed.FeedFragment$d
            r3.<init>(r7)
            io.reactivex.rxjava3.d.g r3 = (io.reactivex.rxjava3.d.g) r3
            r0.subscribe(r3)
            androidx.databinding.ViewDataBinding r0 = r7.b()
            net.one97.paytm.feed.b.u r0 = (net.one97.paytm.feed.b.u) r0
            com.arthurivanets.arvi.widget.PlayableItemsRecyclerView r3 = r0.f34231h
            if (r3 == 0) goto L_0x01cb
            net.one97.paytm.feed.ui.feed.FeedFragment$g r4 = new net.one97.paytm.feed.ui.feed.FeedFragment$g
            com.arthurivanets.arvi.widget.PlayableItemsRecyclerView r5 = r0.f34231h
            java.lang.String r6 = "recyclerview"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = r5.getLayoutManager()
            if (r5 == 0) goto L_0x01c3
            androidx.recyclerview.widget.LinearLayoutManager r5 = (androidx.recyclerview.widget.LinearLayoutManager) r5
            int r6 = r7.r
            r4.<init>(r0, r5, r6, r7)
            androidx.recyclerview.widget.RecyclerView$l r4 = (androidx.recyclerview.widget.RecyclerView.l) r4
            r3.addOnScrollListener(r4)
            goto L_0x01cb
        L_0x01c3:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager"
            r0.<init>(r1)
            throw r0
        L_0x01cb:
            java.lang.String r0 = B
            net.one97.paytm.feed.repository.models.Category r3 = r7.f34880f
            if (r3 == 0) goto L_0x01d6
            java.lang.String r3 = r3.getDisplayName()
            goto L_0x01d7
        L_0x01d6:
            r3 = r1
        L_0x01d7:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x01f0
            androidx.databinding.ViewDataBinding r0 = r7.b()
            net.one97.paytm.feed.b.u r0 = (net.one97.paytm.feed.b.u) r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r0.f34230g
            net.one97.paytm.feed.ui.feed.FeedFragment$m r2 = new net.one97.paytm.feed.ui.feed.FeedFragment$m
            r2.<init>(r7)
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout$b r2 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout.b) r2
            r0.setOnRefreshListener(r2)
            goto L_0x01fd
        L_0x01f0:
            androidx.databinding.ViewDataBinding r0 = r7.b()
            net.one97.paytm.feed.b.u r0 = (net.one97.paytm.feed.b.u) r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = r0.f34230g
            if (r0 == 0) goto L_0x01fd
            r0.setEnabled(r2)
        L_0x01fd:
            java.lang.String r0 = r7.f34881g
            java.lang.String r2 = z
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0212
            net.one97.paytm.feed.repository.b r0 = net.one97.paytm.feed.repository.b.f34608a
            boolean r0 = net.one97.paytm.feed.repository.b.b()
            if (r0 != 0) goto L_0x0212
            r7.p()
        L_0x0212:
            androidx.lifecycle.ai r0 = r7.c()
            net.one97.paytm.feed.ui.feed.e r0 = (net.one97.paytm.feed.ui.feed.e) r0
            java.lang.String r2 = r7.f34881g
            android.content.Context r3 = r7.f34870c
            java.lang.String r4 = "categoryName"
            kotlin.g.b.k.c(r2, r4)
            androidx.lifecycle.LiveData<java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal>> r4 = r0.f35037a
            if (r4 != 0) goto L_0x022f
            if (r3 == 0) goto L_0x022f
            net.one97.paytm.feed.repository.db.a r4 = net.one97.paytm.feed.repository.db.a.f34614a
            androidx.lifecycle.LiveData r2 = net.one97.paytm.feed.repository.db.a.a(r3, r2)
            r0.f35037a = r2
        L_0x022f:
            androidx.lifecycle.LiveData<java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal>> r0 = r0.f35037a
            if (r0 != 0) goto L_0x0236
            kotlin.g.b.k.a()
        L_0x0236:
            r2 = r7
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            net.one97.paytm.feed.ui.feed.FeedFragment$h r3 = new net.one97.paytm.feed.ui.feed.FeedFragment$h
            r3.<init>(r7)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
            java.lang.String r0 = B
            net.one97.paytm.feed.repository.models.Category r3 = r7.f34880f
            if (r3 == 0) goto L_0x024e
            java.lang.String r3 = r3.getDisplayName()
            goto L_0x024f
        L_0x024e:
            r3 = r1
        L_0x024f:
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x027c
            androidx.lifecycle.ai r0 = r7.c()
            net.one97.paytm.feed.ui.feed.e r0 = (net.one97.paytm.feed.ui.feed.e) r0
            android.content.Context r3 = r7.f34870c
            androidx.lifecycle.LiveData<java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal>> r4 = r0.f35038b
            if (r4 != 0) goto L_0x026b
            if (r3 == 0) goto L_0x026b
            net.one97.paytm.feed.repository.db.a r4 = net.one97.paytm.feed.repository.db.a.f34614a
            androidx.lifecycle.LiveData r3 = net.one97.paytm.feed.repository.db.a.a((android.content.Context) r3)
            r0.f35038b = r3
        L_0x026b:
            androidx.lifecycle.LiveData<java.util.List<net.one97.paytm.feed.repository.models.FeedDataMinimal>> r0 = r0.f35038b
            if (r0 != 0) goto L_0x0272
            kotlin.g.b.k.a()
        L_0x0272:
            net.one97.paytm.feed.ui.feed.FeedFragment$i r3 = new net.one97.paytm.feed.ui.feed.FeedFragment$i
            r3.<init>(r7)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r0.observe(r2, r3)
        L_0x027c:
            net.one97.paytm.feed.a.a r0 = net.one97.paytm.feed.a.a.f33785c
            r0 = r7
            net.one97.paytm.feed.a.a$a r0 = (net.one97.paytm.feed.a.a.C0555a) r0
            net.one97.paytm.feed.a.a.a((net.one97.paytm.feed.a.a.C0555a) r0)
            androidx.databinding.ViewDataBinding r0 = r7.b()
            net.one97.paytm.feed.b.u r0 = (net.one97.paytm.feed.b.u) r0
            android.widget.TextView r0 = r0.f34226c
            net.one97.paytm.feed.ui.feed.FeedFragment$j r2 = net.one97.paytm.feed.ui.feed.FeedFragment.j.f34892a
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            r7.r()
            boolean r0 = E
            if (r0 != 0) goto L_0x02b1
            java.lang.String r0 = C
            net.one97.paytm.feed.repository.models.Category r2 = r7.f34880f
            if (r2 == 0) goto L_0x02a4
            java.lang.String r1 = r2.getDisplayName()
        L_0x02a4:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x02b1
            boolean r0 = r7.j
            if (r0 == 0) goto L_0x02b1
            r7.r()
        L_0x02b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.FeedFragment.f():void");
    }

    private final void p() {
        Context context = this.f34870c;
        if (context != null) {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            if (net.one97.paytm.feed.utility.j.e(context)) {
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                if (net.one97.paytm.feed.e.b.h() != null) {
                    net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
                    net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                    net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                    String h2 = net.one97.paytm.feed.e.b.h();
                    if (h2 == null) {
                        kotlin.g.b.k.a();
                    }
                    a2.b(context, "/content-users/v1/getUserlanguage/", h2, (kotlin.g.a.b<? super FeedLanguage, x>) new f(this));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        r0 = r0.getDisplayName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r() {
        /*
            r6 = this;
            android.content.Context r0 = r6.f34870c
            if (r0 == 0) goto L_0x012e
            net.one97.paytm.feed.e.b r1 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.k()
            net.one97.paytm.feed.utility.j r1 = net.one97.paytm.feed.utility.j.f35397a
            boolean r0 = net.one97.paytm.feed.utility.j.e(r0)
            if (r0 == 0) goto L_0x011b
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.k()
            boolean r0 = r6.g()     // Catch:{ Exception -> 0x011a }
            if (r0 == 0) goto L_0x002e
            androidx.databinding.ViewDataBinding r0 = r6.b()     // Catch:{ Exception -> 0x011a }
            net.one97.paytm.feed.b.u r0 = (net.one97.paytm.feed.b.u) r0     // Catch:{ Exception -> 0x011a }
            android.widget.TextView r0 = r0.f34224a     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = "dataBinding.feedError"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x011a }
            r1 = 8
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x011a }
        L_0x002e:
            boolean r0 = r6.h()     // Catch:{ Exception -> 0x011a }
            if (r0 != 0) goto L_0x0035
            return
        L_0x0035:
            android.os.Bundle r0 = r6.getArguments()
            java.lang.String r1 = "context!!"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x00f0
            net.one97.paytm.feed.repository.models.Category r0 = r6.f34880f
            if (r0 != 0) goto L_0x0045
            goto L_0x00f0
        L_0x0045:
            r4 = 0
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r0.getDisplayName()
            if (r0 == 0) goto L_0x0059
            java.lang.String r5 = B
            boolean r0 = r0.equals(r5)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x005a
        L_0x0059:
            r0 = r4
        L_0x005a:
            if (r0 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x009b
            r6.f34878d = r3
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c     // Catch:{ Exception -> 0x0098 }
            net.one97.paytm.feed.e.b.k()     // Catch:{ Exception -> 0x0098 }
            androidx.lifecycle.ai r0 = r6.c()     // Catch:{ Exception -> 0x0098 }
            net.one97.paytm.feed.ui.feed.e r0 = (net.one97.paytm.feed.ui.feed.e) r0     // Catch:{ Exception -> 0x0098 }
            android.content.Context r3 = r6.getContext()     // Catch:{ Exception -> 0x0098 }
            if (r3 != 0) goto L_0x007b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0098 }
        L_0x007b:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x0098 }
            net.one97.paytm.feed.repository.models.Category r1 = r6.f34880f     // Catch:{ Exception -> 0x0098 }
            if (r1 != 0) goto L_0x0085
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0098 }
        L_0x0085:
            java.lang.String r1 = r1.getDisplayName()     // Catch:{ Exception -> 0x0098 }
            if (r1 != 0) goto L_0x008e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0098 }
        L_0x008e:
            net.one97.paytm.feed.b r4 = net.one97.paytm.feed.b.f33792d     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = net.one97.paytm.feed.b.i()     // Catch:{ Exception -> 0x0098 }
            r0.a(r3, r1, r2, r4)     // Catch:{ Exception -> 0x0098 }
            return
        L_0x0098:
            r6.f34878d = r2
            return
        L_0x009b:
            net.one97.paytm.feed.repository.models.Category r0 = r6.f34880f
            if (r0 == 0) goto L_0x00af
            java.lang.String r0 = r0.getDisplayName()
            if (r0 == 0) goto L_0x00af
            java.lang.String r4 = C
            boolean r0 = r0.equals(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
        L_0x00af:
            if (r4 != 0) goto L_0x00b4
            kotlin.g.b.k.a()
        L_0x00b4:
            boolean r0 = r4.booleanValue()
            if (r0 == 0) goto L_0x00ef
            net.one97.paytm.feed.e.c r0 = net.one97.paytm.feed.e.c.f34275a
            boolean r0 = net.one97.paytm.feed.e.c.j()
            if (r0 == 0) goto L_0x00ef
            boolean r0 = E     // Catch:{ Exception -> 0x00ed }
            if (r0 != 0) goto L_0x00ef
            r6.f34878d = r3     // Catch:{ Exception -> 0x00ed }
            E = r3     // Catch:{ Exception -> 0x00ed }
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c     // Catch:{ Exception -> 0x00ed }
            net.one97.paytm.feed.e.b.k()     // Catch:{ Exception -> 0x00ed }
            androidx.lifecycle.ai r0 = r6.c()     // Catch:{ Exception -> 0x00ed }
            net.one97.paytm.feed.ui.feed.e r0 = (net.one97.paytm.feed.ui.feed.e) r0     // Catch:{ Exception -> 0x00ed }
            android.content.Context r3 = r6.getContext()     // Catch:{ Exception -> 0x00ed }
            if (r3 != 0) goto L_0x00de
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00ed }
        L_0x00de:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x00ed }
            java.lang.String r1 = C     // Catch:{ Exception -> 0x00ed }
            net.one97.paytm.feed.b r4 = net.one97.paytm.feed.b.f33792d     // Catch:{ Exception -> 0x00ed }
            java.lang.String r4 = net.one97.paytm.feed.b.i()     // Catch:{ Exception -> 0x00ed }
            r0.a(r3, r1, r2, r4)     // Catch:{ Exception -> 0x00ed }
            return
        L_0x00ed:
            r6.f34878d = r2
        L_0x00ef:
            return
        L_0x00f0:
            boolean r0 = D
            if (r0 != 0) goto L_0x012e
            r6.f34878d = r3
            D = r3
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            net.one97.paytm.feed.e.b.k()
            androidx.lifecycle.ai r0 = r6.c()
            net.one97.paytm.feed.ui.feed.e r0 = (net.one97.paytm.feed.ui.feed.e) r0
            android.content.Context r3 = r6.getContext()
            if (r3 != 0) goto L_0x010c
            kotlin.g.b.k.a()
        L_0x010c:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            java.lang.String r1 = z
            net.one97.paytm.feed.b r4 = net.one97.paytm.feed.b.f33792d
            java.lang.String r4 = net.one97.paytm.feed.b.i()
            r0.a(r3, r1, r2, r4)
        L_0x011a:
            return
        L_0x011b:
            net.one97.paytm.feed.e.b r0 = net.one97.paytm.feed.e.b.f34268c
            boolean r0 = net.one97.paytm.feed.e.b.C()
            if (r0 == 0) goto L_0x012e
            net.one97.paytm.feed.repository.b r0 = net.one97.paytm.feed.repository.b.f34608a
            boolean r0 = net.one97.paytm.feed.repository.b.k()
            if (r0 != 0) goto L_0x012e
            r6.s()
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.FeedFragment.r():void");
    }

    public final void a() {
        LinearLayoutManager linearLayoutManager = this.w;
        if (linearLayoutManager == null) {
            kotlin.g.b.k.a("feedLayoutManager");
        }
        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() > 6) {
            PlayableItemsRecyclerView playableItemsRecyclerView = ((u) b()).f34231h;
            LinearLayoutManager linearLayoutManager2 = this.w;
            if (linearLayoutManager2 == null) {
                kotlin.g.b.k.a("feedLayoutManager");
            }
            playableItemsRecyclerView.smoothScrollToPosition(linearLayoutManager2.findLastVisibleItemPosition() - 4);
            new Handler().postDelayed(new l(this), 300);
            return;
        }
        LinearLayoutManager linearLayoutManager3 = this.w;
        if (linearLayoutManager3 == null) {
            kotlin.g.b.k.a("feedLayoutManager");
        }
        if (linearLayoutManager3.findFirstVisibleItemPosition() == 0) {
            ((u) b()).f34231h.scrollToPosition(0);
        } else {
            ((u) b()).f34231h.smoothScrollToPosition(0);
        }
    }

    public static final /* synthetic */ void j(FeedFragment feedFragment) {
        Context context = feedFragment.f34870c;
        if (context != null) {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            if (net.one97.paytm.feed.utility.j.e(context)) {
                ((u) feedFragment.b()).a(0);
                feedFragment.r();
                return;
            }
            Toast.makeText(context, R.string.feed_no_internet, 0).show();
        }
    }

    public static final /* synthetic */ void k(FeedFragment feedFragment) {
        u uVar = (u) feedFragment.b();
        SwipeRefreshLayout swipeRefreshLayout = uVar.f34230g;
        kotlin.g.b.k.a((Object) swipeRefreshLayout, "feedSwipeRefreshLayout");
        if (swipeRefreshLayout.f4572b) {
            SwipeRefreshLayout swipeRefreshLayout2 = uVar.f34230g;
            kotlin.g.b.k.a((Object) swipeRefreshLayout2, "feedSwipeRefreshLayout");
            swipeRefreshLayout2.setRefreshing(false);
        }
    }

    public static final /* synthetic */ void n(FeedFragment feedFragment) {
        Context context;
        if (feedFragment.isAdded() && (context = feedFragment.f34870c) != null) {
            TextView textView = ((u) feedFragment.b()).f34224a;
            textView.setVisibility(0);
            textView.setText(context.getString(R.string.feed_server_error));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, androidx.core.content.b.a(context, R.drawable.feed_no_data), (Drawable) null, (Drawable) null);
            textView.setOnClickListener(new n(context, feedFragment));
        }
    }

    public static final /* synthetic */ void o(FeedFragment feedFragment) {
        if (!feedFragment.f34878d) {
            feedFragment.f34878d = true;
            c cVar = feedFragment.v;
            if (cVar == null) {
                kotlin.g.b.k.a(FeedAdapter.TAG);
            }
            ArrayList<FeedItem> arrayList = cVar.f35011a;
            c cVar2 = feedFragment.v;
            if (cVar2 == null) {
                kotlin.g.b.k.a(FeedAdapter.TAG);
            }
            if (!(arrayList.get(cVar2.f35011a.size() - 1) instanceof FeedProgress)) {
                FeedProgress feedProgress = new FeedProgress(net.one97.paytm.feed.utility.k.PROGRESS.getType());
                feedProgress.setPid(net.one97.paytm.feed.utility.k.PROGRESS.getType());
                c cVar3 = feedFragment.v;
                if (cVar3 == null) {
                    kotlin.g.b.k.a(FeedAdapter.TAG);
                }
                kotlin.g.b.k.c(feedProgress, "feedProgress");
                cVar3.f35011a.add(feedProgress);
                cVar3.notifyItemInserted(cVar3.f35011a.size() - 1);
                Category category = feedFragment.f34880f;
                if (category != null) {
                    if (category == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!TextUtils.isEmpty(category.getId())) {
                        e eVar = (e) feedFragment.c();
                        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                        Context x2 = net.one97.paytm.feed.e.b.x();
                        Category category2 = feedFragment.f34880f;
                        if (category2 == null) {
                            kotlin.g.b.k.a();
                        }
                        String id = category2.getId();
                        if (id == null) {
                            kotlin.g.b.k.a();
                        }
                        net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                        eVar.a(x2, id, false, net.one97.paytm.feed.b.l());
                        net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
                        net.one97.paytm.feed.b.c();
                        return;
                    }
                }
                net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                String str = z;
                net.one97.paytm.feed.b bVar5 = net.one97.paytm.feed.b.f33792d;
                ((e) feedFragment.c()).a(net.one97.paytm.feed.e.b.x(), str, false, net.one97.paytm.feed.b.i());
                net.one97.paytm.feed.b bVar32 = net.one97.paytm.feed.b.f33792d;
                net.one97.paytm.feed.b.c();
                return;
            }
            return;
        }
        FragmentActivity activity = feedFragment.getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        Toast.makeText(activity, R.string.feed_request_already_in_progress, 0).show();
    }

    public static final /* synthetic */ void t(FeedFragment feedFragment) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        StringBuilder sb = new StringBuilder("package:");
        Context context = feedFragment.getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        sb.append(context.getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        Context context2 = feedFragment.getContext();
        if (context2 == null) {
            kotlin.g.b.k.a();
        }
        context2.startActivity(intent);
    }
}
