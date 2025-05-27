package org.wiks.jobboard.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wiks.jobboard.exceptions.FileReadException;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {
    private final S3Client s3Client;

    @Override
    public void putObject(String bucket, String key, byte[] file) {
        PutObjectRequest putRequest = PutObjectRequest
                .builder()
                .bucket(bucket)
                .key(key)
                .build();
        s3Client.putObject(putRequest, RequestBody.fromBytes(file));
    }

    @Override
    public byte[] getObject(String bucket, String key) {
        GetObjectRequest getRequest = GetObjectRequest
                .builder()
                .bucket(bucket)
                .key(key)
                .build();
        ResponseInputStream<GetObjectResponse> response = s3Client.getObject(getRequest);
        try {
            return response.readAllBytes();
        } catch (IOException e) {
            throw new FileReadException("Problem with reading file");
        }
    }
}
