package com.paytm.android.chat.utils;

import android.view.View;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.TimeUnit;

public class RxViewUtils {
    private static final int DELAYED_TIME = 1000;

    public static void setOnClickListeners(View view, g<View> gVar) {
        setOnClickListeners(view, gVar, 1000);
    }

    public static void setOnClickListeners(final View view, g<View> gVar, int i2) {
        p.create(new s<View>() {
            public final void subscribe(final r<View> rVar) {
                view.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (!rVar.isDisposed()) {
                            rVar.onNext(view);
                        }
                    }
                });
            }
        }).throttleFirst((long) i2, TimeUnit.MILLISECONDS).subscribe(gVar);
    }
}
