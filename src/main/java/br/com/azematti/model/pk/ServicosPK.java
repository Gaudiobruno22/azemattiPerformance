package br.com.azematti.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.azematti.model.Servico;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ServicosPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity = Servico.class)
	@JoinColumn(name = "SER_SERVICO_COD", foreignKey = @ForeignKey(name = "t_cad_cadastros_ibfk_2"))
	private Servico servicoCodigo;
}
