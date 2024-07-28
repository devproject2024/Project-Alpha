package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;

public final class PromoListAdapter extends RecyclerView.a<RecyclerView.v> {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final List<PromoListItem> mItemList;
    /* access modifiers changed from: private */
    public final View.OnClickListener onClickListener;

    public PromoListAdapter(Context context, List<PromoListItem> list, View.OnClickListener onClickListener2) {
        k.c(context, "mContext");
        k.c(onClickListener2, "onClickListener");
        this.mContext = context;
        this.mItemList = list;
        this.onClickListener = onClickListener2;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.vh_promo_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(mCon…romo_item, parent, false)");
        return new PromoItemViewHolder(this, inflate);
    }

    public final int getItemCount() {
        List<PromoListItem> list = this.mItemList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        ((PromoItemViewHolder) vVar).populateView();
    }

    public final class PromoItemViewHolder extends RecyclerView.v {
        private final View mView;
        final /* synthetic */ PromoListAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PromoItemViewHolder(PromoListAdapter promoListAdapter, View view) {
            super(view);
            k.c(view, "mView");
            this.this$0 = promoListAdapter;
            this.mView = view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:116:0x0388  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x010e  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0113  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x011b  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x012b  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0156  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0168  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x016d  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0172  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x017d  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01a8  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01e2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void populateView() {
            /*
                r11 = this;
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r0 = r11.this$0
                java.util.List r0 = r0.mItemList
                r1 = 0
                if (r0 == 0) goto L_0x0014
                int r2 = r11.getAdapterPosition()
                java.lang.Object r0 = r0.get(r2)
                net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem r0 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem) r0
                goto L_0x0015
            L_0x0014:
                r0 = r1
            L_0x0015:
                if (r0 == 0) goto L_0x0022
                net.one97.paytm.nativesdk.orflow.promo.model.Offer r2 = r0.getOffer()
                if (r2 == 0) goto L_0x0022
                java.lang.String r2 = r2.getTitle()
                goto L_0x0023
            L_0x0022:
                r2 = r1
            L_0x0023:
                java.lang.String r3 = "mView.tvOfferTitle"
                r4 = 4
                r5 = 0
                if (r2 != 0) goto L_0x004e
                android.view.View r2 = r11.mView
                int r6 = net.one97.paytm.nativesdk.R.id.tvOfferTitle
                android.view.View r2 = r2.findViewById(r6)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r4)
                android.view.View r2 = r11.mView
                int r6 = net.one97.paytm.nativesdk.R.id.tvOfferTitle
                android.view.View r2 = r2.findViewById(r6)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r3 = ""
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.setText(r3)
                goto L_0x007c
            L_0x004e:
                android.view.View r2 = r11.mView
                int r6 = net.one97.paytm.nativesdk.R.id.tvOfferTitle
                android.view.View r2 = r2.findViewById(r6)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                net.one97.paytm.nativesdk.orflow.promo.model.Offer r6 = r0.getOffer()
                if (r6 == 0) goto L_0x0066
                java.lang.String r6 = r6.getTitle()
                goto L_0x0067
            L_0x0066:
                r6 = r1
            L_0x0067:
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r2.setText(r6)
                android.view.View r2 = r11.mView
                int r6 = net.one97.paytm.nativesdk.R.id.tvOfferTitle
                android.view.View r2 = r2.findViewById(r6)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r5)
            L_0x007c:
                if (r0 == 0) goto L_0x0089
                net.one97.paytm.nativesdk.orflow.promo.model.Offer r2 = r0.getOffer()
                if (r2 == 0) goto L_0x0089
                java.lang.String r2 = r2.getIcon()
                goto L_0x008a
            L_0x0089:
                r2 = r1
            L_0x008a:
                java.lang.String r3 = "mView.ivOfferIcon"
                r6 = 1
                if (r2 == 0) goto L_0x00ed
                net.one97.paytm.nativesdk.orflow.promo.model.Offer r2 = r0.getOffer()
                if (r2 != 0) goto L_0x0098
                kotlin.g.b.k.a()
            L_0x0098:
                java.lang.String r2 = r2.getIcon()
                if (r2 != 0) goto L_0x00a1
                kotlin.g.b.k.a()
            L_0x00a1:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r2 = r2.length()
                if (r2 != 0) goto L_0x00ab
                r2 = 1
                goto L_0x00ac
            L_0x00ab:
                r2 = 0
            L_0x00ac:
                if (r2 == 0) goto L_0x00af
                goto L_0x00ed
            L_0x00af:
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.ivOfferIcon
                android.view.View r2 = r2.findViewById(r7)
                android.widget.ImageView r2 = (android.widget.ImageView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r5)
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r2 = r11.this$0
                android.content.Context r2 = r2.mContext
                com.bumptech.glide.i r2 = com.bumptech.glide.b.b(r2)
                net.one97.paytm.nativesdk.orflow.promo.model.Offer r3 = r0.getOffer()
                if (r3 == 0) goto L_0x00d4
                java.lang.String r3 = r3.getIcon()
                goto L_0x00d5
            L_0x00d4:
                r3 = r1
            L_0x00d5:
                com.bumptech.glide.h r2 = r2.a((java.lang.String) r3)
                android.view.View r3 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.ivOfferIcon
                android.view.View r3 = r3.findViewById(r7)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                com.bumptech.glide.e.a.k r2 = r2.a((android.widget.ImageView) r3)
                java.lang.String r3 = "Glide.with(mContext).loa…).into(mView.ivOfferIcon)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                goto L_0x00fd
            L_0x00ed:
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.ivOfferIcon
                android.view.View r2 = r2.findViewById(r7)
                android.widget.ImageView r2 = (android.widget.ImageView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r4)
            L_0x00fd:
                android.view.View r2 = r11.mView
                int r3 = net.one97.paytm.nativesdk.R.id.tvOfferText
                android.view.View r2 = r2.findViewById(r3)
                android.widget.TextView r2 = (android.widget.TextView) r2
                java.lang.String r3 = "mView.tvOfferText"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                if (r0 == 0) goto L_0x0113
                java.lang.String r3 = r0.getOfferText()
                goto L_0x0114
            L_0x0113:
                r3 = r1
            L_0x0114:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.setText(r3)
                if (r0 == 0) goto L_0x0120
                java.lang.String r2 = r0.getCode()
                goto L_0x0121
            L_0x0120:
                r2 = r1
            L_0x0121:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                java.lang.String r3 = "mView.tvOfferCode"
                if (r2 != 0) goto L_0x0156
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.tvOfferCode
                android.view.View r2 = r2.findViewById(r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                if (r0 == 0) goto L_0x013f
                java.lang.String r7 = r0.getCode()
                goto L_0x0140
            L_0x013f:
                r7 = r1
            L_0x0140:
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r2.setText(r7)
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.tvOfferCode
                android.view.View r2 = r2.findViewById(r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r5)
                goto L_0x0166
            L_0x0156:
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.tvOfferCode
                android.view.View r2 = r2.findViewById(r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r4)
            L_0x0166:
                if (r0 == 0) goto L_0x016b
                r0.getCode()
            L_0x016b:
                if (r0 == 0) goto L_0x0172
                java.lang.String r2 = r0.getPromoErrorMsg()
                goto L_0x0173
            L_0x0172:
                r2 = r1
            L_0x0173:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                java.lang.String r3 = "mView.tvErrorMsg"
                if (r2 != 0) goto L_0x01a8
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.tvErrorMsg
                android.view.View r2 = r2.findViewById(r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r5)
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.tvErrorMsg
                android.view.View r2 = r2.findViewById(r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                if (r0 == 0) goto L_0x01a1
                java.lang.String r3 = r0.getPromoErrorMsg()
                goto L_0x01a2
            L_0x01a1:
                r3 = r1
            L_0x01a2:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.setText(r3)
                goto L_0x01ba
            L_0x01a8:
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.tvErrorMsg
                android.view.View r2 = r2.findViewById(r7)
                android.widget.TextView r2 = (android.widget.TextView) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r3 = 8
                r2.setVisibility(r3)
            L_0x01ba:
                android.view.View r2 = r11.mView
                int r3 = net.one97.paytm.nativesdk.R.id.llGratification
                android.view.View r2 = r2.findViewById(r3)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                java.lang.String r3 = "mView.llGratification"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r4)
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.llGratification
                android.view.View r2 = r2.findViewById(r7)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                net.one97.paytm.nativesdk.orflow.Utility r7 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r8 = r11.this$0
                android.content.Context r8 = r8.mContext
                java.lang.String r9 = "null cannot be cast to non-null type android.app.Activity"
                if (r8 == 0) goto L_0x0388
                android.app.Activity r8 = (android.app.Activity) r8
                float r7 = r7.getDensity(r8)
                int r7 = (int) r7
                int r7 = r7 * 13
                r2.setPadding(r5, r5, r5, r7)
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.llGratification
                android.view.View r2 = r2.findViewById(r7)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                r2.removeAllViews()
                if (r0 == 0) goto L_0x02f8
                java.util.List r0 = r0.getGratifications()
                if (r0 == 0) goto L_0x02f8
                int r2 = r0.size()
                if (r2 <= r6) goto L_0x020b
                r2 = 1
                goto L_0x020c
            L_0x020b:
                r2 = 0
            L_0x020c:
                if (r2 == 0) goto L_0x020f
                goto L_0x0210
            L_0x020f:
                r0 = r1
            L_0x0210:
                if (r0 == 0) goto L_0x02f8
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.llGratification
                android.view.View r2 = r2.findViewById(r7)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                r2.setVisibility(r5)
                android.view.View r2 = r11.mView
                int r3 = net.one97.paytm.nativesdk.R.id.llGratification
                android.view.View r2 = r2.findViewById(r3)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                net.one97.paytm.nativesdk.orflow.Utility r3 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r7 = r11.this$0
                android.content.Context r7 = r7.mContext
                if (r7 == 0) goto L_0x02f2
                android.app.Activity r7 = (android.app.Activity) r7
                float r3 = r3.getDensity(r7)
                int r3 = (int) r3
                int r3 = r3 * 7
                r7 = 1095761920(0x41500000, float:13.0)
                net.one97.paytm.nativesdk.orflow.Utility r8 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r10 = r11.this$0
                android.content.Context r10 = r10.mContext
                if (r10 == 0) goto L_0x02ec
                android.app.Activity r10 = (android.app.Activity) r10
                float r8 = r8.getDensity(r10)
                float r8 = r8 * r7
                int r7 = (int) r8
                r2.setPadding(r5, r3, r5, r7)
                java.util.Iterator r0 = r0.iterator()
            L_0x025b:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x02f8
                java.lang.Object r2 = r0.next()
                net.one97.paytm.nativesdk.orflow.promo.model.Gratification r2 = (net.one97.paytm.nativesdk.orflow.promo.model.Gratification) r2
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r3 = r11.this$0
                android.content.Context r3 = r3.mContext
                android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
                int r7 = net.one97.paytm.nativesdk.R.layout.vh_gratification_item
                android.view.View r8 = r11.mView
                int r9 = net.one97.paytm.nativesdk.R.id.llGratification
                android.view.View r8 = r8.findViewById(r9)
                android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
                android.view.View r3 = r3.inflate(r7, r8, r5)
                java.lang.String r7 = "view"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
                int r7 = net.one97.paytm.nativesdk.R.id.tvGratificationTitle
                android.view.View r7 = r3.findViewById(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                java.lang.String r8 = "view.tvGratificationTitle"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
                if (r2 == 0) goto L_0x029a
                java.lang.String r8 = r2.getTitle()
                goto L_0x029b
            L_0x029a:
                r8 = r1
            L_0x029b:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r7.setText(r8)
                int r7 = net.one97.paytm.nativesdk.R.id.tvGratificationMsg
                android.view.View r7 = r3.findViewById(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                java.lang.String r8 = "view.tvGratificationMsg"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
                if (r2 == 0) goto L_0x02b4
                java.lang.String r8 = r2.getText()
                goto L_0x02b5
            L_0x02b4:
                r8 = r1
            L_0x02b5:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r7.setText(r8)
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r7 = r11.this$0
                android.content.Context r7 = r7.mContext
                android.app.Activity r7 = (android.app.Activity) r7
                com.bumptech.glide.i r7 = com.bumptech.glide.b.a((android.app.Activity) r7)
                if (r2 == 0) goto L_0x02cd
                java.lang.String r2 = r2.getIcon()
                goto L_0x02ce
            L_0x02cd:
                r2 = r1
            L_0x02ce:
                com.bumptech.glide.h r2 = r7.a((java.lang.String) r2)
                int r7 = net.one97.paytm.nativesdk.R.id.ivGratificationIcon
                android.view.View r7 = r3.findViewById(r7)
                android.widget.ImageView r7 = (android.widget.ImageView) r7
                r2.a((android.widget.ImageView) r7)
                android.view.View r2 = r11.mView
                int r7 = net.one97.paytm.nativesdk.R.id.llGratification
                android.view.View r2 = r2.findViewById(r7)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                r2.addView(r3)
                goto L_0x025b
            L_0x02ec:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r9)
                throw r0
            L_0x02f2:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r9)
                throw r0
            L_0x02f8:
                android.view.View r0 = r11.mView
                int r1 = net.one97.paytm.nativesdk.R.id.tvApplyOffer
                android.view.View r0 = r0.findViewById(r1)
                android.widget.TextView r0 = (android.widget.TextView) r0
                java.lang.String r1 = "mView.tvApplyOffer"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                int r1 = r11.getAdapterPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.setTag(r1)
                android.view.View r0 = r11.mView
                int r1 = net.one97.paytm.nativesdk.R.id.tvApplyOffer
                android.view.View r0 = r0.findViewById(r1)
                android.widget.TextView r0 = (android.widget.TextView) r0
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r1 = r11.this$0
                android.view.View$OnClickListener r1 = r1.onClickListener
                r0.setOnClickListener(r1)
                android.view.View r0 = r11.mView
                int r1 = net.one97.paytm.nativesdk.R.id.llOfferDetails
                android.view.View r0 = r0.findViewById(r1)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                java.lang.String r1 = "mView.llOfferDetails"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                int r1 = r11.getAdapterPosition()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.setTag(r1)
                android.view.View r0 = r11.mView
                int r1 = net.one97.paytm.nativesdk.R.id.llOfferDetails
                android.view.View r0 = r0.findViewById(r1)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r1 = r11.this$0
                android.view.View$OnClickListener r1 = r1.onClickListener
                r0.setOnClickListener(r1)
                int r0 = r11.getAdapterPosition()
                net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter r1 = r11.this$0
                java.util.List r1 = r1.mItemList
                if (r1 != 0) goto L_0x0361
                kotlin.g.b.k.a()
            L_0x0361:
                int r1 = r1.size()
                int r1 = r1 - r6
                java.lang.String r2 = "mView.bottom_separator"
                if (r0 != r1) goto L_0x0379
                android.view.View r0 = r11.mView
                int r1 = net.one97.paytm.nativesdk.R.id.bottom_separator
                android.view.View r0 = r0.findViewById(r1)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r0.setVisibility(r4)
                return
            L_0x0379:
                android.view.View r0 = r11.mView
                int r1 = net.one97.paytm.nativesdk.R.id.bottom_separator
                android.view.View r0 = r0.findViewById(r1)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                r0.setVisibility(r5)
                return
            L_0x0388:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoListAdapter.PromoItemViewHolder.populateView():void");
        }
    }
}
