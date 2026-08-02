from Restaurante.cardapio.item_cardapio import ItemCardapio
from Restaurante.cardapio.bebida import Bebida
from Restaurante.cardapio.prato import Prato
from Restaurante.restaurante import Restaurante

bebida_1 = Bebida("Coca-Cola", 10.0, 500)
prato_1 = Prato("Pizza", 25.0, "Pizza de pepperoni")
restaurante = Restaurante("Restaurante do Adson", "Comida Italiana")
restaurante.adicionar_item_cardapio(bebida_1)
restaurante.adicionar_item_cardapio(prato_1)
def main():
    restaurante.exibir_cardapio()
    print("Restaurante:", restaurante)
    print("Bebida:", bebida_1)
    print("Prato:", prato_1)

if __name__ == "__main__":
    main()