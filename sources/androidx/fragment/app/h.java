package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;

final class h implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    private final j f3419a;

    h(j jVar) {
        this.f3419a = jVar;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f3419a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, Item.KEY_CLASS);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !f.a(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f3419a.c(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f3419a.c(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f3419a.c(id);
        }
        if (j.a(2)) {
            StringBuilder sb = new StringBuilder("onCreateView: id=0x");
            sb.append(Integer.toHexString(resourceId));
            sb.append(" fname=");
            sb.append(attributeValue);
            sb.append(" existing=");
            sb.append(fragment);
        }
        if (fragment == null) {
            fragment = this.f3419a.u().c(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            j jVar = this.f3419a;
            fragment.mFragmentManager = jVar;
            fragment.mHost = jVar.k;
            fragment.onInflate(this.f3419a.k.f3416c, attributeSet, fragment.mSavedFragmentState);
            this.f3419a.j(fragment);
            this.f3419a.g(fragment);
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            fragment.mHost = this.f3419a.k;
            fragment.onInflate(this.f3419a.k.f3416c, attributeSet, fragment.mSavedFragmentState);
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        if (this.f3419a.j > 0 || !fragment.mFromLayout) {
            this.f3419a.g(fragment);
        } else {
            this.f3419a.a(fragment, 1);
        }
        if (fragment.mView != null) {
            if (resourceId != 0) {
                fragment.mView.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
