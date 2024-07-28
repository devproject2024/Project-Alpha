package net.one97.paytm.feed.ui.feed.actions.comment;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.appsflyer.share.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.feed.d;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.repository.models.FeedDataMinimal;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.repository.models.comment.CreatedBy;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;

public final class c extends net.one97.paytm.feed.ui.feed.d {

    /* renamed from: a  reason: collision with root package name */
    LiveData<FeedDataMinimal> f34960a;

    /* renamed from: b  reason: collision with root package name */
    public FeedItem f34961b;

    /* renamed from: c  reason: collision with root package name */
    io.reactivex.rxjava3.j.b<ArrayList<CommentResponse>> f34962c;

    /* renamed from: d  reason: collision with root package name */
    io.reactivex.rxjava3.j.b<Integer> f34963d;

    /* renamed from: e  reason: collision with root package name */
    public String f34964e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f34965f;

    /* renamed from: g  reason: collision with root package name */
    private LiveData<FeedDataMinimal> f34966g;

    static final class a extends l implements kotlin.g.a.b<List<? extends CommentResponse>, x> {
        final /* synthetic */ String $commentID;
        final /* synthetic */ String $pID;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, String str, String str2) {
            super(1);
            this.this$0 = cVar;
            this.$pID = str;
            this.$commentID = str2;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<CommentResponse>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<CommentResponse> list) {
            if (list != null && (!list.isEmpty())) {
                net.one97.paytm.feed.repository.a aVar = net.one97.paytm.feed.repository.a.f34359b;
                ArrayList<CommentResponse> a2 = net.one97.paytm.feed.repository.a.a(this.$pID, (ArrayList) list, TextUtils.isEmpty(this.$commentID));
                io.reactivex.rxjava3.j.b<Integer> bVar = this.this$0.f34963d;
                d.a aVar2 = net.one97.paytm.feed.d.f34256a;
                bVar.onNext(Integer.valueOf(net.one97.paytm.feed.d.f34257b));
                this.this$0.f34962c.onNext(a2);
            } else if (list == null || !list.isEmpty()) {
                io.reactivex.rxjava3.j.b<Integer> bVar2 = this.this$0.f34963d;
                d.a aVar3 = net.one97.paytm.feed.d.f34256a;
                bVar2.onNext(Integer.valueOf(net.one97.paytm.feed.d.f34260e));
            } else {
                io.reactivex.rxjava3.j.b<Integer> bVar3 = this.this$0.f34963d;
                d.a aVar4 = net.one97.paytm.feed.d.f34256a;
                bVar3.onNext(Integer.valueOf(net.one97.paytm.feed.d.f34259d));
            }
        }
    }

    static final class b extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            boolean z = true;
            if (str != null) {
                if (str.length() > 0) {
                    io.reactivex.rxjava3.j.b<Integer> bVar = this.this$0.f34963d;
                    d.a aVar = net.one97.paytm.feed.d.f34256a;
                    bVar.onNext(Integer.valueOf(net.one97.paytm.feed.d.f34261f));
                    return;
                }
            }
            if (str != null) {
                if (str.length() != 0) {
                    z = false;
                }
                if (z) {
                    io.reactivex.rxjava3.j.b<Integer> bVar2 = this.this$0.f34963d;
                    d.a aVar2 = net.one97.paytm.feed.d.f34256a;
                    bVar2.onNext(Integer.valueOf(net.one97.paytm.feed.d.f34259d));
                    return;
                }
            }
            io.reactivex.rxjava3.j.b<Integer> bVar3 = this.this$0.f34963d;
            d.a aVar3 = net.one97.paytm.feed.d.f34256a;
            bVar3.onNext(Integer.valueOf(net.one97.paytm.feed.d.f34260e));
        }
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.actions.comment.c$c  reason: collision with other inner class name */
    public static final class C0571c extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ String $comment$inlined;
        final /* synthetic */ kotlin.g.a.b $completionHandler$inlined;
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0571c(c cVar, Context context, String str, kotlin.g.a.b bVar) {
            super(1);
            this.this$0 = cVar;
            this.$context$inlined = context;
            this.$comment$inlined = str;
            this.$completionHandler$inlined = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            String str2;
            String str3 = null;
            if (str != null) {
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date());
                k.a((Object) format, "createdAt");
                String str4 = this.$comment$inlined;
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                String i2 = net.one97.paytm.feed.e.c.i();
                if (i2 == null) {
                    k.a();
                }
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String i3 = net.one97.paytm.feed.e.c.i();
                if (i3 == null) {
                    k.a();
                }
                net.one97.paytm.feed.e.c cVar3 = net.one97.paytm.feed.e.c.f34275a;
                String b2 = net.one97.paytm.feed.e.c.b();
                net.one97.paytm.feed.e.c cVar4 = net.one97.paytm.feed.e.c.f34275a;
                CreatedBy createdBy = new CreatedBy(i3, b2, net.one97.paytm.feed.e.c.a());
                Boolean bool = Boolean.FALSE;
                FeedItem feedItem = this.this$0.f34961b;
                if (feedItem != null) {
                    str3 = feedItem.getPid();
                }
                String str5 = str3;
                if (str5 == null) {
                    k.a();
                }
                CommentResponse commentResponse = new CommentResponse(format, createdBy, false, 0, str, "UNMODERATED", str5, str4, "", i2, bool);
                commentResponse.setFeedItemType(net.one97.paytm.feed.utility.k.COMMENTS.name());
                net.one97.paytm.feed.repository.a aVar = net.one97.paytm.feed.repository.a.f34359b;
                net.one97.paytm.feed.repository.a.a(commentResponse.getPostId(), commentResponse);
                this.$completionHandler$inlined.invoke(commentResponse);
                if (this.this$0.f34961b instanceof FeedGeneric) {
                    FeedItem feedItem2 = this.this$0.f34961b;
                    if (feedItem2 != null) {
                        str2 = ((FeedGeneric) feedItem2).getFeedGenericData().getId();
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                    }
                } else {
                    str2 = "";
                }
                net.one97.paytm.feed.repository.db.a aVar2 = net.one97.paytm.feed.repository.db.a.f34614a;
                net.one97.paytm.feed.repository.db.a.a(this.$context$inlined, str2, true);
                net.one97.paytm.feed.events.a aVar3 = net.one97.paytm.feed.events.a.f34284a;
                String comment_ed = FeedEventNames.INSTANCE.getCOMMENT_ED();
                FeedItem feedItem3 = this.this$0.f34961b;
                if (feedItem3 == null) {
                    k.a();
                }
                net.one97.paytm.feed.events.a.a(comment_ed, feedItem3, commentResponse.getText(), "");
                FeedItem feedItem4 = this.this$0.f34961b;
                if (feedItem4 != null) {
                    net.one97.paytm.feed.events.a.a aVar4 = net.one97.paytm.feed.events.a.a.f34296a;
                    net.one97.paytm.feed.events.a.a.a("v2_feed_comment_post", feedItem4.getFeedItemType());
                    return;
                }
                return;
            }
            this.$completionHandler$inlined.invoke(null);
        }
    }

    static final class d extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ kotlin.g.a.b $completionHandler;
        final /* synthetic */ String $toString;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, kotlin.g.a.b bVar, String str) {
            super(1);
            this.this$0 = cVar;
            this.$completionHandler = bVar;
            this.$toString = str;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                this.$completionHandler.invoke(this.$toString);
                net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
                String comment_updated = FeedEventNames.INSTANCE.getCOMMENT_UPDATED();
                FeedItem feedItem = this.this$0.f34961b;
                if (feedItem == null) {
                    k.a();
                }
                net.one97.paytm.feed.events.a.a(comment_updated, feedItem, this.$toString, "");
                FeedItem feedItem2 = this.this$0.f34961b;
                if (feedItem2 != null) {
                    net.one97.paytm.feed.events.a.a aVar2 = net.one97.paytm.feed.events.a.a.f34296a;
                    net.one97.paytm.feed.events.a.a.a("v2_feed_comment_edit", feedItem2.getFeedItemType());
                    return;
                }
                return;
            }
            this.$completionHandler.invoke(null);
        }
    }

    public c() {
        io.reactivex.rxjava3.j.b<ArrayList<CommentResponse>> a2 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a2, "PublishSubject.create()");
        this.f34962c = a2;
        io.reactivex.rxjava3.j.b<Integer> a3 = io.reactivex.rxjava3.j.b.a();
        k.a((Object) a3, "PublishSubject.create()");
        this.f34963d = a3;
    }

    public final LiveData<FeedDataMinimal> a(Context context, String str) {
        k.c(context, "context");
        k.c(str, Constants.URL_MEDIA_SOURCE);
        if (this.f34966g == null) {
            net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
            this.f34966g = net.one97.paytm.feed.repository.db.a.g(context, str);
        }
        LiveData<FeedDataMinimal> liveData = this.f34966g;
        if (liveData == null) {
            k.a();
        }
        return liveData;
    }
}
