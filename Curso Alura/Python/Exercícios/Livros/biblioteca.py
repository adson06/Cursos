class Livro:
    livros = []

    def __init__(self, titulo,  autor, ano_publicacao):
        self.titulo = titulo
        self.autor = autor
        self.ano_publicacao = ano_publicacao
        self.disponivel = True
        Livro.livros.append(self)

    def __str__(self):
        return f'{self.titulo} | {self.autor} | ({self.ano_publicacao})'

    def emprestar(self):
        self.disponivel = False

    @classmethod
    def verificar_disponibilidade(cls, ano):
        return [livro for livro in cls.livros if livro.ano_publicacao == ano and livro.disponivel]


def disponibilidade_livro(ano):
        livros_disponiveis = [livro for livro in Livro.livros if livro.ano_publicacao == ano and livro.disponivel]
        return livros_disponiveis





