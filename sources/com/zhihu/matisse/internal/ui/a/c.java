package com.zhihu.matisse.internal.ui.a;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.b;
import java.util.ArrayList;

public final class c extends m {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Item> f45825a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f45826b = null;

    public interface a {
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public c(j jVar) {
        super(jVar);
    }

    public final Fragment getItem(int i2) {
        return b.a(this.f45825a.get(i2));
    }

    public final int getCount() {
        return this.f45825a.size();
    }

    public final void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
    }

    public final Item a(int i2) {
        return this.f45825a.get(i2);
    }
}
