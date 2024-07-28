package net.one97.paytm.upi.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.k;
import androidx.lifecycle.q;
import com.google.gson.f;
import com.google.gson.u;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CredentialsData;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserMpinDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.b.b;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.UpiConstants;
import org.npci.upi.security.services.CLRemoteResultReceiver;

public final class UPICheckBalanceHelper implements a.C1347a {
    /* access modifiers changed from: private */
    public final int REQUEST_CHECK_BALANCE;
    private int REQUEST_CODE_DEVICE_BINDING;
    private String TAG;
    private boolean isToGetPPBBalanceWithoutPin;
    private q lifecycleOwner;
    /* access modifiers changed from: private */
    public n.c listener;
    private Activity mActivity;
    private Context mContext;
    private Fragment mFragment;
    private a mNpciServices;
    private String mScreenName;
    private b mUpiProfileRepository;
    private net.one97.paytm.upi.registration.b.a.b mUpiRegistrationRepository;

    public final void onServiceConnected() {
    }

    public final void onServiceDisconnected() {
    }

    public /* synthetic */ UPICheckBalanceHelper(Context context, n.c cVar, String str, String str2, int i2, boolean z, Fragment fragment, Activity activity, q qVar, g gVar) {
        this(context, cVar, str, str2, i2, z, fragment, activity, qVar);
    }

