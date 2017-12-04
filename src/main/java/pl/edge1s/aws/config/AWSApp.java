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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */
@SpringBootApplication
@Import(MainConfiguration.class)
public class AWSApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(AWSApp.class, args);
    }

}
