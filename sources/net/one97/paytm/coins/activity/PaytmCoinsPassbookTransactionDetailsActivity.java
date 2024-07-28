package net.one97.paytm.coins.activity;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytm.utility.s;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.coins.c.d;
import net.one97.paytm.coins.model.LoyaltyModel;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRCashBackBaseActivity;

public final class PaytmCoinsPassbookTransactionDetailsActivity extends AJRCashBackBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public LoyaltyModel f16699a;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f16700d;

    public final View a(int i2) {
        if (this.f16700d == null) {
            this.f16700d = new HashMap();
        }
        View view = (View) this.f16700d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f16700d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0258  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onCreate(r12)
            int r12 = net.one97.paytm.vipcashback.R.layout.paytm_coin_passbook_detail
            r11.setContentView((int) r12)
            android.content.Intent r12 = r11.getIntent()
            if (r12 != 0) goto L_0x0011
            kotlin.g.b.k.a()
        L_0x0011:
            android.os.Bundle r12 = r12.getExtras()
            if (r12 != 0) goto L_0x001a
            kotlin.g.b.k.a()
        L_0x001a:
            java.lang.String r0 = "loyalty_model_key"
            java.io.Serializable r12 = r12.getSerializable(r0)
            if (r12 == 0) goto L_0x03f1
            net.one97.paytm.coins.model.LoyaltyModel r12 = (net.one97.paytm.coins.model.LoyaltyModel) r12
            r11.f16699a = r12
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            java.lang.String r0 = "_loyatyModel"
            if (r12 != 0) goto L_0x002f
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x002f:
            java.lang.String r12 = r12.getTransactionType()
            java.lang.String r1 = "REFUND"
            boolean r12 = r1.equals(r12)
            java.lang.String r1 = "tv_status"
            r2 = 0
            if (r12 == 0) goto L_0x0057
            int r12 = net.one97.paytm.vipcashback.R.id.tv_status
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            int r1 = net.one97.paytm.vipcashback.R.string.jr_pc_coins_refunded
            java.lang.String r1 = r11.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            goto L_0x00df
        L_0x0057:
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x005e
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x005e:
            java.lang.String r12 = r12.getTransactionType()
            java.lang.String r3 = "PAY"
            boolean r12 = r3.equals(r12)
            java.lang.String r3 = "iv_download_icon_img"
            if (r12 == 0) goto L_0x0091
            int r12 = net.one97.paytm.vipcashback.R.id.tv_status
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            int r1 = net.one97.paytm.vipcashback.R.string.jr_pc_coins_redeemed
            java.lang.String r1 = r11.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            int r12 = net.one97.paytm.vipcashback.R.id.iv_download_icon_img
            android.view.View r12 = r11.a(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            r12.setVisibility(r2)
            goto L_0x00df
        L_0x0091:
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x0098
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0098:
            java.lang.String r12 = r12.getTransactionType()
            java.lang.String r4 = "REWARD"
            boolean r12 = r4.equals(r12)
            if (r12 == 0) goto L_0x00c9
            int r12 = net.one97.paytm.vipcashback.R.id.tv_status
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            int r1 = net.one97.paytm.vipcashback.R.string.jr_pc_coins_received
            java.lang.String r1 = r11.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            int r12 = net.one97.paytm.vipcashback.R.id.iv_download_icon_img
            android.view.View r12 = r11.a(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            r12.setVisibility(r2)
            goto L_0x00df
        L_0x00c9:
            int r12 = net.one97.paytm.vipcashback.R.id.tv_status
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            int r1 = net.one97.paytm.vipcashback.R.string.jr_pc_coins_received
            java.lang.String r1 = r11.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
        L_0x00df:
            int r12 = net.one97.paytm.vipcashback.R.id.tv_paytm_balance_coins
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r1 = "tv_paytm_balance_coins"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            net.one97.paytm.coins.model.LoyaltyModel r1 = r11.f16699a
            if (r1 != 0) goto L_0x00f4
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00f4:
            java.lang.String r1 = r1.getAccountingAmount()
            if (r1 == 0) goto L_0x00fb
            goto L_0x00fd
        L_0x00fb:
            java.lang.String r1 = "0"
        L_0x00fd:
            double r3 = java.lang.Double.parseDouble(r1)
            java.lang.String r1 = net.one97.paytm.coins.c.e.a(r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x0111
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0111:
            java.lang.String r12 = r12.getAccountingTimestamp()
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss"
            r3 = 8
            java.lang.String r4 = "tv_label_time_stamp_with_status"
            java.lang.String r5 = ""
            r6 = 1
            if (r12 == 0) goto L_0x0180
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label_time_stamp_with_status
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            net.one97.paytm.coins.model.LoyaltyModel r4 = r11.f16699a
            if (r4 != 0) goto L_0x0134
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0134:
            java.lang.String r4 = r4.getAccountingTimestamp()
            if (r4 == 0) goto L_0x0143
            net.one97.paytm.coins.c.d r7 = net.one97.paytm.coins.c.d.f16733a
            java.lang.String r7 = "dd MMM yyyy, hh:mm a"
            java.lang.String r4 = net.one97.paytm.coins.c.d.a(r4, r1, r7)
            goto L_0x0144
        L_0x0143:
            r4 = r5
        L_0x0144:
            int r7 = net.one97.paytm.vipcashback.R.string.coins_closing_balance
            java.lang.Object[] r8 = new java.lang.Object[r6]
            net.one97.paytm.coins.model.LoyaltyModel r9 = r11.f16699a
            if (r9 != 0) goto L_0x014f
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x014f:
            java.lang.String r9 = r9.getActiveBalance()
            if (r9 != 0) goto L_0x0158
            kotlin.g.b.k.a()
        L_0x0158:
            double r9 = java.lang.Double.parseDouble(r9)
            java.lang.String r9 = net.one97.paytm.coins.c.e.a(r9)
            r8[r2] = r9
            java.lang.String r7 = r11.getString(r7, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            java.lang.String r4 = "  |  "
            r8.append(r4)
            r8.append(r7)
            java.lang.String r4 = r8.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r12.setText(r4)
            goto L_0x018e
        L_0x0180:
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label_time_stamp_with_status
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            r12.setVisibility(r3)
        L_0x018e:
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x0195
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0195:
            net.one97.paytm.coins.model.ExtendedInfoModel r12 = r12.getExtendInfo()
            if (r12 == 0) goto L_0x020c
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x01a2
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01a2:
            net.one97.paytm.coins.model.ExtendedInfoModel r12 = r12.getExtendInfo()
            if (r12 != 0) goto L_0x01ab
            kotlin.g.b.k.a()
        L_0x01ab:
            java.lang.String r12 = r12.getOfferIconImage()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x01bc
            int r12 = r12.length()
            if (r12 != 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r12 = 0
            goto L_0x01bd
        L_0x01bc:
            r12 = 1
        L_0x01bd:
            if (r12 != 0) goto L_0x020c
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x01c6
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01c6:
            net.one97.paytm.coins.model.ExtendedInfoModel r12 = r12.getExtendInfo()
            if (r12 != 0) goto L_0x01cf
            kotlin.g.b.k.a()
        L_0x01cf:
            java.lang.String r12 = r12.getOfferIconImage()
            boolean r12 = android.webkit.URLUtil.isValidUrl(r12)
            if (r12 == 0) goto L_0x020c
            com.squareup.picasso.w r12 = com.squareup.picasso.w.a()
            net.one97.paytm.coins.model.LoyaltyModel r4 = r11.f16699a
            if (r4 != 0) goto L_0x01e4
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01e4:
            net.one97.paytm.coins.model.ExtendedInfoModel r4 = r4.getExtendInfo()
            if (r4 != 0) goto L_0x01ed
            kotlin.g.b.k.a()
        L_0x01ed:
            java.lang.String r4 = r4.getOfferIconImage()
            com.squareup.picasso.aa r12 = r12.a((java.lang.String) r4)
            net.one97.paytm.coins.customview.a r4 = new net.one97.paytm.coins.customview.a
            r4.<init>()
            com.squareup.picasso.ah r4 = (com.squareup.picasso.ah) r4
            com.squareup.picasso.aa r12 = r12.a((com.squareup.picasso.ah) r4)
            int r4 = net.one97.paytm.vipcashback.R.id.iv_image1
            android.view.View r4 = r11.a(r4)
            net.one97.paytm.coins.customview.CircularImageView r4 = (net.one97.paytm.coins.customview.CircularImageView) r4
            r12.a((android.widget.ImageView) r4)
            goto L_0x0220
        L_0x020c:
            int r12 = net.one97.paytm.vipcashback.R.id.iv_image1
            android.view.View r12 = r11.a(r12)
            net.one97.paytm.coins.customview.CircularImageView r12 = (net.one97.paytm.coins.customview.CircularImageView) r12
            r4 = r11
            android.content.Context r4 = (android.content.Context) r4
            int r7 = net.one97.paytm.vipcashback.R.drawable.coin_operator_logo
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r7)
            r12.setImageDrawable(r4)
        L_0x0220:
            int r12 = net.one97.paytm.vipcashback.R.id.tv_expiry
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r4 = "tv_expiry"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r4)
            net.one97.paytm.coins.model.LoyaltyModel r7 = r11.f16699a
            if (r7 != 0) goto L_0x0235
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0235:
            java.lang.String r7 = r7.getExpiryTime()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0246
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0244
            goto L_0x0246
        L_0x0244:
            r7 = 0
            goto L_0x0247
        L_0x0246:
            r7 = 1
        L_0x0247:
            if (r7 == 0) goto L_0x0258
            int r1 = net.one97.paytm.vipcashback.R.id.tv_expiry
            android.view.View r1 = r11.a(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r3)
            goto L_0x027c
        L_0x0258:
            net.one97.paytm.coins.model.LoyaltyModel r3 = r11.f16699a
            if (r3 != 0) goto L_0x025f
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x025f:
            java.lang.String r3 = r3.getExpiryTime()
            if (r3 == 0) goto L_0x027c
            int r4 = net.one97.paytm.vipcashback.R.string.coins_expiry_date
            java.lang.Object[] r5 = new java.lang.Object[r6]
            net.one97.paytm.coins.c.d r7 = net.one97.paytm.coins.c.d.f16733a
            java.lang.String r7 = "dd MMM yyyy"
            java.lang.String r1 = net.one97.paytm.coins.c.d.a(r3, r1, r7)
            r5[r2] = r1
            java.lang.String r5 = r11.getString(r4, r5)
            java.lang.String r1 = "getString(R.string.coins…inConstants.DATE_FORMAT))"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
        L_0x027c:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r12.setText(r5)
            int r12 = net.one97.paytm.vipcashback.R.id.tv_order_id
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r1 = "tv_order_id"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            int r1 = net.one97.paytm.vipcashback.R.string.coins_order_id
            java.lang.Object[] r3 = new java.lang.Object[r6]
            net.one97.paytm.coins.model.LoyaltyModel r4 = r11.f16699a
            if (r4 != 0) goto L_0x029a
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x029a:
            java.lang.String r4 = r4.getOrderId()
            r3[r2] = r4
            java.lang.String r1 = r11.getString(r1, r3)
            java.lang.String r3 = "getString(R.string.coins…id, _loyatyModel.orderId)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            int r12 = net.one97.paytm.vipcashback.R.id.iv_back_arrow_img
            android.view.View r12 = r11.a(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            net.one97.paytm.coins.activity.PaytmCoinsPassbookTransactionDetailsActivity$a r1 = new net.one97.paytm.coins.activity.PaytmCoinsPassbookTransactionDetailsActivity$a
            r1.<init>(r11)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x02c7
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x02c7:
            net.one97.paytm.coins.model.ExtendedInfoModel r12 = r12.getExtendInfo()
            java.lang.String r1 = "tv_label2"
            java.lang.String r3 = "tv_label1"
            if (r12 == 0) goto L_0x0330
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x02da
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x02da:
            net.one97.paytm.coins.model.ExtendedInfoModel r12 = r12.getExtendInfo()
            if (r12 != 0) goto L_0x02e3
            kotlin.g.b.k.a()
        L_0x02e3:
            java.lang.String r12 = r12.getOfferName()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x02f1
            int r12 = r12.length()
            if (r12 != 0) goto L_0x02f2
        L_0x02f1:
            r2 = 1
        L_0x02f2:
            if (r2 != 0) goto L_0x0330
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label1
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            int r2 = net.one97.paytm.vipcashback.R.string.jr_pc_for
            java.lang.String r2 = r11.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label2
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            net.one97.paytm.coins.model.LoyaltyModel r1 = r11.f16699a
            if (r1 != 0) goto L_0x031c
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x031c:
            net.one97.paytm.coins.model.ExtendedInfoModel r0 = r1.getExtendInfo()
            if (r0 != 0) goto L_0x0325
            kotlin.g.b.k.a()
        L_0x0325:
            java.lang.String r0 = r0.getOfferName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            goto L_0x03de
        L_0x0330:
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x0337
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0337:
            java.lang.String r12 = r12.getAccountingType()
            java.lang.String r2 = "CREDIT"
            boolean r12 = r2.equals(r12)
            java.lang.String r2 = "tv_label3"
            if (r12 == 0) goto L_0x0389
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label1
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            int r0 = net.one97.paytm.vipcashback.R.string.jr_pc_from
            java.lang.String r0 = r11.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label2
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            int r0 = net.one97.paytm.vipcashback.R.string.jr_pc_paytm
            java.lang.String r0 = r11.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label3
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            int r0 = net.one97.paytm.vipcashback.R.string.jr_pc_in_your
            java.lang.String r0 = r11.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            goto L_0x03de
        L_0x0389:
            net.one97.paytm.coins.model.LoyaltyModel r12 = r11.f16699a
            if (r12 != 0) goto L_0x0390
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0390:
            java.lang.String r12 = r12.getAccountingType()
            java.lang.String r0 = "DEBIT"
            boolean r12 = r0.equals(r12)
            if (r12 == 0) goto L_0x03de
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label1
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            int r0 = net.one97.paytm.vipcashback.R.string.jr_pc_for
            java.lang.String r0 = r11.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label2
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            int r0 = net.one97.paytm.vipcashback.R.string.jr_pc_gift_vocher
            java.lang.String r0 = r11.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            int r12 = net.one97.paytm.vipcashback.R.id.tv_label3
            android.view.View r12 = r11.a(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            int r0 = net.one97.paytm.vipcashback.R.string.jr_pc_from
            java.lang.String r0 = r11.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
        L_0x03de:
            int r12 = net.one97.paytm.vipcashback.R.id.iv_download_icon_img
            android.view.View r12 = r11.a(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            net.one97.paytm.coins.activity.PaytmCoinsPassbookTransactionDetailsActivity$b r0 = new net.one97.paytm.coins.activity.PaytmCoinsPassbookTransactionDetailsActivity$b
            r0.<init>(r11)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r12.setOnClickListener(r0)
            return
        L_0x03f1:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.coins.model.LoyaltyModel"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.activity.PaytmCoinsPassbookTransactionDetailsActivity.onCreate(android.os.Bundle):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinsPassbookTransactionDetailsActivity f16701a;

        a(PaytmCoinsPassbookTransactionDetailsActivity paytmCoinsPassbookTransactionDetailsActivity) {
            this.f16701a = paytmCoinsPassbookTransactionDetailsActivity;
        }

        public final void onClick(View view) {
            this.f16701a.finish();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmCoinsPassbookTransactionDetailsActivity f16702a;

        b(PaytmCoinsPassbookTransactionDetailsActivity paytmCoinsPassbookTransactionDetailsActivity) {
            this.f16702a = paytmCoinsPassbookTransactionDetailsActivity;
        }

        public final void onClick(View view) {
            if (androidx.core.app.a.a((Context) this.f16702a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.a(this.f16702a, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 10);
            } else {
                this.f16702a.a();
            }
        }
    }

    public final void a() {
        d dVar = d.f16733a;
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.container);
        k.a((Object) constraintLayout, "container");
        Bitmap a2 = d.a(constraintLayout);
        d dVar2 = d.f16733a;
        Context context = this;
        Uri a3 = d.a(context, a2);
        d dVar3 = d.f16733a;
        d.a("", "", a3, "", context);
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        ContextWrapper baseContext = net.one97.paytm.vipcashback.c.a.b().getBaseContext(context);
        k.a((Object) baseContext, "CashbackHelper.getImplLi…).getBaseContext(newBase)");
        super.attachBaseContext(baseContext);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 10 && s.a(iArr)) {
            a();
        }
    }
}
