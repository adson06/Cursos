senhas = [123456, "python", 12345, "senhas"]

for senha in senhas:
    senha_texto = str(senha)

    if len(senha_texto) < 6:
        print(f"A {senha_texto} está inválida")
    else:
        print(f"A {senha_texto} está correta")