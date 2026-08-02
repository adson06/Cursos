# Gerenciador de Login - Simples

#Crie um gerenciador de login simples, com o máximo de tentativas.
# (teremos apenas um usuário e senha permitido )
# Apos 3 tentativas se o usuario estiver errado, deve exibir a mensagem "Aguarde 30 mins pra tentar denovo"
# se o usuario acertar antes de 3 deve exibir "Bem vindo ao site"

usuario = ''
senha = ''
tentativas = 0

while (usuario != "jhonatan" or  senha != 'senha123') and tentativas < 3:
    usuario = input("Digite o usuario: ")
    senha = input('Digite sua senha: ')
    tentativas += 1

if usuario ==  "jhonatan" and senha == 'senha123':
    print('Bem vindo ao site')
else:
    print('Aguarde 30 segundos para tentar denovo')


    