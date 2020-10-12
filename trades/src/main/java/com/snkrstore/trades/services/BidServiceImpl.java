package com.snkrstore.trades.services;

import com.snkrstore.trades.domain.Bid;
import com.snkrstore.trades.repository.BidRepository;
import com.snkrstore.trades.web.mapper.BidMapper;
import com.snkrstore.trades.web.model.BidDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BidServiceImpl implements BidService{
    private final BidRepository bidRepository;
    private final BidMapper bidMapper;
    
    @Override
    public BidDto getBidById(Long bidId) {
        Optional<Bid> optionalBid = bidRepository.findById(bidId);
        Bid bid = new Bid();
        if(optionalBid.isPresent()){
            bid = optionalBid.get();
        }
        return bidMapper.bidToBidDto(bid);
    }

    @Override
    public BidDto saveBid(BidDto bidDto) {
        Bid bid = bidMapper.bidDtoToBid(bidDto);
        return bidMapper.bidToBidDto(bidRepository.save(bid));
    }

    @Override
    public BidDto updateBid(BidDto bidDto) {
        Bid bid = bidMapper.bidDtoToBid(bidDto);
        return bidMapper.bidToBidDto(bidRepository.save(bid));
    }

    @Override
    public List<BidDto> getBidListByProductId(String productId) {
        return bidMapper.bidListToBidDtoList(bidRepository.getBidListByProductId(productId));
    }
}
