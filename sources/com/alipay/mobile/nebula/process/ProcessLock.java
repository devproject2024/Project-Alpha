package com.alipay.mobile.nebula.process;

import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class ProcessLock {
    public static final String TAG = "H5ProcessLock";
    private FileLock cacheLock;
    private FileChannel lockChannel;
    private File lockFile;
    private RandomAccessFile lockRaf;

    public ProcessLock(String str) {
        this.lockFile = new File(str);
    }

    public ProcessLock(File file) {
        this.lockFile = file;
    }

    public void lock() {
        try {
            this.lockRaf = new RandomAccessFile(this.lockFile, "rw");
            RandomAccessFile randomAccessFile = this.lockRaf;
            if (randomAccessFile == null || this.lockFile == null) {
                H5Log.e(TAG, "lock error lockRaf = " + this.lockRaf + " lockFile = " + this.lockFile);
                return;
            }
            this.lockChannel = randomAccessFile.getChannel();
            H5Log.d(TAG, "Blocking on lock " + this.lockFile.getPath());
            try {
                this.cacheLock = this.lockChannel.lock();
                H5Log.d(TAG, this.lockFile.getPath() + " locked");
            } catch (IOException e2) {
                H5Log.e(TAG, "lock error ", e2);
            }
        } catch (FileNotFoundException e3) {
            H5Log.e(TAG, "ProcessLock error", e3);
        }
    }

    public void unlock() {
        FileLock fileLock = this.cacheLock;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException unused) {
                StringBuilder sb = new StringBuilder("Failed to release lock on ");
                File file = this.lockFile;
                sb.append(file != null ? file.getPath() : "");
                H5Log.e(TAG, sb.toString());
            }
        }
        H5IOUtils.closeQuietly(this.lockChannel);
        H5IOUtils.closeQuietly(this.lockRaf);
        if (this.lockFile != null) {
            H5Log.d(TAG, this.lockFile.getPath() + " unlocked");
        }
    }
}
