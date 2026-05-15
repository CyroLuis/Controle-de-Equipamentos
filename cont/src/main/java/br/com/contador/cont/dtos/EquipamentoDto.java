package br.com.contador.cont.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class EquipamentoDto {
    private Long id;

    @NotBlank(message = "O nome do equipamento não pode está vazio")
    private String nome;

    @NotBlank(message = "A data de entreda é obrigatória")
    @PastOrPresent(message = "A data de entrada não pode ser no futuro")
    private LocalDate dataDeEntrada;

    private LocalDate dataDeSaida;

    @Size(min = 3, max = 50, message = "O nome do operador deve ter entre 3 e 50 caracteres")
    private String nomeOperador;

    @NotBlank(message = "O campo não pode está vazio")
    private String comentario;

    private MultipartFile foto; // Campo para o arquivo binário

    public EquipamentoDto() {
    }

    public EquipamentoDto(Long id, String nome, LocalDate dataDeEntrada, LocalDate dataDeSaida, String nomeOperador, String comentario, MultipartFile foto) {
        this.id = id;
        this.nome = nome;
        this.dataDeEntrada = dataDeEntrada;
        this.dataDeSaida = dataDeSaida;
        this.nomeOperador = nomeOperador;
        this.comentario = comentario;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(LocalDate dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public LocalDate getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(LocalDate dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public MultipartFile getFoto() {
        return foto;
    }

    public void setFoto(MultipartFile foto) {
        this.foto = foto;
    }
}
