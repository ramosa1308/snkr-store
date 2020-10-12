package com.snkrstore.trades.web.mapper;

import com.snkrstore.trades.domain.Bid;
import com.snkrstore.trades.web.model.BidDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(BidMapperDecorator.class)
public interface BidMapper {
    BidDto bidToBidDto(Bid bid);
    Bid bidDtoToBid(BidDto bidDto);
    List<BidDto> bidListToBidDtoList(List<Bid> bidList);
}
