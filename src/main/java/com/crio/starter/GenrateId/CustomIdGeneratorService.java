package com.crio.starter.GenrateId;

import com.crio.starter.model.XmemeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
 
@Service
public class CustomIdGeneratorService {


    private final MongoOperations mongoOperations;

    @Autowired
    public CustomIdGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long getNextId() {
       long count = mongoOperations.count(new Query(), XmemeEntity.class);
       return count+1;
    
    }
}
 

