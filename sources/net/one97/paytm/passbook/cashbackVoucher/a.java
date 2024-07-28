package net.one97.paytm.passbook.cashbackVoucher;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRCashWalletResponse;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.mgv.UserTemplateDetail;
import net.one97.paytm.passbook.beans.mlv.MLVCardTemplate;
import net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse;
import net.one97.paytm.passbook.beans.mlv.Response;
import net.one97.paytm.passbook.beans.mlv.Result;
import net.one97.paytm.passbook.beans.mlv.UserMLVTemplateDetail;
import net.one97.paytm.passbook.main.entity.MultiSubWallet;
import net.one97.paytm.passbook.main.widget.CashBackVoucherCardView;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.mgv.activity.MGVMainActivity;
import net.one97.paytm.passbook.mlv.activity.MLVMainActivity;
import net.one97.paytm.passbook.mlv.activity.MLVTemplateActivity;
import net.one97.paytm.passbook.mlv.d.a;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<Integer> f57139a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public TextView[] f57140b;

    /* renamed from: c  reason: collision with root package name */
    final CashbackVoucherActivity f57141c;

    /* renamed from: d  reason: collision with root package name */
    private final int f57142d = 20;

    public a(CashbackVoucherActivity cashbackVoucherActivity) {
        k.c(cashbackVoucherActivity, "activity");
        this.f57141c = cashbackVoucherActivity;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashBackVoucherCardView f57145a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserTemplateDetail f57146b;

        c(CashBackVoucherCardView cashBackVoucherCardView, UserTemplateDetail userTemplateDetail) {
            this.f57145a = cashBackVoucherCardView;
            this.f57146b = userTemplateDetail;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f57145a.getContext(), MGVMainActivity.class);
            intent.putExtra("data", this.f57146b);
            this.f57145a.getContext().startActivity(intent);
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "mgv_item_clicked", (String) null, (String) null, "/uth_passbook_myaccounts/cb_voucher", "PASSBOOK");
        }
    }

    private final void a(f<MlvTemplateListResponse> fVar) {
        LinearLayout linearLayout = (LinearLayout) this.f57141c.a(R.id.mlvItemLayout);
        linearLayout.removeAllViews();
        String str = null;
        MlvTemplateListResponse mlvTemplateListResponse = fVar != null ? (MlvTemplateListResponse) fVar.f57887b : null;
        if (mlvTemplateListResponse == null) {
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse");
        } else if (mlvTemplateListResponse.getResponse() != null) {
            Response response = mlvTemplateListResponse.getResponse();
            Result result = response != null ? response.getResult() : null;
            boolean z = true;
            if (p.a("SUCCESS", result != null ? result.getResultCode() : null, true)) {
                Response response2 = mlvTemplateListResponse.getResponse();
                ArrayList<UserMLVTemplateDetail> userTemplateDetails = response2 != null ? response2.getUserTemplateDetails() : null;
                ArrayList arrayList = new ArrayList();
                if (userTemplateDetails == null || userTemplateDetails.size() == 0) {
                    Serializable serializableExtra = this.f57141c.getIntent().getSerializableExtra("cashWalletResponseKey");
                    if (!(serializableExtra instanceof CJRCashWalletResponse)) {
                        serializableExtra = null;
                    }
                    CJRCashWalletResponse cJRCashWalletResponse = (CJRCashWalletResponse) serializableExtra;
                    if (cJRCashWalletResponse != null) {
                        List<CJRSubWallet> subWalletDetailList = cJRCashWalletResponse.getSubWalletDetailList();
                        k.a((Object) subWalletDetailList, "it.subWalletDetailList");
                        if (a((List<? extends CJRSubWallet>) subWalletDetailList).size() <= 0) {
                            z = false;
                        }
                        if (!z) {
                            a();
                            return;
                        }
                        return;
                    }
                    a();
                    return;
                }
                int size = userTemplateDetails.size();
                for (int i2 = 0; i2 < size; i2++) {
                    k.a((Object) linearLayout, "mlvItemLayout");
                    Context context = linearLayout.getContext();
                    k.a((Object) context, "mlvItemLayout.context");
                    CashBackVoucherCardView cashBackVoucherCardView = new CashBackVoucherCardView(context);
                    if (arrayList.size() >= this.f57142d) {
                        CashBackVoucherCardView cashBackVoucherCardView2 = new CashBackVoucherCardView(this.f57141c);
                        AppCompatImageView appCompatImageView = (AppCompatImageView) cashBackVoucherCardView2.a(R.id.ivForwardArrow);
                        k.a((Object) appCompatImageView, "viewAllMLVCard.ivForwardArrow");
                        appCompatImageView.setVisibility(8);
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) cashBackVoucherCardView2.a(R.id.ivVoucherIcon);
                        k.a((Object) appCompatImageView2, "viewAllMLVCard.ivVoucherIcon");
                        appCompatImageView2.setVisibility(8);
                        AppCompatTextView appCompatTextView = (AppCompatTextView) cashBackVoucherCardView2.a(R.id.tvVoucherTitle);
                        k.a((Object) appCompatTextView, "viewAllMLVCard.tvVoucherTitle");
                        appCompatTextView.setVisibility(8);
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) cashBackVoucherCardView2.a(R.id.tvAmount);
                        k.a((Object) appCompatTextView2, "viewAllMLVCard.tvAmount");
                        appCompatTextView2.setVisibility(8);
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) cashBackVoucherCardView2.a(R.id.tvViewMore);
                        k.a((Object) appCompatTextView3, "viewAllMLVCard.tvViewMore");
                        appCompatTextView3.setVisibility(0);
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) cashBackVoucherCardView2.a(R.id.tvViewMore);
                        k.a((Object) appCompatTextView4, "viewAllMLVCard.tvViewMore");
                        appCompatTextView4.setText(this.f57141c.getString(R.string.passbook_view_all_loyality_balance));
                        cashBackVoucherCardView2.setOnClickListener(new C1068a(this));
                        arrayList.add(cashBackVoucherCardView2);
                        linearLayout.addView(cashBackVoucherCardView2);
                        return;
                    }
                    UserMLVTemplateDetail userMLVTemplateDetail = userTemplateDetails.get(i2);
                    k.a((Object) userMLVTemplateDetail, "userTemplates[i]");
                    UserMLVTemplateDetail userMLVTemplateDetail2 = userMLVTemplateDetail;
                    MLVCardTemplate mlvCardTemplate = userMLVTemplateDetail2.getMlvCardTemplate();
                    String amount = userMLVTemplateDetail2.getTotalBalance().getAmount();
                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) cashBackVoucherCardView.a(R.id.tvVoucherTitle);
                    k.a((Object) appCompatTextView5, "innerMLVCardView.tvVoucherTitle");
                    a.C1111a aVar = net.one97.paytm.passbook.mlv.d.a.f58098a;
                    appCompatTextView5.setText(a.C1111a.a(mlvCardTemplate));
                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) cashBackVoucherCardView.a(R.id.tvAmount);
                    k.a((Object) appCompatTextView6, "innerMLVCardView.tvAmount");
                    appCompatTextView6.setText(cashBackVoucherCardView.getContext().getString(R.string.rs).toString() + net.one97.paytm.passbook.utility.c.b(amount));
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) cashBackVoucherCardView.a(R.id.ivVoucherIcon);
                    k.a((Object) appCompatImageView3, "innerMLVCardView.ivVoucherIcon");
                    appCompatImageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                    w.a().a(mlvCardTemplate.getMerchantLogoInfo().getMerchantImageName()).a(R.drawable.pass_merchant_icon_xxhdpi).a((ImageView) (AppCompatImageView) cashBackVoucherCardView.a(R.id.ivVoucherIcon));
                    cashBackVoucherCardView.setOnClickListener(new d(cashBackVoucherCardView, userMLVTemplateDetail2));
                    linearLayout.addView(cashBackVoucherCardView);
                    arrayList.add(cashBackVoucherCardView);
                }
                return;
            }
            if (result != null) {
                str = result.getResultCode();
            }
            if (p.a("USER_VALIDATION_FAILED", str, true)) {
                CashbackVoucherActivity.class.getName();
                j.a(this.f57141c, new NetworkCustomError(), false, true);
            }
        } else {
            CashbackVoucherActivity cashbackVoucherActivity = this.f57141c;
            net.one97.paytm.passbook.mapping.c.a((Context) cashbackVoucherActivity, cashbackVoucherActivity.getString(R.string.error), this.f57141c.getString(R.string.some_went_wrong));
        }
    }

    private final void a() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.f57141c.a(R.id.ivNoDataMLV);
        k.a((Object) appCompatImageView, "activity.ivNoDataMLV");
        appCompatImageView.setVisibility(0);
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.f57141c.a(R.id.tvNoDataMLV);
        k.a((Object) appCompatTextView, "activity.tvNoDataMLV");
        appCompatTextView.setVisibility(0);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.f57141c.a(R.id.tvWonVouchersDesc);
        k.a((Object) appCompatTextView2, "activity.tvWonVouchersDesc");
        appCompatTextView2.setVisibility(8);
    }

    /* renamed from: net.one97.paytm.passbook.cashbackVoucher.a$a  reason: collision with other inner class name */
    static final class C1068a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57143a;

        C1068a(a aVar) {
            this.f57143a = aVar;
        }

        public final void onClick(View view) {
            this.f57143a.f57141c.startActivity(new Intent(this.f57143a.f57141c, MLVTemplateActivity.class));
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CashBackVoucherCardView f57147a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserMLVTemplateDetail f57148b;

        d(CashBackVoucherCardView cashBackVoucherCardView, UserMLVTemplateDetail userMLVTemplateDetail) {
            this.f57147a = cashBackVoucherCardView;
            this.f57148b = userMLVTemplateDetail;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f57147a.getContext(), MLVMainActivity.class);
            intent.putExtra("data", this.f57148b);
            this.f57147a.getContext().startActivity(intent);
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "mlv_item_clicked", (String) null, (String) null, "/uth_passbook_myaccounts/cb_voucher", "PASSBOOK");
        }
    }

    private static ArrayList<MultiSubWallet> a(List<? extends CJRSubWallet> list) {
        ArrayList<CJRSubWallet> b2 = b(list);
        ArrayList<MultiSubWallet> arrayList = new ArrayList<>();
        Iterator<CJRSubWallet> it2 = b2.iterator();
        while (it2.hasNext()) {
            CJRSubWallet next = it2.next();
            k.a((Object) next, "subWallet");
            MultiSubWallet multiSubWallet = new MultiSubWallet(next.getSubWalletType());
            multiSubWallet.addSubWallet(next);
            if (b(next)) {
                arrayList.add(multiSubWallet);
            }
        }
        return arrayList;
    }

    private final void a(ArrayList<MultiSubWallet> arrayList) {
        ((LinearLayout) this.f57141c.a(R.id.otherWalletsItemLayout)).removeAllViews();
        Iterator<MultiSubWallet> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            MultiSubWallet next = it2.next();
            k.a((Object) next, "wallet");
            CashBackVoucherCardView cashBackVoucherCardView = new CashBackVoucherCardView(this.f57141c);
            AppCompatTextView appCompatTextView = (AppCompatTextView) cashBackVoucherCardView.a(R.id.tvVoucherTitle);
            k.a((Object) appCompatTextView, "view.tvVoucherTitle");
            appCompatTextView.setText(next.getDisplayName());
            ArrayList<CJRSubWallet> subWalletList = next.getSubWalletList();
            if (subWalletList != null) {
                if (subWalletList.size() > 0) {
                    ArrayList<CJRSubWallet> subWalletList2 = next.getSubWalletList();
                    k.a((Object) subWalletList2, "wallet.subWalletList");
                    int size = subWalletList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        CJRSubWallet cJRSubWallet = next.getSubWalletList().get(i2);
                        k.a((Object) cJRSubWallet, "wallet.subWalletList[i]");
                        cJRSubWallet.getBalance();
                    }
                }
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) cashBackVoucherCardView.a(R.id.tvAmount);
                k.a((Object) appCompatTextView2, "view.tvAmount");
                String string = this.f57141c.getString(R.string.pass_rupee, new Object[]{net.one97.paytm.passbook.utility.f.b(next.getBalance())});
                k.a((Object) string, "activity.getString(R.str….balance.amountFormat2())");
                net.one97.paytm.passbook.utility.f.a(appCompatTextView2, string);
            }
            if (next.getSubWalletType() == n.LOYALTY_WALLET_TYPE_7.getValue()) {
                ((AppCompatImageView) cashBackVoucherCardView.a(R.id.ivVoucherIcon)).setPadding(4, 4, 4, 4);
            }
            ((AppCompatImageView) cashBackVoucherCardView.a(R.id.ivVoucherIcon)).setImageDrawable(androidx.core.content.b.a(cashBackVoucherCardView.getContext(), q.a(next.getSubWalletType())));
            cashBackVoucherCardView.setOnClickListener(new e(this, next, cashBackVoucherCardView));
            ((LinearLayout) this.f57141c.a(R.id.otherWalletsItemLayout)).addView(cashBackVoucherCardView);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57149a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MultiSubWallet f57150b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CashBackVoucherCardView f57151c;

        e(a aVar, MultiSubWallet multiSubWallet, CashBackVoucherCardView cashBackVoucherCardView) {
            this.f57149a = aVar;
            this.f57150b = multiSubWallet;
            this.f57151c = cashBackVoucherCardView;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                java.lang.String r0 = "it"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                android.content.Context r1 = r9.getContext()
                java.lang.String r2 = "uth_passbook"
                java.lang.String r3 = "clw_item_clicked"
                r4 = 0
                r5 = 0
                java.lang.String r6 = "/uth_passbook_myaccounts/cb_voucher"
                java.lang.String r7 = "PASSBOOK"
                net.one97.paytm.passbook.utility.q.a(r1, r2, r3, r4, r5, r6, r7)
                net.one97.paytm.passbook.main.entity.MultiSubWallet r9 = r8.f57150b
                java.lang.String r0 = "wallet"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                java.util.ArrayList r9 = r9.getSubWalletList()
                if (r9 == 0) goto L_0x00fa
                r1 = 0
                java.lang.Object r9 = r9.get(r1)
                net.one97.paytm.passbook.beans.CJRSubWallet r9 = (net.one97.paytm.passbook.beans.CJRSubWallet) r9
                if (r9 == 0) goto L_0x00fa
                int r9 = r9.getSubWalletType()
                net.one97.paytm.passbook.main.widget.CashBackVoucherCardView r2 = r8.f57151c
                net.one97.paytm.passbook.main.entity.MultiSubWallet r3 = r8.f57150b
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
                java.util.ArrayList r0 = r3.getSubWalletList()
                java.lang.Object r0 = r0.get(r1)
                boolean r0 = r0 instanceof net.one97.paytm.passbook.main.entity.MultiSubWallet
                r4 = 0
                if (r0 == 0) goto L_0x0074
                java.util.ArrayList r0 = r3.getSubWalletList()
                if (r0 == 0) goto L_0x0053
                java.lang.Object r0 = r0.get(r1)
                net.one97.paytm.passbook.beans.CJRSubWallet r0 = (net.one97.paytm.passbook.beans.CJRSubWallet) r0
                goto L_0x0054
            L_0x0053:
                r0 = r4
            L_0x0054:
                boolean r5 = r0 instanceof net.one97.paytm.passbook.main.entity.MultiSubWallet
                if (r5 != 0) goto L_0x0059
                r0 = r4
            L_0x0059:
                net.one97.paytm.passbook.main.entity.MultiSubWallet r0 = (net.one97.paytm.passbook.main.entity.MultiSubWallet) r0
                if (r0 == 0) goto L_0x008b
                java.util.ArrayList r0 = r0.getSubWalletList()
                if (r0 == 0) goto L_0x008b
                java.lang.Object r0 = r0.get(r1)
                net.one97.paytm.passbook.beans.CJRSubWallet r0 = (net.one97.paytm.passbook.beans.CJRSubWallet) r0
                if (r0 == 0) goto L_0x008b
                int r0 = r0.getId()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x008c
            L_0x0074:
                java.util.ArrayList r0 = r3.getSubWalletList()
                if (r0 == 0) goto L_0x008b
                java.lang.Object r0 = r0.get(r1)
                net.one97.paytm.passbook.beans.CJRSubWallet r0 = (net.one97.paytm.passbook.beans.CJRSubWallet) r0
                if (r0 == 0) goto L_0x008b
                int r0 = r0.getId()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x008c
            L_0x008b:
                r0 = r4
            L_0x008c:
                net.one97.paytm.passbook.utility.n r5 = net.one97.paytm.passbook.utility.n.PAYTM_WALLET
                int r5 = r5.getValue()
                if (r9 == r5) goto L_0x00a4
                net.one97.paytm.passbook.utility.n r5 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET_TYPE_7
                int r5 = r5.getValue()
                if (r9 == r5) goto L_0x00a4
                net.one97.paytm.passbook.utility.n r5 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET
                int r5 = r5.getValue()
                if (r9 != r5) goto L_0x00fa
            L_0x00a4:
                android.content.Intent r5 = new android.content.Intent
                android.content.Context r6 = r2.getContext()
                java.lang.Class<net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity> r7 = net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity.class
                r5.<init>(r6, r7)
                java.lang.String r6 = "passbook_type"
                r5.putExtra(r6, r9)
                java.io.Serializable r0 = (java.io.Serializable) r0
                java.lang.String r9 = "clicked_wallet_id"
                r5.putExtra(r9, r0)
                java.util.ArrayList r9 = r3.getSubWalletList()
                if (r9 == 0) goto L_0x00ce
                java.lang.Object r9 = r9.get(r1)
                net.one97.paytm.passbook.beans.CJRSubWallet r9 = (net.one97.paytm.passbook.beans.CJRSubWallet) r9
                if (r9 == 0) goto L_0x00ce
                java.lang.String r9 = r9.getmIssuerId()
                goto L_0x00cf
            L_0x00ce:
                r9 = r4
            L_0x00cf:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                boolean r9 = android.text.TextUtils.isEmpty(r9)
                if (r9 != 0) goto L_0x00ee
                java.util.ArrayList r9 = r3.getSubWalletList()
                if (r9 == 0) goto L_0x00e9
                java.lang.Object r9 = r9.get(r1)
                net.one97.paytm.passbook.beans.CJRSubWallet r9 = (net.one97.paytm.passbook.beans.CJRSubWallet) r9
                if (r9 == 0) goto L_0x00e9
                java.lang.String r4 = r9.getmIssuerId()
            L_0x00e9:
                java.lang.String r9 = "clickedWalletIssuerId"
                r5.putExtra(r9, r4)
            L_0x00ee:
                r9 = 603979776(0x24000000, float:2.7755576E-17)
                r5.setFlags(r9)
                android.content.Context r9 = r2.getContext()
                r9.startActivity(r5)
            L_0x00fa:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.cashbackVoucher.a.e.onClick(android.view.View):void");
        }
    }

    private static ArrayList<CJRSubWallet> b(List<? extends CJRSubWallet> list) {
        ArrayList<CJRSubWallet> arrayList = new ArrayList<>();
        int i2 = 0;
        while (i2 < list.size()) {
            CJRSubWallet cJRSubWallet = (CJRSubWallet) list.get(i2);
            if (a(cJRSubWallet)) {
                MultiSubWallet multiSubWallet = new MultiSubWallet(cJRSubWallet.getSubWalletType(), false);
                int i3 = i2;
                while (i2 < list.size()) {
                    CJRSubWallet cJRSubWallet2 = (CJRSubWallet) list.get(i2);
                    if (!(i3 == i2 || cJRSubWallet == null || cJRSubWallet2 == null || cJRSubWallet.getmIssuerId() == null || cJRSubWallet2.getmIssuerId() == null || cJRSubWallet.getSubWalletType() != cJRSubWallet2.getSubWalletType() || !p.a(cJRSubWallet.getmIssuerId(), cJRSubWallet2.getmIssuerId(), true))) {
                        if (multiSubWallet.getSubWalletList().size() == 0) {
                            multiSubWallet.addSubWallet(cJRSubWallet);
                            multiSubWallet.setIssuerMetadata(cJRSubWallet.getIssuerMetadata());
                        }
                        multiSubWallet.addSubWallet(cJRSubWallet2);
                        i3 = i2;
                    }
                    i2++;
                }
                if (multiSubWallet.getSubWalletList().size() == 0) {
                    arrayList.add(cJRSubWallet);
                } else {
                    arrayList.add(multiSubWallet);
                }
                i2 = i3;
            } else {
                arrayList.add(cJRSubWallet);
            }
            i2++;
        }
        return arrayList;
    }

    private static boolean a(CJRSubWallet cJRSubWallet) {
        return (cJRSubWallet.getSubWalletType() == n.PAYTM_WALLET.getValue() || cJRSubWallet.getSubWalletType() == n.GIFT_VOUCHER.getValue() || cJRSubWallet.getSubWalletType() == n.TOLL.getValue()) ? false : true;
    }

    private static boolean b(CJRSubWallet cJRSubWallet) {
        int subWalletType = cJRSubWallet.getSubWalletType();
        return subWalletType == n.LOYALTY_WALLET_TYPE_7.getValue() || subWalletType == n.LOYALTY_WALLET.getValue();
    }

    public static void a(LottieAnimationView lottieAnimationView, boolean z) {
        k.c(lottieAnimationView, "loader");
        if (z) {
            lottieAnimationView.setVisibility(0);
            net.one97.paytm.passbook.utility.a.a(lottieAnimationView);
            return;
        }
        lottieAnimationView.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(lottieAnimationView);
    }

    public static final class b implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57144a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        b(a aVar) {
            this.f57144a = aVar;
        }

        public final void onPageSelected(int i2) {
            this.f57144a.a(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        int size = this.f57139a.size();
        TextView[] textViewArr = new TextView[size];
        for (int i3 = 0; i3 < size; i3++) {
            textViewArr[i3] = new TextView(this.f57141c);
        }
        this.f57140b = textViewArr;
        ((LinearLayout) this.f57141c.a(R.id.dotLayout)).removeAllViews();
        TextView[] textViewArr2 = this.f57140b;
        if (textViewArr2 == null) {
            k.a("dotArray");
        }
        int length = textViewArr2.length;
        for (int i4 = 0; i4 < length; i4++) {
            TextView[] textViewArr3 = this.f57140b;
            if (textViewArr3 == null) {
                k.a("dotArray");
            }
            textViewArr3[i4] = new TextView(this.f57141c);
            TextView[] textViewArr4 = this.f57140b;
            if (textViewArr4 == null) {
                k.a("dotArray");
            }
            textViewArr4[i4].setPadding(5, 0, 5, 0);
            TextView[] textViewArr5 = this.f57140b;
            if (textViewArr5 == null) {
                k.a("dotArray");
            }
            textViewArr5[i4].setText(Html.fromHtml("&#9679;"));
            TextView[] textViewArr6 = this.f57140b;
            if (textViewArr6 == null) {
                k.a("dotArray");
            }
            textViewArr6[i4].setTextSize(8.0f);
            TextView[] textViewArr7 = this.f57140b;
            if (textViewArr7 == null) {
                k.a("dotArray");
            }
            textViewArr7[i4].setTextColor(androidx.core.content.b.c(this.f57141c, R.color.pass_inactive_dot));
            LinearLayout linearLayout = (LinearLayout) this.f57141c.a(R.id.dotLayout);
            TextView[] textViewArr8 = this.f57140b;
            if (textViewArr8 == null) {
                k.a("dotArray");
            }
            linearLayout.addView(textViewArr8[i4]);
        }
        TextView[] textViewArr9 = this.f57140b;
        if (textViewArr9 == null) {
            k.a("dotArray");
        }
        textViewArr9[i2].setTextColor(androidx.core.content.b.c(this.f57141c, R.color.pass_active_dot));
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse> r17, net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse> r18, net.one97.paytm.passbook.beans.CJRCashWalletResponse r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r3 = r0.f57141c
            boolean r3 = r3.f57129c
            r4 = 0
            if (r3 == 0) goto L_0x0025
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r3 = r0.f57141c
            boolean r3 = r3.f57130d
            if (r3 == 0) goto L_0x0025
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r3 = r0.f57141c
            int r5 = net.one97.paytm.passbook.R.id.lottieLoader
            android.view.View r3 = r3.a(r5)
            com.airbnb.lottie.LottieAnimationView r3 = (com.airbnb.lottie.LottieAnimationView) r3
            java.lang.String r5 = "activity.lottieLoader"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            a(r3, r4)
        L_0x0025:
            r3 = 0
            if (r1 == 0) goto L_0x002b
            net.one97.paytm.passbook.mapping.a.j r5 = r1.f57886a
            goto L_0x002c
        L_0x002b:
            r5 = r3
        L_0x002c:
            net.one97.paytm.passbook.mapping.a.j r6 = net.one97.paytm.passbook.mapping.a.j.SUCCESS
            java.lang.String r7 = "SUCCESS"
            r8 = 1
            if (r5 != r6) goto L_0x0061
            T r5 = r1.f57887b
            net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse r5 = (net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse) r5
            if (r5 == 0) goto L_0x003e
            java.lang.String r5 = r5.getStatus()
            goto L_0x003f
        L_0x003e:
            r5 = r3
        L_0x003f:
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 == 0) goto L_0x0061
            T r5 = r1.f57887b
            net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse r5 = (net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse) r5
            if (r5 == 0) goto L_0x0056
            net.one97.paytm.passbook.beans.mgv.Data r5 = r5.getData()
            if (r5 == 0) goto L_0x0056
            java.util.ArrayList r5 = r5.getUserTemplateDetails()
            goto L_0x0057
        L_0x0056:
            r5 = r3
        L_0x0057:
            if (r5 == 0) goto L_0x005f
            int r5 = r5.size()
            if (r5 == 0) goto L_0x0061
        L_0x005f:
            r5 = 1
            goto L_0x0062
        L_0x0061:
            r5 = 0
        L_0x0062:
            if (r2 == 0) goto L_0x0067
            net.one97.paytm.passbook.mapping.a.j r6 = r2.f57886a
            goto L_0x0068
        L_0x0067:
            r6 = r3
        L_0x0068:
            net.one97.paytm.passbook.mapping.a.j r9 = net.one97.paytm.passbook.mapping.a.j.SUCCESS
            if (r6 != r9) goto L_0x00b4
            if (r2 == 0) goto L_0x0073
            T r6 = r2.f57887b
            net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse r6 = (net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse) r6
            goto L_0x0074
        L_0x0073:
            r6 = r3
        L_0x0074:
            if (r6 == 0) goto L_0x00ac
            net.one97.paytm.passbook.beans.mlv.Response r9 = r6.getResponse()
            if (r9 == 0) goto L_0x00b4
            net.one97.paytm.passbook.beans.mlv.Response r9 = r6.getResponse()
            if (r9 == 0) goto L_0x0087
            net.one97.paytm.passbook.beans.mlv.Result r9 = r9.getResult()
            goto L_0x0088
        L_0x0087:
            r9 = r3
        L_0x0088:
            if (r9 == 0) goto L_0x008f
            java.lang.String r9 = r9.getResultCode()
            goto L_0x0090
        L_0x008f:
            r9 = r3
        L_0x0090:
            boolean r9 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r9, (boolean) r8)
            if (r9 == 0) goto L_0x00b4
            net.one97.paytm.passbook.beans.mlv.Response r6 = r6.getResponse()
            if (r6 == 0) goto L_0x00a1
            java.util.ArrayList r6 = r6.getUserTemplateDetails()
            goto L_0x00a2
        L_0x00a1:
            r6 = r3
        L_0x00a2:
            if (r6 == 0) goto L_0x00b4
            int r6 = r6.size()
            if (r6 == 0) goto L_0x00b4
            r6 = 1
            goto L_0x00b5
        L_0x00ac:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse"
            r1.<init>(r2)
            throw r1
        L_0x00b4:
            r6 = 0
        L_0x00b5:
            if (r19 == 0) goto L_0x00cc
            java.util.List r9 = r19.getSubWalletDetailList()
            java.lang.String r10 = "it.subWalletDetailList"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            java.util.ArrayList r9 = a((java.util.List<? extends net.one97.paytm.passbook.beans.CJRSubWallet>) r9)
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x00cc
            r9 = 1
            goto L_0x00cd
        L_0x00cc:
            r9 = 0
        L_0x00cd:
            if (r5 != 0) goto L_0x011f
            if (r6 != 0) goto L_0x011f
            if (r9 != 0) goto L_0x011f
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r5 = r0.f57141c
            int r6 = net.one97.paytm.passbook.R.id.llPurchasedVouchers
            android.view.View r5 = r5.a(r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            java.lang.String r6 = "activity.llPurchasedVouchers"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r6 = 8
            r5.setVisibility(r6)
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r5 = r0.f57141c
            int r9 = net.one97.paytm.passbook.R.id.tvCashBackVouchersWon
            android.view.View r5 = r5.a(r9)
            androidx.appcompat.widget.AppCompatTextView r5 = (androidx.appcompat.widget.AppCompatTextView) r5
            java.lang.String r9 = "activity.tvCashBackVouchersWon"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            r5.setVisibility(r6)
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r5 = r0.f57141c
            int r9 = net.one97.paytm.passbook.R.id.tvWonVouchersDesc
            android.view.View r5 = r5.a(r9)
            androidx.appcompat.widget.AppCompatTextView r5 = (androidx.appcompat.widget.AppCompatTextView) r5
            java.lang.String r9 = "activity.tvWonVouchersDesc"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            r5.setVisibility(r6)
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r5 = r0.f57141c
            int r6 = net.one97.paytm.passbook.R.id.noDataLayout
            android.view.View r5 = r5.a(r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            java.lang.String r6 = "activity.noDataLayout"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r5.setVisibility(r4)
            r5 = 1
            goto L_0x0120
        L_0x011f:
            r5 = 0
        L_0x0120:
            if (r5 != 0) goto L_0x02b9
            if (r1 == 0) goto L_0x0127
            net.one97.paytm.passbook.mapping.a.j r5 = r1.f57886a
            goto L_0x0128
        L_0x0127:
            r5 = r3
        L_0x0128:
            if (r5 != 0) goto L_0x012c
            goto L_0x028c
        L_0x012c:
            int[] r6 = net.one97.paytm.passbook.cashbackVoucher.b.f57152a
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 == r8) goto L_0x0155
            r4 = 2
            if (r5 == r4) goto L_0x013b
            goto L_0x028c
        L_0x013b:
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r4 = r0.f57141c
            android.app.Activity r4 = (android.app.Activity) r4
            net.one97.paytm.passbook.mapping.a.d<? extends T> r1 = r1.f57888c
            if (r1 == 0) goto L_0x0146
            com.paytm.network.model.NetworkCustomError r1 = r1.f57879a
            goto L_0x0147
        L_0x0146:
            r1 = r3
        L_0x0147:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Class r5 = r16.getClass()
            r5.getName()
            net.one97.paytm.passbook.utility.j.a((android.app.Activity) r4, (java.lang.Throwable) r1)
            goto L_0x028c
        L_0x0155:
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r5 = r0.f57141c
            int r6 = net.one97.paytm.passbook.R.id.mgvItemLayout
            android.view.View r5 = r5.a(r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            T r6 = r1.f57887b
            net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse r6 = (net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse) r6
            if (r6 == 0) goto L_0x016a
            java.lang.String r6 = r6.getStatus()
            goto L_0x016b
        L_0x016a:
            r6 = r3
        L_0x016b:
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x028c
            r5.removeAllViews()
            T r1 = r1.f57887b
            net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse r1 = (net.one97.paytm.passbook.beans.mgv.ListAllTemplateResponse) r1
            if (r1 == 0) goto L_0x0185
            net.one97.paytm.passbook.beans.mgv.Data r1 = r1.getData()
            if (r1 == 0) goto L_0x0185
            java.util.ArrayList r1 = r1.getUserTemplateDetails()
            goto L_0x0186
        L_0x0185:
            r1 = r3
        L_0x0186:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r7 = r0.f57141c
            int r9 = net.one97.paytm.passbook.R.id.tvPurchasedVouchers
            android.view.View r7 = r7.a(r9)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r9 = "activity.tvPurchasedVouchers"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r7.setVisibility(r4)
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r7 = r0.f57141c
            int r9 = net.one97.paytm.passbook.R.id.tvPVDesc
            android.view.View r7 = r7.a(r9)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r9 = "activity.tvPVDesc"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r7.setVisibility(r4)
            if (r1 == 0) goto L_0x01c8
            int r7 = r1.size()
            if (r7 != 0) goto L_0x01c8
            net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity r1 = r0.f57141c
            int r4 = net.one97.paytm.passbook.R.id.tvPVDesc
            android.view.View r1 = r1.a(r4)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            int r4 = net.one97.paytm.passbook.R.string.pass_no_mgv_purchased
            r1.setText(r4)
            goto L_0x028c
        L_0x01c8:
            if (r1 == 0) goto L_0x028c
            int r7 = r1.size()
            if (r4 >= r7) goto L_0x028c
            net.one97.paytm.passbook.main.widget.CashBackVoucherCardView r7 = new net.one97.paytm.passbook.main.widget.CashBackVoucherCardView
            java.lang.String r9 = "mgvItemLayout"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            android.content.Context r9 = r5.getContext()
            java.lang.String r10 = "mgvItemLayout.context"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            r7.<init>(r9)
            java.lang.Object r9 = r1.get(r4)
            java.lang.String r10 = "userTemplates[i]"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            net.one97.paytm.passbook.beans.mgv.UserTemplateDetail r9 = (net.one97.paytm.passbook.beans.mgv.UserTemplateDetail) r9
            net.one97.paytm.passbook.beans.mgv.CardTemplate r10 = r9.getCardTemplate()
            net.one97.paytm.passbook.beans.mgv.MGVAmount r11 = r9.getTotalBalance()
            java.lang.String r11 = r11.getAmountInRs()
            int r12 = net.one97.paytm.passbook.R.id.tvVoucherTitle
            android.view.View r12 = r7.a(r12)
            androidx.appcompat.widget.AppCompatTextView r12 = (androidx.appcompat.widget.AppCompatTextView) r12
            java.lang.String r13 = "innerMGVCardView.tvVoucherTitle"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            java.lang.String r13 = r10.getName()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setText(r13)
            int r12 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r12 = r7.a(r12)
            androidx.appcompat.widget.AppCompatTextView r12 = (androidx.appcompat.widget.AppCompatTextView) r12
            java.lang.String r13 = "innerMGVCardView.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            android.content.Context r14 = r7.getContext()
            int r15 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r14 = r14.getString(r15)
            java.lang.String r14 = r14.toString()
            r13.append(r14)
            java.lang.String r11 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r11)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r12.setText(r11)
            int r11 = net.one97.paytm.passbook.R.id.ivVoucherIcon
            android.view.View r11 = r7.a(r11)
            androidx.appcompat.widget.AppCompatImageView r11 = (androidx.appcompat.widget.AppCompatImageView) r11
            java.lang.String r12 = "innerMGVCardView.ivVoucherIcon"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            android.widget.ImageView$ScaleType r12 = android.widget.ImageView.ScaleType.FIT_XY
            r11.setScaleType(r12)
            com.squareup.picasso.w r11 = com.squareup.picasso.w.a()
            net.one97.paytm.passbook.beans.mgv.MerchantLogoInfo r10 = r10.getMerchantLogoInfo()
            java.lang.String r10 = r10.getMerchantImageName()
            com.squareup.picasso.aa r10 = r11.a((java.lang.String) r10)
            int r11 = net.one97.paytm.passbook.R.drawable.pass_merchant_icon_xxhdpi
            com.squareup.picasso.aa r10 = r10.a((int) r11)
            int r11 = net.one97.paytm.passbook.R.id.ivVoucherIcon
            android.view.View r11 = r7.a(r11)
            androidx.appcompat.widget.AppCompatImageView r11 = (androidx.appcompat.widget.AppCompatImageView) r11
            r10.a((android.widget.ImageView) r11)
            net.one97.paytm.passbook.cashbackVoucher.a$c r10 = new net.one97.paytm.passbook.cashbackVoucher.a$c
            r10.<init>(r7, r9)
            android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
            r7.setOnClickListener(r10)
            r6.add(r7)
            android.view.View r7 = (android.view.View) r7
            r5.addView(r7)
            int r4 = r4 + 1
            goto L_0x01c8
        L_0x028c:
            if (r2 == 0) goto L_0x0290
            net.one97.paytm.passbook.mapping.a.j r3 = r2.f57886a
        L_0x0290:
            if (r3 != 0) goto L_0x0293
            goto L_0x02a1
        L_0x0293:
            int[] r1 = net.one97.paytm.passbook.cashbackVoucher.b.f57153b
            int r3 = r3.ordinal()
            r1 = r1[r3]
            if (r1 == r8) goto L_0x029e
            goto L_0x02a1
        L_0x029e:
            r0.a((net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.mlv.MlvTemplateListResponse>) r2)
        L_0x02a1:
            if (r19 == 0) goto L_0x02b9
            java.util.List r1 = r19.getSubWalletDetailList()
            java.lang.String r2 = "cjrCashWalletResponse.subWalletDetailList"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.util.ArrayList r1 = a((java.util.List<? extends net.one97.paytm.passbook.beans.CJRSubWallet>) r1)
            int r2 = r1.size()
            if (r2 <= 0) goto L_0x02b9
            r0.a((java.util.ArrayList<net.one97.paytm.passbook.main.entity.MultiSubWallet>) r1)
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.cashbackVoucher.a.a(net.one97.paytm.passbook.mapping.a.f, net.one97.paytm.passbook.mapping.a.f, net.one97.paytm.passbook.beans.CJRCashWalletResponse):void");
    }
}
