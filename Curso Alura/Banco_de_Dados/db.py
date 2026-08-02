import sqlite3


def conectar():
    conn = sqlite3.connect("escola.db")
    return conn


def criar_tabela_estudantes():
    conn = conectar()
    cursor = conn.cursor()
    cursor.execute(
        """
        CREATE TABLE IF NOT EXISTS estudantes (
            id INTEGER PRIMARY KEY,
            nome TEXT NOT NULL,
            idade INTEGER NOT NULL
        )
        """
    )
    conn.commit()
    conn.close()


def criar_tabela_matricula():
    conn = conectar()
    cursor = conn.cursor()
    cursor.execute(
        """
        CREATE TABLE IF NOT EXISTS  matricula (
            id INTEGER PRIMARY KEY,
            nome_disciplina TEXT NOT NULL,
            estudante_id INTEGER,
            FOREIGN KEY (estudante_id) REFERENCES estudantes (id)
        )
        """
    )
    conn.commit()
    conn.close()


def criar_estudante(nome, idade):
    conn = conectar()
    cursor = conn.cursor()
    cursor.execute(
        """
        INSERT INTO estudantes (nome, idade) VALUES (?, ?)
        """,
        (nome, idade),
    )
    conn.commit()
    conn.close()


def listar_estudantes():
    conn = conectar()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM estudantes")
    estudantes = cursor.fetchall()

    for estudante in estudantes:
        print(estudante)

    conn.close()


def criar_matricula(estudante_id, nome_disciplina):
    conn = conectar()
    cursor = conn.cursor()
    cursor.execute(
        """
        INSERT INTO matricula (estudante_id, nome_disciplina) VALUES (?, ?)
        """,
        (estudante_id, nome_disciplina),
    )
    conn.commit()
    conn.close()


def listar_matriculas():
    conn = conectar()
    cursor = conn.cursor()

    cursor.execute("""
      SELECT matricula.id, estudantes.nome, matricula.nome_disciplina
    FROM matricula
    JOIN estudantes ON matricula.estudante_id = estudantes.id
""")
    
    matriculas = cursor.fetchall()

    for matricula in matriculas:
        print(matricula)

    conn.commit()
    conn.close()

