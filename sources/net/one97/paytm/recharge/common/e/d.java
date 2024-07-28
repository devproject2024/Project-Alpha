package net.one97.paytm.recharge.common.e;

import androidx.lifecycle.LiveData;
import java.util.List;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;

public interface d {
    LiveData<List<CJRBrowsePlanProductList>> a(String str, String str2, String[] strArr, Object obj);

    LiveData<List<CJRBrowsePlanProductList>> a(String str, ai aiVar, String str2, String[] strArr, Object obj);

    String a();

    void a(String str, ai aiVar, int i2, String str2, Object obj);

    void a(String str, ai aiVar, Object obj);

    void a(CJRBrowsePlanProductList cJRBrowsePlanProductList);

    void b(String str, ai aiVar, Object obj);

    boolean b();

    String c();

    String d();

    Object e();
}
