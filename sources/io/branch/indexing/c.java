package io.branch.indexing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class c {

    /* renamed from: a  reason: collision with root package name */
    MessageDigest f46407a;

    c() {
        try {
            this.f46407a = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException unused) {
        }
    }
}
