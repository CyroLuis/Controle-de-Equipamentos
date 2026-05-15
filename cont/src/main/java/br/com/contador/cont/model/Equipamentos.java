package br.com.contador.cont.model;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Tabela de Equipamentos")
public class Equipamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private LocalDate dataDeEntrada;

    @Column(nullable = false, length = 100)
    private LocalDate dataDeSaida;

    private String nomeOperador;

    @Column(columnDefinition = "TEXT") // Permite textos longos
    private String comentario;

    private String fotoCaminho;

    public Equipamentos() {
    }

    public Equipamentos(Long id, String nome, LocalDate dataDeEntrada, LocalDate dataDeSaida, String nomeOperador,String comentario, String fotoCaminho) {
        this.id = id;
        this.nome = nome;
        this.dataDeEntrada = dataDeEntrada;
        this.dataDeSaida = dataDeSaida;
        this.nomeOperador = nomeOperador;
        this.comentario = comentario;
        this.fotoCaminho = fotoCaminho;
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

    public String getFotoCaminho() {
        return fotoCaminho;
    }

    public void setFotoCaminho(String fotoCaminho) {
        this.fotoCaminho = fotoCaminho;
    }
}
