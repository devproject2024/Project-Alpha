package com.alipay.mobile.framework.app.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alipay.mobile.a.c;
import com.alipay.mobile.framework.app.a;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.framework.b;

public abstract class BaseFragmentActivity extends FragmentActivity {
    static final String TAG = BaseFragmentActivity.class.getSimpleName();
    f app = null;

    public void addLoadingView(View view) {
    }

    public a getActivityApplication() {
        return null;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    /* access modifiers changed from: protected */
    public void replaceResources(Context context) {
    }

    public void startLoading() {
    }

    public void stopLoading() {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        Object[] objArr = {motionEvent};
        c.a("boolean com.alipay.mobile.framework.app.ui.BaseFragmentActivity.dispatchTouchEvent(MotionEvent)", this, objArr);
        Pair<Boolean, Object> b2 = c.b("boolean com.alipay.mobile.framework.app.ui.BaseFragmentActivity.dispatchTouchEvent(MotionEvent)", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            z = _dispatchTouchEvent(motionEvent);
        }
        c.c("boolean com.alipay.mobile.framework.app.ui.BaseFragmentActivity.dispatchTouchEvent(MotionEvent)", this, objArr);
        return z;
    }

    private boolean _dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            new StringBuilder("MotionEvent ").append(motionEvent.getAction());
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = false;
        Object[] objArr = {keyEvent};
        c.a("boolean com.alipay.mobile.framework.app.ui.BaseFragmentActivity.dispatchKeyEvent(KeyEvent)", this, objArr);
        Pair<Boolean, Object> b2 = c.b("boolean com.alipay.mobile.framework.app.ui.BaseFragmentActivity.dispatchKeyEvent(KeyEvent)", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            z = _dispatchKeyEvent(keyEvent);
        }
        c.c("boolean com.alipay.mobile.framework.app.ui.BaseFragmentActivity.dispatchKeyEvent(KeyEvent)", this, objArr);
        return z;
    }

    public boolean _dispatchKeyEvent(KeyEvent keyEvent) {
        try {
            return super.dispatchKeyEvent(keyEvent);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        Object[] objArr = {bundle};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onCreate(Bundle)", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onCreate(Bundle)", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onCreate(bundle);
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onCreate(Bundle)", this, objArr);
    }

    private void _onCreate(Bundle bundle) {
        String str;
        try {
            str = getIntent().getStringExtra("app_id");
        } catch (Throwable unused) {
            str = "";
        }
        this.app = !TextUtils.isEmpty(str) ? b.a().f14954a.f14961b.get(str) : null;
        StringBuilder sb = new StringBuilder("_onCreate appId ");
        sb.append(str);
        sb.append(" app: ");
        sb.append(this.app);
        super.onCreate(bundle);
    }

    public void onResume() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onResume()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onResume()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onResume();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onResume()", this, objArr);
    }

    private void _onResume() {
        super.onResume();
    }

    public void onPause() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onPause()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onPause()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onPause();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onPause()", this, objArr);
    }

    private void _onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onBackPressed()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onBackPressed()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onBackPressed();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onBackPressed()", this, objArr);
    }

    private void _onBackPressed() {
        try {
            super.onBackPressed();
        } catch (Exception unused) {
            finish();
        }
    }

    public void onNewIntent(Intent intent) {
        Object[] objArr = {intent};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onNewIntent(Intent)", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onNewIntent(Intent)", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onNewIntent(intent);
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onNewIntent(Intent)", this, objArr);
    }

    private void _onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onUserLeaveHint()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onUserLeaveHint()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onUserLeaveHint();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onUserLeaveHint()", this, objArr);
    }

    private void _onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    public void onWindowFocusChanged(boolean z) {
        Object[] objArr = {Boolean.valueOf(z)};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onWindowFocusChanged(boolean)", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onWindowFocusChanged(boolean)", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onWindowFocusChanged(z);
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onWindowFocusChanged(boolean)", this, objArr);
    }

    private void _onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void onSaveInstanceState(Bundle bundle) {
        Object[] objArr = {bundle};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onSaveInstanceState(Bundle)", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onSaveInstanceState(Bundle)", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onSaveInstanceState(bundle);
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onSaveInstanceState(Bundle)", this, objArr);
    }

    private void _onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onStart()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onStart()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onStart();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onStart()", this, objArr);
    }

    private void _onStart() {
        super.onStart();
    }

    public void onStop() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onStop()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onStop()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onStop();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onStop()", this, objArr);
    }

    private void _onStop() {
        super.onStop();
    }

    public void onDestroy() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onDestroy()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onDestroy()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onDestroy();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onDestroy()", this, objArr);
    }

    private void _onDestroy() {
        f fVar = this.app;
        if (fVar != null) {
            fVar.destroy((Bundle) null);
            com.alipay.mobile.framework.c cVar = b.a().f14954a;
            f fVar2 = this.app;
            if (fVar2 != null) {
                cVar.f14961b.remove(fVar2.getAppId());
            }
            StringBuilder sb = new StringBuilder("_onDestroy appId ");
            sb.append(this.app.getAppId());
            sb.append(" app: ");
            sb.append(this.app);
        }
        super.onDestroy();
    }

    public void onContentChanged() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onContentChanged()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onContentChanged()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _onContentChanged();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onContentChanged()", this, objArr);
    }

    private void _onContentChanged() {
        super.onContentChanged();
    }

    public void finish() {
        Object[] objArr = new Object[0];
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.finish()", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.finish()", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            _finish();
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.finish()", this, objArr);
    }

    private void _finish() {
        try {
            super.finish();
        } catch (Throwable unused) {
        }
    }

    public void setContentView(int i2) {
        Object[] objArr = {Integer.valueOf(i2)};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.setContentView(int layoutResID)", this, objArr);
        super.setContentView(i2);
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.setContentView(int layoutResID)", this, objArr);
    }

    public void setContentView(View view) {
        Object[] objArr = {view};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.setContentView(View view)", this, objArr);
        super.setContentView(view);
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.setContentView(View view)", this, objArr);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Object[] objArr = {view, layoutParams};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.setContentView(View view, ViewGroup.LayoutParams params)", this, objArr);
        super.setContentView(view, layoutParams);
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.setContentView(View view, ViewGroup.LayoutParams params)", this, objArr);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), intent};
        c.a("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onActivityResult(int,resultCode,Intent)", this, objArr);
        Pair<Boolean, Object> b2 = c.b("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onActivityResult(int,resultCode,Intent)", this, objArr);
        if (b2 == null || !((Boolean) b2.first).booleanValue()) {
            super.onActivityResult(i2, i3, intent);
        }
        c.c("void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.onActivityResult(int,resultCode,Intent)", this, objArr);
    }
}
