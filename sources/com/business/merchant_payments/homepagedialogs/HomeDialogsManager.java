package com.business.merchant_payments.homepagedialogs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.business.common_module.b.e;
import com.business.common_module.utilities.a;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.business.merchant_payments.whatsappconsent.UpsUtility;
import com.business.merchant_payments.whatsappconsent.WhatsAppConsentBottomSheetFragment;
import com.google.gson.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import net.one97.paytm.acceptPayment.model.GrowBusinessDialogPreferences;

public final class HomeDialogsManager implements p {
    public final WeakReference<FragmentActivity> activity;
    public final f gson = new f();
    public k lifecycle;

    public HomeDialogsManager(k kVar, WeakReference<FragmentActivity> weakReference) {
        kotlin.g.b.k.d(weakReference, "activity");
        this.lifecycle = kVar;
        this.activity = weakReference;
        k kVar2 = this.lifecycle;
        if (kVar2 != null) {
            kVar2.a(this);
        }
    }

    public final WeakReference<FragmentActivity> getActivity() {
        return this.activity;
    }

    public final k getLifecycle() {
        return this.lifecycle;
    }

    public final void setLifecycle(k kVar) {
        this.lifecycle = kVar;
    }

    public final f getGson() {
        return this.gson;
    }

    @aa(a = k.a.ON_DESTROY)
    public final void destroy() {
        k kVar = this.lifecycle;
        if (kVar != null) {
            kVar.b(this);
        }
        this.lifecycle = null;
    }

