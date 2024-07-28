package net.one97.paytm.recharge.automatic.c;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;

public interface c {

    public static final class a {
    }

    Context a();

    ContextWrapper a(Context context);

    void a(Activity activity, int i2);

    void a(Activity activity, Fragment fragment, NetworkCustomError networkCustomError, int i2);

    void a(Activity activity, NetworkCustomError networkCustomError, int i2);

    void a(Context context, int i2);

    void a(Context context, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6);

    void a(Context context, String str);

    void a(Context context, String str, CJRHomePageItem cJRHomePageItem);

    void a(String str, Bundle bundle, Context context);

    void a(String str, j jVar);

    boolean a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, CJRFrequentOrder cJRFrequentOrder);

    String b();

    void b(Context context);

    Class<? extends Activity> c();

    boolean c(Context context);

    Class<? extends Activity> d();
}
