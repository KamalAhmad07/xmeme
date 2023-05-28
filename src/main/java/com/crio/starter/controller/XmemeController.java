package com.crio.starter.controller;

import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.service.Xmeme;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class XmemeController {

  @Autowired
  private final Xmeme  xmemeService;


  @PostMapping("memes")
  public  ResponseEntity<ResponseDto> postMemes(@RequestBody @Valid ResponseDto responseDto){
    ResponseDto responseDto1 = xmemeService.postMemes(responseDto);
    if(responseDto1 == null){
      return  ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    return ResponseEntity.ok(responseDto);
  }
  @GetMapping("memes")
  public ResponseEntity<List<ResponseDto>> getAllMemes() {
      List<ResponseDto> memes = xmemeService.getAllMemes();
      if(memes == null){
        return  ResponseEntity.status(HttpStatus.OK).build();
      }
      return ResponseEntity.ok(memes);
  }

  @GetMapping("memes/{id}")
  public  ResponseEntity<ResponseDto> getMemesById(@PathVariable("id") Long id){
    ResponseDto dto = xmemeService.getMemes(id);
    if(dto == null){
      return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }
     return ResponseEntity.ok(dto);
  }
}
