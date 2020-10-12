package com.snkrstore.trades.repository;

import com.snkrstore.trades.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid,Long> {
    List<Bid> getBidListByProductId(String productId);
    List<Bid> getBidListByProductIdAndAndSize(String productId, Float size);
}
