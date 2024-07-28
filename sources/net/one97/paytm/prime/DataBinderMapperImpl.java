package net.one97.paytm.prime;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.prime.c.f;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYPRIMELOADER = 1;
    private static final int LAYOUT_FRAGMENTLYTPRIMESUBSCRIPTIONFAILURE = 2;
    private static final int LAYOUT_FRAGMENTPENDINGTRANSCATION = 3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_prime_loader, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_lyt_prime_subscription_failure, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_pending_transcation, 3);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                if ("layout/fragment_pending_transcation_0".equals(tag)) {
                    return new f(eVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_pending_transcation is invalid. Received: ".concat(String.valueOf(tag)));
            } else if ("layout/fragment_lyt_prime_subscription_failure_0".equals(tag)) {
                return new net.one97.paytm.prime.c.d(eVar, view);
            } else {
                throw new IllegalArgumentException("The tag for fragment_lyt_prime_subscription_failure is invalid. Received: ".concat(String.valueOf(tag)));
            }
        } else if ("layout/activity_prime_loader_0".equals(tag)) {
            return new net.one97.paytm.prime.c.b(eVar, view);
        } else {
            throw new IllegalArgumentException("The tag for activity_prime_loader is invalid. Received: ".concat(String.valueOf(tag)));
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f59733a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f59732a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.nativesdk.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f59732a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(32);
            f59732a = sparseArray;
            sparseArray.put(0, "_all");
            f59732a.put(1, "emiViewModel");
            f59732a.put(2, "instrumentSheetViewModel");
            f59732a.put(3, "section");
            f59732a.put(4, "transcationViewModel");
            f59732a.put(5, "allNetBankingViewModel");
            f59732a.put(6, "bankMandateIfscCodeViewModel");
            f59732a.put(7, "codViewModel");
            f59732a.put(8, "view");
            f59732a.put(9, "netBankingViewModel");
            f59732a.put(10, "netbanking");
            f59732a.put(11, "saveCardModel");
            f59732a.put(12, "model");
            f59732a.put(13, "showInstrumentInfoMsg");
            f59732a.put(14, "a");
            f59732a.put(15, "otpViewholder");
            f59732a.put(16, "pincvvmodel");
            f59732a.put(17, "bank_mandate");
            f59732a.put(18, "debitCardModel");
            f59732a.put(19, "selectedInstrumentSheetViewModel");
            f59732a.put(20, "typeface");
            f59732a.put(21, "aoaWalletViewModel");
            f59732a.put(22, "bankViewModel");
            f59732a.put(23, "landingPageViewModel");
            f59732a.put(24, "walletViewModel");
            f59732a.put(25, "digitalCreditModel");
            f59732a.put(26, "cvvHelpModel");
            f59732a.put(27, "bankMandateSubDetailsViewModel");
            f59732a.put(28, "upiHelpModel");
            f59732a.put(29, "upiCollectModel");
            f59732a.put(30, "viewModel");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f59733a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(3);
            f59733a = hashMap;
            hashMap.put("layout/activity_prime_loader_0", Integer.valueOf(R.layout.activity_prime_loader));
            f59733a.put("layout/fragment_lyt_prime_subscription_failure_0", Integer.valueOf(R.layout.fragment_lyt_prime_subscription_failure));
            f59733a.put("layout/fragment_pending_transcation_0", Integer.valueOf(R.layout.fragment_pending_transcation));
        }
    }
}
