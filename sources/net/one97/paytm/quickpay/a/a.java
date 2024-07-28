package net.one97.paytm.quickpay.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.common.widgets.CJRVolleyImageView;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<IJRDataModel> f59823a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<IJRDataModel> f59824b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f59825c;

    /* renamed from: d  reason: collision with root package name */
    private C1153a f59826d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f59827e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<String> f59828f = new ArrayList<String>() {
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

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public a(Context context, ArrayList<IJRDataModel> arrayList) {
        this.f59823a.addAll(arrayList);
        this.f59825c = LayoutInflater.from(context);
        this.f59827e = context;
        if (this.f59823a != null) {
            this.f59824b = new ArrayList<>();
            this.f59824b.addAll(this.f59823a);
        }
    }

    public final int getCount() {
        ArrayList<IJRDataModel> arrayList = this.f59824b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: a */
    public final IJRDataModel getItem(int i2) {
        return this.f59824b.get(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0179, code lost:
        if (r8.matches("\\d+") != false) goto L_0x01a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x031d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r19, android.view.View r20, android.view.ViewGroup r21) {
        /*
            r18 = this;
            r1 = r18
            net.one97.paytm.common.entity.IJRDataModel r0 = r18.getItem((int) r19)
            r2 = 0
            if (r20 != 0) goto L_0x00a1
            android.view.LayoutInflater r3 = r1.f59825c
            r4 = 2131560226(0x7f0d0722, float:1.8745818E38)
            r5 = r21
            android.view.View r3 = r3.inflate(r4, r5, r2)
            net.one97.paytm.quickpay.a.a$b r4 = new net.one97.paytm.quickpay.a.a$b
            r4.<init>()
            r5 = 2131369482(0x7f0a1e0a, float:1.8358944E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r4.f59830a = r5
            r5 = 2131368148(0x7f0a18d4, float:1.8356238E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r4.f59831b = r5
            r5 = 2131368117(0x7f0a18b5, float:1.8356175E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r4.f59832c = r5
            r5 = 2131366352(0x7f0a11d0, float:1.8352595E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r4.k = r5
            r5 = 2131366351(0x7f0a11cf, float:1.8352593E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f59833d = r5
            r5 = 2131366354(0x7f0a11d2, float:1.83526E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f59834e = r5
            r5 = 2131366355(0x7f0a11d3, float:1.8352601E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f59835f = r5
            r5 = 2131366345(0x7f0a11c9, float:1.835258E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f59836g = r5
            r5 = 2131366349(0x7f0a11cd, float:1.835259E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r4.f59838i = r5
            r5 = 2131368149(0x7f0a18d5, float:1.835624E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r4.j = r5
            r5 = 2131368116(0x7f0a18b4, float:1.8356173E38)
            android.view.View r5 = r3.findViewById(r5)
            net.one97.paytm.common.widgets.CJRVolleyImageView r5 = (net.one97.paytm.common.widgets.CJRVolleyImageView) r5
            r4.l = r5
            r5 = 2131368113(0x7f0a18b1, float:1.8356167E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f59837h = r5
            r3.setTag(r4)
            goto L_0x00a3
        L_0x00a1:
            r3 = r20
        L_0x00a3:
            java.lang.Object r4 = r3.getTag()
            net.one97.paytm.quickpay.a.a$b r4 = (net.one97.paytm.quickpay.a.a.b) r4
            r5 = 10
            int r6 = r19 % 10
            java.util.ArrayList<java.lang.String> r7 = r1.f59828f
            java.lang.Object r6 = r7.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            android.widget.TextView r7 = r4.f59833d
            int r6 = android.graphics.Color.parseColor(r6)
            r7.setBackgroundColor(r6)
            boolean r6 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentSendMoney
            r10 = 1
            if (r6 == 0) goto L_0x00dc
            net.one97.paytm.common.entity.wallet.RecentSendMoney r0 = (net.one97.paytm.common.entity.wallet.RecentSendMoney) r0
            java.lang.String r6 = r0.getImageurl()
            java.lang.String r11 = r0.getPhoneNumber()
            java.lang.String r12 = r0.getName()
            java.lang.String r13 = r0.getAmount()
            long r14 = r0.getTimestamp()
            r0 = r6
            r6 = 1
            goto L_0x0125
        L_0x00dc:
            boolean r6 = r0 instanceof net.one97.paytm.common.entity.wallet.RecentScan
            if (r6 == 0) goto L_0x011e
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r6 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel
            r6.<init>()
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f6 }
            net.one97.paytm.common.entity.wallet.RecentScan r0 = (net.one97.paytm.common.entity.wallet.RecentScan) r0     // Catch:{ JSONException -> 0x00f6 }
            java.lang.String r0 = r0.getScanResult()     // Catch:{ JSONException -> 0x00f6 }
            r11.<init>(r0)     // Catch:{ JSONException -> 0x00f6 }
            android.content.Context r0 = r1.f59827e     // Catch:{ JSONException -> 0x00f6 }
            r6.parseData((org.json.JSONObject) r11, (android.content.Context) r0)     // Catch:{ JSONException -> 0x00f6 }
            goto L_0x00fe
        L_0x00f6:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x00fe:
            java.lang.String r0 = r6.getLogoURL()
            java.lang.String r11 = r6.getMobileNo()
            java.lang.String r12 = r6.getRequestType()
            java.lang.String r13 = "QR_CODE_REQUEST_MONEY"
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x0117
            java.lang.String r6 = r6.getName()
            goto L_0x011b
        L_0x0117:
            java.lang.String r6 = r6.getMerchantName()
        L_0x011b:
            r12 = r6
            r6 = 0
            goto L_0x0122
        L_0x011e:
            r0 = 0
            r6 = 1
            r11 = 0
            r12 = 0
        L_0x0122:
            r13 = 0
            r14 = 0
        L_0x0125:
            boolean r16 = android.text.TextUtils.isEmpty(r12)
            java.lang.String r7 = ""
            if (r16 != 0) goto L_0x01a9
            java.lang.String r8 = r12.trim()
            java.lang.String r5 = " "
            java.lang.String[] r5 = r8.split(r5)
            int r8 = r5.length
            java.lang.String r9 = "\\d+"
            if (r8 != r10) goto L_0x0160
            r17 = r5[r2]
            boolean r17 = android.text.TextUtils.isEmpty(r17)
            if (r17 != 0) goto L_0x0160
            r8 = r5[r2]
            char r8 = r8.charAt(r2)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            boolean r8 = r8.matches(r9)
            if (r8 == 0) goto L_0x0155
            goto L_0x01a9
        L_0x0155:
            r5 = r5[r2]
            char r5 = r5.charAt(r2)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L_0x01aa
        L_0x0160:
            r10 = 2
            if (r8 < r10) goto L_0x01a9
            r8 = r5[r2]
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x017c
            r8 = r5[r2]
            char r8 = r8.charAt(r2)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            boolean r10 = r8.matches(r9)
            if (r10 == 0) goto L_0x017d
            goto L_0x01a9
        L_0x017c:
            r8 = r7
        L_0x017d:
            r10 = 1
            r17 = r5[r10]
            boolean r17 = android.text.TextUtils.isEmpty(r17)
            if (r17 != 0) goto L_0x01a7
            r5 = r5[r10]
            char r5 = r5.charAt(r2)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r9 = r5.matches(r9)
            if (r9 == 0) goto L_0x0197
            goto L_0x01a9
        L_0x0197:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            goto L_0x01aa
        L_0x01a7:
            r5 = r8
            goto L_0x01aa
        L_0x01a9:
            r5 = r7
        L_0x01aa:
            android.widget.TextView r8 = r4.f59835f
            r8.setText(r11)
            r8 = 8
            if (r6 == 0) goto L_0x0217
            android.widget.RelativeLayout r6 = r4.f59831b
            r6.setVisibility(r2)
            android.widget.RelativeLayout r6 = r4.f59832c
            r6.setVisibility(r8)
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L_0x01f1
            android.widget.ImageView r5 = r4.j
            r5.setVisibility(r2)
            android.widget.RelativeLayout r5 = r4.k
            r5.setVisibility(r8)
            com.squareup.picasso.w r5 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r0 = r5.a((java.lang.String) r0)
            android.content.Context r5 = r1.f59827e
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131233863(0x7f080c47, float:1.8083876E38)
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            com.squareup.picasso.aa r0 = r0.a((android.graphics.drawable.Drawable) r5)
            com.squareup.picasso.aa r0 = r0.b((int) r6)
            android.widget.ImageView r5 = r4.j
            r6 = 0
            r0.a((android.widget.ImageView) r5, (com.squareup.picasso.e) r6)
            goto L_0x0246
        L_0x01f1:
            android.widget.ImageView r0 = r4.j
            r0.setVisibility(r8)
            android.widget.RelativeLayout r0 = r4.k
            r0.setVisibility(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x020c
            android.widget.TextView r0 = r4.f59833d
            r0.setText(r5)
            android.widget.ImageView r0 = r4.f59838i
            r0.setVisibility(r8)
            goto L_0x0246
        L_0x020c:
            android.widget.TextView r0 = r4.f59833d
            r0.setText(r7)
            android.widget.ImageView r0 = r4.f59838i
            r0.setVisibility(r2)
            goto L_0x0246
        L_0x0217:
            android.widget.RelativeLayout r6 = r4.f59831b
            r6.setVisibility(r8)
            android.widget.RelativeLayout r6 = r4.f59832c
            r6.setVisibility(r2)
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L_0x0238
            net.one97.paytm.common.widgets.CJRVolleyImageView r5 = r4.l
            r5.setVisibility(r2)
            net.one97.paytm.common.widgets.CJRVolleyImageView r5 = r4.l
            com.paytm.network.b.h r6 = com.paytm.network.b.h.INSTANCE
            com.android.volley.toolbox.ImageLoader r6 = r6.getImageLoader()
            r5.setImageUrl((java.lang.String) r0, (com.android.volley.toolbox.ImageLoader) r6)
            goto L_0x0246
        L_0x0238:
            net.one97.paytm.common.widgets.CJRVolleyImageView r0 = r4.l
            r0.setVisibility(r8)
            android.widget.TextView r0 = r4.f59837h
            if (r5 == 0) goto L_0x0242
            goto L_0x0243
        L_0x0242:
            r5 = r7
        L_0x0243:
            r0.setText(r5)
        L_0x0246:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x0252
            android.widget.TextView r0 = r4.f59834e
            r0.setText(r12)
            goto L_0x0258
        L_0x0252:
            android.widget.TextView r0 = r4.f59834e
            r0.setText(r11)
            r12 = r11
        L_0x0258:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x02ab
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x02a1
            java.lang.String r0 = "[\\D]"
            java.lang.String r0 = r12.replaceAll(r0, r7)
            int r5 = r0.length()
            r6 = 10
            if (r5 <= r6) goto L_0x028f
            java.lang.String r5 = "0"
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto L_0x0282
            java.lang.String r5 = "91"
            boolean r5 = r0.startsWith(r5)
            if (r5 == 0) goto L_0x028f
        L_0x0282:
            int r5 = r0.length()
            int r5 = r5 - r6
            java.lang.String r0 = r0.substring(r5)
            java.lang.String r0 = r0.trim()
        L_0x028f:
            java.lang.String r5 = "^([6,7,8,9]{1}+[0-9]{9})$"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.util.regex.Matcher r0 = r5.matcher(r0)
            boolean r0 = r0.find()
            if (r0 == 0) goto L_0x02a1
            r0 = 1
            goto L_0x02a2
        L_0x02a1:
            r0 = 0
        L_0x02a2:
            if (r0 == 0) goto L_0x02ab
            android.widget.TextView r0 = r4.f59835f
            r5 = 4
            r0.setVisibility(r5)
            goto L_0x02b0
        L_0x02ab:
            android.widget.TextView r0 = r4.f59835f
            r0.setVisibility(r2)
        L_0x02b0:
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L_0x034c
            r5 = 0
            int r0 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x034c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "Paid "
            r0.<init>(r5)
            android.content.Context r5 = r1.f59827e
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131962665(0x7f132b29, float:1.9562062E38)
            java.lang.String r5 = r5.getString(r6)
            r0.append(r5)
            r0.append(r13)
            java.lang.String r5 = ", "
            r0.append(r5)
            java.lang.Long r5 = java.lang.Long.valueOf(r14)
            java.util.Date r6 = new java.util.Date
            long r9 = r5.longValue()
            r6.<init>(r9)
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            r5.setTime(r6)
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            java.util.Calendar r9 = java.util.Calendar.getInstance()
            r10 = -1
            r11 = 6
            r7.add(r11, r10)
            r10 = 1
            int r12 = r9.get(r10)
            int r13 = r5.get(r10)
            java.lang.String r10 = "hh:mm a"
            if (r12 != r13) goto L_0x031d
            int r9 = r9.get(r11)
            int r12 = r5.get(r11)
            if (r9 != r12) goto L_0x031d
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r10)
            java.lang.String r5 = r5.format(r6)
            goto L_0x0345
        L_0x031d:
            r9 = 1
            int r12 = r7.get(r9)
            int r9 = r5.get(r9)
            if (r12 != r9) goto L_0x033a
            int r7 = r7.get(r11)
            int r5 = r5.get(r11)
            if (r7 != r5) goto L_0x033a
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r10)
            java.lang.String r5 = "YESTERDAY"
            goto L_0x0345
        L_0x033a:
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            java.lang.String r7 = "dd/MM/yy"
            r5.<init>(r7)
            java.lang.String r5 = r5.format(r6)
        L_0x0345:
            r0.append(r5)
            java.lang.String r7 = r0.toString()
        L_0x034c:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x035d
            android.widget.TextView r0 = r4.f59836g
            r0.setVisibility(r2)
            android.widget.TextView r0 = r4.f59836g
            r0.setText(r7)
            goto L_0x0362
        L_0x035d:
            android.widget.TextView r0 = r4.f59836g
            r0.setVisibility(r8)
        L_0x0362:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.a.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f59830a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f59831b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f59832c;

        /* renamed from: d  reason: collision with root package name */
        TextView f59833d;

        /* renamed from: e  reason: collision with root package name */
        TextView f59834e;

        /* renamed from: f  reason: collision with root package name */
        TextView f59835f;

        /* renamed from: g  reason: collision with root package name */
        TextView f59836g;

        /* renamed from: h  reason: collision with root package name */
        TextView f59837h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f59838i;
        ImageView j;
        RelativeLayout k;
        CJRVolleyImageView l;

        public b() {
        }
    }

    /* renamed from: net.one97.paytm.quickpay.a.a$a  reason: collision with other inner class name */
    public class C1153a extends Filter {
        public C1153a() {
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = a.this.f59823a;
                filterResults.count = a.this.f59823a.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = a.this.f59823a.iterator();
                while (it2.hasNext()) {
                    IJRDataModel iJRDataModel = (IJRDataModel) it2.next();
                    if (iJRDataModel instanceof RecentSendMoney) {
                        String phoneNumber = ((RecentSendMoney) iJRDataModel).getPhoneNumber();
                        if (!TextUtils.isEmpty(phoneNumber) && phoneNumber.trim().contains(charSequence.toString().trim())) {
                            arrayList.add(iJRDataModel);
                        }
                    } else if (iJRDataModel instanceof RecentScan) {
                        CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                        try {
                            cJRQRScanResultModel.parseData(new JSONObject(((RecentScan) iJRDataModel).getScanResult()), a.this.f59827e);
                        } catch (JSONException e2) {
                            q.b(e2.getMessage());
                        }
                        String mobileNo = cJRQRScanResultModel.getMobileNo();
                        if (!TextUtils.isEmpty(mobileNo) && mobileNo.trim().contains(charSequence.toString().trim())) {
                            arrayList.add(iJRDataModel);
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList unused = a.this.f59824b = (ArrayList) filterResults.values;
            a.this.notifyDataSetChanged();
        }
    }

    public final Filter getFilter() {
        if (this.f59826d == null) {
            this.f59826d = new C1153a();
        }
        return this.f59826d;
    }
}
