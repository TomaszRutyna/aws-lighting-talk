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

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import pl.edge1s.aws.service.dto.AppendedFileDto;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */
@DynamoDBDocument
public class LightingTalkFile
{
    @DynamoDBAttribute
    private String uuid;
    @DynamoDBAttribute
    private String name;

    AppendedFileDto toDto() {
        return AppendedFileDto.builder()
                        .name(this.name)
                        .uuid(this.uuid)
                        .build();
    }
}
