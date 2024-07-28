package androidx.databinding;

import android.view.View;
import java.util.Collections;
import java.util.List;

public abstract class d {
    public abstract String convertBrIdToString(int i2);

    public abstract ViewDataBinding getDataBinder(e eVar, View view, int i2);

    public abstract ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2);

    public abstract int getLayoutId(String str);

    public List<d> collectDependencies() {
        return Collections.emptyList();
    }
}
