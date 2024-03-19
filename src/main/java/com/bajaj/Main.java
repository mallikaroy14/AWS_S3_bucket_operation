package com.bajaj;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ClientConfig clientConfig = new ClientConfig();

        BucketOps bucketOps = new BucketOps(clientConfig);
        // To get all bucket
//        bucketOps.getAllBuckets();

        // To create bucket
//        bucketOps.createBucket("mallika-java-demo");

        String policy = "{\n" +
                "\t\"Version\": \"2012-10-17\",\n" +
                "\t\"Statement\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"Sid\": \"Statement1\",\n" +
                "\t\t\t\"Principal\": \"*\",\n" +
                "\t\t\t\"Effect\": \"Allow\",\n" +
                "\t\t\t\"Action\": [\n" +
                "\t\t\t\t\"s3:GetObject\",\n" +
                "\t\t\t\t\"s3:PutObject\"\n" +
                "\t\t\t],\n" +
                "\t\t\t\"Resource\": [\"arn:aws:s3:::mallika-java-demo/*\"]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

//        bucketOps.changeBucketPolicy("mallika-java-demo", policy);

        //To upload file in S3
//        bucketOps.uploadFile("mallika-java-demo", "demo-file", "/Users/mallikaroy/Downloads/superAchieverAward.jpg");

        //List
//        bucketOps.seeAllObjects("mallika-java-demo");

        //To download file from S3
        bucketOps.downloadFile("mallika-java-demo", "demo-file");

// To delete
        // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-s3-objects.html
        
    }
}