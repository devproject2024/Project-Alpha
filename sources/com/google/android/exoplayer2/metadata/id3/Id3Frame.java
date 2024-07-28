package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;

public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: f  reason: collision with root package name */
    public final String f32702f;

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
    }

    public int describeContents() {
        return 0;
    }

    public Id3Frame(String str) {
        this.f32702f = str;
    }

    public String toString() {
        return this.f32702f;
    }
}
