package com.paytm.business.merchantprofile.viewmodel;

import android.app.Application;
import android.text.Editable;
import android.text.TextUtils;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.ErrorUtil;
import com.paytm.business.merchantprofile.common.gtm.GAGTMTagAnalytics;
import com.paytm.business.merchantprofile.event.OtpEnteredEvent;
import com.paytm.business.merchantprofile.listener.IEditBasicDetails;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.model.MerchantProfileResponse;
import com.paytm.business.merchantprofile.repo.ProfileRepository;
import com.paytm.business.merchantprofile.view.EditBasicDetailsDialogFragment;
import com.paytm.utility.p;
import org.json.JSONException;
import org.json.JSONObject;

public class EditBasicDetailsViewModel extends c {
    public IEditBasicDetails iEditBasicDetails;
    public w<b<GenerateOtpResponseModel>> mGenerateOtpLiveData;
    public i<String> mInput;
    public i<String> mInputError;
    public i<String> mInputHint;
    public ObservableInt mInputMaxLength;
    public ObservableInt mInputType;
    public i<String> mSubTitle;
    public i<String> mTitle;
    public String mType;
    public String mValue;
    public LiveData<b<MerchantProfileResponse>> responseLiveData;

    public EditBasicDetailsViewModel(Application application) {
        super(application);
    }

