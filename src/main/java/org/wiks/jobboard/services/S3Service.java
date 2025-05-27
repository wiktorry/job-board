package org.wiks.jobboard.services;

public interface S3Service {
    void putObject(String bucket, String key, byte[] file);

    byte[] getObject(String bucket, String key);
}
