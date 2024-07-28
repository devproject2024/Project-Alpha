package net.one97.paytm.wallet.newdesign.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.newdesign.models.GetRecentPaymentsAPIBaseResponse;
import net.one97.paytm.wallet.newdesign.models.GetRecentPaymentsResponse;
import net.one97.paytm.wallet.newdesign.models.UpdateRecentPaymentsAPIResponse;
import net.one97.paytm.wallet.newdesign.models.UpdateRecentPaymentsModel;
import net.one97.paytm.wallet.p2p.b;
import org.json.JSONArray;

public class RecentDataNetworkManager {
    public static void uploadRecentPaymentsData(Context context) {
        Class<RecentDataNetworkManager> cls = RecentDataNetworkManager.class;
        ArrayList<IJRDataModel> a2 = b.a(context);
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", a.q(context));
        hashMap.put("content-type", "application/json");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", "RecentDataNetworkManager");
        ArrayList arrayList = new ArrayList();
        Iterator<IJRDataModel> it2 = a2.iterator();
        while (it2.hasNext()) {
            IJRDataModel next = it2.next();
            if (next instanceof RecentSendMoney) {
                UpdateRecentPaymentsModel updateRecentPaymentsModel = new UpdateRecentPaymentsModel();
                RecentSendMoney recentSendMoney = (RecentSendMoney) next;
                updateRecentPaymentsModel.setName(recentSendMoney.getName());
                updateRecentPaymentsModel.setPhoneNumber(recentSendMoney.getPhoneNumber());
                updateRecentPaymentsModel.setImageUrl(recentSendMoney.getImageurl());
                updateRecentPaymentsModel.setTimestamp(recentSendMoney.getTimestamp());
                updateRecentPaymentsModel.setAmount(recentSendMoney.getAmount());
                updateRecentPaymentsModel.setMerchantId((String) null);
                updateRecentPaymentsModel.setType("P2P");
                updateRecentPaymentsModel.setScanResult((String) null);
                if (String.valueOf(recentSendMoney.getTimestamp()).contains(AppUtility.CENTER_DOT)) {
                    c a3 = net.one97.paytm.wallet.communicator.b.a();
                    String name = cls.getName();
                    a3.pushCrashEventToCrashlytics(name, "upload timestamp p2p value: " + recentSendMoney.getTimestamp() + " phone number: " + recentSendMoney.getPhoneNumber(), (Throwable) null);
                }
                arrayList.add(updateRecentPaymentsModel);
            } else if (next instanceof RecentScan) {
                UpdateRecentPaymentsModel updateRecentPaymentsModel2 = new UpdateRecentPaymentsModel();
                RecentScan recentScan = (RecentScan) next;
                updateRecentPaymentsModel2.setTimestamp(recentScan.getTimestamp());
                updateRecentPaymentsModel2.setType("P2M");
                updateRecentPaymentsModel2.setMerchantId(recentScan.getUniqKey());
                updateRecentPaymentsModel2.setScanResult(recentScan.getScanResult());
                if (String.valueOf(recentScan.getTimestamp()).contains(AppUtility.CENTER_DOT)) {
                    c a4 = net.one97.paytm.wallet.communicator.b.a();
                    String name2 = cls.getName();
                    a4.pushCrashEventToCrashlytics(name2, "upload timestamp p2m value: " + recentScan.getTimestamp() + " qr id: " + recentScan.getUniqKey(), (Throwable) null);
                }
                arrayList.add(updateRecentPaymentsModel2);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(((UpdateRecentPaymentsModel) arrayList.get(i2)).getJSONObject());
        }
        new net.one97.paytm.network.b("https://trust.paytm.in/wallet-web/v1/updateRecentPayments", new UpdateRecentPaymentsAPIResponse(), hashMap2, hashMap, jSONArray.toString()).c().observeForever($$Lambda$RecentDataNetworkManager$0gbO8IxEln98AZTXNXRVJLeS2M.INSTANCE);
    }

    public static void fetchRecentPaymentsData(Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            fetchRecentPaymentsDataOnMainThread(context);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(context) {
                private final /* synthetic */ Context f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    RecentDataNetworkManager.fetchRecentPaymentsData(this.f$0);
                }
            });
        }
    }

    private static void fetchRecentPaymentsDataOnMainThread(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", a.q(context));
        hashMap.put("content-type", "application/json");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", "RecentDataNetworkManager");
        new net.one97.paytm.network.a("https://trust.paytm.in/wallet-web/v1/getRecentPayments", new GetRecentPaymentsAPIBaseResponse(), hashMap2, hashMap).c().observeForever(new z(context) {
            private final /* synthetic */ Context f$0;

            {
                this.f$0 = r1;
            }

            public final void onChanged(Object obj) {
                RecentDataNetworkManager.lambda$fetchRecentPaymentsDataOnMainThread$2(this.f$0, (f) obj);
            }
        });
    }

    public static void initializeRecentPaymentsDownload(Context context) {
        if (com.paytm.utility.b.r(context)) {
            com.paytm.b.a.a a2 = be.a(context.getApplicationContext());
            if (a2.b("should_download_recent_payments_data", true, true)) {
                a2.a("should_download_recent_payments_data", false, true);
                fetchRecentPaymentsData(context);
            }
        }
    }

    public static void clearRecentData(Context context) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList, "recents_data");
        DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList2, "recents_sendmoney_data");
    }

    static /* synthetic */ void lambda$fetchRecentPaymentsDataOnMainThread$2(Context context, f fVar) {
        GetRecentPaymentsAPIBaseResponse getRecentPaymentsAPIBaseResponse;
        Class<RecentDataNetworkManager> cls = RecentDataNetworkManager.class;
        if (fVar.f55796a == h.SUCCESS && (fVar.f55797b instanceof GetRecentPaymentsAPIBaseResponse) && (getRecentPaymentsAPIBaseResponse = (GetRecentPaymentsAPIBaseResponse) fVar.f55797b) != null && getRecentPaymentsAPIBaseResponse.getStatus() != null && getRecentPaymentsAPIBaseResponse.getStatusCode() != null) {
            if (!"SUCCESS".equalsIgnoreCase(getRecentPaymentsAPIBaseResponse.getStatus()) || !"SS_0001".equalsIgnoreCase(getRecentPaymentsAPIBaseResponse.getStatusCode())) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList, "recents_data");
                DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList2, "recents_sendmoney_data");
                return;
            }
            ArrayList<GetRecentPaymentsResponse> response = getRecentPaymentsAPIBaseResponse.getResponse();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<GetRecentPaymentsResponse> it2 = response.iterator();
            while (it2.hasNext()) {
                GetRecentPaymentsResponse next = it2.next();
                if (!TextUtils.isEmpty(next.getTimestamp())) {
                    if (next.getScanResult() == null || TextUtils.isEmpty(next.getScanResult())) {
                        RecentSendMoney recentSendMoney = new RecentSendMoney();
                        try {
                            recentSendMoney.setAmount(next.getAmount());
                            recentSendMoney.setImageurl(next.getImageUrl());
                            recentSendMoney.setMerchantId(next.getMerchantId());
                            recentSendMoney.setName(next.getName());
                            recentSendMoney.setPhoneNumber(next.getPhoneNumber());
                            recentSendMoney.setTimestamp(Long.parseLong(next.getTimestamp()));
                        } catch (NumberFormatException e2) {
                            recentSendMoney.setTimestamp((long) Double.parseDouble(next.getTimestamp()));
                            c a2 = net.one97.paytm.wallet.communicator.b.a();
                            String name = cls.getName();
                            a2.pushCrashEventToCrashlytics(name, "fetch timestamp p2p value: " + next.getTimestamp() + " phone number: " + next.getPhoneNumber(), e2);
                        } catch (Exception unused) {
                        }
                        arrayList4.add(recentSendMoney);
                    } else {
                        RecentScan recentScan = new RecentScan();
                        try {
                            recentScan.setScanResult(next.getScanResult());
                            if (next.getMerchantId() != null) {
                                recentScan.setUniqKey(next.getMerchantId());
                            } else {
                                recentScan.setUniqKey(next.getType());
                            }
                            recentScan.setTimestamp(Long.parseLong(next.getTimestamp()));
                        } catch (NumberFormatException e3) {
                            recentScan.setTimestamp((long) Double.parseDouble(next.getTimestamp()));
                            c a3 = net.one97.paytm.wallet.communicator.b.a();
                            String name2 = cls.getName();
                            a3.pushCrashEventToCrashlytics(name2, "fetch timestamp p2m value: " + next.getTimestamp() + " qr id: " + next.getType(), e3);
                        } catch (Exception unused2) {
                        }
                        arrayList3.add(recentScan);
                    }
                }
            }
            DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList3, "recents_data");
            DelegateUtil.INSTANCE.writeObjectToFile(context, arrayList4, "recents_sendmoney_data");
        }
    }

    static /* synthetic */ void lambda$uploadRecentPaymentsData$0(f fVar) {
        if (fVar.f55796a != h.SUCCESS) {
            h hVar = h.ERROR;
        }
    }
}
