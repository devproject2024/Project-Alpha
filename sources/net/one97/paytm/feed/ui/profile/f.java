package net.one97.paytm.feed.ui.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.repository.models.profile.Following;
import net.one97.paytm.feed.utility.c;

public final class f extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public List<Following> f35317a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<FeedItem> f35318b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f35319c;

    /* renamed from: d  reason: collision with root package name */
    private final String f35320d;

    /* renamed from: e  reason: collision with root package name */
    private final a f35321e;

    public interface a {
        void a(int i2);

        void a(int i2, boolean z, int i3);

        void a(FeedGeneric feedGeneric);

        void b(int i2);
    }

    public f(Context context, String str, a aVar) {
        k.c(context, "context");
        k.c(aVar, "profileDiscoveryClickListener");
        this.f35319c = context;
        this.f35320d = str;
        this.f35321e = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        if (c.a().equals(this.f35320d)) {
            View inflate = LayoutInflater.from(this.f35319c).inflate(R.layout.view_holder_following, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…lse\n                    )");
            return new d(inflate);
        }
        View inflate2 = LayoutInflater.from(this.f35319c).inflate(R.layout.view_holder_bookmark, viewGroup, false);
        k.a((Object) inflate2, "LayoutInflater.from(cont…lse\n                    )");
        return new a(inflate2);
    }

    public final int getItemCount() {
        if (k.a((Object) c.a(), (Object) this.f35320d)) {
            List<Following> list = this.f35317a;
            if (list == null) {
                k.a("followingList");
            }
            return list.size();
        }
        ArrayList<FeedItem> arrayList = this.f35318b;
        if (arrayList == null) {
            k.a("bookmarkList");
        }
        return arrayList.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (r2 == (r12.size() - 1)) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        if (r2 == (r11.size() - 1)) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r11 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "holder"
            kotlin.g.b.k.c(r1, r3)
            java.lang.String r3 = net.one97.paytm.feed.utility.c.a()
            java.lang.String r4 = r0.f35320d
            boolean r3 = r3.equals(r4)
            java.lang.String r5 = "bookmarkList"
            java.lang.String r6 = "profileDiscoveryClickListener"
            java.lang.String r7 = "context"
            r8 = 0
            r9 = 1
            if (r3 == 0) goto L_0x014f
            boolean r3 = r1 instanceof net.one97.paytm.feed.ui.profile.d
            if (r3 == 0) goto L_0x014f
            r3 = r1
            net.one97.paytm.feed.ui.profile.d r3 = (net.one97.paytm.feed.ui.profile.d) r3
            java.util.List<net.one97.paytm.feed.repository.models.profile.Following> r10 = r0.f35317a
            java.lang.String r11 = "followingList"
            if (r10 != 0) goto L_0x002f
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x002f:
            java.lang.Object r10 = r10.get(r2)
            net.one97.paytm.feed.repository.models.profile.Following r10 = (net.one97.paytm.feed.repository.models.profile.Following) r10
            java.lang.String r12 = net.one97.paytm.feed.utility.c.a()
            java.lang.String r13 = r0.f35320d
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0050
            java.util.List<net.one97.paytm.feed.repository.models.profile.Following> r12 = r0.f35317a
            if (r12 != 0) goto L_0x0048
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0048:
            int r11 = r12.size()
            int r11 = r11 - r9
            if (r2 != r11) goto L_0x0060
            goto L_0x005e
        L_0x0050:
            java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedItem> r11 = r0.f35318b
            if (r11 != 0) goto L_0x0057
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0057:
            int r11 = r11.size()
            int r11 = r11 - r9
            if (r2 != r11) goto L_0x0060
        L_0x005e:
            r11 = 1
            goto L_0x0061
        L_0x0060:
            r11 = 0
        L_0x0061:
            android.content.Context r12 = r0.f35319c
            net.one97.paytm.feed.ui.profile.f$a r13 = r0.f35321e
            java.lang.String r14 = "followingData"
            kotlin.g.b.k.c(r10, r14)
            kotlin.g.b.k.c(r12, r7)
            kotlin.g.b.k.c(r13, r6)
            net.one97.paytm.feed.b.de r14 = r3.f35304a
            android.widget.TextView r14 = r14.f34149d
            java.lang.String r15 = r10.getName()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r14.setText(r15)
            net.one97.paytm.feed.b.de r14 = r3.f35304a
            com.makeramen.roundedimageview.RoundedImageView r14 = r14.f34147b
            java.lang.String r15 = "viewHolderFollowingBinding.ivFollow"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            net.one97.paytm.feed.repository.models.profile.FollowingFeedItemData r15 = r10.getFollowingFeedItemData()
            java.lang.String r15 = r15.getImageUrl()
            net.one97.paytm.feed.utility.r r16 = net.one97.paytm.feed.utility.r.f35432a
            r9 = 1109393408(0x42200000, float:40.0)
            float r4 = net.one97.paytm.feed.utility.r.a(r9, r12)
            int r4 = (int) r4
            java.lang.String r4 = java.lang.String.valueOf(r4)
            net.one97.paytm.feed.utility.r r17 = net.one97.paytm.feed.utility.r.f35432a
            float r9 = net.one97.paytm.feed.utility.r.a(r9, r12)
            int r9 = (int) r9
            java.lang.String r9 = java.lang.String.valueOf(r9)
            net.one97.paytm.feed.utility.a.a(r14, r15, r4, r9)
            boolean r4 = r10.getFollowing()
            java.lang.String r9 = "viewHolderFollowingBinding.tvFollow"
            if (r4 == 0) goto L_0x00de
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            android.widget.TextView r4 = r4.f34150e
            java.lang.String r14 = "Following"
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r4.setText(r14)
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            android.widget.TextView r4 = r4.f34150e
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            int r9 = net.one97.paytm.feed.R.drawable.blue_backgound_curved_sides
            android.graphics.drawable.Drawable r9 = androidx.core.content.b.a((android.content.Context) r12, (int) r9)
            r4.setBackground(r9)
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            android.widget.TextView r4 = r4.f34150e
            int r9 = net.one97.paytm.feed.R.color.feed_white
            int r9 = androidx.core.content.b.c(r12, r9)
            r4.setTextColor(r9)
            goto L_0x0106
        L_0x00de:
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            android.widget.TextView r4 = r4.f34150e
            java.lang.String r14 = "Follow"
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r4.setText(r14)
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            android.widget.TextView r4 = r4.f34150e
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            int r9 = net.one97.paytm.feed.R.drawable.white_bg_blue_curved_sides
            android.graphics.drawable.Drawable r9 = androidx.core.content.b.a((android.content.Context) r12, (int) r9)
            r4.setBackground(r9)
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            android.widget.TextView r4 = r4.f34150e
            int r9 = net.one97.paytm.feed.R.color.feed_paytm_blue
            int r9 = androidx.core.content.b.c(r12, r9)
            r4.setTextColor(r9)
        L_0x0106:
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            android.widget.TextView r4 = r4.f34149d
            net.one97.paytm.feed.ui.profile.d$a r9 = new net.one97.paytm.feed.ui.profile.d$a
            r9.<init>(r13, r10)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r4.setOnClickListener(r9)
            net.one97.paytm.feed.b.de r4 = r3.f35304a
            com.makeramen.roundedimageview.RoundedImageView r4 = r4.f34147b
            net.one97.paytm.feed.ui.profile.d$b r9 = new net.one97.paytm.feed.ui.profile.d$b
            r9.<init>(r13, r10)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r4.setOnClickListener(r9)
            java.lang.String r4 = "viewHolderFollowingBinding.hDivider"
            if (r11 != 0) goto L_0x0134
            net.one97.paytm.feed.b.de r9 = r3.f35304a
            android.view.View r9 = r9.f34146a
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            r9.setVisibility(r8)
            r4 = 8
            goto L_0x0140
        L_0x0134:
            net.one97.paytm.feed.b.de r9 = r3.f35304a
            android.view.View r9 = r9.f34146a
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            r4 = 8
            r9.setVisibility(r4)
        L_0x0140:
            net.one97.paytm.feed.b.de r3 = r3.f35304a
            android.widget.TextView r3 = r3.f34150e
            net.one97.paytm.feed.ui.profile.d$c r9 = new net.one97.paytm.feed.ui.profile.d$c
            r9.<init>(r13, r2, r10)
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            r3.setOnClickListener(r9)
            goto L_0x0151
        L_0x014f:
            r4 = 8
        L_0x0151:
            java.lang.String r3 = net.one97.paytm.feed.utility.c.b()
            java.lang.String r9 = r0.f35320d
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x0245
            boolean r3 = r1 instanceof net.one97.paytm.feed.ui.profile.a
            if (r3 == 0) goto L_0x0245
            net.one97.paytm.feed.ui.profile.a r1 = (net.one97.paytm.feed.ui.profile.a) r1
            java.util.ArrayList<net.one97.paytm.feed.repository.models.FeedItem> r3 = r0.f35318b
            if (r3 != 0) goto L_0x016a
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x016a:
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r5 = "bookmarkList.get(position)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            net.one97.paytm.feed.repository.models.FeedItem r3 = (net.one97.paytm.feed.repository.models.FeedItem) r3
            android.content.Context r5 = r0.f35319c
            net.one97.paytm.feed.ui.profile.f$a r9 = r0.f35321e
            java.lang.String r10 = "feedItem"
            kotlin.g.b.k.c(r3, r10)
            kotlin.g.b.k.c(r5, r7)
            kotlin.g.b.k.c(r9, r6)
            r5 = r3
            net.one97.paytm.feed.repository.models.generic.FeedGeneric r5 = (net.one97.paytm.feed.repository.models.generic.FeedGeneric) r5
            net.one97.paytm.feed.repository.models.generic.FeedGenericData r5 = r5.getFeedGenericData()
            net.one97.paytm.feed.b.dc r6 = r1.f35270a
            android.widget.TextView r6 = r6.f34142f
            java.lang.String r7 = "viewHolderBookmarkBinding.title"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r5.getTitle()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            net.one97.paytm.feed.b.dc r6 = r1.f35270a
            android.widget.TextView r6 = r6.f34143g
            java.lang.String r7 = "viewHolderBookmarkBinding.tvCreator"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.feed.repository.models.CreatedBy r7 = r5.getCreatedBy()
            if (r7 == 0) goto L_0x01b5
            java.lang.String r7 = r7.getName()
            if (r7 == 0) goto L_0x01b5
            goto L_0x01b7
        L_0x01b5:
            java.lang.String r7 = ""
        L_0x01b7:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            net.one97.paytm.feed.b.dc r6 = r1.f35270a
            android.widget.TextView r6 = r6.f34144h
            java.lang.String r7 = "viewHolderBookmarkBinding.tvTime"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r5.getCreatedAt()
            java.lang.String r7 = net.one97.paytm.feed.utility.b.a((java.lang.String) r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            net.one97.paytm.feed.b.dc r6 = r1.f35270a
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.f34141e
            net.one97.paytm.feed.ui.profile.a$a r7 = new net.one97.paytm.feed.ui.profile.a$a
            r7.<init>(r9, r3)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            net.one97.paytm.feed.b.dc r6 = r1.f35270a
            android.widget.ImageView r6 = r6.f34140d
            net.one97.paytm.feed.ui.profile.a$b r7 = new net.one97.paytm.feed.ui.profile.a$b
            r7.<init>(r1, r2, r9, r3)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            net.one97.paytm.feed.b.dc r2 = r1.f35270a
            android.widget.ImageView r2 = r2.f34139c
            java.lang.String r6 = "viewHolderBookmarkBinding.ivPlayBtn"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.String r3 = r3.getFeedItemType()
            java.lang.String r6 = "VIDEO"
            r7 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r3, (boolean) r7)
            if (r3 == 0) goto L_0x0207
            r4 = 0
        L_0x0207:
            r2.setVisibility(r4)
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            net.one97.paytm.feed.repository.models.CreatedBy r3 = r5.getCreatedBy()
            r4 = 0
            if (r3 == 0) goto L_0x021a
            java.lang.String r3 = r3.getImageUrl()
            goto L_0x021b
        L_0x021a:
            r3 = r4
        L_0x021b:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            com.squareup.picasso.aa r2 = r2.a((android.net.Uri) r3)
            net.one97.paytm.feed.b.dc r3 = r1.f35270a
            com.makeramen.roundedimageview.RoundedImageView r3 = r3.f34138b
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r2.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r4)
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            java.lang.String r3 = r5.getImageUrl()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            com.squareup.picasso.aa r2 = r2.a((android.net.Uri) r3)
            net.one97.paytm.feed.b.dc r1 = r1.f35270a
            com.makeramen.roundedimageview.RoundedImageView r1 = r1.f34137a
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r2.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r4)
        L_0x0245:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.ui.profile.f.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }
}
