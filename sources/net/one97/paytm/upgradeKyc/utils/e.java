package net.one97.paytm.upgradeKyc.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.viewpager.widget.a;
import java.util.ArrayList;

public abstract class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final j f66327a;

    /* renamed from: b  reason: collision with root package name */
    private q f66328b = null;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f66329c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Fragment> f66330d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f66331e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private Fragment f66332f = null;

    public abstract Fragment a();

    public String a(int i2) {
        return null;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public e(j jVar) {
        this.f66327a = jVar;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        String a2 = a(i2);
        if (this.f66330d.size() > i2 && (fragment = this.f66330d.get(i2)) != null && TextUtils.equals(a2, fragment.getTag())) {
            return fragment;
        }
        if (this.f66328b == null) {
            this.f66328b = this.f66327a.a();
        }
        Fragment a3 = a();
        if (this.f66329c.size() > i2 && TextUtils.equals(a2, this.f66331e.get(i2)) && (savedState = this.f66329c.get(i2)) != null) {
            a3.setInitialSavedState(savedState);
        }
        while (this.f66330d.size() <= i2) {
            this.f66330d.add((Object) null);
        }
        a3.setMenuVisibility(false);
        a3.setUserVisibleHint(false);
        this.f66330d.set(i2, a3);
        this.f66328b.a(viewGroup.getId(), a3, a2);
        return a3;
    }

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f66328b == null) {
            this.f66328b = this.f66327a.a();
        }
        while (this.f66329c.size() <= i2) {
            this.f66329c.add((Object) null);
            this.f66331e.add((Object) null);
        }
        this.f66329c.set(i2, fragment.isAdded() ? this.f66327a.d(fragment) : null);
        this.f66331e.set(i2, fragment.getTag());
        this.f66330d.set(i2, (Object) null);
        this.f66328b.a(fragment);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f66332f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f66332f.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f66332f = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        q qVar = this.f66328b;
        if (qVar != null) {
            qVar.c();
            this.f66328b = null;
            this.f66327a.b();
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f66329c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f66329c.size()];
            this.f66329c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
            bundle.putStringArrayList("tags", this.f66331e);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f66330d.size(); i2++) {
            Fragment fragment = this.f66330d.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f66327a.a(bundle, "f".concat(String.valueOf(i2)), fragment);
            }
        }
        return bundle;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f66329c.clear();
            this.f66330d.clear();
            ArrayList<String> stringArrayList = bundle.getStringArrayList("tags");
            if (stringArrayList != null) {
                this.f66331e = stringArrayList;
            } else {
                this.f66331e.clear();
            }
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f66329c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a2 = this.f66327a.a(bundle, str);
                    if (a2 != null) {
                        while (this.f66330d.size() <= parseInt) {
                            this.f66330d.add((Object) null);
                        }
                        a2.setMenuVisibility(false);
                        this.f66330d.set(parseInt, a2);
                    }
                }
            }
        }
    }
}
