
import random


def gerar_senha():
    maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    minusculas = "abcdefghijklmnopqrstuvwxyz"
    numeros = "0123456789"
    caracteres = "!@#$%^&*()_+-=[]{}|;:,.<>/?"

    senha = [
        random.choice(maiusculas),
        random.choice(minusculas),
        random.choice(numeros),
        random.choice(caracteres)
    ]

    soma = maiusculas + minusculas + numeros + caracteres
    senha.extend(random.choice(soma) for _ in range(8)) #.extende a senha com mais 8 caracteres aleatórios
    random.shuffle(senha) # embaralha a lista de caracteres da senha
    return ''.join(senha) #converte a lista em string

print(f" A senha gerada é: {gerar_senha()}")
