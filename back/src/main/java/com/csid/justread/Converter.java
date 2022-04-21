package com.csid.justread;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public class Converter {

    public MapperFacade mapper = createMapper();

    public MapperFacade createMapper(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        return  mapperFactory.getMapperFacade();
    }

    public <S, D> D map(S sourceObject, Class<D> destinationClass){
        return mapper.map(sourceObject, destinationClass);
    }

    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass){
        return mapper.mapAsList(source, destinationClass);
    }
}
