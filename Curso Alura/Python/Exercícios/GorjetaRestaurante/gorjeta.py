valor_conta = float(input("Digite o valor da conta: "))
gorjeta = float(input("Digite a porcentagem de gorjeta: "))

resultado_gorjeta = valor_conta * (gorjeta /100)
total_a_pagar = valor_conta + resultado_gorjeta

print(f"O valor da gorjeta é: R$ {resultado_gorjeta:.2f}")
print(f"O valor total a pagar é: R$ {total_a_pagar:.2f}")