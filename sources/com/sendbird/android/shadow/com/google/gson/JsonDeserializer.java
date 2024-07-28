package com.sendbird.android.shadow.com.google.gson;

import java.lang.reflect.Type;

public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
