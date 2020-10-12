package com.snkrstore.trades.web.controller;

import com.snkrstore.trades.services.BidService;
import com.snkrstore.trades.web.model.BidDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bid")
public class BidController {
    private final BidService bidService;

    public BidController(BidService bidService){
        this.bidService = bidService;
    }

    @GetMapping("/{bidId}")
    public ResponseEntity<BidDto> getById(@PathVariable Long bidId){
        return new ResponseEntity<>(bidService.getBidById(bidId), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<List<BidDto>> getByProductId(@RequestParam String productId){
        return new ResponseEntity<>(bidService.getBidListByProductId(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BidDto> saveBid(@RequestBody BidDto bidDto){
        return new ResponseEntity<BidDto>(bidService.saveBid(bidDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BidDto> updateBid(@RequestBody BidDto bidDto){
        return new ResponseEntity<BidDto>(bidService.updateBid(bidDto), HttpStatus.CREATED);
    }
    
}
