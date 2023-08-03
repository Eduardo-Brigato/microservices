package br.com.erudio.model;

import lombok.Getter;

@Getter
public class Greeting {
    private final Long id;
    private final String content;

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }


}
