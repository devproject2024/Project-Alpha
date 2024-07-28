package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import com.google.gson.b;
import com.google.gson.c;

public class AnnotationExclusionStrategy implements b {
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    public boolean shouldSkipField(c cVar) {
        return cVar.f39448a.getAnnotation(Exclude.class) != null;
    }
}
