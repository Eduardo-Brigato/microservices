package br.com.erudio.service;

import br.com.erudio.model.dto.CambioDTO;

public interface ICambioService {

    CambioDTO findByFromAndTo(String from, String to);


}
