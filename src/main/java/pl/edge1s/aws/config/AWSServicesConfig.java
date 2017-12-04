/*
 * Copyright 2001,2017 (c) Point Of Sale Solutions (POSS) of Sabre Inc. All
 * rights reserved.
 * 
 * This software and documentation is the confidential and proprietary
 * information of Sabre Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Sabre Inc.
 */
package pl.edge1s.aws.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */

@Configuration
@EnableDynamoDBRepositories(basePackages = "pl.edge1s.aws.service")
public class AWSServicesConfig
{
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSRegion;

    @Bean
    public AmazonDynamoDB amazonDynamoDB()
    {
        AmazonDynamoDB amazonDynamoDB =
                        AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                                        new AwsClientBuilder.EndpointConfiguration(
                                                        amazonDynamoDBEndpoint, amazonAWSRegion))
                                        .build();

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials()
    {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    @Bean
    public AmazonS3 amazonS3() {
        AmazonS3 amazonS3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                        amazonDynamoDBEndpoint, amazonAWSRegion))
                        .build();
        return amazonS3Client;
    }
}
