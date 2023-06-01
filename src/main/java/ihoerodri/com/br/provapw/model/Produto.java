package ihoerodri.com.br.provapw.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date deleted= null;
    String imageuri;
    //@Min(value = 1)
    //@NotBlank(message = "campo obrigatório")
    Float preco;
    @NotBlank(message = "campo obrigatório")
    private String nome;
    @NotBlank(message = "campo obrigatório")
    String concentracao;
    @NotBlank(message = "campo obrigatório")
    String categoria;

}
