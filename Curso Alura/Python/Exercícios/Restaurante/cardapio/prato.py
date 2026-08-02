from Restaurante.cardapio.item_cardapio  import ItemCardapio

class Prato(ItemCardapio):
    
    def __init__(self, nome, preco, descricao):
        super().__init__(nome, preco)
        self.descricao = descricao

    def __str__(self):
        return f"{self.nome} - {self.descricao} - R${self.preco:.2f}"

    def aplicar_desconto(self):
        self._preco -= (self._preco * 0.05)  # aplica um desconto de 5% no preço do prato
