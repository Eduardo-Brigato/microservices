package br.com.erudio.service.core;

import br.com.erudio.model.Cambio;
import br.com.erudio.model.dto.CambioDTO;
import br.com.erudio.repository.CambioRepository;
import br.com.erudio.service.ICambioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CambioService implements ICambioService {

    @Resource
    CambioRepository repository;

    @Override
    public CambioDTO findByFromAndTo(String from, String to) {
        Cambio cambio = repository.findByFromAndTo(from, to);

        return CambioDTO.getToDTOConverter().apply(cambio);
    }
}
