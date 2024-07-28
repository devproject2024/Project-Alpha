package com.paytm.business.merchantprofile.profileotp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.lifecycle.LiveData;
import androidx.localbroadcastmanager.a.a;
import com.business.common_module.OTPSmsRetriever;
import com.business.common_module.utilities.a.b;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.OtpEditBoxesCommonFragment;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.common.utility.AppUtility;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.profileotp.viewModel.AddMobileOTPViewModel;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class AddMobileOTPActivity extends BaseActivity {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "javaClass";
    public final int SMS_CONSENT_CODE = 15;
    public HashMap _$_findViewCache;
    public boolean isFromAddMobileOTPActivity;
    public String mType;
    public String mobNum = "";
    public String otp = "";
    public OtpEditBoxesCommonFragment otpEditBoxesCommonFragment;
    public OTPSmsRetriever otpSmsRetriever;
    public String otpState = "";
    public AddMobileOTPViewModel viewModel;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final OTPSmsRetriever getOtpSmsRetriever() {
        return this.otpSmsRetriever;
    }

    public final void setOtpSmsRetriever(OTPSmsRetriever oTPSmsRetriever) {
        this.otpSmsRetriever = oTPSmsRetriever;
    }

    public final OtpEditBoxesCommonFragment getOtpEditBoxesCommonFragment() {
        return this.otpEditBoxesCommonFragment;
    }

    public final void setOtpEditBoxesCommonFragment(OtpEditBoxesCommonFragment otpEditBoxesCommonFragment2) {
        this.otpEditBoxesCommonFragment = otpEditBoxesCommonFragment2;
    }

    public final AddMobileOTPViewModel getViewModel() {
        return this.viewModel;
    }

    public final void setViewModel(AddMobileOTPViewModel addMobileOTPViewModel) {
        this.viewModel = addMobileOTPViewModel;
    }

    public final boolean isFromAddMobileOTPActivity() {
        return this.isFromAddMobileOTPActivity;
    }

    public final void setFromAddMobileOTPActivity(boolean z) {
        this.isFromAddMobileOTPActivity = z;
    }

    public final String getMobNum() {
        return this.mobNum;
    }

    public final void setMobNum(String str) {
        k.d(str, "<set-?>");
        this.mobNum = str;
    }

    public final String getOtp() {
        return this.otp;
    }

    public final void setOtp(String str) {
        k.d(str, "<set-?>");
        this.otp = str;
    }

    public final String getOtpState() {
        return this.otpState;
    }

    public final void setOtpState(String str) {
        this.otpState = str;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getTAG() {
            return AddMobileOTPActivity.TAG;
        }
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.pr_activity_add_mobile_otp);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("mobileNumber")) {
            Intent intent2 = getIntent();
            String stringExtra = intent2 != null ? intent2.getStringExtra("mobileNumber") : null;
            k.a((Object) stringExtra);
            this.mobNum = stringExtra;
        }
        Intent intent3 = getIntent();
        if (intent3 != null && intent3.hasExtra("otp_type")) {
            Intent intent4 = getIntent();
            if (intent4 == null || (str = intent4.getStringExtra("otp_type")) == null) {
                str = "";
            }
            this.mType = str;
        }
        initUI();
        setUpData();
        hitGenerateOTPApi();
        startSMSListener();
        initSMSRetriever();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.otpSmsRetriever != null) {
            a a2 = a.a((Context) this);
            OTPSmsRetriever oTPSmsRetriever = this.otpSmsRetriever;
            k.a((Object) oTPSmsRetriever);
            a2.a((BroadcastReceiver) oTPSmsRetriever);
        }
    }

    private final void startSMSListener() {
        k.a((Object) this);
        com.google.android.gms.auth.api.phone.a.a(this).b();
    }

    private final void initSMSRetriever() {
        this.otpSmsRetriever = new OTPSmsRetriever((Activity) this);
        registerReceiver(this.otpSmsRetriever, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.SMS_CONSENT_CODE && i3 == -1) {
            String otpFromSms = AppUtility.getOtpFromSms("paytm", intent != null ? intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE") : null);
            if (otpFromSms == null) {
                otpFromSms = "";
            }
            setOTP(otpFromSms);
        }
    }

    private final void setOTP(String str) {
        OtpEditBoxesCommonFragment otpEditBoxesCommonFragment2 = this.otpEditBoxesCommonFragment;
        if (otpEditBoxesCommonFragment2 != null) {
            otpEditBoxesCommonFragment2.setOtpCombined(str);
        }
    }

    /* access modifiers changed from: private */
    public final void hitGenerateOTPApi() {
        showProgressDialog();
        AddMobileOTPViewModel addMobileOTPViewModel = this.viewModel;
        if (addMobileOTPViewModel != null) {
            addMobileOTPViewModel.hitgenerateOtp(this.mobNum, this.mType);
        }
    }

    private final void setUpData() {
        LiveData<b<GenerateOtpResponseModel>> generateOtpLiveData;
        this.viewModel = (AddMobileOTPViewModel) provideViewModel(AddMobileOTPViewModel.class, (Fragment) null);
        if (getIntent().hasExtra(AppConstants.FROM_SCREEN)) {
            this.isFromAddMobileOTPActivity = true;
        }
        AddMobileOTPViewModel addMobileOTPViewModel = this.viewModel;
        if (addMobileOTPViewModel != null && (generateOtpLiveData = addMobileOTPViewModel.getGenerateOtpLiveData()) != null) {
            generateOtpLiveData.observe(this, new AddMobileOTPActivity$setUpData$1(this));
        }
    }

    private final void initUI() {
        ((CustomTextView) _$_findCachedViewById(R.id.tv_resend_otp)).setOnClickListener(new AddMobileOTPActivity$initUI$1(this));
        if (!TextUtils.isEmpty(this.mobNum)) {
            CustomTextView customTextView = (CustomTextView) _$_findCachedViewById(R.id.tv_otp_num);
            k.b(customTextView, "tv_otp_num");
            customTextView.setVisibility(0);
            CustomTextView customTextView2 = (CustomTextView) _$_findCachedViewById(R.id.tv_otp_num);
            k.b(customTextView2, "tv_otp_num");
            customTextView2.setText(getResources().getString(R.string.pr_sent_to) + " " + this.mobNum);
        } else {
            CustomTextView customTextView3 = (CustomTextView) _$_findCachedViewById(R.id.tv_otp_num);
            k.b(customTextView3, "tv_otp_num");
            customTextView3.setVisibility(8);
        }
        ((CustomTextView) _$_findCachedViewById(R.id.tv_confirm)).setOnClickListener(new AddMobileOTPActivity$initUI$2(this));
        this.otpEditBoxesCommonFragment = new OtpEditBoxesCommonFragment();
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.container_id;
        OtpEditBoxesCommonFragment otpEditBoxesCommonFragment2 = this.otpEditBoxesCommonFragment;
        k.a((Object) otpEditBoxesCommonFragment2);
        a2.a(i2, (Fragment) otpEditBoxesCommonFragment2).b();
        ((ImageView) _$_findCachedViewById(R.id.iv_close)).setOnClickListener(new AddMobileOTPActivity$initUI$3(this));
    }
}
