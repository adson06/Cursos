def validar_cpf(cpf):
    if len(cpf) != 11:
        print("CPF inválido. O CPF deve conter 11 dígitos.")
    else:
        print("CPF válido")

cpf = input("Digite seu CPF: ")
validar_cpf(cpf)