package net.one97.paytm.wallet.newdesign.addmoney.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.a.b;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals.PayTMPartnerListModal;
import net.one97.paytm.wallet.newdesign.addmoney.view.NearByAddMoneyActivity;

public final class b extends RecyclerView.a<RecyclerView.v> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    boolean f70664a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PayTMPartnerListModal.Response> f70665b;

    /* renamed from: c  reason: collision with root package name */
    SimpleDateFormat f70666c = new SimpleDateFormat("HH:mm");

    /* renamed from: d  reason: collision with root package name */
    private Context f70667d;

    /* renamed from: e  reason: collision with root package name */
    private Fragment f70668e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, View> f70669f = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: g  reason: collision with root package name */
    private SparseBooleanArray f70670g = new SparseBooleanArray();

    /* renamed from: h  reason: collision with root package name */
    private String f70671h;

    public b(Fragment fragment, ArrayList<PayTMPartnerListModal.Response> arrayList, Context context, boolean z) {
        this.f70668e = fragment;
        this.f70665b = arrayList;
        this.f70667d = context;
        this.f70664a = z;
        a();
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new C1426b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_divider_addmoney, viewGroup, false));
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_nearby_row_addmoney, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar.getItemViewType() == 1) {
            PayTMPartnerListModal.Response response = this.f70665b.get(i2);
            a aVar = (a) vVar;
            if (response != null) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f70667d);
                a2.f43753a = response.cashPointsDetail.logoUrl;
                b.a.C0750a.a(a2.a((Object) androidx.core.content.b.a(this.f70667d, R.drawable.nearby_addmoney)).a(8, b.a.TOP).a(com.paytm.utility.b.b.a.DATA_DISK_CACHE), aVar.f70673a, (com.paytm.utility.b.b.b) null, 2);
                aVar.f70674b.setText(response.cashPointsDetail.displayName);
                String str = response.cashPointsDetail.endTime;
                String str2 = response.cashPointsDetail.startTime;
                String str3 = response.cashPointsDetail.saturdayEndTime;
                String str4 = response.cashPointsDetail.saturdayStartTime;
                String str5 = response.cashPointsDetail.rating;
                if (str5 != null && !TextUtils.isEmpty(str5)) {
                    try {
                        aVar.l.setRating(Float.parseFloat(str5));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (str2 == null || str == null) {
                    aVar.j.setVisibility(8);
                } else if (!a(str2, str, str4, str3)) {
                    SpannableString spannableString = new SpannableString("Open until " + a(str));
                    spannableString.setSpan(new ForegroundColorSpan(this.f70667d.getResources().getColor(R.color.color_21c17a)), 0, 4, 33);
                    aVar.f70679g.setText(spannableString);
                    aVar.j.setVisibility(0);
                } else {
                    aVar.f70679g.setTextColor(this.f70667d.getResources().getColor(R.color.light_red));
                    aVar.j.setVisibility(0);
                    aVar.f70679g.setText("Closed");
                }
                if (TextUtils.isEmpty(response.cashPointsDetail.category)) {
                    aVar.f70675c.setVisibility(8);
                } else {
                    aVar.f70675c.setVisibility(0);
                    aVar.f70675c.setText(response.cashPointsDetail.category);
                }
                if (!TextUtils.isEmpty(response.offerText)) {
                    aVar.f70678f.setVisibility(0);
                    aVar.f70678f.setText(response.offerText);
                } else {
                    aVar.f70678f.setVisibility(8);
                }
                aVar.f70676d.setText(a(response.cashPointsDetail.address));
                ArrayList<String> arrayList = response.cashPointsDetail.servicesOffered;
                if (arrayList != null || arrayList.size() > 0) {
                    boolean z = true;
                    boolean z2 = true;
                    boolean z3 = true;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        String str6 = arrayList.get(i3);
                        if (str6.equals("KYC_POINT")) {
                            z3 = false;
                        } else if (str6.equals("CASH_POINT")) {
                            z2 = false;
                        } else if (str6.equals("PAYMENT_POINT")) {
                            z = false;
                        }
                    }
                    if (!z && !z2 && !z3) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) TypedValue.applyDimension(1, 25.0f, this.f70667d.getResources().getDisplayMetrics()));
                        layoutParams.addRule(3, R.id.tv_pay_with_paytm);
                        layoutParams.setMargins(0, 10, 0, 0);
                    }
                }
                if (response.cashPointsDetail.contactNo == null || response.cashPointsDetail.contactNo.size() <= 0 || !b()) {
                    aVar.f70680h.setVisibility(8);
                } else {
                    aVar.f70680h.setVisibility(0);
                }
                aVar.f70680h.setOnClickListener(this);
                aVar.f70681i.setOnClickListener(this);
                aVar.f70678f.setOnClickListener(this);
                aVar.k.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
                aVar.f70680h.setTag(Integer.valueOf(i2));
                aVar.f70681i.setTag(Integer.valueOf(i2));
                aVar.f70678f.setTag(Integer.valueOf(i2));
            }
        }
    }

    private String a(String str) {
        try {
            return new SimpleDateFormat("h:mm a").format(this.f70666c.parse(str));
        } catch (ParseException e2) {
            e2.printStackTrace();
            q.d(e2.getMessage());
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private boolean a(String str, String str2, String str3, String str4) {
        try {
            Calendar instance = Calendar.getInstance();
            Date parse = this.f70666c.parse(str);
            Date parse2 = this.f70666c.parse(str2);
            if (!(instance.get(7) != 7 || str3 == null || str4 == null)) {
                parse = this.f70666c.parse(str4);
                parse2 = this.f70666c.parse(str3);
            }
            Date date = new Date();
            if (!date.after(parse2) || !date.before(parse)) {
                return true;
            }
            return false;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return true;
        }
    }

    private static String a(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!TextUtils.isEmpty(arrayList.get(i2))) {
                    sb.append(arrayList.get(i2));
                }
                if (i2 < size - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public final int getItemCount() {
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f70665b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int getItemViewType(int i2) {
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.f70665b;
        return (arrayList == null || arrayList.get(i2) != null) ? 1 : 0;
    }

    public final void onClick(View view) {
        Object tag;
        PayTMPartnerListModal.Response response;
        int id = view.getId();
        if (id == R.id.ll_direction_distance) {
            Object tag2 = view.getTag();
            if (tag2 != null && (tag2 instanceof Integer)) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("new_wallet_screen_type", "nearby");
                    hashMap.put("new_wallet_nearby_tab_name", this.f70671h);
                    net.one97.paytm.helper.a.b().a("new_wallet_nearby_distance_icon_clicked", (Map<String, Object>) hashMap, this.f70667d);
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
                int intValue = ((Integer) tag2).intValue();
                if (this.f70665b.get(intValue).cashPointsDetail.location != null && this.f70665b.get(intValue).cashPointsDetail.location.lat != null && this.f70665b.get(intValue).cashPointsDetail.location.lon != null) {
                    net.one97.paytm.wallet.newdesign.addmoney.nearby.b.a();
                    net.one97.paytm.wallet.newdesign.addmoney.nearby.b.a(this.f70665b.get(intValue).cashPointsDetail.location.lat, this.f70665b.get(intValue).cashPointsDetail.location.lon, this.f70667d);
                }
            }
        } else if (id == R.id.ll_nearby_call) {
            Object tag3 = view.getTag();
            if (!b()) {
                Fragment fragment = this.f70668e;
                if (fragment != null && fragment.getActivity() != null && !this.f70668e.getActivity().isFinishing() && (this.f70668e.getActivity() instanceof NearByAddMoneyActivity)) {
                    NearByAddMoneyActivity nearByAddMoneyActivity = (NearByAddMoneyActivity) this.f70668e.getActivity();
                    if (!nearByAddMoneyActivity.f70690b) {
                        nearByAddMoneyActivity.findViewById(R.id.error_service_not_available_tv).setVisibility(0);
                        nearByAddMoneyActivity.f70690b = true;
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                if (!NearByAddMoneyActivity.this.isFinishing()) {
                                    NearByAddMoneyActivity.this.findViewById(R.id.error_service_not_available_tv).setVisibility(8);
                                }
                                boolean unused = NearByAddMoneyActivity.this.f70690b = false;
                            }
                        }, 2500);
                    }
                }
            } else if (tag3 != null && (tag3 instanceof Integer)) {
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("new_wallet_screen_type", "nearby");
                    hashMap2.put("new_wallet_nearby_tab_name", this.f70671h);
                    net.one97.paytm.helper.a.b().a("new_wallet_nearby_call_clicked", (Map<String, Object>) hashMap2, this.f70667d);
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        e3.printStackTrace();
                    }
                }
                PayTMPartnerListModal.Response response2 = this.f70665b.get(((Integer) tag3).intValue());
                if (response2.cashPointsDetail.contactNo != null && response2.cashPointsDetail.contactNo.size() > 0) {
                    this.f70667d.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(response2.cashPointsDetail.contactNo.get(0))))));
                }
            }
        } else if (id == R.id.tv_deal_offer && (tag = view.getTag()) != null && (tag instanceof Integer) && (response = this.f70665b.get(((Integer) tag).intValue())) != null && (response instanceof PayTMPartnerListModal.Response)) {
            CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
            cJRHomePageItem.setUrl(response.dealUrl);
            cJRHomePageItem.setName(response.offerText);
            String uRLType = response.getURLType();
            if (response != null) {
                String str = response.dealUrl;
                if (!TextUtils.isEmpty(str) && str.startsWith("paytmmp://")) {
                    b(uRLType);
                } else if (Patterns.WEB_URL.matcher(str).matches() && uRLType != null && !TextUtils.isEmpty(uRLType) && str != null && URLUtil.isValidUrl(str)) {
                    if (uRLType.equalsIgnoreCase(CLPConstants.URL_TYPE_EMBED)) {
                        b(uRLType);
                    } else if ((uRLType.equalsIgnoreCase(CLPConstants.DEFAULT_GRID_VIEW_TYPE) || uRLType.equalsIgnoreCase("product")) && str != null && URLUtil.isValidUrl(str)) {
                        b(uRLType);
                    }
                }
            }
        }
    }

    private static boolean b() {
        int i2 = Calendar.getInstance().get(11);
        return i2 >= 11 && i2 <= 20;
    }

    public final void a() {
        this.f70670g.clear();
        for (int i2 = 0; i2 < this.f70665b.size(); i2++) {
            this.f70670g.append(i2, false);
        }
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f70673a;

        /* renamed from: b  reason: collision with root package name */
        TextView f70674b;

        /* renamed from: c  reason: collision with root package name */
        TextView f70675c;

        /* renamed from: d  reason: collision with root package name */
        TextView f70676d;

        /* renamed from: e  reason: collision with root package name */
        TextView f70677e;

        /* renamed from: f  reason: collision with root package name */
        TextView f70678f;

        /* renamed from: g  reason: collision with root package name */
        TextView f70679g;

        /* renamed from: h  reason: collision with root package name */
        LinearLayout f70680h;

        /* renamed from: i  reason: collision with root package name */
        LinearLayout f70681i;
        LinearLayout j;
        RelativeLayout k;
        RatingBar l;

        public a(View view) {
            super(view);
            this.f70673a = (ImageView) view.findViewById(R.id.iv_nearby_icon);
            this.f70674b = (TextView) view.findViewById(R.id.tv_nearby_row_brand_name);
            this.l = (RatingBar) view.findViewById(R.id.store_rating);
            this.f70679g = (TextView) view.findViewById(R.id.tv_time);
            this.f70675c = (TextView) view.findViewById(R.id.tv_nearby_row_brandcategory_type);
            this.f70676d = (TextView) view.findViewById(R.id.tv_nearby_row_brand_address);
            this.f70678f = (TextView) view.findViewById(R.id.tv_deal_offer);
            this.f70677e = (TextView) view.findViewById(R.id.tv_nearby_distance);
            this.f70680h = (LinearLayout) view.findViewById(R.id.ll_nearby_call);
            this.k = (RelativeLayout) view.findViewById(R.id.rl_nearby_item);
            this.j = (LinearLayout) view.findViewById(R.id.ll_nearby_time);
            this.f70681i = (LinearLayout) view.findViewById(R.id.ll_direction_distance);
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.addmoney.a.b$b  reason: collision with other inner class name */
    public class C1426b extends RecyclerView.v {
        public C1426b(View view) {
            super(view);
        }
    }

    private void b(String str) {
        Fragment fragment = this.f70668e;
        if (fragment == null || fragment.isDetached() || TextUtils.isEmpty(str) || str.equalsIgnoreCase("nolink")) {
        }
    }
}
