package com.snkrstore.trades.repository;

import com.snkrstore.trades.domain.Ask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AskRepository extends JpaRepository<Ask,Long> {
     List<Ask> getAskListByProductId(String productId);
     List<Ask> getAskListByProductIdAndAndSize(String productId, Float size);
}
