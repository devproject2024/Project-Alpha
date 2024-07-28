package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.g;

public interface Preference<T> {

    public interface Converter<T> {
        T deserialize(String str);

        String serialize(T t);
    }

    g<? super T> asConsumer();

    p<T> asObservable();

    T defaultValue();

    void delete();

    T get();

    boolean isSet();

    String key();

    void set(T t);
}
