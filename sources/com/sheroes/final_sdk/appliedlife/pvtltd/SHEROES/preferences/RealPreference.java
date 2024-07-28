package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.q;

final class RealPreference<T> implements Preference<T> {
    private final Adapter<T> adapter;
    private final T defaultValue;
    private final String key;
    private final SharedPreferences preferences;
    private final p<T> values;

    interface Adapter<T> {
        T get(String str, SharedPreferences sharedPreferences, T t);

        void set(String str, T t, SharedPreferences.Editor editor);
    }

    RealPreference(SharedPreferences sharedPreferences, final String str, T t, Adapter<T> adapter2, p<String> pVar) {
        this.preferences = sharedPreferences;
        this.key = str;
        this.defaultValue = t;
        this.adapter = adapter2;
        this.values = pVar.filter(new q<String>() {
            public boolean test(String str) {
                return str.equals(str);
            }
        }).startWithItem("<init>").map(new h<String, T>() {
            public T apply(String str) {
                return RealPreference.this.get();
            }
        });
    }

    public final String key() {
        return this.key;
    }

    public final T defaultValue() {
        return this.defaultValue;
    }

    public final synchronized T get() {
        return this.adapter.get(this.key, this.preferences, this.defaultValue);
    }

    public final void set(T t) {
        Preconditions.checkNotNull(t, "value == null");
        SharedPreferences.Editor edit = this.preferences.edit();
        this.adapter.set(this.key, t, edit);
        edit.apply();
    }

    public final boolean isSet() {
        return this.preferences.contains(this.key);
    }

    public final synchronized void delete() {
        this.preferences.edit().remove(this.key).apply();
    }

    public final p<T> asObservable() {
        return this.values;
    }

    public final g<? super T> asConsumer() {
        return new g<T>() {
            public void accept(T t) {
                RealPreference.this.set(t);
            }
        };
    }
}
