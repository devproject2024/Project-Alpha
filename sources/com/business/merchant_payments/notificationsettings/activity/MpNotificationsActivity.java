package com.business.merchant_payments.notificationsettings.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.databinding.MpActivityNotificationBinding;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.notificationsettings.CustomDialogUtils;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import com.business.merchant_payments.notificationsettings.model.NotificationsSettingsDataModel;
import com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider;
import com.paytm.business.c.a.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;

public final class MpNotificationsActivity extends BaseActivity {
    public final int ADD_EMAIL_REQUEST_CODE = 1001;
    public final int EMAIL_SETTINGS_REQUEST_CODE = 1003;
    public String FROM_SCREEN = "";
    public final int SMS_SETTINGS_REQUEST_CODE = 1002;
    public HashMap _$_findViewCache;
    public MpActivityNotificationBinding mBinding;
    public String mToBeHighlightedSection = "";
    public a mViewModel;
    public View mViewToBeHighLighted;

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

    public static final /* synthetic */ MpActivityNotificationBinding access$getMBinding$p(MpNotificationsActivity mpNotificationsActivity) {
        MpActivityNotificationBinding mpActivityNotificationBinding = mpNotificationsActivity.mBinding;
        if (mpActivityNotificationBinding == null) {
            k.a("mBinding");
        }
        return mpActivityNotificationBinding;
    }

