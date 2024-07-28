package net.one97.paytm.feed.ui.feed.actions.comment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.appsflyer.share.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.k;
import net.one97.paytm.feed.d;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.progress.FeedProgress;
import net.one97.paytm.feed.ui.base.FeedBaseActivity;
import net.one97.paytm.feed.ui.feed.actions.comment.c;

public final class FeedCommentActivity extends FeedBaseActivity<k, c> implements e {

    /* renamed from: e  reason: collision with root package name */
    public static final a f34935e = new a((byte) 0);
    /* access modifiers changed from: private */
    public static boolean p;
    /* access modifiers changed from: private */
    public static boolean q;
    /* access modifiers changed from: private */
    public static String r = "";
    private static boolean s;

    /* renamed from: c  reason: collision with root package name */
    boolean f34936c;

    /* renamed from: d  reason: collision with root package name */
    boolean f34937d;

    /* renamed from: f  reason: collision with root package name */
    private k f34938f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public d f34939g;

    /* renamed from: h  reason: collision with root package name */
    private FeedItem f34940h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f34941i;
    private String j;
    private boolean k;
    private boolean l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public int o;

    static final class b<T> implements io.reactivex.rxjava3.d.g<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34942a;

        b(FeedCommentActivity feedCommentActivity) {
            this.f34942a = feedCommentActivity;
        }

        static final class a<T> implements z<FeedDataMinimal> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f34943a;

