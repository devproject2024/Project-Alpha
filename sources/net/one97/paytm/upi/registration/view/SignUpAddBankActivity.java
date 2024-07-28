package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.alipay.mobile.h5container.api.H5Param;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.m;
import net.one97.paytm.upi.registration.view.s;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class SignUpAddBankActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f68705a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final int f68706b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private final int f68707c = 1001;

    /* renamed from: d  reason: collision with root package name */
    private final int f68708d = 1002;

    /* renamed from: e  reason: collision with root package name */
    private final int f68709e = 10;

    /* renamed from: f  reason: collision with root package name */
    private String f68710f = "";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void attachBaseContext(Context context) {
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        if (a2.c() == null) {
            super.attachBaseContext(context);
            return;
        }
        i a3 = i.a();
        k.a((Object) a3, "PaytmUpiSdk.getInstance()");
        ContextWrapper d2 = a3.c().d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_signup_add_bank);
        UpiUtils.setStatusBarColor(getResources().getColor(R.color.white), this);
        PaytmUpiPrefUtil.Companion companion = PaytmUpiPrefUtil.Companion;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        String b2 = companion.getPref(applicationContext).b(UpiConstants.EXTRA_UPI_REFER_DEEPLINK, "", true);
        if (!TextUtils.isEmpty(b2)) {
            String queryParameter = Uri.parse(b2).getQueryParameter("referralCode");
            if (!TextUtils.isEmpty(queryParameter)) {
                net.one97.paytm.upi.registration.b.a.b.a.a(getApplicationContext()).d(new b(this), "", queryParameter);
            }
        }
        if (UpiUtils.isSimAvailable(getApplicationContext())) {
            j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                q a2 = supportFragmentManager.a();
                int i2 = R.id.container;
                s.a aVar = s.f69050a;
                a2.a(i2, (Fragment) new s()).b();
                return;
            }
            return;
        }
        b(2);
    }

    public static final class b implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignUpAddBankActivity f68711a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        }

        b(SignUpAddBankActivity signUpAddBankActivity) {
            this.f68711a = signUpAddBankActivity;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            UpiUtils.clearReferralCode(this.f68711a.getApplicationContext());
        }
    }

    public final void a(int i2) {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 288);
        intent.putExtra(UpiConstants.EXTRA_SUBSCRIPTION_ID, i2);
        intent.putExtra(UpiConstants.EXTRA_REGISTRATION_DO_CREATE_PROFILE, true);
        intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal());
        startActivityForResult(intent, this.f68706b);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = i2;
        int i5 = i3;
        Intent intent2 = intent;
        super.onActivityResult(i2, i3, intent);
        Serializable serializable = null;
        if (i4 == this.f68706b) {
            if (i5 != -1 || intent2 == null) {
                b(3);
            } else if (intent2.getBooleanExtra(UpiConstants.ARG_IS_PROFILE_CREATED, false)) {
                Serializable serializableExtra = intent2.getSerializableExtra(UpiConstants.ARG_BANK_LIST);
                if (!(serializableExtra instanceof ArrayList)) {
                    serializableExtra = null;
                }
                ArrayList arrayList = (ArrayList) serializableExtra;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                String stringExtra = intent2.getStringExtra("vpa");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                this.f68710f = stringExtra;
                if (arrayList.isEmpty()) {
                    a(this.f68710f);
                    return;
                }
                j supportFragmentManager = getSupportFragmentManager();
                m.a aVar = m.f68969a;
                UpiUtils.replaceFragmentToActivity(supportFragmentManager, m.a.a(arrayList, this.f68710f), R.id.container, true);
            } else {
                b(1);
            }
        } else if (i4 == this.f68707c) {
            if (i5 == -1) {
                CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "select_individual_account_proceed", "", "", "", "/bhim-upi/signup/singlelinkaccount", "wallet");
                if (intent2 != null) {
                    serializable = intent2.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                }
                if (serializable != null) {
                    BankVpaCreationActivity.a((Activity) this, (AccountProviderBody.AccountProvider) serializable, this.f68710f, this.f68708d);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "single_link_bank_account_back_arrow", "", "", "", "/bhim-upi/signup/singlelinkaccount", "wallet");
            b(3);
        } else if (i4 != this.f68708d) {
        } else {
            if (i5 != -1 || intent2 == null) {
                CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "bank_account_linked_failed_onboarding", "", "", "", "/bhim-upi/signup/singlelinkaccount", "wallet");
                b(3);
                return;
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "bank_account_linked_success_onboarding", "true", "", "", "/bhim-upi/signup/singlelinkaccount", "wallet");
            if (intent2.getSerializableExtra(UpiConstants.EXTRA_BANK_ACCOUNT_LIST) != null) {
                Serializable serializableExtra2 = intent2.getSerializableExtra(UpiConstants.EXTRA_BANK_ACCOUNT_LIST);
                if (serializableExtra2 != null) {
                    ArrayList arrayList2 = (ArrayList) serializableExtra2;
                    j supportFragmentManager2 = getSupportFragmentManager();
                    m.a aVar2 = m.f68969a;
                    String str = this.f68710f;
                    if (str == null) {
                        k.a();
                    }
                    UpiUtils.replaceFragmentToActivity(supportFragmentManager2, m.a.a(arrayList2, str), R.id.container, true);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> /* = java.util.ArrayList<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> */");
            }
            b(1);
        }
    }

    public final void a(String str) {
        k.c(str, "vpaAddress");
        this.f68710f = str;
        AccountProviderActivity.a((Activity) this, this.f68707c);
    }

    public final void onBackPressed() {
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.f() > 0) {
            List<Fragment> g2 = supportFragmentManager.g();
            k.a((Object) g2, "supportFragmentManager.fragments");
            Iterator<Fragment> it2 = g2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Fragment next = it2.next();
                if (!(next instanceof o)) {
                    if (next instanceof m) {
                        ((m) next).b();
                        break;
                    }
                } else {
                    ((o) next).a();
                    return;
                }
            }
        }
        finish();
    }

    public final void b(int i2) {
        Intent intent = new Intent();
        if (i2 == 0) {
            k.a((Object) intent.putExtra("result", "success"), "intent.putExtra(\"result\", \"success\")");
        } else if (i2 == 1) {
            k.a((Object) intent.putExtra("result", ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE), "intent.putExtra(\"result\", \"failure\")");
        } else if (i2 == 2) {
            k.a((Object) intent.putExtra("result", H5Param.DEFAULT_LONG_BACK_BEHAVIOR), "intent.putExtra(\"result\", \"back\")");
        } else if (i2 == 3) {
            intent.putExtra("result", "skip");
        }
        setResult(-1, intent);
        finish();
    }
}
