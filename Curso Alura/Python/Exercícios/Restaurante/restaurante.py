from .avaliacao import Avaliacao
from .cardapio.item_cardapio import ItemCardapio

class Restaurante() :

    restaurantes = []

    def __init__(self, nome, categoria): # o self serve para referenciar o objeto que está sendo criado, permitindo acessar seus atributos e métodos
        self.nome = nome
        self.categoria = categoria
        self._ativo = False # o underline serve para indicar que o atributo é privado, ou seja, não deve ser acessado diretamente fora da classe
        Restaurante.restaurantes.append(self) # essa linha adiciona o restaurante à lista de restaurantes
        self._avaliacao = [] # essa linha cria uma lista de avaliações para cada restaurante, permitindo que cada restaurante tenha suas próprias avaliações
        self._cardapio = [] # essa linha cria uma lista de itens do cardápio para cada restaurante, permitindo que cada restaurante tenha seu próprio cardápio

    def __str__(self):
        return f"{self.nome} - {self.categoria}"
    
    
    @classmethod # o classmethod é um decorador que indica que o método pertence à classe e não a uma instância específica da classe
    def listarrestaurantes(cls): # o cls é uma convenção para referenciar a classe
        print(f"{'Nome do Restaurante'.ljust(25)} | {'Categoria'.ljust(25)} | {'Média'.ljust(25)} | {'Ativo'}")
        for restaurante in Restaurante.restaurantes: # para cada restaurante na lista de restaurantes, ele imprime o nome e a categoria do restaurante
            print(f'{restaurante.nome.ljust(25)} | {restaurante.categoria.ljust(25)} | {str(restaurante.media_avaliacoes).ljust(25)} | {restaurante.ativo}')


    @property #modifica como aquele atributo pode ser lido, nesse caso, ele pode ser lido como se fosse um atributo normal, mas na verdade é um método
    def ativo(self):
        return 'verdadeiro' if self._ativo else 'false'
    
    def alternar_estado(self):
        self._ativo = not self._ativo # o not inverte o valor do atributo, ou seja, se ele for True, ele passa a ser False e vice-versa
    
    
    def receber_avalicao(self, cliente, nota):
        avaliacao = Avaliacao(cliente, nota) # cria uma nova avaliação com o cliente e a nota fornecidos
        self._avaliacao.append(avaliacao) # adiciona a avaliação à lista de avaliações


    @property # nesse caso, fui utilizado para criar um método que retorna a média das avaliações do restaurante, mas sem precisar chamá-lo como um método, ou seja, sem os parênteses. Isso permite que o usuário acesse a média das avaliações como se fosse um atributo normal do restaurante, tornando o código mais legível e intuitivo.
    def media_avaliacoes(self):
        if not self._avaliacao: # verifica se a lista de avaliações está vazia
            return 0 # se estiver vazia, retorna 0
        somas_das_notas = sum(avaliacao.nota for avaliacao in self._avaliacao) # soma todas as notas das avaliações
        quantidade_de_avaliacoes = len(self._avaliacao) # conta a quantidade de avaliações
        media = round(somas_das_notas / quantidade_de_avaliacoes, 1) # retorna a média das avaliações arredondada para uma casa decimal
        return media


    def adicionar_item_cardapio(self, item):
        if isinstance(item, ItemCardapio):
            self._cardapio.append(item)


    def exibir_cardapio(self):
        print(f'Cardapio do restaurante {self.nome}\n')
        for i, item in enumerate(self._cardapio, start=1):
            if hasattr(item, 'descricao'):
                mensagem_prato = f'{i}. Nome: {item.nome} | Preço: R${item.preco:.2f} | Descrição: {item.descricao}'
                print(mensagem_prato)
            else:
                mensagem_bebida = f'{i}. Nome: {item.nome} | Preço: R${item.preco:.2f} | Tamanho: {item.tamanho}'
                print(mensagem_bebida)


#O método __init__ é conhecido como o construtor da classe em Python. Ele é automaticamente chamado quando uma nova instância da classe é criada e serve para realizar as inicializações necessárias nos atributos da instância. O nome __init__ é uma abreviação de initialize (inicializar), e sua principal função é garantir que os atributos da instância tenham valores iniciais apropriados.
