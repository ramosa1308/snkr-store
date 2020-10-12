package com.snkrstore.trades.web.controller;

import com.snkrstore.trades.services.AskService;
import com.snkrstore.trades.web.model.AskDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ask")
public class AskController {
    private final AskService askService;

    public AskController(AskService askService){
        this.askService = askService;
    }

    @GetMapping("/{askId}")
    public ResponseEntity<AskDto> getById(@PathVariable Long askId){
        return new ResponseEntity<>(askService.getAskById(askId), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<List<AskDto>> getByProductId(@RequestParam String productId){
        return new ResponseEntity<>(askService.getAskListByProductId(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AskDto> saveAsk(@RequestBody AskDto askDto){
        return new ResponseEntity<AskDto>(askService.saveAsk(askDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AskDto> updateAsk(@RequestBody AskDto askDto){
        return new ResponseEntity<AskDto>(askService.updateAsk(askDto), HttpStatus.CREATED);
    }


}
