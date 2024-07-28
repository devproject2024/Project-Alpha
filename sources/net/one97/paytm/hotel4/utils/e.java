package net.one97.paytm.hotel4.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.PaytmImages;
import net.one97.paytm.hotel4.service.model.details.TaxData;
import net.one97.paytm.hotel4.viewmodel.DataViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f28642a = new e();

    private e() {
    }

    public static String a(String str, String str2, Integer num) {
        k.c(str, "str");
        k.c(str2, "suff");
        if (num == null || num.intValue() <= 0) {
            return "";
        }
        if (num.intValue() == 1) {
            return str + str2;
        }
        return str + "s" + str2;
    }

    public static TaxData a(JSONObject jSONObject) {
        String str;
        k.c(jSONObject, "json");
        Iterator<String> keys = jSONObject.keys();
        TaxData taxData = null;
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                str = jSONObject.get(next).toString();
            } catch (JSONException unused) {
                str = "";
            }
            taxData = new TaxData(next, str);
        }
        if (taxData == null) {
            k.a();
        }
        return taxData;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> a(java.lang.String r17, java.lang.String r18, java.lang.String r19, net.one97.paytm.hotel4.service.model.details.PaytmImages r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            java.lang.String r7 = "cityName"
            kotlin.g.b.k.c(r0, r7)
            java.lang.String r8 = "hotelId"
            kotlin.g.b.k.c(r1, r8)
            java.lang.String r9 = "hotelName"
            kotlin.g.b.k.c(r2, r9)
            java.lang.String r10 = "deeplinkCity"
            kotlin.g.b.k.c(r3, r10)
            java.lang.String r10 = "numRooms"
            kotlin.g.b.k.c(r4, r10)
            java.lang.String r11 = "numAdults"
            kotlin.g.b.k.c(r5, r11)
            java.lang.String r12 = "numKids"
            kotlin.g.b.k.c(r6, r12)
            java.lang.String r13 = "roomsDetails"
            r14 = r27
            kotlin.g.b.k.c(r14, r13)
            r13 = 0
            if (r20 == 0) goto L_0x0064
            java.util.List r14 = r20.getFull()
            if (r14 == 0) goto L_0x0064
            java.util.List r14 = r20.getFull()
            if (r14 != 0) goto L_0x004a
            kotlin.g.b.k.a()
        L_0x004a:
            java.util.Collection r14 = (java.util.Collection) r14
            boolean r14 = r14.isEmpty()
            r14 = r14 ^ 1
            if (r14 == 0) goto L_0x0064
            java.util.List r14 = r20.getFull()
            if (r14 != 0) goto L_0x005d
            kotlin.g.b.k.a()
        L_0x005d:
            java.lang.Object r14 = r14.get(r13)
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x0066
        L_0x0064:
            java.lang.String r14 = "https://d274ft55l0imju.cloudfront.net/hotels_app_img/share_default_img.png"
        L_0x0066:
            r15 = r2
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r20 = r14
            r14 = 40
            boolean r16 = kotlin.m.p.a((java.lang.CharSequence) r15, (char) r14, (boolean) r13)
            r14 = 41
            if (r16 != 0) goto L_0x007e
            boolean r16 = kotlin.m.p.a((java.lang.CharSequence) r15, (char) r14, (boolean) r13)
            if (r16 == 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r0 = r2
            goto L_0x00bf
        L_0x007e:
            java.lang.String r14 = "$this$replaceAfter"
            kotlin.g.b.k.d(r2, r14)
            java.lang.String r14 = ""
            java.lang.String r13 = "replacement"
            kotlin.g.b.k.d(r14, r13)
            java.lang.String r13 = "missingDelimiterValue"
            kotlin.g.b.k.d(r14, r13)
            r13 = 6
            r0 = 40
            r2 = 0
            int r2 = kotlin.m.p.a((java.lang.CharSequence) r15, (char) r0, (int) r2, (boolean) r2, (int) r13)
            r13 = -1
            if (r2 != r13) goto L_0x009b
            goto L_0x00ab
        L_0x009b:
            int r2 = r2 + 1
            int r13 = r19.length()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.CharSequence r2 = kotlin.m.p.a((java.lang.CharSequence) r15, (int) r2, (int) r13, (java.lang.CharSequence) r14)
            java.lang.String r14 = r2.toString()
        L_0x00ab:
            r2 = 32
            java.lang.String r0 = kotlin.m.p.a((java.lang.String) r14, (char) r0, (char) r2)
            r13 = 41
            java.lang.String r0 = kotlin.m.p.a((java.lang.String) r0, (char) r13, (char) r2)
            if (r0 == 0) goto L_0x01b7
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            kotlin.m.p.b(r2)
        L_0x00bf:
            java.lang.String r2 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r2)
            java.lang.String r2 = java.net.URLEncoder.encode(r3, r2)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            r13.put(r11, r5)
            r13.put(r12, r6)
            r13.put(r8, r1)
            java.lang.String r8 = java.lang.String.valueOf(r22)
            java.lang.String r11 = "check_in_date"
            r13.put(r11, r8)
            java.lang.String r8 = java.lang.String.valueOf(r21)
            java.lang.String r11 = "check_out_date"
            r13.put(r11, r8)
            r13.put(r10, r4)
            r13.put(r7, r3)
            java.lang.String r3 = "utm_medium"
            java.lang.String r7 = "app_share"
            r13.put(r3, r7)
            java.lang.String r3 = "utm_source"
            java.lang.String r7 = "androidapp"
            r13.put(r3, r7)
            java.lang.String r3 = "utm_campaign"
            java.lang.String r7 = "app_details_share"
            r13.put(r3, r7)
            r3 = r19
            r13.put(r9, r3)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "paytmmp://hotel-details?numAdults="
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r5 = "&numKids="
            r7.append(r5)
            r7.append(r6)
            java.lang.String r5 = "&hotelId="
            r7.append(r5)
            r7.append(r1)
            java.lang.String r5 = "&check_in_date="
            r7.append(r5)
            r5 = r22
            r7.append(r5)
            java.lang.String r5 = "&check_out_date="
            r7.append(r5)
            r5 = r21
            r7.append(r5)
            java.lang.String r5 = "&numRooms="
            r7.append(r5)
            r7.append(r4)
            java.lang.String r4 = "&cityName="
            r7.append(r4)
            r7.append(r2)
            java.lang.String r2 = "&hotelName="
            r7.append(r2)
            r7.append(r0)
            java.lang.String r0 = "&utm_source=androidapp&utm_medium=app_share&utm_campaign=app_details_share"
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            r2 = r17
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x017b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r5 = ", "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            goto L_0x017c
        L_0x017b:
            r2 = r3
        L_0x017c:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r5 = "af_scheme"
            java.lang.String r6 = "paytmmp://hotel-details"
            r4.put(r5, r6)
            java.lang.String r5 = "af_dp"
            r4.put(r5, r0)
            java.lang.String r0 = "title"
            r4.put(r0, r3)
            java.lang.String r0 = "pid"
            r4.put(r0, r1)
            java.lang.String r0 = "c"
            java.lang.String r1 = "PDP_Share"
            r4.put(r0, r1)
            java.lang.String r0 = "af_web_dp"
            r14 = r20
            r4.put(r0, r14)
            java.lang.String r0 = r13.toString()
            java.lang.String r1 = "af_scheme_parameter"
            r4.put(r1, r0)
            java.lang.String r0 = "address"
            r4.put(r0, r2)
            java.util.Map r4 = (java.util.Map) r4
            return r4
        L_0x01b7:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.utils.e.a(java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.hotel4.service.model.details.PaytmImages, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.Map");
    }

    public static String a(String str, String str2, String str3, PaytmImages paytmImages) {
        String str4;
        k.c(str, "cityName");
        k.c(str2, "orderId");
        k.c(str3, "hotelName");
        if (!(paytmImages == null || paytmImages.getFull() == null)) {
            List<String> full = paytmImages.getFull();
            if (full == null) {
                k.a();
            }
            if (!full.isEmpty()) {
                List<String> full2 = paytmImages.getFull();
                if (full2 == null) {
                    k.a();
                }
                str4 = full2.get(0);
                Uri.Builder buildUpon = Uri.parse("paytmmp://branchShare").buildUpon();
                buildUpon.appendQueryParameter("title", str);
                buildUpon.appendQueryParameter(RequestConfirmationDialogFragment.KEY_DESCRIPTION, "Hey! I found this exciting hotel on Paytm. Check it out. ".concat(String.valueOf(str3)));
                buildUpon.appendQueryParameter("imgUrl", str4);
                buildUpon.appendQueryParameter("b_key", "hotel_order_summary?orderid=".concat(String.valueOf(str2)));
                String uri = buildUpon.build().toString();
                k.a((Object) uri, "builder.build().toString()");
                return uri;
            }
        }
        str4 = "https://d274ft55l0imju.cloudfront.net/hotels_app_img/share_default_img.png";
        Uri.Builder buildUpon2 = Uri.parse("paytmmp://branchShare").buildUpon();
        buildUpon2.appendQueryParameter("title", str);
        buildUpon2.appendQueryParameter(RequestConfirmationDialogFragment.KEY_DESCRIPTION, "Hey! I found this exciting hotel on Paytm. Check it out. ".concat(String.valueOf(str3)));
        buildUpon2.appendQueryParameter("imgUrl", str4);
        buildUpon2.appendQueryParameter("b_key", "hotel_order_summary?orderid=".concat(String.valueOf(str2)));
        String uri2 = buildUpon2.build().toString();
        k.a((Object) uri2, "builder.build().toString()");
        return uri2;
    }

    public static void a(FragmentActivity fragmentActivity, List<String> list, String str, SharedViewModel sharedViewModel) {
        k.c(sharedViewModel, "sharedViewModel");
        if (fragmentActivity != null) {
            ai a2 = am.a(fragmentActivity).a(DataViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(ac…ataViewModel::class.java)");
            DataViewModel dataViewModel = (DataViewModel) a2;
            dataViewModel.getRecyclerListData().setValue(list);
            if (TextUtils.isEmpty(str)) {
                str = "";
            } else if (str == null) {
                k.a();
            }
            dataViewModel.setTitle(str);
            sharedViewModel.postScreenNavigationEvent("5", SDKConstants.UPI_DOWN_ERROR);
        }
    }

    public static void a(FragmentActivity fragmentActivity, List<String> list, String str, boolean z, boolean z2, SharedViewModel sharedViewModel) {
        k.c(sharedViewModel, "sharedViewModel");
        if (fragmentActivity != null) {
            ai a2 = am.a(fragmentActivity).a(DataViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(ac…ataViewModel::class.java)");
            DataViewModel dataViewModel = (DataViewModel) a2;
            dataViewModel.setShowClose(true);
            if (TextUtils.isEmpty(str)) {
                str = "";
            } else if (str == null) {
                k.a();
            }
            dataViewModel.setTitle(str);
            dataViewModel.setShouldHideBlueDot(z);
            dataViewModel.setShowRecyclerViewList(true);
            dataViewModel.setHtmlText(z2);
            dataViewModel.getRecyclerListData().setValue(list);
            sharedViewModel.postScreenNavigationEvent("5", "1113");
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            if (str.length() > 0) {
                return true;
            }
        }
        return false;
    }
}
