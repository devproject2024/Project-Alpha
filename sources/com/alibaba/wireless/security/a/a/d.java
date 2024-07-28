package com.alibaba.wireless.security.a.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private FileChannel f14593a = null;

    /* renamed from: b  reason: collision with root package name */
    private FileLock f14594b = null;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f14595c = null;

    /* renamed from: d  reason: collision with root package name */
    private File f14596d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14597e = true;

    /* renamed from: f  reason: collision with root package name */
    private String f14598f = null;

    public d(String str) {
        this.f14598f = str;
        this.f14597e = c();
    }

    private boolean c() {
        try {
            this.f14596d = new File(this.f14598f);
            if (!this.f14596d.exists()) {
                this.f14596d.createNewFile();
            }
        } catch (Exception unused) {
            if (!this.f14596d.exists()) {
                try {
                    this.f14596d.createNewFile();
                } catch (Exception unused2) {
                }
            }
        }
        File file = this.f14596d;
        return file != null && file.exists();
    }

    public final boolean a() {
        if (!this.f14597e) {
            this.f14597e = c();
            if (!this.f14597e) {
                return true;
            }
        }
        try {
            if (this.f14596d == null) {
                return false;
            }
            this.f14595c = new RandomAccessFile(this.f14596d, "rw");
            this.f14593a = this.f14595c.getChannel();
            this.f14594b = this.f14593a.lock();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean b() {
        boolean z = true;
        if (!this.f14597e) {
            return true;
        }
        try {
            if (this.f14594b != null) {
                this.f14594b.release();
                this.f14594b = null;
            }
        } catch (IOException unused) {
            z = false;
        }
        try {
            if (this.f14593a != null) {
                this.f14593a.close();
                this.f14593a = null;
            }
        } catch (IOException unused2) {
            z = false;
        }
        try {
            if (this.f14595c == null) {
                return z;
            }
            this.f14595c.close();
            this.f14595c = null;
            return z;
        } catch (IOException unused3) {
            return false;
        }
    }
}
