package com.snkrstore.trades.web.mapper;

import com.snkrstore.trades.domain.Ask;
import com.snkrstore.trades.web.model.AskDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AskMapperDecorator implements AskMapper{
    private AskMapper askMapper;

    @Autowired
    public void setAskMapper(AskMapper askMapper){
        this.askMapper = askMapper;
    }

    @Override
    public AskDto askToAskDto(Ask ask) {
        return askMapper.askToAskDto(ask);
    }

    @Override
    public Ask askDtoToAsk(AskDto askDto) {
        return askMapper.askDtoToAsk(askDto);
    }

    @Override
    public List<AskDto> askListToAskDtoList(List<Ask> askList) {
        return askMapper.askListToAskDtoList(askList);
    }
}
