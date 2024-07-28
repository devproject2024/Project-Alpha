package com.google.android.exoplayer2.g;

import android.opengl.GLES20;
import android.opengl.GLU;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class j {
    public static void a() {
        int i2 = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                new StringBuilder("glError ").append(GLU.gluErrorString(i2));
                l.d();
                i2 = glGetError;
            } else {
                return;
            }
        }
    }

    public static FloatBuffer a(float[] fArr) {
        return (FloatBuffer) a(fArr.length).put(fArr).flip();
    }

    private static FloatBuffer a(int i2) {
        return ByteBuffer.allocateDirect(i2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static void a(int i2, String str, int i3) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
            sb.append(", source: ");
            sb.append(str);
            l.d();
        }
        GLES20.glAttachShader(i3, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        a();
    }
}
