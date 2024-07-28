package net.one97.paytm.passbook.mgv.a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Random;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.mgv.UserCardDetail;
import net.one97.paytm.passbook.beans.mgv.UserTemplateDetail;
import net.one97.paytm.passbook.customview.DottedLine;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public C1100c f57906a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserCardDetail> f57907b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f57908c;

    /* renamed from: d  reason: collision with root package name */
    private UserTemplateDetail f57909d;

    /* renamed from: e  reason: collision with root package name */
    private final int f57910e;

    /* renamed from: f  reason: collision with root package name */
    private final int f57911f = 1;

    /* renamed from: g  reason: collision with root package name */
    private final int f57912g = 2;

    /* renamed from: h  reason: collision with root package name */
    private a f57913h;

    /* renamed from: net.one97.paytm.passbook.mgv.a.c$c  reason: collision with other inner class name */
    public interface C1100c {
        void b(int i2);

        void c();

        void d();
    }

    public c(a aVar) {
        k.c(aVar, "listener");
        this.f57913h = aVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f57910e) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_layout_mgv_main_screen_header, viewGroup, false);
            k.a((Object) inflate, "view");
            a aVar = new a(inflate);
            Object obj = kotlin.a.k.d("A6EA5E", "F9A71C", "00b6c9", "20C1BC", "6456F1", "4790FB", "F27447", "F352A4", "ECAF15", "00ACED", "11BF80").get(new Random().nextInt(11));
            k.a(obj, "colorCodes.get(randomIndex)");
            String str = (String) obj;
            View view = aVar.itemView;
            k.a((Object) view, "holder.itemView");
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.leftContainer);
            k.a((Object) linearLayout, "holder.itemView.leftContainer");
            a.a(linearLayout, str, "19");
            View view2 = aVar.itemView;
            k.a((Object) view2, "holder.itemView");
            ((DottedLine) view2.findViewById(R.id.dottedLine)).setColor(Color.parseColor("#4c".concat(String.valueOf(str))));
            View view3 = aVar.itemView;
            k.a((Object) view3, "holder.itemView");
            RelativeLayout relativeLayout = (RelativeLayout) view3.findViewById(R.id.rightContainer);
            k.a((Object) relativeLayout, "holder.itemView.rightContainer");
            a.a(relativeLayout, str, "33");
            return aVar;
        } else if (i2 == this.f57911f) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_item_row_purchased_vouchers, viewGroup, false);
            k.a((Object) inflate2, "view");
            return new d(inflate2);
        } else if (i2 == this.f57912g) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pass_layout_mgv_no_data, viewGroup, false);
            k.a((Object) inflate3, "view");
            return new b(inflate3);
        } else {
            throw new RuntimeException("Invalid view type");
        }
    }

    public final int getItemCount() {
        int i2 = this.f57909d != null ? 1 : 0;
        if (this.f57907b.size() != 0 || !this.f57908c) {
            return this.f57907b.size() + i2;
        }
        return i2 + 1;
    }

    public final int getItemViewType(int i2) {
        if (i2 == 0) {
            return this.f57910e;
        }
        if (this.f57908c) {
            return this.f57912g;
        }
        return this.f57911f;
    }

    public final void a(UserTemplateDetail userTemplateDetail) {
        this.f57909d = userTemplateDetail;
        notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x007b, code lost:
        r7 = r7.getMerchantLogoInfo();
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
            boolean r3 = r1 instanceof net.one97.paytm.passbook.mgv.a.c.a
            r4 = 1
            java.lang.String r5 = "itemView"
            if (r3 == 0) goto L_0x00f6
            net.one97.paytm.passbook.beans.mgv.UserTemplateDetail r3 = r0.f57909d
            if (r3 == 0) goto L_0x00c4
            r6 = r1
            net.one97.paytm.passbook.mgv.a.c$a r6 = (net.one97.paytm.passbook.mgv.a.c.a) r6
            java.lang.String r7 = "userTemplateDetail"
            kotlin.g.b.k.c(r3, r7)
            android.view.View r7 = r6.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            android.content.Context r7 = r7.getContext()
            android.view.View r8 = r6.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            int r9 = net.one97.paytm.passbook.R.id.nameTv
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            net.one97.paytm.passbook.beans.mgv.CardTemplate r9 = r3.getCardTemplate()
            java.lang.String r9 = r9.getName()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            android.view.View r8 = r6.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            int r9 = net.one97.paytm.passbook.R.id.amountTv
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r7 = r7.getString(r10)
            r9.append(r7)
            net.one97.paytm.passbook.beans.mgv.MGVAmount r7 = r3.getTotalBalance()
            java.lang.String r7 = r7.getAmountInRs()
            java.lang.String r7 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r7)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8.setText(r7)
            net.one97.paytm.passbook.beans.mgv.CardTemplate r7 = r3.getCardTemplate()
            r8 = 0
            if (r7 == 0) goto L_0x0086
            net.one97.paytm.passbook.beans.mgv.MerchantLogoInfo r7 = r7.getMerchantLogoInfo()
            if (r7 == 0) goto L_0x0086
            java.lang.String r7 = r7.getMerchantImageName()
            goto L_0x0087
        L_0x0086:
            r7 = r8
        L_0x0087:
            if (r7 != 0) goto L_0x009c
            android.view.View r3 = r6.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.mgvIcon
            android.view.View r3 = r3.findViewById(r5)
            net.one97.paytm.passbook.customview.CircularImageView r3 = (net.one97.paytm.passbook.customview.CircularImageView) r3
            int r5 = net.one97.paytm.passbook.R.drawable.pass_merchant_icon_xxhdpi
            r3.setImageResource(r5)
            goto L_0x00c4
        L_0x009c:
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            net.one97.paytm.passbook.beans.mgv.CardTemplate r3 = r3.getCardTemplate()
            if (r3 == 0) goto L_0x00b0
            net.one97.paytm.passbook.beans.mgv.MerchantLogoInfo r3 = r3.getMerchantLogoInfo()
            if (r3 == 0) goto L_0x00b0
            java.lang.String r8 = r3.getMerchantImageName()
        L_0x00b0:
            com.squareup.picasso.aa r3 = r7.a((java.lang.String) r8)
            android.view.View r6 = r6.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.mgvIcon
            android.view.View r5 = r6.findViewById(r5)
            net.one97.paytm.passbook.customview.CircularImageView r5 = (net.one97.paytm.passbook.customview.CircularImageView) r5
            r3.a((android.widget.ImageView) r5)
        L_0x00c4:
            android.view.View r3 = r1.itemView
            java.lang.String r5 = "holder.itemView"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r6 = net.one97.paytm.passbook.R.id.payWithVoucherTv
            android.view.View r3 = r3.findViewById(r6)
            android.widget.TextView r3 = (android.widget.TextView) r3
            net.one97.paytm.passbook.mgv.a.c$e r6 = new net.one97.paytm.passbook.mgv.a.c$e
            r6.<init>(r0)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r3.setOnClickListener(r6)
            android.view.View r1 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            int r3 = net.one97.paytm.passbook.R.id.buyVoucherTv
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            net.one97.paytm.passbook.mgv.a.c$f r3 = new net.one97.paytm.passbook.mgv.a.c$f
            r3.<init>(r0)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
            goto L_0x03b8
        L_0x00f6:
            boolean r3 = r1 instanceof net.one97.paytm.passbook.mgv.a.c.d
            if (r3 == 0) goto L_0x03b8
            r3 = r1
            net.one97.paytm.passbook.mgv.a.c$d r3 = (net.one97.paytm.passbook.mgv.a.c.d) r3
            java.util.ArrayList<net.one97.paytm.passbook.beans.mgv.UserCardDetail> r6 = r0.f57907b
            int r7 = r2 + -1
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r7 = "mUserCardsList.get(position - 1)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.passbook.beans.mgv.UserCardDetail r6 = (net.one97.paytm.passbook.beans.mgv.UserCardDetail) r6
            java.lang.String r7 = "userCardDetail"
            kotlin.g.b.k.c(r6, r7)
            android.view.View r7 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            android.content.Context r7 = r7.getContext()
            android.view.View r8 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            int r9 = net.one97.paytm.passbook.R.id.mgvVoucherAmount
            android.view.View r8 = r8.findViewById(r9)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r10 = r7.getString(r10)
            r9.append(r10)
            net.one97.paytm.passbook.beans.mgv.MGVAmount r10 = r6.getTotalAmount()
            java.lang.String r10 = r10.getAmountInRs()
            java.lang.String r10 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r10)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            android.view.View r8 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            int r9 = net.one97.paytm.passbook.R.id.mgvAvailableAmount
            android.view.View r8 = r8.findViewById(r9)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = net.one97.paytm.passbook.R.string.rs
            java.lang.String r10 = r7.getString(r10)
            r9.append(r10)
            net.one97.paytm.passbook.beans.mgv.MGVAmount r10 = r6.getAvailableAmount()
            java.lang.String r10 = r10.getAmountInRs()
            java.lang.String r10 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r10)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            java.lang.String r6 = r6.getExpiredTime()
            java.lang.String r8 = "yyyy-MM-dd'T'HH:mm:ss"
            long r8 = net.one97.paytm.passbook.mapping.a.j(r6, r8)
            java.lang.String r6 = "dd MMMM’yy"
            java.lang.String r6 = net.one97.paytm.passbook.mapping.a.a(r8, r6)
            android.view.View r10 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
            int r11 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r10 = r10.findViewById(r11)
            com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
            java.lang.String r11 = "#1d252d"
            int r12 = android.graphics.Color.parseColor(r11)
            r10.setTextColor(r12)
            android.view.View r10 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
            int r12 = net.one97.paytm.passbook.R.id.mgvVoucherWorth
            android.view.View r10 = r10.findViewById(r12)
            com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
            int r12 = android.graphics.Color.parseColor(r11)
            r10.setTextColor(r12)
            android.view.View r10 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
            int r12 = net.one97.paytm.passbook.R.id.mgvVoucherAmount
            android.view.View r10 = r10.findViewById(r12)
            com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
            int r12 = android.graphics.Color.parseColor(r11)
            r10.setTextColor(r12)
            android.view.View r10 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
            int r12 = net.one97.paytm.passbook.R.id.mgvAvailableBalance
            android.view.View r10 = r10.findViewById(r12)
            com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
            int r12 = android.graphics.Color.parseColor(r11)
            r10.setTextColor(r12)
            android.view.View r10 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r5)
            int r12 = net.one97.paytm.passbook.R.id.mgvAvailableAmount
            android.view.View r10 = r10.findViewById(r12)
            com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
            int r12 = android.graphics.Color.parseColor(r11)
            r10.setTextColor(r12)
            boolean r10 = android.text.format.DateUtils.isToday(r8)
            java.lang.String r12 = "#ffad00"
            java.lang.String r13 = " "
            if (r10 == 0) goto L_0x0246
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r8 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r6 = r6.findViewById(r8)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r9 = net.one97.paytm.passbook.R.string.expires
            java.lang.String r9 = r7.getString(r9)
            r8.append(r9)
            r8.append(r13)
            int r9 = net.one97.paytm.passbook.R.string.today
            java.lang.String r7 = r7.getString(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            android.view.View r3 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r3 = r3.findViewById(r5)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            int r5 = android.graphics.Color.parseColor(r12)
            r3.setTextColor(r5)
            goto L_0x03ac
        L_0x0246:
            long r14 = java.lang.System.currentTimeMillis()
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 <= 0) goto L_0x031a
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            java.lang.String r14 = "cal"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r14)
            r10.setTimeInMillis(r8)
            r8 = 11
            r9 = 23
            r10.set(r8, r9)
            r8 = 12
            r9 = 59
            r10.set(r8, r9)
            r8 = 13
            r10.set(r8, r9)
            long r8 = r10.getTimeInMillis()
            long r14 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r14
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.DAYS
            r14 = 1
            long r16 = r10.toMillis(r14)
            long r8 = r8 / r16
            r16 = 7
            int r10 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x02c6
            android.view.View r8 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            int r9 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r8 = r8.findViewById(r9)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = net.one97.paytm.passbook.R.string.expires
            java.lang.String r7 = r7.getString(r10)
            r9.append(r7)
            r9.append(r13)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r8.setText(r6)
            android.view.View r3 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r3 = r3.findViewById(r5)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            int r5 = android.graphics.Color.parseColor(r11)
            r3.setTextColor(r5)
            goto L_0x03ac
        L_0x02c6:
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x02e3
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r8 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r6 = r6.findViewById(r8)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            int r8 = net.one97.paytm.passbook.R.string.expires_tomorrow
            java.lang.String r7 = r7.getString(r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            goto L_0x0304
        L_0x02e3:
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r10 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r6 = r6.findViewById(r10)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            int r10 = net.one97.paytm.passbook.R.string.expires_in_days_
            java.lang.Object[] r11 = new java.lang.Object[r4]
            r13 = 0
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r11[r13] = r8
            java.lang.String r7 = r7.getString(r10, r11)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
        L_0x0304:
            android.view.View r3 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r3 = r3.findViewById(r5)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            int r5 = android.graphics.Color.parseColor(r12)
            r3.setTextColor(r5)
            goto L_0x03ac
        L_0x031a:
            android.view.View r8 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            int r9 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r8 = r8.findViewById(r9)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = net.one97.paytm.passbook.R.string.expired_on
            java.lang.String r7 = r7.getString(r10)
            r9.append(r7)
            r9.append(r13)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r8.setText(r6)
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r7 = net.one97.paytm.passbook.R.id.mgvVoucherWorth
            android.view.View r6 = r6.findViewById(r7)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            java.lang.String r7 = "#501d252d"
            int r8 = android.graphics.Color.parseColor(r7)
            r6.setTextColor(r8)
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r8 = net.one97.paytm.passbook.R.id.mgvVoucherAmount
            android.view.View r6 = r6.findViewById(r8)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            int r8 = android.graphics.Color.parseColor(r7)
            r6.setTextColor(r8)
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r8 = net.one97.paytm.passbook.R.id.mgvAvailableBalance
            android.view.View r6 = r6.findViewById(r8)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            int r8 = android.graphics.Color.parseColor(r7)
            r6.setTextColor(r8)
            android.view.View r6 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r5)
            int r8 = net.one97.paytm.passbook.R.id.mgvAvailableAmount
            android.view.View r6 = r6.findViewById(r8)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            int r7 = android.graphics.Color.parseColor(r7)
            r6.setTextColor(r7)
            android.view.View r3 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            int r5 = net.one97.paytm.passbook.R.id.mgvExpiry
            android.view.View r3 = r3.findViewById(r5)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            java.lang.String r5 = "#50506d85"
            int r5 = android.graphics.Color.parseColor(r5)
            r3.setTextColor(r5)
        L_0x03ac:
            android.view.View r1 = r1.itemView
            net.one97.paytm.passbook.mgv.a.c$g r3 = new net.one97.paytm.passbook.mgv.a.c$g
            r3.<init>(r0, r2)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
        L_0x03b8:
            java.util.ArrayList<net.one97.paytm.passbook.beans.mgv.UserCardDetail> r1 = r0.f57907b
            int r1 = r1.size()
            int r1 = r1 - r4
            if (r2 != r1) goto L_0x03c8
            if (r2 == 0) goto L_0x03c8
            net.one97.paytm.passbook.mgv.a.a r1 = r0.f57913h
            r1.b()
        L_0x03c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mgv.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57914a;

        e(c cVar) {
            this.f57914a = cVar;
        }

        public final void onClick(View view) {
            C1100c cVar = this.f57914a.f57906a;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57915a;

        f(c cVar) {
            this.f57915a = cVar;
        }

        public final void onClick(View view) {
            C1100c cVar = this.f57915a.f57906a;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57916a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f57917b;

        g(c cVar, int i2) {
            this.f57916a = cVar;
            this.f57917b = i2;
        }

        public final void onClick(View view) {
            C1100c cVar = this.f57916a.f57906a;
            if (cVar != null) {
                cVar.b(this.f57917b - 1);
            }
        }
    }

    public static final class d extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }

    public static final class a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
        }

        public static void a(View view, String str, String str2) {
            k.c(view, "view");
            k.c(str, CLConstants.FIELD_FONT_COLOR);
            k.c(str2, "alpha");
            String str3 = "#" + str2 + str;
            Drawable background = view.getBackground();
            if (background instanceof ShapeDrawable) {
                Paint paint = ((ShapeDrawable) background).getPaint();
                k.a((Object) paint, "(background as ShapeDrawable).paint");
                paint.setColor(Color.parseColor(str3));
            } else if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(Color.parseColor(str3));
            } else if (background instanceof ColorDrawable) {
                ((ColorDrawable) background).setColor(Color.parseColor(str3));
            }
        }
    }

    public static final class b extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
        }
    }
}
