from abc import ABC, abstractmethod


class ItemCardapio(ABC):  # a classe abstrata é uma classe que não pode ser instanciada, ou seja, não pode ser criada um objeto a partir dela. Ela serve como base para outras classes, que irão herdar seus atributos e métodos. A classe abstrata é utilizada para definir uma interface comum para todas as classes que irão herdar dela, garantindo que elas implementem os métodos definidos na classe abstrata.
    
    def __init__(self, nome, preco):
        self.nome = nome
        self.preco = preco

@abstractmethod  # o abstractmethod é um decorador que indica que o método é abstrato, ou seja, não possui implementação na classe abstrata e deve ser implementado nas classes filhas. Ele serve para garantir que todas as classes filhas implementem o método, evitando erros de execução.
def aplicar_desconto(self):
    pass