            a(b bVar) {
                this.f34943a = bVar;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                FeedDataMinimal feedDataMinimal = (FeedDataMinimal) obj;
                if (feedDataMinimal != null) {
                    net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
                    FeedItem a2 = net.one97.paytm.feed.repository.db.b.a(feedDataMinimal);
                    if (a2 != null) {
                        FeedCommentActivity.e(this.f34943a.f34942a).f34961b = a2;
                        d a3 = this.f34943a.f34942a.f34939g;
                        if (a3 != null) {
                            kotlin.g.b.k.c(a2, "feedItem");
                            if (a3.f34967a.size() == 0) {
                                a3.f34967a.add(a2);
                                ArrayList<FeedItem> arrayList = a3.f34967a;
                                net.one97.paytm.feed.repository.a aVar = net.one97.paytm.feed.repository.a.f34359b;
                                arrayList.addAll(net.one97.paytm.feed.repository.a.a());
                                a3.notifyDataSetChanged();
                            } else {
                                a3.f34967a.set(0, a2);
                                a3.notifyItemChanged(0);
                            }
                        }
                        if (!this.f34943a.f34942a.m && this.f34943a.f34942a.n && kotlin.g.b.k.a((Object) a2.getFeedItemType(), (Object) net.one97.paytm.feed.utility.k.NEWS.getType())) {
                            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
                            net.one97.paytm.feed.utility.j.e(this.f34943a.f34942a);
                            this.f34943a.f34942a.m = true;
                        }
                    }
                }
            }
        }

        public final /* synthetic */ void accept(Object obj) {
            Integer num = (Integer) obj;
            d a2 = this.f34942a.f34939g;
            if (a2 != null && a2.f34967a.size() > 0 && (a2.f34967a.get(a2.f34967a.size() - 1) instanceof FeedProgress)) {
                a2.f34967a.remove(a2.f34967a.get(a2.f34967a.size() - 1));
                a2.notifyItemRemoved(a2.f34967a.size() - 1);
            }
            d.a aVar = net.one97.paytm.feed.d.f34256a;
            int a3 = net.one97.paytm.feed.d.f34257b;
            if (num == null || num.intValue() != a3) {
                d.a aVar2 = net.one97.paytm.feed.d.f34256a;
                int e2 = net.one97.paytm.feed.d.f34261f;
                if (num != null && num.intValue() == e2) {
                    this.f34942a.g();
                    String c2 = this.f34942a.f34941i;
                    if (c2 != null) {
                        this.f34942a.n = p.a(c2.subSequence(0, 3), 'o', true);
                        if (c2 != null) {
                            FeedCommentActivity.e(this.f34942a).a(this.f34942a, p.a((CharSequence) c2, 0, 3).toString()).observe(this.f34942a, new a(this));
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                } else {
                    d.a aVar3 = net.one97.paytm.feed.d.f34256a;
                    int c3 = net.one97.paytm.feed.d.f34259d;
                    if (num != null && num.intValue() == c3) {
                        this.f34942a.g();
                        FeedCommentActivity feedCommentActivity = this.f34942a;
                        feedCommentActivity.f34936c = true;
                        if (feedCommentActivity == null) {
                            kotlin.g.b.k.a();
                        }
                        Toast.makeText(feedCommentActivity, R.string.feed_no_comment_available, 0).show();
                    } else {
                        d.a aVar4 = net.one97.paytm.feed.d.f34256a;
                        int d2 = net.one97.paytm.feed.d.f34260e;
                        if (num != null && num.intValue() == d2) {
                            this.f34942a.g();
                            Toast.makeText(this.f34942a, R.string.feed_server_error, 0).show();
                        }
                    }
                }
            }
            this.f34942a.f34937d = false;
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34949a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CommentResponse f34950b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f34951c;

        g(FeedCommentActivity feedCommentActivity, CommentResponse commentResponse, int i2) {
            this.f34949a = feedCommentActivity;
            this.f34950b = commentResponse;
            this.f34951c = i2;
        }

        static final class a extends l implements kotlin.g.a.b<String, x> {
            final /* synthetic */ String $textToUpdate;
            final /* synthetic */ View $view$inlined;
            final /* synthetic */ g this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, g gVar, View view) {
                super(1);
                this.$textToUpdate = str;
                this.this$0 = gVar;
                this.$view$inlined = view;
            }

            public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return x.f47997a;
            }

            public final void invoke(String str) {
                if (str != null) {
                    FeedCommentActivity.j(this.this$0.f34949a);
                    this.this$0.f34950b.setText(str);
                    this.this$0.f34949a.m();
                    d a2 = this.this$0.f34949a.f34939g;
                    if (a2 != null) {
                        a2.notifyItemChanged(this.this$0.f34951c);
                        return;
                    }
                    return;
                }
                FeedCommentActivity.k(this.this$0.f34949a).f34183c.setText(this.$textToUpdate);
                this.this$0.f34949a.k();
                Toast.makeText(this.this$0.f34949a, R.string.feed_server_error, 0).show();
            }
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            kotlin.g.b.k.a((Object) view, "view");
            Context context = view.getContext();
            kotlin.g.b.k.a((Object) context, "view.context");
            if (!net.one97.paytm.feed.utility.j.e(context)) {
                Toast.makeText(view.getContext(), R.string.feed_no_internet, 0).show();
            } else if (this.f34950b != null) {
                this.f34949a.l();
                EditText editText = FeedCommentActivity.k(this.f34949a).f34183c;
                kotlin.g.b.k.a((Object) editText, "containerBinding.feedCommentEdittext");
                String obj = editText.getText().toString();
                if (obj == null) {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                } else if (!TextUtils.isEmpty(p.b(obj).toString())) {
                    net.one97.paytm.feed.utility.u uVar = net.one97.paytm.feed.utility.u.f35438a;
                    if (!net.one97.paytm.feed.utility.u.a()) {
                        EditText editText2 = FeedCommentActivity.k(this.f34949a).f34183c;
                        kotlin.g.b.k.a((Object) editText2, "containerBinding.feedCommentEdittext");
                        Context context2 = view.getContext();
                        kotlin.g.b.k.a((Object) context2, "view.context");
                        editText2.setText(FeedCommentActivity.a(obj, context2));
                        c e2 = FeedCommentActivity.e(this.f34949a);
                        Context context3 = this.f34949a;
                        String postId = this.f34950b.getPostId();
                        String id = this.f34950b.getId();
                        kotlin.g.a.b aVar = new a(obj, this, view);
                        kotlin.g.b.k.c(context3, "context");
                        kotlin.g.b.k.c(postId, "pID");
                        kotlin.g.b.k.c(id, "commentID");
                        kotlin.g.b.k.c(obj, "toString");
                        kotlin.g.b.k.c(aVar, "completionHandler");
                        net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
                        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                        String h2 = net.one97.paytm.feed.e.b.h();
                        if (h2 == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.a.b dVar = new c.d(e2, aVar, obj);
                        kotlin.g.b.k.c(context3, "context");
                        kotlin.g.b.k.c(h2, "baseURL");
                        kotlin.g.b.k.c("/content-comments/v1/post/", H5TabbarUtils.MATCH_TYPE_PATH);
                        kotlin.g.b.k.c(postId, "pID");
                        kotlin.g.b.k.c(id, "commentID");
                        kotlin.g.b.k.c(obj, "flagString");
                        kotlin.g.b.k.c(dVar, "completionHandler");
                        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
                        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                        String h3 = net.one97.paytm.feed.e.b.h();
                        if (h3 == null) {
                            kotlin.g.b.k.a();
                        }
                        String b2 = net.one97.paytm.feed.utility.l.b(context3, h3, "/content-comments/v1/post/" + postId + "/comment/" + id, (Map<String, ? extends Object>) null);
                        String str = net.one97.paytm.feed.repository.a.b.f34365a;
                        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                        net.one97.paytm.feed.e.b.k();
                        b.k kVar = new b.k(a2, postId, obj, b2, dVar, context3, b2, new b.l(dVar), new b.m(dVar, context3));
                        kVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(context3));
                        net.one97.paytm.feed.repository.a.a a3 = net.one97.paytm.feed.repository.a.a.f34362b.a(context3);
                        if (a3 != null) {
                            a3.a(kVar);
                        }
                    }
                } else {
                    this.f34949a.k();
                    Toast.makeText(this.f34949a, R.string.feed_comment_empty, 0).show();
                }
            }
        }
    }

    static final class d<T> implements z<FeedDataMinimal> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34946a;

        d(FeedCommentActivity feedCommentActivity) {
            this.f34946a = feedCommentActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            d a2;
            FeedDataMinimal feedDataMinimal = (FeedDataMinimal) obj;
            if (feedDataMinimal != null) {
                net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
                FeedItem a3 = net.one97.paytm.feed.repository.db.b.a(feedDataMinimal);
                if (a3 != null && (a2 = this.f34946a.f34939g) != null) {
                    a2.a(a3);
                }
            }
        }
    }

    static final class e<T> implements z<FeedDataMinimal> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34947a;

        e(FeedCommentActivity feedCommentActivity) {
            this.f34947a = feedCommentActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            d a2;
            FeedDataMinimal feedDataMinimal = (FeedDataMinimal) obj;
            if (feedDataMinimal != null) {
                net.one97.paytm.feed.repository.db.b bVar = net.one97.paytm.feed.repository.db.b.f34805a;
                FeedItem a3 = net.one97.paytm.feed.repository.db.b.a(feedDataMinimal);
                if (a3 != null && (a2 = this.f34947a.f34939g) != null) {
                    a2.a(a3);
                }
            }
        }
    }

    static final class j<T> implements io.reactivex.rxjava3.d.g<ArrayList<CommentResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34954a;

        j(FeedCommentActivity feedCommentActivity) {
            this.f34954a = feedCommentActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            d a2 = this.f34954a.f34939g;
            if (a2 != null) {
                kotlin.g.b.k.a((Object) arrayList, "s");
                kotlin.g.b.k.c(arrayList, "data");
                a2.f34967a.addAll(arrayList);
                a2.notifyItemRangeInserted(a2.f34967a.size() - arrayList.size(), a2.f34967a.size());
            }
        }
    }

    public static final /* synthetic */ c e(FeedCommentActivity feedCommentActivity) {
        return (c) feedCommentActivity.b();
    }

    public static final /* synthetic */ k k(FeedCommentActivity feedCommentActivity) {
        k kVar = feedCommentActivity.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        return kVar;
    }

    private final void a(String str) {
        c cVar = (c) b();
        Context context = this;
        FeedItem feedItem = ((c) b()).f34961b;
        if (feedItem == null) {
            kotlin.g.b.k.a();
        }
        String pid = feedItem.getPid();
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(pid, "pID");
        kotlin.g.b.k.c(str, "commentID");
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
        String str2 = "/content-comments/v1/post/" + pid + "/comment";
        kotlin.g.a.b aVar2 = new c.a(cVar, pid, str);
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str2, H5TabbarUtils.MATCH_TYPE_PATH);
        kotlin.g.b.k.c(str, "commentID");
        kotlin.g.b.k.c(aVar2, "completionHandler");
        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        String h2 = net.one97.paytm.feed.e.b.h();
        if (h2 == null) {
            kotlin.g.b.k.a();
        }
        String b2 = net.one97.paytm.feed.utility.l.b(context, h2, str2, ae.a(new o("fromId", str)));
        String str3 = net.one97.paytm.feed.repository.a.b.f34365a;
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        b.w wVar = new b.w(a2, b2, aVar2, context, b2, new b.x(aVar2), new b.y(aVar2, context));
        wVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(context));
        net.one97.paytm.feed.repository.a.a a3 = net.one97.paytm.feed.repository.a.a.f34362b.a(context);
        if (a3 != null) {
            a3.a(wVar);
        }
    }

    public final int c() {
        return R.layout.feed_comment;
    }

    public final HashMap<Integer, Object> d() {
        return new HashMap<>();
    }

    public final void e() {
        Window window = getWindow();
        kotlin.g.b.k.a((Object) window, "window");
        View decorView = window.getDecorView();
        kotlin.g.b.k.a((Object) decorView, "window.decorView");
        decorView.setSystemUiVisibility(TarConstants.EOF_BLOCK);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window2 = getWindow();
            kotlin.g.b.k.a((Object) window2, "window");
            window2.setStatusBarColor(0);
        }
        p = true;
        this.f34940h = (FeedItem) getIntent().getParcelableExtra("data");
        this.k = getIntent().getBooleanExtra("fromFullVideoScreen", false);
        this.l = getIntent().getBooleanExtra("requestFocus", false);
        ViewDataBinding a2 = androidx.databinding.f.a(this, R.layout.feed_comment);
        kotlin.g.b.k.a((Object) a2, "DataBindingUtil.setConte…View(this, getLayoutId())");
        this.f34938f = (k) a2;
        k kVar = this.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        kVar.setVariable(net.one97.paytm.feed.a.s, b());
        e eVar = this;
        kVar.setVariable(net.one97.paytm.feed.a.H, new g(eVar));
        if (this.l) {
            kVar.f34183c.requestFocus();
        }
        k kVar2 = this.f34938f;
        if (kVar2 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        RecyclerView recyclerView = kVar2.f34181a;
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator((RecyclerView.f) null);
        Context context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.f34939g = new d(this.f34940h);
        d dVar = this.f34939g;
        if (dVar == null) {
            kotlin.g.b.k.a();
        }
        dVar.setHasStableIds(true);
        recyclerView.setAdapter(this.f34939g);
        d dVar2 = this.f34939g;
        if (dVar2 == null) {
            kotlin.g.b.k.a();
        }
        dVar2.a(eVar);
        ((c) b()).f34963d.subscribe(new b(this));
        ((c) b()).f34962c.subscribe(new j(this));
        b();
        new Handler().postDelayed(new i(this), 2000);
        if (this.f34940h != null) {
            FeedItem feedItem = this.f34940h;
            ((c) b()).f34961b = feedItem;
            if (feedItem == null) {
                kotlin.g.b.k.a();
            }
            r = feedItem.getFeedItemType();
            a("");
            FeedItem feedItem2 = this.f34940h;
            if (feedItem2 != null) {
                this.j = ((FeedGeneric) feedItem2).getFeedGenericData().getId();
                c cVar = (c) b();
                String str = this.j;
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                LiveData<FeedDataMinimal> a3 = cVar.a(context, str);
                q qVar = this;
                a3.observe(qVar, new d(this));
                c cVar2 = (c) b();
                String str2 = this.j;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.c(context, "context");
                kotlin.g.b.k.c(str2, Constants.URL_MEDIA_SOURCE);
                if (cVar2.f34960a == null) {
                    net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                    cVar2.f34960a = net.one97.paytm.feed.repository.db.a.h(context, str2);
                }
                LiveData<FeedDataMinimal> liveData = cVar2.f34960a;
                if (liveData == null) {
                    kotlin.g.b.k.a();
                }
                liveData.observe(qVar, new e(this));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
        }
        k kVar3 = this.f34938f;
        if (kVar3 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        ProgressBar progressBar = kVar3.f34187g;
        kotlin.g.b.k.a((Object) progressBar, "containerBinding.feedLoadingProgress");
        progressBar.setVisibility(0);
        q = true;
        String stringExtra = getIntent().getStringExtra("deepLink");
        kotlin.g.b.k.a((Object) stringExtra, "deeplink");
        List b2 = p.a((CharSequence) stringExtra, new String[]{"/"});
        this.f34941i = (String) b2.get(b2.size() - 1);
        String str3 = this.f34941i;
        if (str3 != null) {
            if (str3 != null) {
                String obj = p.a((CharSequence) str3, 0, 3).toString();
                kotlin.g.b.k.c(context, "context");
                kotlin.g.b.k.c(obj, "id");
                net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a4 = net.one97.paytm.feed.c.a.a();
                kotlin.g.a.b bVar = new c.b((c) b());
                kotlin.g.b.k.c(context, "context");
                kotlin.g.b.k.c(obj, "id");
                kotlin.g.b.k.c(bVar, "completionHandler");
                net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
                net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                String h2 = net.one97.paytm.feed.e.b.h();
                if (h2 == null) {
                    kotlin.g.b.k.a();
                }
                String b3 = net.one97.paytm.feed.utility.l.b(context, h2, "/content-feed/v2/posts/".concat(String.valueOf(obj)), (Map<String, ? extends Object>) null);
                String str4 = net.one97.paytm.feed.repository.a.b.f34365a;
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                Context context2 = context;
                b.ai aiVar = new b.ai(a4, b3, context, bVar, b3, new b.aj(context, bVar), new b.ak(bVar, context));
                aiVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(context2));
                net.one97.paytm.feed.repository.a.a a5 = net.one97.paytm.feed.repository.a.a.f34362b.a(context2);
                if (a5 != null) {
                    a5.a(aiVar);
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        s = true;
    }

    static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34953a;

        i(FeedCommentActivity feedCommentActivity) {
            this.f34953a = feedCommentActivity;
        }

        public final void run() {
            FeedCommentActivity.b(this.f34953a);
        }
    }

    public static final class c extends net.one97.paytm.feed.ui.feed.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f34944a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34945b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar, LinearLayoutManager linearLayoutManager, FeedCommentActivity feedCommentActivity) {
            super(linearLayoutManager, 10);
            this.f34944a = kVar;
            this.f34945b = feedCommentActivity;
        }

        public final boolean a() {
            return this.f34945b.f34936c;
        }

        public final boolean b() {
            return this.f34945b.f34937d;
        }

        public final void a(int i2, int i3) {
            FeedCommentActivity.h(this.f34945b);
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            kotlin.g.b.k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            this.f34945b.o = i2;
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34948a;

        f(FeedCommentActivity feedCommentActivity) {
            this.f34948a = feedCommentActivity;
        }

        public final void onClick(View view) {
            this.f34948a.l();
            FeedCommentActivity.j(this.f34948a);
            EditText editText = FeedCommentActivity.k(this.f34948a).f34183c;
            kotlin.g.b.k.a((Object) editText, "containerBinding.feedCommentEdittext");
            editText.getText().clear();
        }
    }

    /* access modifiers changed from: private */
    public final void k() {
        k kVar = this.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        TextView textView = kVar.f34182b;
        kotlin.g.b.k.a((Object) textView, "containerBinding.feedCommentCancel");
        textView.setVisibility(0);
        k kVar2 = this.f34938f;
        if (kVar2 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        TextView textView2 = kVar2.f34186f;
        kotlin.g.b.k.a((Object) textView2, "containerBinding.feedCommentUpdate");
        textView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void l() {
        k kVar = this.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        TextView textView = kVar.f34182b;
        kotlin.g.b.k.a((Object) textView, "containerBinding.feedCommentCancel");
        textView.setVisibility(8);
        k kVar2 = this.f34938f;
        if (kVar2 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        TextView textView2 = kVar2.f34186f;
        kotlin.g.b.k.a((Object) textView2, "containerBinding.feedCommentUpdate");
        textView2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void m() {
        k kVar = this.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        EditText editText = kVar.f34183c;
        kotlin.g.b.k.a((Object) editText, "containerBinding.feedCommentEdittext");
        editText.getText().clear();
        l();
        net.one97.paytm.feed.utility.g gVar = net.one97.paytm.feed.utility.g.f35396a;
        net.one97.paytm.feed.utility.g.a(this);
    }

    public final void a(CommentResponse commentResponse, int i2) {
        d dVar = this.f34939g;
        if (dVar != null) {
            dVar.a(commentResponse, i2);
        }
        FeedItem feedItem = this.f34940h;
        if (feedItem != null) {
            net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a.a(FeedEventNames.INSTANCE.getCOMMENT_DELETED(), feedItem, commentResponse != null ? commentResponse.getText() : null, "");
        }
    }

    public final void b(CommentResponse commentResponse, int i2) {
        kotlin.g.b.k.c(commentResponse, CJRQRScanResultModel.KEY_COMMENT_SMALL);
        d dVar = this.f34939g;
        if (dVar != null) {
            dVar.a(commentResponse, i2);
        }
    }

    public final void a(CommentResponse commentResponse) {
        if (commentResponse != null) {
            d dVar = this.f34939g;
            if (dVar != null) {
                dVar.f34967a.add(1, commentResponse);
                dVar.notifyItemInserted(1);
                if (dVar.f34967a.size() >= 2) {
                    dVar.notifyItemRangeChanged(2, dVar.f34967a.size());
                }
            }
            m();
            k kVar = this.f34938f;
            if (kVar == null) {
                kotlin.g.b.k.a("containerBinding");
            }
            RecyclerView recyclerView = kVar.f34181a;
            kotlin.g.b.k.a((Object) recyclerView, "containerBinding.commentsRecyclerview");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                if (linearLayoutManager.findLastVisibleItemPosition() > 6) {
                    k kVar2 = this.f34938f;
                    if (kVar2 == null) {
                        kotlin.g.b.k.a("containerBinding");
                    }
                    kVar2.f34181a.smoothScrollToPosition(linearLayoutManager.findLastVisibleItemPosition() - 4);
                    new Handler().postDelayed(new h(this), 300);
                } else if (linearLayoutManager.findFirstVisibleItemPosition() != 0) {
                    k kVar3 = this.f34938f;
                    if (kVar3 == null) {
                        kotlin.g.b.k.a("containerBinding");
                    }
                    kVar3.f34181a.smoothScrollToPosition(1);
                }
            } else {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        }
    }

    static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FeedCommentActivity f34952a;

        h(FeedCommentActivity feedCommentActivity) {
            this.f34952a = feedCommentActivity;
        }

        public final void run() {
            FeedCommentActivity.k(this.f34952a).f34181a.scrollToPosition(1);
        }
    }

    public final void onStart() {
        super.onStart();
        d dVar = this.f34939g;
        if (dVar != null) {
            dVar.a((e) this);
        }
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.b(0);
    }

    public final void onStop() {
        super.onStop();
        d dVar = this.f34939g;
        if (dVar != null) {
            dVar.a((e) null);
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        net.one97.paytm.feed.repository.a aVar = net.one97.paytm.feed.repository.a.f34359b;
        net.one97.paytm.feed.repository.a.a((ArrayList<CommentResponse>) new ArrayList());
        p = false;
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.b(-1);
    }

    public final void onResume() {
        super.onResume();
        p = true;
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.p()) {
            net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a.b(System.currentTimeMillis());
            net.one97.paytm.feed.events.a aVar2 = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.a.a(net.one97.paytm.feed.events.a.e());
            net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
            long c2 = net.one97.paytm.feed.events.f.c();
            net.one97.paytm.feed.events.a aVar4 = net.one97.paytm.feed.events.a.f34284a;
            long d2 = net.one97.paytm.feed.events.a.d();
            net.one97.paytm.feed.events.a aVar5 = net.one97.paytm.feed.events.a.f34284a;
            net.one97.paytm.feed.events.f.c(c2 + (d2 - net.one97.paytm.feed.events.a.c()));
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.b(false);
        }
    }

    public final void onPause() {
        super.onPause();
        p = false;
        net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
        net.one97.paytm.feed.events.a.a((Context) this);
    }

    public final void f() {
        l();
        k kVar = this.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        EditText editText = kVar.f34183c;
        kotlin.g.b.k.a((Object) editText, "containerBinding.feedCommentEdittext");
        editText.getText().clear();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, FeedItem feedItem, boolean z) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(feedItem, "feed");
            Intent intent = new Intent(context, FeedCommentActivity.class);
            intent.putExtra("data", feedItem);
            intent.putExtra("fromFullVideoScreen", false);
            intent.putExtra("requestFocus", z);
            context.startActivity(intent);
        }
    }

    public final void g() {
        k kVar = this.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        ProgressBar progressBar = kVar.f34187g;
        kotlin.g.b.k.a((Object) progressBar, "containerBinding.feedLoadingProgress");
        progressBar.setVisibility(8);
    }

    public final void a(i iVar, int i2) {
        CommentResponse commentResponse;
        String str = null;
        if (iVar != null) {
            commentResponse = iVar.f34974f;
        } else {
            commentResponse = null;
        }
        k kVar = this.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        EditText editText = kVar.f34183c;
        if (commentResponse != null) {
            str = commentResponse.getText();
        }
        editText.setText(str);
        kotlin.g.b.k.a((Object) editText, "this");
        editText.setSelection(editText.getText().length());
        k();
        k kVar2 = this.f34938f;
        if (kVar2 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        ImageView imageView = kVar2.f34185e;
        kotlin.g.b.k.a((Object) imageView, "containerBinding.feedCommentSend");
        imageView.setVisibility(8);
        k kVar3 = this.f34938f;
        if (kVar3 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        kVar3.f34182b.setOnClickListener(new f(this));
        k kVar4 = this.f34938f;
        if (kVar4 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        kVar4.f34186f.setOnClickListener(new g(this, commentResponse, i2));
        k kVar5 = this.f34938f;
        if (kVar5 == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        kVar5.f34183c.requestFocus();
    }

    public static final /* synthetic */ void b(FeedCommentActivity feedCommentActivity) {
        k kVar = feedCommentActivity.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        RecyclerView recyclerView = kVar.f34181a;
        if (recyclerView != null) {
            RecyclerView recyclerView2 = kVar.f34181a;
            kotlin.g.b.k.a((Object) recyclerView2, "commentsRecyclerview");
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager != null) {
                recyclerView.addOnScrollListener(new c(kVar, (LinearLayoutManager) layoutManager, feedCommentActivity));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    public static final /* synthetic */ void h(FeedCommentActivity feedCommentActivity) {
        d dVar = feedCommentActivity.f34939g;
        if (dVar == null) {
            kotlin.g.b.k.a();
        }
        String str = "";
        if (dVar.f34967a.size() > 1) {
            d dVar2 = feedCommentActivity.f34939g;
            if (dVar2 == null) {
                kotlin.g.b.k.a();
            }
            int size = dVar2.f34967a.size() - 1;
            d dVar3 = feedCommentActivity.f34939g;
            if (dVar3 == null) {
                kotlin.g.b.k.a();
            }
            if (dVar3.f34967a.get(size) instanceof CommentResponse) {
                d dVar4 = feedCommentActivity.f34939g;
                if (dVar4 == null) {
                    kotlin.g.b.k.a();
                }
                FeedItem feedItem = dVar4.f34967a.get(size);
                if (feedItem != null) {
                    str = ((CommentResponse) feedItem).getId();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.comment.CommentResponse");
                }
            }
        }
        if (!TextUtils.isEmpty(str) && !feedCommentActivity.f34937d) {
            feedCommentActivity.f34937d = true;
            FeedProgress feedProgress = new FeedProgress(net.one97.paytm.feed.utility.k.PROGRESS.getType());
            d dVar5 = feedCommentActivity.f34939g;
            if (dVar5 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.c(feedProgress, "feedProgress");
            dVar5.f34967a.add(feedProgress);
            dVar5.notifyItemInserted(dVar5.f34967a.size() - 1);
            feedCommentActivity.a(str);
        }
    }

    public static final /* synthetic */ void j(FeedCommentActivity feedCommentActivity) {
        k kVar = feedCommentActivity.f34938f;
        if (kVar == null) {
            kotlin.g.b.k.a("containerBinding");
        }
        ImageView imageView = kVar.f34185e;
        kotlin.g.b.k.a((Object) imageView, "containerBinding.feedCommentSend");
        imageView.setVisibility(0);
    }

    public static final /* synthetic */ SpannableStringBuilder a(String str, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + context.getString(R.string.feed_comment_updating));
        spannableStringBuilder.setSpan(new TypefaceSpan("sans-serif"), str.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.feed_colorAccent)), str.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.feed_comment_posting_size), true), str.length(), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}
