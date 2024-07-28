package net.one97.paytm.verifier.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.newdesign.utils.CustomWalletLoaderDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class VerifierBasicActivity extends PaytmActivity implements b {

    /* renamed from: a  reason: collision with root package name */
    private CustomWalletLoaderDialog f69835a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_verifier_process_call_back);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        try {
            if (this.f69835a == null) {
                this.f69835a = new CustomWalletLoaderDialog(this);
            }
            this.f69835a.showLoader();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("verifier_verifyID")) {
            String stringExtra = intent.getStringExtra("verifier_verifyID");
            String stringExtra2 = intent.getStringExtra("verifier_method");
            String stringExtra3 = intent.getStringExtra("verifier_method_list");
            Intent intent2 = new Intent(this, VerificationProcessActivity.class);
            intent2.putExtra("verifier_verifyID", stringExtra);
            intent2.putExtra("verifier_method", stringExtra2);
            intent2.putExtra("verifier_method_list", stringExtra3);
            startActivityForResult(intent2, 2021);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2021 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("verifier_callback_url");
            if (TextUtils.isEmpty(stringExtra)) {
                setResult(0);
                finish();
            } else if (URLUtil.isValidUrl(stringExtra)) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("userToken", t.b((Context) this));
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
                hashMap.put("channel", "MOB");
                hashMap.put("client", "androidapp");
                hashMap.put("Accept", "application/json");
                hashMap.put("Authorization", jSONObject.toString());
                d.a(this, stringExtra, this, hashMap, (Map<String, String>) null, a.C0715a.POST, (String) null, new CJRMoneyTransferIMPSInitiateDataModel(), a.c.PAYMENTS, a.b.SILENT).a();
            }
        } else {
            setResult(0);
            finish();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel)) {
            Intent intent = new Intent();
            intent.putExtra("verifier_imps_data", (CJRMoneyTransferIMPSInitiateDataModel) iJRPaytmDataModel);
            setResult(-1, intent);
            finish();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        setResult(0);
        finish();
    }
}
