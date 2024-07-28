package androidx.databinding.library.baseAdapters;

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
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f3274a = new HashMap<>(0);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f3274a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f3273a.get(i2);
    }

    public List<d> collectDependencies() {
        return new ArrayList(0);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f3273a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            f3273a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }
}
