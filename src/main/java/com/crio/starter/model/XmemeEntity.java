package com.crio.starter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "xmeme")
@NoArgsConstructor
@AllArgsConstructor 
@CompoundIndexes({
  @CompoundIndex(name = "unique_meme", def = "{'name' : 1, 'url' : 1, 'caption' : 1}", unique = true)
})
public class XmemeEntity {
  
  @Id
  private   Long id;
  
  private String name;

 
  private String url;


  private String caption;


}
