package br.com.makersweb.festa.service.impl;

import br.com.makersweb.festa.model.Convidado;
import br.com.makersweb.festa.repository.ConvidadoRepository;
import br.com.makersweb.festa.service.IConvidadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aaristides
 */
@Service
public class ConvidadoService implements IConvidadoService {

    private static final Logger LOG = LoggerFactory.getLogger(ConvidadoService.class);

    @Autowired
    private ConvidadoRepository convidadoRepository;

    @Override
    public List<Convidado> listar() {
        LOG.info("Iniciou método listar...");

        return convidadoRepository.findAll();
    }

    @Override
    public Convidado buscar(Long codigo) {
        LOG.info("Iniciou método buscar...");
        Convidado convidado = convidadoRepository.findOne(codigo);

        if (null == convidado) {
            LOG.error(String.format("Convidado com o código %s não encontrado.", codigo));
            throw new EmptyResultDataAccessException(1);
        }

        return convidado;
    }

    @Override
    public Convidado salvar(Convidado convidado) {
        LOG.info("Iniciou método salvar...");
        return convidadoRepository.save(convidado);
    }

    @Override
    public Convidado alterar(Long codigo, Convidado convidado) {
        LOG.info("Iniciou método alterar...");
        Convidado convidadoSave = buscar(codigo);
        BeanUtils.copyProperties(convidado, convidadoSave, "codigo");

        return convidadoRepository.save(convidadoSave);
    }

    @Override
    public void excluir(Long codigo) {
        LOG.info("Iniciou método excluir...");
        try {
            convidadoRepository.delete(codigo);
        } catch (EmptyResultDataAccessException e) {
            LOG.error(String.format("Convidado com o código %s não encontrado.", codigo));
            throw new EmptyResultDataAccessException(1);
        }
    }
}
