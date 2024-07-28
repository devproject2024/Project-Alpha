package net.one97.paytm.wallet.splitbill.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.z;
import com.google.gson.g;
import com.paytm.utility.a;
import com.paytm.utility.q;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementBaseResponse;

public class b {
    public static String a(String str) {
        if (TextUtils.isDigitsOnly(str) || TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.trim().split("\\s+");
        if (split.length <= 0 || TextUtils.isEmpty(split[0])) {
            return "";
        }
        return String.valueOf(split[0].charAt(0));
    }

    public static String b(String str) {
        if (((str.hashCode() == 2110829388 && str.equals("GRP001")) ? (char) 0 : 65535) != 0) {
            return null;
        }
        return "Group Already Exist";
    }

    public static String c(String str) {
        return new SimpleDateFormat("hh:mm a,dd MMM yyyy").format(new Date(Long.parseLong(str)));
    }

    public static void a(Activity activity, SBMarkAsPaid sBMarkAsPaid) {
        if (activity != null && !activity.isFinishing()) {
            String stringFromGTM = !TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(activity, "getMarkAsPaidURL")) ? net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(activity, "getMarkAsPaidURL") : "https://prms.paytmbank.com/prms/ext/v1/user/payment";
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", b.class.getSimpleName());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("user-token", a.q(activity));
            hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
            hashMap2.put("content-type", "application/json");
            hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
            g gVar = new g();
            gVar.f39467e = false;
            new net.one97.paytm.network.b(stringFromGTM, new SBUserSettlementBaseResponse(), hashMap, hashMap2, gVar.a().b(sBMarkAsPaid)).c().observeForever(new z(activity) {
                private final /* synthetic */ Activity f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    b.a(SBMarkAsPaid.this, this.f$1, (f) obj);
                }
            });
        }
    }

    public static String a(Double d2) {
        if (Math.floor(d2.doubleValue()) == Math.ceil(d2.doubleValue())) {
            return new DecimalFormat("0.#").format(d2);
        }
        return String.valueOf(d2);
    }

    public static String d(String str) {
        if (str.length() < 20) {
            return str;
        }
        String[] split = str.split(" ");
        if (split.length == 1) {
            return str;
        }
        if (split[0].length() + split[1].length() > 20) {
            return split[0];
        }
        return split[0] + " " + split[1];
    }

    public static void a(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        try {
            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEventsWithMultipleLabel(context, str, str2, arrayList, str3, str4, str5);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(SBMarkAsPaid sBMarkAsPaid, Activity activity, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("user2user");
            arrayList.add("success");
            arrayList.add(sBMarkAsPaid.getPaymentMode());
            a(activity, "split_bill", "splitbill_markPay_success", arrayList, sBMarkAsPaid.getTotalAmount(), "/splitbill/markaspaid", "split_bill");
        } else if (fVar.f55796a == h.ERROR) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("user2user");
            arrayList2.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            arrayList2.add(sBMarkAsPaid.getPaymentMode());
            a(activity, "split_bill", "splitbill_markPay_success", arrayList2, sBMarkAsPaid.getTotalAmount(), "/splitbill/markaspaid", "split_bill");
        }
    }
}
