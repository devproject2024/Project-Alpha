package net.one97.paytm.feed.ui.feed.actions.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.m;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.progress.FeedProgress;
import net.one97.paytm.feed.ui.base.b;
import net.one97.paytm.feed.ui.feed.c;
import net.one97.paytm.feed.ui.feed.d.a;
import net.one97.paytm.feed.ui.feed.d.c;
import net.one97.paytm.feed.ui.feed.h;

public final class d extends RecyclerView.a<b<?, ?, ?>> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<FeedItem> f34967a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private e f34968b;

    /* renamed from: c  reason: collision with root package name */
    private final FeedItem f34969c;

    public d(FeedItem feedItem) {
        this.f34969c = feedItem;
        FeedItem feedItem2 = this.f34969c;
        if (feedItem2 != null) {
            this.f34967a.add(feedItem2);
        }
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        String feedItemType = this.f34967a.get(i2).getFeedItemType();
        if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.GENERIC.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.VIDEOS.getType()) || k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.HIGHLIGHTS.getType())) {
            FeedItem feedItem = this.f34967a.get(i2);
            if (feedItem != null) {
                a aVar = new a((FeedGeneric) feedItem);
                aVar.f35026d = 1;
                ((c) bVar).a(aVar, i2);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.generic.FeedGeneric");
        } else if (k.a((Object) feedItemType, (Object) net.one97.paytm.feed.utility.k.PROGRESS.getType())) {
            h hVar = (h) bVar;
            FeedItem feedItem2 = this.f34967a.get(i2);
            if (feedItem2 != null) {
                hVar.a((FeedProgress) feedItem2);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.progress.FeedProgress");
        } else {
            if (!(bVar instanceof h)) {
                bVar = null;
            }
            h hVar2 = (h) bVar;
            if (hVar2 != null) {
                FeedItem feedItem3 = this.f34967a.get(i2);
                if (feedItem3 != null) {
                    i iVar = new i((CommentResponse) feedItem3);
                    k.c(iVar, "viewModel");
                    m mVar = (m) hVar2.f34872a;
                    mVar.setVariable(net.one97.paytm.feed.a.f33777d, iVar);
                    mVar.setVariable(net.one97.paytm.feed.a.f33780g, iVar.f34974f);
                    mVar.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
                    for (Map.Entry entry : ae.c(new o(Integer.valueOf(net.one97.paytm.feed.a.f33775b), new b(hVar2.f34971b))).entrySet()) {
                        mVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
                    }
                    ((m) hVar2.f34872a).executePendingBindings();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.comment.CommentResponse");
            }
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        b bVar;
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 == 2 || i2 == 20 || i2 == 26) {
            if (from == null) {
                k.a();
            }
            View inflate = from.inflate(R.layout.feed_generic, viewGroup, false);
            k.a((Object) inflate, "view");
            bVar = new c(inflate);
            inflate.setTag(bVar);
        } else if (i2 == 10) {
            if (from == null) {
                k.a();
            }
            View inflate2 = from.inflate(R.layout.feed_comment_item, viewGroup, false);
            k.a((Object) inflate2, "view");
            bVar = new h(inflate2, this.f34968b);
            inflate2.setTag(bVar);
        } else if (i2 != 11) {
            bVar = null;
        } else {
            if (from == null) {
                k.a();
            }
            View inflate3 = from.inflate(R.layout.feed_progress, viewGroup, false);
            k.a((Object) inflate3, "view");
            bVar = new h(inflate3);
            inflate3.setTag(bVar);
        }
        if (bVar == null) {
            k.a("viewViewHolder");
        }
        return bVar;
    }

    public final int getItemCount() {
        return this.f34967a.size();
    }

    public final int getItemViewType(int i2) {
        c.b.a aVar = c.b.f35021a;
        return c.b.a.a(this.f34967a.get(i2).getFeedItemType());
    }

    public final long getItemId(int i2) {
        int hashCode;
        if (i2 == 0) {
            hashCode = this.f34967a.get(i2).getPid().hashCode();
        } else if (this.f34967a.get(i2) instanceof FeedProgress) {
            hashCode = this.f34967a.get(i2).getFeedItemType().hashCode();
        } else {
            FeedItem feedItem = this.f34967a.get(i2);
            if (feedItem != null) {
                hashCode = ((CommentResponse) feedItem).getId().hashCode();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.comment.CommentResponse");
            }
        }
        return (long) hashCode;
    }

    public final void a(e eVar) {
        if (this.f34968b == null || eVar == null) {
            this.f34968b = eVar;
        }
    }

    public final void a(CommentResponse commentResponse, int i2) {
        ArrayList<FeedItem> arrayList = this.f34967a;
        if (commentResponse != null) {
            arrayList.remove(commentResponse);
            notifyItemRemoved(i2);
            notifyItemRangeChanged(i2, getItemCount());
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.feed.repository.models.FeedItem");
    }

    public final void a(FeedItem feedItem) {
        k.c(feedItem, "feedItem");
        this.f34967a.set(0, feedItem);
        notifyItemChanged(0);
    }
}
