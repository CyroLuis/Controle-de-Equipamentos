package br.com.contador.cont.services;
import br.com.contador.cont.dtos.EquipamentoDto;
import br.com.contador.cont.model.Equipamentos;
import br.com.contador.cont.repository.RepositoryEquipamentos;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ServiceEquipamento {

@Autowired
private RepositoryEquipamentos repository;

public List<Equipamentos> exibir(){

    return repository.findAll();
}

    public void salvar(EquipamentoDto dto) {
        var equipamentos = new Equipamentos();
        BeanUtils.copyProperties(dto, equipamentos);

        if (dto.getFoto() != null && !dto.getFoto().isEmpty()) {
            try {
                // "user.dir" pega a pasta raiz do seu projeto automaticamente
                String pastaRaiz = System.getProperty("user.dir");
                String diretorio = pastaRaiz + "/upload-dir/";

                // Limpa o nome do arquivo (remove espaços ou caracteres estranhos)
                String nomeOriginal = dto.getFoto().getOriginalFilename();
                String nomeArquivo = System.currentTimeMillis() + "_" + (nomeOriginal != null ? nomeOriginal.replaceAll("\\s+", "_") : "foto");

                File pasta = new File(diretorio);
                if (!pasta.exists()) pasta.mkdirs();

                dto.getFoto().transferTo(new File(diretorio + nomeArquivo));

                // Garante que o atributo da Entity receba o nome do arquivo salvo
                equipamentos.setFotoCaminho(nomeArquivo);

            } catch (IOException e) {
                // Em um sistema real, aqui você jogaria uma RuntimeException para avisar o usuário
                throw new RuntimeException("Erro ao salvar a foto: " + e.getMessage());
            }
        }
        repository.save(equipamentos);
    }
    public Equipamentos buscarPorId(Long id) {
        // Retorna o equipamento ou lança um erro caso não encontre
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado com o ID: " + id));
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}


















