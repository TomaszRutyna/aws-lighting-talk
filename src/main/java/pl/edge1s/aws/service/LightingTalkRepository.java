package pl.edge1s.aws.service;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Tomasz Rutyna (SG0301553)
 * @since Dec 01, 2017
 */
@EnableScan
interface LightingTalkRepository extends CrudRepository<LightingTalk, String>
{
    LightingTalk findByUuid(String uuid);
}
