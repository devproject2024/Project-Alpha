package net.one97.paytm.v2.features.cashbacklanding.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.v2.features.cashbacklanding.model.CashbackSummary;
import net.one97.paytm.v2.features.cashbackoffers.ui.OfferListActivity;
import net.one97.paytm.v2.features.cashbackoffers.ui.VoucherDealPagerActivity;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.h;

public final class f extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends View> f20199a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CashbackSummary> f20200b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    boolean f20201c;

    /* renamed from: d  reason: collision with root package name */
    final String f20202d = ViewHolderFactory.TYPE_CAROUSEL_LOCKED_CARD;

    /* renamed from: e  reason: collision with root package name */
    final String f20203e = ViewHolderFactory.TYPE_CAROUSEL_SCRATCH_CARD;

    /* renamed from: f  reason: collision with root package name */
    boolean f20204f = true;

    /* renamed from: g  reason: collision with root package name */
    boolean f20205g = true;

    /* renamed from: h  reason: collision with root package name */
    kotlin.g.a.b<? super ScratchCard, x> f20206h;

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.v2.features.cashbacklanding.d.a f20207i;
    public net.one97.paytm.v2.features.cashbacklanding.d.d j;
    public e k;
    public e l;
    private final int m;
    private final int n = 1;
    private final int o = 2;
    private LayoutInflater p;
    private final Fragment q;

    public f(Fragment fragment) {
        k.c(fragment, "fragment");
        this.q = fragment;
    }

    public final e a() {
        e eVar = this.k;
        if (eVar == null) {
            k.a("gamesOffersAdapter");
        }
        return eVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.p = from;
        if (i2 == this.m) {
            LayoutInflater layoutInflater = this.p;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            android.view.View inflate = layoutInflater.inflate(R.layout.cashback_summary_layout, viewGroup, false);
            if (inflate == null) {
                k.a();
            }
            return new b(inflate, this.q.getActivity());
        } else if (i2 == this.o) {
            LayoutInflater layoutInflater2 = this.p;
            if (layoutInflater2 == null) {
                k.a("mInflater");
            }
            android.view.View inflate2 = layoutInflater2.inflate(R.layout.cashback_bottom_bar_layout, viewGroup, false);
            k.a((Object) inflate2, "footerView");
            return new a(this, inflate2);
        } else if (i2 == this.n) {
            LayoutInflater layoutInflater3 = this.p;
            if (layoutInflater3 == null) {
                k.a("mInflater");
            }
            android.view.View inflate3 = layoutInflater3.inflate(R.layout.storefront_shimmer_layout, viewGroup, false);
            k.a((Object) inflate3, "shimmerView");
            return new c(this, inflate3);
        } else {
            String layoutTypeNameNameFromIndex = WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2);
            if (k.a((Object) layoutTypeNameNameFromIndex, (Object) this.f20203e)) {
                LayoutInflater layoutInflater4 = this.p;
                if (layoutInflater4 == null) {
                    k.a("mInflater");
                }
                android.view.View inflate4 = layoutInflater4.inflate(R.layout.scratchcard_layout, viewGroup, false);
                k.a((Object) inflate4, "mInflater.inflate(R.layo…card_layout,parent,false)");
                Fragment fragment = this.q;
                e eVar = this.l;
                if (eVar == null) {
                    k.a("scratchCardOffersAdapter");
                }
                return new d(this, inflate4, fragment, eVar);
            } else if (k.a((Object) layoutTypeNameNameFromIndex, (Object) this.f20202d)) {
                LayoutInflater layoutInflater5 = this.p;
                if (layoutInflater5 == null) {
                    k.a("mInflater");
                }
                android.view.View inflate5 = layoutInflater5.inflate(R.layout.scratchcard_layout, viewGroup, false);
                k.a((Object) inflate5, "mInflater.inflate(R.layo…card_layout,parent,false)");
                Fragment fragment2 = this.q;
                e eVar2 = this.k;
                if (eVar2 == null) {
                    k.a("gamesOffersAdapter");
                }
                return new d(this, inflate5, fragment2, eVar2);
            } else {
                CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), this.q.getChildFragmentManager(), (IGAHandlerListener) null);
                k.a((Object) viewHolder, "ViewHolderFactory.getVie…           null\n        )");
                return viewHolder;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r13, int r14) {
        /*
            r12 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r13, r0)
            boolean r0 = r13 instanceof com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001f
            com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder r13 = (com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder) r13
            java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r0 = r12.f20199a
            if (r0 != 0) goto L_0x0014
            kotlin.g.b.k.a()
        L_0x0014:
            int r14 = r14 - r1
            java.lang.Object r14 = r0.get(r14)
            com.paytmmall.clpartifact.modal.clpCommon.View r14 = (com.paytmmall.clpartifact.modal.clpCommon.View) r14
            r13.bind((com.paytmmall.clpartifact.modal.clpCommon.View) r14, (com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder.IParentListProvider) r2)
            return
        L_0x001f:
            boolean r0 = r13 instanceof net.one97.paytm.v2.features.cashbacklanding.c.f.b
            r3 = 8
            r4 = 0
            if (r0 == 0) goto L_0x039b
            boolean r14 = r12.f20204f
            if (r14 == 0) goto L_0x003b
            net.one97.paytm.v2.features.cashbacklanding.c.f$b r13 = (net.one97.paytm.v2.features.cashbacklanding.c.f.b) r13
            net.one97.paytm.common.views.ShimmerFrameLayout r14 = r13.f20211c
            if (r14 == 0) goto L_0x0033
            r14.setVisibility(r4)
        L_0x0033:
            net.one97.paytm.common.views.ShimmerFrameLayout r13 = r13.f20211c
            if (r13 == 0) goto L_0x003a
            r13.a()
        L_0x003a:
            return
        L_0x003b:
            net.one97.paytm.v2.features.cashbacklanding.c.f$b r13 = (net.one97.paytm.v2.features.cashbacklanding.c.f.b) r13
            java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.CashbackSummary> r14 = r12.f20200b
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = r13.f20211c
            if (r0 == 0) goto L_0x0046
            r0.setVisibility(r3)
        L_0x0046:
            net.one97.paytm.common.views.ShimmerFrameLayout r0 = r13.f20211c
            if (r0 == 0) goto L_0x004d
            r0.b()
        L_0x004d:
            android.view.View r0 = r13.f20212d
            if (r0 == 0) goto L_0x0054
            r0.setVisibility(r4)
        L_0x0054:
            android.view.View r0 = r13.f20213e
            if (r0 == 0) goto L_0x005b
            r0.setVisibility(r4)
        L_0x005b:
            android.view.View r0 = r13.f20209a
            if (r0 == 0) goto L_0x032b
            r3 = r14
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x006d
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r3 = 0
            goto L_0x006e
        L_0x006d:
            r3 = 1
        L_0x006e:
            r5 = 4
            if (r3 != 0) goto L_0x0275
            java.util.Iterator r3 = r14.iterator()
        L_0x0075:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x032b
            java.lang.Object r6 = r3.next()
            net.one97.paytm.v2.features.cashbacklanding.model.CashbackSummary r6 = (net.one97.paytm.v2.features.cashbacklanding.model.CashbackSummary) r6
            if (r6 == 0) goto L_0x0088
            java.lang.String r7 = r6.getCategoryType()
            goto L_0x0089
        L_0x0088:
            r7 = r2
        L_0x0089:
            net.one97.paytm.vipcashback.d.a$c$a r8 = net.one97.paytm.vipcashback.d.a.c.f20786a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.c.f20787b
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x0140
            int r7 = net.one97.paytm.vipcashback.R.id.defaultTitle
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00a2
            r7.setVisibility(r5)
        L_0x00a2:
            int r7 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00af
            r7.setVisibility(r4)
        L_0x00af:
            int r7 = net.one97.paytm.vipcashback.R.id.amountVIew
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00bc
            r7.setVisibility(r4)
        L_0x00bc:
            int r7 = net.one97.paytm.vipcashback.R.id.imageView
            android.view.View r7 = r0.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00c9
            r7.setVisibility(r4)
        L_0x00c9:
            int r7 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x00e0
            if (r6 == 0) goto L_0x00da
            java.lang.String r8 = r6.getCategoryMessage()
            goto L_0x00db
        L_0x00da:
            r8 = r2
        L_0x00db:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
        L_0x00e0:
            java.lang.String r7 = r6.getIcon()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0103
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            java.lang.String r8 = r6.getIcon()
            com.squareup.picasso.aa r7 = r7.a((java.lang.String) r8)
            int r8 = net.one97.paytm.vipcashback.R.id.imageView
            android.view.View r8 = r0.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.a((android.widget.ImageView) r8)
        L_0x0103:
            int r7 = net.one97.paytm.vipcashback.R.id.amountVIew
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x012a
            android.content.res.Resources r8 = r0.getResources()
            int r9 = net.one97.paytm.vipcashback.R.string.cashback_rs
            java.lang.Object[] r10 = new java.lang.Object[r1]
            net.one97.paytm.vipcashback.f.d$a r11 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r6 = r6.getAmount()
            java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.e(r6)
            r10[r4] = r6
            java.lang.String r6 = r8.getString(r9, r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
        L_0x012a:
            int r6 = net.one97.paytm.vipcashback.R.id.background1
            android.view.View r6 = r0.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0075
            net.one97.paytm.v2.features.cashbacklanding.c.f$b$a r7 = new net.one97.paytm.v2.features.cashbacklanding.c.f$b$a
            r7.<init>(r0, r13, r14)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            goto L_0x0075
        L_0x0140:
            net.one97.paytm.vipcashback.d.a$c$a r8 = net.one97.paytm.vipcashback.d.a.c.f20786a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.c.f20788c
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x01e9
            int r7 = net.one97.paytm.vipcashback.R.id.defaultTitle2
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0159
            r7.setVisibility(r5)
        L_0x0159:
            int r7 = net.one97.paytm.vipcashback.R.id.title2
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0166
            r7.setVisibility(r4)
        L_0x0166:
            int r7 = net.one97.paytm.vipcashback.R.id.amountVIew2
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0173
            r7.setVisibility(r4)
        L_0x0173:
            int r7 = net.one97.paytm.vipcashback.R.id.imageView2
            android.view.View r7 = r0.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0180
            r7.setVisibility(r4)
        L_0x0180:
            int r7 = net.one97.paytm.vipcashback.R.id.title2
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0197
            if (r6 == 0) goto L_0x0191
            java.lang.String r8 = r6.getCategoryMessage()
            goto L_0x0192
        L_0x0191:
            r8 = r2
        L_0x0192:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
        L_0x0197:
            java.lang.String r7 = r6.getIcon()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01ba
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            java.lang.String r8 = r6.getIcon()
            com.squareup.picasso.aa r7 = r7.a((java.lang.String) r8)
            int r8 = net.one97.paytm.vipcashback.R.id.imageView2
            android.view.View r8 = r0.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.a((android.widget.ImageView) r8)
        L_0x01ba:
            int r7 = net.one97.paytm.vipcashback.R.id.amountVIew2
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x01d3
            net.one97.paytm.vipcashback.f.d$a r8 = net.one97.paytm.vipcashback.f.d.f20859a
            java.lang.String r6 = r6.getAmount()
            java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.e(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
        L_0x01d3:
            int r6 = net.one97.paytm.vipcashback.R.id.background2
            android.view.View r6 = r0.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0075
            net.one97.paytm.v2.features.cashbacklanding.c.f$b$b r7 = new net.one97.paytm.v2.features.cashbacklanding.c.f$b$b
            r7.<init>(r0, r13, r14)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r6.setOnClickListener(r7)
            goto L_0x0075
        L_0x01e9:
            net.one97.paytm.vipcashback.d.a$c$a r8 = net.one97.paytm.vipcashback.d.a.c.f20786a
            java.lang.String r8 = net.one97.paytm.vipcashback.d.a.c.f20789d
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0075
            int r7 = net.one97.paytm.vipcashback.R.id.defaultTitle3
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0202
            r7.setVisibility(r5)
        L_0x0202:
            int r7 = net.one97.paytm.vipcashback.R.id.title3
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x020f
            r7.setVisibility(r4)
        L_0x020f:
            int r7 = net.one97.paytm.vipcashback.R.id.sticker_add_money
            android.view.View r7 = r0.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x021c
            r7.setVisibility(r4)
        L_0x021c:
            int r7 = net.one97.paytm.vipcashback.R.id.sticker_referal
            android.view.View r7 = r0.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0229
            r7.setVisibility(r4)
        L_0x0229:
            java.lang.String r7 = r6.getAmount()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x023a
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0238
            goto L_0x023a
        L_0x0238:
            r7 = 0
            goto L_0x023b
        L_0x023a:
            r7 = 1
        L_0x023b:
            if (r7 == 0) goto L_0x024b
            int r7 = net.one97.paytm.vipcashback.R.id.textView1
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x025f
            r7.setVisibility(r4)
            goto L_0x025f
        L_0x024b:
            int r7 = net.one97.paytm.vipcashback.R.id.countView
            android.view.View r7 = r0.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r8 = "countView"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r8 = r6.getAmount()
            net.one97.paytm.v2.b.a.a(r7, r8)
        L_0x025f:
            int r7 = net.one97.paytm.vipcashback.R.id.background3
            android.view.View r7 = r0.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0075
            net.one97.paytm.v2.features.cashbacklanding.c.f$b$c r8 = new net.one97.paytm.v2.features.cashbacklanding.c.f$b$c
            r8.<init>(r6, r13, r14)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r7.setOnClickListener(r8)
            goto L_0x0075
        L_0x0275:
            int r14 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0282
            r14.setVisibility(r5)
        L_0x0282:
            int r14 = net.one97.paytm.vipcashback.R.id.amountVIew
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x028f
            r14.setVisibility(r5)
        L_0x028f:
            int r14 = net.one97.paytm.vipcashback.R.id.imageView
            android.view.View r14 = r0.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x029c
            r14.setVisibility(r5)
        L_0x029c:
            int r14 = net.one97.paytm.vipcashback.R.id.title2
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x02a9
            r14.setVisibility(r5)
        L_0x02a9:
            int r14 = net.one97.paytm.vipcashback.R.id.amountVIew2
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x02b6
            r14.setVisibility(r5)
        L_0x02b6:
            int r14 = net.one97.paytm.vipcashback.R.id.imageView2
            android.view.View r14 = r0.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x02c3
            r14.setVisibility(r5)
        L_0x02c3:
            int r14 = net.one97.paytm.vipcashback.R.id.title3
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x02d0
            r14.setVisibility(r5)
        L_0x02d0:
            int r14 = net.one97.paytm.vipcashback.R.id.countView
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x02dd
            r14.setVisibility(r5)
        L_0x02dd:
            int r14 = net.one97.paytm.vipcashback.R.id.textView1
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x02ea
            r14.setVisibility(r5)
        L_0x02ea:
            int r14 = net.one97.paytm.vipcashback.R.id.sticker_add_money
            android.view.View r14 = r0.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x02f7
            r14.setVisibility(r5)
        L_0x02f7:
            int r14 = net.one97.paytm.vipcashback.R.id.sticker_referal
            android.view.View r14 = r0.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0304
            r14.setVisibility(r5)
        L_0x0304:
            int r14 = net.one97.paytm.vipcashback.R.id.defaultTitle
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0311
            r14.setVisibility(r4)
        L_0x0311:
            int r14 = net.one97.paytm.vipcashback.R.id.defaultTitle2
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x031e
            r14.setVisibility(r4)
        L_0x031e:
            int r14 = net.one97.paytm.vipcashback.R.id.defaultTitle3
            android.view.View r14 = r0.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x032b
            r14.setVisibility(r4)
        L_0x032b:
            android.view.View r14 = r13.itemView
            int r0 = net.one97.paytm.vipcashback.R.id.dealsView
            android.view.View r14 = r14.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x0352
            int r0 = net.one97.paytm.vipcashback.R.id.title
            android.view.View r0 = r14.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0352
            androidx.fragment.app.FragmentActivity r1 = r13.f20210b
            if (r1 == 0) goto L_0x034c
            int r3 = net.one97.paytm.vipcashback.R.string.vouchers_deals
            java.lang.String r1 = r1.getString(r3)
            goto L_0x034d
        L_0x034c:
            r1 = r2
        L_0x034d:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0352:
            if (r14 == 0) goto L_0x036f
            int r0 = net.one97.paytm.vipcashback.R.id.subtitle
            android.view.View r0 = r14.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x036f
            androidx.fragment.app.FragmentActivity r1 = r13.f20210b
            if (r1 == 0) goto L_0x0369
            int r3 = net.one97.paytm.vipcashback.R.string.voucher_subtitle
            java.lang.String r1 = r1.getString(r3)
            goto L_0x036a
        L_0x0369:
            r1 = r2
        L_0x036a:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x036f:
            if (r14 == 0) goto L_0x038e
            int r0 = net.one97.paytm.vipcashback.R.id.imageView
            android.view.View r0 = r14.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x038e
            androidx.fragment.app.FragmentActivity r1 = r13.f20210b
            if (r1 == 0) goto L_0x038b
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x038b
            int r2 = net.one97.paytm.vipcashback.R.drawable.ic_arrow_details
            android.graphics.drawable.Drawable r2 = r1.getDrawable(r2)
        L_0x038b:
            r0.setBackground(r2)
        L_0x038e:
            if (r14 == 0) goto L_0x039a
            net.one97.paytm.v2.features.cashbacklanding.c.f$b$d r0 = new net.one97.paytm.v2.features.cashbacklanding.c.f$b$d
            r0.<init>(r13, r14)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r14.setOnClickListener(r0)
        L_0x039a:
            return
        L_0x039b:
            boolean r0 = r13 instanceof net.one97.paytm.v2.features.cashbacklanding.c.f.c
            if (r0 == 0) goto L_0x03a9
            net.one97.paytm.v2.features.cashbacklanding.c.f$c r13 = (net.one97.paytm.v2.features.cashbacklanding.c.f.c) r13
            net.one97.paytm.common.views.ShimmerFrameLayout r13 = r13.f20225a
            if (r13 == 0) goto L_0x03a8
            r13.a()
        L_0x03a8:
            return
        L_0x03a9:
            boolean r0 = r13 instanceof net.one97.paytm.v2.features.cashbacklanding.c.f.d
            if (r0 == 0) goto L_0x04cd
            com.paytmmall.clpartifact.utils.WidgetLayoutType$Companion r0 = com.paytmmall.clpartifact.utils.WidgetLayoutType.Companion
            int r5 = r12.getItemViewType(r14)
            java.lang.String r0 = r0.getLayoutTypeNameNameFromIndex(r5)
            java.lang.String r5 = r12.f20202d
            boolean r8 = r0.equals(r5)
            com.paytmmall.clpartifact.utils.WidgetLayoutType$Companion r0 = com.paytmmall.clpartifact.utils.WidgetLayoutType.Companion
            int r5 = r12.getItemViewType(r14)
            java.lang.String r0 = r0.getLayoutTypeNameNameFromIndex(r5)
            java.lang.String r5 = r12.f20203e
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x03d9
            net.one97.paytm.v2.features.cashbacklanding.d.d r0 = r12.j
            if (r0 != 0) goto L_0x03e0
            java.lang.String r5 = "scratchCardViewModel"
        L_0x03d5:
            kotlin.g.b.k.a((java.lang.String) r5)
            goto L_0x03e0
        L_0x03d9:
            net.one97.paytm.v2.features.cashbacklanding.d.a r0 = r12.f20207i
            if (r0 != 0) goto L_0x03e0
            java.lang.String r5 = "cashBackofferViewModel"
            goto L_0x03d5
        L_0x03e0:
            r7 = r13
            net.one97.paytm.v2.features.cashbacklanding.c.f$d r7 = (net.one97.paytm.v2.features.cashbacklanding.c.f.d) r7
            if (r0 == 0) goto L_0x04c5
            net.one97.paytm.v2.features.cashbackoffers.c.a r0 = (net.one97.paytm.v2.features.cashbackoffers.c.a) r0
            java.lang.String r13 = "viewModel"
            kotlin.g.b.k.c(r0, r13)
            net.one97.paytm.v2.features.cashbacklanding.c.e r10 = r7.f20229c
            if (r10 == 0) goto L_0x04cd
            if (r8 == 0) goto L_0x042c
            net.one97.paytm.v2.features.cashbacklanding.c.f r13 = r7.f20230d
            net.one97.paytm.v2.features.cashbacklanding.c.e r13 = r13.a()
            net.one97.paytm.v2.features.cashbacklanding.c.f r5 = r7.f20230d
            java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r5 = r5.f20199a
            if (r5 == 0) goto L_0x040d
            int r6 = r14 + -1
            java.lang.Object r5 = r5.get(r6)
            com.paytmmall.clpartifact.modal.clpCommon.View r5 = (com.paytmmall.clpartifact.modal.clpCommon.View) r5
            if (r5 == 0) goto L_0x040d
            java.lang.String r5 = r5.getTitle()
            goto L_0x040e
        L_0x040d:
            r5 = r2
        L_0x040e:
            r13.b(r5)
            android.widget.TextView r13 = r7.f20227a
            if (r13 == 0) goto L_0x044d
            net.one97.paytm.v2.features.cashbacklanding.c.f r5 = r7.f20230d
            java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r5 = r5.f20199a
            if (r5 == 0) goto L_0x0428
            int r14 = r14 - r1
            java.lang.Object r14 = r5.get(r14)
            com.paytmmall.clpartifact.modal.clpCommon.View r14 = (com.paytmmall.clpartifact.modal.clpCommon.View) r14
            if (r14 == 0) goto L_0x0428
            java.lang.String r2 = r14.getTitle()
        L_0x0428:
            net.one97.paytm.v2.b.a.a(r13, r2)
            goto L_0x044d
        L_0x042c:
            net.one97.paytm.v2.features.cashbacklanding.c.f r13 = r7.f20230d
            net.one97.paytm.v2.features.cashbacklanding.c.e r13 = r13.l
            if (r13 != 0) goto L_0x0437
            java.lang.String r5 = "scratchCardOffersAdapter"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0437:
            net.one97.paytm.v2.features.cashbacklanding.c.f r5 = r7.f20230d
            java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r5 = r5.f20199a
            if (r5 == 0) goto L_0x044a
            int r14 = r14 - r1
            java.lang.Object r14 = r5.get(r14)
            com.paytmmall.clpartifact.modal.clpCommon.View r14 = (com.paytmmall.clpartifact.modal.clpCommon.View) r14
            if (r14 == 0) goto L_0x044a
            java.lang.String r2 = r14.getTitle()
        L_0x044a:
            r13.b(r2)
        L_0x044d:
            if (r10 == 0) goto L_0x0458
            net.one97.paytm.v2.features.cashbacklanding.c.f$d$c r13 = new net.one97.paytm.v2.features.cashbacklanding.c.f$d$c
            r13.<init>(r7, r10, r0)
            kotlin.g.a.m r13 = (kotlin.g.a.m) r13
            r10.f20149a = r13
        L_0x0458:
            android.view.View r9 = r7.itemView
            java.lang.String r13 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r13)
            android.widget.TextView r11 = r7.f20227a
            if (r8 != 0) goto L_0x0471
            android.view.View r14 = r7.itemView
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r13)
            net.one97.paytm.v2.features.cashbacklanding.c.f.d.a(r4, r14)
            if (r11 == 0) goto L_0x0479
            r11.setVisibility(r3)
            goto L_0x0479
        L_0x0471:
            android.view.View r14 = r7.itemView
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r13)
            net.one97.paytm.v2.features.cashbacklanding.c.f.d.a(r1, r14)
        L_0x0479:
            if (r0 == 0) goto L_0x0488
            androidx.lifecycle.LiveData r13 = r0.b()
            if (r13 == 0) goto L_0x0488
            androidx.fragment.app.Fragment r14 = r7.f20228b
            androidx.lifecycle.q r14 = (androidx.lifecycle.q) r14
            r13.removeObservers(r14)
        L_0x0488:
            if (r0 == 0) goto L_0x0497
            androidx.lifecycle.LiveData r13 = r0.d()
            if (r13 == 0) goto L_0x0497
            androidx.fragment.app.Fragment r14 = r7.f20228b
            androidx.lifecycle.q r14 = (androidx.lifecycle.q) r14
            r13.removeObservers(r14)
        L_0x0497:
            if (r0 == 0) goto L_0x04ad
            androidx.lifecycle.LiveData r13 = r0.d()
            if (r13 == 0) goto L_0x04ad
            androidx.fragment.app.Fragment r14 = r7.f20228b
            androidx.lifecycle.q r14 = (androidx.lifecycle.q) r14
            net.one97.paytm.v2.features.cashbacklanding.c.f$d$a r1 = new net.one97.paytm.v2.features.cashbacklanding.c.f$d$a
            r1.<init>(r7)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r13.observe(r14, r1)
        L_0x04ad:
            if (r0 == 0) goto L_0x04c4
            androidx.lifecycle.LiveData r13 = r0.b()
            if (r13 == 0) goto L_0x04c4
            androidx.fragment.app.Fragment r14 = r7.f20228b
            androidx.lifecycle.q r14 = (androidx.lifecycle.q) r14
            net.one97.paytm.v2.features.cashbacklanding.c.f$d$b r0 = new net.one97.paytm.v2.features.cashbacklanding.c.f$d$b
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r13.observe(r14, r0)
        L_0x04c4:
            return
        L_0x04c5:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type net.one97.paytm.v2.features.cashbackoffers.viewModel.OfferViewModelInterface"
            r13.<init>(r14)
            throw r13
        L_0x04cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbacklanding.c.f.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemCount() {
        List<? extends View> list = this.f20199a;
        if (list != null) {
            return list.size() + 2;
        }
        return 2;
    }

    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return this.m;
        }
        if (i2 == 1 && this.f20205g) {
            return this.n;
        }
        List<? extends View> list = this.f20199a;
        if (list != null && list != null && i2 == list.size() + 1) {
            return this.o;
        }
        WidgetLayoutType.Companion companion = WidgetLayoutType.Companion;
        List<? extends View> list2 = this.f20199a;
        if (list2 == null) {
            k.a();
        }
        return companion.getLayoutTypeIndexfromName((View) list2.get(i2 - 1));
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        android.view.View f20209a;

        /* renamed from: b  reason: collision with root package name */
        FragmentActivity f20210b;

        /* renamed from: c  reason: collision with root package name */
        ShimmerFrameLayout f20211c;

        /* renamed from: d  reason: collision with root package name */
        android.view.View f20212d;

        /* renamed from: e  reason: collision with root package name */
        android.view.View f20213e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(android.view.View view, FragmentActivity fragmentActivity) {
            super(view);
            k.c(view, "itemView");
            this.f20209a = view;
            this.f20210b = fragmentActivity;
            this.f20211c = (ShimmerFrameLayout) view.findViewById(R.id.summaryshimmerView);
            this.f20212d = view.findViewById(R.id.cashBack);
            this.f20213e = view.findViewById(R.id.dealsView);
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ android.view.View f20214a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f20215b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f20216c;

            a(android.view.View view, b bVar, ArrayList arrayList) {
                this.f20214a = view;
                this.f20215b = bVar;
                this.f20216c = arrayList;
            }

            public final void onClick(android.view.View view) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                k.a((Object) view, "it");
                d.a.a(view);
                net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(view.getContext(), "cashback_offers", "cashback_summary_clicked", (ArrayList<String>) null, (String) null, "/cashback-landing", "cashback");
                k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
                Boolean H = net.one97.paytm.vipcashback.f.f.H();
                k.a((Object) H, "GTMHelper.getInstance().isGetCashbackFromWeb");
                if (H.booleanValue()) {
                    k.a((Object) net.one97.paytm.vipcashback.f.f.a(), "GTMHelper.getInstance()");
                    net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20215b.f20210b, net.one97.paytm.vipcashback.f.f.y());
                    return;
                }
                Intent intent = new Intent(this.f20214a.getContext(), OfferListActivity.class);
                a.b.C0384a aVar2 = a.b.f20777a;
                intent.putExtra("offer_type_card", a.b.f20778b);
                FragmentActivity fragmentActivity = this.f20215b.f20210b;
                if (fragmentActivity != null) {
                    intent.putExtra("activityName", ((AppCompatActivity) fragmentActivity).getClass().getName());
                    FragmentActivity fragmentActivity2 = this.f20215b.f20210b;
                    if (fragmentActivity2 != null) {
                        ((AppCompatActivity) fragmentActivity2).startActivityForResult(intent, 100);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                }
                throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
        }

        /* renamed from: net.one97.paytm.v2.features.cashbacklanding.c.f$b$b  reason: collision with other inner class name */
        static final class C0363b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ android.view.View f20217a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f20218b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f20219c;

            C0363b(android.view.View view, b bVar, ArrayList arrayList) {
                this.f20217a = view;
                this.f20218b = bVar;
                this.f20219c = arrayList;
            }

            public final void onClick(android.view.View view) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                k.a((Object) view, "it");
                d.a.a(view);
                net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(view.getContext(), "cashback_offers", "points_summary_clicked", (ArrayList<String>) null, (String) null, "/cashback-landing", "cashback");
                Intent intent = new Intent(this.f20217a.getContext(), OfferListActivity.class);
                a.b.C0384a aVar2 = a.b.f20777a;
                intent.putExtra("offer_type_card", a.b.f20779c);
                FragmentActivity fragmentActivity = this.f20218b.f20210b;
                if (fragmentActivity != null) {
                    intent.putExtra("activityName", ((AppCompatActivity) fragmentActivity).getClass().getName());
                    FragmentActivity fragmentActivity2 = this.f20218b.f20210b;
                    if (fragmentActivity2 != null) {
                        ((AppCompatActivity) fragmentActivity2).startActivityForResult(intent, 100);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                }
                throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
        }

        static final class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CashbackSummary f20220a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f20221b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f20222c;

            c(CashbackSummary cashbackSummary, b bVar, ArrayList arrayList) {
                this.f20220a = cashbackSummary;
                this.f20221b = bVar;
                this.f20222c = arrayList;
            }

            public final void onClick(android.view.View view) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                k.a((Object) view, "it");
                d.a.a(view);
                String deeplink = this.f20220a.getDeeplink();
                if (deeplink != null) {
                    net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20221b.f20210b, deeplink);
                }
            }
        }

        static final class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f20223a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ConstraintLayout f20224b;

            d(b bVar, ConstraintLayout constraintLayout) {
                this.f20223a = bVar;
                this.f20224b = constraintLayout;
            }

            public final void onClick(android.view.View view) {
                net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
                k.a((Object) view, "it");
                b2.sendNewCustomGTMEventsWithMultipleLabel(view.getContext(), "cashback_offers", "my_vouchers_clicked", (ArrayList<String>) null, (String) null, "/cashback-landing", "cashback");
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a((android.view.View) this.f20224b);
                Intent intent = new Intent(this.f20223a.f20210b, VoucherDealPagerActivity.class);
                a.b.C0384a aVar2 = a.b.f20777a;
                intent.putExtra("offer_type_card", a.b.f20782f);
                FragmentActivity fragmentActivity = this.f20223a.f20210b;
                if (fragmentActivity != null) {
                    fragmentActivity.startActivityForResult(intent, 100);
                }
            }
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ShimmerFrameLayout f20225a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f20226b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f fVar, android.view.View view) {
            super(view);
            k.c(view, "view");
            this.f20226b = fVar;
            this.f20225a = (ShimmerFrameLayout) view.findViewById(R.id.storefrontShimmerLayout);
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f20208a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f fVar, android.view.View view) {
            super(view);
            k.c(view, "view");
            this.f20208a = fVar;
        }
    }

    public final class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f20227a;

        /* renamed from: b  reason: collision with root package name */
        final Fragment f20228b;

        /* renamed from: c  reason: collision with root package name */
        final e f20229c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f20230d;

        static final class a<T> implements z<String> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f20231a;

            a(d dVar) {
                this.f20231a = dVar;
            }

            public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
            }
        }

        static final class c extends l implements m<Integer, String, x> {
            final /* synthetic */ e $adapter;
            final /* synthetic */ net.one97.paytm.v2.features.cashbackoffers.c.a $viewModel;
            final /* synthetic */ d this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(d dVar, e eVar, net.one97.paytm.v2.features.cashbackoffers.c.a aVar) {
                super(2);
                this.this$0 = dVar;
                this.$adapter = eVar;
                this.$viewModel = aVar;
            }

            public final /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), (String) obj2);
                return x.f47997a;
            }

            public final void invoke(int i2, String str) {
                int i3;
                k.c(str, "title");
                if (!this.this$0.f20230d.f20201c) {
                    this.this$0.f20230d.f20201c = true;
                    final LiveData<Object> liveData = null;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (kotlin.d.f) null, (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super x>, Object>(this, (kotlin.d.d) null) {
                        int label;
                        private CoroutineScope p$;
                        final /* synthetic */ c this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                            k.c(dVar, "completion");
                            AnonymousClass1 r0 = 

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            public d(f fVar, android.view.View view, Fragment fragment, e eVar) {
                                super(view);
                                Resources resources;
                                k.c(view, "itemView");
                                k.c(fragment, "fragment");
                                this.f20230d = fVar;
                                this.f20228b = fragment;
                                this.f20229c = eVar;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.scratchCardRV);
                                int i2 = 0;
                                if (recyclerView != null) {
                                    recyclerView.setLayoutManager(new LinearLayoutManager(this.f20228b.getContext(), 0, false));
                                }
                                this.f20227a = (TextView) view.findViewById(R.id.scratchcardTitle);
                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.scratchCardRV);
                                if (recyclerView2 != null) {
                                    recyclerView2.setAdapter(this.f20229c);
                                }
                                Context context = this.f20228b.getContext();
                                if (!(context == null || (resources = context.getResources()) == null)) {
                                    i2 = resources.getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_8dp);
                                }
                                RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.scratchCardRV);
                                if (recyclerView3 != null) {
                                    recyclerView3.addItemDecoration(new net.one97.paytm.vipcashback.widget.c(i2, i2));
                                }
                            }

                            public static final class b implements z<h<Object>> {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ d f20232a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ boolean f20233b;

                                /* renamed from: c  reason: collision with root package name */
                                final /* synthetic */ android.view.View f20234c;

                                /* renamed from: d  reason: collision with root package name */
                                final /* synthetic */ e f20235d;

                                /* renamed from: e  reason: collision with root package name */
                                final /* synthetic */ TextView f20236e;

                                b(d dVar, boolean z, android.view.View view, e eVar, TextView textView) {
                                    this.f20232a = dVar;
                                    this.f20233b = z;
                                    this.f20234c = view;
                                    this.f20235d = eVar;
                                    this.f20236e = textView;
                                }

                                /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e9, code lost:
                                    r0 = (com.paytmmall.clpartifact.modal.clpCommon.View) r0.get(r6.f20232a.getAdapterPosition() - 1);
                                 */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final /* synthetic */ void onChanged(java.lang.Object r7) {
                                    /*
                                        r6 = this;
                                        net.one97.paytm.vipcashback.f.h r7 = (net.one97.paytm.vipcashback.f.h) r7
                                        java.lang.String r0 = "it"
                                        kotlin.g.b.k.c(r7, r0)
                                        int r0 = r7.f20893a
                                        r1 = 0
                                        r2 = 8
                                        switch(r0) {
                                            case 101: goto L_0x008e;
                                            case 102: goto L_0x007d;
                                            case 103: goto L_0x007c;
                                            case 104: goto L_0x004e;
                                            case 105: goto L_0x0011;
                                            default: goto L_0x000f;
                                        }
                                    L_0x000f:
                                        goto L_0x0130
                                    L_0x0011:
                                        net.one97.paytm.v2.features.cashbacklanding.c.e r7 = r6.f20235d
                                        java.util.ArrayList r0 = new java.util.ArrayList
                                        r0.<init>()
                                        r7.a((java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a>) r0)
                                        android.view.View r7 = r6.f20234c
                                        if (r7 == 0) goto L_0x002c
                                        int r0 = net.one97.paytm.vipcashback.R.id.scratchcardTitle
                                        android.view.View r7 = r7.findViewById(r0)
                                        android.widget.TextView r7 = (android.widget.TextView) r7
                                        if (r7 == 0) goto L_0x002c
                                        r7.setVisibility(r2)
                                    L_0x002c:
                                        android.view.View r7 = r6.f20234c
                                        if (r7 == 0) goto L_0x003d
                                        int r0 = net.one97.paytm.vipcashback.R.id.scratchCardRV
                                        android.view.View r7 = r7.findViewById(r0)
                                        androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
                                        if (r7 == 0) goto L_0x003d
                                        r7.setVisibility(r2)
                                    L_0x003d:
                                        boolean r7 = r6.f20233b
                                        if (r7 == 0) goto L_0x0046
                                        android.view.View r7 = r6.f20234c
                                        net.one97.paytm.v2.features.cashbacklanding.c.f.d.a(r1, r7)
                                    L_0x0046:
                                        android.view.View r7 = r6.f20234c
                                        if (r7 == 0) goto L_0x0130
                                        r7.setVisibility(r2)
                                        return
                                    L_0x004e:
                                        boolean r7 = r6.f20233b
                                        if (r7 == 0) goto L_0x0057
                                        android.view.View r7 = r6.f20234c
                                        net.one97.paytm.v2.features.cashbacklanding.c.f.d.a(r1, r7)
                                    L_0x0057:
                                        android.view.View r7 = r6.f20234c
                                        if (r7 == 0) goto L_0x005e
                                        r7.setVisibility(r2)
                                    L_0x005e:
                                        net.one97.paytm.vipcashback.f.d$a r7 = net.one97.paytm.vipcashback.f.d.f20859a
                                        net.one97.paytm.v2.features.cashbacklanding.c.f$d r7 = r6.f20232a
                                        androidx.fragment.app.Fragment r7 = r7.f20228b
                                        android.content.Context r7 = r7.getContext()
                                        if (r7 != 0) goto L_0x006d
                                        kotlin.g.b.k.a()
                                    L_0x006d:
                                        java.lang.String r0 = "fragment.context!!"
                                        kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
                                        net.one97.paytm.v2.features.cashbacklanding.c.f$d$b$a r0 = new net.one97.paytm.v2.features.cashbacklanding.c.f$d$b$a
                                        r0.<init>(r6)
                                        kotlin.g.a.a r0 = (kotlin.g.a.a) r0
                                        net.one97.paytm.vipcashback.f.d.a.a((android.content.Context) r7, (kotlin.g.a.a<kotlin.x>) r0)
                                    L_0x007c:
                                        return
                                    L_0x007d:
                                        boolean r7 = r6.f20233b
                                        if (r7 == 0) goto L_0x0086
                                        android.view.View r7 = r6.f20234c
                                        net.one97.paytm.v2.features.cashbacklanding.c.f.d.a(r1, r7)
                                    L_0x0086:
                                        android.view.View r7 = r6.f20234c
                                        if (r7 == 0) goto L_0x008d
                                        r7.setVisibility(r2)
                                    L_0x008d:
                                        return
                                    L_0x008e:
                                        T r0 = r7.f20894b
                                        if (r0 == 0) goto L_0x010e
                                        T r0 = r7.f20894b
                                        java.lang.String r3 = "null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.CashbackOffer> /* = java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.CashbackOffer> */"
                                        if (r0 == 0) goto L_0x0108
                                        java.util.ArrayList r0 = (java.util.ArrayList) r0
                                        int r0 = r0.size()
                                        if (r0 <= 0) goto L_0x010e
                                        boolean r0 = r6.f20233b
                                        if (r0 == 0) goto L_0x00a9
                                        android.view.View r0 = r6.f20234c
                                        net.one97.paytm.v2.features.cashbacklanding.c.f.d.a(r1, r0)
                                    L_0x00a9:
                                        net.one97.paytm.v2.features.cashbacklanding.c.e r0 = r6.f20235d
                                        r2 = 1
                                        if (r0 == 0) goto L_0x00c6
                                        T r4 = r7.f20894b
                                        if (r4 == 0) goto L_0x00c0
                                        java.util.ArrayList r4 = (java.util.ArrayList) r4
                                        int r4 = r4.size()
                                        r5 = 10
                                        if (r4 < r5) goto L_0x00bd
                                        r1 = 1
                                    L_0x00bd:
                                        r0.f20175b = r1
                                        goto L_0x00c6
                                    L_0x00c0:
                                        kotlin.u r7 = new kotlin.u
                                        r7.<init>(r3)
                                        throw r7
                                    L_0x00c6:
                                        net.one97.paytm.v2.features.cashbacklanding.c.e r0 = r6.f20235d
                                        T r7 = r7.f20894b
                                        if (r7 == 0) goto L_0x0102
                                        java.util.ArrayList r7 = (java.util.ArrayList) r7
                                        r0.a((java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a>) r7)
                                        boolean r7 = r6.f20233b
                                        if (r7 != 0) goto L_0x0130
                                        net.one97.paytm.v2.features.cashbacklanding.c.f$d r7 = r6.f20232a
                                        int r7 = r7.getAdapterPosition()
                                        if (r7 <= 0) goto L_0x0130
                                        android.widget.TextView r7 = r6.f20236e
                                        if (r7 == 0) goto L_0x0101
                                        net.one97.paytm.v2.features.cashbacklanding.c.f$d r0 = r6.f20232a
                                        net.one97.paytm.v2.features.cashbacklanding.c.f r0 = r0.f20230d
                                        java.util.List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> r0 = r0.f20199a
                                        if (r0 == 0) goto L_0x00fd
                                        net.one97.paytm.v2.features.cashbacklanding.c.f$d r1 = r6.f20232a
                                        int r1 = r1.getAdapterPosition()
                                        int r1 = r1 - r2
                                        java.lang.Object r0 = r0.get(r1)
                                        com.paytmmall.clpartifact.modal.clpCommon.View r0 = (com.paytmmall.clpartifact.modal.clpCommon.View) r0
                                        if (r0 == 0) goto L_0x00fd
                                        java.lang.String r0 = r0.getTitle()
                                        goto L_0x00fe
                                    L_0x00fd:
                                        r0 = 0
                                    L_0x00fe:
                                        net.one97.paytm.v2.b.a.a(r7, r0)
                                    L_0x0101:
                                        return
                                    L_0x0102:
                                        kotlin.u r7 = new kotlin.u
                                        r7.<init>(r3)
                                        throw r7
                                    L_0x0108:
                                        kotlin.u r7 = new kotlin.u
                                        r7.<init>(r3)
                                        throw r7
                                    L_0x010e:
                                        android.view.View r7 = r6.f20234c
                                        if (r7 == 0) goto L_0x011f
                                        int r0 = net.one97.paytm.vipcashback.R.id.scratchcardTitle
                                        android.view.View r7 = r7.findViewById(r0)
                                        android.widget.TextView r7 = (android.widget.TextView) r7
                                        if (r7 == 0) goto L_0x011f
                                        r7.setVisibility(r2)
                                    L_0x011f:
                                        android.view.View r7 = r6.f20234c
                                        if (r7 == 0) goto L_0x0130
                                        int r0 = net.one97.paytm.vipcashback.R.id.scratchCardRV
                                        android.view.View r7 = r7.findViewById(r0)
                                        androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
                                        if (r7 == 0) goto L_0x0130
                                        r7.setVisibility(r2)
                                    L_0x0130:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbacklanding.c.f.d.b.onChanged(java.lang.Object):void");
                                }

                                static final class a extends l implements kotlin.g.a.a<x> {
                                    final /* synthetic */ b this$0;

                                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                    a(b bVar) {
                                        super(0);
                                        this.this$0 = bVar;
                                    }

                                    public final void invoke() {
                                        FragmentActivity activity = this.this$0.f20232a.f20228b.getActivity();
                                        if (activity != null) {
                                            activity.onBackPressed();
                                        }
                                    }
                                }
                            }

                            static void a(boolean z, android.view.View view) {
                                ShimmerFrameLayout shimmerFrameLayout = view != null ? (ShimmerFrameLayout) view.findViewById(R.id.scratchcardShimmerLayout) : null;
                                if (z) {
                                    if (shimmerFrameLayout != null) {
                                        shimmerFrameLayout.setVisibility(0);
                                    }
                                    if (shimmerFrameLayout != null) {
                                        shimmerFrameLayout.a();
                                        return;
                                    }
                                    return;
                                }
                                if (shimmerFrameLayout != null) {
                                    shimmerFrameLayout.b();
                                }
                                if (shimmerFrameLayout != null) {
                                    shimmerFrameLayout.setVisibility(8);
                                }
                            }
                        }
                    }
