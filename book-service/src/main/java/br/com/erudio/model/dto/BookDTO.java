package br.com.erudio.model.dto;

import br.com.erudio.model.Book;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.Function;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String author;
    private Date launchDate;
    private BigDecimal price;
    private String title;
    private String currency;
    private String enviroment;

    public static ToDTO getToDTOConverter(){return new ToDTO();}

    public static class ToDTO implements Function<Book, BookDTO>{
        @Override
        public BookDTO apply(Book entity){
            BookDTO dto = new BookDTO();
            dto.setAuthor(entity.getAuthor());
            dto.setPrice(entity.getPrice());
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setLaunchDate(entity.getLaunchDate());

            return dto;
        }

    }


}
