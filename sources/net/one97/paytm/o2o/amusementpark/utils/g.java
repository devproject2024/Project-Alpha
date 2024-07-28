package net.one97.paytm.o2o.amusementpark.utils;

import java.util.Comparator;
import java.util.List;
import kotlin.a.k;
import net.one97.paytm.common.entity.CJRSelectCityModel;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f73665a = new g();

    private g() {
    }

    public static List<CJRSelectCityModel> a(List<? extends CJRSelectCityModel> list, List<String> list2) {
        if (list == null || list2 == null) {
            return null;
        }
        return k.a(list, new a(list2));
    }

    public static final class a<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f73666a;

        public a(List list) {
            this.f73666a = list;
        }

        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Integer.valueOf(this.f73666a.indexOf(((CJRSelectCityModel) t2).getLabel())), Integer.valueOf(this.f73666a.indexOf(((CJRSelectCityModel) t).getLabel())));
        }
    }
}
