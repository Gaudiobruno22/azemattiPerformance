package br.com.azematti.model.dto;

import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Transactional
public class SolicitacaoCadastroDTO {
	
	private Long codigo;
	
	private String nome;	
	
	private String email;
		
	private String veiculo;
		
	private String servico;
	

	public SolicitacaoCadastroDTO() {
	}
}
