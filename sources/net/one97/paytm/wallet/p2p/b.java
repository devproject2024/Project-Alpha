package net.one97.paytm.wallet.p2p;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.contacts.entities.beans.P2MRecentScan;
import net.one97.paytm.contacts.entities.beans.P2PRecentSendMoney;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.d.k;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static ArrayList<IJRDataModel> a(Context context) {
        ArrayList<IJRDataModel> arrayList = new ArrayList<>();
        j.a();
        ArrayList<IJRDataModel> b2 = j.b(context);
        if (b2 != null && !b2.isEmpty()) {
            arrayList.addAll(b2);
        }
        k.a();
        ArrayList<IJRDataModel> a2 = k.a(context);
        if (a2 != null && !a2.isEmpty()) {
            arrayList.addAll(a2);
        }
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    public static ArrayList<IJRDataModel> b(Context context) {
        String str;
        ArrayList<IJRDataModel> arrayList = new ArrayList<>();
        j.a();
        ArrayList<IJRDataModel> b2 = j.b(context);
        if (b2 != null && !b2.isEmpty()) {
            Iterator<IJRDataModel> it2 = b2.iterator();
            while (it2.hasNext()) {
                IJRDataModel next = it2.next();
                if (next instanceof RecentScan) {
                    P2MRecentScan p2MRecentScan = new P2MRecentScan();
                    CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                    try {
                        cJRQRScanResultModel.parseData(new JSONObject(((RecentScan) next).getScanResult()), context);
                    } catch (JSONException unused) {
                        String scanResult = ((RecentScan) next).getScanResult();
                        if (scanResult != null) {
                            str = net.one97.paytm.wallet.utility.a.z(scanResult);
                        }
                    }
                    str = "";
                    String mobileNo = cJRQRScanResultModel.getMobileNo();
                    if (TextUtils.isEmpty(str)) {
                        if ("QR_CODE_REQUEST_MONEY".equals(cJRQRScanResultModel.getRequestType())) {
                            str = cJRQRScanResultModel.getName();
                        } else {
                            str = cJRQRScanResultModel.getMerchantName();
                        }
                    }
                    String logoURL = cJRQRScanResultModel.getLogoURL();
                    p2MRecentScan.setName(str);
                    p2MRecentScan.setNickName(str);
                    p2MRecentScan.setPhoneNumber(mobileNo);
                    p2MRecentScan.setRecentScan((RecentScan) next);
                    p2MRecentScan.setImageUrl(logoURL);
                    arrayList.add(p2MRecentScan);
                }
            }
        }
        k.a();
        ArrayList<IJRDataModel> a2 = k.a(context);
        if (a2 != null && !a2.isEmpty()) {
            Iterator<IJRDataModel> it3 = a2.iterator();
            while (it3.hasNext()) {
                IJRDataModel next2 = it3.next();
                if (next2 instanceof RecentSendMoney) {
                    P2PRecentSendMoney p2PRecentSendMoney = new P2PRecentSendMoney();
                    RecentSendMoney recentSendMoney = (RecentSendMoney) next2;
                    p2PRecentSendMoney.setNickName(recentSendMoney.getName());
                    p2PRecentSendMoney.setRecentSendMoney(recentSendMoney);
                    arrayList.add(p2PRecentSendMoney);
                }
            }
        }
        Collections.sort(arrayList, new a());
        return arrayList;
    }

    static class a implements Comparator<IJRDataModel> {
        a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            IJRDataModel iJRDataModel2 = (IJRDataModel) obj2;
            boolean z = iJRDataModel instanceof RecentScan;
            if (!z || !(iJRDataModel2 instanceof RecentScan)) {
                boolean z2 = iJRDataModel instanceof RecentSendMoney;
                if (z2 && (iJRDataModel2 instanceof RecentSendMoney)) {
                    return Long.compare(Long.valueOf(((RecentSendMoney) iJRDataModel2).getTimestamp()).longValue(), Long.valueOf(((RecentSendMoney) iJRDataModel).getTimestamp()).longValue());
                } else if (z && (iJRDataModel2 instanceof RecentSendMoney)) {
                    return Long.compare(Long.valueOf(((RecentSendMoney) iJRDataModel2).getTimestamp()).longValue(), Long.valueOf(((RecentScan) iJRDataModel).getTimestamp()).longValue());
                } else if (!z2 || !(iJRDataModel2 instanceof RecentScan)) {
                    return 0;
                } else {
                    return Long.compare(Long.valueOf(((RecentScan) iJRDataModel2).getTimestamp()).longValue(), Long.valueOf(((RecentSendMoney) iJRDataModel).getTimestamp()).longValue());
                }
            } else {
                return Long.compare(Long.valueOf(((RecentScan) iJRDataModel2).getTimestamp()).longValue(), Long.valueOf(((RecentScan) iJRDataModel).getTimestamp()).longValue());
            }
        }
    }
}
