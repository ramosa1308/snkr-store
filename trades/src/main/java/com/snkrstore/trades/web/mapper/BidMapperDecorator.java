package com.snkrstore.trades.web.mapper;

import com.snkrstore.trades.domain.Bid;
import com.snkrstore.trades.web.model.BidDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BidMapperDecorator implements BidMapper {
    private BidMapper bidMapper;

    @Autowired
    public void setBidMapper(BidMapper bidMapper){
        this.bidMapper = bidMapper;
    }

    @Override
    public BidDto bidToBidDto(Bid bid) {
        return bidMapper.bidToBidDto(bid);
    }

    @Override
    public Bid bidDtoToBid(BidDto bidDto) {
        return bidMapper.bidDtoToBid(bidDto);
    }

    @Override
    public List<BidDto> bidListToBidDtoList(List<Bid> bidList) {
        return bidMapper.bidListToBidDtoList(bidList);
    }
}
