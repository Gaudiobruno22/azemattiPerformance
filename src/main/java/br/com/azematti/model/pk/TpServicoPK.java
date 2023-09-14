package br.com.azematti.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.azematti.model.TipoServico;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TpServicoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity = TipoServico.class)
	@PrimaryKeyJoinColumn
	@JoinColumn(name = "SER_TPSERVICO_COD", foreignKey = @ForeignKey(name = "t_ser_servico_ibfk_1"))
	private TipoServico tipoServico;
}
