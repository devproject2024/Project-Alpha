package com.alipay.mobile.nebula.util.tar;

import easypay.manager.Constants;
import java.io.File;
import java.util.Date;

public class TarEntry {
    protected File file;
    protected TarHeader header;

    private TarEntry() {
        this.file = null;
        this.header = new TarHeader();
    }

    public TarEntry(File file2, String str) {
        this();
        this.file = file2;
        extractTarHeader(str);
    }

    public TarEntry(byte[] bArr) {
        this();
        parseTarHeader(bArr);
    }

    public TarEntry(TarHeader tarHeader) {
        this.file = null;
        this.header = tarHeader;
    }

    public boolean equals(TarEntry tarEntry) {
        return this.header.name.toString().equals(tarEntry.header.name.toString());
    }

    public boolean isDescendent(TarEntry tarEntry) {
        return tarEntry.header.name.toString().startsWith(this.header.name.toString());
    }

    public TarHeader getHeader() {
        return this.header;
    }

    public String getName() {
        String stringBuffer = this.header.name.toString();
        if (this.header.namePrefix == null || "".equals(this.header.namePrefix.toString())) {
            return stringBuffer;
        }
        return this.header.namePrefix.toString() + "/" + stringBuffer;
    }

    public void setName(String str) {
        this.header.name = new StringBuffer(str);
    }

    public int getUserId() {
        return this.header.userId;
    }

    public void setUserId(int i2) {
        this.header.userId = i2;
    }

    public int getGroupId() {
        return this.header.groupId;
    }

    public void setGroupId(int i2) {
        this.header.groupId = i2;
    }

    public String getUserName() {
        return this.header.userName.toString();
    }

    public void setUserName(String str) {
        this.header.userName = new StringBuffer(str);
    }

    public String getGroupName() {
        return this.header.groupName.toString();
    }

    public void setGroupName(String str) {
        this.header.groupName = new StringBuffer(str);
    }

    public void setIds(int i2, int i3) {
        setUserId(i2);
        setGroupId(i3);
    }

    public void setModTime(long j) {
        this.header.modTime = j / 1000;
    }

    public Date getModTime() {
        return new Date(this.header.modTime * 1000);
    }

    public void setModTime(Date date) {
        this.header.modTime = date.getTime() / 1000;
    }

    public File getFile() {
        return this.file;
    }

    public long getSize() {
        return this.header.size;
    }

    public void setSize(long j) {
        this.header.size = j;
    }

    public boolean isDirectory() {
        File file2 = this.file;
        if (file2 != null) {
            return file2.isDirectory();
        }
        TarHeader tarHeader = this.header;
        if (tarHeader == null) {
            return false;
        }
        if (tarHeader.linkFlag != 53 && !this.header.name.toString().endsWith("/")) {
            return false;
        }
        return true;
    }

    public void extractTarHeader(String str) {
        this.header = TarHeader.createHeader(str, this.file.length(), this.file.lastModified() / 1000, this.file.isDirectory());
    }

    public long computeCheckSum(byte[] bArr) {
        long j = 0;
        for (byte b2 : bArr) {
            j += (long) (b2 & 255);
        }
        return j;
    }

    public void writeEntryHeader(byte[] bArr) {
        int longOctalBytes = Octal.getLongOctalBytes(this.header.modTime, bArr, Octal.getLongOctalBytes(this.header.size, bArr, Octal.getOctalBytes((long) this.header.groupId, bArr, Octal.getOctalBytes((long) this.header.userId, bArr, Octal.getOctalBytes((long) this.header.mode, bArr, TarHeader.getNameBytes(this.header.name, bArr, 0, 100), 8), 8), 8), 12), 12);
        int i2 = longOctalBytes;
        int i3 = 0;
        while (i3 < 8) {
            bArr[i2] = 32;
            i3++;
            i2++;
        }
        bArr[i2] = this.header.linkFlag;
        for (int nameBytes = TarHeader.getNameBytes(this.header.namePrefix, bArr, Octal.getOctalBytes((long) this.header.devMinor, bArr, Octal.getOctalBytes((long) this.header.devMajor, bArr, TarHeader.getNameBytes(this.header.groupName, bArr, TarHeader.getNameBytes(this.header.userName, bArr, TarHeader.getNameBytes(this.header.magic, bArr, TarHeader.getNameBytes(this.header.linkName, bArr, i2 + 1, 100), 8), 32), 32), 8), 8), 155); nameBytes < bArr.length; nameBytes++) {
            bArr[nameBytes] = 0;
        }
        Octal.getCheckSumOctalBytes(computeCheckSum(bArr), bArr, longOctalBytes, 8);
    }

    public void parseTarHeader(byte[] bArr) {
        this.header.name = TarHeader.parseName(bArr, 0, 100);
        this.header.mode = (int) Octal.parseOctal(bArr, 100, 8);
        this.header.userId = (int) Octal.parseOctal(bArr, 108, 8);
        this.header.groupId = (int) Octal.parseOctal(bArr, 116, 8);
        this.header.size = Octal.parseOctal(bArr, 124, 12);
        this.header.modTime = Octal.parseOctal(bArr, 136, 12);
        this.header.checkSum = (int) Octal.parseOctal(bArr, 148, 8);
        TarHeader tarHeader = this.header;
        tarHeader.linkFlag = bArr[156];
        tarHeader.linkName = TarHeader.parseName(bArr, Constants.ACTION_SAVE_CUST_ID, 100);
        this.header.magic = TarHeader.parseName(bArr, 257, 8);
        this.header.userName = TarHeader.parseName(bArr, 265, 32);
        this.header.groupName = TarHeader.parseName(bArr, 297, 32);
        this.header.devMajor = (int) Octal.parseOctal(bArr, 329, 8);
        this.header.devMinor = (int) Octal.parseOctal(bArr, 337, 8);
        this.header.namePrefix = TarHeader.parseName(bArr, 345, 155);
    }
}
