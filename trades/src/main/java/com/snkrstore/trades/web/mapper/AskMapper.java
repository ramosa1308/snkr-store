package com.snkrstore.trades.web.mapper;

import com.snkrstore.trades.domain.Ask;
import com.snkrstore.trades.web.model.AskDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(AskMapperDecorator.class)
public interface AskMapper {
    AskDto askToAskDto(Ask ask);
    Ask askDtoToAsk(AskDto askDto);
    List<AskDto> askListToAskDtoList(List<Ask> askList);
}
