package com.google.android.play.core.b;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

class bp extends X509Certificate {

    /* renamed from: a  reason: collision with root package name */
    private final X509Certificate f37297a;

    public bp(X509Certificate x509Certificate) {
        this.f37297a = x509Certificate;
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.f37297a.checkValidity();
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.f37297a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.f37297a.getBasicConstraints();
    }

    public final Set<String> getCriticalExtensionOIDs() {
        return this.f37297a.getCriticalExtensionOIDs();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f37297a.getEncoded();
    }

    public final byte[] getExtensionValue(String str) {
        return this.f37297a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.f37297a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.f37297a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.f37297a.getKeyUsage();
    }

    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.f37297a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.f37297a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.f37297a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.f37297a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.f37297a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.f37297a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.f37297a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.f37297a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.f37297a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.f37297a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.f37297a.getSubjectUniqueID();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f37297a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.f37297a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.f37297a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.f37297a.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f37297a.verify(publicKey);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f37297a.verify(publicKey, str);
    }
}
