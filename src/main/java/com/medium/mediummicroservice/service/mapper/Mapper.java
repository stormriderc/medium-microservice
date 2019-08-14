package com.medium.mediummicroservice.service.mapper;

public interface Mapper<A, B> {

    B map(A input);
}
