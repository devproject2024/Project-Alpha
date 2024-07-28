package net.one97.paytm.dynamicModule;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.paytm.utility.q;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.g.a;
import net.one97.paytm.i.h;
import net.one97.paytm.paytm_finance.R;

public class CommonDynamicFragment extends h implements DynamicModuleManager.Listener {
    private static String CLASSPATH = "classpath";
    private static String INITCLASSPATH = "InitClasspath";
    public static String MODULE_NAME = "module_name";
    private static String TAG = "CommonDynamicFragmentLoader";
    private String classPath = null;
    private Context contextOnAttach;
    private Fragment displayedFragment;
    private String initClassPath = null;
    private boolean isFragmentReplaced = false;
    private boolean isModuleInstallInProgress;
    private boolean isModuleInstalled = false;
    private boolean isVisible;
    private DynamicModuleLoaderAdapter mAdapter;
    private a mBinding;
    private String moduleName = null;

    private void log(String str) {
    }

    public void onPending(String str) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
        this.contextOnAttach = context;
        if (getArguments() != null) {
            this.moduleName = getArguments().getString(MODULE_NAME);
            this.classPath = getArguments().getString(CLASSPATH);
            this.initClassPath = getArguments().getString(INITCLASSPATH);
            if (!TextUtils.isEmpty(this.moduleName)) {
                if (this.moduleName != null) {
                    this.isModuleInstalled = DynamicModuleManager.getInstance().isInstalled(this.moduleName);
                } else {
                    this.isModuleInstalled = false;
                }
            }
        }
        if (!TextUtils.isEmpty(this.moduleName)) {
            DynamicModuleManager.getInstance().registerListener(this);
        }
        StringBuilder sb = new StringBuilder("onAttached -> Module name :: ");
        sb.append(this.moduleName);
        sb.append(" classPath is :: ");
        sb.append(this.classPath);
        sb.append(" installation status :: ");
        sb.append(this.isModuleInstalled);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinding = (a) f.a(layoutInflater, (int) R.layout.fragment_dynamic_module_loader, viewGroup, false);
        return this.mBinding.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.isModuleInstalled) {
            StringBuilder sb = new StringBuilder("Switching Fragment -> Module name :: ");
            sb.append(this.moduleName);
            sb.append("classPath is :: ");
            sb.append(this.classPath);
            switchFragment(false);
            return;
        }
        StringBuilder sb2 = new StringBuilder("onViewCreated -> Module name :: ");
        sb2.append(this.moduleName);
        sb2.append("isModuleInstallInProgress :: ");
        sb2.append(this.isModuleInstallInProgress);
        sb2.append(" isVisible :: ");
        sb2.append(this.isVisible);
        sb2.append(" isVisible Method :: ");
        sb2.append(isVisible());
        this.mAdapter = new DynamicModuleLoaderAdapter(this.contextOnAttach, getActivity(), DynamicModuleHelper.downloadSourceBottomSheet);
        this.mBinding.f50478b.setLayoutManager(new LinearLayoutManager(this.contextOnAttach));
        this.mBinding.f50478b.setAdapter(this.mAdapter);
        this.mAdapter.refreshCurrentQueue();
    }

    public void onResume() {
        super.onResume();
        log("from onResume:: ----->>>>>>>true");
        setupDownloadProcess(true);
    }

    private void installModule() {
        StringBuilder sb = new StringBuilder("CommonDynamicFragment::installModule for ");
        sb.append(this.moduleName);
        sb.append(" class ");
        sb.append(this.classPath);
        if (this.moduleName != null) {
            DynamicModuleManager.getInstance().startInstall(this.moduleName, (Activity) getActivity());
            StringBuilder sb2 = new StringBuilder("CommonDynamicFragment::installModule for ");
            sb2.append(this.moduleName);
            sb2.append(" started");
            this.mAdapter.refreshCurrentQueue();
        }
    }

    private void switchFragment(boolean z) {
        try {
            Fragment c2 = getChildFragmentManager().c(this.moduleName);
            if (c2 != null) {
                getChildFragmentManager().a().b(this.mBinding.f50477a.getId(), c2, this.moduleName).c();
            } else {
                this.displayedFragment = getFragment(z);
                if (this.displayedFragment != null) {
                    getChildFragmentManager().a().b(this.mBinding.f50477a.getId(), this.displayedFragment, this.moduleName).c();
                }
            }
            this.isFragmentReplaced = true;
            DynamicModuleManager.getInstance().unRegisterListener(this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void setupDownloadProcess(boolean z) {
        if (isAdded()) {
            log("Is Added :: --->>>>>> ModuleName :: " + this.moduleName + " setUserVisibleHint :: " + z + " isModuleInstallInProgress :: " + this.isModuleInstallInProgress + " isFragmentReplaced :: " + this.isFragmentReplaced + " isModuleInstalled :: " + this.isModuleInstalled + " isVisible :: " + this.isVisible);
            List<Fragment> d2 = getChildFragmentManager().f3424a.d();
            for (int i2 = 0; i2 < d2.size(); i2++) {
                log("setUserVisibleHint fragment is :: " + d2.get(i2).getTag());
                d2.get(i2).setUserVisibleHint(z);
            }
            if (!z || this.isModuleInstallInProgress || TextUtils.isEmpty(this.moduleName)) {
                if (z) {
                    DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter = this.mAdapter;
                    if (dynamicModuleLoaderAdapter != null) {
                        dynamicModuleLoaderAdapter.refreshCurrentQueue();
                    }
                    if (this.isModuleInstallInProgress) {
                        this.isModuleInstalled = DynamicModuleManager.getInstance().isInstalled(this.moduleName);
                        if (this.isModuleInstalled && !this.isFragmentReplaced) {
                            switchFragment(false);
                            this.isModuleInstallInProgress = false;
                        }
                    }
                }
            } else if (!this.isFragmentReplaced && this.isModuleInstalled) {
                switchFragment(false);
            } else if (!this.isModuleInstalled) {
                DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter2 = this.mAdapter;
                if (dynamicModuleLoaderAdapter2 != null) {
                    dynamicModuleLoaderAdapter2.refreshCurrentQueue();
                }
                this.isModuleInstallInProgress = true;
                installModule();
            } else {
                log("Successfully replaced");
            }
            DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter3 = this.mAdapter;
            if (dynamicModuleLoaderAdapter3 == null || dynamicModuleLoaderAdapter3.getItemCount() <= 1) {
                this.mBinding.f50479c.setVisibility(8);
            } else {
                this.mBinding.f50479c.setVisibility(0);
            }
        } else {
            log("Is Not Added :: ----->>>>>>>" + isAdded() + "ModuleName :: " + this.moduleName + " setUserVisibleHint :: " + z + " isModuleInstallInProgress :: " + this.isModuleInstallInProgress + " isFragmentReplaced :: " + this.isFragmentReplaced + " isModuleInstalled :: " + this.isModuleInstalled + " isVisible :: " + this.isVisible);
        }
    }

    private void initDownloadedModules() {
        if (!TextUtils.isEmpty(this.initClassPath)) {
            try {
                Class<?> cls = Class.forName(this.initClassPath);
                Method declaredMethod = cls.getDeclaredMethod("init", new Class[]{Application.class});
                if (getActivity() != null) {
                    declaredMethod.invoke(cls.newInstance(), new Object[]{getActivity().getApplication()});
                }
            } catch (InstantiationException e2) {
                q.b(e2.getMessage());
            } catch (IllegalAccessException e3) {
                q.b(e3.getMessage());
            } catch (ClassNotFoundException e4) {
                q.b(e4.getMessage());
            } catch (NoSuchMethodException e5) {
                q.b(e5.getMessage());
            } catch (InvocationTargetException e6) {
                q.b(e6.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.fragment.app.Fragment getFragment(boolean r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.classPath
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            java.lang.String r2 = "Getting Fragment -> classPath :: "
            r0.<init>(r2)     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            java.lang.String r2 = r3.classPath     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            r0.append(r2)     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            java.lang.String r2 = "moduleName is ::"
            r0.append(r2)     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            java.lang.String r2 = r3.moduleName     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            r0.append(r2)     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            java.lang.String r0 = r3.classPath     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ InstantiationException -> 0x0061, IllegalAccessException -> 0x0057, ClassNotFoundException -> 0x004d }
            android.os.Bundle r1 = r3.getArguments()     // Catch:{ InstantiationException -> 0x004b, IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0047 }
            if (r1 != 0) goto L_0x0037
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ InstantiationException -> 0x004b, IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0047 }
            r1.<init>()     // Catch:{ InstantiationException -> 0x004b, IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0047 }
        L_0x0037:
            java.lang.String r2 = "IS_FRESH_INSTALL"
            r1.putBoolean(r2, r4)     // Catch:{ InstantiationException -> 0x004b, IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0047 }
            java.lang.String r4 = "IS_VISIBLE"
            boolean r2 = r3.isVisible     // Catch:{ InstantiationException -> 0x004b, IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0047 }
            r1.putBoolean(r4, r2)     // Catch:{ InstantiationException -> 0x004b, IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0047 }
            r0.setArguments(r1)     // Catch:{ InstantiationException -> 0x004b, IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0047 }
            goto L_0x006a
        L_0x0047:
            r4 = move-exception
            goto L_0x004f
        L_0x0049:
            r4 = move-exception
            goto L_0x0059
        L_0x004b:
            r4 = move-exception
            goto L_0x0063
        L_0x004d:
            r4 = move-exception
            r0 = r1
        L_0x004f:
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
            goto L_0x006a
        L_0x0057:
            r4 = move-exception
            r0 = r1
        L_0x0059:
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
            goto L_0x006a
        L_0x0061:
            r4 = move-exception
            r0 = r1
        L_0x0063:
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.b(r4)
        L_0x006a:
            if (r0 != 0) goto L_0x006f
            java.lang.String r4 = "null"
            goto L_0x0077
        L_0x006f:
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
        L_0x0077:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CommonDynamicFragment::getFragment returning  "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = "Fragment -> "
            r1.append(r4)
            r1.append(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamicModule.CommonDynamicFragment.getFragment(boolean):androidx.fragment.app.Fragment");
    }

    public static Fragment newInstance(Bundle bundle, String str, String str2, String str3) {
        CommonDynamicFragment commonDynamicFragment = new CommonDynamicFragment();
        bundle.putString(MODULE_NAME, str);
        bundle.putString(CLASSPATH, str2);
        bundle.putString(INITCLASSPATH, str3);
        StringBuilder sb = new StringBuilder("CommonDynamicFragment::newInstance moduleName is  ");
        sb.append(str);
        sb.append(" classpath ");
        sb.append(str2);
        commonDynamicFragment.setArguments(bundle);
        commonDynamicFragment.setUserVisibleHint(false);
        return commonDynamicFragment;
    }

    public void onRequestSuccess(String str) {
        DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter;
        log(str + ": onRequestSuccess: Download will start soon.");
        if (isAdded() && (dynamicModuleLoaderAdapter = this.mAdapter) != null) {
            dynamicModuleLoaderAdapter.updateItemData(str, false, this.contextOnAttach.getString(R.string.msg_request_started_but_not_download), 0);
        }
    }

    public void onDownloading(String str, int i2) {
        DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter;
        log(str + ": onDownloading: " + i2 + "%");
        if (isAdded() && (dynamicModuleLoaderAdapter = this.mAdapter) != null) {
            dynamicModuleLoaderAdapter.updateItemData(str, false, this.contextOnAttach.getString(R.string.lbl_downloading), i2);
        }
    }

    public void onDownloaded(String str) {
        DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter;
        log(str + ": onDownloaded");
        if (isAdded() && (dynamicModuleLoaderAdapter = this.mAdapter) != null) {
            dynamicModuleLoaderAdapter.updateItemData(str, false, this.contextOnAttach.getString(R.string.lbl_installing), 100);
        }
    }

    public void onInstalled(String str) {
        DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter;
        log(str + ": onInstalled");
        if (this.moduleName.equalsIgnoreCase(str)) {
            this.isModuleInstalled = true;
            this.isModuleInstallInProgress = false;
            initDownloadedModules();
        }
        if (!isAdded() || (dynamicModuleLoaderAdapter = this.mAdapter) == null) {
            DynamicModuleManager.getInstance().unRegisterListener(this);
            return;
        }
        dynamicModuleLoaderAdapter.updateItemData(str, false, this.contextOnAttach.getString(R.string.lbl_installed), 100);
        if (this.moduleName.equalsIgnoreCase(str) && DynamicModuleManager.getInstance().isInstalled(this.moduleName)) {
            switchFragment(true);
        }
    }

    public void onCancelled(String str) {
        DynamicModuleLoaderAdapter dynamicModuleLoaderAdapter;
        log(str + ": onCancelled");
        if (isAdded() && (dynamicModuleLoaderAdapter = this.mAdapter) != null) {
            dynamicModuleLoaderAdapter.updateItemData(str, true, this.contextOnAttach.getString(R.string.lbl_cancelled), 0);
        }
        if (this.moduleName.equalsIgnoreCase(str)) {
            this.isModuleInstallInProgress = false;
        }
    }

    public void onRequestFailed(String str, DynamicModuleManager.REQUEST_FAILED request_failed, int i2, String str2) {
        log(str + ": onRequestFailed: " + request_failed);
        if (this.moduleName.equalsIgnoreCase(str)) {
            this.isModuleInstallInProgress = false;
        }
        if (isAdded() && this.mAdapter != null) {
            this.mAdapter.updateItemData(str, true, DynamicModuleUtils.getRequestFailedErrorMsg(this.contextOnAttach, request_failed), 0);
            if (this.moduleName.equalsIgnoreCase(str) && request_failed != DynamicModuleManager.REQUEST_FAILED.ACCESS_DENIED) {
                return;
            }
            if (request_failed == DynamicModuleManager.REQUEST_FAILED.INSUFFICIENT_STORAGE) {
                if (getActivity() != null && this.moduleName.equalsIgnoreCase(str)) {
                    DynamicModuleHelper.loadPlayCoreErrorBottomSheet(getActivity().getSupportFragmentManager(), DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.INSUFFICIENT_STORAGE.name(), str, i2, str2);
                }
            } else if (request_failed == DynamicModuleManager.REQUEST_FAILED.MODULE_UNAVAILABLE || request_failed == DynamicModuleManager.REQUEST_FAILED.API_NOT_AVAILABLE) {
                if (getActivity() != null && this.moduleName.equalsIgnoreCase(str)) {
                    DynamicModuleHelper.loadPlayCoreErrorBottomSheet(getActivity().getSupportFragmentManager(), DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.MODULE_UNAVAILABLE.name(), str, i2, str2);
                }
            } else if (request_failed != DynamicModuleManager.REQUEST_FAILED.NETWORK_ERROR && request_failed != DynamicModuleManager.REQUEST_FAILED.SERVICE_DIED && getActivity() != null && this.moduleName.equalsIgnoreCase(str)) {
                DynamicModuleHelper.loadPlayCoreErrorBottomSheet(getActivity().getSupportFragmentManager(), DynamicModuleManager.REQUEST_FAILED_ERROR_TYPE.OTHER.name(), str, i2, str2);
            }
        }
    }

    public void onRequestRetry(String str, DynamicModuleManager.REQUEST_FAILED request_failed) {
        log(str + ": onRequestRetry: " + str);
        if (isAdded() && this.mAdapter != null) {
            this.mAdapter.updateItemData(str, false, DynamicModuleUtils.getRequestFailedErrorMsg(this.contextOnAttach, request_failed), 0);
        }
        if (this.moduleName.equalsIgnoreCase(str)) {
            this.isModuleInstallInProgress = true;
        }
    }

    public void onDetach() {
        super.onDetach();
        StringBuilder sb = new StringBuilder("onDetach -> Module name :: ");
        sb.append(this.moduleName);
        sb.append(" installation status :: ");
        sb.append(this.isModuleInstalled);
        this.contextOnAttach = null;
        DynamicModuleManager.getInstance().unRegisterListener(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        StringBuilder sb = new StringBuilder("onActivityResult -> requestCode :: ");
        sb.append(i2);
        sb.append(" resultCode :: ");
        sb.append(i3);
        sb.append(" intent :: ");
        sb.append(intent);
        Fragment fragment = this.displayedFragment;
        if (fragment != null) {
            fragment.onActivityResult(i2, i3, intent);
        }
    }
}
