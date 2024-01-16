package br.com.azematti.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "T_SER_TPSERVICO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoServico implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "SER_TPSERVICO_COD")
	@PrimaryKeyJoinColumn
	private Long codigo;
	
	
	@Column(name = "SER_TPSERVICO_DESCRICAO", columnDefinition = "VARCHAR(200)", nullable = true)
	private String descricao;
	
	@Column(name = "SER_TPSERVICO_MAPA", columnDefinition = "CHAR(1)", nullable = true)
	private String mapa;
	
	@Column(name = "SER_TPSERVICO_DOWNPIPE", columnDefinition = "CHAR(1)", nullable = true)
	private String downpipe;
	
	@Column(name = "SER_TPSERVICO_TROCA_TURBINA", columnDefinition = "CHAR(1)", nullable = true)
	private String trocouTurbina;
	
	@Column(name = "SER_TPSERVICO_MECANICA", columnDefinition = "CHAR(1)", nullable = true)
	private String servicoMecanica;
	
	@Column(name = "SER_TPSERVICO_VALOR", columnDefinition = "FLOAT(6,2)", nullable = true)
	private Double valorServico;
	
	public TipoServico() {
	}
}
