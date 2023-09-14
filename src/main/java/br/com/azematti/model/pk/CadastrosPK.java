package br.com.azematti.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.azematti.model.SolicitacaoCadastro;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CadastrosPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity = SolicitacaoCadastro.class)
	@PrimaryKeyJoinColumn
	@JoinColumn(name = "USU_USUARIO_CODIGO", foreignKey = @ForeignKey(name = "t_cad_cadastros_ibfk_1"))
	private SolicitacaoCadastro usuarioCadastro;
}
