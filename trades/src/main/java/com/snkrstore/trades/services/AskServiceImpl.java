package com.snkrstore.trades.services;

import com.snkrstore.trades.domain.Ask;
import com.snkrstore.trades.repository.AskRepository;
import com.snkrstore.trades.web.mapper.AskMapper;
import com.snkrstore.trades.web.model.AskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AskServiceImpl implements AskService{

    private final AskRepository askRepository;
    private final AskMapper askMapper;

    @Override
    public AskDto getAskById(Long askId) {
        Optional<Ask> optionalAsk = askRepository.findById(askId);
        Ask ask = new Ask();
        if(optionalAsk.isPresent()){
            ask = optionalAsk.get();
        }
        return askMapper.askToAskDto(ask);
    }

    @Override
    public AskDto saveAsk(AskDto askDto) {
        Ask ask = askMapper.askDtoToAsk(askDto);
        return askMapper.askToAskDto(askRepository.save(ask));
    }

    @Override
    public AskDto updateAsk(AskDto askDto) {
        Ask ask = askMapper.askDtoToAsk(askDto);
        return askMapper.askToAskDto(askRepository.save(ask));
    }

    @Override
    public List<AskDto> getAskListByProductId(String productId) {
        return askMapper.askListToAskDtoList(askRepository.
                getAskListByProductId(productId));
    }
}
