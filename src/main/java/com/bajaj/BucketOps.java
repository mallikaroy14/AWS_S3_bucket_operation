package com.bajaj;

import com.amazonaws.services.s3.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BucketOps {
    private ClientConfig clientConfig;

    BucketOps(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    public void getAllBuckets() {

        List<Bucket> bucketList = this
                .clientConfig.getS3Client().listBuckets();
        bucketList.forEach((b) -> {
            System.out.println(b);
        });
    }

    public void createBucket(String bucketName) {
        if (this.clientConfig.getS3Client().doesBucketExistV2(bucketName)) {
            System.out.println("Bucket already exist");
        } else {
            Bucket bucket = this.clientConfig.getS3Client().createBucket(bucketName);
            System.out.println(bucket.getName());
        }
    }

    public void changeBucketPolicy(String bucketName, String policy) {
        this.clientConfig.getS3Client().setBucketPolicy(bucketName, policy);
    }

    public void uploadFile(String bucketName, String key, String filePath) {
        this.clientConfig.getS3Client().putObject(bucketName, key, new File(filePath));
    }

    public void seeAllObjects(String bucketName) {
        ListObjectsV2Result objectsV2Result = this.clientConfig.getS3Client().listObjectsV2(bucketName);
        List<S3ObjectSummary> listOfObjectSummer = objectsV2Result.getObjectSummaries();
        listOfObjectSummer.forEach((b) -> {
            System.out.println(b.getKey());
            System.out.println(b.getLastModified());
        });
    }

    public void downloadFile(String bucketName, String key) throws IOException {
        S3Object object = this.clientConfig.getS3Client().getObject(bucketName, key);
        S3ObjectInputStream inputObject = object.getObjectContent();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/mallikaroy/Downloads/new_file/abc.png"));
        byte[] readBuf  = new byte[1024];
        int read_len = 0;
        while((read_len = inputObject.read(readBuf))>0){
            fileOutputStream.write(readBuf,0,read_len);
        }

        object.close();
        inputObject.close();

    }

}
