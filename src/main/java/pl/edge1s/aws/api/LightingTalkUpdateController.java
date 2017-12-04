/*
 * Copyright 2001,2017 (c) Point Of Sale Solutions (POSS) of Sabre Inc. All
 * rights reserved.
 * 
 * This software and documentation is the confidential and proprietary
 * information of Sabre Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Sabre Inc.
 */
package pl.edge1s.aws.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edge1s.aws.service.LightingTalkUpdateService;
import pl.edge1s.aws.service.dto.CreateLightingTalkDto;
import pl.edge1s.aws.service.dto.EditLightingTalkDto;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */
@RestController
@RequestMapping("api/talk")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LightingTalkUpdateController
{
    private final LightingTalkUpdateService service;

    @PutMapping
    public void createTalk(@RequestBody CreateLightingTalkDto request) {
        service.create(request);
    }

    @PostMapping
    public void updateTalk(@RequestBody EditLightingTalkDto request) {
        service.edit(request);
    }

    @DeleteMapping
    public void deleteTalk() {
        service.delete(null);
    }
}
