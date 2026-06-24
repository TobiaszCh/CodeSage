package com.educator.s3;

import com.educator.core.exception.CodeSageRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

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
            String key = "course/" + courseId + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
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

    public void deleteFile(String imageUrl) {
        try {
            String key = imageUrl.replace(urlAws, "");
            s3Client.deleteObject(DeleteObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .build()
            );
        }
        catch (SdkException e) {
            throw new CodeSageRuntimeException("Cannot delete course image to S3: " + e);
        }
    }

}
