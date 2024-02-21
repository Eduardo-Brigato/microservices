package br.com.erudio.service.core;

import br.com.erudio.model.Book;
import br.com.erudio.model.dto.BookDTO;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService implements IBookService {

    @Resource
    private BookRepository repository;

    @Override
    public BookDTO getById(Long id) {
        Book book = repository.getReferenceById(id);

        return BookDTO.getToDTOConverter().apply(book);
    }
}
