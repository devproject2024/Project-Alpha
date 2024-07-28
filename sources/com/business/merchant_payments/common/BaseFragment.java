package com.business.merchant_payments.common;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import com.business.common_module.c.a.a;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import net.one97.paytm.i.h;

public abstract class BaseFragment extends h {
    public final String TAG = getClass().getSimpleName();
    public Context mContext;
    public ProgressDialog progressDialog;

    public abstract void initUI();

    public void switchTabFragment() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        a.f7337b = getClass().getSimpleName();
    }

    public void onResume() {
        super.onResume();
        a.f7337b = getClass().getSimpleName();
        String stringExtra = getActivity().getIntent().getStringExtra("source");
        if (stringExtra != null && !stringExtra.isEmpty()) {
            GAGTMTagAnalytics.getSingleInstance().setCurrentVisibleScreen(stringExtra);
        }
    }

    public void onPause() {
        super.onPause();
        GAGTMTagAnalytics.getSingleInstance().setCurrentVisibleScreen(getClass().getSimpleName());
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getActivity();
        initUI();
    }

    public void showDialogFragment(b bVar, String str) {
        if (!isAdded() || isStateSaved()) {
            String str2 = this.TAG;
            LogUtility.e(str2, this.TAG + " is not active to show dialog fragment  " + bVar.getClass().getSimpleName());
            return;
        }
        bVar.show(getChildFragmentManager(), str);
    }

    public void showProgressDialog(boolean z, Context context) {
        showProgressDialog(false, getString(R.string.mp_please_wait), context);
    }

    public void showProgressDialog(boolean z, String str, Context context) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 == null || !progressDialog2.isShowing()) {
            closeKeyboard(context);
            this.progressDialog = DialogUtility.showProgressDialog(context, str, z);
        }
    }

    public void showProgressDialog(Context context) {
        showProgressDialog(false, context);
    }

    public void closeKeyboard(Context context) {
        View currentFocus = ((AppCompatActivity) context).getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r0.isDestroyed() == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (((android.app.Activity) r0).isFinishing() == false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeProgressDialog() {
        /*
            r3 = this;
            android.app.ProgressDialog r0 = r3.progressDialog
            if (r0 == 0) goto L_0x003d
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x003a
            android.app.ProgressDialog r0 = r3.progressDialog
            android.content.Context r0 = r0.getContext()
            android.content.ContextWrapper r0 = (android.content.ContextWrapper) r0
            android.content.Context r0 = r0.getBaseContext()
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0037
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x002f
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r1 = r0.isFinishing()
            if (r1 != 0) goto L_0x003a
            boolean r0 = r0.isDestroyed()
            if (r0 != 0) goto L_0x003a
            goto L_0x0037
        L_0x002f:
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x003a
        L_0x0037:
            r3.dismissWithExceptionHandling()
        L_0x003a:
            r0 = 0
            r3.progressDialog = r0
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.common.BaseFragment.removeProgressDialog():void");
    }

    public void dismissWithExceptionHandling() {
        try {
            this.progressDialog.dismiss();
        } catch (Exception | IllegalArgumentException unused) {
        } finally {
            this.progressDialog = null;
        }
    }

    public <T extends c> T provideViewModel(Application application, Class<T> cls, Fragment fragment) {
        return (c) new al((ao) fragment, (al.b) new c.a(application)).a(cls);
    }
}
