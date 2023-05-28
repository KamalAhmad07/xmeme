package com.crio.starter.service;

import com.crio.starter.App;
import com.crio.starter.exception.DataMatchedEception;
import com.crio.starter.exception.DataNotFoundException;
import com.crio.starter.exchange.ResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = {App.class})
public class XmemeServiceTest {

    // @Autowired
    // private Xmeme xmemeService;

    // private ResponseDto responseDto;

    // @BeforeEach
    // public void setup() throws DataMatchedEception {
    //     responseDto = new ResponseDto(1L, "Meme", "https://test.com/meme", "Caption");
    //     xmemeService.postMemes(responseDto);
    // }

    // @Test
    // public void testSaveMemes() throws DataMatchedEception, DataNotFoundException {

    //     ResponseDto dummy = new ResponseDto(2L, "Meme2", "https://test2.com/meme", "Caption2");

    //     xmemeService.postMemes(dummy);

    //     ResponseDto response = xmemeService.getMemes(dummy.getId());

    //     assertEquals(dummy.getId(), response.getId());
    //     assertEquals(dummy.getName(), response.getName());
    //     assertEquals(dummy.getUrl(), response.getUrl());
    //     assertEquals(dummy.getCaption(), response.getCaption());

    // }

    // @Test
    // public void testGetMemeById() throws DataNotFoundException {
        
    //     ResponseDto response = xmemeService.getMemes(responseDto.getId());

    //     boolean actual = false;
    //     if(response != null) actual = true;

    //     assertEquals(true , actual);

    // }

    // @Test
    // public void testGetMemes() throws DataMatchedEception {
        
    //     ResponseDto dummy = new ResponseDto(3L, "Meme3", "https://test3.com/meme", "Caption3");

    //     xmemeService.postMemes(dummy);

    //     List<ResponseDto> responseDtos = xmemeService.getAllMemes();

    //     assertTrue(responseDtos.size() >= 2);

    // }

}