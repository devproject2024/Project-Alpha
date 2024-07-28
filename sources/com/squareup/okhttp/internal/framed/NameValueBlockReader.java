package com.squareup.okhttp.internal.framed;

import i.c;
import i.e;
import i.f;
import i.i;
import i.m;
import i.n;
import i.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class NameValueBlockReader {
    /* access modifiers changed from: private */
    public int compressedLimit;
    private final m inflaterSource;
    private final e source = n.a((v) this.inflaterSource);

    public NameValueBlockReader(e eVar) {
        this.inflaterSource = new m((v) new i(eVar) {
            public long read(c cVar, long j) throws IOException {
                if (NameValueBlockReader.this.compressedLimit == 0) {
                    return -1;
                }
                long read = super.read(cVar, Math.min(j, (long) NameValueBlockReader.this.compressedLimit));
                if (read == -1) {
                    return -1;
                }
                NameValueBlockReader nameValueBlockReader = NameValueBlockReader.this;
                int unused = nameValueBlockReader.compressedLimit = (int) (((long) nameValueBlockReader.compressedLimit) - read);
                return read;
            }
        }, (Inflater) new Inflater() {
            public int inflate(byte[] bArr, int i2, int i3) throws DataFormatException {
                int inflate = super.inflate(bArr, i2, i3);
                if (inflate != 0 || !needsDictionary()) {
                    return inflate;
                }
                setDictionary(Spdy3.DICTIONARY);
                return super.inflate(bArr, i2, i3);
            }
        });
    }

    public List<Header> readNameValueBlock(int i2) throws IOException {
        this.compressedLimit += i2;
        int i3 = this.source.i();
        if (i3 < 0) {
            throw new IOException("numberOfPairs < 0: ".concat(String.valueOf(i3)));
        } else if (i3 <= 1024) {
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            while (i4 < i3) {
                f asciiLowercase = readByteString().toAsciiLowercase();
                f readByteString = readByteString();
                if (asciiLowercase.size() != 0) {
                    arrayList.add(new Header(asciiLowercase, readByteString));
                    i4++;
                } else {
                    throw new IOException("name.size == 0");
                }
            }
            doneReading();
            return arrayList;
        } else {
            throw new IOException("numberOfPairs > 1024: ".concat(String.valueOf(i3)));
        }
    }

    private f readByteString() throws IOException {
        return this.source.d((long) this.source.i());
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit > 0) {
            this.inflaterSource.a();
            if (this.compressedLimit != 0) {
                throw new IOException("compressedLimit > 0: " + this.compressedLimit);
            }
        }
    }

    public void close() throws IOException {
        this.source.close();
    }
}