    public static final /* synthetic */ a access$getMViewModel$p(MpNotificationsActivity mpNotificationsActivity) {
        a aVar = mpNotificationsActivity.mViewModel;
        if (aVar == null) {
            k.a("mViewModel");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initBindings();
        initObservers();
        loadNotificationSettings();
    }

    public final void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    public final void loadNotificationSettings() {
        if (i.a(getApplication())) {
            a aVar = this.mViewModel;
            if (aVar == null) {
                k.a("mViewModel");
            }
            aVar.a().setValue(Boolean.TRUE);
            return;
        }
        MpActivityNotificationBinding mpActivityNotificationBinding = this.mBinding;
        if (mpActivityNotificationBinding == null) {
            k.a("mBinding");
        }
        showSnackBar(mpActivityNotificationBinding.getRoot(), getString(R.string.no_internet), getString(R.string.retry), -2, new MpNotificationsActivity$loadNotificationSettings$1(this));
    }

    private final void initObservers() {
        a aVar = this.mViewModel;
        if (aVar == null) {
            k.a("mViewModel");
        }
        aVar.n.observe(this, new MpNotificationsActivity$initObservers$1(this));
        a aVar2 = this.mViewModel;
        if (aVar2 == null) {
            k.a("mViewModel");
        }
        aVar2.o.observe(this, new MpNotificationsActivity$initObservers$2(this));
        a aVar3 = this.mViewModel;
        if (aVar3 == null) {
            k.a("mViewModel");
        }
        aVar3.b().observe(this, new MpNotificationsActivity$initObservers$3(this));
    }

    /* access modifiers changed from: private */
    public final void showEmailDeactivationDialog() {
        CustomDialogUtils.Companion companion = CustomDialogUtils.Companion;
        String string = getString(R.string.mp_notification_deactivation_title, new Object[]{getString(R.string.mp_email)});
        String string2 = getString(R.string.mp_notification_deactivation_msg);
        k.b(string2, "getString(R.string.mp_no…ication_deactivation_msg)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{getString(R.string.mp_email), getString(R.string.mp_payment_refunds)}, 2));
        k.b(format, "java.lang.String.format(format, *args)");
        String string3 = getString(R.string.mp_deactivate_text);
        k.b(string3, "getString(R.string.mp_deactivate_text)");
        companion.showCustomActionDialog(this, string, format, string3, getString(R.string.mp_cancel), false, true, "Email Deactivation Popup Option Selected", "Notifications", new MpNotificationsActivity$showEmailDeactivationDialog$1(this), new MpNotificationsActivity$showEmailDeactivationDialog$2(this));
        GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        singleInstance.sendEvent(instance.getAppContext(), "Notifications", "Email Deactivation Popup Impression", "", "");
    }

    /* access modifiers changed from: private */
    public final void showSmsDeactivationDialog() {
        CustomDialogUtils.Companion companion = CustomDialogUtils.Companion;
        String string = getString(R.string.mp_notification_deactivation_title, new Object[]{getString(R.string.mp_sms)});
        String string2 = getString(R.string.mp_notification_deactivation_msg);
        k.b(string2, "getString(R.string.mp_no…ication_deactivation_msg)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{getString(R.string.mp_sms), getString(R.string.mp_payment_refunds)}, 2));
        k.b(format, "java.lang.String.format(format, *args)");
        String string3 = getString(R.string.mp_deactivate_text);
        k.b(string3, "getString(R.string.mp_deactivate_text)");
        companion.showCustomActionDialog(this, string, format, string3, getString(R.string.mp_cancel), false, true, "SMS Deactivation Popup Option Selected", "Notifications", new MpNotificationsActivity$showSmsDeactivationDialog$1(this), new MpNotificationsActivity$showSmsDeactivationDialog$2(this));
        GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        singleInstance.sendEvent(instance.getAppContext(), "Notifications", "SMS Deactivation Popup Impression", "", "");
    }

    public final void onStart() {
        super.onStart();
    }

    public final void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: private */
    public final void handleUpdatedSettings(b<NotificationOnOffDataModel> bVar) {
        e eVar;
        b<NotificationOnOffDataModel> bVar2 = bVar;
        if (bVar2 != null && (eVar = bVar2.f7357b) != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[eVar.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                showProgressDialog();
            } else if (i2 == 2) {
                removeProgressDialog();
                a aVar = this.mViewModel;
                if (aVar == null) {
                    k.a("mViewModel");
                }
                aVar.j();
                MpActivityNotificationBinding mpActivityNotificationBinding = this.mBinding;
                if (mpActivityNotificationBinding == null) {
                    k.a("mBinding");
                }
                showSnackBar(mpActivityNotificationBinding.getRoot(), getString(R.string.no_internet), (String) null, 0, new MpNotificationsActivity$handleUpdatedSettings$$inlined$let$lambda$1(this));
            } else if (i2 == 3 || i2 == 4) {
                removeProgressDialog();
                a aVar2 = this.mViewModel;
                if (aVar2 == null) {
                    k.a("mViewModel");
                }
                aVar2.j();
                ErrorUtil.handleInvalidToken(bVar2.f7356a);
                MpActivityNotificationBinding mpActivityNotificationBinding2 = this.mBinding;
                if (mpActivityNotificationBinding2 == null) {
                    k.a("mBinding");
                }
                showSnackBar(mpActivityNotificationBinding2.getRoot(), ErrorUtil.getErrorMessage(bVar2.f7356a), (String) null, 0, new MpNotificationsActivity$handleUpdatedSettings$$inlined$let$lambda$2(this));
            } else if (i2 == 5) {
                removeProgressDialog();
                NotificationOnOffDataModel notificationOnOffDataModel = (NotificationOnOffDataModel) bVar2.f7358c;
                if (notificationOnOffDataModel != null) {
                    a aVar3 = this.mViewModel;
                    if (aVar3 == null) {
                        k.a("mViewModel");
                    }
                    k.d(notificationOnOffDataModel, "settings");
                    NotificationSettingsDataProvider.INSTANCE.setNotificationSettings(notificationOnOffDataModel);
                    aVar3.d().setValue(Boolean.valueOf(notificationOnOffDataModel.getTransaction().getEmailAllowed() || notificationOnOffDataModel.getRefund().getEmailAllowed()));
                    y<Boolean> c2 = aVar3.c();
                    if (!notificationOnOffDataModel.getTransaction().getSmsAllowed() && !notificationOnOffDataModel.getRefund().getSmsAllowed()) {
                        z = false;
                    }
                    c2.setValue(Boolean.valueOf(z));
                    GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                    PaymentsConfig instance = PaymentsConfig.getInstance();
                    k.b(instance, "PaymentsConfig.getInstance()");
                    singleInstance.sendEvent(instance.getAppContext(), "Notifications", "Email Alert Toggled", "", k.a((Object) aVar3.d().getValue(), (Object) Boolean.TRUE) ? "On" : "Off");
                    GAGTMTagAnalytics singleInstance2 = GAGTMTagAnalytics.getSingleInstance();
                    PaymentsConfig instance2 = PaymentsConfig.getInstance();
                    k.b(instance2, "PaymentsConfig.getInstance()");
                    singleInstance2.sendEvent(instance2.getAppContext(), "Notifications", "SMS Alert Toggled", "", k.a((Object) aVar3.c().getValue(), (Object) Boolean.TRUE) ? "On" : "Off");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setNotificationSettings(b<NotificationsSettingsDataModel> bVar) {
        e eVar;
        String str;
        b<NotificationsSettingsDataModel> bVar2 = bVar;
        if (bVar2 != null && (eVar = bVar2.f7357b) != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[eVar.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                showProgressDialog();
            } else if (i2 == 2) {
                removeProgressDialog();
                if (this.mViewModel == null) {
                    k.a("mViewModel");
                }
                a.h();
                MpActivityNotificationBinding mpActivityNotificationBinding = this.mBinding;
                if (mpActivityNotificationBinding == null) {
                    k.a("mBinding");
                }
                showSnackBar(mpActivityNotificationBinding.getRoot(), getString(R.string.no_internet), getString(R.string.retry), -2, new MpNotificationsActivity$setNotificationSettings$$inlined$let$lambda$1(this));
            } else if (i2 == 3 || i2 == 4) {
                removeProgressDialog();
                if (this.mViewModel == null) {
                    k.a("mViewModel");
                }
                a.h();
                ErrorUtil.handleInvalidToken(bVar2.f7356a);
                MpActivityNotificationBinding mpActivityNotificationBinding2 = this.mBinding;
                if (mpActivityNotificationBinding2 == null) {
                    k.a("mBinding");
                }
                showSnackBar(mpActivityNotificationBinding2.getRoot(), ErrorUtil.getErrorMessage(bVar2.f7356a), getString(R.string.retry), -2, new MpNotificationsActivity$setNotificationSettings$$inlined$let$lambda$2(this));
            } else if (i2 == 5) {
                removeProgressDialog();
                NotificationsSettingsDataModel notificationsSettingsDataModel = (NotificationsSettingsDataModel) bVar2.f7358c;
                if (notificationsSettingsDataModel != null) {
                    a aVar = this.mViewModel;
                    if (aVar == null) {
                        k.a("mViewModel");
                    }
                    k.d(notificationsSettingsDataModel, "notificationsSettingsDataModel");
                    NotificationSettingsDataProvider.INSTANCE.setNotificationSettings(notificationsSettingsDataModel.getNotifications());
                    ArrayList<NotificationReceiverModel> arrayList = new ArrayList<>();
                    String primaryMobile = notificationsSettingsDataModel.getReceiverInfo().getPrimaryMobile();
                    String secondaryMobile = notificationsSettingsDataModel.getReceiverInfo().getSecondaryMobile();
                    String additionalMobile = notificationsSettingsDataModel.getReceiverInfo().getAdditionalMobile();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList.add(new NotificationReceiverModel(primaryMobile, 2));
                    if (!TextUtils.isEmpty(secondaryMobile)) {
                        primaryMobile = primaryMobile + ", " + secondaryMobile;
                        arrayList.add(new NotificationReceiverModel(secondaryMobile, 3));
                    }
                    if (!TextUtils.isEmpty(additionalMobile)) {
                        for (String str2 : p.b((CharSequence) additionalMobile, new String[]{AppConstants.COMMA})) {
                            arrayList2.add(str2);
                            arrayList.add(new NotificationReceiverModel(str2, 5));
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(primaryMobile);
                        sb.append("  ");
                        PaymentsConfig instance = PaymentsConfig.getInstance();
                        k.b(instance, "PaymentsConfig.getInstance()");
                        Context appContext = instance.getAppContext();
                        k.b(appContext, "PaymentsConfig.getInstance().appContext");
                        sb.append(appContext.getResources().getString(R.string.mp_and_more, new Object[]{Integer.valueOf(arrayList2.size())}));
                        primaryMobile = sb.toString();
                    }
                    aVar.e().setValue(primaryMobile);
                    aVar.c().setValue(Boolean.valueOf(notificationsSettingsDataModel.getNotifications().getTransaction().getSmsAllowed() || notificationsSettingsDataModel.getNotifications().getRefund().getSmsAllowed()));
                    GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
                    PaymentsConfig instance2 = PaymentsConfig.getInstance();
                    k.b(instance2, "PaymentsConfig.getInstance()");
                    singleInstance.sendEvent(instance2.getAppContext(), "Notifications", "SMS Alert Impression", "", k.a((Object) aVar.c().getValue(), (Object) Boolean.TRUE) ? "On" : "Off");
                    aVar.q = arrayList;
                    ArrayList<NotificationReceiverModel> arrayList3 = new ArrayList<>();
                    String primaryEmail = notificationsSettingsDataModel.getReceiverInfo().getPrimaryEmail();
                    String secondaryEmail = notificationsSettingsDataModel.getReceiverInfo().getSecondaryEmail();
                    String str3 = "";
                    if (!TextUtils.isEmpty(primaryEmail)) {
                        str3 = str3 + primaryEmail;
                        arrayList3.add(new NotificationReceiverModel(primaryEmail, 1));
                    }
                    if (!TextUtils.isEmpty(secondaryEmail)) {
                        if (str.length() > 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append("  ");
                            PaymentsConfig instance3 = PaymentsConfig.getInstance();
                            k.b(instance3, "PaymentsConfig.getInstance()");
                            Context appContext2 = instance3.getAppContext();
                            k.b(appContext2, "PaymentsConfig.getInstance().appContext");
                            sb2.append(appContext2.getResources().getString(R.string.mp_and_more, new Object[]{1}));
                            str = sb2.toString();
                        } else {
                            str = secondaryEmail;
                        }
                        arrayList3.add(new NotificationReceiverModel(secondaryEmail, 4));
                    }
                    if (str.length() > 0) {
                        aVar.f().setValue(str);
                    }
                    y<Boolean> d2 = aVar.d();
                    if (!notificationsSettingsDataModel.getNotifications().getTransaction().getEmailAllowed() && !notificationsSettingsDataModel.getNotifications().getRefund().getEmailAllowed()) {
                        z = false;
                    }
                    d2.setValue(Boolean.valueOf(z));
                    GAGTMTagAnalytics singleInstance2 = GAGTMTagAnalytics.getSingleInstance();
                    PaymentsConfig instance4 = PaymentsConfig.getInstance();
                    k.b(instance4, "PaymentsConfig.getInstance()");
                    singleInstance2.sendEvent(instance4.getAppContext(), "Notifications", "Email Alert Impression", "", k.a((Object) aVar.d().getValue(), (Object) Boolean.TRUE) ? "On" : "Off");
                    aVar.p = arrayList3;
                }
            }
        }
    }

    private final void initBindings() {
        ViewDataBinding a2 = f.a(this, R.layout.mp_activity_notification);
        k.b(a2, "DataBindingUtil.setConte…mp_activity_notification)");
        MpActivityNotificationBinding mpActivityNotificationBinding = (MpActivityNotificationBinding) a2;
        this.mBinding = mpActivityNotificationBinding;
        if (mpActivityNotificationBinding == null) {
            k.a("mBinding");
        }
        mpActivityNotificationBinding.setLifecycleOwner(this);
        ai a3 = new al(this).a(a.class);
        k.b(a3, "ViewModelProvider(this).…ionViewModel::class.java)");
        this.mViewModel = (a) a3;
        MpActivityNotificationBinding mpActivityNotificationBinding2 = this.mBinding;
        if (mpActivityNotificationBinding2 == null) {
            k.a("mBinding");
        }
        a aVar = this.mViewModel;
        if (aVar == null) {
            k.a("mViewModel");
        }
        mpActivityNotificationBinding2.setViewmodel(aVar);
        if (getIntent().hasExtra("from")) {
            String stringExtra = getIntent().getStringExtra("from");
            k.b(stringExtra, "intent.getStringExtra(Ap…OTIFICATION_DETAILS.FROM)");
            this.FROM_SCREEN = stringExtra;
        }
    }

    public final void onBackPressed() {
        if (p.a(AppConstants.NOTIFICATION_DETAILS.BUSINESS_DETAILS, this.FROM_SCREEN, true)) {
            Intent intent = new Intent();
            a aVar = this.mViewModel;
            if (aVar == null) {
                k.a("mViewModel");
            }
            intent.putExtra("update_secondary_mobile", aVar.i());
            a aVar2 = this.mViewModel;
            if (aVar2 == null) {
                k.a("mViewModel");
            }
            String str = "";
            intent.putExtra("update_secondary_email", aVar2.p.size() > 1 ? aVar2.p.get(1).getReceiverString() : str);
            a aVar3 = this.mViewModel;
            if (aVar3 == null) {
                k.a("mViewModel");
            }
            if (true ^ aVar3.p.isEmpty()) {
                str = aVar3.p.get(0).getReceiverString();
            }
            intent.putExtra("update_primary_email", str);
            setResult(-1, intent);
            finish();
            return;
        }
        super.onBackPressed();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == this.ADD_EMAIL_REQUEST_CODE) {
            addEmailId();
        } else if (i2 == 1101) {
            if (intent != null) {
                onPrimaryEmailAdded(intent, 1);
            }
        } else if (i2 == 1102) {
            if (intent != null) {
                onPrimaryEmailAdded(intent, 4);
            }
        } else if (i2 == this.SMS_SETTINGS_REQUEST_CODE) {
            if (intent != null) {
                onSmsSettingsChanged(intent);
            }
        } else if (i2 == this.EMAIL_SETTINGS_REQUEST_CODE && intent != null) {
            onEmailSettingsChanged(intent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r4 = r1.getTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onEmailSettingsChanged(android.content.Intent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "NOTIFICATION_LIST"
            boolean r1 = r8.hasExtra(r0)
            if (r1 == 0) goto L_0x00db
            android.os.Bundle r8 = r8.getBundleExtra(r0)
            java.lang.String r0 = "NOTIFICATION_SETIINGS"
            boolean r1 = r8.containsKey(r0)
            if (r1 == 0) goto L_0x00db
            java.io.Serializable r8 = r8.getSerializable(r0)
            if (r8 == 0) goto L_0x00d3
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            com.paytm.business.c.a.a r0 = r7.mViewModel
            if (r0 != 0) goto L_0x0025
            java.lang.String r1 = "mViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0025:
            java.lang.String r1 = "emailReceiverList"
            kotlin.g.b.k.d(r8, r1)
            r0.p = r8
            com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider r1 = com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider.INSTANCE
            com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel r1 = r1.getNotificationSettings()
            androidx.lifecycle.y r2 = r0.d()
            r3 = 0
            if (r1 == 0) goto L_0x0044
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r4 = r1.getTransaction()
            if (r4 == 0) goto L_0x0044
            boolean r4 = r4.getEmailAllowed()
            goto L_0x0045
        L_0x0044:
            r4 = 0
        L_0x0045:
            r5 = 1
            if (r4 != 0) goto L_0x005a
            if (r1 == 0) goto L_0x0055
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r1 = r1.getRefund()
            if (r1 == 0) goto L_0x0055
            boolean r1 = r1.getEmailAllowed()
            goto L_0x0056
        L_0x0055:
            r1 = 0
        L_0x0056:
            if (r1 != 0) goto L_0x005a
            r1 = 0
            goto L_0x005b
        L_0x005a:
            r1 = 1
        L_0x005b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.setValue(r1)
            boolean r1 = r8.isEmpty()
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x00c9
            int r1 = r8.size()
            if (r1 <= r5) goto L_0x00b7
            androidx.lifecycle.y r0 = r0.f()
            java.lang.Object r8 = r8.get(r3)
            com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel r8 = (com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel) r8
            java.lang.String r8 = r8.getReceiverString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " "
            r1.<init>(r2)
            com.business.merchant_payments.PaymentsConfig r2 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r4 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r2, r4)
            android.content.Context r2 = r2.getAppContext()
            java.lang.String r4 = "PaymentsConfig.getInstance().appContext"
            kotlin.g.b.k.b(r2, r4)
            android.content.res.Resources r2 = r2.getResources()
            int r4 = com.business.merchant_payments.R.string.mp_and_more
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6[r3] = r5
            java.lang.String r2 = r2.getString(r4, r6)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r8 = kotlin.g.b.k.a((java.lang.String) r8, (java.lang.Object) r1)
            r0.setValue(r8)
            return
        L_0x00b7:
            androidx.lifecycle.y r0 = r0.f()
            java.lang.Object r8 = r8.get(r3)
            com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel r8 = (com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel) r8
            java.lang.String r8 = r8.getReceiverString()
            r0.setValue(r8)
            return
        L_0x00c9:
            androidx.lifecycle.y r8 = r0.f()
            java.lang.String r0 = ""
            r8.setValue(r0)
            return
        L_0x00d3:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.ArrayList<com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel> /* = java.util.ArrayList<com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel> */"
            r8.<init>(r0)
            throw r8
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.activity.MpNotificationsActivity.onEmailSettingsChanged(android.content.Intent):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        r4 = r1.getTransaction();
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onSmsSettingsChanged(android.content.Intent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "NOTIFICATION_LIST"
            boolean r1 = r9.hasExtra(r0)
            if (r1 == 0) goto L_0x00f2
            android.os.Bundle r9 = r9.getBundleExtra(r0)
            java.lang.String r0 = "NOTIFICATION_SETIINGS"
            boolean r1 = r9.containsKey(r0)
            if (r1 == 0) goto L_0x00f2
            java.io.Serializable r9 = r9.getSerializable(r0)
            if (r9 == 0) goto L_0x00ea
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            com.paytm.business.c.a.a r0 = r8.mViewModel
            if (r0 != 0) goto L_0x0025
            java.lang.String r1 = "mViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0025:
            java.lang.String r1 = "smsReceiverList"
            kotlin.g.b.k.d(r9, r1)
            r0.q = r9
            com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider r1 = com.business.merchant_payments.notificationsettings.repository.NotificationSettingsDataProvider.INSTANCE
            com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel r1 = r1.getNotificationSettings()
            androidx.lifecycle.y r2 = r0.c()
            r3 = 0
            if (r1 == 0) goto L_0x0045
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r4 = r1.getTransaction()
            if (r4 == 0) goto L_0x0045
            boolean r4 = r4.getSmsAllowed()
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            r5 = 1
            if (r4 != 0) goto L_0x005b
            if (r1 == 0) goto L_0x0056
            com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel r1 = r1.getRefund()
            if (r1 == 0) goto L_0x0056
            boolean r1 = r1.getSmsAllowed()
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            if (r1 != 0) goto L_0x005b
            r1 = 0
            goto L_0x005c
        L_0x005b:
            r1 = 1
        L_0x005c:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.setValue(r1)
            java.lang.Object r1 = r9.get(r3)
            com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel r1 = (com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel) r1
            java.lang.String r1 = r1.getReceiverString()
            int r2 = r9.size()
            java.lang.String r4 = ", "
            r6 = 2
            if (r2 <= r6) goto L_0x00c2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            java.lang.Object r4 = r9.get(r5)
            com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel r4 = (com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel) r4
            java.lang.String r4 = r4.getReceiverString()
            r2.append(r4)
            r4 = 32
            r2.append(r4)
            com.business.merchant_payments.PaymentsConfig r4 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r7 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r4, r7)
            android.content.Context r4 = r4.getAppContext()
            java.lang.String r7 = "PaymentsConfig.getInstance().appContext"
            kotlin.g.b.k.b(r4, r7)
            android.content.res.Resources r4 = r4.getResources()
            int r7 = com.business.merchant_payments.R.string.mp_and_more
            java.lang.Object[] r5 = new java.lang.Object[r5]
            int r9 = r9.size()
            int r9 = r9 - r6
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r5[r3] = r9
            java.lang.String r9 = r4.getString(r7, r5)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r9)
            goto L_0x00e2
        L_0x00c2:
            int r2 = r9.size()
            if (r2 <= r5) goto L_0x00e2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            java.lang.Object r9 = r9.get(r5)
            com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel r9 = (com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel) r9
            java.lang.String r9 = r9.getReceiverString()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r9)
        L_0x00e2:
            androidx.lifecycle.y r9 = r0.e()
            r9.setValue(r1)
            return
        L_0x00ea:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.ArrayList<com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel> /* = java.util.ArrayList<com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel> */"
            r9.<init>(r0)
            throw r9
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.notificationsettings.activity.MpNotificationsActivity.onSmsSettingsChanged(android.content.Intent):void");
    }

    private final void onPrimaryEmailAdded(Intent intent, int i2) {
        String stringExtra = intent.getStringExtra(AppConstants.NOTIFICATION_DETAILS.UPDATED_VALUE);
        a aVar = this.mViewModel;
        if (aVar == null) {
            k.a("mViewModel");
        }
        k.b(stringExtra, "updatedValue");
        k.d(stringExtra, "primaryEmail");
        aVar.f().setValue(stringExtra);
        aVar.p.add(new NotificationReceiverModel(stringExtra, i2));
    }

    private final void addEmailId() {
        Intent intent = new Intent(this, AddMobileActivity.class);
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (instance.getMerchantDataProvider().j()) {
            intent.putExtra("type", "update_primary_email");
            startActivityForResult(intent, AppConstants.REQUEST_CODE.ADD_PRIMARY_EMAIL);
            return;
        }
        intent.putExtra("type", "update_secondary_email");
        startActivityForResult(intent, AppConstants.REQUEST_CODE.ADD_SECONDARY_EMAIL);
    }

    private final void highlightParticularSection() {
        if (this.mToBeHighlightedSection.length() > 0) {
            String str = this.mToBeHighlightedSection;
            if (k.a((Object) str, (Object) "add_another_mobile")) {
                MpActivityNotificationBinding mpActivityNotificationBinding = this.mBinding;
                if (mpActivityNotificationBinding == null) {
                    k.a("mBinding");
                }
                this.mViewToBeHighLighted = mpActivityNotificationBinding.smsSettingsOverlay;
            } else if (k.a((Object) str, (Object) "add_another_email")) {
                MpActivityNotificationBinding mpActivityNotificationBinding2 = this.mBinding;
                if (mpActivityNotificationBinding2 == null) {
                    k.a("mBinding");
                }
                this.mViewToBeHighLighted = mpActivityNotificationBinding2.emailSettingsOverlay;
            } else if (k.a((Object) str, (Object) "notification_settings") || k.a((Object) str, (Object) "notification-settings")) {
                MpActivityNotificationBinding mpActivityNotificationBinding3 = this.mBinding;
                if (mpActivityNotificationBinding3 == null) {
                    k.a("mBinding");
                }
                this.mViewToBeHighLighted = mpActivityNotificationBinding3.notificationSettingsOverlay;
            }
            if (this.mViewToBeHighLighted != null) {
                new Handler().postDelayed(new MpNotificationsActivity$highlightParticularSection$1(this), 1000);
            }
        }
    }
}
