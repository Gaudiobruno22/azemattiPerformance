package br.com.azematti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Table(name = "T_USU_SOLCADASTRO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SolicitacaoCadastro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "USU_USUARIO_CODIGO")
	@PrimaryKeyJoinColumn
	private Long codigo;
	
	@NotBlank
	@Size(max = 150)
	@Column(name = "USU_USUARIO_NOME", columnDefinition = "VARCHAR(150)", nullable = true)
	private String nome;
	
	@NotBlank
	@Column(name = "USU_USUARIO_CPF", columnDefinition = "CHAR(11)", nullable = true)
	private String cpf;
	
	@Column(name = "USU_USUARIO_CIDADE", columnDefinition = "VARCHAR(255)", nullable = true)
	private String cidade;
	
	@Column(name = "USU_USUARIO_ESTADO", columnDefinition = "VARCHAR(255)", nullable = true)
	private String estado;
	
	@Size(max = 255)
	@Email
	@Column(name = "USU_USUARIO_EMAIL", columnDefinition = "VARCHAR(255)", nullable = true)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "USU_USUARIO_TELEFONE", columnDefinition = "VARCHAR(20)", nullable = true)
	private String telefone;
	
	@Column(name = "USU_USUARIO_VEICULO", columnDefinition = "VARCHAR(255)", nullable = true)
	private String veiculo;
	
	@Column(name = "USU_USUARIO_SERVICO", columnDefinition = "VARCHAR(255)", nullable = true)
	private String servico;
	
	@Column(name = "USU_USUARIO_EFETIVOU", columnDefinition = "CHAR(1)", nullable = true)
	private String efetivou;
	
	public SolicitacaoCadastro() {
	}
}
