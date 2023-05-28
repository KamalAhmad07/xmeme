package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class ResponseDto {
  
  private Long id; 
  @NotEmpty
  private String name;
  @NotEmpty
  private String url;
  @NotEmpty
  private String caption;

}
 