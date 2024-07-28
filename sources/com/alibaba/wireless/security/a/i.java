package com.alibaba.wireless.security.a;

import java.io.File;

final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ File f14637a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14638b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ h f14639c;

    i(h hVar, File file, String str) {
        this.f14639c = hVar;
        this.f14637a = file;
        this.f14638b = str;
    }

    public final void run() {
        File filesDir;
        File[] listFiles;
        File[] listFiles2;
        try {
            if (this.f14637a != null && this.f14637a.isDirectory() && (listFiles2 = this.f14637a.listFiles()) != null && listFiles2.length > 0) {
                for (File file : listFiles2) {
                    if (file.isDirectory() && file.getName().startsWith("app_") && !file.getName().equals(this.f14638b)) {
                        this.f14639c.a(file);
                    } else if (file.getName().startsWith("libsg")) {
                        file.delete();
                    }
                }
            }
            if (this.f14639c.f14624a != null && (filesDir = this.f14639c.f14624a.getFilesDir()) != null && filesDir.isDirectory() && (listFiles = filesDir.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.getName().startsWith("libsecuritysdk")) {
                        file2.delete();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
