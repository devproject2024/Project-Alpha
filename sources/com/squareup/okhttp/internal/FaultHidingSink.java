package com.squareup.okhttp.internal;

import i.c;
import i.h;
import i.u;
import java.io.IOException;

class FaultHidingSink extends h {
    private boolean hasErrors;

    /* access modifiers changed from: protected */
    public void onException(IOException iOException) {
    }

    public FaultHidingSink(u uVar) {
        super(uVar);
    }

    public void write(c cVar, long j) throws IOException {
        if (this.hasErrors) {
            cVar.i(j);
            return;
        }
        try {
            super.write(cVar, j);
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }

    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e2) {
                this.hasErrors = true;
                onException(e2);
            }
        }
    }

    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e2) {
                this.hasErrors = true;
                onException(e2);
            }
        }
    }
}