    private UPICheckBalanceHelper(Context context, n.c cVar, String str, String str2, int i2, boolean z, Fragment fragment, Activity activity, q qVar) {
        this.mContext = context;
        this.listener = cVar;
        this.TAG = str;
        this.mScreenName = str2;
        this.REQUEST_CODE_DEVICE_BINDING = i2;
        this.mUpiProfileRepository = net.one97.paytm.upi.g.a();
        this.mUpiRegistrationRepository = net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null));
        this.mNpciServices = net.one97.paytm.upi.g.a((a.C1347a) this);
        this.isToGetPPBBalanceWithoutPin = z;
        this.mFragment = fragment;
        this.mActivity = activity;
        this.lifecycleOwner = qVar;
    }

    public final void startSetMpinScreen(UpiProfileDefaultBank upiProfileDefaultBank, int i2) {
        k.c(upiProfileDefaultBank, "upiProfileDefaultBank");
        Intent intent = new Intent(this.mContext, SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build());
        Fragment fragment = this.mFragment;
        if (fragment == null) {
            Activity activity = this.mActivity;
            if (activity != null && activity != null) {
                activity.startActivityForResult(intent, i2);
            }
        } else if (fragment != null) {
            fragment.startActivityForResult(intent, i2);
        }
    }

    public final void getUpiAccountBalance(UpiProfileDefaultBank upiProfileDefaultBank) {
        k.c(upiProfileDefaultBank, "upiProfileDefaultBank");
        if (isFragmentAttached()) {
            this.listener.Z_();
        }
        if (isToGetPPBWithoutPin()) {
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
            if (isPaytmPBAccount(debitBank)) {
                BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
                k.a((Object) debitBank2, "upiProfileDefaultBank.debitBank");
                debitBank2.setAccountType(UpiConstants.BANK_ACCOUNT_TYPE.SAVINGS.getType());
                b bVar = this.mUpiProfileRepository;
                if (bVar != null) {
                    upiProfileDefaultBank.getDebitBank().getAccount();
                    bVar.a((a.C1382a) new UPICheckBalanceHelper$getUpiAccountBalance$1(this, upiProfileDefaultBank));
                    return;
                }
                return;
            }
        }
        net.one97.paytm.upi.registration.b.a.b bVar2 = this.mUpiRegistrationRepository;
        if (bVar2 != null) {
            bVar2.b((a.C1389a) new UPICheckBalanceHelper$getUpiAccountBalance$2(this, upiProfileDefaultBank), this.TAG, this.mScreenName);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFragmentAttached() {
        q qVar = this.lifecycleOwner;
        if (qVar == null) {
            return true;
        }
        if (qVar == null) {
            k.a();
        }
        androidx.lifecycle.k lifecycle = qVar.getLifecycle();
        k.a((Object) lifecycle, "lifecycleOwner!!.lifecycle");
        return lifecycle.a().isAtLeast(k.b.CREATED);
    }

    private final boolean isToGetPPBWithoutPin() {
        return this.isToGetPPBBalanceWithoutPin;
    }

    private final boolean isPaytmPBAccount(BankAccountDetails.BankAccount bankAccount) {
        String ifsc = bankAccount.getIfsc();
        kotlin.g.b.k.a((Object) ifsc, "bankAccount.ifsc");
        return p.a((CharSequence) ifsc, (CharSequence) "PYTM", false);
    }

    /* access modifiers changed from: private */
    public final void onGetCredentialError(String str) {
        this.listener.b();
        if (TextUtils.isEmpty(str) || !p.a("1006", str, true)) {
            this.listener.a(n.b.ERROR_UNDEFINED);
        } else {
            startDeviceRegistration();
        }
    }

    /* access modifiers changed from: private */
    public final void onCheckBalanceError(UpiCustomVolleyError upiCustomVolleyError, String str) {
        if (isFragmentAttached()) {
            if (!TextUtils.isEmpty(str)) {
                if (kotlin.g.b.k.a((Object) "ZM", (Object) str)) {
                    this.listener.a(n.b.INCORRECT_MPIN);
                } else if (kotlin.g.b.k.a((Object) "1006", (Object) str)) {
                    startDeviceRegistration();
                } else if (kotlin.g.b.k.a((Object) "Z6", (Object) str)) {
                    this.listener.a(n.b.INCORRECT_MPIN_TOO_MANY_TIMES);
                } else {
                    this.listener.a(n.b.UNABLE_TO_CHECK_BALANCE);
                }
            } else if (upiCustomVolleyError != null) {
                String str2 = upiCustomVolleyError.getmErrorCode();
                if (UpiUtils.isAuthenticationFailure(str2)) {
                    this.listener.a(n.b.SESSION_TIMEOUT);
                } else if (TextUtils.isEmpty(str2) || !kotlin.g.b.k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str2)) {
                    this.listener.a(n.b.ERROR_UNDEFINED);
                } else {
                    this.listener.a(n.b.NO_NETWORK);
                }
            } else {
                this.listener.a(n.b.ERROR_UNDEFINED);
            }
        }
    }

    private final void startDeviceRegistration() {
        if (this.mActivity == null && this.mFragment == null) {
            this.listener.a(n.b.ERROR_UNDEFINED);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            Intent intent = new Intent(context, UpiRegistrationActivity.class);
            intent.putExtra("redirect", 112);
            intent.setFlags(536870912);
            Fragment fragment = this.mFragment;
            if (fragment != null) {
                if (fragment != null ? fragment.isAdded() : false) {
                    Fragment fragment2 = this.mFragment;
                    if (fragment2 != null) {
                        fragment2.startActivityForResult(intent, this.REQUEST_CODE_DEVICE_BINDING);
                        return;
                    }
                    return;
                }
            }
            Activity activity = this.mActivity;
            if (activity != null && activity != null) {
                activity.startActivityForResult(intent, this.REQUEST_CODE_DEVICE_BINDING);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void fetchTokenForBalance(String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        net.one97.paytm.upi.registration.b.a.b bVar = this.mUpiRegistrationRepository;
        if (bVar != null) {
            if (!bVar.g()) {
                this.listener.b();
                startDeviceRegistration();
            }
            if (bVar != null) {
                bVar.d(new UPICheckBalanceHelper$fetchTokenForBalance$$inlined$let$lambda$1(this, str, upiProfileDefaultBank), this.TAG, this.mScreenName);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void getBalanceCredentials(String str, String str2, UpiProfileDefaultBank upiProfileDefaultBank) {
        String upiSequenceNo = UpiUtils.getUpiSequenceNo();
        net.one97.paytm.upi.h.a aVar = this.mNpciServices;
        if (aVar != null) {
            Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.a()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (valueOf.booleanValue()) {
                net.one97.paytm.upi.h.a aVar2 = this.mNpciServices;
                if (aVar2 != null) {
                    aVar2.a(upiSequenceNo, str, str2, 0, upiProfileDefaultBank.getDebitBank(), new CLRemoteResultReceiver(new UPICheckBalanceHelper$getBalanceCredentials$1(this, upiSequenceNo, upiProfileDefaultBank, new Handler())));
                    return;
                }
                return;
            }
        }
        this.listener.a(n.b.ERROR_UNDEFINED);
    }

    /* access modifiers changed from: private */
    public final void parseResult(int i2, Bundle bundle, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        String string = bundle.getString("error");
        if (string != null) {
            if (!(string.length() == 0)) {
                try {
                    this.listener.b();
                    this.listener.a(n.b.ERROR_BACK_PRESSED);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
        Serializable serializable = bundle.getSerializable("credBlocks");
        if (serializable != null) {
            HashMap hashMap = (HashMap) serializable;
            ArrayList arrayList = new ArrayList();
            for (String str2 : hashMap.keySet()) {
                try {
                    GetCredentialsResponse getCredentialsResponse = (GetCredentialsResponse) new f().a((String) hashMap.get(str2), GetCredentialsResponse.class);
                    kotlin.g.b.k.a((Object) getCredentialsResponse, "getCredentialsResponse");
                    getCredentialsResponse.setSubtype(str2);
                    arrayList.add(getCredentialsResponse);
                } catch (u e3) {
                    e3.printStackTrace();
                }
            }
            if (i2 == this.REQUEST_CHECK_BALANCE) {
                fetchBalanceFromPSP(arrayList, str, upiProfileDefaultBank);
                return;
            }
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }

    private final void fetchBalanceFromPSP(List<? extends GetCredentialsResponse> list, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        UserMpinDetails userMpinDetails = new UserMpinDetails();
        for (GetCredentialsResponse getCredentialsResponse : list) {
            if (p.a("MPIN", getCredentialsResponse.getSubtype(), true)) {
                StringBuilder sb = new StringBuilder();
                CredentialsData data = getCredentialsResponse.getData();
                kotlin.g.b.k.a((Object) data, "credential.data");
                sb.append(data.getCode());
                sb.append(AppConstants.COMMA);
                CredentialsData data2 = getCredentialsResponse.getData();
                kotlin.g.b.k.a((Object) data2, "credential.data");
                sb.append(data2.getKi());
                sb.append(AppConstants.COMMA);
                CredentialsData data3 = getCredentialsResponse.getData();
                kotlin.g.b.k.a((Object) data3, "credential.data");
                sb.append(data3.getEncryptedBase64String());
                userMpinDetails.setMpin(sb.toString());
            }
        }
        this.listener.Z_();
        b bVar = this.mUpiProfileRepository;
        if (bVar != null) {
            bVar.a(str, userMpinDetails, upiProfileDefaultBank, (a.C1382a) new UPICheckBalanceHelper$fetchBalanceFromPSP$1(this, upiProfileDefaultBank), this.TAG, this.mScreenName);
        }
    }

    public static final class UPICheckBalanceBuilder {
        private Integer REQUEST_CODE_DEVICE_BINDING = 10520;
        private String TAG = getClass().getName();
        private boolean isToGetPPBBalanceWithoutPin = true;
        private q lifecycleOwner;
        private n.c listener;
        private Activity mActivity;
        private Context mContext;
        private Fragment mFragment;
        private String mScreenName = getClass().getName();

        public UPICheckBalanceBuilder(Context context, n.c cVar) {
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(cVar, "listener");
            this.mContext = context;
            this.listener = cVar;
        }

        public final UPICheckBalanceBuilder setTag(String str) {
            if (str != null) {
                this.TAG = str;
            }
            return this;
        }

        public final UPICheckBalanceBuilder setLifecycleOwner(q qVar) {
            kotlin.g.b.k.c(qVar, "lifecycleOwner");
            this.lifecycleOwner = qVar;
            return this;
        }

        public final UPICheckBalanceBuilder setScreenName(String str) {
            if (str != null) {
                this.mScreenName = str;
            }
            return this;
        }

        public final UPICheckBalanceBuilder setDeviceBindingRequestCode(Integer num) {
            if (num != null) {
                this.REQUEST_CODE_DEVICE_BINDING = Integer.valueOf(num.intValue());
            }
            return this;
        }

        public final UPICheckBalanceBuilder setIsToGetPPBBalanceWithoutPin(boolean z) {
            this.isToGetPPBBalanceWithoutPin = z;
            return this;
        }

        public final UPICheckBalanceBuilder setOnActivityResultRecieverAfterDeviceBinding(Fragment fragment) {
            this.mFragment = fragment;
            return this;
        }

        public final UPICheckBalanceBuilder setOnActivityResultRecieverAfterDeviceBinding(Activity activity) {
            this.mActivity = activity;
            return this;
        }

        public final UPICheckBalanceHelper build() {
            Context context = this.mContext;
            n.c cVar = this.listener;
            String str = this.TAG;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            String str2 = this.mScreenName;
            if (str2 == null) {
                kotlin.g.b.k.a();
            }
            Integer num = this.REQUEST_CODE_DEVICE_BINDING;
            if (num == null) {
                kotlin.g.b.k.a();
            }
            return new UPICheckBalanceHelper(context, cVar, str, str2, num.intValue(), this.isToGetPPBBalanceWithoutPin, this.mFragment, this.mActivity, this.lifecycleOwner, (g) null);
        }
    }
}
