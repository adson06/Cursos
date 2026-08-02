#Escreva um programa que retorne o valor hora de um funcionário com base no seu salário mensal e horas trabalhadas no mês

#Para descobrir o valor hora temos que fazer o salario mensal/horas trabalhadas


horas_trabalhadas = int(input("Digite o total de horas trabalhadas no mês: "))
salario_mensal = float(input('Digite o seu salário mensal: '))

valor_hora = salario_mensal / horas_trabalhadas

print(valor_hora)