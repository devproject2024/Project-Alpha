package com.google.android.exoplayer2.metadata.emsg;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f32658a = new ByteArrayOutputStream(512);

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f32659b = new DataOutputStream(this.f32658a);

    public final byte[] a(EventMessage eventMessage) {
        this.f32658a.reset();
        try {
            a(this.f32659b, eventMessage.f32652a);
            a(this.f32659b, eventMessage.f32653b != null ? eventMessage.f32653b : "");
            a(this.f32659b, eventMessage.f32654c);
            a(this.f32659b, eventMessage.f32655d);
            this.f32659b.write(eventMessage.f32656e);
            this.f32659b.flush();
            return this.f32658a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void a(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    private static void a(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeByte(((int) (j >>> 24)) & PriceRangeSeekBar.INVALID_POINTER_ID);
        dataOutputStream.writeByte(((int) (j >>> 16)) & PriceRangeSeekBar.INVALID_POINTER_ID);
        dataOutputStream.writeByte(((int) (j >>> 8)) & PriceRangeSeekBar.INVALID_POINTER_ID);
        dataOutputStream.writeByte(((int) j) & PriceRangeSeekBar.INVALID_POINTER_ID);
    }
}
