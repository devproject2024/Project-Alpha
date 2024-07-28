package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.lifecycle.ao;
import androidx.lifecycle.k;

final class n {

    /* renamed from: a  reason: collision with root package name */
    final Fragment f3455a;

    /* renamed from: b  reason: collision with root package name */
    int f3456b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final i f3457c;

    n(i iVar, Fragment fragment) {
        this.f3457c = iVar;
        this.f3455a = fragment;
    }

    n(i iVar, ClassLoader classLoader, f fVar, FragmentState fragmentState) {
        this.f3457c = iVar;
        this.f3455a = fVar.c(classLoader, fragmentState.f3366a);
        if (fragmentState.j != null) {
            fragmentState.j.setClassLoader(classLoader);
        }
        this.f3455a.setArguments(fragmentState.j);
        this.f3455a.mWho = fragmentState.f3367b;
        this.f3455a.mFromLayout = fragmentState.f3368c;
        Fragment fragment = this.f3455a;
        fragment.mRestored = true;
        fragment.mFragmentId = fragmentState.f3369d;
        this.f3455a.mContainerId = fragmentState.f3370e;
        this.f3455a.mTag = fragmentState.f3371f;
        this.f3455a.mRetainInstance = fragmentState.f3372g;
        this.f3455a.mRemoving = fragmentState.f3373h;
        this.f3455a.mDetached = fragmentState.f3374i;
        this.f3455a.mHidden = fragmentState.k;
        this.f3455a.mMaxState = k.b.values()[fragmentState.l];
        if (fragmentState.m != null) {
            this.f3455a.mSavedFragmentState = fragmentState.m;
        } else {
            this.f3455a.mSavedFragmentState = new Bundle();
        }
        if (j.a(2)) {
            new StringBuilder("Instantiated fragment ").append(this.f3455a);
        }
    }

    n(i iVar, Fragment fragment, FragmentState fragmentState) {
        this.f3457c = iVar;
        this.f3455a = fragment;
        Fragment fragment2 = this.f3455a;
        fragment2.mSavedViewState = null;
        fragment2.mBackStackNesting = 0;
        fragment2.mInLayout = false;
        fragment2.mAdded = false;
        fragment2.mTargetWho = fragment2.mTarget != null ? this.f3455a.mTarget.mWho : null;
        this.f3455a.mTarget = null;
        if (fragmentState.m != null) {
            this.f3455a.mSavedFragmentState = fragmentState.m;
        } else {
            this.f3455a.mSavedFragmentState = new Bundle();
        }
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        int i2 = this.f3456b;
        if (this.f3455a.mFromLayout) {
            if (this.f3455a.mInLayout) {
                i2 = Math.max(this.f3456b, 1);
            } else if (this.f3456b < 2) {
                i2 = Math.min(i2, this.f3455a.mState);
            } else {
                i2 = Math.min(i2, 1);
            }
        }
        if (!this.f3455a.mAdded) {
            i2 = Math.min(i2, 1);
        }
        if (this.f3455a.mRemoving) {
            if (this.f3455a.isInBackStack()) {
                i2 = Math.min(i2, 1);
            } else {
                i2 = Math.min(i2, -1);
            }
        }
        if (this.f3455a.mDeferStart && this.f3455a.mState < 3) {
            i2 = Math.min(i2, 2);
        }
        int i3 = AnonymousClass1.f3458a[this.f3455a.mMaxState.ordinal()];
        if (i3 == 1) {
            return i2;
        }
        if (i3 == 2) {
            return Math.min(i2, 3);
        }
        if (i3 != 3) {
            return Math.min(i2, -1);
        }
        return Math.min(i2, 1);
    }

