package com.crio.starter.repository;

import com.crio.starter.model.XmemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface XmemeRepository extends MongoRepository<XmemeEntity, Long> {
    XmemeEntity findByNameAndUrlAndCaption(String name, String url, String caption);

}
