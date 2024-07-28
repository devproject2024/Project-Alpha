package com.google.android.play.core.assetpacks;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

final class cm {

    /* renamed from: g  reason: collision with root package name */
    private static final b f37147g = new b("SliceMetadataManager");

    /* renamed from: a  reason: collision with root package name */
    final ad f37148a;

    /* renamed from: b  reason: collision with root package name */
    final String f37149b;

    /* renamed from: c  reason: collision with root package name */
    final int f37150c;

    /* renamed from: d  reason: collision with root package name */
    final long f37151d;

    /* renamed from: e  reason: collision with root package name */
    final String f37152e;

    /* renamed from: f  reason: collision with root package name */
    int f37153f;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f37154h = new byte[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];

    cm(ad adVar, String str, int i2, long j, String str2) {
        this.f37148a = adVar;
        this.f37149b = str;
        this.f37150c = i2;
        this.f37151d = j;
        this.f37152e = str2;
        this.f37153f = 0;
    }

    private final File e() {
        File f2 = this.f37148a.f(this.f37149b, this.f37150c, this.f37151d, this.f37152e);
        if (!f2.exists()) {
            f2.mkdirs();
        }
        return f2;
    }

    /* access modifiers changed from: package-private */
    public final cl a() throws IOException {
        File c2 = this.f37148a.c(this.f37149b, this.f37150c, this.f37151d, this.f37152e);
        if (c2.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(c2);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new ax("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", H5BridgeContext.INVALID_ID));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", H5BridgeContext.INVALID_ID));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f37153f = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new ak(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e2) {
                    throw new ax("Slice checkpoint file corrupt.", (Exception) e2);
                }
            } catch (Throwable th) {
                bg.a(th, th);
            }
        } else {
            throw new ax("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void a(InputStream inputStream, long j) throws IOException {
        int read;
        File b2 = b();
        b2.getParentFile().mkdirs();
        RandomAccessFile randomAccessFile = new RandomAccessFile(b2, "rw");
        randomAccessFile.seek(j);
        do {
            read = inputStream.read(this.f37154h);
            if (read > 0) {
                randomAccessFile.write(this.f37154h, 0, read);
            }
        } while (read == this.f37154h.length);
        randomAccessFile.close();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, long j, long j2, int i2) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f37153f));
        FileOutputStream fileOutputStream = new FileOutputStream(d());
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        File e2 = e();
        int i2 = this.f37153f;
        this.f37153f = i2 + 1;
        try {
            fileOutputStream = new FileOutputStream(new File(e2, String.format("%s-LFH.dat", new Object[]{Integer.valueOf(i2)})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e3) {
            throw new ax("Could not write metadata file.", (Exception) e3);
        } catch (Throwable th) {
            bg.a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public final void a(byte[] bArr, InputStream inputStream) throws IOException {
        File e2 = e();
        int i2 = this.f37153f;
        this.f37153f = i2 + 1;
        FileOutputStream fileOutputStream = new FileOutputStream(new File(e2, String.format("%s-NAM.dat", new Object[]{Integer.valueOf(i2)})));
        fileOutputStream.write(bArr);
        int read = inputStream.read(this.f37154h);
        while (read > 0) {
            fileOutputStream.write(this.f37154h, 0, read);
            read = inputStream.read(this.f37154h);
        }
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final File b() {
        return new File(e(), String.format("%s-NAM.dat", new Object[]{Integer.valueOf(this.f37153f - 1)}));
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        File c2 = this.f37148a.c(this.f37149b, this.f37150c, this.f37151d, this.f37152e);
        if (c2.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(c2);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                if (properties.getProperty("fileStatus") != null) {
                    return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
                }
                f37147g.b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                return false;
            } catch (IOException e2) {
                f37147g.b("Could not read checkpoint while checking if extraction finished. %s", e2);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final File d() throws IOException {
        File c2 = this.f37148a.c(this.f37149b, this.f37150c, this.f37151d, this.f37152e);
        c2.getParentFile().mkdirs();
        c2.createNewFile();
        return c2;
    }
}
