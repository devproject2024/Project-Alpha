package com.google.android.exoplayer2.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f31173a = new d(new int[]{2}, 8);

    /* renamed from: d  reason: collision with root package name */
    private static final d f31174d = new d(new int[]{2, 5, 6}, 8);

    /* renamed from: b  reason: collision with root package name */
    final int[] f31175b;

    /* renamed from: c  reason: collision with root package name */
    final int f31176c;

    public static d a(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        if ((ae.f32499a >= 17 && "Amazon".equals(ae.f32501c)) && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f31174d;
        }
        if (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            return f31173a;
        }
        return new d(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    private d(int[] iArr, int i2) {
        if (iArr != null) {
            this.f31175b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f31175b);
        } else {
            this.f31175b = new int[0];
        }
        this.f31176c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Arrays.equals(this.f31175b, dVar.f31175b) && this.f31176c == dVar.f31176c;
    }

    public final int hashCode() {
        return this.f31176c + (Arrays.hashCode(this.f31175b) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f31176c + ", supportedEncodings=" + Arrays.toString(this.f31175b) + "]";
    }
}
