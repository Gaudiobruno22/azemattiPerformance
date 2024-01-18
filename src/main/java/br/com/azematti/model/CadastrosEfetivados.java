package br.com.azematti.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "T_CAD_CADASTROS")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CadastrosEfetivados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "CADASTRO_CODIGO", columnDefinition = "BIGINT")
	private Long cadCodigo;
	
	@ManyToOne(targetEntity = SolicitacaoCadastro.class)
	@JoinColumn(name = "USU_USUARIO_CODIGO", foreignKey = @ForeignKey(name = "t_cad_cadastros_ibfk_1"))
	private SolicitacaoCadastro usuarioCodigo; 
	
	@Column(name = "DATA_GRAVACAO", columnDefinition = "TIMESTAMP", nullable = true)
	private LocalDateTime dtGravacao;
	
	@Column(name = "VEICULO", columnDefinition = "VARCHAR(255)", nullable = true)
	private String veiculo;
	
	@ManyToOne(targetEntity = Servico.class)
	@JoinColumn(name = "SER_SERVICO_CODIGO", foreignKey = @ForeignKey(name = "t_cad_cadastros_ibfk_2"))
	private Servico servicos;
}
