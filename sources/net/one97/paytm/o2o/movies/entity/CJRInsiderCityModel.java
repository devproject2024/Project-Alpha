package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsiderCityModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "_id")
    public String _id;
    @b(a = "name")
    public String name;
    @b(a = "pinned")
    public boolean pinned;
    @b(a = "slug")
    public String slug;

    public boolean equals(Object obj) {
        if (obj instanceof CJRInsiderCityModel) {
            return ((CJRInsiderCityModel) obj).name.equals(this.name);
        }
        return super.equals(obj);
    }

    public CJRInsiderCityModel(String str) {
        this.name = str;
    }
}
