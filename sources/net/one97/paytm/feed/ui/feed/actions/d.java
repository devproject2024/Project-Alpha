package net.one97.paytm.feed.ui.feed.actions;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.s;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.FeedCommentReportTags;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.FeedPostReportTags;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import net.one97.paytm.feed.ui.feed.actions.comment.f;
import net.one97.paytm.feed.utility.j;
import net.one97.paytm.feed.utility.r;
import net.one97.paytm.feed.utility.u;

public final class d extends a<s, b> {

    /* renamed from: d  reason: collision with root package name */
    public f f34975d;

    /* renamed from: e  reason: collision with root package name */
    public c f34976e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f34977f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f34978g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CommentResponse f34979h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public FeedItem f34980i;
    private HashMap j;

    public final void f() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f34983a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f34984b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34985c;

        b(d dVar, String str, String str2) {
            this.f34983a = dVar;
            this.f34984b = str;
            this.f34985c = str2;
        }

        static final class a extends l implements kotlin.g.a.b<String, x> {
            final /* synthetic */ Context $it;
            final /* synthetic */ b this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, b bVar) {
                super(1);
                this.$it = context;
                this.this$0 = bVar;
            }

            public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return x.f47997a;
            }

            public final void invoke(String str) {
                if (str == null) {
                    Toast.makeText(this.$it, this.this$0.f34983a.getString(R.string.feed_server_error), 0).show();
                } else if (this.this$0.f34983a.f34980i != null) {
                    c d2 = this.this$0.f34983a.f34976e;
                    if (d2 != null) {
                        FeedItem c2 = this.this$0.f34983a.f34980i;
                        if (c2 == null) {
                            k.a();
                        }
                        d2.a(c2.getPid(), this.$it);
                    }
                    try {
                        net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                        String post_report = FeedEventNames.INSTANCE.getPOST_REPORT();
                        FeedItem c3 = this.this$0.f34983a.f34980i;
                        if (c3 == null) {
                            k.a();
                        }
                        net.one97.paytm.feed.events.a.a(post_report, c3, "", this.this$0.f34983a.f34978g);
                        net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                        FeedItem c4 = this.this$0.f34983a.f34980i;
                        if (c4 == null) {
                            k.a();
                        }
                        String feedItemType = c4.getFeedItemType();
                        String b2 = this.this$0.f34983a.f34978g;
                        if (b2 == null) {
                            k.a();
                        }
                        net.one97.paytm.feed.events.a.a.a("v2_feed_hide_post", feedItemType, b2, "");
                    } catch (Exception unused) {
                    }
                }
                this.this$0.f34983a.f34976e = null;
                this.this$0.f34983a.f34978g = null;
                this.this$0.f34983a.dismiss();
            }
        }

        /* renamed from: net.one97.paytm.feed.ui.feed.actions.d$b$b  reason: collision with other inner class name */
        static final class C0572b extends l implements kotlin.g.a.b<String, x> {
            final /* synthetic */ b this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0572b(b bVar) {
                super(1);
                this.this$0 = bVar;
            }

            public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return x.f47997a;
            }

            public final void invoke(String str) {
                if (str != null) {
                    f g2 = this.this$0.f34983a.f34975d;
                    if (g2 != null) {
                        CommentResponse f2 = this.this$0.f34983a.f34979h;
                        if (f2 == null) {
                            k.a();
                        }
                        g2.a(f2);
                    }
                    net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
                    FeedCommentActivity.a aVar2 = FeedCommentActivity.f34935e;
                    String j = FeedCommentActivity.r;
                    String b2 = this.this$0.f34983a.f34978g;
                    if (b2 == null) {
                        k.a();
                    }
                    net.one97.paytm.feed.events.a.a.a("v2_feed_comment_report", j, b2, "");
                }
                this.this$0.f34983a.f34975d = null;
                this.this$0.f34983a.f34978g = null;
                this.this$0.f34983a.dismiss();
            }
        }

        public final void onClick(View view) {
            Context context;
            u uVar = u.f35438a;
            if (!u.a() && (context = this.f34983a.f34931c) != null) {
                j jVar = j.f35397a;
                if (!j.e(context)) {
                    Toast.makeText(context, R.string.feed_no_internet, 0).show();
                } else if (!p.a(this.f34984b, "Comment", true)) {
                    if (this.f34983a.f34977f != null) {
                        d dVar = this.f34983a;
                        TextView a2 = dVar.f34977f;
                        if (a2 == null) {
                            k.a();
                        }
                        dVar.f34978g = a2.getText().toString();
                        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
                        net.one97.paytm.feed.repository.a.b a3 = net.one97.paytm.feed.c.a.a();
                        String str = "/content-actions/v1/actions/" + this.f34985c + "/flags";
                        String b2 = this.f34983a.f34978g;
                        if (b2 == null) {
                            k.a();
                        }
                        kotlin.g.a.b aVar2 = new a(context, this);
                        k.c(context, "context");
                        k.c(str, H5TabbarUtils.MATCH_TYPE_PATH);
                        k.c(b2, "flagString");
                        k.c(aVar2, "completionHandler");
                        net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
                        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                        String h2 = net.one97.paytm.feed.e.b.h();
                        if (h2 == null) {
                            k.a();
                        }
                        String b3 = net.one97.paytm.feed.utility.l.b(context, h2, str, (Map<String, ? extends Object>) null);
                        String str2 = net.one97.paytm.feed.repository.a.b.f34365a;
                        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                        net.one97.paytm.feed.e.b.k();
                        b.bm bmVar = new b.bm(a3, b2, b3, aVar2, context, b3, new b.bn(aVar2), new b.bo(aVar2, context));
                        bmVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(context));
                        net.one97.paytm.feed.repository.a.a a4 = net.one97.paytm.feed.repository.a.a.f34362b.a(context);
                        if (a4 != null) {
                            a4.a(bmVar);
                        }
                    }
                } else if (this.f34983a.f34977f != null) {
                    d dVar2 = this.f34983a;
                    TextView a5 = dVar2.f34977f;
                    if (a5 == null) {
                        k.a();
                    }
                    dVar2.f34978g = a5.getText().toString();
                    net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                    net.one97.paytm.feed.repository.a.b a6 = net.one97.paytm.feed.c.a.a();
                    net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                    Context x = net.one97.paytm.feed.e.b.x();
                    net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                    String h3 = net.one97.paytm.feed.e.b.h();
                    if (h3 == null) {
                        k.a();
                    }
                    CommentResponse f2 = this.f34983a.f34979h;
                    String postId = f2 != null ? f2.getPostId() : null;
                    if (postId == null) {
                        k.a();
                    }
                    CommentResponse f3 = this.f34983a.f34979h;
                    String id = f3 != null ? f3.getId() : null;
                    if (id == null) {
                        k.a();
                    }
                    String b4 = this.f34983a.f34978g;
                    if (b4 == null) {
                        k.a();
                    }
                    kotlin.g.a.b bVar5 = new C0572b(this);
                    k.c(x, "context");
                    k.c(h3, "baseURL");
                    k.c("/content-comments/v1/post/", H5TabbarUtils.MATCH_TYPE_PATH);
                    k.c(postId, "pID");
                    k.c(id, "commentID");
                    k.c(b4, "flag");
                    k.c(bVar5, "completionHandler");
                    net.one97.paytm.feed.utility.l lVar2 = net.one97.paytm.feed.utility.l.f35406a;
                    net.one97.paytm.feed.e.b bVar6 = net.one97.paytm.feed.e.b.f34268c;
                    String h4 = net.one97.paytm.feed.e.b.h();
                    if (h4 == null) {
                        k.a();
                    }
                    String b5 = net.one97.paytm.feed.utility.l.b(x, h4, "/content-comments/v1/post/" + postId + "/comment/" + id + "/flag", (Map<String, ? extends Object>) null);
                    String str3 = net.one97.paytm.feed.repository.a.b.f34365a;
                    net.one97.paytm.feed.e.b bVar7 = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.k();
                    b.h hVar = new b.h(a6, b4, b5, bVar5, x, b5, new b.i(bVar5), new b.j(bVar5, x));
                    hVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(x));
                    net.one97.paytm.feed.repository.a.a a7 = net.one97.paytm.feed.repository.a.a.f34362b.a(x);
                    if (a7 != null) {
                        a7.a(hVar);
                    }
                }
            }
        }
    }

    public final int b() {
        return R.layout.feed_feedback_action_layout;
    }

    public final HashMap<Integer, Object> c() {
        return new HashMap<>();
    }

    public final void d() {
        List<String> list;
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("Source") : null;
        if (string == null || !p.a(string, "Comment", true)) {
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            FeedPostReportTags e2 = net.one97.paytm.feed.e.b.e();
            if (e2 == null) {
                k.a();
            }
            list = e2.getTags();
        } else {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            FeedCommentReportTags f2 = net.one97.paytm.feed.e.b.f();
            if (f2 == null) {
                k.a();
            }
            list = f2.getTags();
        }
        if (p.a(string, "Comment", true)) {
            this.f34979h = arguments != null ? (CommentResponse) arguments.getParcelable(CJRQRScanResultModel.KEY_COMMENT_SMALL) : null;
        } else {
            this.f34980i = arguments != null ? (FeedItem) arguments.getParcelable("feedItem") : null;
        }
        FeedItem feedItem = this.f34980i;
        if (feedItem != null) {
            str = feedItem.getPid();
        }
        for (String text : list) {
            TextView textView = new TextView(this.f34931c);
            textView.setText(text);
            textView.setTextSize(2, 16.0f);
            textView.setTextColor(Color.parseColor("#999999"));
            r rVar = r.f35432a;
            r rVar2 = r.f35432a;
            r rVar3 = r.f35432a;
            r rVar4 = r.f35432a;
            textView.setPadding((int) r.b(16.0f, this.f34931c), (int) r.b(8.0f, this.f34931c), (int) r.b(16.0f, this.f34931c), (int) r.b(8.0f, this.f34931c));
            textView.setBackgroundResource(R.drawable.feed_feedback_label_bg);
            textView.setOnClickListener(new a(this, textView));
            ((s) a()).f34218d.addView(textView);
        }
        ((s) a()).f34220f.setOnClickListener(new b(this, string, str));
        ((s) a()).f34215a.setOnClickListener(new c(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f34986a;

        c(d dVar) {
            this.f34986a = dVar;
        }

        public final void onClick(View view) {
            this.f34986a.f34975d = null;
            this.f34986a.dismiss();
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f34981a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f34982b;

        a(d dVar, TextView textView) {
            this.f34981a = dVar;
            this.f34982b = textView;
        }

        public final void onClick(View view) {
            if (k.a((Object) this.f34981a.f34977f, (Object) view)) {
                d.b(this.f34981a, this.f34982b);
                return;
            }
            if (this.f34981a.f34977f != null) {
                d dVar = this.f34981a;
                TextView a2 = dVar.f34977f;
                if (a2 != null) {
                    d.b(dVar, a2);
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                }
            }
            this.f34982b.setTextColor(Color.parseColor("#ffffff"));
            this.f34982b.setBackgroundResource(R.drawable.feed_feedback_selector_bg);
            d dVar2 = this.f34981a;
            if (view != null) {
                dVar2.f34977f = (TextView) view;
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        c cVar = this.f34976e;
        if (cVar != null) {
            cVar.a();
        }
        f fVar = this.f34975d;
        if (fVar != null) {
            fVar.a();
        }
        super.onDismiss(dialogInterface);
        this.f34975d = null;
        this.f34976e = null;
    }

    public static final /* synthetic */ void b(d dVar, TextView textView) {
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setBackgroundResource(R.drawable.feed_feedback_label_bg);
        dVar.f34977f = null;
    }
}
