package androidx.work;

import androidx.work.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OverwritingInputMerger extends j {
    public final e a(List<e> list) {
        e.a aVar = new e.a();
        HashMap hashMap = new HashMap();
        for (e eVar : list) {
            hashMap.putAll(Collections.unmodifiableMap(eVar.f5094b));
        }
        aVar.a((Map<String, Object>) hashMap);
        return aVar.a();
    }
}
