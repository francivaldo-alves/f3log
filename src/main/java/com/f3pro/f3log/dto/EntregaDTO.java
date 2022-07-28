package com.f3pro.f3log.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.f3pro.f3log.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDTO {
	
	private Long idLong;
	private String nomeCliente;
	private DestionatarioDTO destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

}
