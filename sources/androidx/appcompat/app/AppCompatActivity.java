package androidx.appcompat.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ah;
import androidx.core.app.f;
import androidx.core.app.p;
import androidx.fragment.app.FragmentActivity;

public class AppCompatActivity extends FragmentActivity implements a.b, d, p.a {
    private e mDelegate;
    private Resources mResources;

    /* access modifiers changed from: protected */
    public void onNightModeChanged(int i2) {
    }

    public void onPrepareSupportNavigateUpTaskStack(p pVar) {
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Deprecated
    public void setSupportProgress(int i2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    public AppCompatActivity() {
    }

    public AppCompatActivity(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().a(context));
    }

    public void onCreate(Bundle bundle) {
        e delegate = getDelegate();
        delegate.k();
        delegate.c();
        super.onCreate(bundle);
    }

    public void setTheme(int i2) {
        super.setTheme(i2);
        getDelegate().a(i2);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().d();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().a();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().b();
    }

    public void setContentView(int i2) {
        getDelegate().c(i2);
    }

    public void setContentView(View view) {
        getDelegate().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().a(configuration);
    }

    public void onPostResume() {
        super.onPostResume();
        getDelegate().g();
    }

    public void onStart() {
        super.onStart();
        getDelegate().e();
    }

    public void onStop() {
        super.onStop();
        getDelegate().f();
    }

    public <T extends View> T findViewById(int i2) {
        return getDelegate().b(i2);
    }

    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.c() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public void onDestroy() {
        super.onDestroy();
        getDelegate().i();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().a(charSequence);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().d(i2);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().h();
    }

    public void invalidateOptionsMenu() {
        getDelegate().h();
    }

    public b startSupportActionMode(b.a aVar) {
        return getDelegate().a(aVar);
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            p a2 = p.a((Context) this);
            onCreateSupportNavigateUpTaskStack(a2);
            onPrepareSupportNavigateUpTaskStack(a2);
            a2.a();
            try {
                androidx.core.app.a.a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    public Intent getSupportParentActivityIntent() {
        return f.a(this);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return f.a((Activity) this, intent);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public a.C0021a getDrawerToggleDelegate() {
        return getDelegate().j();
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate();
    }

    public e getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = e.a((Activity) this, (d) this);
        }
        return this.mDelegate;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.a(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public Resources getResources() {
        if (this.mResources == null && ah.a()) {
            this.mResources = new ah(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean performMenuItemShortcut(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x003e
            boolean r0 = r3.isCtrlPressed()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getMetaState()
            boolean r0 = android.view.KeyEvent.metaStateHasNoModifiers(r0)
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getRepeatCount()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getKeyCode()
            boolean r0 = android.view.KeyEvent.isModifierKey(r0)
            if (r0 != 0) goto L_0x003e
            android.view.Window r0 = r2.getWindow()
            if (r0 == 0) goto L_0x003e
            android.view.View r1 = r0.getDecorView()
            if (r1 == 0) goto L_0x003e
            android.view.View r0 = r0.getDecorView()
            boolean r3 = r0.dispatchKeyShortcutEvent(r3)
            if (r3 == 0) goto L_0x003e
            r3 = 1
            return r3
        L_0x003e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatActivity.performMenuItemShortcut(android.view.KeyEvent):boolean");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.i()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.j()) {
            super.closeOptionsMenu();
        }
    }

    public void onCreateSupportNavigateUpTaskStack(p pVar) {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = f.a(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(pVar.f2809b.getPackageManager());
            }
            pVar.a(component);
            pVar.a(supportParentActivityIntent);
        }
    }

    public void supportNavigateUpTo(Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }
}
