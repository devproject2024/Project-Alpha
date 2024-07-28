package net.one97.paytm.feed.ui.feed.actions.comment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.t;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.ui.feed.actions.d;

public final class b implements t.b, f {

    /* renamed from: a  reason: collision with root package name */
    public Context f34955a;

    /* renamed from: b  reason: collision with root package name */
    public i f34956b;

    /* renamed from: c  reason: collision with root package name */
    public int f34957c;

    /* renamed from: d  reason: collision with root package name */
    public final e f34958d;

    static final class a extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ CommentResponse $response;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CommentResponse commentResponse, b bVar) {
            super(1);
            this.$response = commentResponse;
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                String postId = this.$response.getPostId();
                String id = this.$response.getId();
                e eVar = this.this$0.f34958d;
                if (eVar != null) {
                    eVar.a(this.$response, this.this$0.f34957c);
                }
                net.one97.paytm.feed.repository.a aVar = net.one97.paytm.feed.repository.a.f34359b;
                k.c(postId, "pID");
                k.c(id, "cID");
                if (net.one97.paytm.feed.repository.a.f34358a.containsKey(id)) {
                    ArrayList<CommentResponse> arrayList = net.one97.paytm.feed.repository.a.f34358a.get(postId);
                    if (arrayList == null) {
                        k.a();
                    }
                    k.a((Object) arrayList, "userCommentsMap[pID]!!");
                    ArrayList arrayList2 = arrayList;
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        CommentResponse commentResponse = (CommentResponse) it2.next();
                        if (commentResponse.getId().equals(postId)) {
                            arrayList2.remove(commentResponse);
                        }
                    }
                }
                b bVar = this.this$0;
                bVar.f34956b = null;
                bVar.f34955a = null;
                return;
            }
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Toast.makeText(net.one97.paytm.feed.e.b.x(), R.string.feed_server_error, 0).show();
        }
    }

    public b(e eVar) {
        this.f34958d = eVar;
    }

    /* renamed from: net.one97.paytm.feed.ui.feed.actions.comment.b$b  reason: collision with other inner class name */
    public static final class C0570b implements t.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f34959a;

        public C0570b(b bVar) {
            this.f34959a = bVar;
        }

        public final void a() {
            this.f34959a.f34955a = null;
        }
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        CommentResponse commentResponse;
        CommentResponse commentResponse2;
        j jVar = null;
        Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
        int i2 = R.id.edit_comment;
        if (valueOf != null && valueOf.intValue() == i2) {
            e eVar = this.f34958d;
            if (eVar != null) {
                i iVar = this.f34956b;
                if (iVar == null) {
                    k.a();
                }
                eVar.a(iVar, this.f34957c);
            }
            return true;
        }
        int i3 = R.id.report;
        if (valueOf != null && valueOf.intValue() == i3) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putString("Source", "Comment");
            i iVar2 = this.f34956b;
            if (iVar2 != null) {
                commentResponse2 = iVar2.f34974f;
            } else {
                commentResponse2 = null;
            }
            if (commentResponse2 == null) {
                k.a();
            }
            bundle.putParcelable(CJRQRScanResultModel.KEY_COMMENT_SMALL, commentResponse2);
            dVar.setArguments(bundle);
            dVar.f34975d = this;
            Context context = this.f34955a;
            if (context != null) {
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                if (fragmentActivity != null) {
                    jVar = fragmentActivity.getSupportFragmentManager();
                }
                dVar.show(jVar, dVar.getTag());
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                return true;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
        int i4 = R.id.delete_comment;
        if (valueOf == null || valueOf.intValue() != i4) {
            return false;
        }
        Context context2 = this.f34955a;
        if (context2 != null) {
            net.one97.paytm.feed.utility.j jVar2 = net.one97.paytm.feed.utility.j.f35397a;
            if (net.one97.paytm.feed.utility.j.e(context2)) {
                i iVar3 = this.f34956b;
                if (!(iVar3 == null || (commentResponse = iVar3.f34974f) == null || this.f34956b == null)) {
                    i.a(commentResponse.getPostId(), commentResponse.getId(), new a(commentResponse, this));
                }
            } else {
                Toast.makeText(context2, R.string.feed_no_internet, 0).show();
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.f34974f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.feed.repository.models.comment.CommentResponse r4) {
        /*
            r3 = this;
            java.lang.String r0 = "comment"
            kotlin.g.b.k.c(r4, r0)
            net.one97.paytm.feed.ui.feed.actions.comment.i r0 = r3.f34956b
            r1 = 0
            if (r0 == 0) goto L_0x0013
            net.one97.paytm.feed.repository.models.comment.CommentResponse r0 = r0.f34974f
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getId()
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            java.lang.String r2 = r4.getId()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0029
            net.one97.paytm.feed.ui.feed.actions.comment.e r0 = r3.f34958d
            if (r0 == 0) goto L_0x0027
            int r2 = r3.f34957c
            r0.b(r4, r2)
        L_0x0027:
            r3.f34956b = r1
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.feed.actions.comment.b.a(net.one97.paytm.feed.repository.models.comment.CommentResponse):void");
    }

    public final void a() {
        this.f34956b = null;
    }
}
