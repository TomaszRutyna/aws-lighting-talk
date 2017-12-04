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

import com.google.common.collect.Streams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edge1s.aws.service.dto.LightingTalkDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LightingTalkFinder
{
    private final LightingTalkRepository repository;

    public List<LightingTalkDto> getAll() {
        Iterable<LightingTalk> all = repository.findAll();

        return Streams.stream(all)
                        .map(LightingTalk::toDto)
                        .collect(Collectors.toList());
    }

    public LightingTalkDto findOne(String uuid) {
        LightingTalk talk = repository.findByUuid(uuid);

        if (Objects.isNull(talk)) {
            return null;
        }

        return talk.toDto();
    }
}
