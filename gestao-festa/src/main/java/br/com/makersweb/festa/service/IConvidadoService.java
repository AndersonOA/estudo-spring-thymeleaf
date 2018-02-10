package br.com.makersweb.festa.service;

import br.com.makersweb.festa.model.Convidado;

import java.util.List;

/**
 * @author aaristides
 */
public interface IConvidadoService {

    List<Convidado> listar();

    Convidado buscar(Long codigo);

    Convidado salvar(Convidado convidado);

    Convidado alterar(Long codigo, Convidado convidado);

    void excluir(Long id);
}
