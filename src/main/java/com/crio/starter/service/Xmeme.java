package com.crio.starter.service;

import java.util.List;
import com.crio.starter.exchange.ResponseDto;

public interface Xmeme {
    
    public  ResponseDto postMemes(ResponseDto responseDto);
    public  List<ResponseDto> getAllMemes();
    public  ResponseDto getMemes(Long id);
    

}
