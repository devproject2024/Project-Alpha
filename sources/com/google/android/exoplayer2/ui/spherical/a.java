package com.google.android.exoplayer2.ui.spherical;

import android.view.Surface;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f33608b = {"uniform mat4 uMvpMatrix;", "attribute vec3 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * vec4(aPosition, 1);", "  vTexCoords = aTexCoords;", "}"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f33609c = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* renamed from: a  reason: collision with root package name */
    Surface f33610a;
}
