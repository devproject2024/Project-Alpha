package net.one97.paytm.wallet.p2p;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.ah;
import java.net.URLDecoder;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.postpayment.utils.WalletCircularProgressBar;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.p2p.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    boolean f71543a;

    /* renamed from: b  reason: collision with root package name */
    boolean f71544b;

    /* renamed from: c  reason: collision with root package name */
    Context f71545c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<IJRDataModel> f71546d;

    /* renamed from: e  reason: collision with root package name */
    boolean f71547e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71548f;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<String> f71549g = new ArrayList<String>() {
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

    /* renamed from: h  reason: collision with root package name */
    d f71550h;

    /* renamed from: i  reason: collision with root package name */
    e f71551i;
    f j;
    RecyclerView k;
    private boolean l;

    public interface c {
        void stopProgress();
    }

    public interface d {
    }

    public interface e {
        void a(int i2);

        void a(IJRDataModel iJRDataModel, c cVar);
    }

    public interface f {
        void onRemoved(int i2, IJRDataModel iJRDataModel);
    }

    public a(Context context, ArrayList<IJRDataModel> arrayList, boolean z, e eVar) {
        this.f71543a = z;
        if (this.f71543a) {
            RecentScan recentScan = new RecentScan();
            recentScan.setUniqKey("view_all");
            arrayList.add(recentScan);
        }
        this.l = true;
        this.f71545c = context;
        this.f71546d = arrayList;
        this.f71551i = eVar;
    }

    public a(Context context, ArrayList<IJRDataModel> arrayList, f fVar) {
        this.f71545c = context;
        this.f71546d = arrayList;
        this.f71544b = true;
        this.j = fVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (this.l || this.f71544b) {
            return new h(LayoutInflater.from(this.f71545c).inflate(R.layout.lyt_new_recent, viewGroup, false));
        }
        if (this.f71547e) {
            return new g(LayoutInflater.from(this.f71545c).inflate(R.layout.recent_scan_horizontal_list_item, viewGroup, false));
        }
        return new b(LayoutInflater.from(this.f71545c).inflate(R.layout.wallet_p2p_horizontal_recent_contact_row, viewGroup, false));
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0474  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r13, int r14) {
        /*
            r12 = this;
            java.util.ArrayList<net.one97.paytm.common.entity.IJRDataModel> r0 = r12.f71546d
            java.lang.Object r0 = r0.get(r14)
            net.one97.paytm.common.entity.IJRDataModel r0 = (net.one97.paytm.common.entity.IJRDataModel) r0
            if (r0 == 0) goto L_0x04f7
            boolean r1 = r13 instanceof net.one97.paytm.wallet.p2p.a.b
            java.lang.String r2 = "QR_CODE_REQUEST_MONEY"
            java.lang.String r3 = ""
            r4 = 1
            r5 = 8
            r6 = 0
            r7 = 0
            if (r1 == 0) goto L_0x0234
            net.one97.paytm.wallet.p2p.a$b r13 = (net.one97.paytm.wallet.p2p.a.b) r13
            android.widget.LinearLayout r1 = r13.f71563d
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            r1.setTag(r8)
            int r14 = r14 % 20
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this
            java.util.ArrayList<java.lang.String> r1 = r1.f71549g
            int r14 = r14 % 10
            java.lang.Object r14 = r1.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this
            boolean r1 = r1.f71548f
            if (r1 == 0) goto L_0x003d
            android.widget.LinearLayout r1 = r13.f71563d
            r1.setClickable(r4)
        L_0x003d:
            android.widget.LinearLayout r1 = r13.f71563d
            boolean r1 = r1.isClickable()
            if (r1 == 0) goto L_0x004a
            net.one97.paytm.postpayment.utils.WalletCircularProgressBar r1 = r13.f71562c
            r1.setVisibility(r5)
        L_0x004a:
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this
            boolean r1 = r1.f71547e
            if (r1 == 0) goto L_0x008b
            android.widget.LinearLayout r1 = r13.f71563d
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            android.content.Context r8 = r8.f71545c
            android.content.res.Resources r8 = r8.getResources()
            r9 = 17170445(0x106000d, float:2.461195E-38)
            int r8 = r8.getColor(r9)
            r1.setBackgroundColor(r8)
            android.widget.TextView r1 = r13.f71565f
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            android.content.Context r8 = r8.f71545c
            android.content.res.Resources r8 = r8.getResources()
            int r9 = net.one97.paytm.wallet.R.color.white
            int r8 = r8.getColor(r9)
            r1.setTextColor(r8)
            android.widget.TextView r1 = r13.f71566g
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            android.content.Context r8 = r8.f71545c
            android.content.res.Resources r8 = r8.getResources()
            int r9 = net.one97.paytm.wallet.R.drawable.circle_grey
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r9)
            r1.setBackground(r8)
            goto L_0x00c4
        L_0x008b:
            android.widget.LinearLayout r1 = r13.f71563d
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            android.content.Context r8 = r8.f71545c
            android.content.res.Resources r8 = r8.getResources()
            int r9 = net.one97.paytm.wallet.R.color.white
            int r8 = r8.getColor(r9)
            r1.setBackgroundColor(r8)
            android.widget.TextView r1 = r13.f71565f
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            android.content.Context r8 = r8.f71545c
            android.content.res.Resources r8 = r8.getResources()
            int r9 = net.one97.paytm.wallet.R.color.color_222222
            int r8 = r8.getColor(r9)
            r1.setTextColor(r8)
            android.widget.TextView r1 = r13.f71566g
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            android.content.Context r8 = r8.f71545c
            android.content.res.Resources r8 = r8.getResources()
            int r9 = net.one97.paytm.wallet.R.drawable.transparent_gray_circle
            android.graphics.drawable.Drawable r8 = r8.getDrawable(r9)
            r1.setBackground(r8)
        L_0x00c4:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentSendMoney
            if (r1 == 0) goto L_0x00d9
            net.one97.paytm.common.entity.wallet.RecentSendMoney r0 = (net.one97.paytm.common.entity.wallet.RecentSendMoney) r0
            java.lang.String r1 = r0.getImageurl()
            java.lang.String r2 = r0.getPhoneNumber()
            java.lang.String r0 = r0.getName()
            r8 = r1
            r10 = r2
            goto L_0x0132
        L_0x00d9:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentScan
            if (r1 == 0) goto L_0x012f
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel
            r1.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f8 }
            r9 = r0
            net.one97.paytm.common.entity.wallet.RecentScan r9 = (net.one97.paytm.common.entity.wallet.RecentScan) r9     // Catch:{ JSONException -> 0x00f8 }
            java.lang.String r9 = r9.getScanResult()     // Catch:{ JSONException -> 0x00f8 }
            r8.<init>(r9)     // Catch:{ JSONException -> 0x00f8 }
            net.one97.paytm.wallet.p2p.a r9 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ JSONException -> 0x00f8 }
            android.content.Context r9 = r9.f71545c     // Catch:{ JSONException -> 0x00f8 }
            r1.parseData((org.json.JSONObject) r8, (android.content.Context) r9)     // Catch:{ JSONException -> 0x00f8 }
            r0 = r6
            r9 = 1
            goto L_0x0110
        L_0x00f8:
            r8 = move-exception
            net.one97.paytm.common.entity.wallet.RecentScan r0 = (net.one97.paytm.common.entity.wallet.RecentScan) r0
            java.lang.String r0 = r0.getScanResult()
            if (r0 == 0) goto L_0x0107
            java.lang.String r0 = b(r0)
            r9 = 0
            goto L_0x0109
        L_0x0107:
            r0 = r6
            r9 = 1
        L_0x0109:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            com.paytm.utility.q.d(r8)
        L_0x0110:
            java.lang.String r8 = r1.getLogoURL()
            java.lang.String r10 = r1.getMobileNo()
            if (r9 == 0) goto L_0x012d
            java.lang.String r0 = r1.getRequestType()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0129
            java.lang.String r0 = r1.getName()
            goto L_0x012d
        L_0x0129:
            java.lang.String r0 = r1.getMerchantName()
        L_0x012d:
            r1 = 0
            goto L_0x0133
        L_0x012f:
            r0 = r6
            r8 = r0
            r10 = r8
        L_0x0132:
            r1 = 1
        L_0x0133:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r0 = r10
        L_0x013b:
            java.lang.String r2 = a(r0)
            android.widget.TextView r9 = r13.f71564e
            int r10 = android.graphics.Color.parseColor(r14)
            r9.setBackgroundColor(r10)
            if (r1 == 0) goto L_0x01c1
            android.widget.RelativeLayout r14 = r13.f71561b
            r14.setVisibility(r7)
            android.widget.RelativeLayout r14 = r13.f71560a
            r14.setVisibility(r5)
            boolean r14 = android.text.TextUtils.isEmpty(r8)
            if (r14 != 0) goto L_0x0195
            android.widget.ImageView r14 = r13.f71568i
            r14.setVisibility(r7)
            android.widget.ImageView r14 = r13.f71568i
            r14.setImageDrawable(r6)
            android.widget.RelativeLayout r14 = r13.l
            r14.setVisibility(r5)
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x022e }
            com.squareup.picasso.aa r14 = r14.a((java.lang.String) r8)     // Catch:{ Exception -> 0x022e }
            net.one97.paytm.wallet.p2p.a$a r1 = new net.one97.paytm.wallet.p2p.a$a     // Catch:{ Exception -> 0x022e }
            net.one97.paytm.wallet.p2p.a r2 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x022e }
            r1.<init>(r2, r7)     // Catch:{ Exception -> 0x022e }
            com.squareup.picasso.aa r14 = r14.a((com.squareup.picasso.ah) r1)     // Catch:{ Exception -> 0x022e }
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x022e }
            android.content.Context r1 = r1.f71545c     // Catch:{ Exception -> 0x022e }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x022e }
            int r2 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x022e }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch:{ Exception -> 0x022e }
            com.squareup.picasso.aa r14 = r14.a((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x022e }
            android.widget.ImageView r1 = r13.f71568i     // Catch:{ Exception -> 0x022e }
            r14.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r6)     // Catch:{ Exception -> 0x022e }
            goto L_0x022e
        L_0x0195:
            android.widget.ImageView r14 = r13.f71568i
            r14.setVisibility(r5)
            android.widget.ImageView r14 = r13.f71568i
            r14.setImageDrawable(r6)
            android.widget.RelativeLayout r14 = r13.l
            r14.setVisibility(r7)
            boolean r14 = android.text.TextUtils.isEmpty(r2)
            if (r14 != 0) goto L_0x01b6
            android.widget.TextView r14 = r13.f71564e
            r14.setText(r2)
            android.widget.ImageView r14 = r13.f71567h
            r14.setVisibility(r5)
            goto L_0x022e
        L_0x01b6:
            android.widget.TextView r14 = r13.f71564e
            r14.setText(r3)
            android.widget.ImageView r14 = r13.f71567h
            r14.setVisibility(r7)
            goto L_0x022e
        L_0x01c1:
            android.widget.RelativeLayout r1 = r13.f71560a
            r1.setVisibility(r7)
            android.widget.RelativeLayout r1 = r13.f71561b
            r1.setVisibility(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L_0x0208
            android.widget.ImageView r14 = r13.j
            r14.setVisibility(r7)
            android.widget.ImageView r14 = r13.j
            r14.setBackground(r6)
            android.widget.RelativeLayout r14 = r13.m
            r14.setVisibility(r5)
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x022e }
            com.squareup.picasso.aa r14 = r14.a((java.lang.String) r8)     // Catch:{ Exception -> 0x022e }
            r14.f45353b = r4     // Catch:{ Exception -> 0x022e }
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x022e }
            android.content.Context r1 = r1.f71545c     // Catch:{ Exception -> 0x022e }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x022e }
            int r2 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x022e }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch:{ Exception -> 0x022e }
            com.squareup.picasso.aa r14 = r14.a((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x022e }
            int r1 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x022e }
            com.squareup.picasso.aa r14 = r14.b((int) r1)     // Catch:{ Exception -> 0x022e }
            android.widget.ImageView r1 = r13.j     // Catch:{ Exception -> 0x022e }
            r14.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r6)     // Catch:{ Exception -> 0x022e }
            goto L_0x022e
        L_0x0208:
            android.widget.ImageView r1 = r13.j
            r1.setVisibility(r5)
            android.widget.ImageView r1 = r13.j
            r1.setImageDrawable(r6)
            android.widget.RelativeLayout r1 = r13.m
            r1.setVisibility(r7)
            android.widget.ImageView r1 = r13.k
            r1.setVisibility(r5)
            android.widget.TextView r1 = r13.f71566g
            if (r2 == 0) goto L_0x0221
            goto L_0x0222
        L_0x0221:
            r2 = r3
        L_0x0222:
            r1.setText(r2)
            android.widget.TextView r1 = r13.f71566g
            int r14 = android.graphics.Color.parseColor(r14)
            r1.setBackgroundColor(r14)
        L_0x022e:
            android.widget.TextView r13 = r13.f71565f
            r13.setText(r0)
            return
        L_0x0234:
            boolean r1 = r13 instanceof net.one97.paytm.wallet.p2p.a.g
            if (r1 == 0) goto L_0x0305
            net.one97.paytm.wallet.p2p.a$g r13 = (net.one97.paytm.wallet.p2p.a.g) r13
            android.widget.LinearLayout r1 = r13.f71570a
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r1.setTag(r14)
            net.one97.paytm.wallet.p2p.a r14 = net.one97.paytm.wallet.p2p.a.this
            boolean r14 = r14.f71548f
            if (r14 == 0) goto L_0x0250
            android.widget.LinearLayout r14 = r13.f71570a
            r14.setClickable(r4)
        L_0x0250:
            boolean r14 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentSendMoney
            if (r14 == 0) goto L_0x0265
            net.one97.paytm.common.entity.wallet.RecentSendMoney r0 = (net.one97.paytm.common.entity.wallet.RecentSendMoney) r0
            java.lang.String r14 = r0.getImageurl()
            r0.getPhoneNumber()
            java.lang.String r0 = r0.getName()
            r11 = r0
            r0 = r14
            r14 = r11
            goto L_0x02a6
        L_0x0265:
            boolean r14 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentScan
            if (r14 == 0) goto L_0x02a4
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r14 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel
            r14.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0281 }
            net.one97.paytm.common.entity.wallet.RecentScan r0 = (net.one97.paytm.common.entity.wallet.RecentScan) r0     // Catch:{ JSONException -> 0x0281 }
            java.lang.String r0 = r0.getScanResult()     // Catch:{ JSONException -> 0x0281 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0281 }
            net.one97.paytm.wallet.p2p.a r0 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ JSONException -> 0x0281 }
            android.content.Context r0 = r0.f71545c     // Catch:{ JSONException -> 0x0281 }
            r14.parseData((org.json.JSONObject) r1, (android.content.Context) r0)     // Catch:{ JSONException -> 0x0281 }
            goto L_0x0289
        L_0x0281:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
        L_0x0289:
            java.lang.String r0 = r14.getLogoURL()
            r14.getMobileNo()
            java.lang.String r1 = r14.getRequestType()
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x029f
            java.lang.String r14 = r14.getName()
            goto L_0x02a6
        L_0x029f:
            java.lang.String r14 = r14.getMerchantName()
            goto L_0x02a6
        L_0x02a4:
            r14 = r6
            r0 = r14
        L_0x02a6:
            java.lang.String r1 = a(r14)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x02eb
            net.one97.paytm.common.widgets.CircularImageView r1 = r13.f71573d
            r1.setVisibility(r7)
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x02e9 }
            com.squareup.picasso.aa r0 = r1.a((java.lang.String) r0)     // Catch:{ Exception -> 0x02e9 }
            r0.f45353b = r4     // Catch:{ Exception -> 0x02e9 }
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x02e9 }
            android.content.Context r1 = r1.f71545c     // Catch:{ Exception -> 0x02e9 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x02e9 }
            int r2 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x02e9 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch:{ Exception -> 0x02e9 }
            com.squareup.picasso.aa r0 = r0.a((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x02e9 }
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x02e9 }
            android.content.Context r1 = r1.f71545c     // Catch:{ Exception -> 0x02e9 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x02e9 }
            int r2 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x02e9 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch:{ Exception -> 0x02e9 }
            com.squareup.picasso.aa r0 = r0.b((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x02e9 }
            net.one97.paytm.common.widgets.CircularImageView r1 = r13.f71573d     // Catch:{ Exception -> 0x02e9 }
            r0.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r6)     // Catch:{ Exception -> 0x02e9 }
            goto L_0x02f9
        L_0x02e9:
            goto L_0x02f9
        L_0x02eb:
            net.one97.paytm.common.widgets.CircularImageView r0 = r13.f71573d
            r0.setVisibility(r5)
            android.widget.TextView r0 = r13.f71571b
            if (r1 == 0) goto L_0x02f5
            goto L_0x02f6
        L_0x02f5:
            r1 = r3
        L_0x02f6:
            r0.setText(r1)
        L_0x02f9:
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x0304
            android.widget.TextView r13 = r13.f71572c
            r13.setText(r14)
        L_0x0304:
            return
        L_0x0305:
            boolean r1 = r13 instanceof net.one97.paytm.wallet.p2p.a.h
            if (r1 == 0) goto L_0x04f7
            net.one97.paytm.wallet.p2p.a$h r13 = (net.one97.paytm.wallet.p2p.a.h) r13
            android.widget.LinearLayout r1 = r13.f71579e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r14)
            r1.setTag(r8)
            int r1 = r14 % 20
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            java.util.ArrayList<java.lang.String> r8 = r8.f71549g
            int r1 = r1 % 10
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            boolean r8 = r8.f71548f
            if (r8 == 0) goto L_0x032f
            android.widget.LinearLayout r8 = r13.f71579e
            r8.setClickable(r4)
        L_0x032f:
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            boolean r8 = r8.f71543a
            if (r8 == 0) goto L_0x0366
            net.one97.paytm.wallet.p2p.a r8 = net.one97.paytm.wallet.p2p.a.this
            int r8 = r8.getItemCount()
            int r8 = r8 - r4
            if (r14 != r8) goto L_0x0366
            android.widget.RelativeLayout r14 = r13.f71575a
            r14.setVisibility(r7)
            android.widget.RelativeLayout r14 = r13.f71576b
            r14.setVisibility(r5)
            android.widget.ImageView r14 = r13.k
            r14.setBackground(r6)
            android.widget.RelativeLayout r14 = r13.n
            r14.setVisibility(r5)
            android.widget.ImageView r14 = r13.k
            r14.setVisibility(r7)
            android.widget.ImageView r14 = r13.k
            int r0 = net.one97.paytm.wallet.R.drawable.ic_view_all
            r14.setImageResource(r0)
            android.widget.TextView r13 = r13.f71581g
            int r14 = net.one97.paytm.wallet.R.string.view_all
            r13.setText(r14)
            return
        L_0x0366:
            boolean r14 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentSendMoney
            if (r14 == 0) goto L_0x037b
            net.one97.paytm.common.entity.wallet.RecentSendMoney r0 = (net.one97.paytm.common.entity.wallet.RecentSendMoney) r0
            java.lang.String r14 = r0.getImageurl()
            java.lang.String r2 = r0.getPhoneNumber()
            java.lang.String r0 = r0.getName()
            r8 = r14
            r10 = r2
            goto L_0x03d5
        L_0x037b:
            boolean r14 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentScan
            if (r14 == 0) goto L_0x03d2
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r14 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel
            r14.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x039a }
            r9 = r0
            net.one97.paytm.common.entity.wallet.RecentScan r9 = (net.one97.paytm.common.entity.wallet.RecentScan) r9     // Catch:{ JSONException -> 0x039a }
            java.lang.String r9 = r9.getScanResult()     // Catch:{ JSONException -> 0x039a }
            r8.<init>(r9)     // Catch:{ JSONException -> 0x039a }
            net.one97.paytm.wallet.p2p.a r9 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ JSONException -> 0x039a }
            android.content.Context r9 = r9.f71545c     // Catch:{ JSONException -> 0x039a }
            r14.parseData((org.json.JSONObject) r8, (android.content.Context) r9)     // Catch:{ JSONException -> 0x039a }
            r0 = r6
            r9 = 1
            goto L_0x03b2
        L_0x039a:
            r8 = move-exception
            net.one97.paytm.common.entity.wallet.RecentScan r0 = (net.one97.paytm.common.entity.wallet.RecentScan) r0
            java.lang.String r0 = r0.getScanResult()
            if (r0 == 0) goto L_0x03a9
            java.lang.String r0 = b(r0)
            r9 = 0
            goto L_0x03ab
        L_0x03a9:
            r0 = r6
            r9 = 1
        L_0x03ab:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            com.paytm.utility.q.d(r8)
        L_0x03b2:
            java.lang.String r8 = r14.getLogoURL()
            java.lang.String r10 = r14.getMobileNo()
            if (r9 == 0) goto L_0x03d0
            java.lang.String r0 = r14.getRequestType()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x03cb
            java.lang.String r14 = r14.getName()
            goto L_0x03cf
        L_0x03cb:
            java.lang.String r14 = r14.getMerchantName()
        L_0x03cf:
            r0 = r14
        L_0x03d0:
            r14 = 0
            goto L_0x03d6
        L_0x03d2:
            r0 = r6
            r8 = r0
            r10 = r8
        L_0x03d5:
            r14 = 1
        L_0x03d6:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x03dd
            goto L_0x03de
        L_0x03dd:
            r0 = r10
        L_0x03de:
            java.lang.String r2 = a(r0)
            java.lang.String r2 = r2.toUpperCase()
            android.widget.TextView r9 = r13.f71580f
            int r10 = android.graphics.Color.parseColor(r1)
            r9.setBackgroundColor(r10)
            if (r14 == 0) goto L_0x0474
            android.widget.RelativeLayout r14 = r13.f71576b
            r14.setVisibility(r7)
            android.widget.RelativeLayout r14 = r13.f71575a
            r14.setVisibility(r5)
            boolean r14 = android.text.TextUtils.isEmpty(r8)
            if (r14 != 0) goto L_0x043d
            android.widget.ImageView r14 = r13.j
            r14.setVisibility(r7)
            android.widget.ImageView r14 = r13.j
            r14.setImageDrawable(r6)
            android.widget.RelativeLayout r14 = r13.m
            r14.setVisibility(r5)
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x043b }
            com.squareup.picasso.aa r14 = r14.a((java.lang.String) r8)     // Catch:{ Exception -> 0x043b }
            net.one97.paytm.wallet.p2p.a$a r1 = new net.one97.paytm.wallet.p2p.a$a     // Catch:{ Exception -> 0x043b }
            net.one97.paytm.wallet.p2p.a r2 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x043b }
            r1.<init>(r2, r7)     // Catch:{ Exception -> 0x043b }
            com.squareup.picasso.aa r14 = r14.a((com.squareup.picasso.ah) r1)     // Catch:{ Exception -> 0x043b }
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x043b }
            android.content.Context r1 = r1.f71545c     // Catch:{ Exception -> 0x043b }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x043b }
            int r2 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x043b }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch:{ Exception -> 0x043b }
            com.squareup.picasso.aa r14 = r14.a((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x043b }
            android.widget.ImageView r1 = r13.j     // Catch:{ Exception -> 0x043b }
            r14.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r6)     // Catch:{ Exception -> 0x043b }
            goto L_0x0467
        L_0x043b:
            goto L_0x0467
        L_0x043d:
            android.widget.ImageView r14 = r13.j
            r14.setVisibility(r5)
            android.widget.ImageView r14 = r13.j
            r14.setImageDrawable(r6)
            android.widget.RelativeLayout r14 = r13.m
            r14.setVisibility(r7)
            boolean r14 = android.text.TextUtils.isEmpty(r2)
            if (r14 != 0) goto L_0x045d
            android.widget.TextView r14 = r13.f71580f
            r14.setText(r2)
            android.widget.ImageView r14 = r13.f71583i
            r14.setVisibility(r5)
            goto L_0x0467
        L_0x045d:
            android.widget.TextView r14 = r13.f71580f
            r14.setText(r3)
            android.widget.ImageView r14 = r13.f71583i
            r14.setVisibility(r7)
        L_0x0467:
            net.one97.paytm.wallet.p2p.a r14 = net.one97.paytm.wallet.p2p.a.this
            boolean r14 = r14.f71544b
            if (r14 == 0) goto L_0x04ee
            android.widget.ImageView r14 = r13.f71577c
            r14.setVisibility(r7)
            goto L_0x04ee
        L_0x0474:
            android.widget.RelativeLayout r14 = r13.f71575a
            r14.setVisibility(r7)
            android.widget.RelativeLayout r14 = r13.f71576b
            r14.setVisibility(r5)
            boolean r14 = android.text.TextUtils.isEmpty(r8)
            if (r14 != 0) goto L_0x04bd
            android.widget.ImageView r14 = r13.k
            r14.setVisibility(r7)
            android.widget.ImageView r14 = r13.k
            r14.setBackground(r6)
            android.widget.RelativeLayout r14 = r13.n
            r14.setVisibility(r5)
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x04bb }
            com.squareup.picasso.aa r14 = r14.a((java.lang.String) r8)     // Catch:{ Exception -> 0x04bb }
            r14.f45353b = r4     // Catch:{ Exception -> 0x04bb }
            net.one97.paytm.wallet.p2p.a r1 = net.one97.paytm.wallet.p2p.a.this     // Catch:{ Exception -> 0x04bb }
            android.content.Context r1 = r1.f71545c     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x04bb }
            int r2 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x04bb }
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch:{ Exception -> 0x04bb }
            com.squareup.picasso.aa r14 = r14.a((android.graphics.drawable.Drawable) r1)     // Catch:{ Exception -> 0x04bb }
            int r1 = net.one97.paytm.wallet.R.drawable.profile_logout     // Catch:{ Exception -> 0x04bb }
            com.squareup.picasso.aa r14 = r14.b((int) r1)     // Catch:{ Exception -> 0x04bb }
            android.widget.ImageView r1 = r13.k     // Catch:{ Exception -> 0x04bb }
            r14.a((android.widget.ImageView) r1, (com.squareup.picasso.e) r6)     // Catch:{ Exception -> 0x04bb }
            goto L_0x04e3
        L_0x04bb:
            goto L_0x04e3
        L_0x04bd:
            android.widget.ImageView r14 = r13.k
            r14.setVisibility(r5)
            android.widget.ImageView r14 = r13.k
            r14.setImageDrawable(r6)
            android.widget.RelativeLayout r14 = r13.n
            r14.setVisibility(r7)
            android.widget.ImageView r14 = r13.l
            r14.setVisibility(r5)
            android.widget.TextView r14 = r13.f71582h
            if (r2 == 0) goto L_0x04d6
            goto L_0x04d7
        L_0x04d6:
            r2 = r3
        L_0x04d7:
            r14.setText(r2)
            android.widget.TextView r14 = r13.f71582h
            int r1 = android.graphics.Color.parseColor(r1)
            r14.setBackgroundColor(r1)
        L_0x04e3:
            net.one97.paytm.wallet.p2p.a r14 = net.one97.paytm.wallet.p2p.a.this
            boolean r14 = r14.f71544b
            if (r14 == 0) goto L_0x04ee
            android.widget.ImageView r14 = r13.f71578d
            r14.setVisibility(r7)
        L_0x04ee:
            android.widget.TextView r13 = r13.f71581g
            java.lang.String r14 = com.paytm.utility.b.A((java.lang.String) r0)
            r13.setText(r14)
        L_0x04f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.p2p.a.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.k = recyclerView;
    }

    public final int getItemCount() {
        ArrayList<IJRDataModel> arrayList = this.f71546d;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList.size() > 20) {
            return 20;
        }
        return this.f71546d.size();
    }

    public final void a() {
        int size = this.f71546d.size();
        this.f71546d.clear();
        notifyItemRangeRemoved(0, size);
    }

    class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f71560a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f71561b;

        /* renamed from: c  reason: collision with root package name */
        WalletCircularProgressBar f71562c;
        /* access modifiers changed from: package-private */

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f71563d;

        /* renamed from: e  reason: collision with root package name */
        TextView f71564e;

        /* renamed from: f  reason: collision with root package name */
        TextView f71565f;

        /* renamed from: g  reason: collision with root package name */
        TextView f71566g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f71567h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f71568i;
        ImageView j;
        ImageView k;
        RelativeLayout l;
        RelativeLayout m;

        public b(View view) {
            super(view);
            this.f71563d = (LinearLayout) view.findViewById(R.id.p2p_recent_row_ll);
            this.f71561b = (RelativeLayout) view.findViewById(R.id.p2p_profile_RL);
            this.f71560a = (RelativeLayout) view.findViewById(R.id.p2m_profile_rl);
            this.l = (RelativeLayout) view.findViewById(R.id.layer_contact_list_logo_rl);
            this.m = (RelativeLayout) view.findViewById(R.id.layer_contact_list_logo_rl_p2m);
            this.f71568i = (ImageView) view.findViewById(R.id.p2p_profile_iv);
            this.f71564e = (TextView) view.findViewById(R.id.layer_contact_list_initials);
            this.f71567h = (ImageView) view.findViewById(R.id.layer_contact_list_img);
            this.k = (ImageView) view.findViewById(R.id.layer_contact_list_img_p2m);
            this.j = (ImageView) view.findViewById(R.id.p2m_profile_iv);
            this.f71566g = (TextView) view.findViewById(R.id.p2m_image_name_tv);
            this.f71565f = (TextView) view.findViewById(R.id.layer_contact_name);
            this.f71562c = (WalletCircularProgressBar) view.findViewById(R.id.p2p_progress_bar);
            this.f71563d.setOnClickListener(this);
        }

        public final void onClick(View view) {
            try {
                a.this.f71548f = false;
                this.f71562c.setVisibility(0);
                this.f71563d.setEnabled(false);
                this.f71563d.setClickable(false);
                a.this.f71546d.get(Integer.parseInt(view.getTag().toString()));
                if (a.this.f71550h != null) {
                    new c() {
                        public final void stopProgress() {
                            a.b.this.a();
                        }
                    };
                }
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        b.this.f71563d.setEnabled(true);
                    }
                }, 2000);
            } catch (NumberFormatException unused) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            this.f71562c.setVisibility(8);
            this.f71563d.setClickable(true);
        }
    }

    class h extends RecyclerView.v implements View.OnClickListener, View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f71575a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f71576b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f71577c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f71578d;
        /* access modifiers changed from: package-private */

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f71579e;

        /* renamed from: f  reason: collision with root package name */
        TextView f71580f;

        /* renamed from: g  reason: collision with root package name */
        TextView f71581g;

        /* renamed from: h  reason: collision with root package name */
        TextView f71582h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f71583i;
        ImageView j;
        ImageView k;
        ImageView l;
        RelativeLayout m;
        RelativeLayout n;
        private WalletCircularProgressBar p;

        public h(View view) {
            super(view);
            this.f71579e = (LinearLayout) view.findViewById(R.id.p2p_recent_row_ll);
            this.f71576b = (RelativeLayout) view.findViewById(R.id.p2p_profile_RL);
            this.f71575a = (RelativeLayout) view.findViewById(R.id.p2m_profile_rl);
            this.m = (RelativeLayout) view.findViewById(R.id.layer_contact_list_logo_rl);
            this.n = (RelativeLayout) view.findViewById(R.id.layer_contact_list_logo_rl_p2m);
            this.j = (ImageView) view.findViewById(R.id.p2p_profile_iv);
            this.f71580f = (TextView) view.findViewById(R.id.layer_contact_list_initials);
            this.f71583i = (ImageView) view.findViewById(R.id.layer_contact_list_img);
            this.l = (ImageView) view.findViewById(R.id.layer_contact_list_img_p2m);
            this.k = (ImageView) view.findViewById(R.id.p2m_profile_iv);
            this.f71582h = (TextView) view.findViewById(R.id.p2m_image_name_tv);
            this.f71581g = (TextView) view.findViewById(R.id.layer_contact_name);
            this.f71577c = (ImageView) view.findViewById(R.id.p2p_remove_recent_iv);
            this.f71578d = (ImageView) view.findViewById(R.id.p2m_remove_recent_iv);
            this.p = (WalletCircularProgressBar) view.findViewById(R.id.p2p_progress_bar);
            this.f71579e.setOnClickListener(this);
            this.f71579e.setOnLongClickListener(this);
        }

        public final void onClick(View view) {
            try {
                a.this.f71548f = false;
                if (a.this.k.getItemAnimator() == null || !a.this.k.getItemAnimator().b()) {
                    int parseInt = Integer.parseInt(view.getTag().toString());
                    IJRDataModel iJRDataModel = a.this.f71546d.get(parseInt);
                    if (a.this.f71544b) {
                        a.this.f71546d.remove(parseInt);
                        a.this.notifyItemRemoved(parseInt);
                        a aVar = a.this;
                        aVar.notifyItemRangeChanged(parseInt, aVar.f71546d.size());
                        a.this.j.onRemoved(parseInt, iJRDataModel);
                    } else {
                        this.p.setVisibility(0);
                        this.f71579e.setEnabled(false);
                        this.f71579e.setClickable(false);
                        if (a.this.f71543a && parseInt == a.this.getItemCount() - 1) {
                            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
                            ((Activity) a.this.f71545c).startActivityForResult(net.one97.paytm.contacts.utils.e.a(a.this.f71545c, e.c.SCANNER.getType()), 3001);
                            ((Activity) a.this.f71545c).overridePendingTransition(R.anim.wallet_bottom_up, R.anim.do_not_move);
                        } else if (a.this.f71551i != null) {
                            a.this.f71551i.a(iJRDataModel, new c() {
                                public final void stopProgress() {
                                    a.h.this.b();
                                }
                            });
                        }
                    }
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            a.h.this.a();
                        }
                    }, 2000);
                }
            } catch (NumberFormatException unused) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            this.p.setVisibility(8);
            this.f71579e.setClickable(true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            this.f71579e.setEnabled(true);
        }

        public final boolean onLongClick(View view) {
            int parseInt = Integer.parseInt(view.getTag().toString());
            if (a.this.f71551i == null) {
                return false;
            }
            a.this.f71551i.a(parseInt);
            return true;
        }
    }

    class g extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f71570a;

        /* renamed from: b  reason: collision with root package name */
        TextView f71571b;

        /* renamed from: c  reason: collision with root package name */
        TextView f71572c;

        /* renamed from: d  reason: collision with root package name */
        CircularImageView f71573d;

        public g(View view) {
            super(view);
            this.f71570a = (LinearLayout) view.findViewById(R.id.p2p_recent_row_ll);
            this.f71571b = (TextView) view.findViewById(R.id.p2m_image_name_tv);
            this.f71573d = (CircularImageView) view.findViewById(R.id.p2m_profile_iv);
            this.f71572c = (TextView) view.findViewById(R.id.layer_contact_name);
            this.f71570a.setOnClickListener(this);
        }

        public final void onClick(View view) {
            try {
                a.this.f71548f = false;
                IJRDataModel iJRDataModel = a.this.f71546d.get(Integer.parseInt(view.getTag().toString()));
                if (iJRDataModel instanceof RecentScan) {
                    a aVar = a.this;
                    RecentScan recentScan = (RecentScan) iJRDataModel;
                    net.one97.paytm.f.b.a().f50402a.setMode("recentBeneficiary");
                    try {
                        String scanResult = recentScan.getScanResult();
                        JSONObject jSONObject = new JSONObject(scanResult);
                        jSONObject.remove("ORDER_ID");
                        if (!com.paytm.utility.b.r(aVar.f71545c)) {
                            Intent intent = new Intent(aVar.f71545c, PaySendInfoActivity.class);
                            intent.putExtra("dest", "qr_send_money");
                            intent.putExtra("qr_scan_result", scanResult);
                            aVar.f71545c.startActivity(intent);
                            return;
                        }
                        String uniqKey = recentScan.getUniqKey();
                        if (TextUtils.isEmpty(uniqKey) || uniqKey.length() != 24) {
                            String jSONObject2 = jSONObject.toString();
                            CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                            try {
                                cJRQRScanResultModel.parseData(new JSONObject(jSONObject2), aVar.f71545c);
                            } catch (JSONException e2) {
                                q.d(String.valueOf(e2));
                            }
                            if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(cJRQRScanResultModel.getRequestType())) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("NAME", cJRQRScanResultModel.getName());
                                intent2.putExtra("PHONE_NUMBER", cJRQRScanResultModel.getMobileNo());
                                intent2.putExtra("MODE", "RECENT_SCAN");
                                net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
                                a2.f71392d = a.c.QR_SCAN_PAYTM_P2P;
                                a2.f71394f = H5AppHandler.CHECK_VALUE;
                                net.one97.paytm.wallet.utility.a.a(intent2, (Activity) aVar.f71545c);
                                return;
                            }
                            Intent intent3 = new Intent(aVar.f71545c, AJRQRActivity.class);
                            intent3.putExtra("OPERATION", "scan");
                            intent3.putExtra("scan_result", jSONObject2);
                            intent3.putExtra("QR_CODE_ID", cJRQRScanResultModel.getQrCodeId());
                            aVar.f71545c.startActivity(intent3);
                        }
                    } catch (Exception e3) {
                        q.d(String.valueOf(e3));
                    }
                } else if (iJRDataModel instanceof RecentSendMoney) {
                    RecentSendMoney recentSendMoney = (RecentSendMoney) iJRDataModel;
                    Intent intent4 = new Intent();
                    intent4.putExtra("PHONE_NUMBER", recentSendMoney.getPhoneNumber());
                    intent4.putExtra("NAME", recentSendMoney.getName());
                    intent4.putExtra("MODE_OF_PAYMENT", recentSendMoney.getModeOfPayment());
                    net.one97.paytm.wallet.utility.a.a(intent4, (Activity) a.this.f71545c);
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    private static String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String[] split = str.trim().split(" ");
        int length = split.length;
        if (length != 1 || TextUtils.isEmpty(split[0])) {
            if (length < 2) {
                return str2;
            }
            if (!TextUtils.isEmpty(split[0])) {
                String valueOf = String.valueOf(split[0].charAt(0));
                if (valueOf.matches("\\d+")) {
                    return str2;
                }
                str2 = valueOf;
            }
            if (TextUtils.isEmpty(split[1])) {
                return str2;
            }
            String valueOf2 = String.valueOf(split[1].charAt(0));
            if (valueOf2.matches("\\d+")) {
                return str2;
            }
            return str2 + valueOf2;
        } else if (String.valueOf(split[0].charAt(0)).matches("\\d+")) {
            return str2;
        } else {
            return String.valueOf(split[0].charAt(0));
        }
    }

    private static String b(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("pn");
            if (!TextUtils.isEmpty(queryParameter)) {
                return URLDecoder.decode(queryParameter, AppConstants.UTF_8);
            }
            return "UPI";
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return "UPI";
        }
    }

    /* renamed from: net.one97.paytm.wallet.p2p.a$a  reason: collision with other inner class name */
    class C1452a implements ah {
        public final String key() {
            return "circle";
        }

        private C1452a() {
        }

        /* synthetic */ C1452a(a aVar, byte b2) {
            this();
        }

        public final Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            float f2 = ((float) min) / 2.0f;
            canvas.drawCircle(f2, f2, f2, paint);
            createBitmap.recycle();
            return createBitmap2;
        }
    }
}
