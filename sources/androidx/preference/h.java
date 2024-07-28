package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.u;
import androidx.preference.Preference;
import androidx.preference.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h extends RecyclerView.a<k> implements Preference.a {

    /* renamed from: a  reason: collision with root package name */
    private PreferenceGroup f30869a;

    /* renamed from: b  reason: collision with root package name */
    private List<Preference> f30870b;

    /* renamed from: c  reason: collision with root package name */
    private List<Preference> f30871c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f30872d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f30873e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f30874f = new Runnable() {
        public final void run() {
            h.this.b();
        }
    };

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a(i2).a((k) vVar);
    }

    public h(PreferenceGroup preferenceGroup) {
        this.f30869a = preferenceGroup;
        this.f30873e = new Handler();
        this.f30869a.x = this;
        this.f30870b = new ArrayList();
        this.f30871c = new ArrayList();
        this.f30872d = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f30869a;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).f30805d);
        } else {
            setHasStableIds(true);
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        for (Preference preference : this.f30870b) {
            preference.x = null;
        }
        this.f30870b = new ArrayList(this.f30870b.size());
        a(this.f30870b, this.f30869a);
        final List<Preference> list = this.f30871c;
        final List<Preference> a2 = a(this.f30869a);
        this.f30871c = a2;
        i iVar = this.f30869a.k;
        if (iVar == null || iVar.f30888d == null) {
            notifyDataSetChanged();
        } else {
            final i.d dVar = iVar.f30888d;
            androidx.recyclerview.widget.h.a(new h.a() {
                public final int getOldListSize() {
                    return list.size();
                }

                public final int getNewListSize() {
                    return a2.size();
                }

                public final boolean areItemsTheSame(int i2, int i3) {
                    i.d dVar = dVar;
                    list.get(i2);
                    a2.get(i3);
                    return dVar.a();
                }

                public final boolean areContentsTheSame(int i2, int i3) {
                    i.d dVar = dVar;
                    list.get(i2);
                    a2.get(i3);
                    return dVar.b();
                }
            }).a((RecyclerView.a) this);
        }
        for (Preference preference2 : this.f30870b) {
            preference2.z = false;
        }
    }

    private List<Preference> a(final PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int g2 = preferenceGroup.g();
        int i2 = 0;
        for (int i3 = 0; i3 < g2; i3++) {
            Preference b2 = preferenceGroup.b(i3);
            if (b2.t) {
                if (!b(preferenceGroup) || i2 < preferenceGroup.f30796c) {
                    arrayList.add(b2);
                } else {
                    arrayList2.add(b2);
                }
                if (!(b2 instanceof PreferenceGroup)) {
                    i2++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) b2;
                    if (!preferenceGroup2.o()) {
                        continue;
                    } else if (!b(preferenceGroup) || !b(preferenceGroup2)) {
                        for (Preference next : a(preferenceGroup2)) {
                            if (!b(preferenceGroup) || i2 < preferenceGroup.f30796c) {
                                arrayList.add(next);
                            } else {
                                arrayList2.add(next);
                            }
                            i2++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (b(preferenceGroup) && i2 > preferenceGroup.f30796c) {
            b bVar = new b(preferenceGroup.j, arrayList2, preferenceGroup.e());
            bVar.l = new Preference.c() {
                public final boolean a() {
                    preferenceGroup.a(Integer.MAX_VALUE);
                    h.this.a();
                    return true;
                }
            };
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public final Preference a(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.f30871c.get(i2);
    }

    public final int getItemCount() {
        return this.f30871c.size();
    }

    public final long getItemId(int i2) {
        if (!hasStableIds()) {
            return -1;
        }
        return a(i2).e();
    }

    public final void a(Preference preference) {
        int indexOf = this.f30871c.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    public final void a() {
        this.f30873e.removeCallbacks(this.f30874f);
        this.f30873e.post(this.f30874f);
    }

    public final int getItemViewType(int i2) {
        a aVar = new a(a(i2));
        int indexOf = this.f30872d.indexOf(aVar);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.f30872d.size();
        this.f30872d.add(aVar);
        return size;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f30882a;

        /* renamed from: b  reason: collision with root package name */
        int f30883b;

        /* renamed from: c  reason: collision with root package name */
        String f30884c;

        a(Preference preference) {
            this.f30884c = preference.getClass().getName();
            this.f30882a = preference.v;
            this.f30883b = preference.w;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f30882a == aVar.f30882a && this.f30883b == aVar.f30883b && TextUtils.equals(this.f30884c, aVar.f30884c)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return ((((this.f30882a + 527) * 31) + this.f30883b) * 31) + this.f30884c.hashCode();
        }
    }

    private void a(List<Preference> list, PreferenceGroup preferenceGroup) {
        synchronized (preferenceGroup) {
            Collections.sort(preferenceGroup.f30795b);
        }
        int g2 = preferenceGroup.g();
        for (int i2 = 0; i2 < g2; i2++) {
            Preference b2 = preferenceGroup.b(i2);
            list.add(b2);
            a aVar = new a(b2);
            if (!this.f30872d.contains(aVar)) {
                this.f30872d.add(aVar);
            }
            if (b2 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) b2;
                if (preferenceGroup2.o()) {
                    a(list, preferenceGroup2);
                }
            }
            b2.x = this;
        }
    }

    private static boolean b(PreferenceGroup preferenceGroup) {
        return preferenceGroup.f30796c != Integer.MAX_VALUE;
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        a aVar = this.f30872d.get(i2);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = androidx.appcompat.a.a.a.b(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(aVar.f30882a, viewGroup, false);
        if (inflate.getBackground() == null) {
            u.a(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            if (aVar.f30883b != 0) {
                from.inflate(aVar.f30883b, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new k(inflate);
    }
}
