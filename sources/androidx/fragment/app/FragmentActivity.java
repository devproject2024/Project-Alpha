package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.a.h;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.c;
import androidx.core.app.a;
import androidx.core.app.o;
import androidx.lifecycle.an;
import androidx.lifecycle.ao;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements a.C0038a, a.c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final t mFragmentLifecycleRegistry = new t(this);
    final e mFragments = e.a((g<?>) new a());
    int mNextCandidateRequestIndex;
    h<String> mPendingFragmentActivityResults;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mStartedActivityFromFragment;
    boolean mStartedIntentSenderFromFragment;
    boolean mStopped = true;

    public void onAttachFragment(Fragment fragment) {
    }

    public FragmentActivity() {
    }

    public FragmentActivity(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment a2;
        this.mFragments.a();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String a3 = this.mPendingFragmentActivityResults.a(i5, null);
            this.mPendingFragmentActivityResults.a(i5);
            if (a3 != null && (a2 = this.mFragments.a(a3)) != null) {
                a2.onActivityResult(i2 & 65535, i3, intent);
                return;
            }
            return;
        }
        a.b a4 = androidx.core.app.a.a();
        if (a4 == null || !a4.b()) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.a.b(this);
    }

    public void setEnterSharedElementCallback(o oVar) {
        androidx.core.app.a.a((Activity) this, oVar);
    }

    public void setExitSharedElementCallback(o oVar) {
        androidx.core.app.a.b(this, oVar);
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.a.c(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.a.d(this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.f3412a.f3418e.b(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.f3412a.f3418e.c(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.a();
        this.mFragments.f3412a.f3418e.a(configuration);
    }

    public void onCreate(Bundle bundle) {
        e eVar = this.mFragments;
        eVar.f3412a.f3418e.a(eVar.f3412a, (d) eVar.f3412a, (Fragment) null);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(FRAGMENTS_TAG);
            e eVar2 = this.mFragments;
            if (eVar2.f3412a instanceof ao) {
                eVar2.f3412a.f3418e.a(parcelable);
                if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                    this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                    int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                    String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                    if (!(intArray == null || stringArray == null || intArray.length != stringArray.length)) {
                        this.mPendingFragmentActivityResults = new h<>(intArray.length);
                        for (int i2 = 0; i2 < intArray.length; i2++) {
                            this.mPendingFragmentActivityResults.b(intArray[i2], stringArray[i2]);
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new h<>();
            this.mNextCandidateRequestIndex = 0;
        }
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.a(k.a.ON_CREATE);
        this.mFragments.f3412a.f3418e.m();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        e eVar = this.mFragments;
        return onCreatePanelMenu | eVar.f3412a.f3418e.a(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f3412a.f3418e.f3426c.onCreateView(view, str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f3412a.f3418e.r();
        this.mFragmentLifecycleRegistry.a(k.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.f3412a.f3418e.s();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mFragments.f3412a.f3418e.a(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.mFragments.f3412a.f3418e.b(menuItem);
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.f3412a.f3418e.b(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f3412a.f3418e.d(3);
        this.mFragmentLifecycleRegistry.a(k.a.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.a();
    }

    public void onStateNotSaved() {
        this.mFragments.a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mResumed = true;
        this.mFragments.a();
        this.mFragments.b();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.a(k.a.ON_RESUME);
        this.mFragments.f3412a.f3418e.p();
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return i2 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.f3412a.f3418e.a(menu) : super.onPreparePanel(i2, view, menu);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.a(k.a.ON_STOP);
        Parcelable k = this.mFragments.f3412a.f3418e.k();
        if (k != null) {
            bundle.putParcelable(FRAGMENTS_TAG, k);
        }
        if (this.mPendingFragmentActivityResults.b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.b()];
            for (int i2 = 0; i2 < this.mPendingFragmentActivityResults.b(); i2++) {
                iArr[i2] = this.mPendingFragmentActivityResults.b(i2);
                strArr[i2] = this.mPendingFragmentActivityResults.c(i2);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.f3412a.f3418e.n();
        }
        this.mFragments.a();
        this.mFragments.b();
        this.mFragmentLifecycleRegistry.a(k.a.ON_START);
        this.mFragments.f3412a.f3418e.o();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.f3412a.f3418e.q();
        this.mFragmentLifecycleRegistry.a(k.a.ON_STOP);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.f3412a.f3418e.a(str, fileDescriptor, printWriter, strArr);
    }

    public j getSupportFragmentManager() {
        return this.mFragments.f3412a.f3418e;
    }

    @Deprecated
    public androidx.loader.a.a getSupportLoaderManager() {
        return androidx.loader.a.a.a(this);
    }

    public void startActivityForResult(Intent intent, int i2) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        if (!this.mStartedActivityFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.mStartedIntentSenderFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    static void checkForValidRequestCode(int i2) {
        if ((i2 & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public final void validateRequestPermissionsRequestCode(int i2) {
        if (!this.mRequestedPermissionsFromFragment && i2 != -1) {
            checkForValidRequestCode(i2);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Fragment a2;
        this.mFragments.a();
        int i3 = (i2 >> 16) & 65535;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String a3 = this.mPendingFragmentActivityResults.a(i4, null);
            this.mPendingFragmentActivityResults.a(i4);
            if (a3 != null && (a2 = this.mFragments.a(a3)) != null) {
                a2.onRequestPermissionsResult(i2 & 65535, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i2 == -1) {
            try {
                androidx.core.app.a.a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i2);
            androidx.core.app.a.a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (i2 & 65535), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        int i6 = i2;
        this.mStartedIntentSenderFromFragment = true;
        if (i6 == -1) {
            try {
                androidx.core.app.a.a(this, intentSender, i2, intent, i3, i4, i5, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            checkForValidRequestCode(i2);
            androidx.core.app.a.a(this, intentSender, ((allocateRequestIndex(fragment) + 1) << 16) + (i6 & 65535), intent, i3, i4, i5, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.d(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i2 = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.b(i2, fragment.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i2) {
        if (i2 == -1) {
            androidx.core.app.a.a(this, strArr, i2);
            return;
        }
        checkForValidRequestCode(i2);
        try {
            this.mRequestedPermissionsFromFragment = true;
            androidx.core.app.a.a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (i2 & 65535));
            this.mRequestedPermissionsFromFragment = false;
        } catch (Throwable th) {
            this.mRequestedPermissionsFromFragment = false;
            throw th;
        }
    }

    class a extends g<FragmentActivity> implements c, ao {
        public a() {
            super(FragmentActivity.this);
        }

        public final k getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public final an getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public final void a(String str, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, (FileDescriptor) null, printWriter, strArr);
        }

        public final boolean b() {
            return !FragmentActivity.this.isFinishing();
        }

        public final LayoutInflater c() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public final void d() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        public final void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i2, bundle);
        }

        public final void a(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
            FragmentActivity.this.startIntentSenderFromFragment(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
        }

        public final void a(Fragment fragment, String[] strArr, int i2) {
            FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i2);
        }

        public final boolean a(String str) {
            return androidx.core.app.a.a((Activity) FragmentActivity.this, str);
        }

        public final void a(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public final View a(int i2) {
            return FragmentActivity.this.findViewById(i2);
        }

        public final boolean a() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public final /* bridge */ /* synthetic */ Object e() {
            return FragmentActivity.this;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), k.b.CREATED));
    }

    private static boolean markState(j jVar, k.b bVar) {
        boolean z = false;
        for (Fragment next : jVar.f3424a.d()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z |= markState(next.getChildFragmentManager(), bVar);
                }
                if (next.getLifecycle().a().isAtLeast(k.b.STARTED)) {
                    next.mLifecycleRegistry.b(bVar);
                    z = true;
                }
            }
        }
        return z;
    }
}
