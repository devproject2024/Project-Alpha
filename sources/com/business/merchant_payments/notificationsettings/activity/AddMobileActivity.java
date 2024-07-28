package com.business.merchant_payments.notificationsettings.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.f;
import androidx.lifecycle.al;
import androidx.lifecycle.z;
import com.business.common_module.events.d;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.R;
import com.business.merchant_payments.acceptpayments.AddMobileOTPActivity;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.databinding.MpAddMobileActivityBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

public class AddMobileActivity extends BaseActivity {
    public static final int OTP_REQ_CODE = 1;
    public String currentlyPresentMultipleNumers;
    public MpAddMobileActivityBinding mBinding;
    public String mType;
    public String primaryEmailOrMob;
    public AddMobileViewModel viewModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBinding = (MpAddMobileActivityBinding) f.a(this, R.layout.mp_add_mobile_activity);
        AddMobileViewModel addMobileViewModel = (AddMobileViewModel) new al(this).a(AddMobileViewModel.class);
        this.viewModel = addMobileViewModel;
        this.mBinding.setViewModel(addMobileViewModel);
        this.mBinding.back.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMobileActivity.this.lambda$onCreate$0$AddMobileActivity(view);
            }
        });
        this.mBinding.button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMobileActivity.this.lambda$onCreate$1$AddMobileActivity(view);
            }
        });
        initData();
        setObservers();
    }

    public /* synthetic */ void lambda$onCreate$0$AddMobileActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$AddMobileActivity(View view) {
        onContinue();
    }

    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("type");
            if (stringExtra == null || !"update_secondary_email".equals(stringExtra)) {
                GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("Accept Payment/Add-Change notification settings/Add another Mobile number");
            } else {
                GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("Accept Payment/Add-Change notification settings/Add another email");
            }
        }
    }

    private void setObservers() {
        this.viewModel.responseLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                AddMobileActivity.this.lambda$setObservers$2$AddMobileActivity((b) obj);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$setObservers$2$AddMobileActivity(com.business.common_module.utilities.a.b r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x00ba
            com.business.common_module.utilities.a.e r0 = r8.f7357b
            com.business.common_module.utilities.a.e r1 = com.business.common_module.utilities.a.e.LOADING
            if (r0 != r1) goto L_0x0009
            return
        L_0x0009:
            r7.removeProgressDialog()
            T r0 = r8.f7358c
            if (r0 == 0) goto L_0x00b3
            com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse r0 = (com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse) r0
            java.lang.String r0 = r0.getStatus()
            if (r0 == 0) goto L_0x00b3
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            T r1 = r8.f7358c
            com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse r1 = (com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse) r1
            java.lang.String r1 = r1.getStatus()
            java.lang.String r1 = r1.toUpperCase()
            int r2 = r1.hashCode()
            r3 = -1149187101(0xffffffffbb80cbe3, float:-0.003930555)
            r4 = -1
            r5 = 0
            r6 = 1
            if (r2 == r3) goto L_0x0044
            r3 = -368591510(0xffffffffea07bd6a, float:-4.1024867E25)
            if (r2 != r3) goto L_0x004e
            java.lang.String r2 = "FAILURE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x004e
            r1 = 1
            goto L_0x004f
        L_0x0044:
            java.lang.String r2 = "SUCCESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x004e
            r1 = 0
            goto L_0x004f
        L_0x004e:
            r1 = -1
        L_0x004f:
            java.lang.String r2 = "type"
            if (r1 == 0) goto L_0x008f
            java.lang.String r3 = "There was an error updating your details. Please try again"
            if (r1 == r6) goto L_0x006a
            java.lang.String r8 = r7.mType
            r0.putExtra(r2, r8)
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r3, r6)
            r8.show()
            r7.setResult(r5)
            r7.finish()
            return
        L_0x006a:
            java.lang.String r1 = r7.mType
            r0.putExtra(r2, r1)
            T r8 = r8.f7358c
            com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse r8 = (com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse) r8
            java.lang.String r0 = r8.getStatusMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0081
            java.lang.String r3 = r8.getStatusMessage()
        L_0x0081:
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r3, r6)
            r8.show()
            r7.setResult(r5)
            r7.finish()
            return
        L_0x008f:
            java.lang.String r8 = r7.mType
            r0.putExtra(r2, r8)
            com.business.merchant_payments.notificationsettings.viewmodel.AddMobileViewModel r8 = r7.viewModel
            java.lang.String r8 = r8.getmInput()
            java.lang.String r1 = "updated_value"
            r0.putExtra(r1, r8)
            int r8 = com.business.merchant_payments.R.string.mp_details_updated_successfully
            java.lang.String r8 = r7.getString(r8)
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r8, r6)
            r8.show()
            r7.setResult(r4, r0)
            r7.finish()
            return
        L_0x00b3:
            java.lang.String r0 = r7.mType
            java.lang.String r1 = "UMP"
            com.business.merchant_payments.common.ErrorUtil.handleAPIError(r0, r1, r8)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.activity.AddMobileActivity.lambda$setObservers$2$AddMobileActivity(com.business.common_module.utilities.a.b):void");
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("type") && !TextUtils.isEmpty(intent.getStringExtra("type"))) {
                this.mType = intent.getStringExtra("type");
            }
            if (intent.hasExtra(AppConstants.NOTIFICATION_DETAILS.PRIMARY_EMAIL) && !TextUtils.isEmpty(intent.getStringExtra(AppConstants.NOTIFICATION_DETAILS.PRIMARY_EMAIL))) {
                this.primaryEmailOrMob = intent.getStringExtra(AppConstants.NOTIFICATION_DETAILS.PRIMARY_EMAIL);
            }
            if (intent.hasExtra(AppConstants.NOTIFICATION_DETAILS.PRIMARY_MOBILE) && !TextUtils.isEmpty(intent.getStringExtra(AppConstants.NOTIFICATION_DETAILS.PRIMARY_MOBILE))) {
                this.primaryEmailOrMob = intent.getStringExtra(AppConstants.NOTIFICATION_DETAILS.PRIMARY_MOBILE);
            }
            if (intent.hasExtra(AppConstants.MULTIPLE_NUMBERS) && !TextUtils.isEmpty(intent.getStringExtra(AppConstants.MULTIPLE_NUMBERS))) {
                this.currentlyPresentMultipleNumers = intent.getStringExtra(AppConstants.MULTIPLE_NUMBERS);
            }
        }
        String str = this.mType;
        if (str != null) {
            this.viewModel.setType(str);
        }
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onStop() {
        super.onStop();
        c.a().b(this);
    }

    public void onContinue() {
        if (this.viewModel.isValid() && !this.viewModel.isDuplicate(this.primaryEmailOrMob)) {
            String str = this.mType;
            if (str == null || !"update_secondary_mobile".equalsIgnoreCase(str)) {
                String str2 = this.mType;
                if (str2 != null && "update_secondary_email".equalsIgnoreCase(str2)) {
                    GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/business-app/Accept Payments/Add/Change notification settings");
                    GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "Accept Payment", "Add-Change notification settings", "/business-app/Accept Payments/Add/Change notification settings", "Add another email");
                }
            } else {
                GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(this, "Accept Payment", "Add-Change notification settings", "Save another mobile number");
            }
            char c2 = 65535;
            if (this.mType.equalsIgnoreCase(AppConstants.NOTIFICATION_DETAILS.MOBILE_EDIT_QR)) {
                Intent intent = new Intent();
                intent.putExtra(AppConstants.NOTIFICATION_DETAILS.UPDATED_VALUE, this.viewModel.getmInput());
                setResult(-1, intent);
                finish();
            } else if (!i.a(getApplication())) {
                ErrorUtil.handleNoNetworkError(this.mType);
            } else {
                c.a().c(new d(true));
                String str3 = this.mType;
                switch (str3.hashCode()) {
                    case -1917971045:
                        if (str3.equals("update_secondary_email")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1606931927:
                        if (str3.equals("update_primary_email")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -908748295:
                        if (str3.equals(AppConstants.NOTIFICATION_DETAILS.ADD_ADDITIONAL_CONTACT)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 903349891:
                        if (str3.equals("update_secondary_mobile")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1955627957:
                        if (str3.equals("update_primary_mobile")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    this.viewModel.apiFlag.setValue(Boolean.TRUE);
                } else if (c2 == 1) {
                    this.viewModel.apiFlag.setValue(Boolean.TRUE);
                } else if (c2 == 2 || c2 == 3) {
                    if (!isNumberAlreadyPresentInList()) {
                        showOTPScreen();
                        return;
                    }
                    c.a().c(new d(false));
                    this.viewModel.mInputError.set(getResources().getString(R.string.mp_mobile_number_already_added));
                } else if (c2 == 4) {
                    showOTPScreen();
                }
            }
        }
    }

    private boolean isNumberAlreadyPresentInList() {
        if (TextUtils.isEmpty(this.currentlyPresentMultipleNumers)) {
            return false;
        }
        String[] split = this.currentlyPresentMultipleNumers.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
        if (split != null && split.length > 0) {
            for (String equalsIgnoreCase : split) {
                if (equalsIgnoreCase.equalsIgnoreCase(this.viewModel.mInput.get())) {
                    return true;
                }
            }
        }
        return this.currentlyPresentMultipleNumers.equalsIgnoreCase(APSharedPreferences.getInstance().getMerchantMobile());
    }

    private void showOTPScreen() {
        Intent intent = new Intent(this, AddMobileOTPActivity.class);
        intent.putExtra("mobileNumber", this.viewModel.mInput.get());
        intent.putExtra(AppConstants.FROM_SCREEN, "addMobileActivity");
        startActivityForResult(intent, 1);
    }

    @j
    public void onErrorRetryEvent(com.business.common_module.events.b bVar) {
        if (this.mType.equals(bVar.f7341a)) {
            onContinue();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && intent != null) {
            updateMobNum(intent.getStringExtra("OTP"), intent.getStringExtra("OTP_STATE"));
        } else if (i2 == 1) {
            removeProgressDialog();
        }
    }

    private void updateMobNum(String str, String str2) {
        this.viewModel.apiFlag.setValue(Boolean.TRUE);
        this.viewModel.updateOTPValues(str, str2);
    }

    @j
    public void handleProgressEvent(d dVar) {
        if (dVar.f7351a) {
            super.showProgressDialog(false);
        } else {
            super.removeProgressDialog();
        }
    }
}
