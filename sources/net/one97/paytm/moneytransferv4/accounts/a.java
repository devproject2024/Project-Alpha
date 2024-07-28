package net.one97.paytm.moneytransferv4.accounts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.c.p;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    boolean f54878a;

    /* renamed from: b  reason: collision with root package name */
    int f54879b = -1;

    /* renamed from: c  reason: collision with root package name */
    String f54880c = "";

    /* renamed from: d  reason: collision with root package name */
    final Map<String, String> f54881d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    boolean f54882e;

    /* renamed from: f  reason: collision with root package name */
    int f54883f = -1;

    /* renamed from: g  reason: collision with root package name */
    int f54884g = -1;

    /* renamed from: h  reason: collision with root package name */
    List<? extends BankAccountDetails.BankAccount> f54885h;

    /* renamed from: i  reason: collision with root package name */
    final b f54886i;
    private final int j;
    private final int k = 1;

    public interface b {
        void a();

        void a(BankAccountDetails.BankAccount bankAccount);

        void a(BankAccountDetails.BankAccount bankAccount, boolean z);

        void b(BankAccountDetails.BankAccount bankAccount);
    }

    public a(List<? extends BankAccountDetails.BankAccount> list, b bVar) {
        k.c(list, "list");
        k.c(bVar, "listener");
        this.f54885h = list;
        this.f54886i = bVar;
    }

    public final int getItemViewType(int i2) {
        if (i2 == this.f54885h.size()) {
            return this.k;
        }
        return this.j;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.j) {
            net.one97.paytm.moneytransfer.c.a a2 = net.one97.paytm.moneytransfer.c.a.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
            k.a((Object) a2, "AccAndBalHistoryItemView….context), parent, false)");
            return new c(this, a2);
        }
        p a3 = p.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a3, "MtAddMoreAccountBinding.….context), parent, false)");
        return new C0986a(this, a3);
    }

    public final int getItemCount() {
        return this.f54885h.size() + 1;
    }

    public final void a(boolean z) {
        this.f54878a = z;
        int i2 = this.f54879b;
        notifyItemChanged(i2, Integer.valueOf(i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0220  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r9, r0)
            boolean r0 = r9 instanceof net.one97.paytm.moneytransferv4.accounts.a.c
            r1 = 4
            r2 = 0
            if (r0 == 0) goto L_0x0284
            net.one97.paytm.moneytransferv4.accounts.a$c r9 = (net.one97.paytm.moneytransferv4.accounts.a.c) r9
            java.util.List<? extends net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount> r0 = r8.f54885h
            java.lang.Object r10 = r0.get(r10)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r10 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r10
            java.lang.String r0 = "bankAccount"
            kotlin.g.b.k.c(r10, r0)
            net.one97.paytm.moneytransferv4.accounts.a r0 = r9.f54891b
            int r0 = r0.f54879b
            int r3 = r9.getAdapterPosition()
            r4 = 1
            if (r0 != r3) goto L_0x0051
            net.one97.paytm.moneytransferv4.accounts.a r0 = r9.f54891b
            java.lang.String r0 = r0.f54880c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.m.p.a(r0)
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x0051
            net.one97.paytm.moneytransferv4.accounts.a r0 = r9.f54891b
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.f54881d
            java.lang.String r3 = r10.getAccRefId()
            java.lang.String r5 = "bankAccount.accRefId"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            net.one97.paytm.moneytransferv4.accounts.a r5 = r9.f54891b
            java.lang.String r5 = r5.f54880c
            r0.put(r3, r5)
            net.one97.paytm.moneytransferv4.accounts.a r0 = r9.f54891b
            java.lang.String r3 = ""
            r0.f54880c = r3
            net.one97.paytm.moneytransferv4.accounts.a r0 = r9.f54891b
            r3 = -1
            r0.f54879b = r3
        L_0x0051:
            net.one97.paytm.moneytransfer.c.a r0 = r9.f54890a
            java.lang.String r3 = r10.getMaskedAccountNumber()
            java.lang.String r5 = "bankAccount.maskedAccountNumber"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r5 = r10.getMaskedAccountNumber()
            int r5 = r5.length()
            int r5 = r5 - r1
            if (r3 == 0) goto L_0x027c
            java.lang.String r1 = r3.substring(r5)
            java.lang.String r3 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            android.widget.TextView r1 = r0.f53593e
            java.lang.String r3 = "bankName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r3 = r10.getBankName()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            java.lang.String r1 = r10.getBankLogoUrl()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0091
            boolean r1 = kotlin.m.p.a(r1)
            if (r1 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r1 = 0
            goto L_0x0092
        L_0x0091:
            r1 = 1
        L_0x0092:
            java.lang.String r3 = "root"
            if (r1 != 0) goto L_0x00bf
            java.lang.String r1 = r10.getBankLogoUrl()
            boolean r1 = android.webkit.URLUtil.isValidUrl(r1)
            if (r1 != 0) goto L_0x00a1
            goto L_0x00bf
        L_0x00a1:
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r5 = r10.getBankLogoUrl()
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r5)
            int r5 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r1 = r1.a((int) r5)
            int r5 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r1 = r1.b((int) r5)
            android.widget.ImageView r5 = r0.f53591c
            r1.a((android.widget.ImageView) r5)
            goto L_0x00d3
        L_0x00bf:
            android.widget.ImageView r1 = r0.f53591c
            java.lang.String r5 = r10.getIfsc()
            androidx.constraintlayout.widget.ConstraintLayout r6 = r0.a()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            android.content.Context r6 = r6.getContext()
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r1, (java.lang.String) r5, (android.content.Context) r6)
        L_0x00d3:
            net.one97.paytm.moneytransferv4.accounts.a r1 = r9.f54891b
            boolean r1 = r1.f54878a
            if (r1 == 0) goto L_0x00e9
            int r1 = r9.getAdapterPosition()
            net.one97.paytm.moneytransferv4.accounts.a r5 = r9.f54891b
            int r5 = r5.f54879b
            if (r1 != r5) goto L_0x00e9
            com.airbnb.lottie.LottieAnimationView r1 = r0.f53595g
            net.one97.paytm.upi.util.AnimationFactory.startWalletLoader(r1)
            goto L_0x00ee
        L_0x00e9:
            com.airbnb.lottie.LottieAnimationView r1 = r0.f53595g
            net.one97.paytm.upi.util.AnimationFactory.stopWalletLoader(r1)
        L_0x00ee:
            android.widget.TextView r1 = r0.f53594f
            r5 = r1
            android.view.View r5 = (android.view.View) r5
            boolean r6 = r10.isMpinSet()
            if (r6 == 0) goto L_0x0118
            net.one97.paytm.moneytransferv4.accounts.a r6 = r9.f54891b
            java.util.Map<java.lang.String, java.lang.String> r6 = r6.f54881d
            java.lang.String r7 = r10.getAccRefId()
            java.lang.Object r6 = r6.get(r7)
            if (r6 != 0) goto L_0x0118
            com.airbnb.lottie.LottieAnimationView r6 = r0.f53595g
            java.lang.String r7 = "lottieLoader"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.view.View r6 = (android.view.View) r6
            boolean r6 = net.one97.paytm.upi.f.d(r6)
            if (r6 != 0) goto L_0x0118
            r6 = 1
            goto L_0x0119
        L_0x0118:
            r6 = 0
        L_0x0119:
            net.one97.paytm.upi.f.a((android.view.View) r5, (boolean) r6)
            net.one97.paytm.moneytransferv4.accounts.a$c$a r5 = new net.one97.paytm.moneytransferv4.accounts.a$c$a
            r5.<init>(r0, r9, r10)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r1.setOnClickListener(r5)
            android.widget.TextView r1 = r0.f53589a
            r5 = r1
            android.view.View r5 = (android.view.View) r5
            net.one97.paytm.moneytransferv4.accounts.a r6 = r9.f54891b
            java.util.Map<java.lang.String, java.lang.String> r6 = r6.f54881d
            java.lang.String r7 = r10.getAccRefId()
            boolean r6 = r6.containsKey(r7)
            net.one97.paytm.upi.f.a((android.view.View) r5, (boolean) r6)
            net.one97.paytm.moneytransferv4.accounts.a r5 = r9.f54891b
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.f54881d
            java.lang.String r6 = r10.getAccRefId()
            java.lang.Object r5 = r5.get(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            android.widget.TextView r1 = r0.l
            r5 = r1
            android.view.View r5 = (android.view.View) r5
            boolean r6 = r10.isMpinSet()
            r6 = r6 ^ r4
            net.one97.paytm.upi.f.a((android.view.View) r5, (boolean) r6)
            net.one97.paytm.moneytransferv4.accounts.a$c$b r5 = new net.one97.paytm.moneytransferv4.accounts.a$c$b
            r5.<init>(r9, r10)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r1.setOnClickListener(r5)
            android.view.View r1 = r9.itemView
            net.one97.paytm.moneytransferv4.accounts.a$c$c r5 = new net.one97.paytm.moneytransferv4.accounts.a$c$c
            r5.<init>(r0, r9, r10)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r1.setOnClickListener(r5)
            android.widget.RadioButton r1 = r0.j
            java.lang.String r5 = "radioButton"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.moneytransferv4.accounts.a r6 = r9.f54891b
            boolean r6 = r6.f54882e
            net.one97.paytm.upi.f.a((android.view.View) r1, (boolean) r6)
            android.widget.RadioButton r1 = r0.j
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.moneytransferv4.accounts.a r5 = r9.f54891b
            boolean r5 = r5.f54882e
            if (r5 == 0) goto L_0x0195
            net.one97.paytm.moneytransferv4.accounts.a r5 = r9.f54891b
            int r5 = r5.f54883f
            int r6 = r9.getAdapterPosition()
            if (r5 != r6) goto L_0x0195
            r5 = 1
            goto L_0x0196
        L_0x0195:
            r5 = 0
        L_0x0196:
            r1.setChecked(r5)
            android.widget.RadioButton r1 = r0.j
            net.one97.paytm.moneytransferv4.accounts.a$c$d r5 = new net.one97.paytm.moneytransferv4.accounts.a$c$d
            r5.<init>(r9, r10)
            android.widget.CompoundButton$OnCheckedChangeListener r5 = (android.widget.CompoundButton.OnCheckedChangeListener) r5
            r1.setOnCheckedChangeListener(r5)
            androidx.cardview.widget.CardView r1 = r0.f53596h
            java.lang.String r5 = "primaryDotView"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            android.view.View r1 = (android.view.View) r1
            java.lang.Boolean r5 = r10.getPrimaryAccount()
            java.lang.String r6 = "bankAccount.primaryAccount"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            boolean r5 = r5.booleanValue()
            net.one97.paytm.upi.f.a((android.view.View) r1, (boolean) r5)
            android.widget.TextView r1 = r0.f53597i
            java.lang.String r5 = "primaryTextView"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            android.view.View r1 = (android.view.View) r1
            java.lang.Boolean r5 = r10.getPrimaryAccount()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            boolean r5 = r5.booleanValue()
            net.one97.paytm.upi.f.a((android.view.View) r1, (boolean) r5)
            java.lang.Boolean r1 = r10.getPrimaryAccount()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01ea
            net.one97.paytm.moneytransferv4.accounts.a r1 = r9.f54891b
            int r9 = r9.getAdapterPosition()
            r1.f54884g = r9
        L_0x01ea:
            java.lang.String r9 = r10.getAccountType()
            java.lang.String r1 = "CURRENT"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r1)
            java.lang.String r1 = "bankAccNumber"
            if (r9 == 0) goto L_0x0220
            android.widget.TextView r9 = r0.f53590b
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.Context r0 = r0.getContext()
            int r1 = net.one97.paytm.moneytransfer.R.string.mt_current_acc_number
            java.lang.Object[] r3 = new java.lang.Object[r4]
            java.lang.String r10 = r10.getAccount()
            java.lang.String r10 = net.one97.paytm.upi.util.UpiAppUtils.getAccountNoV4Format(r10)
            r3[r2] = r10
            java.lang.String r10 = r0.getString(r1, r3)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
            return
        L_0x0220:
            java.lang.String r9 = r10.getAccountType()
            java.lang.String r5 = "SAVINGS"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r5)
            if (r9 == 0) goto L_0x0254
            android.widget.TextView r9 = r0.f53590b
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.Context r0 = r0.getContext()
            int r1 = net.one97.paytm.moneytransfer.R.string.mt_saving_acc_number
            java.lang.Object[] r3 = new java.lang.Object[r4]
            java.lang.String r10 = r10.getAccount()
            java.lang.String r10 = net.one97.paytm.upi.util.UpiAppUtils.getAccountNoV4Format(r10)
            r3[r2] = r10
            java.lang.String r10 = r0.getString(r1, r3)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
            return
        L_0x0254:
            android.widget.TextView r9 = r0.f53590b
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.Context r0 = r0.getContext()
            int r1 = net.one97.paytm.moneytransfer.R.string.mt_acc_number
            java.lang.Object[] r3 = new java.lang.Object[r4]
            java.lang.String r10 = r10.getAccount()
            java.lang.String r10 = net.one97.paytm.upi.util.UpiAppUtils.getAccountNoV4Format(r10)
            r3[r2] = r10
            java.lang.String r10 = r0.getString(r1, r3)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
            return
        L_0x027c:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type java.lang.String"
            r9.<init>(r10)
            throw r9
        L_0x0284:
            boolean r10 = r9 instanceof net.one97.paytm.moneytransferv4.accounts.a.C0986a
            if (r10 == 0) goto L_0x02bd
            net.one97.paytm.moneytransferv4.accounts.a$a r9 = (net.one97.paytm.moneytransferv4.accounts.a.C0986a) r9
            net.one97.paytm.moneytransfer.c.p r10 = r9.f54887a
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.a()
            net.one97.paytm.moneytransferv4.accounts.a$a$a r3 = new net.one97.paytm.moneytransferv4.accounts.a$a$a
            r3.<init>(r9)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r0.setOnClickListener(r3)
            net.one97.paytm.moneytransferv4.accounts.a r9 = r9.f54888b
            boolean r9 = r9.f54878a
            java.lang.String r0 = "addMoreBankGroup"
            if (r9 == 0) goto L_0x02b0
            androidx.constraintlayout.widget.Group r9 = r10.f53813c
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r9.setVisibility(r1)
            com.airbnb.lottie.LottieAnimationView r9 = r10.f53814d
            net.one97.paytm.upi.util.AnimationFactory.startWalletLoader(r9)
            return
        L_0x02b0:
            androidx.constraintlayout.widget.Group r9 = r10.f53813c
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r9.setVisibility(r2)
            com.airbnb.lottie.LottieAnimationView r9 = r10.f53814d
            net.one97.paytm.upi.util.AnimationFactory.stopWalletLoader(r9)
        L_0x02bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accounts.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final void b(boolean z) {
        this.f54883f = -1;
        this.f54882e = z;
        notifyDataSetChanged();
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final net.one97.paytm.moneytransfer.c.a f54890a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f54891b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, net.one97.paytm.moneytransfer.c.a aVar2) {
            super(aVar2.a());
            k.c(aVar2, "binding");
            this.f54891b = aVar;
            this.f54890a = aVar2;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.accounts.a$c$a  reason: collision with other inner class name */
        static final class C0988a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.moneytransfer.c.a f54892a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f54893b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54894c;

            C0988a(net.one97.paytm.moneytransfer.c.a aVar, c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54892a = aVar;
                this.f54893b = cVar;
                this.f54894c = bankAccount;
            }

            public final void onClick(View view) {
                if (!this.f54893b.f54891b.f54878a) {
                    this.f54893b.f54891b.f54879b = this.f54893b.getAdapterPosition();
                    this.f54893b.f54891b.f54886i.a(this.f54894c);
                }
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f54895a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54896b;

            b(c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54895a = cVar;
                this.f54896b = bankAccount;
            }

            public final void onClick(View view) {
                this.f54895a.f54891b.f54886i.a(this.f54896b, false);
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.accounts.a$c$c  reason: collision with other inner class name */
        static final class C0989c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.moneytransfer.c.a f54897a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f54898b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54899c;

            C0989c(net.one97.paytm.moneytransfer.c.a aVar, c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54897a = aVar;
                this.f54898b = cVar;
                this.f54899c = bankAccount;
            }

            public final void onClick(View view) {
                if (this.f54898b.f54891b.f54882e) {
                    RadioButton radioButton = this.f54897a.j;
                    k.a((Object) radioButton, "radioButton");
                    radioButton.setChecked(true);
                }
            }
        }

        static final class d implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f54900a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BankAccountDetails.BankAccount f54901b;

            d(c cVar, BankAccountDetails.BankAccount bankAccount) {
                this.f54900a = cVar;
                this.f54901b = bankAccount;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z && this.f54900a.f54891b.f54883f != this.f54900a.getAdapterPosition()) {
                    int i2 = this.f54900a.f54891b.f54883f;
                    this.f54900a.f54891b.f54883f = this.f54900a.getAdapterPosition();
                    this.f54900a.f54891b.notifyItemChanged(i2, Integer.valueOf(i2));
                    this.f54900a.f54891b.f54886i.b(this.f54901b);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.accounts.a$a  reason: collision with other inner class name */
    public final class C0986a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final p f54887a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f54888b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0986a(a aVar, p pVar) {
            super(pVar.a());
            k.c(pVar, "binding");
            this.f54888b = aVar;
            this.f54887a = pVar;
        }

        /* renamed from: net.one97.paytm.moneytransferv4.accounts.a$a$a  reason: collision with other inner class name */
        static final class C0987a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0986a f54889a;

            C0987a(C0986a aVar) {
                this.f54889a = aVar;
            }

            public final void onClick(View view) {
                this.f54889a.f54888b.f54886i.a();
            }
        }
    }
}
