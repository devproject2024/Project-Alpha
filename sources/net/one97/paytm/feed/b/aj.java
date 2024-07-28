package net.one97.paytm.feed.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.ui.feed.g.c;

public final class aj extends ai implements a.C0556a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f33841d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f33842e = null;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f33843f;

    /* renamed from: g  reason: collision with root package name */
    private long f33844g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public aj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f33841d, f33842e));
    }

    private aj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f33844g = -1;
        this.f33838a.setTag((Object) null);
        setRootTag(view);
        this.f33843f = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33844g = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33844g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f33840c = (c) obj;
            synchronized (this) {
                this.f33844g |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f33839b = (FeedLanguageData) obj;
            synchronized (this) {
                this.f33844g |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        Drawable drawable;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f33844g;
            this.f33844g = 0;
        }
        FeedLanguageData feedLanguageData = this.f33839b;
        String str = null;
        boolean z = false;
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (feedLanguageData != null) {
                z = feedLanguageData.isSelected();
                str = feedLanguageData.getLocaleName();
            }
            if (i3 != 0) {
                if (z) {
                    j3 = j | 16;
                    j2 = 64;
                } else {
                    j3 = j | 8;
                    j2 = 32;
                }
                j = j3 | j2;
            }
            i2 = getColorFromResource(this.f33838a, z ? R.color.feed_white : R.color.unselected_text);
            drawable = getDrawableFromResource(this.f33838a, z ? R.drawable.feed_language_selected : R.drawable.feed_language_rounded_border);
        } else {
            drawable = null;
            i2 = 0;
        }
        if ((6 & j) != 0) {
            androidx.databinding.a.e.a((View) this.f33838a, drawable);
            d.a(this.f33838a, (CharSequence) str);
            this.f33838a.setTextColor(i2);
        }
        if ((j & 4) != 0) {
            this.f33838a.setOnClickListener(this.f33843f);
        }
    }

    public final void a(int i2, View view) {
        c cVar = this.f33840c;
        FeedLanguageData feedLanguageData = this.f33839b;
        if (cVar != null) {
            k.c(view, "view");
            k.c(feedLanguageData, "data");
            if (feedLanguageData.isSelected()) {
                feedLanguageData.setSelected(false);
                view.setBackground(b.a(view.getContext(), R.drawable.feed_language_rounded_border));
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    textView.setTextColor(b.c(textView.getContext(), R.color.unselected_text));
                    return;
                }
                return;
            }
            feedLanguageData.setSelected(true);
            view.setBackground(b.a(view.getContext(), R.drawable.feed_language_selected));
            if (view instanceof TextView) {
                TextView textView2 = (TextView) view;
                textView2.setTextColor(b.c(textView2.getContext(), R.color.feed_white));
            }
        }
    }
}
