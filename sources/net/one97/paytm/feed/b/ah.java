package net.one97.paytm.feed.b;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.d.a.a;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.ui.feed.g.a;
import net.one97.paytm.feed.ui.feed.g.c;
import org.json.JSONArray;

public final class ah extends ag implements a.C0556a {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        k = sparseIntArray;
        sparseIntArray.put(R.id.title, 3);
        k.put(R.id.description, 4);
        k.put(R.id.langauge_container, 5);
    }

    public ah(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, j, k));
    }

    private ah(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[5], objArr[2], objArr[3]);
        this.o = -1;
        this.f33829a.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f33832d.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 1);
        this.n = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.feed.a.f33775b == i2) {
            this.f33834f = (c) obj;
            synchronized (this) {
                this.o |= 1;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33775b);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33778e == i2) {
            this.f33836h = (Integer) obj;
            synchronized (this) {
                this.o |= 2;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33778e);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.j == i2) {
            this.f33835g = (a.C0579a) obj;
            synchronized (this) {
                this.o |= 4;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.j);
            super.requestRebind();
        } else if (net.one97.paytm.feed.a.f33780g != i2) {
            return false;
        } else {
            this.f33837i = (String) obj;
            synchronized (this) {
                this.o |= 8;
            }
            notifyPropertyChanged(net.one97.paytm.feed.a.f33780g);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.o;
            this.o = 0;
        }
        if ((j2 & 16) != 0) {
            this.f33829a.setOnClickListener(this.m);
            this.f33832d.setOnClickListener(this.n);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            c cVar = this.f33834f;
            String str = this.f33837i;
            if (cVar != null) {
                z = true;
            }
            if (z) {
                k.c(view, "view");
                k.c(str, "id");
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                Context context = view.getContext();
                k.a((Object) context, "view.context");
                net.one97.paytm.feed.repository.db.a.f(context, str);
            }
        } else if (i2 == 2) {
            c cVar2 = this.f33834f;
            Integer num = this.f33836h;
            a.C0579a aVar2 = this.f33835g;
            String str2 = this.f33837i;
            if (cVar2 == null) {
                z2 = false;
            }
            if (z2) {
                int intValue = num.intValue();
                k.c(view, "view");
                k.c(str2, "id");
                k.c(aVar2, "languageResponseHandler");
                b bVar = b.f34268c;
                if (b.d() != null) {
                    ArrayList arrayList = new ArrayList();
                    b bVar2 = b.f34268c;
                    List<FeedLanguageData> d2 = b.d();
                    if (d2 == null) {
                        k.a();
                    }
                    for (FeedLanguageData next : d2) {
                        if (next.isSelected()) {
                            arrayList.add(next.getLanguageCode());
                        }
                    }
                    if (arrayList.size() > 0) {
                        JSONArray jSONArray = new JSONArray(arrayList.toString());
                        net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                        net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                        Context context2 = view.getContext();
                        k.a((Object) context2, "view.context");
                        String jSONArray2 = jSONArray.toString();
                        k.a((Object) jSONArray2, "jsArray.toString()");
                        a2.a(context2, jSONArray2, (kotlin.g.a.b<? super String, x>) new c.a(aVar2, intValue, view));
                        return;
                    }
                    Toast.makeText(view.getContext(), R.string.feed_language_check, 0).show();
                }
            }
        }
    }
}
