package net.one97.paytm.feed.ui.publisher;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.progress.FeedProgress;
import net.one97.paytm.feed.ui.base.b;
import net.one97.paytm.feed.ui.feed.c;
import net.one97.paytm.feed.ui.feed.d.c;
import net.one97.paytm.feed.ui.feed.h;

public final class a extends RecyclerView.a<b<?, ?, ?>> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FeedItem> f35341a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f35342b;

    public a(Context context) {
        k.c(context, "context");
        this.f35342b = context;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c((b) vVar, "holder");
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2, List list) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        k.c(list, "payloads");
        if (list.isEmpty()) {
            String feedItemType = this.f35341a.get(i2).getFeedItemType();
            if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                FeedItem feedItem = this.f35341a.get(i2);
                if (feedItem != null) {
                    net.one97.paytm.feed.ui.feed.d.a aVar = new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem);
                    aVar.f35026d = 0;
                    ((c) bVar).a(aVar, i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
            } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.PROGRESS.getType())) {
                h hVar = (h) bVar;
                FeedItem feedItem2 = this.f35341a.get(i2);
                if (feedItem2 != null) {
                    hVar.a((FeedProgress) feedItem2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.progress.FeedProgress");
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next();
                if (bVar instanceof c) {
                    c cVar = (c) bVar;
                    FeedItem feedItem3 = this.f35341a.get(i2);
                    if (feedItem3 != null) {
                        cVar.a(new net.one97.paytm.feed.ui.feed.d.a((FeedGeneric) feedItem3), i2);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView.v onCreateViewHolder(android.view.ViewGroup r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "parent"
            kotlin.g.b.k.c(r5, r0)
            android.content.Context r0 = r4.f35342b
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2
            java.lang.String r2 = "view"
            r3 = 0
            if (r6 == r1) goto L_0x0036
            r1 = 11
            if (r6 == r1) goto L_0x001d
            r1 = 20
            if (r6 == r1) goto L_0x0036
            r5 = 0
            r6 = r5
            goto L_0x004e
        L_0x001d:
            if (r0 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            int r6 = net.one97.paytm.feed.R.layout.feed_progress
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.h r6 = new net.one97.paytm.feed.ui.feed.h
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            net.one97.paytm.feed.ui.base.b r6 = (net.one97.paytm.feed.ui.base.b) r6
            r5.setTag(r6)
            goto L_0x004e
        L_0x0036:
            if (r0 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            int r6 = net.one97.paytm.feed.R.layout.feed_generic
            android.view.View r5 = r0.inflate(r6, r5, r3)
            net.one97.paytm.feed.ui.feed.d.c r6 = new net.one97.paytm.feed.ui.feed.d.c
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r6.<init>(r5)
            net.one97.paytm.feed.ui.base.b r6 = (net.one97.paytm.feed.ui.base.b) r6
            r5.setTag(r6)
        L_0x004e:
            if (r6 != 0) goto L_0x0056
            java.lang.String r5 = "viewViewHolder"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0056:
            androidx.recyclerview.widget.RecyclerView$v r6 = (androidx.recyclerview.widget.RecyclerView.v) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.publisher.a.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$v");
    }

    public final int getItemCount() {
        return this.f35341a.size();
    }

    public final long getItemId(int i2) {
        return (long) this.f35341a.get(i2).getPid().hashCode();
    }

    /* renamed from: net.one97.paytm.feed.ui.publisher.a$a  reason: collision with other inner class name */
    public static final class C0590a extends h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f35343a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f35344b;

        C0590a(a aVar, ArrayList arrayList) {
            this.f35343a = aVar;
            this.f35344b = arrayList;
        }

        public final int getOldListSize() {
            return this.f35343a.f35341a.size();
        }

        public final int getNewListSize() {
            return this.f35344b.size();
        }

        public final boolean areItemsTheSame(int i2, int i3) {
            return ((FeedItem) this.f35344b.get(i3)).getPid().equals(this.f35343a.f35341a.get(i2).getPid());
        }

        public final boolean areContentsTheSame(int i2, int i3) {
            boolean z;
            boolean z2;
            int i4;
            int i5;
            int i6;
            boolean z3;
            boolean z4;
            int i7;
            int i8;
            int i9;
            String feedItemType = this.f35343a.f35341a.get(i2).getFeedItemType();
            if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                FeedItem feedItem = this.f35343a.f35341a.get(i2);
                k.a((Object) feedItem, "feedList[oldItemPosition]");
                FeedItem feedItem2 = feedItem;
                if (feedItem2 != null) {
                    FeedGeneric feedGeneric = (FeedGeneric) feedItem2;
                    Integer likeCount = feedGeneric.getFeedGenericData().getLikeCount();
                    if (likeCount == null) {
                        k.a();
                    }
                    i6 = likeCount.intValue();
                    Integer shareCount = feedGeneric.getFeedGenericData().getShareCount();
                    if (shareCount == null) {
                        k.a();
                    }
                    i5 = shareCount.intValue();
                    Integer commentCount = feedGeneric.getFeedGenericData().getCommentCount();
                    if (commentCount == null) {
                        k.a();
                    }
                    i4 = commentCount.intValue();
                    z2 = feedGeneric.getFeedGenericData().isFollowed();
                    z = feedGeneric.getFeedGenericData().isBookmarked();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                }
            } else {
                z = false;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                z2 = false;
            }
            String feedItemType2 = ((FeedItem) this.f35344b.get(i3)).getFeedItemType();
            if (k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType()) || k.a((Object) feedItemType2, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType())) {
                Object obj = this.f35344b.get(i3);
                k.a(obj, "list[newItemPosition]");
                FeedItem feedItem3 = (FeedItem) obj;
                if (feedItem3 != null) {
                    FeedGeneric feedGeneric2 = (FeedGeneric) feedItem3;
                    Integer likeCount2 = feedGeneric2.getFeedGenericData().getLikeCount();
                    if (likeCount2 == null) {
                        k.a();
                    }
                    i9 = likeCount2.intValue();
                    Integer shareCount2 = feedGeneric2.getFeedGenericData().getShareCount();
                    if (shareCount2 == null) {
                        k.a();
                    }
                    i8 = shareCount2.intValue();
                    Integer commentCount2 = feedGeneric2.getFeedGenericData().getCommentCount();
                    if (commentCount2 == null) {
                        k.a();
                    }
                    i7 = commentCount2.intValue();
                    z4 = feedGeneric2.getFeedGenericData().isFollowed();
                    z3 = feedGeneric2.getFeedGenericData().isBookmarked();
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
                }
            } else {
                z3 = false;
                i9 = 0;
                i8 = 0;
                i7 = 0;
                z4 = false;
            }
            if (i4 == i7 && i6 == i9 && i5 == i8 && z2 == z4 && z == z3) {
                return true;
            }
            return false;
        }

        public final Object getChangePayload(int i2, int i3) {
            return this.f35344b.get(i3);
        }
    }

    public final void a() {
        if (this.f35341a.size() > 0) {
            ArrayList<FeedItem> arrayList = this.f35341a;
            if (arrayList.get(arrayList.size() - 1) instanceof FeedProgress) {
                ArrayList<FeedItem> arrayList2 = this.f35341a;
                arrayList2.remove(arrayList2.size() - 1);
                notifyItemRemoved(this.f35341a.size());
            }
        }
    }

    public final int getItemViewType(int i2) {
        c.b.a aVar = c.b.f35021a;
        return c.b.a.a(this.f35341a.get(i2).getFeedItemType());
    }
}
