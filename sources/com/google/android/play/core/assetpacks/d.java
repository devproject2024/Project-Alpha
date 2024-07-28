package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class d {
    public abstract long a();

    public abstract Map<String, c> b();

    static d a(Bundle bundle, ba baVar, List<String> list, ab abVar) {
        Bundle bundle2 = bundle;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = stringArrayList.get(i2);
            hashMap.put(str, c.a(bundle, str, baVar, abVar));
        }
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String str2 = list.get(i3);
            hashMap.put(str2, c.a(str2, 4, 0, 0, 0, 0.0d));
        }
        return new aj(bundle.getLong("total_bytes_to_download"), hashMap);
    }
}