    /* renamed from: androidx.fragment.app.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3458a = new int[k.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                androidx.lifecycle.k$b[] r0 = androidx.lifecycle.k.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3458a = r0
                int[] r0 = f3458a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.lifecycle.k$b r1 = androidx.lifecycle.k.b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3458a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.lifecycle.k$b r1 = androidx.lifecycle.k.b.STARTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3458a     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.lifecycle.k$b r1 = androidx.lifecycle.k.b.CREATED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.f3455a.mFromLayout && this.f3455a.mInLayout && !this.f3455a.mPerformedCreateView) {
            if (j.a(3)) {
                new StringBuilder("moveto CREATE_VIEW: ").append(this.f3455a);
            }
            Fragment fragment = this.f3455a;
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), (ViewGroup) null, this.f3455a.mSavedFragmentState);
            if (this.f3455a.mView != null) {
                this.f3455a.mView.setSaveFromParentEnabled(false);
                this.f3455a.mView.setTag(R.id.fragment_container_view_tag, this.f3455a);
                if (this.f3455a.mHidden) {
                    this.f3455a.mView.setVisibility(8);
                }
                Fragment fragment2 = this.f3455a;
                fragment2.onViewCreated(fragment2.mView, this.f3455a.mSavedFragmentState);
                i iVar = this.f3457c;
                Fragment fragment3 = this.f3455a;
                iVar.a(fragment3, fragment3.mView, this.f3455a.mSavedFragmentState, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ClassLoader classLoader) {
        if (this.f3455a.mSavedFragmentState != null) {
            this.f3455a.mSavedFragmentState.setClassLoader(classLoader);
            Fragment fragment = this.f3455a;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f3455a;
            fragment2.mTargetWho = fragment2.mSavedFragmentState.getString("android:target_state");
            if (this.f3455a.mTargetWho != null) {
                Fragment fragment3 = this.f3455a;
                fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            if (this.f3455a.mSavedUserVisibleHint != null) {
                Fragment fragment4 = this.f3455a;
                fragment4.mUserVisibleHint = fragment4.mSavedUserVisibleHint.booleanValue();
                this.f3455a.mSavedUserVisibleHint = null;
            } else {
                Fragment fragment5 = this.f3455a;
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            if (!this.f3455a.mUserVisibleHint) {
                this.f3455a.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(g<?> gVar, j jVar, Fragment fragment) {
        Fragment fragment2 = this.f3455a;
        fragment2.mHost = gVar;
        fragment2.mParentFragment = fragment;
        fragment2.mFragmentManager = jVar;
        this.f3457c.a(fragment2, gVar.f3416c);
        this.f3455a.performAttach();
        if (this.f3455a.mParentFragment == null) {
            gVar.a(this.f3455a);
        } else {
            this.f3455a.mParentFragment.onAttachFragment(this.f3455a);
        }
        this.f3457c.b(this.f3455a, gVar.f3416c);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (j.a(3)) {
            new StringBuilder("moveto CREATED: ").append(this.f3455a);
        }
        if (!this.f3455a.mIsCreated) {
            i iVar = this.f3457c;
            Fragment fragment = this.f3455a;
            iVar.a(fragment, fragment.mSavedFragmentState);
            Fragment fragment2 = this.f3455a;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            i iVar2 = this.f3457c;
            Fragment fragment3 = this.f3455a;
            iVar2.b(fragment3, fragment3.mSavedFragmentState);
            return;
        }
        Fragment fragment4 = this.f3455a;
        fragment4.restoreChildFragmentState(fragment4.mSavedFragmentState);
        this.f3455a.mState = 1;
    }

    /* JADX WARNING: type inference failed for: r5v20, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(androidx.fragment.app.d r5) {
        /*
            r4 = this;
            androidx.fragment.app.Fragment r0 = r4.f3455a
            boolean r0 = r0.mFromLayout
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.j.a((int) r0)
            if (r0 == 0) goto L_0x001a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "moveto CREATE_VIEW: "
            r0.<init>(r1)
            androidx.fragment.app.Fragment r1 = r4.f3455a
            r0.append(r1)
        L_0x001a:
            r0 = 0
            androidx.fragment.app.Fragment r1 = r4.f3455a
            android.view.ViewGroup r1 = r1.mContainer
            if (r1 == 0) goto L_0x0027
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.ViewGroup r0 = r5.mContainer
            goto L_0x00a3
        L_0x0027:
            androidx.fragment.app.Fragment r1 = r4.f3455a
            int r1 = r1.mContainerId
            if (r1 == 0) goto L_0x00a3
            androidx.fragment.app.Fragment r0 = r4.f3455a
            int r0 = r0.mContainerId
            r1 = -1
            if (r0 == r1) goto L_0x0088
            androidx.fragment.app.Fragment r0 = r4.f3455a
            int r0 = r0.mContainerId
            android.view.View r5 = r5.a(r0)
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x00a3
            androidx.fragment.app.Fragment r5 = r4.f3455a
            boolean r5 = r5.mRestored
            if (r5 == 0) goto L_0x0048
            goto L_0x00a3
        L_0x0048:
            androidx.fragment.app.Fragment r5 = r4.f3455a     // Catch:{ NotFoundException -> 0x0057 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x0057 }
            androidx.fragment.app.Fragment r0 = r4.f3455a     // Catch:{ NotFoundException -> 0x0057 }
            int r0 = r0.mContainerId     // Catch:{ NotFoundException -> 0x0057 }
            java.lang.String r5 = r5.getResourceName(r0)     // Catch:{ NotFoundException -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            java.lang.String r5 = "unknown"
        L_0x005a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "No view found for id 0x"
            r1.<init>(r2)
            androidx.fragment.app.Fragment r2 = r4.f3455a
            int r2 = r2.mContainerId
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r1.append(r2)
            java.lang.String r2 = " ("
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = ") for fragment "
            r1.append(r5)
            androidx.fragment.app.Fragment r5 = r4.f3455a
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0088:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot create fragment "
            r0.<init>(r1)
            androidx.fragment.app.Fragment r1 = r4.f3455a
            r0.append(r1)
            java.lang.String r1 = " for a container view with no id"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x00a3:
            androidx.fragment.app.Fragment r5 = r4.f3455a
            r5.mContainer = r0
            android.os.Bundle r1 = r5.mSavedFragmentState
            android.view.LayoutInflater r1 = r5.performGetLayoutInflater(r1)
            androidx.fragment.app.Fragment r2 = r4.f3455a
            android.os.Bundle r2 = r2.mSavedFragmentState
            r5.performCreateView(r1, r0, r2)
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r5 = r5.mView
            if (r5 == 0) goto L_0x0117
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r5 = r5.mView
            r1 = 0
            r5.setSaveFromParentEnabled(r1)
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r5 = r5.mView
            int r2 = androidx.fragment.R.id.fragment_container_view_tag
            androidx.fragment.app.Fragment r3 = r4.f3455a
            r5.setTag(r2, r3)
            if (r0 == 0) goto L_0x00d6
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r5 = r5.mView
            r0.addView(r5)
        L_0x00d6:
            androidx.fragment.app.Fragment r5 = r4.f3455a
            boolean r5 = r5.mHidden
            if (r5 == 0) goto L_0x00e5
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r5 = r5.mView
            r0 = 8
            r5.setVisibility(r0)
        L_0x00e5:
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r5 = r5.mView
            androidx.core.h.u.z(r5)
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r0 = r5.mView
            androidx.fragment.app.Fragment r2 = r4.f3455a
            android.os.Bundle r2 = r2.mSavedFragmentState
            r5.onViewCreated(r0, r2)
            androidx.fragment.app.i r5 = r4.f3457c
            androidx.fragment.app.Fragment r0 = r4.f3455a
            android.view.View r2 = r0.mView
            androidx.fragment.app.Fragment r3 = r4.f3455a
            android.os.Bundle r3 = r3.mSavedFragmentState
            r5.a(r0, r2, r3, r1)
            androidx.fragment.app.Fragment r5 = r4.f3455a
            android.view.View r0 = r5.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0115
            androidx.fragment.app.Fragment r0 = r4.f3455a
            android.view.ViewGroup r0 = r0.mContainer
            if (r0 == 0) goto L_0x0115
            r1 = 1
        L_0x0115:
            r5.mIsNewlyAdded = r1
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.a(androidx.fragment.app.d):void");
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (j.a(3)) {
            new StringBuilder("moveto ACTIVITY_CREATED: ").append(this.f3455a);
        }
        Fragment fragment = this.f3455a;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        i iVar = this.f3457c;
        Fragment fragment2 = this.f3455a;
        iVar.c(fragment2, fragment2.mSavedFragmentState);
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (j.a(3)) {
            new StringBuilder("moveto RESTORE_VIEW_STATE: ").append(this.f3455a);
        }
        if (this.f3455a.mView != null) {
            Fragment fragment = this.f3455a;
            fragment.restoreViewState(fragment.mSavedFragmentState);
        }
        this.f3455a.mSavedFragmentState = null;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        if (j.a(3)) {
            new StringBuilder("moveto STARTED: ").append(this.f3455a);
        }
        this.f3455a.performStart();
        this.f3457c.a(this.f3455a);
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (j.a(3)) {
            new StringBuilder("moveto RESUMED: ").append(this.f3455a);
        }
        this.f3455a.performResume();
        this.f3457c.b(this.f3455a);
        Fragment fragment = this.f3455a;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        if (j.a(3)) {
            new StringBuilder("movefrom RESUMED: ").append(this.f3455a);
        }
        this.f3455a.performPause();
        this.f3457c.c(this.f3455a);
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        if (j.a(3)) {
            new StringBuilder("movefrom STARTED: ").append(this.f3455a);
        }
        this.f3455a.performStop();
        this.f3457c.d(this.f3455a);
    }

    /* access modifiers changed from: package-private */
    public final FragmentState j() {
        FragmentState fragmentState = new FragmentState(this.f3455a);
        if (this.f3455a.mState < 0 || fragmentState.m != null) {
            fragmentState.m = this.f3455a.mSavedFragmentState;
        } else {
            fragmentState.m = k();
            if (this.f3455a.mTargetWho != null) {
                if (fragmentState.m == null) {
                    fragmentState.m = new Bundle();
                }
                fragmentState.m.putString("android:target_state", this.f3455a.mTargetWho);
                if (this.f3455a.mTargetRequestCode != 0) {
                    fragmentState.m.putInt("android:target_req_state", this.f3455a.mTargetRequestCode);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    public final Bundle k() {
        Bundle bundle = new Bundle();
        this.f3455a.performSaveInstanceState(bundle);
        this.f3457c.d(this.f3455a, bundle);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f3455a.mView != null) {
            l();
        }
        if (this.f3455a.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f3455a.mSavedViewState);
        }
        if (!this.f3455a.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f3455a.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final void l() {
        if (this.f3455a.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f3455a.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f3455a.mSavedViewState = sparseArray;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(g<?> gVar, l lVar) {
        if (j.a(3)) {
            new StringBuilder("movefrom CREATED: ").append(this.f3455a);
        }
        boolean z = true;
        boolean z2 = this.f3455a.mRemoving && !this.f3455a.isInBackStack();
        if (z2 || lVar.b(this.f3455a)) {
            if (gVar instanceof ao) {
                z = lVar.f3453e;
            } else if (gVar.f3416c instanceof Activity) {
                z = true ^ ((Activity) gVar.f3416c).isChangingConfigurations();
            }
            if (z2 || z) {
                lVar.d(this.f3455a);
            }
            this.f3455a.performDestroy();
            this.f3457c.f(this.f3455a);
            return;
        }
        this.f3455a.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(l lVar) {
        if (j.a(3)) {
            new StringBuilder("movefrom ATTACHED: ").append(this.f3455a);
        }
        this.f3455a.performDetach();
        this.f3457c.g(this.f3455a);
        Fragment fragment = this.f3455a;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((fragment.mRemoving && !this.f3455a.isInBackStack()) || lVar.b(this.f3455a)) {
            if (j.a(3)) {
                new StringBuilder("initState called for fragment: ").append(this.f3455a);
            }
            this.f3455a.initState();
        }
    }
}
