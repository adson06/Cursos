import sqlite3

conn = sqlite3.connect('hotelplus.db')
cursor = conn.cursor()

usuarios = [
    ("Ana Silva", "ana@hotelplus.com"),
    ("Bruno Costa", "bruno@hotelplus.com")
]

cursor.executemany(
    """
    INSERT INTO usuarios (nome, email)
    VALUES (?, ?)
    """,
    usuarios
)

conn.commit()
conn.close()

print("Dois usuários foram adicionados com sucesso.")
