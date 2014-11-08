package com.hackfmi.sport.squad.assembler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inakov on 14-11-8.
 */
public abstract class BaseAssembler<Document, Dto> {

    protected abstract Document createDocument();
    protected abstract Dto createDto();
    protected abstract void convertToDto(Document document, Dto dto);
    protected abstract void convertToDocument(Document document, Dto dto);

    public Document toDocument(Dto dto){
        Document document = createDocument();
        convertToDocument(document, dto);

        return document;
    }

    public List<Document> toDocuments(List<Dto> dtos){
        List<Document> documents = new ArrayList<>(dtos.size());
        for(Dto dto : dtos){
            documents.add(toDocument(dto));
        }

        return documents;
    }

    public Dto toDto(Document document){
        Dto dto = createDto();
        convertToDto(document, dto);

        return dto;
    }

    public List<Dto> toDtos(List<Document> documents){
        List<Dto> dtos = new ArrayList<>(documents.size());
        for(Document document : documents){
            dtos.add(toDto(document));
        }

        return dtos;
    }


}
