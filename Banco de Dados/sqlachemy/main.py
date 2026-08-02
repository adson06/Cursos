from sqlachemy import create_engine # create_engine serve para criar uma conexão com o banco de dados

db = create_engine('sqlite:///example.db')  # Conexão com um banco de dados SQLite chamado example.db

