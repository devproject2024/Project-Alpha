package net.one97.paytm.nativesdk.bank_mandate.viewModel;

import android.content.Context;
import android.view.View;
import android.webkit.URLUtil;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateIFSCBank;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateIFSCBranch;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateIFSCCity;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateIFSCState;
import net.one97.paytm.nativesdk.bank_mandate.listeners.BankMandateProviderListener;
import net.one97.paytm.nativesdk.bank_mandate.view.BankMandateFindIFSCFragment;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import org.json.JSONObject;

public class BankMandateIfscCodeViewModel extends BaseViewModel implements Response.ErrorListener, Response.Listener {
    public ObservableBoolean bankClickable = new ObservableBoolean(true);
    public i<String> bankName = new i<>();
    public ObservableBoolean branchClickable = new ObservableBoolean(false);
    public i<String> branchName = new i<>();
    public ObservableBoolean cityClickable = new ObservableBoolean(false);
    public i<String> cityName = new i<>();
    public ObservableInt continueVisibility = new ObservableInt(8);
    public i<String> ifscCode = new i<>();
    public ObservableInt ifscVisibility = new ObservableInt(8);
    private Context mContext;
    private BankMandateFindIFSCFragment.BankMandateIFSCSelectListener mIfscSelectListener;
    private BankMandateProviderListener mListener;
    public ObservableBoolean stateClickable = new ObservableBoolean(false);
    public i<String> stateName = new i<>();

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public void onClickBackArrow(View view) {
    }

    public void onErrorResponse(VolleyError volleyError) {
    }

    public BankMandateIfscCodeViewModel(Context context, BankMandateProviderListener bankMandateProviderListener, BankMandateFindIFSCFragment.BankMandateIFSCSelectListener bankMandateIFSCSelectListener) {
        super(context, (BaseViewActions) null);
        this.mContext = context;
        this.mListener = bankMandateProviderListener;
        this.mIfscSelectListener = bankMandateIFSCSelectListener;
    }

    public void callBankListApi(View view) {
        if (this.bankClickable.get()) {
            this.bankClickable.set(false);
            this.ifscVisibility.set(8);
            this.continueVisibility.set(8);
            VolleyPostRequest volleyPostRequest = new VolleyPostRequest(0, SDKUtility.addAuthDefaultParams(this.mContext, NativeSdkGtmLoader.getIFSC()), (Map<String, String>) null, (Map<String, String>) null, (String) null, this, this, BankMandateIFSCBank.class);
            Context context = this.mContext;
            if (context != null) {
                VolleyRequestQueue.getInstance(context).addToRequestQueue(volleyPostRequest);
            }
        }
    }

