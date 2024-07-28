package net.one97.paytm.o2o.movies.utils;

import com.alipay.mobile.nebula.permission.H5PermissionManager;
import kotlin.g.b.k;

public final class u {
    public static final void a(String str, String str2, String str3) {
        k.c(str, H5PermissionManager.level);
        k.c(str2, "tag");
        k.c(str3, "message");
    }
}
