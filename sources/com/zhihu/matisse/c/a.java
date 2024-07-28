package com.zhihu.matisse.c;

import android.content.Context;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.b;
import java.util.Set;

public abstract class a {
    public abstract b a(Context context, Item item);

    /* access modifiers changed from: protected */
    public abstract Set<com.zhihu.matisse.b> a();

    /* access modifiers changed from: protected */
    public final boolean b(Context context, Item item) {
        for (com.zhihu.matisse.b checkType : a()) {
            if (checkType.checkType(context.getContentResolver(), item.f45765c)) {
                return true;
            }
        }
        return false;
    }
}
