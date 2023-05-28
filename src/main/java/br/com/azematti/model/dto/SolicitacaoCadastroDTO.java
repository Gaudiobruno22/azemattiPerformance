package br.com.azematti.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public class SolicitacaoCadastroDTO {

	private Long codigo;
	private String nome;
	private String veiculo;
	private String telefone;
	private String cpf;
}
