package androidx.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.ac;
import androidx.lifecycle.ae;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import androidx.lifecycle.ao;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.t;
import androidx.savedstate.b;
import androidx.savedstate.c;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements c, ao, j, q, c {
    private int mContentLayoutId;
    private al.b mDefaultFactory;
    private final t mLifecycleRegistry;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final b mSavedStateRegistryController;
    private an mViewModelStore;

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object f969a;

        /* renamed from: b  reason: collision with root package name */
        an f970b;

        a() {
        }
    }

    public ComponentActivity() {
        this.mLifecycleRegistry = new t(this);
        this.mSavedStateRegistryController = b.a((c) this);
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            public final void run() {
                ComponentActivity.super.onBackPressed();
            }
        });
        if (getLifecycle() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                getLifecycle().a(new o() {
                    public final void a(q qVar, k.a aVar) {
                        if (aVar == k.a.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            getLifecycle().a(new o() {
                public final void a(q qVar, k.a aVar) {
                    if (aVar == k.a.ON_DESTROY && !ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().b();
                    }
                }
            });
            if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public ComponentActivity(int i2) {
        this();
        this.mContentLayoutId = i2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedStateRegistryController.a(bundle);
        ac.a((Activity) this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        k lifecycle = getLifecycle();
        if (lifecycle instanceof t) {
            ((t) lifecycle).b(k.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
    }

    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        an anVar = this.mViewModelStore;
        if (anVar == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            anVar = aVar.f970b;
        }
        if (anVar == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f969a = onRetainCustomNonConfigurationInstance;
        aVar2.f970b = anVar;
        return aVar2;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f969a;
        }
        return null;
    }

    public k getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public an getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                a aVar = (a) getLastNonConfigurationInstance();
                if (aVar != null) {
                    this.mViewModelStore = aVar.f970b;
                }
                if (this.mViewModelStore == null) {
                    this.mViewModelStore = new an();
                }
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public al.b getDefaultViewModelProviderFactory() {
        if (getApplication() != null) {
            if (this.mDefaultFactory == null) {
                this.mDefaultFactory = new ae(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.a();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f4517a;
    }
}
