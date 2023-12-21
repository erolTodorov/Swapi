package com.erol.swapi.web.dto;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@JsonPropertyOrder({"meta","contents"})
public class PeopleApiPage {
    
    //private List<T> contents;

    @JsonProperty("metadata")
    private PaginationMetadata meta;


    public <T> PeopleApiPage(Page <T> springPage){
        //this.contents = springPage.getContent();
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


