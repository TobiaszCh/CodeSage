package com.educator.core.s3;

import com.educator.core.exception.CodeSageRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.url}")
    private String urlAws;

    private final S3Client s3Client;

    public String uploadFile(Long courseId, MultipartFile file) {
        try {
            String key = "/course/" + courseId + "/" + file.getOriginalFilename();
            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .build(), RequestBody.fromBytes(file.getBytes())
            );
            return urlAws + key;
        }
        catch (IOException e) {
            throw new CodeSageRuntimeException("Cannot upload course image to S3: " + e);
        }
    }

}
