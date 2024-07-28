package com.paytm.business.merchantprofile.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.k;
import com.airbnb.lottie.LottieAnimationView;
import com.business.common_module.c.a.a;
import com.business.common_module.events.ErrorDisplayEvent;
import com.business.common_module.events.e;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.d;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.utility.DialogUtility;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.greenrobot.eventbus.j;

public abstract class BaseActivity extends PaytmActivity implements d {
    public ProgressDialog progressDialog;

    public void showProgressDialog(boolean z) {
        showProgressDialog(false, getString(R.string.pr_please_wait));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.f7336a = getClass().getSimpleName();
    }

    public void onResume() {
        super.onResume();
        a.f7336a = getClass().getSimpleName();
    }

    public void onPause() {
        super.onPause();
        String stringExtra = getIntent().getStringExtra("source");
        if (stringExtra != null && !stringExtra.isEmpty()) {
            ProfileConfig.getInstance().getEventPublisher();
        } else if (!activityHasFragment()) {
            ProfileConfig.getInstance().getEventPublisher();
            getClass().getSimpleName();
        }
    }

    private boolean activityHasFragment() {
        List<Fragment> d2 = getSupportFragmentManager().f3424a.d();
        return (d2 == null || d2.size() == 0) ? false : true;
    }

    public void showProgressDialog(boolean z, String str) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 == null || !progressDialog2.isShowing()) {
            closeKeyboard();
            this.progressDialog = DialogUtility.showProgressDialog(this, str, z);
        }
    }

    public void showProgressDialog() {
        showProgressDialog(false);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(ProfileConfig.getInstance().getCommonUtils().a(context));
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.common.BaseActivity.removeProgressDialog():void");
    }

    public void dismissWithExceptionHandling() {
        try {
            this.progressDialog.dismiss();
        } catch (Exception | IllegalArgumentException unused) {
        } finally {
            this.progressDialog = null;
        }
    }

    public void closeKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(17432576, 17432577);
    }

    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
        overridePendingTransition(17432576, 17432577);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(17432576, 17432577);
    }

    public void hideKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void replaceFragmentKeepingBackStack(Fragment fragment) {
        getSupportFragmentManager().a().a((String) null).b(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).a(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).c();
        supportInvalidateOptionsMenu();
    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager().a().b(R.id.fragment_container, fragment, (String) null).a(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).a((String) null).c();
        supportInvalidateOptionsMenu();
    }

    public Fragment getVisibleFragment() {
        List<Fragment> d2 = getSupportFragmentManager().f3424a.d();
        if (d2 == null) {
            return null;
        }
        for (Fragment next : d2) {
            if (next != null && next.isVisible()) {
                return next;
            }
        }
        return null;
    }

    public <T extends c> T provideViewModel(Class<T> cls, Fragment fragment) {
        c.a aVar = new c.a(getApplication());
        if (fragment == null) {
            return (c) new al((ao) this, (al.b) aVar).a(cls);
        }
        return (c) new al((ao) fragment, (al.b) aVar).a(cls);
    }

    @j
    public void onSessionExpiryEvent(e eVar) {
        ProfileConfig.getInstance().getCommonUtils().a(this, getClass().getName(), getIntent().getExtras());
    }

    @j
    public void onErrorDisplayEvent(ErrorDisplayEvent errorDisplayEvent) {
        showErrorSnackBar(errorDisplayEvent);
    }

    private void showErrorSnackBar(ErrorDisplayEvent errorDisplayEvent) {
        View view;
        String string = getApplicationContext().getString(R.string.pr_error_inconvenience_msg);
        if (findViewById(R.id.fragment_container) == null) {
            view = findViewById(R.id.coordinatorLayout);
        } else {
            view = findViewById(R.id.fragment_container);
        }
        int i2 = errorDisplayEvent.f7339b;
        if (i2 == 11) {
            string = getApplicationContext().getString(R.string.pr_no_internet_connection);
        } else if (i2 == 12) {
            String string2 = getApplicationContext().getString(R.string.pr_error_inconvenience_msg);
            if (!TextUtils.isEmpty(errorDisplayEvent.f7340c)) {
                string2 = errorDisplayEvent.f7340c;
            }
            if (view != null) {
                Snackbar a2 = Snackbar.a(view, (CharSequence) string2, 0);
                a2.a((CharSequence) getString(R.string.retry), (View.OnClickListener) new View.OnClickListener(a2) {
                    private final /* synthetic */ Snackbar f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        BaseActivity.lambda$showErrorSnackBar$0(ErrorDisplayEvent.this, this.f$1, view);
                    }
                });
                a2.d(getApplicationContext().getResources().getColor(R.color.color_00b9f5));
                View b2 = a2.b();
                b2.setBackgroundColor(b.c(getApplicationContext(), R.color.black));
                TextView textView = (TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text);
                ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
                textView.setTypeface(textView.getTypeface(), 1);
                textView.setTextColor(-1);
                a2.c();
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(errorDisplayEvent.f7340c)) {
            string = errorDisplayEvent.f7340c;
        }
        if (view != null) {
            Snackbar a3 = Snackbar.a(view, (CharSequence) string, 0);
            a3.a((CharSequence) getString(R.string.pr_ok), (View.OnClickListener) new View.OnClickListener() {
                public final void onClick(View view) {
                    Snackbar.this.d();
                }
            });
            a3.d(getApplicationContext().getResources().getColor(R.color.color_00b9f5));
            View b3 = a3.b();
            b3.setBackgroundColor(b.c(getApplicationContext(), R.color.black));
            TextView textView2 = (TextView) b3.findViewById(com.google.android.material.R.id.snackbar_text);
            ((TextView) b3.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
            textView2.setTypeface(textView2.getTypeface(), 1);
            textView2.setTextColor(-1);
            a3.c();
        }
    }

    public static /* synthetic */ void lambda$showErrorSnackBar$0(ErrorDisplayEvent errorDisplayEvent, Snackbar snackbar, View view) {
        org.greenrobot.eventbus.c.a().c(new com.business.common_module.events.b(errorDisplayEvent.f7338a));
        snackbar.d();
    }

    public void showDialogFragment(androidx.fragment.app.b bVar, String str) {
        if (!getLifecycle().a().isAtLeast(k.b.RESUMED)) {
            String simpleName = getClass().getSimpleName();
            LogUtility.e(simpleName, "Activity is not active to show dialog fragment  " + bVar.getClass().getSimpleName());
            return;
        }
        bVar.show(getSupportFragmentManager(), str);
    }

    public static void startLottieAnimation(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("blue_dotted_progress.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public static void stopLottieAnimation(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(8);
        lottieAnimationView.cancelAnimation();
    }

    public void setStatusBarWhiteColor(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            if (!z || Build.VERSION.SDK_INT < 23) {
                window.setStatusBarColor(getResources().getColor(R.color.statusBarColor));
                window.getDecorView().setSystemUiVisibility(0);
                return;
            }
            window.getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            window.setStatusBarColor(-1);
        }
    }

    public void showSnackBar(View view, String str, String str2, int i2, Runnable runnable) {
        Snackbar a2 = Snackbar.a(view, (CharSequence) str, i2);
        if (str2 != null) {
            a2.a((CharSequence) str2, (View.OnClickListener) new View.OnClickListener(runnable) {
                private final /* synthetic */ Runnable f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BaseActivity.lambda$showSnackBar$2(Snackbar.this, this.f$1, view);
                }
            });
        }
        a2.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = a2.b();
        b2.setBackgroundColor(b.c(this, R.color.black));
        b2.findViewById(com.google.android.material.R.id.snackbar_text);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        a2.c();
    }

    public static /* synthetic */ void lambda$showSnackBar$2(Snackbar snackbar, Runnable runnable, View view) {
        snackbar.d();
        if (runnable != null) {
            runnable.run();
        }
    }

    public void addFragment(Class<? extends Fragment> cls, Bundle bundle, int i2) {
        Fragment c2 = getSupportFragmentManager().c(cls.getCanonicalName());
        if (c2 != null) {
            getSupportFragmentManager().a().a(c2).c();
        }
        try {
            Fragment fragment = (Fragment) cls.newInstance();
            fragment.setArguments(bundle);
            getSupportFragmentManager().a().a(i2, fragment, fragment.getClass().getCanonicalName()).c();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    public void removeFragment(Class<? extends Fragment> cls) {
        Fragment c2 = getSupportFragmentManager().c(cls.getCanonicalName());
        if (c2 != null) {
            getSupportFragmentManager().a().a(c2).c();
        }
    }

    public AssetManager getAssets() {
        super.getAssets();
        return getResources().getAssets();
    }
}
