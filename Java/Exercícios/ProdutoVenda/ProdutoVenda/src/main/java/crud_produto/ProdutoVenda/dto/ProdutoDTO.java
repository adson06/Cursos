package crud_produto.ProdutoVenda.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDTO {


    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
