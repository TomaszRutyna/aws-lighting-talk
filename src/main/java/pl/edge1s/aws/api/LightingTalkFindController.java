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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edge1s.aws.service.LightingTalkFinder;
import pl.edge1s.aws.service.dto.LightingTalkDto;

import java.util.List;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */
@RestController
@RequestMapping("api/talk")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LightingTalkFindController
{
    private final LightingTalkFinder finder;

    @GetMapping
    public List<LightingTalkDto> getAll() {
        return finder.getAll();
    }

    @GetMapping(value = "/{uuid]")
    public LightingTalkDto getOne(@PathVariable("uuid") String uuid) {
        return finder.findOne(uuid);
    }
}
