package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;

public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
