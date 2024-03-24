package com.hegazy.mohammed.service.iservices;

import java.util.List;

public interface CrudOperation <AllDto ,AddDtoRequest,UpdateDtoRequest,DtoResponse>{

    void add(int source,AddDtoRequest request);
    List<AllDto> findAll(int sourceId);
    DtoResponse update(int sourceId,UpdateDtoRequest entity);
    void delete(int first,int second);

}