    public void initDefaultParams() {
        this.mInputMaxLength = new ObservableInt();
        this.mInputType = new ObservableInt(1);
        this.mInput = new i<>("");
        this.mTitle = new i<>("");
        this.mSubTitle = new i<>("");
        this.mInputHint = new i<>("");
        this.mInputError = new i<>("");
        this.mGenerateOtpLiveData = new w<>();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.paytm.business.merchantprofile.listener.IEditBasicDetails r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r5.iEditBasicDetails = r6
            r5.mType = r7
            r5.mValue = r8
            androidx.databinding.i<java.lang.String> r6 = r5.mInput
            r6.set(r8)
            java.lang.String r6 = r5.mType
            int r7 = r6.hashCode()
            r8 = 5
            r0 = 4
            r1 = 1
            r2 = 3
            r3 = 2
            switch(r7) {
                case -1917971045: goto L_0x0051;
                case -1606931927: goto L_0x0046;
                case -1339964514: goto L_0x003b;
                case 903349891: goto L_0x0030;
                case 1511229046: goto L_0x0025;
                case 1955627957: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x005c
        L_0x001a:
            java.lang.String r7 = "update_primary_mobile"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x005c
            r6 = 2
            goto L_0x005d
        L_0x0025:
            java.lang.String r7 = "update_login_details"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x005c
            r6 = 5
            goto L_0x005d
        L_0x0030:
            java.lang.String r7 = "update_secondary_mobile"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x005c
            r6 = 3
            goto L_0x005d
        L_0x003b:
            java.lang.String r7 = "update_display_name"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x005c
            r6 = 4
            goto L_0x005d
        L_0x0046:
            java.lang.String r7 = "update_primary_email"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x005c
            r6 = 0
            goto L_0x005d
        L_0x0051:
            java.lang.String r7 = "update_secondary_email"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x005c
            r6 = 1
            goto L_0x005d
        L_0x005c:
            r6 = -1
        L_0x005d:
            r7 = 254(0xfe, float:3.56E-43)
            r4 = 32
            if (r6 == 0) goto L_0x0224
            if (r6 == r1) goto L_0x01d7
            r1 = 10
            if (r6 == r3) goto L_0x018a
            if (r6 == r2) goto L_0x013d
            if (r6 == r0) goto L_0x00ec
            if (r6 == r8) goto L_0x0070
            return
        L_0x0070:
            java.lang.String r6 = r5.mValue
            boolean r6 = com.paytm.utility.p.c(r6)
            if (r6 == 0) goto L_0x00b2
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_update_login_email_address
            java.lang.String r8 = r8.getString(r0)
            r6.set(r8)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_update_login_email_sub_title
            java.lang.String r8 = r8.getString(r0)
            r6.set(r8)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_login_email_address
            java.lang.String r8 = r8.getString(r0)
            r6.set(r8)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r6.<init>((int) r4)
            r5.mInputType = r6
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r6.set(r7)
            return
        L_0x00b2:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_update_login_number
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_update_login_mobile_sub_title
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_login_mobile_number
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r6.<init>((int) r2)
            r5.mInputType = r6
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r6.set(r1)
            return
        L_0x00ec:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            java.lang.String r7 = r5.mValue
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0101
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_add_display_name
            java.lang.String r7 = r7.getString(r8)
            goto L_0x010b
        L_0x0101:
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_change_display_name
            java.lang.String r7 = r7.getString(r8)
        L_0x010b:
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_update_display_name_sub_title_new
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_display_name
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r7 = 50
            r6.set(r7)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r7 = 8192(0x2000, float:1.14794E-41)
            r6.<init>((int) r7)
            r5.mInputType = r6
            return
        L_0x013d:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            java.lang.String r7 = r5.mValue
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x0152
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_add_secondary_mobile_number
            java.lang.String r7 = r7.getString(r8)
            goto L_0x015c
        L_0x0152:
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_update_secondary_mobile_number
            java.lang.String r7 = r7.getString(r8)
        L_0x015c:
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_update_notification_mobile_sub_title
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_secondary_mobile_number
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r6.set(r1)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r6.<init>((int) r3)
            r5.mInputType = r6
            return
        L_0x018a:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            java.lang.String r7 = r5.mValue
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x019f
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_add_primary_mobile_number
            java.lang.String r7 = r7.getString(r8)
            goto L_0x01a9
        L_0x019f:
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_update_primary_mobile_number
            java.lang.String r7 = r7.getString(r8)
        L_0x01a9:
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_update_notification_mobile_sub_title
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r7 = r5.getContext()
            int r8 = com.paytm.business.merchantprofile.R.string.pr_lbl_primary_mobile_number
            java.lang.String r7 = r7.getString(r8)
            r6.set(r7)
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r6.set(r1)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r6.<init>((int) r3)
            r5.mInputType = r6
            return
        L_0x01d7:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            java.lang.String r8 = r5.mValue
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x01ec
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_add_secondary_email_address
            java.lang.String r8 = r8.getString(r0)
            goto L_0x01f6
        L_0x01ec:
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_update_secondary_email_address
            java.lang.String r8 = r8.getString(r0)
        L_0x01f6:
            r6.set(r8)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_update_notification_email_sub_title
            java.lang.String r8 = r8.getString(r0)
            r6.set(r8)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_secondary_email_address
            java.lang.String r8 = r8.getString(r0)
            r6.set(r8)
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r6.set(r7)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r6.<init>((int) r4)
            r5.mInputType = r6
            return
        L_0x0224:
            androidx.databinding.i<java.lang.String> r6 = r5.mTitle
            java.lang.String r8 = r5.mValue
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x0239
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_add_primary_email_address
            java.lang.String r8 = r8.getString(r0)
            goto L_0x0243
        L_0x0239:
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_update_primary_email_address
            java.lang.String r8 = r8.getString(r0)
        L_0x0243:
            r6.set(r8)
            androidx.databinding.i<java.lang.String> r6 = r5.mSubTitle
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_update_notification_email_sub_title
            java.lang.String r8 = r8.getString(r0)
            r6.set(r8)
            androidx.databinding.i<java.lang.String> r6 = r5.mInputHint
            android.content.Context r8 = r5.getContext()
            int r0 = com.paytm.business.merchantprofile.R.string.pr_lbl_primary_email_address
            java.lang.String r8 = r8.getString(r0)
            r6.set(r8)
            androidx.databinding.ObservableInt r6 = r5.mInputMaxLength
            r6.set(r7)
            androidx.databinding.ObservableInt r6 = new androidx.databinding.ObservableInt
            r6.<init>((int) r4)
            r5.mInputType = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.viewmodel.EditBasicDetailsViewModel.setData(com.paytm.business.merchantprofile.listener.IEditBasicDetails, java.lang.String, java.lang.String):void");
    }

    public void afterInputChanged(Editable editable) {
        this.mInputError.set("");
    }

    private boolean checkValidityAndNotify() {
        String str;
        String str2 = this.mInput.get();
        String str3 = this.mValue;
        if (str3 == null || !str3.equals(str2)) {
            String str4 = this.mType;
            char c2 = 65535;
            switch (str4.hashCode()) {
                case -1917971045:
                    if (str4.equals("update_secondary_email")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1606931927:
                    if (str4.equals("update_primary_email")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1339964514:
                    if (str4.equals(EditBasicDetailsDialogFragment.TYPE_DISPLAY_NAME)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 903349891:
                    if (str4.equals("update_secondary_mobile")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1511229046:
                    if (str4.equals(EditBasicDetailsDialogFragment.TYPE_LOGIN_DETAILS)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1955627957:
                    if (str4.equals("update_primary_mobile")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                if (!p.c(str2)) {
                    str = getContext().getString(R.string.pr_msg_sign_in_invalid_email);
                }
            } else if (c2 == 2 || c2 == 3) {
                if (!p.d(str2)) {
                    str = getContext().getString(R.string.pr_msg_sign_in_invalid_phone);
                }
            } else if (c2 != 4) {
                if (c2 == 5) {
                    if (p.c(this.mValue)) {
                        if (str2.length() == 0 || !p.c(str2)) {
                            str = getContext().getString(R.string.pr_msg_sign_in_invalid_email);
                        }
                    } else if (!p.d(str2)) {
                        str = getContext().getString(R.string.pr_msg_sign_in_invalid_phone);
                    }
                }
            } else if (str2.length() == 0) {
                str = getContext().getString(R.string.pr_enter_display_name);
            } else if (str2.length() < 2 || str2.length() > 50) {
                str = getContext().getString(R.string.pr_display_name_invalid_text_err);
            } else {
                if (!(!TextUtils.isEmpty(str2) && p.a("^[a-zA-Z0-9\\s]*$", str2))) {
                    str = getContext().getString(R.string.pr_display_name_invalid_text_err);
                }
            }
            str = "";
        } else {
            str = getContext().getString(R.string.pr_no_edit_change_desc);
        }
        this.mInputError.set(str);
        return TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2.trim());
    }

    public void onContinue() {
        if (checkValidityAndNotify()) {
            if (!com.business.common_module.utilities.i.a(ProfileConfig.getInstance().getApplication())) {
                ErrorUtil.handleNoNetworkError(this.mType);
                return;
            }
            this.iEditBasicDetails.showProgressDialog();
            String str = this.mType;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1917971045:
                    if (str.equals("update_secondary_email")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1606931927:
                    if (str.equals("update_primary_email")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1339964514:
                    if (str.equals(EditBasicDetailsDialogFragment.TYPE_DISPLAY_NAME)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 903349891:
                    if (str.equals("update_secondary_mobile")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1511229046:
                    if (str.equals(EditBasicDetailsDialogFragment.TYPE_LOGIN_DETAILS)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1955627957:
                    if (str.equals("update_primary_mobile")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
                this.responseLiveData = ProfileRepository.getInstance().updateMerchantProfileSecondary(getBody(), this.mType);
                this.iEditBasicDetails.setResponseObserver();
            } else if (c2 == 4) {
                GAGTMTagAnalytics.getSingleInstance().sendEvent(getContext(), "Account", "Business Profile", "/business-app/Account /Business Profile/Change Business Name", "Change Business Name");
                this.responseLiveData = ProfileRepository.getInstance().updateMerchantProfileDisplay(getBody(), this.mType);
                this.iEditBasicDetails.setResponseObserver();
            } else if (c2 == 5) {
                generateOtpForEditLoginDetails();
            }
        }
    }

    private String getBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.mType;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1917971045:
                    if (str.equals("update_secondary_email")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1606931927:
                    if (str.equals("update_primary_email")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1339964514:
                    if (str.equals(EditBasicDetailsDialogFragment.TYPE_DISPLAY_NAME)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 903349891:
                    if (str.equals("update_secondary_mobile")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1955627957:
                    if (str.equals("update_primary_mobile")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                jSONObject.put("primaryEmail", this.mInput.get());
                return jSONObject.toString();
            } else if (c2 == 1) {
                jSONObject.put("secondaryEmail", this.mInput.get());
                return jSONObject.toString();
            } else if (c2 == 2) {
                jSONObject.put("primaryMobile", this.mInput.get());
                return jSONObject.toString();
            } else if (c2 != 3) {
                if (c2 == 4) {
                    jSONObject.put("oldDisplayName", this.mValue);
                    jSONObject.put("newDisplayName", this.mInput.get());
                }
                return jSONObject.toString();
            } else {
                jSONObject.put("secondaryPhone", this.mInput.get());
                return jSONObject.toString();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void onClose() {
        this.iEditBasicDetails.dismissDialog();
    }

    public String getUpdatedValue() {
        return this.mInput.get();
    }

    private void generateOtpForEditLoginDetails() {
        LiveData<b<GenerateOtpResponseModel>> generateOtp = ProfileRepository.getInstance().generateOtp(EditBasicDetailsDialogFragment.TYPE_LOGIN_DETAILS, "", false);
        this.mGenerateOtpLiveData.addSource(generateOtp, new z(generateOtp) {
            private final /* synthetic */ LiveData f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                EditBasicDetailsViewModel.this.lambda$generateOtpForEditLoginDetails$0$EditBasicDetailsViewModel(this.f$1, (b) obj);
            }
        });
    }

    public /* synthetic */ void lambda$generateOtpForEditLoginDetails$0$EditBasicDetailsViewModel(LiveData liveData, b bVar) {
        this.mGenerateOtpLiveData.setValue(bVar);
        this.mGenerateOtpLiveData.removeSource(liveData);
    }

    public LiveData<b<GenerateOtpResponseModel>> getGenerateOtpEvent() {
        return this.mGenerateOtpLiveData;
    }

    public void onOtpEnteredByUser(OtpEnteredEvent otpEnteredEvent) {
        if (otpEnteredEvent == null || otpEnteredEvent.getOtpModel() == null || TextUtils.isEmpty(otpEnteredEvent.getOtpModel().getState()) || TextUtils.isEmpty(otpEnteredEvent.getOtp())) {
            LogUtility.e(EditBasicDetailsViewModel.class.getSimpleName(), "OtpEnteredEvent has invalid data");
            return;
        }
        String str = null;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("otp", Integer.parseInt(otpEnteredEvent.getOtp()));
            jSONObject2.put("state", otpEnteredEvent.getOtpModel().getState());
            jSONObject.put("validateOtp", jSONObject2);
            if (p.c(this.mValue)) {
                jSONObject.put(AppConstants.KEY_EMAIL, this.mInput.get().trim());
                jSONObject.put("accountPrimary", "1");
            } else {
                jSONObject.put("mobile", this.mInput.get().trim());
                jSONObject.put("accountPrimary", "0");
            }
            str = jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            this.responseLiveData = ProfileRepository.getInstance().updateMerchantLoginInfo(str, this.mType);
            this.iEditBasicDetails.setResponseObserver();
        }
    }
}
