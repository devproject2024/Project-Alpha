package androidx.databinding;

import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergedDataBinderMapper extends d {
    private static final String TAG = "MergedDataBinderMapper";
    private Set<Class<? extends d>> mExistingMappers = new HashSet();
    private List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();
    private List<d> mMappers = new CopyOnWriteArrayList();

    public void addMapper(d dVar) {
        if (this.mExistingMappers.add(dVar.getClass())) {
            this.mMappers.add(dVar);
            for (d addMapper : dVar.collectDependencies()) {
                addMapper(addMapper);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addMapper(String str) {
        List<String> list = this.mFeatureBindingMappers;
        list.add(str + ".DataBinderMapperImpl");
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        for (d dataBinder : this.mMappers) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(eVar, view, i2);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(eVar, view, i2);
        }
        return null;
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        for (d dataBinder : this.mMappers) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(eVar, viewArr, i2);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(eVar, viewArr, i2);
        }
        return null;
    }

    public int getLayoutId(String str) {
        for (d layoutId : this.mMappers) {
            int layoutId2 = layoutId.getLayoutId(str);
            if (layoutId2 != 0) {
                return layoutId2;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }

    public String convertBrIdToString(int i2) {
        for (d convertBrIdToString : this.mMappers) {
            String convertBrIdToString2 = convertBrIdToString.convertBrIdToString(i2);
            if (convertBrIdToString2 != null) {
                return convertBrIdToString2;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i2);
        }
        return null;
    }

    private boolean loadFeatures() {
        boolean z = false;
        for (String next : this.mFeatureBindingMappers) {
            try {
                Class<?> cls = Class.forName(next);
                if (d.class.isAssignableFrom(cls)) {
                    addMapper((d) cls.newInstance());
                    this.mFeatureBindingMappers.remove(next);
                    z = true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            }
        }
        return z;
    }
}
