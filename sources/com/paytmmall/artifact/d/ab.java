package com.paytmmall.artifact.d;

import android.graphics.BitmapFactory;
import android.util.Base64;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    private static int f15689a = -1;

    public static boolean a() {
        if (f15689a == -1) {
            byte[] decode = Base64.decode("UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA", 2);
            try {
                f15689a = BitmapFactory.decodeByteArray(decode, 0, decode.length) != null ? 1 : 0;
            } catch (Exception e2) {
                f15689a = 0;
                e2.printStackTrace();
            }
        }
        return f15689a == 1;
    }
}
