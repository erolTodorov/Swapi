package com.erol.swapi.web.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@JsonPropertyOrder({"meta", "content"})
public class PlanetApiPage <T> {

    
    private List<T> content;

    @JsonProperty("metadata")
    private PaginationMetadata meta;


    public PlanetApiPage(Page <T> springPage){
        this.content = springPage.getContent();
        this.meta = PaginationMetadata.builder().currPage(springPage.getPageable().getPageNumber())
                .totalPages(springPage.getTotalPages()).pageSize(springPage.getSize())
                .totalElements(springPage.getTotalElements()).build();
    }


    @Getter
    @Setter
   @Builder
    private static class  PaginationMetadata{

        private final Integer currPage;
        private final Integer totalPages;
        private final Integer pageSize;
        private final Long totalElements;
    
        
    }
}
