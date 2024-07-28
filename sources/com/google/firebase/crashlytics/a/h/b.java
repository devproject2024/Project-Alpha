package com.google.firebase.crashlytics.a.h;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public final class b extends FileOutputStream {

    /* renamed from: a  reason: collision with root package name */
    public static final FilenameFilter f38602a = new FilenameFilter() {
        public final boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final String f38603b;

    /* renamed from: c  reason: collision with root package name */
    private File f38604c;

    /* renamed from: d  reason: collision with root package name */
    private File f38605d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f38606e = false;

    public b(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.f38603b = file + File.separator + str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f38603b);
        sb.append(".cls_temp");
        this.f38604c = new File(sb.toString());
    }

    public final synchronized void close() throws IOException {
        if (!this.f38606e) {
            this.f38606e = true;
            super.flush();
            super.close();
            File file = new File(this.f38603b + ".cls");
            if (this.f38604c.renameTo(file)) {
                this.f38604c = null;
                this.f38605d = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.f38604c.exists()) {
                str = " (source does not exist)";
            }
            throw new IOException("Could not rename temp file: " + this.f38604c + " -> " + file + str);
        }
    }

    public final void a() throws IOException {
        if (!this.f38606e) {
            this.f38606e = true;
            super.flush();
            super.close();
        }
    }
}
