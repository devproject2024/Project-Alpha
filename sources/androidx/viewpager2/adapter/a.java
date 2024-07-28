package androidx.viewpager2.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.a.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.i;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public abstract class a extends RecyclerView.a<b> implements c {

    /* renamed from: a  reason: collision with root package name */
    final k f4974a;

    /* renamed from: b  reason: collision with root package name */
    final j f4975b;

    /* renamed from: c  reason: collision with root package name */
    final d<Fragment> f4976c;

    /* renamed from: d  reason: collision with root package name */
    C0075a f4977d;

    public long getItemId(int i2) {
        return (long) i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(final Fragment fragment, final FrameLayout frameLayout) {
        this.f4975b.f3432i.f3420a.add(new i.a(new j.b() {
            public final void a(j jVar, Fragment fragment, View view) {
                if (fragment == fragment) {
                    i iVar = jVar.f3432i;
                    synchronized (iVar.f3420a) {
                        int i2 = 0;
                        int size = iVar.f3420a.size();
                        while (true) {
                            if (i2 >= size) {
                                break;
                            } else if (iVar.f3420a.get(i2).f3422a == this) {
                                iVar.f3420a.remove(i2);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    a.a(view, frameLayout);
                }
            }
        }));
    }

    static void a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    /* renamed from: androidx.viewpager2.adapter.a$a  reason: collision with other inner class name */
    class C0075a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f4981a;

        /* renamed from: b  reason: collision with root package name */
        private ViewPager2 f4982b;

        /* renamed from: c  reason: collision with root package name */
        private long f4983c;

        /* access modifiers changed from: package-private */
        public final void a() {
            int currentItem;
            if (!this.f4981a.f4975b.i() && this.f4982b.getScrollState() == 0 && !this.f4981a.f4976c.c() && this.f4981a.getItemCount() != 0 && (currentItem = this.f4982b.getCurrentItem()) < this.f4981a.getItemCount()) {
                long itemId = this.f4981a.getItemId(currentItem);
                if (itemId != this.f4983c) {
                    Fragment fragment = null;
                    Fragment a2 = this.f4981a.f4976c.a(itemId, null);
                    if (a2 != null && a2.isAdded()) {
                        this.f4983c = itemId;
                        q a3 = this.f4981a.f4975b.a();
                        for (int i2 = 0; i2 < this.f4981a.f4976c.b(); i2++) {
                            long b2 = this.f4981a.f4976c.b(i2);
                            Fragment c2 = this.f4981a.f4976c.c(i2);
                            if (c2.isAdded()) {
                                if (b2 != this.f4983c) {
                                    a3.a(c2, k.b.STARTED);
                                } else {
                                    fragment = c2;
                                }
                                c2.setMenuVisibility(b2 == this.f4983c);
                            }
                        }
                        if (fragment != null) {
                            a3.a(fragment, k.b.RESUMED);
                        }
                        if (!a3.h()) {
                            a3.d();
                        }
                    }
                }
            }
        }
    }
}
