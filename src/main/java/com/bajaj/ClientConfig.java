package com.bajaj;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


public class ClientConfig {
    private static AmazonS3 s3Client;

    public ClientConfig() {
        s3Client = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.DEFAULT_REGION)
                .build();

    }

    public AmazonS3 getS3Client() {
        return s3Client;
    }


}
