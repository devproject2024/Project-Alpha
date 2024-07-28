package com.paytm.android.chat.f;

import android.content.Context;
import com.paytm.android.chat.R;
import com.zhihu.matisse.c.a;
import com.zhihu.matisse.internal.c.e;
import com.zhihu.matisse.internal.entity.Item;
import java.util.HashSet;
import java.util.Set;
import net.one97.paytm.upi.util.UpiConstants;

final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f42028a = UpiConstants.REQUEST_CODE_BANK_DETAIL;

    /* renamed from: b  reason: collision with root package name */
    private int f42029b = UpiConstants.REQUEST_CODE_BANK_DETAIL;

    /* renamed from: c  reason: collision with root package name */
    private int f42030c = 5242880;

    b() {
    }

    public final Set<com.zhihu.matisse.b> a() {
        return new HashSet<com.zhihu.matisse.b>() {
            {
                add(com.zhihu.matisse.b.GIF);
            }
        };
    }

    public final com.zhihu.matisse.internal.entity.b a(Context context, Item item) {
        if (!b(context, item) || item.f45766d <= ((long) this.f42030c)) {
            return null;
        }
        return new com.zhihu.matisse.internal.entity.b(context.getString(R.string.chat_module_error_gif, new Object[]{String.valueOf(e.a((long) this.f42030c))}), (byte) 0);
    }
}
