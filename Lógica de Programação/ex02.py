#Escreva um programa que, ao iniciar gera um valor aleatório de 1 a 10 e permite que o usuário chute um número até o valor gerado no ínicio do programa seja chutado corretamente. O programa deve informar se o chute foi acima, abaixo ou igual do valor aleatório do inicio do programa

#Dados de entrada necessário?? preciso de um numero aleatorio
#O que devo fazer com esse dado?? preciso acertar qual é o valor aleatório
#Restrições?? não conseguir gerar o numero, e não conseguir colocar se mais baixo, alto ou igual o numero
#Sequencia de Passos?? gerar um número aleatório, o usuário vai tentar acertar, se for mais baixo ou mais alto o programa deve avisar e ele deve continuar chutando se ele acertar, o programa deve parar e exibe a mensagem que ele acertou o número
#
#

import random

numero_aleatorio = random.randint(1, 10)

while True:
    chute = int(input("Digite seu chute: "))

    if chute > numero_aleatorio:
        print("Chute muito baixo") 
    elif chute < numero_aleatorio:
        print("Chute mais alto ")
    elif chute == numero_aleatorio:
        print('Parabéns, você acertou!!')
        break
    else:
        print("Erro ao digitar o chute")



