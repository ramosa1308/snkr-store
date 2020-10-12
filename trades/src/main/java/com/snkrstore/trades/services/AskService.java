package com.snkrstore.trades.services;

import com.snkrstore.trades.web.model.AskDto;

import java.util.List;

public interface AskService {

    AskDto getAskById(Long askId);

    AskDto saveAsk(AskDto askDto);

    AskDto updateAsk(AskDto askDto);

    List<AskDto> getAskListByProductId(String productId);
}
