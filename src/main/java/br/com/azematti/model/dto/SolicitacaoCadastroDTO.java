package br.com.azematti.model.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class SolicitacaoCadastroDTO {
	
	private Long codigo;
	
	private String nome;	

	private String cidade;
	
	private String estado;
	
	private String email;
	
	private String cpf;
	
	private String telefone;
		
	private String veiculo;
		
	private String servico;
	

	public SolicitacaoCadastroDTO() {
	}
	
}
