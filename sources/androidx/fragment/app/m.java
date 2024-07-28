package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.k;
import androidx.viewpager.widget.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public abstract class m extends a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private q mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final j mFragmentManager;

    public abstract Fragment getItem(int i2);

    public long getItemId(int i2) {
        return (long) i2;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public m(j jVar) {
        this(jVar, 0);
    }

    public m(j jVar, int i2) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = jVar;
        this.mBehavior = i2;
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.a();
        }
        long itemId = getItemId(i2);
        Fragment c2 = this.mFragmentManager.c(makeFragmentName(viewGroup.getId(), itemId));
        if (c2 != null) {
            this.mCurTransaction.f(c2);
        } else {
            c2 = getItem(i2);
            this.mCurTransaction.a(viewGroup.getId(), c2, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (c2 != this.mCurrentPrimaryItem) {
            c2.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.a(c2, k.b.STARTED);
            } else {
                c2.setUserVisibleHint(false);
            }
        }
        return c2;
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.a();
        }
        this.mCurTransaction.d(fragment);
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.a();
                    }
                    this.mCurTransaction.a(this.mCurrentPrimaryItem, k.b.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.a();
                }
                this.mCurTransaction.a(fragment, k.b.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        q qVar = this.mCurTransaction;
        if (qVar != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    qVar.e();
                    this.mExecutingFinishUpdate = false;
                } catch (Throwable th) {
                    this.mExecutingFinishUpdate = false;
                    throw th;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    private static String makeFragmentName(int i2, long j) {
        return "android:switcher:" + i2 + AppConstants.COLON + j;
    }
}
