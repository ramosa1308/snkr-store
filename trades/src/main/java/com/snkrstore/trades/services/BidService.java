package com.snkrstore.trades.services;

import com.snkrstore.trades.web.model.BidDto;

import java.util.List;

public interface BidService {
    BidDto getBidById(Long bidId);

    BidDto saveBid(BidDto bidDto);

    BidDto updateBid(BidDto bidDto);

    List<BidDto> getBidListByProductId(String productId);
}
