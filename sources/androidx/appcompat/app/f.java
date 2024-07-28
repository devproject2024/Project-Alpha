package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.b;
import androidx.core.h.f;

public class f extends Dialog implements d {
    private e mDelegate;
    private final f.a mKeyDispatcher;

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public f(Context context) {
        this(context, 0);
    }

    public f(Context context, int i2) {
        super(context, getThemeResId(context, i2));
        this.mKeyDispatcher = new f.a() {
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return f.this.superDispatchKeyEvent(keyEvent);
            }
        };
        e delegate = getDelegate();
        delegate.a(getThemeResId(context, i2));
        delegate.c();
    }

    protected f(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new f.a() {
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return f.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().k();
        super.onCreate(bundle);
        getDelegate().c();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().a();
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

    public <T extends View> T findViewById(int i2) {
        return getDelegate().b(i2);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().a(charSequence);
    }

    public void setTitle(int i2) {
        super.setTitle(i2);
        getDelegate().a((CharSequence) getContext().getString(i2));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().b(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().f();
    }

    public void dismiss() {
        super.dismiss();
        getDelegate().i();
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().d(i2);
    }

    public void invalidateOptionsMenu() {
        getDelegate().h();
    }

    public e getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = e.a((Dialog) this, (d) this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.h.f.a(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}
