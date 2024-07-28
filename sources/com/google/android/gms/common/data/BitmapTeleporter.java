package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8659a;

    /* renamed from: b  reason: collision with root package name */
    private ParcelFileDescriptor f8660b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8661c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f8662d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8663e = false;

    /* renamed from: f  reason: collision with root package name */
    private File f8664f;

    BitmapTeleporter(int i2, ParcelFileDescriptor parcelFileDescriptor, int i3) {
        this.f8659a = i2;
        this.f8660b = parcelFileDescriptor;
        this.f8661c = i3;
    }

    public final Bitmap a() {
        if (!this.f8663e) {
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.f8660b));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Bitmap.Config valueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                a(dataInputStream);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.f8662d = createBitmap;
                this.f8663e = true;
            } catch (IOException e2) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e2);
            } catch (Throwable th) {
                a(dataInputStream);
                throw th;
            }
        }
        return this.f8662d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        if (this.f8660b == null) {
            Bitmap bitmap = this.f8662d;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(b()));
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                a(dataOutputStream);
            } catch (IOException e2) {
                throw new IllegalStateException("Could not write into unlinked file", e2);
            } catch (Throwable th) {
                a(dataOutputStream);
                throw th;
            }
        }
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8659a);
        b.a(parcel, 2, this.f8660b, i2 | 1, false);
        b.b(parcel, 3, this.f8661c);
        b.b(parcel, a2);
        this.f8660b = null;
    }

    private final FileOutputStream b() {
        File file = this.f8664f;
        if (file != null) {
            try {
                File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.f8660b = ParcelFileDescriptor.open(createTempFile, 268435456);
                    createTempFile.delete();
                    return fileOutputStream;
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e2) {
                throw new IllegalStateException("Could not create temporary file", e2);
            }
        } else {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
