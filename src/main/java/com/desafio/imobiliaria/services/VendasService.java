    package com.desafio.imobiliaria.services;

    import com.desafio.imobiliaria.model.Vendas;
    import com.desafio.imobiliaria.model.Cliente;
    import com.desafio.imobiliaria.model.Apartamento;
    import com.desafio.imobiliaria.model.StatusAP;
    import com.desafio.imobiliaria.repository.VendasRepository;
    import com.desafio.imobiliaria.repository.ClienteRepository;
    import com.desafio.imobiliaria.repository.ApartamentoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.stereotype.Service;
    import org.springframework.web.server.ResponseStatusException;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;
    import java.util.List;

    @Service
    public class VendasService {
        @Autowired
        private VendasRepository vendasRepository;

        @Autowired
        private ClienteRepository clienteRepository;

        @Autowired
        private ApartamentoRepository apartamentoRepository;

        public List<Vendas> listarTodas() {
            return vendasRepository.findAll();
        }

        public Vendas buscarPorId(Long id) {
            return vendasRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada"));
        }

        public Vendas registrarVenda(Vendas venda) {
            Cliente cliente = clienteRepository.findById(venda.getCliente().getClienteId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

            Apartamento apartamento = apartamentoRepository.findById(venda.getApartamento().getCodigo())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartamento não encontrado"));

            if (apartamento.getStatus() != StatusAP.DISPONIVEL) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apartamento indisponível para venda");
            }

            if (!"São Paulo".equalsIgnoreCase(apartamento.getCidade())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apenas imóveis de São Paulo podem ser vendidos");
            }

            apartamento.setStatus(StatusAP.INDISPONIVEL);
            apartamentoRepository.save(apartamento);

            venda.setCliente(cliente);
            venda.setApartamento(apartamento);
            venda.setDataVenda(LocalDateTime.now());

            return vendasRepository.save(venda);
        }
    }
