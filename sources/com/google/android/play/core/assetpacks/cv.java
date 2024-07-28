package com.google.android.play.core.assetpacks;

import com.google.android.play.core.e.b;

final /* synthetic */ class cv implements b {

    /* renamed from: a  reason: collision with root package name */
    static final b f37166a = new cv();

    private cv() {
    }

    public final void onFailure(Exception exc) {
        cw.f37167d.e(String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
