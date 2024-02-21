package br.com.erudio.controller;

import br.com.erudio.model.dto.BookDTO;
import br.com.erudio.proxy.CambioProxy;
import br.com.erudio.service.IBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;
@Tag(name = "Book Endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Resource
    private Environment environment;

    @Resource
    private IBookService service;

    @Resource
    private CambioProxy proxy;

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value = "/{id}/{currency}")
    public BookDTO findById(@PathVariable("id")Long id,
                            @PathVariable("currency")String currency){

        BookDTO book = service.getById(id);

        if (Objects.isNull(book)) throw new RuntimeException("Book not Found");

        HashMap<String,String> params = new HashMap<>();

        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");

        book.setEnviroment("Book port: " + port + " Cambio Port: " + cambio.getEnviroment());
        book.setPrice(cambio.getConvertedValue());

        return book;
    }
}
