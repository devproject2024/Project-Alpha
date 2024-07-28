package net.one97.paytm.coins.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.coins.e.a;
import net.one97.paytm.coins.model.LoyaltyModel;
import net.one97.paytm.coins.model.TransactionHeader;
import net.one97.paytm.vipcashback.R;

public final class a extends RecyclerView.a<RecyclerView.v> implements a.C0250a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<LoyaltyModel> f16638a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    d f16639b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16640c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16641d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f16642e = 2;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f16643f;

    /* renamed from: g  reason: collision with root package name */
    private c f16644g;

    public interface c {
        void a();
    }

    public interface d {
        void a(LoyaltyModel loyaltyModel);
    }

    public a(c cVar, d dVar) {
        k.c(cVar, "listener");
        k.c(dVar, "itemOperationsListener");
        this.f16644g = cVar;
        this.f16639b = dVar;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        C0244a aVar;
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        k.a((Object) from, "LayoutInflater.from(parent.context)");
        this.f16643f = from;
        if (i2 == this.f16640c) {
            LayoutInflater layoutInflater = this.f16643f;
            if (layoutInflater == null) {
                k.a("mInflater");
            }
            View inflate = layoutInflater.inflate(R.layout.coins_new_search_header_item, viewGroup, false);
            k.a((Object) inflate, "mInflater.inflate(R.layo…ader_item, parent, false)");
            aVar = new e(inflate);
        } else {
            LayoutInflater layoutInflater2 = this.f16643f;
            if (layoutInflater2 == null) {
                k.a("mInflater");
            }
            View inflate2 = layoutInflater2.inflate(R.layout.coins_subwallet_txn_item_layout, (ViewGroup) null);
            k.a((Object) inflate2, "mInflater.inflate(R.layo…et_txn_item_layout, null)");
            aVar = new b(this, inflate2);
        }
        return aVar;
    }

    public final int getItemCount() {
        ArrayList<LoyaltyModel> arrayList = this.f16638a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f16638a.get(i2) instanceof TransactionHeader) {
            return this.f16640c;
        }
        return this.f16641d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0292  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r13, int r14) {
        /*
            r12 = this;
            java.lang.String r0 = "baseTransactionsHolder"
            kotlin.g.b.k.c(r13, r0)
            java.util.ArrayList<net.one97.paytm.coins.model.LoyaltyModel> r0 = r12.f16638a
            java.lang.Object r0 = r0.get(r14)
            java.lang.String r1 = "mTransactionList[position]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.coins.model.LoyaltyModel r0 = (net.one97.paytm.coins.model.LoyaltyModel) r0
            boolean r1 = r13 instanceof net.one97.paytm.coins.a.a.b
            java.lang.String r2 = "transaction"
            r3 = 1
            if (r1 == 0) goto L_0x029e
            net.one97.paytm.coins.a.a$b r13 = (net.one97.paytm.coins.a.a.b) r13
            kotlin.g.b.k.c(r0, r2)
            android.view.View r1 = r13.itemView
            java.lang.String r2 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Context r1 = r1.getContext()
            r13.f16645a = r0
            net.one97.paytm.coins.model.ExtendedInfoModel r4 = r0.getExtendInfo()
            r5 = 0
            if (r4 == 0) goto L_0x0093
            net.one97.paytm.coins.model.ExtendedInfoModel r4 = r0.getExtendInfo()
            if (r4 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            java.lang.String r4 = r4.getOfferIconImage()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x004d
            int r4 = r4.length()
            if (r4 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r4 = 0
            goto L_0x004e
        L_0x004d:
            r4 = 1
        L_0x004e:
            if (r4 != 0) goto L_0x0093
            net.one97.paytm.coins.model.ExtendedInfoModel r4 = r0.getExtendInfo()
            if (r4 != 0) goto L_0x0059
            kotlin.g.b.k.a()
        L_0x0059:
            java.lang.String r4 = r4.getOfferIconImage()
            boolean r4 = android.webkit.URLUtil.isValidUrl(r4)
            if (r4 == 0) goto L_0x0093
            com.squareup.picasso.w r4 = com.squareup.picasso.w.a()
            net.one97.paytm.coins.model.ExtendedInfoModel r6 = r0.getExtendInfo()
            if (r6 != 0) goto L_0x0070
            kotlin.g.b.k.a()
        L_0x0070:
            java.lang.String r6 = r6.getOfferIconImage()
            com.squareup.picasso.aa r4 = r4.a((java.lang.String) r6)
            net.one97.paytm.coins.customview.a r6 = new net.one97.paytm.coins.customview.a
            r6.<init>()
            com.squareup.picasso.ah r6 = (com.squareup.picasso.ah) r6
            com.squareup.picasso.aa r4 = r4.a((com.squareup.picasso.ah) r6)
            android.view.View r6 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            int r7 = net.one97.paytm.vipcashback.R.id.iv_icon
            android.view.View r6 = r6.findViewById(r7)
            net.one97.paytm.coins.customview.CircularImageView r6 = (net.one97.paytm.coins.customview.CircularImageView) r6
            r4.a((android.widget.ImageView) r6)
        L_0x0093:
            java.lang.String r4 = r0.getAccountingType()
            java.lang.String r6 = "CREDIT"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x00a4
            int r4 = net.one97.paytm.vipcashback.R.color.color_21c17a
            java.lang.String r6 = "+ "
            goto L_0x00b8
        L_0x00a4:
            java.lang.String r4 = r0.getAccountingType()
            java.lang.String r6 = "DEBIT"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x00b5
            int r4 = net.one97.paytm.vipcashback.R.color.color_222222
            java.lang.String r6 = "- "
            goto L_0x00b8
        L_0x00b5:
            java.lang.String r6 = ""
            r4 = 0
        L_0x00b8:
            java.lang.String r7 = r0.getAccountingAmount()
            r8 = 8
            java.lang.String r9 = "itemView.tv_amount"
            if (r7 == 0) goto L_0x0115
            android.view.View r7 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            int r10 = net.one97.paytm.vipcashback.R.id.tv_amount
            android.view.View r7 = r7.findViewById(r10)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r6 = r0.getAccountingAmount()
            if (r6 != 0) goto L_0x00e3
            kotlin.g.b.k.a()
        L_0x00e3:
            double r10 = java.lang.Double.parseDouble(r6)
            java.lang.String r6 = net.one97.paytm.coins.c.e.a(r10)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
            android.view.View r6 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            int r7 = net.one97.paytm.vipcashback.R.id.tv_amount
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            android.view.View r7 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            android.content.Context r7 = r7.getContext()
            int r4 = androidx.core.content.b.c(r7, r4)
            r6.setTextColor(r4)
            goto L_0x0128
        L_0x0115:
            android.view.View r4 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r6 = net.one97.paytm.vipcashback.R.id.tv_amount
            android.view.View r4 = r4.findViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            r4.setVisibility(r8)
        L_0x0128:
            net.one97.paytm.coins.model.ExtendedInfoModel r4 = r0.getExtendInfo()
            java.lang.String r6 = "itemView.tv_receive_type"
            if (r4 == 0) goto L_0x0171
            net.one97.paytm.coins.model.ExtendedInfoModel r4 = r0.getExtendInfo()
            if (r4 != 0) goto L_0x0139
            kotlin.g.b.k.a()
        L_0x0139:
            java.lang.String r4 = r4.getDisplayName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x014a
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r4 = 0
            goto L_0x014b
        L_0x014a:
            r4 = 1
        L_0x014b:
            if (r4 != 0) goto L_0x0171
            android.view.View r4 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r7 = net.one97.paytm.vipcashback.R.id.tv_receive_type
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            net.one97.paytm.coins.model.ExtendedInfoModel r6 = r0.getExtendInfo()
            if (r6 != 0) goto L_0x0166
            kotlin.g.b.k.a()
        L_0x0166:
            java.lang.String r6 = r6.getDisplayName()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            goto L_0x01e8
        L_0x0171:
            java.lang.String r4 = r0.getTransactionType()
            java.lang.String r7 = "REFUND"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0199
            android.view.View r4 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r7 = net.one97.paytm.vipcashback.R.id.tv_receive_type
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            int r6 = net.one97.paytm.vipcashback.R.string.jr_pc_coins_refunded
            java.lang.String r6 = r1.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            goto L_0x01e8
        L_0x0199:
            java.lang.String r4 = r0.getTransactionType()
            java.lang.String r7 = "PAY"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x01c1
            android.view.View r4 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r7 = net.one97.paytm.vipcashback.R.id.tv_receive_type
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            int r6 = net.one97.paytm.vipcashback.R.string.jr_pc_coins_redeemed
            java.lang.String r6 = r1.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            goto L_0x01e8
        L_0x01c1:
            java.lang.String r4 = r0.getTransactionType()
            java.lang.String r7 = "REWARD"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x01e8
            android.view.View r4 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r7 = net.one97.paytm.vipcashback.R.id.tv_receive_type
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            int r6 = net.one97.paytm.vipcashback.R.string.jr_pc_coins_received
            java.lang.String r6 = r1.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
        L_0x01e8:
            android.view.View r4 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r6 = net.one97.paytm.vipcashback.R.id.tv_send_receive_time
            android.view.View r4 = r4.findViewById(r6)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            java.lang.String r6 = "itemView.tv_send_receive_time"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r6 = r0.getFormattedTxnTime()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r4.setText(r6)
            java.lang.String r4 = r0.getActiveBalance()
            java.lang.String r6 = "itemView.passbook_closing_balance"
            if (r4 == 0) goto L_0x024f
            android.view.View r4 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r7 = net.one97.paytm.vipcashback.R.id.passbook_closing_balance
            android.view.View r4 = r4.findViewById(r7)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            int r7 = net.one97.paytm.vipcashback.R.string.coins_closing_balance
            java.lang.Object[] r8 = new java.lang.Object[r3]
            java.lang.String r9 = r0.getActiveBalance()
            if (r9 != 0) goto L_0x0228
            kotlin.g.b.k.a()
        L_0x0228:
            double r9 = java.lang.Double.parseDouble(r9)
            java.lang.String r9 = net.one97.paytm.coins.c.e.a(r9)
            r8[r5] = r9
            java.lang.String r1 = r1.getString(r7, r8)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r4 = net.one97.paytm.vipcashback.R.id.passbook_closing_balance
            android.view.View r1 = r1.findViewById(r4)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r1.setVisibility(r5)
            goto L_0x0262
        L_0x024f:
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r4 = net.one97.paytm.vipcashback.R.id.passbook_closing_balance
            android.view.View r1 = r1.findViewById(r4)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r1.setVisibility(r8)
        L_0x0262:
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r2 = net.one97.paytm.vipcashback.R.id.passbook_entry_row_detail_rl
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            net.one97.paytm.coins.a.a$b$a r2 = new net.one97.paytm.coins.a.a$b$a
            r2.<init>(r13, r14, r0)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            int r0 = r14 + 1
            java.util.ArrayList<net.one97.paytm.coins.model.LoyaltyModel> r1 = r12.f16638a
            int r1 = r1.size()
            int r1 = r1 - r3
            if (r0 >= r1) goto L_0x0292
            java.util.ArrayList<net.one97.paytm.coins.model.LoyaltyModel> r1 = r12.f16638a
            java.lang.Object r0 = r1.get(r0)
            boolean r0 = r0 instanceof net.one97.paytm.coins.model.TransactionHeader
            if (r0 == 0) goto L_0x02b6
            r13.a()
            goto L_0x02b6
        L_0x0292:
            java.util.ArrayList<net.one97.paytm.coins.model.LoyaltyModel> r1 = r12.f16638a
            int r1 = r1.size()
            if (r0 != r1) goto L_0x02b6
            r13.a()
            goto L_0x02b6
        L_0x029e:
            boolean r1 = r13 instanceof net.one97.paytm.coins.a.a.e
            if (r1 == 0) goto L_0x02b6
            net.one97.paytm.coins.a.a$e r13 = (net.one97.paytm.coins.a.a.e) r13
            kotlin.g.b.k.c(r0, r2)
            boolean r1 = r0 instanceof net.one97.paytm.coins.model.TransactionHeader
            if (r1 == 0) goto L_0x02b6
            android.widget.TextView r13 = r13.f16650a
            java.lang.String r0 = r0.getTxnDate()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setText(r0)
        L_0x02b6:
            java.util.ArrayList<net.one97.paytm.coins.model.LoyaltyModel> r13 = r12.f16638a
            int r13 = r13.size()
            int r13 = r13 - r3
            int r0 = r12.f16642e
            int r13 = r13 - r0
            if (r14 != r13) goto L_0x02c7
            net.one97.paytm.coins.a.a$c r13 = r12.f16644g
            r13.a()
        L_0x02c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.a.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final class b extends C0244a {

        /* renamed from: a  reason: collision with root package name */
        public LoyaltyModel f16645a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f16646b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f16646b = aVar;
        }

        /* renamed from: net.one97.paytm.coins.a.a$b$a  reason: collision with other inner class name */
        static final class C0245a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f16647a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f16648b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ LoyaltyModel f16649c;

            C0245a(b bVar, int i2, LoyaltyModel loyaltyModel) {
                this.f16647a = bVar;
                this.f16648b = i2;
                this.f16649c = loyaltyModel;
            }

            public final void onClick(View view) {
                this.f16647a.f16646b.f16639b.a(this.f16649c);
            }
        }

        public final void a() {
            View view = this.itemView;
            k.a((Object) view, "itemView");
            View findViewById = view.findViewById(R.id.bottom_separator);
            k.a((Object) findViewById, "itemView.bottom_separator");
            findViewById.setVisibility(8);
        }
    }

    public static final class e extends C0244a {

        /* renamed from: a  reason: collision with root package name */
        final TextView f16650a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.date);
            k.a((Object) findViewById, "itemView.findViewById(R.id.date)");
            this.f16650a = (TextView) findViewById;
        }
    }

    /* renamed from: net.one97.paytm.coins.a.a$a  reason: collision with other inner class name */
    public static class C0244a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0244a(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }

    public final int a(int i2) {
        while (!c(i2)) {
            i2--;
            if (i2 < 0) {
                return 0;
            }
        }
        return i2;
    }

    public final int b(int i2) {
        if (this.f16638a.get(i2) instanceof TransactionHeader) {
            return R.layout.coins_new_search_header_item;
        }
        return R.layout.coins_subwallet_txn_item_layout;
    }

    public final void a(View view, int i2) {
        k.c(view, H5Logger.HEADER);
        TextView textView = (TextView) view.findViewById(R.id.date);
        LoyaltyModel loyaltyModel = this.f16638a.get(i2);
        if (loyaltyModel != null) {
            k.a((Object) textView, "tvHeader");
            textView.setText(((TransactionHeader) loyaltyModel).getTxnDate());
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.coins.model.TransactionHeader");
    }

    public final boolean c(int i2) {
        try {
            return this.f16638a.get(i2) instanceof TransactionHeader;
        } catch (Exception unused) {
            return false;
        }
    }
}
