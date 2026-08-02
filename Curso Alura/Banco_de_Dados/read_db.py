import sqlite3

conn = sqlite3.connect('hotelplus.db')
cursor = conn.cursor()

cursor.execute(
    """
    SELECT id, nome, email
    FROM usuarios
    ORDER BY id
    """
)

usuarios = cursor.fetchall()

for usuario in usuarios:
    print(usuario)

conn.close()