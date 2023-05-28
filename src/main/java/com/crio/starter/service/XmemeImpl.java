package com.crio.starter.service;

import com.crio.starter.GenrateId.CustomIdGeneratorService;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.model.XmemeEntity;
import com.crio.starter.repository.XmemeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class XmemeImpl  implements Xmeme{

  @Autowired
  private final XmemeRepository xmemeRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private final MongoTemplate mongoTemplate;

  @Autowired 
  private final CustomIdGeneratorService customIdGeneratorService;
   
  @Override
  public ResponseDto postMemes(ResponseDto responseDto){
    // Validating data

    // Generating custom id
     long nextId = customIdGeneratorService.getNextId();
    responseDto.setId(nextId);

    XmemeEntity entity = modelMapper.map(responseDto, XmemeEntity.class);

    // Check if the combination of name, url, and caption already exists
    XmemeEntity existingMeme = xmemeRepository.findByNameAndUrlAndCaption(
        responseDto.getName(), responseDto.getUrl(), responseDto.getCaption());
    
    if (existingMeme != null) {
      // Return null if meme already exists 
          return null;
    }
    entity = xmemeRepository.save(entity);
    return modelMapper.map(entity, ResponseDto.class);
  }

  @Override
  public List<ResponseDto> getAllMemes() {
          
    List<ResponseDto> responseDtos = new ArrayList();
    List<XmemeEntity> xmemeEntity;
    
    try {
      // Aggregating the data in dec order and fetching 100 records
      Aggregation aggregation = Aggregation.newAggregation(
      Aggregation.sort(Sort.Direction.DESC, "_id"),
      Aggregation.limit(100));

      // Fetching all the records from DB
      xmemeEntity = mongoTemplate.aggregate(aggregation, "xmeme", XmemeEntity.class).getMappedResults();


      // mapping from xmemeEntity to responseDto
      responseDtos = Arrays.asList(modelMapper.map(xmemeEntity,ResponseDto[].class));

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return responseDtos;
  }
  @Override
  public ResponseDto getMemes(Long id){
      Optional<XmemeEntity> optionalEntity = xmemeRepository.findById(id);
      if (!optionalEntity.isPresent()) {
          return null;
      }
      XmemeEntity entity = optionalEntity.get();
      ResponseDto dto = modelMapper.map(entity, ResponseDto.class);
      return dto;
  }
  

}
