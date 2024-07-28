package com.zhihu.matisse.internal.b;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.paytm.android.chat.R;
import com.zhihu.matisse.b;
import com.zhihu.matisse.internal.c.d;
import com.zhihu.matisse.internal.c.e;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.c;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Set<Item> f45733a;

    /* renamed from: b  reason: collision with root package name */
    public int f45734b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final Context f45735c;

    public c(Context context) {
        this.f45735c = context;
    }

    public final void a(Bundle bundle) {
        if (bundle == null) {
            this.f45733a = new LinkedHashSet();
            return;
        }
        this.f45733a = new LinkedHashSet(bundle.getParcelableArrayList("state_selection"));
        this.f45734b = bundle.getInt("state_collection_type", 0);
    }

    public final void b(Bundle bundle) {
        bundle.putParcelableArrayList("state_selection", new ArrayList(this.f45733a));
        bundle.putInt("state_collection_type", this.f45734b);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("state_selection", new ArrayList(this.f45733a));
        bundle.putInt("state_collection_type", this.f45734b);
        return bundle;
    }

    public final boolean a(Item item) {
        if (!f(item)) {
            boolean add = this.f45733a.add(item);
            if (add) {
                int i2 = this.f45734b;
                if (i2 == 0) {
                    if (b.isImage(item.f45764b)) {
                        this.f45734b = 1;
                    } else if (b.isVideo(item.f45764b)) {
                        this.f45734b = 2;
                    }
                } else if (i2 == 1) {
                    if (b.isVideo(item.f45764b)) {
                        this.f45734b = 3;
                    }
                } else if (i2 == 2 && b.isImage(item.f45764b)) {
                    this.f45734b = 3;
                }
            }
            return add;
        }
        throw new IllegalArgumentException("Can't select images and videos at the same time.");
    }

    public final boolean b(Item item) {
        boolean remove = this.f45733a.remove(item);
        if (remove) {
            boolean z = false;
            if (this.f45733a.size() == 0) {
                this.f45734b = 0;
            } else if (this.f45734b == 3) {
                boolean z2 = false;
                for (Item next : this.f45733a) {
                    if (b.isImage(next.f45764b) && !z) {
                        z = true;
                    }
                    if (b.isVideo(next.f45764b) && !z2) {
                        z2 = true;
                    }
                }
                if (z && z2) {
                    this.f45734b = 3;
                } else if (z) {
                    this.f45734b = 1;
                } else if (z2) {
                    this.f45734b = 2;
                }
            }
        }
        return remove;
    }

    public final List<Item> b() {
        return new ArrayList(this.f45733a);
    }

    public final List<Uri> c() {
        ArrayList arrayList = new ArrayList();
        for (Item item : this.f45733a) {
            arrayList.add(item.f45765c);
        }
        return arrayList;
    }

    public final List<String> d() {
        ArrayList arrayList = new ArrayList();
        for (Item item : this.f45733a) {
            arrayList.add(d.a(this.f45735c, item.f45765c));
        }
        return arrayList;
    }

    public final boolean c(Item item) {
        return this.f45733a.contains(item);
    }

    public final com.zhihu.matisse.internal.entity.b d(Item item) {
        String str;
        if (e()) {
            int g2 = g();
            try {
                str = this.f45735c.getString(R.string.chat_module_error_over_count, new Object[]{Integer.valueOf(g2)});
            } catch (Resources.NotFoundException unused) {
                str = this.f45735c.getString(R.string.chat_module_error_over_count, new Object[]{Integer.valueOf(g2)});
            } catch (NoClassDefFoundError unused2) {
                str = this.f45735c.getString(R.string.chat_module_error_over_count, new Object[]{Integer.valueOf(g2)});
            }
            return new com.zhihu.matisse.internal.entity.b(str);
        } else if (f(item)) {
            return new com.zhihu.matisse.internal.entity.b(this.f45735c.getString(R.string.chat_module_error_type_conflict));
        } else {
            return e.a(this.f45735c, item);
        }
    }

    public final boolean e() {
        return this.f45733a.size() == g();
    }

    public final int f() {
        return this.f45733a.size();
    }

    public final int e(Item item) {
        int indexOf = new ArrayList(this.f45733a).indexOf(item);
        if (indexOf == -1) {
            return Integer.MIN_VALUE;
        }
        return indexOf + 1;
    }

    private int g() {
        com.zhihu.matisse.internal.entity.c a2 = c.a.f45787a;
        if (a2.f45784g > 0) {
            return a2.f45784g;
        }
        int i2 = this.f45734b;
        if (i2 == 1) {
            return a2.f45785h;
        }
        if (i2 == 2) {
            return a2.f45786i;
        }
        return a2.f45784g;
    }

    private boolean f(Item item) {
        int i2;
        if (!c.a.f45787a.f45779b) {
            return false;
        }
        if (!b.isImage(item.f45764b) || !((i2 = this.f45734b) == 2 || i2 == 3)) {
            if (!b.isVideo(item.f45764b)) {
                return false;
            }
            int i3 = this.f45734b;
            if (i3 == 1 || i3 == 3) {
                return true;
            }
            return false;
        }
        return true;
    }
}
