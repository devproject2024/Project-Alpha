package net.one97.paytm.paymentsBank;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_PBFRAGMENTNACHDETAILTRANSACTIONLIST = 1;
    private static final int LAYOUT_PBNACHDETAILTRANSACTIONLISTITEM = 2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.pb_fragment_nach_detail_transaction_list, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.pb_nach_detail_transaction_list_item, 2);
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
                return null;
            }
            if ("layout/pb_nach_detail_transaction_list_item_0".equals(tag)) {
                return new net.one97.paytm.paymentsBank.c.d(eVar, view);
            }
            throw new IllegalArgumentException("The tag for pb_nach_detail_transaction_list_item is invalid. Received: ".concat(String.valueOf(tag)));
        } else if ("layout/pb_fragment_nach_detail_transaction_list_0".equals(tag)) {
            return new net.one97.paytm.paymentsBank.c.b(eVar, view);
        } else {
            throw new IllegalArgumentException("The tag for pb_fragment_nach_detail_transaction_list is invalid. Received: ".concat(String.valueOf(tag)));
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
        if (str == null || (num = b.f17271a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f17270a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.bankOpen.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.common.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f17270a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(2);
            f17270a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f17271a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            f17271a = hashMap;
            hashMap.put("layout/pb_fragment_nach_detail_transaction_list_0", Integer.valueOf(R.layout.pb_fragment_nach_detail_transaction_list));
            f17271a.put("layout/pb_nach_detail_transaction_list_item_0", Integer.valueOf(R.layout.pb_nach_detail_transaction_list_item));
        }
    }
}