    public final void showBottomSheetOnLaunch(Intent intent) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
        if (!instance.getMerchantDataProvider().c()) {
            showAccountDeactivateBottomSheet();
        } else if (intent != null && intent.hasExtra("featuretype") && kotlin.m.p.a(intent.getStringExtra("featuretype"), DeepLinkConstant.FEATURES.KEY_WHATSAPP_BOTTOM_SHEET_LAUNCH, true)) {
            launchWhatsAppConsentBottomSheet();
        } else if (intent == null || !intent.hasExtra("featuretype") || !kotlin.m.p.a(intent.getStringExtra("featuretype"), DeepLinkConstant.FEATURES.KEY_WHATSAPP_CONSENT_ACTIVATE, true)) {
            showOptionDialogToGrowBusiness();
        } else {
            FragmentActivity fragmentActivity = (FragmentActivity) this.activity.get();
            if (fragmentActivity != null) {
                UpsUtility.statusRecieved(fragmentActivity);
            }
        }
    }

    public final void launchWhatsAppConsentBottomSheet() {
        FragmentActivity fragmentActivity = (FragmentActivity) this.activity.get();
        if (fragmentActivity != null) {
            WhatsAppConsentBottomSheetFragment whatsAppConsentBottomSheetFragment = new WhatsAppConsentBottomSheetFragment();
            whatsAppConsentBottomSheetFragment.setCancelable(true);
            kotlin.g.b.k.b(fragmentActivity, "(it)");
            j supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            kotlin.g.b.k.b(supportFragmentManager, "(it).supportFragmentManager");
            whatsAppConsentBottomSheetFragment.show(supportFragmentManager, "whatsup_consent_bottomsheet");
        }
    }

    public final void showAccountDeactivateBottomSheet() {
        this.activity.get();
    }

    public final void showOptionDialogToGrowBusiness() {
        int optionDialogToShow;
        FragmentActivity fragmentActivity = (FragmentActivity) this.activity.get();
        if (fragmentActivity != null && (optionDialogToShow = getOptionDialogToShow()) != -1) {
            GrowBusinessBottomSheetDialog growBusinessBottomSheetDialog = new GrowBusinessBottomSheetDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("DIALOG_PURPOSE", optionDialogToShow);
            growBusinessBottomSheetDialog.setArguments(bundle);
            kotlin.g.b.k.b(fragmentActivity, "it");
            if (fragmentActivity.getSupportFragmentManager().c("growBusinessBottomSheetDialog") == null) {
                growBusinessBottomSheetDialog.show(fragmentActivity.getSupportFragmentManager(), "growBusinessBottomSheetDialog");
            }
        }
    }

    public final int getOptionDialogToShow() {
        GrowBusinessDialogPreferences growBusinessDialogPreferences = getGrowBusinessDialogPreferences();
        boolean z = false;
        if (growBusinessDialogPreferences == null) {
            setGrowBusinessDialogPreferences(new GrowBusinessDialogPreferences(0, System.currentTimeMillis(), 1, 1, kotlin.a.k.d(1, 2)));
            return -1;
        }
        growBusinessDialogPreferences.setLaunchCount(growBusinessDialogPreferences.getLaunchCount() + 1);
        if (growBusinessDialogPreferences.getLastLaunchTimestamp() == 0) {
            return showFirstDialog(growBusinessDialogPreferences);
        }
        ArrayList<Integer> futureDialogs = growBusinessDialogPreferences.getFutureDialogs();
        if (futureDialogs == null || futureDialogs.isEmpty()) {
            z = true;
        }
        if (!z) {
            return showPeriodicDialog(growBusinessDialogPreferences);
        }
        return -1;
    }

    private final int showPeriodicDialog(GrowBusinessDialogPreferences growBusinessDialogPreferences) {
        int i2;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
        long b2 = instance.getGTMDataProvider().getLong(PaymentsGTMConstants.KEY_MIN_APL_FOR_PERIODIC_DIALOG, 0);
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance2, "PaymentsConfig.getInstance()");
        if (getSecondsDiff(System.currentTimeMillis(), growBusinessDialogPreferences.getLastLaunchTimestamp()) < instance2.getGTMDataProvider().getLong(PaymentsGTMConstants.KEY_MIN_SECS_OF_APL_PERIODIC_DIALOG, 0) || ((long) growBusinessDialogPreferences.getLaunchCount()) < b2) {
            i2 = -1;
        } else {
            i2 = growBusinessDialogPreferences.getNextDialog();
            growBusinessDialogPreferences.setLaunchCount(0);
            growBusinessDialogPreferences.setLastLaunchTimestamp(System.currentTimeMillis());
            if (growBusinessDialogPreferences.getFutureDialogs().size() > 1) {
                if (i2 == 1) {
                    growBusinessDialogPreferences.setNextDialog(2);
                } else {
                    growBusinessDialogPreferences.setNextDialog(1);
                }
            }
        }
        setGrowBusinessDialogPreferences(growBusinessDialogPreferences);
        return i2;
    }

    private final int showFirstDialog(GrowBusinessDialogPreferences growBusinessDialogPreferences) {
        int i2;
        PaymentsConfig instance = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
        long b2 = instance.getGTMDataProvider().getLong(PaymentsGTMConstants.KEY_MIN_APL_FOR_FIRST_DIALOG, 0);
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance2, "PaymentsConfig.getInstance()");
        if (getSecondsDiff(System.currentTimeMillis(), growBusinessDialogPreferences.getFirstLaunchTimestamp()) < instance2.getGTMDataProvider().getLong(PaymentsGTMConstants.KEY_MIN_SECS_OF_APL_FOR_FIRST_DIALOG, 0) || ((long) growBusinessDialogPreferences.getLaunchCount()) < b2) {
            i2 = -1;
        } else {
            growBusinessDialogPreferences.setLaunchCount(0);
            growBusinessDialogPreferences.setLastLaunchTimestamp(System.currentTimeMillis());
            growBusinessDialogPreferences.setNextDialog(2);
            i2 = 1;
        }
        setGrowBusinessDialogPreferences(growBusinessDialogPreferences);
        return i2;
    }

    public final void checkChangeListener(int i2, boolean z) {
        ArrayList<Integer> futureDialogs;
        if (z) {
            if (i2 == 1) {
                PaymentsConfig instance = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
                e eventPublisher = instance.getEventPublisher();
                PaymentsConfig instance2 = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance2, "PaymentsConfig.getInstance()");
                eventPublisher.b(instance2.getAppContext(), "accept_payments_home", "Order QR Dialog Never Ask Clicked", "", "");
            } else {
                PaymentsConfig instance3 = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance3, "PaymentsConfig.getInstance()");
                e eventPublisher2 = instance3.getEventPublisher();
                PaymentsConfig instance4 = PaymentsConfig.getInstance();
                kotlin.g.b.k.b(instance4, "PaymentsConfig.getInstance()");
                eventPublisher2.b(instance4.getAppContext(), "accept_payments_home", "Download P4B Dialog Never Ask Clicked", "", "");
            }
            doNotShowThisDialogAgain(i2);
            return;
        }
        GrowBusinessDialogPreferences growBusinessDialogPreferences = getGrowBusinessDialogPreferences();
        if (!(growBusinessDialogPreferences == null || (futureDialogs = growBusinessDialogPreferences.getFutureDialogs()) == null)) {
            futureDialogs.add(Integer.valueOf(i2));
        }
        setGrowBusinessDialogPreferences(growBusinessDialogPreferences);
    }

    public final void doNotShowThisDialogAgain(int i2) {
        ArrayList<Integer> futureDialogs;
        GrowBusinessDialogPreferences growBusinessDialogPreferences = getGrowBusinessDialogPreferences();
        if (!(growBusinessDialogPreferences == null || (futureDialogs = growBusinessDialogPreferences.getFutureDialogs()) == null)) {
            futureDialogs.remove(Integer.valueOf(i2));
        }
        setGrowBusinessDialogPreferences(growBusinessDialogPreferences);
    }

    public final void setGrowBusinessDialogPreferences(GrowBusinessDialogPreferences growBusinessDialogPreferences) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
        Context appContext = instance.getAppContext();
        String b2 = this.gson.b(growBusinessDialogPreferences);
        kotlin.g.b.k.b(b2, "gson.toJson(growBusinessDialogPreferences)");
        a.C0104a aVar = a.f7354a;
        kotlin.g.b.k.b(appContext, "context");
        Context applicationContext = appContext.getApplicationContext();
        kotlin.g.b.k.b(applicationContext, "context.applicationContext");
        a.C0104a.a(applicationContext).a("AP_DIALOG_PREFS", b2, true);
    }

    public final GrowBusinessDialogPreferences getGrowBusinessDialogPreferences() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        kotlin.g.b.k.b(instance, "PaymentsConfig.getInstance()");
        Context appContext = instance.getAppContext();
        a.C0104a aVar = a.f7354a;
        kotlin.g.b.k.b(appContext, "context");
        Context applicationContext = appContext.getApplicationContext();
        kotlin.g.b.k.b(applicationContext, "context.applicationContext");
        String b2 = a.C0104a.a(applicationContext).b("AP_DIALOG_PREFS", "", true);
        if (true ^ kotlin.g.b.k.a((Object) b2, (Object) "")) {
            return (GrowBusinessDialogPreferences) new f().a(b2, GrowBusinessDialogPreferences.class);
        }
        return null;
    }

    public final long getSecondsDiff(long j, long j2) {
        return (j - j2) / 1000;
    }

    public final void handleBusinessDialogOnOtherBottomsheets() {
        GrowBusinessDialogPreferences growBusinessDialogPreferences = getGrowBusinessDialogPreferences();
        if (growBusinessDialogPreferences == null) {
            getOptionDialogToShow();
            return;
        }
        growBusinessDialogPreferences.setLaunchCount(growBusinessDialogPreferences.getLaunchCount() + 1);
        setGrowBusinessDialogPreferences(growBusinessDialogPreferences);
    }
}
