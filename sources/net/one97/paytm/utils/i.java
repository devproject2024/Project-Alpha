package net.one97.paytm.utils;

import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Arrays;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;

public final class i {
    public static ArrayList<CJRRelatedCategory> a(String str) {
        CJRRelatedCategory[] cJRRelatedCategoryArr;
        try {
            if (TextUtils.isEmpty(str) || (cJRRelatedCategoryArr = (CJRRelatedCategory[]) new f().a(str, CJRRelatedCategory[].class)) == null || cJRRelatedCategoryArr.length <= 0) {
                return null;
            }
            return new ArrayList<>(Arrays.asList(cJRRelatedCategoryArr));
        } catch (Exception e2) {
            if (!b.v) {
                return null;
            }
            q.b(e2.getMessage());
            return null;
        }
    }
}
