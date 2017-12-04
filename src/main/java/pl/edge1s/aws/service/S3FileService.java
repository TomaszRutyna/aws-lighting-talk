/*
 * Copyright 2001,2017 (c) Point Of Sale Solutions (POSS) of Sabre Inc. All
 * rights reserved.
 * 
 * This software and documentation is the confidential and proprietary
 * information of Sabre Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Sabre Inc.
 */
package pl.edge1s.aws.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 04, 2017
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class S3FileService
{

    private final AmazonS3 s3Client;

    public void put() {
        PutObjectResult result = s3Client.putObject(null, null, new File(""));
    }

    public void get() {
        S3Object result = s3Client.getObject(null);

    }

}
