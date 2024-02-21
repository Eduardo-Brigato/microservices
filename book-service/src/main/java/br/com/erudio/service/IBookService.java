package br.com.erudio.service;

import br.com.erudio.model.dto.BookDTO;

public interface IBookService {

    BookDTO getById(Long id);
}
