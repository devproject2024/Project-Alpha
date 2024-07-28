package net.one97.paytm.p2p.theme;

import android.animation.TimeInterpolator;

public final class b implements TimeInterpolator {

    /* renamed from: a  reason: collision with root package name */
    private final a f56989a;

    public b(a aVar) {
        this.f56989a = aVar;
    }

    public final float getInterpolation(float f2) {
        float f3 = f2;
        switch (this.f56989a) {
            case LINEAR:
                return f3;
            case QUAD_IN:
                return (float) Math.pow((double) f3, 2.0d);
            case QUAD_OUT:
                return c.a(f3, 2.0d);
            case QUAD_IN_OUT:
                return c.b(f3, 2.0d);
            case CUBIC_IN:
                return (float) Math.pow((double) f3, 3.0d);
            case CUBIC_OUT:
                return c.a(f3, 3.0d);
            case CUBIC_IN_OUT:
                return c.b(f3, 3.0d);
            case QUART_IN:
                return (float) Math.pow((double) f3, 4.0d);
            case QUART_OUT:
                return c.a(f3, 4.0d);
            case QUART_IN_OUT:
                return c.b(f3, 4.0d);
            case QUINT_IN:
                return (float) Math.pow((double) f3, 5.0d);
            case QUINT_OUT:
                return c.a(f3, 5.0d);
            case QUINT_IN_OUT:
                return c.b(f3, 5.0d);
            case SINE_IN:
                return (float) (1.0d - Math.cos((((double) f3) * 3.141592653589793d) / 2.0d));
            case SINE_OUT:
                return (float) Math.sin((((double) f3) * 3.141592653589793d) / 2.0d);
            case SINE_IN_OUT:
                return (float) ((Math.cos(((double) f3) * 3.141592653589793d) - 1.0d) * -0.5d);
            case BACK_IN:
                return (float) (((double) (f3 * f3)) * ((((double) f3) * 2.7d) - 1.7d));
            case BACK_OUT:
                float f4 = f3 - 1.0f;
                return (float) ((((double) (f4 * f4)) * ((((double) f4) * 2.7d) + 1.7d)) + 1.0d);
            case BACK_IN_OUT:
                float f5 = f3 * 2.0f;
                if (f5 < 1.0f) {
                    return (float) (((double) (f5 * f5 * ((f5 * 3.5925f) - 2.5925f))) * 0.5d);
                }
                float f6 = f5 - 2.0f;
                return (float) (((double) ((f6 * f6 * ((f6 * 3.5925f) + 2.5925f)) + 2.0f)) * 0.5d);
            case CIRC_IN:
                return (float) (-(Math.sqrt((double) (1.0f - (f3 * f3))) - 1.0d));
            case CIRC_OUT:
                float f7 = f3 - 1.0f;
                return (float) Math.sqrt((double) (1.0f - (f7 * f7)));
            case CIRC_IN_OUT:
                float f8 = f3 * 2.0f;
                if (f8 < 1.0f) {
                    return (float) ((Math.sqrt((double) (1.0f - (f8 * f8))) - 1.0d) * -0.5d);
                }
                float f9 = f8 - 2.0f;
                return (float) ((Math.sqrt((double) (1.0f - (f9 * f9))) + 1.0d) * 0.5d);
            case BOUNCE_IN:
                return c.a(f2);
            case BOUNCE_OUT:
                return c.b(f2);
            case BOUNCE_IN_OUT:
                if (f3 < 0.5f) {
                    return c.a(f3 * 2.0f) * 0.5f;
                }
                return (c.b((f3 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
            case ELASTIC_IN:
                if (f3 == 0.0f || f3 == 1.0f) {
                    return f3;
                }
                float f10 = f3 - 1.0f;
                return (float) (-(Math.pow(2.0d, (double) (f10 * 10.0f)) * 1.0d * Math.sin(((((double) f10) - (Math.asin(1.0d) * 0.0477464829275686d)) * 6.283185307179586d) / 0.3d)));
            case ELASTIC_OUT:
                if (f3 == 0.0f || f3 == 1.0f) {
                    return f3;
                }
                return (float) ((Math.pow(2.0d, (double) (f3 * -10.0f)) * 1.0d * Math.sin(((((double) f3) - (Math.asin(1.0d) * 0.0477464829275686d)) * 6.283185307179586d) / 0.3d)) + 1.0d);
            case ELASTIC_IN_OUT:
                double asin = Math.asin(1.0d) * 0.0716197243913529d;
                float f11 = f3 * 2.0f;
                if (f11 < 1.0f) {
                    float f12 = f11 - 1.0f;
                    return (float) (Math.pow(2.0d, (double) (f12 * 10.0f)) * 1.0d * Math.sin(((((double) f12) - asin) * 6.283185307179586d) / 0.45d) * -0.5d);
                }
                float f13 = f11 - 1.0f;
                return (float) ((Math.pow(2.0d, (double) (f13 * -10.0f)) * 1.0d * Math.sin(((((double) f13) - asin) * 6.283185307179586d) / 0.45d) * 0.5d) + 1.0d);
            case EASE_IN_EXPO:
                return (float) Math.pow(2.0d, (double) ((f3 - 1.0f) * 10.0f));
            case EASE_OUT_EXPO:
                return ((float) (-Math.pow(2.0d, (double) (f3 * -10.0f)))) + 1.0f;
            case EASE_IN_OUT_EXPO:
                float f14 = f3 * 2.0f;
                if (f14 < 1.0f) {
                    return ((float) Math.pow(2.0d, (double) ((f14 - 1.0f) * 10.0f))) * 0.5f;
                }
                return ((float) ((-Math.pow(2.0d, (double) ((f14 - 1.0f) * -10.0f))) + 2.0d)) * 0.5f;
            default:
                return f3;
        }
    }
}
