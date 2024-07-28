package com.business.common_module.utilities.a;

import androidx.lifecycle.LiveData;

public final class a extends LiveData {
    public a() {
        postValue(null);
    }

    public static <T> LiveData<T> a() {
        return new a();
    }
}
