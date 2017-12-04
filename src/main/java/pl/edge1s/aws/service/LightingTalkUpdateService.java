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

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edge1s.aws.service.dto.CreateLightingTalkDto;
import pl.edge1s.aws.service.dto.EditLightingTalkDto;

import java.util.Objects;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LightingTalkUpdateService
{
    private final LightingTalkRepository repository;

    public void create(CreateLightingTalkDto dto) {
        repository.save(LightingTalk.create(dto));
    }

    @Transactional
    public void edit(EditLightingTalkDto dto) {
        LightingTalk talk = repository.findByUuid(dto.getUuid());

        Preconditions.checkState(Objects.nonNull(talk), "Cannot edit talk, which is not exist");

        talk.update(dto);
    }

    public void delete(String uuid) {
        LightingTalk talk = repository.findByUuid(uuid);

        Preconditions.checkState(Objects.nonNull(talk), "Cannot delete talk, which is not exist");

        repository.delete(talk);
    }

}
