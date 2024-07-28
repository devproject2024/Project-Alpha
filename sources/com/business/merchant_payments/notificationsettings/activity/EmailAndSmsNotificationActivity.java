package com.business.merchant_payments.notificationsettings.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.merchant_payments.R;
import com.business.merchant_payments.biometrics.PaymentsP4BLockActivity;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.databinding.MpActivityEmailSmsNotificationBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.notificationsettings.BindingUtils;
import com.business.merchant_payments.notificationsettings.CustomDialogUtils;
import com.business.merchant_payments.notificationsettings.adapter.NotificationReceiverListAdapter;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m;
import org.greenrobot.eventbus.c;

public final class EmailAndSmsNotificationActivity extends BaseActivity {
    public HashMap _$_findViewCache;
    public MpActivityEmailSmsNotificationBinding mBinding;
    public NotificationReceiverListAdapter mNotificationAdapter;
    public int mNotificationType = -1;
    public EmailAndSmsNotificationViewModel mViewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[e.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[e.LOADING.ordinal()] = 1;
            $EnumSwitchMapping$0[e.OFFLINE.ordinal()] = 2;
            $EnumSwitchMapping$0[e.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$0[e.FAILURE.ordinal()] = 4;
            $EnumSwitchMapping$0[e.SUCCESS.ordinal()] = 5;
            int[] iArr2 = new int[e.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[e.LOADING.ordinal()] = 1;
            $EnumSwitchMapping$1[e.OFFLINE.ordinal()] = 2;
            $EnumSwitchMapping$1[e.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$1[e.FAILURE.ordinal()] = 4;
            $EnumSwitchMapping$1[e.SUCCESS.ordinal()] = 5;
        }
    }

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

    public final MpActivityEmailSmsNotificationBinding getMBinding() {
        MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding = this.mBinding;
        if (mpActivityEmailSmsNotificationBinding == null) {
            k.a("mBinding");
        }
        return mpActivityEmailSmsNotificationBinding;
    }

    public final void setMBinding(MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding) {
        k.d(mpActivityEmailSmsNotificationBinding, "<set-?>");
        this.mBinding = mpActivityEmailSmsNotificationBinding;
    }

    public final EmailAndSmsNotificationViewModel getMViewModel() {
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        return emailAndSmsNotificationViewModel;
    }

    public final void setMViewModel(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
        k.d(emailAndSmsNotificationViewModel, "<set-?>");
        this.mViewModel = emailAndSmsNotificationViewModel;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBindings();
        initObservers();
    }

    public final void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public final void onStop() {
        super.onStop();
        c.a().b(this);
    }

    private final void initBindings() {
        ViewDataBinding a2 = f.a(this, R.layout.mp_activity_email_sms_notification);
        k.b(a2, "DataBindingUtil.setConte…y_email_sms_notification)");
        MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding = (MpActivityEmailSmsNotificationBinding) a2;
        this.mBinding = mpActivityEmailSmsNotificationBinding;
        if (mpActivityEmailSmsNotificationBinding == null) {
            k.a("mBinding");
        }
        mpActivityEmailSmsNotificationBinding.setLifecycleOwner(this);
        ai a3 = new al(this).a(EmailAndSmsNotificationViewModel.class);
        k.b(a3, "ViewModelProvider(this).…ionViewModel::class.java)");
        this.mViewModel = (EmailAndSmsNotificationViewModel) a3;
        MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding2 = this.mBinding;
        if (mpActivityEmailSmsNotificationBinding2 == null) {
            k.a("mBinding");
        }
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        mpActivityEmailSmsNotificationBinding2.setViewModel(emailAndSmsNotificationViewModel);
        MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding3 = this.mBinding;
        if (mpActivityEmailSmsNotificationBinding3 == null) {
            k.a("mBinding");
        }
        mpActivityEmailSmsNotificationBinding3.setBindingUtils(BindingUtils.Companion);
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
        if (emailAndSmsNotificationViewModel2 == null) {
            k.a("mViewModel");
        }
        this.mNotificationAdapter = new NotificationReceiverListAdapter(emailAndSmsNotificationViewModel2);
        MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding4 = this.mBinding;
        if (mpActivityEmailSmsNotificationBinding4 == null) {
            k.a("mBinding");
        }
        mpActivityEmailSmsNotificationBinding4.setAdapter(this.mNotificationAdapter);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(AppConstants.NOTIFICATION_LIST)) {
            Bundle bundleExtra = getIntent().getBundleExtra(AppConstants.NOTIFICATION_LIST);
            if (bundleExtra.containsKey(AppConstants.NOTIFICATION_SETIINGS) && bundleExtra.containsKey(AppConstants.NOTIFICATION_TYPE)) {
                this.mNotificationType = bundleExtra.getInt(AppConstants.NOTIFICATION_TYPE);
                EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel3 = this.mViewModel;
                if (emailAndSmsNotificationViewModel3 == null) {
                    k.a("mViewModel");
                }
                emailAndSmsNotificationViewModel3.initUiResId(this.mNotificationType);
                Serializable serializable = bundleExtra.getSerializable(AppConstants.NOTIFICATION_SETIINGS);
                if (serializable != null) {
                    ArrayList arrayList = (ArrayList) serializable;
                    EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel4 = this.mViewModel;
                    if (emailAndSmsNotificationViewModel4 == null) {
                        k.a("mViewModel");
                    }
                    emailAndSmsNotificationViewModel4.setNotificationSettings(arrayList);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel> /* = java.util.ArrayList<com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel> */");
            }
        }
    }

    private final void initObservers() {
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        emailAndSmsNotificationViewModel.getMReceiverList().observe(this, new EmailAndSmsNotificationActivity$initObservers$1(this));
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
        if (emailAndSmsNotificationViewModel2 == null) {
            k.a("mViewModel");
        }
        emailAndSmsNotificationViewModel2.getRemoveSecondaryLiveData().observe(this, new EmailAndSmsNotificationActivity$initObservers$2(this));
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel3 = this.mViewModel;
        if (emailAndSmsNotificationViewModel3 == null) {
            k.a("mViewModel");
        }
        emailAndSmsNotificationViewModel3.getUpdateNotificationSettingsLiveData().observe(this, new EmailAndSmsNotificationActivity$initObservers$3(this));
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel4 = this.mViewModel;
        if (emailAndSmsNotificationViewModel4 == null) {
            k.a("mViewModel");
        }
        emailAndSmsNotificationViewModel4.getEVENT().observe(this, new EmailAndSmsNotificationActivity$initObservers$4(this));
    }

    /* access modifiers changed from: private */
    public final void showRefundDeactivateDialog() {
        CustomDialogUtils.Companion companion = CustomDialogUtils.Companion;
        String string = getString(R.string.mp_notification_deactivation_title, new Object[]{getString(R.string.mp_refunds)});
        String string2 = getString(R.string.mp_notification_deactivation_msg);
        k.b(string2, "getString(R.string.mp_no…ication_deactivation_msg)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{getString(getSmsOrEmailString()), getString(R.string.mp_refunds)}, 2));
        k.b(format, "java.lang.String.format(format, *args)");
        String string3 = getString(R.string.mp_deactivate_text);
        k.b(string3, "getString(R.string.mp_deactivate_text)");
        String string4 = getString(R.string.mp_cancel);
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        companion.showCustomActionDialog(this, string, format, string3, string4, false, true, emailAndSmsNotificationViewModel.getGAEventCategory(), "Refund Deactivation Popup Option Selected", new EmailAndSmsNotificationActivity$showRefundDeactivateDialog$1(this), new EmailAndSmsNotificationActivity$showRefundDeactivateDialog$2(this));
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
        if (emailAndSmsNotificationViewModel2 == null) {
            k.a("mViewModel");
        }
        emailAndSmsNotificationViewModel2.sendGAEvent("Refund Deactivation Popup Impression", "");
    }

    /* access modifiers changed from: private */
    public final void showTransactionDeactivateDialog() {
        CustomDialogUtils.Companion companion = CustomDialogUtils.Companion;
        String string = getString(R.string.mp_notification_deactivation_title, new Object[]{getString(R.string.mp_payments)});
        String string2 = getString(R.string.mp_notification_deactivation_msg);
        k.b(string2, "getString(R.string.mp_no…ication_deactivation_msg)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{getString(getSmsOrEmailString()), getString(R.string.mp_payments)}, 2));
        k.b(format, "java.lang.String.format(format, *args)");
        String string3 = getString(R.string.mp_deactivate_text);
        k.b(string3, "getString(R.string.mp_deactivate_text)");
        String string4 = getString(R.string.mp_cancel);
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        companion.showCustomActionDialog(this, string, format, string3, string4, false, true, emailAndSmsNotificationViewModel.getGAEventCategory(), "Payment Deactivation Popup Option Selected", new EmailAndSmsNotificationActivity$showTransactionDeactivateDialog$1(this), new EmailAndSmsNotificationActivity$showTransactionDeactivateDialog$2(this));
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
        if (emailAndSmsNotificationViewModel2 == null) {
            k.a("mViewModel");
        }
        emailAndSmsNotificationViewModel2.sendGAEvent("Payment Deactivation Popup Impression", "");
    }

    private final int getSmsOrEmailString() {
        int i2 = this.mNotificationType;
        if (i2 == 1) {
            return R.string.mp_email;
        }
        if (i2 != 2) {
            return R.string.mp_sms;
        }
        return R.string.mp_sms;
    }

    /* access modifiers changed from: private */
    public final void handleUpdatedSettings(b<NotificationOnOffDataModel> bVar) {
        if (bVar != null) {
            e eVar = bVar.f7357b;
            if (eVar != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[eVar.ordinal()];
                if (i2 == 1) {
                    showProgressDialog();
                    return;
                } else if (i2 == 2) {
                    removeProgressDialog();
                    EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
                    if (emailAndSmsNotificationViewModel == null) {
                        k.a("mViewModel");
                    }
                    emailAndSmsNotificationViewModel.revertSwitchActions();
                    MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding = this.mBinding;
                    if (mpActivityEmailSmsNotificationBinding == null) {
                        k.a("mBinding");
                    }
                    showSnackBar(mpActivityEmailSmsNotificationBinding.getRoot(), getString(R.string.no_internet), (String) null, 0, new EmailAndSmsNotificationActivity$handleUpdatedSettings$$inlined$let$lambda$1(this));
                    return;
                } else if (i2 == 3 || i2 == 4) {
                    removeProgressDialog();
                    EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
                    if (emailAndSmsNotificationViewModel2 == null) {
                        k.a("mViewModel");
                    }
                    emailAndSmsNotificationViewModel2.revertSwitchActions();
                    ErrorUtil.handleInvalidToken(bVar.f7356a);
                    MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding2 = this.mBinding;
                    if (mpActivityEmailSmsNotificationBinding2 == null) {
                        k.a("mBinding");
                    }
                    showSnackBar(mpActivityEmailSmsNotificationBinding2.getRoot(), ErrorUtil.getErrorMessage(bVar.f7356a), (String) null, 0, new EmailAndSmsNotificationActivity$handleUpdatedSettings$$inlined$let$lambda$2(this));
                    return;
                } else if (i2 == 5) {
                    removeProgressDialog();
                    NotificationOnOffDataModel notificationOnOffDataModel = (NotificationOnOffDataModel) bVar.f7358c;
                    if (notificationOnOffDataModel != null) {
                        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel3 = this.mViewModel;
                        if (emailAndSmsNotificationViewModel3 == null) {
                            k.a("mViewModel");
                        }
                        emailAndSmsNotificationViewModel3.updateNotificationSettingsOnResponse(notificationOnOffDataModel);
                        return;
                    }
                    return;
                }
            }
            throw new m();
        }
    }

    /* access modifiers changed from: private */
    public final void removeSecondaryDetailOnSuccess(b<MerchantProfileResponse> bVar) {
        e eVar = bVar.f7357b;
        if (eVar != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[eVar.ordinal()];
            if (i2 == 1) {
                showProgressDialog();
            } else if (i2 == 2) {
                removeProgressDialog();
                MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding = this.mBinding;
                if (mpActivityEmailSmsNotificationBinding == null) {
                    k.a("mBinding");
                }
                showSnackBar(mpActivityEmailSmsNotificationBinding.getRoot(), getString(R.string.no_internet), getString(R.string.retry), 0, new EmailAndSmsNotificationActivity$removeSecondaryDetailOnSuccess$$inlined$let$lambda$1(this));
            } else if (i2 == 3 || i2 == 4) {
                removeProgressDialog();
                ErrorUtil.handleInvalidToken(bVar.f7356a);
                MpActivityEmailSmsNotificationBinding mpActivityEmailSmsNotificationBinding2 = this.mBinding;
                if (mpActivityEmailSmsNotificationBinding2 == null) {
                    k.a("mBinding");
                }
                showSnackBar(mpActivityEmailSmsNotificationBinding2.getRoot(), ErrorUtil.getErrorMessage(bVar.f7356a), getString(R.string.retry), 0, new EmailAndSmsNotificationActivity$removeSecondaryDetailOnSuccess$$inlined$let$lambda$2(this));
            } else if (i2 == 5) {
                T t = bVar.f7358c;
                if (t != null) {
                    k.a((Object) t);
                    if (((MerchantProfileResponse) t).getStatus() != null) {
                        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
                        if (emailAndSmsNotificationViewModel == null) {
                            k.a("mViewModel");
                        }
                        emailAndSmsNotificationViewModel.updateReceiverRemovalDetails(bVar);
                        Toast.makeText(this, getResources().getString(R.string.mp_details_updated_successfully), 0).show();
                    }
                }
                removeProgressDialog();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void launchP4BLockScreen() {
        Intent intent = new Intent(this, PaymentsP4BLockActivity.class);
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        startActivityForResult(intent, emailAndSmsNotificationViewModel.getRequestCode());
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 100) {
            addSecondaryMobile();
        } else if (i2 == 102) {
            addSecondaryEmail();
        } else if (i2 == 234 && intent != null) {
            handleSecondaryDetailsAddition(intent);
        }
    }

    private final void handleSecondaryDetailsAddition(Intent intent) {
        String stringExtra = intent.getStringExtra("type");
        String stringExtra2 = intent.getStringExtra(AppConstants.NOTIFICATION_DETAILS.UPDATED_VALUE);
        if (stringExtra2 != null && stringExtra != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != -1917971045) {
                if (hashCode != -1606931927) {
                    if (hashCode != -908748295) {
                        if (hashCode == 903349891 && stringExtra.equals("update_secondary_mobile")) {
                            EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
                            if (emailAndSmsNotificationViewModel == null) {
                                k.a("mViewModel");
                            }
                            emailAndSmsNotificationViewModel.addReceiver(stringExtra2, 3);
                            NotificationReceiverListAdapter notificationReceiverListAdapter = this.mNotificationAdapter;
                            if (notificationReceiverListAdapter != null) {
                                notificationReceiverListAdapter.addReceiverToList();
                            }
                        }
                    } else if (stringExtra.equals(AppConstants.NOTIFICATION_DETAILS.ADD_ADDITIONAL_CONTACT)) {
                        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
                        if (emailAndSmsNotificationViewModel2 == null) {
                            k.a("mViewModel");
                        }
                        emailAndSmsNotificationViewModel2.addReceiver(stringExtra2, 5);
                        NotificationReceiverListAdapter notificationReceiverListAdapter2 = this.mNotificationAdapter;
                        if (notificationReceiverListAdapter2 != null) {
                            notificationReceiverListAdapter2.addReceiverToList();
                        }
                    }
                } else if (stringExtra.equals("update_primary_email")) {
                    EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel3 = this.mViewModel;
                    if (emailAndSmsNotificationViewModel3 == null) {
                        k.a("mViewModel");
                    }
                    emailAndSmsNotificationViewModel3.addReceiver(stringExtra2, 1);
                    NotificationReceiverListAdapter notificationReceiverListAdapter3 = this.mNotificationAdapter;
                    if (notificationReceiverListAdapter3 != null) {
                        notificationReceiverListAdapter3.addPrimaryReceiver();
                    }
                }
            } else if (stringExtra.equals("update_secondary_email")) {
                EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel4 = this.mViewModel;
                if (emailAndSmsNotificationViewModel4 == null) {
                    k.a("mViewModel");
                }
                emailAndSmsNotificationViewModel4.addReceiver(stringExtra2, 4);
                NotificationReceiverListAdapter notificationReceiverListAdapter4 = this.mNotificationAdapter;
                if (notificationReceiverListAdapter4 != null) {
                    notificationReceiverListAdapter4.addReceiverToList();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addSecondaryEmail() {
        /*
            r6 = this;
            com.business.merchant_payments.gtm.GAGTMTagAnalytics r0 = com.business.merchant_payments.gtm.GAGTMTagAnalytics.getSingleInstance()
            java.lang.String r2 = "Accept Payment"
            java.lang.String r3 = "Add-Change notification settings"
            java.lang.String r4 = ""
            java.lang.String r5 = "Add another email"
            r1 = r6
            r0.sendEvent(r1, r2, r3, r4, r5)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.business.merchant_payments.notificationsettings.activity.AddMobileActivity> r1 = com.business.merchant_payments.notificationsettings.activity.AddMobileActivity.class
            r0.<init>(r6, r1)
            com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel r1 = r6.mViewModel
            java.lang.String r2 = "mViewModel"
            if (r1 != 0) goto L_0x0020
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0020:
            boolean r1 = r1.isPrimaryEmailAdded()
            java.lang.String r3 = "type"
            if (r1 != 0) goto L_0x0041
            com.business.merchant_payments.PaymentsConfig r1 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r4 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r1, r4)
            com.business.common_module.b.i r1 = r1.getMerchantDataProvider()
            boolean r1 = r1.j()
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = "update_primary_email"
            r0.putExtra(r3, r1)
            goto L_0x0046
        L_0x0041:
            java.lang.String r1 = "update_secondary_email"
            r0.putExtra(r3, r1)
        L_0x0046:
            com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel r1 = r6.mViewModel
            if (r1 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x004d:
            java.lang.String r1 = r1.getAddedEmail()
            if (r1 == 0) goto L_0x0058
            java.lang.String r2 = "primary_email_text"
            r0.putExtra(r2, r1)
        L_0x0058:
            r1 = 234(0xea, float:3.28E-43)
            r6.startActivityForResult(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.activity.EmailAndSmsNotificationActivity.addSecondaryEmail():void");
    }

    private final void addSecondaryMobile() {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this, "Accept Payment", "Add-Change notification settings", "", "Add another Mobile number");
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        Map<String, String> secondaryNumbersIntentData = emailAndSmsNotificationViewModel.getSecondaryNumbersIntentData();
        Intent intent = new Intent(this, AddMobileActivity.class);
        for (Map.Entry next : secondaryNumbersIntentData.entrySet()) {
            intent.putExtra((String) next.getKey(), (String) next.getValue());
        }
        startActivityForResult(intent, 234);
    }

    public final void onBackPressed() {
        EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel = this.mViewModel;
        if (emailAndSmsNotificationViewModel == null) {
            k.a("mViewModel");
        }
        if (emailAndSmsNotificationViewModel.isNotificationSettingsUpdated()) {
            EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel2 = this.mViewModel;
            if (emailAndSmsNotificationViewModel2 == null) {
                k.a("mViewModel");
            }
            ArrayList<NotificationReceiverModel> updatedSettings = emailAndSmsNotificationViewModel2.getUpdatedSettings();
            if (updatedSettings != null) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable(AppConstants.NOTIFICATION_SETIINGS, updatedSettings);
                intent.putExtra(AppConstants.NOTIFICATION_LIST, bundle);
                setResult(-1, intent);
                finish();
                return;
            }
            finish();
            return;
        }
        super.onBackPressed();
    }
}
