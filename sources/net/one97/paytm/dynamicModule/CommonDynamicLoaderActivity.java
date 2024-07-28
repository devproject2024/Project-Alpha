package net.one97.paytm.dynamicModule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.firebase.crashlytics.c;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Set;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.g.a;
import net.one97.paytm.paytm_finance.R;

public class CommonDynamicLoaderActivity extends PaytmActivity implements DynamicModuleManager.Listener {
    public static String EXTRA_INIT_ACTIVITY = "EXTRA_INIT_ACTIVITY";
    public static String EXTRA_INIT_MODULE = "EXTRA_INIT_MODULE";
    public static String EXTRA_TARGET_ACTIVITY_ARGS = "EXTRA_TARGET_ACTIVITY_ARGS";
    private static final String TAG = "PlayCore-DFMActivity";
    private String initActivity;
    private String initModule;
    private DynamicModuleLoaderAdapter mAdapter;
    private a mBinding;
    private Intent resultIntent;

    private void log(String str) {
    }

    public void onPending(String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBinding = (a) f.a(this, R.layout.fragment_dynamic_module_loader);
        this.resultIntent = getIntent();
        this.initActivity = this.resultIntent.getStringExtra(EXTRA_INIT_ACTIVITY);
        this.initModule = this.resultIntent.getStringExtra(EXTRA_INIT_MODULE);
        this.mAdapter = new DynamicModuleLoaderAdapter(this, this, DynamicModuleHelper.downloadSourceActivity);
        this.mBinding.f50478b.setLayoutManager(new LinearLayoutManager(this));
        this.mBinding.f50478b.setAdapter(this.mAdapter);
        DynamicModuleManager.getInstance().startInstall(this.initModule, (Activity) this);
    }

    private void startModuleActivity() {
        try {
            String stringExtra = this.resultIntent.getStringExtra("listener");
            if (!TextUtils.isEmpty(stringExtra)) {
                initializeListener(stringExtra);
            }
            this.resultIntent.setClassName("net.one97.paytm", this.initActivity);
            startActivity(this.resultIntent);
            finish();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onStart() {
        super.onStart();
        DynamicModuleManager.getInstance().registerListener(this);
        this.mAdapter.refreshCurrentQueue();
        DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter = this.mAdapter;
        if (dynamicModuleLoaderAdapter == null || dynamicModuleLoaderAdapter.getItemCount() <= 1) {
            this.mBinding.f50479c.setVisibility(8);
        } else {
            this.mBinding.f50479c.setVisibility(0);
        }
    }

    public void onStop() {
        super.onStop();
        DynamicModuleManager.getInstance().unRegisterListener(this);
    }

    private void initializeListener(String str) {
        try {
            Class.forName(str).newInstance();
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
        } catch (IllegalAccessException e3) {
            q.b(e3.getMessage());
        } catch (InstantiationException e4) {
            q.b(e4.getMessage());
        }
    }

    public void onRequestSuccess(String str) {
        log(str + ": onRequestSuccess: Download will start soon.");
        this.mAdapter.updateItemData(str, false, getString(R.string.msg_request_started_but_not_download), 0);
    }

    public void onDownloading(String str, int i2) {
        log(str + ": onDownloading: " + i2 + "%");
        this.mAdapter.updateItemData(str, false, getString(R.string.lbl_downloading), i2);
    }

    public void onDownloaded(String str) {
        log(str + ": onDownloaded");
        this.mAdapter.updateItemData(str, false, getString(R.string.lbl_installing), 100);
    }

    public void onInstalled(String str) {
        log(str + ": onInstalled");
        this.mAdapter.updateItemData(str, false, getString(DynamicModuleManager.getInstance().isInstalled(str) ? R.string.lbl_installed : R.string.lbl_installation_failed), 100);
        if (this.initModule.equalsIgnoreCase(str)) {
            c.a().a("Install Module Name :  - ".concat(String.valueOf(str)));
            Set<String> installedModules = DynamicModuleManager.getInstance().getInstalledModules();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(installedModules);
            c.a().a("Install Module List :  - ".concat(String.valueOf(arrayList)));
            if (DynamicModuleManager.getInstance().isInstalled(this.initModule)) {
                startModuleActivity();
            }
        }
    }

    public void onCancelled(String str) {
        log(str + ": onCancelled");
        this.mAdapter.updateItemData(str, true, getString(R.string.lbl_cancelled), 0);
    }

    public void onRequestFailed(String str, DynamicModuleManager.REQUEST_FAILED request_failed, int i2, String str2) {
        log(str + ": onRequestFailed: " + request_failed);
        this.mAdapter.updateItemData(str, true, DynamicModuleUtils.getRequestFailedErrorMsg(this, request_failed), 0);
        if (this.initModule.equalsIgnoreCase(str) && request_failed != DynamicModuleManager.REQUEST_FAILED.ACCESS_DENIED) {
            return;
        }
        if (request_failed == DynamicModuleManager.REQUEST_FAILED.INSUFFICIENT_STORAGE && this.initModule.equalsIgnoreCase(str)) {
            DynamicModuleHelper.loadPlayCoreErrorBottomSheet(getSupportFragmentManager(), DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.INSUFFICIENT_STORAGE.name(), str, i2, str2);
        } else if (this.initModule.equalsIgnoreCase(str) && request_failed != DynamicModuleManager.REQUEST_FAILED.MODULE_UNAVAILABLE) {
            DynamicModuleHelper.loadPlayCoreErrorBottomSheet(getSupportFragmentManager(), DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.MODULE_UNAVAILABLE.name(), str, i2, str2);
        } else if (this.initModule.equalsIgnoreCase(str) && request_failed != DynamicModuleManager.REQUEST_FAILED.NETWORK_ERROR && request_failed != DynamicModuleManager.REQUEST_FAILED.SERVICE_DIED) {
            DynamicModuleHelper.loadPlayCoreErrorBottomSheet(getSupportFragmentManager(), DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.OTHER.name(), str, i2, str2);
        } else if (!this.initModule.equalsIgnoreCase(str)) {
        } else {
            if (request_failed == DynamicModuleManager.REQUEST_FAILED.MODULE_UNAVAILABLE || request_failed == DynamicModuleManager.REQUEST_FAILED.API_NOT_AVAILABLE) {
                DynamicModuleHelper.loadPlayCoreErrorBottomSheet(getSupportFragmentManager(), DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.API_NOT_AVAILABLE.name(), str, i2, str2);
            }
        }
    }

    public void onRequestRetry(String str, DynamicModuleManager.REQUEST_FAILED request_failed) {
        log(str + ": onRequestFailed: " + request_failed);
        this.mAdapter.updateItemData(str, false, DynamicModuleUtils.getRequestFailedErrorMsg(this, request_failed), 0);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }
}
