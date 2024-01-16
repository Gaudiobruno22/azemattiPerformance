package br.com.azematti.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.azematti.model.pk.CadastrosPK;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "T_SER_SERVICO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Servico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "SER_SERVICO_CODIGO", columnDefinition = "BIGINT")
	private Long codigo;
	
	
	@ManyToOne(targetEntity = TipoServico.class)
	@JoinColumn(name = "SER_TPSERVICO_COD", foreignKey = @ForeignKey(name = "t_cad_cadastros_ibfk_1")) 
    private TipoServico tpServico;
	
	@Column(name = "SER_SERVICO_DESCRICAO", columnDefinition = "VARCHAR(500)", nullable = true)
	private String descricao;
	
	@ManyToOne(targetEntity = SolicitacaoCadastro.class)
	@JoinColumn(name = "USU_USUARIO_CODIGO", foreignKey = @ForeignKey(name = "t_ser_servico_ibfk_2"))
	private SolicitacaoCadastro usuarioCodigo; 
	
	@Column(name = "USU_USUARIO_CPF", columnDefinition = "CHAR(11)", nullable = false)
	private String cpf;
	
	@Column(name = "SER_SERVICO_DTGRAVACAO", columnDefinition = "TIMESTAMP", nullable = true)
	private LocalDateTime dtGravacao;
	
	@Column(name = "SER_SERVICO_PAGO", columnDefinition = "CHAR(1)", nullable = true)
	private String pago;
	
	@Column(name = "SER_SERVICO_VALOR", columnDefinition = "FLOAT(8,2)", nullable = true)
	private Double valor;
	
	@Column(name = "SER_SERVICO_DESCONTO", columnDefinition = "FLOAT (3,2)", nullable = true)
	private Double desconto;
	
	@Column(name = "SER_SERVICO_FINALIZADO", columnDefinition = "CHAR(1)", nullable = true)
	private String finalizado;
	
	public Servico(){
		
	}
}
