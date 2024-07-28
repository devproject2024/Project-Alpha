package net.one97.paytm.quickpay.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.paytm_finance.R;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f59845a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<IJRDataModel> f59846b;

    /* renamed from: c  reason: collision with root package name */
    boolean f59847c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<String> f59848d = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    /* renamed from: e  reason: collision with root package name */
    b f59849e;

    public interface b {
        void a(IJRDataModel iJRDataModel);
    }

    public c(Context context, ArrayList<IJRDataModel> arrayList, b bVar) {
        this.f59845a = context;
        this.f59846b = arrayList;
        this.f59849e = bVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (this.f59847c) {
            return new C1154c(LayoutInflater.from(this.f59845a).inflate(R.layout.recent_scan_horizontal_list_item, viewGroup, false));
        }
        return new a(LayoutInflater.from(this.f59845a).inflate(R.layout.p2p_horizontal_recent_contact_row, viewGroup, false));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0184  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r14, int r15) {
        /*
            r13 = this;
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r13.f59846b
            java.lang.Object r0 = r0.get(r15)
            net.one97.paytm.common.entity.IJRDataModel r0 = (net.one97.paytm.common.entity.IJRDataModel) r0
            if (r0 == 0) goto L_0x0292
            boolean r1 = r14 instanceof net.one97.paytm.quickpay.a.c.a
            java.lang.String r2 = "QR_CODE_REQUEST_MONEY"
            java.lang.String r3 = ""
            r4 = 2131233863(0x7f080c47, float:1.8083876E38)
            r5 = 1
            r6 = 8
            r7 = 0
            r8 = 0
            if (r1 == 0) goto L_0x01d1
            net.one97.paytm.quickpay.a.c$a r14 = (net.one97.paytm.quickpay.a.c.a) r14
            android.widget.LinearLayout r1 = r14.f59852c
            java.lang.Integer r9 = java.lang.Integer.valueOf(r15)
            r1.setTag(r9)
            int r15 = r15 % 10
            net.one97.paytm.quickpay.a.c r1 = net.one97.paytm.quickpay.a.c.this
            java.util.ArrayList<java.lang.String> r1 = r1.f59848d
            java.lang.Object r15 = r1.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            net.one97.paytm.quickpay.a.c r1 = net.one97.paytm.quickpay.a.c.this
            boolean r1 = r1.f59847c
            r9 = 2131101234(0x7f060632, float:1.7814872E38)
            if (r1 == 0) goto L_0x0076
            android.widget.LinearLayout r1 = r14.f59852c
            net.one97.paytm.quickpay.a.c r10 = net.one97.paytm.quickpay.a.c.this
            android.content.Context r10 = r10.f59845a
            android.content.res.Resources r10 = r10.getResources()
            r11 = 17170445(0x106000d, float:2.461195E-38)
            int r10 = r10.getColor(r11)
            r1.setBackgroundColor(r10)
            android.widget.TextView r1 = r14.f59854e
            net.one97.paytm.quickpay.a.c r10 = net.one97.paytm.quickpay.a.c.this
            android.content.Context r10 = r10.f59845a
            android.content.res.Resources r10 = r10.getResources()
            int r9 = r10.getColor(r9)
            r1.setTextColor(r9)
            android.widget.TextView r1 = r14.f59855f
            net.one97.paytm.quickpay.a.c r9 = net.one97.paytm.quickpay.a.c.this
            android.content.Context r9 = r9.f59845a
            android.content.res.Resources r9 = r9.getResources()
            r10 = 2131231621(0x7f080385, float:1.8079328E38)
            android.graphics.drawable.Drawable r9 = r9.getDrawable(r10)
            r1.setBackground(r9)
            goto L_0x00af
        L_0x0076:
            android.widget.LinearLayout r1 = r14.f59852c
            net.one97.paytm.quickpay.a.c r10 = net.one97.paytm.quickpay.a.c.this
            android.content.Context r10 = r10.f59845a
            android.content.res.Resources r10 = r10.getResources()
            int r9 = r10.getColor(r9)
            r1.setBackgroundColor(r9)
            android.widget.TextView r1 = r14.f59854e
            net.one97.paytm.quickpay.a.c r9 = net.one97.paytm.quickpay.a.c.this
            android.content.Context r9 = r9.f59845a
            android.content.res.Resources r9 = r9.getResources()
            r10 = 2131099982(0x7f06014e, float:1.7812333E38)
            int r9 = r9.getColor(r10)
            r1.setTextColor(r9)
            android.widget.TextView r1 = r14.f59855f
            net.one97.paytm.quickpay.a.c r9 = net.one97.paytm.quickpay.a.c.this
            android.content.Context r9 = r9.f59845a
            android.content.res.Resources r9 = r9.getResources()
            r10 = 2131234337(0x7f080e21, float:1.8084837E38)
            android.graphics.drawable.Drawable r9 = r9.getDrawable(r10)
            r1.setBackground(r9)
        L_0x00af:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentSendMoney
            if (r1 == 0) goto L_0x00c3
            net.one97.paytm.common.entity.wallet.RecentSendMoney r0 = (net.one97.paytm.common.entity.wallet.RecentSendMoney) r0
            java.lang.String r1 = r0.getImageurl()
            java.lang.String r2 = r0.getPhoneNumber()
            java.lang.String r0 = r0.getName()
            r9 = r1
            goto L_0x010a
        L_0x00c3:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentScan
            if (r1 == 0) goto L_0x0107
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel
            r1.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00df }
            net.one97.paytm.common.entity.wallet.RecentScan r0 = (net.one97.paytm.common.entity.wallet.RecentScan) r0     // Catch:{ JSONException -> 0x00df }
            java.lang.String r0 = r0.getScanResult()     // Catch:{ JSONException -> 0x00df }
            r9.<init>(r0)     // Catch:{ JSONException -> 0x00df }
            net.one97.paytm.quickpay.a.c r0 = net.one97.paytm.quickpay.a.c.this     // Catch:{ JSONException -> 0x00df }
            android.content.Context r0 = r0.f59845a     // Catch:{ JSONException -> 0x00df }
            r1.parseData((org.json.JSONObject) r9, (android.content.Context) r0)     // Catch:{ JSONException -> 0x00df }
            goto L_0x00e7
        L_0x00df:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x00e7:
            java.lang.String r0 = r1.getLogoURL()
            java.lang.String r9 = r1.getMobileNo()
            java.lang.String r10 = r1.getRequestType()
            boolean r2 = r2.equals(r10)
            if (r2 == 0) goto L_0x00fe
            java.lang.String r1 = r1.getName()
            goto L_0x0102
        L_0x00fe:
            java.lang.String r1 = r1.getMerchantName()
        L_0x0102:
            r2 = r9
            r9 = r0
            r0 = r1
            r1 = 0
            goto L_0x010b
        L_0x0107:
            r0 = r7
            r2 = r0
            r9 = r2
        L_0x010a:
            r1 = 1
        L_0x010b:
            boolean r10 = android.text.TextUtils.isEmpty(r0)
            if (r10 != 0) goto L_0x0112
            goto L_0x0113
        L_0x0112:
            r0 = r2
        L_0x0113:
            java.lang.String r2 = a(r0)
            android.widget.TextView r10 = r14.f59853d
            int r15 = android.graphics.Color.parseColor(r15)
            r10.setBackgroundColor(r15)
            if (r1 == 0) goto L_0x0184
            android.widget.RelativeLayout r15 = r14.f59851b
            r15.setVisibility(r8)
            android.widget.RelativeLayout r15 = r14.f59850a
            r15.setVisibility(r6)
            boolean r15 = android.text.TextUtils.isEmpty(r9)
            if (r15 != 0) goto L_0x015e
            android.widget.ImageView r15 = r14.f59857h
            r15.setVisibility(r8)
            android.widget.RelativeLayout r15 = r14.f59858i
            r15.setVisibility(r6)
            net.one97.paytm.quickpay.a.c r15 = net.one97.paytm.quickpay.a.c.this     // Catch:{ Exception -> 0x01cb }
            android.content.Context r15 = r15.f59845a     // Catch:{ Exception -> 0x01cb }
            com.paytm.utility.b.b$a$a r15 = com.paytm.utility.b.b.a(r15)     // Catch:{ Exception -> 0x01cb }
            r15.f43753a = r9     // Catch:{ Exception -> 0x01cb }
            r15.n = r5     // Catch:{ Exception -> 0x01cb }
            net.one97.paytm.quickpay.a.c r1 = net.one97.paytm.quickpay.a.c.this     // Catch:{ Exception -> 0x01cb }
            android.content.Context r1 = r1.f59845a     // Catch:{ Exception -> 0x01cb }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01cb }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r4)     // Catch:{ Exception -> 0x01cb }
            com.paytm.utility.b.b$a$a r15 = r15.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x01cb }
            android.widget.ImageView r1 = r14.f59857h     // Catch:{ Exception -> 0x01cb }
            r15.a((android.widget.ImageView) r1)     // Catch:{ Exception -> 0x01cb }
            goto L_0x01cb
        L_0x015e:
            android.widget.ImageView r15 = r14.f59857h
            r15.setVisibility(r6)
            android.widget.RelativeLayout r15 = r14.f59858i
            r15.setVisibility(r8)
            boolean r15 = android.text.TextUtils.isEmpty(r2)
            if (r15 != 0) goto L_0x0179
            android.widget.TextView r15 = r14.f59853d
            r15.setText(r2)
            android.widget.ImageView r15 = r14.f59856g
            r15.setVisibility(r6)
            goto L_0x01cb
        L_0x0179:
            android.widget.TextView r15 = r14.f59853d
            r15.setText(r3)
            android.widget.ImageView r15 = r14.f59856g
            r15.setVisibility(r8)
            goto L_0x01cb
        L_0x0184:
            android.widget.RelativeLayout r15 = r14.f59850a
            r15.setVisibility(r8)
            android.widget.RelativeLayout r15 = r14.f59851b
            r15.setVisibility(r6)
            boolean r15 = android.text.TextUtils.isEmpty(r9)
            if (r15 != 0) goto L_0x01bd
            net.one97.paytm.common.widgets.CircularImageView r15 = r14.j
            r15.setVisibility(r8)
            com.squareup.picasso.w r15 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x01cb }
            com.squareup.picasso.aa r15 = r15.a((java.lang.String) r9)     // Catch:{ Exception -> 0x01cb }
            r15.f45353b = r5     // Catch:{ Exception -> 0x01cb }
            net.one97.paytm.quickpay.a.c r1 = net.one97.paytm.quickpay.a.c.this     // Catch:{ Exception -> 0x01cb }
            android.content.Context r1 = r1.f59845a     // Catch:{ Exception -> 0x01cb }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01cb }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r4)     // Catch:{ Exception -> 0x01cb }
            com.squareup.picasso.aa r15 = r15.a((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x01cb }
            com.squareup.picasso.aa r15 = r15.b((int) r4)     // Catch:{ Exception -> 0x01cb }
            net.one97.paytm.common.widgets.CircularImageView r1 = r14.j     // Catch:{ Exception -> 0x01cb }
            r15.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r7)     // Catch:{ Exception -> 0x01cb }
            goto L_0x01cb
        L_0x01bd:
            net.one97.paytm.common.widgets.CircularImageView r15 = r14.j
            r15.setVisibility(r6)
            android.widget.TextView r15 = r14.f59855f
            if (r2 == 0) goto L_0x01c7
            goto L_0x01c8
        L_0x01c7:
            r2 = r3
        L_0x01c8:
            r15.setText(r2)
        L_0x01cb:
            android.widget.TextView r14 = r14.f59854e
            r14.setText(r0)
            return
        L_0x01d1:
            boolean r1 = r14 instanceof net.one97.paytm.quickpay.a.c.C1154c
            if (r1 == 0) goto L_0x0292
            net.one97.paytm.quickpay.a.c$c r14 = (net.one97.paytm.quickpay.a.c.C1154c) r14
            android.widget.LinearLayout r1 = r14.f59863e
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r1.setTag(r15)
            boolean r15 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentSendMoney
            if (r15 == 0) goto L_0x01f7
            net.one97.paytm.common.entity.wallet.RecentSendMoney r0 = (net.one97.paytm.common.entity.wallet.RecentSendMoney) r0
            java.lang.String r15 = r0.getImageurl()
            r0.getPhoneNumber()
            java.lang.String r0 = r0.getName()
            r12 = r0
            r0 = r15
            r15 = r12
            goto L_0x0238
        L_0x01f7:
            boolean r15 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentScan
            if (r15 == 0) goto L_0x0236
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel
            r15.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0213 }
            net.one97.paytm.common.entity.wallet.RecentScan r0 = (net.one97.paytm.common.entity.wallet.RecentScan) r0     // Catch:{ JSONException -> 0x0213 }
            java.lang.String r0 = r0.getScanResult()     // Catch:{ JSONException -> 0x0213 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0213 }
            net.one97.paytm.quickpay.a.c r0 = net.one97.paytm.quickpay.a.c.this     // Catch:{ JSONException -> 0x0213 }
            android.content.Context r0 = r0.f59845a     // Catch:{ JSONException -> 0x0213 }
            r15.parseData((org.json.JSONObject) r1, (android.content.Context) r0)     // Catch:{ JSONException -> 0x0213 }
            goto L_0x021b
        L_0x0213:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x021b:
            java.lang.String r0 = r15.getLogoURL()
            r15.getMobileNo()
            java.lang.String r1 = r15.getRequestType()
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0231
            java.lang.String r15 = r15.getName()
            goto L_0x0238
        L_0x0231:
            java.lang.String r15 = r15.getMerchantName()
            goto L_0x0238
        L_0x0236:
            r15 = r7
            r0 = r15
        L_0x0238:
            java.lang.String r1 = a(r15)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0279
            net.one97.paytm.common.widgets.CircularImageView r1 = r14.f59861c
            r1.setVisibility(r8)
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0277 }
            com.squareup.picasso.aa r0 = r1.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0277 }
            r0.f45353b = r5     // Catch:{ Exception -> 0x0277 }
            net.one97.paytm.quickpay.a.c r1 = net.one97.paytm.quickpay.a.c.this     // Catch:{ Exception -> 0x0277 }
            android.content.Context r1 = r1.f59845a     // Catch:{ Exception -> 0x0277 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0277 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r4)     // Catch:{ Exception -> 0x0277 }
            com.squareup.picasso.aa r0 = r0.a((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x0277 }
            net.one97.paytm.quickpay.a.c r1 = net.one97.paytm.quickpay.a.c.this     // Catch:{ Exception -> 0x0277 }
            android.content.Context r1 = r1.f59845a     // Catch:{ Exception -> 0x0277 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0277 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r4)     // Catch:{ Exception -> 0x0277 }
            com.squareup.picasso.aa r0 = r0.b((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x0277 }
            net.one97.paytm.common.widgets.CircularImageView r1 = r14.f59861c     // Catch:{ Exception -> 0x0277 }
            r0.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r7)     // Catch:{ Exception -> 0x0277 }
            goto L_0x0287
        L_0x0277:
            goto L_0x0287
        L_0x0279:
            net.one97.paytm.common.widgets.CircularImageView r0 = r14.f59861c
            r0.setVisibility(r6)
            android.widget.TextView r0 = r14.f59859a
            if (r1 == 0) goto L_0x0283
            goto L_0x0284
        L_0x0283:
            r1 = r3
        L_0x0284:
            r0.setText(r1)
        L_0x0287:
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            if (r0 != 0) goto L_0x0292
            android.widget.TextView r14 = r14.f59860b
            r14.setText(r15)
        L_0x0292:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.a.c.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemCount() {
        ArrayList<IJRDataModel> arrayList = this.f59846b;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList.size() > 10) {
            return 10;
        }
        return this.f59846b.size();
    }

    class a extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f59850a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f59851b;
        /* access modifiers changed from: package-private */

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f59852c;

        /* renamed from: d  reason: collision with root package name */
        TextView f59853d;

        /* renamed from: e  reason: collision with root package name */
        TextView f59854e;

        /* renamed from: f  reason: collision with root package name */
        TextView f59855f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f59856g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f59857h;

        /* renamed from: i  reason: collision with root package name */
        RelativeLayout f59858i;
        CircularImageView j;

        public a(View view) {
            super(view);
            this.f59851b = (RelativeLayout) view.findViewById(R.id.p2p_profile_RL);
            this.f59850a = (RelativeLayout) view.findViewById(R.id.p2m_profile_rl);
            this.f59852c = (LinearLayout) view.findViewById(R.id.p2p_recent_row_ll);
            this.f59858i = (RelativeLayout) view.findViewById(R.id.layer_contact_list_logo_rl);
            this.j = (CircularImageView) view.findViewById(R.id.p2m_profile_iv);
            this.f59855f = (TextView) view.findViewById(R.id.p2m_image_name_tv);
            this.f59853d = (TextView) view.findViewById(R.id.layer_contact_list_initials);
            this.f59854e = (TextView) view.findViewById(R.id.layer_contact_name);
            this.f59856g = (ImageView) view.findViewById(R.id.layer_contact_list_img);
            this.f59857h = (ImageView) view.findViewById(R.id.p2p_profile_iv);
            this.f59852c.setOnClickListener(this);
        }

        public final void onClick(View view) {
            try {
                int parseInt = Integer.parseInt(view.getTag().toString());
                c.this.f59849e.a(c.this.f59846b.get(parseInt));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* renamed from: net.one97.paytm.quickpay.a.c$c  reason: collision with other inner class name */
    class C1154c extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        TextView f59859a;

        /* renamed from: b  reason: collision with root package name */
        TextView f59860b;

        /* renamed from: c  reason: collision with root package name */
        CircularImageView f59861c;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f59863e;

        public C1154c(View view) {
            super(view);
            this.f59863e = (LinearLayout) view.findViewById(R.id.p2p_recent_row_ll);
            this.f59859a = (TextView) view.findViewById(R.id.p2m_image_name_tv);
            this.f59861c = (CircularImageView) view.findViewById(R.id.p2m_profile_iv);
            this.f59860b = (TextView) view.findViewById(R.id.layer_contact_name);
            this.f59863e.setOnClickListener(this);
        }

        public final void onClick(View view) {
            try {
                IJRDataModel iJRDataModel = c.this.f59846b.get(Integer.parseInt(view.getTag().toString()));
                if (iJRDataModel instanceof RecentScan) {
                    c cVar = c.this;
                    RecentScan recentScan = (RecentScan) iJRDataModel;
                    net.one97.paytm.f.b.a().f50402a.setMode("recentBeneficiary");
                    try {
                        String scanResult = recentScan.getScanResult();
                        JSONObject jSONObject = new JSONObject(scanResult);
                        jSONObject.remove("ORDER_ID");
                        if (!com.paytm.utility.a.p(cVar.f59845a)) {
                            Intent c2 = d.a().c(cVar.f59845a);
                            c2.putExtra("dest", "qr_send_money");
                            c2.putExtra("qr_scan_result", scanResult);
                            cVar.f59845a.startActivity(c2);
                            return;
                        }
                        String uniqKey = recentScan.getUniqKey();
                        if (TextUtils.isEmpty(uniqKey) || uniqKey.length() != 24) {
                            String jSONObject2 = jSONObject.toString();
                            CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                            try {
                                cJRQRScanResultModel.parseData(new JSONObject(jSONObject2), cVar.f59845a);
                            } catch (JSONException e2) {
                                q.b(e2.getMessage());
                            }
                            if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(cJRQRScanResultModel.getRequestType())) {
                                d.a().a(cVar.f59845a, cJRQRScanResultModel);
                                return;
                            }
                            d.a().a(cVar.f59845a, jSONObject2, cJRQRScanResultModel.getQrCodeId());
                            return;
                        }
                        cVar.f59849e.a(recentScan);
                    } catch (Exception e3) {
                        q.b(e3.getMessage());
                    }
                } else if (iJRDataModel instanceof RecentSendMoney) {
                    RecentSendMoney recentSendMoney = (RecentSendMoney) iJRDataModel;
                    Intent intent = new Intent();
                    intent.putExtra("PHONE_NUMBER", recentSendMoney.getPhoneNumber());
                    intent.putExtra("NAME", recentSendMoney.getName());
                    intent.putExtra("MODE_OF_PAYMENT", recentSendMoney.getModeOfPayment());
                    d.a().a(intent, (Activity) c.this.f59845a);
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    private static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.trim().split(" ");
        int length = split.length;
        if (length != 1 || TextUtils.isEmpty(split[0])) {
            if (length < 2) {
                return "";
            }
            if (!TextUtils.isEmpty(split[0])) {
                str2 = String.valueOf(split[0].charAt(0));
                if (str2.matches("\\d+")) {
                    return "";
                }
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(split[1])) {
                return str2;
            }
            String valueOf = String.valueOf(split[1].charAt(0));
            if (valueOf.matches("\\d+")) {
                return "";
            }
            return str2 + valueOf;
        } else if (String.valueOf(split[0].charAt(0)).matches("\\d+")) {
            return "";
        } else {
            return String.valueOf(split[0].charAt(0));
        }
    }
}