    public void callStateListApi(View view) {
        if (this.stateClickable.get()) {
            this.stateClickable.set(false);
            this.ifscVisibility.set(8);
            this.continueVisibility.set(8);
            String ifsc = NativeSdkGtmLoader.getIFSC();
            if (URLUtil.isValidUrl(ifsc)) {
                String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.mContext, ifsc);
                HashMap hashMap = new HashMap();
                hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("bankName", this.bankName.get());
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put(SDKConstants.CHANNEL, "MP_ANDROID");
                    String appVersion = PaytmSDK.getAppVersion();
                    if (appVersion != null) {
                        jSONObject.put(SDKConstants.VERSION, appVersion);
                    }
                } catch (Exception unused) {
                }
                VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, jSONObject.toString(), this, this, BankMandateIFSCState.class);
                Context context = this.mContext;
                if (context != null) {
                    VolleyRequestQueue.getInstance(context).addToRequestQueue(volleyPostRequest);
                }
            }
        }
    }

    public void callCityListApi(View view) {
        if (this.cityClickable.get()) {
            this.cityClickable.set(false);
            this.ifscVisibility.set(8);
            this.continueVisibility.set(8);
            String ifsc = NativeSdkGtmLoader.getIFSC();
            if (URLUtil.isValidUrl(ifsc)) {
                String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.mContext, ifsc);
                HashMap hashMap = new HashMap();
                hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("bankName", this.bankName.get());
                    jSONObject2.put("state", this.stateName.get());
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put(SDKConstants.CHANNEL, "MP_ANDROID");
                    String appVersion = PaytmSDK.getAppVersion();
                    if (appVersion != null) {
                        jSONObject.put(SDKConstants.VERSION, appVersion);
                    }
                } catch (Exception unused) {
                }
                VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, jSONObject.toString(), this, this, BankMandateIFSCCity.class);
                Context context = this.mContext;
                if (context != null) {
                    VolleyRequestQueue.getInstance(context).addToRequestQueue(volleyPostRequest);
                }
            }
        }
    }

    public void callBranchListApi(View view) {
        if (this.branchClickable.get()) {
            this.branchClickable.set(false);
            this.ifscVisibility.set(8);
            this.continueVisibility.set(8);
            String ifsc = NativeSdkGtmLoader.getIFSC();
            if (URLUtil.isValidUrl(ifsc)) {
                String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.mContext, ifsc);
                HashMap hashMap = new HashMap();
                hashMap.put("SSO_TOKEN", MerchantBL.getMerchantInstance().getSsoToken());
                hashMap.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("bankName", this.bankName.get());
                    jSONObject2.put("state", this.stateName.get());
                    jSONObject2.put("city", this.cityName.get());
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put(SDKConstants.CHANNEL, "MP_ANDROID");
                    String appVersion = PaytmSDK.getAppVersion();
                    if (appVersion != null) {
                        jSONObject.put(SDKConstants.VERSION, appVersion);
                    }
                } catch (Exception unused) {
                }
                VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, addAuthDefaultParams, hashMap, (Map<String, String>) null, jSONObject.toString(), this, this, BankMandateIFSCBranch.class);
                Context context = this.mContext;
                if (context != null) {
                    VolleyRequestQueue.getInstance(context).addToRequestQueue(volleyPostRequest);
                }
            }
        }
    }

    public void onResponse(Object obj) {
        if (obj instanceof BankMandateIFSCBank) {
            this.bankClickable.set(true);
            BankMandateIFSCBank bankMandateIFSCBank = (BankMandateIFSCBank) obj;
            if (bankMandateIFSCBank != null && bankMandateIFSCBank.getResponse() != null && bankMandateIFSCBank.getResponse().getList() != null && bankMandateIFSCBank.getResponse().getList().size() > 0) {
                this.mListener.onBankListReceived(bankMandateIFSCBank.getResponse().getList());
            }
        } else if (obj instanceof BankMandateIFSCState) {
            this.stateClickable.set(true);
            BankMandateIFSCState bankMandateIFSCState = (BankMandateIFSCState) obj;
            if (bankMandateIFSCState != null && bankMandateIFSCState.getResponse() != null && bankMandateIFSCState.getResponse().getList() != null && bankMandateIFSCState.getResponse().getList().size() > 0) {
                this.mListener.onStateListReceived(bankMandateIFSCState.getResponse().getList());
            }
        } else if (obj instanceof BankMandateIFSCCity) {
            this.cityClickable.set(true);
            BankMandateIFSCCity bankMandateIFSCCity = (BankMandateIFSCCity) obj;
            if (bankMandateIFSCCity != null && bankMandateIFSCCity.getResponse() != null && bankMandateIFSCCity.getResponse().getList() != null && bankMandateIFSCCity.getResponse().getList().size() > 0) {
                this.mListener.onCityListReceived(bankMandateIFSCCity.getResponse().getList());
            }
        } else if (obj instanceof BankMandateIFSCBranch) {
            this.branchClickable.set(true);
            BankMandateIFSCBranch bankMandateIFSCBranch = (BankMandateIFSCBranch) obj;
            if (bankMandateIFSCBranch != null && bankMandateIFSCBranch.getResponse() != null && bankMandateIFSCBranch.getResponse().getBankBranchList() != null && bankMandateIFSCBranch.getResponse().getBankBranchList().size() > 0) {
                this.mListener.onBranchListReceived(bankMandateIFSCBranch.getResponse().getBankBranchList());
            }
        }
    }
}
