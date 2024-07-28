package net.one97.paytm.trustlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.impl.j;
import androidx.work.m;
import androidx.work.n;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.google.gson.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.entity.trustlist.EventInfo;
import net.one97.paytm.common.entity.trustlist.MessageInfo;
import net.one97.paytm.common.entity.trustlist.MsgDetail;
import net.one97.paytm.common.entity.trustlist.Request;
import net.one97.paytm.common.entity.trustlist.TrustListRequest;
import net.one97.paytm.common.entity.trustlist.TrustManagerOtpModel;
import net.one97.paytm.common.entity.trustlist.TxnInfo;
import net.one97.paytm.upgradeKyc.utils.g;
import net.one97.paytm.utils.t;
import org.json.JSONObject;

public class TrustListService extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static long f65170a = 120000;

    /* renamed from: b  reason: collision with root package name */
    private String f65171b;

    public TrustListService(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public static void a(Context context) {
        c.a aVar = new c.a();
        aVar.f5083c = m.CONNECTED;
        aVar.f5084d = true;
        j.b(context).a(((n.a) ((n.a) ((n.a) new n.a(TrustListService.class).a(2, TimeUnit.MINUTES)).a(aVar.b())).a("Trustlist_JOB")).c());
    }

    private ListenableWorker.a a() {
        this.f65171b = String.valueOf(System.currentTimeMillis());
        q.a(" handleMessages1 currentTime " + this.f65171b);
        TrustManagerOtpModel b2 = d.b();
        if (b2 == null) {
            return new ListenableWorker.a.c();
        }
        if (b2.getRetryCount() <= 2) {
            return a(b2);
        }
        d.a(b2.getAmount());
        return new ListenableWorker.a.c();
    }

    private ListenableWorker.a a(TrustManagerOtpModel trustManagerOtpModel) {
        MessageInfo otpMsg = trustManagerOtpModel.getOtpMsg();
        String time = trustManagerOtpModel.getTime();
        String transactionId = trustManagerOtpModel.getTransactionId();
        TrustListRequest trustListRequest = new TrustListRequest();
        TxnInfo txnInfo = new TxnInfo();
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            return new ListenableWorker.a.b();
        }
        txnInfo.setUserId(a.a(applicationContext));
        applicationContext.getSystemService(ContactColumn.PHONE_NUMBER);
        txnInfo.setDeviceId(a.e(applicationContext));
        txnInfo.setTxnId(transactionId);
        txnInfo.setTxnDatetime(time);
        txnInfo.setEventAmount(trustManagerOtpModel.getAmount());
        txnInfo.setEventAmountCurrency("INR");
        txnInfo.setOtpValue(trustManagerOtpModel.getManaulOtp());
        EventInfo eventInfo = new EventInfo();
        eventInfo.setTokenId(t.b(applicationContext));
        eventInfo.setWebsiteLanguage(com.paytm.utility.n.a(applicationContext, com.paytm.utility.n.a()));
        eventInfo.setOsType(StringSet.Android);
        eventInfo.setAppVersion(b.Q(applicationContext));
        eventInfo.setTerminalType("APP");
        eventInfo.setOrderTerminalType("APP");
        eventInfo.setOrderOsType(StringSet.Android);
        ArrayList arrayList = new ArrayList();
        if (otpMsg != null) {
            MsgDetail msgDetail = new MsgDetail();
            msgDetail.setScenario("OTP");
            msgDetail.setSMSMask(otpMsg.getSender());
            msgDetail.setOccurTime(otpMsg.getTime());
            msgDetail.setSMSGenerationDatetime(msgDetail.getOccurTime());
            msgDetail.setSender(otpMsg.getSender());
            msgDetail.setMessage(a(otpMsg.getBody()));
            arrayList.add(msgDetail);
        }
        Iterator<MessageInfo> it2 = a.a(time, String.valueOf(System.currentTimeMillis()), trustManagerOtpModel.getAmount()).iterator();
        while (it2.hasNext()) {
            MessageInfo next = it2.next();
            MsgDetail msgDetail2 = new MsgDetail();
            msgDetail2.setScenario("DEBIT");
            msgDetail2.setOccurTime(next.getTime());
            msgDetail2.setSMSGenerationDatetime(next.getTime());
            msgDetail2.setSender(next.getSender());
            msgDetail2.setMessage(a(next.getBody()));
            msgDetail2.setSMSMask(next.getSender());
            q.a(" deductionDetail  ".concat(String.valueOf(msgDetail2)));
            arrayList.add(msgDetail2);
        }
        if (!TextUtils.isEmpty(trustManagerOtpModel.getMaskNumber())) {
            MsgDetail msgDetail3 = new MsgDetail();
            msgDetail3.setScenario("Cashier_Page_Masked_No");
            msgDetail3.setMaskedMobileNo(trustManagerOtpModel.getMaskNumber());
            arrayList.add(msgDetail3);
        }
        Request request = new Request();
        request.setTxnInfo(txnInfo);
        request.setEventInfo(eventInfo);
        request.setMessageInfo(arrayList);
        trustListRequest.setRequest(request);
        trustListRequest.setSignature(a(trustListRequest));
        String b2 = new f().b(trustListRequest);
        q.a(" trustListAPICall ".concat(String.valueOf(b2)));
        if (!a.m(applicationContext)) {
            return new ListenableWorker.a.b();
        }
        try {
            net.one97.paytm.j.c.a();
            String a2 = net.one97.paytm.j.c.a("trustlistUrl", (String) null);
            if (a2 != null) {
                if (URLUtil.isValidUrl(a2)) {
                    String e2 = b.e(applicationContext, a2);
                    RequestFuture newFuture = RequestFuture.newFuture();
                    com.paytm.network.f.b(applicationContext).add(new JsonObjectRequest(1, e2, new JSONObject(b2), newFuture, newFuture));
                    JSONObject jSONObject = (JSONObject) newFuture.get(300, TimeUnit.SECONDS);
                    q.a(" Result ".concat(String.valueOf(jSONObject)));
                    if (jSONObject.getString("resultStatus").equalsIgnoreCase(AppConstants.FEED_SUB_TYPE)) {
                        q.a(" onErrorResponse txnId " + transactionId + " otpModel.getRetryCount()+1 " + trustManagerOtpModel.getRetryCount() + 1);
                        d.a(transactionId, trustManagerOtpModel.getRetryCount() + 1);
                        a();
                    } else {
                        q.a(" onResponse txnId " + transactionId + " currentTime " + this.f65171b);
                        d.b(transactionId);
                        String str = this.f65171b;
                        q.a("DeductionMsgTable deleteMessages startTime ".concat(String.valueOf(str)));
                        SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
                        writableDatabase.delete("deductionSmsTable", "time <=?", new String[]{str});
                        writableDatabase.close();
                        a();
                    }
                    return new ListenableWorker.a.c();
                }
            }
            new ListenableWorker.a.c();
            return new ListenableWorker.a.c();
        } catch (Exception e3) {
            q.b(e3.getMessage());
            q.a(" Result error>>>>>>>>>>>>");
            return new ListenableWorker.a.c();
        } catch (Throwable unused) {
            return new ListenableWorker.a.c();
        }
    }

    private static String a(TrustListRequest trustListRequest) {
        String str;
        String str2 = new f().b(trustListRequest.getRequest()) + "UBaT0lhj42AiEg9TxD+Zyg==";
        q.a(str2);
        new g();
        byte[] bArr = new byte[0];
        try {
            bArr = g.a(str2.getBytes());
            str = new String(bArr);
        } catch (NoSuchAlgorithmException e2) {
            q.b(e2.getMessage());
            str = null;
        }
        q.a(str);
        return b.a(bArr);
    }

    private static String a(String str) {
        String replaceAll = str.replaceAll("[\\S]+://[\\S]", " ").replaceAll("/", "");
        q.a(" cleartext ".concat(String.valueOf(replaceAll)));
        return replaceAll;
    }

    public ListenableWorker.a doWork() {
        SQLiteDatabase writableDatabase = TMDbManager.a().f65169a.getWritableDatabase();
        writableDatabase.execSQL("delete from trustmanagerSmsTable where txnId is null");
        writableDatabase.close();
        q.a(" doWork >>>111 ");
        Context applicationContext = getApplicationContext();
        if (applicationContext == null || !a.m(applicationContext)) {
            return new ListenableWorker.a.C0076a();
        }
        a();
        return new ListenableWorker.a.c();
    }
}
