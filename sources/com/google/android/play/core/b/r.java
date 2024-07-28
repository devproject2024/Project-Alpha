package com.google.android.play.core.b;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class r {
    public static String a(File file) {
        if (file.getName().endsWith(".apk")) {
            return file.getName().replaceFirst("(_\\d+)?\\.apk", "").replace("base-", "config.").replace("-", ".config.").replace(".config.master", "").replace("config.master", "");
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    public static void a(ax axVar, InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[16384];
        InputStream inputStream2 = inputStream;
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int readInt = dataInputStream.readInt();
        if (readInt != -771763713) {
            String valueOf = String.valueOf(String.format("%x", new Object[]{Integer.valueOf(readInt)}));
            throw new aw(valueOf.length() == 0 ? new String("Unexpected magic=") : "Unexpected magic=".concat(valueOf));
        }
        int read = dataInputStream.read();
        if (read == 4) {
            long j2 = 0;
            while (true) {
                long j3 = j - j2;
                try {
                    int read2 = dataInputStream.read();
                    if (read2 == -1) {
                        throw new IOException("Patch file overrun");
                    } else if (read2 != 0) {
                        switch (read2) {
                            case 247:
                                read2 = dataInputStream.readUnsignedShort();
                                a(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 248:
                                read2 = dataInputStream.readInt();
                                a(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 249:
                                long readUnsignedShort = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    a(bArr, axVar, outputStream, readUnsignedShort, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 250:
                                long readUnsignedShort2 = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.readUnsignedShort();
                                a(bArr, axVar, outputStream, readUnsignedShort2, read2, j3);
                                break;
                            case 251:
                                long readUnsignedShort3 = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.readInt();
                                a(bArr, axVar, outputStream, readUnsignedShort3, read2, j3);
                                break;
                            case 252:
                                long readInt2 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    a(bArr, axVar, outputStream, readInt2, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 253:
                                long readInt3 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.readUnsignedShort();
                                a(bArr, axVar, outputStream, readInt3, read2, j3);
                                break;
                            case 254:
                                long readInt4 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.readInt();
                                a(bArr, axVar, outputStream, readInt4, read2, j3);
                                break;
                            case PriceRangeSeekBar.INVALID_POINTER_ID /*255*/:
                                long readLong = dataInputStream.readLong();
                                read2 = dataInputStream.readInt();
                                a(bArr, axVar, outputStream, readLong, read2, j3);
                                break;
                            default:
                                a(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                        }
                        j2 += (long) read2;
                    } else {
                        return;
                    }
                } finally {
                    outputStream.flush();
                }
            }
        } else {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Unexpected version=");
            sb.append(read);
            throw new aw(sb.toString());
        }
    }

    private static void a(byte[] bArr, ax axVar, OutputStream outputStream, long j, int i2, long j2) throws IOException {
        InputStream b2;
        Throwable th;
        byte[] bArr2 = bArr;
        int i3 = i2;
        if (i3 < 0) {
            throw new IOException("copyLength negative");
        } else if (j >= 0) {
            long j3 = (long) i3;
            if (j3 <= j2) {
                try {
                    b2 = new ay(axVar, j, j3).b();
                    while (i3 > 0) {
                        int min = Math.min(i3, 16384);
                        int i4 = 0;
                        while (i4 < min) {
                            int read = b2.read(bArr, i4, min - i4);
                            if (read != -1) {
                                i4 += read;
                            } else {
                                throw new IOException("truncated input stream");
                            }
                        }
                        OutputStream outputStream2 = outputStream;
                        outputStream.write(bArr, 0, min);
                        i3 -= min;
                    }
                    if (b2 != null) {
                        b2.close();
                        return;
                    }
                    return;
                } catch (EOFException e2) {
                    throw new IOException("patch underrun", e2);
                } catch (Throwable th2) {
                    bg.a(th, th2);
                }
            } else {
                throw new IOException("Output length overrun");
            }
        } else {
            throw new IOException("inputOffset negative");
        }
        throw th;
    }

    private static void a(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i2, long j) throws IOException {
        if (i2 < 0) {
            throw new IOException("copyLength negative");
        } else if (((long) i2) <= j) {
            while (i2 > 0) {
                try {
                    int min = Math.min(i2, 16384);
                    dataInputStream.readFully(bArr, 0, min);
                    outputStream.write(bArr, 0, min);
                    i2 -= min;
                } catch (EOFException unused) {
                    throw new IOException("patch underrun");
                }
            }
        } else {
            throw new IOException("Output length overrun");
        }
    }
}
