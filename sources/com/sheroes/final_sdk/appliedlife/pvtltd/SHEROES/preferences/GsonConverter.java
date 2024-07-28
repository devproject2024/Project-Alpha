package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;

public class GsonConverter<T> implements Preference.Converter<T> {
    private Class<T> clazz;
    final f gson;
    private String json;

    public GsonConverter(f fVar, Class<T> cls) {
        this.gson = fVar;
        this.clazz = cls;
    }

    public T deserialize(String str) {
        return this.gson.a(str, this.clazz);
    }

    public String serialize(T t) {
        this.json = this.gson.b(t);
        return this.json;
    }
}
