package com.google.android.exoplayer2.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class f extends e {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f32379a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f32380b;

    /* renamed from: c  reason: collision with root package name */
    private AssetFileDescriptor f32381c;

    /* renamed from: d  reason: collision with root package name */
    private FileInputStream f32382d;

    /* renamed from: e  reason: collision with root package name */
    private long f32383e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32384f;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public f(Context context) {
        super(false);
        this.f32379a = context.getContentResolver();
    }

    public final long a(l lVar) throws a {
        try {
            this.f32380b = lVar.f32395a;
            d();
            this.f32381c = this.f32379a.openAssetFileDescriptor(this.f32380b, "r");
            if (this.f32381c != null) {
                this.f32382d = new FileInputStream(this.f32381c.getFileDescriptor());
                long startOffset = this.f32381c.getStartOffset();
                long skip = this.f32382d.skip(lVar.f32400f + startOffset) - startOffset;
                if (skip == lVar.f32400f) {
                    long j = -1;
                    if (lVar.f32401g != -1) {
                        this.f32383e = lVar.f32401g;
                    } else {
                        long length = this.f32381c.getLength();
                        if (length == -1) {
                            FileChannel channel = this.f32382d.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                j = size - channel.position();
                            }
                            this.f32383e = j;
                        } else {
                            this.f32383e = length - skip;
                        }
                    }
                    this.f32384f = true;
                    b(lVar);
                    return this.f32383e;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: " + this.f32380b);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        long j = this.f32383e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i3 = (int) Math.min(j, (long) i3);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int read = this.f32382d.read(bArr, i2, i3);
        if (read != -1) {
            long j2 = this.f32383e;
            if (j2 != -1) {
                this.f32383e = j2 - ((long) read);
            }
            a(read);
            return read;
        } else if (this.f32383e == -1) {
            return -1;
        } else {
            throw new a(new EOFException());
        }
    }

    public final Uri a() {
        return this.f32380b;
    }

    public final void c() throws a {
        this.f32380b = null;
        try {
            if (this.f32382d != null) {
                this.f32382d.close();
            }
            this.f32382d = null;
            try {
                if (this.f32381c != null) {
                    this.f32381c.close();
                }
                this.f32381c = null;
                if (this.f32384f) {
                    this.f32384f = false;
                    e();
                }
            } catch (IOException e2) {
                throw new a(e2);
            } catch (Throwable th) {
                this.f32381c = null;
                if (this.f32384f) {
                    this.f32384f = false;
                    e();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new a(e3);
        } catch (Throwable th2) {
            this.f32382d = null;
            try {
                if (this.f32381c != null) {
                    this.f32381c.close();
                }
                this.f32381c = null;
                if (this.f32384f) {
                    this.f32384f = false;
                    e();
                }
                throw th2;
            } catch (IOException e4) {
                throw new a(e4);
            } catch (Throwable th3) {
                this.f32381c = null;
                if (this.f32384f) {
                    this.f32384f = false;
                    e();
                }
                throw th3;
            }
        }
    }
}
