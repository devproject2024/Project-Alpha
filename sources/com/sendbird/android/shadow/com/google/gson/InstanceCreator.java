package com.sendbird.android.shadow.com.google.gson;

import java.lang.reflect.Type;

public interface InstanceCreator<T> {
    T createInstance(Type type);
}
