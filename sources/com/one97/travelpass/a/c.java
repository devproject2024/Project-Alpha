package com.one97.travelpass.a;

import net.one97.travelpass.ui.c.j;

public interface c {
    void onItemClickedItem(j jVar, Integer num, Integer num2);

    public static final class a {
        public static /* synthetic */ void a(c cVar, j jVar, Integer num, Integer num2, int i2) {
            if ((i2 & 2) != 0) {
                num = -1;
            }
            if ((i2 & 4) != 0) {
                net.one97.travelpass.ui.a aVar = net.one97.travelpass.ui.a.f30575a;
                num2 = Integer.valueOf(net.one97.travelpass.ui.a.a());
            }
            cVar.onItemClickedItem(jVar, num, num2);
        }
    }
}
