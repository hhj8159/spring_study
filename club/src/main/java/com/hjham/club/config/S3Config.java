// package com.hjham.club.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
// import software.amazon.awssdk.regions.Region;
// import software.amazon.awssdk.services.s3.S3Client;

// @Configuration
// public class S3Config {

//     @Bean
//     public S3Client s3Client() {
//         return S3Client.builder()
//                 .region(Region.US_EAST_1) // AWS 리전 설정
//                 .credentialsProvider(DefaultCredentialsProvider.create()) // 자격 증명 공급자 설정
//                 .build();
//     }
// }
