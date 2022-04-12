package br.com.aula.storemanager.service.mapper;

public interface Mapper<A, B> {
    B map(A input);
}
