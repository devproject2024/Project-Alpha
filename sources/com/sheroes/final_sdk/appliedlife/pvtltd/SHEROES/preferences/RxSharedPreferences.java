package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.d.f;
import java.util.Collections;
import java.util.Set;

public final class RxSharedPreferences {
    private static final Boolean DEFAULT_BOOLEAN = Boolean.FALSE;
    private static final Float DEFAULT_FLOAT = Float.valueOf(0.0f);
    private static final Integer DEFAULT_INTEGER = 0;
    private static final Long DEFAULT_LONG = 0L;
    private static final String DEFAULT_STRING = "";
    private final p<String> keyChanges;
    private final SharedPreferences preferences;

    public static RxSharedPreferences create(SharedPreferences sharedPreferences) {
        Preconditions.checkNotNull(sharedPreferences, "preferences == null");
        return new RxSharedPreferences(sharedPreferences);
    }

    private RxSharedPreferences(final SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
        this.keyChanges = p.create(new s<String>() {
            public void subscribe(final r<String> rVar) {
                final AnonymousClass1 r0 = new SharedPreferences.OnSharedPreferenceChangeListener() {
                    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                        rVar.onNext(str);
                    }
                };
                rVar.setCancellable(new f() {
                    public void cancel() {
                        sharedPreferences.unregisterOnSharedPreferenceChangeListener(r0);
                    }
                });
                sharedPreferences.registerOnSharedPreferenceChangeListener(r0);
            }
        }).share();
    }

    public final Preference<Boolean> getBoolean(String str) {
        return getBoolean(str, DEFAULT_BOOLEAN);
    }

    public final Preference<Boolean> getBoolean(String str, Boolean bool) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(bool, "defaultValue == null");
        return new RealPreference(this.preferences, str, bool, BooleanAdapter.INSTANCE, this.keyChanges);
    }

    public final <T extends Enum<T>> Preference<T> getEnum(String str, T t, Class<T> cls) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(t, "defaultValue == null");
        Preconditions.checkNotNull(cls, "enumClass == null");
        return new RealPreference(this.preferences, str, t, new EnumAdapter(cls), this.keyChanges);
    }

    public final Preference<Float> getFloat(String str) {
        return getFloat(str, DEFAULT_FLOAT);
    }

    public final Preference<Float> getFloat(String str, Float f2) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(f2, "defaultValue == null");
        return new RealPreference(this.preferences, str, f2, FloatAdapter.INSTANCE, this.keyChanges);
    }

    public final Preference<Integer> getInteger(String str) {
        return getInteger(str, DEFAULT_INTEGER);
    }

    public final Preference<Integer> getInteger(String str, Integer num) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(num, "defaultValue == null");
        return new RealPreference(this.preferences, str, num, IntegerAdapter.INSTANCE, this.keyChanges);
    }

    public final Preference<Long> getLong(String str) {
        return getLong(str, DEFAULT_LONG);
    }

    public final Preference<Long> getLong(String str, Long l) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(l, "defaultValue == null");
        return new RealPreference(this.preferences, str, l, LongAdapter.INSTANCE, this.keyChanges);
    }

    public final <T> Preference<T> getObject(String str, T t, Preference.Converter<T> converter) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(t, "defaultValue == null");
        Preconditions.checkNotNull(converter, "converter == null");
        return new RealPreference(this.preferences, str, t, new ConverterAdapter(converter), this.keyChanges);
    }

    public final Preference<String> getString(String str) {
        return getString(str, "");
    }

    public final Preference<String> getString(String str, String str2) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(str2, "defaultValue == null");
        return new RealPreference(this.preferences, str, str2, StringAdapter.INSTANCE, this.keyChanges);
    }

    public final Preference<Set<String>> getStringSet(String str) {
        return getStringSet(str, Collections.emptySet());
    }

    public final Preference<Set<String>> getStringSet(String str, Set<String> set) {
        Preconditions.checkNotNull(str, "key == null");
        Preconditions.checkNotNull(set, "defaultValue == null");
        return new RealPreference(this.preferences, str, set, StringSetAdapter.INSTANCE, this.keyChanges);
    }

    public final void clear() {
        this.preferences.edit().clear().apply();
    }
}
